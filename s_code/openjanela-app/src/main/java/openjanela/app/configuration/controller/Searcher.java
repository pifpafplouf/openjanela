package openjanela.app.configuration.controller;

import java.lang.reflect.Method;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 09-17-12
 * Time: 03:22 PM
 */
public interface Searcher<T> {

    /**
     * Check method for searching into Collection objects
     *
     * @param obj,          Class object
     * @param method,       Method of object class
     * @return boolean
     */
    public boolean check(T obj, Method method, Object value);
}
