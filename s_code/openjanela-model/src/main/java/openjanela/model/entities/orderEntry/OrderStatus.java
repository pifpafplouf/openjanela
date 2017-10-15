package openjanela.model.entities.orderEntry;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright(c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-17-13
 *          Time: 03:44 PM
 */
@Entity
@Table(name = "order_status")
public class OrderStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = true)
    private String description = "";

    @Column(name = "type_id", nullable = true)
    private Integer typeId = 0;

    public OrderStatus() {
    }

    public OrderStatus(String description, Integer typeId) {
        this.description = description;
        this.typeId = typeId;
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
