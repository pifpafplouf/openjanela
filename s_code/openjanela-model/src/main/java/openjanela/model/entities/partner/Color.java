package openjanela.model.entities.partner;

import org.omg.CosNaming._NamingContextExtStub;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.2
 *          Date: 1/28/14
 *          Time: 10:36 AM
 */
@Entity
@Table(name = "color")
public class Color implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "r_rgb", nullable = false)
    private int r;

    @Column(name = "g_rgb", nullable = false)
    private int g;

    @Column(name = "b_rgb", nullable = false)
    private int b;

    @Column(name = "a_rgb", nullable = false)
    private int a;

    @Transient
    private Integer supplierId;

    @Transient
    private boolean remote;

    public Color() {
    }

    public Color(Integer id, String description, int r, int g, int b, int a) {
        this.id = id;
        this.description = description;
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

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

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

}
