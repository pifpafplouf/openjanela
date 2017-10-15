package org.openjanela.commons.util.security;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class SecurityTest {

    /**
     * This method generate a password hash to encode with base16
     *
     * @param password , String
     * @return String
     */
    public static String encodePasswordHash(String password) {

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
        System.out.println("Host: " + Security.encodeBase64("69.60.98.254"));
        System.out.println("user: " + Security.encodeBase64("root"));
        System.out.println("password: " + Security.encodeBase64("1OllX9xi21"));
    }

}
