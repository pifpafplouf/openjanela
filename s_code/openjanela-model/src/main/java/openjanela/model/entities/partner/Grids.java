package openjanela.model.entities.partner;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * @author Sherif
 */
@Entity
@Table(name = "grids")
@Cacheable
public class Grids implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "grid_type_id", nullable = false)
    private int gridTypeId;

    @Column(name = "thickness", nullable = false)
    private int thickness;

    @Column(name = "thickness_imp", nullable = false)
    private int thicknessImp;

    @Column(name = "pricing_group_id", nullable = false)
    private int pricingGroupId;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "minprice", nullable = false)
    private BigDecimal minprice;

    @Column(name = "price_matrix_id", nullable = false)
    private int priceMatrixId;

    @Column(name = "price_uom_id", nullable = false)
    private int priceUomId;

    @Column(name = "v_matirx_id", nullable = false)
    private int vMatirxId;

    @Column(name = "h_matrix_id", nullable = false)
    private int hMatrixId;

    @Column(name = "abbrev", nullable = false)
    private String abbrev;

    @Column(name = "continuity_in", nullable = false)
    private int continuityIn;

    @Column(name = "continuity_out", nullable = false)
    private int continuityOut;

    @Column(name = "remove_w", nullable = false)
    private int removeW;

    @Column(name = "remove_h", nullable = false)
    private int removeH;

    @Column(name = "remove_wi", nullable = false)
    private int removeWi;

    @Column(name = "remove_hi", nullable = false)
    private int removeHi;

    @Column(name = "perimeter_v", nullable = false)
    private int perimeterV;

    @Column(name = "perimeter_h", nullable = false)
    private int perimeterH;

    @Column(name = "perimeter_vi", nullable = false)
    private int perimeterVi;

    @Column(name = "perimeter_hi", nullable = false)
    private int perimeterHi;

    @Column(name = "c_connector", nullable = false)
    private boolean cConnector;

    @Column(name = "p_connector", nullable = false)
    private boolean pConnector;

    @Column(name = "ideal_w", nullable = false)
    private Integer idealW;

    @Column(name = "ideal_wi", nullable = false)
    private Integer idealWi;

    @Column(name = "ideal_h", nullable = false)
    private Integer idealH;

    @Column(name = "ideal_hi", nullable = false)
    private Integer idealHi;

    @Column(name = "max_w", nullable = false)
    private Integer maxW;

    @Column(name = "max_wi", nullable = false)
    private Integer maxWi;

    @Column(name = "max_h", nullable = false)
    private Integer maxH;

    @Column(name = "max_hi", nullable = false)
    private Integer maxHi;

    @Column(name = "min_w", nullable = false)
    private Integer minW;

    @Column(name = "min_wi", nullable = false)
    private Integer minWi;

    @Column(name = "min_h", nullable = false)
    private Integer minH;

    @Column(name = "min_hi", nullable = false)
    private Integer minHi;

    @Column(name = "partid", nullable = false)
    private Integer partid;

    @Column(name = "p_frame", nullable = false)
    private boolean pFrame;

    @Column(name = "pg_support_min", nullable = false)
    private Integer pgSupportMin;

    @Column(name = "pg_support_max", nullable = false)
    private Integer pgSupportMax;

    @Column(name = "pg_support_mini", nullable = false)
    private Integer pgSupportMini;

    @Column(name = "pg_support_maxi", nullable = false)
    private Integer pgSupportMani;

    @Column(name = "partid_sim", nullable = false)
    private Integer partidSim;

    @Column(name = "partid_l", nullable = false)
    private Integer partidL;

    @Column(name = "partid_t", nullable = false)
    private Integer partidT;

    @Column(name = "partid_cross", nullable = false)
    private Integer partidCross;

    @Column(name = "partid_spacer", nullable = false)
    private Integer partidspacer;

    @Column(name = "partid_hub", nullable = false)
    private Integer partidhub;

    @Column(name = "partid_spoke", nullable = false)
    private Integer partidspoke;

    @Column(name = "partid_matrix", nullable = false)
    private Integer partidMatrix;

    @Column(name = "partid_sim_matrix", nullable = false)
    private Integer partidSimMatrix;

    @Column(name = "assemblyid", nullable = false)
    private Integer assemblyId;

    @Column(name = "production_line", nullable = false)
    private Integer productionLineId;

    @Column(name = "station", nullable = false)
    private Integer stationId;

    @Column(name = "made_in", nullable = false)
    private boolean madeIn;

    @Transient
    private int supplierId;

    @Transient
    private boolean remote;

    public Grids() {
    }

    public Grids(Integer id, String description, int gridTypeId, int thickness, int thicknessImp, int pricingGroupId,
                 BigDecimal price, BigDecimal minprice, int priceMatrixId, int priceUomId, int vMatirxId, int hMatrixId,
                 String abbrev, int continuityIn, int continuityOut, int removeW, int removeH, int removeWi, int removeHi,
                 int perimeterV, int perimeterH, int perimeterVi, int perimeterHi, boolean cConnector, boolean pConnector,
                 Integer idealW, Integer idealWi, Integer idealH, Integer idealHi, Integer maxW, Integer maxWi, Integer maxH,
                 Integer maxHi, Integer minW, Integer minWi, Integer minH, Integer minHi, Integer partid, boolean pFrame,
                 Integer pgSupportMin, Integer pgSupportMax, Integer pgSupportMini, Integer pgSupportMani, Integer partidSim,
                 Integer partidL, Integer partidT, Integer partidCross, Integer partidspacer, Integer partidhub, Integer partidspoke,
                 Integer partidMatrix, Integer partidSimMatrix, Integer assemblyId, Integer productionLineId, Integer stationId,
                 boolean madeIn) {

        this.id = id;
        this.description = description;
        this.gridTypeId = gridTypeId;
        this.thickness = thickness;
        this.thicknessImp = thicknessImp;
        this.pricingGroupId = pricingGroupId;
        this.price = price;
        this.minprice = minprice;
        this.priceMatrixId = priceMatrixId;
        this.priceUomId = priceUomId;
        this.vMatirxId = vMatirxId;
        this.hMatrixId = hMatrixId;
        this.abbrev = abbrev;
        this.continuityIn = continuityIn;
        this.continuityOut = continuityOut;
        this.removeW = removeW;
        this.removeH = removeH;
        this.removeWi = removeWi;
        this.removeHi = removeHi;
        this.perimeterV = perimeterV;
        this.perimeterH = perimeterH;
        this.perimeterVi = perimeterVi;
        this.perimeterHi = perimeterHi;
        this.cConnector = cConnector;
        this.pConnector = pConnector;
        this.idealW = idealW;
        this.idealWi = idealWi;
        this.idealH = idealH;
        this.idealHi = idealHi;
        this.maxW = maxW;
        this.maxWi = maxWi;
        this.maxH = maxH;
        this.maxHi = maxHi;
        this.minW = minW;
        this.minWi = minWi;
        this.minH = minH;
        this.minHi = minHi;
        this.partid = partid;
        this.pFrame = pFrame;
        this.pgSupportMin = pgSupportMin;
        this.pgSupportMax = pgSupportMax;
        this.pgSupportMini = pgSupportMini;
        this.pgSupportMani = pgSupportMani;
        this.partidSim = partidSim;
        this.partidL = partidL;
        this.partidT = partidT;
        this.partidCross = partidCross;
        this.partidspacer = partidspacer;
        this.partidhub = partidhub;
        this.partidspoke = partidspoke;
        this.partidMatrix = partidMatrix;
        this.partidSimMatrix = partidSimMatrix;
        this.assemblyId = assemblyId;
        this.productionLineId = productionLineId;
        this.stationId = stationId;
        this.madeIn = madeIn;
    }

    //*********************************************<Getter & Setter>****************************************************

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGridTypeId() {
        return gridTypeId;
    }

    public void setGridTypeId(int gridTypeId) {
        this.gridTypeId = gridTypeId;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public int getThicknessImp() {
        return thicknessImp;
    }

    public void setThicknessImp(int thicknessImp) {
        this.thicknessImp = thicknessImp;
    }

    public int getPricingGroupId() {
        return pricingGroupId;
    }

    public void setPricingGroupId(int pricingGroupId) {
        this.pricingGroupId = pricingGroupId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMinprice() {
        return minprice;
    }

    public void setMinprice(BigDecimal minprice) {
        this.minprice = minprice;
    }

    public int getPriceMatrixId() {
        return priceMatrixId;
    }

    public void setPriceMatrixId(int priceMatrixId) {
        this.priceMatrixId = priceMatrixId;
    }

    public int getPriceUomId() {
        return priceUomId;
    }

    public void setPriceUomId(int priceUomId) {
        this.priceUomId = priceUomId;
    }

    public int getVMatirxId() {
        return vMatirxId;
    }

    public void setVMatirxId(int vMatirxId) {
        this.vMatirxId = vMatirxId;
    }

    public int getHMatrixId() {
        return hMatrixId;
    }

    public void setHMatrixId(int hMatrixId) {
        this.hMatrixId = hMatrixId;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public int getContinuityIn() {
        return continuityIn;
    }

    public void setContinuityIn(int continuityIn) {
        this.continuityIn = continuityIn;
    }

    public int getContinuityOut() {
        return continuityOut;
    }

    public void setContinuityOut(int continuityOut) {
        this.continuityOut = continuityOut;
    }

    public int getRemoveW() {
        return removeW;
    }

    public void setRemoveW(int removeW) {
        this.removeW = removeW;
    }

    public int getRemoveH() {
        return removeH;
    }

    public void setRemoveH(int removeH) {
        this.removeH = removeH;
    }

    public int getRemoveWi() {
        return removeWi;
    }

    public void setRemoveWi(int removeWi) {
        this.removeWi = removeWi;
    }

    public int getRemoveHi() {
        return removeHi;
    }

    public void setRemoveHi(int removeHi) {
        this.removeHi = removeHi;
    }

    public int getPerimeterV() {
        return perimeterV;
    }

    public void setPerimeterV(int perimeterV) {
        this.perimeterV = perimeterV;
    }

    public int getPerimeterH() {
        return perimeterH;
    }

    public void setPerimeterH(int perimeterH) {
        this.perimeterH = perimeterH;
    }

    public int getPerimeterVi() {
        return perimeterVi;
    }

    public void setPerimeterVi(int perimeterVi) {
        this.perimeterVi = perimeterVi;
    }

    public int getPerimeterHi() {
        return perimeterHi;
    }

    public void setPerimeterHi(int perimeterHi) {
        this.perimeterHi = perimeterHi;
    }

    public boolean getCConnector() {
        return cConnector;
    }

    public void setCConnector(boolean cConnector) {
        this.cConnector = cConnector;
    }

    public boolean getPConnector() {
        return pConnector;
    }

    public void setPConnector(boolean pConnector) {
        this.pConnector = pConnector;
    }

    public Integer getIdealW() {
        return idealW;
    }

    public void setIdealW(Integer idealW) {
        this.idealW = idealW;
    }

    public Integer getIdealWi() {
        return idealWi;
    }

    public void setIdealWi(Integer idealWi) {
        this.idealWi = idealWi;
    }

    public Integer getIdealH() {
        return idealH;
    }

    public void setIdealH(Integer idealH) {
        this.idealH = idealH;
    }

    public Integer getIdealHi() {
        return idealHi;
    }

    public void setIdealHi(Integer idealHi) {
        this.idealHi = idealHi;
    }

    public Integer getMaxW() {
        return maxW;
    }

    public void setMaxW(Integer maxW) {
        this.maxW = maxW;
    }

    public Integer getMaxWi() {
        return maxWi;
    }

    public void setMaxWi(Integer maxWi) {

        this.maxWi = maxWi;
    }

    public Integer getMaxH() {

        return maxH;
    }

    public void setMaxH(Integer maxH) {
        this.maxH = maxH;
    }

    public Integer getMaxHi() {
        return maxHi;
    }

    public void setMaxHi(Integer maxHi) {
        this.maxHi = maxHi;
    }

    public Integer getMinW() {
        return minW;
    }

    public void setMinW(Integer minW) {
        this.minW = minW;
    }

    public Integer getMinWi() {
        return minWi;
    }

    public void setMinWi(Integer minWi) {
        this.minWi = minWi;
    }

    public Integer getMinH() {
        return minH;
    }

    public void setMinH(Integer minH) {
        this.minH = minH;
    }

    public Integer getMinHi() {
        return minHi;
    }

    public void setMinHi(Integer minHi) {
        this.minHi = minHi;
    }

    public Integer getPartid() {
        return partid;
    }

    public void setPartid(Integer partid) {
        this.partid = partid;
    }

    public boolean ispFrame() {
        return pFrame;
    }

    public void setpFrame(boolean pFrame) {
        this.pFrame = pFrame;
    }

    public Integer getPgSupportMin() {
        return pgSupportMin;
    }

    public void setPgSupportMin(Integer pgSupportMin) {
        this.pgSupportMin = pgSupportMin;
    }

    public Integer getPgSupportMax() {
        return pgSupportMax;
    }

    public void setPgSupportMax(Integer pgSupportMax) {
        this.pgSupportMax = pgSupportMax;
    }

    public Integer getPgSupportMini() {
        return pgSupportMini;
    }

    public void setPgSupportMini(Integer pgSupportMini) {
        this.pgSupportMini = pgSupportMini;
    }

    public Integer getPgSupportMani() {
        return pgSupportMani;
    }

    public void setPgSupportMani(Integer pgSupportMani) {
        this.pgSupportMani = pgSupportMani;
    }

    public int getvMatirxId() {
        return vMatirxId;
    }

    public void setvMatirxId(int vMatirxId) {
        this.vMatirxId = vMatirxId;
    }

    public int gethMatrixId() {
        return hMatrixId;
    }

    public void sethMatrixId(int hMatrixId) {
        this.hMatrixId = hMatrixId;
    }

    public boolean iscConnector() {
        return cConnector;
    }

    public void setcConnector(boolean cConnector) {
        this.cConnector = cConnector;
    }

    public boolean ispConnector() {
        return pConnector;
    }

    public void setpConnector(boolean pConnector) {
        this.pConnector = pConnector;
    }

    public Integer getPartidSim() {
        return partidSim;
    }

    public void setPartidSim(Integer partidSim) {
        this.partidSim = partidSim;
    }

    public Integer getPartidL() {
        return partidL;
    }

    public void setPartidL(Integer partidL) {
        this.partidL = partidL;
    }

    public Integer getPartidT() {
        return partidT;
    }

    public void setPartidT(Integer partidT) {
        this.partidT = partidT;
    }

    public Integer getPartidCross() {
        return partidCross;
    }

    public void setPartidCross(Integer partidCross) {
        this.partidCross = partidCross;
    }

    public Integer getPartidspacer() {
        return partidspacer;
    }

    public void setPartidspacer(Integer partidspacer) {
        this.partidspacer = partidspacer;
    }

    public Integer getPartidhub() {
        return partidhub;
    }

    public void setPartidhub(Integer partidhub) {
        this.partidhub = partidhub;
    }

    public Integer getPartidspoke() {
        return partidspoke;
    }

    public void setPartidspoke(Integer partidspoke) {
        this.partidspoke = partidspoke;
    }

    public Integer getAssemblyId() {
        return assemblyId;
    }

    public void setAssemblyId(Integer assemblyId) {
        this.assemblyId = assemblyId;
    }

    public Integer getProductionLineId() {
        return productionLineId;
    }

    public void setProductionLineId(Integer productionLineId) {
        this.productionLineId = productionLineId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public boolean isMadeIn() {
        return madeIn;
    }

    public void setMadeIn(boolean madeIn) {
        this.madeIn = madeIn;
    }

    public Integer getPartidMatrix() {
        return partidMatrix;
    }

    public void setPartidMatrix(Integer partidMatrix) {
        this.partidMatrix = partidMatrix;
    }

    public Integer getPartidSimMatrix() {
        return partidSimMatrix;
    }

    public void setPartidSimMatrix(Integer partidSimMatrix) {
        this.partidSimMatrix = partidSimMatrix;
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
        return description;
    }

}
