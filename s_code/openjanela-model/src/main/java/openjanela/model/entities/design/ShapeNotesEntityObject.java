package openjanela.model.entities.design;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-02-13
 *          Time: 02:45 PM
 */
@Entity
@Table(name = "design_shape_notes")
@Cacheable
public class ShapeNotesEntityObject implements Serializable {

    //Serializable version
    private static final long serialVersionUID = -3837621304236262433L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    private Integer id;

    @Column(name = "level_id", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int levelId;

    @Column(name = "sequence_id", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequenceId;

    @Column(name = "assembly_level_id", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int assemblyLevelId;

    @Column(name = "level_1", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level1;

    @Column(name = "level_2", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level2;

    @Column(name = "level_3", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level3;

    @Column(name = "level_4", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level4;

    @Column(name = "level_5", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level5;

    @Column(name = "level_6", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level6;

    @Column(name = "level_7", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level7;

    @Column(name = "level_8", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level8;

    @Column(name = "level_9", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level9;

    @Column(name = "level_10", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level10;

    @Column(name = "level_11", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level11;

    @Column(name = "level_12", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level12;

    @Column(name = "level_13", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level13;

    @Column(name = "level_14", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level14;

    @Column(name = "level_15", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level15;

    @Column(name = "level_16", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level16;

    @Column(name = "level_17", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level17;

    @Column(name = "level_18", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level18;

    @Column(name = "level_19", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level19;

    @Column(name = "level_20", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level20;

    @Column(name = "level_21", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level21;

    @Column(name = "level_22", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level22;

    @Column(name = "sequence_1", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence1;

    @Column(name = "sequence_2", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence2;

    @Column(name = "sequence_3", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence3;

    @Column(name = "sequence_4", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence4;

    @Column(name = "sequence_5", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence5;

    @Column(name = "sequence_6", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence6;

    @Column(name = "sequence_7", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence7;

    @Column(name = "sequence_8", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence8;

    @Column(name = "sequence_9", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence9;

    @Column(name = "sequence_10", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence10;

    @Column(name = "sequence_11", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence11;

    @Column(name = "sequence_12", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence12;

    @Column(name = "sequence_13", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence13;

    @Column(name = "sequence_14", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence14;

    @Column(name = "sequence_15", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence15;

    @Column(name = "sequence_16", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence16;

    @Column(name = "sequence_17", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence17;

    @Column(name = "sequence_18", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence18;

    @Column(name = "sequence_19", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence19;

    @Column(name = "sequence_20", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence20;

    @Column(name = "sequence_21", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence21;

    @Column(name = "sequence_22", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sequence22;

    @Column(name = "order_id", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int orderId;

    @Column(name = "item_no", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int itemNo;

    @Column(name = "version_id", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int versionId;

    @Column(name = "rule_no", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int ruleNo;

    @Column(name = "series_id", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int seriesId;

    @Column(name = "part_id", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int partId;

    @Column(name = "level", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int level;

    @Column(name = "position", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int position;

    @Column(name = "orientation", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int orientation;

    @Column(name = "openingid", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int openingId;

    @Column(name = "sashid", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int sashId;

    @Column(name = "row", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int row;

    @Column(name = "col", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int col;

    @Column(name = "assembly", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int assembly;

    @Column(name = "parent_assembly", nullable = false, insertable = true, updatable = true, length = 11, precision = 0)
    @Basic
    private int parentAssembly;

    @Column(name = "stock_code", nullable = false, insertable = true, updatable = true, length = 150, precision = 0)
    @Basic
    private String stockCode;

    @Column(name = "description", nullable = false, insertable = true, updatable = true, length = 150, precision = 0)
    @Basic
    private String description;

    @Column(name = "value", nullable = false, insertable = true, updatable = true, length = 22, precision = 0)
    @Basic
    private double value;

    @Column(name = "showQty", nullable = false, insertable = true, updatable = true, length = 0, precision = 0)
    @Basic
    private boolean showQty;

    @Column(name = "supplier_remote_id", nullable = false)
    private int supplierId;

    @Column(name = "supplier_series_id", nullable = false)
    private int supplierSeriesId;

    @Column(name = "remote", nullable = false)
    private boolean remote;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bom_id", referencedColumnName = "id", nullable = true)
    private BillOfMaterialEntityObject parentBom;

    @Transient
    private String frameDescription;

    @Transient
    private String frameStockCode;

    @Transient
    private String glassDescription;

    @Transient
    private String glassStockCode;

    @Transient
    private int suType;

    //*************************************************<Getters & Setters>**********************************************

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public int getAssemblyLevelId() {
        return assemblyLevelId;
    }

    public void setAssemblyLevelId(int assemblyLevelId) {
        this.assemblyLevelId = assemblyLevelId;
    }

    public int getLevel1() {
        return level1;
    }

    public void setLevel1(int level1) {
        this.level1 = level1;
    }

    public int getLevel2() {
        return level2;
    }

    public void setLevel2(int level2) {
        this.level2 = level2;
    }

    public int getLevel3() {
        return level3;
    }

    public void setLevel3(int level3) {
        this.level3 = level3;
    }

    public int getLevel4() {
        return level4;
    }

    public void setLevel4(int level4) {
        this.level4 = level4;
    }

    public int getLevel5() {
        return level5;
    }

    public void setLevel5(int level5) {
        this.level5 = level5;
    }

    public int getLevel6() {
        return level6;
    }

    public void setLevel6(int level6) {
        this.level6 = level6;
    }

    public int getLevel7() {
        return level7;
    }

    public void setLevel7(int level7) {
        this.level7 = level7;
    }

    public int getLevel8() {
        return level8;
    }

    public void setLevel8(int level8) {
        this.level8 = level8;
    }

    public int getLevel9() {
        return level9;
    }

    public void setLevel9(int level9) {
        this.level9 = level9;
    }

    public int getLevel10() {
        return level10;
    }

    public void setLevel10(int level10) {
        this.level10 = level10;
    }

    public int getLevel11() {
        return level11;
    }

    public void setLevel11(int level11) {
        this.level11 = level11;
    }

    public int getLevel12() {
        return level12;
    }

    public void setLevel12(int level12) {
        this.level12 = level12;
    }

    public int getLevel13() {
        return level13;
    }

    public void setLevel13(int level13) {
        this.level13 = level13;
    }

    public int getLevel14() {
        return level14;
    }

    public void setLevel14(int level14) {
        this.level14 = level14;
    }

    public int getLevel15() {
        return level15;
    }

    public void setLevel15(int level15) {
        this.level15 = level15;
    }

    public int getLevel16() {
        return level16;
    }

    public void setLevel16(int level16) {
        this.level16 = level16;
    }

    public int getLevel17() {
        return level17;
    }

    public void setLevel17(int level17) {
        this.level17 = level17;
    }

    public int getLevel18() {
        return level18;
    }

    public void setLevel18(int level18) {
        this.level18 = level18;
    }

    public int getLevel19() {
        return level19;
    }

    public void setLevel19(int level19) {
        this.level19 = level19;
    }

    public int getLevel20() {
        return level20;
    }

    public void setLevel20(int level20) {
        this.level20 = level20;
    }

    public int getLevel21() {
        return level21;
    }

    public void setLevel21(int level21) {
        this.level21 = level21;
    }

    public int getLevel22() {
        return level22;
    }

    public void setLevel22(int level22) {
        this.level22 = level22;
    }

    public int getSequence1() {
        return sequence1;
    }

    public void setSequence1(int sequence1) {
        this.sequence1 = sequence1;
    }

    public int getSequence2() {
        return sequence2;
    }

    public void setSequence2(int sequence2) {
        this.sequence2 = sequence2;
    }

    public int getSequence3() {
        return sequence3;
    }

    public void setSequence3(int sequence3) {
        this.sequence3 = sequence3;
    }

    public int getSequence4() {
        return sequence4;
    }

    public void setSequence4(int sequence4) {
        this.sequence4 = sequence4;
    }

    public int getSequence5() {
        return sequence5;
    }

    public void setSequence5(int sequence5) {
        this.sequence5 = sequence5;
    }

    public int getSequence6() {
        return sequence6;
    }

    public void setSequence6(int sequence6) {
        this.sequence6 = sequence6;
    }

    public int getSequence7() {
        return sequence7;
    }

    public void setSequence7(int sequence7) {
        this.sequence7 = sequence7;
    }

    public int getSequence8() {
        return sequence8;
    }

    public void setSequence8(int sequence8) {
        this.sequence8 = sequence8;
    }

    public int getSequence9() {
        return sequence9;
    }

    public void setSequence9(int sequence9) {
        this.sequence9 = sequence9;
    }

    public int getSequence10() {
        return sequence10;
    }

    public void setSequence10(int sequence10) {
        this.sequence10 = sequence10;
    }

    public int getSequence11() {
        return sequence11;
    }

    public void setSequence11(int sequence11) {
        this.sequence11 = sequence11;
    }

    public int getSequence12() {
        return sequence12;
    }

    public void setSequence12(int sequence12) {
        this.sequence12 = sequence12;
    }

    public int getSequence13() {
        return sequence13;
    }

    public void setSequence13(int sequence13) {
        this.sequence13 = sequence13;
    }

    public int getSequence14() {
        return sequence14;
    }

    public void setSequence14(int sequence14) {
        this.sequence14 = sequence14;
    }

    public int getSequence15() {
        return sequence15;
    }

    public void setSequence15(int sequence15) {
        this.sequence15 = sequence15;
    }

    public int getSequence16() {
        return sequence16;
    }

    public void setSequence16(int sequence16) {
        this.sequence16 = sequence16;
    }

    public int getSequence17() {
        return sequence17;
    }

    public void setSequence17(int sequence17) {
        this.sequence17 = sequence17;
    }

    public int getSequence18() {
        return sequence18;
    }

    public void setSequence18(int sequence18) {
        this.sequence18 = sequence18;
    }

    public int getSequence19() {
        return sequence19;
    }

    public void setSequence19(int sequence19) {
        this.sequence19 = sequence19;
    }

    public int getSequence20() {
        return sequence20;
    }

    public void setSequence20(int sequence20) {
        this.sequence20 = sequence20;
    }

    public int getSequence21() {
        return sequence21;
    }

    public void setSequence21(int sequence21) {
        this.sequence21 = sequence21;
    }

    public int getSequence22() {
        return sequence22;
    }

    public void setSequence22(int sequence22) {
        this.sequence22 = sequence22;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public int getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(int ruleNo) {
        this.ruleNo = ruleNo;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getOpeningId() {
        return openingId;
    }

    public void setOpeningId(int openingId) {
        this.openingId = openingId;
    }

    public int getSashId() {
        return sashId;
    }

    public void setSashId(int sashId) {
        this.sashId = sashId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getAssembly() {
        return assembly;
    }

    public void setAssembly(int assembly) {
        this.assembly = assembly;
    }

    public int getParentAssembly() {
        return parentAssembly;
    }

    public void setParentAssembly(int parentAssembly) {
        this.parentAssembly = parentAssembly;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isShowQty() {
        return showQty;
    }

    public void setShowQty(boolean showQty) {
        this.showQty = showQty;
    }

    public BillOfMaterialEntityObject getParentBom() {
        return parentBom;
    }

    public void setParentBom(BillOfMaterialEntityObject parentBom) {
        this.parentBom = parentBom;
    }

    public String getFrameDescription() {
        return frameDescription;
    }

    public void setFrameDescription(String frameDescription) {
        this.frameDescription = frameDescription;
    }

    public String getFrameStockCode() {
        return frameStockCode;
    }

    public void setFrameStockCode(String frameStockCode) {
        this.frameStockCode = frameStockCode;
    }

    public String getGlassDescription() {
        return glassDescription;
    }

    public void setGlassDescription(String glassDescription) {
        this.glassDescription = glassDescription;
    }

    public String getGlassStockCode() {
        return glassStockCode;
    }

    public void setGlassStockCode(String glassStockCode) {
        this.glassStockCode = glassStockCode;
    }

    public int getSuType() {
        return suType;
    }

    public void setSuType(int suType) {
        this.suType = suType;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getSupplierSeriesId() {
        return supplierSeriesId;
    }

    public void setSupplierSeriesId(int supplierSeriesId) {
        this.supplierSeriesId = supplierSeriesId;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }
}
