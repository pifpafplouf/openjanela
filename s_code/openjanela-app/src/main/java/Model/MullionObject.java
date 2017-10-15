/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani. 
 *  All rights reserved.
 *
 *  Contributors:  
 *  Sherif El Dibani
 ******************************************************************************/
package Model;


import Model.ProfileParts.Profiles;
import Presentation.ItemFrame;


public class MullionObject extends Profiles implements Cloneable {
	
	
	// ////////////////////////////////////////////////////
	
	// //////////////////////////////////////
	public MullionObject() { // 1=V
		
	}
	
	
	public MullionObject(
				final BkgrdOpeningObject parent,
				final int posStart,
				final int posEnd,
				final int VH,
				final double centerXs,
				final double centerXe,
				final double centerYs,
				final double centerYe,
				final double length,
				final ItemFrame myframe) { // 1=V
		
		
		myParent = parent;
		myFrame2 = myframe;
		myJobItem = myFrame2.jobItem;
		MullionObject.this.myFrame2 = myFrame2;
		MullionObject.this.myJobItem =
					myJobItem;
		((Profiles) this).myFrame2 = myFrame2;
		scale = myFrame2.scale;
		this.centerXs = centerXs;
		this.centerXe = centerXe;
		this.centerYs = centerYs;
		this.centerYe = centerYe;
		
		
		orientation = VH;
		startPos = posStart;
		endPos = posEnd;
		this.length = length;
		rID = myParent.rID;
		levelID = 4;
		this.verticalCouplerStraight();
		
	}
	
	
	
	

}
