package dto;

import Model.ShapeNotes;
import Model.ShapeObject;
import Presentation.ItemFrame;
import openjanela.model.entities.design.*;
import openjanela.model.entities.admin.MathOperator;
import openjanela.model.entities.admin.MathOperators;
import openjanela.model.entities.parts.PartsLabelPos;
import org.apache.log4j.Logger;
import org.openjanela.data.ApplicationBaseApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-02-13
 *          Time: 02:10 PM
 */
public class ShapeNotesDTO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(ShapeNotesDTO.class);

    /**
     * Return Shape Notes entity class
     *
     * @param shapeNotes, ShapeNotes
     * @return ShapeNotesEntityObject
     * @throws DTOTransformationError, Error
     */
    public static ShapeNotesEntityObject getShapeNotesEntityObject(ShapeNotes shapeNotes) throws DTOTransformationError {

        if (shapeNotes == null) {
            throw new DTOTransformationError();
        }

        //**************************************************************************
        //Creating and applying transformation
        //**************************************************************************
        ShapeNotesEntityObject shapeNotesEntity = new ShapeNotesEntityObject();

        shapeNotesEntity.setAssemblyLevelId(shapeNotes.a_assemblyLevel);
        shapeNotesEntity.setLevelId(shapeNotes.a_levelID);
        shapeNotesEntity.setSequenceId(shapeNotes.a_sequenceID);
        shapeNotesEntity.setLevel1(shapeNotes.a_1Level);
        shapeNotesEntity.setLevel2(shapeNotes.a_2Level);
        shapeNotesEntity.setLevel3(shapeNotes.a_3Level);
        shapeNotesEntity.setLevel4(shapeNotes.a_4Level);
        shapeNotesEntity.setLevel5(shapeNotes.a_5Level);
        shapeNotesEntity.setLevel6(shapeNotes.a_6Level);
        shapeNotesEntity.setLevel7(shapeNotes.a_7Level);
        shapeNotesEntity.setLevel8(shapeNotes.a_8Level);
        shapeNotesEntity.setLevel9(shapeNotes.a_9Level);
        shapeNotesEntity.setLevel10(shapeNotes.a_10Level);
        shapeNotesEntity.setLevel11(shapeNotes.a_11Level);
        shapeNotesEntity.setLevel12(shapeNotes.a_12Level);
        shapeNotesEntity.setLevel13(shapeNotes.a_13Level);
        shapeNotesEntity.setLevel14(shapeNotes.a_14Level);
        shapeNotesEntity.setLevel15(shapeNotes.a_15Level);
        shapeNotesEntity.setLevel16(shapeNotes.a_16Level);
        shapeNotesEntity.setLevel17(shapeNotes.a_17Level);
        shapeNotesEntity.setLevel18(shapeNotes.a_18Level);
        shapeNotesEntity.setLevel19(shapeNotes.a_19Level);
        shapeNotesEntity.setLevel20(shapeNotes.a_20Level);
        shapeNotesEntity.setLevel21(shapeNotes.a_21Level);
        shapeNotesEntity.setLevel22(shapeNotes.a_22Level);
        shapeNotesEntity.setSequence1(shapeNotes.a_1Sequence);
        shapeNotesEntity.setSequence2(shapeNotes.a_2Sequence);
        shapeNotesEntity.setSequence3(shapeNotes.a_3Sequence);
        shapeNotesEntity.setSequence4(shapeNotes.a_4Sequence);
        shapeNotesEntity.setSequence5(shapeNotes.a_5Sequence);
        shapeNotesEntity.setSequence6(shapeNotes.a_6Sequence);
        shapeNotesEntity.setSequence7(shapeNotes.a_7Sequence);
        shapeNotesEntity.setSequence8(shapeNotes.a_8Sequence);
        shapeNotesEntity.setSequence9(shapeNotes.a_9Sequence);
        shapeNotesEntity.setSequence10(shapeNotes.a_10Sequence);
        shapeNotesEntity.setSequence11(shapeNotes.a_11Sequence);
        shapeNotesEntity.setSequence12(shapeNotes.a_12Sequence);
        shapeNotesEntity.setSequence13(shapeNotes.a_13Sequence);
        shapeNotesEntity.setSequence14(shapeNotes.a_14Sequence);
        shapeNotesEntity.setSequence15(shapeNotes.a_15Sequence);
        shapeNotesEntity.setSequence16(shapeNotes.a_16Sequence);
        shapeNotesEntity.setSequence17(shapeNotes.a_17Sequence);
        shapeNotesEntity.setSequence18(shapeNotes.a_18Sequence);
        shapeNotesEntity.setSequence19(shapeNotes.a_19Sequence);
        shapeNotesEntity.setSequence20(shapeNotes.a_20Sequence);
        shapeNotesEntity.setSequence21(shapeNotes.a_21Sequence);
        shapeNotesEntity.setSequence22(shapeNotes.a_22Sequence);

        shapeNotesEntity.setOrderId(shapeNotes.orderid);
        shapeNotesEntity.setItemNo(shapeNotes.itemno);
        shapeNotesEntity.setVersionId(shapeNotes.versionid);

        shapeNotesEntity.setRuleNo(shapeNotes.ruleno);
        shapeNotesEntity.setSeriesId(shapeNotes.seriesid);
        shapeNotesEntity.setPartId(shapeNotes.partid);
        shapeNotesEntity.setLevel(shapeNotes.level);
        shapeNotesEntity.setPosition(shapeNotes.position);
        shapeNotesEntity.setOrientation(shapeNotes.orientation);
        shapeNotesEntity.setOpeningId(shapeNotes.openingid);
        shapeNotesEntity.setSashId(shapeNotes.sash);
        shapeNotesEntity.setRow(shapeNotes.row);
        shapeNotesEntity.setCol(shapeNotes.col);
        shapeNotesEntity.setAssembly(shapeNotes.assemblyid);
        shapeNotesEntity.setParentAssembly(shapeNotes.parentAssembly);

        shapeNotesEntity.setFrameDescription(shapeNotes.frameDescription);
        shapeNotesEntity.setFrameStockCode(shapeNotes.frameStockCode);
        shapeNotesEntity.setGlassDescription(shapeNotes.glassDescription);
        shapeNotesEntity.setGlassStockCode(shapeNotes.glassStockCode);
        shapeNotesEntity.setSuType(shapeNotes.suType);

        shapeNotesEntity.setStockCode(shapeNotes.stockcode);
        shapeNotesEntity.setDescription(shapeNotes.description);
        shapeNotesEntity.setValue(shapeNotes.value);
        shapeNotesEntity.setShowQty(shapeNotes.showQty);

        shapeNotesEntity.setSupplierId(shapeNotes.supplierId);
        shapeNotesEntity.setSupplierSeriesId(shapeNotes.supplierSeriesId);
        shapeNotesEntity.setRemote(shapeNotes.remote);

        return shapeNotesEntity;
    }

    /**
     * Return Shape Notes Model Object
     *
     * @param shapeNotesEntity, ShapeNotesEntityObject
     * @return ShapeNotes
     * @throws DTOTransformationError, Error
     */
    public static ShapeNotes getShapeNotesModel(ShapeNotesEntityObject shapeNotesEntity) throws DTOTransformationError {

        if (shapeNotesEntity == null) {
            throw new DTOTransformationError();
        }

        ShapeNotes shapeNotes = new ShapeNotes();
        shapeNotes.a_levelID = shapeNotesEntity.getLevelId();
        shapeNotes.a_sequenceID = shapeNotesEntity.getSequenceId();
        shapeNotes.a_assemblyLevel = shapeNotesEntity.getAssemblyLevelId();
        shapeNotes.a_1Level = shapeNotesEntity.getLevel1();
        shapeNotes.a_1Sequence = shapeNotesEntity.getSequence1();
        shapeNotes.a_2Level = shapeNotesEntity.getLevel2();
        shapeNotes.a_2Sequence = shapeNotesEntity.getSequence2();
        shapeNotes.a_3Level = shapeNotesEntity.getLevel3();
        shapeNotes.a_3Sequence = shapeNotesEntity.getSequence3();
        shapeNotes.a_4Level = shapeNotesEntity.getLevel4();
        shapeNotes.a_4Sequence = shapeNotesEntity.getSequence4();
        shapeNotes.a_5Level = shapeNotesEntity.getLevel5();
        shapeNotes.a_5Sequence = shapeNotesEntity.getSequence5();
        shapeNotes.a_6Level = shapeNotesEntity.getLevel6();
        shapeNotes.a_6Sequence = shapeNotesEntity.getSequence6();
        shapeNotes.a_7Level = shapeNotesEntity.getLevel7();
        shapeNotes.a_7Sequence = shapeNotesEntity.getSequence7();
        shapeNotes.a_8Level = shapeNotesEntity.getLevel8();
        shapeNotes.a_8Sequence = shapeNotesEntity.getSequence8();
        shapeNotes.a_9Level = shapeNotesEntity.getLevel9();
        shapeNotes.a_9Sequence = shapeNotesEntity.getSequence9();
        shapeNotes.a_10Level = shapeNotesEntity.getLevel10();
        shapeNotes.a_10Sequence = shapeNotesEntity.getSequence10();
        shapeNotes.a_11Level = shapeNotesEntity.getLevel11();
        shapeNotes.a_11Sequence = shapeNotesEntity.getSequence11();
        shapeNotes.a_12Level = shapeNotesEntity.getLevel12();
        shapeNotes.a_12Sequence = shapeNotesEntity.getSequence12();
        shapeNotes.a_13Level = shapeNotesEntity.getLevel13();
        shapeNotes.a_13Sequence = shapeNotesEntity.getSequence13();
        shapeNotes.a_14Level = shapeNotesEntity.getLevel14();
        shapeNotes.a_14Sequence = shapeNotesEntity.getSequence14();
        shapeNotes.a_15Level = shapeNotesEntity.getLevel15();
        shapeNotes.a_15Sequence = shapeNotesEntity.getSequence15();
        shapeNotes.a_16Level = shapeNotesEntity.getLevel16();
        shapeNotes.a_16Sequence = shapeNotesEntity.getSequence16();
        shapeNotes.a_17Level = shapeNotesEntity.getLevel17();
        shapeNotes.a_17Sequence = shapeNotesEntity.getSequence17();
        shapeNotes.a_18Level = shapeNotesEntity.getLevel18();
        shapeNotes.a_18Sequence = shapeNotesEntity.getSequence18();
        shapeNotes.a_19Level = shapeNotesEntity.getLevel19();
        shapeNotes.a_19Sequence = shapeNotesEntity.getSequence19();
        shapeNotes.a_20Level = shapeNotesEntity.getLevel20();
        shapeNotes.a_20Sequence = shapeNotesEntity.getSequence20();
        shapeNotes.a_21Level = shapeNotesEntity.getLevel21();
        shapeNotes.a_21Sequence = shapeNotesEntity.getSequence21();
        shapeNotes.a_22Level = shapeNotesEntity.getLevel22();
        shapeNotes.a_22Sequence = shapeNotesEntity.getSequence22();

        shapeNotes.orderid = shapeNotesEntity.getOrderId();
        shapeNotes.itemno = shapeNotesEntity.getItemNo();
        shapeNotes.versionid = shapeNotesEntity.getVersionId();

        shapeNotes.ruleno = shapeNotesEntity.getRuleNo();
        shapeNotes.seriesid = shapeNotesEntity.getSeriesId();
        shapeNotes.partid = shapeNotesEntity.getPartId();
        shapeNotes.level = shapeNotesEntity.getLevel();
        shapeNotes.position = shapeNotesEntity.getPosition();
        shapeNotes.orientation = shapeNotesEntity.getOrientation();
        shapeNotes.openingid = shapeNotesEntity.getOpeningId();
        shapeNotes.sash = shapeNotesEntity.getSashId();
        shapeNotes.row = shapeNotesEntity.getRow();
        shapeNotes.col = shapeNotesEntity.getCol();
        shapeNotes.assemblyid = shapeNotesEntity.getAssembly();
        shapeNotes.parentAssembly = shapeNotesEntity.getParentAssembly();

        shapeNotes.stockcode = shapeNotesEntity.getStockCode();
        shapeNotes.description = shapeNotesEntity.getDescription();
        shapeNotes.value = shapeNotesEntity.getValue();
        shapeNotes.showQty = shapeNotesEntity.isShowQty();

        shapeNotes.supplierId = shapeNotesEntity.getSupplierId();
        shapeNotes.supplierSeriesId = shapeNotesEntity.getSupplierSeriesId();
        shapeNotes.remote = shapeNotesEntity.isRemote();

        return shapeNotes;
    }

    /**
     * Evaluate if BillOfMaterialEntityObject is a parent bom for ShapeNotes
     *
     * @param shapeNotesEntity, ShapeNotesEntityObject
     * @param billOfMaterial,   BillOfMaterialEntityObject
     * @return boolean
     * @throws DTOTransformationError, Exception
     */
    public static boolean isParentBom(ShapeNotesEntityObject shapeNotesEntity, BillOfMaterialEntityObject billOfMaterial)
            throws DTOTransformationError {

        if (shapeNotesEntity == null) {
            throw new DTOTransformationError();
        }

        if (billOfMaterial == null) {
            throw new DTOTransformationError();
        }

            /* Evaluate Properties values for both objects */
        if (shapeNotesEntity.getLevelId() != billOfMaterial.getLevelId()) return false;
        if (shapeNotesEntity.getSequenceId() != billOfMaterial.getSequenceId()) return false;
        if (shapeNotesEntity.getAssemblyLevelId() != billOfMaterial.getConstructionMap().get_a_assemblyLevel()) return false;
        if (shapeNotesEntity.getLevel1() != billOfMaterial.getConstructionMap().get_a_1Level()) return false;
        if (shapeNotesEntity.getLevel2() != billOfMaterial.getConstructionMap().get_a_2Level()) return false;
        if (shapeNotesEntity.getLevel3() != billOfMaterial.getConstructionMap().get_a_3Level()) return false;
        if (shapeNotesEntity.getLevel4() != billOfMaterial.getConstructionMap().get_a_4Level()) return false;
        if (shapeNotesEntity.getLevel5() != billOfMaterial.getConstructionMap().get_a_5Level()) return false;
        if (shapeNotesEntity.getLevel6() != billOfMaterial.getConstructionMap().get_a_6Level()) return false;
        if (shapeNotesEntity.getLevel7() != billOfMaterial.getConstructionMap().get_a_7Level()) return false;
        if (shapeNotesEntity.getLevel8() != billOfMaterial.getConstructionMap().get_a_8Level()) return false;
        if (shapeNotesEntity.getLevel9() != billOfMaterial.getConstructionMap().get_a_9Level()) return false;
        if (shapeNotesEntity.getLevel10() != billOfMaterial.getConstructionMap().get_a_10Level()) return false;
        if (shapeNotesEntity.getLevel11() != billOfMaterial.getConstructionMap().get_a_11Level()) return false;
        if (shapeNotesEntity.getLevel12() != billOfMaterial.getConstructionMap().get_a_12Level()) return false;
        if (shapeNotesEntity.getLevel13() != billOfMaterial.getConstructionMap().get_a_13Level()) return false;
        if (shapeNotesEntity.getLevel14() != billOfMaterial.getConstructionMap().get_a_14Level()) return false;
        if (shapeNotesEntity.getLevel15() != billOfMaterial.getConstructionMap().get_a_15Level()) return false;
        if (shapeNotesEntity.getLevel16() != billOfMaterial.getConstructionMap().get_a_16Level()) return false;
        if (shapeNotesEntity.getLevel17() != billOfMaterial.getConstructionMap().get_a_17Level()) return false;
        if (shapeNotesEntity.getLevel18() != billOfMaterial.getConstructionMap().get_a_18Level()) return false;
        if (shapeNotesEntity.getLevel19() != billOfMaterial.getConstructionMap().get_a_19Level()) return false;
        if (shapeNotesEntity.getLevel20() != billOfMaterial.getConstructionMap().get_a_20Level()) return false;
        if (shapeNotesEntity.getLevel21() != billOfMaterial.getConstructionMap().get_a_21Level()) return false;
        if (shapeNotesEntity.getLevel22() != billOfMaterial.getConstructionMap().get_a_22Level()) return false;
        if (shapeNotesEntity.getSequence1() != billOfMaterial.getConstructionMap().get_a_1Sequence()) return false;
        if (shapeNotesEntity.getSequence2() != billOfMaterial.getConstructionMap().get_a_2Sequence()) return false;
        if (shapeNotesEntity.getSequence3() != billOfMaterial.getConstructionMap().get_a_3Sequence()) return false;
        if (shapeNotesEntity.getSequence4() != billOfMaterial.getConstructionMap().get_a_4Sequence()) return false;
        if (shapeNotesEntity.getSequence5() != billOfMaterial.getConstructionMap().get_a_5Sequence()) return false;
        if (shapeNotesEntity.getSequence6() != billOfMaterial.getConstructionMap().get_a_6Sequence()) return false;
        if (shapeNotesEntity.getSequence7() != billOfMaterial.getConstructionMap().get_a_7Sequence()) return false;
        if (shapeNotesEntity.getSequence8() != billOfMaterial.getConstructionMap().get_a_8Sequence()) return false;
        if (shapeNotesEntity.getSequence9() != billOfMaterial.getConstructionMap().get_a_9Sequence()) return false;
        if (shapeNotesEntity.getSequence10() != billOfMaterial.getConstructionMap().get_a_10Sequence()) return false;
        if (shapeNotesEntity.getSequence11() != billOfMaterial.getConstructionMap().get_a_11Sequence()) return false;
        if (shapeNotesEntity.getSequence12() != billOfMaterial.getConstructionMap().get_a_12Sequence()) return false;
        if (shapeNotesEntity.getSequence13() != billOfMaterial.getConstructionMap().get_a_13Sequence()) return false;
        if (shapeNotesEntity.getSequence14() != billOfMaterial.getConstructionMap().get_a_14Sequence()) return false;
        if (shapeNotesEntity.getSequence15() != billOfMaterial.getConstructionMap().get_a_15Sequence()) return false;
        if (shapeNotesEntity.getSequence16() != billOfMaterial.getConstructionMap().get_a_16Sequence()) return false;
        if (shapeNotesEntity.getSequence17() != billOfMaterial.getConstructionMap().get_a_17Sequence()) return false;
        if (shapeNotesEntity.getSequence18() != billOfMaterial.getConstructionMap().get_a_18Sequence()) return false;
        if (shapeNotesEntity.getSequence19() != billOfMaterial.getConstructionMap().get_a_19Sequence()) return false;
        if (shapeNotesEntity.getSequence20() != billOfMaterial.getConstructionMap().get_a_20Sequence()) return false;
        if (shapeNotesEntity.getSequence21() != billOfMaterial.getConstructionMap().get_a_21Sequence()) return false;
        if (shapeNotesEntity.getSequence22() != billOfMaterial.getConstructionMap().get_a_22Sequence()) return false;

        if (shapeNotesEntity.getRuleNo() != billOfMaterial.getRuleNo()) return false;
        if (shapeNotesEntity.getPartId() != billOfMaterial.getPartId()) return false;
        if (shapeNotesEntity.getLevel() != billOfMaterial.getLevel()) return false;
        if (shapeNotesEntity.getPosition() != billOfMaterial.getPosition()) return false;
        if (shapeNotesEntity.getOrientation() != billOfMaterial.getOrientation()) return false;
        if (shapeNotesEntity.getOpeningId() != billOfMaterial.getOpeningId()) return false;
        if (shapeNotesEntity.getSashId() != billOfMaterial.getSash()) return false;
        if (shapeNotesEntity.getRow() != billOfMaterial.getRow()) return false;
        if (shapeNotesEntity.getCol() != billOfMaterial.getCol()) return false;
        if (shapeNotesEntity.getAssembly() != billOfMaterial.getAssemblyId()) return false;
        if (shapeNotesEntity.getParentAssembly() != billOfMaterial.getParentAssemblyId()) return false;
        if (!shapeNotesEntity.getStockCode().trim().equals(billOfMaterial.getStockCode().trim())) return false;
        if (!shapeNotesEntity.getDescription().trim().equals(billOfMaterial.getDescription().trim())) return false;
        if (shapeNotesEntity.getValue() != billOfMaterial.getQty()) return false;

        return true;

    }

    /**
     * Evaluate if ShapeObject is a parent for ShapeNotes
     *
     * @param shapeNotes,  ShapeNotes
     * @param shapeObject, ShapeObject
     * @return boolean
     */
    public static boolean isParentShapeObject(ShapeNotes shapeNotes, ShapeObject shapeObject) throws DTOTransformationError {

        if (shapeNotes == null) {
            throw new DTOTransformationError();
        }

        if (shapeObject == null) {
            throw new DTOTransformationError();
        }

        /* Evaluate Properties values 1for both objects */
        if (shapeNotes.a_levelID != shapeObject.a_levelID) return false;
        if (shapeNotes.a_sequenceID != shapeObject.a_sequenceID) return false;
        if (shapeNotes.a_assemblyLevel != shapeObject.a_assemblyLevel) return false;
        if (shapeNotes.a_1Level != shapeObject.a_1Level) return false;
        if (shapeNotes.a_2Level != shapeObject.a_2Level) return false;
        if (shapeNotes.a_3Level != shapeObject.a_3Level) return false;
        if (shapeNotes.a_4Level != shapeObject.a_4Level) return false;
        if (shapeNotes.a_5Level != shapeObject.a_5Level) return false;
        if (shapeNotes.a_6Level != shapeObject.a_6Level) return false;
        if (shapeNotes.a_7Level != shapeObject.a_7Level) return false;
        if (shapeNotes.a_8Level != shapeObject.a_8Level) return false;
        if (shapeNotes.a_9Level != shapeObject.a_9Level) return false;
        if (shapeNotes.a_10Level != shapeObject.a_10Level) return false;
        if (shapeNotes.a_11Level != shapeObject.a_11Level) return false;
        if (shapeNotes.a_12Level != shapeObject.a_12Level) return false;
        if (shapeNotes.a_13Level != shapeObject.a_13Level) return false;
        if (shapeNotes.a_14Level != shapeObject.a_14Level) return false;
        if (shapeNotes.a_15Level != shapeObject.a_15Level) return false;
        if (shapeNotes.a_16Level != shapeObject.a_16Level) return false;
        if (shapeNotes.a_17Level != shapeObject.a_17Level) return false;
        if (shapeNotes.a_18Level != shapeObject.a_18Level) return false;
        if (shapeNotes.a_19Level != shapeObject.a_19Level) return false;
        if (shapeNotes.a_20Level != shapeObject.a_20Level) return false;
        if (shapeNotes.a_21Level != shapeObject.a_21Level) return false;
        if (shapeNotes.a_22Level != shapeObject.a_22Level) return false;
        if (shapeNotes.a_1Sequence != shapeObject.a_1Sequence) return false;
        if (shapeNotes.a_2Sequence != shapeObject.a_2Sequence) return false;
        if (shapeNotes.a_3Sequence != shapeObject.a_3Sequence) return false;
        if (shapeNotes.a_4Sequence != shapeObject.a_4Sequence) return false;
        if (shapeNotes.a_5Sequence != shapeObject.a_5Sequence) return false;
        if (shapeNotes.a_6Sequence != shapeObject.a_6Sequence) return false;
        if (shapeNotes.a_7Sequence != shapeObject.a_7Sequence) return false;
        if (shapeNotes.a_8Sequence != shapeObject.a_8Sequence) return false;
        if (shapeNotes.a_9Sequence != shapeObject.a_9Sequence) return false;
        if (shapeNotes.a_10Sequence != shapeObject.a_10Sequence) return false;
        if (shapeNotes.a_11Sequence != shapeObject.a_11Sequence) return false;
        if (shapeNotes.a_12Sequence != shapeObject.a_12Sequence) return false;
        if (shapeNotes.a_13Sequence != shapeObject.a_13Sequence) return false;
        if (shapeNotes.a_14Sequence != shapeObject.a_14Sequence) return false;
        if (shapeNotes.a_15Sequence != shapeObject.a_15Sequence) return false;
        if (shapeNotes.a_16Sequence != shapeObject.a_16Sequence) return false;
        if (shapeNotes.a_17Sequence != shapeObject.a_17Sequence) return false;
        if (shapeNotes.a_18Sequence != shapeObject.a_18Sequence) return false;
        if (shapeNotes.a_19Sequence != shapeObject.a_19Sequence) return false;
        if (shapeNotes.a_20Sequence != shapeObject.a_20Sequence) return false;
        if (shapeNotes.a_21Sequence != shapeObject.a_21Sequence) return false;
        if (shapeNotes.a_22Sequence != shapeObject.a_22Sequence) return false;

        return true;   

    }

    /**
     * Evaluate if ShapeObject is a parent for ShapeNotes
     *
     * @param shapeNotesEntity, ShapeNotesEntityObject
     * @param shapeObject,      ShapeAbstractObject
     * @return boolean
     * @throws DTOTransformationError, Exception
     */
    public static boolean isParentShapeEntityObject(ShapeNotesEntityObject shapeNotesEntity, ShapeAbstractObject shapeObject)
            throws DTOTransformationError {

        if (shapeNotesEntity == null) {
            throw new DTOTransformationError();
        }

        if (shapeObject == null) {
            throw new DTOTransformationError();
        }

        /* Evaluate Properties values 1for both objects */
        if (shapeNotesEntity.getLevelId() != shapeObject.getLevelId()) return false;
        if (shapeNotesEntity.getSequenceId() != shapeObject.getSequenceId()) return false;
        if (shapeNotesEntity.getAssemblyLevelId() != shapeObject.getConstructionMap().get_a_assemblyLevel())
            return false;
        if (shapeNotesEntity.getLevel1() != shapeObject.getConstructionMap().get_a_1Level()) return false;
        if (shapeNotesEntity.getLevel2() != shapeObject.getConstructionMap().get_a_2Level()) return false;
        if (shapeNotesEntity.getLevel3() != shapeObject.getConstructionMap().get_a_3Level()) return false;
        if (shapeNotesEntity.getLevel4() != shapeObject.getConstructionMap().get_a_4Level()) return false;
        if (shapeNotesEntity.getLevel5() != shapeObject.getConstructionMap().get_a_5Level()) return false;
        if (shapeNotesEntity.getLevel6() != shapeObject.getConstructionMap().get_a_6Level()) return false;
        if (shapeNotesEntity.getLevel7() != shapeObject.getConstructionMap().get_a_7Level()) return false;
        if (shapeNotesEntity.getLevel8() != shapeObject.getConstructionMap().get_a_8Level()) return false;
        if (shapeNotesEntity.getLevel9() != shapeObject.getConstructionMap().get_a_9Level()) return false;
        if (shapeNotesEntity.getLevel10() != shapeObject.getConstructionMap().get_a_10Level()) return false;
        if (shapeNotesEntity.getLevel11() != shapeObject.getConstructionMap().get_a_11Level()) return false;
        if (shapeNotesEntity.getLevel12() != shapeObject.getConstructionMap().get_a_12Level()) return false;
        if (shapeNotesEntity.getLevel13() != shapeObject.getConstructionMap().get_a_13Level()) return false;
        if (shapeNotesEntity.getLevel14() != shapeObject.getConstructionMap().get_a_14Level()) return false;
        if (shapeNotesEntity.getLevel15() != shapeObject.getConstructionMap().get_a_15Level()) return false;
        if (shapeNotesEntity.getLevel16() != shapeObject.getConstructionMap().get_a_16Level()) return false;
        if (shapeNotesEntity.getLevel17() != shapeObject.getConstructionMap().get_a_17Level()) return false;
        if (shapeNotesEntity.getLevel18() != shapeObject.getConstructionMap().get_a_18Level()) return false;
        if (shapeNotesEntity.getLevel19() != shapeObject.getConstructionMap().get_a_19Level()) return false;
        if (shapeNotesEntity.getLevel20() != shapeObject.getConstructionMap().get_a_20Level()) return false;
        if (shapeNotesEntity.getLevel21() != shapeObject.getConstructionMap().get_a_21Level()) return false;
        if (shapeNotesEntity.getLevel22() != shapeObject.getConstructionMap().get_a_22Level()) return false;
        if (shapeNotesEntity.getSequence1() != shapeObject.getConstructionMap().get_a_1Sequence()) return false;
        if (shapeNotesEntity.getSequence2() != shapeObject.getConstructionMap().get_a_2Sequence()) return false;
        if (shapeNotesEntity.getSequence3() != shapeObject.getConstructionMap().get_a_3Sequence()) return false;
        if (shapeNotesEntity.getSequence4() != shapeObject.getConstructionMap().get_a_4Sequence()) return false;
        if (shapeNotesEntity.getSequence5() != shapeObject.getConstructionMap().get_a_5Sequence()) return false;
        if (shapeNotesEntity.getSequence6() != shapeObject.getConstructionMap().get_a_6Sequence()) return false;
        if (shapeNotesEntity.getSequence7() != shapeObject.getConstructionMap().get_a_7Sequence()) return false;
        if (shapeNotesEntity.getSequence8() != shapeObject.getConstructionMap().get_a_8Sequence()) return false;
        if (shapeNotesEntity.getSequence9() != shapeObject.getConstructionMap().get_a_9Sequence()) return false;
        if (shapeNotesEntity.getSequence10() != shapeObject.getConstructionMap().get_a_10Sequence()) return false;
        if (shapeNotesEntity.getSequence11() != shapeObject.getConstructionMap().get_a_11Sequence()) return false;
        if (shapeNotesEntity.getSequence12() != shapeObject.getConstructionMap().get_a_12Sequence()) return false;
        if (shapeNotesEntity.getSequence13() != shapeObject.getConstructionMap().get_a_13Sequence()) return false;
        if (shapeNotesEntity.getSequence14() != shapeObject.getConstructionMap().get_a_14Sequence()) return false;
        if (shapeNotesEntity.getSequence15() != shapeObject.getConstructionMap().get_a_15Sequence()) return false;
        if (shapeNotesEntity.getSequence16() != shapeObject.getConstructionMap().get_a_16Sequence()) return false;
        if (shapeNotesEntity.getSequence17() != shapeObject.getConstructionMap().get_a_17Sequence()) return false;
        if (shapeNotesEntity.getSequence18() != shapeObject.getConstructionMap().get_a_18Sequence()) return false;
        if (shapeNotesEntity.getSequence19() != shapeObject.getConstructionMap().get_a_19Sequence()) return false;
        if (shapeNotesEntity.getSequence20() != shapeObject.getConstructionMap().get_a_20Sequence()) return false;
        if (shapeNotesEntity.getSequence21() != shapeObject.getConstructionMap().get_a_21Sequence()) return false;
        if (shapeNotesEntity.getSequence22() != shapeObject.getConstructionMap().get_a_22Sequence()) return false;

        return true;
    }

    /**
     * Return Better fenestration rating value
     *
     * @param frameEntity, Frame Entity Object
     * @param notes,       Shape Notes Collection
     * @param remote,      Indicate if the part is from external supplier
     * @return double
     */
    public static DesignGlassRatingsEntityObject getFenestrationRatingValue(FrameEntityObject frameEntity,
                                                                            List<ShapeNotesEntityObject> notes,
                                                                            int supplierId, boolean remote) {
        String glassDescription = "";
        String glassStockCode = "";

        int suType = 0;
        int seriesId = 0;

        //*******************************************************************************************************
        //Group Notes by Parts Label Position
        //*******************************************************************************************************
        Map<Integer, List<ShapeNotesEntityObject>> notesLabels = new HashMap<Integer, List<ShapeNotesEntityObject>>();
        for (ShapeNotesEntityObject shapeNotes : notes) {

            //Part Type Identification
            int pos = 0;
            if (shapeNotes.isRemote()) {
                pos = ItemFrame.getApplicationRemoteBaseRules().getPart(shapeNotes.getSupplierId(), shapeNotes.getPartId()).
                        getLabel_pos();
            } else {
                pos = ItemFrame.getApplicationBase().getPart(shapeNotes.getPartId()).getLabel_pos();
            }

            if (notesLabels.get(pos) == null) {
                List<ShapeNotesEntityObject> values = new ArrayList<ShapeNotesEntityObject>();
                values.add(shapeNotes);

                notesLabels.put(pos, values);

            } else {

                List<ShapeNotesEntityObject> values = notesLabels.get(pos);
                values.add(shapeNotes);

                notesLabels.put(pos, values);
            }
        }

        //*******************************************************************************************************
        //Evaluate Notes Math Operator Evaluation
        //*******************************************************************************************************
        List<DesignRatingsLabel> designRatingsLabels = new ArrayList<DesignRatingsLabel>();
        for (Map.Entry<Integer, List<ShapeNotesEntityObject>> entry : notesLabels.entrySet()) {

            PartsLabelPos partsLabelPos = null;
            MathOperator mathOperator = null;

            if (remote) {
                partsLabelPos = ItemFrame.getApplicationRemoteBaseRules().getPartLabelPos(supplierId, entry.getKey());
                mathOperator = ApplicationBaseApp.getInstance().getMathEval(partsLabelPos.getMathOperatorId());
            } else {
                partsLabelPos = ItemFrame.getApplicationBase().getPartsLabelPos(entry.getKey());
                mathOperator = ItemFrame.getApplicationBase().getMathEval(partsLabelPos.getMathOperatorId());
            }

            //Final Value Process
            double value = 0.0;
            String stockCode = "";

            if (MathOperators.LESSER.getMathValue().trim().equalsIgnoreCase(mathOperator.getSymbol())) {

                for (ShapeNotesEntityObject shapeNotes : entry.getValue()) {

                    if (value == 0) {
                        value = shapeNotes.getValue();
                    }

                    if (shapeNotes.getValue() < value) {
                        value = shapeNotes.getValue();
                    }

                    //Update Glass StockCode & Glass Description
                    suType = shapeNotes.getSuType();
                    seriesId = shapeNotes.getSeriesId();
                    glassStockCode = shapeNotes.getGlassStockCode();
                    glassDescription = shapeNotes.getGlassDescription();
                }
            }

            if (MathOperators.GRATHER.getMathValue().trim().equalsIgnoreCase(mathOperator.getSymbol())) {

                for (ShapeNotesEntityObject shapeNotes : entry.getValue()) {

                    if (value == 0) {
                        value = shapeNotes.getValue();
                    }

                    if (shapeNotes.getValue() > value) {
                        value = shapeNotes.getValue();
                    }

                    //Update Glass StockCode & Glass Description
                    suType = shapeNotes.getSuType();
                    seriesId = shapeNotes.getSeriesId();
                    glassStockCode = shapeNotes.getGlassStockCode();
                    glassDescription = shapeNotes.getGlassDescription();
                }
            }

            if (MathOperators.EQUALS.getMathValue().trim().equals(mathOperator.getSymbol())) {

                for (ShapeNotesEntityObject shapeNotes : entry.getValue()) {

                    if (value == 0) {
                        value = shapeNotes.getValue();
                    }

                    if (shapeNotes.getValue() == value) {
                        stockCode = shapeNotes.getStockCode();
                    }

                    //Update Glass StockCode & Glass Description
                    suType = shapeNotes.getSuType();
                    seriesId = shapeNotes.getSeriesId();
                    glassStockCode = shapeNotes.getGlassStockCode();
                    glassDescription = shapeNotes.getGlassDescription();
                }
            }

            //************************************************************************************
            //Create Design Value Glass
            //************************************************************************************
            DesignRatingsLabel designRatingLabel = new DesignRatingsLabel();
            designRatingLabel.setValue(String.valueOf(value));
            if (!stockCode.equals("")) {
                designRatingLabel.setValue(stockCode);
            }
            designRatingLabel.setPartLabelId(partsLabelPos.getId());

            designRatingsLabels.add(designRatingLabel);
        }

        //Create Design Glass Ratings Object
        DesignGlassRatingsEntityObject designGlassRating = new DesignGlassRatingsEntityObject();
        designGlassRating.setSequenceId(frameEntity.getSequenceId());
        designGlassRating.setLevelId(frameEntity.getLevelId());
        designGlassRating.setAssemblyLevelId(frameEntity.getConstructionMap().get_a_assemblyLevel());

        designGlassRating.setLevel1(frameEntity.getConstructionMap().get_a_1Level());
        designGlassRating.setLevel2(frameEntity.getConstructionMap().get_a_2Level());
        designGlassRating.setLevel3(frameEntity.getConstructionMap().get_a_3Level());
        designGlassRating.setLevel4(frameEntity.getConstructionMap().get_a_4Level());
        designGlassRating.setLevel5(frameEntity.getConstructionMap().get_a_5Level());
        designGlassRating.setLevel6(frameEntity.getConstructionMap().get_a_6Level());
        designGlassRating.setLevel7(frameEntity.getConstructionMap().get_a_7Level());
        designGlassRating.setLevel8(frameEntity.getConstructionMap().get_a_8Level());
        designGlassRating.setLevel9(frameEntity.getConstructionMap().get_a_9Level());
        designGlassRating.setLevel10(frameEntity.getConstructionMap().get_a_10Level());
        designGlassRating.setLevel11(frameEntity.getConstructionMap().get_a_11Level());
        designGlassRating.setLevel12(frameEntity.getConstructionMap().get_a_12Level());
        designGlassRating.setLevel13(frameEntity.getConstructionMap().get_a_13Level());
        designGlassRating.setLevel14(frameEntity.getConstructionMap().get_a_14Level());
        designGlassRating.setLevel15(frameEntity.getConstructionMap().get_a_15Level());
        designGlassRating.setLevel16(frameEntity.getConstructionMap().get_a_16Level());
        designGlassRating.setLevel17(frameEntity.getConstructionMap().get_a_17Level());
        designGlassRating.setLevel18(frameEntity.getConstructionMap().get_a_18Level());
        designGlassRating.setLevel19(frameEntity.getConstructionMap().get_a_19Level());
        designGlassRating.setLevel20(frameEntity.getConstructionMap().get_a_20Level());
        designGlassRating.setLevel21(frameEntity.getConstructionMap().get_a_21Level());
        designGlassRating.setLevel22(frameEntity.getConstructionMap().get_a_22Level());
        designGlassRating.setSequence1(frameEntity.getConstructionMap().get_a_1Sequence());
        designGlassRating.setSequence2(frameEntity.getConstructionMap().get_a_2Sequence());
        designGlassRating.setSequence3(frameEntity.getConstructionMap().get_a_3Sequence());
        designGlassRating.setSequence4(frameEntity.getConstructionMap().get_a_4Sequence());
        designGlassRating.setSequence5(frameEntity.getConstructionMap().get_a_5Sequence());
        designGlassRating.setSequence6(frameEntity.getConstructionMap().get_a_6Sequence());
        designGlassRating.setSequence7(frameEntity.getConstructionMap().get_a_7Sequence());
        designGlassRating.setSequence8(frameEntity.getConstructionMap().get_a_8Sequence());
        designGlassRating.setSequence9(frameEntity.getConstructionMap().get_a_9Sequence());
        designGlassRating.setSequence10(frameEntity.getConstructionMap().get_a_10Sequence());
        designGlassRating.setSequence11(frameEntity.getConstructionMap().get_a_11Sequence());
        designGlassRating.setSequence12(frameEntity.getConstructionMap().get_a_12Sequence());
        designGlassRating.setSequence13(frameEntity.getConstructionMap().get_a_13Sequence());
        designGlassRating.setSequence14(frameEntity.getConstructionMap().get_a_14Sequence());
        designGlassRating.setSequence15(frameEntity.getConstructionMap().get_a_15Sequence());
        designGlassRating.setSequence16(frameEntity.getConstructionMap().get_a_16Sequence());
        designGlassRating.setSequence17(frameEntity.getConstructionMap().get_a_17Sequence());
        designGlassRating.setSequence18(frameEntity.getConstructionMap().get_a_18Sequence());
        designGlassRating.setSequence19(frameEntity.getConstructionMap().get_a_19Sequence());
        designGlassRating.setSequence20(frameEntity.getConstructionMap().get_a_20Sequence());
        designGlassRating.setSequence21(frameEntity.getConstructionMap().get_a_21Sequence());
        designGlassRating.setSequence22(frameEntity.getConstructionMap().get_a_22Sequence());

        designGlassRating.setFrameDescription("**");
        designGlassRating.setFrameStockCode("**");
        designGlassRating.setGlassDescription(glassDescription);
        designGlassRating.setGlassStockCode(glassStockCode);
        designGlassRating.setSuType(suType);
        designGlassRating.setSeriesId(seriesId);

        designGlassRating.setDesignRatings(designRatingsLabels);

        return designGlassRating;
    }
}
