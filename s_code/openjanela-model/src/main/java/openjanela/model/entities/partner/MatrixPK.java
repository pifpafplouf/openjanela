package openjanela.model.entities.partner;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-22-12
 * Time: 07:50 PM
 */
@Embeddable
public class MatrixPK implements Serializable {

    /**
     * PROPERTY NAME: Identification Id
     */
    private Integer id;
    /**
     * PROPERTY NAME: Cell number
     */
    private Integer cellNumber;

    /**
     * Default Constructor
     */
    public MatrixPK() {}

    /**
     * Constructor matrix primary key
     *
     * @param id,         Identification Id
     * @param cellNumber, Cell number
     */
    public MatrixPK(Integer id, Integer cellNumber) {
        this.id = id;
        this.cellNumber = cellNumber;
    }

    // ==================================<GETTTER AND SETTERS>=================================================

    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "cell_no", nullable = false)
    public Integer getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(Integer cellNumber) {
        this.cellNumber = cellNumber;
    }
}
