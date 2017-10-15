package Rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import openjanela.app.configuration.controller.calculation.MatrixController;
import openjanela.model.entities.partner.RuleAnswers;
import openjanela.model.entities.partner.RuleTest;
import openjanela.model.entities.partner.RuleTestValue;
import openjanela.model.entities.partner.Rules;
import openjanela.model.entities.partner.RulesComparator;
import openjanela.model.entities.parts.Parts;
import Model.OrderItemsCart;
import Model.ShapeObject;
import Model.ProfileParts.Profiles;
import Presentation.ItemFrame;

public class ExecuteClearanceRules extends ExecuteOptionRules {

	public ExecuteClearanceRules(ItemFrame myframe) {

		super(myframe);
		// TODO Auto-generated constructor stub
	}

	// @Override
	public Object[] executeClearanceRules(ShapeObject shape, OrderItemsCart item, Profiles mullion) {

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

		myUOM = myFrame2.currentUOM;

		if (myFrame2.currentUOM == 1) {
			myScale = myFrame2.metricscale;
		} else {
			myScale = myFrame2.imperialscale;
		}

		/**
		 * Set Object to pre-defined Object in order to use its properties
		 */

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

		if (myMullionCoupler != null && (myMullionCoupler.a_assemblyLevel >= 30 &&
                myMullionCoupler.a_assemblyLevel <= 32)) { // Coupler

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

		this.currentRules = getClearanceRules(ItemFrame.getApplicationBaseRules().getRules(this.mainFrame.seriesID));

		// resetShapeOptionsFromDesignOptionsAll();

		Object[] clearances = new Object[8];
		clearances[0] = 0;
		clearances[1] = 0;
		clearances[2] = 0;
		clearances[3] = 0;
		clearances[4] = 0;
		clearances[5] = 0;
		clearances[6] = 0;
		clearances[7] = 0;

		try {
			clearances = executeCurrentClearanceRules(
					this.currentRules,
					ItemFrame.getApplicationBaseRules().getRuleTest(
							this.mainFrame.seriesID), ItemFrame
							.getApplicationBaseRules().getRuleAnswers(), null,
					this.mainFrame.seriesID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clearances;
	}

	private List<Rules> getClearanceRules(List<Rules> rules) {

		// getRuletype() == 9
		List<Rules> mainRules = new ArrayList();
		
		for (Rules rule : rules) {
			
			if (isCorrectAssemblyLevel(rule) && (rule.getRuletype() == 4 || rule.getRuletype() == 5)) {
				mainRules.add(rule);
				
			} else if (isCorrectAssemblyLevel(rule) && rule.getRuletype() == 9) {

				boolean passLocalTest = filterArraysAndTest(rule, ItemFrame.getApplicationBaseRules().getRuleAnswers(),
                        ItemFrame.getApplicationBaseRules().getRuleTest(this.mainFrame.seriesID), this.mainFrame.seriesID);

				if (passLocalTest) {

					List<Rules> ruleList = new ArrayList<Rules>();

                    if (rule.isRemote()) {
                        ruleList = getClearanceRules(ItemFrame.getApplicationRemoteBaseRules().getRules(rule.getSupplierId(), rule.getRulevalue()));
                    } else {
                        ruleList = getClearanceRules(ItemFrame.getApplicationBaseRules().getRules(rule.getRulevalue()));
                    }

					for (Rules r : ruleList) {

						if ((r.getRuletype() == 4 || r.getRuletype() == 5) &&
                                filterArraysAndTest(r, subParentRulesAnswers, subParentTests, rule.getRulevalue())) {

							mainRules.add(r);

						}
					}
				}
			}
		}

		return mainRules;
	}

	public List<Rules> getAllClearanceRules(List<Rules> rules) {

		List<Rules> mainRules = new ArrayList();
		for (Rules rule : rules) {
			if (rule.getRuletype() > 3)
				mainRules.add(rule);
		}

		Collections.sort(mainRules, RulesComparator.RULE_ID);

		return mainRules;
	}

	public Object[] executeCurrentClearanceRules(List<Rules> rules, List<RuleTest> rtests, List<RuleAnswers> ranswers,
			Rules parentRule, int series) throws Exception {

		boolean passLocalTest = false;

		int clearanceTop = 0;
		int clearanceTopi = 0;
		int clearanceBot = 0;
		int clearanceBoti = 0;
		int clearanceLeft = 0;
		int clearanceLefti = 0;
		int clearanceRight = 0;
		int clearanceRighti = 0;

		Object[] clearances = new Object[8];

		Object[] res = new Object[2];

		for (Rules rule : rules) {

			/**
			 * 
			 * by rule type
			 * 
			 */

            if (rule.isRemote()) {
                ranswers = ItemFrame.getApplicationRemoteBaseRules().getRuleAnswers(rule.getSupplierId());
                rtests = ItemFrame.getApplicationRemoteBaseRules().getRuleTest(rule.getSupplierId(), rule.getRulesPK().getSeriesId());
            } else {
                rtests = ItemFrame.getApplicationBaseRules().getRuleTest(rule.getRulesPK().getSeriesId());
            }

			passLocalTest = filterArraysAndTest(rule, ranswers, rtests, rule.getRulesPK().getSeriesId());

			if (passLocalTest) {

				// if (rule.getRuletype() == 9) // Rule Segment
				// {
				//
				// int mseries = rule.getRulevalue();
				// if (mseries == 12) {
				// part = new Parts();
				// }
				//
				// this.subParentTests = rtests;
				// this.subParentRulesAnswers = ranswers;
				//
				// this.myParentRule = rule;
				// this.parentRuleID = rule.getRulesPK().getId();
				//
				// List<Rules> ruleList = new ArrayList<Rules>();
				//
				//
				// ruleList = getClearanceRules(ItemFrame
				// .getApplicationBaseRules().getRules(mseries));
				//
				// for (Rules r : ruleList) {
				//
				// if (filterArraysAndTest(r, subParentRulesAnswers,
				// subParentTests, mseries)) {
				//
				// List<Rules> ml = new ArrayList<Rules>();
				// ml.add(r);
				//
				// executeCurrentClearanceRules(
				// ml,
				// ItemFrame.getApplicationBaseRules().getRuleTest(
				// mseries), ItemFrame
				// .getApplicationBaseRules().getRuleAnswers(), null,
				// mseries);
				//
				//
				//
				//
				// }
				// }
				//
				// } else {

				if (rule.getPosition() == 1 || rule.getPosition() == 7
						|| rule.getPosition() == 5 && myShape != null) // Top
				{
					res = getTopClearances(rule);

					if ((Integer) res[0] != 0) {
						clearanceTop = (Integer) res[0];
					}
					if ((Integer) res[1] != 0) {
						clearanceTopi = (Integer) res[1];
					}

				}
				if (rule.getPosition() == 2 || rule.getPosition() == 7
						|| rule.getPosition() == 5 && myShape != null) // Bottom
				{
					res = getBottomClearances(rule);

					if ((Integer) res[0] != 0) {
						clearanceBot = (Integer) res[0];
					}
					if ((Integer) res[1] != 0) {
						clearanceBoti = (Integer) res[1];
					}

				}
				if (rule.getPosition() == 3 || rule.getPosition() == 6
						|| rule.getPosition() == 7 && myShape != null) // Left
				{
					res = getLeftClearances(rule);

					if ((Integer) res[0] != 0) {
						clearanceLeft = (Integer) res[0];
					}
					if ((Integer) res[1] != 0) {
						clearanceLefti = (Integer) res[1];
					}

				}
				if (rule.getPosition() == 4 || rule.getPosition() == 6
						|| rule.getPosition() == 7 && myShape != null) {
					res = getRightClearances(rule);

					if ((Integer) res[0] != 0) {
						clearanceRight = (Integer) res[0];
					}
					if ((Integer) res[1] != 0) {
						clearanceRighti = (Integer) res[1];
					}

				}
			}
		}

		clearances[0] = clearanceTop;
		clearances[1] = clearanceTopi;
		clearances[2] = clearanceBot;
		clearances[3] = clearanceBoti;
		clearances[4] = clearanceLeft;
		clearances[5] = clearanceLefti;
		clearances[6] = clearanceRight;
		clearances[7] = clearanceRighti;

		return clearances;
	}

	public Object[] getRightClearances(Rules rule) throws Exception {

		MatrixController matrixController = new MatrixController(myShape, this.myFrame2);

		Object[] clearances = new Object[2];
		clearances[0] = 0;
		clearances[1] = 0;
		if (rule.getRcondition() == 1) // None
		{

			if (rule.getRuletype() == 4) {
				clearances[0] = rule.getRulevalue();
				clearances[1] = rule.getRulevaluei();
			} else {
				clearances[0] = (int) ((matrixController.getValueFromMatrix(
						Integer.valueOf(rule.getRulevalue()), rule.getSupplierId(), false, false, rule.isRemote()))
						.doubleValue());

				clearances[1] = (int) ((matrixController.getValueFromMatrix(
						Integer.valueOf(rule.getRulevalue()), rule.getSupplierId(), false, false, rule.isRemote()))
						.doubleValue());
			}

		} else if (rule.getRcondition() == 2 && myShape.rightIn) // IN
		{

			if (rule.getRuletype() == 4) {
				clearances[0] = rule.getRulevalue();
				clearances[1] = rule.getRulevaluei();
			} else {
				clearances[0] = (int) ((matrixController.getValueFromMatrix(
						rule.getRulevalue(), rule.getSupplierId(), false, false, rule.isRemote())).doubleValue());

				clearances[1] = (int) ((matrixController.getValueFromMatrix(
						rule.getRulevalue(), rule.getSupplierId(), false, false, rule.isRemote())).doubleValue());
			}

		} else if (rule.getRcondition() == 3 && !myShape.rightIn) {

			if (rule.getRuletype() == 4) {
				clearances[0] = rule.getRulevalue();
				clearances[1] = rule.getRulevaluei();
			} else {
				clearances[0] = (int) ((matrixController.getValueFromMatrix(
						rule.getRulevalue(), rule.getSupplierId(), false, false, rule.isRemote())).doubleValue());

				clearances[1] = (int) ((matrixController.getValueFromMatrix(
						rule.getRulevalue(), rule.getSupplierId(), false, false, rule.isRemote())).doubleValue());
			}

		}

		return clearances;
	}

	public Object[] getLeftClearances(Rules rule) throws Exception {

		MatrixController matrixController = new MatrixController(myShape, this.myFrame2);

		Object[] clearances = new Object[2];
		clearances[0] = 0;
		clearances[1] = 0;
		if (rule.getRcondition() == 1) // None
		{

			if (rule.getRuletype() == 4) {
				clearances[0] = rule.getRulevalue();
				clearances[1] = rule.getRulevaluei();
			} else {
				clearances[0] = (int) ((matrixController.getValueFromMatrix(
						rule.getRulevalue(), rule.getSupplierId(), false, false, rule.isRemote())).doubleValue());

				clearances[1] = (int) ((matrixController.getValueFromMatrix(
						rule.getRulevalue(), rule.getSupplierId(), false, false, rule.isRemote())).doubleValue());
			}

		} else if (rule.getRcondition() == 2 && myShape.leftIn) // IN
		{

			if (rule.getRuletype() == 4) {
				clearances[0] = rule.getRulevalue();
				clearances[1] = rule.getRulevaluei();
			} else {
				clearances[0] = (int) ((matrixController.getValueFromMatrix(
						rule.getRulevalue(), rule.getSupplierId(), false, false, rule.isRemote())).doubleValue());

				clearances[1] = (int) ((matrixController.getValueFromMatrix(
						rule.getRulevalue(), rule.getSupplierId(), false, false, rule.isRemote())).doubleValue());
			}

		} else if (rule.getRcondition() == 3 && !myShape.leftIn) {

			if (rule.getRuletype() == 4) {
				clearances[0] = rule.getRulevalue();
				clearances[1] = rule.getRulevaluei();
			} else {
				clearances[0] = (int) ((matrixController.getValueFromMatrix(
						rule.getRulevalue(), rule.getSupplierId(), false, false, rule.isRemote())).doubleValue());

				clearances[1] = (int) ((matrixController.getValueFromMatrix(
						rule.getRulevalue(), rule.getSupplierId(), false, false, rule.isRemote())).doubleValue());
			}

		}

		return clearances;
	}

	public Object[] getBottomClearances(Rules rule) throws Exception {

		MatrixController matrixController = new MatrixController(myShape, this.myFrame2);

		Object[] clearances = new Object[2];
		clearances[0] = 0;
		clearances[1] = 0;
		if (rule.getRcondition() == 1) // None
		{

			if (rule.getRuletype() == 4) {
				clearances[0] = rule.getRulevalue();
				clearances[1] = rule.getRulevaluei();
			} else {
				clearances[0] = (int) ((matrixController.getValueFromMatrix(
						rule.getRulevalue(), rule.getSupplierId(), false, false, rule.isRemote())).doubleValue());

				clearances[1] = (int) ((matrixController.getValueFromMatrix(
						rule.getRulevalue(), rule.getSupplierId(), false, false, rule.isRemote())).doubleValue());
			}

		} else if (rule.getRcondition() == 2 && myShape.botIn) // IN
		{

			if (rule.getRuletype() == 4) {
				clearances[0] = rule.getRulevalue();
				clearances[1] = rule.getRulevaluei();
			} else {
				clearances[0] = (int) ((matrixController.getValueFromMatrix(
						Integer.valueOf(rule.getRulevalue()), rule.getSupplierId(), false, false, rule.isRemote()))
						.doubleValue());

				clearances[1] = (int) ((matrixController.getValueFromMatrix(
						Integer.valueOf(rule.getRulevalue()), rule.getSupplierId(), false, false, rule.isRemote()))
						.doubleValue());
			}

		} else if (rule.getRcondition() == 3 && !myShape.botIn) {

			if (rule.getRuletype() == 4) {
				clearances[0] = rule.getRulevalue();
				clearances[1] = rule.getRulevaluei();
			} else {
				clearances[0] = (int) ((matrixController.getValueFromMatrix(
						Integer.valueOf(rule.getRulevalue()), rule.getSupplierId(), false, false, rule.isRemote()))
						.doubleValue());

				clearances[1] = (int) ((matrixController.getValueFromMatrix(
						Integer.valueOf(rule.getRulevalue()), rule.getSupplierId(), false, false, rule.isRemote()))
						.doubleValue());
			}

		}

		return clearances;
	}

	public Object[] getTopClearances(Rules rule) throws Exception {

		MatrixController matrixController = new MatrixController(myShape, this.myFrame2);

		Object[] clearances = new Object[2];
		clearances[0] = 0;
		clearances[1] = 0;
		if (rule.getRcondition() == 1) // None
		{
			if (rule.getRuletype() == 4) {
				clearances[0] = rule.getRulevalue();
				clearances[1] = rule.getRulevaluei();
			} else {
				clearances[0] = (int) ((matrixController.getValueFromMatrix(
						Integer.valueOf(rule.getRulevalue()), rule.getSupplierId(), false, false, rule.isRemote()))
						.doubleValue());

				clearances[1] = (int) ((matrixController.getValueFromMatrix(
						Integer.valueOf(rule.getRulevalue()), rule.getSupplierId(), false, false, rule.isRemote()))
						.doubleValue());
			}

		} else if (rule.getRcondition() == 2 && myShape.topIn) // IN
		{

			if (rule.getRuletype() == 4) {
				clearances[0] = rule.getRulevalue();
				clearances[1] = rule.getRulevaluei();
			} else {
				clearances[0] = (int) ((matrixController.getValueFromMatrix(
						Integer.valueOf(rule.getRulevalue()), rule.getSupplierId(), false, false, rule.isRemote()))
						.doubleValue());

				clearances[1] = (int) ((matrixController.getValueFromMatrix(
						Integer.valueOf(rule.getRulevalue()), rule.getSupplierId(), false, false, rule.isRemote()))
						.doubleValue());
			}

		} else if (rule.getRcondition() == 3 && !myShape.topIn) {

			if (rule.getRuletype() == 4) {
				clearances[0] = rule.getRulevalue();
				clearances[1] = rule.getRulevaluei();
			} else {
				clearances[0] = (int) ((matrixController.getValueFromMatrix(
						Integer.valueOf(rule.getRulevalue()), rule.getSupplierId(), false, false, rule.isRemote()))
						.doubleValue());

				clearances[1] = (int) ((matrixController.getValueFromMatrix(
						Integer.valueOf(rule.getRulevalue()), rule.getSupplierId(), false, false, rule.isRemote()))
						.doubleValue());
			}

		}

		return clearances;
	}

}
