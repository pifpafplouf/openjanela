package openjanela.app.configuration.controller;

import openjanela.model.entities.partner.SUType;

import java.lang.reflect.Method;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 09-17-12
 * Time: 03:23 PM
 */
public class SUTypeSearcher implements Searcher<SUType> {

    @Override
    public boolean check(SUType obj, Method method, Object value) {
        return true;
    }
}
