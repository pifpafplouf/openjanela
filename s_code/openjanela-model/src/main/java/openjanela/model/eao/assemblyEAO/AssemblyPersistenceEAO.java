package openjanela.model.eao.assemblyEAO;

import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.AssemblyEntityObject;
import openjanela.model.entities.design.BillOfMaterialEntityObject;
import openjanela.model.entities.design.ConfirmAssemblyEntityObject;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
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
 *          Date: 02-26-13
 *          Time: 08:49 PM
 */
public class AssemblyPersistenceEAO extends GenericPersistenceEAO<AssemblyEntityObject, Integer> implements AssemblyEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(AssemblyPersistenceEAO.class);

    @Override
    public void updateQuantity(Integer orderId, Integer itemId, Integer versionId, Integer qty)
            throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            em.createQuery("update AssemblyEntityObject a set a.qty = :quantity where a.orderId = :orderId and " +
                    "a.itemNo = :itemId and a.versionId = :versionId").
                    setParameter("quantity", qty).
                    setParameter("orderId", orderId).
                    setParameter("itemId", itemId).
                    setParameter("versionId", versionId).executeUpdate();

        } finally {
            closeService();
        }
    }

    @Override
    public List<AssemblyEntityObject> findByOrderId(Integer orderID) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            List<AssemblyEntityObject> assemblies = em.createQuery("select a from AssemblyEntityObject a where a.orderId = :orderId").
                    setParameter("orderId", orderID).getResultList();

            for (AssemblyEntityObject assembly : assemblies) {
                Hibernate.initialize(assembly.getBom());
                assembly.getId();
            }

            return assemblies;

        } finally {
            closeService();
        }
    }
    

    @Override
    public List<AssemblyEntityObject> findSupplierItemAssemblyByOrderId(Integer orderID) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final int param_order_id = orderID;

            final List<AssemblyEntityObject> assemblies = new ArrayList<AssemblyEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select assembly.* ");
                    query.append("from design_assemblies assembly inner join design_bill_of_materials bom ");
                    query.append("on assembly.bom_id = bom.id ");
                    query.append("where bom.parent_assembly_id = 0 and ");
                    query.append("bom.supplier_remote_id > 0 and ");
                    query.append("bom.remote = 1 ");
                    query.append("where assembly.order_id = ?");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        AssemblyEntityObject assembly = new AssemblyEntityObject();
                        assembly.setId(rs.getInt("id"));
                        assembly.setOrderId(rs.getInt("order_id"));
                        assembly.setItemNo(rs.getInt("item_no"));
                        assembly.setVersionId(rs.getInt("version_no"));
                        assembly.setAssemblyId(rs.getInt("assembly_id"));
                        assembly.setQty(rs.getInt("qty"));
                        assembly.setRow(rs.getInt("row"));
                        assembly.setCol(rs.getInt("col"));
                        assembly.setStage(rs.getInt("stage"));
                        assembly.setShift(rs.getInt("shift"));

                        assemblies.add(assembly);
                    }
                }
            });

            return assemblies;

        } finally {
            closeService();
        }
    }
}
