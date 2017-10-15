package openjanela.model.eao.partner.matrixEAO;

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
import openjanela.model.entities.partner.Matrix;
import openjanela.model.entities.partner.MatrixPK;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;


/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-22-12
 *          Time: 09:35 PM
 */
public class MatrixPersistenceEAO extends GenericPersistenceEAO<Matrix, MatrixPK> implements MatrixEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(MatrixPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Matrix Persistence Default Constructor
     */
    public MatrixPersistenceEAO() {
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
    public List<Matrix> findMatrixCellsById(Integer mid) throws GenericPersistenceEAOException {

        try {

            // Init service
            initService();

            //Query String
            String query = "select m from Matrix m where m.id.id = :matrixID order by m.id.cellNumber asc";

            // Executing query and retrieve collection
            List<Matrix> matrixCells = new ArrayList();

            Query q = em.createQuery(query);
            q.setParameter("matrixID", mid);

            matrixCells = q.getResultList();

            return matrixCells;

        } finally {
            closeService();
        }
    }

    @Override
    public List<Matrix> findAllBySeries(String inClause) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final String param_in_clause = inClause;

            final List<Matrix> matrices = new ArrayList<Matrix>();

            if (inClause.length() <= 0) {
                return matrices;
            }

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select m.* from matrix m where m.id in (").append(param_in_clause).append(") ");
                    query.append("order by m.id, m.cell_no");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        MatrixPK matrixPK = new MatrixPK();
                        matrixPK.setId(rs.getInt("id"));
                        matrixPK.setCellNumber(rs.getInt("cell_no"));

                        Matrix matrix = new Matrix();
                        matrix.setId(matrixPK);
                        matrix.setMatrixRowL(rs.getString("rowL"));
                        matrix.setMatrixRowU(rs.getString("rowU"));
                        matrix.setMatrixColL(rs.getString("colL"));
                        matrix.setMatrixColU(rs.getString("colU"));
                        matrix.setCellType(rs.getInt("cell_type"));
                        matrix.setPrice(rs.getString("price"));

                        matrices.add(matrix);

                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return matrices;

        } finally {
            closeService();
        }
    }

    @Override
    public List<Matrix> findAllRemoteBySeries(String inClause, int supplierId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initRemoteService(supplierId);

            final String param_in_clause = inClause;

            final List<Matrix> matrices = new ArrayList<Matrix>();

            if (inClause.length() <= 0) {
                return matrices;
            }

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select m.* from matrix m where m.id in (").append(param_in_clause).append(") ");
                    query.append("order by m.id, m.cell_no");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        MatrixPK matrixPK = new MatrixPK();
                        matrixPK.setId(rs.getInt("id"));
                        matrixPK.setCellNumber(rs.getInt("cell_no"));

                        Matrix matrix = new Matrix();
                        matrix.setId(matrixPK);
                        matrix.setMatrixRowL(rs.getString("rowL"));
                        matrix.setMatrixRowU(rs.getString("rowU"));
                        matrix.setMatrixColL(rs.getString("colL"));
                        matrix.setMatrixColU(rs.getString("colU"));
                        matrix.setCellType(rs.getInt("cell_type"));
                        matrix.setPrice(rs.getString("price"));

                        matrices.add(matrix);

                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return matrices;

        } finally {
            closeRemoteService();
        }
    }

    @Override
    public List<Matrix> findAllByHeaders(String inClause) throws GenericPersistenceEAOException {
        try {

            //Init service
            initService();

            String query = "select mh from Matrix mh where mh.id.id in(" + inClause + ") order by mh.id.id";

            List<Matrix> matrixHeaders = em.createQuery(query).getResultList();

            return matrixHeaders;

        } finally {
            //Stop service
            commitService();
        }
    }

}
