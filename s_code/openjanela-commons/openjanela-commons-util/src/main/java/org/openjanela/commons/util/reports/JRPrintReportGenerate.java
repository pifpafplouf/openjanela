package org.openjanela.commons.util.reports;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-26-13
 *          Time: 10:41 AM
 */
public enum JRPrintReportGenerate {

    CVS(".csv"),
    DOC(".doc"),
    HTML(".html"),
    EXCEL(".xls"),
    PDF(".pdf"),
    RTF(".rtf"),
    ORD(".ord"),
    TXT(".txt");

    String typeOfFile;

    JRPrintReportGenerate(String typeOfFile) {
        this.typeOfFile = typeOfFile;
    }

    public String getTypeOfFile() {
        return typeOfFile;
    }
}
