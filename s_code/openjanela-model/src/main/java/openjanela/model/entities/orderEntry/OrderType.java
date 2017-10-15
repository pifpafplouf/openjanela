package openjanela.model.entities.orderEntry;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright(c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-17-13
 *          Time: 03:26 PM
 */
@Entity
@Table(name = "order_type")
@Cacheable
public class OrderType implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = true)
    private String description = "";

    @Column(name = "CostIncrease", nullable = true)
    private double costIncrease = 0;

    @Column(name = "taxship", nullable = true)
    private boolean taxShip = false;

    @Column(name = "taxinstall", nullable = true)
    private boolean taxInstall;

    public OrderType() {
    }

    public OrderType(Integer id, String description, double costIncrease, boolean taxShip, boolean taxInstall) {
        this.id = id;
        this.description = description;
        this.costIncrease = costIncrease;
        this.taxShip = taxShip;
        this.taxInstall = taxInstall;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

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

    public double getCostIncrease() {
        return costIncrease;
    }

    public void setCostIncrease(double costIncrease) {
        this.costIncrease = costIncrease;
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
}
