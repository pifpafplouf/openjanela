/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/

package Operations;

import java.math.BigDecimal;

import Model.ShapeObject;
import Presentation.ItemFrame;

public class AnalyseShape
{
	
	public ShapeObject myFrame;
	
	ItemFrame myFrame2;
	
	VerifyModifyDims verifyDims;
	
	public BigDecimal scale = new BigDecimal(0);
	
	public AnalyseShape(ShapeObject levelShape, boolean shapeChange, ItemFrame myframe, BigDecimal myscale) {
	
		myFrame = levelShape;
		myFrame2 = myframe;
		scale = myscale;
		
		// if(!shapeChange) {
		verifyDims = new VerifyModifyDims(myFrame.shapeID, myFrame.lean, myFrame.lean2, myFrame.lean3, myFrame.lean4,
					myFrame.dimA1, myFrame.dimA2, myFrame.dimA3, myFrame.dimA0, myFrame.dimB1, myFrame.dimB2, myFrame.dimB0,
					myFrame.dimC1, myFrame.dimC2, myFrame.dimC0, myFrame.dimD1, myFrame.dimD2, myFrame.dimD0,
					myFrame.widthPix, myFrame.heightPix, scale, true, myFrame.minLeg);
		
		verifyDims.verify4SidedShapeInput();
		
		this.setLevelShapeAfterVerify();
		
		this.analyseShape();
		
	}
	
	private void setLevelShapeAfterVerify()
	{
	
		myFrame.shapeID = verifyDims.myShape;
		myFrame.lean = verifyDims.lean;
		myFrame.lean2 = verifyDims.lean2;
		myFrame.lean3 = verifyDims.lean3;
		myFrame.lean4 = verifyDims.lean4;
		myFrame.dimA1 = verifyDims.dimA1;
		myFrame.dimA2 = verifyDims.dimA2;
		myFrame.dimA3 = verifyDims.dimA3;
		myFrame.dimA0 = verifyDims.dimA0;
		myFrame.dimB1 = verifyDims.dimB1;
		myFrame.dimB2 = verifyDims.dimB2;
		myFrame.dimB0 = verifyDims.dimB0;
		myFrame.dimC1 = verifyDims.dimC1;
		myFrame.dimC2 = verifyDims.dimC2;
		myFrame.dimC0 = verifyDims.dimC0;
		myFrame.dimD1 = verifyDims.dimD1;
		myFrame.dimD2 = verifyDims.dimD2;
		myFrame.dimD0 = verifyDims.dimD0;
		myFrame.widthPix = verifyDims.myw;
		
		myFrame.heightPix = verifyDims.myh;
		myFrame.deltaA1 = verifyDims.deltaA1;
		myFrame.deltaC2 = verifyDims.deltaC2;
		myFrame.deltaD1 = verifyDims.deltaD1;
	}
	
	public void analyseShape()
	{
	
		int arcType = 0;
		int myShape = 0;
		if (myFrame.shapeID == 333)
		{
			myFrame.shapeID = 301;
			arcType = 333;
		}
		else if (myFrame.shapeID == 3333)
		{
			myFrame.shapeID = 302;
			arcType = 3333;
		}
		if (myFrame.shapeID == 1 || myFrame.shapeID <= 9)
		{
			myShape = 1;
		}
		else if (myFrame.shapeID >= 100 && myFrame.shapeID <= 149)
		{
			myShape = 1;
		}
		else if (myFrame.shapeID == 451)
		{
			myShape = 401;
		}
		else if (myFrame.shapeID == 452)
		{
			myShape = 402;
		}
		else
		{
			myShape = myFrame.shapeID;
		}
		myFrame.top1.posInUse = true;
		myFrame.bot1.posInUse = true;
		myFrame.left.posInUse = true;
		myFrame.right.posInUse = true;
		
		myFrame.top2.posInUse = false;
		myFrame.top3.posInUse = false;
		myFrame.bot2.posInUse = false;
		myFrame.bot3.posInUse = false;
		
		myFrame.topShape = 1;
		myFrame.leftShape = 1;
		myFrame.rightShape = 1;
		myFrame.botShape = 1;
		
		switch (myShape)
		{
		
		case 1: // rectangle// 4 sided
			myFrame.noSides = 4;
			
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			
			myFrame.topShape = 1;
			myFrame.leftShape = 1;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			
			myFrame.top2.posInUse = false;
			myFrame.top3.posInUse = false;
			
			myFrame.bot2.posInUse = false;
			myFrame.bot3.posInUse = false;
			
			myFrame.top1.lineStraight1B();
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 10: // rectangle// 4 sided
			myFrame.noSides = 0;
			
			myFrame.noSidesTop = 0;
			myFrame.noSidesBot = 0;
			myFrame.noSidesLeft = 0;
			myFrame.noSidesRight = 0;
			myFrame.lean = 0;
			myFrame.lean2 = 0;
			myFrame.lean3 = 0;
			myFrame.lean4 = 0;
			
			myFrame.topShape = 1;
			myFrame.leftShape = 1;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			myFrame.top2.posInUse = false;
			myFrame.top3.posInUse = false;
			
			myFrame.bot2.posInUse = false;
			myFrame.bot3.posInUse = false;
			
			break;
		case 90: // Pentagon
			myFrame.noSides = 5;
			
			myFrame.noSidesTop = 2;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			
			myFrame.topShape = 1;
			myFrame.leftShape = 1;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			
			myFrame.top2.posInUse = true;
			
			myFrame.top1.lineStraight1B_2();
			myFrame.top2.lineStraight1B_2();
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 91: // rectangle// 4 sided
			myFrame.noSides = 6;
			
			myFrame.noSidesTop = 3;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			
			myFrame.topShape = 1;
			myFrame.leftShape = 1;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			
			myFrame.top2.posInUse = true;
			myFrame.top3.posInUse = true;
			
			myFrame.bot2.posInUse = false;
			myFrame.bot3.posInUse = false;
			
			myFrame.top1.lineStraight1B_2();
			myFrame.top3.lineStraight1B_2();
			myFrame.top2.lineStraight1B_2();
			
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 92: // rectangle// 4 sided
			myFrame.noSides = 6;
			
			myFrame.noSidesTop = 3;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			
			myFrame.top2.posInUse = true;
			myFrame.top3.posInUse = true;
			
			myFrame.bot2.posInUse = false;
			myFrame.bot3.posInUse = false;
			
			myFrame.top1.lineStraight1B_2();
			myFrame.top3.lineStraight1B_2();
			myFrame.top2.lineStraight1B_2();
			
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 93: // rectangle// 4 sided
			myFrame.noSides = 8;
			
			myFrame.noSidesTop = 3;
			myFrame.noSidesBot = 3;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			myFrame.top1.posInUse = true;
			myFrame.top2.posInUse = true;
			myFrame.top3.posInUse = true;
			myFrame.bot1.posInUse = true;
			myFrame.bot2.posInUse = true;
			myFrame.bot3.posInUse = true;
			
			myFrame.top1.lineStraight1B_2();
			myFrame.top3.lineStraight1B_2();
			myFrame.top2.lineStraight1B_2();
			
			myFrame.right.rightStraightLine();
			myFrame.bot1.lineStraight1B_2();
			myFrame.bot3.bot1StraightLineB();
			myFrame.bot2.lineStraight1B_2();
			myFrame.left.leftStraightLineB();
			
			break;
		case 150: // rectangle// 4 sided
			myFrame.noSides = 5;
			
			myFrame.noSidesTop = 2;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			
			myFrame.top2.posInUse = true;
			myFrame.top3.posInUse = false;
			
			myFrame.bot2.posInUse = false;
			myFrame.bot3.posInUse = false;
			
			myFrame.top1.lineStraight1B_2();
			myFrame.top2.lineStraight1B_2();
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 154: // rectangle// 4 sided
			myFrame.noSides = 5;
			
			myFrame.noSidesTop = 2;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			
			myFrame.top2.posInUse = true;
			myFrame.top3.posInUse = false;
			
			myFrame.bot2.posInUse = false;
			myFrame.bot3.posInUse = false;
			
			myFrame.top1.lineStraight1B_2();
			myFrame.top2.lineStraight1B_2();
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 155: // rectangle// 4 sided
			myFrame.noSides = 5;
			
			myFrame.noSidesTop = 2;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			
			myFrame.top2.posInUse = true;
			myFrame.top3.posInUse = false;
			
			myFrame.bot2.posInUse = false;
			myFrame.bot3.posInUse = false;
			
			myFrame.top1.lineStraight1B_2();
			myFrame.top2.lineStraight1B_2();
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 160: // rectangle// 4 sided
			myFrame.noSides = 6;
			myFrame.noSidesTop = 3;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			
			myFrame.top2.posInUse = true;
			myFrame.top3.posInUse = true;
			
			myFrame.bot2.posInUse = false;
			myFrame.bot3.posInUse = false;
			
			myFrame.top1.lineStraight1B_2();
			myFrame.top3.lineStraight1B_2();
			myFrame.top2.lineStraight1B_2();
			
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 165: // rectangle// 4 sided
			myFrame.noSides = 6;
			
			myFrame.noSidesTop = 3;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			
			myFrame.top2.posInUse = true;
			myFrame.top3.posInUse = true;
			
			myFrame.bot2.posInUse = false;
			myFrame.bot3.posInUse = false;
			
			myFrame.top1.lineStraight1B_2();
			myFrame.top3.lineStraight1B_2();
			myFrame.top2.lineStraight1B_2();
			
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 200: // extended HR
			myFrame.noSides = 4;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			myFrame.topShape = 2;
			myFrame.leftShape = 1;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			
			myFrame.top1.arc1B();
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 201: // extended HR
			myFrame.noSides = 4;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			myFrame.topShape = 2;
			myFrame.leftShape = 1;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			
			myFrame.top1.arcEnd901B();
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 202: // extended HR
			myFrame.noSides = 4;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			myFrame.topShape = 2;
			myFrame.leftShape = 1;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			
			myFrame.top1.arcBegin901B();
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 203: // HR
			myFrame.noSides = 2;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 0;
			myFrame.noSidesRight = 0;
			myFrame.topShape = 2;
			myFrame.leftShape = 0;
			myFrame.rightShape = 0;
			myFrame.botShape = 1;
			
			myFrame.top2.posInUse = false;
			myFrame.top3.posInUse = false;
			myFrame.left.posInUse = false;
			myFrame.right.posInUse = false;
			
			myFrame.bot2.posInUse = false;
			myFrame.bot3.posInUse = false;
			
			myFrame.top1.arc1B();
			
			myFrame.bot1.bot1StraightLineB();
			
			break;
		case 204: // qRl
			myFrame.noSides = 3;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 0;
			myFrame.noSidesRight = 1;
			myFrame.topShape = 2;
			myFrame.leftShape = 0;
			myFrame.rightShape = 0;
			myFrame.botShape = 1;
			
			myFrame.top1.arcEnd901B();
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			
			break;
		case 205: // qRr
			myFrame.noSides = 3;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 0;
			myFrame.topShape = 2;
			myFrame.leftShape = 0;
			myFrame.rightShape = 0;
			myFrame.botShape = 1;
			
			myFrame.top1.arcBegin901B();
			
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 300: // extended Arc
			myFrame.noSides = 4;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			myFrame.topShape = 3;
			myFrame.leftShape = 1;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			
			myFrame.top1.arc1B();
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 301: // extended Arc End 90
			myFrame.noSides = 4;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			myFrame.topShape = 3;
			myFrame.leftShape = 1;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			
			if (arcType == 333)
			{
				myFrame.top1.arcShape333_1B();
			}
			else
			{
				myFrame.top1.arcEnd901B();
			}
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 302: // extended Arc start 90
			myFrame.noSides = 4;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			myFrame.topShape = 3;
			myFrame.leftShape = 1;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			
			if (arcType == 3333)
			{
				myFrame.top1.arcShape3333_1B();
			}
			else
			{
				myFrame.top1.arcBegin901B();
			}
			
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		
		case 303: // HR/Arc
			myFrame.noSides = 2;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 0;
			myFrame.noSidesRight = 0;
			myFrame.topShape = 2;
			myFrame.leftShape = 0;
			myFrame.rightShape = 0;
			myFrame.botShape = 1;
			
			myFrame.top1.arc1B();
			// this.myTestShapes.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			// this.myTestShapes.left.leftStraightLineB();
			
			break;
		case 304: // qRl
			myFrame.noSides = 3;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 0;
			myFrame.noSidesRight = 1;
			myFrame.topShape = 2;
			myFrame.leftShape = 0;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			
			myFrame.top1.arcEnd901B();
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			
			break;
		case 305: // qRr
			myFrame.noSides = 3;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 0;
			myFrame.topShape = 2;
			myFrame.leftShape = 1;
			myFrame.rightShape = 0;
			myFrame.botShape = 1;
			
			myFrame.top1.arcBegin901B();
			// this.myTestShapes.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 400: // Extended Ellipse
			myFrame.noSides = 4;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			myFrame.topShape = 4;
			myFrame.leftShape = 1;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			
			myFrame.left.endTypeLT = 3;
			myFrame.right.endTypeRB = 3;
			
			myFrame.top1.ellipse1B();
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			// this.myTestShapes.top1.top1ArcC();
			
			break;
		case 401: // Extended Ellipse
			myFrame.noSides = 4;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			myFrame.topShape = 4;
			myFrame.leftShape = 1;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			
			myFrame.left.endTypeLT = 3;
			myFrame.right.endTypeRB = 3;
			
			myFrame.top1.ellipse1B_401();
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 402: // Extended Ellipse
			myFrame.noSides = 4;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			myFrame.topShape = 4;
			myFrame.leftShape = 1;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			
			myFrame.left.endTypeLT = 3;
			myFrame.right.endTypeRB = 3;
			
			myFrame.top1.ellipse1B_402();
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
			break;
		case 403: // Extended Ellipse
			myFrame.noSides = 4;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 1;
			myFrame.topShape = 4;
			myFrame.leftShape = 1;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			
			myFrame.left.endTypeLT = 3;
			myFrame.right.endTypeRB = 3;
			
			myFrame.top1.ellipse1B_403();
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			myFrame.left.leftStraightLineB();
			
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
			myFrame.noSides = 3;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 0;
			myFrame.noSidesRight = 1;
			myFrame.topShape = 1;
			myFrame.leftShape = 0;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			
			myFrame.top2.posInUse = false;
			myFrame.top3.posInUse = false;
			
			myFrame.bot2.posInUse = false;
			myFrame.bot3.posInUse = false;
			
			myFrame.top1.lineStraight1B();
			myFrame.right.rightStraightLine();
			
			myFrame.bot1.bot1StraightLineB();
			
			break;
		case 701: // right Triangle - left
			myFrame.noSides = 3;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 0;
			myFrame.topShape = 1;
			myFrame.leftShape = 1;
			myFrame.rightShape = 0;
			myFrame.botShape = 1;
			
			myFrame.top2.posInUse = false;
			myFrame.top3.posInUse = false;
			
			myFrame.bot2.posInUse = false;
			myFrame.bot3.posInUse = false;
			
			myFrame.top1.lineStraight1B();
			myFrame.left.leftStraightLineB();
			myFrame.bot1.bot1StraightLineB();
			
			break;
		case 702: // triangle iso R
			myFrame.noSides = 3;
			
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 0;
			myFrame.noSidesRight = 1;
			myFrame.topShape = 1;
			myFrame.leftShape = 0;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			
			myFrame.top2.posInUse = false;
			myFrame.top3.posInUse = false;
			
			myFrame.bot2.posInUse = false;
			myFrame.bot3.posInUse = false;
			
			myFrame.top1.lineStraight1B();
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			
			if (myFrame.a_levelID != 1)
			{
				myFrame.right.rightStraightLineBA();
				myFrame.right.rightStraightLineA();
				myFrame.bot1.bot1StraightLineBA();
				myFrame.bot1.bot1StraightLineA();
				
				myFrame.top1.lineStraight2BA();
				myFrame.top1.lineStraight3A();
				
			}
			
			break;
		case 703: // triangle left
			myFrame.noSides = 3;
			
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 0;
			myFrame.topShape = 1;
			myFrame.leftShape = 1;
			myFrame.rightShape = 0;
			myFrame.botShape = 1;
			
			myFrame.top2.posInUse = false;
			myFrame.top3.posInUse = false;
			
			myFrame.bot2.posInUse = false;
			myFrame.bot3.posInUse = false;
			
			myFrame.top1.lineStraight1B();
			myFrame.left.leftStraightLineB();
			myFrame.bot1.bot1StraightLineB();
			
			if (myFrame.a_levelID != 1)
			{
				myFrame.left.leftStraightLineBA();
				myFrame.left.leftStraightLineA();
				myFrame.bot1.bot1StraightLineBA();
				myFrame.bot1.bot1StraightLineA();
				
				myFrame.top1.lineStraight2BA();
				myFrame.top1.lineStraight3A();
			}
			
			break;
		case 704: // triangle iso top
			myFrame.noSides = 3;
			
			myFrame.noSidesTop = 2;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 0;
			myFrame.noSidesRight = 0;
			myFrame.topShape = 1;
			myFrame.leftShape = 0;
			myFrame.rightShape = 0;
			myFrame.botShape = 1;
			
			myFrame.top2.posInUse = true;
			myFrame.top3.posInUse = false;
			
			myFrame.bot2.posInUse = false;
			myFrame.bot3.posInUse = false;
			
			myFrame.top1.lineStraight1B_2();
			myFrame.bot1.bot1StraightLineB();
			myFrame.top2.lineStraight1B_2();
			
			break;
		case 705: // Right Triangle LeanTop
			// (L)
			myFrame.noSides = 3;
			
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 0;
			myFrame.noSidesRight = 1;
			myFrame.topShape = 1;
			myFrame.leftShape = 0;
			myFrame.rightShape = 1;
			myFrame.botShape = 1;
			
			myFrame.top2.posInUse = false;
			myFrame.top3.posInUse = false;
			
			myFrame.bot2.posInUse = false;
			myFrame.bot3.posInUse = false;
			
			myFrame.top1.lineStraight1B();
			myFrame.right.rightStraightLine();
			myFrame.bot1.bot1StraightLineB();
			
			break;
		case 706: // Right triangle Lean Top
			// R
			myFrame.noSides = 3;
			
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 1;
			myFrame.noSidesRight = 0;
			myFrame.topShape = 1;
			myFrame.leftShape = 1;
			myFrame.rightShape = 0;
			myFrame.botShape = 1;
			
			myFrame.top2.posInUse = false;
			myFrame.top3.posInUse = false;
			
			myFrame.bot2.posInUse = false;
			myFrame.bot3.posInUse = false;
			
			myFrame.top1.lineStraight1B();
			myFrame.left.leftStraightLineB();
			myFrame.bot1.bot1StraightLineB();
			
			break;
		case 800: // HR
			myFrame.noSides = 2;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 0;
			myFrame.noSidesRight = 0;
			myFrame.topShape = 2;
			myFrame.leftShape = 0;
			myFrame.rightShape = 0;
			myFrame.botShape = 2;
			if (myFrame.widthPix == myFrame.heightPix)
			{
				myFrame.top1.arcCircle1B();
				
				myFrame.bot1.arcCircle1B();
			}
			else
			{
				myFrame.topShape = 2;
				myFrame.botShape = 2;
				myFrame.top1.archB();
				
				myFrame.bot1.archB();
			}
			
			break;
		case 801: // Ellipse
			myFrame.noSides = 2;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 0;
			myFrame.noSidesRight = 0;
			myFrame.topShape = 2;
			myFrame.leftShape = 0;
			myFrame.rightShape = 0;
			myFrame.botShape = 2;
			// if (myFrame.widthPix == myFrame.heightPix)
			// {
			// myFrame.top1
			// .arcCircle1B();
			//
			// myFrame.bot1
			// .arcCircle1B();
			// }
			// else
			// {
			myFrame.topShape = 2;
			myFrame.botShape = 2;
			myFrame.top1.ellipse1B();
			
			myFrame.bot1.ellipse1B();
			// }
			
			break;
		case 802: // Ellipse V
			// myFrame.noSides = 2;
			// myFrame.noSidesTop = 1;
			// myFrame.noSidesBot = 1;
			// myFrame.noSidesLeft = 0;
			// myFrame.noSidesRight = 0;
			// myFrame.topShape = 4;
			// myFrame.leftShape = 0;
			// myFrame.rightShape = 0;
			// myFrame.botShape = 4;
			//
			// // myFrame.top1.ellipse1B();
			// //
			// // myFrame.bot1.ellipse1B();
			//
			// myFrame.topShape = 2;
			// myFrame.botShape = 2;
			// myFrame.top1.archB();
			//
			// myFrame.bot1.archB();
			myFrame.noSides = 2;
			myFrame.noSidesTop = 1;
			myFrame.noSidesBot = 1;
			myFrame.noSidesLeft = 0;
			myFrame.noSidesRight = 0;
			myFrame.topShape = 2;
			myFrame.leftShape = 0;
			myFrame.rightShape = 0;
			myFrame.botShape = 2;
			if (myFrame.widthPix == myFrame.heightPix)
			{
				myFrame.top1.arcCircle1B();
				
				myFrame.bot1.arcCircle1B();
			}
			else
			{
				myFrame.topShape = 2;
				myFrame.botShape = 2;
				myFrame.top1.arc1B();
				
				myFrame.bot1.archB();
			}
			break;
		}// Switch
		
	}// analyseShapes
	
	private void extendedGothic()
	{
	
		myFrame.noSides = 5;
		myFrame.noSidesTop = 2;
		myFrame.noSidesBot = 1;
		myFrame.noSidesLeft = 1;
		myFrame.noSidesRight = 1;
		myFrame.topShape = 2;
		myFrame.leftShape = 1;
		myFrame.rightShape = 1;
		myFrame.botShape = 1;
		
		myFrame.top2.posInUse = true;
		myFrame.top3.posInUse = false;
		
		myFrame.bot2.posInUse = false;
		myFrame.bot3.posInUse = false;
		
		myFrame.top1.arcEnd901B_450();
		myFrame.top2.arcBegin901B();
		myFrame.right.rightStraightLine();
		myFrame.bot1.bot1StraightLineB();
		myFrame.left.leftStraightLineB();
		
	}
	
	private void gothic()
	{
	
		myFrame.noSides = 3;
		myFrame.noSidesTop = 2;
		myFrame.noSidesBot = 1;
		myFrame.noSidesLeft = 0;
		myFrame.noSidesRight = 0;
		myFrame.topShape = 2;
		myFrame.leftShape = 0;
		myFrame.rightShape = 0;
		myFrame.botShape = 1;
		
		myFrame.top2.posInUse = true;
		myFrame.top3.posInUse = false;
		
		myFrame.bot2.posInUse = false;
		myFrame.bot3.posInUse = false;
		
		myFrame.top1.arcEnd901B_450();
		myFrame.top2.arcBegin901B();
		myFrame.bot1.bot1StraightLineB();
		
	}
	
}
