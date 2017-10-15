package openjanela.model;

/**
 * Persistence Management Service exception
 *
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 08-08-2010
 * Time: 01:46:33 AM
 */
public class PersistenceManagementServiceFactoryException extends Exception {

    /**
     * Error message for factory service
     * @param message, error message description
     */
    public PersistenceManagementServiceFactoryException(String message) {
        super("Error trying to init persistence service: " + message);
    }

    /**
     * Error message for factory service
     * @param message, error message description
     * @param cause, error cause
     */
    public PersistenceManagementServiceFactoryException(String message, Throwable cause) {
        super("Error trying to init persistence service: " + message, cause);
    }

    /**
     * Error message for factory service
     * @param cause, error cause
     */
    public PersistenceManagementServiceFactoryException(Throwable cause) {
        super(cause);
    }
}
