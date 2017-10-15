package openjanela.model.eao.design.billOfMaterialEAO;

import openjanela.model.PersistenceConfigProperties;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.BillOfMaterialEntityObject;
import openjanela.model.entities.production.ProductionLineStation;
import openjanela.model.entities.production.ProductionLineStationPK;
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
public class BillOfMaterialPersistenceEAO extends GenericPersistenceEAO<BillOfMaterialEntityObject, Integer> implements
        BillOfMaterialEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(BillOfMaterialPersistenceEAO.class);

    @Override
    public List<BillOfMaterialEntityObject> findByOrderId(Integer orderId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService(); //Query String
            String query = "select b from BillOfMaterialEntityObject b where b.orderId = :orderId";

            List<BillOfMaterialEntityObject> boms = em.createQuery(query).setParameter("orderId", orderId).
                    getResultList();

            //Initialize Parent Bill Of Materials
            for (BillOfMaterialEntityObject bom : boms) {
                Hibernate.initialize(bom.getParentBom());
            }

            return boms;

        } finally {
            closeService();
        }

    }

    @Override
    public List<BillOfMaterialEntityObject> findByBatch(Integer batchId, Integer prodLineId, Integer stationId,
                                                        boolean optimized) throws GenericPersistenceEAOException {
        try {

            //Init service
            initService();

            final int param_batch_id = batchId;
            final int param_prod_line_id = prodLineId;
            final int param_station_id = stationId;
            final boolean param_optimized = optimized;

            final List<BillOfMaterialEntityObject> boms = new ArrayList<BillOfMaterialEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    //***********************************************************************************************
                    //Find by Assembly relationship
                    //***********************************************************************************************
                    StringBuffer query = new StringBuffer();
                    query.append("select bom.*, subbatch.batchno, subbatch.id as 'subbatchid', assemblies.cart_no, ");
                    query.append("assemblies.slot_no, assemblies.barcode , assemblies.prod_start, p.stockuom, ");
                    query.append("assemblies.qty_no, assemblies.of_qty, ");
                    query.append("p.usageuom, p.usageuomconvert, p.usageuomconverti, p.trimcut, p.trimcuti ");
                    query.append("from design_bill_of_materials bom inner join design_confirm_assemblies assemblies ");
                    query.append("on bom.parent_bom_id = assemblies.bom_id ");
                    query.append("inner join batch_sub subbatch on assemblies.sub_batched = subbatch.id ");
                    query.append("inner join batch b on subbatch.batchno = b.id ");
                    query.append("inner join parts_family partFamily on bom.part_family = partFamily.id ");
                    query.append("inner join parts p on bom.part_id = p.id ");
                    query.append("where b.id = ? and bom.prod_line = ? and bom.station = ? and partFamily.print_details > 0 ");
                    if (param_optimized) {
                        query.append("and (p.part_type = 2 or p.part_type = 15) ");
                    }
                    query.append("order by bom.stock_code, assemblies.cart_no, assemblies.slot_no");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_batch_id);
                    pstmt.setInt(2, param_prod_line_id);
                    pstmt.setInt(3, param_station_id);

                    ResultSet rs = pstmt.executeQuery();

                    int pieceCount = 1;
                    while (rs.next()) {
                        BillOfMaterialEntityObject billOfMat = loadDataFromResultSet(rs);
                        billOfMat.setMasterStockCode(rs.getString("stock_code"));
                        billOfMat.setBatchId(rs.getInt("batchno"));
                        billOfMat.setSubBatchId(rs.getInt("subbatchid"));
                        billOfMat.setQtyNo(rs.getInt("qty_no"));
                        billOfMat.setOfQty(rs.getInt("of_qty"));
                        billOfMat.setCartNo(rs.getInt("cart_no"));
                        billOfMat.setSlotNo(rs.getInt("slot_no"));
                        billOfMat.setStockUOM(rs.getInt("stockuom"));
                        billOfMat.setUsageUOM(rs.getInt("usageuom"));
                        billOfMat.setUsageUOMConvert(rs.getDouble("usageuomconvert"));
                        billOfMat.setUsageUOMConvertI(rs.getDouble("usageuomconverti"));
                        billOfMat.setTrimcut(rs.getInt("trimcut"));
                        billOfMat.setTrimcutImp(rs.getInt("trimcuti"));
                        billOfMat.setPieceId(pieceCount);
                        billOfMat.setBarcode(rs.getString("barcode"));
                        billOfMat.setProdStartDate(rs.getDate("prod_start"));

                        boms.add(billOfMat);

                        pieceCount++;
                    }
                }
            });

            return boms;

        } finally {
            closeService();
        }
    }

    @Override
    public List<BillOfMaterialEntityObject> findNativeByOrderId(Integer orderId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final int param_order_value = orderId;
            final List<BillOfMaterialEntityObject> boms = new ArrayList<BillOfMaterialEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    StringBuffer query = new StringBuffer();
                    query.append("select * from design_bill_of_materials where order_id = ?");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_value);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        BillOfMaterialEntityObject bom = loadDataFromResultSet(rs);
                        boms.add(bom);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return boms;

        } finally {
            closeService();
        }
    }

    @Override
    public List<BillOfMaterialEntityObject> findNativeByOrderId(Integer orderId, Integer itemNo) throws
            GenericPersistenceEAOException {
        try {

            //Init service
            initService();

            final int param_order_value = orderId;
            final int param_item_no_value = itemNo;

            final List<BillOfMaterialEntityObject> boms = new ArrayList<BillOfMaterialEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    StringBuffer query = new StringBuffer();
                    query.append("select * from design_bill_of_materials where order_id = ? and item_no = ?");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_value);
                    pstmt.setInt(2, param_item_no_value);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        BillOfMaterialEntityObject bom = loadDataFromResultSet(rs);
                        boms.add(bom);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return boms;

        } finally {
            closeService();
        }
    }

    @Override
    public List<BillOfMaterialEntityObject> findNativeByOrderId(Integer orderId, Integer itemId, Integer versionId)
            throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final int param_order_id = orderId;
            final List<BillOfMaterialEntityObject> boms = new ArrayList<BillOfMaterialEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    StringBuffer query = new StringBuffer();
                    query.append("select bom.* ");
                    query.append("from design_bill_of_materials bom inner join parts p on bom.part_id = p.id ");
                    query.append("where bom.order_id = ? and (p.part_type >= 12 or p.part_type = 0) and ");
                    query.append("bom.station in (select ps.id from production_stations ps where ps.ship = 1)");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        BillOfMaterialEntityObject bom = loadDataFromResultSet(rs);
                        boms.add(bom);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return boms;

        } finally {
            closeService();
        }
    }

    @Override
    public List<BillOfMaterialEntityObject> findByTypeParts(Integer orderId, Integer itemId, Integer versionId,
                                                            Integer partTypeId) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final int param_order_id = orderId;
            final int param_item_id = itemId;
            final int param_version_id = versionId;
            final int param_part_type_id = partTypeId;

            final List<BillOfMaterialEntityObject> boms = new ArrayList<BillOfMaterialEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    StringBuffer query = new StringBuffer();
                    query.append("select bom.* ");
                    query.append("from  design_bill_of_materials bom inner join parts p on bom.part_id = p.id ");
                    query.append(" where bom.order_id = ? and bom.item_no = ? and bom.version_id = ? and p.part_type = ?");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_id);
                    pstmt.setInt(2, param_item_id);
                    pstmt.setInt(3, param_version_id);
                    pstmt.setInt(4, param_part_type_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        BillOfMaterialEntityObject bom = loadDataFromResultSet(rs);
                        boms.add(bom);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return boms;

        } finally {
            closeService();
        }
    }

    @Override
    public List<BillOfMaterialEntityObject> findNativeShipment(Integer orderId) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final int param_order_id = orderId;
            final List<BillOfMaterialEntityObject> boms = new ArrayList<BillOfMaterialEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    StringBuffer query = new StringBuffer();
                    query.append("select bom.* ");
                    query.append("from design_bill_of_materials bom inner join parts p on bom.part_id = p.id ");
                    query.append("where bom.order_id = ? and (p.part_type >= 12 or p.part_type = 0) and ");
                    query.append("bom.station in (select ps.id from production_stations ps where ps.ship = 1)");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        BillOfMaterialEntityObject bom = loadDataFromResultSet(rs);
                        boms.add(bom);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return boms;

        } finally {
            closeService();
        }
    }

    @Override
    public List<BillOfMaterialEntityObject> findStockCodes(Integer orderId, Integer itemId, Integer parentBomId,
                                                           boolean isGlassBom) throws GenericPersistenceEAOException {
        try {

            //Init service
            initService();

            final int param_order_value = orderId;
            final int param_item_no_value = itemId;
            final int param_parent_bom_value = parentBomId;
            final boolean param_glass_bom_value = isGlassBom;

            final List<BillOfMaterialEntityObject> boms = new ArrayList<BillOfMaterialEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    StringBuffer query = new StringBuffer();

                    if (param_glass_bom_value) {
                        query.append("select bom.rule_no, bom.part_id, bom.stock_code, bom.order_id, bom.item_no, bom.version_id, bom.station, ");
                        query.append("bom.process_id, bom.parent_bom_id, bom.is_buy, bom.req_for_stage, sum(bom.cut_length) as 'cut_length', ");
                        query.append("sum(bom.cut_length_i) as 'cut_length_i', sum(bom.width) as 'width', sum(bom.width_i) as 'width_i', ");
                        query.append("sum(bom.height) as 'height', sum(bom.height_i) as 'height_i', sum(bom.area) as 'area', ");
                        query.append("sum(bom.area_i) as 'area_i', sum(bom.area_user) as 'area_user', sum(bom.depth) as 'depth', ");
                        query.append("sum(bom.depth_i) as 'depth_i', sum(bom.cut_length_user) as 'cut_length_user', ");
                        query.append("sum(bom.cut_length_i_user) as 'cut_length_i_user', sum(bom.depth_user) as 'depth_user', ");
                        query.append("sum(height_i_user) as 'height_i_user', sum(height_user) as 'height_user', sum(width_i_user) as 'width_i_user', ");
                        query.append("sum(width_user) as 'width_user', bom.prod_line, ");
                        query.append("sum(bom.qty) as 'qty', bom.supplier_id, bom.lead_time ");
                        query.append("from design_bill_of_materials bom ");
                        query.append("where bom.order_id = ? and bom.item_no = ? and bom.parent_bom_id = ? ");
                        query.append("and bom.rule_no = -100 ");
                        query.append("group by bom.stock_code ");
                        query.append("order by bom.stock_code, bom.prod_line, bom.station");
                    } else {

                        query.append("select bom.rule_no, bom.part_id, bom.stock_code, bom.order_id, bom.item_no, bom.version_id, bom.station, ");
                        query.append("bom.process_id, bom.parent_bom_id, bom.is_buy, bom.req_for_stage, sum(bom.cut_length) as 'cut_length', ");
                        query.append("sum(bom.cut_length_i) as 'cut_length_i', sum(bom.width) as 'width', sum(bom.width_i) as 'width_i', ");
                        query.append("sum(bom.height) as 'height', sum(bom.height_i) as 'height_i', sum(bom.area) as 'area', ");
                        query.append("sum(bom.area_i) as 'area_i', sum(bom.area_user) as 'area_user', sum(bom.depth) as 'depth', ");
                        query.append("sum(bom.depth_i) as 'depth_i', sum(bom.cut_length_user) as 'cut_length_user', ");
                        query.append("sum(bom.cut_length_i_user) as 'cut_length_i_user', sum(bom.depth_user) as 'depth_user', ");
                        query.append("sum(height_i_user) as 'height_i_user', sum(height_user) as 'height_user', sum(width_i_user) as 'width_i_user', ");
                        query.append("sum(width_user) as 'width_user', bom.prod_line, ");
                        query.append("sum(bom.qty) as 'qty', p.masterstockcode, pt.process_lt, bom.supplier_id, bom.lead_time ");
                        query.append("from design_bill_of_materials bom inner join parts p on bom.part_id = p.id ");
                        query.append("inner join openjanela.type_part tp on p.part_type = tp.id ");
                        query.append("left join type_process pt on bom.process_id = pt.id ");
                        query.append("where bom.order_id = ? and ");
                        query.append("bom.item_no = ? and ");
                        query.append("bom.parent_bom_id = ? and ");
                        query.append("tp.systemtype = 1 and ");
                        query.append("bom.rule_no <> -100 ");
                        query.append("group by bom.stock_code ");
                        query.append("order by bom.stock_code, bom.prod_line, bom.station ");

                    }

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_value);
                    pstmt.setInt(2, param_item_no_value);
                    pstmt.setInt(3, param_parent_bom_value);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {

                        //Load Bill of Material Entity Object
                        BillOfMaterialEntityObject bom = new BillOfMaterialEntityObject();
                        bom.setRuleNo(rs.getInt("rule_no"));
                        bom.setPartId(rs.getInt("part_id"));
                        bom.setStockCode(rs.getString("stock_code"));
                        bom.setOrderId(rs.getInt("order_id"));
                        bom.setItemNo(rs.getInt("item_no"));
                        bom.setVersionId(rs.getInt("version_id"));
                        bom.setBuy(rs.getBoolean("is_buy"));
                        bom.setProdLine(rs.getInt("prod_line"));
                        bom.setStation(rs.getInt("station"));
                        bom.setProcessId(rs.getInt("process_id"));
                        bom.setParentBomId(rs.getInt("parent_bom_id"));
                        bom.setReqForStage(rs.getInt("req_for_stage"));
                        bom.setCutLength(rs.getInt("cut_length"));
                        bom.setCutLengthI(rs.getInt("cut_length_i"));
                        bom.setCutLengthIUser(rs.getInt("cut_length_i_user"));
                        bom.setCutLengthUser(rs.getInt("cut_length_user"));
                        bom.setWidth(rs.getInt("width"));
                        bom.setWidthI(rs.getInt("width_i"));
                        bom.setWidthIUser(rs.getInt("width_i_user"));
                        bom.setWidthUser(rs.getInt("width_user"));
                        bom.setHeight(rs.getInt("height"));
                        bom.setHeightI(rs.getInt("height_i"));
                        bom.setHeightIUser(rs.getInt("height_i_user"));
                        bom.setHeightUser(rs.getInt("height_user"));
                        bom.setArea(rs.getInt("area"));
                        bom.setAreaI(rs.getInt("area_i"));
                        bom.setAreaUser(rs.getInt("area_user"));
                        bom.setDepth(rs.getInt("depth"));
                        bom.setDepthI(rs.getInt("depth_i"));
                        bom.setQty(rs.getInt("qty"));
                        bom.setSupplierId(rs.getInt("supplier_id"));
                        bom.setLeadtime(rs.getInt("lead_time"));

                        //Load process Lead Time for parts
                        if (!param_glass_bom_value) {
                            bom.setMasterStockCode(rs.getString("masterstockcode"));
                            bom.setProcessLT(rs.getInt("process_lt"));
                        }

                        boms.add(bom);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return boms;

        } finally {
            closeService();
        }
    }

    @Override
    public List<BillOfMaterialEntityObject> findGlassAculiteMachine(Integer batchId, Integer prodLine, Integer stationId)
            throws GenericPersistenceEAOException {
        try {

            //Init service
            initService();

            final int param_batch_id = batchId;
            final int param_prod_line_id = prodLine;
            final int param_station_id = stationId;

            final List<BillOfMaterialEntityObject> boms = new ArrayList<BillOfMaterialEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    StringBuffer query = new StringBuffer();
                    query.append("select bom.id, ");
                    query.append("bom.order_id, ");
                    query.append("bom.stock_code, ");
                    query.append("bom.description, ");
                    query.append("bom.qty, ");
                    query.append("bom.shape_id, ");
                    query.append("bom.part_id, ");
                    query.append("bom.rule_no, ");
                    query.append("bom.sash, ");
                    query.append("bom.opening_id, ");
                    query.append("bom.position, ");
                    query.append("bom.level, ");
                    query.append("bom.level_id, ");
                    query.append("glass.width_m, ");
                    query.append("glass.width_i, ");
                    query.append("glass.height_m, ");
                    query.append("glass.height_i, ");
                    query.append("glass.num_of_leaves, ");
                    query.append("glass_leaf1.id as 'leaf1_id', ");
                    query.append("glass_leaf1.stockcode as 'leaf1_stockcode', ");
                    query.append("glass_leaf1.description as 'leaf1_description', ");
                    query.append("glass_leaf1.made_in as 'leaf1_made_in', ");
                    query.append("glass_leaf2.id as 'leaf2_id', ");
                    query.append("glass_leaf2.stockcode as 'leaf2_stockcode', ");
                    query.append("glass_leaf2.description as 'leaf2_description',");
                    query.append("glass_leaf2.made_in as 'leaf2_made_in', ");
                    query.append("glass_leaf3.id as 'leaf3_id', ");
                    query.append("glass_leaf3.stockcode as 'leaf3_stockcode', ");
                    query.append("glass_leaf3.description as 'leaf3_description', ");
                    query.append("glass_leaf3.made_in as 'leaf3_made_in', ");
                    query.append("glass_leaf4.id as 'leaf4_id', ");
                    query.append("glass_leaf4.stockcode as 'leaf4_stockcode', ");
                    query.append("glass_leaf4.description as 'leaf4_description', ");
                    query.append("glass_leaf4.made_in as 'leaf4_made_in', ");
                    query.append("o.order_no, ");
                    query.append("assemblies.item_no, ");
                    query.append("assemblies.version_no, ");
                    query.append("assemblies.qty_no, ");
                    query.append("assemblies.of_qty, ");
                    query.append("assemblies.cart_no, ");
                    query.append("assemblies.slot_no, ");
                    query.append("assemblies.sub_batched, ");
                    query.append("assemblies.barcode ");
                    query.append("from design_bill_of_materials bom inner join design_glass glass on bom.glass_bom_id = glass.id ");
                    query.append("inner join orders o on bom.order_id = o.id ");
                    query.append("left join su_type glass_leaf1 on glass.leaf_1 = glass_leaf1.id ");
                    query.append("left join su_type glass_leaf2 on glass.leaf_2 = glass_leaf2.id ");
                    query.append("left join su_type glass_leaf3 on glass.leaf_3 = glass_leaf3.id ");
                    query.append("left join su_type glass_leaf4 on glass.leaf_4 = glass_leaf4.id ");
                    query.append("left join design_confirm_assemblies assemblies on bom.id = assemblies.bom_id ");
                    query.append("left join batch_sub subbatch on assemblies.sub_batched = subbatch.id ");
                    query.append("where subbatch.batchno = ? and bom.is_buy = 0 and ");
                    query.append("bom.prod_line = ? ");
                    query.append("order by o.order_no, ");
                    query.append("assemblies.item_no, ");
                    query.append("assemblies.version_no, ");
                    query.append("assemblies.qty_no, ");
                    query.append("assemblies.of_qty");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setString(1, String.valueOf(param_batch_id));
                    pstmt.setInt(2, param_prod_line_id);

                    ResultSet rs = pstmt.executeQuery();

                    while(rs.next()) {
                        BillOfMaterialEntityObject bom = new BillOfMaterialEntityObject();
                        bom.setId(rs.getInt("id"));
                        bom.setOrderId(rs.getInt("order_id"));
                        bom.setStockCode(rs.getString("stock_code"));
                        bom.setDescription(rs.getString("description"));
                        bom.setQty(rs.getInt("qty"));
                        bom.setShapeId(rs.getInt("shape_id"));
                        bom.setPartId(rs.getInt("part_id"));
                        bom.setRuleNo(rs.getInt("rule_no"));
                        bom.setSash(rs.getInt("sash"));
                        bom.setOpeningId(rs.getInt("opening_id"));
                        bom.setPosition(rs.getInt("position"));
                        bom.setLevel(rs.getInt("level"));
                        bom.setLevelId(rs.getInt("level_id"));
                        bom.setWidth(rs.getInt("width_m"));
                        bom.setWidthI(rs.getInt("width_i"));
                        bom.setHeight(rs.getInt("height_m"));
                        bom.setHeightI(rs.getInt("height_i"));
                        bom.setOrderNo(rs.getInt("order_no"));
                        bom.setItemNo(rs.getInt("item_no"));
                        bom.setVersionId(rs.getInt("version_no"));
                        bom.setQtyNo(rs.getInt("qty_no"));
                        bom.setOfQty(rs.getInt("of_qty"));
                        bom.setCartNo(rs.getInt("cart_no"));
                        bom.setSlotNo(rs.getInt("slot_no"));
                        bom.setNumOfLeaves(rs.getInt("num_of_leaves"));
                        bom.setLeafNo1(rs.getInt("leaf1_id"));
                        bom.setLeafNo1_stockCode(rs.getString("leaf1_stockcode"));
                        bom.setLeafNo1_description(rs.getString("leaf1_description"));
                        bom.setLeafNo1_madein(rs.getBoolean("leaf1_made_in"));
                        bom.setLeafNo2(rs.getInt("leaf2_id"));
                        bom.setLeafNo2_stockCode(rs.getString("leaf2_stockcode"));
                        bom.setLeafNo2_description(rs.getString("leaf2_description"));
                        bom.setLeafNo2_madein(rs.getBoolean("leaf2_made_in"));
                        bom.setLeafNo3(rs.getInt("leaf3_id"));
                        bom.setLeafNo3_stockCode(rs.getString("leaf3_stockcode"));
                        bom.setLeafNo3_description(rs.getString("leaf3_description"));
                        bom.setLeafNo3_madein(rs.getBoolean("leaf3_made_in"));
                        bom.setLeafNo4(rs.getInt("leaf4_id"));
                        bom.setLeafNo4_stockCode(rs.getString("leaf4_stockcode"));
                        bom.setLeafNo4_description(rs.getString("leaf4_description"));
                        bom.setLeafNo4_madein(rs.getBoolean("leaf4_made_in"));
                        bom.setSubBatchId(rs.getInt("sub_batched"));
                        bom.setBarcode(rs.getString("barcode"));
                        bom.setBomId(rs.getInt("id"));

                        boms.add(bom);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return boms;

        } finally {
            closeService();
        }
    }

    @Override
    public List<BillOfMaterialEntityObject> findByPartIdentification(Date dateRequired, Integer partId, Integer orderStatus)
            throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final Date param_date_required = dateRequired;
            final int param_part_id = partId;
            final int param_order_status = orderStatus;

            final List<BillOfMaterialEntityObject> boms = new ArrayList<BillOfMaterialEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select bom.*, items.partid, items.shipqty, items.quantity, o.probability, stock_sup.orderuom, ");
                    query.append("stock_sup.uomconvert ");
                    query.append("from design_bill_of_materials bom inner join order_items items ");
                    query.append("on bom.order_id = items.order_id and bom.item_no = items.item_id and ");
                    query.append("bom.version_id = items.version_id ");
                    query.append("inner join orders o on items.order_id = o.id ");
                    query.append("inner join stock_records stock on bom.part_id = stock.partid ");
                    query.append("inner join stock_supplier stock_sup on stock.id = stock_sup.stockid ");
                    query.append("where stock.partid = ? and o.statusid = ? and o.daterequired <= ? ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_part_id);
                    pstmt.setInt(2, param_order_status);
                    pstmt.setDate(3, new java.sql.Date(param_date_required.getTime()));

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        BillOfMaterialEntityObject bom = loadDataFromResultSet(rs);
                        bom.setQtyNo(rs.getInt("shipqty"));
                        bom.setOfQty(rs.getInt("quantity"));
                        bom.setOrderUOM(rs.getInt("orderuom"));
                        bom.setUomConvert(rs.getDouble("uomconvert"));
                        bom.setOrderProbability(rs.getDouble("probability"));

                        boms.add(bom);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return boms;

        } finally {
            closeService();
        }
    }

    @Override
    public List<BillOfMaterialEntityObject> findByParentAssembly(Integer parentBomId, Integer stationId)
            throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final int param_parent_bom_id = parentBomId;
            final int param_station_id = stationId;

            final List<BillOfMaterialEntityObject> boms = new ArrayList<BillOfMaterialEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select bom.* ");
                    query.append("from design_bill_of_materials bom inner join design_bill_of_materials parent_bom ");
                    query.append("on bom.parent_bom_id = parent_bom.id inner join design_job_item job_item ");
                    query.append("on parent_bom.job_item_id = job_item.id inner join parts_family pf on ");
                    query.append("bom.part_family = pf.id ");
                    query.append("where parent_bom.id = ? and (pf.print_details = 1 || pf.print_details = 2) and ");
                    query.append("bom.station = ? ");
                    query.append("order by bom.id ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_parent_bom_id);
                    pstmt.setInt(2, param_station_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        boms.add(loadDataFromResultSet(rs));
                    }

                    pstmt.close();
                    rs.close();

                }
            });

            return boms;

        } finally {
            closeService();
        }
    }

    @Override
    public List<BillOfMaterialEntityObject> findAssemblyByParentBomId(Integer parentBomId) throws GenericPersistenceEAOException {
        try {

            //Init Service
            initService();

            final int param_parent_bom_id = parentBomId;

            final List<BillOfMaterialEntityObject> assemblies = new ArrayList<BillOfMaterialEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select bom.id, bom.rule_no, bom.description, bom.stock_code, bom.qty, bom.cut_length, ");
                    query.append("bom.cut_length_i, bom.radius_1, bom.radius_1_i, bom.radius_2, bom.radius_2_i, ");
                    query.append("bom.position, bom.orientation, bom.notches, bom.notches_i, bom.notches_i_y ");
                    query.append("from design_bill_of_materials bom inner join design_bill_of_materials parent_bom ");
                    query.append("on bom.parent_bom_id = parent_bom.id ");
                    query.append("where parent_bom.id = ? and bom.is_assembly_bom = 1 ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_parent_bom_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        BillOfMaterialEntityObject assembly = new BillOfMaterialEntityObject();
                        assembly.setId(rs.getInt("id"));
                        assembly.setRuleNo(rs.getInt("rule_no"));
                        assembly.setDescription(rs.getString("description"));
                        assembly.setStockCode(rs.getString("stock_code"));
                        assembly.setQty(rs.getInt("qty"));
                        assembly.setCutLength(rs.getInt("cut_length"));
                        assembly.setCutLengthI(rs.getInt("cut_length_i"));
                        assembly.setRadius1(rs.getInt("radius_1"));
                        assembly.setRadius1I(rs.getInt("radius_1_i"));
                        assembly.setRadius2(rs.getInt("radius_2"));
                        assembly.setRadius2(rs.getInt("radius_2_i"));
                        assembly.setPosition(rs.getInt("position"));
                        assembly.setOrientation(rs.getInt("orientation"));
                        assembly.setNotchesM(rs.getString("notches"));
                        assembly.setNotchesI(rs.getString("notches_i"));
                        assembly.setNotchesIY(rs.getString("notches_i_y"));

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

    @Override
    public List<BillOfMaterialEntityObject> findGridsBomByParentBomId(Integer parentBomId) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final int param_parent_bom_id = parentBomId;

            final List<BillOfMaterialEntityObject> gridBoms = new ArrayList<BillOfMaterialEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select bom.id, bom.rule_no, bom.description, bom.stock_code, bom.qty, bom.cut_length, ");
                    query.append("bom.cut_length_i, bom.radius_1, bom.radius_1_i, bom.radius_2, bom.radius_2_i, ");
                    query.append("bom.position, bom.orientation, bom.notches, bom.notches_i, bom.notches_i_y ");
                    query.append("from design_bill_of_materials bom ");
                    query.append("where bom.parent_bom_id = ? ");
                    query.append("order by bom.orientation");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_parent_bom_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        BillOfMaterialEntityObject gridBom = new BillOfMaterialEntityObject();
                        gridBom.setId(rs.getInt("id"));
                        gridBom.setRuleNo(rs.getInt("rule_no"));
                        gridBom.setDescription(rs.getString("description"));
                        gridBom.setStockCode(rs.getString("stock_code"));
                        gridBom.setQty(rs.getInt("qty"));
                        gridBom.setCutLength(rs.getInt("cut_length"));
                        gridBom.setCutLengthI(rs.getInt("cut_length_i"));
                        gridBom.setRadius1(rs.getInt("radius_1"));
                        gridBom.setRadius1I(rs.getInt("radius_1_i"));
                        gridBom.setRadius2(rs.getInt("radius_2"));
                        gridBom.setRadius2(rs.getInt("radius_2_i"));
                        gridBom.setPosition(rs.getInt("position"));
                        gridBom.setOrientation(rs.getInt("orientation"));
                        gridBom.setNotchesM(rs.getString("notches"));
                        gridBom.setNotchesI(rs.getString("notches_i"));
                        gridBom.setNotchesIY(rs.getString("notches_i_y"));

                        gridBoms.add(gridBom);
                    }

                    rs.close();
                    pstmt.close();
                }
            });

            return gridBoms;

        } finally {
            closeService();
        }
    }

    @Override
    public List<BillOfMaterialEntityObject> findGlassBomByParentBomId(String parentBomIds) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final String param_parent_bom_id = parentBomIds;

            final List<BillOfMaterialEntityObject> glassBoms = new ArrayList<BillOfMaterialEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select bom.id, bom.rule_no, bom.qty, bom.cut_length, bom.cut_length_i, ");
                    query.append("bom.radius_1, bom.radius_1_i, bom.radius_2, bom.radius_2_i, glass.stock_code, ");
                    query.append("glass.description, glass.width_i, glass.width_m, glass.height_i, glass.height_m, ");
                    query.append("c.r_rgb, c.g_rgb, c.b_rgb, c.a_rgb ");
                    query.append("from design_bill_of_materials bom inner join design_glass glass ");
                    query.append("on bom.glass_bom_id = glass.id ");
                    query.append("inner join su_type su on glass.su_id = su.id ");
                    query.append("left join color c on su.flag_color = c.id ");
                    query.append("where bom.parent_bom_id in (").append(param_parent_bom_id).append(")") ;

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        BillOfMaterialEntityObject glassBom = new BillOfMaterialEntityObject();
                        glassBom.setId(rs.getInt("id"));
                        glassBom.setRuleNo(rs.getInt("rule_no"));
                        glassBom.setQty(rs.getInt("qty"));
                        glassBom.setCutLength(rs.getInt("cut_length"));
                        glassBom.setCutLengthI(rs.getInt("cut_length_i"));
                        glassBom.setRadius1(rs.getInt("radius_1"));
                        glassBom.setRadius1I(rs.getInt("radius_1_i"));
                        glassBom.setRadius2(rs.getInt("radius_2"));
                        glassBom.setRadius2(rs.getInt("radius_2_i"));
                        glassBom.setStockCode(rs.getString("stock_code"));
                        glassBom.setDescription(rs.getString("description"));
                        glassBom.setWidthI(rs.getInt("width_i"));
                        glassBom.setWidth(rs.getInt("width_m"));
                        glassBom.setHeightI(rs.getInt("height_i"));
                        glassBom.setHeight(rs.getInt("height_m"));
                        glassBom.setGlass_r(rs.getInt("r_rgb"));
                        glassBom.setGlass_g(rs.getInt("g_rgb"));
                        glassBom.setGlass_b(rs.getInt("b_rgb"));
                        glassBom.setGlass_a(rs.getInt("a_rgb"));

                        glassBoms.add(glassBom);
                    }

                    rs.close();
                    pstmt.close();
                }
            });

            return glassBoms;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ProductionLineStation> findBOMStationsByBatch(Integer batchId) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final int param_batch_id = batchId;

            final List<ProductionLineStation> prodLineStations = new ArrayList<ProductionLineStation>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select distinct(prodstation.id) as 'prod_station_id', ");
                    query.append("prodstation.description as 'prod_station_desc', ");
                    query.append("prodline.id as 'prod_line_id', ");
                    query.append("prodline.description as 'prod_line_desc', ");
                    query.append("prodline.parent as 'prod_line_parent' ");
                    query.append("from design_bill_of_materials bom inner join parts p on bom.part_id = p.id ");
                    query.append("inner join production_line prodline on bom.prod_line = prodline.id ");
                    query.append("inner join production_stations prodstation on bom.station = prodstation.id ");
                    query.append("inner join design_confirm_assemblies assembly on bom.parent_bom_id = assembly.bom_id ");
                    query.append("inner join batch_sub subbatch on assembly.sub_batched = subbatch.id ");
                    query.append("where subbatch.batchno = ? ");
                    query.append("order by	prodstation.id ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_batch_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        ProductionLineStationPK prodLineStationPK = new ProductionLineStationPK();
                        prodLineStationPK.setProdlineid(rs.getInt("prod_line_id"));
                        prodLineStationPK.setStationid(rs.getInt("prod_station_id"));

                        ProductionLineStation productionLineStation = new ProductionLineStation();
                        productionLineStation.setId(prodLineStationPK);
                        productionLineStation.setProdLineParent(rs.getInt("prod_line_parent"));

                        prodLineStations.add(productionLineStation);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return prodLineStations;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ProductionLineStation> findBOMStationsFromPartFamily(Integer batchId) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final int param_batch_id = batchId;

            final List<ProductionLineStation> prodLineStations = new ArrayList<ProductionLineStation>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select distinct(bom.prod_line) as 'prod_line_id', ");
                    query.append("pfs.station_id as 'prod_station_id', ");
                    query.append("prodline.description as 'prod_line_desc', ");
                    query.append("stations.description as 'prod_station_desc' ");
                    query.append("from parts_family_station pfs inner join parts_family pf ");
                    query.append("on pfs.part_family_id = pf.id ");
                    query.append("inner join design_bill_of_materials bom ");
                    query.append("on bom.part_family = pf.id ");
                    query.append("inner join design_confirm_assemblies assemblies ");
                    query.append("on bom.id = assemblies.bom_id ");
                    query.append("inner join batch_sub subbatch ");
                    query.append("on assemblies.sub_batched = subbatch.id ");
                    query.append("inner join batch b ");
                    query.append("on subbatch.batchno = b.id ");
                    query.append("inner join production_line prodline ");
                    query.append("on bom.prod_line = prodline.id ");
                    query.append("inner join production_stations stations ");
                    query.append("on pfs.station_id = stations.id ");
                    query.append("where b.id = ?");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_batch_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        ProductionLineStationPK prodLineStationPK = new ProductionLineStationPK();
                        prodLineStationPK.setProdlineid(rs.getInt("prod_line_id"));
                        prodLineStationPK.setStationid(rs.getInt("prod_station_id"));

                        ProductionLineStation productionLineStation = new ProductionLineStation();
                        productionLineStation.setId(prodLineStationPK);

                        prodLineStations.add(productionLineStation);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return prodLineStations;

        } finally {
            closeService();
        }
    }

    @Override
    public List<BillOfMaterialEntityObject> findForDealer(Integer orderId, Integer itemId, Integer versionId)
            throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            final int param_order_id = orderId;
            final int param_item_id = itemId;
            final int param_version_id = versionId;

            final List<BillOfMaterialEntityObject> bom = new ArrayList<BillOfMaterialEntityObject>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select bom.* ");
                    query.append("from design_bill_of_materials bom ");
                    query.append("where bom.order_id = ? and bom.item_no = ? and bom.version_id = ? and bom.remote = 0 ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_id);
                    pstmt.setInt(2, param_item_id);
                    pstmt.setInt(3, param_version_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        BillOfMaterialEntityObject billOfMat = loadDataFromResultSet(rs);
                        bom.add(billOfMat);
                    }

                    pstmt.close();
                    rs.close();
                }
            });

            return bom;

        } finally {
            closeService();
        }
    }

    //******************************************************************************************************************
    //************************************************<Private Execution>***********************************************
    //******************************************************************************************************************

    /**
     * Load data information from ResultSet
     *
     * @param rs, ResultSet
     * @return BillOfMaterialEntityObject
     * @throws java.sql.SQLException, Exception
     */
    public BillOfMaterialEntityObject loadDataFromResultSet(ResultSet rs) throws SQLException {

        BillOfMaterialEntityObject bom = new BillOfMaterialEntityObject();
        bom.setId(rs.getInt("id"));
        bom.setAddon(rs.getBoolean("is_addon"));
        bom.setArea(rs.getDouble("area"));
        bom.setAreaI(rs.getDouble("area_i"));
        bom.setAreaIUser(rs.getDouble("area_i_user"));
        bom.setAreaUser(rs.getDouble("area_user"));
        bom.setAssemblyBom(rs.getBoolean("is_assembly_bom"));
        bom.setAssemblyId(rs.getInt("assembly_id"));
        bom.setAssemblyLevelId(rs.getInt("assembly_level_id"));
        bom.setBuy(rs.getBoolean("is_buy"));
        bom.setCol(rs.getInt("col"));
        bom.setCost(rs.getBigDecimal("cost"));
        bom.setCutLength(rs.getInt("cut_length"));
        bom.setCutLengthI(rs.getInt("cut_length_i"));
        bom.setCutLengthIUser(rs.getInt("cut_length_i_user"));
        bom.setCutLengthUser(rs.getInt("cut_length_user"));
        bom.setDelivery(rs.getInt("delivery"));
        bom.setDepth(rs.getInt("depth"));
        bom.setDepthI(rs.getInt("depth_i"));
        bom.setDepthIUser(rs.getInt("depth_i_user"));
        bom.setDepthUser(rs.getInt("depth_user"));
        bom.setDescription(rs.getString("description"));
        bom.setDescriptionUser(rs.getString("description_user"));
        bom.setHeight(rs.getInt("height"));
        bom.setHeightI(rs.getInt("height_i"));
        bom.setHeightIUser(rs.getInt("height_i_user"));
        bom.setHeightUser(rs.getInt("height_user"));
        bom.setWildColor(rs.getBoolean("is_wild_color"));
        bom.setWildDepth(rs.getBoolean("is_wild_depth"));
        bom.setWildSize(rs.getBoolean("is_wild_size"));
        bom.setItemNo(rs.getInt("item_no"));
        bom.setLeadtime(rs.getInt("lead_time"));
        bom.setLeftAngle(rs.getDouble("left_angle"));
        bom.setLeftCut(rs.getInt("left_cut"));
        bom.setLevel(rs.getInt("level"));
        bom.setLevelId(rs.getInt("level_id"));
        bom.setOpeningId(rs.getInt("opening_id"));
        bom.setOrderId(rs.getInt("order_id"));
        bom.setOrientation(rs.getInt("orientation"));
        bom.setStartPos(rs.getInt("start_pos"));
        bom.setEndPos(rs.getInt("end_pos"));
        bom.setParentAssemblyId(rs.getInt("parent_assembly_id"));
        bom.setParentCol(rs.getInt("parent_col"));
        bom.setParentRow(rs.getInt("parent_row"));
        bom.setParentRule(rs.getInt("parent_rule"));
        bom.setPartFamily(rs.getInt("part_family"));
        bom.setPartId(rs.getInt("part_id"));
        bom.setPosition(rs.getInt("position"));
        bom.setPrice(rs.getBigDecimal("price"));
        bom.setPriceCat(rs.getInt("price_cat"));
        bom.setPriceGroup(rs.getInt("price_group"));
        bom.setPriceUser(rs.getBigDecimal("price_user"));
        bom.setProdLine(rs.getInt("prod_line"));
        bom.setQty(rs.getInt("qty"));
        bom.setQtyUser(rs.getInt("qty_user"));
        bom.setRadius1(rs.getInt("radius_1"));
        bom.setRadius1I(rs.getInt("radius_1_i"));
        bom.setRadius2(rs.getInt("radius_2"));
        bom.setRadius2I(rs.getInt("radius_2_i"));
        bom.setReport(rs.getInt("report"));
        bom.setReqForStage(rs.getInt("req_for_stage"));
        bom.setRightAngle(rs.getDouble("right_angle"));
        bom.setRightCut(rs.getInt("right_cut"));
        bom.setRow(rs.getInt("row"));
        bom.setRuleNo(rs.getInt("rule_no"));
        bom.setSash(rs.getInt("sash"));
        bom.setSegId(rs.getInt("seg_id"));
        bom.setSequenceId(rs.getInt("sequence_id"));
        bom.setShapeId(rs.getInt("shape_id"));
        bom.setStation(rs.getInt("station"));
        bom.setStockCode(rs.getString("stock_code"));
        bom.setStockcodeUser(rs.getString("stock_code_user"));
        bom.setSupplierId(rs.getInt("supplier_id"));
        bom.setSysAssemblyId(rs.getInt("sys_assembly_id"));
        bom.setTotalCost(rs.getBigDecimal("total_cost"));
        bom.setTotalPrice(rs.getBigDecimal("total_price"));
        bom.setTotalPriceUser(rs.getBigDecimal("total_price_user"));
        bom.setTrack(rs.getBoolean("is_track"));
        bom.setVersionId(rs.getInt("version_id"));
        bom.setVolume(rs.getDouble("volume"));
        bom.setVolumeI(rs.getDouble("volume_i"));
        bom.setVolumeIUser(rs.getDouble("volume_i_user"));
        bom.setVolumeUser(rs.getDouble("volume_user"));
        bom.setWeld(rs.getInt("weld"));
        bom.setWeldI(rs.getInt("weld_i"));
        bom.setWeldR(rs.getInt("weld_r"));
        bom.setWeldRI(rs.getInt("weld_r_i"));
        bom.setWidth(rs.getInt("width"));
        bom.setWidthI(rs.getInt("width_i"));
        bom.setWidthIUser(rs.getInt("width_i_user"));
        bom.setWidthUser(rs.getInt("width_user"));
        bom.setShips(rs.getBoolean("ships"));
        bom.setNotchesM(rs.getString("notches"));
        bom.setNotchesI(rs.getString("notches_i"));
        bom.setNotchesIY(rs.getString("notches_i_y"));
        bom.setSupplierRuleNo(rs.getInt("supplier_rule_no"));
        bom.setSupplierPartId(rs.getInt("supplier_part_id"));
        bom.setGlass_made_in(rs.getBoolean("glass_made_in"));
        bom.setBought_glazed(rs.getBoolean("bought_glazed"));
        bom.setParentBomId(rs.getInt("parent_bom_id"));
        bom.setGlassBomId(rs.getInt("glass_bom_id"));
        bom.setJob_item_model(rs.getBytes("job_item_model"));
        bom.setBomId(bom.getId());

        return bom;
    }
}
