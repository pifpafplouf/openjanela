/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

import com.objectplanet.image.PngEncoder;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

public class ImageUtils {

    //Max Thumbnail Width Size
    public static final int THUMBNAIL_WIDTH_MAX_SIZE = 150;

    //Max Thumbnail Height Size
    public static final int THUMBNAIL_HEIGHT_MAX_SIZE = 150;

    /**
     * Create Thumbnail image
     *
     * @param image, byte[]
     * @return byte[]
     */
    public static byte[] createThumbnail(byte[] image, int targetWidth, int targetHeight) {

        //Creating image icon
        ImageIcon imageIcon = new ImageIcon(image);

        //Determine scale for thumbnail
        double scale = determineImageScale(imageIcon.getIconWidth(), imageIcon.getIconHeight(), targetWidth, targetHeight);

        if (scale <= 0) {
            scale = 1.0;
        }

        Image scaledImage = null;
        if (imageIcon.getIconWidth() > targetWidth || imageIcon.getIconHeight() > targetHeight) {

            int _scale_width = (int) (imageIcon.getIconWidth() * scale);
            int _scale_height = (int) (imageIcon.getIconHeight() * scale);

            scaledImage = imageIcon.getImage().getScaledInstance(_scale_width <= targetWidth ? _scale_width : targetWidth,
                    _scale_height <= targetHeight ? _scale_height : targetHeight, Image.SCALE_SMOOTH);
        } else {
            scaledImage = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth(), imageIcon.getIconHeight(),
                    Image.SCALE_SMOOTH);
        }

        ImageIcon imageIconResize = new ImageIcon(scaledImage);
        Image imageResize = imageIconResize.getImage();

        PngEncoder pngEncoder = new PngEncoder(PngEncoder.COLOR_TRUECOLOR_ALPHA);

        //Convert to Byte Array
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            pngEncoder.encode(imageResize, out);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return out.toByteArray();
    }

    /**
     * Create Thumbnail not scale
     *
     * @param image,        Byte array of images
     * @param targetWidth,  Target Width to scale
     * @param targetHeight, Target Height to scale
     * @return byte[]
     */
    public static byte[] createThumbnailNotScale(byte[] image, int targetWidth, int targetHeight) {

        //Creating image icon
        ImageIcon imageIcon = new ImageIcon(image);

        //Determine scale for thumbnail
        double scale = 1;

        Image scaledImage = null;
        if (imageIcon.getIconWidth() > targetWidth || imageIcon.getIconHeight() > targetHeight) {
            scaledImage = imageIcon.getImage().getScaledInstance((int) (targetWidth * scale),
                    (int) (targetHeight * scale), Image.SCALE_SMOOTH);
        } else {
            scaledImage = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth(), imageIcon.getIconHeight(),
                    Image.SCALE_SMOOTH);
        }

        ImageIcon imageIconResize = new ImageIcon(scaledImage);
        Image imageResize = imageIconResize.getImage();

        PngEncoder pngEncoder = new PngEncoder(PngEncoder.COLOR_TRUECOLOR_ALPHA);

        //Convert to Byte Array
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            pngEncoder.encode(imageResize, out);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return out.toByteArray();
    }

    /**
     * Create PNG Image Default System
     *
     * @param image, byte[]
     * @return byte[]
     */
    public static byte[] createPngImage(byte[] image) {

        //Creating image icon
        ImageIcon imageIcon = new ImageIcon(image);
        Image pngImage = imageIcon.getImage();

        PngEncoder pngEncoder = new PngEncoder(PngEncoder.COLOR_TRUECOLOR_ALPHA);

        //Convert to Byte Array
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            pngEncoder.encode(pngImage, out);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return out.toByteArray();
    }

    /**
     * Convert to byte[]
     *
     * @param image, Image
     * @return byte[]
     */
    public static byte[] convertToByteArray(Image image) {

        PngEncoder pngEncoder = new PngEncoder(PngEncoder.COLOR_TRUECOLOR_ALPHA);

        //Convert to Byte Array
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            pngEncoder.encode(image, out);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return out.toByteArray();
    }

    /**
     * Determine image scale
     *
     * @param sourceWidth,  Source width
     * @param sourceHeight, Source height
     * @param targetWidth,  Target width
     * @param targetHeight, Target height
     * @return double
     */
    public static double determineImageScale(int sourceWidth, int sourceHeight, int targetWidth, int targetHeight) {

        double scale = 0;

        if (sourceWidth > sourceHeight) {
            scale = (double) targetWidth / sourceWidth;
        } else if (sourceWidth < sourceHeight) {
            scale = (double) targetHeight / sourceHeight;
        }

        return scale;
    }

    public static byte[] constrain(String srcFilename, int boxSize) {
        try {
            FileInputStream fis = new FileInputStream(srcFilename);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            MemoryCacheImageOutputStream mos = new MemoryCacheImageOutputStream(baos);
            constrain(fis, mos, boxSize);
            return baos.toByteArray();
            //ByteArrayInputSteam bais = new ByteArrayInputStream( baos.toByteArray() );
            //return bais;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }

    public static void constrain(InputStream is, ImageOutputStream os, int boxSize) {
        try {
            // Read the source file
            BufferedImage input = ImageIO.read(is);

            // Get the original size of the image
            int srcHeight = input.getHeight();
            int srcWidth = input.getWidth();

            // Constrain the thumbnail to a predefined box size
            int height = boxSize;
            int width = boxSize;
            if (srcHeight > srcWidth) {
                width = (int) (((float) height / (float) srcHeight) * (float) srcWidth);
            } else if (srcWidth > srcHeight) {
                height = (int) (((float) width / (float) srcWidth) * (float) srcHeight);
            }

            // Create a new thumbnail BufferedImage
            BufferedImage thumb = new BufferedImage(width, height, BufferedImage.TYPE_USHORT_565_RGB);
            Graphics g = thumb.getGraphics();
            g.drawImage(input, 0, 0, width, height, null);

            // Get Writer and set compression
            Iterator iter = ImageIO.getImageWritersByFormatName("JPG");
            if (iter.hasNext()) {
                ImageWriter writer = (ImageWriter) iter.next();
                ImageWriteParam iwp = writer.getDefaultWriteParam();
                iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                iwp.setCompressionQuality(0.75f);
                writer.setOutput(os);
                IIOImage image = new IIOImage(thumb, null, null);
                writer.write(null, image, iwp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
