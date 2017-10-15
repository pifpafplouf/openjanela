package org.openjanela.commons.util.zip;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-08-13
 *          Time: 08:47 AM
 */
public class GZipFile {

    /**
     * This compress byte[] reducing weight
     *
     * @param content, byte[]
     * @return byte[]
     */
    public static byte[] gzipCompress(byte[] content) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        GZIPOutputStream gzos = new GZIPOutputStream(baos);
        gzos.write(content);

        gzos.close();

        return baos.toByteArray();
    }

    /**
     * This method decompress byte[] to original weight
     *
     * @param content, byte[]
     * @return byte[]
     * @throws IOException, Exception
     */
    public static byte[] gzipDecompress(byte[] content) throws IOException {

        ByteArrayInputStream bais = new ByteArrayInputStream(content);
        GZIPInputStream gzis = new GZIPInputStream(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int numBytesRead = 0;
        byte[] tempBytes = new byte[6000];

        while ((numBytesRead = gzis.read(tempBytes, 0, tempBytes.length)) != -1) {
            baos.write(tempBytes, 0, numBytesRead);
        }

        return baos.toByteArray();
    }

    /**
     * This method compress object to GZIP byte Array
     *
     * @param object, Object
     * @return byte[]
     * @throws IOException, Exception
     */
    public static byte[] gzipObjectToBytes(Object object) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        GZIPOutputStream gzos = new GZIPOutputStream(baos);
        ObjectOutputStream oos = new ObjectOutputStream(gzos);

        oos.writeObject(object);

        oos.flush();
        oos.close();
        gzos.close();

        return baos.toByteArray();
    }

    /**
     * This method decompressed byteArray to Object
     *
     * @param bytesArray, byte[]
     * @return Object
     * @throws IOException,            Exception
     * @throws ClassNotFoundException, Exception
     */
    public static Object gzipBytesToObject(byte[] bytesArray) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytesArray);
        GZIPInputStream gzis = new GZIPInputStream(bais);
        ObjectInputStream ois = new ObjectInputStream(gzis);

        return ois.readObject();
    }

    /**
     * This method save create and save compress object to GZIP format
     *
     * @param fileName, File name to compress
     * @param object,   Object to compress
     * @return ObjectOutputStream
     * @throws IOException, Exception
     */
    public static void gzipObjectFile(String fileName, Object object) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\" + fileName + ".gz");
        GZIPOutputStream gzos = new GZIPOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(gzos);

        oos.writeObject(object);

        oos.flush();
        oos.close();
        gzos.close();
        fos.close();
    }

}
