package openjanela.model.entities.admin;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 *
 * @author Eddy Montenegro
 *         Date: 09-17-12
 *         Time: 10:35 PM
 */
@Entity
@Table(name = "type_part_wild_cards")
@Cacheable
public class TypeWildCard implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

    public TypeWildCard() {}

    public TypeWildCard(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    // ==================================<GETTTER AND SETTERS>=================================================

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

    public String toString() {
        return description;
    }
}
