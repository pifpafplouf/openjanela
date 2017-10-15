/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileView;

// Referenced classes of package vsm:
//            Utils

public class ImageFileView extends FileView {

    public ImageFileView() {
    }

    public String getName(File f) {
        return null;
    }

    public String getDescription(File f) {
        return null;
    }

    public Boolean isTraversable(File f) {
        return null;
    }

    public String getTypeDescription(File f) {
        String extension = Utils.getExtension(f);
        String type = null;
        if (extension != null && (extension.equals("jpeg") || extension.equals("jpg")))
            type = "JPEG Image";
        return type;
    }

    public Icon getIcon(File f) {
        String extension = Utils.getExtension(f);
        Icon icon = null;
        if (extension != null && !extension.equals("jpeg"))
            if (!extension.equals("jpg")) ;
        return icon;
    }
}
