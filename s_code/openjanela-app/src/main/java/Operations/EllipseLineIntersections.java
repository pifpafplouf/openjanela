/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 * 
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Operations;


import java.awt.geom.Point2D;

import Model.ShapeObject;


public class EllipseLineIntersections
	{

	public double getYusingX(
			final double sX,
			final double sY,
			final double eX,
			final double eY,
			final double r,
			final double cX,
			final double cY,
			final boolean positive)
		{

		double pY = 0;
		if (!positive)
			{
			pY =
					Math.sqrt(Math.abs(Math.pow(r, 2)
							- Math.pow(Math.abs(cX - sX), 2)));
			pY = cY - pY;
			}
		else
			{
			pY =
					Math.sqrt(Math.abs(Math.pow(r, 2)
							- Math.pow(Math.abs(sX - cX), 2)));
			pY = cY + pY;
			}
		return pY;
		}

	public double getXusingY(
			final double sX,
			final double sY,
			final double eX,
			final double eY,
			final double r,
			final double cX,
			final double cY,
			final boolean positive)
		{

// For your line equations, x1 = x2,
// so M=(y2-y1)/(x2-x1) gives you an indeterminate answer.
// (i.e. no answer) Not very helpful.
//
// If your arc is of radius r, and has centre (a,b),
// then it is formed as part of the equation (x-a)2 + (y-b)2
// = r2
//
// We'll let the line be x=k, so:
// (k-a)2 + (y-b)2 = r2
// (y-b)2 = r2 - (k-a)2
// y-b = �sqrt[r2 - (k-a)2]
// y = b � sqrt[r2 - (k-a)2]

// (y-b)2 -r2 = - (k-a)2
// r2 - (y-b)2 = (k-a)2
//
// + a + sqrt(r2 - (y-b)2) = k

//
// We know already that x=k, so the coordinates of
// the intersection are either:
// (k, b + sqrt[r2 - (k-a)2]) or (k, b - sqrt[r2 - (k-a)2])
// Whichever actually touches the arc.
		double pX = 0;
		if (!positive)
			{
			pX =
					Math.sqrt(Math.abs(Math.pow(r, 2)
							- Math.pow(cY - sY, 2)));
			pX = cX - pX;
			}
		else
			{
			pX =
					Math.sqrt(Math.abs(Math.pow(r, 2)
							- Math.pow(sY - cY, 2)));
			pX = cX + pX;
			}
		return pX;
		}

	public
			ShapeObject
			doArcIntersectionsT1L(final ShapeObject myShape)
		{

		Point2D p = new Point2D.Double();
		if (myShape.top1Part.endTypeRB == 1)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.leftPart.startXC,
							myShape.leftPart.startYC,
							myShape.leftPart.endXC,
							myShape.leftPart.endYC,

							1,
							true);
			myShape.leftPart.endXC = myShape.top1Part.startXC;
			myShape.leftPart.endYC =
					myShape.top1Part.startYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.leftPart.startXBA,
							myShape.leftPart.startYBA,
							myShape.leftPart.endXBA,
							myShape.leftPart.endYBA,

							1,
							true);
			myShape.leftPart.endXBA = myShape.top1Part.startXBA;
			// myShape.top1Part.startXBA =
// (double)
			// p.getX();
			myShape.leftPart.endYBA =
					myShape.top1Part.startYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.leftPart.startXA,
							myShape.leftPart.startYA,
							myShape.leftPart.endXA,
							myShape.leftPart.endYA,

							1,
							true);

			myShape.leftPart.endXA = myShape.top1Part.startXA;
			// myShape.top1Part.startXA =
// (double)
			// p.getX();
			myShape.leftPart.endYA =
					myShape.top1Part.startYA = p.getY();
			}

		if (myShape.top1Part.endTypeRB == 2)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.leftPart.startXC,
							myShape.leftPart.startYC,
							myShape.leftPart.endXC,
							myShape.leftPart.endYC,

							1,
							true);

			myShape.top1Part.startYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.leftPart.startXC,
							myShape.leftPart.startYC,
							myShape.leftPart.endXC,
							myShape.leftPart.endYC,

							1,
							true);

			myShape.top1Part.startYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.leftPart.startXA,
							myShape.leftPart.startYA,
							myShape.leftPart.endXA,
							myShape.leftPart.endYA,

							1,
							true);

			myShape.top1Part.startYA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.leftPart.startXC,
							myShape.leftPart.startYC,
							myShape.leftPart.endXC,
							myShape.leftPart.endYC,

							1,
							true);

			myShape.leftPart.endYC = p.getY();
			myShape.top1Part.startXC = myShape.leftPart.endXC;

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.leftPart.startXBA,
							myShape.leftPart.startYBA,
							myShape.leftPart.endXBA,
							myShape.leftPart.endYBA,

							1,
							true);

			myShape.leftPart.endYBA = p.getY();
			myShape.top1Part.startXBA = myShape.leftPart.endXC;

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.leftPart.startXA,
							myShape.leftPart.startYA,
							myShape.leftPart.endXA,
							myShape.leftPart.endYA,

							1,
							true);

			myShape.leftPart.endYA = p.getY();

			}

		if (myShape.top1Part.endTypeRB == 3)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.leftPart.startXBA,
							myShape.leftPart.startYBA,
							myShape.leftPart.endXBA,
							myShape.leftPart.endYBA,

							1,
							true);

			myShape.top1Part.startYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.leftPart.startXBA,
							myShape.leftPart.startYBA,
							myShape.leftPart.endXBA,
							myShape.leftPart.endYBA,

							1,
							true);

			myShape.top1Part.startYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.leftPart.startXBA,
							myShape.leftPart.startYBA,
							myShape.leftPart.endXBA,
							myShape.leftPart.endYBA,

							1,
							true);

			myShape.top1Part.startYA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.leftPart.startXC,
							myShape.leftPart.startYC,
							myShape.leftPart.endXC,
							myShape.leftPart.endYC,

							1,
							true);

			myShape.leftPart.endYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.leftPart.startXBA,
							myShape.leftPart.startYBA,
							myShape.leftPart.endXBA,
							myShape.leftPart.endYBA,

							1,
							true);

			myShape.leftPart.endYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.leftPart.startXA,
							myShape.leftPart.startYA,
							myShape.leftPart.endXA,
							myShape.leftPart.endYA,

							1,
							true);

			myShape.leftPart.endYA = p.getY();

			myShape.leftPart.stopAeX = myShape.top1Part.startXA;
			myShape.leftPart.stopAeY = myShape.top1Part.startYA;

			}
		return myShape;
		}

	public
			ShapeObject
			doArcIntersectionsT1R(final ShapeObject myShape)
		{

		Point2D p = new Point2D.Double();

		if (myShape.top1Part.endTypeLT == 1)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.rightPart.startXC,
							myShape.rightPart.startYC,
							myShape.rightPart.endXC,
							myShape.rightPart.endYC,
							1,
							false);
			myShape.rightPart.startXC = myShape.top1Part.endXC;
			myShape.rightPart.startYC =
					myShape.top1Part.endYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.rightPart.startXBA,
							myShape.rightPart.startYBA,
							myShape.rightPart.endXBA,
							myShape.rightPart.endYBA,
							1,
							false);
			myShape.rightPart.startXBA = myShape.top1Part.endXBA;

			myShape.rightPart.startYBA =
					myShape.top1Part.endYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.rightPart.startXA,
							myShape.rightPart.startYA,
							myShape.rightPart.endXA,
							myShape.rightPart.endYA,
							1,
							false);

			myShape.rightPart.startXA = myShape.top1Part.endXA;

			myShape.rightPart.startYA =
					myShape.top1Part.endYA = p.getY();
			}

		if (myShape.top1Part.endTypeLT == 2)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.rightPart.startXC,
							myShape.rightPart.startYC,
							myShape.rightPart.endXC,
							myShape.rightPart.endYC,
							1,
							false);

			myShape.top1Part.endYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.rightPart.startXC,
							myShape.rightPart.startYC,
							myShape.rightPart.endXC,
							myShape.rightPart.endYC,
							1,
							false);

			myShape.top1Part.endYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.rightPart.startXA,
							myShape.rightPart.startYA,
							myShape.rightPart.endXA,
							myShape.rightPart.endYA,
							1,
							false);

			myShape.top1Part.endYA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.rightPart.startXC,
							myShape.rightPart.startYC,
							myShape.rightPart.endXC,
							myShape.rightPart.endYC,

							1,
							false);

			myShape.rightPart.startYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.rightPart.startXBA,
							myShape.rightPart.startYBA,
							myShape.rightPart.endXBA,
							myShape.rightPart.endYBA,

							1,
							false);

			myShape.rightPart.startYBA = p.getY();
			myShape.top1Part.endXC = myShape.rightPart.startXC;
			myShape.top1Part.endXBA = myShape.rightPart.startXC;

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.rightPart.startXA,
							myShape.rightPart.startYA,
							myShape.rightPart.endXA,
							myShape.rightPart.endYA,

							1,
							false);

			myShape.rightPart.startYA = p.getY();

			}

		if (myShape.top1Part.endTypeLT == 3)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.rightPart.startXBA,
							myShape.rightPart.startYBA,
							myShape.rightPart.endXBA,
							myShape.rightPart.endYBA,
							1,
							false);

			myShape.top1Part.endYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.rightPart.startXBA,
							myShape.rightPart.startYBA,
							myShape.rightPart.endXBA,
							myShape.rightPart.endYBA,
							1,
							false);

			myShape.top1Part.endYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.rightPart.startXBA,
							myShape.rightPart.startYBA,
							myShape.rightPart.endXBA,
							myShape.rightPart.endYBA,
							1,
							false);

			myShape.top1Part.endYA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.rightPart.startXC,
							myShape.rightPart.startYC,
							myShape.rightPart.endXC,
							myShape.rightPart.endYC,

							1,
							false);

			myShape.rightPart.startYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.rightPart.startXBA,
							myShape.rightPart.startYBA,
							myShape.rightPart.endXBA,
							myShape.rightPart.endYBA,

							1,
							false);

			myShape.rightPart.startYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.rightPart.startXA,
							myShape.rightPart.startYA,
							myShape.rightPart.endXA,
							myShape.rightPart.endYA,

							1,
							false);

			myShape.rightPart.startYA = p.getY();

			myShape.rightPart.stopAsX = myShape.top1Part.endXA;
			myShape.rightPart.stopAsY = myShape.top1Part.endYA;

			}
		return myShape;
		}

	public ShapeObject doArcIntersectionsT1T2(
			final ShapeObject myShape)
		{

		Point2D p = new Point2D.Double();

		if (myShape.top1Part.endTypeLT == 1)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top2Part.startXC,
							myShape.top2Part.startYC,
							myShape.top2Part.endXC,
							myShape.top2Part.endYC,
							1,
							false);
			myShape.top2Part.startXC = myShape.top1Part.endXC;
			myShape.top2Part.startYC =
					myShape.top1Part.endYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top2Part.startXBA,
							myShape.top2Part.startYBA,
							myShape.top2Part.endXBA,
							myShape.top2Part.endYBA,
							1,
							false);
			myShape.top2Part.startXBA = myShape.top1Part.endXBA;

			myShape.top2Part.startYBA =
					myShape.top1Part.endYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top2Part.startXA,
							myShape.top2Part.startYA,
							myShape.top2Part.endXA,
							myShape.top2Part.endYA,
							1,
							false);

			myShape.top2Part.startXA = myShape.top1Part.endXA;

			myShape.top2Part.startYA =
					myShape.top1Part.endYA = p.getY();
			}

		if (myShape.top1Part.endTypeLT == 2)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top2Part.startXC,
							myShape.top2Part.startYC,
							myShape.top2Part.endXC,
							myShape.top2Part.endYC,
							1,
							false);

			myShape.top1Part.endYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top2Part.startXC,
							myShape.top2Part.startYC,
							myShape.top2Part.endXC,
							myShape.top2Part.endYC,
							1,
							false);

			myShape.top1Part.endYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top2Part.startXA,
							myShape.top2Part.startYA,
							myShape.top2Part.endXA,
							myShape.top2Part.endYA,
							1,
							false);

			myShape.top1Part.endYA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top2Part.startXC,
							myShape.top2Part.startYC,
							myShape.top2Part.endXC,
							myShape.top2Part.endYC,

							1,
							false);

			myShape.top2Part.startYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top2Part.startXBA,
							myShape.top2Part.startYBA,
							myShape.top2Part.endXBA,
							myShape.top2Part.endYBA,

							1,
							false);

			myShape.top2Part.startYBA = p.getY();
			myShape.top1Part.endXC = myShape.top2Part.startXC;
			myShape.top1Part.endXBA = myShape.top2Part.startXC;

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top2Part.startXA,
							myShape.top2Part.startYA,
							myShape.top2Part.endXA,
							myShape.top2Part.endYA,

							1,
							false);

			myShape.top2Part.startYA = p.getY();

			}

		if (myShape.top1Part.endTypeLT == 3)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top2Part.startXBA,
							myShape.top2Part.startYBA,
							myShape.top2Part.endXBA,
							myShape.top2Part.endYBA,
							1,
							false);

			myShape.top1Part.endYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top2Part.startXBA,
							myShape.top2Part.startYBA,
							myShape.top2Part.endXBA,
							myShape.top2Part.endYBA,
							1,
							false);

			myShape.top1Part.endYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top2Part.startXBA,
							myShape.top2Part.startYBA,
							myShape.top2Part.endXBA,
							myShape.top2Part.endYBA,
							1,
							false);

			myShape.top1Part.endYA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top2Part.startXC,
							myShape.top2Part.startYC,
							myShape.top2Part.endXC,
							myShape.top2Part.endYC,

							1,
							false);

			myShape.top2Part.startYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top2Part.startXBA,
							myShape.top2Part.startYBA,
							myShape.top2Part.endXBA,
							myShape.top2Part.endYBA,

							1,
							false);

			myShape.top2Part.startYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top2Part.startXA,
							myShape.top2Part.startYA,
							myShape.top2Part.endXA,
							myShape.top2Part.endYA,

							1,
							false);

			myShape.top2Part.startYA = p.getY();

			myShape.top2Part.stopAsX = myShape.top1Part.endXA;
			myShape.top2Part.stopAsY = myShape.top1Part.endYA;

			}
		return myShape;
		}

	public ShapeObject doArcIntersectionsT1T3(
			final ShapeObject myShape)
		{

		Point2D p = new Point2D.Double();

		if (myShape.top1Part.endTypeLT == 1)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top3Part.startXC,
							myShape.top3Part.startYC,
							myShape.top3Part.endXC,
							myShape.top3Part.endYC,
							1,
							false);
			myShape.top3Part.startXC = myShape.top1Part.endXC;
			myShape.top3Part.startYC =
					myShape.top1Part.endYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top3Part.startXBA,
							myShape.top3Part.startYBA,
							myShape.top3Part.endXBA,
							myShape.top3Part.endYBA,
							1,
							false);
			myShape.top3Part.startXBA = myShape.top1Part.endXBA;

			myShape.top3Part.startYBA =
					myShape.top1Part.endYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top3Part.startXA,
							myShape.top3Part.startYA,
							myShape.top3Part.endXA,
							myShape.top3Part.endYA,
							1,
							false);

			myShape.top3Part.startXA = myShape.top1Part.endXA;

			myShape.top3Part.startYA =
					myShape.top1Part.endYA = p.getY();
			}

		if (myShape.top1Part.endTypeLT == 2)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top3Part.startXC,
							myShape.top3Part.startYC,
							myShape.top3Part.endXC,
							myShape.top3Part.endYC,
							1,
							false);

			myShape.top1Part.endYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top3Part.startXC,
							myShape.top3Part.startYC,
							myShape.top3Part.endXC,
							myShape.top3Part.endYC,
							1,
							false);

			myShape.top1Part.endYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top3Part.startXA,
							myShape.top3Part.startYA,
							myShape.top3Part.endXA,
							myShape.top3Part.endYA,
							1,
							false);

			myShape.top1Part.endYA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top3Part.startXC,
							myShape.top3Part.startYC,
							myShape.top3Part.endXC,
							myShape.top3Part.endYC,

							1,
							false);

			myShape.top3Part.startYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top3Part.startXBA,
							myShape.top3Part.startYBA,
							myShape.top3Part.endXBA,
							myShape.top3Part.endYBA,

							1,
							false);

			myShape.top3Part.startYBA = p.getY();
			myShape.top1Part.endXC = myShape.top3Part.startXC;
			myShape.top1Part.endXBA = myShape.top3Part.startXC;

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top3Part.startXA,
							myShape.top3Part.startYA,
							myShape.top3Part.endXA,
							myShape.top3Part.endYA,

							1,
							false);

			myShape.top3Part.startYA = p.getY();

			}

		if (myShape.top1Part.endTypeLT == 3)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top3Part.startXBA,
							myShape.top3Part.startYBA,
							myShape.top3Part.endXBA,
							myShape.top3Part.endYBA,
							1,
							false);

			myShape.top1Part.endYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top3Part.startXBA,
							myShape.top3Part.startYBA,
							myShape.top3Part.endXBA,
							myShape.top3Part.endYBA,
							1,
							false);

			myShape.top1Part.endYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top3Part.startXBA,
							myShape.top3Part.startYBA,
							myShape.top3Part.endXBA,
							myShape.top3Part.endYBA,
							1,
							false);

			myShape.top1Part.endYA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top3Part.startXC,
							myShape.top3Part.startYC,
							myShape.top3Part.endXC,
							myShape.top3Part.endYC,

							1,
							false);

			myShape.top3Part.startYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top3Part.startXBA,
							myShape.top3Part.startYBA,
							myShape.top3Part.endXBA,
							myShape.top3Part.endYBA,

							1,
							false);

			myShape.top3Part.startYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.top3Part.startXA,
							myShape.top3Part.startYA,
							myShape.top3Part.endXA,
							myShape.top3Part.endYA,

							1,
							false);

			myShape.top3Part.startYA = p.getY();

			myShape.top3Part.stopAsX = myShape.top1Part.endXA;
			myShape.top3Part.stopAsY = myShape.top1Part.endYA;

			}
		return myShape;
		}

	public ShapeObject doArcIntersectionsT3T2(
			final ShapeObject myShape)
		{

		Point2D p = new Point2D.Double();
		if (myShape.top2Part.endTypeRB == 1)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.top3Part.startXC,
							myShape.top3Part.startYC,
							myShape.top3Part.endXC,
							myShape.top3Part.endYC,

							1,
							true);
			myShape.top3Part.endXC = myShape.top2Part.startXC;
			myShape.top3Part.endYC =
					myShape.top2Part.startYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.top3Part.startXBA,
							myShape.top3Part.startYBA,
							myShape.top3Part.endXBA,
							myShape.top3Part.endYBA,

							1,
							true);
			myShape.top3Part.endXBA = myShape.top2Part.startXBA;
			// myShape.top2Part.startXBA =
// (double)
			// p.getX();
			myShape.top3Part.endYBA =
					myShape.top2Part.startYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXA,
							myShape.top2Part.bkgrdStartYA, //
							myShape.top2Part.bkgrdWidthA,
							myShape.top2Part.bkgrdHeightA, //
							myShape.top2Part.startAngleA,
							myShape.top2Part.endAngleA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.top3Part.startXA,
							myShape.top3Part.startYA,
							myShape.top3Part.endXA,
							myShape.top3Part.endYA,

							1,
							true);

			myShape.top3Part.endXA = myShape.top2Part.startXA;
			// myShape.top2Part.startXA =
// (double)
			// p.getX();
			myShape.top3Part.endYA =
					myShape.top2Part.startYA = p.getY();
			}

		if (myShape.top2Part.endTypeRB == 2)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.top3Part.startXC,
							myShape.top3Part.startYC,
							myShape.top3Part.endXC,
							myShape.top3Part.endYC,

							1,
							true);

			myShape.top2Part.startYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.top3Part.startXC,
							myShape.top3Part.startYC,
							myShape.top3Part.endXC,
							myShape.top3Part.endYC,

							1,
							true);

			myShape.top2Part.startYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXA,
							myShape.top2Part.bkgrdStartYA, //
							myShape.top2Part.bkgrdWidthA,
							myShape.top2Part.bkgrdHeightA, //
							myShape.top2Part.startAngleA,
							myShape.top2Part.endAngleA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.top3Part.startXA,
							myShape.top3Part.startYA,
							myShape.top3Part.endXA,
							myShape.top3Part.endYA,

							1,
							true);

			myShape.top2Part.startYA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.top3Part.startXC,
							myShape.top3Part.startYC,
							myShape.top3Part.endXC,
							myShape.top3Part.endYC,

							1,
							true);

			myShape.top3Part.endYC = p.getY();
			myShape.top2Part.startXC = myShape.top3Part.endXC;

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.top3Part.startXBA,
							myShape.top3Part.startYBA,
							myShape.top3Part.endXBA,
							myShape.top3Part.endYBA,

							1,
							true);

			myShape.top3Part.endYBA = p.getY();
			myShape.top2Part.startXBA = myShape.top3Part.endXC;

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.top3Part.startXA,
							myShape.top3Part.startYA,
							myShape.top3Part.endXA,
							myShape.top3Part.endYA,

							1,
							true);

			myShape.top3Part.endYA = p.getY();

			}

		if (myShape.top2Part.endTypeRB == 3)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.top3Part.startXBA,
							myShape.top3Part.startYBA,
							myShape.top3Part.endXBA,
							myShape.top3Part.endYBA,

							1,
							true);

			myShape.top2Part.startYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.top3Part.startXBA,
							myShape.top3Part.startYBA,
							myShape.top3Part.endXBA,
							myShape.top3Part.endYBA,

							1,
							true);

			myShape.top2Part.startYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXA,
							myShape.top2Part.bkgrdStartYA, //
							myShape.top2Part.bkgrdWidthA,
							myShape.top2Part.bkgrdHeightA, //
							myShape.top2Part.startAngleA,
							myShape.top2Part.endAngleA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.top3Part.startXBA,
							myShape.top3Part.startYBA,
							myShape.top3Part.endXBA,
							myShape.top3Part.endYBA,

							1,
							true);

			myShape.top2Part.startYA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.top3Part.startXC,
							myShape.top3Part.startYC,
							myShape.top3Part.endXC,
							myShape.top3Part.endYC,

							1,
							true);

			myShape.top3Part.endYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.top3Part.startXBA,
							myShape.top3Part.startYBA,
							myShape.top3Part.endXBA,
							myShape.top3Part.endYBA,

							1,
							true);

			myShape.top3Part.endYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXA,
							myShape.top2Part.bkgrdStartYA, //
							myShape.top2Part.bkgrdWidthA,
							myShape.top2Part.bkgrdHeightA, //
							myShape.top2Part.startAngleA,
							myShape.top2Part.endAngleA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.top3Part.startXA,
							myShape.top3Part.startYA,
							myShape.top3Part.endXA,
							myShape.top3Part.endYA,

							1,
							true);

			myShape.top3Part.endYA = p.getY();

			myShape.top3Part.stopAeX = myShape.top2Part.startXA;
			myShape.top3Part.stopAeY = myShape.top2Part.startYA;

			}
		return myShape;
		}

	public
			ShapeObject
			doArcIntersectionsT2R(final ShapeObject myShape)
		{

		Point2D p = new Point2D.Double();

		if (myShape.top2Part.endTypeLT == 1)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.rightPart.startXC,
							myShape.rightPart.startYC,
							myShape.rightPart.endXC,
							myShape.rightPart.endYC,
							1,
							false);
			myShape.rightPart.startXC = myShape.top2Part.endXC;
			myShape.rightPart.startYC =
					myShape.top2Part.endYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.rightPart.startXBA,
							myShape.rightPart.startYBA,
							myShape.rightPart.endXBA,
							myShape.rightPart.endYBA,
							1,
							false);
			myShape.rightPart.startXBA = myShape.top2Part.endXBA;

			myShape.rightPart.startYBA =
					myShape.top2Part.endYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXA,
							myShape.top2Part.bkgrdStartYA, //
							myShape.top2Part.bkgrdWidthA,
							myShape.top2Part.bkgrdHeightA, //
							myShape.top2Part.startAngleA,
							myShape.top2Part.endAngleA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.rightPart.startXA,
							myShape.rightPart.startYA,
							myShape.rightPart.endXA,
							myShape.rightPart.endYA,
							1,
							false);

			myShape.rightPart.startXA = myShape.top2Part.endXA;

			myShape.rightPart.startYA =
					myShape.top2Part.endYA = p.getY();
			}

		if (myShape.top2Part.endTypeLT == 2)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.rightPart.startXC,
							myShape.rightPart.startYC,
							myShape.rightPart.endXC,
							myShape.rightPart.endYC,
							1,
							false);

			myShape.top2Part.endYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.rightPart.startXC,
							myShape.rightPart.startYC,
							myShape.rightPart.endXC,
							myShape.rightPart.endYC,
							1,
							false);

			myShape.top2Part.endYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXA,
							myShape.top2Part.bkgrdStartYA, //
							myShape.top2Part.bkgrdWidthA,
							myShape.top2Part.bkgrdHeightA, //
							myShape.top2Part.startAngleA,
							myShape.top2Part.endAngleA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.rightPart.startXA,
							myShape.rightPart.startYA,
							myShape.rightPart.endXA,
							myShape.rightPart.endYA,
							1,
							false);

			myShape.top2Part.endYA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.rightPart.startXC,
							myShape.rightPart.startYC,
							myShape.rightPart.endXC,
							myShape.rightPart.endYC,

							1,
							false);

			myShape.rightPart.startYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.rightPart.startXBA,
							myShape.rightPart.startYBA,
							myShape.rightPart.endXBA,
							myShape.rightPart.endYBA,

							1,
							false);

			myShape.rightPart.startYBA = p.getY();
			myShape.top2Part.endXC = myShape.rightPart.startXC;
			myShape.top2Part.endXBA = myShape.rightPart.startXC;

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.rightPart.startXA,
							myShape.rightPart.startYA,
							myShape.rightPart.endXA,
							myShape.rightPart.endYA,

							1,
							false);

			myShape.rightPart.startYA = p.getY();

			}

		if (myShape.top2Part.endTypeLT == 3)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.rightPart.startXBA,
							myShape.rightPart.startYBA,
							myShape.rightPart.endXBA,
							myShape.rightPart.endYBA,
							1,
							false);

			myShape.top2Part.endYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.rightPart.startXBA,
							myShape.rightPart.startYBA,
							myShape.rightPart.endXBA,
							myShape.rightPart.endYBA,
							1,
							false);

			myShape.top2Part.endYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXA,
							myShape.top2Part.bkgrdStartYA, //
							myShape.top2Part.bkgrdWidthA,
							myShape.top2Part.bkgrdHeightA, //
							myShape.top2Part.startAngleA,
							myShape.top2Part.endAngleA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.rightPart.startXBA,
							myShape.rightPart.startYBA,
							myShape.rightPart.endXBA,
							myShape.rightPart.endYBA,
							1,
							false);

			myShape.top2Part.endYA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.rightPart.startXC,
							myShape.rightPart.startYC,
							myShape.rightPart.endXC,
							myShape.rightPart.endYC,

							1,
							false);

			myShape.rightPart.startYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.rightPart.startXBA,
							myShape.rightPart.startYBA,
							myShape.rightPart.endXBA,
							myShape.rightPart.endYBA,

							1,
							false);

			myShape.rightPart.startYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXA,
							myShape.top2Part.bkgrdStartYA, //
							myShape.top2Part.bkgrdWidthA,
							myShape.top2Part.bkgrdHeightA, //
							myShape.top2Part.startAngleA,
							myShape.top2Part.endAngleA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.rightPart.startXA,
							myShape.rightPart.startYA,
							myShape.rightPart.endXA,
							myShape.rightPart.endYA,

							1,
							false);

			myShape.rightPart.startYA = p.getY();

			myShape.rightPart.stopAsX = myShape.top2Part.endXA;
			myShape.rightPart.stopAsY = myShape.top2Part.endYA;

			}
		return myShape;
		}

	public ShapeObject doArcIntersectionsT1LB(
			final ShapeObject myShape)
		{

		Point2D p = new Point2D.Double();
		if (myShape.top1Part.endTypeRB == 1)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,

							1,
							true);
			myShape.bot1Part.endXC =
					myShape.top1Part.startXC = p.getX();
// myShape.bot1Part.endY = myShape.top1Part.startY =
// (double)
// p
// .getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							true);
			myShape.bot1Part.endXBA =
					myShape.top1Part.startXBA = p.getX();

			myShape.top1Part.startYBA = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,

							1,
							true);

			myShape.bot1Part.endXA =
					myShape.top1Part.startXA = p.getX();

			myShape.top1Part.startYA = p.getY();
			}

		if (myShape.top1Part.endTypeRB == 2)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,

							1,
							true);

			myShape.top1Part.startYC = p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,

							1,
							true);

			myShape.top1Part.startYBA = myShape.top1Part.startYC;
			myShape.top1Part.startXBA = (double) p.getX();
			;

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,

							1,
							true);

			myShape.top1Part.startYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,

							1,
							true);

			myShape.bot1Part.endXC = (double) p.getX();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							true);

			myShape.bot1Part.endXBA = (double) p.getX();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,

							1,
							true);

			myShape.bot1Part.endXA = (double) p.getX();

			myShape.top1Part.stopAsX = myShape.bot1Part.endXA;
			myShape.top1Part.stopAsY = myShape.bot1Part.endYBA;

			}

		if (myShape.top1Part.endTypeRB == 3)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							true);

			myShape.top1Part.startYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							true);

			myShape.top1Part.startYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							true);

			myShape.top1Part.startYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,

							1,
							true);

			myShape.bot1Part.endXC = (double) p.getX();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							true);

			myShape.bot1Part.endXBA = (double) p.getX();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,

							1,
							true);

			myShape.bot1Part.endXA = (double) p.getX();

			myShape.bot1Part.stopAeX = myShape.bot1Part.endXA;
			myShape.bot1Part.stopAeY = myShape.top1Part.startYA;

			}
		return myShape;
		}

	public ShapeObject doArcIntersectionsT2RB(
			final ShapeObject myShape)
		{

		Point2D p = new Point2D.Double();

		if (myShape.top2Part.endTypeLT == 1)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,
							1,
							false);
			myShape.bot1Part.startXC = myShape.top2Part.endXC;
			myShape.bot1Part.startYC =
					myShape.top2Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,
							1,
							false);
			myShape.bot1Part.startXBA = myShape.top2Part.endXBA;

			myShape.bot1Part.startYBA =
					myShape.top2Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXA,
							myShape.top2Part.bkgrdStartYA, //
							myShape.top2Part.bkgrdWidthA,
							myShape.top2Part.bkgrdHeightA, //
							myShape.top2Part.startAngleA,
							myShape.top2Part.endAngleA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,
							1,
							false);

			myShape.bot1Part.startXA = myShape.top2Part.endXA;

			myShape.bot1Part.startYA =
					myShape.top2Part.endYA = (double) p.getY();
			}

		if (myShape.top2Part.endTypeLT == 2)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,
							1,
							false);

			myShape.top2Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,
							1,
							false);

			myShape.top2Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXA,
							myShape.top2Part.bkgrdStartYA, //
							myShape.top2Part.bkgrdWidthA,
							myShape.top2Part.bkgrdHeightA, //
							myShape.top2Part.startAngleA,
							myShape.top2Part.endAngleA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,
							1,
							false);

			myShape.top2Part.endYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,

							1,
							false);

			myShape.bot1Part.startYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							false);

			myShape.bot1Part.startYBA = (double) p.getY();
			myShape.top2Part.endXC = myShape.bot1Part.startXC;
			myShape.top2Part.endXBA = myShape.bot1Part.startXC;

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,

							1,
							false);

			myShape.bot1Part.startYA = (double) p.getY();

			}

		if (myShape.top2Part.endTypeLT == 3)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,
							1,
							false);

			myShape.top2Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,
							1,
							false);

			myShape.top2Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXA,
							myShape.top2Part.bkgrdStartYA, //
							myShape.top2Part.bkgrdWidthA,
							myShape.top2Part.bkgrdHeightA, //
							myShape.top2Part.startAngleA,
							myShape.top2Part.endAngleA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,
							1,
							false);

			myShape.top2Part.endYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,

							1,
							false);

			myShape.bot1Part.startYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							false);

			myShape.bot1Part.startYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXA,
							myShape.top2Part.bkgrdStartYA, //
							myShape.top2Part.bkgrdWidthA,
							myShape.top2Part.bkgrdHeightA, //
							myShape.top2Part.startAngleA,
							myShape.top2Part.endAngleA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,

							1,
							false);

			myShape.bot1Part.startYA = (double) p.getY();

			myShape.bot1Part.stopAsX = myShape.top2Part.endXA;
			myShape.bot1Part.stopAsY = myShape.top2Part.endYA;

			}
		return myShape;
		}

	public ShapeObject doArcIntersectionsT1RB(
			final ShapeObject myShape)
		{

		Point2D p = new Point2D.Double();

		if (myShape.top1Part.endTypeLT == 1)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,
							1,
							false);
			myShape.bot1Part.startXC = myShape.top1Part.endXC;
			myShape.bot1Part.startYC = myShape.top1Part.endYC;
// = (double) p
// .getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,
							1,
							false);
			myShape.bot1Part.startXBA =
					myShape.top1Part.endXBA = (double) p.getX();

			myShape.top1Part.endYBA = myShape.bot1Part.startYBA;

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,
							1,
							false);

			myShape.bot1Part.startXA =
					myShape.top1Part.endXA = (double) p.getX();

			myShape.top1Part.endYA = myShape.bot1Part.startYA;
			}

		if (myShape.top1Part.endTypeLT == 2)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,
							1,
							false);

			myShape.top1Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,
							1,
							false);

			myShape.top1Part.endYBA = myShape.top1Part.endYC;// (double)
																// p.getY();
			myShape.top1Part.endXBA = (double) p.getX();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,
							1,
							false);

			myShape.top1Part.endYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,

							1,
							false);

			myShape.bot1Part.startXC = (double) p.getX();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							false);

			myShape.bot1Part.startXBA = (double) p.getX();
			// myShape.top1Part.endX =
			// myShape.bot1Part.startX;
			// myShape.top1Part.endXBA =
			// myShape.bot1Part.startX;

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,

							1,
							false);

			myShape.bot1Part.startXA = (double) p.getX();

			myShape.top1Part.stopAeX = myShape.bot1Part.startXA;
			myShape.top1Part.stopAeY = myShape.bot1Part.startYA;

			}

		if (myShape.top1Part.endTypeLT == 3)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,
							1,
							false);

			myShape.top1Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,
							1,
							false);

			myShape.top1Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,
							1,
							false);

			myShape.top1Part.endYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,

							1,
							false);

			myShape.bot1Part.startXC = (double) p.getX();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							false);

			myShape.bot1Part.startXBA = (double) p.getX();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,

							1,
							false);

			myShape.bot1Part.startXA = (double) p.getX();

			myShape.bot1Part.stopAsX = myShape.bot1Part.startXA;
			myShape.bot1Part.stopAsY = myShape.top1Part.endYA;

			}
		return myShape;
		}

	public ShapeObject doArcIntersectionsT1LB2(
			final ShapeObject myShape)
		{

		Point2D p = new Point2D.Double();
		if (myShape.top1Part.endTypeRB == 1)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot2Part.startXC,
							myShape.bot2Part.startYC,
							myShape.bot2Part.endXC,
							myShape.bot2Part.endYC,

							1,
							true);
			myShape.bot2Part.endXC = myShape.top1Part.startXC;
			myShape.bot2Part.endYC =
					myShape.top1Part.startYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot2Part.startXBA,
							myShape.bot2Part.startYBA,
							myShape.bot2Part.endXBA,
							myShape.bot2Part.endYBA,

							1,
							true);
			myShape.bot2Part.endXBA = myShape.top1Part.startXBA;
			// myShape.top1Part.startXBA =
// (double)
			// p.getX();
			myShape.bot2Part.endYBA =
					myShape.top1Part.startYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot2Part.startXA,
							myShape.bot2Part.startYA,
							myShape.bot2Part.endXA,
							myShape.bot2Part.endYA,

							1,
							true);

			myShape.bot2Part.endXA = myShape.top1Part.startXA;
			// myShape.top1Part.startXA =
// (double)
			// p.getX();
			myShape.bot2Part.endYA =
					myShape.top1Part.startYA = (double) p.getY();
			}

		if (myShape.top1Part.endTypeRB == 2)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot2Part.startXC,
							myShape.bot2Part.startYC,
							myShape.bot2Part.endXC,
							myShape.bot2Part.endYC,

							1,
							true);

			myShape.top1Part.startYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot2Part.startXC,
							myShape.bot2Part.startYC,
							myShape.bot2Part.endXC,
							myShape.bot2Part.endYC,

							1,
							true);

			myShape.top1Part.startYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot2Part.startXA,
							myShape.bot2Part.startYA,
							myShape.bot2Part.endXA,
							myShape.bot2Part.endYA,

							1,
							true);

			myShape.top1Part.startYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot2Part.startXC,
							myShape.bot2Part.startYC,
							myShape.bot2Part.endXC,
							myShape.bot2Part.endYC,

							1,
							true);

			myShape.bot2Part.endYC = (double) p.getY();
			myShape.top1Part.startXC = myShape.bot2Part.endXC;

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot2Part.startXBA,
							myShape.bot2Part.startYBA,
							myShape.bot2Part.endXBA,
							myShape.bot2Part.endYBA,

							1,
							true);

			myShape.bot2Part.endYBA = (double) p.getY();
			myShape.top1Part.startXBA = myShape.bot2Part.endXC;

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot2Part.startXA,
							myShape.bot2Part.startYA,
							myShape.bot2Part.endXA,
							myShape.bot2Part.endYA,

							1,
							true);

			myShape.bot2Part.endYA = (double) p.getY();

			}

		if (myShape.top1Part.endTypeRB == 3)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot2Part.startXBA,
							myShape.bot2Part.startYBA,
							myShape.bot2Part.endXBA,
							myShape.bot2Part.endYBA,

							1,
							true);

			myShape.top1Part.startYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot2Part.startXBA,
							myShape.bot2Part.startYBA,
							myShape.bot2Part.endXBA,
							myShape.bot2Part.endYBA,

							1,
							true);

			myShape.top1Part.startYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot2Part.startXBA,
							myShape.bot2Part.startYBA,
							myShape.bot2Part.endXBA,
							myShape.bot2Part.endYBA,

							1,
							true);

			myShape.top1Part.startYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot2Part.startXC,
							myShape.bot2Part.startYC,
							myShape.bot2Part.endXC,
							myShape.bot2Part.endYC,

							1,
							true);

			myShape.bot2Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot2Part.startXBA,
							myShape.bot2Part.startYBA,
							myShape.bot2Part.endXBA,
							myShape.bot2Part.endYBA,

							1,
							true);

			myShape.bot2Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot2Part.startXA,
							myShape.bot2Part.startYA,
							myShape.bot2Part.endXA,
							myShape.bot2Part.endYA,

							1,
							true);

			myShape.bot2Part.endYA = (double) p.getY();

			myShape.bot2Part.stopAeX = myShape.top1Part.startXA;
			myShape.bot2Part.stopAeY = myShape.top1Part.startYA;

			}
		return myShape;
		}

	public ShapeObject doArcIntersectionsT1RB3(
			final ShapeObject myShape)
		{

		Point2D p = new Point2D.Double();

		if (myShape.top1Part.endTypeLT == 1)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot3Part.startXC,
							myShape.bot3Part.startYC,
							myShape.bot3Part.endXC,
							myShape.bot3Part.endYC,
							1,
							false);
			myShape.bot3Part.startXC = myShape.top1Part.endXC;
			myShape.bot3Part.startYC =
					myShape.top1Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot3Part.startXBA,
							myShape.bot3Part.startYBA,
							myShape.bot3Part.endXBA,
							myShape.bot3Part.endYBA,
							1,
							false);
			myShape.bot3Part.startXBA = myShape.top1Part.endXBA;

			myShape.bot3Part.startYBA =
					myShape.top1Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot3Part.startXA,
							myShape.bot3Part.startYA,
							myShape.bot3Part.endXA,
							myShape.bot3Part.endYA,
							1,
							false);

			myShape.bot3Part.startXA = myShape.top1Part.endXA;

			myShape.bot3Part.startYA =
					myShape.top1Part.endYA = (double) p.getY();
			}

		if (myShape.top1Part.endTypeLT == 2)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot3Part.startXC,
							myShape.bot3Part.startYC,
							myShape.bot3Part.endXC,
							myShape.bot3Part.endYC,
							1,
							false);

			myShape.top1Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot3Part.startXC,
							myShape.bot3Part.startYC,
							myShape.bot3Part.endXC,
							myShape.bot3Part.endYC,
							1,
							false);

			myShape.top1Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot3Part.startXA,
							myShape.bot3Part.startYA,
							myShape.bot3Part.endXA,
							myShape.bot3Part.endYA,
							1,
							false);

			myShape.top1Part.endYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot3Part.startXC,
							myShape.bot3Part.startYC,
							myShape.bot3Part.endXC,
							myShape.bot3Part.endYC,

							1,
							false);

			myShape.bot3Part.startYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot3Part.startXBA,
							myShape.bot3Part.startYBA,
							myShape.bot3Part.endXBA,
							myShape.bot3Part.endYBA,

							1,
							false);

			myShape.bot3Part.startYBA = (double) p.getY();
			myShape.top1Part.endXC = myShape.bot3Part.startXC;
			myShape.top1Part.endXBA = myShape.bot3Part.startXC;

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot3Part.startXA,
							myShape.bot3Part.startYA,
							myShape.bot3Part.endXA,
							myShape.bot3Part.endYA,

							1,
							false);

			myShape.bot3Part.startYA = (double) p.getY();

			}

		if (myShape.top1Part.endTypeLT == 3)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot3Part.startXBA,
							myShape.bot3Part.startYBA,
							myShape.bot3Part.endXBA,
							myShape.bot3Part.endYBA,
							1,
							false);

			myShape.top1Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXBA,
							myShape.top1Part.bkgrdStartYBA, //
							myShape.top1Part.bkgrdWidthBA,
							myShape.top1Part.bkgrdHeightBA, //
							myShape.top1Part.startAngleBA,
							myShape.top1Part.endAngleBA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot3Part.startXBA,
							myShape.bot3Part.startYBA,
							myShape.bot3Part.endXBA,
							myShape.bot3Part.endYBA,
							1,
							false);

			myShape.top1Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot3Part.startXBA,
							myShape.bot3Part.startYBA,
							myShape.bot3Part.endXBA,
							myShape.bot3Part.endYBA,
							1,
							false);

			myShape.top1Part.endYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot3Part.startXC,
							myShape.bot3Part.startYC,
							myShape.bot3Part.endXC,
							myShape.bot3Part.endYC,

							1,
							false);

			myShape.bot3Part.startYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartX,
							myShape.top1Part.bkgrdStartY, //
							myShape.top1Part.bkgrdWidth,
							myShape.top1Part.bkgrdHeight, //
							myShape.top1Part.startAngle,
							myShape.top1Part.endAngle, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot3Part.startXBA,
							myShape.bot3Part.startYBA,
							myShape.bot3Part.endXBA,
							myShape.bot3Part.endYBA,

							1,
							false);

			myShape.bot3Part.startYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top1Part.bkgrdStartXA,
							myShape.top1Part.bkgrdStartYA, //
							myShape.top1Part.bkgrdWidthA,
							myShape.top1Part.bkgrdHeightA, //
							myShape.top1Part.startAngleA,
							myShape.top1Part.endAngleA, //
							myShape.top1Part.x1,
							myShape.top1Part.y1,
							myShape.bot3Part.startXA,
							myShape.bot3Part.startYA,
							myShape.bot3Part.endXA,
							myShape.bot3Part.endYA,

							1,
							false);

			myShape.bot3Part.startYA = (double) p.getY();

			myShape.bot3Part.stopAsX = myShape.top1Part.endXA;
			myShape.bot3Part.stopAsY = myShape.top1Part.endYA;

			}
		return myShape;
		}

	public ShapeObject doArcIntersectionsB1B2(
			final ShapeObject myShape)
		{

		Point2D p = new Point2D.Double();

		if (myShape.bot1Part.endTypeLT == 1)
			{
			p =
					this.getIntersectionLineArc(
							myShape.bot1Part.bkgrdStartX,
							myShape.bot1Part.bkgrdStartY, //
							myShape.bot1Part.bkgrdWidth,
							myShape.bot1Part.bkgrdHeight, //
							myShape.bot1Part.startAngle,
							myShape.bot1Part.endAngle, //
							myShape.bot1Part.x1,
							myShape.bot1Part.y1,
							myShape.bot2Part.startXC,
							myShape.bot2Part.startYC,
							myShape.bot2Part.endXC,
							myShape.bot2Part.endYC,
							1,
							false);
			myShape.bot2Part.startXC = myShape.bot1Part.endXC;
			myShape.bot2Part.startYC =
					myShape.bot1Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot1Part.bkgrdStartXBA,
							myShape.bot1Part.bkgrdStartYBA, //
							myShape.bot1Part.bkgrdWidthBA,
							myShape.bot1Part.bkgrdHeightBA, //
							myShape.bot1Part.startAngleBA,
							myShape.bot1Part.endAngleBA, //
							myShape.bot1Part.x1,
							myShape.bot1Part.y1,
							myShape.bot2Part.startXBA,
							myShape.bot2Part.startYBA,
							myShape.bot2Part.endXBA,
							myShape.bot2Part.endYBA,
							1,
							false);
			myShape.bot2Part.startXBA = myShape.bot1Part.endXBA;

			myShape.bot2Part.startYBA =
					myShape.bot1Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot1Part.bkgrdStartXA,
							myShape.bot1Part.bkgrdStartYA, //
							myShape.bot1Part.bkgrdWidthA,
							myShape.bot1Part.bkgrdHeightA, //
							myShape.bot1Part.startAngleA,
							myShape.bot1Part.endAngleA, //
							myShape.bot1Part.x1,
							myShape.bot1Part.y1,
							myShape.bot2Part.startXA,
							myShape.bot2Part.startYA,
							myShape.bot2Part.endXA,
							myShape.bot2Part.endYA,
							1,
							false);

			myShape.bot2Part.startXA = myShape.bot1Part.endXA;

			myShape.bot2Part.startYA =
					myShape.bot1Part.endYA = (double) p.getY();
			}

		if (myShape.bot1Part.endTypeLT == 2)
			{
			p =
					this.getIntersectionLineArc(
							myShape.bot1Part.bkgrdStartX,
							myShape.bot1Part.bkgrdStartY, //
							myShape.bot1Part.bkgrdWidth,
							myShape.bot1Part.bkgrdHeight, //
							myShape.bot1Part.startAngle,
							myShape.bot1Part.endAngle, //
							myShape.bot1Part.x1,
							myShape.bot1Part.y1,
							myShape.bot2Part.startXC,
							myShape.bot2Part.startYC,
							myShape.bot2Part.endXC,
							myShape.bot2Part.endYC,
							1,
							false);

			myShape.bot1Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot1Part.bkgrdStartXBA,
							myShape.bot1Part.bkgrdStartYBA, //
							myShape.bot1Part.bkgrdWidthBA,
							myShape.bot1Part.bkgrdHeightBA, //
							myShape.bot1Part.startAngleBA,
							myShape.bot1Part.endAngleBA, //
							myShape.bot1Part.x1,
							myShape.bot1Part.y1,
							myShape.bot2Part.startXC,
							myShape.bot2Part.startYC,
							myShape.bot2Part.endXC,
							myShape.bot2Part.endYC,
							1,
							false);

			myShape.bot1Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot1Part.bkgrdStartXA,
							myShape.bot1Part.bkgrdStartYA, //
							myShape.bot1Part.bkgrdWidthA,
							myShape.bot1Part.bkgrdHeightA, //
							myShape.bot1Part.startAngleA,
							myShape.bot1Part.endAngleA, //
							myShape.bot1Part.x1,
							myShape.bot1Part.y1,
							myShape.bot2Part.startXA,
							myShape.bot2Part.startYA,
							myShape.bot2Part.endXA,
							myShape.bot2Part.endYA,
							1,
							false);

			myShape.bot1Part.endYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot1Part.bkgrdStartXBA,
							myShape.bot1Part.bkgrdStartYBA, //
							myShape.bot1Part.bkgrdWidthBA,
							myShape.bot1Part.bkgrdHeightBA, //
							myShape.bot1Part.startAngleBA,
							myShape.bot1Part.endAngleBA, //
							myShape.bot1Part.x1,
							myShape.bot1Part.y1,
							myShape.bot2Part.startXC,
							myShape.bot2Part.startYC,
							myShape.bot2Part.endXC,
							myShape.bot2Part.endYC,

							1,
							false);

			myShape.bot2Part.startYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot1Part.bkgrdStartXBA,
							myShape.bot1Part.bkgrdStartYBA, //
							myShape.bot1Part.bkgrdWidthBA,
							myShape.bot1Part.bkgrdHeightBA, //
							myShape.bot1Part.startAngleBA,
							myShape.bot1Part.endAngleBA, //
							myShape.bot1Part.x1,
							myShape.bot1Part.y1,
							myShape.bot2Part.startXBA,
							myShape.bot2Part.startYBA,
							myShape.bot2Part.endXBA,
							myShape.bot2Part.endYBA,

							1,
							false);

			myShape.bot2Part.startYBA = (double) p.getY();
			myShape.bot1Part.endXC = myShape.bot2Part.startXC;
			myShape.bot1Part.endXBA = myShape.bot2Part.startXC;

			p =
					this.getIntersectionLineArc(
							myShape.bot1Part.bkgrdStartXBA,
							myShape.bot1Part.bkgrdStartYBA, //
							myShape.bot1Part.bkgrdWidthBA,
							myShape.bot1Part.bkgrdHeightBA, //
							myShape.bot1Part.startAngleBA,
							myShape.bot1Part.endAngleBA, //
							myShape.bot1Part.x1,
							myShape.bot1Part.y1,
							myShape.bot2Part.startXA,
							myShape.bot2Part.startYA,
							myShape.bot2Part.endXA,
							myShape.bot2Part.endYA,

							1,
							false);

			myShape.bot2Part.startYA = (double) p.getY();

			}

		if (myShape.bot1Part.endTypeLT == 3)
			{
			p =
					this.getIntersectionLineArc(
							myShape.bot1Part.bkgrdStartX,
							myShape.bot1Part.bkgrdStartY, //
							myShape.bot1Part.bkgrdWidth,
							myShape.bot1Part.bkgrdHeight, //
							myShape.bot1Part.startAngle,
							myShape.bot1Part.endAngle, //
							myShape.bot1Part.x1,
							myShape.bot1Part.y1,
							myShape.bot2Part.startXBA,
							myShape.bot2Part.startYBA,
							myShape.bot2Part.endXBA,
							myShape.bot2Part.endYBA,
							1,
							false);

			myShape.bot1Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot1Part.bkgrdStartXBA,
							myShape.bot1Part.bkgrdStartYBA, //
							myShape.bot1Part.bkgrdWidthBA,
							myShape.bot1Part.bkgrdHeightBA, //
							myShape.bot1Part.startAngleBA,
							myShape.bot1Part.endAngleBA, //
							myShape.bot1Part.x1,
							myShape.bot1Part.y1,
							myShape.bot2Part.startXBA,
							myShape.bot2Part.startYBA,
							myShape.bot2Part.endXBA,
							myShape.bot2Part.endYBA,
							1,
							false);

			myShape.bot1Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot1Part.bkgrdStartXA,
							myShape.bot1Part.bkgrdStartYA, //
							myShape.bot1Part.bkgrdWidthA,
							myShape.bot1Part.bkgrdHeightA, //
							myShape.bot1Part.startAngleA,
							myShape.bot1Part.endAngleA, //
							myShape.bot1Part.x1,
							myShape.bot1Part.y1,
							myShape.bot2Part.startXBA,
							myShape.bot2Part.startYBA,
							myShape.bot2Part.endXBA,
							myShape.bot2Part.endYBA,
							1,
							false);

			myShape.bot1Part.endYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot1Part.bkgrdStartX,
							myShape.bot1Part.bkgrdStartY, //
							myShape.bot1Part.bkgrdWidth,
							myShape.bot1Part.bkgrdHeight, //
							myShape.bot1Part.startAngle,
							myShape.bot1Part.endAngle, //
							myShape.bot1Part.x1,
							myShape.bot1Part.y1,
							myShape.bot2Part.startXC,
							myShape.bot2Part.startYC,
							myShape.bot2Part.endXC,
							myShape.bot2Part.endYC,

							1,
							false);

			myShape.bot2Part.startYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot1Part.bkgrdStartX,
							myShape.bot1Part.bkgrdStartY, //
							myShape.bot1Part.bkgrdWidth,
							myShape.bot1Part.bkgrdHeight, //
							myShape.bot1Part.startAngle,
							myShape.bot1Part.endAngle, //
							myShape.bot1Part.x1,
							myShape.bot1Part.y1,
							myShape.bot2Part.startXBA,
							myShape.bot2Part.startYBA,
							myShape.bot2Part.endXBA,
							myShape.bot2Part.endYBA,

							1,
							false);

			myShape.bot2Part.startYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot1Part.bkgrdStartXA,
							myShape.bot1Part.bkgrdStartYA, //
							myShape.bot1Part.bkgrdWidthA,
							myShape.bot1Part.bkgrdHeightA, //
							myShape.bot1Part.startAngleA,
							myShape.bot1Part.endAngleA, //
							myShape.bot1Part.x1,
							myShape.bot1Part.y1,
							myShape.bot2Part.startXA,
							myShape.bot2Part.startYA,
							myShape.bot2Part.endXA,
							myShape.bot2Part.endYA,

							1,
							false);

			myShape.bot2Part.startYA = (double) p.getY();

			myShape.bot2Part.stopAsX = myShape.bot1Part.endXA;
			myShape.bot2Part.stopAsY = myShape.bot1Part.endYA;

			}
		return myShape;
		}

	public ShapeObject doArcIntersectionsT2RB3(
			final ShapeObject myShape)
		{

		Point2D p = new Point2D.Double();

		if (myShape.top2Part.endTypeLT == 1)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot3Part.startXC,
							myShape.bot3Part.startYC,
							myShape.bot3Part.endXC,
							myShape.bot3Part.endYC,
							1,
							false);
			myShape.bot3Part.startXC = myShape.top2Part.endXC;
			myShape.bot3Part.startYC =
					myShape.top2Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot3Part.startXBA,
							myShape.bot3Part.startYBA,
							myShape.bot3Part.endXBA,
							myShape.bot3Part.endYBA,
							1,
							false);
			myShape.bot3Part.startXBA = myShape.top2Part.endXBA;

			myShape.bot3Part.startYBA =
					myShape.top2Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXA,
							myShape.top2Part.bkgrdStartYA, //
							myShape.top2Part.bkgrdWidthA,
							myShape.top2Part.bkgrdHeightA, //
							myShape.top2Part.startAngleA,
							myShape.top2Part.endAngleA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot3Part.startXA,
							myShape.bot3Part.startYA,
							myShape.bot3Part.endXA,
							myShape.bot3Part.endYA,
							1,
							false);

			myShape.bot3Part.startXA = myShape.top2Part.endXA;

			myShape.bot3Part.startYA =
					myShape.top2Part.endYA = (double) p.getY();
			}

		if (myShape.top2Part.endTypeLT == 2)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot3Part.startXC,
							myShape.bot3Part.startYC,
							myShape.bot3Part.endXC,
							myShape.bot3Part.endYC,
							1,
							false);

			myShape.top2Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot3Part.startXC,
							myShape.bot3Part.startYC,
							myShape.bot3Part.endXC,
							myShape.bot3Part.endYC,
							1,
							false);

			myShape.top2Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXA,
							myShape.top2Part.bkgrdStartYA, //
							myShape.top2Part.bkgrdWidthA,
							myShape.top2Part.bkgrdHeightA, //
							myShape.top2Part.startAngleA,
							myShape.top2Part.endAngleA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot3Part.startXA,
							myShape.bot3Part.startYA,
							myShape.bot3Part.endXA,
							myShape.bot3Part.endYA,
							1,
							false);

			myShape.top2Part.endYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot3Part.startXC,
							myShape.bot3Part.startYC,
							myShape.bot3Part.endXC,
							myShape.bot3Part.endYC,

							1,
							false);

			myShape.bot3Part.startYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot3Part.startXBA,
							myShape.bot3Part.startYBA,
							myShape.bot3Part.endXBA,
							myShape.bot3Part.endYBA,

							1,
							false);

			myShape.bot3Part.startYBA = (double) p.getY();
			myShape.top2Part.endXC = myShape.bot3Part.startXC;
			myShape.top2Part.endXBA = myShape.bot3Part.startXC;

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot3Part.startXA,
							myShape.bot3Part.startYA,
							myShape.bot3Part.endXA,
							myShape.bot3Part.endYA,

							1,
							false);

			myShape.bot3Part.startYA = (double) p.getY();

			}

		if (myShape.top2Part.endTypeLT == 3)
			{
			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot3Part.startXBA,
							myShape.bot3Part.startYBA,
							myShape.bot3Part.endXBA,
							myShape.bot3Part.endYBA,
							1,
							false);

			myShape.top2Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXBA,
							myShape.top2Part.bkgrdStartYBA, //
							myShape.top2Part.bkgrdWidthBA,
							myShape.top2Part.bkgrdHeightBA, //
							myShape.top2Part.startAngleBA,
							myShape.top2Part.endAngleBA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot3Part.startXBA,
							myShape.bot3Part.startYBA,
							myShape.bot3Part.endXBA,
							myShape.bot3Part.endYBA,
							1,
							false);

			myShape.top2Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXA,
							myShape.top2Part.bkgrdStartYA, //
							myShape.top2Part.bkgrdWidthA,
							myShape.top2Part.bkgrdHeightA, //
							myShape.top2Part.startAngleA,
							myShape.top2Part.endAngleA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot3Part.startXBA,
							myShape.bot3Part.startYBA,
							myShape.bot3Part.endXBA,
							myShape.bot3Part.endYBA,
							1,
							false);

			myShape.top2Part.endYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot3Part.startXC,
							myShape.bot3Part.startYC,
							myShape.bot3Part.endXC,
							myShape.bot3Part.endYC,

							1,
							false);

			myShape.bot3Part.startYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartX,
							myShape.top2Part.bkgrdStartY, //
							myShape.top2Part.bkgrdWidth,
							myShape.top2Part.bkgrdHeight, //
							myShape.top2Part.startAngle,
							myShape.top2Part.endAngle, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot3Part.startXBA,
							myShape.bot3Part.startYBA,
							myShape.bot3Part.endXBA,
							myShape.bot3Part.endYBA,

							1,
							false);

			myShape.bot3Part.startYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.top2Part.bkgrdStartXA,
							myShape.top2Part.bkgrdStartYA, //
							myShape.top2Part.bkgrdWidthA,
							myShape.top2Part.bkgrdHeightA, //
							myShape.top2Part.startAngleA,
							myShape.top2Part.endAngleA, //
							myShape.top2Part.x1,
							myShape.top2Part.y1,
							myShape.bot3Part.startXA,
							myShape.bot3Part.startYA,
							myShape.bot3Part.endXA,
							myShape.bot3Part.endYA,

							1,
							false);

			myShape.bot3Part.startYA = (double) p.getY();

			myShape.bot3Part.stopAsX = myShape.top2Part.endXA;
			myShape.bot3Part.stopAsY = myShape.top2Part.endYA;

			}
		return myShape;
		}

	public ShapeObject doArcIntersectionsB2B1(
			final ShapeObject myShape)
		{

		Point2D p = new Point2D.Double();
		if (myShape.bot2Part.endTypeRB == 1)
			{
			p =
					this.getIntersectionLineArc(
							myShape.bot2Part.bkgrdStartX,
							myShape.bot2Part.bkgrdStartY, //
							myShape.bot2Part.bkgrdWidth,
							myShape.bot2Part.bkgrdHeight, //
							myShape.bot2Part.startAngle,
							myShape.bot2Part.endAngle, //
							myShape.bot2Part.x1,
							myShape.bot2Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,

							1,
							true);
			myShape.bot1Part.endXC = myShape.bot2Part.startXC;
			myShape.bot1Part.endYC =
					myShape.bot2Part.startYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot2Part.bkgrdStartXBA,
							myShape.bot2Part.bkgrdStartYBA, //
							myShape.bot2Part.bkgrdWidthBA,
							myShape.bot2Part.bkgrdHeightBA, //
							myShape.bot2Part.startAngleBA,
							myShape.bot2Part.endAngleBA, //
							myShape.bot2Part.x1,
							myShape.bot2Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							true);
			myShape.bot1Part.endXBA = myShape.bot2Part.startXBA;
			// myShape.bot2Part.startXBA =
// (double)
			// p.getX();
			myShape.bot1Part.endYBA =
					myShape.bot2Part.startYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot2Part.bkgrdStartXA,
							myShape.bot2Part.bkgrdStartYA, //
							myShape.bot2Part.bkgrdWidthA,
							myShape.bot2Part.bkgrdHeightA, //
							myShape.bot2Part.startAngleA,
							myShape.bot2Part.endAngleA, //
							myShape.bot2Part.x1,
							myShape.bot2Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,

							1,
							true);

			myShape.bot1Part.endXA = myShape.bot2Part.startXA;
			// myShape.bot2Part.startXA =
// (double)
			// p.getX();
			myShape.bot1Part.endYA =
					myShape.bot2Part.startYA = (double) p.getY();
			}

		if (myShape.bot2Part.endTypeRB == 2)
			{
			p =
					this.getIntersectionLineArc(
							myShape.bot2Part.bkgrdStartX,
							myShape.bot2Part.bkgrdStartY, //
							myShape.bot2Part.bkgrdWidth,
							myShape.bot2Part.bkgrdHeight, //
							myShape.bot2Part.startAngle,
							myShape.bot2Part.endAngle, //
							myShape.bot2Part.x1,
							myShape.bot2Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,

							1,
							true);

			myShape.bot2Part.startYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot2Part.bkgrdStartXBA,
							myShape.bot2Part.bkgrdStartYBA, //
							myShape.bot2Part.bkgrdWidthBA,
							myShape.bot2Part.bkgrdHeightBA, //
							myShape.bot2Part.startAngleBA,
							myShape.bot2Part.endAngleBA, //
							myShape.bot2Part.x1,
							myShape.bot2Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,

							1,
							true);

			myShape.bot2Part.startYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot2Part.bkgrdStartXA,
							myShape.bot2Part.bkgrdStartYA, //
							myShape.bot2Part.bkgrdWidthA,
							myShape.bot2Part.bkgrdHeightA, //
							myShape.bot2Part.startAngleA,
							myShape.bot2Part.endAngleA, //
							myShape.bot2Part.x1,
							myShape.bot2Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,

							1,
							true);

			myShape.bot2Part.startYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot2Part.bkgrdStartXBA,
							myShape.bot2Part.bkgrdStartYBA, //
							myShape.bot2Part.bkgrdWidthBA,
							myShape.bot2Part.bkgrdHeightBA, //
							myShape.bot2Part.startAngleBA,
							myShape.bot2Part.endAngleBA, //
							myShape.bot2Part.x1,
							myShape.bot2Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,

							1,
							true);

			myShape.bot1Part.endYC = (double) p.getY();
			myShape.bot2Part.startXC = myShape.bot1Part.endXC;

			p =
					this.getIntersectionLineArc(
							myShape.bot2Part.bkgrdStartXBA,
							myShape.bot2Part.bkgrdStartYBA, //
							myShape.bot2Part.bkgrdWidthBA,
							myShape.bot2Part.bkgrdHeightBA, //
							myShape.bot2Part.startAngleBA,
							myShape.bot2Part.endAngleBA, //
							myShape.bot2Part.x1,
							myShape.bot2Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							true);

			myShape.bot1Part.endYBA = (double) p.getY();
			myShape.bot2Part.startXBA = myShape.bot1Part.endXC;

			p =
					this.getIntersectionLineArc(
							myShape.bot2Part.bkgrdStartXBA,
							myShape.bot2Part.bkgrdStartYBA, //
							myShape.bot2Part.bkgrdWidthBA,
							myShape.bot2Part.bkgrdHeightBA, //
							myShape.bot2Part.startAngleBA,
							myShape.bot2Part.endAngleBA, //
							myShape.bot2Part.x1,
							myShape.bot2Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,

							1,
							true);

			myShape.bot1Part.endYA = (double) p.getY();

			}

		if (myShape.bot2Part.endTypeRB == 3)
			{
			p =
					this.getIntersectionLineArc(
							myShape.bot2Part.bkgrdStartX,
							myShape.bot2Part.bkgrdStartY, //
							myShape.bot2Part.bkgrdWidth,
							myShape.bot2Part.bkgrdHeight, //
							myShape.bot2Part.startAngle,
							myShape.bot2Part.endAngle, //
							myShape.bot2Part.x1,
							myShape.bot2Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							true);

			myShape.bot2Part.startYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot2Part.bkgrdStartXBA,
							myShape.bot2Part.bkgrdStartYBA, //
							myShape.bot2Part.bkgrdWidthBA,
							myShape.bot2Part.bkgrdHeightBA, //
							myShape.bot2Part.startAngleBA,
							myShape.bot2Part.endAngleBA, //
							myShape.bot2Part.x1,
							myShape.bot2Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							true);

			myShape.bot2Part.startYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot2Part.bkgrdStartXA,
							myShape.bot2Part.bkgrdStartYA, //
							myShape.bot2Part.bkgrdWidthA,
							myShape.bot2Part.bkgrdHeightA, //
							myShape.bot2Part.startAngleA,
							myShape.bot2Part.endAngleA, //
							myShape.bot2Part.x1,
							myShape.bot2Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							true);

			myShape.bot2Part.startYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot2Part.bkgrdStartX,
							myShape.bot2Part.bkgrdStartY, //
							myShape.bot2Part.bkgrdWidth,
							myShape.bot2Part.bkgrdHeight, //
							myShape.bot2Part.startAngle,
							myShape.bot2Part.endAngle, //
							myShape.bot2Part.x1,
							myShape.bot2Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,

							1,
							true);

			myShape.bot1Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot2Part.bkgrdStartX,
							myShape.bot2Part.bkgrdStartY, //
							myShape.bot2Part.bkgrdWidth,
							myShape.bot2Part.bkgrdHeight, //
							myShape.bot2Part.startAngle,
							myShape.bot2Part.endAngle, //
							myShape.bot2Part.x1,
							myShape.bot2Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							true);

			myShape.bot1Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot2Part.bkgrdStartXA,
							myShape.bot2Part.bkgrdStartYA, //
							myShape.bot2Part.bkgrdWidthA,
							myShape.bot2Part.bkgrdHeightA, //
							myShape.bot2Part.startAngleA,
							myShape.bot2Part.endAngleA, //
							myShape.bot2Part.x1,
							myShape.bot2Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,

							1,
							true);

			myShape.bot1Part.endYA = (double) p.getY();

			myShape.bot1Part.stopAeX = myShape.bot2Part.startXA;
			myShape.bot1Part.stopAeY = myShape.bot2Part.startYA;

			}
		return myShape;
		}

	public ShapeObject doArcIntersectionsB3B1(
			final ShapeObject myShape)
		{

		Point2D p = new Point2D.Double();

		if (myShape.bot3Part.endTypeLT == 1)
			{
			p =
					this.getIntersectionLineArc(
							myShape.bot3Part.bkgrdStartX,
							myShape.bot3Part.bkgrdStartY, //
							myShape.bot3Part.bkgrdWidth,
							myShape.bot3Part.bkgrdHeight, //
							myShape.bot3Part.startAngle,
							myShape.bot3Part.endAngle, //
							myShape.bot3Part.x1,
							myShape.bot3Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,
							1,
							false);
			myShape.bot1Part.startXC = myShape.bot3Part.endXC;
			myShape.bot1Part.startYC =
					myShape.bot3Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot3Part.bkgrdStartXBA,
							myShape.bot3Part.bkgrdStartYBA, //
							myShape.bot3Part.bkgrdWidthBA,
							myShape.bot3Part.bkgrdHeightBA, //
							myShape.bot3Part.startAngleBA,
							myShape.bot3Part.endAngleBA, //
							myShape.bot3Part.x1,
							myShape.bot3Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,
							1,
							false);
			myShape.bot1Part.startXBA = myShape.bot3Part.endXBA;

			myShape.bot1Part.startYBA =
					myShape.bot3Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot3Part.bkgrdStartXA,
							myShape.bot3Part.bkgrdStartYA, //
							myShape.bot3Part.bkgrdWidthA,
							myShape.bot3Part.bkgrdHeightA, //
							myShape.bot3Part.startAngleA,
							myShape.bot3Part.endAngleA, //
							myShape.bot3Part.x1,
							myShape.bot3Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,
							1,
							false);

			myShape.bot1Part.startXA = myShape.bot3Part.endXA;

			myShape.bot1Part.startYA =
					myShape.bot3Part.endYA = (double) p.getY();
			}

		if (myShape.bot3Part.endTypeLT == 2)
			{
			p =
					this.getIntersectionLineArc(
							myShape.bot3Part.bkgrdStartX,
							myShape.bot3Part.bkgrdStartY, //
							myShape.bot3Part.bkgrdWidth,
							myShape.bot3Part.bkgrdHeight, //
							myShape.bot3Part.startAngle,
							myShape.bot3Part.endAngle, //
							myShape.bot3Part.x1,
							myShape.bot3Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,
							1,
							false);

			myShape.bot3Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot3Part.bkgrdStartXBA,
							myShape.bot3Part.bkgrdStartYBA, //
							myShape.bot3Part.bkgrdWidthBA,
							myShape.bot3Part.bkgrdHeightBA, //
							myShape.bot3Part.startAngleBA,
							myShape.bot3Part.endAngleBA, //
							myShape.bot3Part.x1,
							myShape.bot3Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,
							1,
							false);

			myShape.bot3Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot3Part.bkgrdStartXA,
							myShape.bot3Part.bkgrdStartYA, //
							myShape.bot3Part.bkgrdWidthA,
							myShape.bot3Part.bkgrdHeightA, //
							myShape.bot3Part.startAngleA,
							myShape.bot3Part.endAngleA, //
							myShape.bot3Part.x1,
							myShape.bot3Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,
							1,
							false);

			myShape.bot3Part.endYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot3Part.bkgrdStartXBA,
							myShape.bot3Part.bkgrdStartYBA, //
							myShape.bot3Part.bkgrdWidthBA,
							myShape.bot3Part.bkgrdHeightBA, //
							myShape.bot3Part.startAngleBA,
							myShape.bot3Part.endAngleBA, //
							myShape.bot3Part.x1,
							myShape.bot3Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,

							1,
							false);

			myShape.bot1Part.startYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot3Part.bkgrdStartXBA,
							myShape.bot3Part.bkgrdStartYBA, //
							myShape.bot3Part.bkgrdWidthBA,
							myShape.bot3Part.bkgrdHeightBA, //
							myShape.bot3Part.startAngleBA,
							myShape.bot3Part.endAngleBA, //
							myShape.bot3Part.x1,
							myShape.bot3Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							false);

			myShape.bot1Part.startYBA = (double) p.getY();
			myShape.bot3Part.endXC = myShape.bot1Part.startXC;
			myShape.bot3Part.endXBA = myShape.bot1Part.startXC;

			p =
					this.getIntersectionLineArc(
							myShape.bot3Part.bkgrdStartXBA,
							myShape.bot3Part.bkgrdStartYBA, //
							myShape.bot3Part.bkgrdWidthBA,
							myShape.bot3Part.bkgrdHeightBA, //
							myShape.bot3Part.startAngleBA,
							myShape.bot3Part.endAngleBA, //
							myShape.bot3Part.x1,
							myShape.bot3Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,

							1,
							false);

			myShape.bot1Part.startYA = (double) p.getY();

			}

		if (myShape.bot3Part.endTypeLT == 3)
			{
			p =
					this.getIntersectionLineArc(
							myShape.bot3Part.bkgrdStartX,
							myShape.bot3Part.bkgrdStartY, //
							myShape.bot3Part.bkgrdWidth,
							myShape.bot3Part.bkgrdHeight, //
							myShape.bot3Part.startAngle,
							myShape.bot3Part.endAngle, //
							myShape.bot3Part.x1,
							myShape.bot3Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,
							1,
							false);

			myShape.bot3Part.endYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot3Part.bkgrdStartXBA,
							myShape.bot3Part.bkgrdStartYBA, //
							myShape.bot3Part.bkgrdWidthBA,
							myShape.bot3Part.bkgrdHeightBA, //
							myShape.bot3Part.startAngleBA,
							myShape.bot3Part.endAngleBA, //
							myShape.bot3Part.x1,
							myShape.bot3Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,
							1,
							false);

			myShape.bot3Part.endYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot3Part.bkgrdStartXA,
							myShape.bot3Part.bkgrdStartYA, //
							myShape.bot3Part.bkgrdWidthA,
							myShape.bot3Part.bkgrdHeightA, //
							myShape.bot3Part.startAngleA,
							myShape.bot3Part.endAngleA, //
							myShape.bot3Part.x1,
							myShape.bot3Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,
							1,
							false);

			myShape.bot3Part.endYA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot3Part.bkgrdStartX,
							myShape.bot3Part.bkgrdStartY, //
							myShape.bot3Part.bkgrdWidth,
							myShape.bot3Part.bkgrdHeight, //
							myShape.bot3Part.startAngle,
							myShape.bot3Part.endAngle, //
							myShape.bot3Part.x1,
							myShape.bot3Part.y1,
							myShape.bot1Part.startXC,
							myShape.bot1Part.startYC,
							myShape.bot1Part.endXC,
							myShape.bot1Part.endYC,

							1,
							false);

			myShape.bot1Part.startYC = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot3Part.bkgrdStartX,
							myShape.bot3Part.bkgrdStartY, //
							myShape.bot3Part.bkgrdWidth,
							myShape.bot3Part.bkgrdHeight, //
							myShape.bot3Part.startAngle,
							myShape.bot3Part.endAngle, //
							myShape.bot3Part.x1,
							myShape.bot3Part.y1,
							myShape.bot1Part.startXBA,
							myShape.bot1Part.startYBA,
							myShape.bot1Part.endXBA,
							myShape.bot1Part.endYBA,

							1,
							false);

			myShape.bot1Part.startYBA = (double) p.getY();

			p =
					this.getIntersectionLineArc(
							myShape.bot3Part.bkgrdStartXA,
							myShape.bot3Part.bkgrdStartYA, //
							myShape.bot3Part.bkgrdWidthA,
							myShape.bot3Part.bkgrdHeightA, //
							myShape.bot3Part.startAngleA,
							myShape.bot3Part.endAngleA, //
							myShape.bot3Part.x1,
							myShape.bot3Part.y1,
							myShape.bot1Part.startXA,
							myShape.bot1Part.startYA,
							myShape.bot1Part.endXA,
							myShape.bot1Part.endYA,

							1,
							false);

			myShape.bot1Part.startYA = (double) p.getY();

			myShape.bot1Part.stopAsX = myShape.bot3Part.endXA;
			myShape.bot1Part.stopAsY = myShape.bot3Part.endYA;

			}
		return myShape;
		}

	public Point2D getIntersectionLineArc(
	//
			final double bsX,
			final double bsY, //
			final double w,
			final double h, //
			final double sA,
			final double eA, //
			final double cX,
			final double cY,
			final double sX,
			final double sY,
			final double eX,
			final double eY,
			final int pos,
			final boolean isP)
		{

		Point2D myP = new Point2D.Double();

		if (pos == 1)
			{// Top Part

			final Point2D myPs = new Point2D.Double(sX, sY);
			final Point2D myPe = new Point2D.Double(eX, eY);

			myP =
					this.getLineCircleIntersection(
							bsX,
							bsY,
							w,
							h,
							cX,
							cY,
							myPs,
							myPe,
							isP);
			}

		return myP;

		}

	public Point2D getLineCircleIntersection(
			final double bsX,
			final double bsY,
			final double wW,
			final double hH,
			final double centerX,
			final double centerY,
			final Point2D source,
			final Point2D p,
			final boolean isP)
		{

		// final Rectangle2D r = view.getBounds2D();

		final double a = wW / 2;// r.getWidth() +
// 1;/// 2;
		final double b = hH / 2;// r.getHeight() +
// 1;// / 2;

		// x0,y0 - center of ellipse
		final double x0 = centerX;// view.getCenterX();//x
// +
		// a;
		final double y0 = centerY;// view.getCenterY();//y
// +
		// b;

		// x1, y1 - point

		double x1 = 0; // was p
		double y1 = 0;
		if (!isP)
			{
			x1 = source.getX(); // was p
			y1 = source.getY();
			}
		else
			{
			x1 = p.getX();
			y1 = p.getY();
			}

		// Calculates straight line equation through
// point
		// and ellipse center
		// y = d * x + h
		final double dx = x1 - x0;
		final double dy = y1 - y0;

		if (dx == 0)
			{
			return new Point2D.Double((double) x0, (double) (y0 + b
					* dy
					/ Math.abs(dy)));
			}

		final double d = dy / dx;
		final double h = y0 - d * x0;

		// Calculates intersection
		final double e = a * a * d * d + b * b;
		final double f = -2 * x0 * e;
		final double g =
				a
						* a
						* d
						* d
						* x0
						* x0
						+ b
						* b
						* x0
						* x0
						- a
						* a
						* b
						* b;

		final double det = Math.sqrt(f * f - 4 * e * g);

		// Two solutions (perimeter points)
		final double xout1 = (-f + det) / (2 * e);
		final double xout2 = (-f - det) / (2 * e);
		final double yout1 = d * xout1 + h;
		final double yout2 = d * xout2 + h;

		final double dist1 =
				Math.sqrt(Math.pow((xout1 - x1), 2)
						+ Math.pow((yout1 - y1), 2));
		final double dist2 =
				Math.sqrt(Math.pow((xout2 - x1), 2)
						+ Math.pow((yout2 - y1), 2));

		// Correct solution
		double xout, yout;

		if (dist1 < dist2)
			{
			xout = xout1;
			yout = yout1;
			}
		else
			{
			xout = xout2;
			yout = yout2;
			}

		return new Point2D.Double((double) xout, (double) yout);
		}

	public double[] getArchesAngles(
			final double sX,
			final double eX,
			final double sY,
			final double eY,
			final double radius,
			final double x1,
			final double y1,
			final boolean useYL,
			final boolean useYR)
		{

		final double[] myAngles = new double[4];
		double startAngle = 0;
		double endAngle = 0;
		double extentAngle = 0;
		double baseR = 0;
		double baseL = 0;
		double hR = 0;
		double hL = 0;
		double yS = 0;
		double yE = 0;
		if (!useYR)
			{
			if (x1 > sX && x1 < eX)
				{
				baseR = eX - x1;

				startAngle =
						Math.abs((double) Math.toDegrees(Math
								.acos(baseR / radius)));

				hR =
						(double) (radius * Math.sin(Math
								.toRadians(startAngle)));

				yE = y1 - hR;

				}
			else if (x1 > eX)
				{
				baseR = x1 - eX;

				startAngle =
						180 - Math.abs((double) Math.toDegrees(Math
								.acos(baseR / radius)));

				hR =
						(double) (radius * Math.sin(Math
								.abs((double) Math.acos(baseR
										/ radius))));

				yE = y1 - hR;

				}
			else if (x1 < sX)
				{
				baseR = eX - x1;

				startAngle =
						Math.abs((double) Math.toDegrees(Math
								.acos(baseR / radius)));

				hR =
						(double) (radius * Math.sin(Math
								.toRadians(startAngle)));

				yE = y1 - hR;

				}
			}
		else
			{
			if (x1 > sX && x1 < eX)
				{
				baseR = eX - x1;

				hR = y1 - eY;

				startAngle =
						Math.abs((double) Math.toDegrees(Math.atan(hR
								/ baseR)));

				yE = eY;

				}
			else if (x1 > eX)
				{
				baseR = x1 - eX;

				hR = y1 - eY;

				startAngle =
						180 - Math.abs((double) Math.toDegrees(Math
								.atan(hR / baseR)));

				yE = eY;

				}
			else if (x1 < sX)
				{
				baseR = eX - x1;
				hR = y1 - eY;
				startAngle =
						Math.abs((double) Math.toDegrees(Math.atan(hR
								/ baseR)));

				yE = eY;

				}
			}

		// endAngles Start Here

		if (!useYL)
			{
			if (x1 > sX && x1 < eX)
				{

				baseL = x1 - sX;

				endAngle =
						Math.abs((double) Math.toDegrees(Math
								.acos(baseL / radius)));
				// extentAngle = 180 -
// (endAngle +
				// startAngle);

				hL =
						(double) (radius * Math.sin(Math
								.toRadians(endAngle)));

				yS = y1 - hL;

				}
			else if (x1 > eX)
				{

				baseL = x1 - sX;

				endAngle =
						Math.abs((double) Math.toDegrees(Math
								.acos(baseL / radius)));
				// extentAngle = 180 -
// (endAngle +
				// startAngle);

				hL =
						(double) (radius * Math.sin(Math
								.toRadians(endAngle)));

				yS = y1 - hL;

				}
			else if (x1 < sX)
				{

				baseL = sX - x1;

				endAngle =
						Math.abs((double) Math.toDegrees(Math
								.acos(baseL / radius)));
				// extentAngle = endAngle -
// startAngle;

				hL =
						(double) (radius * Math.sin(Math
								.toRadians(endAngle)));

				yS = y1 - hL;
				}
			}
		else
			{
			if (x1 > sX && x1 < eX)
				{

				baseL = x1 - sX;

				hL = y1 - sY;

				endAngle =
						Math.abs((double) Math.toDegrees(Math.atan(hL
								/ baseL)));
				// extentAngle = 180 -
// (endAngle +
				// startAngle);

				yS = sY;

				}
			else if (x1 > eX)
				{

				baseL = x1 - sX;
				hL = y1 - sY;
				endAngle =
						Math.abs((double) Math.toDegrees(Math.atan(hL
								/ baseL)));
				// extentAngle = 180 -
// (endAngle +
				// startAngle);

				yS = sY;

				}
			else if (x1 < sX)
				{

				baseL = sX - x1;
				hL = y1 - sY;

				endAngle =
						Math.abs((double) Math.toDegrees(Math.atan(hL
								/ baseL)));
				// extentAngle = endAngle -
// startAngle;

				yS = sY;
				}
			}

		if (x1 > sX && x1 < eX)
			{
			extentAngle = 180 - (endAngle + startAngle);
			}
		else if (x1 > eX)
			{
			extentAngle = 180 - (endAngle + startAngle);
			}
		else if (x1 < sX)
			{
			extentAngle = endAngle - startAngle;
			}

		myAngles[0] = startAngle;
		myAngles[1] = extentAngle;
		myAngles[2] = yS;
		myAngles[3] = yE;

		return myAngles;

		// top2
		}
	//
	// public void getPointsArc(final Arc2D arc) {
	// final double flatness = 0.000001f;
	// final PathIterator pit =
// arc.getPathIterator(null,
	// flatness);
	// final double[] coords = new double[6];
	// int count = 0;
	// double myX=0;
	// double myY=0;
	// while (!pit.isDone()) {
	// final int type = pit.currentSegment(coords);
	// switch (type) {
	//
	// case PathIterator.SEG_MOVETO:
	// myX = coords[0];
	// myY = coords[1];
	// xCoordB.add(myX);
	// yCoordB.add(myY);
	// count++;
	// break;
	//
	// case PathIterator.SEG_LINETO:
	// if (coords[0] > 0) {
	// myX = coords[0];
	// myY = coords[1];
	//
	// xCoordB.add(myX);
	// yCoordB.add(myY);
	//
	// }
	// count++;
	// break;
	// default:
	// System.out.println("unexpected type: "
	// + type);
	// }
	// pit.next();
	// }
	// }
	//
	// public void getPoints(final Arc2D arc,
	// final int topBot, final double startX) {
	// final double flatness = 0.000001f;
	// final PathIterator pit =
// arc.getPathIterator(null,
	// flatness);
	// final double[] coords = new double[6];
	// int count = 0;
	// double myX=0;
	// double myY=0;
	// while (!pit.isDone()) {
	// final int type = pit.currentSegment(coords);
	// switch (type) {
	//
	// case PathIterator.SEG_MOVETO:
	// myX = coords[0];
	// myY = coords[1];
	// xCoordB.add(myX);
	// yCoordB.add(myY);
	// count++;
	// break;
	//
	// case PathIterator.SEG_LINETO:
	// if (coords[0] > 0) {
	// myX = coords[0];
	// myY = coords[1];
	// if (topBot == 1) {
	// if (myX >= startX) {
	//
	// xCoordB.add(myX);
	// yCoordB.add(myY);
	// }
	// }
	// else {
	// if (myX <= startX) {
	//
	// xCoordB.add(myX);
	// yCoordB.add(myY);
	// }
	// }
	// }
	// count++;
	// break;
	// default:
	// System.out.println("unexpected type: "
	// + type);
	// }
	// pit.next();
	// }
	// }
	//
	//

	}
