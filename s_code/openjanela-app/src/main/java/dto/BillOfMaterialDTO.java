package dto;

import Model.BillOfMat;
import openjanela.model.entities.design.BillOfMaterialEntityObject;
import openjanela.model.entities.design.ConstructionMap;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 12-16-12
 * Time: 12:50 AM
 */
public class BillOfMaterialDTO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(BillOfMaterialEntityObject.class);

    /**
     * Return Bill Of Material entity class
     *
     * @param billOfMat, BillOfMat
     * @return BillOfMaterialEntityObject
     * @throws DTOTransformationError, Error
     */
    public static BillOfMaterialEntityObject getBillOfMaterialEntity(BillOfMat billOfMat) throws DTOTransformationError {

        if (billOfMat == null) {
            throw new DTOTransformationError();
        }

        //**************************************************************************
        //Creating and applying transformation
        //**************************************************************************
        BillOfMaterialEntityObject billOfMaterialEntity = new BillOfMaterialEntityObject();

        ConstructionMap constructionMap = new ConstructionMap();
        constructionMap.set_a_assemblyLevel(billOfMat.a_assemblyLevel);
        constructionMap.set_a_assemblySequence(billOfMat.a_sequenceID);
        constructionMap.set_a_1Level(billOfMat.a_1Level);
        constructionMap.set_a_2Level(billOfMat.a_2Level);
        constructionMap.set_a_3Level(billOfMat.a_3Level);
        constructionMap.set_a_4Level(billOfMat.a_4Level);
        constructionMap.set_a_5Level(billOfMat.a_5Level);
        constructionMap.set_a_6Level(billOfMat.a_6Level);
        constructionMap.set_a_7Level(billOfMat.a_7Level);
        constructionMap.set_a_8Level(billOfMat.a_8Level);
        constructionMap.set_a_9Level(billOfMat.a_9Level);
        constructionMap.set_a_10Level(billOfMat.a_10Level);
        constructionMap.set_a_11Level(billOfMat.a_11Level);
        constructionMap.set_a_12Level(billOfMat.a_12Level);
        constructionMap.set_a_13Level(billOfMat.a_13Level);
        constructionMap.set_a_14Level(billOfMat.a_14Level);
        constructionMap.set_a_15Level(billOfMat.a_15Level);
        constructionMap.set_a_16Level(billOfMat.a_16Level);
        constructionMap.set_a_17Level(billOfMat.a_17Level);
        constructionMap.set_a_18Level(billOfMat.a_18Level);
        constructionMap.set_a_19Level(billOfMat.a_19Level);
        constructionMap.set_a_20Level(billOfMat.a_20Level);
        constructionMap.set_a_21Level(billOfMat.a_21Level);
        constructionMap.set_a_22Level(billOfMat.a_22Level);
        constructionMap.set_a_1Sequence(billOfMat.a_1Sequence);
        constructionMap.set_a_2Sequence(billOfMat.a_2Sequence);
        constructionMap.set_a_3Sequence(billOfMat.a_3Sequence);
        constructionMap.set_a_4Sequence(billOfMat.a_4Sequence);
        constructionMap.set_a_5Sequence(billOfMat.a_5Sequence);
        constructionMap.set_a_6Sequence(billOfMat.a_6Sequence);
        constructionMap.set_a_7Sequence(billOfMat.a_7Sequence);
        constructionMap.set_a_8Sequence(billOfMat.a_8Sequence);
        constructionMap.set_a_9Sequence(billOfMat.a_9Sequence);
        constructionMap.set_a_10Sequence(billOfMat.a_10Sequence);
        constructionMap.set_a_11Sequence(billOfMat.a_11Sequence);
        constructionMap.set_a_12Sequence(billOfMat.a_12Sequence);
        constructionMap.set_a_13Sequence(billOfMat.a_13Sequence);
        constructionMap.set_a_14Sequence(billOfMat.a_14Sequence);
        constructionMap.set_a_15Sequence(billOfMat.a_15Sequence);
        constructionMap.set_a_16Sequence(billOfMat.a_16Sequence);
        constructionMap.set_a_17Sequence(billOfMat.a_17Sequence);
        constructionMap.set_a_18Sequence(billOfMat.a_18Sequence);
        constructionMap.set_a_19Sequence(billOfMat.a_19Sequence);
        constructionMap.set_a_20Sequence(billOfMat.a_20Sequence);
        constructionMap.set_a_21Sequence(billOfMat.a_21Sequence);
        constructionMap.set_a_22Sequence(billOfMat.a_22Sequence);

        //Setting construction map
        billOfMaterialEntity.setConstructionMap(constructionMap);

        billOfMaterialEntity.setSequenceId(billOfMat.a_sequenceID);
        billOfMaterialEntity.setLevelId(billOfMat.a_levelID);
        billOfMaterialEntity.setAssemblyLevelId(billOfMat.a_assemblyLevel);
        billOfMaterialEntity.setParentAssemblyId(billOfMat.parentAssembly);
        billOfMaterialEntity.setBomId(billOfMat.bomId);
        billOfMaterialEntity.setOrderId(billOfMat.orderid);
        billOfMaterialEntity.setItemNo(billOfMat.itemno);
        billOfMaterialEntity.setAddon(billOfMat.addon);
        billOfMaterialEntity.setRuleNo(billOfMat.ruleno == null ? 0 : billOfMat.ruleno);
        billOfMaterialEntity.setPartId(billOfMat.partid);
        billOfMaterialEntity.setSegId(billOfMat.seriesid);
        billOfMaterialEntity.setStockCode(billOfMat.stockcode);
        billOfMaterialEntity.setDescription(billOfMat.description);
        billOfMaterialEntity.setQty((int)billOfMat.qty);
        billOfMaterialEntity.setCutLength(billOfMat.cutlength);
        billOfMaterialEntity.setCutLengthI(billOfMat.cutlengthi);
        billOfMaterialEntity.setWidth(billOfMat.width);
        billOfMaterialEntity.setWidthI(billOfMat.widthi);
        billOfMaterialEntity.setHeight(billOfMat.height);
        billOfMaterialEntity.setHeightI(billOfMat.heighti);
        billOfMaterialEntity.setLevel(billOfMat.level);
        billOfMaterialEntity.setPosition(billOfMat.position);
        billOfMaterialEntity.setOrientation(billOfMat.orientation);
        billOfMaterialEntity.setOpeningId(billOfMat.openingid);
        billOfMaterialEntity.setSash(billOfMat.sash);
        billOfMaterialEntity.setRadius1(billOfMat.radius1);
        billOfMaterialEntity.setRadius1I(billOfMat.radius1i);
        billOfMaterialEntity.setRadius2(billOfMat.radius2);
        billOfMaterialEntity.setRadius2I(billOfMat.radius2i);
        billOfMaterialEntity.setLeftAngle(billOfMat.leftangle);
        billOfMaterialEntity.setRightAngle(billOfMat.rightangle);
        billOfMaterialEntity.setRow(billOfMat.row);
        billOfMaterialEntity.setCol(billOfMat.col);
        billOfMaterialEntity.setStartPos(billOfMat.startpos);
        billOfMaterialEntity.setEndPos(billOfMat.endpos);
        billOfMaterialEntity.setParentRow(billOfMat.parentrow);
        billOfMaterialEntity.setParentCol(billOfMat.parentcol);
        billOfMaterialEntity.setProdLine(billOfMat.prodline);
        billOfMaterialEntity.setStation(billOfMat.station);
        billOfMaterialEntity.setReport(billOfMat.report);
        billOfMaterialEntity.setDelivery(billOfMat.delivery);
        billOfMaterialEntity.setCost(billOfMat.cost);
        billOfMaterialEntity.setPrice(billOfMat.price);
        billOfMaterialEntity.setBuy(billOfMat.buy);
        billOfMaterialEntity.setSupplierId(billOfMat.supplierid);
        billOfMaterialEntity.setLeadtime(billOfMat.leadtime);
        billOfMaterialEntity.setTrack(billOfMat.track);
        billOfMaterialEntity.setAssemblyId(billOfMat.assemblyid);
        billOfMaterialEntity.setParentBomId(billOfMat.parentbomid);
        billOfMaterialEntity.setReqForStage(billOfMat.reqforstage == 0 ? 1 : billOfMat.reqforstage);
        billOfMaterialEntity.setSysAssemblyId(billOfMat.sysAssemblyId);
        billOfMaterialEntity.setTotalPrice(billOfMat.totalprice);
        billOfMaterialEntity.setTotalCost(billOfMat.totalcost);
        billOfMaterialEntity.setPriceUser(billOfMat.priceuser);
        billOfMaterialEntity.setTotalPriceUser(billOfMat.totalpriceuser);
        billOfMaterialEntity.setStockcodeUser(billOfMat.stockcodeUser);
        billOfMaterialEntity.setDescriptionUser(billOfMat.descriptionuser);
        billOfMaterialEntity.setQtyUser(billOfMat.qtyuser);
        billOfMaterialEntity.setCutLengthUser(billOfMat.cutlengthuser);
        billOfMaterialEntity.setCutLengthIUser(billOfMat.cutlengthiuser);
        billOfMaterialEntity.setWidthUser(billOfMat.widthuser);
        billOfMaterialEntity.setWidthIUser(billOfMat.widthiuser);
        billOfMaterialEntity.setHeightUser(billOfMat.heightuser);
        billOfMaterialEntity.setHeightIUser(billOfMat.heightiuser);
        billOfMaterialEntity.setDepth(billOfMat.depth);
        billOfMaterialEntity.setDepthI(billOfMat.depthi);
        billOfMaterialEntity.setDepthUser(billOfMat.depthuser);
        billOfMaterialEntity.setDepthIUser(billOfMat.depthiuser);
        billOfMaterialEntity.setArea(billOfMat.area);
        billOfMaterialEntity.setAreaI(billOfMat.areai);
        billOfMaterialEntity.setAreaUser(billOfMat.areauser);
        billOfMaterialEntity.setAreaIUser(billOfMat.areaiuser);
        billOfMaterialEntity.setVolume(billOfMat.volume);
        billOfMaterialEntity.setVolumeI(billOfMat.volumei);
        billOfMaterialEntity.setVolumeUser(billOfMat.volumeuser);
        billOfMaterialEntity.setVolumeIUser(billOfMat.volumeiuser);
        billOfMaterialEntity.setWeld(billOfMat.weld);
        billOfMaterialEntity.setWeldI(billOfMat.weldi);
        billOfMaterialEntity.setWeldR(billOfMat.weldR);
        billOfMaterialEntity.setWeldRI(billOfMat.weldRi);
        billOfMaterialEntity.setLeftCut(billOfMat.leftcut);
        billOfMaterialEntity.setRightCut(billOfMat.rightcut);
        billOfMaterialEntity.setWildSize(billOfMat.isWildSize);
        billOfMaterialEntity.setWildDepth(billOfMat.isWildDepth);
        billOfMaterialEntity.setWildColor(billOfMat.isWildColor);
        billOfMaterialEntity.setParentRule(billOfMat.parentRule);
        billOfMaterialEntity.setPartFamily(billOfMat.partFamily);
        billOfMaterialEntity.setPriceGroup(billOfMat.priceGroup);
        billOfMaterialEntity.setPriceCat(billOfMat.priceCat);
        billOfMaterialEntity.setGlassBomId(billOfMat.glassBomid);
        billOfMaterialEntity.setShapeId(billOfMat.shapeID);
        billOfMaterialEntity.setAssemblyBom(billOfMat.assembly);
        billOfMaterialEntity.setProcessId(billOfMat.processId);
        billOfMaterialEntity.setLeafNo(billOfMat.leafNo);
        billOfMaterialEntity.setShips(billOfMat.ships);

        billOfMaterialEntity.setLengthw2(billOfMat.lengthw2);
        billOfMaterialEntity.setLengthh2(billOfMat.lengthh2);
        billOfMaterialEntity.setLengthf12(billOfMat.lengthf12);
        billOfMaterialEntity.setLengthf22(billOfMat.lengthf22);

        //*********************************************************
        //Convert notches values
        //*********************************************************
        StringBuffer notches = new StringBuffer();
        if (billOfMat.notchesM != null && billOfMat.notchesM.size() > 0) {
            for (String notch : billOfMat.notchesM) {
                if (notches.length() == 0) {
                    notches.append(notch + "");
                } else {
                    notches.append(", " + notch);
                }
            }
        }

        StringBuffer notchesI = new StringBuffer();
        if (billOfMat.notchesI != null && billOfMat.notchesI.size() > 0) {
            for (String notch : billOfMat.notchesI) {
                if (notchesI.length() == 0) {
                    notchesI.append(notch + "");
                } else {
                    notchesI.append(", " + notch);
                }
            }
        }

        StringBuffer notchesIY = new StringBuffer();
        if (billOfMat.notchesIY != null && billOfMat.notchesIY.size() > 0) {
            for (String notch : billOfMat.notchesIY) {
                if (notchesIY.length() == 0) {
                    notchesIY.append(notch + "");
                } else {
                    notchesIY.append(", " + notch);
                }
            }
        }

        billOfMaterialEntity.setNotchesM(notches.toString());
        billOfMaterialEntity.setNotchesI(notchesI.toString());
        billOfMaterialEntity.setNotchesIY(notchesIY.toString());

        billOfMaterialEntity.setSupplierRuleNo(billOfMat.supplier_rule_no);
        billOfMaterialEntity.setSupplierPartId(billOfMat.supplier_part_id);
        billOfMaterialEntity.setGlass_made_in(billOfMat.glass_made_in);
        billOfMaterialEntity.setBought_glazed(billOfMat.bought_glazed);

        billOfMaterialEntity.setRadius_1_s(billOfMat.radius1_shape);
        billOfMaterialEntity.setRadius_1_i_s(billOfMat.radius1_i_shape);
        billOfMaterialEntity.setRadius_2_s(billOfMat.radius2_shape);
        billOfMaterialEntity.setRadius_2_i_s(billOfMat.radius2_i_shape);

        billOfMaterialEntity.setMinLeg(billOfMat.minLeg);
        billOfMaterialEntity.setMinLeg_i(billOfMat.minLeg_i);

        billOfMaterialEntity.setDimA_0(billOfMat.dimA0);
        billOfMaterialEntity.setDimA_1(billOfMat.dimA1);
        billOfMaterialEntity.setDimA_2(billOfMat.dimA2);
        billOfMaterialEntity.setDimA_3(billOfMat.dimA3);
        billOfMaterialEntity.setDimA_4(billOfMat.dimA4);
        billOfMaterialEntity.setDimA_5(billOfMat.dimA5);

        billOfMaterialEntity.setDimB_0(billOfMat.dimB0);
        billOfMaterialEntity.setDimB_1(billOfMat.dimB1);
        billOfMaterialEntity.setDimB_2(billOfMat.dimB2);
        billOfMaterialEntity.setDimB_3(billOfMat.dimB3);
        billOfMaterialEntity.setDimB_4(billOfMat.dimB4);
        billOfMaterialEntity.setDimB_5(billOfMat.dimB5);

        billOfMaterialEntity.setDimC_0(billOfMat.dimC0);
        billOfMaterialEntity.setDimC_1(billOfMat.dimC1);
        billOfMaterialEntity.setDimC_2(billOfMat.dimC2);
        billOfMaterialEntity.setDimC_3(billOfMat.dimC3);
        billOfMaterialEntity.setDimC_4(billOfMat.dimC4);
        billOfMaterialEntity.setDimC_5(billOfMat.dimC5);

        billOfMaterialEntity.setDimD_0(billOfMat.dimD0);
        billOfMaterialEntity.setDimD_1(billOfMat.dimD1);
        billOfMaterialEntity.setDimD_2(billOfMat.dimD2);
        billOfMaterialEntity.setDimD_3(billOfMat.dimD3);
        billOfMaterialEntity.setDimD_4(billOfMat.dimD4);
        billOfMaterialEntity.setDimD_5(billOfMat.dimD5);

        billOfMaterialEntity.setDimA_0_i(billOfMat.dimA0_i);
        billOfMaterialEntity.setDimA_1_i(billOfMat.dimA1_i);
        billOfMaterialEntity.setDimA_2_i(billOfMat.dimA2_i);
        billOfMaterialEntity.setDimA_3_i(billOfMat.dimA3_i);
        billOfMaterialEntity.setDimA_4_i(billOfMat.dimA4_i);
        billOfMaterialEntity.setDimA_5_i(billOfMat.dimA5_i);

        billOfMaterialEntity.setDimB_0_i(billOfMat.dimB0_i);
        billOfMaterialEntity.setDimB_1_i(billOfMat.dimB1_i);
        billOfMaterialEntity.setDimB_2_i(billOfMat.dimB2_i);
        billOfMaterialEntity.setDimB_3_i(billOfMat.dimB3_i);
        billOfMaterialEntity.setDimB_4_i(billOfMat.dimB4_i);
        billOfMaterialEntity.setDimB_5_i(billOfMat.dimB5_i);

        billOfMaterialEntity.setDimC_0_i(billOfMat.dimC0_i);
        billOfMaterialEntity.setDimC_1_i(billOfMat.dimC1_i);
        billOfMaterialEntity.setDimC_2_i(billOfMat.dimC2_i);
        billOfMaterialEntity.setDimC_3_i(billOfMat.dimC3_i);
        billOfMaterialEntity.setDimC_4_i(billOfMat.dimC4_i);
        billOfMaterialEntity.setDimC_5_i(billOfMat.dimC5_i);

        billOfMaterialEntity.setDimD_0_i(billOfMat.dimD0_i);
        billOfMaterialEntity.setDimD_1_i(billOfMat.dimD1_i);
        billOfMaterialEntity.setDimD_2_i(billOfMat.dimD2_i);
        billOfMaterialEntity.setDimD_3_i(billOfMat.dimD3_i);
        billOfMaterialEntity.setDimD_4_i(billOfMat.dimD4_i);
        billOfMaterialEntity.setDimD_5_i(billOfMat.dimD5_i);

        billOfMaterialEntity.setSupplierRemoteId(billOfMat.supplierRemoteId);
        billOfMaterialEntity.setSupplierSeriesId(billOfMat.supplierSeriesId);
        billOfMaterialEntity.setRemote(billOfMat.remote);

        return billOfMaterialEntity;
    }

    /**
     * Return a BillOfMat model object
     *
     * @param billOfMaterialEntity, BillOfMaterialEntity
     * @return BillOfMat
     * @throws DTOTransformationError, Error
     */
    public static BillOfMat getBuildOfMaterialModel(BillOfMaterialEntityObject billOfMaterialEntity) throws DTOTransformationError {

        if (billOfMaterialEntity == null) {
            throw new DTOTransformationError();
        }

        BillOfMat billOfMat = new BillOfMat();
        billOfMat.a_assemblyLevel = billOfMaterialEntity.getConstructionMap().get_a_assemblyLevel();
        billOfMat.a_1Level = billOfMaterialEntity.getConstructionMap().get_a_1Level();
        billOfMat.a_2Level = billOfMaterialEntity.getConstructionMap().get_a_2Level();
        billOfMat.a_3Level = billOfMaterialEntity.getConstructionMap().get_a_3Level();
        billOfMat.a_4Level = billOfMaterialEntity.getConstructionMap().get_a_4Level();
        billOfMat.a_5Level = billOfMaterialEntity.getConstructionMap().get_a_5Level();
        billOfMat.a_6Level = billOfMaterialEntity.getConstructionMap().get_a_6Level();
        billOfMat.a_7Level = billOfMaterialEntity.getConstructionMap().get_a_7Level();
        billOfMat.a_8Level = billOfMaterialEntity.getConstructionMap().get_a_8Level();
        billOfMat.a_9Level = billOfMaterialEntity.getConstructionMap().get_a_9Level();
        billOfMat.a_10Level = billOfMaterialEntity.getConstructionMap().get_a_10Level();
        billOfMat.a_11Level = billOfMaterialEntity.getConstructionMap().get_a_11Level();
        billOfMat.a_12Level = billOfMaterialEntity.getConstructionMap().get_a_12Level();
        billOfMat.a_13Level = billOfMaterialEntity.getConstructionMap().get_a_13Level();
        billOfMat.a_14Level = billOfMaterialEntity.getConstructionMap().get_a_14Level();
        billOfMat.a_15Level = billOfMaterialEntity.getConstructionMap().get_a_15Level();
        billOfMat.a_16Level = billOfMaterialEntity.getConstructionMap().get_a_16Level();
        billOfMat.a_17Level = billOfMaterialEntity.getConstructionMap().get_a_17Level();
        billOfMat.a_18Level = billOfMaterialEntity.getConstructionMap().get_a_18Level();
        billOfMat.a_19Level = billOfMaterialEntity.getConstructionMap().get_a_19Level();
        billOfMat.a_20Level = billOfMaterialEntity.getConstructionMap().get_a_20Level();
        billOfMat.a_21Level = billOfMaterialEntity.getConstructionMap().get_a_21Level();
        billOfMat.a_22Level = billOfMaterialEntity.getConstructionMap().get_a_22Level();
        billOfMat.a_1Sequence = billOfMaterialEntity.getConstructionMap().get_a_1Sequence();
        billOfMat.a_2Sequence = billOfMaterialEntity.getConstructionMap().get_a_2Sequence();
        billOfMat.a_3Sequence = billOfMaterialEntity.getConstructionMap().get_a_3Sequence();
        billOfMat.a_4Sequence = billOfMaterialEntity.getConstructionMap().get_a_4Sequence();
        billOfMat.a_5Sequence = billOfMaterialEntity.getConstructionMap().get_a_5Sequence();
        billOfMat.a_6Sequence = billOfMaterialEntity.getConstructionMap().get_a_6Sequence();
        billOfMat.a_7Sequence = billOfMaterialEntity.getConstructionMap().get_a_7Sequence();
        billOfMat.a_8Sequence = billOfMaterialEntity.getConstructionMap().get_a_8Sequence();
        billOfMat.a_9Sequence = billOfMaterialEntity.getConstructionMap().get_a_9Sequence();
        billOfMat.a_10Sequence = billOfMaterialEntity.getConstructionMap().get_a_10Sequence();
        billOfMat.a_11Sequence = billOfMaterialEntity.getConstructionMap().get_a_11Sequence();
        billOfMat.a_12Sequence = billOfMaterialEntity.getConstructionMap().get_a_12Sequence();
        billOfMat.a_13Sequence = billOfMaterialEntity.getConstructionMap().get_a_13Sequence();
        billOfMat.a_14Sequence = billOfMaterialEntity.getConstructionMap().get_a_14Sequence();
        billOfMat.a_15Sequence = billOfMaterialEntity.getConstructionMap().get_a_15Sequence();
        billOfMat.a_16Sequence = billOfMaterialEntity.getConstructionMap().get_a_16Sequence();
        billOfMat.a_17Sequence = billOfMaterialEntity.getConstructionMap().get_a_17Sequence();
        billOfMat.a_18Sequence = billOfMaterialEntity.getConstructionMap().get_a_18Sequence();
        billOfMat.a_19Sequence = billOfMaterialEntity.getConstructionMap().get_a_19Sequence();
        billOfMat.a_20Sequence = billOfMaterialEntity.getConstructionMap().get_a_20Sequence();
        billOfMat.a_21Sequence = billOfMaterialEntity.getConstructionMap().get_a_21Sequence();
        billOfMat.a_22Sequence = billOfMaterialEntity.getConstructionMap().get_a_22Sequence();

        billOfMat.a_sequenceID = billOfMaterialEntity.getSequenceId();
        billOfMat.a_levelID = billOfMaterialEntity.getLevelId();
        billOfMat.a_assemblyLevel = billOfMaterialEntity.getAssemblyLevelId();
        billOfMat.bomId = billOfMaterialEntity.getId() != null ? billOfMaterialEntity.getId() : 0;
        billOfMat.orderid = billOfMaterialEntity.getOrderId();
        billOfMat.itemno = billOfMaterialEntity.getItemNo();
        billOfMat.addon = billOfMaterialEntity.isAddon();
        billOfMat.ruleno = billOfMaterialEntity.getRuleNo();
        billOfMat.partid = billOfMaterialEntity.getPartId();
        billOfMat.seriesid = billOfMaterialEntity.getSegId();
        billOfMat.stockcode = billOfMaterialEntity.getStockCode();
        billOfMat.description = billOfMaterialEntity.getDescription();
        billOfMat.qty = billOfMaterialEntity.getQty();
        billOfMat.cutlength = billOfMaterialEntity.getCutLength();
        billOfMat.cutlengthi = billOfMaterialEntity.getCutLengthI();
        billOfMat.width = billOfMaterialEntity.getWidth();
        billOfMat.widthi = billOfMaterialEntity.getWidthI();
        billOfMat.height = billOfMaterialEntity.getHeight();
        billOfMat.heighti = billOfMaterialEntity.getHeightI();
        billOfMat.level = billOfMaterialEntity.getLevel();
        billOfMat.position = billOfMaterialEntity.getPosition();
        billOfMat.orientation = billOfMaterialEntity.getOrientation();
        billOfMat.openingid = billOfMaterialEntity.getOpeningId();
        billOfMat.sash = billOfMaterialEntity.getSash();
        billOfMat.radius1 = billOfMaterialEntity.getRadius1();
        billOfMat.radius1i = billOfMaterialEntity.getRadius1I();
        billOfMat.radius2 = billOfMaterialEntity.getRadius2();
        billOfMat.radius2i = billOfMaterialEntity.getRadius2I();
        billOfMat.leftangle = billOfMaterialEntity.getLeftAngle();
        billOfMat.rightangle = billOfMaterialEntity.getRightAngle();
        billOfMat.row = billOfMaterialEntity.getRow();
        billOfMat.col = billOfMaterialEntity.getCol();
        billOfMat.startpos = billOfMaterialEntity.getStartPos();
        billOfMat.endpos = billOfMaterialEntity.getEndPos();
        billOfMat.parentrow = billOfMaterialEntity.getParentRow();
        billOfMat.parentcol = billOfMaterialEntity.getParentCol();
        billOfMat.prodline = billOfMaterialEntity.getProdLine();
        billOfMat.station = billOfMaterialEntity.getStation();
        billOfMat.report = billOfMaterialEntity.getReport();
        billOfMat.delivery = billOfMaterialEntity.getDelivery();
        billOfMat.cost = billOfMaterialEntity.getCost();
        billOfMat.price = billOfMaterialEntity.getPrice();
        billOfMat.buy = billOfMaterialEntity.isBuy();
        billOfMat.supplierid = billOfMaterialEntity.getSupplierId();
        billOfMat.leadtime = billOfMaterialEntity.getLeadtime();
        billOfMat.track = billOfMaterialEntity.isTrack();
        billOfMat.assemblyid = billOfMaterialEntity.getAssemblyId();
        billOfMat.parentAssembly = billOfMaterialEntity.getParentAssemblyId();
        billOfMat.parentbomid = billOfMaterialEntity.getParentBom() != null ? billOfMaterialEntity.getParentBom().getId() : 0;
        billOfMat.reqforstage = billOfMaterialEntity.getReqForStage();
        billOfMat.sysAssemblyId = billOfMaterialEntity.getSysAssemblyId();
        billOfMat.totalprice = billOfMaterialEntity.getTotalPrice();
        billOfMat.totalcost = billOfMaterialEntity.getTotalCost();
        billOfMat.priceuser = billOfMaterialEntity.getPriceUser();
        billOfMat.totalpriceuser = billOfMaterialEntity.getTotalPriceUser();
        billOfMat.stockcodeUser = billOfMaterialEntity.getStockcodeUser();
        billOfMat.descriptionuser = billOfMaterialEntity.getDescriptionUser();
        billOfMat.qtyuser = billOfMaterialEntity.getQtyUser();
        billOfMat.cutlengthuser = billOfMaterialEntity.getCutLengthUser();
        billOfMat.cutlengthiuser = billOfMaterialEntity.getCutLengthIUser();
        billOfMat.widthuser = billOfMaterialEntity.getWidthUser();
        billOfMat.widthiuser = billOfMaterialEntity.getWidthIUser();
        billOfMat.heightuser = billOfMaterialEntity.getHeightUser();
        billOfMat.heightiuser = billOfMaterialEntity.getHeightIUser();
        billOfMat.depth = billOfMaterialEntity.getDepth();
        billOfMat.depthi = billOfMaterialEntity.getDepthI();
        billOfMat.depthuser = billOfMaterialEntity.getDepthUser();
        billOfMat.depthiuser = billOfMaterialEntity.getDepthIUser();
        billOfMat.area = billOfMaterialEntity.getArea();
        billOfMat.areai = billOfMaterialEntity.getAreaI();
        billOfMat.areauser = billOfMaterialEntity.getAreaUser();
        billOfMat.areaiuser = billOfMaterialEntity.getAreaIUser();
        billOfMat.volume = billOfMaterialEntity.getVolume();
        billOfMat.volumei = billOfMaterialEntity.getVolumeI();
        billOfMat.volumeuser = billOfMaterialEntity.getVolumeUser();
        billOfMat.volumeiuser = billOfMaterialEntity.getVolumeIUser();
        billOfMat.weld = billOfMaterialEntity.getWeld();
        billOfMat.weldi = billOfMaterialEntity.getWeldI();
        billOfMat.weldR = billOfMaterialEntity.getWeldR();
        billOfMat.weldRi = billOfMaterialEntity.getWeldRI();
        billOfMat.leftcut = billOfMaterialEntity.getLeftCut();
        billOfMat.rightcut = billOfMaterialEntity.getRightCut();
        billOfMat.isWildSize = billOfMaterialEntity.isWildSize();
        billOfMat.isWildDepth = billOfMaterialEntity.isWildDepth();
        billOfMat.isWildColor = billOfMaterialEntity.isWildColor();
        billOfMat.parentRule = billOfMaterialEntity.getParentRule();
        billOfMat.partFamily = billOfMaterialEntity.getPartFamily();
        billOfMat.priceGroup = billOfMaterialEntity.getPriceGroup();
        billOfMat.priceCat = billOfMaterialEntity.getPriceCat();
        billOfMat.shapeID = billOfMaterialEntity.getShapeId();
        billOfMat.assembly = billOfMaterialEntity.getAssembly() != null;
        billOfMat.processId = billOfMaterialEntity.getProcessId();
        billOfMat.leafNo = billOfMaterialEntity.getLeafNo();
        billOfMat.ships = billOfMaterialEntity.isShips();
        billOfMat.lengthw2 = billOfMaterialEntity.getLengthw2();
        billOfMat.lengthh2 = billOfMaterialEntity.getLengthh2();
        billOfMat.lengthf12 = billOfMaterialEntity.getLengthf12();
        billOfMat.lengthf22 = billOfMaterialEntity.getLengthf22();

        //*********************************************************
        //Convert notches values
        //*********************************************************
        List<String> notches = new ArrayList<String>();

        if (billOfMaterialEntity.getNotchesM() != null && billOfMaterialEntity.getNotchesM().length() > 0) {
            String[] notchesStr = billOfMaterialEntity.getNotchesM().split(",");
            for (String notch : notchesStr) {
                notches.add(notch);
            }
        }

        List<String> notchesI = new ArrayList<String>();

        if (billOfMaterialEntity.getNotchesI() != null && billOfMaterialEntity.getNotchesI().length() > 0) {
            String[] notchesIStr = billOfMaterialEntity.getNotchesI().split(",");
            for (String notch : notchesIStr) {
                notchesI.add(notch);
            }
        }

        List<String> notchesIY = new ArrayList<String>();

        if (billOfMaterialEntity.getNotchesIY() != null && billOfMaterialEntity.getNotchesIY().length() > 0) {
            String[] notchesIStr = billOfMaterialEntity.getNotchesIY().split(",");
            for (String notch : notchesIStr) {
                notchesI.add(notch);
            }
        }

        billOfMat.notchesM = notches;
        billOfMat.notchesI = notchesI;
        billOfMat.notchesIY = notchesIY;

        billOfMat.supplier_rule_no = billOfMaterialEntity.getSupplierRuleNo();
        billOfMat.supplier_part_id = billOfMaterialEntity.getSupplierPartId();
        billOfMat.glass_made_in = billOfMaterialEntity.isGlass_made_in();
        billOfMat.bought_glazed = billOfMaterialEntity.isBought_glazed();

        billOfMat.radius1_shape = billOfMaterialEntity.getRadius_1_s();
        billOfMat.radius1_i_shape = billOfMaterialEntity.getRadius_1_i_s();
        billOfMat.radius2_shape = billOfMaterialEntity.getRadius_2_s();
        billOfMat.radius2_i_shape = billOfMaterialEntity.getRadius_2_i_s();

        billOfMat.minLeg = billOfMaterialEntity.getMinLeg();
        billOfMat.minLeg_i = billOfMaterialEntity.getMinLeg_i();

        billOfMat.dimA0 = billOfMaterialEntity.getDimA_0();
        billOfMat.dimA1 = billOfMaterialEntity.getDimA_1();
        billOfMat.dimA2 = billOfMaterialEntity.getDimA_2();
        billOfMat.dimA3 = billOfMaterialEntity.getDimA_3();
        billOfMat.dimA4 = billOfMaterialEntity.getDimA_4();
        billOfMat.dimA5 = billOfMaterialEntity.getDimA_5();

        billOfMat.dimB0 = billOfMaterialEntity.getDimB_0();
        billOfMat.dimB1 = billOfMaterialEntity.getDimB_1();
        billOfMat.dimB2 = billOfMaterialEntity.getDimB_2();
        billOfMat.dimB3 = billOfMaterialEntity.getDimB_3();
        billOfMat.dimB4 = billOfMaterialEntity.getDimB_4();
        billOfMat.dimB5 = billOfMaterialEntity.getDimB_5();

        billOfMat.dimC0 = billOfMaterialEntity.getDimC_0();
        billOfMat.dimC1 = billOfMaterialEntity.getDimC_1();
        billOfMat.dimC2 = billOfMaterialEntity.getDimC_2();
        billOfMat.dimC3 = billOfMaterialEntity.getDimC_3();
        billOfMat.dimC4 = billOfMaterialEntity.getDimC_4();
        billOfMat.dimC5 = billOfMaterialEntity.getDimC_5();

        billOfMat.dimD0 = billOfMaterialEntity.getDimD_0();
        billOfMat.dimD1 = billOfMaterialEntity.getDimD_1();
        billOfMat.dimD2 = billOfMaterialEntity.getDimD_2();
        billOfMat.dimD3 = billOfMaterialEntity.getDimD_3();
        billOfMat.dimD4 = billOfMaterialEntity.getDimD_4();
        billOfMat.dimD5 = billOfMaterialEntity.getDimD_5();

        billOfMat.dimA0_i = billOfMaterialEntity.getDimA_0_i();
        billOfMat.dimA1_i = billOfMaterialEntity.getDimA_1_i();
        billOfMat.dimA2_i = billOfMaterialEntity.getDimA_2_i();
        billOfMat.dimA3_i = billOfMaterialEntity.getDimA_3_i();
        billOfMat.dimA4_i = billOfMaterialEntity.getDimA_4_i();
        billOfMat.dimA5_i = billOfMaterialEntity.getDimA_5_i();

        billOfMat.dimB0_i = billOfMaterialEntity.getDimB_0_i();
        billOfMat.dimB1_i = billOfMaterialEntity.getDimB_1_i();
        billOfMat.dimB2_i = billOfMaterialEntity.getDimB_2_i();
        billOfMat.dimB3_i = billOfMaterialEntity.getDimB_3_i();
        billOfMat.dimB4_i = billOfMaterialEntity.getDimB_4_i();
        billOfMat.dimB5_i = billOfMaterialEntity.getDimB_5_i();

        billOfMat.dimC0_i = billOfMaterialEntity.getDimC_0_i();
        billOfMat.dimC1_i = billOfMaterialEntity.getDimC_1_i();
        billOfMat.dimC2_i = billOfMaterialEntity.getDimC_2_i();
        billOfMat.dimC3_i = billOfMaterialEntity.getDimC_3_i();
        billOfMat.dimC4_i = billOfMaterialEntity.getDimC_4_i();
        billOfMat.dimC5_i = billOfMaterialEntity.getDimC_5_i();

        billOfMat.dimD0_i = billOfMaterialEntity.getDimD_0_i();
        billOfMat.dimD1_i = billOfMaterialEntity.getDimD_1_i();
        billOfMat.dimD2_i = billOfMaterialEntity.getDimD_2_i();
        billOfMat.dimD3_i = billOfMaterialEntity.getDimD_3_i();
        billOfMat.dimD4_i = billOfMaterialEntity.getDimD_4_i();
        billOfMat.dimD5_i = billOfMaterialEntity.getDimD_5_i();

        billOfMat.supplierRemoteId = billOfMaterialEntity.getSupplierRemoteId();
        billOfMat.supplierSeriesId = billOfMaterialEntity.getSupplierSeriesId();
        billOfMat.remote = billOfMaterialEntity.isRemote();

        return billOfMat;
    }

}


