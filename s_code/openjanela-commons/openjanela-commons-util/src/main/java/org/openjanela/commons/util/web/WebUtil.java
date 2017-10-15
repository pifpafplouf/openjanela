package org.openjanela.commons.util.web;

import hirondelle.web4j.util.Util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Static convenience methods for common web-related tasks.
 */
public final class WebUtil {

    /**
     * Validate the form of an email address.
     * <p/>
     * <P>Return <tt>true</tt> only if
     * <ul>
     * <li> <tt>aEmailAddress</tt> can successfully construct an
     * {@link javax.mail.internet.InternetAddress}
     * <li> when parsed with "@" as delimiter, <tt>aEmailAddress</tt> contains
     * two tokens which satisfy {@link hirondelle.web4j.util.Util#textHasContent}.
     * </ul>
     * <p/>
     * <P> The second condition arises since local email addresses, simply of the form
     * "<tt>albert</tt>", for example, are valid for
     * {@link javax.mail.internet.InternetAddress}, but almost always undesired.
     */
    public static boolean isValidEmailAddress(String aEmailAddress) {
        if (aEmailAddress == null) return false;
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(aEmailAddress);
            if (!hasNameAndDomain(aEmailAddress)) {
                result = false;
            }
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    private static boolean hasNameAndDomain(String aEmailAddress) {
        String[] tokens = aEmailAddress.split("@");
        return
                tokens.length == 2 &&
                        Util.textHasContent(tokens[0]) &&
                        Util.textHasContent(tokens[1]);
    }
}
