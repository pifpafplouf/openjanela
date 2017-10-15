package openjanela.app.configuration.controller.calculation;

import Model.BillOfMat;
import Presentation.ItemFrame;
import Rules.CalculatePriceCost;
import openjanela.model.entities.admin.TypePriceCategory;
import openjanela.model.entities.orderEntry.PricingGroup;
import openjanela.model.entities.partner.PartnerLineDiscount;
import openjanela.model.entities.parts.*;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.2
 *          Date: 03-04-14
 *          Time: 01:34 AM
 */
public class DealerCalculationController {

    //Apache Log4j
    private static final Logger logger = Logger.getLogger(DealerCalculationController.class);

    //Item Frame Main Constructor
    private ItemFrame myParent;

    /**
     * Dealer Price-Cost Calculation Controller Constructor
     *
     * @param itemFrame, ItemFrame
     */
    public DealerCalculationController(ItemFrame itemFrame) {
        this.myParent = itemFrame;
    }

    /**
     * Calculate Cost & Price for Dealer
     */
    public void calculateCostPriceDealer() {

        //-------------------------------------------------------------------------------
        //Init Configured Part Dealer
        //-------------------------------------------------------------------------------
        BillOfMat configuredBom = initConfiguredSupplierPart(this.myParent.jobItem.bom);

        if (configuredBom != null) {

            //-------------------------------------------------------------------------------
            //Iterate BOM from dealer to summarized cost & price
            //-------------------------------------------------------------------------------
            BigDecimal cost = new BigDecimal("0");
            for (BillOfMat bom : this.myParent.jobItem.bom) {
                if (bom.remote) {
                    cost = cost.add(bom.priceuser);
                }
            }

            Parts parts = ItemFrame.getApplicationBase().getPart(configuredBom.partid);
            parts.setCost(cost);

            //-------------------------------------------------------------------------------
            //Calculate Price Cost markup
            //-------------------------------------------------------------------------------
            calculateCostPriceMarkup(parts, configuredBom, (int) configuredBom.qty);
        }
    }

    //******************************************************************************************************************
    //***************************************<Private Methods>**********************************************************
    //******************************************************************************************************************

    /**
     * Init Configured Part Dealer
     *
     * @param billOfMaterial, Bill Of Materials
     */
    private BillOfMat initConfiguredSupplierPart(Collection<BillOfMat> billOfMaterial) {

        BillOfMat bomConfigured = null;

        /**
         * Iterate Bill Of Material to get a configured part for dealer
         */
        for (BillOfMat bom : billOfMaterial) {

            /**
             * Evaluate only for local parts configured not dealer parts
             */
            if (!bom.remote) {

                Parts part = ItemFrame.getApplicationBaseRules().getPart(bom.partid); //Return Configured Part
                if (part != null && part.isConfigured() && part.getSeries() == myParent.mySeries.getId()) {
                    bomConfigured = bom;

                    break;
                }
            }
        }

        return bomConfigured;
    }

    /**
     * Calculate Cost Price Markup
     *
     * @param parts, Parts Object
     * @param bom,   Bill Of Material
     * @param qty,   Quantity Required
     */
    private void calculateCostPriceMarkup(Parts parts, BillOfMat bom, int qty) {

        try {

            //----------------------------------------------------
            //Initialize Part Cost Price
            //----------------------------------------------------
            PartsCostPrice pcp = initializePartCostPrice(parts);

            //----------------------------------------------------
            //Search for a Valid Part Cost Price
            //----------------------------------------------------
            List<PartsCostPrice> partsCostPrices = ItemFrame.getApplicationBase().getPartsCostPrices();
            for (PartsCostPrice costPrice : partsCostPrices) {
                if (costPrice.getId().getPartid() == parts.getId() && costPrice.isIsdefault()) {
                    pcp = costPrice;
                }
            }

            //---------------------------------------------------
            //Calculate Part Cost
            //---------------------------------------------------
            BigDecimal myPartCost = new BigDecimal("0");

            if (parts != null && pcp != null && pcp.getId().getPriceuom() > 0) {

                parts.setPriceuom(pcp.getId().getPriceuom());
                parts.setPrice(pcp.getPrice());
                parts.setMinprice(pcp.getMinPrice());
                parts.setPricemeasure(pcp.getPricemeasure());

                if (parts.getPricemeasure() == 0) {
                    parts.setPricemeasure(this.myParent.currentUOM);
                }

                parts.setPricematrix(pcp.getPricematrix());
                parts.setCostmatrix(pcp.getStdcostmatrix());
                parts.setCostmeasure(pcp.getPricemeasure());
                parts.setCostuom(pcp.getId().getPriceuom());
                parts.setTaxable(pcp.isTaxable());
                parts.setDiscountable(pcp.isDiscountable());
                parts.setPrice_markup(pcp.getPrice_markup());
                parts.setCost_markup(pcp.getCost_markup());

                //Calculate Part Cost
                myPartCost = parts.getCost().multiply(new BigDecimal((parts.getCost_markup() + 1) + ""));

                //Calculate Part Price
                if (parts.getPrice_markup() > 0 && parts.getPricematrix() == 0) {
                    parts.setPrice(myPartCost.multiply(new BigDecimal((parts.getPrice_markup() + 1) + "")));
                }
            }

            //---------------------------------------------------------------------------------
            //Calculate Line Discount
            //---------------------------------------------------------------------------------
            PricingGroup priceGroup = ItemFrame.getApplicationBase().getPricingGroup(parts.getPricegroup());
            TypePriceCategory priceCategory = ItemFrame.getApplicationBase().getTypePriceCategory(priceGroup.getId());

            double discount = getLineDiscount(priceCategory.getId());

            //--------------------------------------------------------------------------------
            //Calculate Price Sizes
            //--------------------------------------------------------------------------------
            double pricesizem = 0.0d;
            double costsizem = 0.0d;
            double pricesizei = 0.0d;
            double costsizei = 0.0d;

            if (pcp.getId().getPriceuom() == 1) {
                pricesizem = 0;
                pricesizei = 0;
            } else if (pcp.getId().getPriceuom() == 2) {
                pricesizem = bom.cutlength / 100d / 1000d;
                pricesizei = bom.cutlengthi / 64d / 12d;
            } else if (pcp.getId().getPriceuom() == 3) {
                pricesizem = bom.areauser;
                pricesizei = bom.areaiuser;
            } else if (pcp.getId().getPriceuom() == 4) {// FaceIn
                pricesizem = parts.getFacein() * bom.cutlength / 100d / 1000d;
                pricesizei = parts.getFaceini() * bom.cutlengthi / 64d / 12d;
            } else if (pcp.getId().getPriceuom() == 5) {// FaceOut
                pricesizem = parts.getFaceout() * bom.cutlength / 100d / 1000d;
                pricesizei = parts.getFaceouti() * bom.cutlengthi / 64d / 12d;
            } else if (pcp.getId().getPriceuom() == 6) {// Perimeter
                pricesizem = parts.getPerimeter() * bom.cutlength / 100d / 1000d;
                pricesizei = parts.getPerimeteri() * bom.cutlengthi / 64d / 12d;
            } else if (pcp.getId().getPriceuom() == 7) {// weight
                pricesizem = parts.getWeight() * bom.cutlength / 100d / 1000d;
                pricesizei = parts.getWeighti() * bom.cutlengthi / 64d / 12d;
            } else if (pcp.getId().getPriceuom() == 8) {
                pricesizem = bom.volume;
                pricesizei = bom.volumei;
            } else if (pcp.getId().getPriceuom() == 9) {
                pricesizem = 1;
                pricesizei = 1;
            } else if (pcp.getId().getPriceuom() == 10) {
                pricesizem = 1;
                pricesizei = 1;
            } else if (pcp.getId().getPriceuom() == 11) {
                pricesizem = 1;
                pricesizei = 1;
            }

            if (pcp.costuom == 1) {
                costsizem = 0;
                costsizei = 0;
            } else if (pcp.costuom == 2) {
                costsizem = bom.cutlength / 100d / 1000d;
                costsizei = bom.cutlengthi / 64d / 12d;
            } else if (pcp.costuom == 3) {
                costsizem = bom.areauser;
                costsizei = bom.areaiuser;
            } else if (pcp.costuom == 4) {
                costsizem = parts.getFacein() * bom.cutlength / 100d / 1000d;
                costsizei = parts.getFaceini() * bom.cutlengthi / 64d / 12d;
            } else if (pcp.costuom == 5) {
                costsizem = parts.getFaceout() * bom.cutlength / 100d / 1000d;
                costsizei = parts.getFaceouti() * bom.cutlengthi / 64d / 12d;
            } else if (pcp.costuom == 6) {
                costsizem = parts.getPerimeter() * bom.cutlength / 100d / 1000d;
                costsizei = parts.getPerimeteri() * bom.cutlengthi / 64d / 12d;
            } else if (pcp.costuom == 7) {
                costsizem = parts.getWeight() * bom.cutlength / 100d / 1000d;
                costsizei = parts.getWeighti() * bom.cutlengthi / 64d / 12d;
            } else if (pcp.costuom == 8) {
                costsizem = bom.volume;
                costsizei = bom.volumei;
            } else if (pcp.costuom == 9) {
                costsizem = 1;
                costsizei = 1;
            } else if (pcp.costuom == 10) {
                costsizem = 1;
                costsizei = 1;
            } else if (pcp.costuom == 11) {
                costsizem = 1;
                costsizei = 1;
            }

            BigDecimal myPrice = pcp.getPrice();

            Object[] mypricecost = setCalcPrice(pricesizem, pricesizei, costsizem, costsizei, priceGroup, qty, discount,
                    pcp.price_markup, pcp.cost_markup, myPrice, myPartCost, pcp.minPrice, pcp.getId().getPriceuom(),
                    pcp.costuom, pcp.pricemeasure, pcp.isDiscountable(), this.myParent, this.myParent.currentUOM,
                    parts.getWaste());

            bom.price = bom.priceuser = new BigDecimal(mypricecost[2].toString());
            bom.cost = new BigDecimal(mypricecost[3].toString());

            bom.totalprice = bom.totalpriceuser = new BigDecimal(mypricecost[0].toString());
            bom.totalcost = new BigDecimal(mypricecost[1].toString());


        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * Initialized Parts Cost Price
     *
     * @param parts, Parts
     * @return PartsCostPrice
     */
    private PartsCostPrice initializePartCostPrice(Parts parts) {

        //----------------------------------------------------------------------
        //Init Parts Cost Price
        //----------------------------------------------------------------------
        PartsCostPrice pcp = new PartsCostPrice();

        //Create Parts Cost Price Primary Key
        PartsCostPricePK partsCostPricePK = new PartsCostPricePK();
        partsCostPricePK.setPartid(parts.getId());
        partsCostPricePK.setPriceuom(parts.getPriceuom());

        pcp.setId(partsCostPricePK);

        //Set Price cost Values
        pcp.isdefault = true;
        pcp.cost_markup = parts.getCost_markup();
        pcp.discountable = parts.isDiscountable();
        pcp.fifocost = parts.getCost();
        pcp.lifocost = parts.getCost();
        pcp.minPrice = parts.getMinprice();
        pcp.mostrecentcost = parts.getCost();
        pcp.movingavgcost = parts.getCost();
        pcp.price = parts.getPrice();
        pcp.price_markup = parts.getPrice_markup();

        if (parts.getPrice_markup() == 1) {
            pcp.pricefromcost = true;
        }

        pcp.pricematrix = parts.getPricematrix();
        pcp.stdcostmatrix = parts.getCostmatrix();
        pcp.pricemeasure = parts.getPricemeasure();
        pcp.priceuomconvert = parts.getPriceuomconvert();
        pcp.stdcost = parts.getCost();
        pcp.taxable = parts.isTaxable();

        pcp.costuom = parts.getUsageuom();
        pcp.pricemeasure = parts.getPricemeasure();

        //------------------------------------------------------
        //Init Part Family
        //------------------------------------------------------
        PartsFamily partFam = ItemFrame.getApplicationBase().getPartsFamily(parts.getPartfamily());
        if (partFam.getId() == 8) {
            pcp.costuom = parts.getCostuom();
        }

        PartFamilySeries pfSeries = ItemFrame.getApplicationBase().getPartFamilySeries(partFam.getId(), this.myParent.seriesID);

        if (pfSeries != null) {
            partFam.setIncludeInPrice(pfSeries.getIncludeInPrice());
            partFam.setPriceGroup(pfSeries.getPriceGroup());
            partFam.setMarkedupCost(pfSeries.getMarkedupCost());
            partFam.setPriceMarkup(pfSeries.getPriceMarkup());
            partFam.setPriceMarkupMatrix(pfSeries.getPriceMarkupMatrix());
            partFam.setIncludeInCost(pfSeries.getIncludeInCost());
            partFam.setIncludeInCost(pfSeries.getIncludeInCost());
            partFam.setCostGroup(pfSeries.getCostGroup());
            partFam.setCostMarkup(pfSeries.getCostMarkup());
            partFam.setCostMarkupMatrix(pfSeries.getCostMarkupMatrix());
        }

        // Do matrix loopup here for price markup
        if (parts.getPrice_markup() == 0 || pfSeries != null) {
            pcp.price_markup = partFam.getPriceMarkup();
        }

        // Do matrix loopup here for price markup
        if (parts.getCost_markup() == 0 || pfSeries != null) {
            pcp.cost_markup = partFam.getCostMarkup();
        }

        return pcp;
    }

    /**
     * Return Line Discount
     *
     * @param pricecat, Price Category
     * @return double
     */
    private double getLineDiscount(int pricecat) {

        //Init Discount
        double discount = 0.0d;

        //Init Partner Line Discounts
        List<PartnerLineDiscount> lineDiscounts = ItemFrame.getApplicationBase().getPartnerLineDiscounts();
        for (PartnerLineDiscount lineDiscount : lineDiscounts) {
            if (pricecat == lineDiscount.getId().getPriceCategoryId()) {
                discount = lineDiscount.getDiscount();

                break;
            }
        }

        return discount;
    }

    /**
     * Calculate Price
     *
     * @return Object[]
     */
    public Object[] setCalcPrice(double size, double sizei, double costingsize, double costingsizei, PricingGroup priceGroup,
                                 double quantity, double discountP, double pricemarkup, double costmarkup, BigDecimal price,
                                 BigDecimal cost, BigDecimal minprice, int priceuom, int costuom, int pricemeasure,
                                 boolean discountable, ItemFrame itemFrame, int currentUOM, double waste) {

        CalculatePriceCost calPriceCost = new CalculatePriceCost();
        calPriceCost.qty = quantity;
        calPriceCost.sizem = size;
        calPriceCost.sizei = sizei;
        calPriceCost.costingsizem = costingsize;
        calPriceCost.costingsizei = costingsizei;
        calPriceCost.price = price;
        calPriceCost.cost = cost;
        calPriceCost.discountP = discountP;
        calPriceCost.myFrame2 = itemFrame;
        calPriceCost.pg = priceGroup;
        calPriceCost.pricemarkup = pricemarkup;
        calPriceCost.costmarkup = costmarkup;
        calPriceCost.priceuom = priceuom;
        calPriceCost.costuom = costuom;
        calPriceCost.myMeasure = currentUOM;
        calPriceCost.pricemeasure = pricemeasure;
        calPriceCost.discountable = discountable;
        calPriceCost.minprice = minprice;
        calPriceCost.waste = waste;

        Object[] mo = calPriceCost.calcTotalPrice();

        return mo;
    }
}
