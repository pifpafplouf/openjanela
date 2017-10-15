package openjanela.model.entities.design;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 10/10/13
 *          Time: 12:41 PM
 */
@Entity
@Table(name = "design_ratings_label")
public class DesignRatingsLabel implements Serializable, Cloneable {

    //Serializable version
    private static final long serialVersionUID = 5862518417280840443L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "value", nullable = false)
    private String value;

    @Column(name = "part_label_pos_id", nullable = false)
    private Integer partLabelId;

    public DesignRatingsLabel() {
    }

    public DesignRatingsLabel(String value, Integer partLabelId) {
        this.value = value;
        this.partLabelId = partLabelId;
    }

    //**************************************************<Getter & Setter>***********************************************

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getPartLabelId() {
        return partLabelId;
    }

    public void setPartLabelId(Integer partLabelId) {
        this.partLabelId = partLabelId;
    }

    @Override
    public DesignRatingsLabel clone() {
        try {
            DesignRatingsLabel object = (DesignRatingsLabel)super.clone();

            return object;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
