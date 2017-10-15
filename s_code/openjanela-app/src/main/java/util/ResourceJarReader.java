/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/

package util;

import java.applet.Applet;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.swing.ImageIcon;
import javax.swing.JApplet;

public final class ResourceJarReader {

    public static boolean debugOn = false;
    private static Hashtable<String, Integer> htSizes = new Hashtable<String, Integer>();
    private static Hashtable<String, byte[]> htJarContents = new Hashtable<String, byte[]>();
    private static String jarFileName = null;
    public static HashMap<?, ?> imageIconMap = new HashMap<Object, Object>();

    private ResourceJarReader() {
    }

    public static void setJarFileName(String fileName) {
        jarFileName = fileName;
        init();
    }

    public static byte[] getResource(String name) {
        return (byte[]) htJarContents.get(((name)));
    }

    public static ImageIcon getImage(final String imageName) {
        ImageIcon ic = ((new ImageIcon(getResource(imageName)) {

            @Override
            public String getDescription() {
                return imageName;
            }

            @Override
            public String toString() {
                return imageName;
            }

        }));
        return ic;
    }

    private static void init() {
        try {
            ZipFile zf = new ZipFile(jarFileName);
            ZipEntry ze;
            for (Enumeration e = zf.entries(); e.hasMoreElements(); htSizes
                    .put(((ze.getName())), ((new Integer((int) ze.getSize()))))) {
                ze = (ZipEntry) e.nextElement();
                if (debugOn)
                    System.out.println(dumpZipEntry(ze));
            }

            zf.close();
            FileInputStream fis = new FileInputStream(jarFileName);
            BufferedInputStream bis = new BufferedInputStream(((fis)));
            ZipInputStream zis = new ZipInputStream(((bis)));
            ze = null;
            do {
                if ((ze = zis.getNextEntry()) == null)
                    break;
                if (!ze.isDirectory()) {
                    if (debugOn)
                        System.out.println(String.valueOf(((String
                                .valueOf((((new StringBuffer("ze.getName()="))
                                        .append(ze.getName()).append(",")
                                        .append("getSize()=").append(ze
                                                .getSize()))))))));
                    int size = (int) ze.getSize();
                    if (size == -1)
                        size = ((Integer) htSizes.get(((ze.getName()))))
                                .intValue();
                    byte b[] = new byte[size];
                    int rb = 0;
                    int chunk = 0;
                    do {
                        if (size - rb <= 0)
                            break;
                        chunk = zis.read(b, rb, size - rb);
                        if (chunk == -1)
                            break;
                        rb += chunk;
                    } while (true);
                    htJarContents.put(((ze.getName())), ((b)));
                    if (debugOn)
                        System.out.println(String.valueOf(((String
                                .valueOf((((new StringBuffer(String
                                        .valueOf(((String.valueOf(((ze
                                                .getName())))))))).append(
                                        "  rb=").append(rb).append(",size=")
                                        .append(size).append(",csize=")
                                        .append(ze.getCompressedSize()))))))));
                }
            } while (true);
        } catch (NullPointerException e) {
            System.out.println("done.");
        } catch (FileNotFoundException e) {
            ((Throwable) (e)).printStackTrace();
        } catch (IOException e) {
            ((Throwable) (e)).printStackTrace();
        }
    }

    private static String dumpZipEntry(ZipEntry ze) {
        StringBuffer sb = new StringBuffer();
        if (ze.isDirectory())
            sb.append("d ");
        else
            sb.append("f ");
        if (ze.getMethod() == 0)
            sb.append("stored   ");
        else
            sb.append("defaulted ");
        sb.append(ze.getName());
        sb.append("\t");
        sb.append("".concat(String.valueOf(((String.valueOf(ze.getSize()))))));
        if (ze.getMethod() == 8)
            sb.append("/".concat(String.valueOf(((String.valueOf(ze
                    .getCompressedSize()))))));
        return sb.toString();
    }

    public static void main(String args[]) throws IOException {
        setJarFileName("erpiccoloresources.jar");
        byte buff[] = getResource("1GridH.jpg");
        if (buff == null)
            System.out.println(String.valueOf(((String
                    .valueOf((((new StringBuffer("Could not find "))
                            .append(args[1]).append("."))))))));
    }

    public static ImageIcon getImageIcon(URL imageNameURL) {
        ImageIcon ic = new ImageIcon(imageNameURL);
        return ic;
    }

    public static HashMap<String, Object> loadImageIconMap() {
        HashMap<String, Object> imageIcon_Map = new HashMap<String, Object>();
        imageIcon_Map.put("imageFeature", ((getImage("Features.jpg"))));
        imageIcon_Map.put("imageShape", ((getImage("Shapes.jpg"))));
        imageIcon_Map.put("imageOpening", ((getImage("Opening.jpg"))));
        imageIcon_Map.put("imageGlass", ((getImage("Glass.jpg"))));
        imageIcon_Map.put("imageGrid", ((getImage("Grid.jpg"))));
        imageIcon_Map.put("imagenogrid", ((getImage("NoGrid.gif"))));
        imageIcon_Map.put("imagecutGrid", ((getImage("CutGrid.gif"))));
        imageIcon_Map.put("imagecutRadius", ((getImage("CutRadius.gif"))));
        imageIcon_Map.put("imagecutSpoke", ((getImage("CutSpokes.gif"))));
        imageIcon_Map.put("imageUndo", ((getImage("Undo.jpg"))));
        imageIcon_Map.put("imageS2", ((getImage("RR.jpg"))));
        imageIcon_Map.put("imageS3", ((getImage("LR.jpg"))));
        imageIcon_Map.put("imageS4", ((getImage("DT.jpg"))));
        imageIcon_Map.put("imageS5", ((getImage("PTL.jpg"))));
        imageIcon_Map.put("imageS6", ((getImage("PTR.jpg"))));
        imageIcon_Map.put("imageS7", ((getImage("PTRB.jpg"))));
        imageIcon_Map.put("imageS8", ((getImage("PTLB.jpg"))));
        imageIcon_Map.put("imageS9", ((getImage("P.jpg"))));
        imageIcon_Map.put("imageS10", ((getImage("PT.jpg"))));
        imageIcon_Map.put("imageS11", ((getImage("T.jpg"))));
        imageIcon_Map.put("imageS15", ((getImage("EHR.jpg"))));
        imageIcon_Map.put("imageS16", ((getImage("EQRL.jpg"))));
        imageIcon_Map.put("imageS17", ((getImage("EQRR.jpg"))));
        imageIcon_Map.put("imageS18", ((getImage("EQRRBLSB.jpg"))));
        imageIcon_Map.put("imageS19", ((getImage("EQRLBLSB.jpg"))));
        imageIcon_Map.put("imageS21", ((getImage("ee1.jpg"))));
        imageIcon_Map.put("imageS22", ((getImage("EHEL.jpg"))));
        imageIcon_Map.put("imageS23", ((getImage("EHER.jpg"))));
        imageIcon_Map.put("imageS24", ((getImage("EHELLSB.jpg"))));
        imageIcon_Map.put("imageS25", ((getImage("EHERLSB.jpg"))));
        imageIcon_Map.put("imageS26", ((getImage("EG.jpg"))));
        imageIcon_Map.put("imageS27", ((getImage("ee1.jpg"))));
        imageIcon_Map.put("imageS28", ((getImage("EQRL.jpg"))));
        imageIcon_Map.put("imageS29", ((getImage("EQRR.jpg"))));
        imageIcon_Map.put("imageS33", ((getImage("OCT.jpg"))));
        imageIcon_Map.put("imageS34", ((getImage("PRL.jpg"))));
        imageIcon_Map.put("shape1", ((getImage("Arect.jpg"))));
        imageIcon_Map.put("shape2", ((getImage("Atrap.jpg"))));
        imageIcon_Map.put("shape3", ((getImage("Atrap2.jpg"))));
        imageIcon_Map.put("shape4", ((getImage("Adbltrap.jpg"))));
        imageIcon_Map.put("shape5", ((getImage("Aptrap.jpg"))));
        imageIcon_Map.put("shape6", ((getImage("Aptrap2.jpg"))));
        imageIcon_Map.put("shape7", ((getImage("Aptrap2U.jpg"))));
        imageIcon_Map.put("shape8", ((getImage("AptrapU.jpg"))));
        imageIcon_Map.put("shape9", ((getImage("Apeak.jpg"))));
        imageIcon_Map.put("imageS25", ((getImage("EHERLSB.jpg"))));
        imageIcon_Map.put("shape10", ((getImage("Apoly.jpg"))));
        imageIcon_Map.put("shape11", ((getImage("Atriangle.jpg"))));
        imageIcon_Map.put("shape12", ((getImage("Atrh.jpg"))));
        imageIcon_Map.put("shape13", ((getImage("Atrh2.jpg"))));
        imageIcon_Map.put("shape14", ((getImage("Ahr.jpg"))));
        imageIcon_Map.put("shape15", ((getImage("Aextendedhr.jpg"))));
        imageIcon_Map.put("shape16", ((getImage("AextendedQR.jpg"))));
        imageIcon_Map.put("shape17", ((getImage("AextendedQR2.jpg"))));
        imageIcon_Map.put("shape18", ((getImage("Aextendedslqr2.jpg"))));
        imageIcon_Map.put("shape19", ((getImage("Aextendedsrqr.jpg"))));
        imageIcon_Map.put("shape20", ((getImage("Aellipse.jpg"))));
        imageIcon_Map.put("shape21", ((getImage("Aextendedellipse.jpg"))));
        imageIcon_Map.put("shape22", ((getImage("Aextendedhellipse.jpg"))));
        imageIcon_Map.put("shape23", ((getImage("Aextendedhellipse2.jpg"))));
        imageIcon_Map.put("shape24", ((getImage("Aextendedhellipselt.jpg"))));
        imageIcon_Map.put("shape25", ((getImage("Aextendedhellipsert.jpg"))));
        imageIcon_Map.put("shape26", ((getImage("Aextendedgothic.jpg"))));
        imageIcon_Map.put("shape27", ((getImage("Aextendedellipse.jpg"))));
        imageIcon_Map.put("shape28", ((getImage("AextendedQR.jpg"))));
        imageIcon_Map.put("shape29", ((getImage("AextendedQR2.jpg"))));
        imageIcon_Map.put("shape31", ((getImage("Agothic.jpg"))));
        imageIcon_Map.put("shape32", ((getImage("Acircle.jpg"))));
        imageIcon_Map.put("shape33", ((getImage("Octagon.jpg"))));
        imageIcon_Map.put("shape34", ((getImage("Aparallellogram.jpg"))));
        imageIcon_Map.put("shape35", ((getImage("Abasket.jpg"))));
        imageIcon_Map.put("shape36", ((getImage("Aqbasket.jpg"))));
        imageIcon_Map.put("shape37", ((getImage("Aqbasket2.jpg"))));
        imageIcon_Map.put("shape38", ((getImage("Aqellipse.jpg"))));
        imageIcon_Map.put("shape39", ((getImage("Aqellipse2.jpg"))));
        imageIcon_Map.put("shape42", ((getImage("Aqr.jpg"))));
        imageIcon_Map.put("shape43", ((getImage("Aqr2.jpg"))));
        imageIcon_Map.put("Feature1", ((getImage("VCoupler.jpg"))));
        imageIcon_Map.put("Feature1_a", ((getImage("VCoupler1.jpg"))));
        imageIcon_Map.put("Feature1_b", ((getImage("VCoupler2.jpg"))));
        imageIcon_Map.put("Feature1_c", ((getImage("VCoupler3.jpg"))));
        imageIcon_Map.put("Feature2", ((Object) (getImage("HCoupler.jpg"))));
        imageIcon_Map.put("Feature2_a", ((Object) (getImage("HCoupler1.jpg"))));
        imageIcon_Map.put("Feature2_b", ((Object) (getImage("HCoupler2.jpg"))));
        imageIcon_Map.put("Feature2_c", ((Object) (getImage("HCoupler3.jpg"))));
        imageIcon_Map.put("Feature3", ((Object) (getImage("VMullion.jpg"))));
        imageIcon_Map.put("Feature3_a", ((Object) (getImage("VMullion1.jpg"))));
        imageIcon_Map.put("Feature3_b", ((Object) (getImage("VMullion2.jpg"))));
        imageIcon_Map.put("Feature3_c", ((Object) (getImage("VMullion3.jpg"))));
        imageIcon_Map.put("Feature4", ((Object) (getImage("HMullion.jpg"))));
        imageIcon_Map.put("Feature4_a", ((Object) (getImage("HMullion1.jpg"))));
        imageIcon_Map.put("Feature4_b", ((Object) (getImage("HMullion2.jpg"))));
        imageIcon_Map.put("Feature4_c", ((Object) (getImage("HMullion3.jpg"))));
        ImageIcon iconTmp = getImage("Apic.jpg");
        iconTmp.setDescription("Apic.jpg");
        imageIcon_Map.put("Opening1", ((Object) (iconTmp)));
        iconTmp = getImage("Afs.jpg");
        iconTmp.setDescription("Afs.jpg");
        imageIcon_Map.put("Opening2", ((Object) (iconTmp)));
        iconTmp = getImage("Arh.jpg");
        iconTmp.setDescription("Arh.jpg");
        imageIcon_Map.put("Opening3", ((Object) (iconTmp)));
        iconTmp = getImage("Alh.jpg");
        iconTmp.setDescription("Alh.jpg");
        imageIcon_Map.put("Opening4", ((Object) (iconTmp)));
        iconTmp = getImage("Aawn.jpg");
        iconTmp.setDescription("Aawn.jpg");
        imageIcon_Map.put("Opening5", ((Object) (iconTmp)));
        iconTmp = getImage("Acasf.jpg");
        iconTmp.setDescription("Acasf.jpg");
        imageIcon_Map.put("Opening6", ((Object) (iconTmp)));
        iconTmp = getImage("Adh.jpg");
        iconTmp.setDescription("Adh.jpg");
        imageIcon_Map.put("Opening7", ((Object) (iconTmp)));
        iconTmp = getImage("Ash.jpg");
        iconTmp.setDescription("Ash.jpg");
        imageIcon_Map.put("Opening8", ((Object) (iconTmp)));
        iconTmp = getImage("A1lsr.jpg");
        iconTmp.setDescription("Allsr.jpg");
        imageIcon_Map.put("Opening9", ((Object) (iconTmp)));
        iconTmp = getImage("A1lsl.jpg");
        iconTmp.setDescription("Alls1.jpg");
        imageIcon_Map.put("Opening10", ((Object) (iconTmp)));
        iconTmp = getImage("A2ls.jpg");
        iconTmp.setDescription("A21s.jpg");
        imageIcon_Map.put("Opening11", ((Object) (iconTmp)));
        iconTmp = getImage("A3ls.jpg");
        iconTmp.setDescription("A31s.jpg");
        imageIcon_Map.put("Opening12", ((Object) (iconTmp)));
        iconTmp = getImage("A4ls.jpg");
        iconTmp.setDescription("A41s.jpg");
        imageIcon_Map.put("Opening13", ((Object) (iconTmp)));
        iconTmp = getImage("Afsrf.jpg");
        iconTmp.setDescription("Afsrf.jpg");
        imageIcon_Map.put("Opening14", ((Object) (iconTmp)));
        iconTmp = getImage("Afslf.jpg");
        iconTmp.setDescription("Afs1f.jpg");
        imageIcon_Map.put("Opening15", ((Object) (iconTmp)));
        iconTmp = getImage("Abislide.jpg");
        iconTmp.setDescription("Abislide.jpg");
        imageIcon_Map.put("Opening16", ((Object) (iconTmp)));
        iconTmp = getImage("Ahop.jpg");
        iconTmp.setDescription("Ahop.jpg");
        imageIcon_Map.put("Opening17", ((Object) (iconTmp)));
        iconTmp = getImage("Attr.jpg");
        iconTmp.setDescription("Attr.jpg");
        imageIcon_Map.put("Opening18", ((Object) (iconTmp)));
        iconTmp = getImage("Attl.jpg");
        iconTmp.setDescription("Att1.jpg");
        imageIcon_Map.put("Opening19", ((Object) (iconTmp)));
        iconTmp = getImage("Alttf.jpg");
        iconTmp.setDescription("A1ttf.jpg");
        imageIcon_Map.put("Opening20", ((Object) (iconTmp)));
        iconTmp = getImage("Arttf.jpg");
        iconTmp.setDescription("Arttf.jpg");
        imageIcon_Map.put("Opening21", ((Object) (iconTmp)));
        iconTmp = getImage("Areversibleh.jpg");
        iconTmp.setDescription("Areversibleh.jpg");
        imageIcon_Map.put("Opening22", ((Object) (iconTmp)));
        iconTmp = getImage("Areversible.jpg");
        iconTmp.setDescription("Areversible.jpg");
        imageIcon_Map.put("Opening23", ((Object) (iconTmp)));
        iconTmp = getImage("Apivotv.jpg");
        iconTmp.setDescription("Apivotv.jpg");
        imageIcon_Map.put("Opening24", ((Object) (iconTmp)));
        iconTmp = getImage("Apivoth.jpg");
        iconTmp.setDescription("Apivoth.jpg");
        imageIcon_Map.put("Opening25", ((Object) (iconTmp)));
        iconTmp = getImage("TFBF.jpg");
        iconTmp.setDescription("TFBF.jpg");
        imageIcon_Map.put("Opening26", ((Object) (iconTmp)));
        iconTmp = getImage("CSRS.jpg");
        iconTmp.setDescription("CSRS.jpg");
        imageIcon_Map.put("Opening27", ((Object) (iconTmp)));
        iconTmp = getImage("CSLS.jpg");
        iconTmp.setDescription("CSLS.jpg");
        imageIcon_Map.put("Opening28", ((Object) (iconTmp)));
        iconTmp = getImage("L3SS.jpg");
        iconTmp.setDescription("L3SS.jpg");
        imageIcon_Map.put("Opening29", ((Object) (iconTmp)));
        iconTmp = getImage("R3SS.jpg");
        iconTmp.setDescription("R3SS.jpg");
        imageIcon_Map.put("Opening30", ((Object) (iconTmp)));
        iconTmp = getImage("4LSS.jpg");
        iconTmp.setDescription("4LSS.jpg");
        imageIcon_Map.put("Opening31", ((Object) (iconTmp)));
        iconTmp = getImage("3LSS.jpg");
        iconTmp.setDescription("3LSS.jpg");
        imageIcon_Map.put("Opening32", ((Object) (iconTmp)));
        iconTmp = getImage("SSLS.jpg");
        iconTmp.setDescription("SSLS.jpg");
        imageIcon_Map.put("Opening33", ((Object) (iconTmp)));
        iconTmp = getImage("SSRS.jpg");
        iconTmp.setDescription("SSRS.jpg");
        imageIcon_Map.put("Opening34", ((Object) (iconTmp)));
        iconTmp = getImage("THS.jpg");
        iconTmp.setDescription("THS.jpg");
        imageIcon_Map.put("Opening35", ((Object) (iconTmp)));
        iconTmp = getImage("BHS.jpg");
        iconTmp.setDescription("BHS.jpg");
        imageIcon_Map.put("Opening36", ((Object) (iconTmp)));
        imageIcon_Map.put("Bay Graphic.gif",
                ((Object) (getImage("BayGraphic.gif"))));
        imageIcon_Map.put("Bow Graphic.gif",
                ((Object) (getImage("BowGraphic.gif"))));
        return imageIcon_Map;
    }

    public static byte[] getResourceJarReadersSrcByte(JApplet jApplet,
                                                      String imageName) {
        InputStream in = null;
        byte b[] = new byte[0];
        int size = 0;
        in = ((Object) (jApplet)).getClass().getResourceAsStream(
                "/".concat(String.valueOf(((Object) (String
                        .valueOf(((Object) (imageName))))))));
        try {
            if (in == null)
                System.out.println("imageName is: ".concat(String
                        .valueOf(((Object) (String
                                .valueOf(((Object) (imageName))))))));
            size = in.available();
            b = new byte[size];
            in.read(b);
        } catch (IOException e) {
            ((Throwable) (e)).printStackTrace();
        } catch (Exception ex) {
            ((Throwable) (ex)).printStackTrace();
        }
        return b;
    }

    public static HashMap loadImageIconMap(JApplet loginApplet)
            throws MalformedURLException {
        HashMap imageIcon_Map = new HashMap();
        System.out.println(((Object) (((Applet) (loginApplet)).getCodeBase())));
        String codeBase = "http://localhost/quote/";
        String imageFolder = "quote/images";
        String finalPath = "http://localhost/quote/quote/images";
        finalPath = String.valueOf(
                ((Object) (String.valueOf(((Object) (((Applet) (loginApplet))
                        .getCodeBase())))))).concat("images");
        byte imageNeedSrc[] = new byte[0];
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Features.jpg"));
        imageIcon_Map.put("imageFeature",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Shapes.jpg"));
        imageIcon_Map.put("imageShape",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Opening.jpg"));
        imageIcon_Map.put("imageOpening",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Grid.jpg"));
        imageIcon_Map
                .put("imageGrid", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Glass.jpg"));
        imageIcon_Map.put("imageGlass",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/NoGrid.gif"));
        imageIcon_Map.put("imagenogrid",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/CutGrid.gif"));
        imageIcon_Map.put("imagecutGrid",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/CutRadius.gif"));
        imageIcon_Map.put("imagecutRadius", ((Object) (new ImageIcon(
                imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/CutSpokes.gif"));
        imageIcon_Map.put("imagecutSpoke", ((Object) (new ImageIcon(
                imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Undo.jpg"));
        imageIcon_Map
                .put("imageUndo", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/RR.jpg"));
        imageIcon_Map.put("imageS2", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/LR.jpg"));
        imageIcon_Map.put("imageS3", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/DT.jpg"));
        imageIcon_Map.put("imageS4", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/PTL.jpg"));
        imageIcon_Map.put("imageS5", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/PTR.jpg"));
        imageIcon_Map.put("imageS6", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/PTRB.jpg"));
        imageIcon_Map.put("imageS7", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/PTLB.jpg"));
        imageIcon_Map.put("imageS8", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/P.jpg"));
        imageIcon_Map.put("imageS9", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/PT.jpg"));
        imageIcon_Map.put("imageS10", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/T.jpg"));
        imageIcon_Map.put("imageS11", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/EHR.jpg"));
        imageIcon_Map.put("imageS15", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/EQRL.jpg"));
        imageIcon_Map.put("imageS16", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/EQRR.jpg"));
        imageIcon_Map.put("imageS17", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/EQRRBLSB.jpg"));
        imageIcon_Map.put("imageS18", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/EQRLBLSB.jpg"));
        imageIcon_Map.put("imageS19", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/ee1.jpg"));
        imageIcon_Map.put("imageS21", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/EHEL.jpg"));
        imageIcon_Map.put("imageS22", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/EHER.jpg"));
        imageIcon_Map.put("imageS23", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/EHELLSB.jpg"));
        imageIcon_Map.put("imageS24", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/EHERLSB.jpg"));
        imageIcon_Map.put("imageS25", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/EG.jpg"));
        imageIcon_Map.put("imageS26", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/ee1.jpg"));
        imageIcon_Map.put("imageS27", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/EQRL.jpg"));
        imageIcon_Map.put("imageS28", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/EQRR.jpg"));
        imageIcon_Map.put("imageS29", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/OCT.jpg"));
        imageIcon_Map.put("imageS33", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/PRL.jpg"));
        imageIcon_Map.put("imageS34", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Arect.jpg"));
        imageIcon_Map.put("shape1", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Atrap.jpg"));
        imageIcon_Map.put("shape2", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Atrap2.jpg"));
        imageIcon_Map.put("shape3", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Adbltrap.jpg"));
        imageIcon_Map.put("shape4", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aptrap.jpg"));
        imageIcon_Map.put("shape5", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aptrap2.jpg"));
        imageIcon_Map.put("shape6", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aptrap2U.jpg"));
        imageIcon_Map.put("shape7", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/AptrapU.jpg"));
        imageIcon_Map.put("shape8", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Apeak.jpg"));
        imageIcon_Map.put("shape9", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/EHERLSB.jpg"));
        imageIcon_Map.put("imageS25", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Apoly.jpg"));
        imageIcon_Map.put("shape10", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Atriangle.jpg"));
        imageIcon_Map.put("shape11", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Atrh.jpg"));
        imageIcon_Map.put("shape12", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Atrh2.jpg"));
        imageIcon_Map.put("shape13", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Ahr.jpg"));
        imageIcon_Map.put("shape14", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aextendedhr.jpg"));
        imageIcon_Map.put("shape15", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/AextendedQR.jpg"));
        imageIcon_Map.put("shape16", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/AextendedQR2.jpg"));
        imageIcon_Map.put("shape17", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aextendedslqr2.jpg"));
        imageIcon_Map.put("shape18", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aextendedsrqr.jpg"));
        imageIcon_Map.put("shape19", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aellipse.jpg"));
        imageIcon_Map.put("shape20", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aextendedellipse.jpg"));
        imageIcon_Map.put("shape21", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aextendedhellipse.jpg"));
        imageIcon_Map.put("shape22", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aextendedhellipse2.jpg"));
        imageIcon_Map.put("shape23", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aextendedhellipselt.jpg"));
        imageIcon_Map.put("shape24", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aextendedhellipsert.jpg"));
        imageIcon_Map.put("shape25", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aextendedgothic.jpg"));
        imageIcon_Map.put("shape26", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aextendedellipse.jpg"));
        imageIcon_Map.put("shape27", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/AextendedQR.jpg"));
        imageIcon_Map.put("shape28", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/AextendedQR2.jpg"));
        imageIcon_Map.put("shape29", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Agothic.jpg"));
        imageIcon_Map.put("shape31", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Acircle.jpg"));
        imageIcon_Map.put("shape32", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Octagon.jpg"));
        imageIcon_Map.put("shape33", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aparallellogram.jpg"));
        imageIcon_Map.put("shape34", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Abasket.jpg"));
        imageIcon_Map.put("shape35", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aqbasket.jpg"));
        imageIcon_Map.put("shape36", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aqbasket2.jpg"));
        imageIcon_Map.put("shape37", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aqellipse.jpg"));
        imageIcon_Map.put("shape38", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aqellipse2.jpg"));
        imageIcon_Map.put("shape39", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aqr.jpg"));
        imageIcon_Map.put("shape42", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aqr2.jpg"));
        imageIcon_Map.put("shape43", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/VCoupler.jpg"));
        imageIcon_Map.put("Feature1", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/VCoupler1.jpg"));
        imageIcon_Map.put("Feature1_a",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/VCoupler2.jpg"));
        imageIcon_Map.put("Feature1_b",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/VCoupler3.jpg"));
        imageIcon_Map.put("Feature1_c",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/HCoupler.jpg"));
        imageIcon_Map.put("Feature2", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/HCoupler1.jpg"));
        imageIcon_Map.put("Feature2_a",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/HCoupler2.jpg"));
        imageIcon_Map.put("Feature2_b",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/HCoupler3.jpg"));
        imageIcon_Map.put("Feature2_c",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/VMullion.jpg"));
        imageIcon_Map.put("Feature3", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/VMullion1.jpg"));
        imageIcon_Map.put("Feature3_a",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/VMullion2.jpg"));
        imageIcon_Map.put("Feature3_b",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/VMullion3.jpg"));
        imageIcon_Map.put("Feature3_c",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/HMullion.jpg"));
        imageIcon_Map.put("Feature4", ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/HMullion1.jpg"));
        imageIcon_Map.put("Feature4_a",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/HMullion2.jpg"));
        imageIcon_Map.put("Feature4_b",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/HMullion3.jpg"));
        imageIcon_Map.put("Feature4_c",
                ((Object) (new ImageIcon(imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Apic.jpg"));
        ImageIcon iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Apic.jpg");
        imageIcon_Map.put("Opening1", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Afs.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Afs.jpg");
        imageIcon_Map.put("Opening2", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Arh.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Arh.jpg");
        imageIcon_Map.put("Opening3", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Alh.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Alh.jpg");
        imageIcon_Map.put("Opening4", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Aawn.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Aawn.jpg");
        imageIcon_Map.put("Opening5", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Acasf.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Acasf.jpg");
        imageIcon_Map.put("Opening6", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Adh.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Adh.jpg");
        imageIcon_Map.put("Opening7", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Ash.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Ash.jpg");
        imageIcon_Map.put("Opening8", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/A1lsr.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Allsr.jpg");
        imageIcon_Map.put("Opening9", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/A1lsl.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Alls1.jpg");
        imageIcon_Map.put("Opening10", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/A2ls.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("A21s.jpg");
        imageIcon_Map.put("Opening11", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/A3ls.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("A31s.jpg");
        imageIcon_Map.put("Opening12", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/A4ls.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("A41s.jpg");
        imageIcon_Map.put("Opening13", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Afsrf.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Afsrf.jpg");
        imageIcon_Map.put("Opening14", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Afslf.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Afs1f.jpg");
        imageIcon_Map.put("Opening15", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Abislide.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Abislide.jpg");
        imageIcon_Map.put("Opening16", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Ahop.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Ahop.jpg");
        imageIcon_Map.put("Opening17", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Attr.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Attr.jpg");
        imageIcon_Map.put("Opening18", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Attl.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Att1.jpg");
        imageIcon_Map.put("Opening19", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Alttf.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("A1ttf.jpg");
        imageIcon_Map.put("Opening20", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Arttf.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Arttf.jpg");
        imageIcon_Map.put("Opening21", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Areversibleh.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Areversibleh.jpg");
        imageIcon_Map.put("Opening22", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Areversible.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Areversible.jpg");
        imageIcon_Map.put("Opening23", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Apivotv.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Apivotv.jpg");
        imageIcon_Map.put("Opening24", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/Apivoth.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("Apivoth.jpg");
        imageIcon_Map.put("Opening25", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/TFBF.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("TFBF.jpg");
        imageIcon_Map.put("Opening26", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/CSRS.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("CSRS.jpg");
        imageIcon_Map.put("Opening27", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/CSLS.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("CSLS.jpg");
        imageIcon_Map.put("Opening28", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/L3SS.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("L3SS.jpg");
        imageIcon_Map.put("Opening29", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/R3SS.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("R3SS.jpg");
        imageIcon_Map.put("Opening30", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/4LSS.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("4LSS.jpg");
        imageIcon_Map.put("Opening31", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/3LSS.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("3LSS.jpg");
        imageIcon_Map.put("Opening32", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/SSLS.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("SSLS.jpg");
        imageIcon_Map.put("Opening33", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/SSRS.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("SSRS.jpg");
        imageIcon_Map.put("Opening34", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/THS.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("THS.jpg");
        imageIcon_Map.put("Opening35", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/BHS.jpg"));
        iconTmp = new ImageIcon(imageNeedSrc);
        iconTmp.setDescription("BHS.jpg");
        imageIcon_Map.put("Opening36", ((Object) (iconTmp)));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/BayGraphic.gif"));
        imageIcon_Map.put("Bay Graphic.gif", ((Object) (new ImageIcon(
                imageNeedSrc))));
        imageNeedSrc = getResourceJarReadersSrcByte(loginApplet, String
                .valueOf(((Object) (String.valueOf(((Object) (finalPath))))))
                .concat("/BowGraphic.gif"));
        imageIcon_Map.put("Bow Graphic.gif", ((Object) (new ImageIcon(
                imageNeedSrc))));
        return imageIcon_Map;
    }

}
