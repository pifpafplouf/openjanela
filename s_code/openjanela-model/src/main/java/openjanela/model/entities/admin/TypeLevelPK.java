package openjanela.model.entities.admin;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-18-13
 *          Time: 12:19 PM
 */
@Embeddable
public class TypeLevelPK implements Serializable {

    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "level_id", nullable = false)
    private Integer levelId;

    /**
     * Type Level Constructor
     */
    public TypeLevelPK() {
    }

    /**
     * Type Level Constructor
     *
     * @param id,      Identification Id
     * @param levelId, Level Identification Id
     */
    public TypeLevelPK(Integer id, Integer levelId) {
        this.id = id;
        this.levelId = levelId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }
}
