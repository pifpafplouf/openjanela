package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 08-28-12
 * Time: 02:44 PM
 */
@Entity
@Table(name = "series_valid_shapes")
@Cacheable
public class SeriesValidShapes implements Serializable {

    /**
     * PROPERTY NAME: Primary Key Identification
     */
    private SeriesValidShapesPK id;
    /**
     * PROPERTY NAME: Supplier Identification Id
     */
    private Integer supplierId;
    /**
     * PROPERTY NAME: Supplier Remote
     */
    private boolean remote;

    // ==================================<GETTTER AND SETTERS>=================================================

    @EmbeddedId
    public SeriesValidShapesPK getId() {
        return id;
    }

    public void setId(SeriesValidShapesPK id) {
        this.id = id;
    }

    @Transient
    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
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
