package openjanela.model.eao.admin.typeLevelEAO;

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
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.entities.admin.TypeLevel;

import openjanela.model.entities.admin.TypeLevelPK;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import javax.persistence.NoResultException;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-11-12
 *          Time: 03:01 PM
 */
public class TypeLevelPersistenceEAO extends GenericPersistenceEAO<TypeLevel, TypeLevelPK> implements TypeLevelEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(TypeLevelPersistenceEAO.class);

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
    public TypeLevel getLevel(int id) throws PersistenceClassNotFoundException, GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            // Query string
            TypeLevel typeLevel = (TypeLevel) em.createQuery("select t from TypeLevel t where t.typeLevelPK.id = :id").
                    setParameter("id", id).getSingleResult();

            return typeLevel;

        } catch (NoResultException e) {
            throw new PersistenceClassNotFoundException(id);
        } finally {
            //Close service
            closeService();
        }
    }

    @Override
    public List<TypeLevel> getAllLevels() throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //Init Type Shapes
            final List<TypeLevel> typeLevels = new ArrayList<TypeLevel>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select * from type_level order by id");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        TypeLevelPK typeLevelPK = new TypeLevelPK();
                        typeLevelPK.setId(rs.getInt("id"));
                        typeLevelPK.setLevelId(rs.getInt("level_id"));

                        TypeLevel typeLevel = new TypeLevel();
                        typeLevel.setTypeLevelPK(typeLevelPK);
                        typeLevel.setDescription(rs.getString("description"));
                        typeLevel.setSeriesType(rs.getInt("seriestype"));

                        typeLevels.add(typeLevel);
                    }

                    rs.close();
                    pstmt.close();

                }
            });

            return typeLevels;

        } finally {
            closeService();
        }
    }

}
