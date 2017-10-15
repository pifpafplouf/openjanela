package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-22-12
 * Time: 09:03 PM
 */
@Entity
@Table(name = "type_matrix_cell")
@Cacheable
public class TypeMatrixCell implements Serializable {

    /**
     * PROPERTY NAME: Identification Id
     */
    private Integer id;
    /**
     * PROPERTY NAME: Description
     */
    private String description;

    public TypeMatrixCell() {
    }

    public TypeMatrixCell(Integer id, String description) {
        this.id = id;
        this.description = description;
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

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
