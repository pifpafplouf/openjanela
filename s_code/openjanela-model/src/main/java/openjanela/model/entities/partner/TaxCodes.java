package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.2
 *          Date: 09-01-13
 *          Time: 09:44 PM
 */
@Entity
@Table(name = "tax_codes")
public class TaxCodes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer id;

    @Column(name = "description", nullable = true)
    public String description;

    @Column(name = "tax_account", nullable = true)
    public String taxAccount = "";

    @Column(name = "valid_from", nullable = true)
    public Date validFrom;

    @Column(name = "valid_to", nullable = true)
    public Date validTo;

    @Column(name = "country", nullable = true)
    public String country;

    @Column(name = "state", nullable = false)
    public int state;

    @Column(name = "county", nullable = true)
    public String county;

    @Column(name = "city", nullable = true)
    public String city;

    @Column(name = "zip", nullable = true)
    public String zip;

    @Column(name = "currency", nullable = true)
    public String currency;

    @Column(name = "sequence", nullable = true)
    public Integer sequence;

    @Column(name = "coumpound", nullable = true)
    public boolean coumpound;

    @Column(name = "deposits_at_invoice_rate", nullable = true)
    public boolean depositsAtInvoiceRate;

    @Column(name = "max_taxable_value", nullable = true)
    public BigDecimal maxTaxableValue;

    @Column(name = "tax_base", nullable = true)
    public boolean taxBase;

    @Column(name = "tax_ship", nullable = true)
    public boolean taxShip;

    @Column(name = "tax_install", nullable = true)
    public boolean taxInstall;

    @Column(name = "tax_mfg_labor", nullable = true)
    public boolean taxMfgLabor;

    @Column(name = "tax_other", nullable = true)
    public boolean taxOther;

    @Column(name = "rate", nullable = true)
    public double rate;

    @Column(name = "abbrev", nullable = true)
    public String abbrev;

    public TaxCodes() {
    }

    public TaxCodes(Integer id, String description, String taxAccount, Date validFrom, Date validTo, String country,
                    int state, String county, String city, String zip, String currency, Integer sequence, boolean coumpound,
                    boolean depositsAtInvoiceRate, BigDecimal maxTaxableValue, boolean taxBase, boolean taxShip,
                    boolean taxInstall, boolean taxMfgLabor, boolean taxOther, double rate, String abbrev) {

        this.id = id;
        this.description = description;
        this.taxAccount = taxAccount;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.country = country;
        this.state = state;
        this.county = county;
        this.city = city;
        this.zip = zip;
        this.currency = currency;
        this.sequence = sequence;
        this.coumpound = coumpound;
        this.depositsAtInvoiceRate = depositsAtInvoiceRate;
        this.maxTaxableValue = maxTaxableValue;
        this.taxBase = taxBase;
        this.taxShip = taxShip;
        this.taxInstall = taxInstall;
        this.taxMfgLabor = taxMfgLabor;
        this.taxOther = taxOther;
        this.rate = rate;
        this.abbrev = abbrev;
    }

    //*******************************************<Getters & Setters>****************************************************

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

    public String getTaxAccount() {
        return taxAccount;
    }

    public void setTaxAccount(String taxAccount) {
        this.taxAccount = taxAccount;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public boolean isCoumpound() {
        return coumpound;
    }

    public void setCoumpound(boolean coumpound) {
        this.coumpound = coumpound;
    }

    public boolean isDepositsAtInvoiceRate() {
        return depositsAtInvoiceRate;
    }

    public void setDepositsAtInvoiceRate(boolean depositsAtInvoiceRate) {
        this.depositsAtInvoiceRate = depositsAtInvoiceRate;
    }

    public BigDecimal getMaxTaxableValue() {
        return maxTaxableValue;
    }

    public void setMaxTaxableValue(BigDecimal maxTaxableValue) {
        this.maxTaxableValue = maxTaxableValue;
    }

    public boolean isTaxBase() {
        return taxBase;
    }

    public void setTaxBase(boolean taxBase) {
        this.taxBase = taxBase;
    }

    public boolean isTaxShip() {
        return taxShip;
    }

    public void setTaxShip(boolean taxShip) {
        this.taxShip = taxShip;
    }

    public boolean isTaxInstall() {
        return taxInstall;
    }

    public void setTaxInstall(boolean taxInstall) {
        this.taxInstall = taxInstall;
    }

    public boolean isTaxMfgLabor() {
        return taxMfgLabor;
    }

    public void setTaxMfgLabor(boolean taxMfgLabor) {
        this.taxMfgLabor = taxMfgLabor;
    }

    public boolean isTaxOther() {
        return taxOther;
    }

    public void setTaxOther(boolean taxOther) {
        this.taxOther = taxOther;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }
}
