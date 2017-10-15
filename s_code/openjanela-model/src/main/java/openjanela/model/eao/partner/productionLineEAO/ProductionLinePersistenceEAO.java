package openjanela.model.eao.partner.productionLineEAO;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.partner.ProductionLine;
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
 * @version 2.0.8
 *          Date: 11-13-12
 *          Time: 11:53 PM
 */
public class ProductionLinePersistenceEAO extends GenericPersistenceEAO<ProductionLine, Integer> implements ProductionLineEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(ProductionLinePersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Production Line Persistence Constructor
     */
    public ProductionLinePersistenceEAO() {
        this.partnersEAO = new PartnersPersistenceEAO();
    }


    /**
     * This method init a remote persistence service
     *
     * @param supplierId, Supplier Identification Id
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
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
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
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
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
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
    public List<ProductionLine> findAllOrderByPrimaryKey() throws GenericPersistenceEAOException {
        try {

            //Init service
            initService();

            final List<ProductionLine> prodLines = new ArrayList<ProductionLine>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select p.* from production_line p order by p.id");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        ProductionLine prodLine = new ProductionLine();
                        prodLine.setId(rs.getInt("id"));
                        prodLine.setDescription(rs.getString("description"));
                        prodLine.setVirtual(rs.getBoolean("virtual"));
                        prodLine.setParent(rs.getInt("parent"));
                        prodLine.setCartSize(rs.getInt("cartsize"));
                        prodLine.setLevel(rs.getBoolean("level"));
                        prodLine.setShift_1(rs.getBoolean("shift1"));
                        prodLine.setShift_2(rs.getBoolean("shift2"));
                        prodLine.setShift_3(rs.getBoolean("shift3"));
                        prodLine.setBuildingNo(rs.getInt("buildingno"));
                        prodLine.setWarehouseId(rs.getInt("warehouseid"));
                        prodLine.setShipBuilding(rs.getInt("shipbuilding"));
                        prodLine.setTransferlt(rs.getDouble("transferlt"));
                        prodLine.setGlassLine(rs.getBoolean("isglassline"));
                        prodLine.setActive(rs.getBoolean("active"));
                        prodLine.setAssignOwnCartSlot(rs.getBoolean("assign_own_cart_slot"));

                        prodLines.add(prodLine);
                    }

                    rs.close();
                    pstmt.close();
                }
            });

            return prodLines;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ProductionLine> findAllOrderById() throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            String query = "select p from ProductionLine p where p.virtual = false and p.active = true and " +
                    "p.glassLine = true order by p.id";

            List<ProductionLine> productionLines = em.createQuery(query).getResultList();

            return productionLines;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ProductionLine> findAll() throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            String query = "select p from ProductionLine p where  p.active = true  order by p.id";

            List<ProductionLine> productionLines = em.createQuery(query).getResultList();

            return productionLines;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ProductionLine> findAllRemoteOrderById(int supplierId) throws GenericPersistenceEAOException {
        try {

            //Init service
            initRemoteService(supplierId);

            final List<ProductionLine> prodLines = new ArrayList<ProductionLine>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select p.* from production_line p order by p.id");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        ProductionLine prodLine = new ProductionLine();
                        prodLine.setId(rs.getInt("id"));
                        prodLine.setDescription(rs.getString("description"));
                        prodLine.setVirtual(rs.getBoolean("virtual"));
                        prodLine.setParent(rs.getInt("parent"));
                        prodLine.setCartSize(rs.getInt("cartsize"));
                        prodLine.setLevel(rs.getBoolean("level"));
                        prodLine.setShift_1(rs.getBoolean("shift1"));
                        prodLine.setShift_2(rs.getBoolean("shift2"));
                        prodLine.setShift_3(rs.getBoolean("shift3"));
                        prodLine.setBuildingNo(rs.getInt("buildingno"));
                        prodLine.setWarehouseId(rs.getInt("warehouseid"));
                        prodLine.setShipBuilding(rs.getInt("shipbuilding"));
                        prodLine.setTransferlt(rs.getDouble("transferlt"));
                        prodLine.setGlassLine(rs.getBoolean("isglassline"));
                        prodLine.setActive(rs.getBoolean("active"));
                        prodLine.setAssignOwnCartSlot(rs.getBoolean("assign_own_cart_slot"));

                        prodLines.add(prodLine);
                    }

                    rs.close();
                    pstmt.close();
                }
            });

            return prodLines;

        } finally {
            closeRemoteService();
        }
    }

}