package openjanela.model.entities.design;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 12-23-12
 *          Time: 02:07 PM
 */
@Entity
@Table(name = "design_options")
@Cacheable
public class DesignOptionEntityObject implements Serializable {

    //Serializable version
    private static final long serialVersionUID = -4153861322961093539L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "level_id", nullable = false)
    private int levelId;

    @Column(name = "sequence_id", nullable = false)
    private int sequenceId;

    @Column(name = "assembly_level_id", nullable = false)
    private int assemblyLevelId;

    @Column(name = "series_id", nullable = false)
    private int seriesId;

    @Column(name = "seq", nullable = false)
    private int seq;

    @Column(name = "rule_no", nullable = false)
    private int ruleno;

    @Column(name = "option_id", nullable = false)
    private int optionId;

    @Column(name = "answer_id", nullable = false)
    private int answerId;

    @Column(name = "answer_size", nullable = false)
    private int sizeAnswer;

    @Column(name = "answer_size_i", nullable = false)
    private int sizeAnswerI;

    @Column(name = "depth_answer", nullable = false)
    private int depthAnswer;

    @Column(name = "depth_answer_i", nullable = false)
    private int depthAnswerI;

    @Column(name = "adjust", nullable = false)
    private int adjust;

    @Column(name = "adjust_i", nullable = false)
    private int adjustI;

    @Column(name = "text_answer", nullable = false)
    private String textAnswer;

    @Column(name = "w", nullable = false)
    private int w;

    @Column(name = "h", nullable = false)
    private int h;

    @Column(name = "w_i", nullable = false)
    private int wi;

    @Column(name = "h_i", nullable = false)
    private int hi;

    @Column(name = "d", nullable = false)
    private int d;

    @Column(name = "d_i", nullable = false)
    private int di;

    @Column(name = "l", nullable = false)
    private int l;

    @Column(name = "l_i", nullable = false)
    private int li;

    @Column(name = "price_uom", nullable = false)
    private int priceUOM;

    @Column(name = "cost_uom", nullable = false)
    private int costUOM;

    @Column(name = "price_measure", nullable = false)
    private int priceMeasure;

    @Column(name = "rgb_r", nullable = false)
    private int rgb_R = 255;

    @Column(name = "rgb_g", nullable = false)
    private int rgb_G = 255;

    @Column(name = "rgb_b", nullable = false)
    private int rgb_B = 255;

    @Column(name = "qty_answer", nullable = false)
    private double qtyAnswer;

    @Column(name = "discount_p", nullable = false)
    private double discountP;

    @Column(name = "total_price", nullable = false)
    private BigDecimal priceTotal = new BigDecimal("0");

    @Column(name = "total_price_user", nullable = false)
    private BigDecimal priceTotalUser = new BigDecimal("0");

    @Column(name = "total_cost", nullable = false)
    private BigDecimal costTotal = new BigDecimal("0");

    @Column(name = "price_user", nullable = false)
    private BigDecimal priceUser = new BigDecimal("0");

    @Column(name = "cost", nullable = false)
    private BigDecimal cost = new BigDecimal("0");

    @Column(name = "price", nullable = false)
    private BigDecimal price = new BigDecimal("0");

    @Column(name = "is_mixed", nullable = false)
    private boolean isMixed;

    @Column(name = "is_auto", nullable = false)
    private boolean isAuto;

    @Column(name = "is_remove", nullable = false)
    private boolean remove;

    @Column(name = "is_global", nullable = false)
    private boolean global;

    @Column(name = "option_definitions_id", nullable = false)
    private int optionDefinitionsId;

    @Column(name = "option_definitions_type_id", nullable = false)
    private int optionDefinitionsTypeId;

    @Column(name = "option_answers_id", nullable = false)
    private int optionAnswersId;

    @Column(name = "is_design_net", nullable = false)
    private boolean isDesignNet;

    @Column(name = "is_design_all", nullable = false)
    private boolean isDesignAll;

    @Column(name = "option_definitions_desc", nullable = false)
    private String optionDefinitionsDesc = null;

    @Column(name = "option_answers_desc", nullable = false)
    private String optionAnswersDesc = null;

    @Column(name = "supplier_id", nullable = false)
    private int supplierId;

    @Column(name = "supplier_series_id", nullable = false)
    private int supplierSeriesId;

    @Column(name = "remote", nullable = false)
    private boolean remote;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "map_id", referencedColumnName = "id")
    private ConstructionMap constructionMap;

    public DesignOptionEntityObject() {
    }

    public DesignOptionEntityObject(int levelId, int sequenceId, int assemblyLevelId, int seriesId, int seq, int ruleno,
                                    int optionId, int answerId, int sizeAnswer, int sizeAnswerI, int depthAnswer,
                                    int depthAnswerI, int adjust, int adjustI, String textAnswer, int w, int h, int wi,
                                    int hi, int d, int di, int l, int li, int priceUOM, int costUOM, int priceMeasure,
                                    int rgb_R, int rgb_G, int rgb_B, double qtyAnswer, double discountP, BigDecimal priceTotal,
                                    BigDecimal priceTotalUser, BigDecimal costTotal, BigDecimal priceUser, BigDecimal cost,
                                    BigDecimal price, boolean isMixed, boolean isAuto, boolean remove, boolean global,
                                    int optionDefinitionsId, int optionDefinitionsTypeId, int optionAnswersId, boolean isDesignNet,
                                    boolean isDesignAll, String optionDefinitionsDesc, String optionAnswersDesc, int supplierId,
                                    int supplierSeriesId, boolean remote, ConstructionMap constructionMap) {

        this.levelId = levelId;
        this.sequenceId = sequenceId;
        this.assemblyLevelId = assemblyLevelId;
        this.seriesId = seriesId;
        this.seq = seq;
        this.ruleno = ruleno;
        this.optionId = optionId;
        this.answerId = answerId;
        this.sizeAnswer = sizeAnswer;
        this.sizeAnswerI = sizeAnswerI;
        this.depthAnswer = depthAnswer;
        this.depthAnswerI = depthAnswerI;
        this.adjust = adjust;
        this.adjustI = adjustI;
        this.textAnswer = textAnswer;
        this.w = w;
        this.h = h;
        this.wi = wi;
        this.hi = hi;
        this.d = d;
        this.di = di;
        this.l = l;
        this.li = li;
        this.priceUOM = priceUOM;
        this.costUOM = costUOM;
        this.priceMeasure = priceMeasure;
        this.rgb_R = rgb_R;
        this.rgb_G = rgb_G;
        this.rgb_B = rgb_B;
        this.qtyAnswer = qtyAnswer;
        this.discountP = discountP;
        this.priceTotal = priceTotal;
        this.priceTotalUser = priceTotalUser;
        this.costTotal = costTotal;
        this.priceUser = priceUser;
        this.cost = cost;
        this.price = price;
        this.isMixed = isMixed;
        this.isAuto = isAuto;
        this.remove = remove;
        this.global = global;
        this.optionDefinitionsId = optionDefinitionsId;
        this.optionDefinitionsTypeId = optionDefinitionsTypeId;
        this.optionAnswersId = optionAnswersId;
        this.isDesignNet = isDesignNet;
        this.isDesignAll = isDesignAll;
        this.optionDefinitionsDesc = optionDefinitionsDesc;
        this.optionAnswersDesc = optionAnswersDesc;
        this.supplierId = supplierId;
        this.supplierSeriesId = supplierSeriesId;
        this.remote = remote;
        this.constructionMap = constructionMap;
    }

    // ==================================<GETTTER AND SETTERS>=================================================

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

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getRuleno() {
        return ruleno;
    }

    public void setRuleno(int ruleno) {
        this.ruleno = ruleno;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getSizeAnswer() {
        return sizeAnswer;
    }

    public void setSizeAnswer(int sizeAnswer) {
        this.sizeAnswer = sizeAnswer;
    }

    public int getSizeAnswerI() {
        return sizeAnswerI;
    }

    public void setSizeAnswerI(int sizeAnswerI) {
        this.sizeAnswerI = sizeAnswerI;
    }

    public int getDepthAnswer() {
        return depthAnswer;
    }

    public void setDepthAnswer(int depthAnswer) {
        this.depthAnswer = depthAnswer;
    }

    public int getDepthAnswerI() {
        return depthAnswerI;
    }

    public void setDepthAnswerI(int depthAnswerI) {
        this.depthAnswerI = depthAnswerI;
    }

    public int getAdjust() {
        return adjust;
    }

    public void setAdjust(int adjust) {
        this.adjust = adjust;
    }

    public int getAdjustI() {
        return adjustI;
    }

    public void setAdjustI(int adjustI) {
        this.adjustI = adjustI;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getWi() {
        return wi;
    }

    public void setWi(int wi) {
        this.wi = wi;
    }

    public int getHi() {
        return hi;
    }

    public void setHi(int hi) {
        this.hi = hi;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getDi() {
        return di;
    }

    public void setDi(int di) {
        this.di = di;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getLi() {
        return li;
    }

    public void setLi(int li) {
        this.li = li;
    }

    public int getPriceUOM() {
        return priceUOM;
    }

    public void setPriceUOM(int priceUOM) {
        this.priceUOM = priceUOM;
    }

    public int getCostUOM() {
        return costUOM;
    }

    public void setCostUOM(int costUOM) {
        this.costUOM = costUOM;
    }

    public int getPriceMeasure() {
        return priceMeasure;
    }

    public void setPriceMeasure(int priceMeasure) {
        this.priceMeasure = priceMeasure;
    }

    public int getRgb_R() {
        return rgb_R;
    }

    public void setRgb_R(int rgb_R) {
        this.rgb_R = rgb_R;
    }

    public int getRgb_G() {
        return rgb_G;
    }

    public void setRgb_G(int rgb_G) {
        this.rgb_G = rgb_G;
    }

    public int getRgb_B() {
        return rgb_B;
    }

    public void setRgb_B(int rgb_B) {
        this.rgb_B = rgb_B;
    }

    public double getQtyAnswer() {
        return qtyAnswer;
    }

    public void setQtyAnswer(double qtyAnswer) {
        this.qtyAnswer = qtyAnswer;
    }

    public double getDiscountP() {
        return discountP;
    }

    public void setDiscountP(double discountP) {
        this.discountP = discountP;
    }

    public BigDecimal getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(BigDecimal priceTotal) {
        this.priceTotal = priceTotal;
    }

    public BigDecimal getPriceTotalUser() {
        return priceTotalUser;
    }

    public void setPriceTotalUser(BigDecimal priceTotalUser) {
        this.priceTotalUser = priceTotalUser;
    }

    public BigDecimal getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(BigDecimal costTotal) {
        this.costTotal = costTotal;
    }

    public BigDecimal getPriceUser() {
        return priceUser;
    }

    public void setPriceUser(BigDecimal priceUser) {
        this.priceUser = priceUser;
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

    public boolean isMixed() {
        return isMixed;
    }

    public void setMixed(boolean mixed) {
        isMixed = mixed;
    }

    public boolean isAuto() {
        return isAuto;
    }

    public void setAuto(boolean auto) {
        isAuto = auto;
    }

    public boolean isRemove() {
        return remove;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }

    public int getOptionDefinitionsId() {
        return optionDefinitionsId;
    }

    public void setOptionDefinitionsId(int optionDefinitionsId) {
        this.optionDefinitionsId = optionDefinitionsId;
    }

    public int getOptionDefinitionsTypeId() {
        return optionDefinitionsTypeId;
    }

    public void setOptionDefinitionsTypeId(int optionDefinitionsTypeId) {
        this.optionDefinitionsTypeId = optionDefinitionsTypeId;
    }

    public int getOptionAnswersId() {
        return optionAnswersId;
    }

    public void setOptionAnswersId(int optionAnswersId) {
        this.optionAnswersId = optionAnswersId;
    }

    public String getOptionDefinitionsDesc() {
        return optionDefinitionsDesc;
    }

    public void setOptionDefinitionsDesc(String optionDefinitionsDesc) {
        this.optionDefinitionsDesc = optionDefinitionsDesc;
    }

    public String getOptionAnswersDesc() {
        return optionAnswersDesc;
    }

    public void setOptionAnswersDesc(String optionAnswersDesc) {
        this.optionAnswersDesc = optionAnswersDesc;
    }

    public boolean isDesignNet() {
        return isDesignNet;
    }

    public void setDesignNet(boolean designNet) {
        isDesignNet = designNet;
    }

    public boolean isDesignAll() {
        return isDesignAll;
    }

    public void setDesignAll(boolean designAll) {
        isDesignAll = designAll;
    }

    public ConstructionMap getConstructionMap() {
        return constructionMap;
    }

    public void setConstructionMap(ConstructionMap constructionMap) {
        this.constructionMap = constructionMap;
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
