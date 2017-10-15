package openjanela.model.eao.admin.typePriceCategoryEAO;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.TypePriceCategory;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-21-12
 *          Time: 08:27 AM
 */
public interface TypePriceCategoryEAO extends GenericEAO<TypePriceCategory, Integer> {

    /**
     * Find price categories
     *
     * @return List<TypePriceCategory>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<TypePriceCategory> findTypePriceCategory() throws GenericPersistenceEAOException;
}
