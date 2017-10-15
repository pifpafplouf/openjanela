package openjanela.model.entities.design;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 03-06-12
 * Time: 11:44 AM
 * This class represents the ID complex type for ShapeObject
 */
@Embeddable
public class ShapeObjectID implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "N_ID", nullable = false)
    private Integer id;
    @Column(name = "N_JOB_ID", nullable = false)
    private int jobId;
    @Column(name = "C_ITEM_ID", nullable = false)
    private String itemId;
    @Column(name = "N_LEVEL_ID", nullable = false)
    private int levelId;
    @Column(name = "N_SEQUENCE_ID", nullable = false)
    private int sequenceId;
    @Column(name = "N_ASSEMBLY_LEVEL_ID", nullable = false)
    private int assemblyLevelId;

    /**
     * Default Constructor
     */
    public ShapeObjectID() {
        this.id = BigDecimal.ZERO.intValue();
        this.jobId = BigDecimal.ZERO.intValue();
        this.itemId = "";
        this.levelId = BigDecimal.ZERO.intValue();
        this.sequenceId = BigDecimal.ZERO.intValue();
        this.assemblyLevelId = BigDecimal.ZERO.intValue();
    }

    /**
     * Constructor with parameters
     *
     * @param jobId,           Job item order
     * @param levelId,         Level construction
     * @param sequenceId,      Sequence construction
     * @param assemblyLevelId, Assembly construction
     */
    public ShapeObjectID(int jobId, int levelId, int sequenceId, int assemblyLevelId) {
        this.jobId = jobId;
        this.levelId = levelId;
        this.itemId = String.valueOf(jobId);
        this.sequenceId = sequenceId;
        this.assemblyLevelId = assemblyLevelId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public int getAssemblyLevelId() {
        return assemblyLevelId;
    }

    public void setAssemblyLevelId(int assemblyLevelId) {
        this.assemblyLevelId = assemblyLevelId;
    }
}
