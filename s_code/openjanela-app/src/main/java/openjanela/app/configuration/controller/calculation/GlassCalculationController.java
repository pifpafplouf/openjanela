package openjanela.app.configuration.controller.calculation;

import java.math.BigDecimal;
import java.util.List;

import Presentation.ItemFrame;
import openjanela.app.configuration.controller.BaseController;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.eao.partner.partsFamilyEAO.PartsFamilyEAO;
import openjanela.model.eao.partner.partsFamilyEAO.PartsFamilyPersistenceEAO;
import openjanela.model.entities.admin.SystemUOM;
import openjanela.model.entities.orderEntry.PricingGroup;
import openjanela.model.entities.partner.*;
import openjanela.model.entities.parts.PartsFamily;

import org.apache.log4j.Logger;

import Model.GlassSU;
import org.openjanela.data.ApplicationBaseApp;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 * 
 * @author Eddy Montenegro
 * @version 2.0.8 Date: 10-11-12 Time: 10:14 AM
 */
public class GlassCalculationController extends BaseController {

	// Apache log4j
	private static final Logger logger = Logger.getLogger(GlassCalculationController.class);

	// Controllers access
	private PartnerDiscountController partnerDiscountController;
	private MatrixController matrixController;

	/**
	 * Default constructor
	 * 
	 * Exceed
	 */
	public GlassCalculationController() {
		partnerDiscountController = new PartnerDiscountController();
	}

	/**
	 * Calculate Glass SU Price
	 * 
	 * @param glassSU
	 *            , GlassSU
	 * @throws Exception
	 *             , Exception
	 */
	public BigDecimal calculatePriceActualSize(GlassSU glassSU, BigDecimal price, BigDecimal cost) throws Exception {

		BigDecimal price1 = new BigDecimal(0);
		try {

			// Search for pricing group of Glass SU.
			PricingGroup pricingGroup = ItemFrame.getApplicationBase()
					.getPricingGroup(glassSU.priceGroupId);
			SystemUOM systemUOM = ItemFrame.getApplicationBase().getSystemUOM(
					glassSU.pricingUOMId);

			// Creating matrix controller
			matrixController = new MatrixController(glassSU, glassSU.myFrame2);

			// Price for GlassSU

			if (pricingGroup.getPriceFromCost().compareTo(Boolean.TRUE) == 0) {
				price1 = calculatePriceFromCost(glassSU, systemUOM,
						pricingGroup, price, cost);
			} else {
				price1 = calculatePrice(glassSU, systemUOM, pricingGroup,
						price, cost);

				if (glassSU.priceMatrixId > 0) {
					price = matrixController.getValueFromMatrix(
							glassSU.priceMatrixId, 0, true, false, false);
				}
			}

			// **************************************************
			// Appliying discount if this price Category has one
			// **************************************************
			Partner partner = glassSU.myFrame2.supplierPanel
					.getSupplierController().getPartnerSelected();
			Series series = glassSU.myFrame2.supplierPanel
					.getSupplierController().getSeriesSelected();

			// Get discount for pricingGroupId of GlassSU
			BigDecimal discount = partnerDiscountController
					.searchDiscountByPricingGroup(partner, series,
							glassSU.priceGroupId);

			price1 = price1.multiply(new BigDecimal("1").subtract(discount));

		} catch (PersistenceClassNotFoundException e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage(), e);
		} catch (GenericPersistenceEAOException e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage(), e);
		}

		return price1;
	}

	/**
	 * Calculate Nominal Price Glass
	 * 
	 * @param glassSU
	 *            , GlassSU
	 * @param price
	 *            , BigDecimal
	 * @param cost
	 *            , BigDecimal
	 * @param markUp
	 *            , BigDecimal
	 * @param nominalSize
	 *            , Boolean
	 * @return BigDecimal
	 * @throws Exception
	 *             , Exception
	 */
	public BigDecimal calculateNominalPrice(GlassSU glassSU, BigDecimal price,
			BigDecimal cost, BigDecimal markUp, boolean nominalSize)
			throws Exception {

		BigDecimal price1 = new BigDecimal(0);

		// Search system unit of metric
		BigDecimal area = getSize(glassSU, nominalSize);

		// Calculating the price
		price1 = price.multiply(area).setScale(4, BigDecimal.ROUND_HALF_EVEN);

		// Evaluate price calculated with min_price
		if (price.compareTo(glassSU.minPrice) <= -1
				|| price.compareTo(glassSU.minPrice) == 0) {
			price1 = glassSU.minPrice;
		}

		return price1;

	}

	public BigDecimal getSize(GlassSU glassSU, boolean nominal) {

		SystemUOM systemUOM = ItemFrame.getApplicationBase().getSystemUOM(
				glassSU.pricingUOMId);
		// Glass area
		BigDecimal area = new BigDecimal(0);
		BigDecimal widthPix = new BigDecimal(0);
		BigDecimal heightPix = new BigDecimal(0);

		if (glassSU.myFrame2.currentUOM == 1) {

			BigDecimal v2 = new BigDecimal(100000);
			if (nominal) {
				widthPix = new BigDecimal(glassSU.widthMN).divide(v2, 20,
						BigDecimal.ROUND_UP);
				heightPix = new BigDecimal(glassSU.heightMN).divide(v2, 20,
						BigDecimal.ROUND_UP);
			} else {
				widthPix = new BigDecimal(glassSU.widthM).divide(v2, 20,
						BigDecimal.ROUND_UP);
				heightPix = new BigDecimal(glassSU.heightM).divide(v2, 20,
						BigDecimal.ROUND_UP);

			}

			area = widthPix.multiply(heightPix);

		} else {
			BigDecimal v2 = new BigDecimal(64);// .divide(new

			if (nominal) {
				widthPix = new BigDecimal(glassSU.widthIN).divide(v2, 20,
						BigDecimal.ROUND_UP);
				heightPix = new BigDecimal(glassSU.heightIN).divide(v2, 20,
						BigDecimal.ROUND_UP);
			} else {
				widthPix = new BigDecimal(glassSU.widthI).divide(v2, 20,
						BigDecimal.ROUND_UP);
				heightPix = new BigDecimal(glassSU.heightI).divide(v2, 20,
						BigDecimal.ROUND_UP);

			}

			BigDecimal v3 = new BigDecimal(144);// .divide(new

			area = widthPix.multiply(heightPix).divide(v3, 20,
					BigDecimal.ROUND_UP);
		}

		if (systemUOM.getId().equals(new Integer(SystemsUOM.Area.getValue()))) {

			// Calculate for metric measure
			if (glassSU.measure == SystemsMeasurement.Metric.getValue()) {
				// If glassArea is less than min_pricing_area equals to this
				// value
				if (area.compareTo(new BigDecimal(glassSU.minPricingArea)) <= -1
						|| area.compareTo(new BigDecimal(glassSU.minPricingArea)) == 0) {
					area = new BigDecimal(glassSU.minPricingArea);
				}
			}

			// Calculate for imperial measure
			if (glassSU.measure == SystemsMeasurement.Imperial.getValue()) {
				// If glassArea is less than min_pricing_area equals to this
				// value
				if (area.compareTo(new BigDecimal(glassSU.minPricingAreaImp)) <= -1
						|| area.compareTo(new BigDecimal(
								glassSU.minPricingAreaImp)) == 0) {
					area = new BigDecimal(glassSU.minPricingAreaImp);
				}
			}

		}
		return area;
	}

	// *********************************************************
	// Private calculations methods
	// *********************************************************
	public BigDecimal calculateCost(GlassSU glassSU, SystemUOM systemUOM, BigDecimal price, BigDecimal cost,
                                    double waste) throws Exception {

		BigDecimal myCost = new BigDecimal(0);
		try {

			// Glass area
			BigDecimal width = null;
			BigDecimal heigth = null;
			BigDecimal glassArea = new BigDecimal(0);

			// Calculating cost for area
			if (systemUOM.getId().equals(new Integer(SystemsUOM.Area.getValue()))) {

				// Calculate for metric measure
				if (glassSU.measure == SystemsMeasurement.Metric.getValue()) {

					width = new BigDecimal(glassSU.widthM).divide(new BigDecimal("100"));
					heigth = new BigDecimal(glassSU.heightM).divide(new BigDecimal("100"));

					glassArea = width.divide(new BigDecimal("1000"), 20, BigDecimal.ROUND_UP)
							.multiply(heigth.divide(new BigDecimal("1000"), 20, BigDecimal.ROUND_UP))
							.setScale(20, BigDecimal.ROUND_UP);

					// If glassArea is less than min_pricing_area equals to this value
					if (glassArea.doubleValue() < glassSU.minCostArea) {
						glassArea = new BigDecimal(glassSU.minCostArea);
					}
				}

				// Calculate for imperial measure
				if (glassSU.measure == SystemsMeasurement.Imperial.getValue()) {

					width = new BigDecimal(glassSU.widthI).divide(new BigDecimal("64"), 20, BigDecimal.ROUND_UP);
					heigth = new BigDecimal(glassSU.heightI).divide(new BigDecimal("64"), 20, BigDecimal.ROUND_UP);

					glassArea = width.multiply(heigth).divide(new BigDecimal("144"), 20, BigDecimal.ROUND_UP)
							.setScale(20, BigDecimal.ROUND_UP);

					// If glassArea is less than min_pricing_area equals to this value
					if (glassArea.doubleValue() < glassSU.minCostAreaImp) {
						glassArea = new BigDecimal(glassSU.minCostAreaImp);
					}
				}
			}

			// Calculating the cost
			myCost = cost.multiply(glassArea).multiply(new BigDecimal(waste / 100 + 1)).setScale(20, BigDecimal.ROUND_UP);

            PartsFamily pf = new PartsFamily();
            if (glassSU.remote) {
                pf = ItemFrame.getApplicationRemoteBaseRules().getPartFamily(glassSU.supplierId, glassSU.partFamily);
            } else {
                pf = ItemFrame.getApplicationBaseRules().getPartsFamily(glassSU.partFamily);
            }

			myCost = myCost.multiply(new BigDecimal((pf.getCostMarkup() + 1) + ""));

		} catch (NullPointerException e) {
			logger.error(e.getMessage(), e);
			throw new Exception("An error occured while calculating Glass cost. Please contact Support", e);
		}

		return myCost;
	}

	/**
	 * Calculate price for GlassSU
	 * 
	 * @param glassSU
	 *            , GlassSU
	 * @param systemUOM
	 *            , SystemUOM
	 * @param pricingGroup
	 *            , PricingGroup
	 * @return BigDecimal
	 * @throws Exception
	 *             , Exception
	 */
	public BigDecimal calculatePrice(GlassSU glassSU, SystemUOM systemUOM,
			PricingGroup pricingGroup, BigDecimal price, BigDecimal cost)
			throws Exception {

		BigDecimal price1 = new BigDecimal(0);
		try {

			// Glass area
			BigDecimal width = null;
			BigDecimal heigth = null;
			BigDecimal glassArea = null;

			// Calculating price for Area
			if (systemUOM.getId().equals(
					new Integer(SystemsUOM.Area.getValue()))) {

				// Calculate for metric measure
				if (glassSU.measure == SystemsMeasurement.Metric.getValue()) {

					// Calculating length round for width
					// width / lengthRounding(i) = x | Math.ceil(x) *
					// lengthRounding = y
					width = new BigDecimal(glassSU.widthM).divide(
							new BigDecimal("100"), 20, BigDecimal.ROUND_UP);
					width = width.divide(
							new BigDecimal(pricingGroup.getLengthRounding()),
							20, BigDecimal.ROUND_UP);
					width = new BigDecimal(Math.ceil(width.doubleValue()))
							.multiply(new BigDecimal(pricingGroup
									.getLengthRounding()));

					// Calculation length rounding for heigth
					heigth = new BigDecimal(glassSU.heightM).divide(
							new BigDecimal("100"), 20, BigDecimal.ROUND_UP);
					heigth = heigth.divide(
							new BigDecimal(pricingGroup.getLengthRounding()),
							20, BigDecimal.ROUND_UP);
					heigth = new BigDecimal(Math.ceil(heigth.doubleValue()))
							.multiply(new BigDecimal(pricingGroup
									.getLengthRounding()));

					// Calculation area rounding for area
					// area / areaRounding(i) = x | Math.ceil(x) * areaRounding
					// = y
					glassArea = width
							.divide(new BigDecimal("1000"), 20,
									BigDecimal.ROUND_UP)
							.multiply(
									heigth.divide(new BigDecimal("1000"), 20,
											BigDecimal.ROUND_UP))
							.setScale(6, BigDecimal.ROUND_UP);
					glassArea = glassArea.divide(
							new BigDecimal(pricingGroup.getAreaRounding()), 20,
							BigDecimal.ROUND_UP);
					glassArea = new BigDecimal(Math.ceil(glassArea
							.doubleValue())).multiply(
							new BigDecimal(pricingGroup.getAreaRounding()))
							.setScale(20, BigDecimal.ROUND_UP);

					// If glassArea is less than min_pricing_area equals to this
					// value
					if (glassArea.doubleValue() < glassSU.minPricingArea) {
						glassArea = new BigDecimal(glassSU.minPricingArea);
					}
				}

				// Calculate for imperial measure
				if (glassSU.measure == SystemsMeasurement.Imperial.getValue()) {

					// Calculating length rounding for width
					width = new BigDecimal(glassSU.widthI).divide(
							new BigDecimal("64"), 20, BigDecimal.ROUND_UP);
					width = width.divide(new BigDecimal(pricingGroup
							.getLengthRoundingI()));
					width = new BigDecimal(Math.ceil(width.doubleValue()))
							.multiply(new BigDecimal(pricingGroup
									.getLengthRoundingI()));

					// Calculating length rounding for heigth
					heigth = new BigDecimal(glassSU.heightI).divide(
							new BigDecimal("64"), 20, BigDecimal.ROUND_UP);
					heigth = heigth.divide(new BigDecimal(pricingGroup
							.getLengthRoundingI()));
					heigth = new BigDecimal(Math.ceil(heigth.doubleValue()))
							.multiply(new BigDecimal(pricingGroup
									.getLengthRoundingI()));

					// Calculating area rounding for area
					glassArea = width
							.multiply(heigth)
							.divide(new BigDecimal("144"), 20,
									BigDecimal.ROUND_UP)
							.setScale(20, BigDecimal.ROUND_UP);
					glassArea = glassArea.divide(
							new BigDecimal(pricingGroup.getAreaRoundingI()),
							20, BigDecimal.ROUND_UP);
					glassArea = new BigDecimal(Math.ceil(glassArea
							.doubleValue())).multiply(
							new BigDecimal(pricingGroup.getAreaRoundingI()))
							.setScale(20, BigDecimal.ROUND_UP);

					// If glassArea is less than min_pricing_area equals to this
					// value
					if (glassArea.doubleValue() < glassSU.minPricingAreaImp) {
						glassArea = new BigDecimal(glassSU.minPricingAreaImp);
					}
				}

				// Calculating the price
				price1 = price.multiply(glassArea).setScale(4,
						BigDecimal.ROUND_HALF_EVEN);

				// Evaluate price calculated with min_price
				if (price1.compareTo(glassSU.minPrice) <= -1
						|| price1.compareTo(glassSU.minPrice) == 0) {
					price1 = glassSU.minPrice;
				}
			}

            //Get Partner Line Discounts
            double disc = 0.0;

            List<PartnerLineDiscount> partnerDiscounts = ApplicationBaseApp.getInstance().getPartnerLineDiscounts();
            for (PartnerLineDiscount discount : partnerDiscounts) {
                if (discount.getId().getPriceCategoryId() == 3) {
                    disc = discount.getDiscount();
                }
            }

            double discFactor = 1 - disc;

            price1 = price1.multiply(new BigDecimal(discFactor));

		} catch (NullPointerException e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage(), e);
		}

		return price1;

	}

	/**
	 * Calculating price from cost
	 * 
	 * @param glassSU
	 *            , GlassSU
	 * @param systemUOM
	 *            , SystemUOM
	 * @param pricingGroup
	 *            , PricingGroup
	 * @return BigDecimal
	 * @throws Exception
	 *             , Exception
	 */
	private BigDecimal calculatePriceFromCost(GlassSU glassSU,
			SystemUOM systemUOM, PricingGroup pricingGroup, BigDecimal price,
			BigDecimal cost) throws Exception {

		try {

			BigDecimal price1 = null;

			// **************************************************
			// Calculating cost
			// **************************************************
			BigDecimal mycost = calculateCost(glassSU, systemUOM, price, cost,
					0);

			// Calculating waste from glassSU
			BigDecimal waste = new BigDecimal(glassSU.waste).divide(
					new BigDecimal("100"), 20, BigDecimal.ROUND_HALF_EVEN).add(
					new BigDecimal("1"));
			// Calculating markup from pricingGroup
			BigDecimal markup = new BigDecimal(pricingGroup.getCostMarkup())
					.divide(new BigDecimal("100"), 6,
							BigDecimal.ROUND_HALF_EVEN)
					.add(new BigDecimal("1"));

			mycost = mycost.multiply(waste);
			mycost = mycost.multiply(markup);

			// *************************************************
			// Calculating price
			// *************************************************
			price1 = mycost.multiply(
					new BigDecimal(pricingGroup.getPriceMarkup())
							.add(new BigDecimal("1"))).setScale(4,
					BigDecimal.ROUND_HALF_EVEN);

			// Evaluate price calculated with min_price
			if (price.compareTo(glassSU.minPrice) <= -1
					|| price.compareTo(glassSU.minPrice) == 0) {
				price1 = glassSU.minPrice;
			}

            //Get Partner Line Discounts
            double disc = 0.0;

            List<PartnerLineDiscount> partnerDiscounts = ApplicationBaseApp.getInstance().getPartnerLineDiscounts();
            for (PartnerLineDiscount discount : partnerDiscounts) {
                if (discount.getId().getPriceCategoryId() == 3) {
                    disc = discount.getDiscount();
                }
            }

            double discFactor = 1 - disc;

            price = price.multiply(new BigDecimal(discFactor));

			return price;

		} catch (NullPointerException e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage(), e);
		}
	}

}
