package org.openjanela.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import openjanela.model.entities.orderEntry.CartDefault;
import openjanela.model.entities.partner.PartnerDefault;
import openjanela.model.entities.sales.SalesRepsCommission;

import javax.swing.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 * <p/>
 * This class handle user preferences for OpenJanela configurator
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 01-23-13
 *          Time: 11:03 PM
 */
public class UserPreferences implements Serializable {

    private int supplierID;

    private int partnerID;
    private int userID;
    private int uomID;
    private int orderCartID;
    private int orderID;
    private int itemID;
    private int versionID;

    private int jobType;
    
    private int itemType;

    private int salesRepID;

    private double netListRatio;

    private double abdNetListRatio;

    private int companyID;

    private int seriesID;
    private int adjustmentRoID;
    private int designFamilyID;

    private int designID;

    private double width;
    private double height;

    private BigDecimal price;

    private String country;
    private String currency;
    private Locale locale;
    private String language;

    private String reference;
    private String location;
    private String description;

    private boolean isNew;
    private boolean isViewOut;
    private boolean isViewBom;
    private boolean isRound_total;
    private boolean isRound_price;
    private boolean isRound_discounted_price;
    private boolean isView_price;
    private boolean isView_cost;
    private boolean isChange_base_price;
    private boolean isChange_bom_price;
    private boolean isChange_discount;
    private boolean isChange_glass_price;
    private boolean isChange_option_price;
    private boolean isOpening_size;

    private boolean distribMP = true;
    private boolean distribMPtoIS = false;// distribute Manual Price to Install and Ship Price
    private boolean isSupplier = false;
    private boolean isEdit = true;

    private List<CartDefault> cartDefaults;
    private List<PartnerDefault> partnerDefaults;

    private JPanel itemsPanel;
    private JDialog parent;
    
    private int docType;

    public SalesRepsCommission salesCommission = new SalesRepsCommission();

    // ==================================<GETTTER AND SETTERS>=================================================

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getPartnerID() {

        return partnerID;
    }

    public void setPartnerID(int partnerID) {

        this.partnerID = partnerID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUomID() {
        return uomID;
    }

    public void setUomID(int uomID) {
        this.uomID = uomID;
    }

    public int getOrderCartID() {
        return orderCartID;
    }

    public void setOrderCartID(int orderCartID) {
        this.orderCartID = orderCartID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getVersionID() {
        return versionID;
    }

    public void setVersionID(int versionID) {
        this.versionID = versionID;
    }

    public int getSeriesID() {
        return seriesID;
    }

    public void setSeriesID(int seriesID) {
        this.seriesID = seriesID;
    }

    public int getAdjustmentRoID() {
        return adjustmentRoID;
    }

    public void setAdjustmentRoID(int adjustmentRoID) {
        this.adjustmentRoID = adjustmentRoID;
    }

    public int getDesignFamilyID() {
        return designFamilyID;
    }

    public void setDesignFamilyID(int designFamilyID) {
        this.designFamilyID = designFamilyID;
    }

    public int getDesignID() {
        return designID;
    }

    public void setDesignID(int designID) {
        this.designID = designID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isViewOut() {
        return isViewOut;
    }

    public void setViewOut(boolean viewOut) {
        isViewOut = viewOut;
    }

    public boolean isViewBom() {
        return isViewBom;
    }

    public void setViewBom(boolean isViewBom) {
        this.isViewBom = isViewBom;
    }

    public boolean isRound_total() {
        return isRound_total;
    }

    public void setRound_total(boolean round_total) {
        isRound_total = round_total;
    }

    public boolean isRound_price() {
        return isRound_price;
    }

    public void setRound_price(boolean round_price) {
        isRound_price = round_price;
    }

    public boolean isRound_discounted_price() {
        return isRound_discounted_price;
    }

    public void setRound_discounted_price(boolean round_discounted_price) {
        isRound_discounted_price = round_discounted_price;
    }

    public boolean isView_price() {
        return isView_price;
    }

    public void setView_price(boolean view_price) {
        isView_price = view_price;
    }

    public boolean isView_cost() {
        return isView_cost;
    }

    public void setView_cost(boolean view_cost) {
        isView_cost = view_cost;
    }

    public boolean isChange_base_price() {
        return isChange_base_price;
    }

    public void setChange_base_price(boolean change_base_price) {
        isChange_base_price = change_base_price;
    }

    public boolean isChange_bom_price() {
        return isChange_bom_price;
    }

    public void setChange_bom_price(boolean change_bom_price) {
        isChange_bom_price = change_bom_price;
    }

    public boolean isChange_discount() {
        return isChange_discount;
    }

    public void setChange_discount(boolean change_discount) {
        isChange_discount = change_discount;
    }

    public boolean isChange_glass_price() {
        return isChange_glass_price;
    }

    public void setChange_glass_price(boolean change_glass_price) {
        isChange_glass_price = change_glass_price;
    }

    public boolean isChange_option_price() {
        return isChange_option_price;
    }

    public void setChange_option_price(boolean chance_option_price) {
        isChange_option_price = chance_option_price;
    }

    public boolean isOpening_size() {
        return isOpening_size;
    }

    public void setOpening_size(boolean opening_size) {
        isOpening_size = opening_size;
    }

    public List getPartnerDefaults() {
        return partnerDefaults;
    }

    public void setPartnerDefaults(List partnerDefaults) {
        this.partnerDefaults = partnerDefaults;
    }

    public List getCartDefaults() {
        return cartDefaults;
    }

    public void setCartDefaults(List cartDefaults) {
        this.cartDefaults = cartDefaults;
    }

    public SalesRepsCommission getSalesCommission() {
		return salesCommission;
	}

	public void setSalesCommission(SalesRepsCommission salesCommission) {
		this.salesCommission = salesCommission;
	}

	public boolean isDistribMP() {

        return distribMP;
    }

    public void setDistribMP(boolean distribMP) {

        this.distribMP = distribMP;
    }

    public boolean isDistribMPtoIS() {

        return distribMPtoIS;
    }

    public void setDistribMPtoIS(boolean distribMPtoIS) {

        this.distribMPtoIS = distribMPtoIS;
    }

    public JPanel getItemsPanel() {
        return itemsPanel;
    }

    public void setItemsPanel(JPanel itemsPanel) {
        this.itemsPanel = itemsPanel;
    }

    public JDialog getParent() {
        return parent;
    }

    public void setParent(JDialog parent) {
        this.parent = parent;
    }

    public String getReference() {

        return reference;
    }

    public void setReference(String reference) {

        this.reference = reference;
    }

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public int getJobType() {

        return jobType;
    }

    public void setJobType(int jobType) {

        this.jobType = jobType;
    }

    public int getSalesRepID() {

        return salesRepID;
    }

    public void setSalesRepID(int salesRepID) {

        this.salesRepID = salesRepID;
    }

    public SalesRepsCommission getCommission() {

        return this.salesCommission;
    }

    public void setSalesRepCommission(SalesRepsCommission comm) {

        this.salesCommission = comm;
    }

    public double getNetListRatio() {

        return netListRatio;
    }

    public void setNetListRatio(double netListRatio) {

        this.netListRatio = netListRatio;
    }

    public double getAbdNetListRatio() {

        return abdNetListRatio;
    }

    public void setAbdNetListRatio(double abdNetListRatio) {

        this.abdNetListRatio = abdNetListRatio;
    }

    public int getDocType() {
		return docType;
	}

	public void setDocType(int docTtype) {
		this.docType = docTtype;
	}

	public boolean isSupplier() {
        return isSupplier;
    }

    public void setSupplier(boolean isSupplier) {
        this.isSupplier = isSupplier;
    }

    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

	public int getItemType() {
		return itemType;
	}

	public void setItemType(int itemType) {
		this.itemType = itemType;
	}

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
