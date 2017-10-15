package openjanela.model.eao.admin.typeOpeningEAO;

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
import openjanela.model.eao.partner.partnerEAO.PartnerPersistenceEAO;
import openjanela.model.entities.admin.TypeOpening;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public class TypeOpeningPersistenceEAO extends GenericPersistenceEAO<TypeOpening, Integer> implements TypeOpeningEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(PartnerPersistenceEAO.class);

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
    public List<TypeOpening> findAllOpenings() throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //Init Type Shapes
            final List<TypeOpening> typeOpenings = new ArrayList<TypeOpening>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select * from type_opening order by id");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        TypeOpening typeOpening = new TypeOpening();
                        typeOpening.setId(rs.getInt("id"));
                        typeOpening.setDescription(rs.getString("description"));
                        typeOpening.setAbbrev(rs.getString("abbrev"));
                        typeOpening.setPicture(rs.getBoolean("picture"));
                        typeOpening.setOutswing(rs.getBoolean("outswing"));
                        typeOpening.setInswing(rs.getBoolean("inswing"));
                        typeOpening.setSslider(rs.getBoolean("sslider"));
                        typeOpening.setDslider(rs.getBoolean("dslider"));
                        typeOpening.setNslider(rs.getBoolean("nslider"));
                        typeOpening.setFolding(rs.getBoolean("folding"));
                        typeOpening.setTransom(rs.getBoolean("transom"));
                        typeOpening.setSidelight(rs.getBoolean("sidelight"));
                        typeOpening.setKickpanel(rs.getBoolean("kickpanel"));
                        typeOpening.setPocket(rs.getBoolean("pocket"));
                        typeOpening.setPivot(rs.getBoolean("pivot"));
                        typeOpening.setLouvered(rs.getBoolean("louvered"));
                        typeOpening.setWindow(rs.getBoolean("window"));
                        typeOpening.setDoor(rs.getBoolean("door"));
                        typeOpening.setEntrance(rs.getBoolean("entrance"));
                        typeOpening.setStandard(rs.getBoolean("standard"));

                        typeOpenings.add(typeOpening);
                    }

                    rs.close();
                    pstmt.close();

                }
            });

            return typeOpenings;

        } finally {
            closeService();
        }
    }
}
