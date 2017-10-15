package Operations;

import Model.ShapeObject;
import Model.ShapeOption;

public class SetShapeObjectColors
{
	
	public ShapeObject shape;
	
	public SetShapeObjectColors() {
		
	}

    public static ShapeObject setShapeObjectPartColors(ShapeObject myFrame) {

        int rgb_r = 255;

        int rgb_g = 255;

        int rgb_b = 255;

        Object[] options = myFrame.options.toArray();
        for (Object o : options) {
            ShapeOption option = (ShapeOption)o;

            if (option.rgb_B != -1 && option.rgb_G != -1 && option.rgb_R != -1) {
                rgb_b = ((ShapeOption) o).rgb_B;
                rgb_g = ((ShapeOption) o).rgb_G;
                rgb_r = ((ShapeOption) o).rgb_R;
            }
        }

//        myFrame.top1Part.rgb_B = rgb_b;
//        myFrame.top1Part.rgb_R = rgb_r;
//        myFrame.top1Part.rgb_G = rgb_g;
//
//        myFrame.top2Part.rgb_B = rgb_b;
//        myFrame.top2Part.rgb_R = rgb_r;
//        myFrame.top2Part.rgb_G = rgb_g;
//
//        myFrame.top3Part.rgb_B = rgb_b;
//        myFrame.top3Part.rgb_R = rgb_r;
//        myFrame.top3Part.rgb_G = rgb_g;
//
//        myFrame.bot1Part.rgb_B = rgb_b;
//        myFrame.bot1Part.rgb_R = rgb_r;
//        myFrame.bot1Part.rgb_G = rgb_g;
//
//        myFrame.bot2Part.rgb_B = rgb_b;
//        myFrame.bot2Part.rgb_R = rgb_r;
//        myFrame.bot2Part.rgb_G = rgb_g;
//
//        myFrame.bot3Part.rgb_B = rgb_b;
//        myFrame.bot3Part.rgb_R = rgb_r;
//        myFrame.bot3Part.rgb_G = rgb_g;
//
//        myFrame.leftPart.rgb_B = rgb_b;
//        myFrame.leftPart.rgb_R = rgb_r;
//        myFrame.leftPart.rgb_G = rgb_g;
//
//        myFrame.rightPart.rgb_B = rgb_b;
//        myFrame.rightPart.rgb_R = rgb_r;
//        myFrame.rightPart.rgb_G = rgb_g;

        return myFrame;
    }
}