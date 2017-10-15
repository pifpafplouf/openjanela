package Rules;

import Model.*;
import Model.ProfileParts.Profiles;
import Presentation.ItemFrame;
import openjanela.app.configuration.controller.calculation.MatrixController;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.TypePriceCategory;
import openjanela.model.entities.orderEntry.PricingGroup;
import openjanela.model.entities.partner.*;
import openjanela.model.entities.parts.PartFamilySeries;
import openjanela.model.entities.parts.Parts;
import openjanela.model.entities.parts.PartsCostPrice;
import openjanela.model.entities.parts.PartsFamily;
import util.UOMConvert;

import javax.swing.*;

import java.math.BigDecimal;
import java.util.*;

public class ExecutePartRules extends ExecuteClearanceRules {

	boolean doBom = false;

	public ExecutePartRules(ItemFrame myframe) {
		super(myframe);
	}

	/*
	 * public Object executePartRules(ShapeObject shape, OrderItemsCart item,
	 * Profiles mullion, int level, boolean doErrors, boolean doAll, String
	 * from, boolean doBom, series) {
	 *//*******
	 * Assembly Level to indicate which rule level to execute.
	 * 
	 * Object myObject = generic Object sent for evaluation
	 * 
	 * Need Override for occasions where the user forced a choice, for example
	 * Specific profile or end type, or color
	 * 
	 * 
	 ********/
	/*
		
		*//**
	 * 1,0,Overall,1 2,1,Facet,1 3,3,Frame,1 4,121,Sash Type,1 5,12,Sash,1
	 * 6,21,Glass/Glazing,1 7,0,Glazing Bead,1 8,22,DLO,1 20,5,Bkgrd Opening,1
	 * 30,0,Divider,1 31,2,Coupler,1 32,4,Mullion,1 32,0,Grids,1 40,5,Opening,1
	 * 200,1,Sub-Facet,1 400,121,Sub-Sash,1 902,0,Object,2 903,0,Object,3
	 * 904,0,Object,4 905,0,Object,5 906,0,Object,6 907,0,Object,7
	 */
	/*
	 * doAll = false;
	 * 
	 * int setS = this.setAssembly;
	 * 
	 * myUOM = myFrame2.currentUOM;
	 * 
	 * if (myFrame2.currentUOM == 1) { myScale = myFrame2.metricscale; } else {
	 * myScale = myFrame2.imperialscale; }
	 * 
	 * myAssemblyLevel = level;
	 *//**
	 * Set Object to pre-defined Object in order to use its properties
	 */
	/*
	 * 
	 * myShape = shape;
	 * 
	 * myMullionCoupler = mullion;
	 * 
	 * myItem = item;
	 * 
	 * if (myShape != null) { mySeq = myShape.a_sequenceID; myShape.bom.clear();
	 * } if (myMullionCoupler != null) { mySeq = myMullionCoupler.rowCol;
	 * myMullionCoupler.bom.clear(); } else { mySeq = 0;
	 * 
	 * }
	 * 
	 * if (myMullionCoupler != null && (myMullionCoupler.a_assemblyLevel >= 30
	 * && myMullionCoupler.a_assemblyLevel <= 32)) { // Coupler
	 * 
	 * if (myMullionCoupler.a_assemblyLevel == 30) { // divider myDivider =
	 * mullion; } else if (myMullionCoupler.a_assemblyLevel == 31) {// coupler
	 * myCoupler = mullion; } else {
	 * 
	 * if (myMullionCoupler.cOrM == 2) {// mullion myMullion = mullion; } else
	 * if (myMullionCoupler.cOrM == 7) {// grid myGrid = mullion; } } }
	 * 
	 * if (myAssemblyLevel == 903) {// Part/item Unit myUnitItem = myItem; }
	 * else if (myAssemblyLevel == 904) {// Part Profile myProfileItem = myItem;
	 * } else if (myAssemblyLevel == 905) {// Part/item Area myAreaItem =
	 * myItem; } else if (myAssemblyLevel == 906) {// Part/item Volume
	 * myVolumeItem = myItem; } else if (myAssemblyLevel == 907) {// Part/item
	 * Labour/Service myLabourItem = myItem; }
	 * 
	 * this.currentRules =
	 * getPartRules(ItemFrame.getApplicationBaseRules().getRules
	 * (ItemFrame.seriesID));
	 * 
	 * if(!doAll){ // this.currentRules =
	 * getPartRules(ItemFrame.getApplicationBaseRules
	 * ().getRules(ItemFrame.seriesID));
	 * 
	 * Object[] cr = currentRules.toArray(); currentRules.clear(); for(Object r
	 * : cr){ if(((Rules) r).getAffectsdesign()){ currentRules.add((Rules)r); }
	 * }
	 * 
	 * }
	 * 
	 * if (this.currentRules.size() > 0) {
	 * 
	 * return executeCurrentPartRules(this.currentRules,
	 * ItemFrame.getApplicationBaseRules().getRuleTest(ItemFrame.seriesID),
	 * ItemFrame
	 * .getApplicationBaseRules().getRuleTestValues(ItemFrame.seriesID),
	 * ItemFrame.getApplicationBaseRules().getRuleAnswers(), doErrors, doBom); }
	 * else {
	 * 
	 * if (myShape != null) { return myShape; } else if (myMullionCoupler !=
	 * null) { return myMullionCoupler; } else if (myItem != null) { return
	 * null; }
	 * 
	 * return null; }
	 * 
	 * }
	 */

	/**
	 * Execute Part Rules for Shape Object & Profiles
	 * 
	 * @param rule
	 *            , Rule Object
	 * @param shape
	 *            , Shape Object
	 * @param mullion
	 *            , Profiles
	 * @return Object
	 */
	public Object executePartRules(Rules rule, ShapeObject shape,
			Profiles mullion, boolean dobom) {

		doBom = dobom;

		if (doBom) {
			this.myUOM = myFrame2.currentUOM;
		}

		/**
		 * 1. Init Unit of Measure & Scale
		 */
		this.myUOM = myFrame2.currentUOM;

		if (myFrame2.currentUOM == 1) {
			this.myScale = myFrame2.metricscale;
		} else {
			this.myScale = myFrame2.imperialscale;
		}

		/**
		 * 2. Set Object to pre-defined Object in order to use its properties
		 */
		this.myShape = shape;
		this.myMullionCoupler = mullion;

		if (myMullionCoupler != null
				&& (myMullionCoupler.a_assemblyLevel >= 30 && myMullionCoupler.a_assemblyLevel <= 32)) { // Coupler

			if (myMullionCoupler.a_assemblyLevel == 30) { // divider
				myDivider = mullion;
			} else if (myMullionCoupler.a_assemblyLevel == 31) {// coupler
				myCoupler = mullion;
			} else {

				if (myMullionCoupler.cOrM == 2) {// mullion
					myMullion = mullion;
				} else if (myMullionCoupler.cOrM == 7) {// grid
					myGrid = mullion;
				}
			}
		}

		/**
		 * 3. Init Current Rules
		 */
		this.currentRules = new ArrayList<Rules>();
		this.currentRules.add(rule);

		/**
		 * 4. Execute Current Rules
		 */
		return executeCurrentPartRules(this.currentRules, ItemFrame
				.getApplicationBaseRules().getRuleTestByRuleNo(rule), ItemFrame
				.getApplicationBaseRules().getRuleAnswers(), true, doBom, rule
				.getRulesPK().getSeriesId());
	}

	public List<Rules> getPartRules(List<Rules> rules) {

		List<Rules> mainRules = new ArrayList();
		for (Rules rule : rules) {
			if (rule.getRuletype() > 5 && isCorrectAssemblyLevel(rule))
			// if ( isCorrectAssemblyLevel(rule))
			{
				mainRules.add(rule);
			}
		}

		Collections.sort(mainRules, RulesComparator.RULE_ID);

		return mainRules;
	}

	public List<Rules> getAllpartRules(List<Rules> rules) {

		List<Rules> mainRules = new ArrayList();
		for (Rules rule : rules) {
			if (rule.getRuletype() > 3)
				mainRules.add(rule);
		}

		Collections.sort(mainRules, RulesComparator.RULE_ID);

		return mainRules;
	}

	@SuppressWarnings("rawtypes")
	public Object executeCurrentPartRules(List<Rules> rules,
			List<RuleTest> rtests, List<RuleAnswers> ranswers,
			boolean doErrors, boolean doBom, int series) {

		boolean passLocalTest = false;
		double quantity = 0;
		int wAdjust = 0;
		int hAdjust = 0;
		int wAdjusti = 0;
		int hAdjusti = 0;

		int w = 0;
		int wi = 0;
		int h = 0;
		int hi = 0;
		int l = 0;
		int li = 0;
		int d = 0;
		int di = 0;

		Parts part = new Parts();
		Profiles profile = new Profiles();
		String error = " ";
		String warning = " ";

		PricingGroup priceGroup = new PricingGroup();

		for (Rules rule : rules) {

			part = new Parts();
			profile = new Profiles();
			error = " ";
			warning = " ";
			priceGroup = new PricingGroup();
			passLocalTest = false;

			if (rule.getRulesPK().getSeriesId()==28 &&
					rule.getRulesPK().getId()==16) {
				part = new Parts();
			}

			// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			// Evaluate Rule Answers & Rule Test for Suppliers
			// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			if (rule.isRemote()) {
				rtests = ItemFrame.getApplicationRemoteBaseRules().getRuleTest(
						rule.getSupplierId(), rule.getRulesPK().getSeriesId());
				ranswers = ItemFrame.getApplicationRemoteBaseRules()
						.getRuleAnswers(rule.getSupplierId());
			}

			passLocalTest = filterArraysAndTest(rule, ranswers, rtests, series);

			// Add Errors & Warnings Rules
			if (!passLocalTest
					&& (rule.getRuletype() == 19 || rule.getRuletype() == 20)) {
				if (myFrame2.errorMessages.size() > 0
						|| this.myFrame2.warningMessages.size() > 0) {
					cleanErrorsAndWarnings(rule.getRulesPK().getId());
				}
			}

			// Remove Rules from Bill of Materials
			if (!passLocalTest) {

				if (myShape != null) {

					for (Iterator it = myShape.bom.iterator(); it.hasNext();) {
						BillOfMat bom = (BillOfMat) it.next();

						if (bom.seriesid == rule.getRulesPK().getSeriesId()
								&& bom.ruleno.intValue() == rule.getRulesPK()
										.getId()) {
							it.remove();
						}
					}

				} else if (myMullionCoupler != null) {

					for (Iterator it = myMullionCoupler.bom.iterator(); it
							.hasNext();) {
						BillOfMat bom = (BillOfMat) it.next();

						if (bom.ruleno.intValue() == rule.getRulesPK().getId()) {
							it.remove();
						}
					}

				} else if (this.myItem != null) {

					for (Iterator it = myItem.bom.iterator(); it.hasNext();) {
						BillOfMat bom = (BillOfMat) it.next();

						if (bom.ruleno.intValue() == rule.getRulesPK().getId()) {
							it.remove();
						}
					}
				}
			}

			// Execute If Rule Local Test Pass
			if (passLocalTest) {

				myParentRule = rule; // TODO: Change value
				parentRuleID = 0;

				if (rule.getRuletype() == 9) // Rule Segment
				{
					// subRules.clear();
					// subTests.clear();
					// subTestValues.clear();
					// subRulesAnswers.clear();// shipping

					int mseries = rule.getRulevalue();

					this.subParentTests = rtests;
					this.subParentRulesAnswers = ranswers;

					this.myParentRule = rule;
					this.parentRuleID = rule.getRulesPK().getId();

					if (mseries == 21) {
						System.out.println(mseries);
					}

					List<Rules> ruleList = new ArrayList<Rules>();

					if (doBom) {
						if (rule.isRemote()) {
							ruleList = getAllpartRules(ItemFrame
									.getApplicationRemoteBaseRules().getRules(
											rule.getSupplierId(), mseries));
						} else {
							ruleList = getAllpartRules(ItemFrame
									.getApplicationBaseRules()
									.getRules(mseries));
						}
					} else {
						if (rule.isRemote()) {
							ruleList = getAllpartRules(ItemFrame
									.getApplicationRemoteBaseRules().getRules(
											rule.getSupplierId(), mseries));
						} else {
							ruleList = getPartRules(ItemFrame
									.getApplicationBaseRules()
									.getRules(mseries));
						}
					}

					for (Rules r : ruleList) {

						if (filterArraysAndTest(r, subParentRulesAnswers,
								subParentTests, mseries)) {

							List<Rules> ml = new ArrayList<Rules>();
							ml.add(r);

							executeCurrentPartRules(ml,
									ItemFrame.getApplicationBaseRules()
											.getRuleTest(mseries), ItemFrame
											.getApplicationBaseRules()
											.getRuleAnswers(), true, doBom,
									mseries);
						}
					}

				} else if (rule.getRuletype() != 9) // Part
				{
					if (passLocalTest) {

						/**
						 * 
						 * Get Quantity Values From rule
						 * 
						 */

						try {

							if (rule.getRulesPK().getId() == 14) {
								part = new Parts();
							}

							part = getPart(rule, part);

							if (part == null) {
								part = new Parts();
							}

						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						quantity = this.getRuleQuantityValue(rule);

						/**
						 * Get Adjudtment Values From rule
						 */

						int[] res2 = this.getAdjustValue(rule);

						wAdjust = res2[0];

						wAdjusti = res2[1];

						hAdjust = res2[2];

						hAdjusti = res2[3];

						/**
						 * 
						 * Get w and h (metric and Imp) based for ShapeObject
						 * Based on Metric/Imp and Condition 4 (Nominal/Actual
						 * Size)
						 * 
						 */

						Collection boms = new ArrayList();

						if (rule.getRulesPK().getId() == 188) {
							boms = new ArrayList();
						}

						boms = getPartSizeForShape(rule, myUOM, wAdjust,
								wAdjusti, hAdjust, hAdjusti, quantity, part,
								doErrors, passLocalTest);

						/**
						 * Calculate Price and Cost for Non Input Options
						 */

						if (myShape != null) {

							boolean found = false;

							Object[] sboms = myShape.bom.toArray();

							for (Object sb : sboms) {
								BillOfMat bom = ((BillOfMat) sb);
								if (bom.ruleno == rule.getRulesPK().getId()
										&& bom.seriesid == rule.getRulesPK().getSeriesId()) {
									found = true;
									break;
								}
							}

							if (!found && doBom) {
								myShape.bom.addAll(boms);
							}

						} else if (myMullionCoupler != null) {
							boolean found = false;

							Object[] sboms = myMullionCoupler.bom.toArray();
							for (Object sb : sboms) {
								BillOfMat bom = ((BillOfMat) sb);
								if (bom.ruleno == rule.getRulesPK().getId()) {
									found = true;
									break;
								}
							}

							if (!found && doBom) {

								myMullionCoupler.bom.addAll(boms);

							}

						} else if (myItem != null) {

						}
					}
				}
			}
		}

		if (myShape != null) {
			return myShape;
		} else if (myMullionCoupler != null) {
			return myMullionCoupler;
		} else if (myItem != null) {
			return null;
		}

		return null;
	}

	public void cleanErrorsAndWarnings(int ruleid) {

		Object[] err = myFrame2.errorMessages.toArray();
		Object[] war = myFrame2.warningMessages.toArray();
		myFrame2.errorMessages.clear();
		myFrame2.warningMessages.clear();

		for (Object ew : err) {
			if (((ErrorsAndWarnings) ew).ruleId != ruleid) {
				myFrame2.errorMessages.add((ErrorsAndWarnings) ew);
			}
		}

		for (Object ew : war) {
			if (((ErrorsAndWarnings) ew).ruleId != rule.getRulesPK().getId()) {
				myFrame2.warningMessages.add((ErrorsAndWarnings) ew);
			}

		}

	}

	public void cleanInfoMessage(int ruleid) {

		Object[] err = myFrame2.infoMessages.toArray();

		myFrame2.infoMessages.clear();

		for (Object ew : err) {
			if (((InfoMessage) ew).ruleid != ruleid) {
				myFrame2.infoMessages.add((InfoMessage) ew);
			}
		}

	}

	public void cleanShapeNotes(int ruleid) {

		if (myShape != null) {
			Object[] snotes = myShape.notes.toArray();

			myShape.notes.clear();

			for (Object ew : snotes) {
				if (((ShapeNotes) ew).ruleid != ruleid) {
					myShape.notes.add((ShapeNotes) ew);
				}
			}
		}
		if (this.myMullionCoupler != null) {
			Object[] snotes = myMullionCoupler.notes.toArray();

			myMullionCoupler.notes.clear();

			for (Object ew : snotes) {
				if (((ShapeNotes) ew).ruleid != ruleid) {
					myMullionCoupler.notes.add((ShapeNotes) ew);
				}
			}
		}

	}

	/**
	 * Return Part from Rules Value
	 * 
	 * @param rule
	 *            , Rule Object to Process
	 * @param parts
	 *            , Part Object to Process
	 * @return Parts
	 * @throws Exception
	 *             , Exception
	 */
	private Parts getPart(Rules rule, Parts parts) throws Exception {

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// Search Part Value
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (rule.getRuletype() == 6) {
			if (rule.isRemote()) {
				parts = ItemFrame.getApplicationRemoteBaseRules().getPart(
						rule.getSupplierId(), rule.getRulevalue());
			} else {
				parts = ItemFrame.getApplicationBaseRules().getPart(
						rule.getRulevalue());
			}

		} else if (rule.getRuletype() == 7 || rule.getRuletype() == 8) {

			int partID = 0;

			if (myShape != null) {
				MatrixController matrixController = new MatrixController(
						myShape, this.myFrame2);
				partID = (int) (matrixController.getValueFromMatrix(
						rule.getRulevalue(), rule.getSupplierId(), false,
						false, rule.isRemote())).doubleValue();
			} else if (myShape == null && this.myMullionCoupler != null) {
				MatrixController matrixController = new MatrixController(
						myMullionCoupler, this.myFrame2);
				partID = (int) (matrixController.getValueFromMatrix(
						rule.getRulevalue(), rule.getSupplierId(), false,
						false, rule.isRemote())).doubleValue();
			} else if (myShape == null && this.myMullionCoupler == null
					&& this.myItem != null) {

			}

			if (rule.isRemote()) {
				parts = ItemFrame.getApplicationRemoteBaseRules().getPart(
						rule.getSupplierId(), partID);
			} else {
				parts = ItemFrame.getApplicationBaseRules().getPart(partID);
			}

		} else if (rule.getRuletype() == 90 || rule.getRuletype() == 92) {
			if (rule.isRemote()) {
				parts = ItemFrame.getApplicationRemoteBaseRules().getPart(
						rule.getSupplierId(), rule.getRulevalue());
			} else {
				parts = ItemFrame.getApplicationBaseRules().getPart(
						rule.getRulevalue());
			}
		} else if (rule.getRuletype() == 19 || rule.getRuletype() == 20) {
			if (rule.isRemote()) {
				parts = ItemFrame.getApplicationRemoteBaseRules().getPart(
						rule.getSupplierId(), rule.getRulevalue());
			} else {
				parts = ItemFrame.getApplicationBaseRules().getPart(
						rule.getRulevalue());
			}
		}

		return parts;
	}

	private Collection getPartSizeForShape(Rules rule, int myUOM, int adjw,
			int adjwi, int adjh, int adjhi, double qty, Parts part,
			boolean doErrors, boolean passLocalTest) {

		Collection bomRecords = new ArrayList();

		if (rule.getRulesPK().getId() == 17) {
			System.out.println(rule);
		}

		/**
		 * Type of Rule: Part, Matrix, profile matrix, segment, warning, error
		 */
		if (rule.getRuletype() == 6 || rule.getRuletype() == 7
				|| rule.getRuletype() == 8 || rule.getRuletype() == 9) {

			/**
			 * By Type of Part Then by Position0
			 */
			if (part.getParttype() == 1 || part.getParttype() == 19) {

				doUnitParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
						bomRecords);

			} else if (part.getParttype() == 2 || part.getParttype() == 15
					|| part.getParttype() == 502) { // Profile Parts
				doProfileParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
						bomRecords);

			} else if (part.getParttype() == 3 || part.getParttype() == 16) { // Area/Film
				doAreaParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
						bomRecords);
			} else if (part.getParttype() == 4 || part.getParttype() == 18) { // Roll
				doRollParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
						bomRecords);
			} else if (part.getParttype() == 5) { // WxH Report
				doAreaParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
						bomRecords);
			} else if (part.getParttype() == 6) { // Kit
				doUnitParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
						bomRecords);
			} else if (part.getParttype() == 8 || part.getParttype() == 8
					|| part.getParttype() == 17) {// Labour
				doUnitParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
						bomRecords);
			} else if (part.getParttype() == 10 || part.getParttype() == 50
					|| part.getParttype() == 51 || part.getParttype() == 500
					|| part.getParttype() == 501) { // Capacity
				if (rule.getRulesPK().getId() == 295) {
					int ff = 0;
				}
				doUnitParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
						bomRecords);
			} else if (part.getParttype() == 11) { // Error
				doUnitParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
						bomRecords);
			} else if (part.getParttype() == 14) { // Volume
				doVolumeParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
						bomRecords);
			}
		}
		/**
		 * set prod Line, Station .... etc.
		 */
		else if (rule.getRuletype() >= 11 && rule.getRuletype() <= 17
				|| rule.getRuletype() <= 95) {

			if (rule.getRuletype() == 90) {
				if (part.getParttype() == 12) { // Set Assembly Unit
					this.setAssembly = part.getId();

					doUnitParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
							bomRecords);
				} else if (part.getParttype() == 13) { // Set Assembly WxH
					this.setAssembly = part.getId();

					doAreaParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
							bomRecords);
				}
			}
			if (rule.getRuletype() == 92) {
				if (part.getParttype() == 12) { // Set Assembly Unit
					this.setParentAssembly = part.getId();
					setParentRule = rule.getRulesPK().getId();
					// doUnitParts(rule, adjw, adjwi, adjh, adjhi, qty,
					// part, bomRecords);
				} else if (part.getParttype() == 13) { // Set Assembly WxH
					this.setParentAssembly = part.getId();
					setParentRule = rule.getRulesPK().getId();
					// doAreaParts(rule, adjw, adjwi, adjh, adjhi, qty,
					// part, bomRecords);
					// doAreaParts(rule, adjw, adjwi, adjh, adjhi, qty,
					// part, bomRecords);
				}
			}
			if (rule.getRuletype() == 95)// Force Assembly
			{

				forcedAssembly = rule.getRulevalue();

			} else if (rule.getRuletype() == 11) // set Wild
			{

				/**
				 * Set Which Color Option controls the Color for Following Parts
				 */

				Object[] opts = null;
				if (myShape != null) {

					opts = myShape.options.toArray();
				} else if (myMullionCoupler != null) {
					opts = myMullionCoupler.options.toArray();
				} else if (this.myItem != null) {

				}
				OptionDefinitions option = new OptionDefinitions();

				for (Object o : opts) {

					// Init Shape Option
					ShapeOption shapeOption = (ShapeOption) o;

					if (shapeOption.remote) {
						option = ItemFrame.getApplicationRemoteBaseRules()
								.getOptionDefinitions(shapeOption.supplierId,
										shapeOption.optionid);
					} else {
						option = ItemFrame.getApplicationBaseRules()
								.getOptionDefinitions(shapeOption.optionid);
					}

					if (((ShapeOption) o).optionid == rule.getRulevalue()) {

						if (Integer.valueOf(rule.getRulevalue2()).intValue() == 1) {
							this.setWild1 = ((ShapeOption) o).myanswer.getId()
									.getId();
							this.setWild1T = ((ShapeOption) o).myanswer
									.getAbbreviation();
						} else if (Integer.valueOf(rule.getRulevalue2())
								.intValue() == 2) {
							this.setWild2 = ((ShapeOption) o).myanswer.getId()
									.getId();
							this.setWild2T = ((ShapeOption) o).myanswer
									.getAbbreviation();
						} else if (Integer.valueOf(rule.getRulevalue2())
								.intValue() == 3) {
							this.setWild2 = ((ShapeOption) o).myanswer.getId()
									.getId();
							this.setWild2T = ((ShapeOption) o).myanswer
									.getAbbreviation();
						} else if (Integer.valueOf(rule.getRulevalue2())
								.intValue() == 3) {
							this.setWild3 = ((ShapeOption) o).myanswer.getId()
									.getId();
							this.setWild3T = ((ShapeOption) o).myanswer
									.getAbbreviation();
						} else if (Integer.valueOf(rule.getRulevalue2())
								.intValue() == 4) {
							this.setWild4 = ((ShapeOption) o).myanswer.getId()
									.getId();
							this.setWild4T = ((ShapeOption) o).myanswer
									.getAbbreviation();
						} else if (Integer.valueOf(rule.getRulevalue2())
								.intValue() == 5) {
							this.setWild5 = ((ShapeOption) o).myanswer.getId()
									.getId();
							this.setWild5T = ((ShapeOption) o).myanswer
									.getAbbreviation();
						} else if (Integer.valueOf(rule.getRulevalue2())
								.intValue() == 6) {
							this.setWild6 = ((ShapeOption) o).myanswer.getId()
									.getId();
							this.setWild6T = ((ShapeOption) o).myanswer
									.getAbbreviation();
						}

						if (option.getOptiontypeid() == 2) {

							this.colorList.add(option.getId());

							// if(company pref First option Out Color ? y/n)
							if (colorList.size() == 1) {
								this.setColorAnswer = ((ShapeOption) o).myanswer;
								this.setRGB_r = ((ShapeOption) o).rgb_R;
								this.setRGB_g = ((ShapeOption) o).rgb_G;
								this.setRGB_b = ((ShapeOption) o).rgb_B;
								showColorOptionID = option.getId();
							} else if (colorList.size() > 1) {
								this.setColorAnswerIn = ((ShapeOption) o).myanswer;
								this.setRGB_rIn = ((ShapeOption) o).rgb_R;
								this.setRGB_gIn = ((ShapeOption) o).rgb_G;
								this.setRGB_bIn = ((ShapeOption) o).rgb_B;
							}
						} else if (option.getOptiontypeid() == 4) {
							this.setSize = ((ShapeOption) o).sizeanswer;
							this.setSizeI = ((ShapeOption) o).sizeansweri;
						} else if (option.getOptiontypeid() == 5) {
							this.setDepth = ((ShapeOption) o).depthanswer;
							this.setDepthI = ((ShapeOption) o).depthansweri;
						}

						break;
					}
				}
			} else if (rule.getRuletype() == 14) {
				this.setProdLine = rule.getRulevalue();
			} else if (rule.getRuletype() == 15) {
				this.setStation = rule.getRulevalue();
			} else if (rule.getRuletype() == 16) {
				this.setReport = rule.getRulevalue();
			} else if (rule.getRuletype() == 17) {
				this.setDelivery = rule.getRulevalue();
			} else if (rule.getRuletype() == 18) {
				this.setProcess = rule.getRulevalue();
			}

			if (rule.getRuletype() == 19 && doErrors) { // warning

				ErrorsAndWarnings ew = new ErrorsAndWarnings();
				ew.setShapeIdentifires(this.myShape, myMullionCoupler, myItem,
						rule.getDescription(), rule.getRulesPK().getId());

				this.myFrame2.warningMessages.add(ew);

				JOptionPane.showMessageDialog(this.myFrame2,
						"Warning: " + rule.getDescription()
								+ "\n Warning issued at Rule: "
								+ rule.getRulesPK().getId(),
						"Rule based WARNING!", JOptionPane.WARNING_MESSAGE);

			} else if (rule.getRuletype() == 20 && doErrors) { // Error

				ErrorsAndWarnings ew = new ErrorsAndWarnings();
				ew.setShapeIdentifires(this.myShape, myMullionCoupler, myItem,
						rule.getDescription(), rule.getRulesPK().getId());

				this.myFrame2.errorMessages.add(ew);

				JOptionPane.showMessageDialog(this.myFrame2,
						"Error: " + rule.getDescription()
								+ "\n Error issued at Rule: "
								+ rule.getRulesPK().getId(),
						"Rule based ERROR!", JOptionPane.ERROR_MESSAGE);
			}

		}

		return bomRecords;
	}

	public void doUnitParts(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		if (rule.getPosition() == 1 || rule.getPosition() == 5
				|| rule.getPosition() == 7) {
			bomRecords = topUnitParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);
		}

		if (rule.getPosition() == 2 || rule.getPosition() == 5
				|| rule.getPosition() == 7) {
			bomRecords = botUnitParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);
		}

		if (rule.getPosition() == 3 || rule.getPosition() == 6
				|| rule.getPosition() == 7) {
			bomRecords = leftUnitParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);
		}

		if (rule.getPosition() == 4 || rule.getPosition() == 6
				|| rule.getPosition() == 7) {
			bomRecords = rightUnitParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);
		}
		if (rule.getPosition() == 11) {
			bomRecords = areaParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
					bomRecords);
		} else if (rule.getPosition() >= 8 && rule.getPosition() <= 10) {

			bomRecords = mullionCouplerUnits(rule, adjw, adjwi, adjh, adjhi,
					qty, part, bomRecords);
		} else if (rule.getPosition() >= 12) {
			bomRecords = otherParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
					bomRecords);
		}

		if (part.getParttype() >= 500) {

			this.cleanInfoMessage(rule.getRulesPK().getId());
			this.cleanShapeNotes(rule.getRulesPK().getId());

			Object[] boms = bomRecords.toArray();

			for (Object bom : boms) {

				// Init Bill Of Material
				BillOfMat billOfMat = (BillOfMat) bom;

				InfoMessage infoM = new InfoMessage();
				infoM.ruleid = ((BillOfMat) bom).ruleno;

				// **************************************************************
				// Init Shape Notes
				// **************************************************************
				ShapeNotes shapeNotes = new ShapeNotes();
				shapeNotes.setNotesValues(billOfMat);

				boolean isReportQty = false;
				if (((BillOfMat) bom).remote) {
					isReportQty = ItemFrame
							.getApplicationRemoteBaseRules()
							.getAttribute(((BillOfMat) bom).supplierRemoteId,
									part.getAttributeID()).isReportqty();
				} else {
					isReportQty = ItemFrame.getApplicationBase()
							.getAttribute(part.getAttributeID()).isReportqty();
				}

				if (isReportQty) {

					infoM.stockcode = ((BillOfMat) bom).stockcode;
					infoM.description = ((BillOfMat) bom).description;
					infoM.value = ((BillOfMat) bom).qty + "";
					infoM.showQty = true;

					if (myShape != null) {
						boolean equals = false;
						for (ShapeNotes notes : myShape.notes) {
							if (notes.equals(shapeNotes)) {
								equals = true;
							}
						}

						if (!equals) {
							myShape.notes.add(shapeNotes);
						}
					} else if (this.myMullionCoupler != null) {
						boolean equals = false;
						for (ShapeNotes notes : myMullionCoupler.notes) {
							if (notes.equals(shapeNotes)) {
								equals = true;
							}
						}

						if (!equals) {
							myMullionCoupler.notes.add(shapeNotes);
						}
					}

					myFrame2.infoMessages.add(infoM);

				} else {

					infoM.stockcode = ((BillOfMat) bom).stockcode;
					infoM.description = ((BillOfMat) bom).description;
					infoM.value = ((BillOfMat) bom).qty + "";
					infoM.showQty = false;
					myFrame2.infoMessages.add(infoM);

					if (myShape != null) {
						boolean equals = false;
						for (ShapeNotes notes : myShape.notes) {
							if (notes.equals(shapeNotes)) {
								equals = true;
							}
						}

						if (!equals) {
							myShape.notes.add(shapeNotes);
						}

					} else if (this.myMullionCoupler != null) {
						boolean equals = false;
						for (ShapeNotes notes : myMullionCoupler.notes) {
							if (notes.equals(shapeNotes)) {
								equals = true;
							}
						}

						if (!equals) {
							myMullionCoupler.notes.add(shapeNotes);
						}
					}

				}
			}
		}
	}

	public void doProfileParts(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		if (rule.getPosition() == 1) {
			bomRecords = topProfileParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);
		} else if (rule.getPosition() == 2) {
			bomRecords = botProfileParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);
		}
		if (rule.getPosition() == 3) {
			bomRecords = leftProfileParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);
		}
		if (rule.getPosition() == 4) {
			bomRecords = rightProfileParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);
		} else if (rule.getPosition() == 5) {
			bomRecords = topProfileParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

			bomRecords = botProfileParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);
		} else if (rule.getPosition() == 6) {
			bomRecords = leftProfileParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

			bomRecords = rightProfileParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

		} else if (rule.getPosition() == 7) {
			bomRecords = topProfileParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

			bomRecords = botProfileParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

			bomRecords = leftProfileParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

			bomRecords = rightProfileParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

		} else if (rule.getPosition() == 8 || rule.getPosition() == 9
				|| rule.getPosition() == 10) {
			bomRecords = mullionCouplerProfiles(rule, adjw, adjwi, adjh, adjhi,
					qty, part, bomRecords);
		}

	}

	public void doRollParts(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		if (rule.getPosition() == 1 || rule.getPosition() == 5
				|| rule.getPosition() == 7) {
			bomRecords = topProfileParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);
		}

		if (rule.getPosition() == 2 || rule.getPosition() == 5
				|| rule.getPosition() == 7) {
			bomRecords = botProfileParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);
		}

		if (rule.getPosition() == 3 || rule.getPosition() == 6
				|| rule.getPosition() == 7) {
			bomRecords = topProfileParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);
		}

		if (rule.getPosition() == 4 || rule.getPosition() == 6
				|| rule.getPosition() == 7) {
			bomRecords = rightProfileParts(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);
		}

		if (rule.getPosition() == 12) {
			bomRecords = this.doUIBomFromParts(rule, adjw, adjwi, adjh, adjhi,
					qty, part, bomRecords, rule.getPosition());
		}

		if (rule.getPosition() == 13) {
			bomRecords = this.doPerimeterBomFromParts(rule, adjw, adjwi, adjh,
					adjhi, qty, part, bomRecords, rule.getPosition());

		}
	}

	public void doAreaParts(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		// if (rule.getPosition() == 11 || rule.getPosition() == 26)
		// {
		bomRecords = areaParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
				bomRecords);
		// }

	}

	public void doVolumeParts(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		if (rule.getPosition() == 11) {
			bomRecords = volumeParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
					bomRecords);
		}

	}

	public Collection topUnitParts(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		if (rule.getRcondition() == 1) { // None

			bomRecords = doTop123Unit(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

		} else if (rule.getRcondition() == 2 && myShape.topIn) { // Inside

			bomRecords = doTop123Unit(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

		} else if (rule.getRcondition() == 3 && !myShape.topIn) { // OutSide

			bomRecords = doTop123Unit(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

		}

		return bomRecords;
	}

	public Collection mullionCouplerProfiles(Rules rule, int adjw, int adjwi,
			int adjh, int adjhi, double qty, Parts part, Collection bomRecords) {

		if (myMullionCoupler != null) {
			if (rule.getPosition() == 8) {
				if (rule.getRcondition() == 1
						&& myMullionCoupler.posCondition == 1
						&& myMullionCoupler.orientation == 1) { // |-- --|

					bomRecords = doVHProfile(rule, adjw, adjwi, adjh, adjhi,
							qty, part, bomRecords);

				} else if (rule.getRcondition() == 2
						&& myMullionCoupler.posCondition == 2
						&& myMullionCoupler.orientation == 1) { // |-- *

					bomRecords = doVHProfile(rule, adjw, adjwi, adjh, adjhi,
							qty, part, bomRecords);

				} else if (rule.getRcondition() == 3
						&& myMullionCoupler.posCondition == 3
						&& myMullionCoupler.orientation == 1) { // * --|

					bomRecords = doVHProfile(rule, adjw, adjwi, adjh, adjhi,
							qty, part, bomRecords);

				} else if (rule.getRcondition() == 3
						&& myMullionCoupler.posCondition == 4
						&& myMullionCoupler.orientation == 1) { // *-- --*

					bomRecords = doVHProfile(rule, adjw, adjwi, adjh, adjhi,
							qty, part, bomRecords);

				} else if (rule.getRcondition() == 1
						&& myMullionCoupler.orientation == 1) { // *-- --*

					bomRecords = doVHProfile(rule, adjw, adjwi, adjh, adjhi,
							qty, part, bomRecords);

				}
			} else if (rule.getPosition() == 9) {
				if (rule.getRcondition() == 1
						&& myMullionCoupler.posCondition == 1
						&& myMullionCoupler.orientation == 2) { // |-- --|

					bomRecords = doVHProfile(rule, adjw, adjwi, adjh, adjhi,
							qty, part, bomRecords);

				} else if (rule.getRcondition() == 2
						&& myMullionCoupler.posCondition == 2
						&& myMullionCoupler.orientation == 2) { // |-- *

					bomRecords = doVHProfile(rule, adjw, adjwi, adjh, adjhi,
							qty, part, bomRecords);

				} else if (rule.getRcondition() == 3
						&& myMullionCoupler.posCondition == 3
						&& myMullionCoupler.orientation == 2) { // * --|

					bomRecords = doVHProfile(rule, adjw, adjwi, adjh, adjhi,
							qty, part, bomRecords);

				} else if (rule.getRcondition() == 3
						&& myMullionCoupler.posCondition == 4
						&& myMullionCoupler.orientation == 2) { // *-- --*

					bomRecords = doVHProfile(rule, adjw, adjwi, adjh, adjhi,
							qty, part, bomRecords);

				} else if (rule.getRcondition() == 1
						&& myMullionCoupler.orientation == 2) { // *-- --*

					bomRecords = doVHProfile(rule, adjw, adjwi, adjh, adjhi,
							qty, part, bomRecords);

				}
			} else if (rule.getPosition() == 10) {
				if (rule.getRcondition() == 1
						&& myMullionCoupler.posCondition == 1) { // |-- --|

					bomRecords = doVHProfile(rule, adjw, adjwi, adjh, adjhi,
							qty, part, bomRecords);

				} else if (rule.getRcondition() == 2
						&& myMullionCoupler.posCondition == 2) { // |-- *

					bomRecords = doVHProfile(rule, adjw, adjwi, adjh, adjhi,
							qty, part, bomRecords);

				} else if (rule.getRcondition() == 3
						&& myMullionCoupler.posCondition == 3) { // * --|

					bomRecords = doVHProfile(rule, adjw, adjwi, adjh, adjhi,
							qty, part, bomRecords);

				} else if (rule.getRcondition() == 3
						&& myMullionCoupler.posCondition == 4) { // *-- --*

					bomRecords = doVHProfile(rule, adjw, adjwi, adjh, adjhi,
							qty, part, bomRecords);

				} else if (rule.getRcondition() == 1) { // *-- --*

					bomRecords = doVHProfile(rule, adjw, adjwi, adjh, adjhi,
							qty, part, bomRecords);

				}
			}
		} else {

			// JOptionPane.showMessageDialog(this.myFrame2,
			// "Error at Rule No. : "
			// + rule.getRulesPK().getId() + "\n  Series: "
			// + rule.getRulesPK().getSeriesId()
			// + "\n  Possible Incorrect Level on Rule!", "Rule Error!",
			// JOptionPane.ERROR_MESSAGE);

		}

		return bomRecords;
	}

	public Collection mullionCouplerUnits(Rules rule, int adjw, int adjwi,
			int adjh, int adjhi, double qty, Parts part, Collection bomRecords) {

		if (myMullionCoupler == null) {

			// JOptionPane.showMessageDialog(this.myFrame2,
			// "Error at Rule No. : "
			// + rule.getRulesPK().getId() + "\n  Series: "
			// + rule.getRulesPK().getSeriesId()
			// + "\n  Possible Incorrect Level on Rule!", "Rule Error!",
			// JOptionPane.ERROR_MESSAGE);

		} else {
			if (rule.getPosition() == 8 && myMullionCoupler.orientation == 1) { // None

				bomRecords = doCouplerConditiion(rule, adjw, adjwi, adjh,
						adjhi, qty, part, bomRecords);

			} else if (rule.getPosition() == 9
					&& myMullionCoupler.orientation == 2) { // None
				bomRecords = doCouplerConditiion(rule, adjw, adjwi, adjh,
						adjhi, qty, part, bomRecords);

			} else if (rule.getPosition() == 10) { // None
				bomRecords = doCouplerConditiion(rule, adjw, adjwi, adjh,
						adjhi, qty, part, bomRecords);

			}
		}

		return bomRecords;
	}

	public Collection doCouplerConditiion(Rules rule, int adjw, int adjwi,
			int adjh, int adjhi, double qty, Parts part, Collection bomRecords) {

		if (myMullionCoupler == null) {

			// JOptionPane.showMessageDialog(this.myFrame2,
			// "Error at Rule No. : "
			// + rule.getRulesPK().getId() + "\n  Series: "
			// + rule.getRulesPK().getSeriesId()
			// + "\n  Possible Incorrect Level on Rule!", "Rule Error!",
			// JOptionPane.ERROR_MESSAGE);

		} else {

			if (rule.getRcondition() == 6 && myMullionCoupler.posCondition == 1) { // |--

				// --|

				bomRecords = doVHUnit(rule, adjw, adjwi, adjh, adjhi, qty,
						part, bomRecords);

			} else if (rule.getRcondition() == 7
					&& myMullionCoupler.posCondition == 2) { // |-- *

				bomRecords = doVHUnit(rule, adjw, adjwi, adjh, adjhi, qty,
						part, bomRecords);

			} else if (rule.getRcondition() == 8
					&& myMullionCoupler.posCondition == 3) { // * --|

				bomRecords = doVHUnit(rule, adjw, adjwi, adjh, adjhi, qty,
						part, bomRecords);

			} else if (rule.getRcondition() == 9
					&& myMullionCoupler.posCondition == 4) { // *-- --*

				bomRecords = doVHUnit(rule, adjw, adjwi, adjh, adjhi, qty,
						part, bomRecords);

			} else if (rule.getRcondition() == 1) { // *-- --*
				bomRecords = doVHUnit(rule, adjw, adjwi, adjh, adjhi, qty,
						part, bomRecords);
			}
		}
		return bomRecords;
	}

	public Collection topProfileParts(Rules rule, int adjw, int adjwi,
			int adjh, int adjhi, double qty, Parts part, Collection bomRecords) {

		if (myShape == null) {

			JOptionPane.showMessageDialog(this.myFrame2, "Error at Rule No. : "
					+ rule.getRulesPK().getId() + "\n  Series: "
					+ rule.getRulesPK().getSeriesId()
					+ "\n  Possible Incorrect Level on Rule!", "Rule Error!",
					JOptionPane.ERROR_MESSAGE);

		} else {
			if (rule.getRcondition() == 1) { // None

				bomRecords = doTop123Profile(rule, adjw, adjwi, adjh, adjhi,
						qty, part, bomRecords);

			} else if (rule.getRcondition() == 2 && myShape.topIn) { // Inside

				bomRecords = doTop123Profile(rule, adjw, adjwi, adjh, adjhi,
						qty, part, bomRecords);

			} else if (rule.getRcondition() == 3 && !myShape.topIn) { // OutSide

				bomRecords = doTop123Profile(rule, adjw, adjwi, adjh, adjhi,
						qty, part, bomRecords);

			}
		}
		return bomRecords;
	}

	public Collection botUnitParts(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		if (rule.getRcondition() == 1) { // None

			bomRecords = doBot123Unit(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

		} else if (rule.getRcondition() == 2 && myShape.botIn) { // Inside

			bomRecords = doBot123Unit(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

		} else if (rule.getRcondition() == 3 && !myShape.botIn) { // OutSide

			bomRecords = doBot123Unit(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

		}

		return bomRecords;
	}

	public Collection botProfileParts(Rules rule, int adjw, int adjwi,
			int adjh, int adjhi, double qty, Parts part, Collection bomRecords) {

		if (rule.getRcondition() == 1) { // None

			bomRecords = doBot123Profile(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

		} else if (rule.getRcondition() == 2 && myShape.botIn) { // Inside

			bomRecords = doBot123Profile(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

		} else if (rule.getRcondition() == 3 && !myShape.botIn) { // OutSide

			bomRecords = doBot123Profile(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

		}

		return bomRecords;
	}

	public Collection leftUnitParts(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		if (rule.getRcondition() == 1) { // None

			bomRecords = doLeftUnit(rule, adjw, adjwi, adjh, adjhi, qty, part,
					bomRecords);

		} else if (rule.getRcondition() == 2 && myShape.leftIn) { // Inside

			bomRecords = doLeftUnit(rule, adjw, adjwi, adjh, adjhi, qty, part,
					bomRecords);

		} else if (rule.getRcondition() == 3 && !myShape.leftIn) { // OutSide

			bomRecords = doLeftUnit(rule, adjw, adjwi, adjh, adjhi, qty, part,
					bomRecords);

		}

		return bomRecords;
	}

	public Collection leftProfileParts(Rules rule, int adjw, int adjwi,
			int adjh, int adjhi, double qty, Parts part, Collection bomRecords) {

		if (rule.getRcondition() == 1) { // None

			bomRecords = doLeftProfile(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

		} else if (rule.getRcondition() == 2 && myShape.leftIn) { // Inside

			bomRecords = doLeftProfile(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

		} else if (rule.getRcondition() == 3 && !myShape.leftIn) { // OutSide

			bomRecords = doLeftProfile(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

		}

		return bomRecords;
	}

	public Collection rightUnitParts(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		if (rule.getRcondition() == 1) { // None

			bomRecords = doRightUnit(rule, adjw, adjwi, adjh, adjhi, qty, part,
					bomRecords);

		} else if (rule.getRcondition() == 2 && myShape.rightIn) { // Inside

			bomRecords = doRightUnit(rule, adjw, adjwi, adjh, adjhi, qty, part,
					bomRecords);

		} else if (rule.getRcondition() == 3 && !myShape.rightIn) { // OutSide

			bomRecords = doRightUnit(rule, adjw, adjwi, adjh, adjhi, qty, part,
					bomRecords);

		}

		return bomRecords;
	}

	public Collection rightProfileParts(Rules rule, int adjw, int adjwi,
			int adjh, int adjhi, double qty, Parts part, Collection bomRecords) {

		if (rule.getRcondition() == 1) { // None

			bomRecords = doRightProfile(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

		} else if (rule.getRcondition() == 2 && myShape.rightIn) { // Inside

			bomRecords = doRightProfile(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

		} else if (rule.getRcondition() == 3 && !myShape.rightIn) { // OutSide

			bomRecords = doRightProfile(rule, adjw, adjwi, adjh, adjhi, qty,
					part, bomRecords);

		}

		return bomRecords;
	}

	public Collection doTop123Unit(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts myPart, Collection bomRecords) {

		BillOfMat bom = new BillOfMat(this);
		bom = bom.setBomCommonElements(myShape.top1Part, myPart, myShape, null,
				null, false, rule, qty, adjw, adjwi, adjh, adjhi,
				this.parentRuleID);
		bom.position = 1;
		calcCostPrice(qty, myPart, bom);

		bomRecords.add(bom);

		if (myShape.noSidesTop >= 2) {
			bom = new BillOfMat(this);
			bom = bom.setBomCommonElements(myShape.top2Part, myPart, myShape,
					null, null, false, rule, qty, adjw, adjwi, adjh, adjhi,
					this.parentRuleID);
			bom.position = 2;

			calcCostPrice(qty, myPart, bom);

			bomRecords.add(bom);

			if (myShape.noSidesTop == 3) {
				bom = new BillOfMat(this);
				bom = bom.setBomCommonElements(myShape.top3Part, myPart,
						myShape, null, null, false, rule, qty, adjw, adjwi,
						adjh, adjhi, this.parentRuleID);

				calcCostPrice(qty, myPart, bom);
				bom.position = 3;
				bomRecords.add(bom);
			}
		}

		return bomRecords;
	}

	public Collection doTop123Profile(Rules rule, int adjw, int adjwi,
			int adjh, int adjhi, double qty, Parts myPart, Collection bomRecords) {

		BillOfMat bom = new BillOfMat(this);

		if (rule.getAffectsdesign()) {

			if (!myShape.top1Part.partIDByUser) {

				myShape.top1Part.partDimA = UOMConvert.getBigDecimalConversion(
						myPart.getDima(), myFrame2.metricscale, 1);
				myShape.top1Part.partDimAi = UOMConvert
						.getBigDecimalConversion(myPart.getDimai(),
								myFrame2.imperialscale, 1);
				myShape.top1Part.partDimB = UOMConvert.getBigDecimalConversion(
						myPart.getDimb(), myFrame2.metricscale, 1);
				myShape.top1Part.partDimBi = UOMConvert
						.getBigDecimalConversion(myPart.getDimbi(),
								myFrame2.imperialscale, 1);
				myShape.top1Part.partDimC = UOMConvert.getBigDecimalConversion(
						myPart.getDimc(), myFrame2.metricscale, 1);
				myShape.top1Part.partDimCi = UOMConvert
						.getBigDecimalConversion(myPart.getDimci(),
								myFrame2.imperialscale, 1);
				myShape.top1Part.partDimD = UOMConvert.getBigDecimalConversion(
						myPart.getDimd(), myFrame2.metricscale, 1);
				myShape.top1Part.partDimDi = UOMConvert
						.getBigDecimalConversion(myPart.getDimdi(),
								myFrame2.imperialscale, 1);
				myShape.top1Part.partDimM = UOMConvert.getBigDecimalConversion(
						myPart.getDimm(), myFrame2.metricscale, 1);
				myShape.top1Part.partDimMi = UOMConvert
						.getBigDecimalConversion(myPart.getDimm_imp(),
								myFrame2.imperialscale, 1);
			}

			if (!myShape.top1Part.endTypeLTByUser) {
				myShape.top1Part.endTypeLT = rule.getLeftside();
			}

			if (!myShape.top1Part.endTypeRBByUser) {
				myShape.top1Part.endTypeRB = rule.getRightside();
			}

			doProfileBomFromParts(rule, adjw, adjwi, adjh, adjhi, qty, myPart,
					bomRecords, bom, 1, myShape.top1Part, true,
					rule.getLeftside(), rule.getRightside());

		} else {
			doProfileBomFromParts(rule, adjw, adjwi, adjh, adjhi, qty, myPart,
					bomRecords, bom, 1, myShape.top1Part, false,
					rule.getLeftside(), rule.getRightside());
		}

		if (myShape.noSidesTop >= 2) {

			if (rule.getAffectsdesign()) {

				if (!myShape.top2Part.partIDByUser) {

					myShape.top2Part.partDimA = UOMConvert
							.getBigDecimalConversion(myPart.getDima(),
									myFrame2.metricscale, 1);
					myShape.top2Part.partDimAi = UOMConvert
							.getBigDecimalConversion(myPart.getDimai(),
									myFrame2.imperialscale, 1);
					myShape.top2Part.partDimB = UOMConvert
							.getBigDecimalConversion(myPart.getDimb(),
									myFrame2.metricscale, 1);
					myShape.top2Part.partDimBi = UOMConvert
							.getBigDecimalConversion(myPart.getDimbi(),
									myFrame2.imperialscale, 1);
					myShape.top2Part.partDimC = UOMConvert
							.getBigDecimalConversion(myPart.getDimc(),
									myFrame2.metricscale, 1);
					myShape.top2Part.partDimCi = UOMConvert
							.getBigDecimalConversion(myPart.getDimci(),
									myFrame2.imperialscale, 1);
					myShape.top2Part.partDimD = UOMConvert
							.getBigDecimalConversion(myPart.getDimd(),
									myFrame2.metricscale, 1);
					myShape.top2Part.partDimDi = UOMConvert
							.getBigDecimalConversion(myPart.getDimdi(),
									myFrame2.imperialscale, 1);
					myShape.top2Part.partDimM = UOMConvert
							.getBigDecimalConversion(myPart.getDimm(),
									myFrame2.metricscale, 1);
					myShape.top2Part.partDimMi = UOMConvert
							.getBigDecimalConversion(myPart.getDimm_imp(),
									myFrame2.imperialscale, 1);

					myShape.top2Part.supplierId = myPart.getSupplierId();
					myShape.top2Part.remote = myPart.isRemote();

				}
				if (!myShape.top2Part.endTypeLTByUser) {
					myShape.top2Part.endTypeLT = rule.getLeftside();
				}
				if (!myShape.top2Part.endTypeRBByUser) {
					myShape.top2Part.endTypeRB = rule.getRightside();
				}

				doProfileBomFromParts(rule, adjw, adjwi, adjh, adjhi, qty,
						myPart, bomRecords, bom, 2, myShape.top2Part, true,
						rule.getLeftside(), rule.getRightside());
			} else {

				doProfileBomFromParts(rule, adjw, adjwi, adjh, adjhi, qty,
						myPart, bomRecords, bom, 2, myShape.top2Part, false,
						rule.getLeftside(), rule.getRightside());
			}

			if (myShape.noSidesTop == 3) {
				if (rule.getAffectsdesign()) {
					if (!myShape.top3Part.partIDByUser) {
						myShape.top3Part.partDimA = UOMConvert
								.getBigDecimalConversion(myPart.getDima(),
										myFrame2.metricscale, 1);
						myShape.top3Part.partDimAi = UOMConvert
								.getBigDecimalConversion(myPart.getDimai(),
										myFrame2.imperialscale, 1);
						myShape.top3Part.partDimB = UOMConvert
								.getBigDecimalConversion(myPart.getDimb(),
										myFrame2.metricscale, 1);
						myShape.top3Part.partDimBi = UOMConvert
								.getBigDecimalConversion(myPart.getDimbi(),
										myFrame2.imperialscale, 1);
						myShape.top3Part.partDimC = UOMConvert
								.getBigDecimalConversion(myPart.getDimc(),
										myFrame2.metricscale, 1);
						myShape.top3Part.partDimCi = UOMConvert
								.getBigDecimalConversion(myPart.getDimci(),
										myFrame2.imperialscale, 1);
						myShape.top3Part.partDimD = UOMConvert
								.getBigDecimalConversion(myPart.getDimd(),
										myFrame2.metricscale, 1);
						myShape.top3Part.partDimDi = UOMConvert
								.getBigDecimalConversion(myPart.getDimdi(),
										myFrame2.imperialscale, 1);
						myShape.top3Part.partDimM = UOMConvert
								.getBigDecimalConversion(myPart.getDimm(),
										myFrame2.metricscale, 1);
						myShape.top3Part.partDimMi = UOMConvert
								.getBigDecimalConversion(myPart.getDimm_imp(),
										myFrame2.imperialscale, 1);

						myShape.top3Part.supplierId = myPart.getSupplierId();
						myShape.top3Part.remote = myPart.isRemote();
					}

					if (!myShape.top3Part.partIDByUser) {
						myShape.top3Part.endTypeLT = rule.getLeftside();
					}

					if (!myShape.top3Part.partIDByUser) {
						myShape.top3Part.endTypeRB = rule.getRightside();
					}

					doProfileBomFromParts(rule, adjw, adjwi, adjh, adjhi, qty,
							myPart, bomRecords, bom, 3, myShape.top3Part, true,
							rule.getLeftside(), rule.getRightside());
				} else {
					doProfileBomFromParts(rule, adjw, adjwi, adjh, adjhi, qty,
							myPart, bomRecords, bom, 3, myShape.top3Part,
							false, rule.getLeftside(), rule.getRightside());
				}

			}
		}

		return bomRecords;
	}

	public Collection doBot123Unit(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts myPart, Collection bomRecords) {

		BillOfMat bom = new BillOfMat(this);
		bom = bom.setBomCommonElements(myShape.bot1Part, myPart, myShape, null,
				null, false, rule, qty, adjw, adjwi, adjh, adjhi, parentRuleID);

		calcCostPrice(qty, myPart, bom);
		bom.position = 5;
		bomRecords.add(bom);

		if (myShape.noSidesBot >= 2) {
			bom = new BillOfMat(this);
			bom = bom.setBomCommonElements(myShape.bot2Part, myPart, myShape,
					null, null, false, rule, qty, adjw, adjwi, adjh, adjhi,
					parentRuleID);

			calcCostPrice(qty, myPart, bom);
			bom.position = 7;
			bomRecords.add(bom);

			if (myShape.noSidesBot == 3) {
				bom = new BillOfMat(this);
				bom = bom.setBomCommonElements(myShape.bot3Part, myPart,
						myShape, null, null, false, rule, qty, adjw, adjwi,
						adjh, adjhi, parentRuleID);

				calcCostPrice(qty, myPart, bom);
				bom.position = 6;
				bomRecords.add(bom);
			}
		}

		return bomRecords;
	}

	public Collection doBot123Profile(Rules rule, int adjw, int adjwi,
			int adjh, int adjhi, double qty, Parts part, Collection bomRecords) {

		BillOfMat bom = new BillOfMat(this);
		if (rule.getAffectsdesign()) {
			if (!myShape.bot1Part.partIDByUser) {

				myShape.bot1Part.partDimA = UOMConvert.getBigDecimalConversion(
						part.getDima(), myFrame2.metricscale, 1);
				myShape.bot1Part.partDimAi = UOMConvert
						.getBigDecimalConversion(part.getDimai(),
								myFrame2.imperialscale, 1);
				myShape.bot1Part.partDimB = UOMConvert.getBigDecimalConversion(
						part.getDimb(), myFrame2.metricscale, 1);
				myShape.bot1Part.partDimBi = UOMConvert
						.getBigDecimalConversion(part.getDimbi(),
								myFrame2.imperialscale, 1);
				myShape.bot1Part.partDimC = UOMConvert.getBigDecimalConversion(
						part.getDimc(), myFrame2.metricscale, 1);
				myShape.bot1Part.partDimCi = UOMConvert
						.getBigDecimalConversion(part.getDimci(),
								myFrame2.imperialscale, 1);
				myShape.bot1Part.partDimD = UOMConvert.getBigDecimalConversion(
						part.getDimd(), myFrame2.metricscale, 1);
				myShape.bot1Part.partDimDi = UOMConvert
						.getBigDecimalConversion(part.getDimdi(),
								myFrame2.imperialscale, 1);
				myShape.bot1Part.partDimM = UOMConvert.getBigDecimalConversion(
						part.getDimm(), myFrame2.metricscale, 1);
				myShape.bot1Part.partDimMi = UOMConvert
						.getBigDecimalConversion(part.getDimm_imp(),
								myFrame2.imperialscale, 1);
			}

			if (!myShape.bot1Part.endTypeLTByUser) {
				myShape.bot1Part.endTypeLT = rule.getLeftside();
			}

			if (!myShape.bot1Part.endTypeRBByUser) {
				myShape.bot1Part.endTypeRB = rule.getRightside();
			}
			doProfileBomFromParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
					bomRecords, bom, 5, myShape.bot1Part, true,
					rule.getLeftside(), rule.getRightside());
		} else {

			doProfileBomFromParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
					bomRecords, bom, 5, myShape.bot1Part, false,
					rule.getLeftside(), rule.getRightside());
		}

		if (myShape.noSidesBot >= 2) {
			if (rule.getAffectsdesign()) {
				if (!myShape.bot2Part.partIDByUser) {
					myShape.bot2Part.partDimA = UOMConvert
							.getBigDecimalConversion(part.getDima(),
									myFrame2.metricscale, 1);
					myShape.bot2Part.partDimAi = UOMConvert
							.getBigDecimalConversion(part.getDimai(),
									myFrame2.imperialscale, 1);
					myShape.bot2Part.partDimB = UOMConvert
							.getBigDecimalConversion(part.getDimb(),
									myFrame2.metricscale, 1);
					myShape.bot2Part.partDimBi = UOMConvert
							.getBigDecimalConversion(part.getDimbi(),
									myFrame2.imperialscale, 1);
					myShape.bot2Part.partDimC = UOMConvert
							.getBigDecimalConversion(part.getDimc(),
									myFrame2.metricscale, 1);
					myShape.bot2Part.partDimCi = UOMConvert
							.getBigDecimalConversion(part.getDimci(),
									myFrame2.imperialscale, 1);
					myShape.bot2Part.partDimD = UOMConvert
							.getBigDecimalConversion(part.getDimd(),
									myFrame2.metricscale, 1);
					myShape.bot2Part.partDimDi = UOMConvert
							.getBigDecimalConversion(part.getDimdi(),
									myFrame2.imperialscale, 1);
					myShape.bot2Part.partDimM = UOMConvert
							.getBigDecimalConversion(part.getDimm(),
									myFrame2.metricscale, 1);
					myShape.bot2Part.partDimMi = UOMConvert
							.getBigDecimalConversion(part.getDimm_imp(),
									myFrame2.imperialscale, 1);
				}

				if (!myShape.bot2Part.endTypeLTByUser) {
					myShape.bot2Part.endTypeLT = rule.getLeftside();
				}

				if (!myShape.bot2Part.endTypeRBByUser) {
					myShape.bot2Part.endTypeRB = rule.getRightside();
				}
				doProfileBomFromParts(rule, adjw, adjwi, adjh, adjhi, qty,
						part, bomRecords, bom, 7, myShape.bot2Part, true,
						rule.getLeftside(), rule.getRightside());
			} else {

				doProfileBomFromParts(rule, adjw, adjwi, adjh, adjhi, qty,
						part, bomRecords, bom, 7, myShape.bot2Part, false,
						rule.getLeftside(), rule.getRightside());
			}

			if (myShape.noSidesBot == 3) {
				if (rule.getAffectsdesign()) {

					if (!myShape.bot3Part.partIDByUser) {
						myShape.bot3Part.partDimA = UOMConvert
								.getBigDecimalConversion(part.getDima(),
										myFrame2.metricscale, 1);
						myShape.bot3Part.partDimAi = UOMConvert
								.getBigDecimalConversion(part.getDimai(),
										myFrame2.imperialscale, 1);
						myShape.bot3Part.partDimB = UOMConvert
								.getBigDecimalConversion(part.getDimb(),
										myFrame2.metricscale, 1);
						myShape.bot3Part.partDimBi = UOMConvert
								.getBigDecimalConversion(part.getDimbi(),
										myFrame2.imperialscale, 1);
						myShape.bot3Part.partDimC = UOMConvert
								.getBigDecimalConversion(part.getDimc(),
										myFrame2.metricscale, 1);
						myShape.bot3Part.partDimCi = UOMConvert
								.getBigDecimalConversion(part.getDimci(),
										myFrame2.imperialscale, 1);
						myShape.bot3Part.partDimD = UOMConvert
								.getBigDecimalConversion(part.getDimd(),
										myFrame2.metricscale, 1);
						myShape.bot3Part.partDimDi = UOMConvert
								.getBigDecimalConversion(part.getDimdi(),
										myFrame2.imperialscale, 1);
						myShape.bot3Part.partDimM = UOMConvert
								.getBigDecimalConversion(part.getDimm(),
										myFrame2.metricscale, 1);
						myShape.bot3Part.partDimMi = UOMConvert
								.getBigDecimalConversion(part.getDimm_imp(),
										myFrame2.imperialscale, 1);

					}
					if (!myShape.bot3Part.endTypeLTByUser) {
						myShape.bot3Part.endTypeLT = rule.getLeftside();
					}

					if (!myShape.bot3Part.endTypeLTByUser) {
						myShape.bot3Part.endTypeRB = rule.getRightside();
					}
					doProfileBomFromParts(rule, adjw, adjwi, adjh, adjhi, qty,
							part, bomRecords, bom, 6, myShape.bot3Part, true,
							rule.getLeftside(), rule.getRightside());
				} else {

					doProfileBomFromParts(rule, adjw, adjwi, adjh, adjhi, qty,
							part, bomRecords, bom, 6, myShape.bot3Part, false,
							rule.getLeftside(), rule.getRightside());
				}

			}
		}

		return bomRecords;
	}

	public Collection doLeftUnit(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		BillOfMat bom = new BillOfMat(this);
		// if (part.getParttype() == 2 || part.getParttype() == 15)
		// {
		bom.position = 8;
		bom = bom.setBomCommonElements(myShape.leftPart, part, myShape, null,
				null, false, rule, qty, adjw, adjwi, adjh, adjhi, parentRuleID);

		calcCostPrice(qty, part, bom);

		bomRecords.add(bom);

		// }

		return bomRecords;
	}

	public Collection doLeftProfile(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		BillOfMat bom = new BillOfMat(this);
		// if (part.getParttype() == 2 || part.getParttype() == 15 ||
		// part.getParttype() == 502) {
		bom.position = 8;
		if (rule.getAffectsdesign()) {
			if (!myShape.leftPart.partIDByUser) {

				myShape.leftPart.partDimA = UOMConvert.getBigDecimalConversion(
						part.getDima(), myFrame2.metricscale, 1);
				myShape.leftPart.partDimAi = UOMConvert
						.getBigDecimalConversion(part.getDimai(),
								myFrame2.imperialscale, 1);
				myShape.leftPart.partDimB = UOMConvert.getBigDecimalConversion(
						part.getDimb(), myFrame2.metricscale, 1);
				myShape.leftPart.partDimBi = UOMConvert
						.getBigDecimalConversion(part.getDimbi(),
								myFrame2.imperialscale, 1);
				myShape.leftPart.partDimC = UOMConvert.getBigDecimalConversion(
						part.getDimc(), myFrame2.metricscale, 1);
				myShape.leftPart.partDimCi = UOMConvert
						.getBigDecimalConversion(part.getDimci(),
								myFrame2.imperialscale, 1);
				myShape.leftPart.partDimD = UOMConvert.getBigDecimalConversion(
						part.getDimd(), myFrame2.metricscale, 1);
				myShape.leftPart.partDimDi = UOMConvert
						.getBigDecimalConversion(part.getDimdi(),
								myFrame2.imperialscale, 1);
				myShape.leftPart.partDimM = UOMConvert.getBigDecimalConversion(
						part.getDimm(), myFrame2.metricscale, 1);
				myShape.leftPart.partDimMi = UOMConvert
						.getBigDecimalConversion(part.getDimm_imp(),
								myFrame2.imperialscale, 1);
			}

			if (!myShape.leftPart.endTypeLTByUser) {
				myShape.leftPart.endTypeLT = rule.getLeftside();
			}

			if (!myShape.leftPart.endTypeRBByUser) {
				myShape.leftPart.endTypeRB = rule.getRightside();
			}
			doProfileBomFromParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
					bomRecords, bom, 8, myShape.leftPart, true,
					myShape.leftPart.endTypeLT, myShape.leftPart.endTypeRB);
		} else {

			doProfileBomFromParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
					bomRecords, bom, 8, myShape.leftPart, false,
					rule.getLeftside(), rule.getRightside());
		}

		// }

		return bomRecords;
	}

	public Collection doRightUnit(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		BillOfMat bom = new BillOfMat(this);
		// if (part.getParttype() == 2 || part.getParttype() == 15)
		// {
		bom.position = 4;
		bom = bom.setBomCommonElements(myShape.rightPart, part, myShape, null,
				null, false, rule, qty, adjw, adjwi, adjh, adjhi, parentRuleID);
		bom.position = 4;
		calcCostPrice(qty, part, bom);

		bomRecords.add(bom);

		// }

		return bomRecords;
	}

	public Collection doRightProfile(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		BillOfMat bom = new BillOfMat(this);
		// if (part.getParttype() == 2 || part.getParttype() == 15) {

		if (rule.getAffectsdesign()) {
			if (!myShape.rightPart.partIDByUser) {

				myShape.rightPart.partDimA = UOMConvert
						.getBigDecimalConversion(part.getDima(),
								myFrame2.metricscale, 1);
				myShape.rightPart.partDimAi = UOMConvert
						.getBigDecimalConversion(part.getDimai(),
								myFrame2.imperialscale, 1);
				myShape.rightPart.partDimB = UOMConvert
						.getBigDecimalConversion(part.getDimb(),
								myFrame2.metricscale, 1);
				myShape.rightPart.partDimBi = UOMConvert
						.getBigDecimalConversion(part.getDimbi(),
								myFrame2.imperialscale, 1);
				myShape.rightPart.partDimC = UOMConvert
						.getBigDecimalConversion(part.getDimc(),
								myFrame2.metricscale, 1);
				myShape.rightPart.partDimCi = UOMConvert
						.getBigDecimalConversion(part.getDimci(),
								myFrame2.imperialscale, 1);
				myShape.rightPart.partDimD = UOMConvert
						.getBigDecimalConversion(part.getDimd(),
								myFrame2.metricscale, 1);
				myShape.rightPart.partDimDi = UOMConvert
						.getBigDecimalConversion(part.getDimdi(),
								myFrame2.imperialscale, 1);
				myShape.rightPart.partDimM = UOMConvert
						.getBigDecimalConversion(part.getDimm(),
								myFrame2.metricscale, 1);
				myShape.rightPart.partDimMi = UOMConvert
						.getBigDecimalConversion(part.getDimm_imp(),
								myFrame2.imperialscale, 1);

			}
			if (!myShape.rightPart.endTypeLTByUser) {
				myShape.rightPart.endTypeLT = rule.getLeftside();
			}
			if (!myShape.rightPart.endTypeRBByUser) {
				myShape.rightPart.endTypeRB = rule.getRightside();
			}
			doProfileBomFromParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
					bomRecords, bom, 4, myShape.rightPart, true,
					myShape.rightPart.endTypeLT, myShape.rightPart.endTypeRB);
		} else {

			doProfileBomFromParts(rule, adjw, adjwi, adjh, adjhi, qty, part,
					bomRecords, bom, 4, myShape.rightPart, false,
					rule.getLeftside(), rule.getRightside());
		}

		// }

		return bomRecords;
	}

	public void doProfileBomFromParts(Rules rule, int adjw, int adjwi,
			int adjh, int adjhi, double qty, Parts myPart,
			Collection bomRecords, BillOfMat bom, int pos, Profiles myProf,
			boolean doDims, int endLT, int endRB) {

		if (myShape.partObjects.size() == 0) {
			myShape.partObjects.add(myShape.top1Part);
			myShape.partObjects.add(myShape.top2Part);
			myShape.partObjects.add(myShape.top2Part);
			myShape.partObjects.add(myShape.bot1Part);
			myShape.partObjects.add(myShape.bot2Part);
			myShape.partObjects.add(myShape.bot3Part);
			myShape.partObjects.add(myShape.leftPart);
			myShape.partObjects.add(myShape.rightPart);
		}

		Object[] prs = myShape.partObjects.toArray();

		myShape.partObjects.clear();

		for (Object p : prs) {

			if (((Profiles) p).position == pos) {

				((Profiles) p).bom.clear();

				((Profiles) p).supplierId = myProf.supplierId;
				((Profiles) p).remote = myProf.remote;

				if (doDims) {

					((Profiles) p).partDimA = myProf.partDimA;
					((Profiles) p).partDimAi = myProf.partDimAi;
					((Profiles) p).partDimB = myProf.partDimB;
					((Profiles) p).partDimBi = myProf.partDimBi;
					((Profiles) p).partDimC = myProf.partDimC;
					((Profiles) p).partDimCi = myProf.partDimCi;
					((Profiles) p).partDimD = myProf.partDimD;
					((Profiles) p).partDimDi = myProf.partDimDi;
					((Profiles) p).partDimM = myProf.partDimM;
					((Profiles) p).partDimMi = myProf.partDimMi;
				}

				if (!((Profiles) p).endIn) {
					((Profiles) p).endTypeLT = endLT;
				}
				if (!((Profiles) p).rightIn) {
					((Profiles) p).endTypeRB = endRB;
				}

				if (this.myFrame2.jobItem.viewOut) {
					((Profiles) p).rgb_R = this.setRGB_r;
					((Profiles) p).rgb_G = this.setRGB_g;
					((Profiles) p).rgb_B = this.setRGB_b;
					((Profiles) p).rgb_Rout = this.setRGB_r;
					((Profiles) p).rgb_Gout = this.setRGB_g;
					((Profiles) p).rgb_Bout = this.setRGB_b;
					((Profiles) p).rgb_Rt = this.setRGB_r;
					((Profiles) p).rgb_Gt = this.setRGB_g;
					((Profiles) p).rgb_Bt = this.setRGB_b;

				} else {
					((Profiles) p).rgb_R = this.setRGB_rIn;
					((Profiles) p).rgb_G = this.setRGB_gIn;
					((Profiles) p).rgb_B = this.setRGB_bIn;
					((Profiles) p).rgb_Rin = this.setRGB_rIn;
					((Profiles) p).rgb_Gin = this.setRGB_gIn;
					((Profiles) p).rgb_Bin = this.setRGB_bIn;
				}

				bom = new BillOfMat(this);

				bom = bom.setBomCommonElements((Profiles) p, myPart, myShape,
						null, null, false, rule, qty, adjw, adjwi, adjh, adjhi,
						parentRuleID);

				bom.position = pos;

				if (((Profiles) p).posInUse) {
					calcCostPrice(qty, myPart, bom);
				}

				if (this.myShape.a_assemblyLevel == 7) {
					((Profiles) p).bom.add(bom);
				}

				bomRecords.add(bom);
			}

			myShape.partObjects.add(p);
		}
	}

	public Collection doPerimeterBomFromParts(Rules rule, int adjw, int adjwi,
			int adjh, int adjhi, double qty, Parts myPart,
			Collection bomRecords, int pos) {

		double perimeter = myShape.top1Part.length;

		if (myShape.top2Part.posInUse) {
			perimeter = perimeter + myShape.top2Part.length;
		}
		if (myShape.top3Part.posInUse) {
			perimeter = perimeter + myShape.top3Part.length;
		}

		perimeter = perimeter + myShape.bot1Part.length;

		if (myShape.bot2Part.posInUse) {
			perimeter = perimeter + myShape.bot2Part.length;
		}
		if (myShape.bot3Part.posInUse) {
			perimeter = perimeter + myShape.bot3Part.length;
		}
		if (myShape.leftPart.posInUse) {
			perimeter = perimeter + myShape.leftPart.length;
		}
		if (myShape.rightPart.posInUse) {
			perimeter = perimeter + myShape.rightPart.length;
		}

		Profiles pp = new Profiles();

		pp = (Profiles) pp.cloneProfile(myShape.top1Part);

		pp.length = perimeter / myFrame2.scale.doubleValue();
		pp.lengthM = (int) (perimeter / myFrame2.metricscale.doubleValue());
		pp.lengthI = (int) (perimeter / myFrame2.imperialscale.doubleValue());

		BillOfMat bom = new BillOfMat(this);

		bom = bom.setBomCommonElements(pp, myPart, myShape, null, null, false,
				rule, qty, adjw, adjwi, adjh, adjhi, parentRuleID);

		bom.position = pos;

		calcCostPrice(qty, myPart, bom);

		bomRecords.add(bom);

		return bomRecords;

	}

	public Collection doUIBomFromParts(Rules rule, int adjw, int adjwi,
			int adjh, int adjhi, double qty, Parts myPart,
			Collection bomRecords, int pos) {

		double UI = myShape.widthPix + myShape.heightPix;

		Profiles pp = new Profiles();

		pp = (Profiles) pp.cloneProfile(myShape.top1Part);

		pp.length = UI / myFrame2.scale.doubleValue();
		pp.lengthM = (int) (UI / myFrame2.metricscale.doubleValue());
		pp.lengthI = (int) (UI / myFrame2.imperialscale.doubleValue());

		BillOfMat bom = new BillOfMat(this);

		bom = bom.setBomCommonElements(pp, myPart, myShape, null, null, false,
				rule, qty, adjw, adjwi, adjh, adjhi, parentRuleID);

		bom.position = pos;

		calcCostPrice(qty, myPart, bom);

		bomRecords.add(bom);

		return bomRecords;

	}

	public void calculatePerimeter(ShapeObject shape) {
	}

	public Collection doVHProfile(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		BillOfMat bom = new BillOfMat(this);
		if (part.getParttype() == 2 || part.getParttype() == 15) {

			if (rule.getAffectsdesign()) {

				// Setting partID to Mullion Coupler
				myMullionCoupler.partID = part.getId();

				myMullionCoupler.partDimA = UOMConvert.getBigDecimalConversion(
						part.getDima(), myFrame2.metricscale, 1);
				myMullionCoupler.partDimAi = UOMConvert
						.getBigDecimalConversion(part.getDimai(),
								myFrame2.imperialscale, 1);
				myMullionCoupler.partDimB = UOMConvert.getBigDecimalConversion(
						part.getDimb(), myFrame2.metricscale, 1);
				myMullionCoupler.partDimBi = UOMConvert
						.getBigDecimalConversion(part.getDimbi(),
								myFrame2.imperialscale, 1);
				myMullionCoupler.partDimC = UOMConvert.getBigDecimalConversion(
						part.getDimc(), myFrame2.metricscale, 1);
				myMullionCoupler.partDimCi = UOMConvert
						.getBigDecimalConversion(part.getDimci(),
								myFrame2.imperialscale, 1);
				myMullionCoupler.partDimD = UOMConvert.getBigDecimalConversion(
						part.getDimd(), myFrame2.metricscale, 1);
				myMullionCoupler.partDimDi = UOMConvert
						.getBigDecimalConversion(part.getDimdi(),
								myFrame2.imperialscale, 1);
				myMullionCoupler.partDimM = UOMConvert.getBigDecimalConversion(
						part.getDimm(), myFrame2.metricscale, 1);
				myMullionCoupler.partDimMi = UOMConvert
						.getBigDecimalConversion(part.getDimm_imp(),
								myFrame2.imperialscale, 1);

				myMullionCoupler.partDimBtoC = UOMConvert
						.getBigDecimalConversion(part.getDimbtoc(),
								myFrame2.metricscale, 1);
				myMullionCoupler.partDimBtoCi = UOMConvert
						.getBigDecimalConversion(part.getDimbtoc_imp(),
								myFrame2.imperialscale, 1);

				if (myFrame2.mySeries.getSeriesUom() == 1) {
					myMullionCoupler.thickness = myMullionCoupler.partDimB;
				} else {
					myMullionCoupler.thickness = myMullionCoupler.partDimBi;
				}

				myMullionCoupler.endTypeLT = rule.getLeftside();
				myMullionCoupler.endTypeRB = rule.getLeftside();

				bom = bom.setBomCommonElements(myMullionCoupler, part, myShape,
						myMullionCoupler, null, false, rule, qty, adjw, adjwi,
						adjh, adjhi, parentRuleID);

				bom.position = 10 + myMullionCoupler.cOrM;
				bom.orientation = myMullionCoupler.orientation;
			} else {

				bom = bom.setBomCommonElements(myMullionCoupler, part, myShape,
						myMullionCoupler, null, false, rule, qty, adjw, adjwi,
						adjh, adjhi, parentRuleID);
				bom.position = 10 + myMullionCoupler.cOrM;
				bom.orientation = myMullionCoupler.orientation;
			}

			calcCostPrice(qty, part, bom);

			bomRecords.add(bom);

		}

		return bomRecords;
	}

	public Collection doVHUnit(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		BillOfMat bom = new BillOfMat(this);
		// if (part.getPartType() == 2 || part.getPartType() == 15) {

		bom = bom.setBomCommonElements(myMullionCoupler, part, null,
				myMullionCoupler, null, false, rule, qty, adjw, adjwi, adjh,
				adjhi, parentRuleID);

		// bom.position = 10 + myMullionCoupler.cOrM;

		calcCostPrice(qty, part, bom);

		bomRecords.add(bom);

		// }

		return bomRecords;
	}

	public Collection areaParts(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		BillOfMat bom = new BillOfMat(this);

		bom = bom.setBomCommonElements(myShape.top1Part, part, myShape, null,
				null, false, rule, qty, adjw, adjwi, adjh, adjhi, parentRuleID);

		calcCostPrice(qty, part, bom);

		bom.position = 20;

		bomRecords.add(bom);
		return bomRecords;
	}

	public Collection perimeterParts(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		BillOfMat bom = new BillOfMat(this);

		bom = bom.setBomCommonElements(myShape.top1Part, part, myShape, null,
				null, false, rule, qty, adjw, adjwi, adjh, adjhi, parentRuleID);

		calcCostPrice(qty, part, bom);

		bom.position = 20;

		bomRecords.add(bom);
		return bomRecords;
	}

	public Collection otherParts(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		BillOfMat bom = new BillOfMat(this);
		bom = bom.setBomCommonElements(null, part, myShape, null, null, false,
				rule, qty, adjw, adjwi, adjh, adjhi, parentRuleID);

		calcCostPrice(qty, part, bom);

		if (rule.getPosition() == 12) {
			bom.position = 22;
		} else if (rule.getPosition() == 18) {
			bom.position = 24;
		} else if (rule.getPosition() == 19) {
			bom.position = 19;
		} else if (rule.getPosition() == 20) {
			bom.position = 20;
		} else if (rule.getPosition() == 21) {
			bom.position = 51;
		} else if (rule.getPosition() == 22) {
			bom.position = 52;
		} else if (rule.getPosition() == 23) {
			bom.position = 53;
		} else if (rule.getPosition() == 24) {
			bom.position = 54;
		} else if (rule.getPosition() == 25) {
			bom.position = 55;
		} else if (rule.getPosition() == 26) {
			bom.position = 56;
		}

		bomRecords.add(bom);
		return bomRecords;
	}

	public Collection volumeParts(Rules rule, int adjw, int adjwi, int adjh,
			int adjhi, double qty, Parts part, Collection bomRecords) {

		BillOfMat bom = new BillOfMat(this);
		bom = bom.setBomCommonElements(myShape.top1Part, part, myShape, null,
				null, false, rule, qty, adjw, adjwi, adjh, adjhi, parentRuleID);

		calcCostPrice(qty, part, bom);

		bom.position = 22;

		bomRecords.add(bom);
		return bomRecords;
	}

	public void calcCostPrice(double qty, Parts myPart, BillOfMat bom) {

		// ----------------------------------------------------
		// Init Parts Cost Price from Part
		// ----------------------------------------------------
		PartsCostPrice pcp = new PartsCostPrice();
		try {
			pcp = initializePCP(myPart, pcp);
		} catch (GenericPersistenceEAOException e) {
			e.printStackTrace();
		}

		// ----------------------------------------------------
		// Init from Parts Cost Prices Collection
		// ----------------------------------------------------
		if (myPart.isRemote()) {
			this.partCostPrices = ItemFrame.getApplicationRemoteBaseRules()
					.getPartCostPrices(myPart.getSupplierId());
		} else {
			this.partCostPrices = ItemFrame.getApplicationBase()
					.getPartsCostPrices();
		}

		for (Object pc : this.partCostPrices) {
			if (((PartsCostPrice) pc).getId().getPartid() == myPart.getId()
					&& ((PartsCostPrice) pc).isdefault) {
				pcp = ((PartsCostPrice) pc);
			}
		}

		BigDecimal myPartCost = new BigDecimal(0);

		// set part from pcp
		if (myPart != null && pcp != null && pcp.getId().getPriceuom() > 0) {

			myPart.setPriceuom(pcp.getId().getPriceuom());
			myPart.setPrice(pcp.price);
			myPart.setMinprice(pcp.minPrice);
			myPart.setPricemeasure(pcp.pricemeasure);

			if (pcp.pricemeasure == 0) {
				myPart.setPricemeasure(this.myFrame2.currentUOM);
			}

			myPart.setPricematrix(pcp.pricematrix);
			myPart.setCostmatrix(pcp.stdcostmatrix);
			myPart.setCostmeasure(pcp.pricemeasure);
			myPart.setCostuom(pcp.getId().getPriceuom());
			myPart.setTaxable(pcp.taxable);
			myPart.setDiscountable(pcp.discountable);
			myPart.setPrice_markup(pcp.price_markup);
			myPart.setCost_markup(pcp.cost_markup);

			// Init Matrix Controller
			MatrixController matrixController = new MatrixController(myShape,
					this.myFrame2);

			if (pcp != null) {
				if (pcp.pricematrix != null && pcp.pricematrix > 0) {

					try {
						pcp.price = matrixController.getValueFromMatrix(
								pcp.pricematrix, myPart.getSupplierId(), false,
								false, myPart.isRemote());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				if (pcp.stdcostmatrix != null && pcp.stdcostmatrix > 0
						&& myPart.getCostmethod() == 4) {
					try {
						pcp.stdcost = matrixController.getValueFromMatrix(
								pcp.stdcostmatrix, rule.getSupplierId(), false,
								false, rule.isRemote());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			if (myPart.getCostmethod() == 4) {
				myPart.setCost(pcp.stdcost);
			} else if (myPart.getCostmethod() == 1) {
				myPart.setCost(pcp.fifocost);
			} else if (myPart.getCostmethod() == 2) {
				myPart.setCost(pcp.lifocost);
			} else if (myPart.getCostmethod() == 3) {
				myPart.setCost(pcp.movingavgcost);
			} else if (myPart.getCostmethod() == 5) {
				myPart.setCost(pcp.mostrecentcost);
			}
			// Waste is saved whole i.e 10% = 10
			// myPart.setCost(myPart.getCost().multiply(new
			// BigDecimal((myPart.getWaste()/100 + 1) + "")));

			// myPart.setCost(myPart.getCost().multiply(
			// new BigDecimal((myPart.getCost_markup() + 1) + "")));

			BigDecimal myCost = myPart.getCost();

			if (myPart.getCostmethod() == 1) {// LIFO
				myCost = pcp.fifocost;
			} else if (myPart.getCostmethod() == 2) {// FIFO
				myCost = pcp.lifocost;
			} else if (myPart.getCostmethod() == 3) {// Average
				myCost = pcp.movingavgcost;
			} else if (myPart.getCostmethod() == 4) {// Standard
				myCost = pcp.stdcost;
				if (pcp.stdcostmatrix > 0) {
					try {
						myCost = matrixController.getValueFromMatrix(
								pcp.stdcostmatrix, rule.getSupplierId(), false,
								false, rule.isRemote());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else if (myPart.getCostmethod() == 5) {// Most Recent
				myCost = pcp.mostrecentcost;
			}
			myPartCost = myCost.multiply(new BigDecimal((myPart
					.getCost_markup() + 1) + ""));

			if (myPart.getPrice_markup() > 0 && myPart.getPricematrix() == 0) {
				myPart.setPrice(myPartCost.multiply(new BigDecimal((myPart
						.getPrice_markup() + 1) + "")));
			}
		}

		PricingGroup myPG = null;
		TypePriceCategory myPC = null;
		if (myPart.isRemote()) {
			myPG = ItemFrame.getApplicationRemoteBaseRules().getPricingGroup(
					myPart.getSupplierId(), myPart.getPricegroup());
			myPC = ItemFrame.getApplicationBase().getTypePriceCategory(
					myPG.getId());
		} else {
			myPG = ItemFrame.getApplicationBase().getPricingGroup(
					myPart.getPricegroup());
			myPC = ItemFrame.getApplicationBase().getTypePriceCategory(
					myPG.getId());
		}

		// Return Line Discount
		double discount = 0;

		if (myPart.isRemote()) {
			discount = getRemoteLineDiscount(myPart.getSupplierId(),
					myPC.getId());
		} else {
			discount = getLineDiscount(myPC.getId());
		}

		double pricesizem = 0;
		double pricesizei = 0;
		double costsizem = 0;
		double costsizei = 0;

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
			pricesizem = myPart.getFacein() * bom.cutlength / 100d / 1000d;
			pricesizei = myPart.getFaceini() * bom.cutlengthi / 64d / 12d;
		} else if (pcp.getId().getPriceuom() == 5) {// FaceOut
			pricesizem = myPart.getFaceout() * bom.cutlength / 100d / 1000d;
			pricesizei = myPart.getFaceouti() * bom.cutlengthi / 64d / 12d;
		} else if (pcp.getId().getPriceuom() == 6) {// Perimeter
			pricesizem = myPart.getPerimeter() * bom.cutlength / 100d / 1000d;
			pricesizei = myPart.getPerimeteri() * bom.cutlengthi / 64d / 12d;
		} else if (pcp.getId().getPriceuom() == 7) {// weight
			pricesizem = myPart.getWeight() * bom.cutlength / 100d / 1000d;
			pricesizei = myPart.getWeighti() * bom.cutlengthi / 64d / 12d;
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
			costsizem = myPart.getFacein() * bom.cutlength / 100d / 1000d;
			costsizei = myPart.getFaceini() * bom.cutlengthi / 64d / 12d;
		} else if (pcp.costuom == 5) {
			costsizem = myPart.getFaceout() * bom.cutlength / 100d / 1000d;
			costsizei = myPart.getFaceouti() * bom.cutlengthi / 64d / 12d;
		} else if (pcp.costuom == 6) {
			costsizem = myPart.getPerimeter() * bom.cutlength / 100d / 1000d;
			costsizei = myPart.getPerimeteri() * bom.cutlengthi / 64d / 12d;
		} else if (pcp.costuom == 7) {
			costsizem = myPart.getWeight() * bom.cutlength / 100d / 1000d;
			costsizei = myPart.getWeighti() * bom.cutlengthi / 64d / 12d;
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

		BigDecimal myPrice = pcp.price;

		Object[] mypricecost = setCalcPrice(pricesizem, pricesizei, costsizem,
				costsizei, myPG, qty, discount, pcp.price_markup,
				pcp.cost_markup, myPrice, myPartCost, pcp.minPrice, pcp.getId()
						.getPriceuom(), pcp.costuom, pcp.pricemeasure,
				pcp.isDiscountable(), myFrame2, myFrame2.currentUOM,
				myPart.getWaste(), pcp.inclPrice, pcp.inclCost);

		bom.price = bom.priceuser = new BigDecimal(mypricecost[2].toString());
		bom.cost = new BigDecimal(mypricecost[3].toString());

		bom.totalprice = bom.totalpriceuser = new BigDecimal(
				mypricecost[0].toString());
		bom.totalcost = new BigDecimal(mypricecost[1].toString());
	}

	/**
	 * Initialize Parts Cost Price
	 * 
	 * @param myPart
	 *            , Parts
	 * @param pcp
	 *            , Parts Cost Price
	 * @return PartsCostPrice
	 * @throws GenericPersistenceEAOException
	 *             , Exception
	 */
	public PartsCostPrice initializePCP(Parts myPart, PartsCostPrice pcp)
			throws GenericPersistenceEAOException {

		pcp.isdefault = true;

		pcp.cost_markup = myPart.getCost_markup();
		pcp.discountable = myPart.isDiscountable();
		pcp.fifocost = myPart.getCost();
		pcp.lifocost = myPart.getCost();
		pcp.minPrice = myPart.getMinprice();
		pcp.mostrecentcost = myPart.getCost();
		pcp.movingavgcost = myPart.getCost();
		pcp.getId().setPartid(myPart.getId());
		pcp.price = myPart.getPrice();
		pcp.price_markup = myPart.getPrice_markup();

		if (myPart.getPrice_markup() == 1) {
			pcp.pricefromcost = true;
		}

		pcp.pricematrix = myPart.getPricematrix();
		pcp.stdcostmatrix = myPart.getCostmatrix();
		pcp.pricemeasure = myPart.getPricemeasure();

		pcp.getId().setPriceuom(myPart.getPriceuom());
		pcp.priceuomconvert = myPart.getPriceuomconvert();
		pcp.stdcost = myPart.getCost();
		pcp.taxable = myPart.isTaxable();

		pcp.description = ItemFrame.getApplicationBase()
				.getSystemUOM(pcp.getId().getPriceuom()).getDescription();

		// CostUOM == UsageUOM
		pcp.costuom = myPart.getUsageuom();

		pcp.pricemeasure = myPart.getPricemeasure();

		// ------------------------------------------------------
		// Init Part Family
		// ------------------------------------------------------
		PartsFamily partFam = null;
		if (myPart.isRemote()) {
			partFam = ItemFrame.getApplicationRemoteBaseRules().getPartFamily(
					myPart.getSupplierId(), myPart.getPartfamily());
		} else {
			partFam = ItemFrame.getApplicationBase().getPartsFamily(
					myPart.getPartfamily());
		}

		// Init Include In Price Value
		pcp.inclPrice = partFam.getIncludeInPrice();
		pcp.inclCost = partFam.getIncludeInCost();

		if (partFam.getIncludeInPriceMatrix() > 0) {
			try {
				MatrixController matrixController = new MatrixController(
						myShape, this.myFrame2);
				pcp.inclPrice = ((int) (matrixController.getValueFromMatrix(
						partFam.getIncludeInPriceMatrix(),
						rule.getSupplierId(), false, false, rule.isRemote()))
						.doubleValue()) == 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (partFam.getId() == 8) {
			pcp.costuom = myPart.getCostuom();
		}

		PartFamilySeries pfSeries = ItemFrame.getApplicationBase()
				.getPartFamilySeries(partFam.getId(), ItemFrame.seriesID);

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

		if (myPart.getPrice_markup() == 0 || pfSeries != null) {
			pcp.price_markup = partFam.getPriceMarkup();
			// Do matrix loopup here for price markup
		}

		if (myPart.getCost_markup() == 0 || pfSeries != null) {
			pcp.cost_markup = partFam.getCostMarkup();
			// Do matrix loopup here for price markup
		}

		return pcp;
	}

	public BillOfMat createBomRecordFromProfile(Profiles profile, Parts part,
			Rules rule, int qty, int adjw, int adjwi, int adjh, int adjhi) {

		BillOfMat bom = new BillOfMat(this);

		return bom.setBomCommonElements(profile, part, myShape, null, null,
				false, rule, qty, adjw, adjwi, adjh, adjhi, this.parentRuleID);

	}

	public BillOfMat createBomRecordFromPart(Parts part) {

		BillOfMat bom = new BillOfMat(this);

		return bom;

	}

}
