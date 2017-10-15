
package openjanela.model.eao.partner.gridsEAO;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.partner.Grids;
import org.apache.log4j.Logger;

import javax.persistence.FlushModeType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public class GridsPersistenceEAO extends GenericPersistenceEAO<Grids, Integer> implements GridsEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(GridsPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Grids Persistence Default Constructor
     */
    public GridsPersistenceEAO() {
        this.partnersEAO = new PartnersPersistenceEAO();
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
    public List<Integer> findAllMatrix() throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            //Get Collection of Grids
            List<Grids> grids = em.createQuery("select g from Grids g").getResultList();

            Set<Integer> matrixIds = new HashSet<Integer>();
            for (Grids grid : grids) {

                if (grid.getPartidMatrix() > 0) {
                    matrixIds.add(grid.getPartidMatrix());
                }

                if (grid.getPartidSimMatrix() > 0) {
                    matrixIds.add(grid.getPartidSimMatrix());
                }
            }

            List<Integer> ids = new ArrayList<Integer>();
            ids.addAll(matrixIds);

            return ids;

        } finally {
            closeService();
        }
    }

    @Override
    public List<Integer> findAllRemoteMatrix(int supplierId) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initRemoteService(supplierId);

            //Get Collection of Grids
            List<Grids> grids = em.createQuery("select g from Grids g").getResultList();

            Set<Integer> matrixIds = new HashSet<Integer>();
            for (Grids grid : grids) {

                if (grid.getPartidMatrix() > 0) {
                    matrixIds.add(grid.getPartidMatrix());
                }

                if (grid.getPartidSimMatrix() > 0) {
                    matrixIds.add(grid.getPartidSimMatrix());
                }
            }

            List<Integer> ids = new ArrayList<Integer>();
            ids.addAll(matrixIds);

            return ids;

        } finally {
            closeService();
        }
    }

    @Override
    public List<Grids> findAllRemote(int supplierId) throws GenericPersistenceEAOException {
        try {

            //Init Remote service
            initRemoteService(supplierId);

            return em.createQuery("select g from Grids g order by g.id").getResultList();

        } finally {
            closeRemoteService();
        }
    }
}
