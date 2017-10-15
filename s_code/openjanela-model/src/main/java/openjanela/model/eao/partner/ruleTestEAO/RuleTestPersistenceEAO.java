package openjanela.model.eao.partner.ruleTestEAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.FlushModeType;
import javax.persistence.Query;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.partner.RuleTest;

import openjanela.model.entities.partner.RuleTestPK;
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
public class RuleTestPersistenceEAO extends GenericPersistenceEAO<RuleTest, Integer> implements RuleTestEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(RuleTestPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Rule Test Persistence Constructor
     */
    public RuleTestPersistenceEAO() {
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
    public List<RuleTest> findAllByRuleBySeries(int ruleNo, int seriesId) throws GenericPersistenceEAOException {

        try {

            // Init service
            initService();

            Query query = em.createQuery("select r from RuleTest r where r.ruleTestPK.ruleno = :ruleNo " +
                    "and r.ruleTestPK.seriesid = :seriesId");
            query.setParameter("ruleNo", ruleNo);
            query.setParameter("seriesId", seriesId);

            List<RuleTest> tests = query.getResultList();

            return tests;

        } finally {
            closeService();
        }
    }

    @Override
    public List<RuleTest> findAllBySeries(int seriesId) throws GenericPersistenceEAOException {
        try {

            // Init remote service
            initService();

            final int param_series_id = seriesId;

            //Rule Test Collection
            final List<RuleTest> tests = new ArrayList<RuleTest>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select r.* from rule_test r where r.seriesid = ? order by r.testid");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_series_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        RuleTestPK ruleTestPK = new RuleTestPK();
                        ruleTestPK.setRuleno(rs.getInt("ruleno"));
                        ruleTestPK.setTestid(rs.getInt("testid"));
                        ruleTestPK.setSeriesid(rs.getInt("seriesid"));

                        RuleTest ruleTest = new RuleTest();
                        ruleTest.setRuleTestPK(ruleTestPK);

                        ruleTest.setAndor(rs.getBoolean("andor"));
                        ruleTest.setIsnot(rs.getBoolean("isnot"));
                        ruleTest.setType(rs.getInt("type"));
                        ruleTest.setIsrange(rs.getBoolean("isrange"));
                        ruleTest.setValue1(rs.getDouble("value1"));
                        ruleTest.setValue1i(rs.getDouble("value1i"));
                        ruleTest.setValue2(rs.getDouble("value2"));
                        ruleTest.setValue2i(rs.getDouble("value2i"));
                        ruleTest.setStartdate(rs.getDate("startdate"));
                        ruleTest.setEnddate(rs.getDate("enddate"));
                        ruleTest.setNext(rs.getInt("next"));
                        ruleTest.setDescription(rs.getString("description"));
                        ruleTest.setStartGroup(rs.getInt("startgroup"));
                        tests.add(ruleTest);
                    }

                    rs.close();
                    pstmt.close();
                }
            });

            return tests;

        } finally {
            closeService();
        }
    }

    @Override
    public List<RuleTest> findAllRemoteBySeries(int seriesId, int supplierId) throws GenericPersistenceEAOException {
        try {

            // Init remote service
            initRemoteService(supplierId);

            final int param_series_id = seriesId;

            //Rule Test Collection
            final List<RuleTest> tests = new ArrayList<RuleTest>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select r.* from rule_test r where r.seriesid = ? order by r.testid");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_series_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        RuleTestPK ruleTestPK = new RuleTestPK();
                        ruleTestPK.setRuleno(rs.getInt("ruleno"));
                        ruleTestPK.setTestid(rs.getInt("testid"));
                        ruleTestPK.setSeriesid(rs.getInt("seriesid"));

                        RuleTest ruleTest = new RuleTest();
                        ruleTest.setRuleTestPK(ruleTestPK);

                        ruleTest.setAndor(rs.getBoolean("andor"));
                        ruleTest.setIsnot(rs.getBoolean("isnot"));
                        ruleTest.setType(rs.getInt("type"));
                        ruleTest.setIsrange(rs.getBoolean("isrange"));
                        ruleTest.setValue1(rs.getDouble("value1"));
                        ruleTest.setValue1i(rs.getDouble("value1i"));
                        ruleTest.setValue2(rs.getDouble("value2"));
                        ruleTest.setValue2i(rs.getDouble("value2i"));
                        ruleTest.setStartdate(rs.getDate("startdate"));
                        ruleTest.setEnddate(rs.getDate("enddate"));
                        ruleTest.setNext(rs.getInt("next"));
                        ruleTest.setDescription(rs.getString("description"));
                        ruleTest.setStartGroup(rs.getInt("startgroup"));
                        tests.add(ruleTest);
                    }

                    rs.close();
                    pstmt.close();
                }
            });

            return tests;

        } finally {
            closeRemoteService();
        }
    }


}
