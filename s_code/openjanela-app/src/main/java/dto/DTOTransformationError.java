package dto;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * <p/>
 * This class represents a serious error execution problem in transforming objects to model
 * <p/>
 * User: EMontenegro
 * Date: 04-12-12
 * Time: 12:01 AM
 */
public class DTOTransformationError extends Error {

    /**
     * This method construct a default instance of Error class
     */
    public DTOTransformationError() {
        super("Error trying to perform the request operation.");
    }

    /**
     * This method construct a Error class with a message information
     *
     * @param msg, Error message
     */
    public DTOTransformationError(String msg) {
        super(msg);
    }

    /**
     * This method construct a Error class with a message information and throwable cause
     *
     * @param msg,   Error message
     * @param cause, Throwable cause error
     */
    public DTOTransformationError(String msg, Throwable cause) {
        super(msg, cause);
    }
}
