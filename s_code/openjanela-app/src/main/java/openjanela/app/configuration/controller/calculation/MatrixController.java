
package openjanela.app.configuration.controller.calculation;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import openjanela.app.configuration.controller.BaseController;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.eao.partner.matrixEAO.MatrixEAO;
import openjanela.model.eao.partner.matrixEAO.MatrixPersistenceEAO;
import openjanela.model.eao.partner.matrixHeaderEAO.MatrixHeaderEAO;
import openjanela.model.eao.partner.matrixHeaderEAO.MatrixHeaderPersistenceEAO;
import openjanela.model.eao.partner.typeMatrixDictionaryEAO.TypeMatrixDictionaryEAO;
import openjanela.model.eao.partner.typeMatrixDictionaryEAO.TypeMatrixDictionaryPersistenceEAO;
import openjanela.model.entities.partner.Matrix;
import openjanela.model.entities.partner.MatrixHeader;
import openjanela.model.entities.partner.TypeMatrixDiccionary;
import openjanela.model.entities.partner.TypeOperands;
import openjanela.model.entities.partner.TypesMatrixCell;

import org.apache.log4j.Logger;

import Model.GlassSU;
import Model.matrix.MatrixDictionaryCalculation;
import Presentation.ItemFrame;
import org.openjanela.data.ApplicationRemoteBaseRulesApp;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved. User: EMontenegro Date:
 * 10-22-12 Time: 07:33 PM
 */
public class MatrixController extends BaseController {

    // Apache log4j   findOption
    private static final Logger logger = Logger.getLogger(GlassCalculationController.class);

    private final MatrixDictionaryCalculation matrixCalculation;

    private MatrixHeader matrixHeader;

    private List<Matrix> matrices;

    // ************************************************
    // Entity Access Object
    // ************************************************
    private final MatrixHeaderEAO matrixHeaderEAO;

    private final MatrixEAO matrixEAO;

    private final TypeMatrixDictionaryEAO typeMatrixDictionaryEAO;

    private GlassSUController glassSUController;

    ItemFrame myItemFrame;

    double netListRatio = 1;


    /**
     * Constructor controller
     *
     * @param matrixCalculation , matrixCalculation model
     */
    public MatrixController(MatrixDictionaryCalculation matrixCalculation, ItemFrame myRoot) {

        // Setting matrixCalculation

        // If From CouplerMullion Shape = null!!!

        this.matrixCalculation = matrixCalculation;

        this.myItemFrame = myRoot;

        // Initialize entity access objects
        this.matrixHeaderEAO = new MatrixHeaderPersistenceEAO();
        this.matrixEAO = new MatrixPersistenceEAO();
        this.typeMatrixDictionaryEAO = new TypeMatrixDictionaryPersistenceEAO();
    }

    /**
     * Constructor controller
     *
     * @param nlr , matrixCalculation model
     */
    public MatrixController(double nlr) {

        // Setting matrixCalculation

        // If From CouplerMullion Shape = null!!!
        this.matrixCalculation = null;

        this.netListRatio = nlr;


        // Initialize entity access objects
        this.matrixHeaderEAO = new MatrixHeaderPersistenceEAO();
        this.matrixEAO = new MatrixPersistenceEAO();
        this.typeMatrixDictionaryEAO = new TypeMatrixDictionaryPersistenceEAO();
    }


    /**
     * Get price glass from matrix
     *
     * @param matrixId , Identification matrix
     * @param forPrice , For price calculation
     * @return BigDecimal
     */
    public BigDecimal getValueFromMatrix(Integer matrixId, Integer supplierId, boolean forPrice, boolean forCommission,
                                         boolean remote) throws Exception {

        try {

            // Search for matrix header
            if (forCommission) {
                this.matrixHeader = ItemFrame.getApplicationBaseRules().getCommissionMatrixHeader(matrixId);
            } else {
                if (remote) {
                    this.matrixHeader = ItemFrame.getApplicationRemoteBaseRules().getMatrixHeader(supplierId, matrixId);
                } else {
                    this.matrixHeader = ItemFrame.getApplicationBaseRules().getMatrixHeader(matrixId);
                }
            }

            if (matrixHeader != null) {

                // Get typeOperator and math operator value
                Integer mathOperatorId = matrixHeader.getMathOperatorId();
                BigDecimal mathOperatorValue = matrixHeader.getOperatorValue();

                if (forCommission) {
                    this.matrices = getCommissionMatrixCellContent(matrixId);
                } else {
                    if (remote) {
                        this.matrices = getMatrixCellContent(supplierId, matrixId);
                    } else {
                        this.matrices = getMatrixCellContent(matrixId);
                    }
                }

                // Get limits from matrix header
                Object rowMatrixValue = getRowColumnMatrixValue(this.matrixHeader.getRowTypeId(), forPrice, true);
                Object columnMatrixValue = getRowColumnMatrixValue(this.matrixHeader.getColumnTypeId(), forPrice, false);

                for (Matrix cell : this.matrices) {

                    boolean foundRow = false;
                    boolean foundCol = false;

                    // Evaluating row cell
                    if (matrixHeader.getRowTypeId() != 28 && matrixHeader.getRowTypeId() != 2) {
                        BigDecimal matrixRowL = new BigDecimal(cell.getMatrixRowL());
                        BigDecimal matrixRowU = new BigDecimal(cell.getMatrixRowU());
                        BigDecimal rowMatrixVal = null;

                        if (rowMatrixValue instanceof Double) {
                            rowMatrixVal = new BigDecimal((Double)rowMatrixValue);
                        } else if (rowMatrixValue instanceof  BigDecimal) {
                            rowMatrixVal = (BigDecimal) rowMatrixValue;
                        }

                        foundRow = (matrixRowL.compareTo(rowMatrixVal) <= -1 && (matrixRowU.compareTo(rowMatrixVal) >= 1) ||
                                matrixRowU.compareTo(rowMatrixVal) == 0);

                    } else if (matrixHeader.getRowTypeId() == 28) {
                        String matrixRowL = cell.getMatrixRowL();
                        String matrixRowU = cell.getMatrixRowU();
                        String rowMatrixVal = (String) rowMatrixValue;

                        foundRow = (matrixRowL.compareToIgnoreCase(rowMatrixVal) <= -1 &&
                                (matrixRowU.compareToIgnoreCase(rowMatrixVal) >= 1) || matrixRowU.compareTo(rowMatrixVal) == 0);
                    } else if (matrixHeader.getRowTypeId() == 2) {
                        foundRow = true;
                    }

                    // Evaluating col cell
                    if (matrixHeader.getColumnTypeId() != 28 && matrixHeader.getColumnTypeId() != 2) {
                        BigDecimal matrixColL = new BigDecimal(cell.getMatrixColL());
                        BigDecimal matrixColU = new BigDecimal(cell.getMatrixColU());
                        BigDecimal colMatrixVal = (BigDecimal) columnMatrixValue;

                        foundCol = (matrixColL.compareTo(colMatrixVal) <= -1 && (matrixColU.compareTo(colMatrixVal) >= 1) ||
                                matrixColU.compareTo(colMatrixVal) == 0);

                    } else if (matrixHeader.getColumnTypeId() == 28) {
                        String matrixColL = cell.getMatrixColL();
                        String matrixColU = cell.getMatrixColU();
                        String colMatrixVal = (String) columnMatrixValue;

                        foundCol = (matrixColL.compareToIgnoreCase(colMatrixVal) <= -1 &&
                                (matrixColU.compareToIgnoreCase(colMatrixVal) >= 1) || matrixColU.compareTo(colMatrixVal) == 0);
                    } else if (matrixHeader.getColumnTypeId() == 2) {
                        foundCol = true;
                    }

                    if (foundRow && foundCol) {

                        if (cell.getCellType() == TypesMatrixCell.NOT_FOUND.getValue()) {
                            throw new Exception("Pricing cell not found in matrix " + cell.getId());
                        }

                        if (cell.getCellType() == TypesMatrixCell.VALUE.getValue()) {
                            return new BigDecimal(cell.getPrice().trim());
                        }

                        if (cell.getCellType() == TypesMatrixCell.MATRIX.getValue()) {
                            // Executing a recursive call matrix
                            return getValueFromMatrix(new Integer(cell.getPrice()), cell.getSupplierId(), forPrice,
                                    forCommission, cell.isRemote());
                        }

                        if (cell.getCellType() == TypesMatrixCell.ERROR.getValue()) {
                            String errorMsg = cell.getPrice(); // Represents
                            // error
                            // message
                            // value
                            throw new Exception(errorMsg);
                        }

                        if (cell.getCellType() == TypesMatrixCell.WARNING.getValue()) {
                            String warningMsg = cell.getPrice(); // Represents
                            // warning
                            // message
                            // value
                            throw new Exception(warningMsg);
                        }

                        if (cell.getCellType() == TypesMatrixCell.TITLE.getValue()) {
                            String title = cell.getPrice(); // Represents a
                            // title
                            // message
                            throw new Exception(title);
                        }

                        if (cell.getCellType() == TypesMatrixCell.XR.getValue()) {
                            BigDecimal price = new BigDecimal(cell.getPrice());
                            return price.multiply((BigDecimal) rowMatrixValue);
                        }

                        if (cell.getCellType() == TypesMatrixCell.XC.getValue()) {
                            BigDecimal price = new BigDecimal(cell.getPrice());
                            return price.multiply((BigDecimal) columnMatrixValue);
                        }
                        break;
                    }
                }
            }

        } catch (Exception e) {
            System.out.print(e + "  MatrixID = " + matrixId);
            e.printStackTrace();
        }

        return new BigDecimal("0");
    }

    /**
     * Get matrix content
     *
     * @param matrixId , Matrix Identification Id
     * @return List<Matrix>
     * @throws Exception, Exception
     */
    private List<Matrix> getMatrixCellContent(int matrixId) throws Exception {
        return ItemFrame.getApplicationBaseRules().getMatrixCells(matrixId); //matrixEAO.findMatrixCellsById(matrixId);
    }

    /**
     * Return Remote Matrix Cell Content
     *
     * @param supplierId, Supplier Identification Id
     * @param matrixId,   Matrix Identification Id
     * @return List<Matrix>
     * @throws Exception, Exception
     */
    private List<Matrix> getMatrixCellContent(int supplierId, int matrixId) throws Exception {
        return ItemFrame.getApplicationRemoteBaseRules().getMatrixCells(supplierId, matrixId);
    }

    /**
     * Get commission matrix content
     *
     * @param matrixId , Matrix Identification Id
     * @return List<Matrix>
     * @throws Exception, Exception
     */
    private List<Matrix> getCommissionMatrixCellContent(int matrixId) throws Exception {
        return ItemFrame.getApplicationBaseRules().getCommissionMatrixCells(matrixId);
    }

    public int getMatrixMeasure(int matrixID) {
        MatrixHeader m = ItemFrame.getApplicationBaseRules().getMatrixHeader(matrixID);
        return m.getMeasure();
    }

    /**
     * Get matrix content calculated by operator and value
     *
     * @param matrixId   , Matrix Identification Id
     * @param operatorId , Operator Identification Id
     * @param value      , Value
     * @return List<Matrix>
     * @throws Exception , Exception
     */
    private List<Matrix> getMatrixCellContentCalculated(int matrixId, int operatorId, BigDecimal value) throws Exception {

        try {

            // Search matrix cells
            //			this.matrixEAO = new MatrixPersistenceEAO();

            List<Matrix> matrixCells = matrixEAO.findMatrixCellsById(matrixId);

            for (Matrix cell : matrixCells) {

                if (operatorId == TypeOperands.ADD.getValue())
                    cell.setPrice(new BigDecimal(cell.getPrice()).add(value).toString());

                if (operatorId == TypeOperands.SUBSTRACT.getValue())
                    cell.setPrice(new BigDecimal(cell.getPrice()).subtract(value).toString());

                if (operatorId == TypeOperands.MULTIPLY.getValue())
                    cell.setPrice(new BigDecimal(cell.getPrice()).multiply(value).toString());

                if (operatorId == TypeOperands.DIVIDE.getValue())
                    cell.setPrice(new BigDecimal(cell.getPrice()).divide(value).toString());
            }

            return matrixCells;

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage() + " MatrixID = " + matrixId, e);
        }
    }

    /**
     * Get row column matrix value
     *
     * @param rowColumnTypeId , Row type Identification
     * @return BigDecimal
     * @throws Exception , Exception
     */
    private Object getRowColumnMatrixValue(int rowColumnTypeId, boolean forPrice, boolean forRow) throws Exception {

        Object rowMatrixValue = new Object();

        // Searching Type matrix diccionary
        TypeMatrixDiccionary typeMatrixDiccionary = ItemFrame.getApplicationBaseRules().getTypeMatrixDictionary(rowColumnTypeId);

        switch (rowColumnTypeId) {

            case 1:  // Opening Class
                rowMatrixValue = matrixCalculation.returnOpeningClassID();

                break;

            case 2: // None
                rowMatrixValue = typeMatrixDiccionary.getDescription();

                break;

            case 3: // Shape
                rowMatrixValue = matrixCalculation.returnShapeID();

                break;

            case 4: // Option
                int optionid = 0;

                if (forRow) {
                    optionid = this.matrixHeader.getRowOptionId();
                } else {
                    optionid = this.matrixHeader.getColumnOptionId();
                }

                System.out.println("Option ID = "+ optionid + "   \n");
                
                rowMatrixValue = matrixCalculation.returnOptionAndAnswer(optionid, matrixHeader.getMeasure());

                break;

            case 6: // SUType
                rowMatrixValue = matrixCalculation instanceof GlassSU ?
                        ((GlassSU) matrixCalculation).returnGlassSUID() : new BigDecimal(-1);

                break;

            case 7: // User defined opening name
                rowMatrixValue = matrixCalculation.returnUserDefinedOpeningID();

                break;

            case 8: //
                rowMatrixValue = matrixCalculation.returnSUFamiles();

                break;

            case 11: // Grid type DLO
                rowMatrixValue = matrixCalculation.returnGridType();

                break;

            case 12: // Partner
                rowMatrixValue = new BigDecimal(this.myItemFrame.myCustomer.getId());

                break;

            case 13: // Partner group Identification
                rowMatrixValue = new BigDecimal(this.myItemFrame.myCustomer.getGroupId());

                break;

            case 14: // Design
                rowMatrixValue = new BigDecimal(myItemFrame.jobItem.designID);

                break;

            case 15: // Std. product
                rowMatrixValue = new BigDecimal(myItemFrame.jobItem.stdProdCode);

                break;

            case 22: // Width
                rowMatrixValue = matrixCalculation.calculateWidth(matrixHeader.getMeasure());

                break;

            case 23: // Height

                rowMatrixValue = matrixCalculation.calculateHeight(matrixHeader.getMeasure());

                break;

            case 24: // UI
                rowMatrixValue = matrixCalculation.calculateUI(matrixHeader.getMeasure());

                break;

            case 25: // Area

                rowMatrixValue = matrixCalculation.calculateArea(matrixHeader.getMeasure());

                break;

            case 26: // Grids W dlo.noGFridsH, W, S , R
                rowMatrixValue = matrixCalculation.returnNumberGridsW();

                break;

            case 27: // Grids H
                rowMatrixValue = matrixCalculation.returnNumberGridsH();

                break;

            case 28: // Date
                rowMatrixValue = returnDate();

                break;

            case 29: // No. spokes
                rowMatrixValue = matrixCalculation.returnNumberSpokes();

                break;

            case 30: // No. of Radii
                rowMatrixValue = matrixCalculation.returnNumberRadii();

                break;

            case 31: // Product type // ms tardeFrom Design :
                rowMatrixValue = matrixCalculation.returnProductType();

                break;

            case 32: // Length
                // Only for ProfileParts - mullion, Coupler, Divider in Design.
                rowMatrixValue = matrixCalculation.calculateLength(matrixHeader.getMeasure());

                break;

            case 34: // Quantity
                // Not For Shape Object - Need to send QTY from Cart
                rowMatrixValue = new BigDecimal(-1);

                break;

            case 35: // Volume
                // Only for CartItems not Designs
                rowMatrixValue = new BigDecimal(-1);

                break;

            case 36: //
                rowMatrixValue = new BigDecimal(-1);

                break;

            case 43: //
                rowMatrixValue = this.netListRatio;

                break;

            default:
                rowMatrixValue = new BigDecimal(-1);

                break;
        }

        return rowMatrixValue;
    }

    public String returnDate() {
        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        return currentDate.toString();
    }


}
