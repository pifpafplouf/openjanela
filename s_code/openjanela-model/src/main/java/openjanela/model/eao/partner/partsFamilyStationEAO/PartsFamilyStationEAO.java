package openjanela.model.eao.partner.partsFamilyStationEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.parts.PartFamilyStation;
import openjanela.model.entities.parts.PartFamilyStationPK;

import java.util.List;

/**
 * Copyright (c) 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 10/24/13
 *          Time: 1:01 AM
 */
public interface PartsFamilyStationEAO extends GenericEAO<PartFamilyStation, PartFamilyStationPK> {

    /**
     * Find All Remote Parts Family Station
     *
     * @param supplierId, Supplier Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<PartFamilyStation> findAllRemote(int supplierId) throws GenericPersistenceEAOException;
}
