/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

import java.io.*;
import java.sql.*;
import java.util.*;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;

//import com.sun.image.codec.jpeg.*;

public class JGetImage {
//	double deduct = Math.max((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-400D),
//	(Toolkit.getDefaultToolkit().getScreenSize().
//	getHeight()-550D)   );

    double factorsize = Math.min((Toolkit.getDefaultToolkit().getScreenSize()
            .getWidth() - 400D), (Toolkit.getDefaultToolkit()
            .getScreenSize().getHeight() - 320D));

    public JGetImage() {


    }

    public JGetImage(Connection conSeries, String myDBSeries, String UserSeriesID,
                     String PassWordforSeries) {
        conSeries = conSeries;
        dataBaseSeries = myDBSeries;
        userIdSeries = UserSeriesID;
        passWordSeries = PassWordforSeries;
    }

    public static void setBufferedImage(BufferedImage bufferedimage) {
    }

    public static BufferedImage getBufferedImage(Connection conSeries,
                                                 int designID, float scaleFactor) {
        double deduct = Math.max((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 400D),
                (Toolkit.getDefaultToolkit().getScreenSize().
                        getHeight() - 550D));
//		double factorsize = Toolkit.getDefaultToolkit().getScreenSize().
//		getWidth() - deduct;
        double factorsize = Math.min((Toolkit.getDefaultToolkit().getScreenSize()
                .getWidth() - 400D), (Toolkit.getDefaultToolkit()
                .getScreenSize().getHeight() - 320D));
        GeneralPath pathImage = new GeneralPath();
        PreparedStatement preSelect = null;
        ResultSet rs = null;
        InputStream inStream = null;
        BufferedImage resultImage = new BufferedImage((int) ((float) factorsize *
                scaleFactor + (float) 6 + (float) 20),
                (int) ((float) factorsize *
                        scaleFactor + (float) 6 + (float) 20), 1);

        Graphics2D g2d = resultImage.createGraphics();
        Rectangle2D rect = new Rectangle2D.Double(0.0D, 0.0D,
                factorsize * (double) scaleFactor + (double) 6 + (double) 20,
                factorsize * (double) scaleFactor + (double) 6 + (double) 20);
        g2d.setColor(Color.white);
        g2d.fill(rect);
        g2d.setColor(Color.black);
        try {
            preSelect = conSeries.prepareStatement(
                    "SELECT ScaledImage FROM Design WHERE ID = ?", 1004, 1007);
            preSelect.setInt(1, designID);
            rs = preSelect.executeQuery();
            do {
                if (!rs.next()) {
                    break;
                }
                pathImage.reset();
                inStream = rs.getBinaryStream("ScaledImage");
                if (inStream != null) {
                    int length = inStream.available();
                    int byteReadNumber = 0;
                    ByteArrayInputStream byteInStream = null;
                    DataInputStream dataIn = null;
                    byte bInt[] = new byte[4];
                    byte bFloat[] = new byte[4];
                    int counter = 0;
                    while (byteReadNumber < length) {
                        inStream.read(bInt, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bInt);
                        dataIn = new DataInputStream(byteInStream);
                        int type = dataIn.readInt();
                        if (type == 0) {
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dx0 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dy0 = dataIn.readFloat() * scaleFactor;
                            pathImage.moveTo(dx0, dy0);
                        } else if (type == 1) {
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dx0 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dy0 = dataIn.readFloat() * scaleFactor;
                            pathImage.lineTo(dx0, dy0);
                        } else if (type == 2) {
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dx0 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dy0 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dx1 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dy1 = dataIn.readFloat() * scaleFactor;
                            pathImage.quadTo(dx0, dy0, dx1, dy1);
                        } else if (type == 3) {
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dx0 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dy0 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dx1 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dy1 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dx2 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dy2 = dataIn.readFloat() * scaleFactor;
                            pathImage.curveTo(dx0, dy0, dx1, dy1, dx2, dy2);
                        } else if (type == 4) {
                            pathImage.closePath();
                        }
                        counter++;
                    }
                }
            }
            while (true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        g2d.translate(10, 10);
        g2d.draw(pathImage);
        return resultImage;
    }

    public static BufferedImage getBufferedImage(Connection conSeries,
                                                 int designID, float scaleFactor,
                                                 boolean isDoorSrc) {
        double deduct = Math.max((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 400D),
                (Toolkit.getDefaultToolkit().getScreenSize().
                        getHeight() - 550D));
        double factorsize = Math.min((Toolkit.getDefaultToolkit().getScreenSize()
                .getWidth() - 400D), (Toolkit.getDefaultToolkit()
                .getScreenSize().getHeight() - 320D));
        GeneralPath pathImage = new GeneralPath();
        PreparedStatement preSelect = null;
        ResultSet rs = null;
        InputStream inStream = null;
        BufferedImage resultImage = new BufferedImage((int) ((float) factorsize *
                scaleFactor + (float) 6 + (float) 20),
                (int) ((float) factorsize *
                        scaleFactor + (float) 6 + (float) 20), 1);

        Graphics2D g2d = resultImage.createGraphics();

        Rectangle2D rect = new Rectangle2D.Double(0.0D, 0.0D,
                factorsize * (double) scaleFactor + (double) 6 + (double) 20,
                factorsize * (double) scaleFactor + (double) 6 + (double) 20);
        g2d.setColor(Color.white);
        g2d.fill(rect);
        g2d.setColor(Color.black);
        try {
            preSelect = conSeries.prepareStatement(
                    "SELECT ScaledImage FROM DesignDoor WHERE ID = ?", 1004, 1007);
            preSelect.setInt(1, designID);
            rs = preSelect.executeQuery();
            rs.beforeFirst();
            do {
                if (!rs.next()) {
                    break;
                }
                pathImage.reset();
                inStream = rs.getBinaryStream("ScaledImage");
                if (inStream != null) {
                    int length = inStream.available();
                    int byteReadNumber = 0;
                    ByteArrayInputStream byteInStream = null;
                    DataInputStream dataIn = null;
                    byte bInt[] = new byte[4];
                    byte bFloat[] = new byte[4];
                    int counter = 0;
                    while (byteReadNumber < length) {
                        inStream.read(bInt, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bInt);
                        dataIn = new DataInputStream(byteInStream);
                        int type = dataIn.readInt();
                        if (type == 0) {
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dx0 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dy0 = dataIn.readFloat() * scaleFactor;
                            pathImage.moveTo(dx0, dy0);
                        } else if (type == 1) {
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dx0 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dy0 = dataIn.readFloat() * scaleFactor;
                            pathImage.lineTo(dx0, dy0);
                        } else if (type == 2) {
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dx0 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dy0 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dx1 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dy1 = dataIn.readFloat() * scaleFactor;
                            pathImage.quadTo(dx0, dy0, dx1, dy1);
                        } else if (type == 3) {
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dx0 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dy0 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dx1 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dy1 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dx2 = dataIn.readFloat() * scaleFactor;
                            inStream.read(bFloat, 0, 4);
                            byteReadNumber += 4;
                            byteInStream = new ByteArrayInputStream(bFloat);
                            dataIn = new DataInputStream(byteInStream);
                            float dy2 = dataIn.readFloat() * scaleFactor;
                            pathImage.curveTo(dx0, dy0, dx1, dy1, dx2, dy2);
                        } else if (type == 4) {
                            pathImage.closePath();
                        }
                        counter++;
                    }
                }
            }
            while (true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        g2d.translate(10, 10);
        g2d.draw(pathImage);
        return resultImage;
    }

    public static BufferedImage getBufferedImage(InputStream inStream,
                                                 int designID, float scaleFactor) {
        ///Selection
        double deduct = Math.max((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 400D),
                (Toolkit.getDefaultToolkit().getScreenSize().
                        getHeight() - 550D));
        double factorsize = Math.min((Toolkit.getDefaultToolkit().getScreenSize()
                .getWidth() - 400D), (Toolkit.getDefaultToolkit()
                .getScreenSize().getHeight() - 320D));
        GeneralPath pathImage = new GeneralPath();
        BufferedImage resultImage = new BufferedImage((int) ((float) 300 *
                scaleFactor + (float) 6 + (float) 20),
                (int) ((float) 300 *
                        scaleFactor + (float) 6 + (float) 20), 1);

        Graphics2D g2d = resultImage.createGraphics();

        Rectangle2D rect = new Rectangle2D.Double(0.0D, 0.0D,
                factorsize * (double) scaleFactor + (double) 6 + (double) 20,
                factorsize * (double) scaleFactor + (double) 6 + (double) 20);
        g2d.setColor(Color.white);
        g2d.fill(rect);
        g2d.setColor(Color.black);
        try {
            pathImage.reset();
            if (inStream != null) {
                int length = inStream.available();
                int byteReadNumber = 0;
                ByteArrayInputStream byteInStream = null;
                DataInputStream dataIn = null;
                byte bInt[] = new byte[4];
                byte bFloat[] = new byte[4];
                do {
                    if (byteReadNumber >= length) {
                        break;
                    }
                    inStream.read(bInt, 0, 4);
                    byteReadNumber += 4;
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    int type = dataIn.readInt();
                    if (type == 0) {
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy0 = dataIn.readFloat() * scaleFactor;
                        pathImage.moveTo(dx0, dy0);
                    } else if (type == 1) {
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy0 = dataIn.readFloat() * scaleFactor;
                        pathImage.lineTo(dx0, dy0);
                    } else if (type == 2) {
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx1 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy1 = dataIn.readFloat() * scaleFactor;
                        pathImage.quadTo(dx0, dy0, dx1, dy1);
                    } else if (type == 3) {
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx1 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy1 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx2 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy2 = dataIn.readFloat() * scaleFactor;
                        pathImage.curveTo(dx0, dy0, dx1, dy1, dx2, dy2);
                    } else if (type == 4) {
                        pathImage.closePath();
                    }
                }
                while (true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        g2d.translate(10, 10);
        g2d.draw(pathImage);
        return resultImage;
    }

    public static BufferedImage getBufferedImage(InputStream inStream,
                                                 float scaleFactor) {
        double deduct = Math.max((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 400D),
                (Toolkit.getDefaultToolkit().getScreenSize().
                        getHeight() - 550D));
        double factorsize = Math.min((Toolkit.getDefaultToolkit().getScreenSize()
                .getWidth() - 400D), (Toolkit.getDefaultToolkit()
                .getScreenSize().getHeight() - 320D));
        GeneralPath pathImage = new GeneralPath();
        BufferedImage resultImage = new BufferedImage((int) ((float) (factorsize) *
                scaleFactor) + 20, (int) ((float) (factorsize) * scaleFactor) + 20, 1);
        //HERE

        Graphics2D g2d = resultImage.createGraphics();

        Rectangle2D rect = new Rectangle2D.Double(0.0D, 0.0D,
                factorsize * (double) scaleFactor + (double) 6 + (double) 20,
                factorsize * (double) scaleFactor + (double) 6 + (double) 20);

//		Rectangle2D rect = new java.awt.geom.Rectangle2D.Double(0.0D, 0.0D,
//		factorsize * (double) scaleFactor, factorsize * (double) scaleFactor);

        g2d.setColor(Color.white);
        g2d.fill(rect);
        g2d.setColor(Color.black);
        try {
            pathImage.reset();
            if (inStream != null) {
                int length = inStream.available();
                int byteReadNumber = 0;
                ByteArrayInputStream byteInStream = null;
                DataInputStream dataIn = null;
                byte bInt[] = new byte[4];
                byte bFloat[] = new byte[4];
                do {
                    if (byteReadNumber >= length) {
                        break;
                    }
                    inStream.read(bInt, 0, 4);
                    byteReadNumber += 4;
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    int type = dataIn.readInt();
                    if (type == 0) {
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy0 = dataIn.readFloat() * scaleFactor;
                        pathImage.moveTo(dx0, dy0);
                    } else if (type == 1) {
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy0 = dataIn.readFloat() * scaleFactor;
                        pathImage.lineTo(dx0, dy0);
                    } else if (type == 2) {
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx1 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy1 = dataIn.readFloat() * scaleFactor;
                        pathImage.quadTo(dx0, dy0, dx1, dy1);
                    } else if (type == 3) {
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx1 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy1 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx2 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy2 = dataIn.readFloat() * scaleFactor;
                        pathImage.curveTo(dx0, dy0, dx1, dy1, dx2, dy2);
                    } else if (type == 4) {
                        pathImage.closePath();
                    }
                }
                while (true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        g2d.translate(10, 10);
        g2d.draw(pathImage);
        return resultImage;
    }

    public static BufferedImage getBufferedImage(InputStream inStream,
                                                 float scaleFactor,
                                                 Color backGround) {
        double deduct = Math.max((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 400D),
                (Toolkit.getDefaultToolkit().getScreenSize().
                        getHeight() - 550D));
        double factorsize = Math.min((Toolkit.getDefaultToolkit().getScreenSize()
                .getWidth() - 400D), (Toolkit.getDefaultToolkit()
                .getScreenSize().getHeight() - 320D));
        GeneralPath pathImage = new GeneralPath();
        BufferedImage resultImage = new BufferedImage((int) ((float) factorsize *
                scaleFactor + (float) 6 + (float) 20),
                (int) ((float) factorsize *
                        scaleFactor + (float) 6 + (float) 20), 1);

        Graphics2D g2d = resultImage.createGraphics();

        Rectangle2D rect = new Rectangle2D.Double(0.0D, 0.0D,
                factorsize * (double) scaleFactor + (double) 6 + (double) 20,
                factorsize * (double) scaleFactor + (double) 6 + (double) 20);
        g2d.setColor(backGround);
        g2d.fill(rect);
        g2d.setColor(Color.black);
        try {
            pathImage.reset();
            if (inStream != null) {
                int length = inStream.available();
                int byteReadNumber = 0;
                ByteArrayInputStream byteInStream = null;
                DataInputStream dataIn = null;
                byte bInt[] = new byte[4];
                byte bFloat[] = new byte[4];
                do {
                    if (byteReadNumber >= length) {
                        break;
                    }
                    inStream.read(bInt, 0, 4);
                    byteReadNumber += 4;
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    int type = dataIn.readInt();
                    if (type == 0) {
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy0 = dataIn.readFloat() * scaleFactor;
                        pathImage.moveTo(dx0, dy0);
                    } else if (type == 1) {
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy0 = dataIn.readFloat() * scaleFactor;
                        pathImage.lineTo(dx0, dy0);
                    } else if (type == 2) {
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx1 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy1 = dataIn.readFloat() * scaleFactor;
                        pathImage.quadTo(dx0, dy0, dx1, dy1);
                    } else if (type == 3) {
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx1 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy1 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx2 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy2 = dataIn.readFloat() * scaleFactor;
                        pathImage.curveTo(dx0, dy0, dx1, dy1, dx2, dy2);
                    } else if (type == 4) {
                        pathImage.closePath();
                    }
                }
                while (true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        g2d.translate(10, 10);
        g2d.draw(pathImage);
        return resultImage;
    }

    public static BufferedImage getBufferedImage(byte byteSource[]) {
        BufferedImage resultImage = new BufferedImage(600, 500, 1);
        Graphics2D g2d = resultImage.createGraphics();
        Rectangle2D rect = new Rectangle2D.Double(0.0D, 0.0D, 321D,
                321D);
        g2d.fill(rect);
        g2d.setColor(Color.black);
        g2d.translate(10, 10);
        ImageIcon imageIcon = new ImageIcon(byteSource);
        Image image = imageIcon.getImage();
        g2d.drawImage(image, null, null);
        return resultImage;
    }

    public static BufferedImage getBufferedImage(byte byteSource[],
                                                 Color backGround) {
        ImageIcon imageIcon = new ImageIcon(byteSource);
        Image image = imageIcon.getImage();
        int imageWidthSrc = image.getWidth(null);
        int imageHeightSrc = image.getHeight(null);
        double widthScale = (double) imageWidthSrc / 650D;
        double heightScale = (double) imageHeightSrc / 490D;

        double myFactorSize = Math.max((double) imageWidthSrc, (double) imageHeightSrc) /
                Math.min((Toolkit.getDefaultToolkit().getScreenSize()
                        .getWidth() - 400D), (Toolkit.getDefaultToolkit()
                        .getScreenSize().getHeight() - 320D));

        BufferedImage resultImage = new BufferedImage(
                (int) ((double) 600 * widthScale) + 10,
                (int) ((double) 500 * heightScale) + 10, 1);

//		BufferedImage resultImage = new BufferedImage( 
//				(int) ( (Toolkit.getDefaultToolkit().getScreenSize()
//						.getWidth() - 400D) *  myFactorSize)+100, 
//				(int) ( (Toolkit.getDefaultToolkit()
//						.getScreenSize().getHeight() - 320D)+100* myFactorSize), 1);

        Graphics2D g2d = resultImage.createGraphics();
//		Rectangle2D rect = new java.awt.geom.Rectangle2D.Double(0.0D, 0.0D, 326D,
//				326D);
//		g2d.setColor(backGround);
//		g2d.fill(rect);
        g2d.translate(10, 10);
        g2d.drawImage(image, null, null);
        return resultImage;
    }

    public static int[] getImageDimension(byte imageSource[]) {
        int imageSize[] = new int[2];
        ImageIcon imageIcon = new ImageIcon(imageSource);
        imageSize[0] = imageIcon.getIconWidth();
        imageSize[1] = imageIcon.getIconHeight();
        return imageSize;
    }

    public static BufferedImage getBufferedImage(byte byteSource[], int width,
                                                 int height) {
        ImageIcon imageIcon = new ImageIcon(byteSource);
        int w = imageIcon.getIconWidth();
        int h = imageIcon.getIconHeight();
        if (w > width) {
            w = width;
        }
        if (h > height) {
            h = height;
        }
        ImageIcon newImageIcon = new ImageIcon(imageIcon.getImage().
                getScaledInstance(w, h, 2));
        Image image = newImageIcon.getImage();
        BufferedImage resultImage = new BufferedImage(w, h, 1);
        Graphics2D g2d = resultImage.createGraphics();
        g2d.drawImage(image, null, null);
        return resultImage;
    }

    public static boolean imageResize(String sourceName, String destName,
                                      int nWidth, int nHeight) throws Exception {
//        boolean backimageresize = false;
//        JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(new FileInputStream(
//                sourceName));
//        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(new FileOutputStream(
//                destName));
//        BufferedImage sourceImg = decoder.decodeAsBufferedImage();
//        BufferedImage imgThumb = scaleToSize(nWidth, nHeight, sourceImg);
//        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(imgThumb);
//        param.setQuality(0.25F, false);
//        param.setHorizontalSubsampling(0, 1);
//        param.setHorizontalSubsampling(1, 1);
//        param.setHorizontalSubsampling(2, 1);
//        param.setVerticalSubsampling(0, 1);
//        param.setVerticalSubsampling(1, 1);
//        param.setVerticalSubsampling(2, 1);
//        encoder.setJPEGEncodeParam(param);
//        encoder.encode(imgThumb);
//        backimageresize = true;
//        return backimageresize;
        return false;
    }

    public static BufferedImage scaleToSize(int nMaxWidth, int nMaxHeight,
                                            BufferedImage imgSrc) {
        int nHeight = imgSrc.getHeight();
        int nWidth = imgSrc.getWidth();
        double scaleX = (double) nMaxWidth / (double) nWidth;
        double scaleY = (double) nMaxHeight / (double) nHeight;
        double fScale = Math.min(scaleX, scaleY);
        return scale(fScale, imgSrc);
    }

    public static BufferedImage scale(double scale, BufferedImage srcImg) {
        if (scale == (double) 1) {
            return srcImg;
        } else {
            AffineTransform xform = AffineTransform.getScaleInstance(scale, scale);
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_RENDERING,
                    RenderingHints.
                            VALUE_RENDER_QUALITY);
            AffineTransformOp op = new AffineTransformOp(xform, hints);
            BufferedImage dstImg = op.createCompatibleDestImage(srcImg,
                    srcImg.getColorModel());
            return op.filter(srcImg, dstImg);
        }
    }

    public static BufferedImage getBufferedImage(InputStream inStream,
                                                 float scaleFactor,
                                                 Color backGround,
                                                 InputStream
                                                         streamFileSlabInsertImage) {
        double deduct = Math.max((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 400D),
                (Toolkit.getDefaultToolkit().getScreenSize().
                        getHeight() - 550D));
        double factorsize = Math.min((Toolkit.getDefaultToolkit().getScreenSize()
                .getWidth() - 400D), (Toolkit.getDefaultToolkit()
                .getScreenSize().getHeight() - 320D));
        GeneralPath pathImage = new GeneralPath();
        BufferedImage resultImage = new BufferedImage((int) ((float) factorsize *
                scaleFactor + (float) 6 + (float) 20),
                (int) ((float) factorsize *
                        scaleFactor + (float) 6 + (float) 20), 1);

        Graphics2D g2d = resultImage.createGraphics();

        Rectangle2D rect = new Rectangle2D.Double(0.0D, 0.0D,
                factorsize * (double) scaleFactor + (double) 6 + (double) 20,
                (float) factorsize * scaleFactor + (float) 6 + (float) 20);
        g2d.setColor(backGround);
        g2d.fill(rect);
        g2d.translate(10, 10);
        g2d.setColor(Color.black);
        try {
            pathImage.reset();
            if (inStream != null) {
                int length = inStream.available();
                int byteReadNumber = 0;
                ByteArrayInputStream byteInStream = null;
                DataInputStream dataIn = null;
                byte bInt[] = new byte[4];
                byte bFloat[] = new byte[4];
                do {
                    if (byteReadNumber >= length) {
                        break;
                    }
                    inStream.read(bInt, 0, 4);
                    byteReadNumber += 4;
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    int type = dataIn.readInt();
                    if (type == 0) {
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy0 = dataIn.readFloat() * scaleFactor;
                        pathImage.moveTo(dx0, dy0);
                    } else if (type == 1) {
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy0 = dataIn.readFloat() * scaleFactor;
                        pathImage.lineTo(dx0, dy0);
                    } else if (type == 2) {
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx1 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy1 = dataIn.readFloat() * scaleFactor;
                        pathImage.quadTo(dx0, dy0, dx1, dy1);
                    } else if (type == 3) {
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy0 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx1 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy1 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dx2 = dataIn.readFloat() * scaleFactor;
                        inStream.read(bFloat, 0, 4);
                        byteReadNumber += 4;
                        byteInStream = new ByteArrayInputStream(bFloat);
                        dataIn = new DataInputStream(byteInStream);
                        float dy2 = dataIn.readFloat() * scaleFactor;
                        pathImage.curveTo(dx0, dy0, dx1, dy1, dx2, dy2);
                    } else if (type == 4) {
                        pathImage.closePath();
                    }
                }
                while (true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        g2d.setClip(pathImage);
        drawSlabInsertImage(g2d, scaleFactor, streamFileSlabInsertImage);
        g2d.draw(pathImage);
        return resultImage;
    }

    private static void drawSlabInsertImage(Graphics2D g2d, float scaleFactor,
                                            InputStream streamFileSlabInsertImage) {
        ByteArrayInputStream byteInStream = null;
        DataInputStream dataIn = null;
        byte bInt[] = new byte[4];
        byte bDouble[] = new byte[8];
        byte bBoolean[] = new byte[1];
        boolean end_of_file = false;
        int noCols = 0;
        int noRows = 0;
        int cellX = 0;
        int cellY = 0;
        boolean slabExist = false;
        boolean insertExist = false;
        int slabSrcLength = 0;
        int insertSrcLength = 0;
        boolean slabIntListExist = false;
        int slabIntListSize = 0;
        try {
            streamFileSlabInsertImage.read(bInt, 0, 4);
            byteInStream = new ByteArrayInputStream(bInt);
            dataIn = new DataInputStream(byteInStream);
            noCols = dataIn.readInt();
            streamFileSlabInsertImage.read(bInt, 0, 4);
            byteInStream = new ByteArrayInputStream(bInt);
            dataIn = new DataInputStream(byteInStream);
            noRows = dataIn.readInt();
        } catch (Exception ep) {
            ep.printStackTrace();
        }
        try {
            for (int i = 0; i < noCols; i++) {
                for (int j = 0; j < noRows; j++) {
                    if (end_of_file) {
                        continue;
                    }
                    streamFileSlabInsertImage.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    cellX = dataIn.readInt();
                    streamFileSlabInsertImage.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    cellY = dataIn.readInt();
                    streamFileSlabInsertImage.read(bBoolean, 0, 1);
                    byteInStream = new ByteArrayInputStream(bBoolean);
                    dataIn = new DataInputStream(byteInStream);
                    slabIntListExist = dataIn.readBoolean();
                    if (!slabIntListExist) {
                        continue;
                    }
                    streamFileSlabInsertImage.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    slabIntListSize = dataIn.readInt();
                    for (int si = 0; si < slabIntListSize; si++) {
                        byte slbImgSrc[] = new byte[0];
                        byte instImgSrc[] = new byte[0];
                        String slbStockCode = null;
                        String instStockCode = null;
                        double slbDwgPtn[] = new double[4];
                        double instDwgPtn[] = new double[4];
                        streamFileSlabInsertImage.read(bBoolean, 0, 1);
                        byteInStream = new ByteArrayInputStream(bBoolean);
                        dataIn = new DataInputStream(byteInStream);
                        slabExist = dataIn.readBoolean();
                        byte mystr[];
                        if (slabExist) {
                            mystr = new byte[20];
                            streamFileSlabInsertImage.read(mystr, 0, 20);
                            slbStockCode = new String(mystr);
                            slbStockCode = slbStockCode.trim();
                            streamFileSlabInsertImage.read(bInt, 0, 4);
                            byteInStream = new ByteArrayInputStream(bInt);
                            dataIn = new DataInputStream(byteInStream);
                            slabSrcLength = dataIn.readInt();
                            slbImgSrc = new byte[slabSrcLength];
                            streamFileSlabInsertImage.read(slbImgSrc, 0, slabSrcLength);
                            for (int k = 0; k < slbDwgPtn.length; k++) {
                                streamFileSlabInsertImage.read(bDouble, 0, 8);
                                byteInStream = new ByteArrayInputStream(bDouble);
                                dataIn = new DataInputStream(byteInStream);
                                slbDwgPtn[k] = dataIn.readDouble();
                            }

                            ImageIcon imageIconSlab = new ImageIcon(slbImgSrc);
                            Image image = imageIconSlab.getImage();
                            g2d.drawImage(image, (int) (slbDwgPtn[0] * (double) scaleFactor),
                                    (int) (slbDwgPtn[1] * (double) scaleFactor),
                                    (int) (slbDwgPtn[2] * (double) scaleFactor),
                                    (int) (slbDwgPtn[3] * (double) scaleFactor), null);
                        }
                        streamFileSlabInsertImage.read(bBoolean, 0, 1);
                        byteInStream = new ByteArrayInputStream(bBoolean);
                        dataIn = new DataInputStream(byteInStream);
                        insertExist = dataIn.readBoolean();
                        if (!insertExist) {
                            continue;
                        }
                        mystr = new byte[20];
                        streamFileSlabInsertImage.read(mystr, 0, 20);
                        instStockCode = new String(mystr);
                        instStockCode = instStockCode.trim();
                        streamFileSlabInsertImage.read(bInt, 0, 4);
                        byteInStream = new ByteArrayInputStream(bInt);
                        dataIn = new DataInputStream(byteInStream);
                        insertSrcLength = dataIn.readInt();
                        instImgSrc = new byte[insertSrcLength];
                        streamFileSlabInsertImage.read(instImgSrc, 0, insertSrcLength);
                        for (int k = 0; k < instDwgPtn.length; k++) {
                            streamFileSlabInsertImage.read(bDouble, 0, 8);
                            byteInStream = new ByteArrayInputStream(bDouble);
                            dataIn = new DataInputStream(byteInStream);
                            instDwgPtn[k] = dataIn.readDouble();
                        }

                        ImageIcon imageIconInsert = new ImageIcon(instImgSrc);
                        Image imageInsert = imageIconInsert.getImage();
                        g2d.drawImage(imageInsert,
                                (int) (instDwgPtn[0] * (double) scaleFactor),
                                (int) (instDwgPtn[1] * (double) scaleFactor),
                                (int) (instDwgPtn[2] * (double) scaleFactor),
                                (int) (instDwgPtn[3] * (double) scaleFactor), null);
                    }

                }

            }

            dataIn.close();
            byteInStream.close();
            streamFileSlabInsertImage.close();
        } catch (EOFException ef) {
            end_of_file = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            end_of_file = true;
        }
    }

    public static ArrayList<ArrayList<String>> getPctValue_Member_Cell(InputStream myStreamFile) {
        ArrayList<String> myTextRow = new ArrayList<String>();
        ArrayList<String> myTextCol = new ArrayList<String>();
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        int noRows = 0;
        int noCols = 0;
        boolean eof = false;
        try {
            if (myStreamFile != null) {
                ByteArrayInputStream byteInStream = null;
                DataInputStream dataIn = null;
                byte bInt[] = new byte[4];
                byte bDouble[] = new byte[8];
                myStreamFile.read(bInt, 0, 4);
                byteInStream = new ByteArrayInputStream(bInt);
                dataIn = new DataInputStream(byteInStream);
                noCols = dataIn.readInt();
                myStreamFile.read(bInt, 0, 4);
                byteInStream = new ByteArrayInputStream(bInt);
                dataIn = new DataInputStream(byteInStream);
                noRows = dataIn.readInt();
                String MR = null;
                String MC = null;
                try {
                    for (int j = 0; j < noRows; j++) {
                        byte myt[] = new byte[21];
                        myStreamFile.read(myt, 0, 21);
                        MR = new String(myt);
                        myTextRow.add(MR.trim());
                    }

                    for (int i = 0; i < noCols; i++) {
                        byte myt[] = new byte[21];
                        myStreamFile.read(myt, 0, 21);
                        MC = new String(myt);
                        myTextCol.add(MC.trim());
                    }

                    result.add(myTextRow);
                    result.add(myTextCol);
                    dataIn.close();
                    byteInStream.close();
                    myStreamFile.close();
                } catch (EOFException ef) {
                    eof = true;
                }
            }
        } catch (Exception eo) {
            eo.printStackTrace();
        }
        return result;
    }

    public static BufferedImage getBufferedImage(byte byteSource[], int width,
                                                 int height, Shape pathHRTRSM,
                                                 Color backGround) {
        Arc2D.Double myAr = (Arc2D.Double) pathHRTRSM;
        double x = myAr.x;
        double y = myAr.y;
        double wi = myAr.width;
        double he = myAr.height;
        double a1 = myAr.start;
        double a2 = myAr.extent;
        ImageIcon imageIcon = new ImageIcon(byteSource);
        int w = imageIcon.getIconWidth();
        int h = imageIcon.getIconHeight();
        if (w > width) {
            w = width;
        }
        if (h > height) {
            h = height;
        }
        ImageIcon newImageIcon = new ImageIcon(imageIcon.getImage().
                getScaledInstance(width, height, 2));
        Image image = newImageIcon.getImage();
        BufferedImage resultImage = new BufferedImage(width, height, 2);
        Graphics2D g2d = resultImage.createGraphics();
        Rectangle2D rect = new Rectangle2D.Double(-x, -y, width,
                height);
        g2d.setColor(backGround);
        g2d.fill(rect);
        g2d.translate(-x, -y);
        g2d.setClip(myAr);
        g2d.drawImage(image, (int) x, (int) y, backGround, null);
        return resultImage;
    }

    public static HashMap<String, HashMap<String, String>> getVH_SRGridNumber(InputStream myStreamFile2,
                                                                              byte byteItemFile[]) {
        HashMap<String, HashMap<String, String>> resultMap = new HashMap<String, HashMap<String, String>>();
        HashMap<String, String> hMap = new HashMap<String, String>();
        HashMap<String, String> vMap = new HashMap<String, String>();
        HashMap<String, String> sMap = new HashMap<String, String>();
        HashMap<String, String> rMap = new HashMap<String, String>();
        resultMap.put("h", hMap);
        resultMap.put("v", vMap);
        resultMap.put("s", sMap);
        resultMap.put("r", rMap);
        ArrayList<Comparable> VectorHV = new ArrayList<Comparable>();
        ArrayList<Comparable> myGridsV = new ArrayList<Comparable>();
        ArrayList<Comparable> myGridsH = new ArrayList<Comparable>();
        ArrayList<Comparable> VectorS = new ArrayList<Comparable>();
        ArrayList<Comparable> myGridsSpoke = new ArrayList<Comparable>();
        ArrayList<Comparable> myGridsHR = new ArrayList<Comparable>();
        int noRows = 0;
        int noCols = 0;
        int num = 0;
        int row = 0;
        int col = 0;
        int glassNum = 0;
        double x1 = 0.0D;
        double x2 = 0.0D;
        double y1 = 0.0D;
        double y2 = 0.0D;
        double t1 = 0.0D;
        double t2 = 0.0D;
        boolean active = true;
        boolean cut = true;
        double minx = 0.0D;
        double maxx = 0.0D;
        double miny = 0.0D;
        double maxy = 0.0D;
        boolean directionH = false;
        boolean directionV = false;
        double mySlope = 0.0D;
        double m1 = 0.0D;
        byte gridDescription[] = new byte[30];
        byte gridType[] = new byte[20];
        if (myStreamFile2 != null) {
            try {
                int g_x_g_y[] = getValue_noRows_y(byteItemFile);
                noRows = g_x_g_y[0];
                noCols = g_x_g_y[1];
                ByteArrayInputStream byteInStream = null;
                DataInputStream dataIn = null;
                byte bInt[] = new byte[4];
                byte bDouble[] = new byte[8];
                byte bBoolean[] = new byte[1];
                myStreamFile2.read(gridType, 0, 20);
                myStreamFile2.read(gridDescription, 0, 30);
                myStreamFile2.read(bDouble, 0, 8);
                byteInStream = new ByteArrayInputStream(bDouble);
                dataIn = new DataInputStream(byteInStream);
                double thickG = dataIn.readDouble();
                myStreamFile2.read(bInt, 0, 4);
                byteInStream = new ByteArrayInputStream(bInt);
                dataIn = new DataInputStream(byteInStream);
                num = dataIn.readInt();
                VectorHV.clear();
                myGridsV.clear();
                myGridsH.clear();
                VectorS.clear();
                myGridsSpoke.clear();
                myGridsHR.clear();
                for (int ii = 0; ii < num; ii++) {
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    row = dataIn.readInt();
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    col = dataIn.readInt();
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    glassNum = dataIn.readInt();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    x1 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    y1 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    x2 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    y2 = dataIn.readDouble();
                    myStreamFile2.read(bBoolean, 0, 1);
                    byteInStream = new ByteArrayInputStream(bBoolean);
                    dataIn = new DataInputStream(byteInStream);
                    cut = dataIn.readBoolean();
                    myStreamFile2.read(bBoolean, 0, 1);
                    byteInStream = new ByteArrayInputStream(bBoolean);
                    dataIn = new DataInputStream(byteInStream);
                    active = dataIn.readBoolean();
                    VectorHV.add(new Integer(row));
                    VectorHV.add(new Integer(col));
                    VectorHV.add(new Integer(glassNum));
                    VectorHV.add(new Double(x1));
                    VectorHV.add(new Double(y1));
                    VectorHV.add(new Double(x2));
                    VectorHV.add(new Double(y2));
                    VectorHV.add(null);
                    VectorHV.add(new Boolean(cut));
                    VectorHV.add(new Boolean(active));
                }

                myStreamFile2.read(bInt, 0, 4);
                byteInStream = new ByteArrayInputStream(bInt);
                dataIn = new DataInputStream(byteInStream);
                num = dataIn.readInt();
                for (int ii = 0; ii < num; ii++) {
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    row = dataIn.readInt();
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    col = dataIn.readInt();
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    glassNum = dataIn.readInt();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    x1 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    y1 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    x2 = dataIn.readDouble();
                    myStreamFile2.read(bBoolean, 0, 1);
                    byteInStream = new ByteArrayInputStream(bBoolean);
                    dataIn = new DataInputStream(byteInStream);
                    cut = dataIn.readBoolean();
                    myStreamFile2.read(bBoolean, 0, 1);
                    byteInStream = new ByteArrayInputStream(bBoolean);
                    dataIn = new DataInputStream(byteInStream);
                    active = dataIn.readBoolean();
                    myGridsH.add(new Integer(row));
                    myGridsH.add(new Integer(col));
                    myGridsH.add(new Integer(glassNum));
                    myGridsH.add(null);
                    myGridsH.add(new Double(x1));
                    myGridsH.add(new Double(y1));
                    myGridsH.add(new Double(x2));
                    myGridsH.add(new Boolean(cut));
                    myGridsH.add(new Boolean(active));
                }

                myStreamFile2.read(bInt, 0, 4);
                byteInStream = new ByteArrayInputStream(bInt);
                dataIn = new DataInputStream(byteInStream);
                num = dataIn.readInt();
                for (int ii = 0; ii < num; ii++) {
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    row = dataIn.readInt();
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    col = dataIn.readInt();
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    glassNum = dataIn.readInt();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    x1 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    y1 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    x2 = dataIn.readDouble();
                    myStreamFile2.read(bBoolean, 0, 1);
                    byteInStream = new ByteArrayInputStream(bBoolean);
                    dataIn = new DataInputStream(byteInStream);
                    cut = dataIn.readBoolean();
                    myStreamFile2.read(bBoolean, 0, 1);
                    byteInStream = new ByteArrayInputStream(bBoolean);
                    dataIn = new DataInputStream(byteInStream);
                    active = dataIn.readBoolean();
                    myGridsV.add(new Integer(row));
                    myGridsV.add(new Integer(col));
                    myGridsV.add(new Integer(glassNum));
                    myGridsV.add(null);
                    myGridsV.add(new Double(x1));
                    myGridsV.add(new Double(y1));
                    myGridsV.add(new Double(x2));
                    myGridsV.add(new Boolean(cut));
                    myGridsV.add(new Boolean(active));
                }

                myStreamFile2.read(bInt, 0, 4);
                byteInStream = new ByteArrayInputStream(bInt);
                dataIn = new DataInputStream(byteInStream);
                num = dataIn.readInt();
                for (int ii = 0; ii < num; ii++) {
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    row = dataIn.readInt();
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    col = dataIn.readInt();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    x1 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    y1 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    x2 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    y2 = dataIn.readDouble();
                    myStreamFile2.read(bBoolean, 0, 1);
                    byteInStream = new ByteArrayInputStream(bBoolean);
                    dataIn = new DataInputStream(byteInStream);
                    cut = dataIn.readBoolean();
                    myStreamFile2.read(bBoolean, 0, 1);
                    byteInStream = new ByteArrayInputStream(bBoolean);
                    dataIn = new DataInputStream(byteInStream);
                    active = dataIn.readBoolean();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    t1 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    t2 = dataIn.readDouble();
                    myGridsHR.add(new Integer(row));
                    myGridsHR.add(new Integer(col));
                    myGridsHR.add(null);
                    myGridsHR.add(new Double(x1));
                    myGridsHR.add(new Double(y1));
                    myGridsHR.add(new Double(x2));
                    myGridsHR.add(new Double(y2));
                    myGridsHR.add(new Boolean(cut));
                    myGridsHR.add(new Boolean(active));
                    myGridsHR.add(new Double(t1));
                    myGridsHR.add(new Double(t2));
                }

                myStreamFile2.read(bInt, 0, 4);
                byteInStream = new ByteArrayInputStream(bInt);
                dataIn = new DataInputStream(byteInStream);
                num = dataIn.readInt();
                for (int ii = 0; ii < num; ii++) {
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    row = dataIn.readInt();
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    col = dataIn.readInt();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    x1 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    y1 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    x2 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    y2 = dataIn.readDouble();
                    myStreamFile2.read(bBoolean, 0, 1);
                    byteInStream = new ByteArrayInputStream(bBoolean);
                    dataIn = new DataInputStream(byteInStream);
                    cut = dataIn.readBoolean();
                    VectorS.add(new Integer(row));
                    VectorS.add(new Integer(col));
                    VectorS.add(null);
                    VectorS.add(new Double(x1));
                    VectorS.add(new Double(y1));
                    VectorS.add(new Double(x2));
                    VectorS.add(new Double(y2));
                    VectorS.add(new Boolean(cut));
                }

                myStreamFile2.read(bInt, 0, 4);
                byteInStream = new ByteArrayInputStream(bInt);
                dataIn = new DataInputStream(byteInStream);
                num = dataIn.readInt();
                for (int ii = 0; ii < num; ii++) {
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    row = dataIn.readInt();
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    col = dataIn.readInt();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    x1 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    y1 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    x2 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    y2 = dataIn.readDouble();
                    myStreamFile2.read(bBoolean, 0, 1);
                    byteInStream = new ByteArrayInputStream(bBoolean);
                    dataIn = new DataInputStream(byteInStream);
                    cut = dataIn.readBoolean();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    t1 = dataIn.readDouble();
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                    t2 = dataIn.readDouble();
                    myStreamFile2.read(bBoolean, 0, 1);
                    byteInStream = new ByteArrayInputStream(bBoolean);
                    dataIn = new DataInputStream(byteInStream);
                    active = dataIn.readBoolean();
                    myGridsSpoke.add(new Integer(row));
                    myGridsSpoke.add(new Integer(col));
                    myGridsSpoke.add(null);
                    myGridsSpoke.add(new Double(x1));
                    myGridsSpoke.add(new Double(y1));
                    myGridsSpoke.add(new Double(x2));
                    myGridsSpoke.add(new Double(y2));
                    myGridsSpoke.add(new Boolean(cut));
                    myGridsSpoke.add(new Double(t1));
                    myGridsSpoke.add(new Double(t2));
                    myGridsSpoke.add(new Boolean(active));
                }

                myStreamFile2.read(bInt, 0, 4);
                byteInStream = new ByteArrayInputStream(bInt);
                dataIn = new DataInputStream(byteInStream);
                num = dataIn.readInt();
                for (int ii = 0; ii < num; ii++) {
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                }

                myStreamFile2.read(bInt, 0, 4);
                byteInStream = new ByteArrayInputStream(bInt);
                dataIn = new DataInputStream(byteInStream);
                num = dataIn.readInt();
                for (int ii = 0; ii < num; ii++) {
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                }

                myStreamFile2.read(bInt, 0, 4);
                byteInStream = new ByteArrayInputStream(bInt);
                dataIn = new DataInputStream(byteInStream);
                num = dataIn.readInt();
                for (int ii = 0; ii < num; ii++) {
                    myStreamFile2.read(bDouble, 0, 8);
                    byteInStream = new ByteArrayInputStream(bDouble);
                    dataIn = new DataInputStream(byteInStream);
                }

                myStreamFile2.read(bInt, 0, 4);
                byteInStream = new ByteArrayInputStream(bInt);
                dataIn = new DataInputStream(byteInStream);
                num = dataIn.readInt();
                for (int ii = 0; ii < num; ii++) {
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                    myStreamFile2.read(bInt, 0, 4);
                    byteInStream = new ByteArrayInputStream(bInt);
                    dataIn = new DataInputStream(byteInStream);
                }

                dataIn.close();
                byteInStream.close();
                myStreamFile2.close();
            } catch (EOFException ef) {
                ef.printStackTrace();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        int count = 0;
        for (int i = 0; i < noCols; i++) {
            for (int j = 0; j < noRows; j++) {
                for (int k = 0; k < 4; k++) {
                    count = 0;
                    for (int h = 0; h < myGridsH.size() / 9; h++) {
                        if (Integer.parseInt(myGridsH.get(9 * h).toString()) == i &&
                                Integer.parseInt(myGridsH.get(9 * h + 1).toString()) == j &&
                                Integer.parseInt(myGridsH.get(9 * h + 2).toString()) == k &&
                                myGridsH.get(9 * h + 7).equals(Boolean.TRUE) &&
                                myGridsH.get(9 * h + 8).equals(Boolean.TRUE)) {
                            count++;

                        }
                    }
                    hMap.put(String.valueOf(String.valueOf((new StringBuffer(String.
                            valueOf(String.valueOf(i)))).append(",").append(j).append(",").
                            append(k))),
                            String.valueOf(String.valueOf(count)).concat(""));
                }

            }

        }

        count = 0;
        for (int i = 0; i < noCols; i++) {
            for (int j = 0; j < noRows; j++) {
                for (int k = 0; k < 4; k++) {
                    count = 0;
                    for (int h = 0; h < myGridsV.size() / 9; h++) {
                        if (Integer.parseInt(myGridsV.get(9 * h).toString()) == i &&
                                Integer.parseInt(myGridsV.get(9 * h + 1).toString()) == j &&
                                Integer.parseInt(myGridsV.get(9 * h + 2).toString()) == k &&
                                myGridsV.get(9 * h + 7).equals(Boolean.TRUE) &&
                                myGridsV.get(9 * h + 8).equals(Boolean.TRUE)) {
                            count++;

                        }
                    }
                    vMap.put(String.valueOf(String.valueOf((new StringBuffer(String.
                            valueOf(String.valueOf(i)))).append(",").append(j).append(",").
                            append(k))),
                            String.valueOf(String.valueOf(count)).concat(""));
                }

            }

        }

        count = 0;
        for (int i = 0; i < noCols; i++) {
            for (int j = 0; j < noRows; j++) {
                count = 0;
                for (int h = 0; h < myGridsHR.size() / 11; h++) {
                    if (Integer.parseInt(myGridsHR.get(11 * h).toString()) == i &&
                            Integer.parseInt(myGridsHR.get(11 * h + 1).toString()) == j &&
                            myGridsHR.get(11 * h + 7).equals(Boolean.TRUE) &&
                            myGridsHR.get(11 * h + 8).equals(Boolean.TRUE)) {
                        count++;

                    }
                }
                rMap.put(String.valueOf(String.valueOf((new StringBuffer(String.
                        valueOf(String.valueOf(i)))).append(",").append(j))),
                        String.valueOf(String.valueOf(count)).concat(""));
            }

        }

        count = 0;
        for (int i = 0; i < noCols; i++) {
            for (int j = 0; j < noRows; j++) {
                count = 0;
                for (int h = 0; h < VectorS.size() / 8; h++) {
                    if (Integer.parseInt(VectorS.get(8 * h).toString()) == i &&
                            Integer.parseInt(VectorS.get(8 * h + 1).toString()) == j &&
                            VectorS.get(8 * h + 7).equals(Boolean.TRUE)) {
                        count++;

                    }
                }
                sMap.put(String.valueOf(String.valueOf((new StringBuffer(String.
                        valueOf(String.valueOf(i)))).append(",").append(j))),
                        String.valueOf(String.valueOf(count)).concat(""));
            }

        }

        return resultMap;
    }

    protected static int[] getValue_noRows_y(byte design_Or_std_File[]) {
        int results[] = new int[2];
        int noRows = 0;
        int noCols = 0;
        InputStream myStreamFile = new ByteArrayInputStream(design_Or_std_File);
        boolean eof = false;
        try {
            if (myStreamFile != null) {
                ByteArrayInputStream byteInStream = null;
                DataInputStream dataIn = null;
                byte bInt[] = new byte[4];
                byte bDouble[] = new byte[8];
                myStreamFile.read(bInt, 0, 4);
                byteInStream = new ByteArrayInputStream(bInt);
                dataIn = new DataInputStream(byteInStream);
                noCols = dataIn.readInt();
                myStreamFile.read(bInt, 0, 4);
                byteInStream = new ByteArrayInputStream(bInt);
                dataIn = new DataInputStream(byteInStream);
                noRows = dataIn.readInt();
                results[0] = noRows;
                results[1] = noCols;
                try {
                    dataIn.close();
                    byteInStream.close();
                    myStreamFile.close();
                } catch (EOFException ef) {
                    eof = true;
                }
            }
        } catch (Exception eo) {
            eo.printStackTrace();
        }
        return results;
    }

    private static final int SPECE_FOR_IMAGE = 3;
    private static BufferedImage bufImage;
    private static Connection conSeries;
    private static String dataBaseSeries;
    private static String userIdSeries;
    private static String passWordSeries;

}
