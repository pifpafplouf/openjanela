package openjanela.model.entities.design;

import java.io.Serializable;

/**
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-26-13
 *          Time: 03:36 PM
 */
public class DesignOptionsAnswersEntity implements Serializable {

    //Serializable version
    private static final long serialVersionUID = 555738436149212050L;

    private Integer Id;

    private Integer optionAnswerId;

    public DesignOptionsAnswersEntity() {
    }

    public DesignOptionsAnswersEntity(Integer optionAnswerId) {
        this.optionAnswerId = optionAnswerId;
    }

    //*********************************************<GETTERS & SETTERS>***********************************************

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getOptionAnswerId() {
        return optionAnswerId;
    }

    public void setOptionAnswerId(Integer optionAnswerId) {
        this.optionAnswerId = optionAnswerId;
    }
}
