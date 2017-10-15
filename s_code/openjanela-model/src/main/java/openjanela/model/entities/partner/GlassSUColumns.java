package openjanela.model.entities.partner;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 12-01-12
 * Time: 06:01 PM
 */
public enum GlassSUColumns {
	
	STOCKCODE("stockCode"),
	DESCRIPTION("description"),
	WIDTHM("widthM"),
	WIDTHI("widthI"),
	HEIGHTM("heightM"),
	HEIGHTI("heightI"),
	COST("cost"),
	PRICE("price"),
	NONE("none");
	
	private String value;
	
	GlassSUColumns(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	/**
	 * Getting column name value configuration
	 *
	 * @param value, String
	 * @return String
	 */
	public String getColumnName(String value) {
		if (value.equals(STOCKCODE.getValue())) {
			return "Stock Code";
		} else if (value.equals(DESCRIPTION.getValue())) {
			return "Description";
		} else if (value.equals(WIDTHM.getValue()) || value.equals(WIDTHI.getValue())) {
			return "Width";
		} else if (value.equals(HEIGHTM.getValue()) || value.equals(HEIGHTI.getValue())) {
			return "Height";
		} else if (value.equals(COST.getValue()) || value.equals(COST.getValue())) {
			return "Cost";
		} else if (value.equals(PRICE.getValue()) || value.equals(PRICE.getValue())) {
			return "Price";
		} else {
			return "None";
		}
	}
}
