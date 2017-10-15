package Model;

import java.io.Serializable;

/**
 * Represents Level & Sequence for ShapeObject
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 05-28-13
 *          Time: 01:32 PM
 */
public class LevelSequence implements Serializable {

    Integer levelID;
    Integer sequenceID;

    public LevelSequence(Integer levelID, Integer sequenceID) {
        this.levelID = levelID;
        this.sequenceID = sequenceID;
    }

}
