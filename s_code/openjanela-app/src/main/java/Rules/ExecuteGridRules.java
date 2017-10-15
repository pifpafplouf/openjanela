package Rules;

import Model.BillOfMat;
import Model.DLO;
import Model.DesignGrid;
import Model.OpeningObject;
import Model.ProfileParts.Profiles;
import Presentation.ItemFrame;
import openjanela.app.configuration.controller.calculation.MatrixController;
import openjanela.model.entities.admin.TypeGrids;
import openjanela.model.entities.admin.TypePriceCategory;
import openjanela.model.entities.orderEntry.PricingGroup;
import openjanela.model.entities.partner.Grids;
import openjanela.model.entities.partner.PartnerLineDiscount;
import openjanela.model.entities.partner.ValidOrientations;
import openjanela.model.entities.parts.*;
import org.apache.log4j.Logger;
import org.openjanela.data.ApplicationBaseApp;
import org.openjanela.data.ApplicationBaseRulesApp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 12/3/13
 *          Time: 3:27 PM
 */
public class ExecuteGridRules {

    //Apache Log4j
    private static final Logger logger = Logger.getLogger(ExecuteGridRules.class);

    //***********************************************************************************
    //Properties Values
    //***********************************************************************************

    //Level Identification Id
    private int levelId = 0;

    //Number of Total Grids Design Per Glass Unit
    private int noGrids = 0;

    //ItemFrame main frame
    private ItemFrame parentFrame;

    /**
     * Execute Grid Rules Constructor
     *
     * @param mainFrame, ItemFrame
     */
    public ExecuteGridRules(ItemFrame mainFrame) {
        this.parentFrame = mainFrame;
    }

    /**
     * Execute Grid Rules
     *
     * @param dlo, DLO
     * @return List<DesignGrid>
     */
    public List<DesignGrid> executeGridRules(OpeningObject opening, DLO dlo) throws Exception {

        //Bill of Material Design Grids
        List<DesignGrid> boms = new ArrayList<DesignGrid>();

        //Return Grid Type Setting DLO
        Grids grid = null;
        if (dlo.remote) {
            grid = ItemFrame.getApplicationRemoteBaseRules().getGrids(dlo.supplierId, dlo.gridID);
        } else {
            grid = ApplicationBaseRulesApp.getInstance().getGrids(dlo.gridID);
        }

        //Evaluate if grid is configured
        if (grid == null) {
            return boms;
        }

        //Create Normal Grids Bom
        if (grid.getGridTypeId() == TypeGrids.NORMAL.getValue()) {
            boms.addAll(createNormalGridBoms(opening, dlo));
        }

        //Create Normal Grids Perimeter
        if (grid.getGridTypeId() == TypeGrids.PERIMETER.getValue()) {
            boms.addAll(createNormalGridBoms(opening, dlo));
        }

        //Create TDL Grids
        if (grid.getGridTypeId() == TypeGrids.TDL.getValue()) {
            boms.addAll(createTDLGridBoms(opening, dlo));
        }

        //Create TDL Grids Perimeter
        if (grid.getGridTypeId() == TypeGrids.TDL_PERIMETER.getValue()) {
            boms.addAll(createTDLGridBoms(opening, dlo));
        }

        //Create SDL Grids
        if (grid.getGridTypeId() == TypeGrids.SDL.getValue()) {
            boms.addAll(createSDLGridBoms(opening, dlo));
        }

        //Create STUCK ON Grids
        if (grid.getGridTypeId() == TypeGrids.STUCK_ON.getValue()) {
            boms.addAll(createStuckOnGridBoms(opening, dlo));
        }

        //Create STUCK ON Grids Perimeter
        if (grid.getGridTypeId() == TypeGrids.STUCK_ON_PERIMETER.getValue()) {
            boms.addAll(createStuckOnGridBoms(opening, dlo));
        }

        //Create Connectors Bom
        if (boms != null && boms.size() > 0) {
            boms.addAll(createConnectorBoms(opening, dlo));
        }

        return boms;
    }

    //******************************************************************************************************************
    //Create Bill of Materials for Grids
    //******************************************************************************************************************

    /**
     * Create Normal & Perimeter Grid Boms
     *
     * @param opening, OpeningObject
     * @param dlo,     DLO
     * @return List<DesignGrid>
     */
    private List<DesignGrid> createNormalGridBoms(OpeningObject opening, DLO dlo) throws Exception {

        //Design Grids
        List<DesignGrid> gridBoms = new ArrayList<DesignGrid>();

        //Update Number of Grids Design
        this.noGrids = 1;

        //*************************************************************
        //Create parts BOM for vertical & horizontal grids
        //*************************************************************
        Grids grid = null;
        if (dlo.remote) {
            grid = ItemFrame.getApplicationRemoteBaseRules().getGrids(dlo.supplierId, dlo.gridID);
        } else {
            grid = ItemFrame.getApplicationBaseRules().getGrids(dlo.gridID);
        }

        //Create Vertical Grids
        if (dlo.bOpeningObject.mullions != null && dlo.bOpeningObject.mullions.size() > 0) {

            //Get Mullion Collection
            Object[] rmp = dlo.bOpeningObject.mullions.toArray();

            //**************************************************************
            //Retrieve Part Id
            //**************************************************************
            int gridPartId = grid.getPartid();

            if (grid.getPartidMatrix() > 0) {

                //Init Matrix Controller
                MatrixController matrixController = new MatrixController(dlo, dlo.myFrame2);

                if (dlo.remote) {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidMatrix(), dlo.supplierId, false,
                            false, dlo.remote)).doubleValue();
                } else {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidMatrix(), dlo.supplierId,
                            false, false, dlo.remote)).doubleValue();
                }
            }

            for (Object v : rmp) {

                //Get Profiles Object
                Profiles profiles = (Profiles) v;

                //Update Level Id
                this.levelId = profiles.a_levelID;

                //Update Orientation
                profiles.orientation = ValidOrientations.VERTICAL.getValue();

                //Create Bom Grid Object
                DesignGrid designGrid = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(), gridPartId, false);

                //Calculate Cost Grids
                calculateCostPriceMarkup(designGrid.getParts(), designGrid, (int) designGrid.getQtyuser());

                //Add to Grids Bom
                gridBoms.add(designGrid);
            }
        }

        // Horizontal Grid Mullions
        if (dlo.bOpeningObject.mullionsH != null && dlo.bOpeningObject.mullionsH.size() > 0) {

            Object[] rmp = dlo.bOpeningObject.mullionsH.toArray();

            //**************************************************************
            //Retrieve Part Id
            //**************************************************************
            int gridPartId = grid.getPartid();

            if (grid.getPartidMatrix() > 0) {

                //Init Matrix Controller
                MatrixController matrixController = new MatrixController(dlo, dlo.myFrame2);

                if (dlo.remote) {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidMatrix(), dlo.supplierId, false,
                            false, dlo.remote)).doubleValue();
                } else {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidMatrix(), dlo.supplierId,
                            false, false, dlo.remote)).doubleValue();
                }
            }


            for (Object v : rmp) {

                //Get Profiles Object
                Profiles profiles = (Profiles) v;

                //Update Level Id
                this.levelId = profiles.a_levelID;

                //Update Orientation
                profiles.orientation = ValidOrientations.HORIZONTAL.getValue();

                //Create Bom Grid Object
                DesignGrid designGrid = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(), gridPartId,
                        false);

                //Calculate Cost Grids
                calculateCostPriceMarkup(designGrid.getParts(), designGrid, (int) designGrid.getQtyuser());

                //Create Bom Grid Object
                gridBoms.add(designGrid);
            }
        }

        // Spokes Mullions
        if (dlo.gridPartsS != null && dlo.gridPartsS.size() > 0) {

            Object[] rmp = dlo.gridPartsS.toArray();

            //**************************************************************
            //Retrieve Part Id
            //**************************************************************
            int gridPartId = grid.getPartid();

            if (grid.getPartidMatrix() > 0) {

                //Init Matrix Controller
                MatrixController matrixController = new MatrixController((Profiles) rmp[0], dlo.myFrame2);

                if (dlo.remote) {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidMatrix(), dlo.supplierId, false,
                            false, dlo.remote)).doubleValue();
                } else {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidMatrix(), dlo.supplierId,
                            false, false, dlo.remote)).doubleValue();
                }
            }


            for (Object v : rmp) {

                //Get Profiles Object
                Profiles profiles = (Profiles) v;

                //Update Level Id
                this.levelId = profiles.a_levelID;

                //Create Bom Grid Object
                DesignGrid designGrid = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                        gridPartId, false);

                //Calculate Cost Grids
                calculateCostPriceMarkup(designGrid.getParts(), designGrid, (int) designGrid.getQtyuser());

                //Create Bom Grid Object
                gridBoms.add(designGrid);
            }
        }

        return gridBoms;
    }

    /**
     * Create TDL Grid Boms
     *
     * @param opening, OpeningObject
     * @param dlo,     DLO
     * @return List<DesignGrid>
     */
    private List<DesignGrid> createTDLGridBoms(OpeningObject opening, DLO dlo) {
        throw new UnsupportedOperationException();
    }

    /**
     * Create SDL Grid Boms
     *
     * @param opening, OpeningObject
     * @param dlo,     DLO
     * @return List<DesignGrid>
     */
    private List<DesignGrid> createSDLGridBoms(OpeningObject opening, DLO dlo) throws Exception {

        //Design Grids
        List<DesignGrid> gridBoms = new ArrayList<DesignGrid>();

        //Update Number of Grids Design
        this.noGrids = 3;

        //*************************************************************
        //Create parts BOM for vertical & horizontal grids
        //*************************************************************
        Grids grid = null;
        if (dlo.remote) {
            grid = ItemFrame.getApplicationRemoteBaseRules().getGrids(dlo.supplierId, dlo.gridID);
        } else {
            grid = ItemFrame.getApplicationBaseRules().getGrids(dlo.gridID);
        }

        if (grid.getContinuityIn() != grid.getContinuityOut()) {
            gridBoms.addAll(createSDLGridBomsOut(opening, dlo));
        }

        if (dlo.bOpeningObject.mullions != null && dlo.bOpeningObject.mullions.size() > 0) {

            //Get Mullion Collection
            Object[] rmp = dlo.bOpeningObject.mullions.toArray();

            //**************************************************************
            //Retrieve Part Id
            //**************************************************************
            int gridPartId = grid.getPartid();
            int gridPartSimId = grid.getPartidSim();

            if (grid.getPartidMatrix() > 0) {

                //Init Matrix Controller
                MatrixController matrixController = new MatrixController(dlo, dlo.myFrame2);

                if (dlo.remote) {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidMatrix(), dlo.supplierId, false,
                            false, dlo.remote)).doubleValue();
                } else {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidMatrix(), dlo.supplierId,
                            false, false, dlo.remote)).doubleValue();
                }
            }

            if (grid.getPartidSimMatrix() > 0) {

                //Init Matrix Controller
                MatrixController matrixController = new MatrixController(dlo, dlo.myFrame2);

                if (dlo.remote) {
                    gridPartSimId = (int) (matrixController.getValueFromMatrix(grid.getPartidSimMatrix(), dlo.supplierId, false,
                            false, dlo.remote)).doubleValue();
                } else {
                    gridPartSimId = (int) (matrixController.getValueFromMatrix(grid.getPartidSimMatrix(), dlo.supplierId,
                            false, false, dlo.remote)).doubleValue();
                }
            }

            for (Object v : rmp) {

                //Get Profiles Object
                Profiles profiles = (Profiles) v;

                //Update Orientation
                profiles.orientation = ValidOrientations.VERTICAL.getValue();

                //Update Level Id
                this.levelId = profiles.levelID;

                if (grid.getContinuityIn() == grid.getContinuityOut()) {

                    //Part #1 . Create Bom Grid Object - Leaf #1
                    DesignGrid gridPart1 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                            gridPartSimId, true);

                    //Calculate Cost Grids
                    calculateCostPriceMarkup(gridPart1.getParts(), gridPart1, (int) gridPart1.getQtyuser());

                    gridBoms.add(gridPart1);

                    //Part #2 . Create Bom Grid Object - Leaf #2
                    DesignGrid gridPart2 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                            gridPartSimId, true);

                    //Calculate Cost Grids
                    calculateCostPriceMarkup(gridPart2.getParts(), gridPart2, (int) gridPart2.getQtyuser());

                    gridBoms.add(gridPart2);
                }

                //Part #3 . Create Bom Grid Object - Middle SU
                DesignGrid gridPart3 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                        gridPartId, false);

                //Calculate Cost Grids
                calculateCostPriceMarkup(gridPart3.getParts(), gridPart3, (int) gridPart3.getQtyuser());

                gridBoms.add(gridPart3);
            }
        }

        // Horizontal Grid Mullions
        if (dlo.bOpeningObject.mullionsH != null && dlo.bOpeningObject.mullionsH.size() > 0) {

            Object[] rmp = dlo.bOpeningObject.mullionsH.toArray();

            //**************************************************************
            //Retrieve Part Id
            //**************************************************************
            int gridPartId = grid.getPartid();
            int gridPartSimId = grid.getPartidSim();

            if (grid.getPartidMatrix() > 0) {

                //Init Matrix Controller
                MatrixController matrixController = new MatrixController(dlo, dlo.myFrame2);

                if (dlo.remote) {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidMatrix(), dlo.supplierId, false,
                            false, dlo.remote)).doubleValue();
                } else {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidMatrix(), dlo.supplierId,
                            false, false, dlo.remote)).doubleValue();
                }
            }

            if (grid.getPartidSimMatrix() > 0) {

                //Init Matrix Controller
                MatrixController matrixController = new MatrixController(dlo, dlo.myFrame2);

                if (dlo.remote) {
                    gridPartSimId = (int) (matrixController.getValueFromMatrix(grid.getPartidSimMatrix(), dlo.supplierId, false,
                            false, dlo.remote)).doubleValue();
                } else {
                    gridPartSimId = (int) (matrixController.getValueFromMatrix(grid.getPartidSimMatrix(), dlo.supplierId,
                            false, false, dlo.remote)).doubleValue();
                }
            }

            for (Object v : rmp) {

                //Get Profiles Object
                Profiles profiles = (Profiles) v;

                //Update Orientation
                profiles.orientation = ValidOrientations.HORIZONTAL.getValue();

                //Update Level Id
                this.levelId = profiles.levelID;

                if (grid.getContinuityIn() == grid.getContinuityOut()) {

                    //Part #1 . Create Bom Grid Object - Leaf #1
                    DesignGrid gridPart1 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                            gridPartSimId, true);

                    //Calculate Cost Grids
                    calculateCostPriceMarkup(gridPart1.getParts(), gridPart1, (int) gridPart1.getQtyuser());

                    gridBoms.add(gridPart1);

                    //Part #2 . Create Bom Grid Object - Leaf #2
                    DesignGrid gridPart2 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                            gridPartSimId, true);

                    //Calculate Cost Grids
                    calculateCostPriceMarkup(gridPart2.getParts(), gridPart2, (int) gridPart2.getQtyuser());

                    gridBoms.add(gridPart2);
                }

                //Part #3 . Create Bom Grid Object - Middle SU
                DesignGrid gridPart3 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                        gridPartId, false);

                //Calculate Cost Grids
                calculateCostPriceMarkup(gridPart3.getParts(), gridPart3, (int) gridPart3.getQtyuser());

                gridBoms.add(gridPart3);
            }
        }

        // Spokes Mullions
        if (dlo.gridPartsS != null && dlo.gridPartsS.size() > 0) {

            Object[] rmp = dlo.gridPartsS.toArray();

            //**************************************************************
            //Retrieve Part Id
            //**************************************************************
            int gridPartId = grid.getPartid();
            int gridPartSimId = grid.getPartidSim();

            if (grid.getPartidMatrix() > 0) {

                //Init Matrix Controller
                MatrixController matrixController = new MatrixController(dlo, dlo.myFrame2);

                if (dlo.remote) {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidMatrix(), dlo.supplierId, false,
                            false, dlo.remote)).doubleValue();
                } else {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidMatrix(), dlo.supplierId,
                            false, false, dlo.remote)).doubleValue();
                }
            }

            if (grid.getPartidSimMatrix() > 0) {

                //Init Matrix Controller
                MatrixController matrixController = new MatrixController(dlo, dlo.myFrame2);

                if (dlo.remote) {
                    gridPartSimId = (int) (matrixController.getValueFromMatrix(grid.getPartidSimMatrix(), dlo.supplierId, false,
                            false, dlo.remote)).doubleValue();
                } else {
                    gridPartSimId = (int) (matrixController.getValueFromMatrix(grid.getPartidSimMatrix(), dlo.supplierId,
                            false, false, dlo.remote)).doubleValue();
                }
            }

            for (Object v : rmp) {

                //Get Profiles Object
                Profiles profiles = (Profiles) v;

                //Update Level Id
                this.levelId = profiles.levelID;

                //Part #1 . Create Bom Grid Object - Leaf #1
                DesignGrid gridPart1 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                        gridPartSimId, true);

                //Calculate Cost Grids
                calculateCostPriceMarkup(gridPart1.getParts(), gridPart1, (int) gridPart1.getQtyuser());

                gridBoms.add(gridPart1);

                //Part #2 . Create Bom Grid Object - Leaf #2
                DesignGrid gridPart2 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                        gridPartSimId, true);

                //Calculate Cost Grids
                calculateCostPriceMarkup(gridPart2.getParts(), gridPart2, (int) gridPart2.getQtyuser());

                gridBoms.add(gridPart2);

                //Part #3 . Create Bom Grid Object - Middle SU
                DesignGrid gridPart3 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                        gridPartId, false);

                //Calculate Cost Grids
                calculateCostPriceMarkup(gridPart3.getParts(), gridPart3, (int) gridPart3.getQtyuser());

                gridBoms.add(gridPart3);
            }
        }

        return gridBoms;
    }

    /**
     * Create SDL Grids Boms Out
     *
     * @param opening, OpeningObject
     * @param dlo,     DLO
     * @return List<DesignGrid>
     */
    private List<DesignGrid> createSDLGridBomsOut(OpeningObject opening, DLO dlo) throws Exception {

        //Design Grids
        List<DesignGrid> gridBoms = new ArrayList<DesignGrid>();

        //*************************************************************
        //Create parts BOM for vertical & horizontal grids
        //*************************************************************
        Grids grid = null;
        if (dlo.remote) {
            grid = ItemFrame.getApplicationRemoteBaseRules().getGrids(dlo.supplierId, dlo.gridID);
        } else {
            grid = ItemFrame.getApplicationBaseRules().getGrids(dlo.gridID);
        }

        if (dlo.gridPartsV != null && dlo.gridPartsV.size() > 0) {

            //Get Mullion Collection
            Object[] rmp = dlo.gridPartsV.toArray();

            //**************************************************************
            //Retrieve Part Id
            //**************************************************************
            int gridPartSimId = grid.getPartidSim();

            if (grid.getPartidSimMatrix() > 0) {

                //Init Matrix Controller
                MatrixController matrixController = new MatrixController(dlo, dlo.myFrame2);

                if (dlo.remote) {
                    gridPartSimId = (int) (matrixController.getValueFromMatrix(grid.getPartidSimMatrix(), dlo.supplierId, false,
                            false, dlo.remote)).doubleValue();
                } else {
                    gridPartSimId = (int) (matrixController.getValueFromMatrix(grid.getPartidSimMatrix(), dlo.supplierId,
                            false, false, dlo.remote)).doubleValue();
                }
            }

            for (Object v : rmp) {

                //Get Profiles Object
                Profiles profiles = (Profiles) v;

                //Update Orientation
                profiles.orientation = ValidOrientations.VERTICAL.getValue();

                //Update Level Id
                this.levelId = profiles.levelID;

                //Length
                profiles.length = Math.sqrt(Math.pow((Math.max(profiles.x1, profiles.x4) - Math.min(profiles.x1, profiles.x4)), 2) +
                        Math.pow((Math.max(profiles.y1, profiles.y4) - Math.min(profiles.y1, profiles.y4)), 2));

                profiles.lengthM = (int) (profiles.length / dlo.myFrame2.metricscale.doubleValue());
                profiles.lengthI = (int) (profiles.length / dlo.myFrame2.imperialscale.doubleValue());

                //Part #1 . Create Bom Grid Object - Leaf #1
                DesignGrid gridPart1 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                        gridPartSimId, true);

                //Calculate Cost Grids
                calculateCostPriceMarkup(gridPart1.getParts(), gridPart1, (int) gridPart1.getQtyuser());

                gridBoms.add(gridPart1);

                //Part #2 . Create Bom Grid Object - Leaf #2
                DesignGrid gridPart2 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                        gridPartSimId, true);

                //Calculate Cost Grids
                calculateCostPriceMarkup(gridPart2.getParts(), gridPart2, (int) gridPart2.getQtyuser());

                gridBoms.add(gridPart2);
            }
        }

        // Horizontal Grid Mullions
        if (dlo.gridPartsH != null && dlo.gridPartsH.size() > 0) {

            Object[] rmp = dlo.gridPartsH.toArray();

            //**************************************************************
            //Retrieve Part Id
            //**************************************************************
            int gridPartSimId = grid.getPartidSim();

            if (grid.getPartidSimMatrix() > 0) {

                //Init Matrix Controller
                MatrixController matrixController = new MatrixController(dlo, dlo.myFrame2);

                if (dlo.remote) {
                    gridPartSimId = (int) (matrixController.getValueFromMatrix(grid.getPartidSimMatrix(), dlo.supplierId, false,
                            false, dlo.remote)).doubleValue();
                } else {
                    gridPartSimId = (int) (matrixController.getValueFromMatrix(grid.getPartidSimMatrix(), dlo.supplierId,
                            false, false, dlo.remote)).doubleValue();
                }
            }

            for (Object v : rmp) {

                //Get Profiles Object
                Profiles profiles = (Profiles) v;

                //Update Orientation
                profiles.orientation = ValidOrientations.HORIZONTAL.getValue();

                //Update Level Id
                this.levelId = profiles.levelID;

                //Length
                profiles.length = Math.sqrt(Math.pow((Math.max(profiles.x2, profiles.x3) - Math.min(profiles.x2, profiles.x3)), 2) +
                        Math.pow((Math.max(profiles.y2, profiles.y3) - Math.min(profiles.y2, profiles.y3)), 2));

                profiles.lengthM = (int) (profiles.length / dlo.myFrame2.metricscale.doubleValue());
                profiles.lengthI = (int) (profiles.length / dlo.myFrame2.imperialscale.doubleValue());

                //Part #1 . Create Bom Grid Object - Leaf #1
                DesignGrid gridPart1 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                        gridPartSimId, true);

                //Calculate Cost Grids
                calculateCostPriceMarkup(gridPart1.getParts(), gridPart1, (int) gridPart1.getQtyuser());

                gridBoms.add(gridPart1);

                //Part #2 . Create Bom Grid Object - Leaf #2
                DesignGrid gridPart2 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                        gridPartSimId, true);

                //Calculate Cost Grids
                calculateCostPriceMarkup(gridPart2.getParts(), gridPart2, (int) gridPart2.getQtyuser());

                gridBoms.add(gridPart2);

            }
        }

        return gridBoms;
    }

    /**
     * Create Stuck On Grid Boms
     *
     * @param opening, OpeningObject
     * @param dlo,     DLO
     * @return List<DesignGrid>
     */
    private List<DesignGrid> createStuckOnGridBoms(OpeningObject opening, DLO dlo) throws Exception {

        //Design Grids
        List<DesignGrid> gridBoms = new ArrayList<DesignGrid>();

        //Update Number of Grids Design
        this.noGrids = 2;

        //*************************************************************
        //Create parts BOM for vertical & horizontal grids
        //*************************************************************
        Grids grid = null;
        if (dlo.remote) {
            grid = ItemFrame.getApplicationRemoteBaseRules().getGrids(dlo.supplierId, dlo.gridID);
        } else {
            grid = ItemFrame.getApplicationBaseRules().getGrids(dlo.gridID);
        }

        if (dlo.bOpeningObject.mullions != null && dlo.bOpeningObject.mullions.size() > 0) {

            //Get Mullion Collection
            Object[] rmp = dlo.bOpeningObject.mullions.toArray();

            //**************************************************************
            //Retrieve Part Id
            //**************************************************************
            int gridPartId = grid.getPartid();

            if (grid.getPartidMatrix() > 0) {

                //Init Matrix Controller
                MatrixController matrixController = new MatrixController(dlo, dlo.myFrame2);

                if (dlo.remote) {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidSimMatrix(), dlo.supplierId, false,
                            false, dlo.remote)).doubleValue();
                } else {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidSimMatrix(), dlo.supplierId,
                            false, false, dlo.remote)).doubleValue();
                }
            }

            for (Object v : rmp) {

                //Get Profiles Object
                Profiles profiles = (Profiles) v;

                //Update Level Id
                this.levelId = profiles.levelID;

                //Part #1 . Create Bom Grid Object - Leaf #1
                DesignGrid gridPart1 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                        gridPartId, true);

                //Calculate Cost Grids
                calculateCostPriceMarkup(gridPart1.getParts(), gridPart1, (int) gridPart1.getQtyuser());

                gridBoms.add(gridPart1);

                //Part #2 . Create Bom Grid Object - Leaf #2
                DesignGrid gridPart2 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                        gridPartId, true);

                //Calculate Cost Grids
                calculateCostPriceMarkup(gridPart2.getParts(), gridPart2, (int) gridPart2.getQtyuser());

                gridBoms.add(gridPart2);
            }
        }

        // Horizontal Grid Mullions
        if (dlo.bOpeningObject.mullionsH != null && dlo.bOpeningObject.mullionsH.size() > 0) {

            Object[] rmp = dlo.bOpeningObject.mullionsH.toArray();

            //**************************************************************
            //Retrieve Part Id
            //**************************************************************
            int gridPartId = grid.getPartid();

            if (grid.getPartidMatrix() > 0) {

                //Init Matrix Controller
                MatrixController matrixController = new MatrixController(dlo, dlo.myFrame2);

                if (dlo.remote) {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidSimMatrix(), dlo.supplierId, false,
                            false, dlo.remote)).doubleValue();
                } else {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidSimMatrix(), dlo.supplierId,
                            false, false, dlo.remote)).doubleValue();
                }
            }

            for (Object v : rmp) {

                //Get Profiles Object
                Profiles profiles = (Profiles) v;

                //Update Level Id
                this.levelId = profiles.levelID;

                //Part #1 . Create Bom Grid Object - Leaf #1
                DesignGrid gridPart1 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                        gridPartId, true);

                //Calculate Cost Grids
                calculateCostPriceMarkup(gridPart1.getParts(), gridPart1, (int) gridPart1.getQtyuser());

                gridBoms.add(gridPart1);

                //Part #2 . Create Bom Grid Object - Leaf #2
                DesignGrid gridPart2 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                        gridPartId, true);

                //Calculate Cost Grids
                calculateCostPriceMarkup(gridPart2.getParts(), gridPart2, (int) gridPart2.getQtyuser());

                gridBoms.add(gridPart2);
            }
        }

        // Spokes Mullions
        if (dlo.gridPartsS != null && dlo.gridPartsS.size() > 0) {

            Object[] rmp = dlo.gridPartsS.toArray();

            //**************************************************************
            //Retrieve Part Id
            //**************************************************************
            int gridPartId = grid.getPartid();

            if (grid.getPartidMatrix() > 0) {

                //Init Matrix Controller
                MatrixController matrixController = new MatrixController(dlo, dlo.myFrame2);

                if (dlo.remote) {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidSimMatrix(), dlo.supplierId, false,
                            false, dlo.remote)).doubleValue();
                } else {
                    gridPartId = (int) (matrixController.getValueFromMatrix(grid.getPartidSimMatrix(), dlo.supplierId,
                            false, false, dlo.remote)).doubleValue();
                }
            }

            for (Object v : rmp) {

                //Get Profiles Object
                Profiles profiles = (Profiles) v;

                //Update Level Id
                this.levelId = profiles.levelID;

                //Part #1 . Create Bom Grid Object - Leaf #1
                DesignGrid gridPart1 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                        gridPartId, true);

                //Calculate Cost Grids
                calculateCostPriceMarkup(gridPart1.getParts(), gridPart1, (int) gridPart1.getQtyuser());

                gridBoms.add(gridPart1);

                //Part #2 . Create Bom Grid Object - Leaf #2
                DesignGrid gridPart2 = new DesignGrid(opening, dlo, dlo.myParentGlass, profiles, 1, grid.getId(),
                        gridPartId, true);

                //Calculate Cost Grids
                calculateCostPriceMarkup(gridPart2.getParts(), gridPart2, (int) gridPart2.getQtyuser());

                gridBoms.add(gridPart2);
            }
        }

        return gridBoms;
    }

    /**
     * Create Connector Boms
     *
     * @param opening, OpeningObject
     * @param dlo,     DLO
     * @return List<DesignGrid>
     */
    private List<DesignGrid> createConnectorBoms(OpeningObject opening, DLO dlo) {

        //Design Grids
        List<DesignGrid> gridBoms = new ArrayList<DesignGrid>();

        //Getting Grid Type Value
        Grids grid = null;
        if (dlo.remote) {
            grid = ItemFrame.getApplicationRemoteBaseRules().getGrids(dlo.supplierId, dlo.gridID);
        } else {
            grid = ItemFrame.getApplicationBaseRules().getGrids(dlo.gridID);
        }

        //Create Cross Connectors Parts
        if (dlo.crossConnectors > 0 && grid.getPartidCross() > 0) {
            DesignGrid designGrid = new DesignGrid(opening, dlo, dlo.myParentGlass, null, dlo.crossConnectors, grid.getId(),
                    grid.getPartidCross(), false);

            //Update level Identification
            designGrid.setLevel(this.levelId);

            //Update connectors qty per grids design
            designGrid.setQtyuser(designGrid.getQtyuser() * this.noGrids);

            gridBoms.add(designGrid);
        }

        //Create T Connectors Parts
        if (dlo.tConnectors > 0 && grid.getPartidT() > 0) {
            DesignGrid designGrid = new DesignGrid(opening, dlo, dlo.myParentGlass, null, dlo.tConnectors, grid.getId(),
                    grid.getPartidT(), false);

            //Update level Identification
            designGrid.setLevel(this.levelId);

            //Update connectors qty per grids design
            designGrid.setQtyuser(designGrid.getQtyuser() * this.noGrids);

            gridBoms.add(designGrid);

        }

        //Create L Connectors Parts
        if (dlo.lConnectors > 0 && grid.getPartidL() > 0) {
            DesignGrid designGrid = new DesignGrid(opening, dlo, dlo.myParentGlass, null, dlo.lConnectors, grid.getId(),
                    grid.getPartidL(), false);

            //Update level Identification
            designGrid.setLevel(this.levelId);

            //Update connectors qty per grids design
            designGrid.setQtyuser(designGrid.getQtyuser() * this.noGrids);

            gridBoms.add(designGrid);
        }

        //Create Spacers Connectors Parts
        if (dlo.spacerConnectors > 0 && grid.getPartidspacer() > 0) {
            DesignGrid designGrid = new DesignGrid(opening, dlo, dlo.myParentGlass, null, dlo.spacerConnectors, grid.getId(),
                    grid.getPartidspacer(), false);

            //Update level Identification
            designGrid.setLevel(this.levelId);

            //Update connectors qty per grids design
            designGrid.setQtyuser(designGrid.getQtyuser() * this.noGrids);

            gridBoms.add(designGrid);
        }

        //Create Hub Connectos Parts
        if (dlo.hubConnector > 0 && grid.getPartidhub() > 0) {
            DesignGrid designGrid = new DesignGrid(opening, dlo, dlo.myParentGlass, null, dlo.hubConnector, grid.getId(),
                    grid.getPartidhub(), false);

            //Update level Identification
            designGrid.setLevel(this.levelId);

            //Update connectors qty per grids design
            designGrid.setQtyuser(designGrid.getQtyuser() * this.noGrids);

            gridBoms.add(designGrid);
        }

        //Create Spoke Connectors Parts
        if (dlo.spokeConnectors > 0 && grid.getPartidspoke() > 0) {
            DesignGrid designGrid = new DesignGrid(opening, dlo, dlo.myParentGlass, null, dlo.spokeConnectors, grid.getId(),
                    grid.getPartidspoke(), false);

            //Update level Identification
            designGrid.setLevel(this.levelId);

            //Update connectors qty per grids design
            designGrid.setQtyuser(designGrid.getQtyuser() * this.noGrids);

            gridBoms.add(designGrid);
        }

        return gridBoms;
    }

    /**
     * Calculate Cost Price Markup
     *
     * @param parts, Parts Object
     * @param bom,   Grids Bill Of Material
     * @param qty,   Quantity Required
     */
    private void calculateCostPriceMarkup(Parts parts, DesignGrid bom, int qty) {

        try {

            //----------------------------------------------------
            //Initialize Part Cost Price
            //----------------------------------------------------
            PartsCostPrice pcp = initializePartCostPrice(parts);

            //----------------------------------------------------
            //Search for a Valid Part Cost Price
            //----------------------------------------------------
            List<PartsCostPrice> partCostPrices = null;
            if (parts.isRemote()) {
                partCostPrices = ItemFrame.getApplicationRemoteBaseRules().getPartCostPrices(parts.getSupplierId());
            } else {
                partCostPrices = ItemFrame.getApplicationBase().getPartsCostPrices();
            }

            for (PartsCostPrice costPrice : partCostPrices) {
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
                    parts.setPricemeasure(this.parentFrame.currentUOM);
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
            PricingGroup priceGroup = null;
            TypePriceCategory priceCategory = null;

            if (parts.isRemote()) {
                priceGroup = ItemFrame.getApplicationRemoteBaseRules().getPricingGroup(parts.getSupplierId(), parts.getPricegroup());
                priceCategory = ItemFrame.getApplicationBase().getTypePriceCategory(priceGroup.getId());
            } else {
                priceGroup = ItemFrame.getApplicationBase().getPricingGroup(parts.getPricegroup());
                priceCategory = ItemFrame.getApplicationBase().getTypePriceCategory(priceGroup.getId());
            }

            //Return Line Discount
            double discount = 0;

            if (parts.isRemote()) {
                discount = getRemoteLineDiscount(parts.getSupplierId(), priceCategory.getId());
            } else {
                discount = getLineDiscount(priceCategory.getId());
            }

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
                pricesizem = bom.getCutlength() / 100d / 1000d;
                pricesizei = bom.getCutlength() / 64d / 12d;
            } else if (pcp.getId().getPriceuom() == 3) {
                pricesizem = bom.getAreauser();
                pricesizei = bom.getAreaiuser();
            } else if (pcp.getId().getPriceuom() == 4) {// FaceIn
                pricesizem = parts.getFacein() * bom.getCutlength() / 100d / 1000d;
                pricesizei = parts.getFaceini() * bom.getCutlengthi() / 64d / 12d;
            } else if (pcp.getId().getPriceuom() == 5) {// FaceOut
                pricesizem = parts.getFaceout() * bom.getCutlength() / 100d / 1000d;
                pricesizei = parts.getFaceouti() * bom.getCutlengthi() / 64d / 12d;
            } else if (pcp.getId().getPriceuom() == 6) {// Perimeter
                pricesizem = parts.getPerimeter() * bom.getCutlength() / 100d / 1000d;
                pricesizei = parts.getPerimeteri() * bom.getCutlengthi() / 64d / 12d;
            } else if (pcp.getId().getPriceuom() == 7) {// weight
                pricesizem = parts.getWeight() * bom.getCutlength() / 100d / 1000d;
                pricesizei = parts.getWeighti() * bom.getCutlengthi() / 64d / 12d;
            } else if (pcp.getId().getPriceuom() == 8) {
                pricesizem = bom.getVolume();
                pricesizei = bom.getVolumei();
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
                costsizem = bom.getCutlength() / 100d / 1000d;
                costsizei = bom.getCutlengthi() / 64d / 12d;
            } else if (pcp.costuom == 3) {
                costsizem = bom.getAreauser();
                costsizei = bom.getAreaiuser();
            } else if (pcp.costuom == 4) {
                costsizem = parts.getFacein() * bom.getCutlength() / 100d / 1000d;
                costsizei = parts.getFaceini() * bom.getCutlengthi() / 64d / 12d;
            } else if (pcp.costuom == 5) {
                costsizem = parts.getFaceout() * bom.getCutlength() / 100d / 1000d;
                costsizei = parts.getFaceouti() * bom.getCutlengthi() / 64d / 12d;
            } else if (pcp.costuom == 6) {
                costsizem = parts.getPerimeter() * bom.getCutlength() / 100d / 1000d;
                costsizei = parts.getPerimeteri() * bom.getCutlengthi() / 64d / 12d;
            } else if (pcp.costuom == 7) {
                costsizem = parts.getWeight() * bom.getCutlength() / 100d / 1000d;
                costsizei = parts.getWeighti() * bom.getCutlengthi() / 64d / 12d;
            } else if (pcp.costuom == 8) {
                costsizem = bom.getVolume();
                costsizei = bom.getVolumei();
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
                    pcp.costuom, pcp.pricemeasure, pcp.isDiscountable(), this.parentFrame, this.parentFrame.currentUOM,
                    parts.getWaste());

            bom.setPrice(new BigDecimal(mypricecost[2].toString()));
            bom.setPriceuser(new BigDecimal(mypricecost[2].toString()));

            bom.setCost(new BigDecimal(mypricecost[3].toString()));

            bom.setTotalprice(new BigDecimal(mypricecost[0].toString()));
            bom.setTotalpriceuser( new BigDecimal(mypricecost[0].toString()));
            bom.setTotalcost(new BigDecimal(mypricecost[1].toString()));

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
        PartsFamily partFam = null;
        if (parts.isRemote()) {
            partFam = ItemFrame.getApplicationRemoteBaseRules().getPartFamily(parts.getSupplierId(), parts.getPartfamily());
        } else {
            partFam = ItemFrame.getApplicationBase().getPartsFamily(parts.getPartfamily());
        }

        if (partFam.getId() == 8) {
            pcp.costuom = parts.getCostuom();
        }

        PartFamilySeries pfSeries = ItemFrame.getApplicationBase().getPartFamilySeries(partFam.getId(), this.parentFrame.seriesID);

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
     * Return Line Discount Remote
     *
     * @param supplierId, Supplier Identification Id
     * @param pricecat,   Price Category
     * @return double
     */
    public double getRemoteLineDiscount(int supplierId, int pricecat) {

        double discount = 0.0d;

        List<PartnerLineDiscount> partnerDiscounts = ItemFrame.getApplicationRemoteBaseRules().getPartnerLineDiscounts(supplierId);
        for (PartnerLineDiscount d : partnerDiscounts) {
            if (pricecat == d.getId().getPriceCategoryId()) {
                discount = d.getDiscount();
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
