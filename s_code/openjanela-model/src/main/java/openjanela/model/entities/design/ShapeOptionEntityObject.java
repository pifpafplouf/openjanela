package openjanela.model.entities.design;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 12-14-12
 *          Time: 12:28 AM
 */
public class ShapeOptionEntityObject implements Serializable {

    //Serializable version
    private static final long serialVersionUID = 7971774511180267101L;

    private Integer id;

    public int seriesId = 0;
    private int ruleno = 0;
    private int levelId = 0;
    private int sequenceId = 0;
    private int assemblyLevelId = 0;
    private int optionId = 0;
    private int answerId = 0;
    private int sizeAnswer = 0;
    private int sizeAnswerI = 0;
    private int depthAnswer = 0;
    private int depthAnswerI = 0;
    private int adjust = 0;
    private int adjustI = 0;
    private int w = 0;
    private int h = 0;
    private int wi = 0;
    private int hi = 0;
    private int d = 0;
    private int di = 0;
    private int l = 0;
    private int li = 0;
    private int priceUOMId = 0;
    private int costUOMId = 0;
    private int priceMeasureId = 0;
    private int optionDefinitionsId = 0;
    private int optionDefinitionsTypeId = 0;
    private int optionAnswersId = 0;

    private String optionDefinitionDesc = "";
    private String optionDefinitionTypeDesc = "";
    private String optionAnswersDesc = "";
    private String optionAnswersStockCode = "";
    private String optionAnswersAbbrev = "";

    private double discountP = 0;
    private double qtyAnswer = 0;

    private boolean isAuto = false;
    private boolean remove = false;
    private boolean global = false;

    private String textAnswer = "";

    private BigDecimal price = new BigDecimal("0");
    private BigDecimal priceUser = new BigDecimal("0");
    private BigDecimal priceTotal = new BigDecimal("0");
    private BigDecimal priceTotalUser = new BigDecimal("0");
    private BigDecimal cost = new BigDecimal("0");
    private BigDecimal costTotal = new BigDecimal("0");

    private int supplierId = 0;

    private int supplierSeriesId = 0;
    private boolean remote = false;

    private ConstructionMap constructionMap;

    // ==================================<GETTTER AND SETTERS>=================================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public int getRuleno() {
        return ruleno;
    }

    public void setRuleno(int ruleno) {
        this.ruleno = ruleno;
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

    public boolean isAuto() {
        return isAuto;
    }

    public void setAuto(boolean auto) {
        isAuto = auto;
    }

    public double getQtyAnswer() {
        return qtyAnswer;
    }

    public void setQtyAnswer(double qtyAnswer) {
        this.qtyAnswer = qtyAnswer;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceUser() {
        return priceUser;
    }

    public void setPriceUser(BigDecimal priceUser) {
        this.priceUser = priceUser;
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(BigDecimal costTotal) {
        this.costTotal = costTotal;
    }

    public double getDiscountP() {
        return discountP;
    }

    public void setDiscountP(double discountP) {
        this.discountP = discountP;
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

    public int getPriceUOMId() {
        return priceUOMId;
    }

    public void setPriceUOMId(int priceUOMId) {
        this.priceUOMId = priceUOMId;
    }

    public int getCostUOMId() {
        return costUOMId;
    }

    public void setCostUOMId(int costUOMId) {
        this.costUOMId = costUOMId;
    }

    public int getPriceMeasureId() {
        return priceMeasureId;
    }

    public void setPriceMeasureId(int priceMeasureId) {
        this.priceMeasureId = priceMeasureId;
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

    public String getOptionDefinitionDesc() {
        return optionDefinitionDesc;
    }

    public void setOptionDefinitionDesc(String optionDefinitionDesc) {
        this.optionDefinitionDesc = optionDefinitionDesc;
    }

    public String getOptionDefinitionTypeDesc() {
        return optionDefinitionTypeDesc;
    }

    public void setOptionDefinitionTypeDesc(String optionDefinitionTypeDesc) {
        this.optionDefinitionTypeDesc = optionDefinitionTypeDesc;
    }

    public String getOptionAnswersDesc() {
        return optionAnswersDesc;
    }

    public void setOptionAnswersDesc(String optionAnswersDesc) {
        this.optionAnswersDesc = optionAnswersDesc;
    }

    public String getOptionAnswersStockCode() {
        return optionAnswersStockCode;
    }

    public void setOptionAnswersStockCode(String optionAnswersStockCode) {
        this.optionAnswersStockCode = optionAnswersStockCode;
    }

    public String getOptionAnswersAbbrev() {
        return optionAnswersAbbrev;
    }

    public void setOptionAnswersAbbrev(String optionAnswersAbbrev) {
        this.optionAnswersAbbrev = optionAnswersAbbrev;
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

    public ConstructionMap getConstructionMap() {
        return constructionMap;
    }

    public void setConstructionMap(ConstructionMap constructionMap) {
        this.constructionMap = constructionMap;
    }

}
