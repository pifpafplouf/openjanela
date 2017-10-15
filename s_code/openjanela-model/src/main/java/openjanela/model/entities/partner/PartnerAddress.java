package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 07-25-12
 *          Time: 09:35 AM
 */
@Entity
@Table(name = "partner_address")
@Cacheable
public class PartnerAddress implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "partnerid", nullable = false)
    private int partnerId;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "address1", nullable = true)
    private String address_1;

    @Column(name = "address2", nullable = true)
    private String address_2;

    @Column(name = "city", nullable = true)
    private String city;

    @Column(name = "province", nullable = false)
    private int province;

    @Column(name = "country", nullable = true)
    private String country;

    @Column(name = "postalcode", nullable = true)
    private String postalCode;

    @Column(name = "isdefault", nullable = false)
    private boolean isDefault;

    @Column(name = "notes", nullable = true)
    private String notes;

    @Column(name = "billto", nullable = false)
    private boolean billTo;

    @Column(name = "shipto", nullable = false)
    private boolean shipTo;

    @Column(name = "shiproute", nullable = false)
    private int shipRoute;

    @Column(name = "shipdrop", nullable = false)
    private int shipDrop;

    @Column(name = "pricepershipuom", nullable = true)
    private BigDecimal priceShipUOM;

    @Column(name = "county", nullable = true)
    private String county;

    @Column(name = "deleted", nullable = true)
    private boolean deleted;

    public PartnerAddress() {
    }

    public PartnerAddress(Integer id, int partnerId, String description, String address_1, String address_2, String city,
                          int province, String country, String postalCode, boolean isDefault, String notes, boolean billTo,
                          boolean shipTo, int shipRoute, int shipDrop, BigDecimal priceShipUOM, String county, boolean deleted) {

        this.id = id;
        this.partnerId = partnerId;
        this.description = description;
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalCode = postalCode;
        this.isDefault = isDefault;
        this.notes = notes;
        this.billTo = billTo;
        this.shipTo = shipTo;
        this.shipRoute = shipRoute;
        this.shipDrop = shipDrop;
        this.priceShipUOM = priceShipUOM;
        this.county = county;
        this.deleted = deleted;
    }

    //************************************************<Getters & Setters>***********************************************

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isBillTo() {
        return billTo;
    }

    public void setBillTo(boolean billTo) {
        this.billTo = billTo;
    }

    public boolean isShipTo() {
        return shipTo;
    }

    public void setShipTo(boolean shipTo) {
        this.shipTo = shipTo;
    }

    public int getShipRoute() {
        return shipRoute;
    }

    public void setShipRoute(int shipRoute) {
        this.shipRoute = shipRoute;
    }

    public int getShipDrop() {
        return shipDrop;
    }

    public void setShipDrop(int shipDrop) {
        this.shipDrop = shipDrop;
    }

    public BigDecimal getPriceShipUOM() {
        return priceShipUOM;
    }

    public void setPriceShipUOM(BigDecimal priceShipUOM) {
        this.priceShipUOM = priceShipUOM;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
