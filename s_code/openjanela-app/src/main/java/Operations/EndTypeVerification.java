/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 * 
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Operations;


import javax.swing.JOptionPane;

import Model.Frame;


public class EndTypeVerification
	{

	Frame myParent;

	boolean done = false;

	boolean check = true;

	boolean top1LT = true;

	boolean top1RB = true;

	boolean top2LT = true;

	boolean top2RB = true;

	boolean top3LT = true;

	boolean top3RB = true;

	boolean bot1LT = true;

	boolean bot1RB = true;

	boolean bot2LT = true;

	boolean bot2RB = true;

	boolean bot3LT = true;

	boolean bot3RB = true;

	boolean leftLT = true;

	boolean leftRB = true;

	boolean rightLT = true;

	boolean rightRB = true;

	public EndTypeVerification(final Frame myFrame)
		{

		this.myParent = myFrame;
		this.done = false;
		this.top1LT = true;
		this.top1RB = true;
		this.top2LT = true;
		this.top2RB = true;
		this.top3LT = true;
		this.top3RB = true;
		this.bot1LT = true;
		this.bot1RB = true;
		this.bot2LT = true;
		this.bot2RB = true;
		this.bot3LT = true;
		this.bot3RB = true;
		this.leftLT = true;
		this.leftRB = true;
		this.rightLT = true;
		this.rightRB = true;
		this.checkEndTypes();
		}

	public void checkEndTypes()
		{

		if (!this.done)
			{
			if (this.myParent.shapeID >= 90 && this.myParent.shapeID <= 99
					|| this.myParent.shapeID == 300 && this.myParent.dimB1 == this.myParent.widthPix / 2)
				{
				this.myParent.top1.endTypeRB = 1;
				this.myParent.top1.endTypeLT = 1;
				this.myParent.top2.endTypeRB = 1;
				this.myParent.top2.endTypeLT = 1;
				this.myParent.top3.endTypeRB = 1;
				this.myParent.top3.endTypeLT = 1;
				this.myParent.left.endTypeRB = 1;
				this.myParent.left.endTypeLT = 1;
				this.myParent.right.endTypeRB = 1;
				this.myParent.right.endTypeLT = 1;
				this.myParent.bot1.endTypeRB = 1;
				this.myParent.bot1.endTypeLT = 1;
				this.myParent.bot2.endTypeRB = 1;
				this.myParent.bot2.endTypeLT = 1;
				this.myParent.bot3.endTypeRB = 1;
				this.myParent.bot3.endTypeLT = 1;

				this.top1LT = false;
				this.top1RB = false;
				this.top2LT = false;
				this.top2RB = false;
				this.top3LT = false;
				this.top3RB = false;
				this.bot1LT = false;
				this.bot1RB = false;
				this.bot2LT = false;
				this.bot2RB = false;
				this.bot3LT = false;
				this.bot3RB = false;
				this.leftLT = false;
				this.leftRB = false;
				this.rightLT = false;
				this.rightRB = false;
				}
			if (this.myParent.shapeID == 200
					|| this.myParent.shapeID == 300 && this.myParent.dimB1 == this.myParent.widthPix / 2)
				{
				this.myParent.top1.endTypeRB = 3;
				this.myParent.top1.endTypeLT = 3;
				this.myParent.left.endTypeLT = 3;
				this.myParent.right.endTypeRB = 3;
				this.top1LT = true;
				this.top1RB = true;
				this.leftLT = true;
				this.rightRB = true;
				this.check = false;
				}
			if (this.myParent.shapeID == 201
					|| this.myParent.shapeID == 301 && this.myParent.dimD2 == this.myParent.widthPix)
				{
				this.myParent.top1.endTypeRB = 3;
				this.myParent.left.endTypeLT = 3;
				this.top1RB = true;
				this.leftLT = true;
				this.check = false;
				}
			if (this.myParent.shapeID == 202
					|| this.myParent.shapeID == 302 && this.myParent.dimB1 == this.myParent.widthPix)
				{
				this.myParent.top1.endTypeLT = 3;
				this.top1LT = true;
				this.myParent.right.endTypeRB = 3;
				this.rightRB = true;
				this.check = false;
				}
			if (this.myParent.shapeID >= 800)
				{
				this.myParent.top1.endTypeLT = 3;
				this.myParent.top1.endTypeRB = 3;
				this.top1LT = true;
				this.top1RB = true;

				this.check = false;
				}
			if (this.myParent.leftShape == 0
					&& this.myParent.lean4 == 3)
				{
				this.myParent.top1.endTypeRB = 1;
				this.myParent.bot1.endTypeLT = 1;
				this.top1RB = true;
				this.bot1LT = true;
				}
			if (this.myParent.rightShape == 0
					&& this.myParent.lean2 == 3)
				{
				this.myParent.top1.endTypeLT = 1;
				this.myParent.bot1.endTypeRB = 1;
				this.top1LT = true;
				this.bot1RB = true;
				}
			if (this.myParent.noSidesTop >= 3)
				{
				this.top3Parts();
				}
			else if (this.myParent.noSidesTop == 2)
				{
				this.top2Parts();
				}
			if (this.myParent.noSidesLeft == 0)
				{
				this.noLeftPart();
				}
			if (this.myParent.noSidesRight == 0)
				{
				this.noRightPart();
				}
			else if (this.check)
				{
				this.checkTop();
				this.checkRight();
				this.checkBot();
				this.checkLeft();
				}

			this.done = true;
			}

		}

	private void checkLeft()
		{

		if (this.myParent.left.endTypeRB == 1
				&& this.myParent.bot1.partDimB == this.myParent.left.partDimB
				&& this.bot1LT)
			{
			this.myParent.bot1.endTypeLT = 1;
			this.bot1LT = false;
			}
		else
			{
			if (this.myParent.left.endTypeRB == 1
					&& this.myParent.bot1.partDimB != this.myParent.left.partDimB)
				{
				JOptionPane.showMessageDialog(
						null,
						"Part Dimensions Error: Check Dim B!",
						"Warning",
						JOptionPane.WARNING_MESSAGE);
				return;

				}
			}

		if (this.myParent.left.endTypeLT == 1
				&& this.myParent.left.partDimB != this.myParent.top1.partDimB
				&& this.top1RB)
			{
			this.myParent.top1.endTypeRB = 1;
			this.top1RB = false;
			}
		else
			{
			if (this.myParent.left.endTypeLT == 1
					&& this.myParent.left.partDimB != this.myParent.top1.partDimB)
				{
				JOptionPane.showMessageDialog(
						null,
						"Part Dimensions Error: Check Dim B!",
						"Warning",
						JOptionPane.WARNING_MESSAGE);
				return;

				}
			}
		if (this.myParent.left.endTypeRB == 2
				&& this.myParent.bot1.endTypeLT != 3
				&& this.bot1LT)
			{
			JOptionPane
					.showMessageDialog(
							null,
							"End Type conflict in Rules, will attempt to correct if possible.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
			this.myParent.bot1.endTypeLT = 3;
			this.bot1LT = false;
			return;
			}
		if (this.myParent.left.endTypeRB == 3
				&& this.myParent.bot1.endTypeLT != 2
				&& this.bot1LT)
			{
			JOptionPane
					.showMessageDialog(
							null,
							"End Type conflict in Rules, will attempt to correct if possible.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
			this.myParent.bot1.endTypeLT = 2;
			this.bot1LT = false;
			return;
			}
		if (this.myParent.left.endTypeLT == 2
				&& this.myParent.top1.endTypeRB != 3
				&& this.top1RB)
			{
			JOptionPane
					.showMessageDialog(
							null,
							"End Type conflict in Rules, will attempt to correct if possible.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
			this.myParent.top1.endTypeRB = 3;
			this.top1RB = false;
			return;

			}
		if (this.myParent.left.endTypeRB == 3
				&& this.myParent.bot1.endTypeLT != 2
				&& this.bot1LT)
			{
			JOptionPane
					.showMessageDialog(
							null,
							"End Type conflict in Rules, will attempt to correct if possible.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
			this.myParent.bot1.endTypeLT = 2;
			this.bot1LT = false;
			return;
			}
		}

	private void checkBot()
		{

		if (this.myParent.bot1.endTypeRB == 1
				&& this.myParent.bot1.partDimB == this.myParent.right.partDimB
				&& this.rightLT)
			{
			this.myParent.right.endTypeLT = 1;
			this.rightLT = false;
			}
		else
			{
			if (this.myParent.bot1.endTypeRB == 1
					&& this.myParent.bot1.partDimB != this.myParent.right.partDimB)
				{
				JOptionPane.showMessageDialog(
						null,
						"Part Dimensions Error: Check Dim B!",
						"Warning",
						JOptionPane.WARNING_MESSAGE);
				return;

				}
			}

		if (this.myParent.bot1.endTypeLT == 1
				&& this.myParent.bot1.partDimB != this.myParent.left.partDimB
				&& this.leftRB)
			{
			this.myParent.left.endTypeRB = 1;
			this.leftRB = false;
			}
		else
			{
			if (this.myParent.bot1.endTypeLT == 1
					&& this.myParent.bot1.partDimB != this.myParent.left.partDimB)
				{
				JOptionPane.showMessageDialog(
						null,
						"Part Dimensions Error: Check Dim B!",
						"Warning",
						JOptionPane.WARNING_MESSAGE);
				return;

				}
			}
		if (this.myParent.bot1.endTypeRB == 2
				&& this.myParent.right.endTypeLT != 3
				&& this.rightLT)
			{
			JOptionPane
					.showMessageDialog(
							null,
							"End Type conflict in Rules, will attempt to correct if possible.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
			this.myParent.right.endTypeLT = 3;
			this.rightLT = false;
			return;
			}
		if (this.myParent.bot1.endTypeRB == 3
				&& this.myParent.right.endTypeLT != 2
				&& this.rightLT)
			{
			JOptionPane
					.showMessageDialog(
							null,
							"End Type conflict in Rules, will attempt to correct if possible.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
			this.myParent.right.endTypeLT = 2;
			this.rightLT = false;
			return;
			}
		if (this.myParent.bot1.endTypeLT == 2
				&& this.myParent.left.endTypeRB != 3
				&& this.leftRB)
			{
			JOptionPane
					.showMessageDialog(
							null,
							"End Type conflict in Rules, will attempt to correct if possible.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
			this.myParent.left.endTypeRB = 3;
			this.leftRB = false;
			return;
			}
		if (this.myParent.bot1.endTypeLT == 3
				&& this.myParent.left.endTypeRB != 2
				&& this.leftRB)
			{
			JOptionPane
					.showMessageDialog(
							null,
							"End Type conflict in Rules, will attempt to correct if possible.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
			this.myParent.left.endTypeRB = 2;
			this.leftRB = false;
			return;
			}
		}

	private void checkRight()
		{

		if (this.myParent.right.endTypeRB == 1
				&& this.myParent.top1.partDimB == this.myParent.right.partDimB
				&& this.top1LT)
			{
			this.myParent.top1.endTypeLT = 1;
			this.top1LT = false;
			}
		else
			{
			if (this.myParent.right.endTypeRB == 1
					&& this.myParent.top1.partDimB != this.myParent.right.partDimB)
				{
				JOptionPane.showMessageDialog(
						null,
						"Part Dimensions Error: Check Dim B!",
						"Warning",
						JOptionPane.WARNING_MESSAGE);
				return;

				}
			}

		if (this.myParent.right.endTypeLT == 1
				&& this.myParent.bot1.partDimB == this.myParent.right.partDimB
				&& this.bot1RB)
			{
			this.myParent.bot1.endTypeRB = 1;
			this.bot1RB = false;
			}
		else
			{
			if (this.myParent.right.endTypeLT == 1
					&& this.myParent.bot1.partDimB != this.myParent.right.partDimB)
				{
				JOptionPane.showMessageDialog(
						null,
						"Part Dimensions Error: Check Dim B!",
						"Warning",
						JOptionPane.WARNING_MESSAGE);
				return;

				}
			}

		if (this.myParent.right.endTypeRB == 2
				&& this.myParent.top1.endTypeLT != 3
				&& this.top1LT)
			{
			JOptionPane
					.showMessageDialog(
							null,
							"End Type conflict in Rules, will attempt to correct if possible.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
			this.myParent.top1.endTypeLT = 3;
			this.top1LT = false;
			return;
			}
		if (this.myParent.right.endTypeRB == 3
				&& this.myParent.top1.endTypeLT != 2
				&& this.top1LT)
			{
			JOptionPane
					.showMessageDialog(
							null,
							"End Type conflict in Rules, will attempt to correct if possible.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
			this.myParent.top1.endTypeLT = 2;
			this.top1LT = false;
			return;
			}
		if (this.myParent.right.endTypeLT == 2
				&& this.myParent.bot1.endTypeRB != 3
				&& this.bot1RB)
			{
			JOptionPane
					.showMessageDialog(
							null,
							"End Type conflict in Rules, will attempt to correct if possible.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
			this.myParent.bot1.endTypeRB = 3;
			this.bot1RB = false;
			return;
			}
		if (this.myParent.right.endTypeLT == 3
				&& this.myParent.bot1.endTypeRB != 2
				&& this.bot1RB)
			{
			JOptionPane
					.showMessageDialog(
							null,
							"End Type conflict in Rules, will attempt to correct if possible.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
			this.myParent.bot1.endTypeRB = 2;
			this.bot1RB = false;
			return;
			}
		}

	private void checkTop()
		{

		if (this.myParent.top1.endTypeRB == 1
				&& this.myParent.top1.partDimB == this.myParent.left.partDimB
				&& this.leftLT)
			{
			this.myParent.left.endTypeLT = 1;
			this.leftLT = false;
			}
		else
			{
			if (this.myParent.top1.endTypeRB == 1
					&& this.myParent.top1.partDimB != this.myParent.left.partDimB)
				{
				JOptionPane.showMessageDialog(
						null,
						"Part Dimensions Error: Check Dim B!",
						"Warning",
						JOptionPane.WARNING_MESSAGE);
				return;

				}
			}

		if (this.myParent.top1.endTypeLT == 1
				&& this.myParent.top1.partDimB == this.myParent.right.partDimB
				&& this.rightRB)
			{
			this.myParent.right.endTypeRB = 1;
			this.rightRB = false;
			}
		else
			{
			if (this.myParent.top1.endTypeLT == 1
					&& this.myParent.top1.partDimB != this.myParent.right.partDimB)
				{
				JOptionPane.showMessageDialog(
						null,
						"Part Dimensions Error: Check Dim B!",
						"Warning",
						JOptionPane.WARNING_MESSAGE);
				return;

				}
			}

		if (this.myParent.top1.endTypeRB == 2
				&& this.myParent.left.endTypeLT != 3
				&& this.leftLT)
			{

			JOptionPane
					.showMessageDialog(
							null,
							"End Type conflict in Rules, will attempt to correct if possible.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
			this.myParent.left.endTypeLT = 3;
			this.leftLT = false;
			return;
			}

		if (this.myParent.top1.endTypeRB == 3
				&& this.myParent.left.endTypeLT != 2
				&& this.leftLT)
			{
			JOptionPane
					.showMessageDialog(
							null,
							"End Type conflict in Rules, will attempt to correct if possible.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
			this.myParent.left.endTypeLT = 2;
			this.leftLT = false;
			return;
			}

		if (this.myParent.top1.endTypeLT == 2
				&& this.myParent.right.endTypeRB != 3
				&& this.rightRB)
			{
			JOptionPane
					.showMessageDialog(
							null,
							"End Type conflict in Rules, will attempt to correct if possible.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
			this.myParent.right.endTypeRB = 3;
			this.rightRB = false;
			return;
			}
		if (this.myParent.top1.endTypeLT == 3
				&& this.myParent.right.endTypeRB != 2
				&& this.rightRB)
			{
			JOptionPane
					.showMessageDialog(
							null,
							"End Type conflict in Rules, will attempt to correct if possible.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
			this.myParent.right.endTypeRB = 2;
			this.rightRB = false;
			return;
			}
		}

	private void noRightPart()
		{

		if (this.myParent.noSidesRight == 0)
			{

			if (this.myParent.top1.endTypeLT == 1
					&& this.myParent.top1.partDimB == this.myParent.bot1.partDimB
					&& this.bot1RB)
				{
				this.myParent.bot1.endTypeRB = 1;
				this.bot1RB = false;
				}
			else
				{
				if (this.myParent.top1.endTypeLT == 1
						&& this.myParent.top1.partDimB != this.myParent.bot1.partDimB)
					{
					JOptionPane.showMessageDialog(
							null,
							"Part Dimensions Error: Check Dim B!",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;

					}
				}
			if (this.myParent.top1.endTypeLT == 2
					&& this.myParent.bot1.endTypeRB != 3
					&& this.bot1RB)
				{
				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.bot1.endTypeRB = 3;
				this.bot1RB = false;
				return;
				}
			if (this.myParent.top1.endTypeLT == 3
					&& this.myParent.bot1.endTypeRB != 2
					&& this.bot1RB)
				{
				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.bot1.endTypeRB = 2;
				this.bot1RB = false;
				return;
				}

			if (this.myParent.top1.endTypeRB == 1
					&& this.myParent.top1.partDimB == this.myParent.left.partDimB
					&& this.leftLT)
				{
				this.myParent.left.endTypeLT = 1;
				this.leftLT = false;
				}
			else
				{
				if (this.myParent.top1.endTypeRB == 1
						&& this.myParent.top1.partDimB != this.myParent.left.partDimB)
					{
					JOptionPane.showMessageDialog(
							null,
							"Part Dimensions Error: Check Dim B!",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;

					}
				}
			if (this.myParent.top1.endTypeRB == 2
					&& this.myParent.left.endTypeLT != 3
					&& this.leftLT)
				{

				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.left.endTypeLT = 3;
				this.leftLT = false;
				return;
				}

			if (this.myParent.top1.endTypeRB == 3
					&& this.myParent.left.endTypeLT != 2
					&& this.leftLT)
				{
				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.left.endTypeLT = 2;
				this.leftLT = false;
				return;
				}
			}
		}

	private void noLeftPart()
		{

		if (this.myParent.noSidesLeft == 0)
			{

			if (this.myParent.top1.endTypeRB == 1
					&& this.myParent.top1.partDimB == this.myParent.bot1.partDimB
					&& this.bot1LT)
				{
				this.myParent.bot1.endTypeLT = 1;
				this.bot1LT = false;
				}
			else
				{
				if (this.myParent.top1.endTypeRB == 1
						&& this.myParent.top1.partDimB != this.myParent.bot1.partDimB)
					{
					JOptionPane.showMessageDialog(
							null,
							"Part Dimensions Error: Check Dim B!",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;

					}
				}
			if (this.myParent.top1.endTypeRB == 2
					&& this.myParent.bot1.endTypeLT != 3
					&& this.bot1LT)
				{

				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.bot1.endTypeLT = 3;
				this.bot1LT = false;
				return;
				}

			if (this.myParent.top1.endTypeRB == 3
					&& this.myParent.bot1.endTypeLT != 2
					&& this.bot1LT)
				{
				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.bot1.endTypeLT = 2;
				this.bot1LT = false;
				return;
				}
			if (this.myParent.top1.endTypeLT == 1
					&& this.myParent.top1.partDimB == this.myParent.right.partDimB
					&& this.rightRB)
				{
				this.myParent.right.endTypeRB = 1;
				this.rightRB = false;
				}
			else
				{
				if (this.myParent.top1.endTypeLT == 1
						&& this.myParent.top1.partDimB != this.myParent.right.partDimB)
					{
					JOptionPane.showMessageDialog(
							null,
							"Part Dimensions Error: Check Dim B!",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;

					}
				}
			if (this.myParent.top1.endTypeLT == 2
					&& this.myParent.right.endTypeRB != 3
					&& this.rightRB)
				{
				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.right.endTypeRB = 3;
				this.rightRB = false;
				return;
				}
			if (this.myParent.top1.endTypeLT == 3
					&& this.myParent.right.endTypeRB != 2
					&& this.rightRB)
				{
				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.right.endTypeRB = 2;
				this.rightRB = false;
				return;
				}

			}
		}

	private void top2Parts()
		{

		if (this.myParent.top2.posInUse
				&& !this.myParent.top3.posInUse)
			{

			if (this.myParent.top2.endTypeLT == 2
					&& this.myParent.right.endTypeRB != 3
					&& this.rightRB)
				{
				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.right.endTypeRB = 3;
				this.rightRB = false;
				return;
				}
			if (this.myParent.top2.endTypeLT == 3
					&& this.myParent.right.endTypeRB != 2
					&& this.rightRB)
				{
				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.right.endTypeRB = 2;
				this.rightRB = false;
				return;
				}
			if (this.myParent.top2.endTypeLT == 1
					&& this.myParent.top2.partDimB == this.myParent.right.partDimB
					&& this.rightRB)
				{
				this.myParent.right.endTypeRB = 1;
				this.rightRB = false;
				}
			else
				{
				if (this.myParent.top2.endTypeLT == 1
						&& this.myParent.top2.partDimB != this.myParent.right.partDimB)
					{
					JOptionPane.showMessageDialog(
							null,
							"Part Dimensions Error: Check Dim B!",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;

					}
				}
			if (this.myParent.top1.endTypeRB == 1
					&& this.myParent.top1.partDimB == this.myParent.top2.partDimB
					&& this.top2LT)
				{
				this.myParent.top2.endTypeLT = 1;
				this.top2LT = false;
				}
			else
				{
				if (this.myParent.top1.endTypeRB == 1
						&& this.myParent.top1.partDimB != this.myParent.top2.partDimB)
					{
					JOptionPane.showMessageDialog(
							null,
							"Part Dimensions Error: Check Dim B!",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;

					}
				}
			if (this.myParent.top1.endTypeRB == 2
					&& this.myParent.top2.endTypeLT != 3
					&& this.top2LT)
				{

				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.top2.endTypeLT = 3;
				this.top2LT = false;
				return;
				}

			if (this.myParent.top1.endTypeRB == 3
					&& this.myParent.top2.endTypeLT != 2
					&& this.top2LT)
				{
				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.top2.endTypeLT = 2;
				this.top2LT = false;
				return;
				}
			}
		}

	private void top3Parts()
		{

		if (this.myParent.top2.posInUse
				&& this.myParent.top3.posInUse)
			{
			if (this.myParent.top2.endTypeLT == 2
					&& this.myParent.right.endTypeRB != 3
					&& this.rightRB)
				{
				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.right.endTypeRB = 3;
				this.rightRB = false;
				return;
				}
			if (this.myParent.top2.endTypeLT == 3
					&& this.myParent.right.endTypeRB != 2
					&& this.rightRB)
				{
				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.right.endTypeRB = 2;
				this.rightRB = false;
				return;
				}
			if (this.myParent.top2.endTypeLT == 1
					&& this.myParent.top2.partDimB == this.myParent.right.partDimB
					&& this.rightRB)
				{
				this.myParent.right.endTypeRB = 1;
				this.rightRB = false;
				}
			else
				{
				if (this.myParent.top2.endTypeLT == 1
						&& this.myParent.top2.partDimB != this.myParent.right.partDimB)
					{
					JOptionPane.showMessageDialog(
							null,
							"Part Dimensions Error: Check Dim B!",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;

					}
				}
			if (this.myParent.top2.endTypeRB == 2
					&& this.myParent.top3.endTypeLT != 3
					&& this.top3LT)
				{
				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.top3.endTypeLT = 3;
				this.top3LT = false;
				return;
				}
			if (this.myParent.top2.endTypeRB == 3
					&& this.myParent.top3.endTypeLT != 2
					&& this.top3LT)
				{
				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.top3.endTypeLT = 2;
				this.top3LT = false;
				return;
				}
			if (this.myParent.top2.endTypeRB == 1
					&& this.myParent.top2.partDimB == this.myParent.top3.partDimB
					&& this.top3LT)
				{
				this.myParent.top3.endTypeLT = 1;
				this.top3LT = false;
				}
			else
				{
				if (this.myParent.top2.endTypeRB == 1
						&& this.myParent.top2.partDimB != this.myParent.top3.partDimB)
					{
					JOptionPane.showMessageDialog(
							null,
							"Part Dimensions Error: Check Dim B!",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;

					}
				}
			if (this.myParent.top1.endTypeRB == 1
					&& this.myParent.top1.partDimB == this.myParent.top2.partDimB
					&& this.top2LT)
				{
				this.myParent.top2.endTypeLT = 1;
				this.top2LT = false;
				}
			else
				{
				if (this.myParent.top1.endTypeRB == 1
						&& this.myParent.top1.partDimB != this.myParent.top2.partDimB)
					{
					JOptionPane.showMessageDialog(
							null,
							"Part Dimensions Error: Check Dim B!",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;

					}
				}
			if (this.myParent.top1.endTypeRB == 2
					&& this.myParent.top2.endTypeLT != 3
					&& this.top2LT)
				{

				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.top2.endTypeLT = 3;
				this.top2LT = false;
				return;
				}

			if (this.myParent.top1.endTypeRB == 3
					&& this.myParent.top2.endTypeLT != 2
					&& this.top2LT)
				{
				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.top2.endTypeLT = 2;
				this.top2LT = false;
				return;
				}

			if (this.myParent.top1.endTypeLT == 1
					&& this.myParent.top1.partDimB == this.myParent.top3.partDimB
					&& this.top3RB)
				{
				this.myParent.top3.endTypeRB = 1;
				this.top3RB = false;
				}
			else
				{
				if (this.myParent.top1.endTypeLT == 1
						&& this.myParent.top1.partDimB != this.myParent.top3.partDimB)
					{
					JOptionPane.showMessageDialog(
							null,
							"Part Dimensions Error: Check Dim B!",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;

					}
				}
			if (this.myParent.top1.endTypeLT == 2
					&& this.myParent.top3.endTypeRB != 3
					&& this.top3RB)
				{

				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.top3.endTypeRB = 3;
				this.top3RB = false;
				return;
				}

			if (this.myParent.top1.endTypeLT == 3
					&& this.myParent.top3.endTypeRB != 2
					&& this.top3RB)
				{
				JOptionPane
						.showMessageDialog(
								null,
								"End Type conflict in Rules, will attempt to correct if possible.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
				this.myParent.top3.endTypeRB = 2;
				this.top3RB = false;
				return;
				}
			}
		}

	}
