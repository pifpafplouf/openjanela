package dto;

import Model.*;
import Model.ProfileParts.*;
import Model.ProfileParts.ProfilesType;
import openjanela.model.entities.design.*;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 * <p/>
 * This class perform a transformation ShapeObject to ShapeAbstractObject model
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-11-12
 *          Time: 11:58 PM
 */
public class ShapeObjectDTO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(ShapeObjectDTO.class);

    /**
     * Create ProfileBOMS
     *
     * @param shapeObject, ShapeObject
     * @return Set<ProfileEntityBOM>
     * @throws dto.DTOTransformationError, Error
     */
    private static Set<ProfileEntityBOM> getProfilePartsObject(ShapeObject shapeObject) throws DTOTransformationError {

        //************************************************************************
        //Creating parts objects
        //************************************************************************
        Set<ProfileEntityBOM> profileBOMs = new HashSet<ProfileEntityBOM>();

        if (shapeObject.partObjects != null && !shapeObject.partObjects.isEmpty()) {
            Object[] rmp = shapeObject.partObjects.toArray();
            for (Object v : rmp) {
                if (!((ProfileParts) v).remove) {
                    profileBOMs.add((ProfileEntityBOM) ProfileDTO.getProfileAbstractObject((ProfileParts) v,
                            ProfileEntityBOM.class, ProfilesType._undefined.getValue(), null));
                }
            }
        }

        return profileBOMs;
    }

    /**
     * This method return a collections of parts objects
     *
     * @param profileBOMs, Set
     * @throws dto.DTOTransformationError, Error
     */
    public static void setProfilePartsObject(Set<ProfileEntityBOM> profileBOMs, ShapeObject shapeObject)
            throws DTOTransformationError {

        //Parts object array list
        shapeObject.partObjects.clear();

        for (ProfileEntityBOM profileBOM : profileBOMs) {

            Profiles profiles = new Profiles(shapeObject, profileBOM);
            ConstructionMapDTO.copyConstructionMap(profiles, shapeObject);

            shapeObject.partObjects.add(profiles);
        }
    }

    /**
     * This method return a profiles collection object transforming the following properties in the ShapeObject:
     * <p>top1Part</p>
     * <p>top2Part</p>
     *
     * @param shapeObject, ShapeObject
     * @return Set<ProfileCollectionObject>
     * @throws dto.DTOTransformationError, Error
     */
    private static Set<ProfileCollectionObject> getProfileCollection(ShapeObject shapeObject) throws DTOTransformationError {

        //Profile collection set objects
        Set<ProfileCollectionObject> collectionObject = new HashSet<ProfileCollectionObject>();

        //**************************************************
        //Saving profiles parts collections
        //**************************************************
        collectionObject.add((ProfileCollectionObject) ProfileDTO.getProfileAbstractObject(shapeObject.top1,
                ProfileCollectionObject.class, ProfilesType._top1.getValue(), null));
        collectionObject.add((ProfileCollectionObject) ProfileDTO.getProfileAbstractObject(shapeObject.top2,
                ProfileCollectionObject.class, ProfilesType._top2.getValue(), null));
        collectionObject.add((ProfileCollectionObject) ProfileDTO.getProfileAbstractObject(shapeObject.top3,
                ProfileCollectionObject.class, ProfilesType._top3.getValue(), null));
        collectionObject.add((ProfileCollectionObject) ProfileDTO.getProfileAbstractObject(shapeObject.right,
                ProfileCollectionObject.class, ProfilesType._right.getValue(), null));
        collectionObject.add((ProfileCollectionObject) ProfileDTO.getProfileAbstractObject(shapeObject.left,
                ProfileCollectionObject.class, ProfilesType._left.getValue(), null));
        collectionObject.add((ProfileCollectionObject) ProfileDTO.getProfileAbstractObject(shapeObject.bot1,
                ProfileCollectionObject.class, ProfilesType._botom1.getValue(), null));
        collectionObject.add((ProfileCollectionObject) ProfileDTO.getProfileAbstractObject(shapeObject.bot2,
                ProfileCollectionObject.class, ProfilesType._botom2.getValue(), null));
        collectionObject.add((ProfileCollectionObject) ProfileDTO.getProfileAbstractObject(shapeObject.bot3,
                ProfileCollectionObject.class, ProfilesType._botom3.getValue(), null));

        collectionObject.add((ProfileCollectionObject) ProfileDTO.getProfileAbstractObject(shapeObject.top1Part,
                ProfileCollectionObject.class, ProfilesType._top1_part.getValue(), null));
        collectionObject.add((ProfileCollectionObject) ProfileDTO.getProfileAbstractObject(shapeObject.top2Part,
                ProfileCollectionObject.class, ProfilesType._top2_part.getValue(), null));
        collectionObject.add((ProfileCollectionObject) ProfileDTO.getProfileAbstractObject(shapeObject.top3Part,
                ProfileCollectionObject.class, ProfilesType._top3_part.getValue(), null));
        collectionObject.add((ProfileCollectionObject) ProfileDTO.getProfileAbstractObject(shapeObject.rightPart,
                ProfileCollectionObject.class, ProfilesType._right_part.getValue(), null));
        collectionObject.add((ProfileCollectionObject) ProfileDTO.getProfileAbstractObject(shapeObject.leftPart,
                ProfileCollectionObject.class, ProfilesType._left_part.getValue(), null));
        collectionObject.add((ProfileCollectionObject) ProfileDTO.getProfileAbstractObject(shapeObject.bot1Part,
                ProfileCollectionObject.class, ProfilesType._botom1_part.getValue(), null));
        collectionObject.add((ProfileCollectionObject) ProfileDTO.getProfileAbstractObject(shapeObject.bot2Part,
                ProfileCollectionObject.class, ProfilesType._botom2_part.getValue(), null));
        collectionObject.add((ProfileCollectionObject) ProfileDTO.getProfileAbstractObject(shapeObject.bot3Part,
                ProfileCollectionObject.class, ProfilesType._botom3_part.getValue(), null));

        return collectionObject;
    }

    /**
     * This method set parts object to shapeObject model
     *
     * @param shapeObject,        ShapeObject
     * @param profilesCollection, Set<ProfileCollectionObject>
     * @throws dto.DTOTransformationError, Error
     */
    public static void setProfileCollection(ShapeObject shapeObject, Set<ProfileCollectionObject> profilesCollection)
            throws DTOTransformationError {

        for (ProfileCollectionObject profileCollection : profilesCollection) {

            Profiles profiles = new Profiles(shapeObject.myFrame2);
            ProfileDTO.createProfiles(profiles, profileCollection);
            ConstructionMapDTO.copyConstructionMap(profiles, shapeObject);

            if (profileCollection.get_part_object() == ProfilesType._top1.getValue()) {
                shapeObject.top1 = new Top1Object(shapeObject, false);
                ProfileDTO.profilesClone(shapeObject.top1, profiles);
            }

            if (profileCollection.get_part_object() == ProfilesType._top2.getValue()) {
                shapeObject.top2 = new Top2Object(shapeObject, false);
                ProfileDTO.profilesClone(shapeObject.top2, profiles);
            }

            if (profileCollection.get_part_object() == ProfilesType._top3.getValue()) {
                shapeObject.top3 = new Top3Object(shapeObject, false);
                ProfileDTO.profilesClone(shapeObject.top3, profiles);
            }

            if (profileCollection.get_part_object() == ProfilesType._left.getValue()) {
                shapeObject.left = new LeftObject(shapeObject, false);
                ProfileDTO.profilesClone(shapeObject.left, profiles);
            }

            if (profileCollection.get_part_object() == ProfilesType._right.getValue()) {
                shapeObject.right = new RightObject(shapeObject, false);
                ProfileDTO.profilesClone(shapeObject.right, profiles);
            }

            if (profileCollection.get_part_object() == ProfilesType._botom1.getValue()) {
                shapeObject.bot1 = new Bot1Object(shapeObject, false);
                ProfileDTO.profilesClone(shapeObject.bot1, profiles);
            }

            if (profileCollection.get_part_object() == ProfilesType._botom2.getValue()) {
                shapeObject.bot2 = new Bot2Object(shapeObject, false);
                ProfileDTO.profilesClone(shapeObject.bot2, profiles);
            }

            if (profileCollection.get_part_object() == ProfilesType._botom3.getValue()) {
                shapeObject.bot3 = new Bot3Object(shapeObject, false);
                ProfileDTO.profilesClone(shapeObject.bot3, profiles);
            }

            if (profileCollection.get_part_object() == ProfilesType._top1_part.getValue()) {
                shapeObject.top1Part = profiles;
                shapeObject.top1Part.myParent = shapeObject;
            }

            if (profileCollection.get_part_object() == ProfilesType._top2_part.getValue()) {
                shapeObject.top2Part = profiles;
                shapeObject.top2Part.myParent = shapeObject;
            }

            if (profileCollection.get_part_object() == ProfilesType._top3_part.getValue()) {
                shapeObject.top3Part = profiles;
                shapeObject.top3Part.myParent = shapeObject;
            }

            if (profileCollection.get_part_object() == ProfilesType._left_part.getValue()) {
                shapeObject.leftPart = profiles;
                shapeObject.leftPart.myParent = shapeObject;
            }

            if (profileCollection.get_part_object() == ProfilesType._right_part.getValue()) {
                shapeObject.rightPart = profiles;
                shapeObject.rightPart.myParent = shapeObject;
            }

            if (profileCollection.get_part_object() == ProfilesType._botom1_part.getValue()) {
                shapeObject.bot1Part = profiles;
                shapeObject.bot1Part.myParent = shapeObject;
            }

            if (profileCollection.get_part_object() == ProfilesType._botom2_part.getValue()) {
                shapeObject.bot2Part = profiles;
                shapeObject.bot2Part.myParent = shapeObject;
            }

            if (profileCollection.get_part_object() == ProfilesType._botom3_part.getValue()) {
                shapeObject.bot3Part = profiles;
                shapeObject.bot3Part.myParent = shapeObject;
            }
        }
    }

    /**
     * This method return a profile MyMullion collection object transforming the following properties in the ShapeObject:
     * <p>myMullionTop</p>
     * <p>myMullionBottom</p>
     * <p>myMullionLeft</p>
     * <p>myMullionRight</p>
     *
     * @param shapeObject, ShapeObject
     * @return Set<ProfileMyMullionObject>
     * @throws DTOTransformationError, Error
     */
    private static Set<ProfileMyMullionObject> getMyMullionCollection(ShapeObject shapeObject) throws DTOTransformationError {

        //*************************************************
        //Saving my mullions collection
        //*************************************************
        Set<ProfileMyMullionObject> myMullions = new HashSet<ProfileMyMullionObject>();

        if (shapeObject.myMullionTop != null) {
            ProfileMyMullionObject myMullion = (ProfileMyMullionObject) ProfileDTO.getProfileAbstractObject(
                    shapeObject.myMullionTop, ProfileMyMullionObject.class, ProfilesType._top1_part.getValue(), null);
            myMullion.set_part_object(ProfilesType._top1_part.getValue());
            myMullions.add(myMullion);
        }

        if (shapeObject.myMullionBot != null) {
            ProfileMyMullionObject myMullion = (ProfileMyMullionObject) ProfileDTO.getProfileAbstractObject(
                    shapeObject.myMullionBot, ProfileMyMullionObject.class, ProfilesType._botom1_part.getValue(), null);
            myMullion.set_part_object(ProfilesType._botom1_part.getValue());
            myMullions.add(myMullion);
        }

        if (shapeObject.myMullionLeft != null) {
            ProfileMyMullionObject myMullion = (ProfileMyMullionObject) ProfileDTO.getProfileAbstractObject(
                    shapeObject.myMullionLeft, ProfileMyMullionObject.class, ProfilesType._left_part.getValue(), null);
            myMullion.set_part_object(ProfilesType._left_part.getValue());
            myMullions.add(myMullion);
        }

        if (shapeObject.myMullionRight != null) {
            ProfileMyMullionObject myMullion = (ProfileMyMullionObject) ProfileDTO.getProfileAbstractObject(
                    shapeObject.myMullionRight, ProfileMyMullionObject.class, ProfilesType._right_part.getValue(), null);
            myMullion.set_part_object(ProfilesType._right_part.getValue());
            myMullions.add(myMullion);
        }

        return myMullions;
    }

    /**
     * This method set my mullions object to ShapeObject model
     *
     * @param shapeObject,                ShapeObject
     * @param profileMyMullionCollection, Set<ProfileMyMullionObject>
     * @throws DTOTransformationError, Error
     */
    public static void setMyMullionObjects(ShapeObject shapeObject, Set<ProfileMyMullionObject> profileMyMullionCollection)
            throws DTOTransformationError {

        //*************************************************
        // Open my mullions collection
        //*************************************************
        for (ProfileMyMullionObject profileMyMullion : profileMyMullionCollection) {
            Profiles profiles = new Profiles(shapeObject.myFrame2);
            ProfileDTO.createProfiles(profiles, profileMyMullion);
            ConstructionMapDTO.copyConstructionMap(profiles, shapeObject);

            if (profileMyMullion.get_part_object() == ProfilesType._top1_part.getValue()) {
                shapeObject.myMullionTop = profiles;
            }

            if (profileMyMullion.get_part_object() == ProfilesType._botom1_part.getValue()) {
                shapeObject.myMullionBot = profiles;
            }

            if (profileMyMullion.get_part_object() == ProfilesType._left_part.getValue()) {
                shapeObject.myMullionLeft = profiles;
            }

            if (profileMyMullion.get_part_object() == ProfilesType._right_part.getValue()) {
                shapeObject.myMullionRight = profiles;
            }
        }

    }

    /**
     * This method return ShapeAbstractObject
     *
     * @param shapeObject, ShapeObject
     * @param clazz,       Class
     * @return ShapeAbstractObject
     * @throws dto.DTOTransformationError, Error
     */
    public static ShapeAbstractObject getShapeAbstractObject(ShapeObject shapeObject, Class clazz) throws DTOTransformationError {

        if (shapeObject == null)
            throw new DTOTransformationError();

        //**************************************************************************
        //Creating and applying transformation
        //**************************************************************************
        ShapeAbstractObject shapeEntity;
        try {
            shapeEntity = (ShapeAbstractObject) clazz.newInstance();
        } catch (InstantiationException e) {
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            throw new DTOTransformationError(e.getMessage(), e);
        }

        //Creating object to save
        shapeEntity.setJobId(shapeObject.myFrame2.jobItem.jobid);
        shapeEntity.setItemId(shapeObject.myFrame2.jobItem.itemid);
        shapeEntity.setLevelId(shapeObject.a_levelID);
        shapeEntity.setSequenceId(shapeObject.a_sequenceID);
        shapeEntity.setAssemblyLevelId(shapeObject.a_assemblyLevel);
        shapeEntity.setStdWM(shapeObject.stdWM);
        shapeEntity.setStdWI(shapeObject.stdWI);
        shapeEntity.setStdHM(shapeObject.stdHM);
        shapeEntity.setStdHI(shapeObject.stdHI);

        shapeEntity.setControlOpeningClassType(shapeObject.controlOpeningClassType);
        shapeEntity.setControlOpeningClass(shapeObject.controlOpeningClass);
        shapeEntity.setControlUserDefinedOpeningID(shapeObject.controlUserDefinedOpeningID);

        //Construction map
        ConstructionMap constructionMap = new ConstructionMap();
        constructionMap.set_a_assemblyLevel(shapeObject.a_assemblyLevel);
        constructionMap.set_a_assemblySequence(shapeObject.a_sequenceID);
        constructionMap.set_a_1Level(shapeObject.a_1Level);
        constructionMap.set_a_2Level(shapeObject.a_2Level);
        constructionMap.set_a_3Level(shapeObject.a_3Level);
        constructionMap.set_a_4Level(shapeObject.a_4Level);
        constructionMap.set_a_5Level(shapeObject.a_5Level);
        constructionMap.set_a_6Level(shapeObject.a_6Level);
        constructionMap.set_a_7Level(shapeObject.a_7Level);
        constructionMap.set_a_8Level(shapeObject.a_8Level);
        constructionMap.set_a_9Level(shapeObject.a_9Level);
        constructionMap.set_a_10Level(shapeObject.a_10Level);
        constructionMap.set_a_11Level(shapeObject.a_11Level);
        constructionMap.set_a_12Level(shapeObject.a_12Level);
        constructionMap.set_a_13Level(shapeObject.a_13Level);
        constructionMap.set_a_14Level(shapeObject.a_14Level);
        constructionMap.set_a_15Level(shapeObject.a_15Level);
        constructionMap.set_a_16Level(shapeObject.a_16Level);
        constructionMap.set_a_17Level(shapeObject.a_17Level);
        constructionMap.set_a_18Level(shapeObject.a_18Level);
        constructionMap.set_a_19Level(shapeObject.a_19Level);
        constructionMap.set_a_20Level(shapeObject.a_20Level);
        constructionMap.set_a_21Level(shapeObject.a_21Level);
        constructionMap.set_a_22Level(shapeObject.a_22Level);
        constructionMap.set_a_1Sequence(shapeObject.a_1Sequence);
        constructionMap.set_a_2Sequence(shapeObject.a_2Sequence);
        constructionMap.set_a_3Sequence(shapeObject.a_3Sequence);
        constructionMap.set_a_4Sequence(shapeObject.a_4Sequence);
        constructionMap.set_a_5Sequence(shapeObject.a_5Sequence);
        constructionMap.set_a_6Sequence(shapeObject.a_6Sequence);
        constructionMap.set_a_7Sequence(shapeObject.a_7Sequence);
        constructionMap.set_a_8Sequence(shapeObject.a_8Sequence);
        constructionMap.set_a_9Sequence(shapeObject.a_9Sequence);
        constructionMap.set_a_10Sequence(shapeObject.a_10Sequence);
        constructionMap.set_a_11Sequence(shapeObject.a_11Sequence);
        constructionMap.set_a_12Sequence(shapeObject.a_12Sequence);
        constructionMap.set_a_13Sequence(shapeObject.a_13Sequence);
        constructionMap.set_a_14Sequence(shapeObject.a_14Sequence);
        constructionMap.set_a_15Sequence(shapeObject.a_15Sequence);
        constructionMap.set_a_16Sequence(shapeObject.a_16Sequence);
        constructionMap.set_a_17Sequence(shapeObject.a_17Sequence);
        constructionMap.set_a_18Sequence(shapeObject.a_18Sequence);
        constructionMap.set_a_19Sequence(shapeObject.a_19Sequence);
        constructionMap.set_a_20Sequence(shapeObject.a_20Sequence);
        constructionMap.set_a_21Sequence(shapeObject.a_21Sequence);
        constructionMap.set_a_22Sequence(shapeObject.a_22Sequence);

        //Setting construction map
        shapeEntity.setConstructionMap(constructionMap);

        shapeEntity.setNoPartsTop1(shapeObject.noPartsTop1);
        shapeEntity.setNoPartsTop2(shapeObject.noPartsTop2);
        shapeEntity.setNoPartsTop3(shapeObject.noPartsTop3);
        shapeEntity.setNoPartsBot1(shapeObject.noPartsBot1);
        shapeEntity.setNoPartsBot2(shapeObject.noPartsBot2);
        shapeEntity.setNoPartsBot3(shapeObject.noPartsBot3);
        shapeEntity.setNoPartsLeft(shapeObject.noPartsLeft);
        shapeEntity.setNoPartsRight(shapeObject.noPartsRight);
        shapeEntity.setNewDesign(shapeObject.newDesign);
        shapeEntity.setFrameStartCol(shapeObject.frameStartCol);
        shapeEntity.setFrameStartRow(shapeObject.frameStartRow);
        shapeEntity.setFrameEndCol(shapeObject.frameEndCol);
        shapeEntity.setFrameEndRow(shapeObject.frameEndRow);
        shapeEntity.setWidthM(shapeObject.widthM);
        shapeEntity.setWidthI(shapeObject.widthI);
        shapeEntity.setWidthIO(shapeObject.widthIO);
        shapeEntity.setWidthMO(shapeObject.widthMO);
        shapeEntity.setWidthPix(new BigDecimal(shapeObject.widthPix + ""));
        shapeEntity.setHeightM(shapeObject.heightM);
        shapeEntity.setHeightI(shapeObject.heightI);
        shapeEntity.setHeightIO(shapeObject.heightIO);
        shapeEntity.setHeightMO(shapeObject.heightMO);
        shapeEntity.setHeightPix(new BigDecimal(shapeObject.heightPix + ""));
        shapeEntity.setScaleImp(new BigDecimal(shapeObject.myFrame2.imperialscale + ""));
        shapeEntity.setScaleM(new BigDecimal(shapeObject.myFrame2.metricscale + ""));
        shapeEntity.setScalepix(new BigDecimal(shapeObject.myFrame2.jobItem.scale + ""));
        shapeEntity.setShapeID(shapeObject.shapeID);
        shapeEntity.setxCols(shapeObject.xCols);
        shapeEntity.setyRows(shapeObject.yRows);
        shapeEntity.setNoTracks(shapeObject.noTracks);
        shapeEntity.setOpenOut(shapeObject.openOut);
        shapeEntity.setGlazedOut(shapeObject.glazedOut);
        shapeEntity.setRadius1A(new BigDecimal(shapeObject.radius1A + ""));
        shapeEntity.setRadius2A(new BigDecimal(shapeObject.radius2A + ""));
        shapeEntity.setStartAngleA(new BigDecimal(shapeObject.startAngleA + ""));
        shapeEntity.setEndAngle(new BigDecimal(shapeObject.endAngleA + ""));
        shapeEntity.setCentralAngleA(new BigDecimal(shapeObject.centralAngleA + ""));
        shapeEntity.setHasSash(shapeObject.hasSash);
        shapeEntity.setUnGlazed(shapeObject.unGlazed);
        shapeEntity.setOpeningType(shapeObject.openingClass);
        shapeEntity.setOutSashTracks(shapeObject.outSashTracks);
        shapeEntity.setInSashTracks(shapeObject.inSashTracks);
        shapeEntity.setMidSashTracks(shapeObject.midSashTracks);
        shapeEntity.setOpenIn(shapeObject.openIn);
        shapeEntity.setLean(shapeObject.lean);
        shapeEntity.setLean2(shapeObject.lean2);
        shapeEntity.setLean3(shapeObject.lean3);
        shapeEntity.setLean4(shapeObject.lean4);
        shapeEntity.setNoSides(shapeObject.noSides);
        shapeEntity.setNoSidesTop(shapeObject.noSidesTop);
        shapeEntity.setNoSidesBot(shapeObject.noSidesBot);
        shapeEntity.setNoSidesLeft(shapeObject.noSidesLeft);
        shapeEntity.setNoSidesRight(shapeObject.noSidesRight);
        shapeEntity.setTopShape(shapeObject.topShape);
        shapeEntity.setRightShape(shapeObject.rightShape);
        shapeEntity.setBotShape(shapeObject.botShape);
        shapeEntity.setLeftShape(shapeObject.leftShape);
        shapeEntity.setRadius1(new BigDecimal(shapeObject.radius1 + ""));
        shapeEntity.setRadius2(new BigDecimal(shapeObject.radius2 + ""));
        shapeEntity.setStartAngle(new BigDecimal(shapeObject.startAngle + ""));
        shapeEntity.setEndAngle(new BigDecimal(shapeObject.endAngle + ""));
        shapeEntity.setCentralAngle(new BigDecimal(shapeObject.centralAngle + ""));
        shapeEntity.setStartCol(shapeObject.startCol);
        shapeEntity.setEndCol(shapeObject.endCol);
        shapeEntity.setStartRow(shapeObject.startRow);
        shapeEntity.setEndRow(shapeObject.endRow);
        shapeEntity.setTopIn(shapeObject.topIn);
        shapeEntity.setRightIn(shapeObject.rightIn);
        shapeEntity.setBotIn(shapeObject.botIn);
        shapeEntity.setLeftIn(shapeObject.leftIn);
        shapeEntity.setClearanceTop(new BigDecimal(shapeObject.clearanceTop + ""));
        shapeEntity.setClearanceBot(new BigDecimal(shapeObject.clearanceBot + ""));
        shapeEntity.setClearanceLeft(new BigDecimal(shapeObject.clearanceLeft + ""));
        shapeEntity.setClearanceRight(new BigDecimal(shapeObject.clearanceRight + ""));
        shapeEntity.setHighestX(new BigDecimal(shapeObject.highestX + ""));
        shapeEntity.setLowestX(new BigDecimal(shapeObject.lowestX + ""));
        shapeEntity.setHighestY(new BigDecimal(shapeObject.highestY + ""));
        shapeEntity.setHighestYC(new BigDecimal(shapeObject.highestYC + ""));
        shapeEntity.setLowestY(new BigDecimal(shapeObject.lowestY + ""));
        shapeEntity.setLowestYC(new BigDecimal(shapeObject.lowestYC + ""));
        shapeEntity.setStdW(shapeObject.isStdW);
        shapeEntity.setStdH(shapeObject.isStdH);
        shapeEntity.setBaseUOM(shapeObject.baseUOM);
        shapeEntity.setMyScale(new BigDecimal(shapeObject.myScale + ""));
        shapeEntity.setBkgrdStartX(new BigDecimal(shapeObject.bkgrdStartX + ""));
        shapeEntity.setBkgrdStartY(new BigDecimal(shapeObject.bkgrdStartY + ""));
        shapeEntity.setBkgrdStartXA(new BigDecimal(shapeObject.bkgrdStartXA + ""));
        shapeEntity.setBkgrdStartYA(new BigDecimal(shapeObject.bkgrdStartYA + ""));
        shapeEntity.setCenterPointX(new BigDecimal(shapeObject.centerPointX + ""));
        shapeEntity.setCenterPointY(new BigDecimal(shapeObject.centerPointY + ""));
        shapeEntity.setCenterPointX2(new BigDecimal(shapeObject.centerPointX2 + ""));
        shapeEntity.setCenterPointY2(new BigDecimal(shapeObject.centerPointY2 + ""));
        shapeEntity.setOpeningID(shapeObject.userDefinedOpeningID);
        shapeEntity.setDimA1(new BigDecimal(shapeObject.dimA1 + ""));
        shapeEntity.setDimA2(new BigDecimal(shapeObject.dimA2 + ""));
        shapeEntity.setDimA3(new BigDecimal(shapeObject.dimA3 + ""));
        shapeEntity.setDimA4(new BigDecimal(shapeObject.dimA4 + ""));
        shapeEntity.setDimA5(new BigDecimal(shapeObject.dimA5 + ""));
        shapeEntity.setDimA0(new BigDecimal(shapeObject.dimA0 + ""));
        shapeEntity.setDimB1(new BigDecimal(shapeObject.dimB1 + ""));
        shapeEntity.setDimB2(new BigDecimal(shapeObject.dimB2 + ""));
        shapeEntity.setDimB3(new BigDecimal(shapeObject.dimB3 + ""));
        shapeEntity.setDimB4(new BigDecimal(shapeObject.dimB4 + ""));
        shapeEntity.setDimB5(new BigDecimal(shapeObject.dimB5 + ""));
        shapeEntity.setDimB0(new BigDecimal(shapeObject.dimB0 + ""));
        shapeEntity.setDimC1(new BigDecimal(shapeObject.dimC1 + ""));
        shapeEntity.setDimC2(new BigDecimal(shapeObject.dimC2 + ""));
        shapeEntity.setDimC3(new BigDecimal(shapeObject.dimC3 + ""));
        shapeEntity.setDimC4(new BigDecimal(shapeObject.dimC4 + ""));
        shapeEntity.setDimC5(new BigDecimal(shapeObject.dimC5 + ""));
        shapeEntity.setDimC0(new BigDecimal(shapeObject.dimC0 + ""));
        shapeEntity.setDimD1(new BigDecimal(shapeObject.dimD1 + ""));
        shapeEntity.setDimD2(new BigDecimal(shapeObject.dimD2 + ""));
        shapeEntity.setDimD3(new BigDecimal(shapeObject.dimD3 + ""));
        shapeEntity.setDimD4(new BigDecimal(shapeObject.dimD4 + ""));
        shapeEntity.setDimD5(new BigDecimal(shapeObject.dimD5 + ""));
        shapeEntity.setDimD0(new BigDecimal(shapeObject.dimD0 + ""));
        shapeEntity.setDimA1M(shapeObject.dimA1M);
        shapeEntity.setDimA2M(shapeObject.dimA2M);
        shapeEntity.setDimA3M(shapeObject.dimA3M);
        shapeEntity.setDimA4M(shapeObject.dimA4M);
        shapeEntity.setDimA5M(shapeObject.dimA0M);
        shapeEntity.setDimA0M(shapeObject.dimB1M);
        shapeEntity.setDimB1M(shapeObject.dimB2M);
        shapeEntity.setDimB2M(shapeObject.dimB3M);
        shapeEntity.setDimB3M(shapeObject.dimB4M);
        shapeEntity.setDimB4M(shapeObject.dimB5M);
        shapeEntity.setDimB5M(shapeObject.dimB0M);
        shapeEntity.setDimB0M(shapeObject.dimB0M);
        shapeEntity.setDimC1M(shapeObject.dimC1M);
        shapeEntity.setDimC2M(shapeObject.dimC2M);
        shapeEntity.setDimC3M(shapeObject.dimC3M);
        shapeEntity.setDimC4M(shapeObject.dimC4M);
        shapeEntity.setDimC5M(shapeObject.dimC5M);
        shapeEntity.setDimC0M(shapeObject.dimC0M);
        shapeEntity.setDimD1M(shapeObject.dimD1M);
        shapeEntity.setDimD2M(shapeObject.dimD2M);
        shapeEntity.setDimD3M(shapeObject.dimD3M);
        shapeEntity.setDimD4M(shapeObject.dimD4M);
        shapeEntity.setDimD5M(shapeObject.dimD5M);
        shapeEntity.setDimD0M(shapeObject.dimD0M);
        shapeEntity.setDimA1I(shapeObject.dimA1I);
        shapeEntity.setDimA2I(shapeObject.dimA2I);
        shapeEntity.setDimA3I(shapeObject.dimA3I);
        shapeEntity.setDimA4I(shapeObject.dimA4I);
        shapeEntity.setDimA5I(shapeObject.dimA5I);
        shapeEntity.setDimA0I(shapeObject.dimA0I);
        shapeEntity.setDimB1I(shapeObject.dimB1I);
        shapeEntity.setDimB2I(shapeObject.dimB2I);
        shapeEntity.setDimB3I(shapeObject.dimB3I);
        shapeEntity.setDimB4I(shapeObject.dimB4I);
        shapeEntity.setDimB5I(shapeObject.dimB5I);
        shapeEntity.setDimB0I(shapeObject.dimB0I);
        shapeEntity.setDimC1I(shapeObject.dimC1I);
        shapeEntity.setDimC2I(shapeObject.dimC2I);
        shapeEntity.setDimC3I(shapeObject.dimC3I);
        shapeEntity.setDimC4I(shapeObject.dimC4I);
        shapeEntity.setDimC5I(shapeObject.dimC5I);
        shapeEntity.setDimC0I(shapeObject.dimC0I);
        shapeEntity.setDimD1I(shapeObject.dimD1I);
        shapeEntity.setDimD2I(shapeObject.dimD2I);
        shapeEntity.setDimD3I(shapeObject.dimD3I);
        shapeEntity.setDimD4I(shapeObject.dimD4I);
        shapeEntity.setDimD5I(shapeObject.dimD5I);
        shapeEntity.setDimD0I(shapeObject.dimD0I);
        shapeEntity.setAutoH(shapeObject.autoH);
        shapeEntity.setAutoW(shapeObject.autoW);
        shapeEntity.setParentId(shapeObject.parentid);
        shapeEntity.setStartingX(new BigDecimal(shapeObject.startingX + ""));
        shapeEntity.setStartingY(new BigDecimal(shapeObject.startingY + ""));
        shapeEntity.setbX2(new BigDecimal(shapeObject.bX2 + ""));
        shapeEntity.setbY2(new BigDecimal(shapeObject.bY2 + ""));
        shapeEntity.setbX3(new BigDecimal(shapeObject.bX3 + ""));
        shapeEntity.setbY3(new BigDecimal(shapeObject.bY3 + ""));
        shapeEntity.setbX4(new BigDecimal(shapeObject.bX4 + ""));
        shapeEntity.setbY4(new BigDecimal(shapeObject.bY4 + ""));
        shapeEntity.setStartingXBA(new BigDecimal(shapeObject.startingXBA + ""));
        shapeEntity.setStartingYBA(new BigDecimal(shapeObject.startingYBA + ""));
        shapeEntity.setStartingXA(new BigDecimal(shapeObject.startingXA + ""));
        shapeEntity.setStartingYA(new BigDecimal(shapeObject.startingYA + ""));
        shapeEntity.setbX2B(new BigDecimal(shapeObject.bX2B + ""));
        shapeEntity.setbY2B(new BigDecimal(shapeObject.bY2B + ""));
        shapeEntity.setbX3B(new BigDecimal(shapeObject.bX3B + ""));
        shapeEntity.setbY3B(new BigDecimal(shapeObject.bY3B + ""));
        shapeEntity.setbX4B(new BigDecimal(shapeObject.bX4B + ""));
        shapeEntity.setbY4B(new BigDecimal(shapeObject.bY4B + ""));
        shapeEntity.setbX2A(new BigDecimal(shapeObject.bX2A + ""));
        shapeEntity.setbY2A(new BigDecimal(shapeObject.bY2A + ""));
        shapeEntity.setbX3A(new BigDecimal(shapeObject.bX3A + ""));
        shapeEntity.setbY3A(new BigDecimal(shapeObject.bY3A + ""));
        shapeEntity.setbX4A(new BigDecimal(shapeObject.bX4A + ""));
        shapeEntity.setbY4A(new BigDecimal(shapeObject.bY4A + ""));
        shapeEntity.setStartingCX(new BigDecimal(shapeObject.startingCX + ""));
        shapeEntity.setStartingCY(new BigDecimal(shapeObject.startingCY + ""));
        shapeEntity.setbCX2(new BigDecimal(shapeObject.bCX2 + ""));
        shapeEntity.setbCY2(new BigDecimal(shapeObject.bCY2 + ""));
        shapeEntity.setbCX3(new BigDecimal(shapeObject.bCX3 + ""));
        shapeEntity.setbCY3(new BigDecimal(shapeObject.bCY3 + ""));
        shapeEntity.setbCX4(new BigDecimal(shapeObject.bCX4 + ""));
        shapeEntity.setbCY4(new BigDecimal(shapeObject.bCY4 + ""));
        shapeEntity.setLevelW(new BigDecimal(shapeObject.levelW + ""));
        shapeEntity.setLevelH(new BigDecimal(shapeObject.levelH + ""));
        shapeEntity.setWire(shapeObject.wire);
        shapeEntity.setDimTM(new BigDecimal(shapeObject.dimTM + ""));
        shapeEntity.setDimBM(new BigDecimal(shapeObject.dimBM + ""));
        shapeEntity.setDimLM(new BigDecimal(shapeObject.dimLM + ""));
        shapeEntity.setDimRM(new BigDecimal(shapeObject.dimRM + ""));
        shapeEntity.setDimTA(new BigDecimal(shapeObject.dimTA + ""));
        shapeEntity.setDimBA(new BigDecimal(shapeObject.dimBA + ""));
        shapeEntity.setDimLA(new BigDecimal(shapeObject.dimLA + ""));
        shapeEntity.setDimRA(new BigDecimal(shapeObject.dimRA + ""));
        shapeEntity.setWidthMN(shapeObject.widthMN);
        shapeEntity.setHeightMN(shapeObject.heightMN);
        shapeEntity.setWidthIN(shapeObject.widthIN);
        shapeEntity.setHeightIN(shapeObject.heightIN);

        shapeEntity.setPx1(new BigDecimal(shapeObject.px1 + ""));
        shapeEntity.setPy1(new BigDecimal(shapeObject.py1 + ""));
        shapeEntity.setPx2(new BigDecimal(shapeObject.px2 + ""));
        shapeEntity.setPy2(new BigDecimal(shapeObject.py2 + ""));
        shapeEntity.setPx3(new BigDecimal(shapeObject.px3 + ""));
        shapeEntity.setPy3(new BigDecimal(shapeObject.py3 + ""));
        shapeEntity.setPx4(new BigDecimal(shapeObject.px4 + ""));
        shapeEntity.setPy4(new BigDecimal(shapeObject.py4 + ""));
        shapeEntity.setPx5(new BigDecimal(shapeObject.px5 + ""));
        shapeEntity.setPy5(new BigDecimal(shapeObject.py5 + ""));
        shapeEntity.setPx6(new BigDecimal(shapeObject.px6 + ""));
        shapeEntity.setPy6(new BigDecimal(shapeObject.py6 + ""));
        shapeEntity.setPx7(new BigDecimal(shapeObject.px7 + ""));
        shapeEntity.setPy7(new BigDecimal(shapeObject.py7 + ""));
        shapeEntity.setPx8(new BigDecimal(shapeObject.px8 + ""));
        shapeEntity.setPy8(new BigDecimal(shapeObject.py8 + ""));
        shapeEntity.setPx1A(new BigDecimal(shapeObject.px1A + ""));
        shapeEntity.setPy1A(new BigDecimal(shapeObject.py1A + ""));
        shapeEntity.setPx2A(new BigDecimal(shapeObject.px2A + ""));
        shapeEntity.setPy2A(new BigDecimal(shapeObject.py2A + ""));
        shapeEntity.setPx3A(new BigDecimal(shapeObject.px3A + ""));
        shapeEntity.setPy3A(new BigDecimal(shapeObject.py3A + ""));
        shapeEntity.setPx4A(new BigDecimal(shapeObject.px4A + ""));
        shapeEntity.setPy4A(new BigDecimal(shapeObject.py4A + ""));
        shapeEntity.setPx5A(new BigDecimal(shapeObject.px5A + ""));
        shapeEntity.setPy5A(new BigDecimal(shapeObject.py5A + ""));
        shapeEntity.setPx6A(new BigDecimal(shapeObject.px6A + ""));
        shapeEntity.setPy6A(new BigDecimal(shapeObject.py6A + ""));
        shapeEntity.setPx7A(new BigDecimal(shapeObject.px7A + ""));
        shapeEntity.setPy7A(new BigDecimal(shapeObject.py7A + ""));
        shapeEntity.setPx8A(new BigDecimal(shapeObject.px8A + ""));
        shapeEntity.setPy8A(new BigDecimal(shapeObject.py8A + ""));
        shapeEntity.setPx1c(new BigDecimal(shapeObject.px1c + ""));
        shapeEntity.setPy1c(new BigDecimal(shapeObject.py1c + ""));
        shapeEntity.setPx2c(new BigDecimal(shapeObject.px2c + ""));
        shapeEntity.setPy2c(new BigDecimal(shapeObject.py2c + ""));
        shapeEntity.setPx3c(new BigDecimal(shapeObject.px3c + ""));
        shapeEntity.setPy3c(new BigDecimal(shapeObject.py3c + ""));
        shapeEntity.setPx4c(new BigDecimal(shapeObject.px4c + ""));
        shapeEntity.setPy4c(new BigDecimal(shapeObject.py4c + ""));
        shapeEntity.setPx5c(new BigDecimal(shapeObject.px5c + ""));
        shapeEntity.setPy5c(new BigDecimal(shapeObject.py5c + ""));
        shapeEntity.setPx6c(new BigDecimal(shapeObject.px6c + ""));
        shapeEntity.setPy6c(new BigDecimal(shapeObject.py6c + ""));
        shapeEntity.setPx7c(new BigDecimal(shapeObject.px7c + ""));
        shapeEntity.setPy7c(new BigDecimal(shapeObject.py7c + ""));
        shapeEntity.setPx8c(new BigDecimal(shapeObject.px8c + ""));
        shapeEntity.setPy8c(new BigDecimal(shapeObject.py8c + ""));

        shapeEntity.setSupplierRemoteId(shapeObject.supplierId);
        shapeEntity.setRemote(shapeObject.remote);

        /* Adding profile parts objects */
        Set<ProfileEntityBOM> profileBOMs = getProfilePartsObject(shapeObject);
        shapeEntity.setProfileBOMs(profileBOMs);

        /* Adding parts objects */
        Set<ProfileCollectionObject> profileCollection = getProfileCollection(shapeObject);
        shapeEntity.setProfileCollection(profileCollection);

        /* Adding my mullions collection objects */
        Set<ProfileMyMullionObject> profileMyMullionObjects = getMyMullionCollection(shapeObject);
        shapeEntity.setMyMullions(profileMyMullionObjects);

        /* Adding shape options */
        Set<ShapeOptionEntityObject> shapeOptions = new HashSet<ShapeOptionEntityObject>();
        if (shapeObject.options != null && !shapeObject.options.isEmpty()) {
            for (ShapeOption option : shapeObject.options) {
                ShapeOptionEntityObject optionEntity = ShapeOptionDTO.getShapeOptionEntity(option);

                shapeOptions.add(optionEntity);
            }
        }
        shapeEntity.setOptions(shapeOptions);

        /* Adding Bill of Materials */
        Set<BillOfMaterialEntityObject> boms = new HashSet<BillOfMaterialEntityObject>();
        if (shapeObject.bom != null && !shapeObject.bom.isEmpty()) {
            for (BillOfMat billOfMat : shapeObject.bom) {
                BillOfMaterialEntityObject billOfMaterialEntity = BillOfMaterialDTO.getBillOfMaterialEntity(billOfMat);

                boms.add(billOfMaterialEntity);
            }
        }
        shapeEntity.setBoms(boms);

        /* Adding Shape Notes */
        Set<ShapeNotesEntityObject> shapeNotes = new HashSet<ShapeNotesEntityObject>();
        if (shapeObject.notes != null && !shapeObject.bom.isEmpty()) {
            for (ShapeNotes notes : shapeObject.notes) {
                ShapeNotesEntityObject shapeNotesEntity = ShapeNotesDTO.getShapeNotesEntityObject(notes);

                shapeNotes.add(shapeNotesEntity);
            }
        }
        shapeEntity.setNotes(shapeNotes);

        return shapeEntity;
    }

    /**
     * This method create ShapeObject model
     *
     * @param shapeEntity, ShapeAbstractObject
     * @param shapeObject, ShapeObject
     * @param clazz,       Class
     * @return ShapeObject
     * @throws dto.DTOTransformationError, Error
     */
    public static ShapeObject getShapeObjectModel(ShapeAbstractObject shapeEntity, ShapeObject shapeObject, Class clazz)
            throws DTOTransformationError {

        if (shapeEntity == null) {
            throw new DTOTransformationError();
        }

        if (shapeObject == null) {
            throw new DTOTransformationError();
        }

        //Preparing new scale calculation
        BigDecimal _original_scale = new BigDecimal(shapeObject.myFrame2.jobItem.originalScaleS + "");
        BigDecimal _new_scale = new BigDecimal(shapeObject.myFrame2.jobItem.newScaleS + "");

        BigDecimal _starting_x = new BigDecimal(shapeObject.myFrame2.jobItem.startingX + "");
        BigDecimal _starting_y = new BigDecimal(shapeObject.myFrame2.jobItem.startingY + "");

        //Creating object to model
        shapeObject.a_levelID = shapeEntity.getLevelId();
        shapeObject.a_sequenceID = shapeEntity.getSequenceId();
        shapeObject.a_assemblyLevel = shapeEntity.getAssemblyLevelId();
        shapeObject.stdWM = shapeEntity.getStdWM();
        shapeObject.stdWI = shapeEntity.getStdWI();
        shapeObject.stdHM = shapeEntity.getStdHM();
        shapeObject.stdHI = shapeEntity.getStdHI();

        shapeObject.controlOpeningClassType = shapeEntity.getControlOpeningClassType();
        shapeObject.controlOpeningClass = shapeEntity.getControlOpeningClass();
        shapeObject.controlUserDefinedOpeningID = shapeEntity.getControlUserDefinedOpeningID();

        //Construction map
        shapeObject.a_1Level = shapeEntity.getConstructionMap().get_a_1Level();
        shapeObject.a_2Level = shapeEntity.getConstructionMap().get_a_2Level();
        shapeObject.a_3Level = shapeEntity.getConstructionMap().get_a_3Level();
        shapeObject.a_4Level = shapeEntity.getConstructionMap().get_a_4Level();
        shapeObject.a_5Level = shapeEntity.getConstructionMap().get_a_5Level();
        shapeObject.a_6Level = shapeEntity.getConstructionMap().get_a_6Level();
        shapeObject.a_7Level = shapeEntity.getConstructionMap().get_a_7Level();
        shapeObject.a_8Level = shapeEntity.getConstructionMap().get_a_8Level();
        shapeObject.a_9Level = shapeEntity.getConstructionMap().get_a_9Level();
        shapeObject.a_10Level = shapeEntity.getConstructionMap().get_a_10Level();
        shapeObject.a_11Level = shapeEntity.getConstructionMap().get_a_11Level();
        shapeObject.a_12Level = shapeEntity.getConstructionMap().get_a_12Level();
        shapeObject.a_13Level = shapeEntity.getConstructionMap().get_a_13Level();
        shapeObject.a_14Level = shapeEntity.getConstructionMap().get_a_14Level();
        shapeObject.a_15Level = shapeEntity.getConstructionMap().get_a_15Level();
        shapeObject.a_16Level = shapeEntity.getConstructionMap().get_a_16Level();
        shapeObject.a_17Level = shapeEntity.getConstructionMap().get_a_17Level();
        shapeObject.a_18Level = shapeEntity.getConstructionMap().get_a_18Level();
        shapeObject.a_19Level = shapeEntity.getConstructionMap().get_a_19Level();
        shapeObject.a_20Level = shapeEntity.getConstructionMap().get_a_20Level();
        shapeObject.a_21Level = shapeEntity.getConstructionMap().get_a_21Level();
        shapeObject.a_22Level = shapeEntity.getConstructionMap().get_a_22Level();
        shapeObject.a_1Sequence = shapeEntity.getConstructionMap().get_a_1Sequence();
        shapeObject.a_2Sequence = shapeEntity.getConstructionMap().get_a_2Sequence();
        shapeObject.a_3Sequence = shapeEntity.getConstructionMap().get_a_3Sequence();
        shapeObject.a_4Sequence = shapeEntity.getConstructionMap().get_a_4Sequence();
        shapeObject.a_5Sequence = shapeEntity.getConstructionMap().get_a_5Sequence();
        shapeObject.a_6Sequence = shapeEntity.getConstructionMap().get_a_6Sequence();
        shapeObject.a_7Sequence = shapeEntity.getConstructionMap().get_a_7Sequence();
        shapeObject.a_8Sequence = shapeEntity.getConstructionMap().get_a_8Sequence();
        shapeObject.a_9Sequence = shapeEntity.getConstructionMap().get_a_9Sequence();
        shapeObject.a_10Sequence = shapeEntity.getConstructionMap().get_a_10Sequence();
        shapeObject.a_11Sequence = shapeEntity.getConstructionMap().get_a_11Sequence();
        shapeObject.a_12Sequence = shapeEntity.getConstructionMap().get_a_12Sequence();
        shapeObject.a_13Sequence = shapeEntity.getConstructionMap().get_a_13Sequence();
        shapeObject.a_14Sequence = shapeEntity.getConstructionMap().get_a_14Sequence();
        shapeObject.a_15Sequence = shapeEntity.getConstructionMap().get_a_15Sequence();
        shapeObject.a_16Sequence = shapeEntity.getConstructionMap().get_a_16Sequence();
        shapeObject.a_17Sequence = shapeEntity.getConstructionMap().get_a_17Sequence();
        shapeObject.a_18Sequence = shapeEntity.getConstructionMap().get_a_18Sequence();
        shapeObject.a_19Sequence = shapeEntity.getConstructionMap().get_a_19Sequence();
        shapeObject.a_20Sequence = shapeEntity.getConstructionMap().get_a_20Sequence();
        shapeObject.a_21Sequence = shapeEntity.getConstructionMap().get_a_21Sequence();
        shapeObject.a_22Sequence = shapeEntity.getConstructionMap().get_a_22Sequence();

        shapeObject.shapeID = shapeEntity.getShapeID();
        shapeObject.noPartsTop1 = shapeEntity.getNoPartsTop1();
        shapeObject.noPartsTop2 = shapeEntity.getNoPartsTop2();
        shapeObject.noPartsTop3 = shapeEntity.getNoPartsTop3();
        shapeObject.noPartsBot1 = shapeEntity.getNoPartsBot1();
        shapeObject.noPartsBot2 = shapeEntity.getNoPartsBot2();
        shapeObject.noPartsBot3 = shapeEntity.getNoPartsBot3();
        shapeObject.noPartsLeft = shapeEntity.getNoPartsLeft();
        shapeObject.noPartsRight = shapeEntity.getNoPartsRight();
        shapeObject.newDesign = shapeEntity.isNewDesign();
        shapeObject.frameStartCol = shapeEntity.getFrameStartCol();
        shapeObject.frameStartRow = shapeEntity.getFrameStartRow();
        shapeObject.frameEndCol = shapeEntity.getFrameEndCol();
        shapeObject.frameEndRow = shapeEntity.getFrameEndRow();
        shapeObject.xCols = shapeEntity.getxCols();
        shapeObject.yRows = shapeEntity.getyRows();
        shapeObject.noTracks = shapeEntity.getNoTracks();
        shapeObject.openOut = shapeEntity.isOpenOut();
        shapeObject.glazedOut = shapeEntity.isGlazedOut();
        shapeObject.radius1A = shapeEntity.getRadius1A().doubleValue() > 0 ? shapeEntity.getRadius1A().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getRadius1A().doubleValue();
        shapeObject.radius2A = shapeEntity.getRadius2A().doubleValue() > 0 ? shapeEntity.getRadius2A().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getRadius2A().doubleValue();
        shapeObject.startAngleA = shapeEntity.getStartAngleA().doubleValue();
        shapeObject.endAngleA = shapeEntity.getEndAngle().doubleValue();
        shapeObject.centralAngleA = shapeEntity.getCentralAngleA().doubleValue();
        shapeObject.hasSash = shapeEntity.isHasSash();
        shapeObject.unGlazed = shapeEntity.isUnGlazed();
        shapeObject.openingClass = shapeEntity.getOpeningType();
        shapeObject.outSashTracks = shapeEntity.getOutSashTracks();
        shapeObject.inSashTracks = shapeEntity.getInSashTracks();
        shapeObject.midSashTracks = shapeEntity.getMidSashTracks();
        shapeObject.openIn = shapeEntity.isOpenIn();
        shapeObject.lean = shapeEntity.getLean();
        shapeObject.lean2 = shapeEntity.getLean2();
        shapeObject.lean3 = shapeEntity.getLean3();
        shapeObject.lean4 = shapeEntity.getLean4();
        shapeObject.noSides = shapeEntity.getNoSides();
        shapeObject.noSidesTop = shapeEntity.getNoSidesTop();
        shapeObject.noSidesBot = shapeEntity.getNoSidesBot();
        shapeObject.noSidesLeft = shapeEntity.getNoSidesLeft();
        shapeObject.noSidesRight = shapeEntity.getNoSidesRight();
        shapeObject.topShape = shapeEntity.getTopShape();
        shapeObject.rightShape = shapeEntity.getRightShape();
        shapeObject.botShape = shapeEntity.getBotShape();
        shapeObject.leftShape = shapeEntity.getLeftShape();
        shapeObject.radius1 = shapeEntity.getRadius1().doubleValue() > 0 ? shapeEntity.getRadius1().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getRadius1().doubleValue();
        shapeObject.radius2 = shapeEntity.getRadius2().doubleValue() > 0 ? shapeEntity.getRadius2().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getRadius2().doubleValue();
        shapeObject.startAngle = shapeEntity.getStartAngle().doubleValue();
        shapeObject.endAngle = shapeEntity.getEndAngle().doubleValue();
        shapeObject.centralAngle = shapeEntity.getCentralAngle().doubleValue();
        shapeObject.startCol = shapeEntity.getStartCol();
        shapeObject.endCol = shapeEntity.getEndCol();
        shapeObject.startRow = shapeEntity.getStartRow();
        shapeObject.endRow = shapeEntity.getEndRow();
        shapeObject.topIn = shapeEntity.isTopIn();
        shapeObject.rightIn = shapeEntity.isRightIn();
        shapeObject.botIn = shapeEntity.isBotIn();
        shapeObject.leftIn = shapeEntity.isLeftIn();
        shapeObject.clearanceTop = shapeEntity.getClearanceTop().doubleValue() > 0 ? shapeEntity.getClearanceTop().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getClearanceTop().doubleValue();
        shapeObject.clearanceBot = shapeEntity.getClearanceBot().doubleValue() > 0 ? shapeEntity.getClearanceBot().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getClearanceBot().doubleValue();
        shapeObject.clearanceLeft = shapeEntity.getClearanceLeft().doubleValue() > 0 ? shapeEntity.getClearanceLeft().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getClearanceLeft().doubleValue();
        shapeObject.clearanceRight = shapeEntity.getClearanceRight().doubleValue() > 0 ? shapeEntity.getClearanceRight().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getClearanceRight().doubleValue();
        shapeObject.widthM = shapeEntity.getWidthM();
        shapeObject.widthI = shapeEntity.getWidthI();
        shapeObject.widthIO = shapeEntity.getWidthIO();
        shapeObject.widthMO = shapeEntity.getWidthMO();
        shapeObject.widthPix = shapeEntity.getWidthPix().doubleValue() > 0 ? shapeEntity.getWidthPix().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getWidthPix().doubleValue();
        shapeObject.heightM = shapeEntity.getHeightM();
        shapeObject.heightI = shapeEntity.getHeightI();
        shapeObject.heightIO = shapeEntity.getHeightIO();
        shapeObject.heightMO = shapeEntity.getHeightMO();
        shapeObject.heightPix = shapeEntity.getHeightPix().doubleValue() > 0 ? shapeEntity.getHeightPix().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getHeightPix().doubleValue();
        shapeObject.scaleImp = shapeEntity.getScaleImp();
        shapeObject.scaleM = shapeEntity.getScaleM();
        shapeObject.highestX = shapeEntity.getHighestX().doubleValue();
        shapeObject.lowestX = shapeEntity.getLowestX().doubleValue();
        shapeObject.highestY = calculateNewValueWidthStartingPoint(shapeEntity.getHighestY(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.highestYC = calculateNewValueWidthStartingPoint(shapeEntity.getHighestYC(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.lowestY = calculateNewValueWidthStartingPoint(shapeEntity.getLowestY(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.lowestYC = calculateNewValueWidthStartingPoint(shapeEntity.getLowestYC(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.isStdW = shapeEntity.isStdW();
        shapeObject.isStdH = shapeEntity.isStdH();
        shapeObject.baseUOM = shapeEntity.getBaseUOM();
        shapeObject.myScale = shapeEntity.getMyScale();
        shapeObject.bkgrdStartX = calculateNewValueWidthStartingPoint(shapeEntity.getBkgrdStartX(), _starting_x, _original_scale,
                _new_scale);
        shapeObject.bkgrdStartY = calculateNewValueWidthStartingPoint(shapeEntity.getBkgrdStartY(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.bkgrdStartXA = calculateNewValueWidthStartingPoint(shapeEntity.getBkgrdStartXA(), _starting_x, _original_scale,
                _new_scale);
        shapeObject.bkgrdStartYA = calculateNewValueWidthStartingPoint(shapeEntity.getBkgrdStartYA(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.centerPointX = calculateNewValueWidthStartingPoint(shapeEntity.getCenterPointX(), _starting_x, _original_scale,
                _new_scale);
        shapeObject.centerPointY = calculateNewValueWidthStartingPoint(shapeEntity.getCenterPointY(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.centerPointX2 = calculateNewValueWidthStartingPoint(shapeEntity.getCenterPointX2(), _starting_x, _original_scale,
                _new_scale);
        shapeObject.centerPointY2 = calculateNewValueWidthStartingPoint(shapeEntity.getCenterPointY2(), _starting_x, _original_scale,
                _new_scale);
        
        shapeObject.userDefinedOpeningID = shapeEntity.getOpeningID();
       
        shapeObject.dimA1 = shapeEntity.getDimA1().doubleValue();
        shapeObject.dimA2 = shapeEntity.getDimA2().doubleValue();
        shapeObject.dimA3 = shapeEntity.getDimA3().doubleValue();
        shapeObject.dimA4 = shapeEntity.getDimA4().doubleValue();
        shapeObject.dimA5 = shapeEntity.getDimA5().doubleValue();
        shapeObject.dimA0 = shapeEntity.getDimA0().doubleValue();
        shapeObject.dimB1 = shapeEntity.getDimB1().doubleValue() > 0 ? shapeEntity.getDimB1().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getDimB1().doubleValue();
        shapeObject.dimB2 = shapeEntity.getDimB2().doubleValue() > 0 ? shapeEntity.getDimB2().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getDimB2().doubleValue();
        shapeObject.dimB3 = shapeEntity.getDimB3().doubleValue();
        shapeObject.dimB4 = shapeEntity.getDimB4().doubleValue();
        shapeObject.dimB5 = shapeEntity.getDimB5().doubleValue();
        shapeObject.dimB0 = shapeEntity.getDimB0().doubleValue();
        shapeObject.dimC1 = shapeEntity.getDimC1().doubleValue();
        shapeObject.dimC2 = shapeEntity.getDimC2().doubleValue();
        shapeObject.dimC3 = shapeEntity.getDimC3().doubleValue();
        shapeObject.dimC4 = shapeEntity.getDimC4().doubleValue();
        shapeObject.dimC5 = shapeEntity.getDimC5().doubleValue();
        shapeObject.dimC0 = shapeEntity.getDimC0().doubleValue();
        shapeObject.dimD1 = shapeEntity.getDimD1().doubleValue() > 0 ? shapeEntity.getDimD1().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getDimD1().doubleValue();
        shapeObject.dimD2 = shapeEntity.getDimD2().doubleValue() > 0 ? shapeEntity.getDimD2().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getDimD2().doubleValue();
        shapeObject.dimD3 = shapeEntity.getDimD3().doubleValue();
        shapeObject.dimD4 = shapeEntity.getDimD4().doubleValue();
        shapeObject.dimD5 = shapeEntity.getDimD5().doubleValue();
        shapeObject.dimD0 = shapeEntity.getDimD0().doubleValue();
        shapeObject.dimA1M = shapeEntity.getDimA1M();
        shapeObject.dimA2M = shapeEntity.getDimA2M();
        shapeObject.dimA3M = shapeEntity.getDimA3M();
        shapeObject.dimA4M = shapeEntity.getDimA4M();
        shapeObject.dimA5M = shapeEntity.getDimA5M();
        shapeObject.dimA0M = shapeEntity.getDimA0M();
        shapeObject.dimB1M = shapeEntity.getDimB1M();
        shapeObject.dimB2M = shapeEntity.getDimB2M();
        shapeObject.dimB3M = shapeEntity.getDimB3M();
        shapeObject.dimB4M = shapeEntity.getDimB4M();
        shapeObject.dimB5M = shapeEntity.getDimB5M();
        shapeObject.dimB0M = shapeEntity.getDimB0M();
        shapeObject.dimC1M = shapeEntity.getDimC1M();
        shapeObject.dimC2M = shapeEntity.getDimC2M();
        shapeObject.dimC3M = shapeEntity.getDimC3M();
        shapeObject.dimC4M = shapeEntity.getDimC4M();
        shapeObject.dimC5M = shapeEntity.getDimC5M();
        shapeObject.dimC0M = shapeEntity.getDimC0M();
        shapeObject.dimD1M = shapeEntity.getDimD1M();
        shapeObject.dimD2M = shapeEntity.getDimD2M();
        shapeObject.dimD3M = shapeEntity.getDimD3M();
        shapeObject.dimD4M = shapeEntity.getDimD4M();
        shapeObject.dimD5M = shapeEntity.getDimD5M();
        shapeObject.dimD0M = shapeEntity.getDimD0M();
        shapeObject.dimA1I = shapeEntity.getDimA1I();
        shapeObject.dimA2I = shapeEntity.getDimA2I();
        shapeObject.dimA3I = shapeEntity.getDimA3I();
        shapeObject.dimA4I = shapeEntity.getDimA4I();
        shapeObject.dimA5I = shapeEntity.getDimA5I();
        shapeObject.dimA0I = shapeEntity.getDimA0I();
        shapeObject.dimB1I = shapeEntity.getDimB1I();
        shapeObject.dimB2I = shapeEntity.getDimB2I();
        shapeObject.dimB3I = shapeEntity.getDimB3I();
        shapeObject.dimB4I = shapeEntity.getDimB4I();
        shapeObject.dimB5I = shapeEntity.getDimB5I();
        shapeObject.dimB0I = shapeEntity.getDimB0I();
        shapeObject.dimC1I = shapeEntity.getDimC1I();
        shapeObject.dimC2I = shapeEntity.getDimC2I();
        shapeObject.dimC3I = shapeEntity.getDimC3I();
        shapeObject.dimC4I = shapeEntity.getDimC4I();
        shapeObject.dimC5I = shapeEntity.getDimC5I();
        shapeObject.dimC0I = shapeEntity.getDimC0I();
        shapeObject.dimD1I = shapeEntity.getDimD1I();
        shapeObject.dimD2I = shapeEntity.getDimD2I();
        shapeObject.dimD3I = shapeEntity.getDimD3I();
        shapeObject.dimD4I = shapeEntity.getDimD4I();
        shapeObject.dimD5I = shapeEntity.getDimD5I();
        shapeObject.dimD0I = shapeEntity.getDimD0I();
        shapeObject.autoH = shapeEntity.isAutoH();
        shapeObject.autoW = shapeEntity.isAutoW();
        shapeObject.parentid = shapeEntity.getParentId();
        shapeObject.startingX = calculateNewValueWidthStartingPoint(shapeEntity.getStartingX(), _starting_x,
                _original_scale, _new_scale);
        shapeObject.startingY = calculateNewValueWidthStartingPoint(shapeEntity.getStartingY(), _starting_y,
                _original_scale, _new_scale);
        shapeObject.bX2 = calculateNewValueWidthStartingPoint(shapeEntity.getbX2(), _starting_x,
                _original_scale, _new_scale);
        shapeObject.bY2 = calculateNewValueWidthStartingPoint(shapeEntity.getbY2(), _starting_y,
                _original_scale, _new_scale);
        shapeObject.bX3 = calculateNewValueWidthStartingPoint(shapeEntity.getbX3(), _starting_x,
                _original_scale, _new_scale);
        shapeObject.bY3 = calculateNewValueWidthStartingPoint(shapeEntity.getbY3(), _starting_y,
                _original_scale, _new_scale);
        shapeObject.bX4 = calculateNewValueWidthStartingPoint(shapeEntity.getbX4(), _starting_x,
                _original_scale, _new_scale);
        shapeObject.bY4 = calculateNewValueWidthStartingPoint(shapeEntity.getbY4(), _starting_y,
                _original_scale, _new_scale);
        shapeObject.startingXBA = shapeEntity.getStartingXBA().doubleValue();
        shapeObject.startingYBA = shapeEntity.getStartingYBA().doubleValue();
        shapeObject.startingXA = calculateNewValueWidthStartingPoint(shapeEntity.getStartingXA(), _starting_x,
                _original_scale, _new_scale);
        shapeObject.startingYA = calculateNewValueWidthStartingPoint(shapeEntity.getStartingYA(), _starting_y,
                _original_scale, _new_scale);
        shapeObject.bX2B = calculateNewValueWidthStartingPoint(shapeEntity.getbX2B(), _starting_x, _original_scale,
                _new_scale);
        shapeObject.bY2B = calculateNewValueWidthStartingPoint(shapeEntity.getbY2B(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.bX3B = calculateNewValueWidthStartingPoint(shapeEntity.getbX3B(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.bY3B = calculateNewValueWidthStartingPoint(shapeEntity.getbY3B(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.bX4B = calculateNewValueWidthStartingPoint(shapeEntity.getbX4B(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.bY4B = calculateNewValueWidthStartingPoint(shapeEntity.getbY4B(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.bX2A = calculateNewValueWidthStartingPoint(shapeEntity.getbX2A(), _starting_x, _original_scale,
                _new_scale);
        shapeObject.bY2A = calculateNewValueWidthStartingPoint(shapeEntity.getbY2A(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.bX3A = calculateNewValueWidthStartingPoint(shapeEntity.getbX3A(), _starting_x, _original_scale,
                _new_scale);
        shapeObject.bY3A = calculateNewValueWidthStartingPoint(shapeEntity.getbY3A(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.bX4A = calculateNewValueWidthStartingPoint(shapeEntity.getbX4A(), _starting_x, _original_scale,
                _new_scale);
        shapeObject.bY4A = calculateNewValueWidthStartingPoint(shapeEntity.getbY4A(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.startingCX = calculateNewValueWidthStartingPoint(shapeEntity.getStartingCX(), _starting_x,
                _original_scale, _new_scale);
        shapeObject.startingCY = calculateNewValueWidthStartingPoint(shapeEntity.getStartingCY(), _starting_y,
                _original_scale, _new_scale);
        shapeObject.bCX2 = calculateNewValueWidthStartingPoint(shapeEntity.getbCX2(), _starting_x, _original_scale,
                _new_scale);
        shapeObject.bCY2 = calculateNewValueWidthStartingPoint(shapeEntity.getbCY2(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.bCX3 = calculateNewValueWidthStartingPoint(shapeEntity.getbCX3(), _starting_x, _original_scale,
                _new_scale);
        shapeObject.bCY3 = calculateNewValueWidthStartingPoint(shapeEntity.getbCY3(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.bCX4 = calculateNewValueWidthStartingPoint(shapeEntity.getbCX4(), _starting_x, _original_scale,
                _new_scale);
        shapeObject.bCY4 = calculateNewValueWidthStartingPoint(shapeEntity.getbCY4(), _starting_y, _original_scale,
                _new_scale);
        shapeObject.levelW = shapeEntity.getLevelW().doubleValue() > 0 ? shapeEntity.getLevelW().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getLevelW().doubleValue();
        shapeObject.levelH = shapeEntity.getLevelH().doubleValue() > 0 ? shapeEntity.getLevelH().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getLevelH().doubleValue();
        shapeObject.wire = shapeEntity.isWire();
        shapeObject.dimTM = shapeEntity.getDimTM().doubleValue() > 0 ? shapeEntity.getDimTM().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getDimTM().doubleValue();
        shapeObject.dimBM = shapeEntity.getDimBM().doubleValue() > 0 ? shapeEntity.getDimBM().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getDimBM().doubleValue();
        shapeObject.dimLM = shapeEntity.getDimLM().doubleValue() > 0 ? shapeEntity.getDimLM().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getDimLM().doubleValue();
        shapeObject.dimRM = shapeEntity.getDimRM().doubleValue() > 0 ? shapeEntity.getDimRM().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getDimRM().doubleValue();
        shapeObject.dimTA = shapeEntity.getDimTA().doubleValue() > 0 ? shapeEntity.getDimTA().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getDimTA().doubleValue();
        shapeObject.dimBA = shapeEntity.getDimBA().doubleValue() > 0 ? shapeEntity.getDimBA().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getDimBA().doubleValue();
        shapeObject.dimLA = shapeEntity.getDimLA().doubleValue() > 0 ? shapeEntity.getDimLA().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getDimLA().doubleValue();
        shapeObject.dimRA = shapeEntity.getDimRA().doubleValue() > 0 ? shapeEntity.getDimRA().
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue() :
                shapeEntity.getDimRA().doubleValue();
        shapeObject.widthMN = shapeEntity.getWidthMN();
        shapeObject.heightMN = shapeEntity.getHeightMN();
        shapeObject.widthIN = shapeEntity.getWidthIN();
        shapeObject.heightIN = shapeEntity.getHeightIN();
        shapeObject.lastSeq = shapeEntity.getSequenceId();

        shapeObject.px1 = calculateNewValueWidthStartingPoint(shapeEntity.getPx1(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py1 = calculateNewValueWidthStartingPoint(shapeEntity.getPy1(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px2  = calculateNewValueWidthStartingPoint(shapeEntity.getPx2(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py2  = calculateNewValueWidthStartingPoint(shapeEntity.getPy2(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px3  = calculateNewValueWidthStartingPoint(shapeEntity.getPx3(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py3  = calculateNewValueWidthStartingPoint(shapeEntity.getPy3(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px4  = calculateNewValueWidthStartingPoint(shapeEntity.getPx4(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py4  =calculateNewValueWidthStartingPoint(shapeEntity.getPy4(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px5  = calculateNewValueWidthStartingPoint(shapeEntity.getPx5(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py5  = calculateNewValueWidthStartingPoint(shapeEntity.getPy5(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px6  = calculateNewValueWidthStartingPoint(shapeEntity.getPx6(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py6  = calculateNewValueWidthStartingPoint(shapeEntity.getPy6(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px7  = calculateNewValueWidthStartingPoint(shapeEntity.getPx7(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py7  = calculateNewValueWidthStartingPoint(shapeEntity.getPy7(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px8  = calculateNewValueWidthStartingPoint(shapeEntity.getPx8(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py8  = calculateNewValueWidthStartingPoint(shapeEntity.getPy8(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px1A  = calculateNewValueWidthStartingPoint(shapeEntity.getPx1A(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py1A  = calculateNewValueWidthStartingPoint(shapeEntity.getPy1A(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px2A  = calculateNewValueWidthStartingPoint(shapeEntity.getPx2A(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py2A  = calculateNewValueWidthStartingPoint(shapeEntity.getPy2A(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px3A  = calculateNewValueWidthStartingPoint(shapeEntity.getPx3A(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py3A  = calculateNewValueWidthStartingPoint(shapeEntity.getPy3A(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px4A  = calculateNewValueWidthStartingPoint(shapeEntity.getPx4A(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py4A  = calculateNewValueWidthStartingPoint(shapeEntity.getPy4A(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px5A  = calculateNewValueWidthStartingPoint(shapeEntity.getPx5A(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py5A  = calculateNewValueWidthStartingPoint(shapeEntity.getPy5A(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px6A  = calculateNewValueWidthStartingPoint(shapeEntity.getPx6A(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py6A  = calculateNewValueWidthStartingPoint(shapeEntity.getPy6A(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px7A  = calculateNewValueWidthStartingPoint(shapeEntity.getPx7A(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py7A = calculateNewValueWidthStartingPoint(shapeEntity.getPy7A(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px8A = calculateNewValueWidthStartingPoint(shapeEntity.getPx8A(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py8A  = calculateNewValueWidthStartingPoint(shapeEntity.getPy8A(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px1c  = calculateNewValueWidthStartingPoint(shapeEntity.getPx1c(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py1c  = calculateNewValueWidthStartingPoint(shapeEntity.getPy1c(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px2c  = calculateNewValueWidthStartingPoint(shapeEntity.getPx2c(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py2c  = calculateNewValueWidthStartingPoint(shapeEntity.getPy2c(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px3c  = calculateNewValueWidthStartingPoint(shapeEntity.getPx3c(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py3c  = calculateNewValueWidthStartingPoint(shapeEntity.getPy3c(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px4c  = calculateNewValueWidthStartingPoint(shapeEntity.getPx4c(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py4c  = calculateNewValueWidthStartingPoint(shapeEntity.getPy4c(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px5c  = calculateNewValueWidthStartingPoint(shapeEntity.getPx5c(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py5c  = calculateNewValueWidthStartingPoint(shapeEntity.getPy5c(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px6c  = calculateNewValueWidthStartingPoint(shapeEntity.getPx6c(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py6c  = calculateNewValueWidthStartingPoint(shapeEntity.getPy6c(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px7c  = calculateNewValueWidthStartingPoint(shapeEntity.getPx7c(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py7c  = calculateNewValueWidthStartingPoint(shapeEntity.getPy7c(), _starting_y,  _original_scale, _new_scale);
        shapeObject.px8c  = calculateNewValueWidthStartingPoint(shapeEntity.getPx8c(), _starting_x,  _original_scale, _new_scale);
        shapeObject.py8c  = calculateNewValueWidthStartingPoint(shapeEntity.getPy8c(), _starting_y,  _original_scale, _new_scale);

        if (!shapeObject.myFrame2.isSupplier) {
            shapeObject.supplierId = shapeEntity.getSupplierRemoteId();
            shapeObject.supplierSeriesId = shapeEntity.getSupplierRemoteId();
            shapeObject.remote = shapeEntity.isRemote();
        }

        /* Preparing profile parts */
        setProfilePartsObject(shapeEntity.getProfileBOMs(), shapeObject);

        /* Preparing parts objects */
        setProfileCollection(shapeObject, shapeEntity.getProfileCollection());

        /* Preparing myMullion objects */
        setMyMullionObjects(shapeObject, shapeEntity.getMyMullions());

        /* Preparing shape options */
        if (shapeEntity.getOptions() != null) {
            for (ShapeOptionEntityObject shapeOptionEntity : shapeEntity.getOptions()) {
                shapeObject.options.add(ShapeOptionDTO.getShapeOptionModel(shapeObject.myFrame2, shapeOptionEntity));

                //Adding design option to design option collection
                if (!shapeOptionEntity.isGlobal()) {
                    shapeObject.myFrame2.designOptionsAll.add(ShapeOptionDTO.getDesignOptionModel(shapeObject.myFrame2,
                            shapeOptionEntity));
                }
            }
        }

        /* Preparing Bill of Materials */
        if (shapeEntity.getBoms() != null) {
            for (BillOfMaterialEntityObject billOfMaterial : shapeEntity.getBoms()) {
                shapeObject.bom.add(BillOfMaterialDTO.getBuildOfMaterialModel(billOfMaterial));
            }
        }

        /* Preparing shape notes */
        if (shapeEntity.getNotes() != null) {
            for (ShapeNotesEntityObject shapeNotes : shapeEntity.getNotes()) {
                shapeObject.notes.add(ShapeNotesDTO.getShapeNotesModel(shapeNotes));
            }
        }

        return shapeObject;
    }

    /**
     * This method creates clone of ShapeAbstractObject implementation method
     *
     * @param shapeEntityObject, ShapeAbstractObject
     * @param clazz,             Class instance object to create
     * @return ShapeAbstractObject
     * @throws DTOTransformationError, Error
     */
    public static ShapeAbstractObject cloneShapeAbstractObject(ShapeAbstractObject shapeEntityObject, Class clazz) throws DTOTransformationError {

        if (shapeEntityObject == null) {
            throw new DTOTransformationError();
        }

        //Clone shape abstract object
        ShapeAbstractObject shapeObject = ShapeObjectBeanUtils.cloneBean(shapeEntityObject, clazz);

        //Clone profile collection
        Hibernate.initialize(shapeEntityObject.getProfileCollection());
        if (shapeEntityObject.getProfileCollection() != null && !shapeEntityObject.getProfileCollection().isEmpty()) {
            Set<ProfileCollectionObject> profileCollection = new HashSet<ProfileCollectionObject>();
            for (ProfileCollectionObject profile : shapeEntityObject.getProfileCollection()) {
                ProfileCollectionObject profileCollectionObject = (ProfileCollectionObject) ProfileDTO.
                        cloneProfileAbstractObject(profile, ProfileCollectionObject.class);
                profileCollectionObject.set_part_object(profile.get_part_object());

                profileCollection.add(profileCollectionObject);
            }
            shapeObject.setProfileCollection(profileCollection);
        }

        //Clone profile BOMs
        Hibernate.initialize(shapeEntityObject.getProfileBOMs());
        if (shapeEntityObject.getProfileBOMs() != null && !shapeEntityObject.getProfileBOMs().isEmpty()) {
            Set<ProfileEntityBOM> profileBOMs = new HashSet<ProfileEntityBOM>();
            for (ProfileEntityBOM profile : shapeEntityObject.getProfileBOMs()) {
                ProfileEntityBOM profileEntityBOM = (ProfileEntityBOM) ProfileDTO.cloneProfileAbstractObject(profile,
                        ProfileEntityBOM.class);
                profileBOMs.add(profileEntityBOM);
            }
            shapeObject.setProfileBOMs(profileBOMs);
        }

        //Clone shape options
        Hibernate.initialize(shapeEntityObject.getOptions());
        if (shapeEntityObject.getOptions() != null && !shapeEntityObject.getOptions().isEmpty()) {
            Set<ShapeOptionEntityObject> options = new HashSet<ShapeOptionEntityObject>();
            for (ShapeOptionEntityObject shapeOption : shapeEntityObject.getOptions()) {
                options.add(ShapeOptionBeanUtils.cloneBean(shapeOption));
            }
            shapeObject.setOptions(options);
        }

        return shapeObject;
    }

    //*****************************************************************************************************************
    // UTILITY METHODS
    //*****************************************************************************************************************

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
                divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).add(_starting_value) : value;

        return value.doubleValue();
    }
}
