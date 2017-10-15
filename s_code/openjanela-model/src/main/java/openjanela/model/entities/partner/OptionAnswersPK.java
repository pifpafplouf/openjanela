package openjanela.model.entities.partner;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-31-12
 *          Time: 08:40 PM
 */
@Embeddable
public class OptionAnswersPK implements Serializable {

    @Column(name = "id", nullable = false)
    public int id;

    @Column(name = "option_id", nullable = false)
    public int optionId;

    /**
     * Option Answer Primary Key Constructor
     */
    public OptionAnswersPK() {
    }

    /**
     * Option Answer Primary Key Constructor
     *
     * @param id,       Identification Id
     * @param optionId, Option Identification Id
     */
    public OptionAnswersPK(int id, int optionId) {
        this.id = id;
        this.optionId = optionId;
    }

    //****************************************<GETTERS & SETTERS>******************************************************

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }
}
