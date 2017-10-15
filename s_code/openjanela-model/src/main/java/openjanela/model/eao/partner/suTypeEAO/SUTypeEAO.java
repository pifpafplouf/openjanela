package openjanela.model.eao.partner.suTypeEAO;

import java.sql.Timestamp;
import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.SUType;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-13-12
 *          Time: 04:29 PM
 */
public interface SUTypeEAO extends GenericEAO<SUType, Integer> {

    /**
     * Find SUType list for glazing type
     *
     * @param glazingType, Integer
     * @return List<SUType>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<SUType> findByGlazingType(Integer glazingType) throws GenericPersistenceEAOException;

    /**
     * Find SUType list for thickness selected and actual date
     *
     * @param unitOfMetric,  Unit of metric selected
     * @param fromThickness, from thickness value
     * @param toThickness,   to thickness value
     * @param actualDate,    Actual date selected
     * @return List<SUType>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<SUType> findByThickness(int unitOfMetric, Integer fromThickness, Integer toThickness, Timestamp actualDate)
            throws GenericPersistenceEAOException;
    
    /**
    * Find SUType by StockCode
    *
    * @param unitOfMetric,  Unit of metric selected
    * @param fromThickness, from thickness value
    * @param toThickness,   to thickness value
    * @param actualDate,    Actual date selected
    * @return List<SUType>
    * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
    *          Exception
    */
    public SUType findByStockCode(String stockCode)  throws GenericPersistenceEAOException;

    /**
     * Find SUType List Remote
     *
     * @param supplierId, Supplier Identification Id
     * @return List<SUType>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<SUType> findAllRemote(int supplierId) throws GenericPersistenceEAOException;
}
