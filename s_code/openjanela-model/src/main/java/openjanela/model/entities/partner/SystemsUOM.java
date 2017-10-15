package openjanela.model.entities.partner;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 10-11-12
 * Time: 09:33 AM
 */
public enum SystemsUOM {
	
	Unit(1), Lenght(2), Area(3), FaceIn(4), FaceOut(5), Perimeter(6), Weight(7), Vol_Dry(8), Vol_Liq(9), Time(10), Angles(11);
	
	public int value;
	
	SystemsUOM(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
