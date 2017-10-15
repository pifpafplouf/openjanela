package openjanela.model.eao.partner.partsEAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.parts.Parts;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import javax.persistence.FlushModeType;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-21-12
 *          Time: 10:10 AM
 */
public class PartsPersistenceEAO extends GenericPersistenceEAO<Parts, Integer> implements PartsEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(PartsPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Parts Persistence Default Constructor
     */
    public PartsPersistenceEAO() {
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
    public List<Parts> findAllReadOnly() throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final List<Parts> partsList = new ArrayList<Parts>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer("select p.* from parts p order by p.id");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        Parts parts = new Parts();
                        parts.setId(rs.getInt("id"));
                        parts.setStockcode(rs.getString("stockcode"));
                        parts.setConfigured(rs.getBoolean("configured"));
                        parts.setDescription(rs.getString("description"));
                        parts.setParttype(rs.getInt("part_type"));
                        parts.setPartfamily(rs.getInt("part_family"));
                        parts.setWeight(rs.getDouble("weight"));
                        parts.setWeighti(rs.getDouble("weighti"));
                        parts.setWaste(rs.getDouble("waste"));
                        parts.setMadein(rs.getBoolean("made_in"));
                        parts.setBomid(rs.getInt("bom_id"));
                        parts.setSellable(rs.getBoolean("sellable"));
                        parts.setGenstock(rs.getBoolean("gen_stock"));
                        parts.setKit(rs.getBoolean("kit"));
                        parts.setTracking(rs.getBoolean("tracking"));
                        parts.setStdsizes(rs.getBoolean("std_sizes"));
                        parts.setNotes(rs.getString("notes"));
                        parts.setShipping(rs.getBoolean("shipping"));
                        parts.setInstallation(rs.getBoolean("installation"));
                        parts.setTaxable(rs.getBoolean("taxable"));
                        parts.setAddasline(rs.getBoolean("add_as_line"));
                        parts.setAddtoproduct(rs.getBoolean("add_to_product"));
                        parts.setAddspecifiedqty(rs.getBoolean("add_specified_qty"));
                        parts.setAddmultipliedqty(rs.getBoolean("add_multiplied_qty"));
                        parts.setCostgroup(rs.getInt("cost_group"));
                        parts.setPricegroup(rs.getInt("price_group"));
                        parts.setCostmethod(rs.getInt("cost_method"));
                        parts.setCost(rs.getBigDecimal("cost"));
                        parts.setPrice(rs.getBigDecimal("price"));
                        parts.setCostmatrix(rs.getInt("cost_matrix"));
                        parts.setPricematrix(rs.getInt("price_matrix"));
                        parts.setMinprice(rs.getBigDecimal("min_price"));
                        parts.setShape(rs.getInt("shape"));
                        parts.setDima(rs.getInt("dima"));
                        parts.setDimb(rs.getInt("dimb"));
                        parts.setDimc(rs.getInt("dimc"));
                        parts.setDimd(rs.getInt("dimd"));
                        parts.setDimai(rs.getInt("dima_imp"));
                        parts.setDimbi(rs.getInt("dimb_imp"));
                        parts.setDimci(rs.getInt("dimc_imp"));
                        parts.setDimdi(rs.getInt("dimd_imp"));
                        parts.setFacein(rs.getDouble("face_in"));
                        parts.setPerimeter(rs.getDouble("perimeter"));
                        parts.setFaceini(rs.getDouble("face_in_imp"));
                        parts.setPerimeteri(rs.getDouble("perimeter_imp"));
                        parts.setMinradius(rs.getInt("min_radius"));
                        parts.setMinradiusi(rs.getInt("min_radius_imp"));
                        parts.setMaxmitrelength(rs.getInt("max_mitre_length"));
                        parts.setMaxmitrelengthi(rs.getInt("max_mitre_length_imp"));
                        parts.setWeldallowance(rs.getInt("weld_allowance"));
                        parts.setWeldallowacei(rs.getInt("weld_allowace_imp"));
                        parts.setWeldallowanceother(rs.getInt("weld_allowance_other"));
                        parts.setWeldallowanceotheri(rs.getInt("weld_allowance_other_imp"));
                        parts.setShowincutsheet(rs.getBoolean("show_in_cut_sheet"));
                        parts.setShowcm(rs.getBoolean("showCM"));
                        parts.setShowpart(rs.getBoolean("showPart"));
                        parts.setStockuom(rs.getInt("stockuom"));
                        parts.setStockuomconvert(rs.getDouble("stockuomconvert"));
                        parts.setCostuom(rs.getInt("costuom"));
                        parts.setCostuomconvert(rs.getDouble("costuomconvert"));
                        parts.setPriceuom(rs.getInt("priceuom"));
                        parts.setPriceuomconvert(rs.getDouble("priceuomconvert"));
                        parts.setUsageuom(rs.getInt("usageuom"));
                        parts.setUsageuomconvert(rs.getDouble("usageuomconvert"));
                        parts.setFaceout(rs.getDouble("face_out"));
                        parts.setFaceouti(rs.getDouble("face_out_imp"));
                        parts.setPriceuomconverti(rs.getDouble("priceuomconverti"));
                        parts.setUsageuomconverti(rs.getDouble("usageuomconverti"));
                        parts.setMincost(rs.getBigDecimal("min_cost"));
                        parts.setCostmeasure(rs.getInt("cost_measure"));
                        parts.setPricemeasure(rs.getInt("price_measure"));
                        parts.setDiscountable(rs.getBoolean("discountable"));
                        parts.setPrice_markup(rs.getDouble("price_markup"));
                        parts.setCost_markup(rs.getDouble("cost_markup"));
                        parts.setProdline(rs.getInt("prodline"));
                        parts.setStation(rs.getInt("station"));
                        parts.setReport(rs.getInt("report"));
                        parts.setSeries(rs.getInt("series"));
                        parts.setMasterstockcode(rs.getString("masterstockcode"));
                        parts.setDimbtoc(rs.getInt("dimbtoc"));
                        parts.setDimbtoc_imp(rs.getInt("dimbtoc_imp"));
                        parts.setDimm(rs.getInt("dimm"));
                        parts.setDimm_imp(rs.getInt("dimm_imp"));
                        parts.setAttributeID(rs.getInt("attribute_id"));
                        parts.setTrimcut(rs.getInt("trimcut"));
                        parts.setTrimcut_imp(rs.getInt("trimcuti"));
                        parts.setMin_size_offcut_m(rs.getInt("min_size_offcut_m"));
                        parts.setMin_size_offcut_imp(rs.getInt("min_size_offcut_i"));
                        parts.setLabel_pos(rs.getInt("label_pos"));
                        parts.setShips(rs.getBoolean("label_pos"));

                        partsList.add(parts);
                    }
                }
            });

            return partsList;

        } finally {
            closeService();
        }
    }

    @Override
    public List<Parts> findByPartType(int partType) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            String query = "select p from Parts p where p.parttype = :partType";

            List<Parts> parts = em.createQuery(query).setParameter("partType", partType).getResultList();

            return parts;

        } finally {
            closeService();
        }
    }

    @Override
    public List<Parts> findAllRemote(int supplierId) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initRemoteService(supplierId);

            final List<Parts> partsList = new ArrayList<Parts>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer("select p.* from parts p where p.sellable = 0 order by p.id");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        Parts parts = new Parts();
                        parts.setId(rs.getInt("id"));
                        parts.setStockcode(rs.getString("stockcode"));
                        parts.setConfigured(rs.getBoolean("configured"));
                        parts.setDescription(rs.getString("description"));
                        parts.setParttype(rs.getInt("part_type"));
                        parts.setPartfamily(rs.getInt("part_family"));
                        parts.setWeight(rs.getDouble("weight"));
                        parts.setWeighti(rs.getDouble("weighti"));
                        parts.setWaste(rs.getDouble("waste"));
                        parts.setMadein(rs.getBoolean("made_in"));
                        parts.setBomid(rs.getInt("bom_id"));
                        parts.setSellable(rs.getBoolean("sellable"));
                        parts.setGenstock(rs.getBoolean("gen_stock"));
                        parts.setKit(rs.getBoolean("kit"));
                        parts.setTracking(rs.getBoolean("tracking"));
                        parts.setStdsizes(rs.getBoolean("std_sizes"));
                        parts.setNotes(rs.getString("notes"));
                        parts.setShipping(rs.getBoolean("shipping"));
                        parts.setInstallation(rs.getBoolean("installation"));
                        parts.setTaxable(rs.getBoolean("taxable"));
                        parts.setAddasline(rs.getBoolean("add_as_line"));
                        parts.setAddtoproduct(rs.getBoolean("add_to_product"));
                        parts.setAddspecifiedqty(rs.getBoolean("add_specified_qty"));
                        parts.setAddmultipliedqty(rs.getBoolean("add_multiplied_qty"));
                        parts.setCostgroup(rs.getInt("cost_group"));
                        parts.setPricegroup(rs.getInt("price_group"));
                        parts.setCostmethod(rs.getInt("cost_method"));
                        parts.setCost(rs.getBigDecimal("cost"));
                        parts.setPrice(rs.getBigDecimal("price"));
                        parts.setCostmatrix(rs.getInt("cost_matrix"));
                        parts.setPricematrix(rs.getInt("price_matrix"));
                        parts.setMinprice(rs.getBigDecimal("min_price"));
                        parts.setShape(rs.getInt("shape"));
                        parts.setDima(rs.getInt("dima"));
                        parts.setDimb(rs.getInt("dimb"));
                        parts.setDimc(rs.getInt("dimc"));
                        parts.setDimd(rs.getInt("dimd"));
                        parts.setDimai(rs.getInt("dima_imp"));
                        parts.setDimbi(rs.getInt("dimb_imp"));
                        parts.setDimci(rs.getInt("dimc_imp"));
                        parts.setDimdi(rs.getInt("dimd_imp"));
                        parts.setFacein(rs.getDouble("face_in"));
                        parts.setPerimeter(rs.getDouble("perimeter"));
                        parts.setFaceini(rs.getDouble("face_in_imp"));
                        parts.setPerimeteri(rs.getDouble("perimeter_imp"));
                        parts.setMinradius(rs.getInt("min_radius"));
                        parts.setMinradiusi(rs.getInt("min_radius_imp"));
                        parts.setMaxmitrelength(rs.getInt("max_mitre_length"));
                        parts.setMaxmitrelengthi(rs.getInt("max_mitre_length_imp"));
                        parts.setWeldallowance(rs.getInt("weld_allowance"));
                        parts.setWeldallowacei(rs.getInt("weld_allowace_imp"));
                        parts.setWeldallowanceother(rs.getInt("weld_allowance_other"));
                        parts.setWeldallowanceotheri(rs.getInt("weld_allowance_other_imp"));
                        parts.setShowincutsheet(rs.getBoolean("show_in_cut_sheet"));
                        parts.setShowcm(rs.getBoolean("showCM"));
                        parts.setShowpart(rs.getBoolean("showPart"));
                        parts.setStockuom(rs.getInt("stockuom"));
                        parts.setStockuomconvert(rs.getDouble("stockuomconvert"));
                        parts.setCostuom(rs.getInt("costuom"));
                        parts.setCostuomconvert(rs.getDouble("costuomconvert"));
                        parts.setPriceuom(rs.getInt("priceuom"));
                        parts.setPriceuomconvert(rs.getDouble("priceuomconvert"));
                        parts.setUsageuom(rs.getInt("usageuom"));
                        parts.setUsageuomconvert(rs.getDouble("usageuomconvert"));
                        parts.setFaceout(rs.getDouble("face_out"));
                        parts.setFaceouti(rs.getDouble("face_out_imp"));
                        parts.setPriceuomconverti(rs.getDouble("priceuomconverti"));
                        parts.setUsageuomconverti(rs.getDouble("usageuomconverti"));
                        parts.setMincost(rs.getBigDecimal("min_cost"));
                        parts.setCostmeasure(rs.getInt("cost_measure"));
                        parts.setPricemeasure(rs.getInt("price_measure"));
                        parts.setDiscountable(rs.getBoolean("discountable"));
                        parts.setPrice_markup(rs.getDouble("price_markup"));
                        parts.setCost_markup(rs.getDouble("cost_markup"));
                        parts.setProdline(rs.getInt("prodline"));
                        parts.setStation(rs.getInt("station"));
                        parts.setReport(rs.getInt("report"));
                        parts.setSeries(rs.getInt("series"));
                        parts.setMasterstockcode(rs.getString("masterstockcode"));
                        parts.setDimbtoc(rs.getInt("dimbtoc"));
                        parts.setDimbtoc_imp(rs.getInt("dimbtoc_imp"));
                        parts.setDimm(rs.getInt("dimm"));
                        parts.setDimm_imp(rs.getInt("dimm_imp"));
                        parts.setAttributeID(rs.getInt("attribute_id"));
                        parts.setTrimcut(rs.getInt("trimcut"));
                        parts.setTrimcut_imp(rs.getInt("trimcuti"));
                        parts.setMin_size_offcut_m(rs.getInt("min_size_offcut_m"));
                        parts.setMin_size_offcut_imp(rs.getInt("min_size_offcut_i"));
                        parts.setLabel_pos(rs.getInt("label_pos"));
                        parts.setShips(rs.getBoolean("label_pos"));

                        partsList.add(parts);
                    }
                }
            });

            return partsList;

        } finally {
            closeRemoteService();
        }
    }

    @Override
    public Parts findRemoteByStockCode(Integer supplierId, String stockCode) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initRemoteService(supplierId);

            final String param_stock_code = stockCode;

            final List<Parts> partsList = new ArrayList<Parts>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer("select p.* from parts p where p.stockcode = ? order by p.id");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setString(1, param_stock_code);

                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        Parts parts = new Parts();
                        parts.setId(rs.getInt("id"));
                        parts.setStockcode(rs.getString("stockcode"));
                        parts.setConfigured(rs.getBoolean("configured"));
                        parts.setDescription(rs.getString("description"));
                        parts.setParttype(rs.getInt("part_type"));
                        parts.setPartfamily(rs.getInt("part_family"));
                        parts.setWeight(rs.getDouble("weight"));
                        parts.setWeighti(rs.getDouble("weighti"));
                        parts.setWaste(rs.getDouble("waste"));
                        parts.setMadein(rs.getBoolean("made_in"));
                        parts.setBomid(rs.getInt("bom_id"));
                        parts.setSellable(rs.getBoolean("sellable"));
                        parts.setGenstock(rs.getBoolean("gen_stock"));
                        parts.setKit(rs.getBoolean("kit"));
                        parts.setTracking(rs.getBoolean("tracking"));
                        parts.setStdsizes(rs.getBoolean("std_sizes"));
                        parts.setNotes(rs.getString("notes"));
                        parts.setShipping(rs.getBoolean("shipping"));
                        parts.setInstallation(rs.getBoolean("installation"));
                        parts.setTaxable(rs.getBoolean("taxable"));
                        parts.setAddasline(rs.getBoolean("add_as_line"));
                        parts.setAddtoproduct(rs.getBoolean("add_to_product"));
                        parts.setAddspecifiedqty(rs.getBoolean("add_specified_qty"));
                        parts.setAddmultipliedqty(rs.getBoolean("add_multiplied_qty"));
                        parts.setCostgroup(rs.getInt("cost_group"));
                        parts.setPricegroup(rs.getInt("price_group"));
                        parts.setCostmethod(rs.getInt("cost_method"));
                        parts.setCost(rs.getBigDecimal("cost"));
                        parts.setPrice(rs.getBigDecimal("price"));
                        parts.setCostmatrix(rs.getInt("cost_matrix"));
                        parts.setPricematrix(rs.getInt("price_matrix"));
                        parts.setMinprice(rs.getBigDecimal("min_price"));
                        parts.setShape(rs.getInt("shape"));
                        parts.setDima(rs.getInt("dima"));
                        parts.setDimb(rs.getInt("dimb"));
                        parts.setDimc(rs.getInt("dimc"));
                        parts.setDimd(rs.getInt("dimd"));
                        parts.setDimai(rs.getInt("dima_imp"));
                        parts.setDimbi(rs.getInt("dimb_imp"));
                        parts.setDimci(rs.getInt("dimc_imp"));
                        parts.setDimdi(rs.getInt("dimd_imp"));
                        parts.setFacein(rs.getDouble("face_in"));
                        parts.setPerimeter(rs.getDouble("perimeter"));
                        parts.setFaceini(rs.getDouble("face_in_imp"));
                        parts.setPerimeteri(rs.getDouble("perimeter_imp"));
                        parts.setMinradius(rs.getInt("min_radius"));
                        parts.setMinradiusi(rs.getInt("min_radius_imp"));
                        parts.setMaxmitrelength(rs.getInt("max_mitre_length"));
                        parts.setMaxmitrelengthi(rs.getInt("max_mitre_length_imp"));
                        parts.setWeldallowance(rs.getInt("weld_allowance"));
                        parts.setWeldallowacei(rs.getInt("weld_allowace_imp"));
                        parts.setWeldallowanceother(rs.getInt("weld_allowance_other"));
                        parts.setWeldallowanceotheri(rs.getInt("weld_allowance_other_imp"));
                        parts.setShowincutsheet(rs.getBoolean("show_in_cut_sheet"));
                        parts.setShowcm(rs.getBoolean("showCM"));
                        parts.setShowpart(rs.getBoolean("showPart"));
                        parts.setStockuom(rs.getInt("stockuom"));
                        parts.setStockuomconvert(rs.getDouble("stockuomconvert"));
                        parts.setCostuom(rs.getInt("costuom"));
                        parts.setCostuomconvert(rs.getDouble("costuomconvert"));
                        parts.setPriceuom(rs.getInt("priceuom"));
                        parts.setPriceuomconvert(rs.getDouble("priceuomconvert"));
                        parts.setUsageuom(rs.getInt("usageuom"));
                        parts.setUsageuomconvert(rs.getDouble("usageuomconvert"));
                        parts.setFaceout(rs.getDouble("face_out"));
                        parts.setFaceouti(rs.getDouble("face_out_imp"));
                        parts.setPriceuomconverti(rs.getDouble("priceuomconverti"));
                        parts.setUsageuomconverti(rs.getDouble("usageuomconverti"));
                        parts.setMincost(rs.getBigDecimal("min_cost"));
                        parts.setCostmeasure(rs.getInt("cost_measure"));
                        parts.setPricemeasure(rs.getInt("price_measure"));
                        parts.setDiscountable(rs.getBoolean("discountable"));
                        parts.setPrice_markup(rs.getDouble("price_markup"));
                        parts.setCost_markup(rs.getDouble("cost_markup"));
                        parts.setProdline(rs.getInt("prodline"));
                        parts.setStation(rs.getInt("station"));
                        parts.setReport(rs.getInt("report"));
                        parts.setSeries(rs.getInt("series"));
                        parts.setMasterstockcode(rs.getString("masterstockcode"));
                        parts.setDimbtoc(rs.getInt("dimbtoc"));
                        parts.setDimbtoc_imp(rs.getInt("dimbtoc_imp"));
                        parts.setDimm(rs.getInt("dimm"));
                        parts.setDimm_imp(rs.getInt("dimm_imp"));
                        parts.setAttributeID(rs.getInt("attribute_id"));
                        parts.setTrimcut(rs.getInt("trimcut"));
                        parts.setTrimcut_imp(rs.getInt("trimcuti"));
                        parts.setMin_size_offcut_m(rs.getInt("min_size_offcut_m"));
                        parts.setMin_size_offcut_imp(rs.getInt("min_size_offcut_i"));
                        parts.setLabel_pos(rs.getInt("label_pos"));
                        parts.setShips(rs.getBoolean("label_pos"));

                        partsList.add(parts);
                    }
                }
            });

            return partsList.get(0);

        } finally {
            closeRemoteService();
        }
    }

}