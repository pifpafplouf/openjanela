package org.openjanela.commons.util.file;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 * <p/>
 * This Enum represents the difference types of files to generate by the system
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-25-13
 *          Time: 10:08 AM
 */
public enum FilesFormat {

    TXT(".txt"),
    CSV(".csv"),
    ORD(".ord"),
    DAT(".DAT"),
    CUT(".CUT");

    private String type;

    FilesFormat(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
