package openjanela.model.entities.partner;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-22-12
 * Time: 07:42 PM
 */
@Entity
@Table(name = "matrix")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Matrix implements Serializable {

    /**
     * PROPERTY NAME: Identification Id
     */
    private MatrixPK id;
    /**
     * PROPERTY NAME: Matrix Row L
     */
    private String matrixRowL;
    /**
     * PROPERTY NAME: Matrix Row U
     */
    private String matrixRowU;
    /**
     * PROPERTY NAME: Matrix Col L
     */
    private String matrixColL;
    /**
     * PROPERTY NAME: Matrix Col U
     */
    private String matrixColU;
    /**
     * PROPERTY NAME: Cell type
     */
    private Integer cellType;
    /**
     * PROPERTY NAME: price
     */
    private String price;

    private int supplierId = 0;

    private boolean remote = false;

    public Matrix() {
    }

    public Matrix(MatrixPK id, String matrixRowL, String matrixRowU, String matrixColL, String matrixColU, Integer cellType,
                  String price) {
        this.id = id;
        this.matrixRowL = matrixRowL;
        this.matrixRowU = matrixRowU;
        this.matrixColL = matrixColL;
        this.matrixColU = matrixColU;
        this.cellType = cellType;
        this.price = price;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    @EmbeddedId
    public MatrixPK getId() {
        return id;
    }

    public void setId(MatrixPK id) {
        this.id = id;
    }

    @Column(name = "rowL", nullable = false)
    public String getMatrixRowL() {
        return matrixRowL;
    }

    public void setMatrixRowL(String matrixRowL) {
        this.matrixRowL = matrixRowL;
    }

    @Column(name = "rowU", nullable = false)
    public String getMatrixRowU() {
        return matrixRowU;
    }

    public void setMatrixRowU(String matrixRowU) {
        this.matrixRowU = matrixRowU;
    }

    @Column(name = "colL", nullable = false)
    public String getMatrixColL() {
        return matrixColL;
    }

    public void setMatrixColL(String matrixColL) {
        this.matrixColL = matrixColL;
    }

    @Column(name = "colU", nullable = false)
    public String getMatrixColU() {
        return matrixColU;
    }

    public void setMatrixColU(String matrixColU) {
        this.matrixColU = matrixColU;
    }

    @Column(name = "cell_type", nullable = false)
    public Integer getCellType() {
        return cellType;
    }

    public void setCellType(Integer cellType) {
        this.cellType = cellType;
    }

    @Column(name = "price", nullable = false)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Transient
    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    @Transient
    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }
}
