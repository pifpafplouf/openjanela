package openjanela.model.entities.parts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10/10/13
 *          Time: 10:28 AM
 */
@Entity
@Table(name = "parts_label_position")
public class PartsLabelPos implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "math_operator_id", nullable = false)
    private int mathOperatorId;

    @Column(name = "report_id", nullable = false)
    private int reportId;

    public PartsLabelPos() {
    }

    public PartsLabelPos(Integer id, String name, String description, int mathOperatorId, int reportId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.mathOperatorId = mathOperatorId;
        this.reportId = reportId;
    }

    //*****************************************<Getters & Setters>******************************************************

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMathOperatorId() {
        return mathOperatorId;
    }

    public void setMathOperatorId(int mathOperatorId) {
        this.mathOperatorId = mathOperatorId;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }
}
