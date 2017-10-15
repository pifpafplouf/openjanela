package org.openjanela.commons.util.security;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Copyright (c) 2011-2013, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 03-04-13
 * Time: 04:55 PM
 */
public class Security {

    //Log4j
    private static final Logger logger = Logger.getLogger(Security.class);

    /**
     * This method generate a hash value from base string
     *
     * @param baseString, String
     * @return String
     * @throws NoSuchAlgorithmException, Exception
     */
    public static String createHashString(String baseString) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        if (logger.isDebugEnabled())
            logger.debug("Base string: " + baseString);

        // convert password to byte data
        byte[] passBytes = baseString.getBytes();

        // Hash bytes
        byte[] hash = MessageDigest.getInstance("MD5").digest(passBytes);

        // Encode base16
        String passwordHash = encodeBase16(hash);

        if (logger.isDebugEnabled())
            logger.debug("Hash : " + passwordHash);

        return passwordHash;

    }

    /**
     * This method encode base string to Base64 encoding
     *
     * @param baseString, String
     * @return String
     */
    public static String encodeBase64(String baseString) {
        byte[] encode = Base64.encodeBase64(baseString.getBytes());

        return new String(encode);
    }

    /**
     * This method encode base byte to Base64 encoding
     *
     * @param bytes, byte[]
     * @return String
     */
    public static String encodeBase64(byte[] bytes) {
        byte[] encode = Base64.encodeBase64(bytes);

        return new String(encode);
    }

    /**
     * This method decode base string from Base64
     *
     * @param baseString, String
     * @return String
     */
    public static String decodeBase64(String baseString) {
        byte[] decode = Base64.decodeBase64(baseString.getBytes());

        return new String(decode);
    }

    /**
     * This method decode base string from Base64 to byte[]
     *
     * @param baseString, String
     * @return byte[]
     */
    public static byte[] decodeBase64ToByte(String baseString) {
        return Base64.decodeBase64(baseString);
    }

    /**
     * Base16 encoding (HEX).
     */
    public static String encodeBase16(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            // top 4 bits
            char c = (char) ((b >> 4) & 0xf);
            if (c > 9)
                c = (char) ((c - 10) + 'a');
            else
                c = (char) (c + '0');
            sb.append(c);
            // bottom 4 bits
            c = (char) (b & 0xf);
            if (c > 9)
                c = (char) ((c - 10) + 'a');
            else
                c = (char) (c + '0');
            sb.append(c);
        }
        return sb.toString();
    }
}
