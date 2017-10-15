package org.openjanela.commons.util.test;

import org.openjanela.commons.util.security.Security;

import java.io.UnsupportedEncodingException;
import java.lang.System;
import java.security.NoSuchAlgorithmException;

/**
 * Copyright (c) 2011-2013, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 03-04-13
 * Time: 10:35 PM
 */
public class SecurityTest {

    /**
     * This method generate a password hash to encode with base16
     *
     * @param password, String
     * @return String
     */
    private static String encodePasswordHash(String password) {

        try {
            String passwordHash = Security.createHashString(password);
            return Security.encodeBase16(passwordHash.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.getMessage());
        }

        return "";
    }

    public static void main(String args[]) {

        System.out.println("LocalHost:" + Security.encodeBase64("localhost"));
        System.out.println("LocalUsername:" + Security.encodeBase64("root"));
        System.out.println("LocalPassword:" + Security.encodeBase64("root"));

        System.out.println("RemoteHost:" + Security.encodeBase64("10.0.0.1"));
        System.out.println("RemoteUser:" + Security.encodeBase64("openjanela"));
        System.out.println("RemotePassword:" + Security.encodeBase64("$N3wS0ut4!"));

        System.out.println("RemoteMailHost: " + Security.encodeBase64("openjanelacom.ipage.com"));
        System.out.println("RemoteUser: " + Security.encodeBase64("emontenegro@openjanela.com"));
        System.out.println("RemotePassword: " + Security.encodeBase64("Monte5121984!"));
    }
}
