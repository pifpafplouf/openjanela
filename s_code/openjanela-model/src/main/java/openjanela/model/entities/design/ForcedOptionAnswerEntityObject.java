package openjanela.model.entities.design;

import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-09-13
 *          Time: 11:03 PM
 */
public class ForcedOptionAnswerEntityObject implements Serializable {

    //Serial Version UID
    private static final long serialVersionUID = 901309758159412528L;

    private int optionId;
    private int answerId;

    //*******************************************<Getter & Setters>*****************************************************

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }
}
