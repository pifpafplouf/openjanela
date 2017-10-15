package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-22-12
 * Time: 09:24 PM
 */
@Entity
@Table(name = "type_matrix_dictionary")
@Cacheable
public class TypeMatrixDiccionary implements Serializable {

    /**
     * PROPERTY NAME: Type Matrix Identification Key
     */
    private Integer id;
    /**
     * PROPERTY NAME: Description
     */
    private String description;
    /**
     * PROPERTY NAME: Sentence SQL
     */
    private String sqlSentence;

    public TypeMatrixDiccionary() {
    }

    public TypeMatrixDiccionary(Integer id, String description, String sqlSentence) {
        this.id = id;
        this.description = description;
        this.sqlSentence = sqlSentence;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

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

    @Column(name = "sqlsentence")
    public String getSqlSentence() {
        return sqlSentence;
    }

    public void setSqlSentence(String sqlSentence) {
        this.sqlSentence = sqlSentence;
    }
}
