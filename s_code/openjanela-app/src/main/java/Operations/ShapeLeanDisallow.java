/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 * 
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Operations;


import java.math.BigDecimal;

import util.UOMConvert;
import Presentation.ItemFrame;


/*
 * Call function when Mullion or coupler is clicked into
 * opening.
 */
public class ShapeLeanDisallow
{
	
	public int lean = 0;
	
	public int lean2 = 0;
	
	public int lean3 = 0;
	
	public int lean4 = 0;
	
	public boolean doShapeDialog = true;
	
	public double dimA1 = 0;
	
	public double dimA2 = 0;
	
	public double dimA3 = 0;
	
	public double dimA4 = 0;
	
	public double dimA5 = 0;
	
	public double dimA0 = 0;
	
	public double dimB1 = 0;
	
	public double dimB2 = 0;
	
	public double dimB3 = 0;
	
	public double dimB4 = 0;
	
	public double dimB5 = 0;
	
	public double dimB0 = 0;
	
	public double dimC1 = 0;
	
	public double dimC2 = 0;
	
	public double dimC3 = 0;
	
	public double dimC4 = 0;
	
	public double dimC5 = 0;
	
	public double dimC0 = 0;
	
	public double dimD1 = 0;
	
	public double dimD2 = 0;
	
	public double dimD3 = 0;
	
	public double dimD4 = 0;
	
	public double dimD5 = 0;
	
	public double dimD0 = 0;
	
	public int myShape = 0;
	
	public double deltaA1 = 0;
	
	public double deltaD1 = 0;
	
	public double deltaC2 = 0;
	
	public double w = 0;
	
	public double h = 0;
	
	public int numSides = 0;
	
	public BigDecimal scale = new BigDecimal(0);
	
	public double originalW = 0;
	
	public double originalH = 0;
	
	public double myMinLeg = 0;
	
	public int resetWorH = 0;// 0 nothing, 1 w 2 h 3 both
	
	public ShapeLeanDisallow(
				final int myShape,
				final double ww,
				final double hh,
				final double minleg,
				final int uom,
				final ItemFrame myFrame2)
	{
		
		if (myFrame2.myTopPanel.metric.isSelected())
		{
			scale = myFrame2.scale.multiply(new BigDecimal(100));
			w = ww/100;
			h = hh/100;
		}
		else
		{
			scale = myFrame2.scale;
			w = ww;
			h = hh;
		}
		
		myMinLeg = minleg * scale.doubleValue();
		this.myShape = myShape;
		
		
		switch (this.myShape)
		{
		case 1:
			lean = 0;
			lean2 = 0;
			lean3 = 0;
			lean4 = 0;
			doShapeDialog = false;
			numSides = 4;
			break;
		case 10:
			lean = 0;
			lean2 = 0;
			lean3 = 0;
			lean4 = 0;
			doShapeDialog = false;
			numSides = 0;
			break;
		case 90:
			lean = 0;
			lean2 = 2;
			lean3 = 3;
			lean4 = 1;
			doShapeDialog = false;
			numSides = 5;
			break;
		case 91:
			lean = 0;
			lean2 = 2;
			lean3 = 3;
			lean4 = 1;
			doShapeDialog = false;
			break;
		case 92:
			lean = 0;
			lean2 = 2;
			lean3 = 3;
			lean4 = 1;
			doShapeDialog = false;
			break;
		case 93:
			lean = 0;
			lean2 = 3;
			lean3 = 3;
			lean4 = 3;
			doShapeDialog = false;
			break;
		case 100:
			lean = 0;
			lean2 = 0;
			lean3 = 0;
			lean4 = 1;
			doShapeDialog = true;
			dimD1 = h * 0.75f;
			dimD2 = h * 0.25f;
			break;
		case 101:
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 0;
			doShapeDialog = true;
			dimB1 = h * 0.25f;
			dimB2 = h * 0.75f;
			break;
		case 102:
			lean = 2;
			lean2 = 0;
			lean3 = 0;
			lean4 = 0;
			doShapeDialog = true;
			dimA1 = w * 0.25f;
			dimA2 = w * 0.75f;
			break;
		case 103:
			lean = 1;
			lean2 = 0;
			lean3 = 0;
			lean4 = 0;
			doShapeDialog = true;
			dimA2 = w * 0.25f;
			dimA1 = w * 0.75f;
			break;
		case 104:
			lean = 0;
			lean2 = 1;
			lean3 = 0;
			lean4 = 0;
			doShapeDialog = true;
			dimB2 = h * 0.25f;
			dimB1 = h * 0.75f;
			break;
		case 105:
			lean = 0;
			lean2 = 0;
			lean3 = 0;
			lean4 = 2;
			doShapeDialog = true;
			dimD2 = h * 0.75f;
			dimD1 = h * 0.25f;
			break;
		case 106:
			lean = 0;
			lean2 = 0;
			lean3 = 2;
			lean4 = 0;
			doShapeDialog = true;
			dimC2 = w * 0.75f;
			dimC1 = w * 0.25f;
			break;
		case 107:
			lean = 0;
			lean2 = 0;
			lean3 = 1;
			lean4 = 0;
			doShapeDialog = true;
			dimC2 = w * 0.25f;
			dimC1 = w * 0.75f;
			break;
		case 108:
			lean = 1;
			lean2 = 0;
			lean3 = 1;
			lean4 = 0;
			doShapeDialog = true;
			dimC2 = w * 0.25f;
			dimC1 = w * 0.75f;
			dimA2 = w * 0.25f;
			dimA1 = w * 0.75f;
			break;
		case 109:
			lean = 2;
			lean2 = 0;
			lean3 = 2;
			lean4 = 0;
			doShapeDialog = true;
			dimC1 = w * 0.25f;
			dimC2 = w * 0.75f;
			dimA1 = w * 0.25f;
			dimA2 = w * 0.75f;
			break;
		case 110:
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 2;
			doShapeDialog = true;
			dimB1 = h * 0.25f;
			dimB2 = h * 0.75f;
			dimD2 = h * 0.75f;
			dimD1 = h * 0.25f;
			break;
		case 111:
			lean = 0;
			lean2 = 1;
			lean3 = 0;
			lean4 = 1;
			doShapeDialog = true;
			dimB1 = h * 0.75f;
			dimB2 = h * 0.25f;
			dimD2 = h * 0.25f;
			dimD1 = h * 0.75f;
			break;
		case 112:
			lean = 3;
			lean2 = 0;
			lean3 = 0;
			lean4 = 0;
			doShapeDialog = true;
			dimA0 = w * 0.3f;
			dimA2 = w * 0.3f;
			dimA1 = w * 0.4f;
			
			break;
		case 113:
			lean = 0;
			lean2 = 3;
			lean3 = 0;
			lean4 = 0;
			doShapeDialog = true;
			dimB1 = h * 0.4f;
			dimB2 = h * 0.3f;
			dimB0 = h * 0.3f;
			break;
		case 114:
			lean = 0;
			lean2 = 0;
			lean3 = 3;
			lean4 = 0;
			doShapeDialog = true;
			dimC1 = h * 0.4f;
			dimC2 = h * 0.3f;
			dimC0 = h * 0.3f;
			break;
		case 115:
			lean = 0;
			lean2 = 0;
			lean3 = 0;
			lean4 = 3;
			doShapeDialog = true;
			dimD1 = h * 0.4f;
			dimD2 = h * 0.3f;
			dimD0 = h * 0.3f;
			break;
		case 150:
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			doShapeDialog = true;
			dimA1 = w * 0.5f;
			dimA2 = w * 0.5f;
			dimD1 = h * 0.7f;
			dimD2 = h * 0.3f;
			dimB1 = h * 0.3f;
			dimB2 = h * 0.7f;
			break;
		case 154:
			lean = 2;
			lean2 = 0;
			lean3 = 0;
			lean4 = 1;
			doShapeDialog = true;
			dimA1 = w * 0.25f;
			dimA2 = w * 0.75f;
			dimD1 = h * 0.75f;
			dimD2 = h * 0.25f;
			break;
		case 155:
			lean = 1;
			lean2 = 2;
			lean3 = 0;
			lean4 = 0;
			doShapeDialog = true;
			dimA1 = w * 0.75f;
			dimA2 = w * 0.25f;
			dimB1 = h * 0.25f;
			dimB2 = h * 0.75f;
			break;
		case 160:
			lean = 3;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			doShapeDialog = true;
			dimA1 = w * 0.30f;
			dimA2 = w * 0.30f;
			dimA3 = w * 0.40f;
			dimB1 = h * 0.25f;
			dimB2 = h * 0.75f;
			dimD1 = h * 0.75f;
			dimD2 = h * 0.25f;
			break;
		case 165:
			lean = 3;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			doShapeDialog = false;
			dimA1 = w * 0.30f;
			dimA2 = w * 0.30f;
			dimA3 = w * 0.40f;
			dimB1 = h * 0.25f;
			dimB2 = h * 0.75f;
			dimD1 = h * 0.75f;
			dimD2 = h * 0.25f;
			break;
		case 200:
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			
			dimD2 = dimB1 = w / 2;
			dimD1 = dimB2 = h - dimD2;
			doShapeDialog = false;
			break;
		case 201:
			lean = 0;
			lean2 = 0;
			lean3 = 0;
			lean4 = 1;
			dimD2 = w;
			dimB1 = 0;
			doShapeDialog = false;
			if (w >= h)
			{
				this.myShape = 301;
				dimD2 = w * 0.25f;
				doShapeDialog = true;
			}
			
			break;
		case 202:
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 0;
			dimB1 = w;
			dimD2 = 0;
			doShapeDialog = false;
			if (w >= h)
			{
				this.myShape = 302;
				dimB1 = w * 0.25f;
				doShapeDialog = true;
			}
			
			break;
		case 203:
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			
			dimB1 = dimD2 = h;
			doShapeDialog = false;
			break;
		case 204:
			lean = 0;
			lean2 = 0;
			lean3 = 0;
			lean4 = 1;
			h = h;
			w = w;
			// h = h = w;
			dimD2 = h;
			dimB1 = 0;
			doShapeDialog = false;
			break;
		case 205:
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 0;
			h = h;
			w = w;
			// h = h = w;
			dimB1 = h;
			dimB2 = 0;
			doShapeDialog = false;
			break;
			
		case 300:
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			doShapeDialog = true;
			dimD1 = h * 0.80f;
			dimD2 = h * 0.20f;
			dimB1 = h * 0.20f;
			dimB2 = h * 0.80f;
			break;
		case 301:
			lean = 0;
			lean2 = 0;
			lean3 = 0;
			lean4 = 1;
			doShapeDialog = true;
			dimD1 = h * 0.80f;
			dimD2 = h * 0.20f;
			break;
		case 302:
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 0;
			doShapeDialog = true;
			dimB1 = h * 0.20f;
			dimB2 = h * 0.80f;
			break;
		case 303:
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			
			dimB1 = dimD2 = h;
			doShapeDialog = false;
			break;
		case 304:
			lean = 0;
			lean2 = 0;
			lean3 = 0;
			lean4 = 1;
			dimD2 = h;
			doShapeDialog = false;
			break;
		case 305:
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 0;
			dimB1 = h;
			doShapeDialog = false;
			break;
		case 400:
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			doShapeDialog = true;
			dimD1 = h * 0.80f;
			dimD2 = h * 0.20f;
			dimB1 = h * 0.20f;
			dimB2 = h * 0.80f;
			break;
		case 401:
			lean = 0;
			lean2 = 0;
			lean3 = 0;
			lean4 = 1;
			doShapeDialog = true;
			dimD1 = h * 0.80f;
			dimD2 = h * 0.20f;
			
			break;
		case 402:
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 0;
			doShapeDialog = true;
			dimB1 = h * 0.20f;
			dimB2 = h * 0.80f;
			break;
		case 450: // Ext Gothic
			
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			dimD2 = Math.sqrt(Math.pow(w, 2) - Math.pow((w / 2), 2));
			dimA1 = w / 2;
			dimA2 = dimA1;
			dimB1 = dimD2;
			dimB2 = dimD1 = h - dimD2;
			doShapeDialog = false;
			break;
		case 453: // Gothic
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			
			dimD2 =
						h =
						Math.sqrt(Math.pow(w, 2)
									- Math.pow((w / 2), 2));
			dimA1 = w / 2;
			dimA2 = dimA1;
			dimB1 = dimD2;
			dimB2 = dimD1 = 0;
			// h
			// - dimD2;
			
			doShapeDialog = false;
			break;
		case 454: // Ext Quinto Acuto
			
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			do
			{
				dimD2 =
							Math.sqrt(Math.pow(4 * w / 5, 2)
										- Math.pow((4 * w / 5 - w / 2), 2));
				dimA1 = w / 2;
				dimA2 = dimA1;
				dimB1 = dimD2;
				dimB2 = dimD1 = h - dimD2;
				if (dimD1 < myMinLeg / scale.doubleValue())
				{
					w = w - 1;
				}
			}
			while (dimD1 < myMinLeg / scale.doubleValue());
			
			doShapeDialog = false;
			break;
		case 455:// Quinto Acuto
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			do
			{
				dimD2 =
							Math.sqrt(Math.pow(4 * w / 5, 2)
										- Math.pow((4 * w / 5 - w / 2), 2));
				
				dimB2 = dimD1 = h - dimD2;
				
				h = dimD2;
				dimA1 = w / 2;
				dimA2 = dimA1;
				if (dimD1 < 0)
				{
					w = w - 1;
				}
			}
			while (dimD1 < 0);
			
			doShapeDialog = false;
			break;
		case 456:// Ext Mezzo Acuto
			
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			
			do
			{
				dimD2 =
							Math.sqrt(Math.pow(3.25 * w / 5, 2)
										- Math.pow(3.25 * w / 5 - w / 2, 2));
				
				dimB2 = dimD1 = h - dimD2;
				
				dimA1 = w / 2;
				dimA2 = dimA1;
				dimB1 = dimD2;
				if (dimD1 < myMinLeg / scale.doubleValue())
				{
					w = w - 1;
				}
			}
			while (dimD1 < myMinLeg / scale.doubleValue());
			
			doShapeDialog = false;
			break;
		case 457: // Mezzo Acuto
			
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			
			do
			{
				dimD2 =
							Math.sqrt(Math.pow(3.25 * w / 5, 2)
										- Math.pow(3.25 * w / 5 - w / 2, 2));
				
				dimB2 = dimD1 = h - dimD2;
				
				h = dimD2;
				dimA1 = w / 2;
				dimA2 = dimA1;
				
				if (dimD1 < 0)
				{
					w = w - 1;
				}
			}
			while (dimD1 < 0);
			
			doShapeDialog = false;
			break;
		case 458:// EXT recto Acuto
			
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			dimD1 = h;
			
			do
			{
				dimD2 =
							dimB1 =
							Math.sqrt(Math.pow(5 * w / 4, 2)
										- Math.pow(
													(5 * w / 4 - w / 2),
													2));
				
				dimA1 = dimA2 = w / 2;
				
				dimA1 = dimA2 = w / 2;
				
				dimD1 = dimB2 = h - dimD2;
				if (dimD1 < myMinLeg / scale.doubleValue())
				{
					w = w - 1;
				}
				
			}
			while (dimD1 < myMinLeg / scale.doubleValue());
			doShapeDialog = false;
			break;
		case 459: // recto Acuto
			
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			
			do
			{
				dimD2 =
							h =
							Math.sqrt(Math.pow(5 * w / 4, 2)
										- Math.pow(
													(5 * w / 4 - w / 2),
													2));
				
				dimD1 = dimB2 = h - dimD2;
				
				dimA1 = w / 2;
				dimA2 = dimA1;
				dimB1 = dimD2;
				
				if (dimD1 < 0)
				{
					w = w - 1;
				}
				
			}
			while (dimD1 < 0);
			
			doShapeDialog = false;
			break;
		case 460: // EXT doble Acuto
			
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			if (w >= h)
			{
				w = 8 * h / 10 - h;
			}
			
			do
			{
				
				dimD2 =
							Math.sqrt(Math.pow(2 * w, 2)
										- Math.pow((2 * w - w / 2), 2));
				dimD1 = h - dimD2;
				
				dimA1 = w / 2;
				dimA2 = dimA1;
				dimB1 = dimD2;
				dimD1 = dimB2 = h - dimB1;
				
				if (dimD1 < myMinLeg / scale.doubleValue())
				{
					w = w - 1;
				}
				
			}
			while (dimD1 < myMinLeg / scale.doubleValue());
			doShapeDialog = false;
			break;
		case 461:// doble acuto
			
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			if (w >= h)
			{
				w = 8 * h / 10 - h;
				
			}
			
			do
			{
				
				dimD2 =
							h =
							Math
							.sqrt(Math.pow(2 * w, 2)
										- Math
										.pow(
													(2 * w - w / 2),
													2));
				
				dimD1 = h - dimD2;
				
				dimA1 = w / 2;
				dimA2 = dimA1;
				dimB1 = dimD2;
				dimD1 = dimB2 = h - dimB1;
				
				if (dimD1 < 0)
				{
					w = w - 1;
				}
				
			}
			while (dimD1 < myMinLeg / scale.doubleValue());
			doShapeDialog = false;
			break;
		case 700:
			lean = 0;
			lean2 = 0;
			lean3 = 0;
			lean4 = 1;
			dimD2 = h;
			dimD1 = 0;
			dimD0 = 0;
			doShapeDialog = false;
			break;
		case 701:
			lean = 0;
			lean2 = 2;
			lean3 = 0;
			lean4 = 0;
			dimB1 = h;
			dimB2 = 0;
			dimB0 = 0;
			doShapeDialog = false;
			break;
		case 702:
			lean = 0;
			lean2 = 0;
			lean3 = 0;
			lean4 = 3;
			doShapeDialog = true;
			if (dimD2 == 0 || dimD0 + dimD2 != h)
			{
				dimD2 = h / 2;
			}
			dimD0 = Math.abs(h - dimD2);
			dimD1 = 0;
			
			break;
		case 703:
			lean = 0;
			lean2 = 3;
			lean3 = 0;
			lean4 = 0;
			doShapeDialog = true;
			if (dimB0 == 0 || dimB0 + dimB2 != h)
			{
				dimB0 = h / 2;
			}
			dimB2 = Math.abs(h - dimB0);
			dimB1 = 0;
			break;
		case 704:
			lean = 3;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
			doShapeDialog = true;
			dimA1 = w * 0.5f;
			dimA2 = w * 0.5f;
			dimD1 = 0;
			dimD2 = h;
			dimB1 = h;
			dimB2 = 0;
			break;
			
		case 705:
			lean = 0;
			lean2 = 0;
			lean3 = 0;
			lean4 = 2;
			doShapeDialog = false;
			dimD1 = h;
			dimD2 = 0;
			dimD0 = 0;
			break;
		case 706:
			lean = 0;
			lean2 = 1;
			lean3 = 0;
			lean4 = 0;
			doShapeDialog = false;
			dimB2 = h;
			dimB1 = 0;
			dimB0 = 0;
			break;
		case 800:
			lean = 0;
			lean2 = 0;
			lean3 = 0;
			lean4 = 0;
			
			dimA1 = dimC2 = dimA2 = dimC1 = w / 2;
			dimB1 = dimD2 = dimB2 = dimD1 = h / 2;
			doShapeDialog = false;
			break;
		case 801:
			
			lean = 0;
			lean2 = 0;
			lean3 = 0;
			lean4 = 0;
			
			dimA1 = dimC2 = dimA2 = dimC1 = w / 2;
			dimB1 = dimD2 = dimB2 = dimD1 = h / 2;
			
			doShapeDialog = false;
			break;
		case 802:
			
			lean = 0;
			lean2 = 0;
			lean3 = 0;
			lean4 = 0;
			// w = h;
			dimA1 = dimC2 = dimA2 = dimC1 = w / 2;
			dimB1 = dimD2 = dimB2 = dimD1 = h / 2;
			doShapeDialog = false;
			break;
		}
		
		final VerifyModifyDims verifyDims =
					new VerifyModifyDims(
								this.myShape,
								lean,
								lean2,
								lean3,
								lean4,
								dimA1,
								dimA2,
								dimA3,
								dimA0,
								dimB1,
								dimB2,
								dimB0,
								dimC1,
								dimC2,
								dimC0,
								dimD1,
								dimD2,
								dimD0,
								w,
								h,
								scale,
								false,
								minleg);
		
		verifyDims.verify4SidedShapeInput();
		
		this.myShape = verifyDims.myShape;
		resetWorH = verifyDims.resetWorH;
		
		lean = verifyDims.lean;
		lean2 = verifyDims.lean2;
		lean3 = verifyDims.lean3;
		lean4 = verifyDims.lean4;
		
		// if(uom==1) { myFrame2.getRoundedValueMI
		dimA1 = UOMConvert.getBigDecimalConversion(verifyDims.dimA1, scale, 2);
		dimA2 = UOMConvert.getBigDecimalConversion(verifyDims.dimA2, scale, 2);
		dimA3 = UOMConvert.getBigDecimalConversion(verifyDims.dimA3, scale, 2);
		dimA0 = UOMConvert.getBigDecimalConversion(verifyDims.dimA0, scale, 2);
		dimB1 = UOMConvert.getBigDecimalConversion(verifyDims.dimB1, scale, 2);
		dimB2 = UOMConvert.getBigDecimalConversion(verifyDims.dimB2, scale, 2);
		dimB0 = UOMConvert.getBigDecimalConversion(verifyDims.dimB0, scale, 2);
		dimC1 = UOMConvert.getBigDecimalConversion(verifyDims.dimC1, scale, 2);
		dimC2 = UOMConvert.getBigDecimalConversion(verifyDims.dimC2, scale, 2);
		dimC0 = UOMConvert.getBigDecimalConversion(verifyDims.dimC0, scale, 2);
		dimD1 = UOMConvert.getBigDecimalConversion(verifyDims.dimD1, scale, 2);
		dimD2 = UOMConvert.getBigDecimalConversion(verifyDims.dimD2, scale, 2);
		dimD0 = UOMConvert.getBigDecimalConversion(verifyDims.dimD0, scale, 2);
		

		double myNewW = verifyDims.myw / scale.doubleValue();
		double myNewH = verifyDims.myh / scale.doubleValue();
		
		final double sumA = dimA0 + dimA1 + dimA2 + dimA3;
		final double sumC = dimC0 + dimC1 + dimC2 + dimC3;
		final double sumB = dimB0 + dimB1 + dimB2 + dimB3;
		final double sumD = dimD0 + dimD1 + dimD2 + dimD3;
		
		 dimA0 = Math.round(dimA0);
		 dimA1 = Math.round(dimA1);
		 dimA2 = Math.round(dimA2);
		 dimA3 = Math.round(dimA3);
		
		 dimB0 = Math.round(dimB0);
		 dimB1 = Math.round(dimB1);
		 dimB2 = Math.round(dimB2);
		 dimB3 = Math.round(dimB3);
		
		 dimC0 = Math.round(dimC0);
		 dimC1 = Math.round(dimC1);
		 dimC2 = Math.round(dimC2);
		 dimC3 = Math.round(dimC3);

		 dimD0 = Math.round(dimD0);
		 dimD1 = Math.round(dimD1);
		 dimD2 = Math.round(dimD2);
		 dimD3 = Math.round(dimD3);
		
		final double sumAnet = dimA0 + dimA1 + dimA2 + dimA3;
		final double sumBnet = dimB0 + dimB1 + dimB2 + dimB3;
		final double sumCnet = dimC0 + dimC1 + dimC2 + dimC3;
		final double sumDnet = dimD0 + dimD1 + dimD2 + dimD3;
		
		if(sumA - sumAnet >0){
			dimA2 = dimA2 + (sumA - sumAnet);
		}
		if(sumB - sumBnet >0){
			dimB2 = dimB2 + (sumB - sumBnet);
		}
		if(sumC - sumCnet >0){
			dimC2 = dimC2 + (sumC - sumCnet);
		}
		if(sumD - sumDnet >0){
			dimD1 = dimD1 + (sumD - sumDnet);
		}
		
		
		if (Math.max(sumA, sumC) > 0)
		{
			myNewW = Math.max(sumA, sumC);
		}
		if (Math.max(sumB, sumD) > 0)
		{
			myNewH = Math.max(sumB, sumD);
		}
		
		w = myNewW;
		h = myNewH;
		
		// }
		// else if (uom>1) {
		//
		// dimA1 = myFrame2.roundDim(verifyDims.dimA1 / scale, 2,
		// myFrame2.impRound);
		// dimA2 = myFrame2.roundDim(verifyDims.dimA2 / scale, 2,
		// myFrame2.impRound);
		// dimA3 = myFrame2.roundDim(verifyDims.dimA3 / scale, 2,
		// myFrame2.impRound);
		// dimA0 = myFrame2.roundDim(verifyDims.dimA0 / scale, 2,
		// myFrame2.impRound);
		// dimB1 = myFrame2.roundDim(verifyDims.dimB1 / scale, 2,
		// myFrame2.impRound);
		// dimB2 = myFrame2.roundDim(verifyDims.dimB2 / scale, 2,
		// myFrame2.impRound);
		// dimB0 = myFrame2.roundDim(verifyDims.dimB0 / scale, 2,
		// myFrame2.impRound);
		// dimC1 = myFrame2.roundDim(verifyDims.dimC1 / scale, 2,
		// myFrame2.impRound);
		// dimC2 = myFrame2.roundDim(verifyDims.dimC2 / scale, 2,
		// myFrame2.impRound);
		// dimC0 = myFrame2.roundDim(verifyDims.dimC0 / scale, 2,
		// myFrame2.impRound);
		// dimD1 = myFrame2.roundDim(verifyDims.dimD1 / scale, 2,
		// myFrame2.impRound);
		// dimD2 = myFrame2.roundDim(verifyDims.dimD2 / scale, 2,
		// myFrame2.impRound);
		// dimD0 = myFrame2.roundDim(verifyDims.dimD0 / scale, 2,
		// myFrame2.impRound);
		//
		// double myNewW = myFrame2.roundDim(verifyDims.myw / scale,
		// 2, myFrame2.impRound);
		// double myNewH = myFrame2.roundDim(verifyDims.myh / scale,
		// 2, myFrame2.impRound);
		//
		// final double sumA = dimA0+dimA1+dimA2+dimA3;
		// final double sumC = dimC0+dimC1+dimC2+dimC3;
		// final double sumB = dimB0+dimB1+dimB2+dimB3;
		// final double sumD = dimD0+dimD1+dimD2+dimD3;
		// if(Math.max(sumA, sumC)>0) {
		// myNewW = Math.max(sumA, sumC);
		// }
		// if(Math.max(sumB, sumD)>0) {
		// myNewH = Math.max(sumB, sumD);
		// }
		//
		//
		// w = myNewW;
		// h = myNewH;
		// }
		
		// /////////////////////////////////
		
		// //////////////////////////////////
	}
	
}
