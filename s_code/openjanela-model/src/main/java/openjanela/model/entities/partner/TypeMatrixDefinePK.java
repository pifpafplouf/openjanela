package openjanela.model.entities.partner;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-22-12
 * Time: 09:13 PM
 */
@Embeddable
public class TypeMatrixDefinePK implements Serializable {

    /**
     * PROPERTY NAME: Matrix Identification Id
     */
    private Integer matrixTypeId;
    /**
     * PROPERTY NAME: RowType Identification Id
     */
    private Integer rowTypeId;
    /**
     * PROPERTY NAME: ColType Identification Id
     */
    private Integer colTypeId;

    /**
     * Constructor default
     */
    public TypeMatrixDefinePK() {

    }

    /**
     * Constructor type matrix Define PK
     *
     * @param matrixTypeId, Matrix type Identification Id
     * @param rowTypeId,    Row type Identification Id
     * @param colTypeId,    Col Type Identification Id
     */
    public TypeMatrixDefinePK(Integer matrixTypeId, Integer rowTypeId, Integer colTypeId) {
        this.matrixTypeId = matrixTypeId;
        this.rowTypeId = rowTypeId;
        this.colTypeId = colTypeId;
    }

    // ==================================<GETTTER AND SETTERS>=================================================

    @Column(name = "matrix_type", nullable = false)
    public Integer getMatrixTypeId() {
        return matrixTypeId;
    }

    public void setMatrixTypeId(Integer matrixTypeId) {
        this.matrixTypeId = matrixTypeId;
    }

    @Column(name = "row_type", nullable = false)
    public Integer getRowTypeId() {
        return rowTypeId;
    }

    public void setRowTypeId(Integer rowTypeId) {
        this.rowTypeId = rowTypeId;
    }

    @Column(name = "col_type", nullable = false)
    public Integer getColTypeId() {
        return colTypeId;
    }

    public void setColTypeId(Integer colTypeId) {
        this.colTypeId = colTypeId;
    }
}
