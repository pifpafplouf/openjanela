/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 * 
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Operations;


import Model.ShapeObject;


/*
 * Call function when Mullion or coupler is clicked into
 * opening.
 */
public class ShapeLeanToLocal
	{

	public int lean = 0;

	public int lean2 = 0;

	public int lean3 = 0;

	public int lean4 = 0;

	int myShape = 1;

	ShapeObject myParent;

	public ShapeLeanToLocal(final ShapeObject parent)
		{

		this.myParent = parent;
		this.lean = this.myParent.lean;
		this.lean2 = this.myParent.lean2;
		this.lean3 = this.myParent.lean3;
		this.lean4 = this.myParent.lean4;
		this.myShape = this.myParent.shapeID;
		if (this.myShape == 450
				|| this.myShape >= 453 && this.myShape <= 461)
			{
			this.myShape = 450;
			}
		switch (this.myShape)
			{
			case 1:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 10:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 90:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 3;
			this.myParent.lean4 = 1;
			break;
			case 91:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 3;
			this.myParent.lean4 = 1;
			break;
			case 92:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 3;
			this.myParent.lean4 = 1;
			break;
			case 93:
			this.myParent.lean = 0;
			this.myParent.lean2 = 3;
			this.myParent.lean3 = 3;
			this.myParent.lean4 = 3;
			break;
			case 100:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 101:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 102:
			this.myParent.lean = 2;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 103:
			this.myParent.lean = 1;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 104:
			this.myParent.lean = 0;
			this.myParent.lean2 = 1;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 105:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 2;
			break;
			case 106:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 2;
			this.myParent.lean4 = 0;
			break;
			case 107:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 1;
			this.myParent.lean4 = 0;
			break;
			case 108:
			this.myParent.lean = 1;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 1;
			this.myParent.lean4 = 0;
			break;
			case 109:
			this.myParent.lean = 2;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 2;
			this.myParent.lean4 = 0;
			break;
			case 110:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 2;
			break;
			case 111:
			this.myParent.lean = 0;
			this.myParent.lean2 = 1;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 112:
			this.myParent.lean = 3;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 113:
			this.myParent.lean = 0;
			this.myParent.lean2 = 3;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 114:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 3;
			this.myParent.lean4 = 0;
			break;
			case 115:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 3;
			break;
			case 150:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 154:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 155:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 160:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 165:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 200:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 201:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 202:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 203:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 204:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 205:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;

			case 300:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 301:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 302:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 303:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 304:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 305:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 400:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 401:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 402:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 450:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 451:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 452:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 453:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 454:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 455:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 456:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 457:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 458:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 459:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 460:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 461:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 700:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 1;
			break;
			case 701:
			this.myParent.lean = 0;
			this.myParent.lean2 = 2;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 702:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 3;
			break;
			case 703:
			this.myParent.lean = 0;
			this.myParent.lean2 = 3;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 704:
			this.myParent.lean = 3;
			this.myParent.lean2 = 1;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 2;
			break;
			case 705:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 2;
			break;
			case 706:
			this.myParent.lean = 0;
			this.myParent.lean2 = 1;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 800:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 801:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			case 802:
			this.myParent.lean = 0;
			this.myParent.lean2 = 0;
			this.myParent.lean3 = 0;
			this.myParent.lean4 = 0;
			break;
			}

		}

	}
