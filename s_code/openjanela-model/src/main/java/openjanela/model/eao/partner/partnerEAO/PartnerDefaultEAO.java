package openjanela.model.eao.partner.partnerEAO;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.PartnerDefault;
import openjanela.model.entities.partner.PartnerDefaultPK;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-25-12
 *          Time: 02:27 PM
 */
public interface PartnerDefaultEAO extends GenericEAO<PartnerDefault, PartnerDefaultPK> {

    /**
     * Return partner defaults by partner Id
     *
     * @param id, Partner Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<PartnerDefault> findDefaults(int id) throws GenericPersistenceEAOException;

}
