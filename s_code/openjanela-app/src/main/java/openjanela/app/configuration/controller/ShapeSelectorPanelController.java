package openjanela.app.configuration.controller;

import Presentation.ItemFrame;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.partner.seriesValidShapesEAO.SeriesValidShapesEAO;
import openjanela.model.eao.partner.seriesValidShapesEAO.SeriesValidShapesPersistenceEAO;
import openjanela.model.entities.partner.SeriesValidShapes;
import openjanela.model.entities.partner.ValidShapes;
import org.openjanela.data.ApplicationBaseApp;
import org.openjanela.data.ApplicationBaseRulesApp;
import org.openjanela.data.ApplicationRemoteBaseRulesApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 08-28-12
 * Time: 02:27 PM
 */
public class ShapeSelectorPanelController extends BaseController {

    //Map of valid shapes by serie
    private Map<Integer, List<SeriesValidShapes>> validShapesSeriesMap;
    private Map<Integer, SeriesValidShapes> shapesMap;

    private Map<Integer, ValidShapes> validShapesMap;

    //Data Access Objects
    protected SeriesValidShapesEAO seriesValidShapesEAO;

    /**
     * Shape Selector Panel Controller
     */
    public ShapeSelectorPanelController() {
        validShapesSeriesMap = new HashMap<Integer, List<SeriesValidShapes>>();
        shapesMap = new HashMap<Integer, SeriesValidShapes>();

        validShapesMap = new HashMap<Integer, ValidShapes>();

        //Init data access object
        seriesValidShapesEAO = new SeriesValidShapesPersistenceEAO();

        //Init valid collections map
        initValidCollectionsMap();
    }

    /**
     * Init Valid Collections Map
     * <p>validShapes</p>
     */
    private void initValidCollectionsMap() {

        //Init valid shapes
        for (ValidShapes v : ValidShapes.values()) {
            validShapesMap.put(v.getValue(), v);
        }
    }

    /**
     * Get Valid Shapes for series Identification
     *
     * @param seriesId, Identification series
     * @return List<SeriesValidShapes>
     */
    public void findValidShapes(Integer seriesId) {

        //Get valid shapes from map
        List<SeriesValidShapes> validShapes = validShapesSeriesMap.get(seriesId);

        if (validShapes == null || validShapes.size() <= 0) {

            //Get valid shapes by series Id
            validShapes = new ArrayList<SeriesValidShapes>();
            validShapes.addAll(ApplicationBaseRulesApp.getInstance().getSeriesValidShapes());
            validShapes.addAll(ItemFrame.getApplicationRemoteBaseRules().getSeriesValidShapes());

            //Putting valid shapes to map record
            validShapesSeriesMap.put(seriesId, validShapes);
        }

        //Clear map list
        shapesMap.clear();

        //Putting valid shapes to map record
        for (SeriesValidShapes validShape : validShapes) {
            shapesMap.put(validShape.getId().getShapeId(), validShape);
        }

    }

    /**
     * Return valid shapes map
     *
     * @return Map<Integer, ValidShapes>
     */
    public Map<Integer, ValidShapes> getValidShapesMap() {
        return validShapesMap;
    }

    /**
     * Return valid shapes series
     *
     * @return Map<Integer, SeriesValidShapes>
     */
    public Map<Integer, SeriesValidShapes> getShapes() {
        return shapesMap;
    }

    /**
     * Return valid shape from its Id.
     *
     * @param shapesId, Integer
     * @return SeriesValidShapes
     */
    public SeriesValidShapes getValidShapes(Integer shapesId) {
        return shapesMap.get(shapesId);
    }

    /**
     * Return boolean if shapesMap contains valid shape indentification Id.
     *
     * @param shapeId, Integer
     * @return boolean
     */
    public boolean isContainsValidShapes(Integer shapeId) {
        return shapesMap.containsKey(shapeId);
    }
}
