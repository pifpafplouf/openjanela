package openjanela.model.eao.partner.partnerAddressEAO;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.partner.PartnerAddress;
import org.apache.log4j.Logger;

import javax.persistence.FlushModeType;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 07-25-12
 *          Time: 09:35 AM
 */
public class PartnerAddressPersistenceEAO extends GenericPersistenceEAO<PartnerAddress, Integer> implements PartnerAddressEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(PartnerAddressPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Rules Persistence Default Constructor
     */
    public PartnerAddressPersistenceEAO() {
        partnersEAO = new PartnersPersistenceEAO();
    }

    /**
     * This method init a remote persistence service
     *
     * @param supplierId, Supplier Identification Id
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    protected void initRemoteService(Integer supplierId) throws GenericPersistenceEAOException {


        try {

            //Search supplier remote values
            Partners supplier = partnersEAO.findById(supplierId);

            //Getting persistence service
            em = PersistenceManagementServiceRemoteFactory.getEntityManager(supplier);

            //Added to prevent Flushing
            em.setFlushMode(FlushModeType.AUTO);

            PersistenceManagementServiceRemoteFactory.beginTransaction();

        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }

    }

    /**
     * This method commit a remote persistence service
     *
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    protected void commitRemoteService() throws GenericPersistenceEAOException {
        try {
            PersistenceManagementServiceRemoteFactory.commit(true);
        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }

    /**
     * This method close a remote session service from entity access object
     *
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    protected void closeRemoteService() throws GenericPersistenceEAOException {
        try {
            PersistenceManagementServiceRemoteFactory.close();
        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }

    @Override
    public PartnerAddress findRemoteShipToAddress(Integer supplierId, Integer partnerId) throws GenericPersistenceEAOException {
        try {

            //Init Remote Service
            initRemoteService(supplierId);

            PartnerAddress address = (PartnerAddress)em.createQuery("select p from PartnerAddress p " +
                    "where p.deleted = false and p.isDefault = true and p.partnerId = :partnerId and p.shipTo = true").
                    setParameter("partnerId", partnerId).getSingleResult();

            return address;

        } finally {
            closeRemoteService();
        }
    }

    @Override
    public PartnerAddress findRemoteBillToAddress(Integer supplierId, Integer partnerId) throws GenericPersistenceEAOException {

        try {

            //Init Remote Service
            initRemoteService(supplierId);

            PartnerAddress address = (PartnerAddress)em.createQuery("select p from PartnerAddress p " +
                    "where p.deleted = false and p.isDefault = true and p.partnerId = :partnerId and p.billTo = true").
                    setParameter("partnerId", partnerId).getSingleResult();

            return address;

        } finally {
            closeRemoteService();
        }
    }

}
