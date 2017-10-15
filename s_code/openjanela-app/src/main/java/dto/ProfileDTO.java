package dto;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Model.BillOfMat;
import Model.ShapeNotes;
import openjanela.model.entities.design.*;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

import Model.ShapeOption;
import Model.ProfileParts.PartsNotching;
import Model.ProfileParts.ProfileParts;
import Model.ProfileParts.Profiles;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * <p/>
 * This class represents the transformation object facade for profile model entity
 * User: EMontenegro
 * Date: 04-11-12
 * Time: 11:54 PM
 */
public class ProfileDTO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(ProfileDTO.class);

    protected static final BigDecimal ZERO_VALUE = new BigDecimal("0");
    protected static final BigDecimal INFINITY_NEGATIVE = new BigDecimal("-999999");
    protected static final BigDecimal INFINITY_POSITIVE = new BigDecimal("999999");

    /**
     * This method transform a ProfileAbstractObject implementation class
     *
     * @param profiles,     Profile
     * @param clazz,        Class
     * @param _part_object, part object collection
     * @param bkgrdOpening, BkgrdOpeningEntityObject
     * @return ProfileEntityObject
     * @throws dto.DTOTransformationError, Error
     */
    public static ProfileAbstractObject getProfileAbstractObject(ProfileParts profiles, Class clazz, int _part_object,
                                                                 BkgrdOpeningEntityObject bkgrdOpening) throws DTOTransformationError {

        if (profiles == null)
            throw new DTOTransformationError();

        //**************************************************************************
        //Creating and applying transformation
        //**************************************************************************
        ProfileAbstractObject profileEntity = null;

        try {
            profileEntity = (ProfileAbstractObject) clazz.newInstance();
        } catch (InstantiationException e) {
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            throw new DTOTransformationError(e.getMessage(), e);
        }

        //Construction map
        ConstructionMap constructionMap = new ConstructionMap();
        constructionMap.set_a_assemblyLevel(profiles.a_assemblyLevel);
        constructionMap.set_a_assemblySequence(profiles.a_sequenceID);
        constructionMap.set_a_1Level(profiles.a_1Level);
        constructionMap.set_a_2Level(profiles.a_2Level);
        constructionMap.set_a_3Level(profiles.a_3Level);
        constructionMap.set_a_4Level(profiles.a_4Level);
        constructionMap.set_a_5Level(profiles.a_5Level);
        constructionMap.set_a_6Level(profiles.a_6Level);
        constructionMap.set_a_7Level(profiles.a_7Level);
        constructionMap.set_a_8Level(profiles.a_8Level);
        constructionMap.set_a_9Level(profiles.a_9Level);
        constructionMap.set_a_10Level(profiles.a_10Level);
        constructionMap.set_a_11Level(profiles.a_11Level);
        constructionMap.set_a_12Level(profiles.a_12Level);
        constructionMap.set_a_13Level(profiles.a_13Level);
        constructionMap.set_a_14Level(profiles.a_14Level);
        constructionMap.set_a_15Level(profiles.a_15Level);
        constructionMap.set_a_16Level(profiles.a_16Level);
        constructionMap.set_a_17Level(profiles.a_17Level);
        constructionMap.set_a_18Level(profiles.a_18Level);
        constructionMap.set_a_19Level(profiles.a_19Level);
        constructionMap.set_a_20Level(profiles.a_20Level);
        constructionMap.set_a_21Level(profiles.a_21Level);
        constructionMap.set_a_22Level(profiles.a_22Level);
        constructionMap.set_a_1Sequence(profiles.a_1Sequence);
        constructionMap.set_a_2Sequence(profiles.a_2Sequence);
        constructionMap.set_a_3Sequence(profiles.a_3Sequence);
        constructionMap.set_a_4Sequence(profiles.a_4Sequence);
        constructionMap.set_a_5Sequence(profiles.a_5Sequence);
        constructionMap.set_a_6Sequence(profiles.a_6Sequence);
        constructionMap.set_a_7Sequence(profiles.a_7Sequence);
        constructionMap.set_a_8Sequence(profiles.a_8Sequence);
        constructionMap.set_a_9Sequence(profiles.a_9Sequence);
        constructionMap.set_a_10Sequence(profiles.a_10Sequence);
        constructionMap.set_a_11Sequence(profiles.a_11Sequence);
        constructionMap.set_a_12Sequence(profiles.a_12Sequence);
        constructionMap.set_a_13Sequence(profiles.a_13Sequence);
        constructionMap.set_a_14Sequence(profiles.a_14Sequence);
        constructionMap.set_a_15Sequence(profiles.a_15Sequence);
        constructionMap.set_a_16Sequence(profiles.a_16Sequence);
        constructionMap.set_a_17Sequence(profiles.a_17Sequence);
        constructionMap.set_a_18Sequence(profiles.a_18Sequence);
        constructionMap.set_a_19Sequence(profiles.a_19Sequence);
        constructionMap.set_a_20Sequence(profiles.a_20Sequence);
        constructionMap.set_a_21Sequence(profiles.a_21Sequence);
        constructionMap.set_a_22Sequence(profiles.a_22Sequence);

        //Setting construction map
        profileEntity.setConstructionMap(constructionMap);

        profileEntity.setShapeId(profiles.shapeID);
        profileEntity.setLevelId(profiles.a_levelID);
        profileEntity.setSequenceId(profiles.a_sequenceID);
        profileEntity.setParentId(profiles.parentid);
        profileEntity.setExist(profiles.exists);
        profileEntity.setAbcLines(profiles.ABClines);
        profileEntity.setPartForm(profiles.partForm);
        profileEntity.setPartID(profiles.partID);
        profileEntity.setPartShape(profiles.partShape);
        profileEntity.setPosition(profiles.position);
        profileEntity.setSeq(profiles.seq);
        profileEntity.setEndTypeLT(profiles.endTypeLT);
        profileEntity.setEndTypeRB(profiles.endTypeRB);
        profileEntity.setMyLean(profiles.myLean);
        profileEntity.setMyLean2(profiles.myLean2);
        profileEntity.setMyLean3(profiles.myLean3);
        profileEntity.setMyLean4(profiles.myLean4);
        profileEntity.setBkgrdHeight(evaluateInfinite(profiles.bkgrdHeight));
        profileEntity.setBkgrdHeightA(evaluateInfinite(profiles.bkgrdHeightA));
        profileEntity.setBkgrdHeightBA(evaluateInfinite(profiles.bkgrdHeightBA));
        profileEntity.setBkgrdHeightBC(evaluateInfinite(profiles.bkgrdHeightBC));
        profileEntity.setBkgrdStartX(evaluateInfinite(profiles.bkgrdStartX));
        profileEntity.setBkgrdStartXA(evaluateInfinite(profiles.bkgrdStartXA));
        profileEntity.setBkgrdStartXBA(evaluateInfinite(profiles.bkgrdStartXBA));
        profileEntity.setBkgrdStartXBC(evaluateInfinite(profiles.bkgrdStartXBC));
        profileEntity.setBkgrdStartY(evaluateInfinite(profiles.bkgrdStartY));
        profileEntity.setBkgrdStartYA(evaluateInfinite(profiles.bkgrdStartYA));
        profileEntity.setBkgrdStartYBA(evaluateInfinite(profiles.bkgrdStartYBA));
        profileEntity.setBkgrdStartYBC(evaluateInfinite(profiles.bkgrdStartYBC));
        profileEntity.setBkgrdWidth(evaluateInfinite(profiles.bkgrdWidth));
        profileEntity.setBkgrdWidthA(evaluateInfinite(profiles.bkgrdWidthA));
        profileEntity.setBkgrdWidthBA(evaluateInfinite(profiles.bkgrdWidthBA));
        profileEntity.setBkgrdWidthBC(evaluateInfinite(profiles.bkgrdWidthBC));
        profileEntity.setCentralAngle(evaluateInfinite(profiles.centralAngle));
        profileEntity.setCentralAngleA(evaluateInfinite(profiles.centralAngleA));
        profileEntity.setCentralAngleBA(evaluateInfinite(profiles.centralAngleBA));
        profileEntity.setCentralAngleBC(evaluateInfinite(profiles.centralAngleBC));
        profileEntity.setDimB1A(evaluateInfinite(profiles.dimB1A));
        profileEntity.setDimB1B(evaluateInfinite(profiles.dimB1B));
        profileEntity.setEndAngle(evaluateInfinite(profiles.endAngle));
        profileEntity.setEndAngleA(evaluateInfinite(profiles.endAngleA));
        profileEntity.setEndAngleBA(evaluateInfinite(profiles.endAngleBA));
        profileEntity.setEndAngleBC(evaluateInfinite(profiles.endAngleBC));
        profileEntity.setEndX(evaluateInfinite(profiles.endX));
        profileEntity.setEndXC(evaluateInfinite(profiles.endXC));
        profileEntity.setEndXA(evaluateInfinite(profiles.endXA));
        profileEntity.setEndXBA(evaluateInfinite(profiles.endXBA));
        profileEntity.setEndXBC(evaluateInfinite(profiles.endXBC));
        profileEntity.setEndY(evaluateInfinite(profiles.endY));
        profileEntity.setEndYC(evaluateInfinite(profiles.endYC));
        profileEntity.setEndYA(evaluateInfinite(profiles.endYA));
        profileEntity.setEndYBA(evaluateInfinite(profiles.endYBA));
        profileEntity.setEndYBC(evaluateInfinite(profiles.endYBC));
        profileEntity.setFocal1X(evaluateInfinite(profiles.focal1X));
        profileEntity.setFocal1XA(evaluateInfinite(profiles.focal1XA));
        profileEntity.setFocal1XBA(evaluateInfinite(profiles.focal1XBA));
        profileEntity.setFocal1XBC(evaluateInfinite(profiles.focal1XBC));
        profileEntity.setFocal1Y(evaluateInfinite(profiles.focal1Y));
        profileEntity.setFocal1YA(evaluateInfinite(profiles.focal1YA));
        profileEntity.setFocal1YBA(evaluateInfinite(profiles.focal1YBA));
        profileEntity.setFocal1YBC(evaluateInfinite(profiles.focal1YBC));
        profileEntity.setFocal2X(evaluateInfinite(profiles.focal2X));
        profileEntity.setFocal2XA(evaluateInfinite(profiles.focal2XA));
        profileEntity.setFocal2XBA(evaluateInfinite(profiles.focal2XBA));
        profileEntity.setFocal2XBC(evaluateInfinite(profiles.focal2XBC));
        profileEntity.setFocal2Y(evaluateInfinite(profiles.focal2Y));
        profileEntity.setFocal2YA(evaluateInfinite(profiles.focal2YA));
        profileEntity.setFocal2YBA(evaluateInfinite(profiles.focal2YBA));
        profileEntity.setFocal2YBC(evaluateInfinite(profiles.focal2YBC));
        profileEntity.setGlazingDepth(evaluateInfinite(profiles.glazingDepth));
        profileEntity.setInLaminateArea(evaluateInfinite(profiles.inLaminateArea));
        profileEntity.setInPaintArea(evaluateInfinite(profiles.inPaintArea));
        profileEntity.setLength(evaluateInfinite(profiles.length));
        profileEntity.setLengthA(evaluateInfinite(profiles.lengthA));
        profileEntity.setLengthBA(evaluateInfinite(profiles.lengthBA));
        profileEntity.setLengthBC(evaluateInfinite(profiles.lengthBC));
        profileEntity.setLtAngle(evaluateInfinite(profiles.ltAngle));
        profileEntity.setLtAngleA(evaluateInfinite(profiles.ltAngleA));
        profileEntity.setLtAngleBA(evaluateInfinite(profiles.ltAngleBA));
        profileEntity.setLtAngleBC(evaluateInfinite(profiles.ltAngleBC));
        profileEntity.setMitreLengthLT(evaluateInfinite(profiles.mitreLengthLT));
        profileEntity.setMitreLengthRB(evaluateInfinite(profiles.mitreLengthRB));
        profileEntity.setMyWidth(evaluateInfinite(profiles.myWidth));
        profileEntity.setMyWidthA(evaluateInfinite(profiles.myWidthA));
        profileEntity.setMyWidthBA(evaluateInfinite(profiles.myWidthBA));
        profileEntity.setNewX(evaluateInfinite(profiles.newX));
        profileEntity.setNewXA(evaluateInfinite(profiles.newXA));
        profileEntity.setNewY(evaluateInfinite(profiles.newY));
        profileEntity.setNewYA(evaluateInfinite(profiles.newYA));
        profileEntity.setOutLaminateArea(evaluateInfinite(profiles.outLaminateArea));
        profileEntity.setOutPaintArea(evaluateInfinite(profiles.outPaintArea));
        profileEntity.setPartDimA(evaluateInfinite(profiles.partDimA));
        profileEntity.setPartDimAi(evaluateInfinite(profiles.partDimAi));
        profileEntity.setPartDimB(evaluateInfinite(profiles.partDimB));
        profileEntity.setPartDimBi(evaluateInfinite(profiles.partDimBi));
        profileEntity.setPartDimC(evaluateInfinite(profiles.partDimC));
        profileEntity.setPartDimCi(evaluateInfinite(profiles.partDimCi));
        profileEntity.setPartDimD(evaluateInfinite(profiles.partDimD));
        profileEntity.setPartDimDi(evaluateInfinite(profiles.partDimDi));
        profileEntity.setPartDimM(evaluateInfinite(profiles.partDimM));
        profileEntity.setPartDimMi(evaluateInfinite(profiles.partDimMi));
        profileEntity.setPartDimBtoC(evaluateInfinite(profiles.partDimBtoC));
        profileEntity.setPartDimBtoCI(evaluateInfinite(profiles.partDimBtoCi));
        profileEntity.setRadianCentralAngle(evaluateInfinite(profiles.radianCentralAngle));
        profileEntity.setRadius1(evaluateInfinite(profiles.radius1));
        profileEntity.setRadius1A(evaluateInfinite(profiles.radius1A));
        profileEntity.setRadius1BA(evaluateInfinite(profiles.radius1BA));
        profileEntity.setRadius1BC(evaluateInfinite(profiles.radius1BC));
        profileEntity.setRadius2(evaluateInfinite(profiles.radius2));
        profileEntity.setRadius2A(evaluateInfinite(profiles.radius2A));
        profileEntity.setRadius2BA(evaluateInfinite(profiles.radius2BA));
        profileEntity.setRadius2BC(evaluateInfinite(profiles.radius2BC));
        profileEntity.setRadsStart(evaluateInfinite(profiles.radsStart));
        profileEntity.setRadsStart2(evaluateInfinite(profiles.radsStart2));
        profileEntity.setRadsStart2A(evaluateInfinite(profiles.radsStart2A));
        profileEntity.setRadsStart2BA(evaluateInfinite(profiles.radsStart2BA));
        profileEntity.setRadsStartA(evaluateInfinite(profiles.radsStartA));
        profileEntity.setRadsStartBA(evaluateInfinite(profiles.radsStartBA));
        profileEntity.setRbAngle(evaluateInfinite(profiles.rbAngle));
        profileEntity.setRbAngleA(evaluateInfinite(profiles.rbAngleA));
        profileEntity.setRbAngleBA(evaluateInfinite(profiles.rbAngleBA));
        profileEntity.setRbAngleBC(evaluateInfinite(profiles.rbAngleBC));
        profileEntity.setrID(profiles.rID);
        profileEntity.setRlAngle(evaluateInfinite(profiles.rlAngle));
        profileEntity.setRlAngleA(evaluateInfinite(profiles.rlAngleA));
        profileEntity.setRlAngleBA(evaluateInfinite(profiles.rlAngleBA));
        profileEntity.setRlSlope(evaluateInfinite(profiles.rlSlope));
        profileEntity.setRlSlopeA(evaluateInfinite(profiles.rlSlopeA));
        profileEntity.setRlSlopeBA(evaluateInfinite(profiles.rlSlopeBA));
        profileEntity.setRrAngle(evaluateInfinite(profiles.rrAngle));
        profileEntity.setRrAngleA(evaluateInfinite(profiles.rrAngleA));
        profileEntity.setRrAngleBA(evaluateInfinite(profiles.rrAngleBA));
        profileEntity.setRrSlope(evaluateInfinite(profiles.rrSlope));
        profileEntity.setRrSlopeA(evaluateInfinite(profiles.rrSlopeA));
        profileEntity.setRrSlopeBA(evaluateInfinite(profiles.rrSlopeBA));
        profileEntity.setSlope(evaluateInfinite(profiles.slope));
        profileEntity.setSlopeA(evaluateInfinite(profiles.slopeA));
        profileEntity.setSlopeBA(evaluateInfinite(profiles.slopeBA));
        profileEntity.setSlopeBC(evaluateInfinite(profiles.slopeBC));
        profileEntity.setStartAngle(evaluateInfinite(profiles.startAngle));
        profileEntity.setStartAngleA(evaluateInfinite(profiles.startAngleA));
        profileEntity.setStartAngleBA(evaluateInfinite(profiles.startAngleBA));
        profileEntity.setStartAngleBC(evaluateInfinite(profiles.startAngleBC));
        profileEntity.setStartingX(evaluateInfinite(profiles.startingX));
        profileEntity.setStartingXA(evaluateInfinite(profiles.startingXA));
        profileEntity.setStartingXBA(evaluateInfinite(profiles.startingXBA));
        profileEntity.setStartingXBC(evaluateInfinite(profiles.startingXBC));
        profileEntity.setStartingY(evaluateInfinite(profiles.startingY));
        profileEntity.setStartingYA(evaluateInfinite(profiles.startingYA));
        profileEntity.setStartingYBA(evaluateInfinite(profiles.startingYBA));
        profileEntity.setStartingYBC(evaluateInfinite(profiles.startingYBC));
        profileEntity.setStartX(evaluateInfinite(profiles.startX));
        profileEntity.setStartXC(evaluateInfinite(profiles.startXC));
        profileEntity.setStartXA(evaluateInfinite(profiles.startXA));
        profileEntity.setStartXBA(evaluateInfinite(profiles.startXBA));
        profileEntity.setStartXBC(evaluateInfinite(profiles.startXBC));
        profileEntity.setStartY(evaluateInfinite(profiles.startY));
        profileEntity.setStartYC(evaluateInfinite(profiles.startYC));
        profileEntity.setStartYA(evaluateInfinite(profiles.startYA));
        profileEntity.setStartYBA(evaluateInfinite(profiles.startYBA));
        profileEntity.setStartYBC(evaluateInfinite(profiles.startYBC));
        profileEntity.setStockCode(profiles.stockCode);
        profileEntity.setStopAeX(evaluateInfinite(profiles.stopAeX));
        profileEntity.setStopAeY(evaluateInfinite(profiles.stopAeY));
        profileEntity.setStopAsX(evaluateInfinite(profiles.stopAsX));
        profileEntity.setStopAsY(evaluateInfinite(profiles.stopAsY));
        profileEntity.setTotalDepth(evaluateInfinite(profiles.totalDepth));
        profileEntity.setTotalSurfaceArea(evaluateInfinite(profiles.totalSurfaceArea));
        profileEntity.setWire(profiles.wire);
        profileEntity.setX1(evaluateInfinite(profiles.x1));
        profileEntity.setX1A(evaluateInfinite(profiles.x1A));
        profileEntity.setX1BA(evaluateInfinite(profiles.x1BA));
        profileEntity.setX1BC(evaluateInfinite(profiles.x1BC));
        profileEntity.setX2(evaluateInfinite(profiles.x2));
        profileEntity.setX2A(evaluateInfinite(profiles.x2A));
        profileEntity.setX2BA(evaluateInfinite(profiles.x2BA));
        profileEntity.setX2BC(evaluateInfinite(profiles.x2BC));
        profileEntity.setY1(evaluateInfinite(profiles.y1));
        profileEntity.setY1A(evaluateInfinite(profiles.y1A));
        profileEntity.setY1BA(evaluateInfinite(profiles.y1BA));
        profileEntity.setY1BC(evaluateInfinite(profiles.y1BC));
        profileEntity.setY2(evaluateInfinite(profiles.y2));
        profileEntity.setY2A(evaluateInfinite(profiles.y2A));
        profileEntity.setY2BA(evaluateInfinite(profiles.y2BA));
        profileEntity.setY2BC(evaluateInfinite(profiles.y2BC));
        profileEntity.setX3(evaluateInfinite(profiles.x3));
        profileEntity.setX3A(evaluateInfinite(profiles.x3A));
        profileEntity.setX3BA(evaluateInfinite(profiles.x3BA));
        profileEntity.setX3BC(evaluateInfinite(profiles.x3BC));
        profileEntity.setX4(evaluateInfinite(profiles.x4));
        profileEntity.setX4A(evaluateInfinite(profiles.x4A));
        profileEntity.setX4BA(evaluateInfinite(profiles.x4BA));
        profileEntity.setX4BC(evaluateInfinite(profiles.x4BC));
        profileEntity.setY3(evaluateInfinite(profiles.y3));
        profileEntity.setY3A(evaluateInfinite(profiles.y3A));
        profileEntity.setY3BA(evaluateInfinite(profiles.y3BA));
        profileEntity.setY3BC(evaluateInfinite(profiles.y3BC));
        profileEntity.setY4(evaluateInfinite(profiles.y4));
        profileEntity.setY4A(evaluateInfinite(profiles.y4A));
        profileEntity.setY4BA(evaluateInfinite(profiles.y4BA));
        profileEntity.setY4BC(evaluateInfinite(profiles.y4BC));
        profileEntity.setParentW(evaluateInfinite(profiles.parentW));
        profileEntity.setCenterStartX(evaluateInfinite(profiles.centerStartX));
        profileEntity.setCenterStartY(evaluateInfinite(profiles.centerStartY));
        profileEntity.setCenterEndX(evaluateInfinite(profiles.centerEndX));
        profileEntity.setCenterEndY(evaluateInfinite(profiles.centerEndY));
        profileEntity.setTopIn(profiles.topIn);
        profileEntity.setRightIn(profiles.rightIn);
        profileEntity.setBotIn(profiles.botIn);
        profileEntity.setLeftIn(profiles.leftIn);
        profileEntity.setPosInUse(profiles.posInUse);
        profileEntity.setRowCol(profiles.rowCol);
        profileEntity.setContinuity(profiles.continuity);
        profileEntity.setOrder(profiles.order);
        profileEntity.setStartPos(profiles.startPos);
        profileEntity.setEndPos(profiles.endPos);
        profileEntity.setCenterXs(evaluateInfinite(profiles.centerXs));
        profileEntity.setCenterXsa(evaluateInfinite(profiles.centerXsa));
        profileEntity.setCenterYsa(evaluateInfinite(profiles.centerYsa));
        profileEntity.setCenterXea(evaluateInfinite(profiles.centerXea));
        profileEntity.setCenterYea(evaluateInfinite(profiles.centerYea));
        profileEntity.setX1a(evaluateInfinite(profiles.x1a));
        profileEntity.setX1b(evaluateInfinite(profiles.x1b));
        profileEntity.setX1a3(evaluateInfinite(profiles.x1a3));
        profileEntity.setY1a(evaluateInfinite(profiles.y1a));
        profileEntity.setY1b(evaluateInfinite(profiles.y1b));
        profileEntity.setY1a3(evaluateInfinite(profiles.y1a3));
        profileEntity.setX2a(evaluateInfinite(profiles.x2a));
        profileEntity.setX2b(evaluateInfinite(profiles.x2b));
        profileEntity.setX2a3(evaluateInfinite(profiles.x2a3));
        profileEntity.setY2a(evaluateInfinite(profiles.y2a));
        profileEntity.setY2b(evaluateInfinite(profiles.y2b));
        profileEntity.setY2a3(evaluateInfinite(profiles.y2a3));
        profileEntity.setX3a(evaluateInfinite(profiles.x3a));
        profileEntity.setX3b(evaluateInfinite(profiles.x3b));
        profileEntity.setX3a3(evaluateInfinite(profiles.x3a3));
        profileEntity.setY3a(evaluateInfinite(profiles.y3a));
        profileEntity.setY3b(evaluateInfinite(profiles.y3b));
        profileEntity.setY3a3(evaluateInfinite(profiles.y3a3));
        profileEntity.setX4a(evaluateInfinite(profiles.x4a));
        profileEntity.setX4b(evaluateInfinite(profiles.x4b));
        profileEntity.setX4a3(evaluateInfinite(profiles.x4a3));
        profileEntity.setY4a(evaluateInfinite(profiles.y4a));
        profileEntity.setY4b(evaluateInfinite(profiles.y4b));
        profileEntity.setX4b(evaluateInfinite(profiles.x4b));
        profileEntity.setY4a3(evaluateInfinite(profiles.y4a3));
        profileEntity.setYce(evaluateInfinite(profiles.yce));
        profileEntity.setYcs(evaluateInfinite(profiles.ycs));
        profileEntity.setXcs(evaluateInfinite(profiles.xcs));
        profileEntity.setXce(evaluateInfinite(profiles.xce));
        profileEntity.setX1al(evaluateInfinite(profiles.x1al));
        profileEntity.setY1al(evaluateInfinite(profiles.y1al));
        profileEntity.setX2cl(evaluateInfinite(profiles.x2cl));
        profileEntity.setY2cl(evaluateInfinite(profiles.y2cl));
        profileEntity.setX3cl(evaluateInfinite(profiles.x3cl));
        profileEntity.setY3cl(evaluateInfinite(profiles.y3cl));
        profileEntity.setX4al(evaluateInfinite(profiles.x4al));
        profileEntity.setY4al(evaluateInfinite(profiles.y4al));
        profileEntity.setCenterXs(evaluateInfinite(profiles.centerXs));
        profileEntity.setCenterYs(evaluateInfinite(profiles.centerYs));
        profileEntity.setCenterXe(evaluateInfinite(profiles.centerXe));
        profileEntity.setCenterYe(evaluateInfinite(profiles.centerYe));
        profileEntity.setThickness(evaluateInfinite(profiles.thickness));
        profileEntity.setOrientation(profiles.orientation);
        profileEntity.setColor(profiles.color);
        profileEntity.setColorIn(profiles.colorIn);
        profileEntity.setColorOut(profiles.colorOut);
        profileEntity.setRgb_R(profiles.rgb_R);
        profileEntity.setRgb_G(profiles.rgb_G);
        profileEntity.setRgb_B(profiles.rgb_B);
        profileEntity.setRgb_Rin(profiles.rgb_Rin);
        profileEntity.setRgb_Gin(profiles.rgb_Gin);
        profileEntity.setRgb_Bin(profiles.rgb_Bin);
        profileEntity.setRgb_Rout(profiles.rgb_Rout);
        profileEntity.setRgb_Rout(profiles.rgb_Gout);
        profileEntity.setRgb_Bout(profiles.rgb_Bout);
        profileEntity.setRgb_Rt(profiles.rgb_Rt);
        profileEntity.setRgb_Gt(profiles.rgb_Gt);
        profileEntity.setRgb_Bt(profiles.rgb_Bt);
        profileEntity.setTransp(profiles.transp);
        profileEntity.setCouplerShapeId(profiles.CouplerShapeID);
        profileEntity.setCouplerTypeId(profiles.couplerTypeID);
        profileEntity.setPosCondition(profiles.posCondition);
        profileEntity.setmType(profiles.mType);
        profileEntity.setStartIn(profiles.startIn);
        profileEntity.setEndIn(profiles.endIn);
        profileEntity.setPartLeft(profiles.partLeft);
        profileEntity.setPartRight(profiles.partRight);
        profileEntity.setcOrM(profiles.cOrM);
        profileEntity.setOpeningTypeLB(profiles.openingTypeLB);
        profileEntity.setOpeningIDLB(profiles.openingIDLB);
        profileEntity.setOpeningTypeRT(profiles.openingTypeRT);
        profileEntity.setOpeningIDRT(profiles.openingIDRT);
        profileEntity.setFixedAngle(profiles.fixedAngle);
        profileEntity.setAngle(evaluateInfinite(profiles.angle));
        profileEntity.setMinAngle(evaluateInfinite(profiles.minAngle));
        profileEntity.setMaxAngle(evaluateInfinite(profiles.maxAngle));
        profileEntity.setDivideFacet(profiles.divideFacet);
        profileEntity.setCentralAnglec(evaluateInfinite(profiles.centralAnglec));
        profileEntity.setCentralAnglec1(evaluateInfinite(profiles.centralAnglec1));
        profileEntity.setCentralAnglea1(evaluateInfinite(profiles.centralAnglea1));
        profileEntity.setCentralAnglea(evaluateInfinite(profiles.centralAnglea));
        profileEntity.setRadius1c(evaluateInfinite(profiles.radius1c));
        profileEntity.setRadius1c1(evaluateInfinite(profiles.radius1c1));
        profileEntity.setRadius1a1(evaluateInfinite(profiles.radius1a1));
        profileEntity.setRadius1a(evaluateInfinite(profiles.radius1a));
        profileEntity.setArcH(evaluateInfinite(profiles.arcH));
        profileEntity.setStartAnglec(evaluateInfinite(profiles.startAnglec));
        profileEntity.setEndAnglec(evaluateInfinite(profiles.endAnglec));
        profileEntity.setStartAnglec1(evaluateInfinite(profiles.startAnglec1));
        profileEntity.setEndAnglec1(evaluateInfinite(profiles.endAnglec1));
        profileEntity.setStartAnglea1(evaluateInfinite(profiles.startAnglea1));
        profileEntity.setEndAnglea1(evaluateInfinite(profiles.endAnglea1));
        profileEntity.setStartAnglea(evaluateInfinite(profiles.startAnglea));
        profileEntity.setEndAnglea(evaluateInfinite(profiles.endAnglea));
        profileEntity.setAngleTLa(evaluateInfinite(profiles.angleTLa));
        profileEntity.setAngleBLa(evaluateInfinite(profiles.angleBLa));
        profileEntity.setAngleTRc(evaluateInfinite(profiles.angleTRc));
        profileEntity.setAngleBRc(evaluateInfinite(profiles.angleBRc));
        profileEntity.setOffsetTL(evaluateInfinite(profiles.offsetTL));
        profileEntity.setOffsetRB(evaluateInfinite(profiles.offsetRB));
        profileEntity.setDeltaTL(evaluateInfinite(profiles.deltaTL));
        profileEntity.setDeltaRB(evaluateInfinite(profiles.deltaRB));
        profileEntity.setCurveCenterTL(evaluateInfinite(profiles.curveCenterTL));
        profileEntity.setCurveCenterRB(evaluateInfinite(profiles.curveCenterRB));
        profileEntity.setGlazedOut(profiles.glazedOut);
        profileEntity.setRemoved(profiles.remove);
        profileEntity.setValid(profiles.isValid);
        profileEntity.setWhichPos(profiles.whichPos);
        profileEntity.setLevelW(evaluateInfinite(profiles.levelW));
        profileEntity.setLevelH(evaluateInfinite(profiles.levelH));
        profileEntity.setLeftInf(profiles.leftInf);
        profileEntity.setRightInf(profiles.rightInf);
        profileEntity.setLengthM(profiles.lengthM);
        profileEntity.setLengthI(profiles.lengthI);
        profileEntity.setLengthMN(profiles.lengthMN);
        profileEntity.setLengthIN(profiles.lengthIN);
        profileEntity.setPhantom(profiles.phantom);
        profileEntity.setTypeId(profiles.typeID);

        profileEntity.setSupplierId(profiles.supplierId);
        profileEntity.setRemote(profiles.remote);

        //********************************************
        //Setting part type object
        //********************************************
        if (profileEntity instanceof ProfileCollectionObject)
            ((ProfileCollectionObject) profileEntity).set_part_object(_part_object);

        //********************************************
        //Setting parts notching
        //********************************************
        Set<PartsNotchingEntityObject> partsNotches = new HashSet<PartsNotchingEntityObject>();
        if (profiles.notches != null && !profiles.notches.isEmpty()) {
            for (Object object : profiles.notches) {
                PartsNotching partNotching = (PartsNotching) object;

                PartsNotchingEntityObject partNotchingEntity = new PartsNotchingEntityObject();
                partNotchingEntity.setLevelId(partNotching.levelID);
                partNotchingEntity.setTop1p(partNotching.top1p);
                partNotchingEntity.setTop2p(partNotching.top2p);
                partNotchingEntity.setTop3p(partNotching.top3p);
                partNotchingEntity.setLeftp(partNotching.leftp);
                partNotchingEntity.setRightp(partNotching.rightp);
                partNotchingEntity.setBot1p(partNotching.bot1p);
                partNotchingEntity.setBot2p(partNotching.bot2p);
                partNotchingEntity.setBot3p(partNotching.bot3p);
                partNotchingEntity.setOrientation(partNotching.orientation);
                partNotchingEntity.setRowcol(partNotching.rowcol);
                partNotchingEntity.setPos(partNotching.pos);
                partNotchingEntity.setNothchType(partNotching.nothchType);
                partNotchingEntity.setX1(partNotching.x1);
                partNotchingEntity.setY1(partNotching.y1);
                partNotchingEntity.setX2(partNotching.x2);
                partNotchingEntity.setY2(partNotching.y2);
                partNotchingEntity.setX3(partNotching.x3);
                partNotchingEntity.setY3(partNotching.y3);
                partNotchingEntity.setXcenter(partNotching.xcenter);
                partNotchingEntity.setYcenter(partNotching.ycenter);
                partNotchingEntity.setX5(partNotching.x5);
                partNotchingEntity.setY5(partNotching.y5);
                partNotchingEntity.setX6(partNotching.x6);
                partNotchingEntity.setY6(partNotching.y6);
                partNotchingEntity.setX7(partNotching.x7);
                partNotchingEntity.setY7(partNotching.y7);
                partNotchingEntity.setNotches(true);

                partsNotches.add(partNotchingEntity);
            }
        }

        //********************************************
        //Setting parts notching LT
        //********************************************
        if (profiles.myNotchLT != null && !profiles.myNothcesLT.isEmpty()) {
            for (Object object : profiles.myNothcesLT) {
                PartsNotching partNotching = (PartsNotching) object;

                PartsNotchingEntityObject partNotchingEntity = new PartsNotchingEntityObject();
                partNotchingEntity.setLevelId(partNotching.levelID);
                partNotchingEntity.setTop1p(partNotching.top1p);
                partNotchingEntity.setTop2p(partNotching.top2p);
                partNotchingEntity.setTop3p(partNotching.top3p);
                partNotchingEntity.setLeftp(partNotching.leftp);
                partNotchingEntity.setRightp(partNotching.rightp);
                partNotchingEntity.setBot1p(partNotching.bot1p);
                partNotchingEntity.setBot2p(partNotching.bot2p);
                partNotchingEntity.setBot3p(partNotching.bot3p);
                partNotchingEntity.setOrientation(partNotching.orientation);
                partNotchingEntity.setRowcol(partNotching.rowcol);
                partNotchingEntity.setPos(partNotching.pos);
                partNotchingEntity.setNothchType(partNotching.nothchType);
                partNotchingEntity.setX1(partNotching.x1);
                partNotchingEntity.setY1(partNotching.y1);
                partNotchingEntity.setX2(partNotching.x2);
                partNotchingEntity.setY2(partNotching.y2);
                partNotchingEntity.setX3(partNotching.x3);
                partNotchingEntity.setY3(partNotching.y3);
                partNotchingEntity.setXcenter(partNotching.xcenter);
                partNotchingEntity.setYcenter(partNotching.ycenter);
                partNotchingEntity.setX5(partNotching.x5);
                partNotchingEntity.setY5(partNotching.y5);
                partNotchingEntity.setX6(partNotching.x6);
                partNotchingEntity.setY6(partNotching.y6);
                partNotchingEntity.setX7(partNotching.x7);
                partNotchingEntity.setY7(partNotching.y7);
                partNotchingEntity.setNotchesLT(true);

                partsNotches.add(partNotchingEntity);
            }
        }

        //********************************************
        //Setting parts notching RB
        //********************************************
        if (profiles.myNothcesRB != null && !profiles.myNothcesRB.isEmpty()) {
            for (Object object : profiles.myNothcesRB) {

                PartsNotching partNotching = (PartsNotching) object;

                PartsNotchingEntityObject partNotchingEntity = new PartsNotchingEntityObject();
                partNotchingEntity.setLevelId(partNotching.levelID);
                partNotchingEntity.setTop1p(partNotching.top1p);
                partNotchingEntity.setTop2p(partNotching.top2p);
                partNotchingEntity.setTop3p(partNotching.top3p);
                partNotchingEntity.setLeftp(partNotching.leftp);
                partNotchingEntity.setRightp(partNotching.rightp);
                partNotchingEntity.setBot1p(partNotching.bot1p);
                partNotchingEntity.setBot2p(partNotching.bot2p);
                partNotchingEntity.setBot3p(partNotching.bot3p);
                partNotchingEntity.setOrientation(partNotching.orientation);
                partNotchingEntity.setRowcol(partNotching.rowcol);
                partNotchingEntity.setPos(partNotching.pos);
                partNotchingEntity.setNothchType(partNotching.nothchType);
                partNotchingEntity.setX1(partNotching.x1);
                partNotchingEntity.setY1(partNotching.y1);
                partNotchingEntity.setX2(partNotching.x2);
                partNotchingEntity.setY2(partNotching.y2);
                partNotchingEntity.setX3(partNotching.x3);
                partNotchingEntity.setY3(partNotching.y3);
                partNotchingEntity.setXcenter(partNotching.xcenter);
                partNotchingEntity.setYcenter(partNotching.ycenter);
                partNotchingEntity.setX5(partNotching.x5);
                partNotchingEntity.setY5(partNotching.y5);
                partNotchingEntity.setX6(partNotching.x6);
                partNotchingEntity.setY6(partNotching.y6);
                partNotchingEntity.setX7(partNotching.x7);
                partNotchingEntity.setY7(partNotching.y7);
                partNotchingEntity.setNotchesRB(true);

                partsNotches.add(partNotchingEntity);
            }
        }

        profileEntity.setPartsNotching(partsNotches);

        //********************************************
        //Setting shape options
        //********************************************
        if ((profiles.options != null) && (!profiles.options.isEmpty())) {

            Set<ShapeOptionEntityObject> options = new HashSet<ShapeOptionEntityObject>();
            for (ShapeOption shapeOption : profiles.options) {
                options.add(ShapeOptionDTO.getShapeOptionEntity(shapeOption));
            }

            profileEntity.setOptions(options);
        }

        //********************************************
        //Setting bill of materials
        //********************************************
        if ((profiles.bom != null) && (!profiles.bom.isEmpty())) {
            Set<BillOfMaterialEntityObject> boms = new HashSet<BillOfMaterialEntityObject>();
            for (BillOfMat billOfMat : profiles.bom) {
                boms.add(BillOfMaterialDTO.getBillOfMaterialEntity(billOfMat));
            }

            profileEntity.setBoms(boms);
        }

        //*********************************************
        //Setting Shape notes
        //*********************************************
        if (profiles.notes != null && !profiles.notes.isEmpty()) {
            Set<ShapeNotesEntityObject> notes = new HashSet<ShapeNotesEntityObject>();
            for (ShapeNotes shapeNotes : profiles.notes) {
                notes.add(ShapeNotesDTO.getShapeNotesEntityObject(shapeNotes));
            }

            profileEntity.setNotes(notes);
        }

        return profileEntity;
    }

    /**
     * This method create a ProfileParts object model
     *
     * @param profiles,            ProfileParts
     * @param profileEntityObject, ProfileEntityObject
     * @throws dto.DTOTransformationError, Error
     */
    public static void createProfiles(ProfileParts profiles, ProfileAbstractObject profileEntityObject)
            throws DTOTransformationError {

        if (profileEntityObject == null || profiles == null) {
            throw new DTOTransformationError();
        }

        //Preparing new scale calculation
        BigDecimal _original_scale = profiles.myFrame2.jobItem.originalScaleS;
        BigDecimal _new_scale = profiles.myFrame2.jobItem.newScaleS;

        BigDecimal _starting_x = new BigDecimal(profiles.myFrame2.jobItem.startingX + "");
        BigDecimal _starting_y = new BigDecimal(profiles.myFrame2.jobItem.startingY + "");

        //Construction map
        profiles.a_assemblyLevel = profileEntityObject.getConstructionMap().get_a_assemblyLevel();
        profiles.a_1Level = profileEntityObject.getConstructionMap().get_a_1Level();
        profiles.a_2Level = profileEntityObject.getConstructionMap().get_a_2Level();
        profiles.a_3Level = profileEntityObject.getConstructionMap().get_a_3Level();
        profiles.a_4Level = profileEntityObject.getConstructionMap().get_a_4Level();
        profiles.a_5Level = profileEntityObject.getConstructionMap().get_a_5Level();
        profiles.a_6Level = profileEntityObject.getConstructionMap().get_a_6Level();
        profiles.a_7Level = profileEntityObject.getConstructionMap().get_a_7Level();
        profiles.a_8Level = profileEntityObject.getConstructionMap().get_a_8Level();
        profiles.a_9Level = profileEntityObject.getConstructionMap().get_a_9Level();
        profiles.a_10Level = profileEntityObject.getConstructionMap().get_a_10Level();
        profiles.a_11Level = profileEntityObject.getConstructionMap().get_a_11Level();
        profiles.a_12Level = profileEntityObject.getConstructionMap().get_a_12Level();
        profiles.a_13Level = profileEntityObject.getConstructionMap().get_a_13Level();
        profiles.a_14Level = profileEntityObject.getConstructionMap().get_a_14Level();
        profiles.a_15Level = profileEntityObject.getConstructionMap().get_a_15Level();
        profiles.a_16Level = profileEntityObject.getConstructionMap().get_a_16Level();
        profiles.a_17Level = profileEntityObject.getConstructionMap().get_a_17Level();
        profiles.a_18Level = profileEntityObject.getConstructionMap().get_a_18Level();
        profiles.a_19Level = profileEntityObject.getConstructionMap().get_a_19Level();
        profiles.a_20Level = profileEntityObject.getConstructionMap().get_a_20Level();
        profiles.a_21Level = profileEntityObject.getConstructionMap().get_a_21Level();
        profiles.a_22Level = profileEntityObject.getConstructionMap().get_a_22Level();
        profiles.a_1Sequence = profileEntityObject.getConstructionMap().get_a_1Sequence();
        profiles.a_2Sequence = profileEntityObject.getConstructionMap().get_a_2Sequence();
        profiles.a_3Sequence = profileEntityObject.getConstructionMap().get_a_3Sequence();
        profiles.a_4Sequence = profileEntityObject.getConstructionMap().get_a_4Sequence();
        profiles.a_5Sequence = profileEntityObject.getConstructionMap().get_a_5Sequence();
        profiles.a_6Sequence = profileEntityObject.getConstructionMap().get_a_6Sequence();
        profiles.a_7Sequence = profileEntityObject.getConstructionMap().get_a_7Sequence();
        profiles.a_8Sequence = profileEntityObject.getConstructionMap().get_a_8Sequence();
        profiles.a_9Sequence = profileEntityObject.getConstructionMap().get_a_9Sequence();
        profiles.a_10Sequence = profileEntityObject.getConstructionMap().get_a_10Sequence();
        profiles.a_11Sequence = profileEntityObject.getConstructionMap().get_a_11Sequence();
        profiles.a_12Sequence = profileEntityObject.getConstructionMap().get_a_12Sequence();
        profiles.a_13Sequence = profileEntityObject.getConstructionMap().get_a_13Sequence();
        profiles.a_14Sequence = profileEntityObject.getConstructionMap().get_a_14Sequence();
        profiles.a_15Sequence = profileEntityObject.getConstructionMap().get_a_15Sequence();
        profiles.a_16Sequence = profileEntityObject.getConstructionMap().get_a_16Sequence();
        profiles.a_17Sequence = profileEntityObject.getConstructionMap().get_a_17Sequence();
        profiles.a_18Sequence = profileEntityObject.getConstructionMap().get_a_18Sequence();
        profiles.a_19Sequence = profileEntityObject.getConstructionMap().get_a_19Sequence();
        profiles.a_20Sequence = profileEntityObject.getConstructionMap().get_a_20Sequence();
        profiles.a_21Sequence = profileEntityObject.getConstructionMap().get_a_21Sequence();
        profiles.a_22Sequence = profileEntityObject.getConstructionMap().get_a_22Sequence();

        profiles.shapeID = profileEntityObject.getShapeId();
        profiles.a_sequenceID = profileEntityObject.getSequenceId();
        profiles.a_levelID = profileEntityObject.getLevelId();
        profiles.levelID = profileEntityObject.getLevelId();
        profiles.parentid = profileEntityObject.getParentId();

        profiles.exists = profileEntityObject.getExist();
        profiles.seq = profileEntityObject.getSeq();
        profiles.ABClines = profileEntityObject.getAbcLines();
        profiles.partForm = profileEntityObject.getPartForm();
        profiles.partID = profileEntityObject.getPartID();
        profiles.partShape = profileEntityObject.getPartShape();
        profiles.position = profileEntityObject.getPosition();
        profiles.endTypeLT = profileEntityObject.getEndTypeLT();
        profiles.endTypeRB = profileEntityObject.getEndTypeRB();
        profiles.myLean = profileEntityObject.getMyLean();
        profiles.myLean2 = profileEntityObject.getMyLean2();
        profiles.myLean3 = profileEntityObject.getMyLean3();
        profiles.myLean4 = profileEntityObject.getMyLean4();

        profiles.bkgrdHeight = calculateNewValueWithScale(profileEntityObject.getBkgrdHeight(), _original_scale,
                _new_scale);
        profiles.bkgrdHeightA = calculateNewValueWithScale(profileEntityObject.getBkgrdHeightA(), _original_scale,
                _new_scale);
        profiles.bkgrdHeightBA = calculateNewValueWithScale(profileEntityObject.getBkgrdHeightBA(), _original_scale,
                _new_scale);
        profiles.bkgrdHeightBC = profileEntityObject.getBkgrdHeightBC().doubleValue();

        profiles.bkgrdStartX = calculateNewValueWidthStartingPoint(profileEntityObject.getBkgrdStartX(), _starting_x,
                _original_scale, _new_scale);
        profiles.bkgrdStartXA = calculateNewValueWidthStartingPoint(profileEntityObject.getBkgrdStartXA(), _starting_x,
                _original_scale, _new_scale);
        profiles.bkgrdStartXBA = calculateNewValueWidthStartingPoint(profileEntityObject.getBkgrdStartXBA(), _starting_x,
                _original_scale, _new_scale);
        profiles.bkgrdStartXBC = profileEntityObject.getBkgrdStartXBC().doubleValue();
        profiles.bkgrdStartY = calculateNewValueWidthStartingPoint(profileEntityObject.getBkgrdStartY(), _starting_y,
                _original_scale, _new_scale);
        profiles.bkgrdStartYA = calculateNewValueWidthStartingPoint(profileEntityObject.getBkgrdStartYA(), _starting_y,
                _original_scale, _new_scale);
        profiles.bkgrdStartYBA = calculateNewValueWidthStartingPoint(profileEntityObject.getBkgrdStartYBA(), _starting_y,
                _original_scale, _new_scale);
        profiles.bkgrdStartYBC = profileEntityObject.getBkgrdStartYBC().doubleValue();
        profiles.bkgrdWidth = calculateNewValueWithScale(profileEntityObject.getBkgrdWidth(), _original_scale,
                _new_scale);
        profiles.bkgrdWidthA = calculateNewValueWithScale(profileEntityObject.getBkgrdWidthA(), _original_scale,
                _new_scale);
        profiles.bkgrdWidthBA = calculateNewValueWithScale(profileEntityObject.getBkgrdWidthBA(), _original_scale,
                _new_scale);
        profiles.bkgrdWidthBC = profileEntityObject.getBkgrdWidthBC().doubleValue();
        profiles.centralAngle = profileEntityObject.getCentralAngle().doubleValue();
        profiles.centralAngleA = profileEntityObject.getCentralAngleA().doubleValue();
        profiles.centralAngleBA = profileEntityObject.getCentralAngleBA().doubleValue();
        profiles.centralAngleBC = profileEntityObject.getCentralAngleBC().doubleValue();
        profiles.dimB1A = profileEntityObject.getDimB1A().doubleValue();
        profiles.dimB1B = profileEntityObject.getDimB1B().doubleValue();
        profiles.endAngle = profileEntityObject.getEndAngle().doubleValue();
        profiles.endAngleA = profileEntityObject.getEndAngleA().doubleValue();
        profiles.endAngleBA = profileEntityObject.getEndAngleBA().doubleValue();
        profiles.endAngleBC = profileEntityObject.getEndAngleBC().doubleValue();
        profiles.endX = calculateNewValueWidthStartingPoint(profileEntityObject.getEndX(), _starting_x, _original_scale,
                _new_scale);
        profiles.endXC = calculateNewValueWidthStartingPoint(profileEntityObject.getEndXC(), _starting_x, _original_scale,
                _new_scale);
        profiles.endXA = calculateNewValueWidthStartingPoint(profileEntityObject.getEndXA(), _starting_x, _original_scale,
                _new_scale);
        profiles.endXBA = calculateNewValueWidthStartingPoint(profileEntityObject.getEndXBA(), _starting_x, _original_scale,
                _new_scale);
        profiles.endXBC = profileEntityObject.getEndXBC().doubleValue();
        profiles.endY = calculateNewValueWidthStartingPoint(profileEntityObject.getEndY(), _starting_y, _original_scale,
                _new_scale);
        profiles.endYC = calculateNewValueWidthStartingPoint(profileEntityObject.getEndYC(), _starting_y, _original_scale,
                _new_scale);
        profiles.endYA = calculateNewValueWidthStartingPoint(profileEntityObject.getEndYA(), _starting_y, _original_scale,
                _new_scale);
        profiles.endYBA = calculateNewValueWidthStartingPoint(profileEntityObject.getEndYBA(), _starting_y, _original_scale,
                _new_scale);
        profiles.endYBC = profileEntityObject.getEndYBC().doubleValue();
        profiles.focal1X = calculateNewValueWidthStartingPoint(profileEntityObject.getFocal1X(), _starting_x,
                _original_scale, _new_scale);
        profiles.focal1XA = calculateNewValueWidthStartingPoint(profileEntityObject.getFocal1XA(), _starting_x,
                _original_scale, _new_scale);
        profiles.focal1XBA = calculateNewValueWidthStartingPoint(profileEntityObject.getFocal1XBA(), _starting_x,
                _original_scale, _new_scale);
        profiles.focal1XBC = profileEntityObject.getFocal1XBC().doubleValue();
        profiles.focal1Y = calculateNewValueWidthStartingPoint(profileEntityObject.getFocal1Y(), _starting_y,
                _original_scale, _new_scale);
        profiles.focal1YA = calculateNewValueWidthStartingPoint(profileEntityObject.getFocal1YA(), _starting_y, _original_scale,
                _new_scale);
        profiles.focal1YBA = calculateNewValueWidthStartingPoint(profileEntityObject.getFocal1YBA(), _starting_y, _original_scale,
                _new_scale);
        profiles.focal1YBC = profileEntityObject.getFocal1YBC().doubleValue();
        profiles.focal2X = calculateNewValueWidthStartingPoint(profileEntityObject.getFocal2X(), _starting_x, _original_scale,
                _new_scale);
        profiles.focal2XA = calculateNewValueWidthStartingPoint(profileEntityObject.getFocal2XA(), _starting_x, _original_scale,
                _new_scale);
        profiles.focal2XBA = calculateNewValueWidthStartingPoint(profileEntityObject.getFocal2XBA(), _starting_x, _original_scale,
                _new_scale);
        profiles.focal2XBC = profileEntityObject.getFocal2XBC().doubleValue();
        profiles.focal2Y = calculateNewValueWidthStartingPoint(profileEntityObject.getFocal2Y(), _starting_y, _original_scale,
                _new_scale);
        profiles.focal2YA = calculateNewValueWidthStartingPoint(profileEntityObject.getFocal2YA(), _starting_y, _original_scale,
                _new_scale);
        profiles.focal2YBA = calculateNewValueWidthStartingPoint(profileEntityObject.getFocal2YBA(), _starting_y, _original_scale,
                _new_scale);
        profiles.focal2YBC = profileEntityObject.getFocal2YBC().doubleValue();
        profiles.glazingDepth = profileEntityObject.getGlazingDepth().doubleValue();
        profiles.inLaminateArea = profileEntityObject.getInLaminateArea().doubleValue();
        profiles.inPaintArea = profileEntityObject.getInPaintArea().doubleValue();
        profiles.length = calculateNewValueWithScale(profileEntityObject.getLength(), _original_scale, _new_scale);
        profiles.lengthA = profileEntityObject.getLengthA().doubleValue();
        profiles.lengthBA = profileEntityObject.getLengthBA().doubleValue();
        profiles.lengthBC = profileEntityObject.getLengthBC().doubleValue();
        profiles.ltAngle = profileEntityObject.getLtAngle().doubleValue();
        profiles.ltAngleA = profileEntityObject.getLtAngleA().doubleValue();
        profiles.ltAngleBA = profileEntityObject.getLtAngleBA().doubleValue();
        profiles.ltAngleBC = profileEntityObject.getLtAngleBC().doubleValue();
        profiles.mitreLengthLT = profileEntityObject.getMitreLengthLT().doubleValue();
        profiles.mitreLengthRB = profileEntityObject.getMitreLengthRB().doubleValue();
        profiles.myWidth = profileEntityObject.getMyWidth().doubleValue();
        profiles.myWidthA = profileEntityObject.getMyWidthA().doubleValue();
        profiles.myWidthBA = profileEntityObject.getMyWidthBA().doubleValue();
        profiles.newX = profileEntityObject.getNewX().doubleValue();
        profiles.newXA = profileEntityObject.getNewXA().doubleValue();
        profiles.newY = profileEntityObject.getNewY().doubleValue();
        profiles.newYA = profileEntityObject.getNewYA().doubleValue();
        profiles.outLaminateArea = profileEntityObject.getOutLaminateArea().doubleValue();
        profiles.outPaintArea = profileEntityObject.getOutPaintArea().doubleValue();
        profiles.partDimA = calculateNewValueWithScale(profileEntityObject.getPartDimA(), _original_scale, _new_scale);
        profiles.partDimAi = profileEntityObject.getPartDimAi().doubleValue();
        profiles.partDimB = calculateNewValueWithScale(profileEntityObject.getPartDimB(), _original_scale, _new_scale);
        profiles.partDimBi = profileEntityObject.getPartDimBi().doubleValue();
        profiles.partDimC = profileEntityObject.getPartDimC().doubleValue();
        profiles.partDimCi = profileEntityObject.getPartDimCi().doubleValue();
        profiles.partDimD = profileEntityObject.getPartDimD().doubleValue();
        profiles.partDimDi = profileEntityObject.getPartDimDi().doubleValue();
        profiles.partDimM = calculateNewValueWithScale(profileEntityObject.getPartDimM(), _original_scale, _new_scale);
        profiles.partDimMi = profileEntityObject.getPartDimMi().doubleValue();
        profiles.partDimBtoC = profileEntityObject.getPartDimBtoC().doubleValue();
        profiles.partDimBtoCi = profileEntityObject.getPartDimBtoCI().doubleValue();
        profiles.radianCentralAngle = profileEntityObject.getRadianCentralAngle().doubleValue();
        profiles.radius1 = calculateNewValueWithScale(profileEntityObject.getRadius1(), _original_scale, _new_scale);
        profiles.radius1A = calculateNewValueWithScale(profileEntityObject.getRadius1A(), _original_scale, _new_scale);
        profiles.radius1BA = calculateNewValueWithScale(profileEntityObject.getRadius1BA(), _original_scale, _new_scale);
        profiles.radius1BC = profileEntityObject.getRadius1BC().doubleValue();
        profiles.radius2 = profileEntityObject.getRadius2().doubleValue();
        profiles.radius2A = calculateNewValueWithScale(profileEntityObject.getRadius2A(), _original_scale, _new_scale);
        profiles.radius2BA = calculateNewValueWithScale(profileEntityObject.getRadius2BA(), _original_scale, _new_scale);
        profiles.radius2BC = profileEntityObject.getRadius2BC().doubleValue();
        profiles.radsStart = profileEntityObject.getRadsStart().doubleValue();
        profiles.radsStart2 = profileEntityObject.getRadsStart2().doubleValue();
        profiles.radsStart2A = profileEntityObject.getRadsStart2A().doubleValue();
        profiles.radsStart2BA = profileEntityObject.getRadsStart2BA().doubleValue();
        profiles.radsStartA = profileEntityObject.getRadsStartA().doubleValue();
        profiles.radsStartBA = profileEntityObject.getRadsStartBA().doubleValue();
        profiles.rbAngle = profileEntityObject.getRbAngle().doubleValue();
        profiles.rbAngleA = profileEntityObject.getRbAngleA().doubleValue();
        profiles.rbAngleBA = profileEntityObject.getRbAngleBA().doubleValue();
        profiles.rbAngleBC = profileEntityObject.getRbAngleBC().doubleValue();
        profiles.rID = profileEntityObject.getrID();
        profiles.rlAngle = profileEntityObject.getRlAngle().doubleValue();
        profiles.rlAngleA = profileEntityObject.getRlAngleA().doubleValue();
        profiles.rlAngleBA = profileEntityObject.getRlAngleBA().doubleValue();
        profiles.rlSlope = profileEntityObject.getRlSlope().doubleValue();
        profiles.rlSlopeA = profileEntityObject.getRlSlopeA().doubleValue();
        profiles.rlSlopeBA = profileEntityObject.getRlSlopeBA().doubleValue();
        profiles.rrAngle = profileEntityObject.getRrAngle().doubleValue();
        profiles.rrAngleA = profileEntityObject.getRrAngleA().doubleValue();
        profiles.rrAngleBA = profileEntityObject.getRrAngleBA().doubleValue();
        profiles.rrSlope = (profileEntityObject.getRrSlope().doubleValue() == INFINITY_NEGATIVE.doubleValue() ||
                profileEntityObject.getRrSlope().doubleValue() == INFINITY_POSITIVE.doubleValue()) ? Double.POSITIVE_INFINITY :
                profileEntityObject.getRrSlope().doubleValue();
        profiles.rrSlopeA = (profileEntityObject.getRrSlopeA().doubleValue() == INFINITY_NEGATIVE.doubleValue() ||
                profileEntityObject.getRrSlopeA().doubleValue() == INFINITY_POSITIVE.doubleValue()) ? Double.POSITIVE_INFINITY :
                profileEntityObject.getRrSlopeA().doubleValue();
        profiles.rrSlopeBA = (profileEntityObject.getRrSlopeBA().doubleValue() == INFINITY_NEGATIVE.doubleValue() ||
                profileEntityObject.getRrSlopeBA().doubleValue() == INFINITY_POSITIVE.doubleValue()) ? Double.POSITIVE_INFINITY :
                profileEntityObject.getRrSlopeBA().doubleValue();
        profiles.slope = (profileEntityObject.getSlope().doubleValue() == INFINITY_NEGATIVE.doubleValue() ||
                profileEntityObject.getSlope().doubleValue() == INFINITY_POSITIVE.doubleValue()) ? Double.POSITIVE_INFINITY :
                profileEntityObject.getSlope().doubleValue();
        profiles.slopeA = (profileEntityObject.getSlopeA().doubleValue() == INFINITY_NEGATIVE.doubleValue() ||
                profileEntityObject.getSlopeA().doubleValue() == INFINITY_POSITIVE.doubleValue()) ? Double.POSITIVE_INFINITY :
                profileEntityObject.getSlopeA().doubleValue();
        profiles.slopeBA = (profileEntityObject.getSlopeBA().doubleValue() == INFINITY_NEGATIVE.doubleValue() ||
                profileEntityObject.getSlopeBA().doubleValue() == INFINITY_POSITIVE.doubleValue()) ? Double.POSITIVE_INFINITY :
                profileEntityObject.getSlopeBA().doubleValue();
        profiles.slopeBC = (profileEntityObject.getSlopeBC().doubleValue() == INFINITY_NEGATIVE.doubleValue() ||
                profileEntityObject.getSlopeBC().doubleValue() == INFINITY_POSITIVE.doubleValue()) ? Double.POSITIVE_INFINITY :
                profileEntityObject.getSlopeBC().doubleValue();
        profiles.startAngle = profileEntityObject.getStartAngle().doubleValue();
        profiles.startAngleA = profileEntityObject.getStartAngleA().doubleValue();
        profiles.startAngleBA = profileEntityObject.getStartAngleBA().doubleValue();
        profiles.startAngleBC = profileEntityObject.getStartAngleBC().doubleValue();
        profiles.startingX = profileEntityObject.getStartingX().doubleValue();
        profiles.startingXA = profileEntityObject.getStartingXA().doubleValue();
        profiles.startingXBA = profileEntityObject.getStartingXBA().doubleValue();
        profiles.startingXBC = profileEntityObject.getStartingXBC().doubleValue();
        profiles.startingY = calculateNewValueWidthStartingPoint(profileEntityObject.getStartingY(), _starting_y,
                _original_scale, _new_scale);
        profiles.startingYA = profileEntityObject.getStartingYA().doubleValue();
        profiles.startingYBA = profileEntityObject.getStartingYBA().doubleValue();
        profiles.startingYBC = profileEntityObject.getStartingYBC().doubleValue();
        profiles.startX = calculateNewValueWidthStartingPoint(profileEntityObject.getStartX(), _starting_x,
                _original_scale, _new_scale);
        profiles.startXC = calculateNewValueWidthStartingPoint(profileEntityObject.getStartXC(), _starting_x,
                _original_scale, _new_scale);
        profiles.startXA = calculateNewValueWidthStartingPoint(profileEntityObject.getStartXA(), _starting_x,
                _original_scale, _new_scale);
        profiles.startXBA = calculateNewValueWidthStartingPoint(profileEntityObject.getStartXBA(), _starting_x,
                _original_scale, _new_scale);
        profiles.startXBC = profileEntityObject.getStartXBC().doubleValue();
        profiles.startY = calculateNewValueWidthStartingPoint(profileEntityObject.getStartY(), _starting_y,
                _original_scale, _new_scale);
        profiles.startYC = calculateNewValueWidthStartingPoint(profileEntityObject.getStartYC(), _starting_y,
                _original_scale, _new_scale);
        profiles.startYA = calculateNewValueWidthStartingPoint(profileEntityObject.getStartYA(), _starting_y,
                _original_scale, _new_scale);
        profiles.startYBA = calculateNewValueWidthStartingPoint(profileEntityObject.getStartYBA(), _starting_y,
                _original_scale, _new_scale);
        profiles.startYBC = profileEntityObject.getStartYBC().doubleValue();
        profiles.stockCode = profileEntityObject.getStockCode();
        profiles.stopAeX = calculateNewValueWidthStartingPoint(profileEntityObject.getStopAeX(), _starting_x,
                _original_scale, _new_scale);
        profiles.stopAeY = calculateNewValueWidthStartingPoint(profileEntityObject.getStopAeY(), _starting_y,
                _original_scale, _new_scale);
        profiles.stopAsX = calculateNewValueWidthStartingPoint(profileEntityObject.getStopAsX(), _starting_x,
                _original_scale, _new_scale);
        profiles.stopAsY = calculateNewValueWidthStartingPoint(profileEntityObject.getStopAsY(), _starting_y,
                _original_scale, _new_scale);
        profiles.totalDepth = profileEntityObject.getTotalDepth().doubleValue();
        profiles.totalSurfaceArea = profileEntityObject.getTotalSurfaceArea().doubleValue();
        profiles.wire = profileEntityObject.isWire();
        profiles.x1 = calculateNewValueWidthStartingPoint(profileEntityObject.getX1(), _starting_x, _original_scale,
                _new_scale);
        profiles.x1A = calculateNewValueWidthStartingPoint(profileEntityObject.getX1A(), _starting_x, _original_scale,
                _new_scale);
        profiles.x1BA = calculateNewValueWidthStartingPoint(profileEntityObject.getX1BA(), _starting_x, _original_scale,
                _new_scale);
        profiles.x1BC = profileEntityObject.getX1BC().doubleValue();
        profiles.x2 = calculateNewValueWidthStartingPoint(profileEntityObject.getX2(), _starting_x, _original_scale,
                _new_scale);
        profiles.x2A = calculateNewValueWidthStartingPoint(profileEntityObject.getX2A(), _starting_x, _original_scale,
                _new_scale);
        profiles.x2BA = calculateNewValueWidthStartingPoint(profileEntityObject.getX2BA(), _starting_x, _original_scale,
                _new_scale);
        profiles.x2BC = profileEntityObject.getX2BC().doubleValue();
        profiles.y1 = calculateNewValueWidthStartingPoint(profileEntityObject.getY1(), _starting_y, _original_scale,
                _new_scale);
        profiles.y1A = calculateNewValueWidthStartingPoint(profileEntityObject.getY1A(), _starting_y, _original_scale,
                _new_scale);
        profiles.y1BA = calculateNewValueWidthStartingPoint(profileEntityObject.getY1BA(), _starting_y, _original_scale,
                _new_scale);
        profiles.y1BC = profileEntityObject.getY1BC().doubleValue();
        profiles.y2 = calculateNewValueWidthStartingPoint(profileEntityObject.getY2(), _starting_y, _original_scale,
                _new_scale);
        profiles.y2A = calculateNewValueWidthStartingPoint(profileEntityObject.getY2A(), _starting_y, _original_scale,
                _new_scale);
        profiles.y2BA = calculateNewValueWidthStartingPoint(profileEntityObject.getY2BA(), _starting_y, _original_scale,
                _new_scale);
        profiles.y2BC = profileEntityObject.getY2BC().doubleValue();
        profiles.x3 = calculateNewValueWidthStartingPoint(profileEntityObject.getX3(), _starting_x, _original_scale,
                _new_scale);
        profiles.x3A = profileEntityObject.getX3A().doubleValue();
        profiles.x3BA = profileEntityObject.getX3BA().doubleValue();
        profiles.x3BC = profileEntityObject.getX3BC().doubleValue();
        profiles.x4 = calculateNewValueWidthStartingPoint(profileEntityObject.getX4(), _starting_x, _original_scale,
                _new_scale);
        profiles.x4A = profileEntityObject.getX4A().doubleValue();
        profiles.x4BA = profileEntityObject.getX4BA().doubleValue();
        profiles.x4BC = profileEntityObject.getX4BC().doubleValue();
        profiles.y3 = calculateNewValueWidthStartingPoint(profileEntityObject.getY3(), _starting_y, _original_scale,
                _new_scale);
        profiles.y3A = profileEntityObject.getY3A().doubleValue();
        profiles.y3BA = profileEntityObject.getY3BA().doubleValue();
        profiles.y3BC = profileEntityObject.getY3BC().doubleValue();
        profiles.y4 = calculateNewValueWidthStartingPoint(profileEntityObject.getY4(), _starting_y, _original_scale,
                _new_scale);
        profiles.y4A = profileEntityObject.getY4A().doubleValue();
        profiles.y4BA = profileEntityObject.getY4BA().doubleValue();
        profiles.y4BC = profileEntityObject.getY4BC().doubleValue();
        profiles.parentW = profileEntityObject.getParentW().doubleValue();
        profiles.centerStartX = profileEntityObject.getCenterStartX().doubleValue();
        profiles.centerStartY = profileEntityObject.getCenterStartY().doubleValue();
        profiles.centerEndX = profileEntityObject.getCenterEndX().doubleValue();
        profiles.centerEndY = profileEntityObject.getCenterEndY().doubleValue();
        profiles.topIn = profileEntityObject.isTopIn();
        profiles.rightIn = profileEntityObject.isRightIn();
        profiles.botIn = profileEntityObject.isBotIn();
        profiles.leftIn = profileEntityObject.isLeftIn();
        profiles.posInUse = profileEntityObject.isPosInUse();
        profiles.rowCol = profileEntityObject.getRowCol();
        profiles.continuity = profileEntityObject.getContinuity();
        profiles.order = profileEntityObject.getOrder();
        profiles.startPos = profileEntityObject.getStartPos();
        profiles.endPos = profileEntityObject.getEndPos();
        profiles.centerXs = profileEntityObject.getCenterXs().doubleValue();
        profiles.centerXsa = profileEntityObject.getCenterXsa().doubleValue();
        profiles.centerYsa = profileEntityObject.getCenterYsa().doubleValue();
        profiles.centerXea = profileEntityObject.getCenterXea().doubleValue();
        profiles.centerYea = profileEntityObject.getCenterYea().doubleValue();
        profiles.x1a = calculateNewValueWidthStartingPoint(profileEntityObject.getX1a(), _starting_x, _original_scale,
                _new_scale);
        profiles.x1b = profileEntityObject.getX1b().doubleValue();
        profiles.x1a3 = profileEntityObject.getX1a3().doubleValue();
        profiles.y1a = calculateNewValueWidthStartingPoint(profileEntityObject.getY1a(), _starting_y, _original_scale,
                _new_scale);
        profiles.y1b = calculateNewValueWidthStartingPoint(profileEntityObject.getY1b(), _starting_y, _original_scale,
                _new_scale);
        profiles.y1a3 = profileEntityObject.getY1a3().doubleValue();
        profiles.x2a = calculateNewValueWidthStartingPoint(profileEntityObject.getX2a(), _starting_x, _original_scale,
                _new_scale);
        profiles.x2b = profileEntityObject.getX2b().doubleValue();
        profiles.x2a3 = profileEntityObject.getX2a3().doubleValue();
        profiles.y2a = calculateNewValueWidthStartingPoint(profileEntityObject.getY2a(), _starting_y, _original_scale,
                _new_scale);
        profiles.y2b = calculateNewValueWidthStartingPoint(profileEntityObject.getY2b(), _starting_y, _original_scale,
                _new_scale);
        profiles.y2a3 = profileEntityObject.getY2a3().doubleValue();
        profiles.x3a = calculateNewValueWidthStartingPoint(profileEntityObject.getX3a(), _starting_x, _original_scale,
                _new_scale);
        profiles.x3b = profileEntityObject.getX3b().doubleValue();
        profiles.x3a3 = profileEntityObject.getX3a3().doubleValue();
        profiles.y3a = calculateNewValueWidthStartingPoint(profileEntityObject.getY3a(), _starting_y, _original_scale,
                _new_scale);
        profiles.y3b = calculateNewValueWidthStartingPoint(profileEntityObject.getY3b(), _starting_y, _original_scale,
                _new_scale);
        profiles.y3a3 = profileEntityObject.getY3a3().doubleValue();
        profiles.x4a = calculateNewValueWidthStartingPoint(profileEntityObject.getX4a(), _starting_x, _original_scale,
                _new_scale);
        profiles.x4b = profileEntityObject.getX4b().doubleValue();
        profiles.x4a3 = profileEntityObject.getX4a3().doubleValue();
        profiles.y4a = calculateNewValueWidthStartingPoint(profileEntityObject.getY4a(), _starting_y, _original_scale,
                _new_scale);
        profiles.y4b = calculateNewValueWidthStartingPoint(profileEntityObject.getY4b(), _starting_y, _original_scale,
                _new_scale);
        profiles.y4a3 = profileEntityObject.getY4a3().doubleValue();
        profiles.yce = profileEntityObject.getYce().doubleValue();
        profiles.ycs = profileEntityObject.getYcs().doubleValue();
        profiles.xcs = profileEntityObject.getXcs().doubleValue();
        profiles.xce = profileEntityObject.getXce().doubleValue();
        profiles.x1al = calculateNewValueWidthStartingPoint(profileEntityObject.getX1al(), _starting_x, _original_scale,
                _new_scale);
        profiles.y1al = calculateNewValueWidthStartingPoint(profileEntityObject.getY1al(), _starting_y, _original_scale,
                _new_scale);
        profiles.x2cl = calculateNewValueWidthStartingPoint(profileEntityObject.getX2cl(), _starting_x, _original_scale,
                _new_scale);
        profiles.y2cl = calculateNewValueWidthStartingPoint(profileEntityObject.getY2cl(), _starting_y, _original_scale,
                _new_scale);
        profiles.x3cl = calculateNewValueWidthStartingPoint(profileEntityObject.getX3cl(), _starting_x, _original_scale,
                _new_scale);
        profiles.y3cl = calculateNewValueWidthStartingPoint(profileEntityObject.getY3cl(), _starting_y, _original_scale,
                _new_scale);
        profiles.x4al = calculateNewValueWidthStartingPoint(profileEntityObject.getX4al(), _starting_x, _original_scale,
                _new_scale);
        profiles.y4al = calculateNewValueWidthStartingPoint(profileEntityObject.getY4al(), _starting_y, _original_scale,
                _new_scale);
        profiles.centerXs = calculateNewValueWidthStartingPoint(profileEntityObject.getCenterXs(), _starting_x, _original_scale,
                _new_scale);
        profiles.centerYs = calculateNewValueWidthStartingPoint(profileEntityObject.getCenterYs(), _starting_y, _original_scale,
                _new_scale);
        profiles.centerXe = calculateNewValueWidthStartingPoint(profileEntityObject.getCenterXe(), _starting_x, _original_scale,
                _new_scale);
        profiles.centerYe = calculateNewValueWidthStartingPoint(profileEntityObject.getCenterYe(), _starting_y, _original_scale,
                _new_scale);

        profiles.thickness = profileEntityObject.getThickness().divide(_original_scale, 20, BigDecimal.ROUND_UP)
                .multiply(_new_scale).doubleValue();

        profiles.orientation = profileEntityObject.getOrientation();
        profiles.color = profileEntityObject.getColor();
        profiles.colorIn = profileEntityObject.getColorIn();
        profiles.colorOut = profileEntityObject.getColorOut();
        profiles.rgb_R = profileEntityObject.getRgb_R();
        profiles.rgb_G = profileEntityObject.getRgb_G();
        profiles.rgb_B = profileEntityObject.getRgb_B();
        profiles.rgb_Rin = profileEntityObject.getRgb_Rin();
        profiles.rgb_Gin = profileEntityObject.getRgb_Gin();
        profiles.rgb_Bin = profileEntityObject.getRgb_Bin();
        profiles.rgb_Rout = profileEntityObject.getRgb_Rout();
        profiles.rgb_Gout = profileEntityObject.getRgb_Rout();
        profiles.rgb_Bout = profileEntityObject.getRgb_Bout();
        profiles.rgb_Rt = profileEntityObject.getRgb_Rt();
        profiles.rgb_Gt = profileEntityObject.getRgb_Gt();
        profiles.rgb_Bt = profileEntityObject.getRgb_Bt();
        profiles.transp = profileEntityObject.getTransp();
        profiles.CouplerShapeID = profileEntityObject.getCouplerShapeId();
        profiles.couplerTypeID = profileEntityObject.getCouplerTypeId();
        profiles.posCondition = profileEntityObject.getPosCondition();
        profiles.mType = profileEntityObject.getmType();
        profiles.startIn = profileEntityObject.isStartIn();
        profiles.endIn = profileEntityObject.isEndIn();
        profiles.partLeft = profileEntityObject.isPartLeft();
        profiles.partRight = profileEntityObject.isPartRight();
        profiles.cOrM = profileEntityObject.getcOrM();
        profiles.openingTypeLB = profileEntityObject.getOpeningTypeLB();
        profiles.openingIDLB = profileEntityObject.getOpeningIDLB();
        profiles.openingTypeRT = profileEntityObject.getOpeningTypeRT();
        profiles.openingIDRT = profileEntityObject.getOpeningIDRT();
        profiles.fixedAngle = profileEntityObject.isFixedAngle();
        profiles.angle = profileEntityObject.getAngle().doubleValue();
        profiles.minAngle = profileEntityObject.getMinAngle().doubleValue();
        profiles.maxAngle = profileEntityObject.getMaxAngle().doubleValue();
        profiles.divideFacet = profileEntityObject.isDivideFacet();
        profiles.centralAnglec = profileEntityObject.getCentralAnglec().doubleValue();
        profiles.centralAnglec1 = profileEntityObject.getCentralAnglec1().doubleValue();
        profiles.centralAnglea1 = profileEntityObject.getCentralAnglea1().doubleValue();
        profiles.centralAnglea = profileEntityObject.getCentralAnglea().doubleValue();
        profiles.radius1c = profileEntityObject.getRadius1c().doubleValue();
        profiles.radius1c1 = profileEntityObject.getRadius1c1().doubleValue();
        profiles.radius1a1 = profileEntityObject.getRadius1a1().doubleValue();
        profiles.radius1a = profileEntityObject.getRadius1a().doubleValue();
        profiles.arcH = profileEntityObject.getArcH().doubleValue();
        profiles.startAnglec = profileEntityObject.getStartAnglec().doubleValue();
        profiles.endAnglec = profileEntityObject.getEndAnglec().doubleValue();
        profiles.startAnglec1 = profileEntityObject.getStartAnglec1().doubleValue();
        profiles.endAnglec1 = profileEntityObject.getEndAnglec1().doubleValue();
        profiles.startAnglea1 = profileEntityObject.getStartAnglea1().doubleValue();
        profiles.endAnglea1 = profileEntityObject.getEndAnglea1().doubleValue();
        profiles.startAnglea = profileEntityObject.getStartAnglea().doubleValue();
        profiles.endAnglea = profileEntityObject.getEndAnglea().doubleValue();
        profiles.angleTLa = profileEntityObject.getAngleTLa().doubleValue();
        profiles.angleBLa = profileEntityObject.getAngleBLa().doubleValue();
        profiles.angleTRc = profileEntityObject.getAngleTRc().doubleValue();
        profiles.angleBRc = profileEntityObject.getAngleBRc().doubleValue();
        profiles.offsetTL = profileEntityObject.getOffsetTL().doubleValue();
        profiles.offsetRB = profileEntityObject.getOffsetRB().doubleValue();
        profiles.deltaTL = profileEntityObject.getDeltaTL().doubleValue();
        profiles.deltaRB = profileEntityObject.getDeltaRB().doubleValue();
        profiles.curveCenterTL = profileEntityObject.getCurveCenterTL().doubleValue();
        profiles.curveCenterRB = profileEntityObject.getCurveCenterRB().doubleValue();
        profiles.glazedOut = profileEntityObject.isGlazedOut();
        profiles.remove = profileEntityObject.isRemoved();
        profiles.isValid = profileEntityObject.isValid();
        profiles.whichPos = profileEntityObject.getWhichPos();
        profiles.levelW = profileEntityObject.getLevelW().divide(_original_scale, 20, BigDecimal.ROUND_UP).
                multiply(_new_scale).doubleValue();
        profiles.levelH = profileEntityObject.getLevelH().divide(_original_scale, 20, BigDecimal.ROUND_UP).
                multiply(_new_scale).doubleValue();
        profiles.leftInf = profileEntityObject.isLeftInf();
        profiles.rightInf = profileEntityObject.isRightInf();
        profiles.lengthM = profileEntityObject.getLengthM();
        profiles.lengthI = profileEntityObject.getLengthI();
        profiles.lengthMN = profileEntityObject.getLengthMN();
        profiles.lengthIN = profileEntityObject.getLengthIN();
        profiles.phantom = profileEntityObject.isPhantom();
        profiles.typeID = profileEntityObject.getTypeId();

        if (!profiles.myFrame2.isSupplier) {
            profiles.supplierId = profileEntityObject.getSupplierId();
            profiles.remote = profileEntityObject.isRemote();
        }

		/* Setting parts notching LT */
        if (profileEntityObject.getPartsNotching() != null && !profileEntityObject.getPartsNotching().isEmpty()) {

            profiles.notches = new ArrayList();
            profiles.myNothcesLT = new ArrayList();
            profiles.myNothcesRB = new ArrayList();

            for (PartsNotchingEntityObject partNochingEntity : profileEntityObject.getPartsNotching()) {
                PartsNotching partNotching = new PartsNotching(partNochingEntity.getLevelId(), partNochingEntity.isTop1p(),
                        partNochingEntity.isTop2p(), partNochingEntity.isTop3p(), partNochingEntity.isLeftp(), partNochingEntity.isRightp(),
                        partNochingEntity.isBot1p(), partNochingEntity.isBot2p(), partNochingEntity.isBot3p(), partNochingEntity.getOrientation(),
                        partNochingEntity.getRowcol(), partNochingEntity.getPos(), partNochingEntity.getNothchType(),
                        partNochingEntity.getX1(), partNochingEntity.getY1(), partNochingEntity.getX2(), partNochingEntity.getY2(),
                        partNochingEntity.getX3(), partNochingEntity.getY3(), partNochingEntity.getXcenter(), partNochingEntity.getYcenter(),
                        partNochingEntity.getX5(), partNochingEntity.getY5(), partNochingEntity.getX6(), partNochingEntity.getY6(),
                        partNochingEntity.getX7(), partNochingEntity.getY7());

                if (partNochingEntity.isNotches()) {
                    profiles.notches.add(partNotching);
                }

                if (partNochingEntity.isNotchesLT()) {
                    profiles.myNothcesLT.add(partNotching);
                }

                if (partNochingEntity.isNotchesRB()) {
                    profiles.myNothcesRB.add(partNotching);
                }
            }
        }

		/* Setting Shape options objects */
        if (profileEntityObject.getOptions() != null && !profileEntityObject.getOptions().isEmpty()) {
            for (ShapeOptionEntityObject shapeOptionEntity : profileEntityObject.getOptions()) {
                profiles.options.add(ShapeOptionDTO.getShapeOptionModel(profiles.myFrame2, shapeOptionEntity));

                //Adding design option to design option collection
                profiles.myFrame2.designOptionsAll.add(ShapeOptionDTO.getDesignOptionModel(profiles.myFrame2, shapeOptionEntity));
            }
        }

        /* Settings Bill of Materials */
        if (profileEntityObject.getBoms() != null && !profileEntityObject.getBoms().isEmpty()) {
            for (BillOfMaterialEntityObject billOfMaterialEntity : profileEntityObject.getBoms()) {
                profiles.bom.add(BillOfMaterialDTO.getBuildOfMaterialModel(billOfMaterialEntity));
            }
        }

        /* Setting Shape Notes */
        if (profileEntityObject.getNotes() != null && !profileEntityObject.getNotes().isEmpty()) {
            for (ShapeNotesEntityObject shapeNotes : profileEntityObject.getNotes()) {
                profiles.notes.add(ShapeNotesDTO.getShapeNotesModel(shapeNotes));
            }
        }
    }

    /**
     * This method clone Profiles to ProfileParts model object
     *
     * @param newTop,   ProfileParts model object
     * @param original, Profiles model object
     * @return ProfileParts
     */
    public static ProfileParts profilesClone(ProfileParts newTop, Profiles original) {

        newTop.bkgrdHeight = original.bkgrdHeight;
        newTop.bkgrdHeightA = original.bkgrdHeightA;
        newTop.bkgrdHeightBA = original.bkgrdHeightBA;
        newTop.bkgrdHeightBC = original.bkgrdHeightBC;
        newTop.bkgrdStartX = original.bkgrdStartX;
        newTop.bkgrdStartXA = original.bkgrdStartXA;
        newTop.bkgrdStartXBA = original.bkgrdStartXBA;
        newTop.myParent = original.myParent;
        newTop.bkgrdStartXBC = original.bkgrdStartXBC;
        newTop.bkgrdStartY = original.bkgrdStartY;
        newTop.x1 = original.x1;
        newTop.x2 = original.x2;
        newTop.y1 = original.y1;
        newTop.y2 = original.y2;
        newTop.bkgrdStartYA = original.bkgrdStartYA;
        newTop.bkgrdStartYBA = original.bkgrdStartYBA;
        newTop.bkgrdStartYBC = original.bkgrdStartYBC;
        newTop.bkgrdWidth = original.bkgrdWidth;
        newTop.bkgrdWidthA = original.bkgrdWidthA;
        newTop.bkgrdWidthBA = original.bkgrdWidthBA;
        newTop.bkgrdWidthBC = original.bkgrdWidthBC;
        newTop.centralAngle = original.centralAngle;
        newTop.centralAngleA = original.centralAngleA;
        newTop.centralAngleBA = original.centralAngleBA;
        newTop.centralAngleBC = original.centralAngleBC;
        newTop.dimB1A = original.dimB1A;
        newTop.dimB1B = original.dimB1B;
        newTop.endAngle = original.endAngle;
        newTop.endAngleA = original.endAngleA;
        newTop.endAngleBA = original.endAngleBA;
        newTop.endAngleBC = original.endAngleBC;
        newTop.endX = original.endX;
        newTop.endXC = original.endXC;
        newTop.endXA = original.endXA;
        newTop.endXBA = original.endXBA;
        newTop.endXBC = original.endXBC;
        newTop.endY = original.endY;
        newTop.endYC = original.endYC;
        newTop.endYA = original.endYA;
        newTop.endYBA = original.endYBA;
        newTop.endYBC = original.endYBC;
        newTop.focal1X = original.focal1X;
        newTop.focal1XA = original.focal1XA;
        newTop.focal1XBA = original.focal1XBA;
        newTop.focal1XBC = original.focal1XBC;
        newTop.focal1Y = original.focal1Y;
        newTop.focal1YA = original.focal1YA;
        newTop.focal1YBA = original.focal1YBA;
        newTop.focal1YBC = original.focal1YBC;
        newTop.focal2X = original.focal2X;
        newTop.focal2XA = original.focal2XA;
        newTop.focal2XBA = original.focal2XBA;
        newTop.focal2XBC = original.focal2XBC;
        newTop.focal2Y = original.focal2Y;
        newTop.focal2YA = original.focal2YA;
        newTop.focal2YBA = original.focal2YBA;
        newTop.focal2YBC = original.focal2YBC;
        newTop.glazingDepth = original.glazingDepth;
        newTop.inLaminateArea = original.inLaminateArea;
        newTop.inPaintArea = original.inPaintArea;
        newTop.length = original.length;
        newTop.lengthA = original.lengthA;
        newTop.lengthBA = original.lengthBA;
        newTop.lengthBC = original.lengthBC;
        newTop.lengthM = original.lengthM;
        newTop.lengthI = original.lengthI;
        newTop.lengthMN = original.lengthMN;
        newTop.lengthIN = original.lengthIN;
        newTop.ltAngle = original.ltAngle;
        newTop.ltAngleA = original.ltAngleA;
        newTop.ltAngleBA = original.ltAngleBA;
        newTop.ltAngleBC = original.ltAngleBC;
        newTop.mitreLengthLT = original.mitreLengthLT;
        newTop.mitreLengthRB = original.mitreLengthRB;
        newTop.myWidth = original.myWidth;
        newTop.myWidthA = original.myWidthA;
        newTop.myWidthBA = original.myWidthBA;
        newTop.outLaminateArea = original.outLaminateArea;
        newTop.outPaintArea = original.outPaintArea;
        newTop.partDimA = original.partDimA;
        newTop.partDimAi = original.partDimAi;
        newTop.partDimB = original.partDimB;
        newTop.partDimBi = original.partDimBi;
        newTop.partDimC = original.partDimC;
        newTop.partDimCi = original.partDimCi;
        newTop.partDimM = original.partDimM;
        newTop.partDimMi = original.partDimMi;
        newTop.partForm = original.partForm;
        newTop.partID = original.partID;
        newTop.partShape = original.partShape;
        newTop.position = original.position;
        newTop.seq = original.seq;
        newTop.radianCentralAngle = original.radianCentralAngle;
        newTop.radius1 = original.radius1;
        newTop.radius1A = original.radius1A;
        newTop.radius1BA = original.radius1BA;
        newTop.radius1BC = original.radius1BC;
        newTop.radius2 = original.radius2;
        newTop.radius2A = original.radius2A;
        newTop.radius2BA = original.radius2BA;
        newTop.radius2BC = original.radius2BC;
        newTop.rbAngle = original.rbAngle;
        newTop.rbAngleA = original.rbAngleA;
        newTop.rbAngleBA = original.rbAngleBA;
        newTop.rbAngleBC = original.rbAngleBC;

        newTop.rID = original.rID;
        newTop.rlAngle = original.rlAngle;
        newTop.rlAngleA = original.rlAngleA;
        newTop.rlAngleBA = original.rlAngleBA;
        newTop.rlSlope = original.rlSlope;
        newTop.rlSlopeA = original.rlSlopeA;
        newTop.rlSlopeBA = original.rlSlopeBA;
        newTop.rrAngle = original.rrAngle;
        newTop.rrAngleA = original.rrAngleA;
        newTop.rrAngleBA = original.rrAngleBA;
        newTop.rrSlope = original.rrSlope;
        newTop.rrSlopeA = original.rrSlopeA;
        newTop.rrSlopeBA = original.rrSlopeBA;
        newTop.slope = original.slope;
        newTop.slopeA = original.slopeA;
        newTop.slopeBA = original.slopeBA;
        newTop.slopeBC = original.slopeBC;
        newTop.startAngle = original.startAngle;
        newTop.startAngleA = original.startAngleA;
        newTop.startAngleBA = original.startAngleBA;
        newTop.startAngleBC = original.startAngleBC;
        newTop.startingX = original.startingX;
        newTop.startingXA = original.startingXA;
        newTop.startingXBA = original.startingXBA;
        newTop.startingXBC = original.startingXBC;
        newTop.startingY = original.startingY;
        newTop.startingYA = original.startingYA;
        newTop.startingYBA = original.startingYBA;
        newTop.startingYBC = original.startingYBC;
        newTop.startX = original.startX;
        newTop.startXC = original.startXC;
        newTop.startXA = original.startXA;
        newTop.startXBA = original.startXBA;
        newTop.startXBC = original.startXBC;
        newTop.startY = original.startY;
        newTop.startYC = original.startYC;
        newTop.startYA = original.startYA;
        newTop.startYBA = original.startYBA;
        newTop.startYBC = original.startYBC;
        newTop.stockCode = original.stockCode;
        newTop.color = original.color;
        newTop.totalDepth = original.totalDepth;
        newTop.totalSurfaceArea = original.totalSurfaceArea;
        newTop.endTypeLT = original.endTypeLT;
        newTop.endTypeRB = original.endTypeRB;
        newTop.parentW = original.parentW;
        newTop.rgb_R = original.rgb_R;
        newTop.rgb_G = original.rgb_G;
        newTop.rgb_B = original.rgb_B;
        newTop.rgb_Rt = original.rgb_Rt;
        newTop.rgb_Gt = original.rgb_Gt;
        newTop.rgb_Bt = original.rgb_Bt;
        newTop.profileSelected = original.profileSelected;
        newTop.mullionLeft = original.mullionLeft;
        newTop.mullionRight = original.mullionRight;
        newTop.posInUse = original.posInUse;
        newTop.stopAeX = original.stopAeX;
        newTop.stopAeY = original.stopAeY;
        newTop.stopAsX = original.stopAsX;
        newTop.stopAsY = original.stopAsY;

        return newTop;
    }

    /**
     * This method creates clone of ProfileAbstractObject implementation method
     *
     * @param profileObject, ProfileAbstractObject
     * @param clazz,         Class instance object to create
     * @return ProfileAbstractObject
     * @throws DTOTransformationError, Error
     */
    public static ProfileAbstractObject cloneProfileAbstractObject(ProfileAbstractObject profileObject, Class clazz)
            throws DTOTransformationError {

        try {

            //Clone profile abstract object
            ProfileAbstractObject profile = ProfilesBeanUtils.cloneBean(profileObject, clazz);

            //Clone parts notching
            if (profileObject.getPartsNotching() != null && !profileObject.getPartsNotching().isEmpty()) {
                Set<PartsNotchingEntityObject> partsNotches = new HashSet<PartsNotchingEntityObject>();
                for (PartsNotchingEntityObject partsNotchesEntity : profileObject.getPartsNotching()) {
                    PartsNotchingEntityObject partNotchingEntity = new PartsNotchingEntityObject();
                    BeanUtils.copyProperties(partNotchingEntity, partsNotchesEntity);
                    partNotchingEntity.setId(null);
                    partsNotches.add(partNotchingEntity);
                }

                profile.setPartsNotching(partsNotches);
            }

            //Clone shape options
            if (profileObject.getOptions() != null && !profileObject.getOptions().isEmpty()) {
                Set<ShapeOptionEntityObject> options = new HashSet<ShapeOptionEntityObject>();
                for (ShapeOptionEntityObject shapeOption : profileObject.getOptions()) {
                    options.add(ShapeOptionBeanUtils.cloneBean(shapeOption));
                }
                profile.setOptions(options);
            }

            return profile;

        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (InvocationTargetException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        }

    }

    //*****************************************************************************************************************
    // UTILITY METHODS
    //*****************************************************************************************************************

    /**
     * This method evaluate infinite value
     *
     * @param value, double
     * @return BigDecimal
     */
    private static BigDecimal evaluateInfinite(double value) {

        if (Double.isNaN(value)) {
            return ZERO_VALUE;
        }

        if (Double.isInfinite(value) && value < 0) {
            return INFINITY_NEGATIVE;
        }

        if (Double.isInfinite(value) && value > 0) {
            return INFINITY_POSITIVE;
        }

        return new BigDecimal(value + "");
    }

    /**
     * This method calculate a new value for change in scale ratio for pixels.
     *
     * @param value,           BigDecimal value to recalculate
     * @param _original_scale, Original scale for this value
     * @param _new_scale,      New scale ratio for value calculation
     * @return double
     */
    private static double calculateNewValueWithScale(BigDecimal value, BigDecimal _original_scale, BigDecimal _new_scale) {

        value = value.compareTo(new BigDecimal("0")) >= 1 ? value.divide(_original_scale, 20, BigDecimal.ROUND_UP).
                        multiply(_new_scale) : value;

        return value.doubleValue();
    }

    /**
     * This method calculate a new value with and starting point for change in scale ratio for pixels.
     *
     * @param value,           BigDecimal value to recalculate
     * @param _starting_value, Starting value for calculation
     * @param _original_scale, Original scale for this value
     * @param _new_scale,      New scale ratio for value calculation
     * @return double
     */
    private static double calculateNewValueWidthStartingPoint(BigDecimal value, BigDecimal _starting_value,
                                                              BigDecimal _original_scale, BigDecimal _new_scale) {

        value = value.compareTo(new BigDecimal("0")) >= 1 ? value.subtract(_starting_value).
                divide(_original_scale, 20,
                        BigDecimal.ROUND_UP).multiply(_new_scale).add(_starting_value) : value;

        return value.doubleValue();
    }
}
