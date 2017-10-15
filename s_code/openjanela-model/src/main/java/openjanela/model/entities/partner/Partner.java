package openjanela.model.entities.partner;

import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-25-12
 *          Time: 09:35 AM
 */
@Entity
@Table(name = "partner")
@Cacheable
public class Partner implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "partnerid")
    private Integer partnerid;

    @Column(name = "companyname")
    private String companyName;

    @Column(name = "accountno", nullable = false)
    private Integer accountNo;

    @Column(name = "altaccountno")
    private String altAccountNo;

    @Column(name = "email")
    private String email;

    @Column(name = "website")
    private String website;

    @Column(name = "phone")
    private String phone;

    @Column(name = "fax")
    private String fax;

    @Column(name = "country")
    private String country;

    @Column(name = "notes")
    @Type(type = "text")
    private String notes;

    @Column(name = "paymentid")
    private Integer paymentId;

    @Column(name = "salesrepid")
    private Integer salesRepId;

    @Column(name = "taxid")
    private Integer taxId;

    @Column(name = "taxid2")
    private Integer tax2Id;

    @Column(name = "taxid3")
    private Integer tax3Id;

    @Column(name = "tax2compound")
    private boolean tax2Compound;

    @Column(name = "tax3compound")
    private boolean tax3Compound;

    @Column(name = "discount", nullable = true)
    private Double discount;

    @Column(name = "displaycontact", nullable = false)
    private String displayContact;

    @Column(name = "jobtypeid", nullable = true)
    private Integer jobTypeId;

    @Column(name = "creditlimit", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)")
    private BigDecimal creditLimit;

    @Column(name = "availcredit", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal availCredit;

    @Column(name = "currency", nullable = true)
    private String currency;

    @Column(name = "leadtime", nullable = false)
    private Integer leadTime;

    @Column(name = "cutoff", nullable = false)
    private Integer cutoff;

    @Column(name = "groupid", nullable = true)
    private Integer groupId;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "status", nullable = true)
    private Integer status;

    @Column(name = "factor", nullable = false)
    private boolean factor;

    @Column(name = "measure", nullable = false)
    private Integer measure;

    @Column(name = "partnertype", nullable = false)
    private int partnerType;

    @Column(name = "expense_account", nullable = false)
    private String expenseAccount;

    @Column(name = "tax_id", nullable = false)
    private String tax_ID;

    @Column(name = "account_extra_1", nullable = false)
    private String accountExtra1;

    @Column(name = "account_extra_2", nullable = false)
    private String accountExtra2;

    @Column(name = "date_created", nullable = false)
    private Date dateCreated;

    @Column(name = "partner_since", nullable = false)
    private Date partnerSince;

    @Column(name = "campaign", nullable = false)
    private int campaign;

    @Column(name = "oem", nullable = false)
    private boolean oem;

    @Column(name = "logo", nullable = true)
    private byte[] logo;

    @Column(name = "logo_name", nullable = false)
    private String logoName;
    
    @Column(name = "builder", nullable = false)
    private boolean builder;

    @Column(name = "is_edi", nullable = false)
    private boolean edi;

    @Column(name = "is_edi_confirm", nullable = false)
    private boolean edi_confirm;
    
    
    @Column(name = "referring_id", nullable = false)
    private int referringId;
    
    
    @Column(name = "list_id", nullable = false)
    private int listId;
    
    @Column(name = "inquiry_type", nullable = false)
    private int inquiryType;


    public Partner() {
    }

    public Partner(Integer id, Integer partnerid, String companyName, Integer accountNo, String altAccountNo, String email,
                   String website, String phone, String fax, String country, String notes, Integer paymentId, Integer salesRepId,
                   Integer taxId, Integer tax2Id, Integer tax3Id, boolean tax2Compound, boolean tax3Compound, Double discount,
                   String displayContact, Integer jobTypeId, BigDecimal creditLimit, BigDecimal availCredit, String currency,
                   Integer leadTime, Integer cutoff, Integer groupId, boolean active, Integer status, boolean factor,
                   Integer measure, int partnerType, String expenseAccount, String tax_ID, String accountExtra1,
                   String accountExtra2, Date dateCreated, Date partnerSince, int campaign, boolean oem, byte[] logo,
                   String logoName, boolean builder, boolean edi, boolean edi_confirm, int ref, int list, int inq) {

        this.id = id;
        this.partnerid = partnerid;
        this.companyName = companyName;
        this.accountNo = accountNo;
        this.altAccountNo = altAccountNo;
        this.email = email;
        this.website = website;
        this.phone = phone;
        this.fax = fax;
        this.country = country;
        this.notes = notes;
        this.paymentId = paymentId;
        this.salesRepId = salesRepId;
        this.taxId = taxId;
        this.tax2Id = tax2Id;
        this.tax3Id = tax3Id;
        this.tax2Compound = tax2Compound;
        this.tax3Compound = tax3Compound;
        this.discount = discount;
        this.displayContact = displayContact;
        this.jobTypeId = jobTypeId;
        this.creditLimit = creditLimit;
        this.availCredit = availCredit;
        this.currency = currency;
        this.leadTime = leadTime;
        this.cutoff = cutoff;
        this.groupId = groupId;
        this.active = active;
        this.status = status;
        this.factor = factor;
        this.measure = measure;
        this.partnerType = partnerType;
        this.expenseAccount = expenseAccount;
        this.tax_ID = tax_ID;
        this.accountExtra1 = accountExtra1;
        this.accountExtra2 = accountExtra2;
        this.dateCreated = dateCreated;
        this.partnerSince = partnerSince;
        this.campaign = campaign;
        this.oem = oem;
        this.logo = logo;
        this.logoName = logoName;
        this.builder = builder;
        this.edi = edi;
        this.edi_confirm = edi_confirm;
        this.referringId = ref;
        this.listId = list;
        this.inquiryType = inq;
    }

    // ==========================================<GETTTER AND SETTERS>=================================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(Integer partnerid) {
        this.partnerid = partnerid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public String getAltAccountNo() {
        return altAccountNo;
    }

    public void setAltAccountNo(String altAccountNo) {
        this.altAccountNo = altAccountNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getSalesRepId() {
        return salesRepId;
    }

    public void setSalesRepId(Integer salesRepId) {
        this.salesRepId = salesRepId;
    }

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    public Integer getTax2Id() {
        return tax2Id;
    }

    public void setTax2Id(Integer tax2Id) {
        this.tax2Id = tax2Id;
    }

    public Integer getTax3Id() {
        return tax3Id;
    }

    public void setTax3Id(Integer tax3Id) {
        this.tax3Id = tax3Id;
    }

    public boolean getTax2Compound() {
        return tax2Compound;
    }

    public void setTax2Compound(boolean tax2Compound) {
        this.tax2Compound = tax2Compound;
    }

    public boolean getTax3Compound() {
        return tax3Compound;
    }

    public void setTax3Compound(boolean tax3Compound) {
        this.tax3Compound = tax3Compound;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getDisplayContact() {
        return displayContact;
    }

    public void setDisplayContact(String displayContact) {
        this.displayContact = displayContact;
    }

    public Integer getJobTypeId() {
        return jobTypeId;
    }

    public void setJobTypeId(Integer jobTypeId) {
        this.jobTypeId = jobTypeId;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getAvailCredit() {
        return availCredit;
    }

    public void setAvailCredit(BigDecimal availCredit) {
        this.availCredit = availCredit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(Integer leadTime) {
        this.leadTime = leadTime;
    }

    public Integer getCutoff() {
        return cutoff;
    }

    public void setCutoff(Integer cutoff) {
        this.cutoff = cutoff;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean getFactor() {
        return factor;
    }

    public void setFactor(boolean factor) {
        this.factor = factor;
    }

    public Integer getMeasure() {
        return measure;
    }

    public void setMeasure(Integer measure) {
        this.measure = measure;
    }

    public int getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(int partnerType) {
        this.partnerType = partnerType;
    }

    public String getExpenseAccount() {
        return expenseAccount;
    }

    public void setExpenseAccount(String expenseAccount) {
        this.expenseAccount = expenseAccount;
    }

    public String getTaxID() {
        return tax_ID;
    }

    public void setTaxID(String taxID) {
        this.tax_ID = taxID;
    }

    public String getAccountExtra1() {
        return accountExtra1;
    }

    public void setAccountExtra1(String accountExtra1) {
        this.accountExtra1 = accountExtra1;
    }

    public String getAccountExtra2() {
        return accountExtra2;
    }

    public void setAccountExtra2(String accountExtra2) {
        this.accountExtra2 = accountExtra2;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getPartnerSince() {
        return partnerSince;
    }

    public int getCampaign() {
        return campaign;
    }

    public void setCampaign(int campaign) {
        this.campaign = campaign;
    }

    public void setPartnerSince(Date partnerSince) {
        this.partnerSince = partnerSince;
    }

    public String getLogoName() {
        return logoName;
    }

    public void setLogoName(String logoName) {
        this.logoName = logoName;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public boolean isOem() {
        return oem;
    }

    public void setOem(boolean oem) {
        this.oem = oem;
    }
    
    public boolean isBuilder() {
        return builder;
    }

    public void setBuilder(boolean b) {
        this.builder = b;
    }
        
    public String getTax_ID() {
        return tax_ID;
    }

    public void setTax_ID(String tax_ID) {
        this.tax_ID = tax_ID;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isTax3Compound() {
        return tax3Compound;
    }

    public boolean isTax2Compound() {
        return tax2Compound;
    }

    public boolean isEdi() {
        return edi;
    }

    public void setEdi(boolean edi) {
        this.edi = edi;
    }

    public boolean isEdi_confirm() {
        return edi_confirm;
    }

    public void setEdi_confirm(boolean edi_confirm) {
        this.edi_confirm = edi_confirm;
    }

    public int getReferringId() {
		return referringId;
	}

	public void setReferringId(int referringId) {
		this.referringId = referringId;
	}

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	public int getInquiryType() {
		return inquiryType;
	}

	public void setInquiryType(int inquiryType) {
		this.inquiryType = inquiryType;
	}

	@Override
    public boolean equals(Object object) {

        if (object instanceof Partner) {
            Partner partner = (Partner) object;

            if (this.partnerid.intValue() == partner.partnerid.intValue()) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return this.companyName;
    }

}
