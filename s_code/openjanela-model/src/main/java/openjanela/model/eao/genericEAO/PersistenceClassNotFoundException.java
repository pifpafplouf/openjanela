package openjanela.model.eao.genericEAO;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-05-2010
 *          Time: 10:38:13 PM
 */
public class PersistenceClassNotFoundException extends GenericPersistenceEAOException {

    /**
     * Create a persistence class not found exception
     *
     * @param id, Identification search
     */
    public PersistenceClassNotFoundException(Integer id) {
        super("Entity not found with identifier [" + id + "].");
    }

    /**
     * Create a persistence class not found exception
     *
     * @param criteria, Search criteria
     */
    public PersistenceClassNotFoundException(String criteria) {
        super("Entity not found with [" + criteria + "].");
    }

    /**
     * Create a persistence class not found exception
     *
     * @param message, Error message
     * @param cause,   Throwable cause
     */
    public PersistenceClassNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
