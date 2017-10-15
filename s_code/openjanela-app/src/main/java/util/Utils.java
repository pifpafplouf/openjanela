/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

import java.io.File;

public class Utils {

    public Utils() {
    }

    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');
        if (i > 0 && i < s.length() - 1)
            ext = s.substring(i + 1).toLowerCase();
        return ext;
    }

    public static final String jpeg = "jpeg";
    public static final String jpg = "jpg";
    public static final String rpt = "rpt";
    public static final String xml = "xml";

}
