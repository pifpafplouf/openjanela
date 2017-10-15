package openjanela.model.entities.design;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-12-12
 *          Time: 02:10 PM
 */
@Entity
@Table(name = "confirmed_orders")
@Cacheable
public class ConfirmedOrders implements Serializable {

    @Id
    @Column(name = "orderid", nullable = false)
    private Integer orderID;
    
    @Column(name = "dateordered", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOrdered = new Date(System.currentTimeMillis());
    
    @Column(name = "orderedby", nullable = false)
    private Integer orderedBy;
    
    @Column(name = "confirmed", nullable = false)
    private Boolean confirmed;
	
    @Column(name = "confirmdate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date confirmDate = new Date(System.currentTimeMillis());
    
    @Column(name = "confirmby", nullable = false)
    private Integer confirmBy;
    
    @Column(name = "shippingdate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date shippingDate = new Date(System.currentTimeMillis());
	
    @Column(name = "procompletedate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date proCompleteDate = new Date(System.currentTimeMillis());
	
    @Column(name = "prostartdate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date proStartDate = new Date(System.currentTimeMillis());
	
    @Column(name = "placepodate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date placePODate = new Date(System.currentTimeMillis());
    
    @Column(name = "lastdate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastDate = new Date(System.currentTimeMillis());
	
    @Column(name = "measure_start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date measureStartDate = new Date(System.currentTimeMillis());
    
    @Column(name = "measure_end_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date measureEndDate = new Date(System.currentTimeMillis());
    
    @Column(name = "installation_start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date installationStartDate = new Date(System.currentTimeMillis());
    
    @Column(name = "installation_end_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date installationEndDate = new Date(System.currentTimeMillis());
    
    @Column(name = "last_permits_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPermitsDate = new Date(System.currentTimeMillis());
    
    @Column(name = "delivery_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate = new Date(System.currentTimeMillis());
	
    /*
     
   "orderid"
   
    "dateordered"
    
   "orderedby"
    
    "confirmed"
   
    "confirmdate"
    
    "confirmby"
    
    "shippingdate"
    
    "procompletedate"
    
    "prostartdate"
   
    "placepodate"
    
    "lastdate"
  
    "measure_start_date"
    
    "measure_end_date"
   
    "installation_start_date"
   
    "installation_end_date"
  
    "last_permits_date"
   
   "delivery_date"
    
    */////////////////////////////
    
    public ConfirmedOrders() {
    }

    public ConfirmedOrders(Integer orderID, Date dateOrdered, Integer orderedBy, boolean confirmed,
    	    Date confirmDate, Integer confirmBy, Date shippingDate, Date proCompleteDate ,
    	    Date proStartDate,Date placePODate,Date lastDate, Date measureStartDate , 
    	    Date measureEndDate , Date installationStartDate, Date installationEndDate,
    	    Date lastPermitsDate , Date deliveryDate) {
    	
        this.orderID = orderID;
        this.dateOrdered = dateOrdered;
        this.orderedBy = orderedBy;
        this.confirmed = confirmed;
        this.confirmDate = confirmDate;
        this.confirmBy = confirmBy;
        this.shippingDate = shippingDate;
        this.proCompleteDate = proCompleteDate;
        this.proStartDate = proStartDate;
        this.placePODate = placePODate;
        this.lastDate = lastDate;
        this.measureStartDate = measureStartDate;
        this.installationStartDate = installationStartDate;
        this.installationEndDate = installationEndDate;
        this.lastPermitsDate = lastPermitsDate;
        
    }

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Date getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public Integer getOrderedBy() {
		return orderedBy;
	}

	public void setOrderedBy(Integer orderedBy) {
		this.orderedBy = orderedBy;
	}

	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	public Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	public Integer getConfirmBy() {
		return confirmBy;
	}

	public void setConfirmBy(Integer confirmBy) {
		this.confirmBy = confirmBy;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public Date getProCompleteDate() {
		return proCompleteDate;
	}

	public void setProCompleteDate(Date proCompleteDate) {
		this.proCompleteDate = proCompleteDate;
	}

	public Date getProStartDate() {
		return proStartDate;
	}

	public void setProStartDate(Date proStartDate) {
		this.proStartDate = proStartDate;
	}

	public Date getPlacePODate() {
		return placePODate;
	}

	public void setPlacePODate(Date placePODate) {
		this.placePODate = placePODate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public Date getMeasureStartDate() {
		return measureStartDate;
	}

	public void setMeasureStartDate(Date measureStartDate) {
		this.measureStartDate = measureStartDate;
	}

	public Date getMeasureEndDate() {
		return measureEndDate;
	}

	public void setMeasureEndDate(Date measureEndDate) {
		this.measureEndDate = measureEndDate;
	}

	public Date getInstallationStartDate() {
		return installationStartDate;
	}

	public void setInstallationStartDate(Date installationStartDate) {
		this.installationStartDate = installationStartDate;
	}

	public Date getInstallationEndDate() {
		return installationEndDate;
	}

	public void setInstallationEndDate(Date installationEndDate) {
		this.installationEndDate = installationEndDate;
	}

	public Date getLastPermitsDate() {
		return lastPermitsDate;
	}

	public void setLastPermitsDate(Date lastPermitsDate) {
		this.lastPermitsDate = lastPermitsDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

    // ==================================<GETTERS AND SETTERS METHODS>=================================================


   
}

