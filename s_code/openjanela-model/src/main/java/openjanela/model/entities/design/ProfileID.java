package openjanela.model.entities.design;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 03-13-12
 * Time: 11:34 AM
 */
@Embeddable
public class ProfileID implements Serializable {

    /**
     * PROPERTY NAME: Generated Identification number
     */
    private Integer id;
    /**
     * PROPERTY NAME: Job Item order
     */
    private int jobId;
    /**
     * PROPERTY NAME: Item identification register
     */
    private String itemId;
    /**
     * PROPERTY NAME: Level construction
     */
    private int levelId;
    /**
     * PROPERTY NAME: Sequence construction
     */
    private int sequenceId;
    /**
     * PROPERTY NAME: Assembly construction
     */
    private int assemblyLevel;


    /**
     * Default constructor
     */
    public ProfileID() {
        this.id = BigDecimal.ZERO.intValue();
        this.jobId = BigDecimal.ZERO.intValue();
        this.itemId = "";
        this.levelId = BigDecimal.ZERO.intValue();
        this.sequenceId = BigDecimal.ZERO.intValue();
        this.assemblyLevel = BigDecimal.ZERO.intValue();
    }

    /**
     * Constructor
     *
     * @param jobId, Job Item order
     * @param itemId, Item identification register
     * @param levelId, Level construction
     * @param sequenceId, Sequence construction
     */
    public ProfileID(int jobId, String itemId, int levelId, int sequenceId, int assembly_levelID) {
        this.jobId = jobId;
        this.itemId = itemId;
        this.levelId = levelId;
        this.sequenceId = sequenceId;
        this.assemblyLevel = assembly_levelID;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "N_ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "N_JOB_ID", nullable = false)
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Column(name = "C_ITEM_ID", nullable = false)
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Column(name = "N_LEVEL_ID", nullable = false)
    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    @Column(name = "N_SEQUENCE_ID", nullable = false)
    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    @Column(name = "N_ASSEMBLY_LEVEL_ID", nullable = false)
    public int getAssemblyLevel() {
        return assemblyLevel;
    }

    public void setAssemblyLevel(int assemblyLevel) {
        this.assemblyLevel = assemblyLevel;
    }
}
