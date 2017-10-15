package Model.matrix;

import java.math.BigDecimal;

/**
 * Copyright (c) 2009, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-28-12
 * Time: 08:27 AM
 */
public interface MatrixDictionaryDLO {
	
	/**
	 * Return GridType for DLO
	 *
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #11
	 */
	public BigDecimal returnGridType();
	
	/**
	 * Return number of grids Horizontal
	 *
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #26
	 */
	public BigDecimal returnNumberGridsW();
	
	/**
	 * Return number of grids Vertical
	 *
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #27
	 */
	public BigDecimal returnNumberGridsH();
	
	/**
	 * Return number of spokes
	 *
	 * @return BigDecimal
	 * @see openjanela.model.entities.partner.TypeMatrixDiccionary #29
	 */
	public BigDecimal returnNumberSpokes();
	
	public BigDecimal returnGridID();

}
