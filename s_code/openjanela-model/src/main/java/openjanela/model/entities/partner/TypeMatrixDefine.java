package openjanela.model.entities.partner;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-22-12
 * Time: 09:10 PM
 */
@Entity
@Table(name = "type_matrix_define")
public class TypeMatrixDefine implements Serializable {

    /**
     * PROPERTY NAME: Identification Id
     */
    private TypeMatrixDefinePK id;

    public TypeMatrixDefine() {
    }

    public TypeMatrixDefine(TypeMatrixDefinePK id) {
        this.id = id;
    }

    // ==================================<GETTTER AND SETTERS>=================================================

    @EmbeddedId
    public TypeMatrixDefinePK getId() {
        return id;
    }

    public void setId(TypeMatrixDefinePK id) {
        this.id = id;
    }
}
