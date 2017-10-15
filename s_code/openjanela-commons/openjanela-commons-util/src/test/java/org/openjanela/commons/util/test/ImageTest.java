package org.openjanela.commons.util.test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by EMONTENEGRO on 5/7/14.
 */
public class ImageTest {

    public static void main(String[] args) {

        try {

            //Create file for the source
            File input = new File("C:/Users/EMONTENEGRO/Documents/DOORS CATALOGUE/DB-103 2SL CST.jpg");

            //Read the file to a BufferedImage
            BufferedImage image = ImageIO.read(input);

            //Create a file for the output
            File output = new File("C:/Users/EMONTENEGRO/Documents/DOORS CATALOGUE/DB-103 2SL CST.bmp");

            //Write the image to the destination as a BMP
            ImageIO.write(image, "bmp", output);

        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
    }
}
