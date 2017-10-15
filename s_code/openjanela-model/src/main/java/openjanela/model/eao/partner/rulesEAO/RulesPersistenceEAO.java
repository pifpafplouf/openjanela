package openjanela.model.eao.partner.rulesEAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import openjanela.model.PersistenceConfigProperties;
import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServicePartnerFactory;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.partner.Rules;

import openjanela.model.entities.partner.RulesPK;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.openjanela.commons.util.security.Security;

import javax.persistence.FlushModeType;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public class RulesPersistenceEAO extends GenericPersistenceEAO<Rules, Integer> implements RulesEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(RulesPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Rules Persistence Default Constructor
     */
    public RulesPersistenceEAO () {
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
    public List<Rules> findAllOptionRulesbySeries(Integer seriesId) throws GenericPersistenceEAOException {

        try {

            // Init service
            initService();

            //Create Query
            List<Rules> rules = em.createQuery("select r from Rules r where r.ruletype >= 1 and r.ruletype <= 3 and " +
                    "r.rulesPK.seriesId = :seriesId order by r.rulesPK.id").setParameter("seriesId", seriesId).getResultList();

            return rules;

        } finally {
            //Close service
            closeService();
        }
    }

    @Override
    public List<Rules> findAllRulesbySeries(Integer seriesId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final int param_series_id = seriesId;

            final List<Rules> rules = new ArrayList<Rules>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select r.* from rules r where r.series_id = ? ");
                    query.append("order by r.id");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_series_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        RulesPK rulePK = new RulesPK();
                        rulePK.setId(rs.getInt("id"));
                        rulePK.setSeriesId(rs.getInt("series_id"));

                        Rules rule = new Rules();
                        rule.setRulesPK(rulePK);
                        rule.setDescription(rs.getString("description"));
                        rule.setLevel(rs.getInt("level"));
                        rule.setParentLevel(rs.getInt("parent_level"));
                        rule.setRuletype(rs.getInt("ruletype"));
                        rule.setRulevalue(rs.getInt("rulevalue"));
                        rule.setLeftside(rs.getInt("leftside"));
                        rule.setRightside(rs.getInt("rightside"));
                        rule.setAffectsdesign(rs.getBoolean("affectsdesign"));
                        rule.setPosition(rs.getInt("position"));
                        rule.setRcondition(rs.getInt("rcondition"));
                        rule.setQuantitytype(rs.getInt("quantitytype"));
                        rule.setQtyvalue(rs.getInt("qtyvalue"));
                        rule.setSizeadjustwtype(rs.getInt("sizeadjustwtype"));
                        rule.setSizeadjustw(rs.getInt("sizeadjustw"));
                        rule.setSizeadjustwi(rs.getInt("sizeadjustwi"));
                        rule.setSizeadjusthtype(rs.getInt("sizeadjusthtype"));
                        rule.setSizeadjusth(rs.getInt("sizeadjusth"));
                        rule.setSizeadjusthi(rs.getInt("sizeadjusthi"));
                        rule.setTest(rs.getBoolean("test"));
                        rule.setRulevalue2(rs.getString("rulevalue2"));
                        rule.setAnswerismatrix(rs.getBoolean("answerismatrix"));
                        rule.setStartdate(rs.getTimestamp("startdate"));
                        rule.setEnddate(rs.getTimestamp("enddate"));
                        rule.setAllowedanswer(rs.getBoolean("allowedanswer"));
                        rule.setRecalc(rs.getBoolean("recalc"));
                        rule.setWeldedl(rs.getBoolean("weldedl"));
                        rule.setWeldedr(rs.getBoolean("weldedr"));
                        rule.setRulevaluei(rs.getInt("rulevaluei"));
                        rule.setNominal(rs.getBoolean("nominal"));
                        rule.setAssemblyid(rs.getInt("assemblyid"));
                        rule.setP1(rs.getInt("p1"));
                        rule.setP2(rs.getInt("p2"));
                        rule.setP3(rs.getInt("p3"));
                        rule.setP4(rs.getInt("p4"));
                        rule.setP5(rs.getInt("p5"));
                        rule.setP6(rs.getInt("p6"));
                        rule.setP7(rs.getInt("p7"));
                        rule.setP8(rs.getInt("p8"));
                        rule.setP9(rs.getInt("p9"));
                        rule.setP10(rs.getInt("p10"));
                        rule.setP11(rs.getInt("p11"));
                        rule.setP12(rs.getInt("p12"));
                        rule.setP13(rs.getInt("p13"));
                        rule.setP14(rs.getInt("p14"));
                        rule.setP15(rs.getInt("p15"));
                        rule.setP16(rs.getInt("p16"));
                        rule.setP17(rs.getInt("p17"));
                        rule.setP18(rs.getInt("p18"));
                        rule.setP19(rs.getInt("p19"));
                        rule.setP20(rs.getInt("p20"));
                        rule.setP21(rs.getInt("p21"));
                        rule.setP22(rs.getInt("p22"));
                        rule.setTreeid(rs.getInt("treeid"));
                        rule.setQtyexpression(rs.getString("qtyexpression"));
                        rule.setAdjwexpression(rs.getString("adjwexpression"));
                        rule.setAdjhexpression(rs.getString("adjhexpression"));
                        rule.setQtyexpressioni(rs.getString("qtyexpressioni"));
                        rule.setAdjwexpressioni(rs.getString("adjwexpressioni"));
                        rule.setAdjhexpressioni(rs.getString("adjhexpressioni"));
                        rule.setGlobalOption(rs.getBoolean("global_option"));

                        rules.add(rule);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return rules;

        } finally {
            //Close service
            closeService();
        }
    }

    @Override
    public List<Integer> findAllSeriesSegments(Integer seriesId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //Query String
            List<Integer> seriesSegments = em.createQuery("select distinct(r.rulevalue) from Rules r " +
                    "where r.rulesPK.seriesId = :seriesId and r.ruletype in (3, 9) order by r.rulevalue").
                    setParameter("seriesId", seriesId).getResultList();

            return seriesSegments;

        } finally {
            //Close Service;
            closeService();
        }
    }

    @Override
    public List<Integer> findMatrixIdsBySeries(String seriesId) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final String param_series_id = seriesId;

            final List<Integer> matrixIds = new ArrayList<Integer>();

            if (seriesId.length() <= 0) {
                return matrixIds;
            }

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select r.ruletype, r.rulevalue, r.rulevalue2, ");
                    query.append("r.quantitytype, r.qtyvalue, r.sizeadjustwtype, r.sizeadjusthtype, r.sizeadjustw, r.sizeadjusth ");
                    query.append("from rules r ");
                    query.append("where r.series_id in ( " + param_series_id + ") and ");
                    query.append("(r.ruletype in (5, 7, 8) or (r.answerismatrix = 1 and r.ruletype in (1, 2))) ");
                    query.append("or ((r.quantitytype = 2 or r.sizeadjustwtype = 2 or r.sizeadjusthtype = 2))");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {

                        int ruletype = rs.getInt(1);
                        int rulevalue = rs.getInt(2);
                        int rulevalue2 = rs.getInt(3);
                        int qtytype = rs.getInt(4);
                        int qtyvalue = rs.getInt(5);
                        int adjustwtype = rs.getInt(6);
                        int adjusthtype = rs.getInt(7);
                        int sizeadjustw = rs.getInt(8);
                        int sizeadjusth = rs.getInt(9);

                        if (ruletype == 1 || ruletype == 2) {
                            matrixIds.add(rulevalue2);
                        }

                        if (ruletype == 5 || ruletype == 7 || ruletype == 8) {
                            matrixIds.add(rulevalue);
                        }

                        if (qtytype == 2) {
                            matrixIds.add(qtyvalue);
                        }

                        if (adjustwtype == 2) {
                            matrixIds.add(sizeadjustw);
                        }

                        if (adjusthtype == 2) {
                            matrixIds.add(sizeadjusth);
                        }
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return matrixIds;

        } finally {
            closeService();
        }
    }

    @Override
    public List<Integer> findPartsCostPriceMatrixIdsBySeries(String seriesId) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final String param_series_id = seriesId;

            final List<Integer> matrixIds = new ArrayList<Integer>();

            if (seriesId.length() <= 0) {
                return matrixIds;
            }

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select p.cost_matrix, p.price_matrix ");
                    query.append("from rules r inner join parts p on r.rulevalue = p.id ");
                    query.append("where r.series_id in ( " + param_series_id + ") and ");
                    query.append("r.ruletype = 6 and (p.cost_matrix > 0 || p.price_matrix > 0) ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {

                        int cost_matrix = rs.getInt(1);
                        int price_matrix = rs.getInt(2);

                        if (cost_matrix > 0) {
                            matrixIds.add(cost_matrix);
                        }

                        if (price_matrix > 0) {
                            matrixIds.add(price_matrix);
                        }
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return matrixIds;

        } finally {
            closeService();
        }
    }

    @Override
    public List<Integer> findRemotePartsCostPriceMatrixIdsBySeries(String seriesId, Integer supplierId) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initRemoteService(supplierId);

            final String param_series_id = seriesId;

            final List<Integer> matrixIds = new ArrayList<Integer>();

            if (seriesId.length() <= 0) {
                return matrixIds;
            }

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select p.cost_matrix, p.price_matrix ");
                    query.append("from rules r inner join parts p on r.rulevalue = p.id ");
                    query.append("where r.series_id in ( " + param_series_id + ") and ");
                    query.append("r.ruletype = 6 and (p.cost_matrix > 0 || p.price_matrix > 0) ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {

                        int cost_matrix = rs.getInt(1);
                        int price_matrix = rs.getInt(2);

                        if (cost_matrix > 0) {
                            matrixIds.add(cost_matrix);
                        }

                        if (price_matrix > 0) {
                            matrixIds.add(price_matrix);
                        }
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return matrixIds;

        } finally {
            closeRemoteService();
        }
    }

    @Override
    public List<Integer> findRemoteMatrixIdsBySeries(String seriesId, Integer supplierId) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initRemoteService(supplierId);

            final String param_series_id = seriesId;

            final List<Integer> matrixIds = new ArrayList<Integer>();

            if (seriesId.length() <= 0) {
                return matrixIds;
            }

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select r.ruletype, r.rulevalue, r.rulevalue2, ");
                    query.append("r.quantitytype, r.qtyvalue, r.sizeadjustwtype, r.sizeadjusthtype, r.sizeadjustw, r.sizeadjusth ");
                    query.append("from rules r ");
                    query.append("where r.series_id in ( " + param_series_id + ") and ");
                    query.append("(r.ruletype in (5, 7, 8) or (r.answerismatrix = 1 and r.ruletype in (1, 2))) ");
                    query.append("or ((r.quantitytype = 2 or r.sizeadjustwtype = 2 or r.sizeadjusthtype = 2))");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {

                        int ruletype = rs.getInt(1);
                        int rulevalue = rs.getInt(2);
                        int rulevalue2 = rs.getInt(3);
                        int qtytype = rs.getInt(4);
                        int qtyvalue = rs.getInt(5);
                        int adjustwtype = rs.getInt(6);
                        int adjusthtype = rs.getInt(7);
                        int sizeadjustw = rs.getInt(8);
                        int sizeadjusth = rs.getInt(9);

                        if (ruletype == 1 || ruletype == 2) {
                            matrixIds.add(rulevalue2);
                        }

                        if (ruletype == 5 || ruletype == 7 || ruletype == 8) {
                            matrixIds.add(rulevalue);
                        }

                        if (qtytype == 2) {
                            matrixIds.add(qtyvalue);
                        }

                        if (adjustwtype == 2) {
                            matrixIds.add(sizeadjustw);
                        }

                        if (adjusthtype == 2) {
                            matrixIds.add(sizeadjusth);
                        }
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return matrixIds;

        } finally {
            closeRemoteService();
        }
    }

    @Override
    public List<Integer> findAllRemoteSeriesSegments(Integer seriesId, Integer supplierId) throws GenericPersistenceEAOException {

        try {

            //Init Remote Service
            initRemoteService(supplierId);

            //Query String
            List<Integer> seriesSegments = em.createQuery("select distinct(r.rulevalue) from Rules r " +
                    "where r.rulesPK.seriesId = :seriesId and r.ruletype = 9 order by r.rulevalue").
                    setParameter("seriesId", seriesId).getResultList();

            return seriesSegments;

        } finally {

            //Close Remote Service
            closeRemoteService();
        }
    }

    @Override
    public List<Rules> findAllRemoteOptionRulesBySeries(Integer seriesId, Integer supplierId) throws GenericPersistenceEAOException {

        try {

            // Init service
            initRemoteService(supplierId);

            //Create Query
            List<Rules> rules = em.createQuery("select r from Rules r where r.ruletype >= 1 and r.ruletype <= 3 and " +
                    "r.rulesPK.seriesId = :seriesId order by r.rulesPK.id").setParameter("seriesId", seriesId).getResultList();

            return rules;

        } finally {
            //Close service
            closeRemoteService();
        }
    }

    @Override
    public List<Rules> findAllRemoteRulesBySeries(Integer seriesId, Integer supplierId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initRemoteService(supplierId);

            final int param_series_id = seriesId;

            final List<Rules> rules = new ArrayList<Rules>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select r.* from rules r where r.series_id = ? ");
                    query.append("order by r.id");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_series_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        RulesPK rulePK = new RulesPK();
                        rulePK.setId(rs.getInt("id"));
                        rulePK.setSeriesId(rs.getInt("series_id"));

                        Rules rule = new Rules();
                        rule.setRulesPK(rulePK);
                        rule.setDescription(rs.getString("description"));
                        rule.setLevel(rs.getInt("level"));
                        rule.setParentLevel(rs.getInt("parent_level"));
                        rule.setRuletype(rs.getInt("ruletype"));
                        rule.setRulevalue(rs.getInt("rulevalue"));
                        rule.setLeftside(rs.getInt("leftside"));
                        rule.setRightside(rs.getInt("rightside"));
                        rule.setAffectsdesign(rs.getBoolean("affectsdesign"));
                        rule.setPosition(rs.getInt("position"));
                        rule.setRcondition(rs.getInt("rcondition"));
                        rule.setQuantitytype(rs.getInt("quantitytype"));
                        rule.setQtyvalue(rs.getInt("qtyvalue"));
                        rule.setSizeadjustwtype(rs.getInt("sizeadjustwtype"));
                        rule.setSizeadjustw(rs.getInt("sizeadjustw"));
                        rule.setSizeadjustwi(rs.getInt("sizeadjustwi"));
                        rule.setSizeadjusthtype(rs.getInt("sizeadjusthtype"));
                        rule.setSizeadjusth(rs.getInt("sizeadjusth"));
                        rule.setSizeadjusthi(rs.getInt("sizeadjusthi"));
                        rule.setTest(rs.getBoolean("test"));
                        rule.setRulevalue2(rs.getString("rulevalue2"));
                        rule.setAnswerismatrix(rs.getBoolean("answerismatrix"));
                        rule.setStartdate(rs.getTimestamp("startdate"));
                        rule.setEnddate(rs.getTimestamp("enddate"));
                        rule.setAllowedanswer(rs.getBoolean("allowedanswer"));
                        rule.setRecalc(rs.getBoolean("recalc"));
                        rule.setWeldedl(rs.getBoolean("weldedl"));
                        rule.setWeldedr(rs.getBoolean("weldedr"));
                        rule.setRulevaluei(rs.getInt("rulevaluei"));
                        rule.setNominal(rs.getBoolean("nominal"));
                        rule.setAssemblyid(rs.getInt("assemblyid"));
                        rule.setP1(rs.getInt("p1"));
                        rule.setP2(rs.getInt("p2"));
                        rule.setP3(rs.getInt("p3"));
                        rule.setP4(rs.getInt("p4"));
                        rule.setP5(rs.getInt("p5"));
                        rule.setP6(rs.getInt("p6"));
                        rule.setP7(rs.getInt("p7"));
                        rule.setP8(rs.getInt("p8"));
                        rule.setP9(rs.getInt("p9"));
                        rule.setP10(rs.getInt("p10"));
                        rule.setP11(rs.getInt("p11"));
                        rule.setP12(rs.getInt("p12"));
                        rule.setP13(rs.getInt("p13"));
                        rule.setP14(rs.getInt("p14"));
                        rule.setP15(rs.getInt("p15"));
                        rule.setP16(rs.getInt("p16"));
                        rule.setP17(rs.getInt("p17"));
                        rule.setP18(rs.getInt("p18"));
                        rule.setP19(rs.getInt("p19"));
                        rule.setP20(rs.getInt("p20"));
                        rule.setP21(rs.getInt("p21"));
                        rule.setP22(rs.getInt("p22"));
                        rule.setTreeid(rs.getInt("treeid"));
                        rule.setQtyexpression(rs.getString("qtyexpression"));
                        rule.setAdjwexpression(rs.getString("adjwexpression"));
                        rule.setAdjhexpression(rs.getString("adjhexpression"));
                        rule.setQtyexpression(rs.getString("qtyexpressioni"));
                        rule.setAdjwexpressioni(rs.getString("adjwexpressioni"));
                        rule.setAdjhexpressioni(rs.getString("adjhexpressioni"));
                        rule.setGlobalOption(rs.getBoolean("global_option"));

                        rules.add(rule);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return rules;

        } finally {
            //Close service
            closeRemoteService();
        }

    }

}
