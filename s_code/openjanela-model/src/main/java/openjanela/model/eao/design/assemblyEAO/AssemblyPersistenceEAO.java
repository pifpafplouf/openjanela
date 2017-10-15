package openjanela.model.eao.design.assemblyEAO;

import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.AssemblyEntityObject;
import openjanela.model.entities.design.ConfirmAssemblyEntityObject;
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
 *          Date: 04-30-13
 *          Time: 08:10 PM
 */
public class AssemblyPersistenceEAO extends GenericPersistenceEAO<AssemblyEntityObject,  Integer> implements AssemblyEAO {

    //Apache Log4j
    private static final Logger logger = Logger.getLogger(AssemblyPersistenceEAO.class);

    @Override
    public List<AssemblyEntityObject> findByOrderItem(int orderId, int itemId, int versionId) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final int param_order_id = orderId;
            final int param_item_id = itemId;
            final int param_version_id = versionId;

            final List<AssemblyEntityObject> assemblies = new ArrayList<AssemblyEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select assembly.id, assembly.order_id, assembly.item_no, assembly.version_no, ");
                    query.append("assembly.assembly_id, assembly.qty, assembly.col, assembly.row, assembly.shift, assembly.stage, ");
                    query.append("assembly.is_confirmed, assembly.bom_id ");
                    query.append("from design_assemblies assembly inner join design_bill_of_materials bom ");
                    query.append("on assembly.bom_id = bom.id ");
                    query.append("where assembly.order_id = ? and assembly.item_no = ? and assembly.version_no = ? and ");
                    query.append("bom.parent_assembly_id != 0");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_id);
                    pstmt.setInt(2, param_item_id);
                    pstmt.setInt(3, param_version_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        AssemblyEntityObject assembly = new AssemblyEntityObject();
                        assembly.setId(rs.getInt("id"));
                        assembly.setOrderId(rs.getInt("order_id"));
                        assembly.setItemNo(rs.getInt("item_no"));
                        assembly.setVersionId(rs.getInt("version_no"));
                        assembly.setAssemblyId(rs.getInt("assembly_id"));
                        assembly.setQty(rs.getInt("qty"));
                        assembly.setCol(rs.getInt("col"));
                        assembly.setRow(rs.getInt("row"));
                        assembly.setShift(rs.getInt("shift"));
                        assembly.setStage(rs.getInt("stage"));
                        assembly.setConfirmed(rs.getBoolean("is_confirmed"));
                        assembly.setBomId(rs.getInt("bom_id"));

                        assemblies.add(assembly);
                    }

                    pstmt.close();
                    rs.close();

                }
            });

            return assemblies;

        } finally {
            closeService();
        }

    }

    @Override
    public List<AssemblyEntityObject> findChildAssemblies(Integer orderId, Integer itemId, Integer versionId, Integer bomId)
            throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final int param_order_id = orderId;
            final int param_item_id = itemId;
            final int param_version_id = versionId;
            final int param_bom_id = bomId;

            final List<AssemblyEntityObject> assemblies = new ArrayList<AssemblyEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select assemblies.*, ");
                    query.append("bom.id, bom.stock_code, bom.description, bom.prod_line, bom.station, bom.glass_bom_id, ");
                    query.append("bom.rule_no, bom.cut_length, bom.cut_length_i, bom.depth, bom.depth_i, ");
                    query.append("bom.area, bom.area_i, width, width_i, bom.height, bom.height_i, ");
                    query.append("bom.notches, bom.notches_i, bom.notches_i_y ");
                    query.append("from design_assemblies assemblies inner join design_bill_of_materials bom ");
                    query.append("on assemblies.bom_id = bom.id ");
                    query.append("where assemblies.order_id = ? and assemblies.item_no = ? and ");
                    query.append("assemblies.version_no = ? bom.parent_bom_id = ? ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_id);
                    pstmt.setInt(2, param_item_id);
                    pstmt.setInt(3, param_version_id);
                    pstmt.setInt(4, param_bom_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        AssemblyEntityObject assembly = new AssemblyEntityObject();
                        assembly.setId(rs.getInt("id"));
                        assembly.setOrderId(rs.getInt("order_id"));
                        assembly.setItemNo(rs.getInt("item_no"));
                        assembly.setVersionId(rs.getInt("version_no"));
                        assembly.setAssemblyId(rs.getInt("assembly_id"));
                        assembly.setCol(rs.getInt("col"));
                        assembly.setRow(rs.getInt("row"));
                        assembly.setShift(rs.getInt("shift"));
                        assembly.setStage(rs.getInt("stage"));
                        assembly.setBomId(rs.getInt("bom_id"));
                        assembly.setStockCodeParts(rs.getString("stock_code"));
                        assembly.setDescriptionParts(rs.getString("description"));
                        assembly.setProdLine(rs.getInt("prod_line"));
                        assembly.setStation(rs.getInt("station"));
                        assembly.setOptions(rs.getBytes("options"));
                        assembly.setImage(rs.getBytes("image"));
                        assembly.setGlassBomId(rs.getInt("glass_bom_id"));
                        assembly.setRuleNo(rs.getInt("rule_no"));
                        assembly.setCut_length(rs.getDouble("cut_length"));
                        assembly.setCut_length_i(rs.getDouble("cut_length_i"));
                        assembly.setDepth(rs.getDouble("depth"));
                        assembly.setDepth_i(rs.getDouble("depth_i"));
                        assembly.setArea(rs.getDouble("area"));
                        assembly.setArea_i(rs.getDouble("area_i"));
                        assembly.setWidth(rs.getDouble("width"));
                        assembly.setWidth_i(rs.getDouble("width_i"));
                        assembly.setHeight(rs.getDouble("height"));
                        assembly.setHeight_i(rs.getDouble("height_i"));
                        assembly.setNotches(rs.getString("notches"));
                        assembly.setNotches_i(rs.getString("notches_i"));
                        assembly.setNotches_i_y(rs.getString("notches_i_y"));

                        assemblies.add(assembly);
                    }

                    rs.close();
                    pstmt.close();
                }
            });

            return assemblies;

        } finally {
            closeService();
        }
    }
}
