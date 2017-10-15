package openjanela.model.eao.partner.partnerEAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import openjanela.model.PersistenceManagementServiceFactory;
import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServicePartnerFactory;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.PartnerDefault;
import openjanela.model.entities.partner.PartnerDefaultPK;

import org.apache.log4j.Logger;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-25-12
 *          Time: 02:27 PM
 */
public class PartnerDefaultPersistenceEAO extends GenericPersistenceEAO<PartnerDefault, PartnerDefaultPK> implements
        PartnerDefaultEAO {

    // Apache log4j
    private static final Logger logger = Logger.getLogger(PartnerDefaultPersistenceEAO.class);

    @Override
    public List<PartnerDefault> findDefaults(int partnerid) throws GenericPersistenceEAOException {

        try {

            // Init service
            initService();

            List<PartnerDefault> partners = new ArrayList();

            //Query String
            String hql = "from PartnerDefault where partnerDefaultPK.partnerid= :pid";

            Query query = em.createQuery(hql);
            query.setParameter("pid", partnerid);

            return partners;

        } finally {
            closeService();
        }
    }
}
