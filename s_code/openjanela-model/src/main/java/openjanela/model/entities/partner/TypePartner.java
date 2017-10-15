package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 07-25-12
 * Time: 11:03 AM
 */
@Entity
@Table(name = "type_partner")
public class TypePartner implements Serializable {

    /**
     * PROPERTY NAME: Identification Id
     */
    private Integer id;
    /**
     * PROPERTY NAME: Description Type partner
     */
    private String description;
    /**
     * PROPERTY NAME: Projects
     */
    private boolean projects;
    /**
     * PROPERTY NAME: Orders
     */
    private boolean orders;
    /**
     * PROPERTY NAME: Quotes
     */
    private boolean quotes;
    /**
     * PROPERTY NAME: Service
     */
    private boolean service;
    /**
     * PROPERTY NAME: Company
     */
    private boolean company;
    /**
     * PROPERTY NAME: Prospect
     */
    private Integer prospect;
    /**
     * PROPERTY NAME: Partner
     */
    private boolean partner;
    /**
     * PROPERTY NAME: Dealer
     */
    private boolean dealer;
    /**
     * PROPERTY NAME: Indicate if is supplier
     */
    private boolean isSupplier;
    /**
     * PROPERTY NAME: System.Partner Type
     */
    private Integer systemPartnerType;

    public TypePartner() {
    }

    public TypePartner(Integer id, String description, boolean projects, boolean orders, boolean quotes, boolean service,
                       boolean company, Integer prospect, boolean partner, boolean dealer, boolean isSupplier,
                       Integer systemPartnerType) {
        this.id = id;
        this.description = description;
        this.projects = projects;
        this.orders = orders;
        this.quotes = quotes;
        this.service = service;
        this.company = company;
        this.prospect = prospect;
        this.partner = partner;
        this.dealer = dealer;
        this.isSupplier = isSupplier;
        this.systemPartnerType = systemPartnerType;
    }

    // ==================================<GETTTER AND SETTERS>=================================================

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "projects", nullable = false)
    public boolean getProjects() {
        return projects;
    }

    public void setProjects(boolean projects) {
        this.projects = projects;
    }

    @Column(name = "orders", nullable = false)
    public boolean getOrders() {
        return orders;
    }

    public void setOrders(boolean orders) {
        this.orders = orders;
    }

    @Column(name = "quotes", nullable = false)
    public boolean getQuotes() {
        return quotes;
    }

    public void setQuotes(boolean quotes) {
        this.quotes = quotes;
    }

    @Column(name = "service", nullable = false)
    public boolean getService() {
        return service;
    }

    public void setService(boolean service) {
        this.service = service;
    }

    @Column(name = "company", nullable = false)
    public boolean getCompany() {
        return company;
    }

    public void setCompany(boolean company) {
        this.company = company;
    }

    @Column(name = "prospects", nullable = false)
    public Integer getProspect() {
        return prospect;
    }

    public void setProspect(Integer prospect) {
        this.prospect = prospect;
    }

    @Column(name = "partner", nullable = false)
    public boolean getPartner() {
        return partner;
    }

    public void setPartner(boolean partner) {
        this.partner = partner;
    }

    @Column(name = "dealer", nullable = false)
    public boolean getDealer() {
        return dealer;
    }

    public void setDealer(boolean dealer) {
        this.dealer = dealer;
    }

    @Column(name = "issupplier", nullable = false)
    public boolean getSupplier() {
        return isSupplier;
    }

    public void setSupplier(boolean supplier) {
        isSupplier = supplier;
    }

    @Column(name = "system_partner_type", nullable = false)
    public Integer getSystemPartnerType() {
        return systemPartnerType;
    }

    public void setSystemPartnerType(Integer systemPartnerType) {
        this.systemPartnerType = systemPartnerType;
    }
}
