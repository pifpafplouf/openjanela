package openjanela.model.entities.orderEntry;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * Copyright(c) 2011-2013 OpenJanela LLC. All rights reserved.
 * Date: 03-05-13
 * Time: 09:43 PM
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 */
@Entity
@Table(name = "orders")
@Cacheable
public class Order implements Serializable {

    @EmbeddedId
    private OrderPK id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateentered", nullable = false)
    private Date dateEntered = new Date();

    @Column(name = "daterequired", nullable = false)
    private Date dateRequired = new Date();

    @Column(name = "pono", nullable = true, length = 20)
    private String pono = "";

    @Column(name = "originalquoteno", nullable = true)
    private int originalQuoteNo = 0;

    @Column(name = "partnerid", nullable = false)
    private int partnerId = 0;

    @Column(name = "contactid", nullable = true)
    private int contactId = 0;

    @Lob
    @Column(name = "notes", nullable = true)
    private String notes = "";

    @Column(name = "salesrepid", nullable = true)
    private int salesRepId = 0;

    @Column(name = "paymentid", nullable = true)
    private int paymentId = 0;

    @Column(name = "reference", nullable = true)
    private String reference = "";

    @Column(name = "taxid", nullable = true)
    private int taxId = 0;

    @Column(name = "taxid2", nullable = true)
    private int taxId_2 = 0;

    @Column(name = "taxid3", nullable = true)
    private int taxId_3 = 0;

    @Column(name = "tax2compound", nullable = true)
    private boolean tax_2_compound = false;

    @Column(name = "tax3compound", nullable = true)
    private boolean tax_3_compound = false;

    @Lob
    @Column(name = "letters", nullable = true)
    private String letters = "";

    @Column(name = "pricebyorder", nullable = true)
    private boolean priceByOrder = false;

    @Column(name = "subtotal", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal subTotal = new BigDecimal("0");

    @Column(name = "discountbypercent", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal discountByPercent = new BigDecimal("0");

    @Column(name = "discountbyvalue", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal discountByValue = new BigDecimal("0");

    @Column(name = "tax1value", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal tax_1_value = new BigDecimal("0");

    @Column(name = "tax2value", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal tax_2_value = new BigDecimal("0");

    @Column(name = "tax3value", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal tax_3_value = new BigDecimal("0");

    @Column(name = "deposit", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal deposit = new BigDecimal("0");

    @Column(name = "jobtypeid", nullable = false)
    private int jobTypeId = 0;

    @Column(name = "netprice", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal netPrice = new BigDecimal("0");

    @Column(name = "tax1percent", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal tax_1_percent = new BigDecimal("0");

    @Column(name = "tax2percent", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal tax_2_percent = new BigDecimal("0");

    @Column(name = "tax3percent", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal tax_3_percent = new BigDecimal("0");

    @Column(name = "order_status_id", nullable = true)
    private int orderStatusId = 0;

    @Column(name = "createdby", nullable = true)
    private int createdBy = 0;

    @Column(name = "statusid", nullable = true)
    private int statusId = 0;

    @Column(name = "lockedby", nullable = true)
    private int lockedBy = 0;

    @Column(name = "priority", nullable = true)
    private int priority = 0;

    @Column(name = "isservice", nullable = true)
    private boolean service = false;

    @Column(name = "campaign", nullable = false)
    private int campaign = 0;

    @Column(name = "shiptoid", nullable = false)
    private int shipToId = 0;

    @Column(name = "currencyid", nullable = true, length = 4)
    private String currencyId = "";

    @Column(name = "probability", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal probability = new BigDecimal("0");

    @Column(name = "totalqty", nullable = true)
    private int totalQty = 0;

    @Column(name = "lineitems", nullable = true)
    private int lineItems = 0;

    @Column(name = "billtoid", nullable = true)
    private int billToId = 0;

    @Column(name = "shipprice", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal shipPrice = new BigDecimal("0");

    @Column(name = "installprice", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal installPrice = new BigDecimal("0");

    @Column(name = "deliverynotes", nullable = true)
    private String deliveryNotes = "";

    @Column(name = "onbo", nullable = true)
    private boolean onbo = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastmod", nullable = false)
    private Date lastMod = new Date();

    @Column(name = "modby", nullable = true)
    private int modBy = 0;

    @Column(name = "dropship", nullable = true)
    private boolean dropShip = false;

    @Column(name = "dropshippartnerid", nullable = true)
    private int dropShipPartnerId = 0;

    @Column(name = "taxable", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal taxable = new BigDecimal("0");

    @Column(name = "balance", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal balance = new BigDecimal("0");

    @Column(name = "lossreason", nullable = true)
    private int lossReason = 0;

    @Lob
    @Column(name = "lossnotes", nullable = true)
    private String lossNotes = "";

    @Column(name = "baseprice", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal basePrice = new BigDecimal("0");

    @Column(name = "optionprice", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal optionPrice = new BigDecimal("0");

    @Column(name = "glassprice", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal glassPrice = new BigDecimal("0");

    @Column(name = "gridprice", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal gridPrice = new BigDecimal("0");

    @Column(name = "laborprice", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal laborPrice = new BigDecimal("0");

    @Column(name = "otherprice", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal otherPrice = new BigDecimal("0");

    @Column(name = "cashcustomer")
    private int cashcustomer = 0;

    @Column(name = "pickup", nullable = false)
    private boolean pickup;

    @Column(name = "code_EDI", nullable = true)
    private String codeEDI;
    
    @Column(name = "referring", nullable = true)
    private int referring = 0;

    public Order() {
    }

    public Order(OrderPK id, Date dateEntered, Date dateRequired, String pono, int originalQuoteNo, int partnerId,
                 int contactId, String notes, int salesRepId, int paymentId, String reference, int taxId, int taxId_2,
                 int taxId_3, boolean tax_2_compound, boolean tax_3_compound, String letters, boolean priceByOrder,
                 BigDecimal subTotal, BigDecimal discountByPercent, BigDecimal discountByValue, BigDecimal tax_1_value,
                 BigDecimal tax_2_value, BigDecimal tax_3_value, BigDecimal deposit, int jobTypeId, BigDecimal netPrice,
                 BigDecimal tax_1_percent, BigDecimal tax_2_percent, BigDecimal tax_3_percent, int orderStatusId,
                 int createdBy, int statusId, int lockedBy, int priority, boolean service, int campaign, int shipToId,
                 String currencyId, BigDecimal probability, int totalQty, int lineItems, int billToId, BigDecimal shipPrice,
                 BigDecimal installPrice, String deliveryNotes, boolean onbo, Date lastMod, int modBy, boolean dropShip,
                 int dropShipPartnerId, BigDecimal taxable, BigDecimal balance, int lossReason, String lossNotes,
                 BigDecimal basePrice, BigDecimal optionPrice, BigDecimal glassPrice, BigDecimal gridPrice, BigDecimal laborPrice,
                 BigDecimal otherPrice, int cashcustomer, boolean pickup, String codeEDI, int referring) {

        this.id = id;
        this.dateEntered = dateEntered;
        this.dateRequired = dateRequired;
        this.pono = pono;
        this.originalQuoteNo = originalQuoteNo;
        this.partnerId = partnerId;
        this.contactId = contactId;
        this.notes = notes;
        this.salesRepId = salesRepId;
        this.paymentId = paymentId;
        this.reference = reference;
        this.taxId = taxId;
        this.taxId_2 = taxId_2;
        this.taxId_3 = taxId_3;
        this.tax_2_compound = tax_2_compound;
        this.tax_3_compound = tax_3_compound;
        this.letters = letters;
        this.priceByOrder = priceByOrder;
        this.subTotal = subTotal;
        this.discountByPercent = discountByPercent;
        this.discountByValue = discountByValue;
        this.tax_1_value = tax_1_value;
        this.tax_2_value = tax_2_value;
        this.tax_3_value = tax_3_value;
        this.deposit = deposit;
        this.jobTypeId = jobTypeId;
        this.netPrice = netPrice;
        this.tax_1_percent = tax_1_percent;
        this.tax_2_percent = tax_2_percent;
        this.tax_3_percent = tax_3_percent;
        this.orderStatusId = orderStatusId;
        
        this.createdBy = createdBy;
        this.statusId = statusId;
        this.lockedBy = lockedBy;
        this.priority = priority;
        this.service = service;
        this.campaign = campaign;
        this.shipToId = shipToId;
        this.currencyId = currencyId;
        this.probability = probability;
        this.totalQty = totalQty;
        this.lineItems = lineItems;
        this.billToId = billToId;
        this.shipPrice = shipPrice;
        this.installPrice = installPrice;
        this.deliveryNotes = deliveryNotes;
        
        this.onbo = onbo;
        this.lastMod = lastMod;
        this.modBy = modBy;
        this.dropShip = dropShip;
        this.dropShipPartnerId = dropShipPartnerId;
        this.taxable = taxable;
        this.balance = balance;
        this.lossReason = lossReason;
        this.lossNotes = lossNotes;
        this.basePrice = basePrice;
        this.optionPrice = optionPrice;
        this.glassPrice = glassPrice;
        this.gridPrice = gridPrice;
        this.laborPrice = laborPrice;
        this.otherPrice = otherPrice;
        this.cashcustomer = cashcustomer;
        this.pickup = pickup;
        this.codeEDI = codeEDI;
        this.referring = referring;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public OrderPK getId() {
        return id;
    }

    public void setId(OrderPK id) {
        this.id = id;
    }

    public Date getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public Date getDateRequired() {
        return dateRequired;
    }

    public void setDateRequired(Date dateRequired) {
        this.dateRequired = dateRequired;
    }

    public String getPono() {
        return pono;
    }

    public void setPono(String pono) {
        this.pono = pono;
    }

    public int getOriginalQuoteNo() {
        return originalQuoteNo;
    }

    public void setOriginalQuoteNo(int originalQuoteNo) {
        this.originalQuoteNo = originalQuoteNo;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getSalesRepId() {
        return salesRepId;
    }

    public void setSalesRepId(int salesRepId) {
        this.salesRepId = salesRepId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getTaxId() {
        return taxId;
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }

    public int getTaxId_2() {
        return taxId_2;
    }

    public void setTaxId_2(int taxId_2) {
        this.taxId_2 = taxId_2;
    }

    public int getTaxId_3() {
        return taxId_3;
    }

    public void setTaxId_3(int taxId_3) {
        this.taxId_3 = taxId_3;
    }

    public boolean isTax_2_compound() {
        return tax_2_compound;
    }

    public void setTax_2_compound(boolean tax_2_compound) {
        this.tax_2_compound = tax_2_compound;
    }

    public boolean isTax_3_compound() {
        return tax_3_compound;
    }

    public void setTax_3_compound(boolean tax_3_compound) {
        this.tax_3_compound = tax_3_compound;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public boolean isPriceByOrder() {
        return priceByOrder;
    }

    public void setPriceByOrder(boolean priceByOrder) {
        this.priceByOrder = priceByOrder;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getDiscountByPercent() {
        return discountByPercent;
    }

    public void setDiscountByPercent(BigDecimal discountByPercent) {
        this.discountByPercent = discountByPercent;
    }

    public BigDecimal getDiscountByValue() {
        return discountByValue;
    }

    public void setDiscountByValue(BigDecimal discountByValue) {
        this.discountByValue = discountByValue;
    }

    public BigDecimal getTax_1_value() {
        return tax_1_value;
    }

    public void setTax_1_value(BigDecimal tax_1_value) {
        this.tax_1_value = tax_1_value;
    }

    public BigDecimal getTax_2_value() {
        return tax_2_value;
    }

    public void setTax_2_value(BigDecimal tax_2_value) {
        this.tax_2_value = tax_2_value;
    }

    public BigDecimal getTax_3_value() {
        return tax_3_value;
    }

    public void setTax_3_value(BigDecimal tax_3_value) {
        this.tax_3_value = tax_3_value;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public int getJobTypeId() {
        return jobTypeId;
    }

    public void setJobTypeId(int jobTypeId) {
        this.jobTypeId = jobTypeId;
    }

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(BigDecimal netPrice) {
        this.netPrice = netPrice;
    }

    public BigDecimal getTax_1_percent() {
        return tax_1_percent;
    }

    public void setTax_1_percent(BigDecimal tax_1_percent) {
        this.tax_1_percent = tax_1_percent;
    }

    public BigDecimal getTax_2_percent() {
        return tax_2_percent;
    }

    public void setTax_2_percent(BigDecimal tax_2_percent) {
        this.tax_2_percent = tax_2_percent;
    }

    public BigDecimal getTax_3_percent() {
        return tax_3_percent;
    }

    public void setTax_3_percent(BigDecimal tax_3_percent) {
        this.tax_3_percent = tax_3_percent;
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getLockedBy() {
        return lockedBy;
    }

    public void setLockedBy(int lockedBy) {
        this.lockedBy = lockedBy;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isService() {
        return service;
    }

    public void setService(boolean service) {
        this.service = service;
    }

    public int getCampaign() {
        return campaign;
    }

    public void setCampaign(int campaign) {
        this.campaign = campaign;
    }

    public int getShipToId() {
        return shipToId;
    }

    public void setShipToId(int shipToId) {
        this.shipToId = shipToId;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public BigDecimal getProbability() {
        return probability;
    }

    public void setProbability(BigDecimal probability) {
        this.probability = probability;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public int getLineItems() {
        return lineItems;
    }

    public void setLineItems(int lineItems) {
        this.lineItems = lineItems;
    }

    public int getBillToId() {
        return billToId;
    }

    public void setBillToId(int billToId) {
        this.billToId = billToId;
    }

    public BigDecimal getShipPrice() {
        return shipPrice;
    }

    public void setShipPrice(BigDecimal shipPrice) {
        this.shipPrice = shipPrice;
    }

    public BigDecimal getInstallPrice() {
        return installPrice;
    }

    public void setInstallPrice(BigDecimal installPrice) {
        this.installPrice = installPrice;
    }

    public String getDeliveryNotes() {
        return deliveryNotes;
    }

    public void setDeliveryNotes(String deliveryNotes) {
        this.deliveryNotes = deliveryNotes;
    }

    public boolean isOnbo() {
        return onbo;
    }

    public void setOnbo(boolean onbo) {
        this.onbo = onbo;
    }

    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public int getModBy() {
        return modBy;
    }

    public void setModBy(int modBy) {
        this.modBy = modBy;
    }

    public boolean isDropShip() {
        return dropShip;
    }

    public void setDropShip(boolean dropShip) {
        this.dropShip = dropShip;
    }

    public int getDropShipPartnerId() {
        return dropShipPartnerId;
    }

    public void setDropShipPartnerId(int dropShipPartnerId) {
        this.dropShipPartnerId = dropShipPartnerId;
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

    public int getLossReason() {
        return lossReason;
    }

    public void setLossReason(int lossReason) {
        this.lossReason = lossReason;
    }

    public String getLossNotes() {
        return lossNotes;
    }

    public void setLossNotes(String lossNotes) {
        this.lossNotes = lossNotes;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getOptionPrice() {
        return optionPrice;
    }

    public void setOptionPrice(BigDecimal optionPrice) {
        this.optionPrice = optionPrice;
    }

    public BigDecimal getGlassPrice() {
        return glassPrice;
    }

    public void setGlassPrice(BigDecimal glassPrice) {
        this.glassPrice = glassPrice;
    }

    public BigDecimal getGridPrice() {
        return gridPrice;
    }

    public void setGridPrice(BigDecimal gridPrice) {
        this.gridPrice = gridPrice;
    }

    public BigDecimal getLaborPrice() {
        return laborPrice;
    }

    public void setLaborPrice(BigDecimal laborPrice) {
        this.laborPrice = laborPrice;
    }

    public BigDecimal getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(BigDecimal otherPrice) {
        this.otherPrice = otherPrice;
    }

    public int getCashcustomer() {

        return cashcustomer;
    }

    public void setCashcustomer(int cashcustomer) {

        this.cashcustomer = cashcustomer;
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


