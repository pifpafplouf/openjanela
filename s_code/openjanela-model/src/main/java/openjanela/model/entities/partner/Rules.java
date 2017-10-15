package openjanela.model.entities.partner;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * @author Sherif
 */
@Entity
@Table(name = "rules")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Rules implements Serializable {

    @EmbeddedId
    private RulesPK rulesPK;

    @Basic(optional = false)
    @Column(name = "description")
    private String description;

    @Basic(optional = false)
    @Column(name = "level")
    private int assemblyID;

    @Basic(optional = false)
    @Column(name = "parent_level")
    private int levelID;

    @Basic(optional = false)
    @Column(name = "ruletype")
    private int ruletype;

    @Basic(optional = false)
    @Column(name = "rulevalue")
    private int rulevalue;

    @Basic(optional = false)
    @Column(name = "leftside")
    private int leftside;

    @Basic(optional = false)
    @Column(name = "rightside")
    private int rightside;

    @Basic(optional = false)
    @Column(name = "affectsdesign")
    private boolean affectsdesign;

    @Basic(optional = false)
    @Column(name = "position")
    private int position;

    @Basic(optional = false)
    @Column(name = "rcondition")
    private int rcondition;

    @Basic(optional = false)
    @Column(name = "quantitytype")
    private int quantitytype;

    @Basic(optional = false)
    @Column(name = "qtyvalue")
    private int qtyvalue;

    @Basic(optional = false)
    @Column(name = "sizeadjustwtype")
    private int sizeadjustwtype;

    @Basic(optional = false)
    @Column(name = "sizeadjustw")
    private int sizeadjustw;

    @Basic(optional = false)
    @Column(name = "sizeadjustwi")
    private int sizeadjustwi;

    @Basic(optional = false)
    @Column(name = "sizeadjusthtype")
    private int sizeadjusthtype;

    @Basic(optional = false)
    @Column(name = "sizeadjusth")
    private int sizeadjusth;

    @Basic(optional = false)
    @Column(name = "sizeadjusthi")
    private int sizeadjusthi;

    @Basic(optional = false)
    @Column(name = "test")
    private boolean test;

    @Basic(optional = false)
    @Column(name = "rulevalue2")
    private String rulevalue2;

    @Basic(optional = false)
    @Column(name = "answerismatrix")
    private boolean answerismatrix;

    @Column(name = "startdate")
    private Timestamp startdate = new Timestamp(System.currentTimeMillis());

    @Column(name = "enddate")
    private Timestamp enddate = new Timestamp(System.currentTimeMillis());

    @Basic(optional = false)
    @Column(name = "allowedanswer")
    private boolean allowedanswer;

    @Basic(optional = false)
    @Column(name = "recalc")
    private boolean recalc;

    @Column(name = "weldedl")
    private boolean weldedl;

    @Column(name = "weldedr")
    private boolean weldedr;

    @Column(name = "rulevaluei")
    private int rulevaluei;

    @Column(name = "nominal")
    private boolean nominal;

    @Column(name = "assemblyid")
    public int assemblyid = 0;

    @Column(name = "p1")
    public int p1 = 0;

    @Column(name = "p2")
    public int p2 = 0;

    @Column(name = "p3")
    public int p3 = 0;

    @Column(name = "p4")
    public int p4 = 0;

    @Column(name = "p5")
    public int p5 = 0;

    @Column(name = "p6")
    public int p6 = 0;

    @Column(name = "p7")
    public int p7 = 0;

    @Column(name = "p8")
    public int p8 = 0;

    @Column(name = "p9")
    public int p9 = 0;

    @Column(name = "p10")
    public int p10 = 0;

    @Column(name = "p11")
    public int p11 = 0;

    @Column(name = "p12")
    public int p12 = 0;

    @Column(name = "p13")
    public int p13 = 0;

    @Column(name = "p14")
    public int p14 = 0;

    @Column(name = "p15")
    public int p15 = 0;

    @Column(name = "p16")
    public int p16 = 0;

    @Column(name = "p17")
    public int p17 = 0;

    @Column(name = "p18")
    public int p18 = 0;

    @Column(name = "p19")
    public int p19 = 0;

    @Column(name = "p20")
    public int p20 = 0;

    @Column(name = "p21")
    public int p21 = 0;

    @Column(name = "p22")
    public int p22 = 0;

    @Column(name = "treeid")
    public int treeid = 0;

    @Column(name = "qtyexpression")
    public String qtyexpression = "";

    @Column(name = "adjwexpression")
    public String adjwexpression = "";

    @Column(name = "adjhexpression")
    public String adjhexpression = "";

    @Column(name = "qtyexpressioni")
    public String qtyexpressioni = "";

    @Column(name = "adjwexpressioni")
    public String adjwexpressioni = "";

    @Column(name = "adjhexpressioni")
    public String adjhexpressioni = "";

    @Column(name = "global_option")
    public boolean globalOption = false;

    @Transient
    public int supplierId;

    @Transient
    public boolean remote;

    @Transient
    public int parentAssembly = 0;

    @Transient
    public int assembly = 0;

    @Transient
    public int prodLine = 0;

    @Transient
    public int station = 0;

    @Transient
    public int stage = 0;

    @Transient
    public int report = 0;

    @Transient
    public int process = 0;

    @Transient
    public boolean glazed = true;

    //*********************************************<Constructors>*******************************************************

    public Rules() {
    }

    public Rules(RulesPK rulesPK) {
        this.rulesPK = rulesPK;
    }

    public Rules(RulesPK rulesPK, String description, int level, int parentLevel, int ruletype, int rulevalue, int leftside,
                 int rightside, boolean affectsdesign, int position, int rcondition, int quantitytype, int qtyvalue,
                 int sizeadjustwtype, int sizeadjustw, int sizeadjustwi, int sizeadjusthtype, int sizeadjusth,
                 int sizeadjusthi, boolean test, String rulevalue2, boolean answerismatrix, Timestamp startdate,
                 Timestamp enddate, boolean allowedanswer, boolean recalc) {

        this.rulesPK = rulesPK;
        this.description = description;
        this.assemblyID = level;
        this.levelID = parentLevel;
        this.ruletype = ruletype;
        this.rulevalue = rulevalue;
        this.leftside = leftside;
        this.rightside = rightside;
        this.affectsdesign = affectsdesign;
        this.position = position;
        this.rcondition = rcondition;
        this.quantitytype = quantitytype;
        this.qtyvalue = qtyvalue;
        this.sizeadjustwtype = sizeadjustwtype;
        this.sizeadjustw = sizeadjustw;
        this.sizeadjustwi = sizeadjustwi;
        this.sizeadjusthtype = sizeadjusthtype;
        this.sizeadjusth = sizeadjusth;
        this.sizeadjusthi = sizeadjusthi;
        this.test = test;
        this.rulevalue2 = rulevalue2;
        this.answerismatrix = answerismatrix;
        this.startdate = startdate;
        this.enddate = enddate;
        this.allowedanswer = allowedanswer;
        this.recalc = recalc;
    }

    public Rules(RulesPK rulesPK, String description, int assemblyID, int levelID, int ruletype, int rulevalue, int leftside,
                 int rightside, boolean affectsdesign, int position, int rcondition, int quantitytype, int qtyvalue,
                 int sizeadjustwtype, int sizeadjustw, int sizeadjustwi, int sizeadjusthtype, int sizeadjusth, int sizeadjusthi,
                 boolean test, String rulevalue2, boolean answerismatrix, Timestamp startdate, Timestamp enddate,
                 boolean allowedanswer, boolean recalc, boolean weldedl, boolean weldedr, int rulevaluei, boolean nominal,
                 int assemblyid, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8, int p9, int p10, int p11,
                 int p12, int p13, int p14, int p15, int p16, int p17, int p18, int p19, int p20, int p21, int p22,
                 int treeid, String qtyexpression, String adjwexpression, String adjhexpression, String qtyexpressioni,
                 String adjwexpressioni, String adjhexpressioni, boolean globalOption) {

        this.rulesPK = rulesPK;
        this.description = description;
        this.assemblyID = assemblyID;
        this.levelID = levelID;
        this.ruletype = ruletype;
        this.rulevalue = rulevalue;
        this.leftside = leftside;
        this.rightside = rightside;
        this.affectsdesign = affectsdesign;
        this.position = position;
        this.rcondition = rcondition;
        this.quantitytype = quantitytype;
        this.qtyvalue = qtyvalue;
        this.sizeadjustwtype = sizeadjustwtype;
        this.sizeadjustw = sizeadjustw;
        this.sizeadjustwi = sizeadjustwi;
        this.sizeadjusthtype = sizeadjusthtype;
        this.sizeadjusth = sizeadjusth;
        this.sizeadjusthi = sizeadjusthi;
        this.test = test;
        this.rulevalue2 = rulevalue2;
        this.answerismatrix = answerismatrix;
        this.startdate = startdate;
        this.enddate = enddate;
        this.allowedanswer = allowedanswer;
        this.recalc = recalc;
        this.weldedl = weldedl;
        this.weldedr = weldedr;
        this.rulevaluei = rulevaluei;
        this.nominal = nominal;
        this.assemblyid = assemblyid;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
        this.p7 = p7;
        this.p8 = p8;
        this.p9 = p9;
        this.p10 = p10;
        this.p11 = p11;
        this.p12 = p12;
        this.p13 = p13;
        this.p14 = p14;
        this.p15 = p15;
        this.p16 = p16;
        this.p17 = p17;
        this.p18 = p18;
        this.p19 = p19;
        this.p20 = p20;
        this.p21 = p21;
        this.p22 = p22;
        this.treeid = treeid;
        this.qtyexpression = qtyexpression;
        this.adjwexpression = adjwexpression;
        this.adjhexpression = adjhexpression;
        this.qtyexpressioni = qtyexpressioni;
        this.adjwexpressioni = adjwexpressioni;
        this.adjhexpressioni = adjhexpressioni;
        this.globalOption = globalOption;
    }

    //************************************************<Getters & Setters>***********************************************

    public Rules(int id, int seriesId, int segid) {
        this.rulesPK = new RulesPK(id, seriesId, segid);
    }

    public RulesPK getRulesPK() {
        return rulesPK;
    }

    public void setRulesPK(RulesPK rulesPK) {
        this.rulesPK = rulesPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return assemblyID;
    }

    public void setLevel(int level) {
        this.assemblyID = level;
    }

    public int getParentLevel() {
        return levelID;
    }

    public void setParentLevel(int parentLevel) {
        this.levelID = parentLevel;
    }

    public int getRuletype() {
        return ruletype;
    }

    public void setRuletype(int ruletype) {
        this.ruletype = ruletype;
    }

    public int getRulevalue() {
        return rulevalue;
    }

    public void setRulevalue(int rulevalue) {
        this.rulevalue = rulevalue;
    }

    public int getRulevaluei() {

        return rulevaluei;
    }

    public void setRulevaluei(int rulevaluei) {

        this.rulevaluei = rulevaluei;
    }

    public int getLeftside() {
        return leftside;
    }

    public void setLeftside(int leftside) {
        this.leftside = leftside;
    }

    public int getRightside() {
        return rightside;
    }

    public void setRightside(int rightside) {
        this.rightside = rightside;
    }

    public boolean getAffectsdesign() {

        return affectsdesign;
    }

    public void setAffectsdesign(boolean affectsdesign) {

        this.affectsdesign = affectsdesign;
    }

    public int getPosition() {

        return position;
    }

    public void setPosition(int position) {

        this.position = position;
    }

    public int getRcondition() {

        return rcondition;
    }

    public void setRcondition(int rcondition) {

        this.rcondition = rcondition;
    }

    public int getQuantitytype() {

        return quantitytype;
    }

    public void setQuantitytype(int quantitytype) {

        this.quantitytype = quantitytype;
    }

    public int getQtyvalue() {

        return qtyvalue;
    }

    public void setQtyvalue(int qtyvalue) {

        this.qtyvalue = qtyvalue;
    }

    public int getSizeadjustwtype() {

        return sizeadjustwtype;
    }

    public void setSizeadjustwtype(int sizeadjustwtype) {

        this.sizeadjustwtype = sizeadjustwtype;
    }

    public int getSizeadjustw() {

        return sizeadjustw;
    }

    public void setSizeadjustw(int sizeadjustw) {

        this.sizeadjustw = sizeadjustw;
    }

    public int getSizeadjustwi() {

        return sizeadjustwi;
    }

    public void setSizeadjustwi(int sizeadjustwi) {

        this.sizeadjustwi = sizeadjustwi;
    }

    public int getSizeadjusthtype() {

        return sizeadjusthtype;
    }

    public void setSizeadjusthtype(int sizeadjusthtype) {

        this.sizeadjusthtype = sizeadjusthtype;
    }

    public int getSizeadjusth() {

        return sizeadjusth;
    }

    public void setSizeadjusth(int sizeadjusth) {

        this.sizeadjusth = sizeadjusth;
    }

    public int getSizeadjusthi() {

        return sizeadjusthi;
    }

    public void setSizeadjusthi(int sizeadjusthi) {

        this.sizeadjusthi = sizeadjusthi;
    }

    public boolean getTest() {

        return test;
    }

    public void setTest(boolean test) {

        this.test = test;
    }

    public String getRulevalue2() {

        return rulevalue2;
    }

    public void setRulevalue2(String rulevalue2) {

        this.rulevalue2 = rulevalue2;
    }

    public boolean getAnswerismatrix() {

        return answerismatrix;
    }

    public void setAnswerismatrix(boolean answerismatrix) {

        this.answerismatrix = answerismatrix;
    }

    public Date getStartdate() {

        return startdate;
    }

    public void setStartdate(Timestamp startdate) {

        this.startdate = startdate;
    }

    public Date getEnddate() {

        return enddate;
    }

    public void setEnddate(Timestamp enddate) {

        this.enddate = enddate;
    }

    public boolean getAllowedanswer() {

        return allowedanswer;
    }

    public void setAllowedanswer(boolean allowedanswer) {

        this.allowedanswer = allowedanswer;
    }

    public boolean getRecalc() {

        return recalc;
    }

    public void setWeldedl(boolean wl) {
        this.weldedl = wl;
    }

    public boolean getWeldedl() {
        return weldedl;
    }

    public void setWeldedr(boolean wr) {
        this.weldedr = wr;
    }

    public boolean getWeldedr() {
        return weldedr;
    }

    public void setRecalc(boolean recalc) {
        this.recalc = recalc;
    }

    public int getAssemblyID() {
        return assemblyID;
    }

    public void setAssemblyID(int assemblyID) {
        this.assemblyID = assemblyID;
    }

    public int getLevelID() {
        return levelID;
    }

    public void setLevelID(int levelID) {
        this.levelID = levelID;
    }

    public boolean isNominal() {
        return nominal;
    }

    public void setNominal(boolean nominal) {
        this.nominal = nominal;
    }

    public int getAssemblyid() {
        return assemblyid;
    }

    public void setAssemblyid(int assemblyid) {
        this.assemblyid = assemblyid;
    }

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public int getP2() {
        return p2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }

    public int getP3() {
        return p3;
    }

    public void setP3(int p3) {
        this.p3 = p3;
    }

    public int getP4() {
        return p4;
    }

    public void setP4(int p4) {
        this.p4 = p4;
    }

    public int getP5() {
        return p5;
    }

    public void setP5(int p5) {
        this.p5 = p5;
    }

    public int getP6() {
        return p6;
    }

    public void setP6(int p6) {
        this.p6 = p6;
    }

    public int getP7() {
        return p7;
    }

    public void setP7(int p7) {
        this.p7 = p7;
    }

    public int getP8() {
        return p8;
    }

    public void setP8(int p8) {
        this.p8 = p8;
    }

    public int getP9() {
        return p9;
    }

    public void setP9(int p9) {
        this.p9 = p9;
    }

    public int getP10() {
        return p10;
    }

    public void setP10(int p10) {
        this.p10 = p10;
    }

    public int getP11() {
        return p11;
    }

    public void setP11(int p11) {
        this.p11 = p11;
    }

    public int getP12() {
        return p12;
    }

    public void setP12(int p12) {
        this.p12 = p12;
    }

    public int getP13() {
        return p13;
    }

    public void setP13(int p13) {
        this.p13 = p13;
    }

    public int getP14() {
        return p14;
    }

    public void setP14(int p14) {
        this.p14 = p14;
    }

    public int getP15() {
        return p15;
    }

    public void setP15(int p15) {
        this.p15 = p15;
    }

    public int getP16() {
        return p16;
    }

    public void setP16(int p16) {
        this.p16 = p16;
    }

    public int getP17() {
        return p17;
    }

    public void setP17(int p17) {
        this.p17 = p17;
    }

    public int getP18() {
        return p18;
    }

    public void setP18(int p18) {
        this.p18 = p18;
    }

    public int getP19() {
        return p19;
    }

    public void setP19(int p19) {
        this.p19 = p19;
    }

    public int getP20() {
        return p20;
    }

    public void setP20(int p20) {
        this.p20 = p20;
    }

    public int getP21() {
        return p21;
    }

    public void setP21(int p21) {
        this.p21 = p21;
    }

    public int getP22() {
        return p22;
    }

    public void setP22(int p22) {
        this.p22 = p22;
    }

    public int getTreeid() {
        return treeid;
    }

    public void setTreeid(int treeid) {
        this.treeid = treeid;
    }

    public String getQtyexpression() {
        return qtyexpression;
    }

    public void setQtyexpression(String qtyexpression) {
        this.qtyexpression = qtyexpression;
    }

    public String getAdjwexpression() {
        return adjwexpression;
    }

    public void setAdjwexpression(String adjwexpression) {
        this.adjwexpression = adjwexpression;
    }

    public String getAdjhexpression() {
        return adjhexpression;
    }

    public void setAdjhexpression(String adjhexpression) {
        this.adjhexpression = adjhexpression;
    }

    public String getQtyexpressioni() {
        return qtyexpressioni;
    }

    public void setQtyexpressioni(String qtyexpressioni) {
        this.qtyexpressioni = qtyexpressioni;
    }

    public String getAdjwexpressioni() {
        return adjwexpressioni;
    }

    public void setAdjwexpressioni(String adjwexpressioni) {
        this.adjwexpressioni = adjwexpressioni;
    }

    public String getAdjhexpressioni() {
        return adjhexpressioni;
    }

    public void setAdjhexpressioni(String adjhexpressioni) {
        this.adjhexpressioni = adjhexpressioni;
    }

    public boolean getGlobalOption() {
        return globalOption;
    }

    public void setGlobalOption(boolean globalOption) {
        this.globalOption = globalOption;
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
    public int hashCode() {
        int hash = 0;
        hash += (rulesPK != null ? rulesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        // TODO: Warning - this method won't work in the case the id fields
        // are not set
        if (!(object instanceof Rules)) {
            return false;
        }
        Rules other = (Rules) object;
        if ((this.rulesPK == null && other.rulesPK != null) || (this.rulesPK != null && !this.rulesPK.equals(other.rulesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return rulesPK.getId() + " " + this.description;
    }

}
