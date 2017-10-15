package Rules;

import Model.*;
import Model.ProfileParts.Profiles;
import Operations.FindBiggestDLO;
import Presentation.ForcedOptionAnswer;
import Presentation.ItemFrame;
import Presentation.OptionAnswerDialog;
import openjanela.app.configuration.controller.calculation.MatrixController;
import openjanela.model.entities.orderEntry.CartDefault;
import openjanela.model.entities.orderEntry.PricingGroup;
import openjanela.model.entities.partner.*;

import org.openjanela.data.ApplicationRemoteBaseRulesApp;

import util.UOMConvert;

import java.math.BigDecimal;
import java.util.*;

public class ExecuteOptionRules extends ExecuteRules {

	ItemFrame mainFrame;

	String from = "";

	List<Rules> failedRules = new ArrayList<Rules>();

	public ExecuteOptionRules(ItemFrame myframe) {

		super(myframe);

		mainFrame = myframe;
	}

	// @Override
	public void executeOptionRules(ShapeObject shape, OrderItemsCart item,
			Profiles mullion, int level, String f) {

		/*******
		 * Assembly Level to indicate which rule level to execute.
		 * 
		 * Object myObject = generic Object sent for evaluation
		 * 
		 * Need Override for occasions where the user forced a choice, for
		 * example Specific profile or end type, or color
		 * 
		 * 
		 ********/

		/**
		 * 1,0,Overall,1 2,1,Facet,1 3,3,Frame,1 4,121,Sash Type,1 5,12,Sash,1
		 * 6,21,Glass/Glazing,1 7,0,Glazing Bead,1 8,22,DLO,1 20,5,Bkgrd
		 * Opening,1 30,0,Divider,1 31,2,Coupler,1 32,4,Mullion,1 32,0,Grids,1
		 * 40,5,Opening,1 200,1,Sub-Facet,1 400,121,Sub-Sash,1 902,0,Object,2
		 * 903,0,Object,3 904,0,Object,4 905,0,Object,5 906,0,Object,6
		 * 907,0,Object,7
		 */

		failedRules.clear();

		myAssemblyLevel = level;

		myUOM = myFrame2.currentUOM;

		if (myFrame2.currentUOM == 1) {
			myScale = myFrame2.metricscale;
		} else {
			myScale = myFrame2.imperialscale;
		}

		/**
		 * Set Object to pre-defined Object in order to use its properties
		 */

		from = f;

		myShape = shape;

		myMullionCoupler = mullion;

		myItem = item;

		if (myShape != null) {
			mySeq = myShape.a_sequenceID;

		}
		if (myMullionCoupler != null) {
			mySeq = myMullionCoupler.rowCol;

		} else {
			mySeq = 0;
		}

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

		if (myAssemblyLevel == 903) {// Part/item Unit
			myUnitItem = myItem;
		} else if (myAssemblyLevel == 904) {// Part Profile
			myProfileItem = myItem;
		} else if (myAssemblyLevel == 905) {// Part/item Area
			myAreaItem = myItem;
		} else if (myAssemblyLevel == 906) {// Part/item Volume
			myVolumeItem = myItem;
		} else if (myAssemblyLevel == 907) {// Part/item Labour/Service
			myLabourItem = myItem;
		}

		this.currentRules = getOptionRules(ItemFrame.getApplicationBaseRules()
				.getOptionRules(this.mainFrame.seriesID));

		// removeShapeOptionsFromDesignOptionsAll();

		// myFrame2.jobItem.design.loadOptionsAll();

		if (currentRules.size() > 0) {

			executeCurrentOptionRules(this.currentRules, ItemFrame
					.getApplicationBaseRules().getRuleTest(this.mainFrame.seriesID),
					ItemFrame.getApplicationBaseRules().getRuleAnswers(), null,
					this.mainFrame.seriesID);

		}

		if (myShape != null) {
			Object[] shapeops = myShape.options.toArray();
			myShape.options.clear();

			for (Object sp : shapeops) {

				ShapeOption shapeOption = (ShapeOption) sp;

				Rules myR = null;

				if (shapeOption.remote) {
					myR = ItemFrame.getApplicationRemoteBaseRules().getRule(
							shapeOption.supplierId,
							shapeOption.supplierSeriesId, shapeOption.ruleno);
				} else {
					myR = ItemFrame.getApplicationBaseRules().getRule(
							this.mainFrame.seriesID, ((ShapeOption) sp).ruleno);
					
					if (myR== null && ((ShapeOption) sp).parentRule > 0 &&
							((ShapeOption) sp).parentRule != ((ShapeOption) sp).ruleno) {
						myR = ItemFrame.getApplicationBaseRules().getRule(
								ItemFrame.seriesID,
								((ShapeOption) sp).parentRule);
					}
					
				}

				if (myR != null
						&& !failedRuleExistsInShapeOptions(myR.getRulesPK()
								.getId(), myR.getAssemblyID())) {
					myShape.options.add(shapeOption);
				}

			}

			

		}

		if (myMullionCoupler != null) {
			Object[] shapeops = myMullionCoupler.options.toArray();
			myMullionCoupler.options.clear();

			for (Object sp : shapeops) {

				ShapeOption shapeOption = (ShapeOption) sp;

				Rules myR = null;

				if (shapeOption.remote) {
					myR = ItemFrame.getApplicationRemoteBaseRules().getRule(
							shapeOption.supplierId,
							shapeOption.supplierSeriesId, shapeOption.ruleno);
				} else {
					myR = ItemFrame.getApplicationBaseRules().getRule(
							this.mainFrame.seriesID, ((ShapeOption) sp).ruleno);
					
					if (((ShapeOption) sp).parentRule > 0 &&
							((ShapeOption) sp).parentRule != ((ShapeOption) sp).ruleno) {
						myR = ItemFrame.getApplicationBaseRules().getRule(
								ItemFrame.seriesID,
								((ShapeOption) sp).parentRule);
					}
					
				}

				if (myR != null
						&& !failedRuleExistsInShapeOptions(myR.getRulesPK()
								.getId(), myR.getAssemblyID())) {
					myMullionCoupler.options.add(shapeOption);
				}
			}

		}

	}

	public List<Rules> getOptionRules(List<Rules> rules) {

		List<Rules> optRules = new ArrayList();
		for (Rules rule : rules) {
			if ((rule.getRuletype() <= 3) && isCorrectAssemblyLevel(rule)) { // isExactAssemblyLevel(rule))
																				// {
				optRules.add(rule);
			}
		}

		Collections.sort(optRules, RulesComparator.RULE_ID);

		return optRules;
	}

	public void executeCurrentOptionRules(List<Rules> rules,
			List<RuleTest> rtests, List<RuleAnswers> ranswers,
			Rules parentRule, int series) {

		boolean passLocalTest = false;

		double quantity;
		int wAdjust;
		int hAdjust;
		int wAdjusti;
		int hAdjusti;
		int w;
		int wi;
		int h;
		int hi;
		int l;
		int li;
		int d;
		int di;
		
		
		OptionDefinitions myOption = new OptionDefinitions();
		OptionAnswers myAnswer = new OptionAnswers();
		PricingGroup priceGroup = new PricingGroup();
		
		
		
		for (Rules rule : rules) {
			
			/**
			 * Remove Option from designOptionsAll where ruleno, level, seq, and
			 * assembly are same. (i.e. All Options for this Shape)
			 * 
			 * If the rule passes the test, the option gets added again if it
			 * was already there, (See setOptions)
			 * 
			 * or added for the first time if it is a new option.
			 * 
			 */
			if (rule.isRemote()) {
				rtests = ItemFrame.getApplicationRemoteBaseRules().getRuleTest(
						rule.getSupplierId(), rule.getRulesPK().getSeriesId());
				ranswers = ItemFrame.getApplicationRemoteBaseRules()
						.getRuleAnswers(rule.getSupplierId());
			}

			if (rule.getRuletype() <=3 && rule.getRulesPK().getId()==12) {
				System.out.print("ddd");
			}

			// ****************************************
			// Set OptionAnswer to Last Selected Answer or Default
			// ****************************************
			if (!rule.getAnswerismatrix()) {
				rule = setRuleValue2New(rule);
			}

			passLocalTest = filterArraysAndTest(rule, ranswers, rtests, series);
			
			if (passLocalTest) {
				
				if (rule.getRuletype() == 3) { // Option Segment
					
					int mseries = rule.getRulevalue();
					this.myParentRule = rule;
					parentRuleID = myParentRule.getRulesPK().getId();
					this.subParentTests = rtests;
					this.subParentRulesAnswers = ranswers;

					// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					// Options Segments Supplier Rules
					// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					if (rule.isRemote()) {
						this.subRules = ItemFrame
								.getApplicationRemoteBaseRules().getRules(
										rule.getSupplierId(),
										rule.getRulevalue());
						this.subTests = ItemFrame
								.getApplicationRemoteBaseRules().getRuleTest(
										rule.getSupplierId(),
										rule.getRulevalue());
						this.subRulesAnswers = ItemFrame
								.getApplicationRemoteBaseRules()
								.getRuleAnswers(rule.getSupplierId());
					} else {
						this.subRules = ItemFrame.getApplicationBaseRules()
								.getRules(rule.getRulevalue());
						this.subTests = ItemFrame.getApplicationBaseRules()
								.getRuleTest(rule.getRulevalue());
						this.subRulesAnswers = ItemFrame
								.getApplicationBaseRules().getRuleAnswers();
					}

					if (filterArraysAndTest(myParentRule,
							subParentRulesAnswers, subParentTests, mseries)) {
						
						executeCurrentOptionRules(getOptionRules(subRules),
								subTests, subRulesAnswers, myParentRule, mseries);
						
						parentRule = null;
						parentRuleID =0;
					}

				} else if (rule.getRuletype() <= 2) { // Option choice or Auto

					if (passLocalTest) {

						/**
						 * check if new Option or is something that has not been
						 * processed in previous Loops.
						 * 
						 * if exists and not pass test, then remove from
						 * ShapeOptions.
						 * 
						 */

						/**
						 * apply Rule: Get OptionDefinition and Option
						 * 
						 * Answer ID based on:
						 * 
						 * 1. If Already in ShapeOption then read existing
						 * answer
						 * 
						 * 2. If rule type 1 read Customer Default then Order
						 * Default
						 * 
						 * 3. If rule type 2 keep as is (set option answer to
						 * rulevalue2)
						 * 
						 */
						ShapeOption myShapeOption = new ShapeOption();

						if (rule.isRemote()) {
							myOption = this.getOption(rule.getSupplierId(),
									rule.getRulevalue());
						} else {
							myOption = this.getOption(rule.getRulevalue());
						}

						if (rule.getRuletype() == 1) {

							if ((!this.myFrame2.jobItem.isOpen || !this.myFrame2.jobItem.isEdit)) {

								if (myOption.getMustanswer()
										&& !this.isOptionInDesignOptionsAll(myOption
												.getId())) {

									int answerid = new OptionAnswerDialog(
											myOption, this.mainFrame)
											.getOptionAnswersSelected();

									rule.setRulevalue2(answerid + "");

									ForcedOptionAnswer forced = new ForcedOptionAnswer();
									forced.answerID = answerid;
									forced.optionID = myOption.getId();

									myFrame2.alreadyAnsweredOptions.add(forced);

									// All Option answers findALL by option ID
								} else if (myOption.getMustanswer()
										&& this.isOptionInDesignOptionsAll(myOption
												.getId())) {
									rule.setRulevalue2(this
											.getForcedAnswer(myOption.getId())
											+ "");
								} else if (!myOption.getMustanswer()
										&& this.isOptionInDesignOptionsAll(myOption
												.getId())) {
									int answer = this.getForcedAnswer(myOption
											.getId());

									if (answer > 0) {
										rule.setRulevalue2(answer + "");
									}
								}
							}
						}

						myAnswer = this.getOptionAnswer(rule, myOption);

						if (myOption.getOptiontypeid() <= 2 && myAnswer != null) {
							/**
							 * Get Princing group based on Optionanswer
							 * pricegroup
							 */
							if (myAnswer.isRemote()) {
								priceGroup = this.getRemotePricingGroup(
										myAnswer.getSupplierId(),
										myAnswer.getPrice_group_id());
							} else {
								priceGroup = this.getPricingGroup(myAnswer
										.getPrice_group_id());
							}
						} else if (myAnswer == null) {
							// priceGroup = priceGroup.
						}

						/**
						 * 
						 * Get Quantity Values From rule
						 * 
						 */
						quantity = this.getRuleQuantityValue(rule);

						/**
						 * 
						 * Get Adjudtment Values From rule
						 * 
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
						int[] res3 = new int[4];

						res3 = getOptionWHSizeForShape(rule, myUOM, wAdjust,
								wAdjusti, hAdjust, hAdjusti);

						w = res3[0];
						wi = res3[1];
						h = res3[2];
						hi = res3[3];
						l = res3[4];
						li = res3[5];
						d = res3[6];
						di = res3[7];

						/**
						 * Calculate Price and Cost for Non Input Options
						 * 
						 */
						Object[] priceCost = new Object[3];
						priceCost[0] = new BigDecimal(0);// price
						priceCost[1] = new BigDecimal(0);// cost
						priceCost[2] = 0.0d; // discount

						if (myOption.getOptiontypeid() <= 2 && myAnswer != null) {
							priceCost = getOptionPrice(rule, myAnswer, w, h,
									wi, hi, l, li, d, di, priceGroup, quantity);
						}

						try {
							if (myAnswer != null) {
								myShapeOption = setShapeOption(myOption,
										myAnswer, w, h, wi, hi, rule,
										myShapeOption, priceCost);
								
								if (this.parentRuleID!=   0) {
									myShapeOption.parentRule = parentRuleID;
								} else {
									myShapeOption.parentRule = myShapeOption.ruleno;
								}
								
							}
						} catch (NumberFormatException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						}

						// **********************************************************************************************
						// Check if options exist for shape object and replace
						// the answer
						// **********************************************************************************************
						if (myShape != null) {

							for (Iterator it = myShape.options.iterator(); it
									.hasNext();) {

								// Returning Shape Option
								ShapeOption shapeOption = (ShapeOption) it
										.next();

								if (myShapeOption.optionid == shapeOption.optionid) {
									// Remove Shape Option
									it.remove();
									break;
								}
							}

							if (rule.getGlobalOption() && myAnswer != null) {
								myShapeOption.global = true;
								

								DesignOption dop = new DesignOption();
								setDesignOptions(dop, myShapeOption);

								for (Iterator it = this.myFrame2.shapeOptions
										.iterator(); it.hasNext();) {
									// Returning Shape Option
									DesignOption option = (DesignOption) it
											.next();

									if (myShapeOption.optionid == option.optionid) {
										// Remove Shape Option
										it.remove();
									}
								}

								this.myFrame2.shapeOptions.add(dop);

							} else {
								
								
								myShape.options.add(myShapeOption);
							}

						} else if (myMullionCoupler != null) {

							for (Iterator it = myMullionCoupler.options
									.iterator(); it.hasNext();) {

								// Returning Shape Option
								ShapeOption shapeOption = (ShapeOption) it
										.next();

								if (myShapeOption.optionid == shapeOption.optionid) {

									// Remove Shape Option
									it.remove();

									break;
								}
							}
							
							myMullionCoupler.options.add(myShapeOption);
						}
					}
				}

			} else {
				if (!rule.getGlobalOption()) {
					failedRules.add((rule));
				}
			}
		}
	}

	public Rules setRuleValue2(Rules rule) {

		if (myShape != null) {

			Object[] shapeOpts = myShape.options.toArray();

			// Option Variable Found
			boolean found = false;

			for (Object so : shapeOpts) {

				if (rule.getRulesPK().getId() == ((ShapeOption) so).ruleno) {

					// Option Found
					found = true;

					if (((ShapeOption) so).myoption.getOptiontypeid() <= 2) {
						rule.setRulevalue2(((ShapeOption) so).answerid + "");
					} else if (((ShapeOption) so).myoption.getOptiontypeid() == 3) {
						rule.setRulevalue2(((ShapeOption) so).qtyanswer + "");
					} else if (((ShapeOption) so).myoption.getOptiontypeid() == 4) {
						if (myFrame2.currentUOM == 1) {
							rule.setRulevalue2(((ShapeOption) so).sizeanswer
									+ "");
						} else {
							rule.setRulevalue2(((ShapeOption) so).sizeansweri
									+ "");
						}
					} else if (((ShapeOption) so).myoption.getOptiontypeid() == 5) {
						if (myFrame2.currentUOM == 1) {
							rule.setRulevalue2(((ShapeOption) so).depthanswer
									+ "");
						} else {
							rule.setRulevalue2(((ShapeOption) so).depthansweri
									+ "");
						}
					} else if (((ShapeOption) so).myoption.getOptiontypeid() == 6) {
						rule.setRulevalue2(((ShapeOption) so).textAnswer);
					} else if (((ShapeOption) so).myoption.getOptiontypeid() == 7) {
						if (myFrame2.currentUOM == 1) {
							rule.setRulevalue2(((ShapeOption) so).adjust + "");
						} else {
							rule.setRulevalue2(((ShapeOption) so).adjusti + "");
						}
					}

					break;
				}
			}

			// Search Option Answer from cart defaults
			if (!found) {

				for (Object cartDefault : this.myFrame2.cartDefaults) {
					CartDefault shape_def = (CartDefault) cartDefault;

					if (rule.getRulevalue() == shape_def.getCartDefaultPK()
							.getOptions().intValue()) {

						// Found default option
						found = true;

						rule.setRulevalue2(shape_def.getAnswer() + "");
					}
				}
			}

			// Search Option Answer from partner defaults
			if (!found) {

				for (Object cartDefault : this.myFrame2.partnerDefaults) {
					PartnerDefault shape_def = (PartnerDefault) cartDefault;

					if (rule.getRulevalue() == shape_def.getPartnerDefaultPK()
							.getOptions()) {
						rule.setRulevalue2(shape_def.getAnswer() + "");
					}
				}
			}

		}

		return rule;
	}

	public Rules setRuleValue2New(Rules rule) {

		if (myShape != null) {

			Object[] designOpts = myFrame2.designOptionsAll.toArray();

			// Option Variable Found
			boolean found = false;

			for (Object so : designOpts) {

				if (rule.getRulevalue() == ((DesignOption) so).optionid
						&& rule.getAssemblyid() == ((DesignOption) so).a_assemblyLevel) {

					// Option Found
					found = true;

					if (((DesignOption) so).myoption.getOptiontypeid() <= 2) {
						rule.setRulevalue2(((DesignOption) so).answerid + "");
					} else if (((DesignOption) so).myoption.getOptiontypeid() == 3) {
						rule.setRulevalue2(((DesignOption) so).qtyanswer + "");
					} else if (((DesignOption) so).myoption.getOptiontypeid() == 4) {
						if (myFrame2.currentUOM == 1) {
							rule.setRulevalue2(((DesignOption) so).sizeanswer
									+ "");
						} else {
							rule.setRulevalue2(((DesignOption) so).sizeansweri
									+ "");
						}
					} else if (((DesignOption) so).myoption.getOptiontypeid() == 5) {
						if (myFrame2.currentUOM == 1) {
							rule.setRulevalue2(((DesignOption) so).depthanswer
									+ "");
						} else {
							rule.setRulevalue2(((DesignOption) so).depthansweri
									+ "");
						}
					} else if (((DesignOption) so).myoption.getOptiontypeid() == 6) {
						rule.setRulevalue2(((DesignOption) so).textAnswer);
					} else if (((DesignOption) so).myoption.getOptiontypeid() == 7) {
						if (myFrame2.currentUOM == 1) {
							rule.setRulevalue2(((DesignOption) so).adjust + "");
						} else {
							rule.setRulevalue2(((DesignOption) so).adjusti + "");
						}
					}

					break;
				}
			}

			// Search Option Answer from cart defaults
			if (!found) {

				for (Object cartDefault : this.myFrame2.cartDefaults) {
					CartDefault shape_def = (CartDefault) cartDefault;

					if (rule.getRulevalue() == shape_def.getCartDefaultPK()
							.getOptions().intValue()) {

						// Found default option
						found = true;

						rule.setRulevalue2(shape_def.getAnswer() + "");
					}
				}
			}

			// Search Option Answer from partner defaults
			if (!found) {

				for (Object cartDefault : this.myFrame2.partnerDefaults) {
					PartnerDefault shape_def = (PartnerDefault) cartDefault;

					if (rule.getRulevalue() == shape_def.getPartnerDefaultPK()
							.getOptions()) {
						rule.setRulevalue2(shape_def.getAnswer() + "");
					}
				}
			}

		}

		return rule;
	}

	/**
	 * Return Option Definitions
	 * 
	 * @param optionID
	 *            , Option Identification Id
	 * @return OptionDefinitions
	 */
	public OptionDefinitions getOption(int optionID) {
		return ItemFrame.getApplicationBaseRules().getOptionDefinitions(
				optionID);
	}

	/**
	 * Return Option Definitions
	 * 
	 * @param supplierID
	 *            , Supplier Identification Id
	 * @param optionID
	 *            , Option Identification Id
	 * @return OptionDefinitions
	 */
	public OptionDefinitions getOption(int supplierID, int optionID) {
		return ItemFrame.getApplicationRemoteBaseRules().getOptionDefinitions(
				supplierID, optionID);
	}

	/**
	 * @param rule
	 * @param options
	 * @param myoption
	 * @param myanswer
	 * @return
	 */
	private Object[] isNewOption(Rules rule, Collection options,
			OptionDefinitions myoption, OptionAnswers myanswer) {

		Object[] returns = new Object[4];

		Object[] shapeops = options.toArray();

		boolean setFromDesign = false;

		ShapeOption myO = null;

		int myanswerid = 0;
		String myanswertext = "";

		for (Object op : shapeops) {

			if (((ShapeOption) op).optionid == myoption.getId()) {

				if (((ShapeOption) op).myoption.getOptiontypeid() <= 2) {

					if (((ShapeOption) op).answerid == myanswer.getId().getId()) {

						myO = (ShapeOption) op;
						myanswerid = myanswer.getId().getId();
						setFromDesign = true;
					}

					break;
				} else if (((ShapeOption) op).myoption.getOptiontypeid() == 3) {
					if (((ShapeOption) op).qtyanswer == Double.parseDouble(rule
							.getRulevalue2())) {

						myO = (ShapeOption) op;
						myanswertext = rule.getRulevalue2();
						setFromDesign = true;
					}

					break;
				} else if (((ShapeOption) op).myoption.getOptiontypeid() == 4) {

					if (((ShapeOption) op).sizeanswer == Double
							.parseDouble(rule.getRulevalue2())
							|| ((ShapeOption) op).sizeansweri == Double
									.parseDouble(rule.getRulevalue2())) {

						myO = (ShapeOption) op;
						myanswertext = rule.getRulevalue2();
						setFromDesign = true;
					}

					break;
				} else if (((ShapeOption) op).myoption.getOptiontypeid() == 5) {
					if (((ShapeOption) op).depthanswer == Double
							.parseDouble(rule.getRulevalue2())
							|| ((ShapeOption) op).depthansweri == Double
									.parseDouble(rule.getRulevalue2())) {

						myO = (ShapeOption) op;
						myanswertext = rule.getRulevalue2();
						setFromDesign = true;
					}

					break;
				} else if (((ShapeOption) op).myoption.getOptiontypeid() == 6) {
					if (((ShapeOption) op).textAnswer == rule.getRulevalue2()) {

						myO = (ShapeOption) op;
						myanswertext = rule.getRulevalue2();
						setFromDesign = true;
					}

					break;
				} else if (((ShapeOption) op).myoption.getOptiontypeid() == 7) {
					if (((ShapeOption) op).adjust == Double.parseDouble(rule
							.getRulevalue2())
							|| ((ShapeOption) op).adjusti == Double
									.parseDouble(rule.getRulevalue2())) {

						myO = (ShapeOption) op;
						myanswertext = rule.getRulevalue2();
						setFromDesign = true;
					}

					break;
				}
			}

		}
		returns[0] = myO;
		returns[1] = setFromDesign;
		returns[2] = myanswerid;
		returns[3] = myanswertext;

		return returns;
	}

	public boolean isOptionInDesignOptionsAll(int optionid) {

		Object[] desOpts = myFrame2.alreadyAnsweredOptions.toArray();

		boolean found = false;

		for (Object od : desOpts) {

			if (((ForcedOptionAnswer) od).optionID == optionid) {
				found = true;
				break;

			}

		} // Shape Options Loop

		return found;
	}

	public int getForcedAnswer(int optionid) {

		Object[] desOpts = myFrame2.alreadyAnsweredOptions.toArray();

		int answer = 0;

		for (Object od : desOpts) {

			if (((ForcedOptionAnswer) od).optionID == optionid) {
				answer = ((ForcedOptionAnswer) od).answerID;
				break;
			}
		} // Shape Options Loop

		return answer;
	}

	public void resetShapeOptionsFromDesignOptionsAll() {

		Object[] desOpts = myFrame2.designOptionsAll.toArray();

		myFrame2.designOptionsAll.clear();

		if (myShape != null) {
			myShape.options.clear();

			for (Object od : desOpts) {

				if (((DesignOption) od).isForShape(myShape)) {
					if (((DesignOption) od).ruleno == 5) {
						ShapeOption shapeoption = new ShapeOption();
					}
					if (optionRuleExistsInCurrentRules(((DesignOption) od).ruleno)) {
						ShapeOption shapeoption = new ShapeOption();
						myShape.options.add(this
								.setShapeOptionsFromDesignOptions(
										(DesignOption) od, shapeoption));
					}
				} else {
					myFrame2.designOptionsAll.add(((DesignOption) od));
				}

			} // Shape Options Loop

		} else if (this.myMullionCoupler != null) {
			Object[] cmOpts = myMullionCoupler.options.toArray();
			myMullionCoupler.options.clear();

			for (Object od : desOpts) {

				if (((DesignOption) od).isForMC(myMullionCoupler)) {
					ShapeOption shapeoption = new ShapeOption();
					myMullionCoupler.options.add(this
							.setShapeOptionsFromDesignOptions(
									(DesignOption) od, shapeoption));

				} else {
					myFrame2.designOptionsAll.add(((DesignOption) od));
				}

			}

		}

	}

	public boolean optionRuleExistsInCurrentRules(int ruleNo) {

		Object[] rs = currentRules.toArray();

		for (Object r : rs) {
			if (((Rules) r).getRulesPK().getId() == ruleNo) {
				return true;
			}
		}
		return false;
	}

	public boolean failedRuleExistsInShapeOptions(int id, int assemblyID) {

		if (id == 6) {
			int ff = 0;
		}

		for (Rules r : failedRules) {
			if (r.getAssemblyid() == assemblyID && r.getRulesPK().getId() == id) {
				return true;
			}
		}
		return false;
	}

	public ShapeOption optionRuleExistsIntempOptions(int ruleNo) {

		Object[] rs = myShape.options.toArray();

		for (Object r : rs) {
			if (((ShapeOption) r).ruleno == ruleNo) {
				return (ShapeOption) r;
			}
		}
		return null;
	}

	public void removeShapeOptionsFromDesignOptionsAll() {

		Object[] desOpts = myFrame2.designOptionsAll.toArray();

		myFrame2.designOptionsAll.clear();

		if (myShape != null) {
			Object[] shapeOpts = myShape.options.toArray();

			myShape.options.clear();

			for (Object od : desOpts) {

				if (!((DesignOption) od).isForShape(myShape)) {

					myFrame2.designOptionsAll.add(((DesignOption) od));
				}

			} // Shape Options Loop

		} else if (this.myMullionCoupler != null) {
			Object[] cmOpts = myMullionCoupler.options.toArray();
			myMullionCoupler.options.clear();

			for (Object od : desOpts) {

				if (!((DesignOption) od).isForMC(myMullionCoupler)) {

					myFrame2.designOptionsAll.add(((DesignOption) od));
				}

			}

		}

	}

	public void cleanShapeOptionsByRuleNo() {

		Object[] cr = currentRules.toArray();

		Object[] shapeOpts = myShape.options.toArray();

		myShape.options.clear();

		for (Object so : shapeOpts) {
			for (Object r : cr) {
				if (((ShapeOption) so).ruleno == ((Rules) r).getRulesPK()
						.getId()) {
					myShape.options.add((ShapeOption) so);
					break;
				}

			}

		}

	}

	/**
	 * Set Option - Default Answer
	 * <p/>
	 * 1. Read Option from Rule 2. Check if it exists in Shape/Mullion/Item
	 * Options Collection 3. if Exist -> Update
	 * 
	 * @param rule
	 * @param pass
	 * @return
	 */
	private Object[] setOptions(Rules rule, boolean pass) {

		Object[] res = new Object[3];

		Object resOfReadMatrix[] = new Object[2];

		OptionDefinitions myOption = getOption(rule.getRulevalue());

		OptionAnswers myAnswer = getOptionAnswer(rule, myOption);

		Collection ops = new ArrayList();

		if (myShape != null) {
			ops = myShape.options;
		} else if (myMullionCoupler != null) {
			ops = myMullionCoupler.options;
		} else if (myItem != null) {
			// ops = item.options;
		}

		/**
		 * if Option Exists: get Option Record from ShapeOptions
		 */

		Object[] returns = isNewOption(rule, ops, myOption, myAnswer);

		ShapeOption existingOption = (ShapeOption) returns[0];

		boolean setFromDesignOptions = (Boolean) returns[1];

		int myanswerid = (Integer) returns[2];

		String myanswerText = (String) returns[3];

		boolean update = false;

		/**
		 * If option Exists in Shape Options, and is OPtion Choice (rule type=1)
		 * and answer is not from Matrix (i.e. answer is Default) Then Update.
		 * 
		 * Option answer will remain as in ShapeOption (answer, price, etc.)
		 */

		if (existingOption != null && rule.getRuletype() == 1
				&& !rule.getAnswerismatrix()) {
			if (myShape != null) {

				myShape.options = updateOptionCollection(ops, myOption.getId(),
						rule.getRulesPK().getId(), pass);

			} else if (myMullionCoupler != null) {

				myMullionCoupler.options = updateOptionCollection(ops,
						myOption.getId(), rule.getRulesPK().getId(), pass);

			} else if (myItem != null) {

				// if (myAssemblyLevel == 903)
				// {// Part/item Unit
				// myUnitItem.options = updateShapeOption(ops, myOption.id,
				// rule.getRulesPK().getId());
				// }
				// else if (myAssemblyLevel == 904)
				// {// Part Profile
				// myProfileItem.options = updateShapeOption(ops,
				// myOption.id, rule.getRulesPK().getId());
				// }
				// else if (myAssemblyLevel == 905)
				// {// Part/item Area
				// myAreaItem.options = updateShapeOption(ops, myOption.id,
				// rule.getRulesPK().getId());
				// }
				// else if (myAssemblyLevel == 906)
				// {// Part/item Volume
				// myVolumeItem.options = updateShapeOption(ops,
				// myOption.id, rule.getRulesPK().getId());
				// }
				// else if (myAssemblyLevel == 907)
				// {// Part/item Labour/Service
				// myLabourItem.options = updateShapeOption(ops,
				// myOption.id, rule.getRulesPK().getId());
				// }

			}

			update = true;

		}

		/**
		 * if shapeOption updated, no further processing is required and returns
		 * NULL for option
		 * 
		 */
		if (!update) {
			if (existingOption == null && !rule.getAnswerismatrix()) {
				/**
				 * Get Default Option Answer
				 */
				int myid = getOptionDefaults(rule.getRulevalue());

				if (rule.getRuletype() == 1) // Option Choice
				{

					if (myid != 0) {
						myOption.setMustanswer(false);
						rule.setRulevalue2(myid + "");
					}

					if (setFromDesignOptions) {
						myOption.setMustanswer(false);
						if (myOption.getOptiontypeid() <= 2) {
							rule.setRulevalue2(myanswerid + "");
						} else {
							rule.setRulevalue2(myanswerText);
						}
					}

				} else if (rule.getRuletype() == 2) // Option Auto
				{
					myOption.setMustanswer(false);

				}

			}

			if (rule.getAnswerismatrix()) // Answer From Matrix
			{

				// Need matrix Controller
				MatrixController matrixController = new MatrixController(
						myShape, this.myFrame2);

				try {
					rule.setRulevalue2(matrixController.getValueFromMatrix(
							Integer.valueOf(rule.getRulevalue2()),
							rule.getSupplierId(), false, false, rule.isRemote())
							+ "");

				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			res[0] = rule;
			res[1] = myOption;
			res[2] = myAnswer;

		} else {
			res[0] = rule;
			res[1] = null;
			res[2] = null;
		}

		return res;
	}

	private int[] getOptionWHSizeForShape(Rules rule, int myUOM, int wAdjust,
			int wAdjusti, int hAdjust, int hAdjusti) {

		int w = 0;
		int h = 0;
		int wi = 0;
		int hi = 0;
		int l = 0;
		int li = 0;
		int d = 0;
		int di = 0;

		int[] res = new int[8];

		if (myUOM == 1) {
			if (!rule.isNominal()) {
				if (myShape != null) {

					w = myShape.widthM / 100 / 1000;
					h = myShape.heightM / 100 / 1000;

				} else if (myMullionCoupler != null) {

					w = myMullionCoupler.lengthM / 100 / 1000;

				} else if (myItem != null) {

					w = myItem.getWidth() / 100 / 1000;
					h = myItem.getHeight() / 100 / 1000;
					d = myItem.getDepth() / 100 / 1000;
					l = myItem.getSize() / 100 / 1000;

				}
			} else {
				if (myShape != null) {

					w = myShape.widthMN / 100 / 1000;
					h = myShape.heightMN / 100 / 1000;

				} else if (myMullionCoupler != null) {

					w = myMullionCoupler.lengthMN / 100 / 1000;

				} else if (myItem != null) {

					w = myItem.getWidth() / 100 / 1000;
					h = myItem.getHeight() / 100 / 1000;
					d = myItem.getDepth() / 100 / 1000;
					l = myItem.getSize() / 100 / 1000;

				}
			}
		} else {
			if (!rule.isNominal()) {

				if (myShape != null) {
					wi = myShape.widthI / 64 / 12;
					hi = myShape.heightI / 64 / 12;
					w = myShape.widthI / 64 / 12;
					h = myShape.heightI / 64 / 12;

				} else if (myMullionCoupler != null) {

					w = myMullionCoupler.lengthI / 64 / 12;

				} else if (myItem != null) {

					w = myItem.getWidthI() / 64 / 12;
					h = myItem.getHeightI() / 64 / 12;
					d = myItem.getDepthI() / 64 / 12;
					l = myItem.getSizeI() / 64 / 12;

				}

			} else {

				if (myShape != null) {
					wi = myShape.widthIN / 64 / 12;
					hi = myShape.heightIN / 64 / 12;
					w = myShape.widthIN / 64 / 12;
					h = myShape.heightIN / 64 / 12;

				} else if (myMullionCoupler != null) {

					w = myMullionCoupler.lengthIN / 64 / 12;

				} else if (myItem != null) {

					w = myItem.getWidthI() / 64 / 12;
					h = myItem.getHeightI() / 64 / 12;
					d = myItem.getDepthI() / 64 / 12;
					l = myItem.getSizeI() / 64 / 12;

				}
			}
		}

		res[0] = w + wAdjust;
		res[1] = wi + wAdjusti;

		res[2] = h + hAdjust;
		res[3] = hi + hAdjust;

		res[4] = l + wAdjust;
		res[5] = li + wAdjusti;

		res[6] = d + hAdjust;
		res[7] = di + hAdjust;

		return res;
	}

	/**
	 * Return Option Answer
	 * 
	 * @param rule
	 *            , Rule Execution
	 * @param myOption
	 *            , OptionDefinitions
	 * @return OptionAnswers
	 */
	private OptionAnswers getOptionAnswer(Rules rule, OptionDefinitions myOption) {

		OptionAnswers optionAnswer = new OptionAnswers();

		if (!rule.getAnswerismatrix()) {

			OptionAnswers answers;
			if (rule.isRemote()) {
				answers = ItemFrame.getApplicationRemoteBaseRules()
						.getOptionAnswers(rule.getSupplierId(),
								myOption.getId(),
								Integer.valueOf(rule.getRulevalue2()));
			} else {
				answers = ItemFrame.getApplicationBaseRules()
						.getOptionAnswers(myOption.getId(),
								Integer.valueOf(rule.getRulevalue2()));
			}

			if (myOption.getOptiontypeid() <= 2) {
				optionAnswer = answers;
			}

		} else {

			// Need matrix Controller
			MatrixController matrixController = new MatrixController(myShape,
					this.myFrame2);
			int optionAnswerID = 0;

			try {

				optionAnswerID = (int) ((matrixController.getValueFromMatrix(
						Integer.valueOf(rule.getRulevalue2()),
						rule.getSupplierId(), false, false, rule.isRemote()))
						.doubleValue());

				OptionAnswers answers = new OptionAnswers();
				if (rule.isRemote()) {
					answers = ItemFrame.getApplicationRemoteBaseRules()
							.getOptionAnswers(rule.getSupplierId(),
									myOption.getId(), optionAnswerID);
				} else {
					answers = ItemFrame.getApplicationBaseRules()
							.getOptionAnswers(myOption.getId(), optionAnswerID);
				}

				if (myOption.getOptiontypeid() <= 2) {
					optionAnswer = answers;
				}

			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// optionAnswer Get Price from Matrix
		return optionAnswer;
	}

	private int getOptionDefaults(int optionId) {

		int defaultAnswer = 0;

		defaultAnswer = ItemFrame.getApplicationBase()
				.getPartnerDefault(1, optionId).getAnswer();

		Object[] cartD = this.cartDefaults.toArray();
		for (Object cd : cartD) {
			if (((CartDefault) cd).getCartDefaultPK().getDefaultType() == 1
					&& ((CartDefault) cd).getCartDefaultPK().getOptions() == optionId) {
				defaultAnswer = ((CartDefault) cd).getAnswer();
			}
		}

		return defaultAnswer;
	}

	private Object[] getOptionPrice(Rules rule, OptionAnswers answer, int w,
			int h, int wi, int hi, int l, int li, int d, int di,
			PricingGroup priceGroup, double quantity) {

		BigDecimal price = answer.getPrice();
		BigDecimal cost = answer.getCost();
		BigDecimal minprice = answer.getMin_price();

		BigDecimal totalprice = new BigDecimal(0);
		BigDecimal totalcost = new BigDecimal(0);
		BigDecimal totalpricef = new BigDecimal(0);
		BigDecimal totalcostf = new BigDecimal(0);

		double discountP = 0.0;

		if (priceGroup.isRemote()) {
			discountP = this.getRemoteLineDiscount(priceGroup.getSupplierId(),
					priceGroup.getPriceCategory());
		} else {
			discountP = this.getLineDiscount(priceGroup.getPriceCategory());
		}

		double costmarkup = priceGroup.getCostMarkup();
		if (costmarkup == 0) {
			costmarkup = answer.getCostMarkup();
		}

		double pricemarkup = priceGroup.getPriceMarkup();
		if (pricemarkup == 0) {
			pricemarkup = answer.getPriceMarkup();
		}

		int priceuom = answer.getPrice_group_id();
		int costuom = answer.getCosting_uom_id();
		int pricemeasure = answer.getPriceMeasure();
		boolean discountable = answer.isDiscountable();

		BigDecimal myCost = answer.getCost();

		BigDecimal myPrice = answer.getPrice();

		if (answer.getPrice_matrix_id() > 0) {

			MatrixController matrixController = new MatrixController(myShape,
					this.myFrame2);

			try {
				myPrice = matrixController.getValueFromMatrix(
						answer.getPrice_matrix_id(), rule.getSupplierId(),
						true, false, rule.isRemote());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (answer.getPricing_uom_id() == 1) {
			Object[] mo = setCalcPrice(w, wi, w, wi, priceGroup, quantity,
					discountP, pricemarkup, costmarkup, price, cost, minprice,
					priceuom, costuom, pricemeasure, discountable, myFrame2,
					myFrame2.currentUOM, 0, true, true);
			if (rule.getPosition() == 1 && myShape != null) {
				if (rule.getRcondition() == 1) {
					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];
				} else if (rule.getRcondition() == 2 && myShape.topIn) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];
				} else if (rule.getRcondition() == 3 && !myShape.topIn) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];
				}

			} else if (rule.getPosition() == 2 && myShape != null) {
				if (rule.getRcondition() == 1) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];
				} else if (rule.getRcondition() == 2 && myShape.botIn) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];

				} else if (rule.getRcondition() == 3 && !myShape.botIn) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];
				}

			} else if (rule.getPosition() == 3 && myShape != null) {
				mo = setCalcPrice(h, hi, h, hi, priceGroup, quantity,
						discountP, pricemarkup, costmarkup, price, cost,
						minprice, priceuom, costuom, pricemeasure,
						discountable, myFrame2, myFrame2.currentUOM, 0, true,
						true);

				if (rule.getRcondition() == 1) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];

				} else if (rule.getRcondition() == 2 && myShape.leftIn) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];

				} else if (rule.getRcondition() == 3 && !myShape.leftIn) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];
				}

			} else if (rule.getPosition() == 4 && myShape != null) {

				if (rule.getRcondition() == 1) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];

				} else if (rule.getRcondition() == 2 && myShape.rightIn) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];

				} else if (rule.getRcondition() == 3 && !myShape.rightIn) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];
				}
			} else if (rule.getPosition() == 5 && myShape != null) {
				mo = setCalcPrice(w, wi, w, wi, priceGroup, quantity,
						discountP, pricemarkup, costmarkup, price, cost,
						minprice, priceuom, costuom, pricemeasure,
						discountable, myFrame2, myFrame2.currentUOM, 0, true,
						true);
				if (rule.getRcondition() == 1) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];

					totalpricef = (BigDecimal) mo[0];
					totalcostf = (BigDecimal) mo[1];

				} else if (rule.getRcondition() == 2 && myShape.topIn) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];

				} else if (rule.getRcondition() == 3 && !myShape.topIn) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];
				}

				if (rule.getRcondition() == 2 && myShape.botIn) {

					totalpricef = (BigDecimal) mo[0];
					totalcostf = (BigDecimal) mo[1];

				} else if (rule.getRcondition() == 3 && !myShape.botIn) {

					totalpricef = (BigDecimal) mo[0];
					totalcostf = (BigDecimal) mo[1];
				}

				totalprice = totalprice.add(totalpricef);
				totalcost = totalcost.add(totalcostf);

			} else if (rule.getPosition() == 6 && myShape != null) {
				mo = setCalcPrice(h, hi, h, hi, priceGroup, quantity,
						discountP, pricemarkup, costmarkup, price, cost,
						minprice, priceuom, costuom, pricemeasure,
						discountable, myFrame2, myFrame2.currentUOM, 0, true,
						true);
				if (rule.getRcondition() == 1) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];

					totalpricef = (BigDecimal) mo[0];
					totalcostf = (BigDecimal) mo[1];

				} else if (rule.getRcondition() == 2 && myShape.leftIn) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];

				} else if (rule.getRcondition() == 3 && !myShape.leftIn) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];
				}

				if (rule.getRcondition() == 2 && myShape.rightIn) {

					totalpricef = (BigDecimal) mo[0];
					totalcostf = (BigDecimal) mo[1];

				} else if (rule.getRcondition() == 3 && !myShape.rightIn) {

					totalpricef = (BigDecimal) mo[0];
					totalcostf = (BigDecimal) mo[1];
				}

				totalprice = totalprice.add(totalpricef);
				totalcost = totalcost.add(totalcostf);

			} else if (rule.getPosition() == 7 && myShape != null) {
				mo = setCalcPrice(w, wi, w, wi, priceGroup, quantity,
						discountP, pricemarkup, costmarkup, price, cost,
						minprice, priceuom, costuom, pricemeasure,
						discountable, myFrame2, myFrame2.currentUOM, 0, true,
						true);
				if (rule.getRcondition() == 1) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];

					totalpricef = (BigDecimal) mo[0];
					totalcostf = (BigDecimal) mo[1];

				} else if (rule.getRcondition() == 2 && myShape.topIn) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];

				} else if (rule.getRcondition() == 3 && !myShape.topIn) {

					totalprice = (BigDecimal) mo[0];
					totalcost = (BigDecimal) mo[1];
				}

				if (rule.getRcondition() == 2 && myShape.botIn) {

					totalpricef = (BigDecimal) mo[0];
					totalcostf = (BigDecimal) mo[1];

				} else if (rule.getRcondition() == 3 && !myShape.botIn) {

					totalpricef = (BigDecimal) mo[0];
					totalcostf = (BigDecimal) mo[1];
				}

				totalprice = totalprice.add(totalpricef);
				totalcost = totalcost.add(totalcostf);

				BigDecimal totalpricelr = new BigDecimal(0);
				BigDecimal totalcostlr = new BigDecimal(0);
				BigDecimal totalpriceflr = new BigDecimal(0);
				BigDecimal totalcostflr = new BigDecimal(0);

				mo = setCalcPrice(h, hi, h, hi, priceGroup, quantity,
						discountP, pricemarkup, costmarkup, price, cost,
						minprice, priceuom, costuom, pricemeasure,
						discountable, myFrame2, myFrame2.currentUOM, 0, true,
						true);

				if (rule.getRcondition() == 1) {

					totalpricelr = (BigDecimal) mo[0];
					totalcostlr = (BigDecimal) mo[1];

					totalpriceflr = (BigDecimal) mo[0];
					totalcostflr = (BigDecimal) mo[1];

				} else if (rule.getRcondition() == 2 && myShape.leftIn) {

					totalpricelr = (BigDecimal) mo[0];
					totalcostlr = (BigDecimal) mo[1];

				} else if (rule.getRcondition() == 3 && !myShape.leftIn) {

					totalpricelr = (BigDecimal) mo[0];
					totalcostlr = (BigDecimal) mo[1];
				}

				if (rule.getRcondition() == 2 && myShape.rightIn) {

					totalpriceflr = (BigDecimal) mo[0];
					totalcostflr = (BigDecimal) mo[1];

				} else if (rule.getRcondition() == 3 && !myShape.rightIn) {

					totalpriceflr = (BigDecimal) mo[0];
					totalcostflr = (BigDecimal) mo[1];
				}

				totalpricelr = totalpricelr.add(totalpriceflr);
				totalcostlr = totalcostlr.add(totalcostflr);

				totalprice = totalprice.add(totalpricelr);
				totalcost = totalcost.add(totalcostlr);

			} else if (rule.getPosition() == 8 && myMullionCoupler != null) {

				mo = setCalcPrice(l, li, l, li, priceGroup, quantity,
						discountP, pricemarkup, costmarkup, price, cost,
						minprice, priceuom, costuom, pricemeasure,
						discountable, myFrame2, myFrame2.currentUOM, 0, true,
						true);

				totalprice = (BigDecimal) mo[0];
				totalcost = (BigDecimal) mo[1];

			} else if (rule.getPosition() == 9 && myMullionCoupler != null) {

				mo = setCalcPrice(l, li, l, li, priceGroup, quantity,
						discountP, pricemarkup, costmarkup, price, cost,
						minprice, priceuom, costuom, pricemeasure,
						discountable, myFrame2, myFrame2.currentUOM, 0, true,
						true);

				totalprice = (BigDecimal) mo[0];
				totalcost = (BigDecimal) mo[1];

			} else if (rule.getPosition() == 11
					&& (myShape != null || (myItem != null
							&& myItem.getWidth() > 0 && myItem.getHeight() > 0))) {

				double sizem = w * h;
				double sizei = wi * hi;

				mo = setCalcPrice(sizem, sizei, sizem, sizei, priceGroup,
						quantity, discountP, pricemarkup, costmarkup, price,
						cost, minprice, priceuom, costuom, pricemeasure,
						discountable, myFrame2, myFrame2.currentUOM, 0, true,
						true);
				totalprice = (BigDecimal) mo[0];
				totalcost = (BigDecimal) mo[1];

			} else if (rule.getPosition() == 12
					&& (myShape != null || (myItem != null
							&& myItem.getWidth() > 0 && myItem.getHeight() > 0))) {

				double sizem = w + h;
				double sizei = wi + hi;

				mo = setCalcPrice(sizem, sizei, sizem, sizei, priceGroup,
						quantity, discountP, pricemarkup, costmarkup, price,
						cost, minprice, priceuom, costuom, pricemeasure,
						discountable, myFrame2, myFrame2.currentUOM, 0, true,
						true);
				totalprice = (BigDecimal) mo[0];
				totalcost = (BigDecimal) mo[1];

			} else if (rule.getPosition() == 18 && myShape != null) {

				mo = setCalcPrice(w, wi, w, wi, priceGroup, quantity,
						discountP, pricemarkup, costmarkup, price, cost,
						minprice, priceuom, costuom, pricemeasure,
						discountable, myFrame2, myFrame2.currentUOM, 0, true,
						true);

				totalprice = new BigDecimal(mo[0].toString())
						.multiply(new BigDecimal(myShape.noSides));
				totalcost = new BigDecimal(mo[1].toString())
						.multiply(new BigDecimal(myShape.noSides));

			} else if (rule.getPosition() == 19 && myShape != null) {

				mo = setCalcPrice(w, wi, w, wi, priceGroup, quantity,
						discountP, pricemarkup, costmarkup, price, cost,
						minprice, priceuom, costuom, pricemeasure,
						discountable, myFrame2, myFrame2.currentUOM, 0, true,
						true);

				totalprice = new BigDecimal(mo[0].toString())
						.multiply(new BigDecimal(
								((DLO) myShape).noIntersect4ways));
				totalcost = new BigDecimal(mo[1].toString())
						.multiply(new BigDecimal(
								((DLO) myShape).noIntersect4ways));

			} else if (rule.getPosition() == 20 && myShape != null) {

				mo = setCalcPrice(w, wi, w, wi, priceGroup, quantity,
						discountP, pricemarkup, costmarkup, price, cost,
						minprice, priceuom, costuom, pricemeasure,
						discountable, myFrame2, myFrame2.currentUOM, 0, true,
						true);

				totalprice = new BigDecimal(mo[0].toString())
						.multiply(new BigDecimal(
								((DLO) myShape).noIntersect3ways
										+ ((DLO) myShape).noIntersect2ways));
				totalcost = new BigDecimal(mo[1].toString())
						.multiply(new BigDecimal(
								((DLO) myShape).noIntersect3ways
										+ ((DLO) myShape).noIntersect2ways));

			} else if (rule.getPosition() == 21 && myShape != null) {

				mo = setCalcPrice(w, wi, w, wi, priceGroup, quantity,
						discountP, pricemarkup, costmarkup, price, cost,
						minprice, priceuom, costuom, pricemeasure,
						discountable, myFrame2, myFrame2.currentUOM, 0, true,
						true);

				totalprice = new BigDecimal(mo[0].toString())
						.multiply(new BigDecimal(((DLO) myShape).liteW
								* ((DLO) myShape).liteH));

				totalcost = new BigDecimal(mo[0].toString())
						.multiply(new BigDecimal(((DLO) myShape).liteW
								* ((DLO) myShape).liteH));

			} else if (rule.getPosition() == 22
					&& (myItem != null && (myItem.getSize() > 0 || myItem
							.getSizeI() > 0))) {

				mo = setCalcPrice(l, li, l, li, priceGroup, quantity,
						discountP, pricemarkup, costmarkup, price, cost,
						minprice, priceuom, costuom, pricemeasure,
						discountable, myFrame2, myFrame2.currentUOM, 0, true,
						true);

				totalprice = (BigDecimal) mo[0];
				totalcost = (BigDecimal) mo[1];

			} else if (rule.getPosition() == 23
					&& (myItem != null && (myItem.getWidth() > 0 || myItem
							.getWidthI() > 0))) {

				mo = setCalcPrice(w, wi, w, wi, priceGroup, quantity,
						discountP, pricemarkup, costmarkup, price, cost,
						minprice, priceuom, costuom, pricemeasure,
						discountable, myFrame2, myFrame2.currentUOM, 0, true,
						true);

				totalprice = (BigDecimal) mo[0];
				totalcost = (BigDecimal) mo[1];

			} else if (rule.getPosition() == 24
					&& (myItem != null && (myItem.getHeight() > 0 || myItem
							.getHeightI() > 0))) {

				mo = setCalcPrice(h, hi, h, hi, priceGroup, quantity,
						discountP, pricemarkup, costmarkup, price, cost,
						minprice, priceuom, costuom, pricemeasure,
						discountable, myFrame2, myFrame2.currentUOM, 0, true,
						true);

				totalprice = (BigDecimal) mo[0];
				totalcost = (BigDecimal) mo[1];

			} else if (rule.getPosition() == 25
					&& (myItem != null && (myItem.getDepth() > 0 || myItem
							.getDepthI() > 0))) {

				mo = setCalcPrice(d, di, d, di, priceGroup, quantity,
						discountP, pricemarkup, costmarkup, price, cost,
						minprice, priceuom, costuom, pricemeasure,
						discountable, myFrame2, myFrame2.currentUOM, 0, true,
						true);

				totalprice = (BigDecimal) mo[0];
				totalcost = (BigDecimal) mo[1];

			}

		}

		Object[] res = new Object[3];

		res[0] = totalprice;
		res[1] = totalcost;
		res[2] = discountP;

		return res;
	}

	private void insertShapeOption(ShapeObject shape, int optionid, int ruleno) {

		Object[] shapeops = shape.options.toArray();
		shape.options.clear();

		boolean exist = false;
		ShapeOption myO = null;

		for (Object op : shapeops) {
			if (((ShapeOption) op).optionid == optionid) {
				((ShapeOption) op).ruleno = ruleno;
			}
			shape.options.add((ShapeOption) op);
		}

	}

	private ShapeOption setShapeOption(OptionDefinitions myOption,
			OptionAnswers myAnswer, int w, int h, int wi, int hi, Rules rule,
			ShapeOption myShapeOption, Object[] priceCost)
			throws NumberFormatException, Exception {

		if (myShape != null) {
			myShapeOption.a_levelID = myShape.a_levelID;
			myShapeOption.a_sequenceID = myShape.a_sequenceID;
			myShapeOption.a_assemblyLevel = myShape.a_assemblyLevel;
			myShapeOption.a_1Level = myShape.a_1Level;
			myShapeOption.a_1Sequence = myShape.a_1Sequence;
			myShapeOption.a_2Level = myShape.a_2Level;
			myShapeOption.a_2Sequence = myShape.a_2Sequence;
			myShapeOption.a_3Level = myShape.a_3Level;
			myShapeOption.a_3Sequence = myShape.a_3Sequence;
			myShapeOption.a_4Level = myShape.a_4Level;
			myShapeOption.a_4Sequence = myShape.a_4Sequence;
			myShapeOption.a_5Level = myShape.a_5Level;
			myShapeOption.a_5Sequence = myShape.a_5Sequence;
			myShapeOption.a_6Level = myShape.a_6Level;
			myShapeOption.a_6Sequence = myShape.a_6Sequence;
			myShapeOption.a_7Level = myShape.a_7Level;
			myShapeOption.a_7Sequence = myShape.a_7Sequence;
			myShapeOption.a_8Level = myShape.a_8Level;
			myShapeOption.a_8Sequence = myShape.a_8Sequence;
			myShapeOption.a_9Level = myShape.a_9Level;
			myShapeOption.a_9Sequence = myShape.a_9Sequence;
			myShapeOption.a_10Level = myShape.a_10Level;
			myShapeOption.a_10Sequence = myShape.a_10Sequence;
		} else if (this.myMullionCoupler != null) {
			myShapeOption.a_levelID = myMullionCoupler.levelID;
			myShapeOption.a_sequenceID = myMullionCoupler.rowCol;
			myShapeOption.a_assemblyLevel = myMullionCoupler.a_assemblyLevel;
			myShapeOption.a_1Level = myMullionCoupler.a_1Level;
			myShapeOption.a_1Sequence = myMullionCoupler.a_1Sequence;
			myShapeOption.a_2Level = myMullionCoupler.a_2Level;
			myShapeOption.a_2Sequence = myMullionCoupler.a_2Sequence;
			myShapeOption.a_3Level = myMullionCoupler.a_3Level;
			myShapeOption.a_3Sequence = myMullionCoupler.a_3Sequence;
			myShapeOption.a_4Level = myMullionCoupler.a_4Level;
			myShapeOption.a_4Sequence = myMullionCoupler.a_4Sequence;
			myShapeOption.a_5Level = myMullionCoupler.a_5Level;
			myShapeOption.a_5Sequence = myMullionCoupler.a_5Sequence;
			myShapeOption.a_6Level = myMullionCoupler.a_6Level;
			myShapeOption.a_6Sequence = myMullionCoupler.a_6Sequence;
			myShapeOption.a_7Level = myMullionCoupler.a_7Level;
			myShapeOption.a_7Sequence = myMullionCoupler.a_7Sequence;
			myShapeOption.a_8Level = myMullionCoupler.a_8Level;
			myShapeOption.a_8Sequence = myMullionCoupler.a_8Sequence;
			myShapeOption.a_9Level = myMullionCoupler.a_9Level;
			myShapeOption.a_9Sequence = myMullionCoupler.a_9Sequence;
			myShapeOption.a_10Level = myMullionCoupler.a_10Level;
			myShapeOption.a_10Sequence = myMullionCoupler.a_10Sequence;
		}

		myShapeOption.optionid = myOption.getId();

		if (myOption.getOptiontypeid() <= 2) {
			myShapeOption.answerid = myAnswer.getId().getId();
		} else {
			myShapeOption.answerid = 0;
		}

		myShapeOption.myoption = myOption;

		if (myOption.getOptiontypeid() <= 2) {
			myShapeOption.myanswer = myAnswer;

		} else if (myOption.getOptiontypeid() == 3) {

			myShapeOption.qtyanswer = Double.parseDouble(rule.getRulevalue2());
			myShapeOption.sizeanswer = 0;
			myShapeOption.sizeansweri = 0;
			myShapeOption.depthanswer = 0;
			myShapeOption.depthansweri = 0;
			myShapeOption.adjust = 0;
			myShapeOption.adjusti = 0;
			myShapeOption.textAnswer = " ";

		} else if (myOption.getOptiontypeid() == 4) {
			myShapeOption.qtyanswer = 0;
			if (myFrame2.currentUOM == 1) {
				myShapeOption.sizeanswer = Integer.parseInt(rule
						.getRulevalue2());
				myShapeOption.sizeansweri = Integer
						.parseInt(UOMConvert.metricToImperial(Integer
								.parseInt(rule.getRulevalue2()) / 100 + "")) * 64;
			} else {
				myShapeOption.sizeansweri = Integer.parseInt(rule
						.getRulevalue2());
				myShapeOption.sizeanswer = Integer
						.parseInt(UOMConvert.imperialTometric(Integer
								.parseInt(rule.getRulevalue2()) / 64 + "")) * 100;
			}

			myShapeOption.depthanswer = 0;
			myShapeOption.depthansweri = 0;
			myShapeOption.adjust = 0;
			myShapeOption.adjusti = 0;
			myShapeOption.textAnswer = " ";
		}
		if (myOption.getOptiontypeid() == 5) {
			myShapeOption.qtyanswer = 0;
			myShapeOption.sizeanswer = 0;
			myShapeOption.sizeansweri = 0;

			if (myFrame2.currentUOM == 1) {
				myShapeOption.depthanswer = Integer.parseInt(rule
						.getRulevalue2());
				myShapeOption.depthansweri = Integer
						.parseInt(UOMConvert.metricToImperial(Integer
								.parseInt(rule.getRulevalue2()) / 100 + "")) * 64;
			} else {
				myShapeOption.depthansweri = Integer.parseInt(rule
						.getRulevalue2());
				myShapeOption.depthanswer = Integer
						.parseInt(UOMConvert.imperialTometric(Integer
								.parseInt(rule.getRulevalue2()) / 64 + "")) * 100;
			}

			myShapeOption.adjust = 0;
			myShapeOption.adjusti = 0;
			myShapeOption.textAnswer = " ";
		}
		if (myOption.getOptiontypeid() == 6) {
			myShapeOption.qtyanswer = 0;
			myShapeOption.sizeanswer = 0;
			myShapeOption.sizeansweri = 0;
			myShapeOption.depthanswer = 0;
			myShapeOption.depthansweri = 0;
			myShapeOption.adjust = 0;
			myShapeOption.adjusti = 0;
			myShapeOption.textAnswer = rule.getRulevalue2();
		}
		if (myOption.getOptiontypeid() == 7) {
			myShapeOption.qtyanswer = 0;
			myShapeOption.sizeanswer = 0;
			myShapeOption.sizeansweri = 0;
			myShapeOption.depthanswer = 0;
			myShapeOption.depthansweri = 0;
			if (myFrame2.currentUOM == 1) {
				myShapeOption.adjust = Integer.parseInt(rule.getRulevalue2());
				myShapeOption.adjusti = Integer
						.parseInt(UOMConvert.metricToImperial(Integer
								.parseInt(rule.getRulevalue2()) / 100 + "")) * 64;
			} else {
				myShapeOption.adjusti = Integer.parseInt(rule.getRulevalue2());
				myShapeOption.adjust = Integer
						.parseInt(UOMConvert.imperialTometric(Integer
								.parseInt(rule.getRulevalue2()) / 64 + "")) * 100;

			}
			myShapeOption.textAnswer = " ";
		}

		myShapeOption.rgb_R = myAnswer.getRgb_R();
		myShapeOption.rgb_G = myAnswer.getRgb_G();
		myShapeOption.rgb_B = myAnswer.getRgb_B();

		myShapeOption.price = myAnswer.getPrice();
		myShapeOption.discountP = (Double) priceCost[2];
		myShapeOption.priceUser = myAnswer.getPrice();
		myShapeOption.cost = myAnswer.getCost();

		myShapeOption.w = w;
		myShapeOption.h = h;
		myShapeOption.wi = wi;
		myShapeOption.hi = hi;

		myShapeOption.d = 0;
		myShapeOption.di = 0;

		myShapeOption.li = 0;
		myShapeOption.li = 0;

		myShapeOption.priceuom = myAnswer.getPricing_uom_id();
		myShapeOption.costuom = myAnswer.getCosting_uom_id();
		myShapeOption.pricemeasure = myAnswer.getPriceMeasure();

		myShapeOption.priceTotal = (BigDecimal) priceCost[0];
		myShapeOption.priceTotalUser = (BigDecimal) priceCost[0];
		myShapeOption.costTotal = (BigDecimal) priceCost[1];

		myShapeOption.seriesid = series.getId();

		myShapeOption.optionsAllowedAnswers.addAll(myOptionAnswers);

		myShapeOption.ruleno = rule.getRulesPK().getId();
		myShapeOption.supplierId = rule.getSupplierId();
		myShapeOption.seriesid = rule.getRulesPK().getSeriesId();
		myShapeOption.supplierSeriesId = rule.getRulesPK().getSeriesId();
		myShapeOption.remote = rule.isRemote();

		if (rule.getRuletype() == 2) {
			myShapeOption.isAuto = true;
		} else {
			myShapeOption.isAuto = false;
		}

		return myShapeOption;
	}

	private Collection updateOptionCollection(Collection<ShapeOption> options,
			int optionid, int ruleno, boolean remove) {

		Object[] shapeops = options.toArray();

		options.clear();

		boolean exist = false;

		for (Object op : shapeops) {
			if (!remove) {
				if (((ShapeOption) op).optionid == optionid
						&& ((ShapeOption) op).ruleno == ruleno) {
					((ShapeOption) op).ruleno = ruleno;
					options.add((ShapeOption) op);

					addToDesignOptionAll((ShapeOption) op);

					break;

				}

			}

		}

		return options;
	}

	private DesignOption setDesignOptions(DesignOption designOption,
			ShapeOption shapeOption) {

		designOption.a_levelID = shapeOption.a_levelID;
		designOption.a_sequenceID = shapeOption.a_sequenceID;
		designOption.a_assemblyLevel = shapeOption.a_assemblyLevel;
		designOption.a_1Level = shapeOption.a_1Level;
		designOption.a_1Sequence = shapeOption.a_1Sequence;
		designOption.a_2Level = shapeOption.a_2Level;
		designOption.a_2Sequence = shapeOption.a_2Sequence;
		designOption.a_3Level = shapeOption.a_3Level;
		designOption.a_3Sequence = shapeOption.a_3Sequence;
		designOption.a_4Level = shapeOption.a_4Level;
		designOption.a_4Sequence = shapeOption.a_4Sequence;
		designOption.a_5Level = shapeOption.a_5Level;
		designOption.a_5Sequence = shapeOption.a_5Sequence;
		designOption.a_6Level = shapeOption.a_6Level;
		designOption.a_6Sequence = shapeOption.a_6Sequence;
		designOption.a_7Level = shapeOption.a_7Level;
		designOption.a_7Sequence = shapeOption.a_7Sequence;
		designOption.a_8Level = shapeOption.a_8Level;
		designOption.a_8Sequence = shapeOption.a_8Sequence;
		designOption.a_9Level = shapeOption.a_9Level;
		designOption.a_9Sequence = shapeOption.a_9Sequence;
		designOption.a_10Level = shapeOption.a_10Level;
		designOption.a_10Sequence = shapeOption.a_10Sequence;
		designOption.a_11Level = shapeOption.a_11Level;
		designOption.a_11Sequence = shapeOption.a_11Sequence;
		designOption.a_12Level = shapeOption.a_12Level;
		designOption.a_12Sequence = shapeOption.a_12Sequence;
		designOption.a_13Level = shapeOption.a_13Level;
		designOption.a_13Sequence = shapeOption.a_13Sequence;
		designOption.a_14Level = shapeOption.a_14Level;
		designOption.a_14Sequence = shapeOption.a_14Sequence;
		designOption.a_15Level = shapeOption.a_15Level;
		designOption.a_15Sequence = shapeOption.a_15Sequence;
		designOption.a_16Level = shapeOption.a_16Level;
		designOption.a_16Sequence = shapeOption.a_16Sequence;
		designOption.a_17Level = shapeOption.a_17Level;
		designOption.a_17Sequence = shapeOption.a_17Sequence;
		designOption.a_18Level = shapeOption.a_18Level;
		designOption.a_18Sequence = shapeOption.a_18Sequence;
		designOption.a_19Level = shapeOption.a_19Level;
		designOption.a_19Sequence = shapeOption.a_19Sequence;
		designOption.a_20Level = shapeOption.a_20Level;
		designOption.a_20Sequence = shapeOption.a_20Sequence;
		designOption.a_21Level = shapeOption.a_21Level;
		designOption.a_21Sequence = shapeOption.a_21Sequence;
		designOption.a_22Level = shapeOption.a_22Level;
		designOption.a_22Sequence = shapeOption.a_22Sequence;

		designOption.optionid = shapeOption.optionid;
		designOption.answerid = shapeOption.answerid;
		designOption.myoption = shapeOption.myoption;
		designOption.myanswer = shapeOption.myanswer;
		designOption.qtyanswer = shapeOption.qtyanswer;
		designOption.sizeanswer = shapeOption.sizeanswer;
		designOption.sizeansweri = shapeOption.sizeansweri;
		designOption.depthanswer = shapeOption.depthanswer;
		designOption.depthansweri = shapeOption.depthansweri;
		designOption.adjust = shapeOption.adjust;
		designOption.adjusti = shapeOption.adjusti;
		designOption.textAnswer = shapeOption.textAnswer;
		designOption.rgb_R = shapeOption.rgb_R;
		designOption.rgb_G = shapeOption.rgb_G;
		designOption.rgb_B = shapeOption.rgb_B;
		designOption.price = shapeOption.price;
		designOption.discountP = shapeOption.discountP;
		designOption.priceUser = shapeOption.priceUser;
		designOption.cost = shapeOption.cost;
		designOption.w = shapeOption.w;
		designOption.h = shapeOption.h;
		designOption.wi = shapeOption.wi;
		designOption.hi = shapeOption.hi;
		designOption.d = shapeOption.d;
		designOption.di = shapeOption.di;
		designOption.l = shapeOption.l;
		designOption.li = shapeOption.li;
		designOption.priceuom = shapeOption.priceuom;
		designOption.costuom = shapeOption.costuom;
		designOption.pricemeasure = shapeOption.pricemeasure;
		designOption.priceTotal = shapeOption.priceTotal;
		designOption.priceTotalUser = shapeOption.priceTotalUser;
		designOption.costTotal = shapeOption.costTotal;
		designOption.seriesid = shapeOption.seriesid;
		designOption.ruleno = shapeOption.ruleno;
		designOption.optionsAllowedAnswers.addAll(myOptionAnswers);

		designOption.isAuto = shapeOption.isAuto;
		designOption.global = shapeOption.global;

		designOption.seriesid = shapeOption.seriesid;
		designOption.supplierID = shapeOption.supplierId;
		designOption.supplierSeriesID = shapeOption.supplierSeriesId;
		designOption.remote = shapeOption.remote;

		return designOption;
	}

	private ShapeOption setShapeOptionsFromDesignOptions(
			DesignOption designOption, ShapeOption shapeOption) {

		shapeOption.a_levelID = designOption.a_levelID;
		shapeOption.a_sequenceID = designOption.a_sequenceID;
		shapeOption.a_assemblyLevel = designOption.a_assemblyLevel;
		shapeOption.a_1Level = designOption.a_1Level;
		shapeOption.a_1Sequence = designOption.a_1Sequence;
		shapeOption.a_2Level = designOption.a_2Level;
		shapeOption.a_2Sequence = designOption.a_2Sequence;
		shapeOption.a_3Level = designOption.a_3Level;
		shapeOption.a_3Sequence = designOption.a_3Sequence;
		shapeOption.a_4Level = designOption.a_4Level;
		shapeOption.a_4Sequence = designOption.a_4Sequence;
		shapeOption.a_5Level = designOption.a_5Level;
		shapeOption.a_5Sequence = designOption.a_5Sequence;
		shapeOption.a_6Level = designOption.a_6Level;
		shapeOption.a_6Sequence = designOption.a_6Sequence;
		shapeOption.a_7Level = designOption.a_7Level;
		shapeOption.a_7Sequence = designOption.a_7Sequence;
		shapeOption.a_8Level = designOption.a_8Level;
		shapeOption.a_8Sequence = designOption.a_8Sequence;
		shapeOption.a_9Level = designOption.a_9Level;
		shapeOption.a_9Sequence = designOption.a_9Sequence;
		shapeOption.a_10Level = designOption.a_10Level;
		shapeOption.a_10Sequence = designOption.a_10Sequence;

		shapeOption.optionid = designOption.optionid;
		shapeOption.answerid = designOption.answerid;
		shapeOption.myoption = designOption.myoption;
		shapeOption.myanswer = designOption.myanswer;
		shapeOption.qtyanswer = designOption.qtyanswer;
		shapeOption.sizeanswer = designOption.sizeanswer;
		shapeOption.sizeansweri = designOption.sizeansweri;
		shapeOption.depthanswer = designOption.depthanswer;
		shapeOption.depthansweri = designOption.depthansweri;
		shapeOption.adjust = designOption.adjust;
		shapeOption.adjusti = designOption.adjusti;
		shapeOption.textAnswer = designOption.textAnswer;
		shapeOption.rgb_R = designOption.rgb_R;
		shapeOption.rgb_G = designOption.rgb_G;
		shapeOption.rgb_B = designOption.rgb_B;
		shapeOption.price = designOption.price;

		shapeOption.discountP = designOption.discountP;
		shapeOption.priceUser = designOption.priceUser;

		shapeOption.cost = designOption.cost;
		shapeOption.w = designOption.w;
		shapeOption.h = designOption.h;
		shapeOption.wi = designOption.wi;
		shapeOption.hi = designOption.hi;
		shapeOption.d = designOption.d;
		shapeOption.di = designOption.di;
		shapeOption.l = designOption.l;
		shapeOption.li = designOption.li;

		shapeOption.priceuom = designOption.priceuom;
		shapeOption.costuom = designOption.costuom;
		shapeOption.pricemeasure = designOption.pricemeasure;
		shapeOption.priceTotal = designOption.priceTotal;
		shapeOption.priceTotalUser = designOption.priceTotalUser;
		shapeOption.costTotal = designOption.costTotal;
		shapeOption.seriesid = designOption.seriesid;
		shapeOption.ruleno = designOption.ruleno;
		shapeOption.optionsAllowedAnswers
				.addAll(designOption.optionsAllowedAnswers);

		shapeOption.isAuto = designOption.isAuto;
		shapeOption.global = designOption.global;

		shapeOption.seriesid = designOption.seriesid;
		shapeOption.supplierSeriesId = designOption.supplierSeriesID;
		shapeOption.remote = designOption.remote;

		return shapeOption;
	}

	public void addToDesignOptionAll(ShapeOption myShapeOption) {

		DesignOption designOption = new DesignOption();
		setDesignOptions(designOption, myShapeOption);
		myFrame2.designOptionsAll.add(designOption);

	}

}
