package openjanela.app.configuration.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import openjanela.model.eao.admin.typeOpeningEAO.TypeOpeningEAO;
import openjanela.model.eao.admin.typeOpeningEAO.TypeOpeningPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.partner.seriesValidOpeningShapeEAO.SeriesValidOpeningShapeEAO;
import openjanela.model.eao.partner.seriesValidOpeningShapeEAO.SeriesValidOpeningShapePersistenceEAO;
import openjanela.model.entities.admin.TypeOpening;
import openjanela.model.entities.partner.SeriesValidOpeningShape;
import openjanela.model.entities.partner.ValidDoors;
import openjanela.model.entities.partner.ValidEntries;
import openjanela.model.entities.partner.ValidSashes;
import Presentation.ItemFrame;
import org.apache.log4j.Logger;
import org.openjanela.data.ApplicationBaseApp;
import org.openjanela.data.ApplicationBaseRulesApp;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 08-30-12
 *          Time: 09:37 AM
 */
public class OpeningSelectorPanelController extends BaseController {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(OpeningSelectorPanelController.class);

    private Map<Integer, SeriesValidOpeningShape> windowsMap;
    private Map<Integer, SeriesValidOpeningShape> doorsMap;
    private Map<Integer, SeriesValidOpeningShape> entranceMap;
    private Map<Integer, SeriesValidOpeningShape> standardMap;

    private Map<Integer, SeriesValidOpeningShape> validOpeningsMap;

    private Map<Integer, ValidSashes> validSashMap;
    private Map<Integer, ValidDoors> validDoorMap;
    private Map<Integer, ValidEntries> validEntryMap;

    private List<TypeOpening> typeOpenings;

    /**
     * Contructor OpeningSelectorPanelController
     */
    public OpeningSelectorPanelController() {

        //Init collections map
        windowsMap = new HashMap<Integer, SeriesValidOpeningShape>();
        doorsMap = new HashMap<Integer, SeriesValidOpeningShape>();
        entranceMap = new HashMap<Integer, SeriesValidOpeningShape>();
        standardMap = new HashMap<Integer, SeriesValidOpeningShape>();

        validOpeningsMap = new HashMap<Integer, SeriesValidOpeningShape>();

        validSashMap = new HashMap<Integer, ValidSashes>();
        validDoorMap = new HashMap<Integer, ValidDoors>();
        validEntryMap = new HashMap<Integer, ValidEntries>();

        typeOpenings = new ArrayList<TypeOpening>();

        //Init Valid Collections Map
        initValidCollectionsMap();
    }

    /**
     * Init Valid Collections Map
     * <p>validSashes</p>
     * <p>validDoors</p>
     * <p>validEntries</p>
     */
    private void initValidCollectionsMap() {

        //Init valid sashes
        for (ValidSashes v : ValidSashes.values()) {
            validSashMap.put(v.getValue(), v);
        }

        //Init valid doors
        for (ValidDoors v : ValidDoors.values()) {
            validDoorMap.put(v.getValue(), v);
        }

        //Init valid entries
        for (ValidEntries v : ValidEntries.values()) {
            validEntryMap.put(v.getValue(), v);
        }
    }

    /**
     * Get Valid Openings from series identification
     */
    public void findValidOpenings() {

        //Search series valid openings
        List<SeriesValidOpeningShape> seriesValidOpenings = new ArrayList<SeriesValidOpeningShape>();
        seriesValidOpenings.addAll(ItemFrame.getApplicationBaseRules().getSeriesValidOpeningShapes());
        seriesValidOpenings.addAll(ItemFrame.getApplicationRemoteBaseRules().getSeriesValidOpeningShapes());

        for (SeriesValidOpeningShape validOpening : seriesValidOpenings) {
            if (validOpening.isWindow()) {
                windowsMap.put(validOpening.getSeriesValidOpeningPK().getId(), validOpening);
            } else if (validOpening.isDoor()) {
                doorsMap.put(validOpening.getSeriesValidOpeningPK().getId(), validOpening);
            } else if (validOpening.isEntrance()) {
                entranceMap.put(validOpening.getSeriesValidOpeningPK().getId(), validOpening);
            } else if (validOpening.isStandard()) {
                standardMap.put(validOpening.getSeriesValidOpeningPK().getId(), validOpening);
            }

            validOpeningsMap.put(validOpening.getSeriesValidOpeningPK().getId(), validOpening);
        }

        //Search type openings
        if (typeOpenings.isEmpty()) {
            typeOpenings = ItemFrame.getApplicationBase().getTypeOpenings();
        }
    }

    public Map<Integer, SeriesValidOpeningShape> getWindowsMap() {
        return windowsMap;
    }

    public Map<Integer, SeriesValidOpeningShape> getDoorsMap() {
        return doorsMap;
    }

    public Map<Integer, SeriesValidOpeningShape> getEntranceMap() {
        return entranceMap;
    }

    public Map<Integer, SeriesValidOpeningShape> getStandardMap() {
        return standardMap;
    }

    public List<TypeOpening> getTypeOpenings() {
        return typeOpenings;
    }

    /**
     * Return a valid opening shape for an Opening Identification Id
     *
     * @param openingId,  Opening Identification Id
     * @param isWindow,   Is Window
     * @param isDoor,     Is Door
     * @param isEntrance, Is Entrance
     * @param isStandard, Is Standard
     * @return List
     */
    public List<SeriesValidOpeningShape> getValidOpeningShape(Integer openingId, boolean isWindow, boolean isDoor,
                                                              boolean isEntrance, boolean isStandard) {

        //Series Valid Openings
        List<SeriesValidOpeningShape> seriesValidOpenings = new ArrayList<SeriesValidOpeningShape>();

        if (isWindow) {
            for (Map.Entry<Integer, SeriesValidOpeningShape> entry : windowsMap.entrySet()) {
                SeriesValidOpeningShape validOpening = entry.getValue();
                if (validOpening.getSeriesValidOpeningPK().getOpeningId().intValue() == openingId.intValue()) {
                    seriesValidOpenings.add(validOpening);
                }
            }
        }

        if (isDoor) {
            for (Map.Entry<Integer, SeriesValidOpeningShape> entry : doorsMap.entrySet()) {
                SeriesValidOpeningShape validOpening = entry.getValue();
                if (validOpening.getSeriesValidOpeningPK().getOpeningId().intValue() == openingId.intValue()) {
                    seriesValidOpenings.add(validOpening);
                }
            }
        }

        if (isEntrance) {
            for (Map.Entry<Integer, SeriesValidOpeningShape> entry : entranceMap.entrySet()) {
                SeriesValidOpeningShape validOpening = entry.getValue();
                if (validOpening.getSeriesValidOpeningPK().getOpeningId().intValue() == openingId.intValue()) {
                    seriesValidOpenings.add(validOpening);
                }
            }
        }

        if (isStandard) {
            for (Map.Entry<Integer, SeriesValidOpeningShape> entry : standardMap.entrySet()) {
                SeriesValidOpeningShape validOpening = entry.getValue();
                if (validOpening.getSeriesValidOpeningPK().getOpeningId().intValue() == openingId.intValue()) {
                    seriesValidOpenings.add(validOpening);
                }
            }
        }

        return seriesValidOpenings;
    }

    /**
     * Return boolean if openingsMap contains valid opening indentification Id.
     *
     * @param openingClassType, Integer
     * @return boolean
     */
    public boolean isContainsValidOpenings(Integer openingClassType) {

        //Return type openings
        List<TypeOpening> typeOpenings = ApplicationBaseApp.getInstance().getTypeOpenings(openingClassType);

        for (Map.Entry<Integer, SeriesValidOpeningShape> entry : validOpeningsMap.entrySet()) {
            SeriesValidOpeningShape validOpening = entry.getValue();

            for (TypeOpening typeOpening : typeOpenings) {
                if (validOpening.getSeriesValidOpeningPK().getOpeningId().intValue() == typeOpening.getId()) {

                    //**********************************************************
                    //Adding type openings to collection
                    //**********************************************************
                    boolean found = false;
                    for (TypeOpening tp : this.typeOpenings) {
                        if (tp.getId() == typeOpening.getId()) {
                            found = true;
                        }
                    }

                    if (!found) {
                        this.typeOpenings.add(typeOpening);
                    }

                    return true;
                }
            }
        }

        return false;
    }
}
