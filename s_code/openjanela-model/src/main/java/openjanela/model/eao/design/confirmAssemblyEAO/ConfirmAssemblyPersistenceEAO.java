package openjanela.model.eao.design.confirmAssemblyEAO;

import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
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
import java.util.Date;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-30-13
 *          Time: 08:11 PM
 */
public class ConfirmAssemblyPersistenceEAO extends GenericPersistenceEAO<ConfirmAssemblyEntityObject, Integer> implements
        ConfirmAssemblyEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(ConfirmAssemblyPersistenceEAO.class);

    @Override
    public void createAssemblies(List<ConfirmAssemblyEntityObject> confirmAssemblies) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final List<ConfirmAssemblyEntityObject> _param_confirm_assemblies = new ArrayList<ConfirmAssemblyEntityObject>();
            _param_confirm_assemblies.addAll(confirmAssemblies);

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    connection.setAutoCommit(false);

                    StringBuffer query = new StringBuffer();
                    query.append("insert into design_confirm_assemblies (order_id, item_no, version_no, assembly_id, ");
                    query.append("barcode, batched, col, of_qty, place_po, prod_end, prod_start, qty_no, row, shift, ");
                    query.append("stage, sub_batched, bom_id, item_bc_id, slot_no, cart_no, assembly_shipped_id, ");
                    query.append("reject_code_id, is_repair, rush, shape, options, image) values (");
                    query.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    for (ConfirmAssemblyEntityObject assembly : _param_confirm_assemblies) {

                        pstmt.setInt(1, assembly.getOrderId());
                        pstmt.setInt(2, assembly.getItemNo());
                        pstmt.setInt(3, assembly.getVersionNo());
                        pstmt.setInt(4, assembly.getAssemblyId());
                        pstmt.setString(5, assembly.getBarCode());
                        pstmt.setInt(6, assembly.getBatched());
                        pstmt.setInt(7, assembly.getCol());
                        pstmt.setInt(8, assembly.getOfQty());
                        pstmt.setDate(9, new java.sql.Date(assembly.getPlacePO().getTime()));
                        pstmt.setDate(10, new java.sql.Date(assembly.getProdEnd().getTime()));
                        pstmt.setDate(11, new java.sql.Date(assembly.getProdStart().getTime()));
                        pstmt.setInt(12, assembly.getQtyNo());
                        pstmt.setInt(13, assembly.getRow());
                        pstmt.setInt(14, assembly.getShift());
                        pstmt.setInt(15, assembly.getStage());
                        pstmt.setInt(16, assembly.getSubBatched());
                        pstmt.setInt(17, assembly.getBomId());
                        pstmt.setString(18, assembly.getItemBarcode());
                        pstmt.setInt(19, assembly.getSlotNumber());
                        pstmt.setInt(20, assembly.getCartNumber());
                        pstmt.setInt(21, assembly.getAssemblyShippedId());
                        pstmt.setInt(22, assembly.getRejectCodeId());
                        pstmt.setBoolean(23, assembly.isRepair());
                        pstmt.setBoolean(24, assembly.isRush());
                        pstmt.setBytes(25, assembly.getShape());
                        pstmt.setBytes(26, assembly.getOptions());
                        pstmt.setBytes(27, assembly.getImage());

                        pstmt.addBatch();
                    }

                    //Execute Batch
                    pstmt.executeBatch();

                    connection.commit();

                    pstmt.close();
                }
            });

        } finally {
            closeService();
        }
    }

    @Override
    public void update(Integer id, Integer batched, Integer subBatchId, Integer slotNumber, Integer cartNumber)
            throws GenericPersistenceEAOException {

        try {

            //Init service;
            initService();

            final int param_id = id;
            final int param_batched = batched;
            final int param_subBatch = subBatchId;
            final int param_slotNumber = slotNumber;
            final int param_cartNumber = cartNumber;

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("update design_confirm_assemblies set batched = ?, sub_batched = ?, slot_no = ?, ");
                    query.append("cart_no = ? where id = ?");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_batched);
                    pstmt.setInt(2, param_subBatch);
                    pstmt.setInt(3, param_slotNumber);
                    pstmt.setInt(4, param_cartNumber);
                    pstmt.setInt(5, param_id);

                    pstmt.executeUpdate();

                    pstmt.close();
                }
            });

        } finally {
            closeService();
        }
    }

    @Override
    public void update(List<ConfirmAssemblyEntityObject> confirmAssemblies) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final List<ConfirmAssemblyEntityObject> _param_assemblies = new ArrayList<ConfirmAssemblyEntityObject>();
            _param_assemblies.addAll(confirmAssemblies);

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    connection.setAutoCommit(false);

                    StringBuffer query = new StringBuffer();
                    query.append("update design_confirm_assemblies set batched = ?, sub_batched = ?, slot_no = ?, ");
                    query.append("cart_no = ? where id = ?");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    for (ConfirmAssemblyEntityObject _assembly : _param_assemblies) {
                        pstmt.setInt(1, _assembly.getBatched());
                        pstmt.setInt(2, _assembly.getSubBatched());
                        pstmt.setInt(3, _assembly.getSlotNumber());
                        pstmt.setInt(4, _assembly.getCartNumber());
                        pstmt.setInt(5, _assembly.getId());

                        pstmt.addBatch();
                    }

                    pstmt.executeBatch();

                    connection.commit();
                }
            });

        } finally {
            closeService();
        }
    }

    @Override
    public void update(Integer id, int assemblyShippedId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            String query = "update ConfirmAssemblyEntityObject c set c.assemblyShippedId = :assemblyShippedId " +
                    "where c.id = :id";

            em.createQuery(query).setParameter("assemblyShippedId", assemblyShippedId).setParameter("id", id).executeUpdate();

        } finally {
            closeService();
        }
    }

    @Override
    public void update(Integer id, int typeRejectId, boolean isRepair) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            String query = "update ConfirmAssemblyEntityObject c set c.rejectCodeId = :rejectCode, c.repair = :repair " +
                    "where c.id = :id";

            em.createQuery(query).setParameter("rejectCode", typeRejectId).setParameter("repair", isRepair).
                    setParameter("id", id).executeUpdate();

        } finally {
            closeService();
        }
    }

    @Override
    public void updateProdDates(List<ConfirmAssemblyEntityObject> confirmAssemblies) throws GenericPersistenceEAOException {

        try {

            //Init service;
            initService();

            final List<ConfirmAssemblyEntityObject> _param_confirm_assemblies = confirmAssemblies;

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    connection.setAutoCommit(false);

                    StringBuffer query = new StringBuffer();
                    query.append("update design_confirm_assemblies set prod_start = ?, prod_end = ?, shift = ? ");
                    query.append("where order_id = ? and item_no = ? and qty_no = ? and of_qty = ? ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    for (ConfirmAssemblyEntityObject confirmAssembly : _param_confirm_assemblies) {
                        pstmt.setDate(1, new java.sql.Date(confirmAssembly.getProdStart().getTime()));
                        pstmt.setDate(2, new java.sql.Date(confirmAssembly.getProdEnd().getTime()));
                        pstmt.setInt(3, confirmAssembly.getShift());
                        pstmt.setInt(4, confirmAssembly.getOrderId());
                        pstmt.setInt(5, confirmAssembly.getItemNo());
                        pstmt.setInt(6, confirmAssembly.getQtyNo());
                        pstmt.setInt(7, confirmAssembly.getOfQty());

                        pstmt.addBatch();
                    }

                    //Execute Batch
                    pstmt.executeBatch();

                    connection.commit();

                    pstmt.close();
                }
            });

        } finally {
            closeService();
        }
    }

    @Override
    public void revertBatch(String subBatchIds) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final String param_subbatchIds = subBatchIds;

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("update design_confirm_assemblies assemblies set assemblies.sub_batched = 0, ");
                    query.append("assemblies.batched = 0, assemblies.cart_no = 0, assemblies.slot_no = 0, ");
                    query.append("assemblies.reject_code_id = 0, assemblies.is_repair = 0, assemblies.rush = 0 ");
                    query.append("where assemblies.sub_batched in (").append(param_subbatchIds).append(")");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    pstmt.executeUpdate();

                    pstmt.close();
                }
            });

        } finally {
            closeService();
        }
    }

    @Override
    public List<ConfirmAssemblyEntityObject> findByBarcode(String barcode, Integer prodLineId, Integer stationId,
                                                           boolean useStation) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final String param_barcode = barcode;
            final int param_prod_line = prodLineId;
            final int param_station = stationId;
            final boolean param_use_station = useStation;

            //Array List to return
            final List<ConfirmAssemblyEntityObject> confirmedAssemblies = new ArrayList<ConfirmAssemblyEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select assembly.id, assembly.order_id, assembly.item_no, assembly.version_no, ");
                    query.append("assembly.assembly_id, assembly.barcode, assembly.batched, assembly.col, ");
                    query.append("assembly.of_qty, assembly.place_po, assembly.prod_end, assembly.prod_start, ");
                    query.append("assembly.qty_no, assembly.row, assembly.shift, assembly.stage, assembly.sub_batched, ");
                    query.append("assembly.bom_id, assembly.item_bc_id, assembly.slot_no, assembly.cart_no, ");
                    query.append("assembly.assembly_shipped_id, assembly.reject_code_id, assembly.is_repair, assembly.rush, ");
                    query.append("bom.prod_line, bom.station, bom.job_item_id, bom.part_id, bom.description, assembly.assembly_shipped_id, ");
                    query.append("assembly.options, assembly.image ");
                    query.append("from design_confirm_assemblies assembly inner join design_bill_of_materials bom ");
                    query.append("on assembly.bom_id = bom.id ");
                    query.append("where assembly.batched > 0 and assembly.sub_batched > 0 and ");

                    if (param_use_station) {
                        query.append("assembly.barcode = ? ");
                    } else {
                        query.append("assembly.barcode = ? ");
                    }

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setString(1, param_barcode);

                    if (param_use_station) {
//                        pstmt.setInt(3, param_station);
                    }

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        ConfirmAssemblyEntityObject assembly = new ConfirmAssemblyEntityObject();
                        assembly.setId(rs.getInt("id"));
                        assembly.setOrderId(rs.getInt("order_id"));
                        assembly.setItemNo(rs.getInt("item_no"));
                        assembly.setVersionNo(rs.getInt("version_no"));
                        assembly.setAssemblyId(rs.getInt("assembly_id"));
                        assembly.setBarCode(rs.getString("barcode"));
                        assembly.setBatched(rs.getInt("batched"));
                        assembly.setCol(rs.getInt("col"));
                        assembly.setOfQty(rs.getInt("of_qty"));
                        assembly.setPlacePO(rs.getDate("place_po"));
                        assembly.setProdEnd(rs.getDate("prod_end"));
                        assembly.setProdStart(rs.getDate("prod_start"));
                        assembly.setQtyNo(rs.getInt("qty_no"));
                        assembly.setRow(rs.getInt("row"));
                        assembly.setShift(rs.getInt("shift"));
                        assembly.setStage(rs.getInt("stage"));
                        assembly.setSubBatched(rs.getInt("sub_batched"));
                        assembly.setBomId(rs.getInt("bom_id"));
                        assembly.setDescriptionParts(rs.getString("description"));
                        assembly.setItemBarcode(rs.getString("item_bc_id"));
                        assembly.setSlotNumber(rs.getInt("slot_no"));
                        assembly.setCartNumber(rs.getInt("cart_no"));
                        assembly.setProdLine(rs.getInt("prod_line"));
                        assembly.setStation(rs.getInt("station"));
                        assembly.setJobItemId(rs.getInt("job_item_id"));
                        assembly.setPartId(rs.getInt("part_id"));
                        assembly.setAssemblyShippedId(rs.getInt("assembly_shipped_id"));
                        assembly.setRejectCodeId(rs.getInt("reject_code_id"));
                        assembly.setRepair(rs.getBoolean("is_repair"));
                        assembly.setRush(rs.getBoolean("rush"));
                        assembly.setAssemblyShippedId(rs.getInt("assembly_shipped_id"));
                        assembly.setOptions(rs.getBytes("options"));
                        assembly.setImage(rs.getBytes("image"));

                        confirmedAssemblies.add(assembly);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return confirmedAssemblies;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ConfirmAssemblyEntityObject> findByItemBarcode(String barcode) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final String param_barcode = barcode;

            //Array List to return
            final List<ConfirmAssemblyEntityObject> confirmedAssemblies = new ArrayList<ConfirmAssemblyEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select assembly.id, assembly.order_id, assembly.item_no, assembly.version_no, ");
                    query.append("assembly.assembly_id, assembly.barcode, assembly.batched, assembly.col, ");
                    query.append("assembly.of_qty, assembly.place_po, assembly.prod_end, assembly.prod_start, ");
                    query.append("assembly.qty_no, assembly.row, assembly.shift, assembly.stage, assembly.sub_batched, ");
                    query.append("assembly.bom_id, assembly.item_bc_id, assembly.slot_no, assembly.cart_no, ");
                    query.append("bom.prod_line, bom.station, bom.job_item_id ");
                    query.append("from design_confirm_assemblies assembly inner join design_bill_of_materials bom ");
                    query.append("on assembly.bom_id = bom.id ");
                    query.append("where assembly.batched > 0 and assembly.sub_batched > 0 and assembly.reject_code_id = 0 ");
                    query.append("and assembly.item_bc_id = ? ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setString(1, param_barcode);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        ConfirmAssemblyEntityObject assembly = new ConfirmAssemblyEntityObject();
                        assembly.setId(rs.getInt("id"));
                        assembly.setOrderId(rs.getInt("order_id"));
                        assembly.setItemNo(rs.getInt("item_no"));
                        assembly.setVersionNo(rs.getInt("version_no"));
                        assembly.setAssemblyId(rs.getInt("assembly_id"));
                        assembly.setBarCode(rs.getString("barcode"));
                        assembly.setBatched(rs.getInt("batched"));
                        assembly.setCol(rs.getInt("col"));
                        assembly.setOfQty(rs.getInt("of_qty"));
                        assembly.setPlacePO(rs.getDate("place_po"));
                        assembly.setProdEnd(rs.getDate("prod_end"));
                        assembly.setProdStart(rs.getDate("prod_start"));
                        assembly.setQtyNo(rs.getInt("qty_no"));
                        assembly.setRow(rs.getInt("row"));
                        assembly.setShift(rs.getInt("shift"));
                        assembly.setStage(rs.getInt("stage"));
                        assembly.setSubBatched(rs.getInt("sub_batched"));
                        assembly.setBomId(rs.getInt("bom_id"));
                        assembly.setItemBarcode(rs.getString("item_bc_id"));
                        assembly.setSlotNumber(rs.getInt("slot_no"));
                        assembly.setCartNumber(rs.getInt("cart_no"));
                        assembly.setProdLine(rs.getInt("prod_line"));
                        assembly.setStation(rs.getInt("station"));
                        assembly.setJobItemId(rs.getInt("job_item_id"));

                        confirmedAssemblies.add(assembly);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return confirmedAssemblies;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ConfirmAssemblyEntityObject> findByItemBarcodeShipped(String barcode) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            List<ConfirmAssemblyEntityObject> assemblies = em.createQuery("select c from ConfirmAssemblyEntityObject  c " +
                "inner join c.bom b where c.itemBarcode = :barcode and b.ships = true and c.rejectCodeId <= 0 and c.repair = false").
                    setParameter("barcode", barcode).getResultList();

            return assemblies;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ConfirmAssemblyEntityObject> findAssembliesByItemBarcode(String barcode) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final String param_item_barcode = barcode;

            //Array List to return
            final List<ConfirmAssemblyEntityObject> confirmedAssemblies = new ArrayList<ConfirmAssemblyEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    //*********************************************************************
                    //Construct Select Query
                    //*********************************************************************
                    StringBuffer query = new StringBuffer();
                    query.append("select assembly.id, assembly.order_id, assembly.item_no, assembly.version_no, ");
                    query.append("assembly.assembly_id, assembly.barcode, assembly.batched, assembly.col, ");
                    query.append("assembly.of_qty, assembly.place_po, assembly.prod_end, assembly.prod_start, ");
                    query.append("assembly.qty_no, assembly.row, assembly.shift, assembly.stage, ");
                    query.append("assembly.sub_batched, assembly.bom_id, assembly.item_bc_id, assembly.slot_no, ");
                    query.append("assembly.cart_no, assembly.assembly_shipped_id, assembly.reject_code_id, ");
                    query.append("assembly.is_repair, assembly.rush, bom.prod_line, bom.station ");
                    query.append("from design_confirm_assemblies assembly inner join design_bill_of_materials bom ");
                    query.append("on assembly.bom_id = bom.id ");
                    query.append("where assembly.item_bc_id = ? ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setString(1, param_item_barcode);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {

                        ConfirmAssemblyEntityObject confirmAssembly = new ConfirmAssemblyEntityObject();
                        confirmAssembly.setId(rs.getInt("id"));
                        confirmAssembly.setOrderId(rs.getInt("order_id"));
                        confirmAssembly.setItemNo(rs.getInt("item_no"));
                        confirmAssembly.setVersionNo(rs.getInt("version_no"));
                        confirmAssembly.setAssemblyId(rs.getInt("assembly_id"));
                        confirmAssembly.setBarCode(rs.getString("barcode"));
                        confirmAssembly.setBatched(rs.getInt("batched"));
                        confirmAssembly.setCol(rs.getInt("col"));
                        confirmAssembly.setOfQty(rs.getInt("of_qty"));
                        confirmAssembly.setPlacePO(rs.getDate("place_po"));
                        confirmAssembly.setProdEnd(rs.getDate("prod_end"));
                        confirmAssembly.setProdStart(rs.getDate("prod_start"));
                        confirmAssembly.setQtyNo(rs.getInt("qty_no"));
                        confirmAssembly.setRow(rs.getInt("row"));
                        confirmAssembly.setShift(rs.getInt("shift"));
                        confirmAssembly.setStage(rs.getInt("stage"));
                        confirmAssembly.setSubBatched(rs.getInt("sub_batched"));
                        confirmAssembly.setBomId(rs.getInt("bom_id"));
                        confirmAssembly.setItemBarcode(rs.getString("item_bc_id"));
                        confirmAssembly.setSlotNumber(rs.getInt("slot_no"));
                        confirmAssembly.setCartNumber(rs.getInt("cart_no"));
                        confirmAssembly.setAssemblyShippedId(rs.getInt("assembly_shipped_id"));
                        confirmAssembly.setRejectCodeId(rs.getInt("reject_code_id"));
                        confirmAssembly.setRepair(rs.getBoolean("is_repair"));
                        confirmAssembly.setRush(rs.getBoolean("rush"));
                        confirmAssembly.setProdLine(rs.getInt("prod_line"));
                        confirmAssembly.setStation(rs.getInt("station"));

                        confirmedAssemblies.add(confirmAssembly);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return confirmedAssemblies;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ConfirmAssemblyEntityObject> findChildAssemblies(Integer orderId, Integer itemId, Integer versionId,
                                                                 Integer qtyNo, Integer ofQty, Integer bomId)
            throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final int param_order_id = orderId;
            final int param_item_id = itemId;
            final int param_version_id = versionId;
            final int param_qty_no = qtyNo;
            final int param_of_qty = ofQty;
            final int param_bom_id = bomId;

            final List<ConfirmAssemblyEntityObject> assemblies = new ArrayList<ConfirmAssemblyEntityObject>();

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
                    query.append("from design_confirm_assemblies assemblies inner join design_bill_of_materials bom ");
                    query.append("on assemblies.bom_id = bom.id ");
                    query.append("where assemblies.order_id = ? and assemblies.item_no = ? and ");
                    query.append("assemblies.version_no = ? and assemblies.qty_no = ? and ");
                    query.append("assemblies.of_qty = ? and bom.parent_bom_id = ? and ");
                    query.append("assemblies.reject_code_id <= 0 and assemblies.is_repair = 0 ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_id);
                    pstmt.setInt(2, param_item_id);
                    pstmt.setInt(3, param_version_id);
                    pstmt.setInt(4, param_qty_no);
                    pstmt.setInt(5, param_of_qty);
                    pstmt.setInt(6, param_bom_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        ConfirmAssemblyEntityObject confirmAssembly = new ConfirmAssemblyEntityObject();
                        confirmAssembly.setId(rs.getInt("id"));
                        confirmAssembly.setOrderId(rs.getInt("order_id"));
                        confirmAssembly.setItemNo(rs.getInt("item_no"));
                        confirmAssembly.setVersionNo(rs.getInt("version_no"));
                        confirmAssembly.setAssemblyId(rs.getInt("assembly_id"));
                        confirmAssembly.setBarCode(rs.getString("barcode"));
                        confirmAssembly.setBatched(rs.getInt("batched"));
                        confirmAssembly.setCol(rs.getInt("col"));
                        confirmAssembly.setOfQty(rs.getInt("of_qty"));
                        confirmAssembly.setProdEnd(rs.getDate("prod_end"));
                        confirmAssembly.setProdStart(rs.getDate("prod_start"));
                        confirmAssembly.setQtyNo(rs.getInt("qty_no"));
                        confirmAssembly.setRow(rs.getInt("row"));
                        confirmAssembly.setShift(rs.getInt("shift"));
                        confirmAssembly.setStage(rs.getInt("stage"));
                        confirmAssembly.setSubBatched(rs.getInt("sub_batched"));
                        confirmAssembly.setBomId(rs.getInt("bom_id"));
                        confirmAssembly.setStockCodeParts(rs.getString("stock_code"));
                        confirmAssembly.setDescriptionParts(rs.getString("description"));
                        confirmAssembly.setItemBarcode(rs.getString("item_bc_id"));
                        confirmAssembly.setSlotNumber(rs.getInt("slot_no"));
                        confirmAssembly.setCartNumber(rs.getInt("cart_no"));
                        confirmAssembly.setAssemblyShippedId(rs.getInt("assembly_shipped_id"));
                        confirmAssembly.setRejectCodeId(rs.getInt("reject_code_id"));
                        confirmAssembly.setRepair(rs.getBoolean("is_repair"));
                        confirmAssembly.setRush(rs.getBoolean("rush"));
                        confirmAssembly.setPlacePO(rs.getDate("place_po"));
                        confirmAssembly.setBatched(rs.getInt("batched"));
                        confirmAssembly.setProdLine(rs.getInt("prod_line"));
                        confirmAssembly.setStation(rs.getInt("station"));
                        confirmAssembly.setOptions(rs.getBytes("options"));
                        confirmAssembly.setImage(rs.getBytes("image"));
                        confirmAssembly.setGlassBomId(rs.getInt("glass_bom_id"));
                        confirmAssembly.setRuleNo(rs.getInt("rule_no"));
                        confirmAssembly.setCut_length(rs.getDouble("cut_length"));
                        confirmAssembly.setCut_length_i(rs.getDouble("cut_length_i"));
                        confirmAssembly.setDepth(rs.getDouble("depth"));
                        confirmAssembly.setDepth_i(rs.getDouble("depth_i"));
                        confirmAssembly.setArea(rs.getDouble("area"));
                        confirmAssembly.setArea_i(rs.getDouble("area_i"));
                        confirmAssembly.setWidth(rs.getDouble("width"));
                        confirmAssembly.setWidth_i(rs.getDouble("width_i"));
                        confirmAssembly.setHeight(rs.getDouble("height"));
                        confirmAssembly.setHeight_i(rs.getDouble("height_i"));
                        confirmAssembly.setNotches(rs.getString("notches"));
                        confirmAssembly.setNotches_i(rs.getString("notches_i"));
                        confirmAssembly.setNotches_i_y(rs.getString("notches_i_y"));

                        assemblies.add(confirmAssembly);
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

    @Override
    public List<ConfirmAssemblyEntityObject> findByOrderId(Integer orderId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //Query String
            String query = "select c from ConfirmAssemblyEntityObject c where c.orderId = :orderId";

            List<ConfirmAssemblyEntityObject> assemblies = em.createQuery(query).setParameter("orderId", orderId).
                    getResultList();

            return assemblies;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ConfirmAssemblyEntityObject> findNativeByOrderId(Integer orderId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final int param_order_value = orderId;
            final List<ConfirmAssemblyEntityObject> confirmAssemblies = new ArrayList<ConfirmAssemblyEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    StringBuffer query = new StringBuffer();
                    query.append("select * from design_confirm_assemblies where order_id = ?");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_value);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        ConfirmAssemblyEntityObject confirmAssembly = new ConfirmAssemblyEntityObject();
                        confirmAssembly.setId(rs.getInt("id"));
                        confirmAssembly.setOrderId(rs.getInt("order_id"));
                        confirmAssembly.setItemNo(rs.getInt("item_no"));
                        confirmAssembly.setAssemblyId(rs.getInt("assembly_id"));
                        confirmAssembly.setQtyNo(rs.getInt("qty_no"));
                        confirmAssembly.setOfQty(rs.getInt("of_qty"));
                        confirmAssembly.setRow(rs.getInt("row"));
                        confirmAssembly.setCol(rs.getInt("col"));
                        confirmAssembly.setBarCode(rs.getString("barcode"));
                        confirmAssembly.setStage(rs.getInt("stage"));
                        confirmAssembly.setPlacePO(rs.getDate("place_po"));
                        confirmAssembly.setProdStart(rs.getDate("prod_start"));
                        confirmAssembly.setProdEnd(rs.getDate("prod_end"));
                        confirmAssembly.setBatched(rs.getInt("batched"));
                        confirmAssembly.setSubBatched(rs.getInt("sub_batched"));
                        confirmAssembly.setShift(rs.getInt("shift"));
                        confirmAssembly.setBomId(rs.getInt("bom_id"));
                        confirmAssembly.setItemBarcode(rs.getString("item_bc_id"));
                        confirmAssembly.setSlotNumber(rs.getInt("slot_no"));
                        confirmAssembly.setCartNumber(rs.getInt("cart_no"));
                        confirmAssembly.setAssemblyShippedId(rs.getInt("assembly_shipped_id"));
                        confirmAssembly.setRejectCodeId(rs.getInt("reject_code_id"));
                        confirmAssembly.setRepair(rs.getBoolean("is_repair"));
                        confirmAssembly.setRush(rs.getBoolean("rush"));
                        confirmAssembly.setOptions(rs.getBytes("options"));

                        confirmAssemblies.add(confirmAssembly);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return confirmAssemblies;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ConfirmAssemblyEntityObject> findNativeByBomId(Integer bomId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final int param_bom_id = bomId;
            final List<ConfirmAssemblyEntityObject> confirmAssemblies = new ArrayList<ConfirmAssemblyEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    StringBuffer query = new StringBuffer();
                    query.append("select assemblies.*, bom.prod_line, bom.station from design_confirm_assemblies assemblies ");
                    query.append("inner join design_bill_of_materials bom on assemblies.bom.id = bom.id where bom_id = ?");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_bom_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        ConfirmAssemblyEntityObject confirmAssembly = new ConfirmAssemblyEntityObject();
                        confirmAssembly.setId(rs.getInt("id"));
                        confirmAssembly.setOrderId(rs.getInt("order_id"));
                        confirmAssembly.setItemNo(rs.getInt("item_no"));
                        confirmAssembly.setAssemblyId(rs.getInt("assembly_id"));
                        confirmAssembly.setQtyNo(rs.getInt("qty_no"));
                        confirmAssembly.setOfQty(rs.getInt("of_qty"));
                        confirmAssembly.setRow(rs.getInt("row"));
                        confirmAssembly.setCol(rs.getInt("col"));
                        confirmAssembly.setBarCode(rs.getString("barcode"));
                        confirmAssembly.setStage(rs.getInt("stage"));
                        confirmAssembly.setPlacePO(rs.getDate("place_po"));
                        confirmAssembly.setProdStart(rs.getDate("prod_start"));
                        confirmAssembly.setProdEnd(rs.getDate("prod_end"));
                        confirmAssembly.setBatched(rs.getInt("batched"));
                        confirmAssembly.setSubBatched(rs.getInt("sub_batched"));
                        confirmAssembly.setShift(rs.getInt("shift"));
                        confirmAssembly.setBomId(rs.getInt("bom_id"));
                        confirmAssembly.setProdLine(rs.getInt("prod_line"));
                        confirmAssembly.setStation(rs.getInt("station"));

                        confirmAssemblies.add(confirmAssembly);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return confirmAssemblies;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ConfirmAssemblyEntityObject> findByAssembly(Integer orderId, Integer itemNo, Integer assemblyId,
                                                            Integer shiftId, Integer leafNo) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final int param_order_id = orderId;
            final int param_item_no = itemNo;
            final int param_assembly_id = assemblyId;
            final int param_shift_id = shiftId;
            final int param_leaf_no = leafNo;

            //Array List to return
            final List<ConfirmAssemblyEntityObject> confirmedAssemblies = new ArrayList<ConfirmAssemblyEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    //*********************************************************************
                    //Construct Select Query
                    //*********************************************************************
                    StringBuffer query = new StringBuffer();
                    query.append("select assembly.id, assembly.order_id, assembly.item_no, assembly.version_no, ");
                    query.append("assembly.assembly_id, assembly.barcode, assembly.batched, assembly.col, ");
                    query.append("assembly.of_qty, assembly.place_po, assembly.prod_end, assembly.prod_start, ");
                    query.append("assembly.qty_no, assembly.row, assembly.shift, assembly.stage, ");
                    query.append("assembly.sub_batched, assembly.bom_id, assembly.item_bc_id, assembly.slot_no, ");
                    query.append("assembly.cart_no, assembly.assembly_shipped_id, assembly.reject_code_id, ");
                    query.append("assembly.is_repair, assembly.rush, bom.prod_line, bom.station, bom.assembly_level_id, ");
                    query.append("bom.parent_bom_id, bom.glass_bom_id ");
                    query.append("from design_confirm_assemblies assembly inner join design_bill_of_materials bom ");
                    query.append("on assembly.bom_id = bom.id ");
                    query.append("where assembly.order_id = ? and ");
                    query.append("assembly.item_no = ? and ");
                    query.append("assembly.assembly_id = ? and ");
                    query.append("assembly.shift = ? and ");
                    query.append("assembly.batched = 0 and ");
                    query.append("bom.leaf_no = ? ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_id);
                    pstmt.setInt(2, param_item_no);
                    pstmt.setInt(3, param_assembly_id);
                    pstmt.setInt(4, param_shift_id);
                    pstmt.setInt(5, param_leaf_no);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {

                        ConfirmAssemblyEntityObject confirmAssembly = new ConfirmAssemblyEntityObject();
                        confirmAssembly.setId(rs.getInt("id"));
                        confirmAssembly.setOrderId(rs.getInt("order_id"));
                        confirmAssembly.setItemNo(rs.getInt("item_no"));
                        confirmAssembly.setVersionNo(rs.getInt("version_no"));
                        confirmAssembly.setAssemblyId(rs.getInt("assembly_id"));
                        confirmAssembly.setBarCode(rs.getString("barcode"));
                        confirmAssembly.setBatched(rs.getInt("batched"));
                        confirmAssembly.setCol(rs.getInt("col"));
                        confirmAssembly.setOfQty(rs.getInt("of_qty"));
                        confirmAssembly.setPlacePO(rs.getDate("place_po"));
                        confirmAssembly.setProdEnd(rs.getDate("prod_end"));
                        confirmAssembly.setProdStart(rs.getDate("prod_start"));
                        confirmAssembly.setQtyNo(rs.getInt("qty_no"));
                        confirmAssembly.setRow(rs.getInt("row"));
                        confirmAssembly.setShift(rs.getInt("shift"));
                        confirmAssembly.setStage(rs.getInt("stage"));
                        confirmAssembly.setSubBatched(rs.getInt("sub_batched"));
                        confirmAssembly.setBomId(rs.getInt("bom_id"));
                        confirmAssembly.setItemBarcode(rs.getString("item_bc_id"));
                        confirmAssembly.setSlotNumber(rs.getInt("slot_no"));
                        confirmAssembly.setCartNumber(rs.getInt("cart_no"));
                        confirmAssembly.setAssemblyShippedId(rs.getInt("assembly_shipped_id"));
                        confirmAssembly.setRejectCodeId(rs.getInt("reject_code_id"));
                        confirmAssembly.setRepair(rs.getBoolean("is_repair"));
                        confirmAssembly.setRush(rs.getBoolean("rush"));
                        confirmAssembly.setProdLine(rs.getInt("prod_line"));
                        confirmAssembly.setStation(rs.getInt("station"));
                        confirmAssembly.setAssemblyLevelId(rs.getInt("assembly_level_id"));
                        confirmAssembly.setParentBomId(rs.getInt("parent_bom_id"));
                        confirmAssembly.setGlassBomId(rs.getInt("glass_bom_id"));

                        confirmedAssemblies.add(confirmAssembly);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return confirmedAssemblies;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ConfirmAssemblyEntityObject> findNotBatched(Integer orderId, Integer itemNo, Integer ofQty, Integer shift)
            throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            List<ConfirmAssemblyEntityObject> confirmAssemblies = em.createQuery("select c from ConfirmAssemblyEntityObject c " +
                    "where c.orderId = :orderId and c.itemNo = :itemNo and c.ofQty = :ofQty and c.shift = :shift and " +
                    "c.batched = 0").setParameter("orderId", orderId).setParameter("itemNo", itemNo).
                    setParameter("ofQty", ofQty).setParameter("shift", shift).getResultList();

            for (ConfirmAssemblyEntityObject confirmAssembly : confirmAssemblies) {
                Hibernate.initialize(confirmAssembly.getBom());

                confirmAssembly.setBomId(confirmAssembly.getBom().getBomId());
                confirmAssembly.setProdLine(confirmAssembly.getBom().getProdLine());
                confirmAssembly.setStation(confirmAssembly.getBom().getStation());
            }

            return confirmAssemblies;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ConfirmAssemblyEntityObject> findNotBatched(Integer orderId, Integer itemNo, Integer qtyNo, Integer ofQty,
                                                            Integer shift) throws GenericPersistenceEAOException {
        try {

            //Init service
            initService();

            final int param_order_id = orderId;
            final int param_item_no = itemNo;
            final int param_qty_no = qtyNo;
            final int param_of_qty = ofQty;
            final int param_shift = shift;

            //Array List to return
            final List<ConfirmAssemblyEntityObject> confirmedAssemblies = new ArrayList<ConfirmAssemblyEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    //*********************************************************************
                    //Construct Select Query
                    //*********************************************************************
                    StringBuffer query = new StringBuffer();
                    query.append("select assembly.id, assembly.order_id, assembly.item_no, assembly.version_no, ");
                    query.append("assembly.assembly_id, assembly.barcode, assembly.batched, assembly.col, ");
                    query.append("assembly.of_qty, assembly.place_po, assembly.prod_end, assembly.prod_start, ");
                    query.append("assembly.qty_no, assembly.row, assembly.shift, assembly.stage, ");
                    query.append("assembly.sub_batched, assembly.bom_id, assembly.item_bc_id, assembly.slot_no, ");
                    query.append("assembly.cart_no, assembly.assembly_shipped_id, assembly.reject_code_id, ");
                    query.append("assembly.is_repair, assembly.rush, bom.parent_bom_id, bom.assembly_level_id, ");
                    query.append("bom.prod_line, bom.station ");
                    query.append("from design_confirm_assemblies assembly inner join design_bill_of_materials bom ");
                    query.append("on assembly.bom_id = bom.id ");
                    query.append("where assembly.order_id = ? and ");
                    query.append("assembly.item_no = ? and ");
                    query.append("assembly.qty_no = ? and ");
                    query.append("assembly.of_qty = ? and ");
                    query.append("assembly.shift = ? and ");
                    query.append("assembly.batched = 0 ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_id);
                    pstmt.setInt(2, param_item_no);
                    pstmt.setInt(3, param_qty_no);
                    pstmt.setInt(4, param_of_qty);
                    pstmt.setInt(5, param_shift);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {

                        ConfirmAssemblyEntityObject confirmAssembly = new ConfirmAssemblyEntityObject();
                        confirmAssembly.setId(rs.getInt("id"));
                        confirmAssembly.setOrderId(rs.getInt("order_id"));
                        confirmAssembly.setItemNo(rs.getInt("item_no"));
                        confirmAssembly.setVersionNo(rs.getInt("version_no"));
                        confirmAssembly.setAssemblyId(rs.getInt("assembly_id"));
                        confirmAssembly.setBarCode(rs.getString("barcode"));
                        confirmAssembly.setBatched(rs.getInt("batched"));
                        confirmAssembly.setCol(rs.getInt("col"));
                        confirmAssembly.setOfQty(rs.getInt("of_qty"));
                        confirmAssembly.setPlacePO(rs.getDate("place_po"));
                        confirmAssembly.setProdEnd(rs.getDate("prod_end"));
                        confirmAssembly.setProdStart(rs.getDate("prod_start"));
                        confirmAssembly.setQtyNo(rs.getInt("qty_no"));
                        confirmAssembly.setRow(rs.getInt("row"));
                        confirmAssembly.setShift(rs.getInt("shift"));
                        confirmAssembly.setStage(rs.getInt("stage"));
                        confirmAssembly.setSubBatched(rs.getInt("sub_batched"));
                        confirmAssembly.setBomId(rs.getInt("bom_id"));
                        confirmAssembly.setParentBomId(rs.getInt("parent_bom_id"));
                        confirmAssembly.setAssemblyLevelId(rs.getInt("assembly_level_id"));
                        confirmAssembly.setItemBarcode(rs.getString("item_bc_id"));
                        confirmAssembly.setSlotNumber(rs.getInt("slot_no"));
                        confirmAssembly.setCartNumber(rs.getInt("cart_no"));
                        confirmAssembly.setAssemblyShippedId(rs.getInt("assembly_shipped_id"));
                        confirmAssembly.setRejectCodeId(rs.getInt("reject_code_id"));
                        confirmAssembly.setRepair(rs.getBoolean("is_repair"));
                        confirmAssembly.setRush(rs.getBoolean("rush"));
                        confirmAssembly.setProdLine(rs.getInt("prod_line"));
                        confirmAssembly.setStation(rs.getInt("station"));

                        confirmedAssemblies.add(confirmAssembly);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return confirmedAssemblies;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ConfirmAssemblyEntityObject> findBatched(Integer orderId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final int param_order_id = orderId;

            final List<ConfirmAssemblyEntityObject> assemblies = new ArrayList<ConfirmAssemblyEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select assembly.id, assembly.order_id, assembly.item_no, assembly.assembly_id, ");
                    query.append("assembly.barcode, assembly.batched, assembly.col, assembly.of_qty, assembly.place_po, ");
                    query.append("assembly.prod_end, assembly.prod_start, assembly.qty_no, assembly.row, assembly.shift, ");
                    query.append("assembly.stage, assembly.sub_batched, assembly.bom_id, assembly.item_bc_id, assembly.slot_no, ");
                    query.append("assembly.cart_no, assembly.assembly_shipped_id, assembly.reject_code_id, assembly.is_repair, ");
                    query.append("assembly.rush ");
                    query.append("from design_confirm_assemblies assembly ");
                    query.append("where assembly.order_id = ? and assembly.batched = 1 ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        ConfirmAssemblyEntityObject assembly = new ConfirmAssemblyEntityObject();
                        assembly.setId(rs.getInt("id"));
                        assembly.setOrderId(rs.getInt("order_id"));
                        assembly.setItemNo(rs.getInt("item_no"));
                        assembly.setAssemblyId(rs.getInt("assembly_id"));
                        assembly.setBarCode(rs.getString("barcode"));
                        assembly.setBatched(rs.getInt("batched"));
                        assembly.setCol(rs.getInt("col"));
                        assembly.setOfQty(rs.getInt("of_qty"));
                        assembly.setPlacePO(rs.getDate("place_po"));
                        assembly.setProdEnd(rs.getDate("prod_end"));
                        assembly.setProdStart(rs.getDate("prod_start"));
                        assembly.setQtyNo(rs.getInt("qty_no"));
                        assembly.setRow(rs.getInt("row"));
                        assembly.setShift(rs.getInt("shift"));
                        assembly.setStage(rs.getInt("stage"));
                        assembly.setSubBatched(rs.getInt("sub_batched"));
                        assembly.setBomId(rs.getInt("bom_id"));
                        assembly.setItemBarcode(rs.getString("item_bc_id"));
                        assembly.setSlotNumber(rs.getInt("slot_no"));
                        assembly.setCartNumber(rs.getInt("cart_no"));
                        assembly.setAssemblyShippedId(rs.getInt("assembly_shipped_id"));
                        assembly.setRejectCodeId(rs.getInt("reject_code_id"));
                        assembly.setRepair(rs.getBoolean("is_repair"));
                        assembly.setRush(rs.getBoolean("rush"));

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
    public List<ConfirmAssemblyEntityObject> findBatched(List<Integer> subBatches) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            if (subBatches.size() <= 0) {
                return new ArrayList<ConfirmAssemblyEntityObject>();
            }

            //Confirm Assembly Collection
            List<ConfirmAssemblyEntityObject> confirmAssemblies = em.createQuery("select c from ConfirmAssemblyEntityObject c where " +
                    "c.subBatched in (:subBatches)").
                    setParameter("subBatches", subBatches).getResultList();

            for (ConfirmAssemblyEntityObject confirmAssembly : confirmAssemblies) {
                Hibernate.initialize(confirmAssembly.getBom());

                confirmAssembly.setProdLine(confirmAssembly.getBom().getProdLine());
            }

            return confirmAssemblies;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ConfirmAssemblyEntityObject> findBatched(Integer prodLineId, Integer stationId, Integer shift, Date fromDate,
                                                         Date toDate, boolean groupQty) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final Integer param_prod_line = prodLineId;
            final Integer param_station = stationId;
            final Integer param_shift = shift;
            final Date param_from_date = fromDate;
            final Date param_to_date = toDate;
            final boolean param_group_qty = groupQty;

            //Array List to return
            final List<ConfirmAssemblyEntityObject> confirmedAssemblies = new ArrayList<ConfirmAssemblyEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    //*********************************************************************
                    //Construct Select Query
                    //*********************************************************************
                    StringBuffer selectQuery = new StringBuffer();

                    selectQuery.append("select assemblies.id as 'id', assemblies.order_id as 'order_id', ");
                    selectQuery.append("assemblies.item_no as 'item_no', assemblies.version_no as 'version_no', ");
                    selectQuery.append("assemblies.assembly_id as 'assembly_id', assemblies.barcode as 'barcode', ");
                    selectQuery.append("assemblies.batched as 'batched', assemblies.col as 'col', assemblies.of_qty as 'of_qty', ");
                    selectQuery.append("assemblies.place_po as 'place_po', assemblies.prod_end as 'prod_end', ");
                    selectQuery.append("assemblies.prod_start as 'prod_start', assemblies.qty_no as 'qty_no', ");
                    selectQuery.append("assemblies.row as 'row', assemblies.shift as 'shift', assemblies.stage as 'stage', ");
                    selectQuery.append("assemblies.sub_batched as 'sub_batched', assemblies.bom_id as 'bom_id', ");
                    selectQuery.append("assemblies.item_bc_id as 'item_bc', assemblies.slot_no as 'slot_no', ");
                    selectQuery.append("assemblies.cart_no as 'cart_no', assemblies.assembly_shipped_id as 'assembly_shipped_id', ");
                    selectQuery.append("assemblies.reject_code_id as 'reject_code_id', assemblies.is_repair as 'is_repair', ");
                    selectQuery.append("assemblies.rush as 'rush', station_usage.scheduledusedate as 'station_usage_schedule_date', ");
                    selectQuery.append("prodline.id as 'prod_line_id', prodstation.id as 'prod_station_id', ");
                    selectQuery.append("prodline.description as 'prod_line_desc', prodstation.description as 'station_desc', ");
                    selectQuery.append("b.id as 'batch_id', b.finalized as 'batch_finalized', b.released as 'batch_released', ");
                    selectQuery.append("b.inprod as 'batch_in_production', o.order_no as 'order_no', ");

                    if (param_group_qty) {
                        selectQuery.append("count(assemblies.id) as 'total_qty', sum(station_usage.usedcapacity) as 'station_usage_used_capacity' ");
                    } else {
                        selectQuery.append("station_usage.usedcapacity as 'station_usage_used_capacity' ");
                    }

                    selectQuery.append("from design_confirm_assemblies assemblies inner join batch_sub subbatch ");
                    selectQuery.append("on assemblies.sub_batched = subbatch.id inner join batch b ");
                    selectQuery.append("on subbatch.batchno = b.id inner join assembly_station_usage station_usage ");
                    selectQuery.append("on assemblies.barcode = station_usage.assemblyid inner join design_bill_of_materials bom ");
                    selectQuery.append("on assemblies.bom_id = bom.id inner join production_line prodline ");
                    selectQuery.append("on bom.prod_line = prodline.id inner join production_stations prodstation ");
                    selectQuery.append("on bom.station = prodstation.id inner join orders o ");
                    selectQuery.append("on assemblies.order_id = o.id ");
                    selectQuery.append("where b.prodstartdate >= ? and b.prodstartdate <= ? and b.shift = ? ");

                    if (param_prod_line > 0) {
                        selectQuery.append("and (prodline.id = ").append(param_prod_line).append(" ");
                        selectQuery.append("or prodline.parent = ").append(param_prod_line).append(") ");
                    }

                    if (param_station > 0) {
                        selectQuery.append("and prodstation.id = ").append(param_station).append(" ");
                    }

                    if (param_group_qty) {
                        selectQuery.append("group by prodline.id ");
                    }

                    PreparedStatement pstmt = connection.prepareStatement(selectQuery.toString());
                    pstmt.setDate(1, new java.sql.Date(param_from_date.getTime()));
                    pstmt.setDate(2, new java.sql.Date(param_to_date.getTime()));
                    pstmt.setInt(3, param_shift);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        ConfirmAssemblyEntityObject confirmAssembly = new ConfirmAssemblyEntityObject();
                        confirmAssembly.setId(rs.getInt("id"));
                        confirmAssembly.setOrderId(rs.getInt("order_id"));
                        confirmAssembly.setOrderNo(rs.getInt("order_no"));
                        confirmAssembly.setItemNo(rs.getInt("item_no"));
                        confirmAssembly.setVersionNo(rs.getInt("version_no"));
                        confirmAssembly.setAssemblyId(rs.getInt("assembly_id"));
                        confirmAssembly.setBarCode(rs.getString("barcode"));
                        confirmAssembly.setBatched(rs.getInt("batched"));
                        confirmAssembly.setCol(rs.getInt("col"));
                        confirmAssembly.setOfQty(rs.getInt("of_qty"));
                        confirmAssembly.setPlacePO(rs.getDate("place_po"));
                        confirmAssembly.setProdEnd(rs.getDate("prod_end"));
                        confirmAssembly.setProdStart(rs.getDate("prod_start"));
                        confirmAssembly.setQtyNo(rs.getInt("qty_no"));
                        confirmAssembly.setRow(rs.getInt("row"));
                        confirmAssembly.setShift(rs.getInt("shift"));
                        confirmAssembly.setStage(rs.getInt("stage"));
                        confirmAssembly.setSubBatched(rs.getInt("sub_batched"));
                        confirmAssembly.setBomId(rs.getInt("bom_id"));
                        confirmAssembly.setItemBarcode(rs.getString("item_bc"));
                        confirmAssembly.setSlotNumber(rs.getInt("slot_no"));
                        confirmAssembly.setCartNumber(rs.getInt("cart_no"));
                        confirmAssembly.setAssemblyShippedId(rs.getInt("assembly_shipped_id"));
                        confirmAssembly.setRejectCodeId(rs.getInt("reject_code_id"));
                        confirmAssembly.setRepair(rs.getBoolean("is_repair"));
                        confirmAssembly.setRush(rs.getBoolean("rush"));
                        confirmAssembly.setStationUsageSchedule(rs.getDate("station_usage_schedule_date"));
                        confirmAssembly.setUsedCapacity(rs.getInt("station_usage_used_capacity"));
                        confirmAssembly.setProdLine(rs.getInt("prod_line_id"));
                        confirmAssembly.setStation(rs.getInt("prod_station_id"));
                        confirmAssembly.setProdLineDesc(rs.getString("prod_line_desc"));
                        confirmAssembly.setStationDesc(rs.getString("station_desc"));
                        confirmAssembly.setBatchId(rs.getInt("batch_id"));
                        confirmAssembly.setFinalized(rs.getBoolean("batch_finalized"));
                        confirmAssembly.setReleased(rs.getBoolean("batch_released"));
                        confirmAssembly.setInProduction(rs.getBoolean("batch_in_production"));

                        if (param_group_qty) {
                            confirmAssembly.setOfQty(rs.getInt("total_qty"));
                        }

                        confirmedAssemblies.add(confirmAssembly);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return confirmedAssemblies;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ConfirmAssemblyEntityObject> retrieveConfirmAssemblies(List<Integer> subBatches, boolean groupQty)
            throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final boolean _param_groupQty = groupQty;

            //****************************************************
            //Prepared shifts param values
            //****************************************************
            String inString = "";
            for (Integer value : subBatches) {
                if (inString.length() == 0) {
                    inString = String.valueOf(value);
                } else {
                    inString = inString + "," + value;
                }
            }

            final String _param_subBatches = inString;

            //Array List to return
            final List<ConfirmAssemblyEntityObject> confirmedAssemblies = new ArrayList<ConfirmAssemblyEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    //*********************************************************************
                    //Construct Select Query
                    //*********************************************************************
                    StringBuffer selectQuery = new StringBuffer();

                    if (_param_groupQty) {
                        selectQuery.append(" select assemblies.id, assemblies.order_id, assemblies.item_no, ");
                        selectQuery.append(" assemblies.version_no, count(assemblies.qty_no) as qty_no, count(assemblies.of_qty) as of_qty, ");
                    } else {
                        selectQuery.append(" select assemblies.id, assemblies.order_id, assemblies.item_no, ");
                        selectQuery.append(" assemblies.version_no, assemblies.qty_no, assemblies.of_qty, ");
                    }

                    selectQuery.append(" assemblies.barcode, assemblies.prod_start, assemblies.prod_end, assemblies.shift, ");
                    selectQuery.append(" assemblies.rush, bom.description, bom.prod_line, bom.station, bom.assembly_id, ");
                    selectQuery.append(" bom.req_for_stage, bom.leaf_no, o.order_no, pl.description as 'prod_line_desc',  ");
                    selectQuery.append(" ps.description as 'station_desc' ");

                    //*********************************************************************
                    //Construct From Query
                    //*********************************************************************
                    StringBuffer fromQuery = new StringBuffer();
                    fromQuery.append(" from design_confirm_assemblies assemblies inner join design_bill_of_materials bom ");
                    fromQuery.append(" on assemblies.bom_id = bom.id ");
                    fromQuery.append(" left join parts p on bom.part_id = p.id ");
                    fromQuery.append(" inner join production_line pl on bom.prod_line = pl.id ");
                    fromQuery.append(" inner join production_stations ps on bom.station = ps.id ");
                    fromQuery.append(" inner join orders o on assemblies.order_id = o.id ");
                    fromQuery.append(" inner join order_items order_item on assemblies.order_id = order_item.order_id ");
                    fromQuery.append(" and assemblies.version_no = order_item.version_id and assemblies.item_no = order_item.item_id ");

                    //*********************************************************************
                    //Construct Where Query
                    //*********************************************************************
                    StringBuffer whereQuery = new StringBuffer();
                    whereQuery.append(" where assemblies.batched = 1 and assemblies.sub_batched in (" + _param_subBatches + ")");

                    //*********************************************************************
                    //Construct Group By Query
                    //*********************************************************************
                    StringBuffer groupByQuery = new StringBuffer();

                    if (_param_groupQty) {
                        groupByQuery.append(" group by assemblies.order_id, assemblies.item_no, assemblies.version_no, ");
                        groupByQuery.append(" assemblies.assembly_id, bom.leaf_no ");
                    }

                    //*********************************************************************
                    //Construct Final String query
                    //*********************************************************************
                    StringBuffer query = new StringBuffer();
                    query.append(selectQuery).append(fromQuery).append(whereQuery).append(groupByQuery);

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {

                        ConfirmAssemblyEntityObject confirmAssembly = new ConfirmAssemblyEntityObject();
                        confirmAssembly.setId(rs.getInt("id"));
                        confirmAssembly.setOrderId(rs.getInt("order_id"));
                        confirmAssembly.setItemNo(rs.getInt("item_no"));
                        confirmAssembly.setVersionNo(rs.getInt("version_no"));
                        confirmAssembly.setQtyNo(rs.getInt("qty_no"));
                        confirmAssembly.setOfQty(rs.getInt("of_qty"));
                        confirmAssembly.setBarCode(rs.getString("barcode"));
                        confirmAssembly.setProdStart(rs.getDate("prod_start"));
                        confirmAssembly.setProdEnd(rs.getDate("prod_end"));
                        confirmAssembly.setShift(rs.getInt("shift"));
                        confirmAssembly.setRush(rs.getBoolean("rush"));
                        confirmAssembly.setDescriptionParts(rs.getString("description"));
                        confirmAssembly.setProdLine(rs.getInt("prod_line"));
                        confirmAssembly.setStation(rs.getInt("station"));
                        confirmAssembly.setAssemblyId(rs.getInt("assembly_id"));
                        confirmAssembly.setStage(rs.getInt("req_for_stage"));
                        confirmAssembly.setLeafNo(rs.getInt("leaf_no"));
                        confirmAssembly.setOrderNo(rs.getInt("order_no"));
                        confirmAssembly.setProdLineDesc(rs.getString("prod_line_desc"));
                        confirmAssembly.setStationDesc(rs.getString("station_desc"));

                        confirmedAssemblies.add(confirmAssembly);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return confirmedAssemblies;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ConfirmAssemblyEntityObject> retrieveConfirmAssemblies(Integer orderNumber, Integer prodLine, Date prodStartDate,
                                                                       boolean onOrBefore, List<String> shifts,
                                                                       boolean groupQty) throws GenericPersistenceEAOException {
        try {

            //Init service
            initService();

            final Integer _param_order_number = orderNumber;
            final Integer _param_prod_line = prodLine;
            final Date _param_prodStartDate = prodStartDate;
            final boolean _param_onOrBefore = onOrBefore;
            final boolean _param_groupQty = groupQty;

            //****************************************************
            //Prepared shifts param values
            //****************************************************
            String inString = "";
            for (String value : shifts) {
                if (inString.length() == 0) {
                    inString = value;
                } else {
                    inString = inString + "," + value;
                }
            }

            final String _param_shifts = inString;

            //Array List to return
            final List<ConfirmAssemblyEntityObject> confirmedAssemblies = new ArrayList<ConfirmAssemblyEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    //*********************************************************************
                    //Construct Select Query
                    //*********************************************************************
                    StringBuffer selectQuery = new StringBuffer();

                    if (_param_groupQty) {
                        selectQuery.append(" select assemblies.id, assemblies.order_id, assemblies.item_no, ");
                        selectQuery.append(" assemblies.version_no, count(assemblies.qty_no) as qty_no, assemblies.of_qty, ");
                    } else {
                        selectQuery.append(" select assemblies.id, assemblies.order_id, assemblies.item_no, ");
                        selectQuery.append(" assemblies.version_no, assemblies.qty_no, assemblies.of_qty, ");
                    }

                    selectQuery.append(" assemblies.barcode, assemblies.prod_start, assemblies.prod_end, assemblies.shift, ");
                    selectQuery.append(" assemblies.rush, assemblies.item_bc_id, bom.description, bom.prod_line, bom.station, ");
                    selectQuery.append(" bom.assembly_id, bom.req_for_stage, bom.leaf_no, o.order_no, ");
                    selectQuery.append(" pl.description as 'prod_line_desc', ps.description as 'station_desc' ");

                    //*********************************************************************
                    //Construct From Query
                    //*********************************************************************
                    StringBuffer fromQuery = new StringBuffer();
                    fromQuery.append(" from design_confirm_assemblies assemblies inner join design_bill_of_materials bom ");
                    fromQuery.append(" on assemblies.bom_id = bom.id ");
                    fromQuery.append(" left join parts p on bom.part_id = p.id ");
                    fromQuery.append(" inner join production_line pl on bom.prod_line = pl.id ");
                    fromQuery.append(" inner join production_stations ps on bom.station = ps.id ");
                    fromQuery.append(" inner join orders o on assemblies.order_id = o.id ");
                    fromQuery.append(" inner join order_items order_item on assemblies.order_id = order_item.order_id ");
                    fromQuery.append(" and assemblies.version_no = order_item.version_id and assemblies.item_no = order_item.item_id ");

                    //*********************************************************************
                    //Construct Where Query
                    //*********************************************************************
                    StringBuffer whereQuery = new StringBuffer();
                    whereQuery.append(" where assemblies.batched = 0 and assemblies.shift in (?)");

                    //Adding param on or before prod start date
                    if (_param_onOrBefore) {
                        whereQuery.append(" and assemblies.prod_start <= ?");
                    } else {
                        whereQuery.append(" and assemblies.prod_start = ?");
                    }

                    //Adding param order number value
                    if (_param_order_number > 0) {
                        whereQuery.append(" and o.order_no = ").append(_param_order_number);
                    }

                    if (_param_prod_line > 0) {
                        whereQuery.append(" and bom.prod_line = ").append(_param_prod_line);
                    }

                    //*********************************************************************
                    //Construct Group By Query
                    //*********************************************************************
                    StringBuffer groupByQuery = new StringBuffer();

                    if (_param_groupQty) {
                        groupByQuery.append(" group by assemblies.order_id, assemblies.item_no, assemblies.version_no, ");
                        groupByQuery.append(" assemblies.assembly_id, bom.leaf_no ");
                    }

                    //*********************************************************************
                    //Construct Final String query
                    //*********************************************************************
                    StringBuffer query = new StringBuffer();
                    query.append(selectQuery).append(fromQuery).append(whereQuery).append(groupByQuery);

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setString(1, _param_shifts);
                    pstmt.setDate(2, new java.sql.Date(_param_prodStartDate.getTime()));

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {

                        ConfirmAssemblyEntityObject confirmAssembly = new ConfirmAssemblyEntityObject();
                        confirmAssembly.setId(rs.getInt("id"));
                        confirmAssembly.setOrderId(rs.getInt("order_id"));
                        confirmAssembly.setItemNo(rs.getInt("item_no"));
                        confirmAssembly.setVersionNo(rs.getInt("version_no"));
                        confirmAssembly.setQtyNo(rs.getInt("qty_no"));
                        confirmAssembly.setOfQty(rs.getInt("of_qty"));
                        confirmAssembly.setBarCode(rs.getString("barcode"));
                        confirmAssembly.setProdStart(rs.getDate("prod_start"));
                        confirmAssembly.setProdEnd(rs.getDate("prod_end"));
                        confirmAssembly.setShift(rs.getInt("shift"));
                        confirmAssembly.setRush(rs.getBoolean("rush"));
                        confirmAssembly.setItemBarcode(rs.getString("item_bc_id"));
                        confirmAssembly.setDescriptionParts(rs.getString("description"));
                        confirmAssembly.setProdLine(rs.getInt("prod_line"));
                        confirmAssembly.setStation(rs.getInt("station"));
                        confirmAssembly.setAssemblyId(rs.getInt("assembly_id"));
                        confirmAssembly.setStage(rs.getInt("req_for_stage"));
                        confirmAssembly.setLeafNo(rs.getInt("leaf_no"));
                        confirmAssembly.setOrderNo(rs.getInt("order_no"));
                        confirmAssembly.setProdLineDesc(rs.getString("prod_line_desc"));
                        confirmAssembly.setStationDesc(rs.getString("station_desc"));

                        confirmedAssemblies.add(confirmAssembly);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return confirmedAssemblies;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ConfirmAssemblyEntityObject> retrieveConfirmAssemblies(Integer subBatchId) throws GenericPersistenceEAOException {
        try {

            //Init service
            initService();

            List<ConfirmAssemblyEntityObject> assemblies = em.createQuery("select c from ConfirmAssemblyEntityObject c " +
                    "where c.subBatched = :subBatchId").setParameter("subBatchId", subBatchId).getResultList();

            if (assemblies != null && assemblies.size() > 0) {
                for (ConfirmAssemblyEntityObject assembly : assemblies) {
                    Hibernate.initialize(assembly.getBom());

                    assembly.setDescriptionParts(assembly.getBom().getDescription());
                    assembly.setProdLine(assembly.getBom().getProdLine());
                    assembly.setStation(assembly.getBom().getStation());
                    assembly.setPartId(assembly.getBom().getPartId());
                    assembly.setBomId(assembly.getBom().getBomId());
                }
            }

            return assemblies;

        } finally {
            closeService();
        }
    }

    @Override
    public void deleteForOrderEntry(Integer orderId, Integer versionId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final int param_order_id = orderId;
            final int param_version_id = versionId;

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("delete a from design_confirm_assemblies a where a.order_id = ? and a.version_no = ?");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_id);
                    pstmt.setInt(2, param_version_id);

                    pstmt.executeUpdate();

                    pstmt.close();
                }
            });

        } finally {
            closeService();
        }
    }

    @Override
    public void removeConfirmAssembly(int orderId, int itemNo, int versionNo, int qtyNo, int ofQty) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            em.createQuery("delete from ConfirmAssemblyEntityObject c where c.orderId = :orderId and c.itemNo = :itemNo and " +
                    "c.versionNo = :versionNo and c.qtyNo = :qtyNo and c.ofQty = :ofQty").
                    setParameter("orderId", orderId).
                    setParameter("itemNo", itemNo).
                    setParameter("versionNo", versionNo).
                    setParameter("qtyNo", qtyNo).
                    setParameter("ofQty", ofQty).executeUpdate();

        } finally {
            closeService();
        }
    }

	@Override
	public void deleteForOrderEntry(Integer orderId) throws GenericPersistenceEAOException {
		 try {

	            //Init service
	            initService();

	            //Execute query
	            em.createQuery("delete from ConfirmAssemblyEntityObject c "
	            		+ "where c.orderId = :orderId").setParameter("orderId", orderId).executeUpdate();

	        } finally {
	            closeService();
	        }
		
	}
}
