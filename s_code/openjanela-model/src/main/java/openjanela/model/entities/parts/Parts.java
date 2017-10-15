package openjanela.model.entities.parts;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-21-12
 *          Time: 08:26 AM
 */
@Entity
@Table(name = "parts")
public class Parts implements Serializable, Cloneable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "stockcode", nullable = false)
    private String stockcode = "";

    @Column(name = "configured", nullable = false)
    private boolean configured = false;

    @Column(name = "description", nullable = false)
    private String description = "";

    @Column(name = "part_type", nullable = false)
    private int parttype = 0;

    @Column(name = "part_family", nullable = false)
    private int partfamily = 0;

    @Column(name = "weight", nullable = false)
    private double weight = 0.0;

    @Column(name = "weighti", nullable = false)
    private double weighti = 0.0;

    @Column(name = "waste", nullable = false)
    private double waste = 0.0;

    @Column(name = "made_in", nullable = false)
    private boolean madein = false;

    @Column(name = "bom_id", nullable = false)
    private int bomid = 0;

    @Column(name = "sellable", nullable = false)
    private boolean sellable = false;

    @Column(name = "gen_stock", nullable = false)
    private boolean genstock = false;

    @Column(name = "kit", nullable = false)
    private boolean kit = false;

    @Column(name = "tracking", nullable = false)
    private boolean tracking = false;

    @Column(name = "std_sizes", nullable = false)
    private boolean stdsizes = false;

    @Column(name = "notes", nullable = false)
    private String notes = "";

    @Column(name = "shipping", nullable = false)
    private boolean shipping = false;

    @Column(name = "installation", nullable = false)
    private boolean installation = false;

    @Column(name = "taxable", nullable = false)
    private boolean taxable = false;

    @Column(name = "add_as_line", nullable = false)
    private boolean addasline = false;

    @Column(name = "add_to_product", nullable = false)
    private boolean addtoproduct = false;

    @Column(name = "add_specified_qty", nullable = false)
    private boolean addspecifiedqty = false;

    @Column(name = "add_multiplied_qty", nullable = false)
    private boolean addmultipliedqty = false;

    @Column(name = "cost_group", nullable = false)
    private int costgroup = 0;

    @Column(name = "price_group", nullable = false)
    private int pricegroup = 0;

    @Column(name = "cost_method", nullable = false)
    private int costmethod = 0;

    @Column(name = "cost", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal cost = new BigDecimal("0.00");

    @Column(name = "price", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal price = new BigDecimal("0.00");

    @Column(name = "cost_matrix", nullable = false)
    private int costmatrix = 0;

    @Column(name = "price_matrix", nullable = false)
    private int pricematrix = 0;

    @Column(name = "min_price", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal minprice = new BigDecimal("0.00");

    @Column(name = "shape", nullable = false)
    private int shape = 0;

    @Column(name = "dima", nullable = false)
    private int dima = 0;

    @Column(name = "dimb", nullable = false)
    private int dimb = 0;

    @Column(name = "dimc", nullable = false)
    private int dimc = 0;

    @Column(name = "dimd", nullable = false)
    private int dimd = 0;

    @Column(name = "dima_imp", nullable = false)
    private int dimai = 0;

    @Column(name = "dimb_imp", nullable = false)
    private int dimbi = 0;

    @Column(name = "dimc_imp", nullable = false)
    private int dimci = 0;

    @Column(name = "dimd_imp", nullable = false)
    private int dimdi = 0;

    @Column(name = "face_in", nullable = true)
    private double facein = 0;

    @Column(name = "perimeter", nullable = true)
    private double perimeter = 0;

    @Column(name = "face_in_imp", nullable = true)
    private double faceini = 0;

    @Column(name = "perimeter_imp", nullable = true)
    private double perimeteri = 0;

    @Column(name = "min_radius", nullable = false)
    private int minradius = 0;

    @Column(name = "min_radius_imp", nullable = false)
    private int minradiusi = 0;

    @Column(name = "max_mitre_length", nullable = false)
    private int maxmitrelength = 0;

    @Column(name = "max_mitre_length_imp", nullable = false)
    private int maxmitrelengthi = 0;

    @Column(name = "weld_allowance", nullable = false)
    private int weldallowance = 0;

    @Column(name = "weld_allowace_imp", nullable = false)
    private int weldallowacei = 0;

    @Column(name = "weld_allowance_other", nullable = false)
    private int weldallowanceother = 0;

    @Column(name = "weld_allowance_other_imp", nullable = false)
    private int weldallowanceotheri = 0;

    @Column(name = "show_in_cut_sheet", nullable = false)
    private boolean showincutsheet = false;

    @Column(name = "showCM", nullable = false)
    private boolean showcm = false;

    @Column(name = "showPart", nullable = false)
    private boolean showpart = false;

    @Column(name = "stockuom", nullable = false)
    private int stockuom = 0;

    @Column(name = "stockuomconvert", nullable = false)
    private double stockuomconvert = 0.0;

    @Column(name = "costuom", nullable = false)
    private int costuom = 0;

    @Column(name = "costuomconvert", nullable = false)
    private double costuomconvert = 0.0;

    @Column(name = "priceuom", nullable = false)
    private int priceuom = 0;

    @Column(name = "priceuomconvert", nullable = false)
    private double priceuomconvert = 0.0;

    @Column(name = "usageuom", nullable = false)
    private int usageuom = 0;

    @Column(name = "usageuomconvert", nullable = false)
    private double usageuomconvert = 0.0;

    @Column(name = "face_out", nullable = true)
    private double faceout = 0;

    @Column(name = "face_out_imp", nullable = true)
    private double faceouti = 0;

    @Column(name = "priceuomconverti", nullable = false)
    private Double priceuomconverti = 0.0;

    @Column(name = "usageuomconverti", nullable = false)
    private Double usageuomconverti = 0.0;

    @Column(name = "min_cost", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal mincost = new BigDecimal(0);

    @Column(name = "cost_measure", nullable = false)
    private int costmeasure = 0;

    @Column(name = "price_measure", nullable = false)
    private int pricemeasure = 0;

    @Column(name = "discountable", nullable = false)
    private boolean discountable;

    @Column(name = "price_markup", nullable = false)
    private double price_markup;

    @Column(name = "cost_markup", nullable = false)
    private double cost_markup;

    @Column(name = "prodline", nullable = false)
    private int prodline;

    @Column(name = "station", nullable = false)
    private int station;

    @Column(name = "report", nullable = false)
    private int report;

    @Column(name = "series", nullable = false)
    private int series;

    @Column(name = "masterstockcode", nullable = false)
    private String masterstockcode;

    @Column(name = "dimbtoc", nullable = false)
    private int dimbtoc;

    @Column(name = "dimbtoc_imp", nullable = false)
    private int dimbtoc_imp;

    @Column(name = "dimm", nullable = false)
    private int dimm;

    @Column(name = "dimm_imp", nullable = false)
    private int dimm_imp;

    @Column(name = "attribute_id", nullable = false)
    private int attributeID;

    @Column(name = "trimcut", nullable = false)
    private int trimcut;

    @Column(name = "trimcuti", nullable = false)
    private int trimcut_imp;

    @Column(name = "min_size_offcut_m", nullable = false)
    private int min_size_offcut_m;

    @Column(name = "min_size_offcut_i", nullable = false)
    private int min_size_offcut_imp;

    @Column(name = "label_pos", nullable = false)
    private int label_pos;

    @Column(name = "ships", nullable = false)
    private boolean ships;

    @Transient
    private int supplierId = 0;

    @Transient
    private boolean remote = false;

    /**
     * Parts Entity Constructor
     */
    public Parts() {
        this.id = 0;
    }

    /**
     * Parts Entity Constructor
     *
     * @param id, Id
     */
    public Parts(int id) {
        this.id = id;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStockcode() {
        return stockcode;
    }

    public void setStockcode(String stockcode) {
        this.stockcode = stockcode;
    }

    public boolean isConfigured() {
        return configured;
    }

    public void setConfigured(boolean configured) {
        this.configured = configured;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParttype() {
        return parttype;
    }

    public void setParttype(int parttype) {
        this.parttype = parttype;
    }

    public int getPartfamily() {
        return partfamily;
    }

    public void setPartfamily(int partfamily) {
        this.partfamily = partfamily;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeighti() {
        return weighti;
    }

    public void setWeighti(double weighti) {
        this.weighti = weighti;
    }

    public double getWaste() {
        return waste;
    }

    public void setWaste(double waste) {
        this.waste = waste;
    }

    public boolean isMadein() {
        return madein;
    }

    public void setMadein(boolean madein) {
        this.madein = madein;
    }

    public int getBomid() {
        return bomid;
    }

    public void setBomid(int bomid) {
        this.bomid = bomid;
    }

    public boolean isSellable() {
        return sellable;
    }

    public void setSellable(boolean sellable) {
        this.sellable = sellable;
    }

    public boolean isGenstock() {
        return genstock;
    }

    public void setGenstock(boolean genstock) {
        this.genstock = genstock;
    }

    public boolean isKit() {
        return kit;
    }

    public void setKit(boolean kit) {
        this.kit = kit;
    }

    public boolean isTracking() {
        return tracking;
    }

    public void setTracking(boolean tracking) {
        this.tracking = tracking;
    }

    public boolean isStdsizes() {
        return stdsizes;
    }

    public void setStdsizes(boolean stdsizes) {
        this.stdsizes = stdsizes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isShipping() {
        return shipping;
    }

    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }

    public boolean isInstallation() {
        return installation;
    }

    public void setInstallation(boolean installation) {
        this.installation = installation;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    public boolean isAddasline() {
        return addasline;
    }

    public void setAddasline(boolean addasline) {
        this.addasline = addasline;
    }

    public boolean isAddtoproduct() {
        return addtoproduct;
    }

    public void setAddtoproduct(boolean addtoproduct) {
        this.addtoproduct = addtoproduct;
    }

    public boolean isAddspecifiedqty() {
        return addspecifiedqty;
    }

    public void setAddspecifiedqty(boolean addspecifiedqty) {
        this.addspecifiedqty = addspecifiedqty;
    }

    public boolean isAddmultipliedqty() {
        return addmultipliedqty;
    }

    public void setAddmultipliedqty(boolean addmultipliedqty) {
        this.addmultipliedqty = addmultipliedqty;
    }

    public int getCostgroup() {
        return costgroup;
    }

    public void setCostgroup(int costgroup) {
        this.costgroup = costgroup;
    }

    public int getPricegroup() {
        return pricegroup;
    }

    public void setPricegroup(int pricegroup) {
        this.pricegroup = pricegroup;
    }

    public int getCostmethod() {
        return costmethod;
    }

    public void setCostmethod(int costmethod) {
        this.costmethod = costmethod;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCostmatrix() {
        return costmatrix;
    }

    public void setCostmatrix(int costmatrix) {
        this.costmatrix = costmatrix;
    }

    public int getPricematrix() {
        return pricematrix;
    }

    public void setPricematrix(int pricematrix) {
        this.pricematrix = pricematrix;
    }

    public BigDecimal getMinprice() {
        return minprice;
    }

    public void setMinprice(BigDecimal minprice) {
        this.minprice = minprice;
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }

    public int getDima() {
        return dima;
    }

    public void setDima(int dima) {
        this.dima = dima;
    }

    public int getDimb() {
        return dimb;
    }

    public void setDimb(int dimb) {
        this.dimb = dimb;
    }

    public int getDimc() {
        return dimc;
    }

    public void setDimc(int dimc) {
        this.dimc = dimc;
    }

    public int getDimd() {
        return dimd;
    }

    public void setDimd(int dimd) {
        this.dimd = dimd;
    }

    public int getDimai() {
        return dimai;
    }

    public void setDimai(int dimai) {
        this.dimai = dimai;
    }

    public int getDimbi() {
        return dimbi;
    }

    public void setDimbi(int dimbi) {
        this.dimbi = dimbi;
    }

    public int getDimci() {
        return dimci;
    }

    public void setDimci(int dimci) {
        this.dimci = dimci;
    }

    public int getDimdi() {
        return dimdi;
    }

    public void setDimdi(int dimdi) {
        this.dimdi = dimdi;
    }

    public double getFacein() {
        return facein;
    }

    public void setFacein(double facein) {
        this.facein = facein;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getFaceini() {
        return faceini;
    }

    public void setFaceini(double faceini) {
        this.faceini = faceini;
    }

    public double getPerimeteri() {
        return perimeteri;
    }

    public void setPerimeteri(double perimeteri) {
        this.perimeteri = perimeteri;
    }

    public int getMinradius() {
        return minradius;
    }

    public void setMinradius(int minradius) {
        this.minradius = minradius;
    }

    public int getMinradiusi() {
        return minradiusi;
    }

    public void setMinradiusi(int minradiusi) {
        this.minradiusi = minradiusi;
    }

    public int getMaxmitrelength() {
        return maxmitrelength;
    }

    public void setMaxmitrelength(int maxmitrelength) {
        this.maxmitrelength = maxmitrelength;
    }

    public int getMaxmitrelengthi() {
        return maxmitrelengthi;
    }

    public void setMaxmitrelengthi(int maxmitrelengthi) {
        this.maxmitrelengthi = maxmitrelengthi;
    }

    public int getWeldallowance() {
        return weldallowance;
    }

    public void setWeldallowance(int weldallowance) {
        this.weldallowance = weldallowance;
    }

    public int getWeldallowacei() {
        return weldallowacei;
    }

    public void setWeldallowacei(int weldallowacei) {
        this.weldallowacei = weldallowacei;
    }

    public int getWeldallowanceother() {
        return weldallowanceother;
    }

    public void setWeldallowanceother(int weldallowanceother) {
        this.weldallowanceother = weldallowanceother;
    }

    public int getWeldallowanceotheri() {
        return weldallowanceotheri;
    }

    public void setWeldallowanceotheri(int weldallowanceotheri) {
        this.weldallowanceotheri = weldallowanceotheri;
    }

    public boolean isShowincutsheet() {
        return showincutsheet;
    }

    public void setShowincutsheet(boolean showincutsheet) {
        this.showincutsheet = showincutsheet;
    }

    public boolean isShowcm() {
        return showcm;
    }

    public void setShowcm(boolean showcm) {
        this.showcm = showcm;
    }

    public boolean isShowpart() {
        return showpart;
    }

    public void setShowpart(boolean showpart) {
        this.showpart = showpart;
    }

    public int getStockuom() {
        return stockuom;
    }

    public void setStockuom(int stockuom) {
        this.stockuom = stockuom;
    }

    public double getStockuomconvert() {
        return stockuomconvert;
    }

    public void setStockuomconvert(double stockuomconvert) {
        this.stockuomconvert = stockuomconvert;
    }

    public int getCostuom() {
        return costuom;
    }

    public void setCostuom(int costuom) {
        this.costuom = costuom;
    }

    public double getCostuomconvert() {
        return costuomconvert;
    }

    public void setCostuomconvert(double costuomconvert) {
        this.costuomconvert = costuomconvert;
    }

    public int getPriceuom() {
        return priceuom;
    }

    public void setPriceuom(int priceuom) {
        this.priceuom = priceuom;
    }

    public double getPriceuomconvert() {
        return priceuomconvert;
    }

    public void setPriceuomconvert(double priceuomconvert) {
        this.priceuomconvert = priceuomconvert;
    }

    public int getUsageuom() {
        return usageuom;
    }

    public void setUsageuom(int usageuom) {
        this.usageuom = usageuom;
    }

    public double getUsageuomconvert() {
        return usageuomconvert;
    }

    public void setUsageuomconvert(double usageuomconvert) {
        this.usageuomconvert = usageuomconvert;
    }

    public double getFaceout() {
        return faceout;
    }

    public void setFaceout(double faceout) {
        this.faceout = faceout;
    }

    public double getFaceouti() {
        return faceouti;
    }

    public void setFaceouti(double faceouti) {
        this.faceouti = faceouti;
    }

    public Double getPriceuomconverti() {
        return priceuomconverti;
    }

    public void setPriceuomconverti(Double priceuomconverti) {
        this.priceuomconverti = priceuomconverti;
    }

    public Double getUsageuomconverti() {
        return usageuomconverti;
    }

    public void setUsageuomconverti(Double usageuomconverti) {
        this.usageuomconverti = usageuomconverti;
    }

    public BigDecimal getMincost() {
        return mincost;
    }

    public void setMincost(BigDecimal mincost) {
        this.mincost = mincost;
    }

    public int getCostmeasure() {
        return costmeasure;
    }

    public void setCostmeasure(int costmeasure) {
        this.costmeasure = costmeasure;
    }

    public int getPricemeasure() {
        return pricemeasure;
    }

    public void setPricemeasure(int pricemeasure) {
        this.pricemeasure = pricemeasure;
    }

    public boolean isDiscountable() {
        return discountable;
    }

    public void setDiscountable(boolean discountable) {
        this.discountable = discountable;
    }

    public double getPrice_markup() {
        return price_markup;
    }

    public void setPrice_markup(double price_markup) {
        this.price_markup = price_markup;
    }

    public double getCost_markup() {
        return cost_markup;
    }

    public void setCost_markup(double cost_markup) {
        this.cost_markup = cost_markup;
    }

    public int getProdline() {
        return prodline;
    }

    public void setProdline(int prodline) {
        this.prodline = prodline;
    }

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }

    public int getReport() {
        return report;
    }

    public void setReport(int report) {
        this.report = report;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getMasterstockcode() {
        return masterstockcode;
    }

    public void setMasterstockcode(String masterstockcode) {
        this.masterstockcode = masterstockcode;
    }

    public int getDimbtoc() {
        return dimbtoc;
    }

    public void setDimbtoc(int dimbtoc) {
        this.dimbtoc = dimbtoc;
    }

    public int getDimbtoc_imp() {
        return dimbtoc_imp;
    }

    public void setDimbtoc_imp(int dimbtoc_imp) {
        this.dimbtoc_imp = dimbtoc_imp;
    }

    public int getDimm() {
        return dimm;
    }

    public void setDimm(int dimm) {
        this.dimm = dimm;
    }

    public int getDimm_imp() {
        return dimm_imp;
    }

    public void setDimm_imp(int dimm_imp) {
        this.dimm_imp = dimm_imp;
    }

    public int getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(int attributeID) {
        this.attributeID = attributeID;
    }

    public int getTrimcut() {
        return trimcut;
    }

    public void setTrimcut(int trimcut) {
        this.trimcut = trimcut;
    }

    public int getTrimcut_imp() {
        return trimcut_imp;
    }

    public void setTrimcut_imp(int trimcut_imp) {
        this.trimcut_imp = trimcut_imp;
    }

    public int getMin_size_offcut_m() {
        return min_size_offcut_m;
    }

    public void setMin_size_offcut_m(int min_size_offcut_m) {
        this.min_size_offcut_m = min_size_offcut_m;
    }

    public int getMin_size_offcut_imp() {
        return min_size_offcut_imp;
    }

    public void setMin_size_offcut_imp(int min_size_offcut_imp) {
        this.min_size_offcut_imp = min_size_offcut_imp;
    }

    public int getLabel_pos() {
        return label_pos;
    }

    public void setLabel_pos(int label_pos) {
        this.label_pos = label_pos;
    }

    public boolean isShips() {
        return ships;
    }

    public void setShips(boolean ships) {
        this.ships = ships;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    @Override
    public String toString() {
        return stockcode + " " + description;
    }

    @Override
    public Parts clone() {
        try {
            return (Parts)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
