package openjanela.model.entities.partner;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-22-12
 * Time: 08:06 PM
 */
@Entity
@Table(name = "matrix_header")
@Cacheable
public class MatrixHeader implements Serializable {
	
	/**
	 * PROPERTY NAME: Matrix Identification Key
	 */
	private Integer id;
	/**
	 * PROPERTY NAME: Description
	 */
	private String description;
	/**
	 * PROPERTY NAME: Matrix type Identification
	 */
	private Integer matrixTypeId;
	/**
	 * PROPERTY NAME: Row type Identification Key
	 */
	private Integer rowTypeId;
	/**
	 * PROPERTY NAME: Affected Option
	 */
	private Integer affectedOption;
	/**
	 * PROPERTY NAME: Row option Identification
	 */
	private Integer rowOptionId;
	/**
	 * PROPERTY NAME: Row start
	 */
	private Double rowStart;
	/**
	 * PROPERTY NAME: Row end
	 */
	private Double rowEnd;
	/**
	 * PROPERTY NAME: Row step
	 */
	private Double rowStep;
	/**
	 * PROPERTY NAME: Number rows
	 */
	private Integer numberRows;
	/**
	 * PROPERTY NAME: Column type Identification
	 */
	private Integer columnTypeId;
	/**
	 * PROPERTY NAME: Column option Identification
	 */
	private Integer ColumnOptionId;
	/**
	 * PROPERTY NAME: Column start
	 */
	private Double columnStart;
	/**
	 * PROPERTY NAME: Column end
	 */
	private Double columnEnd;
	/**
	 * PROPERTY NAME: Column step
	 */
	private Double columnStep;
	/**
	 * PROPERTY NAME: Number columns
	 */
	private Integer numberColumns;
	/**
	 * PROPERTY NAME: Deleted
	 */
	private Boolean deleted;
	/**
	 * PROPERTY NAME: System unit of metric Identification
	 */
	private Integer systemUOMId;
	/**
	 * PROPERTY NAME: Sub matrix
	 */
	private Boolean subMatrix;
	/**
	 * PROPERTY NAME: Main matrix Identification
	 */
	private Integer mainMatrixId;
	/**
	 * PROPERTY NAME: Math operator Identification
	 */
	private Integer mathOperatorId;
	/**
	 * PROPERTY NAME: Operator value
	 */
	private BigDecimal operatorValue;
	/**
	 * PROPERTY NAME: Series Identification Key
	 */
	private Integer seriesId;
	/**
	 * PROPERTY NAME: Measure
	 */
	private Integer measure;

    public MatrixHeader() {
    }

    public MatrixHeader(Integer id, String description, Integer matrixTypeId, Integer rowTypeId, Integer affectedOption,
                        Integer rowOptionId, Double rowStart, Double rowEnd, Double rowStep, Integer numberRows,
                        Integer columnTypeId, Integer columnOptionId, Double columnStart, Double columnEnd, Double columnStep,
                        Integer numberColumns, Boolean deleted, Integer systemUOMId, Boolean subMatrix, Integer mainMatrixId,
                        Integer mathOperatorId, BigDecimal operatorValue, Integer seriesId, Integer measure) {

        this.id = id;
        this.description = description;
        this.matrixTypeId = matrixTypeId;
        this.rowTypeId = rowTypeId;
        this.affectedOption = affectedOption;
        this.rowOptionId = rowOptionId;
        this.rowStart = rowStart;
        this.rowEnd = rowEnd;
        this.rowStep = rowStep;
        this.numberRows = numberRows;
        this.columnTypeId = columnTypeId;
        this.ColumnOptionId = columnOptionId;
        this.columnStart = columnStart;
        this.columnEnd = columnEnd;
        this.columnStep = columnStep;
        this.numberColumns = numberColumns;
        this.deleted = deleted;
        this.systemUOMId = systemUOMId;
        this.subMatrix = subMatrix;
        this.mainMatrixId = mainMatrixId;
        this.mathOperatorId = mathOperatorId;
        this.operatorValue = operatorValue;
        this.seriesId = seriesId;
        this.measure = measure;
    }

    // ==================================<GETTTER AND SETTERS>=================================================
	
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
	
	@Column(name = "matrix_type_id")
	public Integer getMatrixTypeId() {
		return matrixTypeId;
	}
	
	public void setMatrixTypeId(Integer matrixTypeId) {
		this.matrixTypeId = matrixTypeId;
	}
	
	@Column(name = "row_type_id")
	public Integer getRowTypeId() {
		return rowTypeId;
	}
	
	public void setRowTypeId(Integer rowTypeId) {
		this.rowTypeId = rowTypeId;
	}
	
	@Column(name = "affected_option")
	public Integer getAffectedOption() {
		return affectedOption;
	}
	
	public void setAffectedOption(Integer affectedOption) {
		this.affectedOption = affectedOption;
	}
	
	@Column(name = "row_option_id")
	public Integer getRowOptionId() {
		return rowOptionId;
	}
	
	public void setRowOptionId(Integer rowOptionId) {
		this.rowOptionId = rowOptionId;
	}
	
	@Column(name = "row_start")
	public Double getRowStart() {
		return rowStart;
	}
	
	public void setRowStart(Double rowStart) {
		this.rowStart = rowStart;
	}
	
	@Column(name = "row_end")
	public Double getRowEnd() {
		return rowEnd;
	}
	
	public void setRowEnd(Double rowEnd) {
		this.rowEnd = rowEnd;
	}
	
	@Column(name = "row_step")
	public Double getRowStep() {
		return rowStep;
	}
	
	public void setRowStep(Double rowStep) {
		this.rowStep = rowStep;
	}
	
	@Column(name = "number_rows")
	public Integer getNumberRows() {
		return numberRows;
	}
	
	public void setNumberRows(Integer numberRows) {
		this.numberRows = numberRows;
	}
	
	@Column(name = "column_type_id")
	public Integer getColumnTypeId() {
		return columnTypeId;
	}
	
	public void setColumnTypeId(Integer columnTypeId) {
		this.columnTypeId = columnTypeId;
	}
	
	@Column(name = "column_option_id")
	public Integer getColumnOptionId() {
		return ColumnOptionId;
	}
	
	public void setColumnOptionId(Integer columnOptionId) {
		ColumnOptionId = columnOptionId;
	}
	
	@Column(name = "column_start")
	public Double getColumnStart() {
		return columnStart;
	}
	
	public void setColumnStart(Double columnStart) {
		this.columnStart = columnStart;
	}
	
	@Column(name = "column_end")
	public Double getColumnEnd() {
		return columnEnd;
	}
	
	public void setColumnEnd(Double columnEnd) {
		this.columnEnd = columnEnd;
	}
	
	@Column(name = "column_step")
	public Double getColumnStep() {
		return columnStep;
	}
	
	public void setColumnStep(Double columnStep) {
		this.columnStep = columnStep;
	}
	
	@Column(name = "number_columns")
	public Integer getNumberColumns() {
		return numberColumns;
	}
	
	public void setNumberColumns(Integer numberColumns) {
		this.numberColumns = numberColumns;
	}
	
	@Column(name = "deleted")
	public Boolean getDeleted() {
		return deleted;
	}
	
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	@Column(name = "system_uom_id")
	public Integer getSystemUOMId() {
		return systemUOMId;
	}
	
	public void setSystemUOMId(Integer systemUOMId) {
		this.systemUOMId = systemUOMId;
	}
	
	@Column(name = "sub_matrix")
	public Boolean getSubMatrix() {
		return subMatrix;
	}
	
	public void setSubMatrix(Boolean subMatrix) {
		this.subMatrix = subMatrix;
	}
	
	@Column(name = "main_matrix_id")
	public Integer getMainMatrixId() {
		return mainMatrixId;
	}
	
	public void setMainMatrixId(Integer mainMatrixId) {
		this.mainMatrixId = mainMatrixId;
	}
	
	@Column(name = "math_operator_id")
	public Integer getMathOperatorId() {
		return mathOperatorId;
	}
	
	public void setMathOperatorId(Integer mathOperatorId) {
		this.mathOperatorId = mathOperatorId;
	}
	
	@Column(name = "operator_value")
	public BigDecimal getOperatorValue()
	{
		return operatorValue;
	}
	
	public void setOperatorValue(BigDecimal operatorValue)
	{
		this.operatorValue = operatorValue;
	}
	
	@Column(name = "series_id", nullable = false)
	public Integer getSeriesId() {
		return seriesId;
	}
	
	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}
	
	@Column(name = "measure", nullable = false)
	public Integer getMeasure() {
		return measure;
	}
	
	public void setMeasure(Integer measure) {
		this.measure = measure;
	}
	
	@Override
	public String toString() {
		return this.description;
	}
}
