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
public class ShapeIDCalc
{
	
	public int shapeID = 0;
	
	public int lean = 0;
	
	public int lean2 = 0;
	
	public int lean3 = 0;
	
	public int lean4 = 0;
	
	public ShapeIDCalc()
	{
		
	}
	
	public void calc(ShapeObject o)
	{
		
		// shapeID = 1;
		if (o.noSides == 0
					&& o.noSidesTop == 0
					&& o.noSidesBot == 0
					&& o.noSidesLeft == 0
					&& o.noSidesRight == 0)
		{
			
			shapeID = 10;
		}
		
		else if (lean == 0
					&& lean2 == 2
					&& lean3 == 3
					&& lean4 == 1
					&& o.noSides == 5
					&& o.noSidesTop == 2
					&& o.noSidesBot == 1
					&& o.noSidesLeft == 1
					&& o.noSidesRight == 1)
		{
			
			shapeID = 90;
		}
		else if (lean == 0
					&& lean2 == 2
					&& lean3 == 3
					&& lean4 == 1
					&&
					
					o.noSides == 6
					&& o.noSidesTop == 3
					&& o.noSidesBot == 1
					&& o.noSidesLeft == 1
					&& o.noSidesRight == 1)
		{
			
			shapeID = 91;
		}
		else if (lean == 0
					&& lean2 == 3
					&& lean3 == 3
					&& lean4 == 3
					&&
					
					o.noSides == 8
					&& o.noSidesTop == 3
					&& o.noSidesBot == 3
					&& o.noSidesLeft == 1
					&& o.noSidesRight == 1)
		{
			
			shapeID = 93;
		}
		
		else if (lean == 0
					&& lean2 == 0
					&& lean3 == 0
					&& lean4 == 1
					&& o.noSides == 4)
		{
			
			shapeID = 100;
		}
		else if (lean == 0
					&& lean2 == 2
					&& lean3 == 0
					&& lean4 == 0
					&& o.noSides == 4)
		{
			
			shapeID = 101;
		}
		else if (lean == 2
					&& lean2 == 0
					&& lean3 == 0
					&& lean4 == 0
					&& o.noSides == 4)
		{
			
			shapeID = 102;
		}
		else if (lean == 1
					&& lean2 == 0
					&& lean3 == 0
					&& lean4 == 0
					&& o.noSides == 4)
		{
			
			shapeID = 103;
		}
		else if (lean == 0
					&& lean2 == 1
					&& lean3 == 0
					&& lean4 == 0
					&& o.noSides == 4)
		{
			
			shapeID = 104;
		}
		else if (lean == 0
					&& lean2 == 0
					&& lean3 == 0
					&& lean4 == 2
					&& o.noSides == 4)
		{
			
			shapeID = 105;
		}
		else if (lean == 0
					&& lean2 == 0
					&& lean3 == 2
					&& lean4 == 0
					&& o.noSides == 4)
		{
			
			shapeID = 106;
		}
		else if (lean == 0
					&& lean2 == 0
					&& lean3 == 1
					&& lean4 == 0
					&& o.noSides == 4)
		{
			
			shapeID = 107;
		}
		else if (lean == 1
					&& lean2 == 0
					&& lean3 == 1
					&& lean4 == 0
					&& o.noSides == 4)
		{
			
			shapeID = 108;
		}
		else if (lean == 2
					&& lean2 == 0
					&& lean3 == 2
					&& lean4 == 0
					&& o.noSides == 4)
		{
			
			shapeID = 109;
		}
		else if (lean == 0
					&& lean2 == 2
					&& lean3 == 0
					&& lean4 == 2
					&& o.noSides == 4)
		{
			
			shapeID = 110;
		}
		else if (lean == 0
					&& lean2 == 1
					&& lean3 == 0
					&& lean4 == 1
					&& o.noSides == 4)
		{
			
			shapeID = 111;
		}
		else if (lean == 3
					&& lean2 == 0
					&& lean3 == 0
					&& lean4 == 0
					&& o.noSides == 4)
		{
			
			shapeID = 112;
		}
		else if (lean == 0
					&& lean2 == 3
					&& lean3 == 0
					&& lean4 == 0
					&& o.noSides == 4)
		{
			
			shapeID = 113;
		}
		else if (lean == 0
					&& lean2 == 0
					&& lean3 == 3
					&& lean4 == 0
					&& o.noSides == 4)
		{
			
			shapeID = 114;
		}
		else if (lean == 0
					&& lean2 == 0
					&& lean3 == 0
					&& lean4 == 3
					&& o.noSides == 4)
		{
			
			shapeID = 115;
		}
		else if (lean == 0
					&& lean2 == 2
					&& lean3 == 0
					&& lean4 == 1
					&&
					
					o.noSides == 5
					&& o.noSidesTop == 2
					&& o.noSidesBot == 1
					&& o.noSidesLeft == 1
					&& o.noSidesRight == 1)
		{
			
			shapeID = 150;
		}
		else if (lean == 0
					&& lean2 == 0
					&& lean3 == 0
					&& lean4 == 1
					&&
					
					o.noSides == 5
					&& o.noSidesTop == 2
					&& o.noSidesBot == 1
					&& o.noSidesLeft == 1
					&& o.noSidesRight == 1)
		{
			
			shapeID = 154;
		}
		else if (lean == 0
					&& lean2 == 2
					&& lean3 == 0
					&& lean4 == 0
					&&
					
					o.noSides == 5
					&& o.noSidesTop == 2
					&& o.noSidesBot == 1
					&& o.noSidesLeft == 1
					&& o.noSidesRight == 1)
		{
			
			shapeID = 155;
		}
		else if (lean == 0
					&& lean2 == 2
					&& lean3 == 0
					&& lean4 == 1
					&&
					
					o.noSides == 6
					&& o.noSidesTop == 3
					&& o.noSidesBot == 1
					&& o.noSidesLeft == 1
					&& o.noSidesRight == 1)
		{
			
			shapeID = 160;
		}
		
		else if (lean == 0
					&& lean2 == 2
					&& lean3 == 0
					&& lean4 == 1
					&&
					
					o.noSides == 4
					&& o.noSidesTop == 1
					&& o.noSidesBot == 1
					&& o.noSidesLeft == 1
					&& o.noSidesRight == 1
					&& o.top1Part.partForm == 2
					&& o.top1Part.startYC == o.top1Part.endYC)
		{
			
			shapeID = 300;
		}
		else if (lean == 0
					&& lean2 == 0
					&& lean3 == 0
					&& lean4 == 1
					&&
					
					o.noSides == 4
					&& o.noSidesTop == 1
					&& o.noSidesBot == 1
					&& o.noSidesLeft == 1
					&& o.noSidesRight == 1
					&& o.top1Part.partForm == 2
					&& o.top1Part.startYC > o.top1Part.endYC)
		{
			
			shapeID = 301;
		}
		else if (lean == 0
					&& lean2 == 2
					&& lean3 == 0
					&& lean4 == 0
					&&
					
					o.noSides == 4
					&& o.noSidesTop == 1
					&& o.noSidesBot == 1
					&& o.noSidesLeft == 1
					&& o.noSidesRight == 1
					&& o.top1Part.partForm == 2
					&& o.top1Part.startYC < o.top1Part.endYC)
		{
			
			shapeID = 302;
		}
		
		else if (lean == 0
					&& lean2 == 2
					&& lean3 == 0
					&& lean4 == 1
					&&
					
					o.noSides == 2
					&& o.noSidesTop == 1
					&& o.noSidesBot == 1
					&& o.noSidesLeft == 0
					&& o.noSidesRight == 0)
		{
			
			shapeID = 303;
		}
		else if (lean == 0
					&& lean2 == 0
					&& lean3 == 0
					&& lean4 == 1
					&&
					
					o.noSides == 3
					&& o.noSidesTop == 1
					&& o.noSidesBot == 1
					&& o.noSidesLeft == 0
					&& o.noSidesRight == 1
					&& o.top1Part.partForm == 2
					&& o.top1Part.startYC > o.top1Part.endYC)
		{
			
			shapeID = 304;
		}
		else if (lean == 0
					&& lean2 == 2
					&& lean3 == 0
					&& lean4 == 0
					&&
					
					o.noSides == 3
					&& o.noSidesTop == 1
					&& o.noSidesBot == 1
					&& o.noSidesLeft == 1
					&& o.noSidesRight == 0
					&& o.top1Part.partForm == 2
					&& o.top1Part.startYC < o.top1Part.endYC)
		{
			
			shapeID = 305;
		}
		else
		{
			shapeID = 1;
		}
		
		// case 400:
		// lean == 0 &&
		// lean2 = 2 &&
		// lean3 == 0 &&
		// lean4 = 1 &&
		// break &&
		// case 401:
		// lean == 0 &&
		// lean2 == 0 &&
		// lean3 == 0 &&
		// lean4 = 1 &&
		// break &&
		// case 402:
		// lean == 0 &&
		// lean2 = 2 &&
		// lean3 == 0 &&
		// lean4 == 0 &&
		// break &&
		// case 450:
		// lean == 0 &&
		// lean2 = 2 &&
		// lean3 == 0 &&
		// lean4 = 1 &&
		// break &&
		// case 451:
		// lean == 0 &&
		// lean2 = 2 &&
		// lean3 == 0 &&
		// lean4 = 1 &&
		// break &&
		// case 452:
		// lean == 0 &&
		// lean2 = 2 &&
		// lean3 == 0 &&
		// lean4 = 1 &&
		// break &&
		// case 453:
		// lean == 0 &&
		// lean2 = 2 &&
		// lean3 == 0 &&
		// lean4 = 1 &&
		// break &&
		// case 454:
		// lean == 0 &&
		// lean2 = 2 &&
		// lean3 == 0 &&
		// lean4 = 1 &&
		// break &&
		// case 455:
		// lean == 0 &&
		// lean2 = 2 &&
		// lean3 == 0 &&
		// lean4 = 1 &&
		// break &&
		// case 456:
		// lean == 0 &&
		// lean2 = 2 &&
		// lean3 == 0 &&
		// lean4 = 1 &&
		// break &&
		// case 457:
		// lean == 0 &&
		// lean2 = 2 &&
		// lean3 == 0 &&
		// lean4 = 1 &&
		// break &&
		// case 458:
		// lean == 0 &&
		// lean2 = 2 &&
		// lean3 == 0 &&
		// lean4 = 1 &&
		// break &&
		// case 459:
		// lean == 0 &&
		// lean2 = 2 &&
		// lean3 == 0 &&
		// lean4 = 1 &&
		// break &&
		// case 460:
		// lean == 0 &&
		// lean2 = 2 &&
		// lean3 == 0 &&
		// lean4 = 1 &&
		// break &&
		// case 461:
		// lean == 0 &&
		// lean2 = 2 &&
		// lean3 == 0 &&
		// lean4 = 1 &&
		// break &&
		// case 700:
		// lean == 0 &&
		// lean2 == 0 &&
		// lean3 == 0 &&
		// lean4 = 1 &&
		// break &&
		// case 701:
		// lean == 0 &&
		// lean2 = 2 &&
		// lean3 == 0 &&
		// lean4 == 0 &&
		// break &&
		// case 702:
		// lean == 0 &&
		// lean2 == 0 &&
		// lean3 == 0 &&
		// lean4 = 3 &&
		// break &&
		// case 703:
		// lean == 0 &&
		// lean2 = 3 &&
		// lean3 == 0 &&
		// lean4 == 0 &&
		// break &&
		// case 704:
		// lean = 3 &&
		// lean2 = 1 &&
		// lean3 == 0 &&
		// lean4 = 2 &&
		// break &&
		// case 705:
		// lean == 0 &&
		// lean2 == 0 &&
		// lean3 == 0 &&
		// lean4 = 2 &&
		// break &&
		// case 706:
		// lean == 0 &&
		// lean2 = 1 &&
		// lean3 == 0 &&
		// lean4 == 0 &&
		// break &&
		// case 800:
		// lean == 0 &&
		// lean2 == 0 &&
		// lean3 == 0 &&
		// lean4 == 0 &&
		// break &&
		// case 801:
		// lean == 0 &&
		// lean2 == 0 &&
		// lean3 == 0 &&
		// lean4 == 0 &&
		// break &&
		// case 802:
		// lean == 0 &&
		// lean2 == 0 &&
		// lean3 == 0 &&
		// lean4 == 0 &&
		// break &&
		
	}
	
}
