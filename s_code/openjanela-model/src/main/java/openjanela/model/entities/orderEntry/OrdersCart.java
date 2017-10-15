package openjanela.model.entities.orderEntry;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Copyright(c) 2011-2013 OpenJanela LLC. All rights reserved.
 * Date: 03-05-13
 * Time: 09:43 PM
 *
 * @author Sherif Eldibani
 * @author Eddy Montenegro
 * @version 2.0.8
 */
@Entity
@Table(name = "orders_cart")
public class OrdersCart implements Serializable {

    @EmbeddedId
    private OrdersCartPK ordersCartPK;

    @Column(name = "dateentered", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateentered;

    @Column(name = "daterequired", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date daterequired;

    @Column(name = "pono")
    private String pono;

    @Column(name = "originalquoteno")
    private Integer originalquoteno;

    @Column(name = "partnerid", nullable = false)
    private int partnerid;

    @Column(name = "contactid")
    private Integer contactid;

    @Lob
    @Column(name = "notes")
    private String notes;

    @Column(name = "salesrepid")
    private Integer salesrepid;

    @Column(name = "paymentid")
    private Integer paymentid;

    @Column(name = "reference")
    private String reference;

    @Column(name = "taxid")
    private Integer taxid;

    @Column(name = "taxid2")
    private Integer taxid2;

    @Column(name = "taxid3")
    private Integer taxid3;

    @Column(name = "tax2compound")
    private boolean tax2compound;

    @Column(name = "tax3compound")
    private boolean tax3compound;

    @Lob
    @Column(name = "letters")
    private String letters;

    @Column(name = "pricebyorder")
    private boolean pricebyorder;

    @Column(name = "subtotal")
    private BigDecimal subtotal;

    @Column(name = "discountbypercent")
    private Double discountbypercent;

    @Column(name = "discountbyvalue")
    private BigDecimal discountbyvalue;

    @Column(name = "tax1value")
    private BigDecimal tax1value;

    @Column(name = "tax2value")
    private BigDecimal tax2value;

    @Column(name = "tax3value")
    private BigDecimal tax3value;

    @Column(name = "deposit")
    private BigDecimal deposit;

    @Column(name = "jobtypeid", nullable = false)
    private int jobtypeid;

    @Column(name = "netprice")
    private BigDecimal netprice;

    @Column(name = "tax1percent")
    private Double tax1percent;

    @Column(name = "tax2percent")
    private Double tax2percent;

    @Column(name = "tax3percent")
    private Double tax3percent;

    @Column(name = "order_status_id")
    private Integer orderStatusId;

    @Column(name = "createdby")
    private Integer createdby;

    @Column(name = "statusid")
    private Integer statusid;

    @Column(name = "lockedby")
    private Integer lockedby;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "isservice")
    private boolean isservice;

    @Column(name = "campaign", nullable = false)
    private int campaign;

    @Column(name = "shiptoid", nullable = false)
    private int shiptoid;

    @Column(name = "currencyid")
    private String currencyid;

    @Column(name = "probability")
    private Double probability;

    @Column(name = "totalqty")
    private Integer totalqty;

    @Column(name = "lineitems")
    private Integer lineitems;

    @Column(name = "billtoid")
    private Integer billtoid;

    @Column(name = "shipprice")
    private BigDecimal shipprice;

    @Column(name = "installprice")
    private BigDecimal installprice;

    @Column(name = "deliverynotes")
    private String deliverynotes;

    @Column(name = "onbo")
    private boolean onbo;

    @Column(name = "lastmod", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastmod;

    @Column(name = "modby")
    private Integer modby;

    @Column(name = "dropship")
    private boolean dropship;

    @Column(name = "dropshippartnerid")
    private Integer dropshippartnerid;

    @Column(name = "taxable")
    private BigDecimal taxable;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "lossreason")
    private Integer lossreason;

    @Lob
    @Column(name = "lossnotes")
    private String lossnotes;

    @Column(name = "baseprice")
    private BigDecimal baseprice;

    @Column(name = "optionprice")
    private BigDecimal optionprice;

    @Column(name = "glassprice")
    private BigDecimal glassprice;

    @Column(name = "gridprice")
    private BigDecimal gridprice;

    @Column(name = "laborprice")
    private BigDecimal laborprice;

    @Column(name = "otherprice")
    private BigDecimal otherprice;

    @Column(name = "cashcustomer")
    private int cashcustomer = 0;

    @Column(name = "pickup", nullable = false)
    private boolean pickup;

    @Column(name = "code_EDI", nullable = true)
    private String codeEDI;
    
    @Column(name = "referring", nullable = true)
    private int referring;

    public OrdersCart() {
    }

    public OrdersCart(OrdersCartPK ordersCartPK, Date dateentered, Date daterequired, String pono, Integer originalquoteno,
                      int partnerid, Integer contactid, String notes, Integer salesrepid, Integer paymentid, String reference,
                      Integer taxid, Integer taxid2, Integer taxid3, boolean tax2compound, boolean tax3compound, String letters,
                      boolean pricebyorder, BigDecimal subtotal, Double discountbypercent, BigDecimal discountbyvalue,
                      BigDecimal tax1value, BigDecimal tax2value, BigDecimal tax3value, BigDecimal deposit, int jobtypeid,
                      BigDecimal netprice, Double tax1percent, Double tax2percent, Double tax3percent, Integer orderStatusId,
                      Integer createdby, Integer statusid, Integer lockedby, Integer priority, boolean isservice, int campaign,
                      int shiptoid, String currencyid, Double probability, Integer totalqty, Integer lineitems, Integer billtoid,
                      BigDecimal shipprice, BigDecimal installprice, String deliverynotes, boolean onbo, Date lastmod, Integer modby,
                      boolean dropship, Integer dropshippartnerid, BigDecimal taxable, BigDecimal balance, Integer lossreason,
                      String lossnotes, BigDecimal baseprice, BigDecimal optionprice, BigDecimal glassprice, BigDecimal gridprice,
                      BigDecimal laborprice, BigDecimal otherprice, int cashcustomer, boolean pickup, String codeEDI, int referring) {

        this.ordersCartPK = ordersCartPK;
        this.dateentered = dateentered;
        this.daterequired = daterequired;
        this.pono = pono;
        this.originalquoteno = originalquoteno;
        this.partnerid = partnerid;
        this.contactid = contactid;
        this.notes = notes;
        this.salesrepid = salesrepid;
        this.paymentid = paymentid;
        this.reference = reference;
        this.taxid = taxid;
        this.taxid2 = taxid2;
        this.taxid3 = taxid3;
        this.tax2compound = tax2compound;
        this.tax3compound = tax3compound;
        this.letters = letters;
        this.pricebyorder = pricebyorder;
        this.subtotal = subtotal;
        this.discountbypercent = discountbypercent;
        this.discountbyvalue = discountbyvalue;
        this.tax1value = tax1value;
        this.tax2value = tax2value;
        this.tax3value = tax3value;
        this.deposit = deposit;
        this.jobtypeid = jobtypeid;
        this.netprice = netprice;
        this.tax1percent = tax1percent;
        this.tax2percent = tax2percent;
        this.tax3percent = tax3percent;
        this.orderStatusId = orderStatusId;
        this.createdby = createdby;
        this.statusid = statusid;
        this.lockedby = lockedby;
        this.priority = priority;
        this.isservice = isservice;
        this.campaign = campaign;
        this.shiptoid = shiptoid;
        this.currencyid = currencyid;
        this.probability = probability;
        this.totalqty = totalqty;
        this.lineitems = lineitems;
        this.billtoid = billtoid;
        this.shipprice = shipprice;
        this.installprice = installprice;
        this.deliverynotes = deliverynotes;
        this.onbo = onbo;
        this.lastmod = lastmod;
        this.modby = modby;
        this.dropship = dropship;
        this.dropshippartnerid = dropshippartnerid;
        this.taxable = taxable;
        this.balance = balance;
        this.lossreason = lossreason;
        this.lossnotes = lossnotes;
        this.baseprice = baseprice;
        this.optionprice = optionprice;
        this.glassprice = glassprice;
        this.gridprice = gridprice;
        this.laborprice = laborprice;
        this.otherprice = otherprice;
        this.cashcustomer = cashcustomer;
        this.pickup = pickup;
        this.codeEDI = codeEDI;
        this.referring = referring;
    }

    public OrdersCartPK getOrdersCartPK() {
        return ordersCartPK;
    }

    public void setOrdersCartPK(OrdersCartPK ordersCartPK) {
        this.ordersCartPK = ordersCartPK;
    }

    public Date getDateentered() {
        return dateentered;
    }

    public void setDateentered(Date dateentered) {
        this.dateentered = dateentered;
    }

    public Date getDaterequired() {
        return daterequired;
    }

    public void setDaterequired(Date daterequired) {
        this.daterequired = daterequired;
    }

    public String getPono() {
        return pono;
    }

    public void setPono(String pono) {
        this.pono = pono;
    }

    public Integer getOriginalquoteno() {
        return originalquoteno;
    }

    public void setOriginalquoteno(Integer originalquoteno) {
        this.originalquoteno = originalquoteno;
    }

    public int getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(int partnerid) {
        this.partnerid = partnerid;
    }

    public Integer getContactid() {
        return contactid;
    }

    public void setContactid(Integer contactid) {
        this.contactid = contactid;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getSalesrepid() {
        return salesrepid;
    }

    public void setSalesrepid(Integer salesrepid) {
        this.salesrepid = salesrepid;
    }

    public Integer getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(Integer paymentid) {
        this.paymentid = paymentid;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getTaxid() {
        return taxid;
    }

    public void setTaxid(Integer taxid) {
        this.taxid = taxid;
    }

    public Integer getTaxid2() {
        return taxid2;
    }

    public void setTaxid2(Integer taxid2) {
        this.taxid2 = taxid2;
    }

    public Integer getTaxid3() {
        return taxid3;
    }

    public void setTaxid3(Integer taxid3) {
        this.taxid3 = taxid3;
    }

    public boolean getTax2compound() {
        return tax2compound;
    }

    public void setTax2compound(boolean tax2compound) {
        this.tax2compound = tax2compound;
    }

    public boolean getTax3compound() {
        return tax3compound;
    }

    public void setTax3compound(boolean tax3compound) {
        this.tax3compound = tax3compound;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public boolean getPricebyorder() {
        return pricebyorder;
    }

    public void setPricebyorder(boolean pricebyorder) {
        this.pricebyorder = pricebyorder;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Double getDiscountbypercent() {
        return discountbypercent;
    }

    public void setDiscountbypercent(Double discountbypercent) {
        this.discountbypercent = discountbypercent;
    }

    public BigDecimal getDiscountbyvalue() {
        return discountbyvalue;
    }

    public void setDiscountbyvalue(BigDecimal discountbyvalue) {
        this.discountbyvalue = discountbyvalue;
    }

    public BigDecimal getTax1value() {
        return tax1value;
    }

    public void setTax1value(BigDecimal tax1value) {
        this.tax1value = tax1value;
    }

    public BigDecimal getTax2value() {
        return tax2value;
    }

    public void setTax2value(BigDecimal tax2value) {
        this.tax2value = tax2value;
    }

    public BigDecimal getTax3value() {
        return tax3value;
    }

    public void setTax3value(BigDecimal tax3value) {
        this.tax3value = tax3value;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public int getJobtypeid() {
        return jobtypeid;
    }

    public void setJobtypeid(int jobtypeid) {
        this.jobtypeid = jobtypeid;
    }

    public BigDecimal getNetprice() {
        return netprice;
    }

    public void setNetprice(BigDecimal netprice) {
        this.netprice = netprice;
    }

    public Double getTax1percent() {
        return tax1percent;
    }

    public void setTax1percent(Double tax1percent) {
        this.tax1percent = tax1percent;
    }

    public Double getTax2percent() {
        return tax2percent;
    }

    public void setTax2percent(Double tax2percent) {
        this.tax2percent = tax2percent;
    }

    public Double getTax3percent() {
        return tax3percent;
    }

    public void setTax3percent(Double tax3percent) {
        this.tax3percent = tax3percent;
    }

    public Integer getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public Integer getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Integer createdby) {
        this.createdby = createdby;
    }

    public Integer getStatusid() {
        return statusid;
    }

    public void setStatusid(Integer statusid) {
        this.statusid = statusid;
    }

    public Integer getLockedby() {
        return lockedby;
    }

    public void setLockedby(Integer lockedby) {
        this.lockedby = lockedby;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public boolean getIsservice() {
        return isservice;
    }

    public void setIsservice(boolean isservice) {
        this.isservice = isservice;
    }

    public int getCampaign() {
        return campaign;
    }

    public void setCampaign(int campaign) {
        this.campaign = campaign;
    }

    public int getShiptoid() {
        return shiptoid;
    }

    public void setShiptoid(int shiptoid) {
        this.shiptoid = shiptoid;
    }

    public String getCurrencyid() {
        return currencyid;
    }

    public void setCurrencyid(String currencyid) {
        this.currencyid = currencyid;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public Integer getTotalqty() {
        return totalqty;
    }

    public void setTotalqty(Integer totalqty) {
        this.totalqty = totalqty;
    }

    public Integer getLineitems() {
        return lineitems;
    }

    public void setLineitems(Integer lineitems) {
        this.lineitems = lineitems;
    }

    public Integer getBilltoid() {
        return billtoid;
    }

    public void setBilltoid(Integer billtoid) {
        this.billtoid = billtoid;
    }

    public BigDecimal getShipprice() {
        return shipprice;
    }

    public void setShipprice(BigDecimal shipprice) {
        this.shipprice = shipprice;
    }

    public BigDecimal getInstallprice() {
        return installprice;
    }

    public void setInstallprice(BigDecimal installprice) {
        this.installprice = installprice;
    }

    public String getDeliverynotes() {
        return deliverynotes;
    }

    public void setDeliverynotes(String deliverynotes) {
        this.deliverynotes = deliverynotes;
    }

    public boolean getOnbo() {
        return onbo;
    }

    public void setOnbo(boolean onbo) {
        this.onbo = onbo;
    }

    public Date getLastmod() {
        return lastmod;
    }

    public void setLastmod(Date lastmod) {
        this.lastmod = lastmod;
    }

    public Integer getModby() {
        return modby;
    }

    public void setModby(Integer modby) {
        this.modby = modby;
    }

    public boolean getDropship() {
        return dropship;
    }

    public void setDropship(boolean dropship) {
        this.dropship = dropship;
    }

    public Integer getDropshippartnerid() {
        return dropshippartnerid;
    }

    public void setDropshippartnerid(Integer dropshippartnerid) {
        this.dropshippartnerid = dropshippartnerid;
    }

    public BigDecimal getTaxable() {
        return taxable;
    }

    public void setTaxable(BigDecimal taxable) {
        this.taxable = taxable;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getLossreason() {
        return lossreason;
    }

    public void setLossreason(Integer lossreason) {
        this.lossreason = lossreason;
    }

    public String getLossnotes() {
        return lossnotes;
    }

    public void setLossnotes(String lossnotes) {
        this.lossnotes = lossnotes;
    }

    public BigDecimal getBaseprice() {
        return baseprice;
    }

    public void setBaseprice(BigDecimal baseprice) {
        this.baseprice = baseprice;
    }

    public BigDecimal getOptionprice() {
        return optionprice;
    }

    public void setOptionprice(BigDecimal optionprice) {
        this.optionprice = optionprice;
    }

    public BigDecimal getGlassprice() {
        return glassprice;
    }

    public void setGlassprice(BigDecimal glassprice) {
        this.glassprice = glassprice;
    }

    public BigDecimal getGridprice() {
        return gridprice;
    }

    public void setGridprice(BigDecimal gridprice) {
        this.gridprice = gridprice;
    }

    public BigDecimal getLaborprice() {
        return laborprice;
    }

    public void setLaborprice(BigDecimal laborprice) {
        this.laborprice = laborprice;
    }

    public BigDecimal getOtherprice() {
        return otherprice;
    }

    public void setOtherprice(BigDecimal otherprice) {
        this.otherprice = otherprice;
    }

    public int getCashcustomer() {
        return cashcustomer;
    }

    public void setCashcustomer(int cashcustomer) {
        this.cashcustomer = cashcustomer;
    }

    public boolean isTax2compound() {
        return tax2compound;
    }

    public boolean isTax3compound() {
        return tax3compound;
    }

    public boolean isPricebyorder() {
        return pricebyorder;
    }

    public boolean isIsservice() {
        return isservice;
    }

    public boolean isOnbo() {
        return onbo;
    }

    public boolean isDropship() {
        return dropship;
    }

    public boolean isPickup() {
        return pickup;
    }

    public void setPickup(boolean pickup) {
        this.pickup = pickup;
    }

    public String getCodeEDI() {
        return codeEDI;
    }

    public void setCodeEDI(String codeEDI) {
        this.codeEDI = codeEDI;
    }

	public int getReferring() {
		return referring;
	}

	public void setReferring(int referring) {
		this.referring = referring;
	}
}


