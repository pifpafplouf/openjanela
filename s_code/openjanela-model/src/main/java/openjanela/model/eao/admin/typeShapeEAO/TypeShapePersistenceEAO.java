package openjanela.model.eao.admin.typeShapeEAO;

import openjanela.model.PersistenceManagementServiceFactory;
import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.entities.admin.TypeShape;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public class TypeShapePersistenceEAO extends GenericPersistenceEAO<TypeShape, Integer> implements TypeShapeEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(TypeShapePersistenceEAO.class);

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
    public TypeShape getShape(int id) throws PersistenceClassNotFoundException, GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            TypeShape typeShape = (TypeShape) em.createQuery("select t from TypeShape t where t.id = :id").
                    setParameter("id", id).getSingleResult();

            if (typeShape == null) {
                throw new PersistenceClassNotFoundException(id);
            }

            return typeShape;

        } finally {
            //Close service
            closeService();
        }

    }

    @Override
    public List<TypeShape> findReadOnly() throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //Init Type Shapes
            final List<TypeShape> typeShapes = new ArrayList<TypeShape>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select * from type_shape order by id");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        TypeShape typeShape = new TypeShape();
                        typeShape.setId(rs.getInt("id"));
                        typeShape.setDescription(rs.getString("description"));
                        typeShape.setAbbrev(rs.getString("abbrev"));

                        typeShapes.add(typeShape);
                    }

                    rs.close();
                    pstmt.close();

                }
            });

            return typeShapes;

        } finally {
            closeService();
        }
    }

}
