package openjanela.model.eao.design.assemblyStationUsageEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.AssemblyStationUsage;
import openjanela.model.entities.design.AssemblyStationUsagePK;

import java.util.Date;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-30-13
 *          Time: 10:33 PM
 */
public interface AssemblyStationUsageEAO extends GenericEAO<AssemblyStationUsage, AssemblyStationUsagePK> {

    /**
     * Return Capacity Usage
     *
     * @param scheduleDate,   Capacity Schedule Date
     * @param shift,          Production Line Shift
     * @param prodLine,       Production Line
     * @param prodLineParent, Production Line Parent
     * @param station,        Production Station
     * @return int
     * @throws GenericPersistenceEAOException, Exception
     */
    public int getCapacityUsage(Date scheduleDate, int shift, int prodLine, int prodLineParent, int station) throws GenericPersistenceEAOException;

    /**
     * Delete Assembly Station Usage
     *
     * @param orderID, Order Identification Id
     * @throws GenericPersistenceEAOException, Exception
     */
    public void deleteAssemblyStationUsage(int orderID) throws GenericPersistenceEAOException;

}
