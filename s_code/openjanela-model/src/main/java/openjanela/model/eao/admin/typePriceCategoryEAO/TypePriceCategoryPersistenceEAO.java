package openjanela.model.eao.admin.typePriceCategoryEAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import openjanela.model.PersistenceManagementServiceFactory;
import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.TypePriceCategory;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-21-12
 *          Time: 08:27 AM
 */
public class TypePriceCategoryPersistenceEAO extends GenericPersistenceEAO<TypePriceCategory, Integer> implements TypePriceCategoryEAO {

    // Apache log4j
    private static final Logger logger = Logger.getLogger(TypePriceCategoryPersistenceEAO.class);

    /**
     * Init persistence service
     *
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
     *          , Exception
     */
    @Override
    protected void initService() throws GenericPersistenceEAOException {

        try {

            // Getting persistence service
            em = PersistenceManagementServiceFactory.getEntityManager();
            PersistenceManagementServiceFactory.beginTransaction();

        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }

    /**
     * Commit service
     *
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException , Exception
     */
    @Override
    protected void commitService() throws GenericPersistenceEAOException {
        try {
            PersistenceManagementServiceFactory.commit(true);
        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }

    /**
     * This method close session service from entity access objects
     *
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    protected void closeService() throws GenericPersistenceEAOException {
        try {
            PersistenceManagementServiceFactory.close();
        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }

    @Override
    public List<TypePriceCategory> findTypePriceCategory() throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //Init Type Shapes
            final List<TypePriceCategory> typePriceCategories = new ArrayList<TypePriceCategory>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select * from type_price_category order by id");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        TypePriceCategory typeShape = new TypePriceCategory();
                        typeShape.setId(rs.getInt("id"));
                        typeShape.setDescription(rs.getString("description"));

                        typePriceCategories.add(typeShape);
                    }

                    rs.close();
                    pstmt.close();

                }
            });

            return typePriceCategories;

        } finally {
            closeService();
        }
    }

}
