/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

import java.io.File;
import javax.swing.filechooser.FileFilter;

// Referenced classes of package vsm:
//            Utils

public class ImageFilter extends FileFilter {

    public ImageFilter() {
    }

    public boolean accept(File f) {
        if (f.isDirectory())
            return true;
        String extension = Utils.getExtension(f);
        if (extension != null)
            return extension.equals("jpeg") || extension.equals("jpg");
        else
            return false;
    }

    public String getDescription() {
        return "JPEG Files";
    }
}
