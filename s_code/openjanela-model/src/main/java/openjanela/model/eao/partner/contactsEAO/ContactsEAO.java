package openjanela.model.eao.partner.contactsEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.Contacts;
import openjanela.model.entities.partner.ContactsPK;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 07-25-12
 *          Time: 09:35 AM
 */
public interface ContactsEAO extends GenericEAO<Contacts, ContactsPK> {

    /**
     * Find Remote Contact for Partner
     *
     * @param supplierId, Supplier Identification Id
     * @param partnerId,  Partner Identification Id
     * @return Contacts
     * @throws GenericPersistenceEAOException, Exception
     */
    public Contacts findRemoteDefaultContact(Integer supplierId, Integer partnerId) throws GenericPersistenceEAOException;
}
