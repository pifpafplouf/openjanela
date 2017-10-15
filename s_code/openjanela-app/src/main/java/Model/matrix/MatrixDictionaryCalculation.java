package Model.matrix;

import java.math.BigDecimal;

/**
 * Copyright (c) 2009, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-27-12
 * Time: 11:53 PM
 */
public interface MatrixDictionaryCalculation {
	
	/**
	 * Return Opening Class ID
	 * 
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #1
	 */
	public BigDecimal returnOpeningClassID();
	
	/**
	 * Return Shape Object Identification ID
	 *
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #3
	 */

	public BigDecimal returnShapeID();
	
	
	/**
	 * Return Abbreviation name from valid ShapeObject
	 *
	 * @return String
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #7
	 */
	public BigDecimal returnSUFamiles();
	
	
	/**
	 * Return Abbreviation name from valid ShapeObject
	 *
	 * @return String
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #7
	 */
	public BigDecimal returnUserDefinedOpeningID();
	
	
	
	/**
	 * Return partner Identification ID
	 *
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #12
	 */
	public BigDecimal returnPartnerIdentificationID();
	
	/**
	 * Return partner group Identification ID
	 *
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #13
	 */
	public BigDecimal returnPartnerGroupID();
	
	/**
	 * Return design Identification ID
	 *
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #14
	 */
	public BigDecimal returnDesignID();
	
	/**
	 * Return standard product ID
	 *
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #15
	 */
	public BigDecimal returnStdProductID();
	
	/**
	 * Calculate width for different types of objects
	 *
	 * @param systemMeasurement, System Measurement from TypeMatrixHeader
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #22
	 */
	public BigDecimal calculateWidth(int systemMeasurement);
	
	/**
	 * Calculate Height for different types of objects
	 *
	 * @param systemMeasurement, System Measurement from TypeMatrixHeader
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #23
	 */
	public BigDecimal calculateHeight(int systemMeasurement);
	
	/**
	 * Calculate UI for different types of objects
	 *
	 * @param systemMeasurement, System Measurement from TypeMatrixHeader
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #24
	 */
	public BigDecimal calculateUI(int systemMeasurement);
	
	/**
	 * Calculate area for different types of objects
	 *
	 * @param systemMeasurement, System Measurement from TypeMatrixHeader
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #25
	 */
	public BigDecimal calculateArea(int systemMeasurement);
	
	
	/**
	 * Return number of radii
	 *
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #30
	 */
	public BigDecimal returnNumberRadii();
	
	/**
	 * Return product type
	 *
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #31
	 */
	public BigDecimal returnProductType();
	
	/**
	 * Calculate length for different types of objects
	 *
	 * @param systemMeasurement, System Measurement from TypeMatrixHeader
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #32
	 */
	public BigDecimal calculateLength(int systemMeasurement);
	
	/**
	 * Return Quantity objects
	 *
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #34
	 */
	public BigDecimal returnQty();
	
	/**
	 * Calculate volume for different types of objects
	 *
	 * @param systemMeasurement, System Measurement from TypeMatrixHeader
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #35
	 */
	public BigDecimal calculateVolume(int systemMeasurement);
	
	/**
	 * Return stock code
	 *
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #36
	 */
	public BigDecimal returnStockCode();
	
	BigDecimal returnGridType();
	
	BigDecimal returnGridID();
	
	BigDecimal returnNumberGridsW();
	
	BigDecimal returnNumberGridsH();
	
	BigDecimal returnNumberSpokes();
	
	BigDecimal returnOptionAndAnswer(int optionid, int uom);
	
	
}
