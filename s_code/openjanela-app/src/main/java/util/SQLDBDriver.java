/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 * 
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/

package util;

import java.applet.Applet;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.zip.*;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import java.awt.*;
import javax.swing.*;

public final class SQLDBDriver {

  public static boolean debugOn = false;
  private static Hashtable<Object, Object> htSizes = new Hashtable<Object, Object>();
  private static Hashtable<Object, Object> htJarContents = new Hashtable<Object, Object>();
  private static String jarFileName = null;
  public static HashMap<?, ?> imageIconMap = new HashMap<Object, Object>();

  private SQLDBDriver() {
  }

  public static void setJarFileName(String fileName) {
    jarFileName = fileName;
    init();
  }

  public static byte[] getResource(String name) {
    return (byte[]) htJarContents.get( ( (Object) (name)));
  }

  private static void init() {
    try {
      ZipFile zf = new ZipFile(jarFileName);
      ZipEntry ze;
      for (Enumeration e = zf.entries(); e.hasMoreElements();
           htSizes.put( ( (Object) (ze.getName())),
                       ( (Object) (new Integer( (int) ze.getSize()))))) {
        ze = (ZipEntry) e.nextElement();
        if (debugOn) {
          System.out.println(dumpZipEntry(ze));
        }
      }

      zf.close();
      FileInputStream fis = new FileInputStream(jarFileName);
      BufferedInputStream bis = new BufferedInputStream( ( (InputStream) (fis)));
      ZipInputStream zis = new ZipInputStream( ( (InputStream) (bis)));
      ze = null;
      do {
        if ( (ze = zis.getNextEntry()) == null) {
          break;
        }
        if (!ze.isDirectory()) {
          if (debugOn) {
            System.out.println(String.valueOf( ( (Object) (String.valueOf( ( (
                Object) ( (new StringBuffer("ze.getName()=")).append(ze.getName()).
                         append(",").append("getSize()=").append(ze.getSize()))))))));
          }
          int size = (int) ze.getSize();
          if (size == -1) {
            size = ( (Integer) htSizes.get( ( (Object) (ze.getName())))).
                intValue();
          }
          byte b[] = new byte[size];
          int rb = 0;
          int chunk = 0;
          do {
            if (size - rb <= 0) {
              break;
            }
            chunk = zis.read(b, rb, size - rb);
            if (chunk == -1) {
              break;
            }
            rb += chunk;
          }
          while (true);
          htJarContents.put( ( (Object) (ze.getName())), ( (Object) (b)));
          if (debugOn) {
            System.out.println(String.valueOf( ( (Object) (String.valueOf( ( (
                Object) ( (new StringBuffer(String.valueOf( ( (Object) (String.
                valueOf( ( (Object) (ze.getName())))))))).append("  rb=").
                         append(rb).append(",size=").append(size).append(
                ",csize=").append(ze.getCompressedSize()))))))));
          }
        }
      }
      while (true);
    }
    catch (NullPointerException e) {
      System.out.println("done.");
    }
    catch (FileNotFoundException e) {
      ( (Throwable) (e)).printStackTrace();
    }
    catch (IOException e) {
      ( (Throwable) (e)).printStackTrace();
    }
  }

  private static String dumpZipEntry(ZipEntry ze) {
    StringBuffer sb = new StringBuffer();
    if (ze.isDirectory()) {
      sb.append("d ");
    }
    else {
      sb.append("f ");
    }
    if (ze.getMethod() == 0) {
      sb.append("stored   ");
    }
    else {
      sb.append("defalted ");
    }
    sb.append(ze.getName());
    sb.append("\t");
    sb.append("".concat(String.valueOf( ( (Object) (String.valueOf(ze.getSize()))))));
    if (ze.getMethod() == 8) {
      sb.append("/".concat(String.valueOf( ( (Object) (String.valueOf(ze.
          getCompressedSize()))))));
    }
    return sb.toString();
  }

  public static void main(String args[]) throws IOException {
    setJarFileName("erpiccoloresources.jar");
    byte buff[] = getResource("Driver.class");
    if (buff == null) {
      System.out.println(String.valueOf( ( (Object) (String.valueOf( ( (Object) ( (new
          StringBuffer("Could not find ")).append(args[1]).append("."))))))));
    }
  }



}
