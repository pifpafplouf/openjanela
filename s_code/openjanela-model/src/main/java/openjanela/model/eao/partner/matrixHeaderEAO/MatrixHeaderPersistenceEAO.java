package openjanela.model.eao.partner.matrixHeaderEAO;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.partner.MatrixHeader;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import javax.persistence.FlushModeType;
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
 * @since 2.0.8
 *          Date: 10-22-12
 *          Time: 09:36 PM
 */
public class MatrixHeaderPersistenceEAO extends GenericPersistenceEAO<MatrixHeader, Integer> implements MatrixHeaderEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(MatrixHeaderPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Matrix Header Persistence Default Constructor
     */
    public MatrixHeaderPersistenceEAO() {
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
    public List<MatrixHeader> findSubMatrixByTypeSeries(int seriesId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            String query = "select mh from MatrixHeader mh where mh.deleted = false and mh.subMatrix = true and" +
                    " (mh.seriesId = :seriesId or mh.seriesId = 0) order by mh.id";

            List<MatrixHeader> matrixHeaders = em.createQuery(query).setParameter("seriesId", seriesId).getResultList();

            return matrixHeaders;

        } finally {
            //Stop service
            closeService();
        }
    }

    @Override
    public List<MatrixHeader> findAllBySeries(String inClause) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final String param_in_clause = inClause;

            final List<MatrixHeader> matrixHeaders = new ArrayList<MatrixHeader>();

            if (inClause.length() <= 0) {
                return matrixHeaders;
            }

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select mh.* from matrix_header mh where mh.id in (");
                    query.append(param_in_clause).append(")");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        MatrixHeader matrixHeader = new MatrixHeader();
                        matrixHeader.setId(rs.getInt("id"));
                        matrixHeader.setDescription(rs.getString("description"));
                        matrixHeader.setMatrixTypeId(rs.getInt("matrix_type_id"));
                        matrixHeader.setRowTypeId(rs.getInt("row_type_id"));
                        matrixHeader.setAffectedOption(rs.getInt("affected_option"));
                        matrixHeader.setRowOptionId(rs.getInt("row_option_id"));
                        matrixHeader.setRowStart(rs.getDouble("row_start"));
                        matrixHeader.setRowEnd(rs.getDouble("row_end"));
                        matrixHeader.setRowStep(rs.getDouble("row_step"));
                        matrixHeader.setNumberRows(rs.getInt("number_rows"));
                        matrixHeader.setColumnTypeId(rs.getInt("column_type_id"));
                        matrixHeader.setColumnOptionId(rs.getInt("column_option_id"));
                        matrixHeader.setColumnStart(rs.getDouble("column_start"));
                        matrixHeader.setColumnEnd(rs.getDouble("column_end"));
                        matrixHeader.setColumnStep(rs.getDouble("column_step"));
                        matrixHeader.setNumberColumns(rs.getInt("number_columns"));
                        matrixHeader.setDeleted(rs.getBoolean("deleted"));
                        matrixHeader.setSystemUOMId(rs.getInt("system_uom_id"));
                        matrixHeader.setSubMatrix(rs.getBoolean("sub_matrix"));
                        matrixHeader.setMainMatrixId(rs.getInt("main_matrix_id"));
                        matrixHeader.setMathOperatorId(rs.getInt("math_operator_id"));
                        matrixHeader.setOperatorValue(rs.getBigDecimal("operator_value"));
                        matrixHeader.setSeriesId(rs.getInt("series_id"));
                        matrixHeader.setMeasure(rs.getInt("measure"));

                        matrixHeaders.add(matrixHeader);
                    }
                }
            });

            return matrixHeaders;

        } finally {
            //Stop service
            commitService();
        }
    }

    @Override
    public List<MatrixHeader> findAllByType(Integer type) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            String query = "select mh from MatrixHeader mh where mh.matrixTypeId = " + type + ") order by mh.id";

            List<MatrixHeader> matrixHeaders = em.createQuery(query).getResultList();

            return matrixHeaders;

        } finally {
            //Stop service
            closeService();
        }
    }

    @Override
    public List<MatrixHeader> findAllCommission() throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            String query = "select mh from MatrixHeader mh where mh.matrixTypeId in (32, 33, 34) order by mh.id";

            List<MatrixHeader> matrixHeaders = em.createQuery(query).getResultList();

            return matrixHeaders;

        } finally {
            //Stop service
            closeService();
        }
    }

    @Override
    public List<MatrixHeader> findAllRemoteBySeries(String inClause, int supplierId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initRemoteService(supplierId);

            final String param_in_clause = inClause;

            final List<MatrixHeader> matrixHeaders = new ArrayList<MatrixHeader>();

            if (inClause.length() <= 0) {
                return matrixHeaders;
            }

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select mh.* from matrix_header mh where mh.id in (");
                    query.append(param_in_clause).append(")");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        MatrixHeader matrixHeader = new MatrixHeader();
                        matrixHeader.setId(rs.getInt("id"));
                        matrixHeader.setDescription(rs.getString("description"));
                        matrixHeader.setMatrixTypeId(rs.getInt("matrix_type_id"));
                        matrixHeader.setRowTypeId(rs.getInt("row_type_id"));
                        matrixHeader.setAffectedOption(rs.getInt("affected_option"));
                        matrixHeader.setRowOptionId(rs.getInt("row_option_id"));
                        matrixHeader.setRowStart(rs.getDouble("row_start"));
                        matrixHeader.setRowEnd(rs.getDouble("row_end"));
                        matrixHeader.setRowStep(rs.getDouble("row_step"));
                        matrixHeader.setNumberRows(rs.getInt("number_rows"));
                        matrixHeader.setColumnTypeId(rs.getInt("column_type_id"));
                        matrixHeader.setColumnOptionId(rs.getInt("column_option_id"));
                        matrixHeader.setColumnStart(rs.getDouble("column_start"));
                        matrixHeader.setColumnEnd(rs.getDouble("column_end"));
                        matrixHeader.setColumnStep(rs.getDouble("column_step"));
                        matrixHeader.setNumberColumns(rs.getInt("number_columns"));
                        matrixHeader.setDeleted(rs.getBoolean("deleted"));
                        matrixHeader.setSystemUOMId(rs.getInt("system_uom_id"));
                        matrixHeader.setSubMatrix(rs.getBoolean("sub_matrix"));
                        matrixHeader.setMainMatrixId(rs.getInt("main_matrix_id"));
                        matrixHeader.setMathOperatorId(rs.getInt("math_operator_id"));
                        matrixHeader.setOperatorValue(rs.getBigDecimal("operator_value"));
                        matrixHeader.setSeriesId(rs.getInt("series_id"));
                        matrixHeader.setMeasure(rs.getInt("measure"));

                        matrixHeaders.add(matrixHeader);
                    }
                }
            });

            return matrixHeaders;

        } finally {
            //Stop service
            closeRemoteService();
        }
    }

}
