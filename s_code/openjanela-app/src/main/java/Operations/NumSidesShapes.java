/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 * 
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Operations;


import Model.ShapeObject;


public class NumSidesShapes
	{

	public ShapeObject myTestShapes;

	public int noSidesTop = 0;

	public int noSidesBot = 0;

	public int noSidesLeft = 0;

	public int noSidesRight = 0;

	public int noSides = 0;

	public NumSidesShapes(int shapeId)
		{

		int myShape = shapeId;
		if (shapeId == 333)
			{
			shapeId = 301;
			}
		else if (shapeId == 3333)
			{
			shapeId = 302;
			}
		if (shapeId == 1 || shapeId <= 9)
			{
			myShape = 1;
			}
		else if (shapeId >= 100 && shapeId <= 149)
			{
			myShape = 1;
			}
		else if (shapeId == 451)
			{
			myShape = 401;
			}
		else if (shapeId == 452)
			{
			myShape = 402;
			}
		else
			{
			myShape = shapeId;
			}

		switch (myShape)
			{
			case 1: // rectangle// 4 sided
			this.noSides = 4;

			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 10: // rectangle// 4 sided
			this.noSides = 0;

			this.noSidesTop = 0;
			this.noSidesBot = 0;
			this.noSidesLeft = 0;
			this.noSidesRight = 0;

			break;
			case 90: // Pentagon
			this.noSides = 5;

			this.noSidesTop = 2;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 91: // hex
			this.noSides = 6;

			this.noSidesTop = 3;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 92: // Hex acute
			this.noSides = 6;

			this.noSidesTop = 3;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 93: // rectangle// 4 sided
			this.noSides = 8;

			this.noSidesTop = 3;
			this.noSidesBot = 3;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 150: // rectangle// 4 sided
			this.noSides = 5;

			this.noSidesTop = 2;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 154: // rectangle// 4 sided
			this.noSides = 5;

			this.noSidesTop = 2;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 155: // rectangle// 4 sided
			this.noSides = 5;

			this.noSidesTop = 2;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 160: // rectangle// 4 sided
			this.noSides = 6;

			this.noSidesTop = 3;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 165: // rectangle// 4 sided
			this.noSides = 6;

			this.noSidesTop = 3;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 200: // extended HR
			this.noSides = 4;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 201: // extended HR
			this.noSides = 4;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 202: // extended HR
			this.noSides = 4;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 203: // HR
			this.noSides = 2;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 0;
			this.noSidesRight = 0;

			break;
			case 204: // qRl
			this.noSides = 2;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 0;
			this.noSidesRight = 1;

			break;
			case 205: // qRr
			this.noSides = 3;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 0;

			break;
			case 300: // extended Arc
			this.noSides = 4;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 301: // extended Arc End 90
			this.noSides = 4;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 302: // extended Arc start 90
			this.noSides = 4;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;

			case 303: // HR/Arc
			this.noSides = 2;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 0;
			this.noSidesRight = 0;

			break;
			case 304: // qRl
			this.noSides = 3;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 0;
			this.noSidesRight = 1;

			break;
			case 305: // qRr
			this.noSides = 3;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 0;

			break;
			case 400: // Extended Ellipse
			this.noSides = 4;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 401: // Extended Ellipse
			this.noSides = 4;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 402: // Extended Ellipse
			this.noSides = 4;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;
			case 403: // Extended Ellipse
			this.noSides = 4;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 1;

			break;

			case 450: // extended Lancet/Gothic
			this.extendedGothic();
			break;
			case 451: // extended Lancet/Gothic
			this.extendedGothic();
			break;
			case 452: // extended Lancet/Gothic
			this.extendedGothic();
			break;
			case 453: // extended Lancet/Gothic
			this.gothic();
			break;
			case 454: // extended Lancet/Gothic
			this.extendedGothic();
			break;
			case 455: // extended Lancet/Gothic
			this.gothic();
			break;
			case 456: // extended Lancet/Gothic
			this.extendedGothic();
			break;
			case 457: // extended Lancet/Gothic
			this.gothic();
			break;
			case 458: // extended Lancet/Gothic
			this.extendedGothic();
			break;
			case 459: // extended Lancet/Gothic
			this.gothic();
			break;
			case 460: // extended Lancet/Gothic
			this.extendedGothic();
			break;
			case 461: // extended Lancet/Gothic
			this.gothic();
			break;

			case 700: // right Triangle - Right
			this.noSides = 3;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 0;
			this.noSidesRight = 1;

			break;
			case 701: // right Triangle - left
			this.noSides = 3;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 0;

			break;
			case 702: // triangle iso R
			this.noSides = 3;

			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 0;
			this.noSidesRight = 1;

			break;
			case 703: // triangle left
			this.noSides = 3;

			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 0;

			break;
			case 704: // triangle iso top
			this.noSides = 3;

			this.noSidesTop = 2;
			this.noSidesBot = 1;
			this.noSidesLeft = 0;
			this.noSidesRight = 0;

			break;
			case 705: // Right Triangle LeanTop
// (L)
			this.noSides = 3;

			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 0;
			this.noSidesRight = 1;

			break;
			case 706: // Right triangle Lean Top
// R
			this.noSides = 3;

			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 1;
			this.noSidesRight = 0;

			break;
			case 800: // HR
			this.noSides = 2;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 0;
			this.noSidesRight = 0;

			break;
			case 801: // Ellipse
			this.noSides = 2;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 0;
			this.noSidesRight = 0;

			break;
			case 802: // Ellipse V
			this.noSides = 2;
			this.noSidesTop = 1;
			this.noSidesBot = 1;
			this.noSidesLeft = 0;
			this.noSidesRight = 0;

			break;
			}// Switch
		}// analyseShapes

	private void extendedGothic()
		{

		this.noSides = 5;
		this.noSidesTop = 2;
		this.noSidesBot = 1;
		this.noSidesLeft = 1;
		this.noSidesRight = 1;

		}

	private void gothic()
		{

		this.noSides = 3;
		this.noSidesTop = 2;
		this.noSidesBot = 1;
		this.noSidesLeft = 0;
		this.noSidesRight = 0;

		}

	}
