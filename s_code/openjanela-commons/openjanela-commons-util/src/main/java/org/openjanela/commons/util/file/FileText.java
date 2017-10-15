package org.openjanela.commons.util.file;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-25-13
 *          Time: 10:07 AM
 */
public class FileText implements Serializable {

    private String typeOfFile = "";

    private String[] columns;

    private List<Integer> rowsSorted;

    private Map<Integer, String[]> rows;

    private String fileName;

    private int colNumber = 0;

    //***********************************************************************************


    public String getTypeOfFile() {
        return typeOfFile;
    }

    public void setTypeOfFile(String typeOfFile) {
        this.typeOfFile = typeOfFile;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public Map<Integer, String[]> getRows() {
        return rows;
    }

    public void setRows(Map<Integer, String[]> rows) {
        this.rows = rows;
    }

    public String getFileName() {
        if (typeOfFile == FilesFormat.TXT.getType()) {
            return fileName + ".txt";
        } else if (typeOfFile == FilesFormat.CSV.getType()) {
            return fileName + ".csv";
        }

        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getColNumber() {
        return colNumber;
    }

    public void setColNumber(int colNumber) {
        this.colNumber = colNumber;
    }

    public List<Integer> getRowsSorted() {
        return rowsSorted;
    }

    public void setRowsSorted(List<Integer> rowsSorted) {
        this.rowsSorted = rowsSorted;
    }

    /**
     * Generate FileText with columns and values
     *
     * @param typeFile, Type of File
     * @param fileName, File Name
     * @param columns,  Columns values
     * @param rows,     Body values
     */
    public FileText(String typeFile, String fileName, String[] columns, Map<Integer, String[]> rows) {
        this.typeOfFile = typeFile;
        this.fileName = fileName;
        this.columns = columns;
        this.rows = rows;

        this.colNumber = columns.length;
    }

    /**
     * Generate FileText with columns and values
     *
     * @param typeFile,   Type of File
     * @param fileName,   File Name
     * @param columns,    Columns values
     * @param rows,       Body values
     * @param rowsSorted, Rows Sorted
     */
    public FileText(String typeFile, String fileName, String[] columns, Map<Integer, String[]> rows,
                    List<Integer> rowsSorted) {
        this.typeOfFile = typeFile;
        this.fileName = fileName;
        this.columns = columns;
        this.rows = rows;

        this.rowsSorted = rowsSorted;
        this.colNumber = columns.length;
    }
}
