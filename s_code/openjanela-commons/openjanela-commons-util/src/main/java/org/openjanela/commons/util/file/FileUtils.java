package org.openjanela.commons.util.file;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-25-13
 *          Time: 10:05 AM
 */
public class FileUtils {

    /**
     * This method generate a CSV File and save to the path indicate for param
     *
     * @param path,         Path rute to save the file
     * @param fileGenerate, File to Generate
     * @throws Exception, Exception
     */
    public static void createCsvFile(String path, FileText fileGenerate) throws IOException {

        //Evaluate if file exist
        if (fileGenerate == null) {
            throw new NullPointerException("File to generate is not exist");
        }

        //Generate new File in format specified
        FileWriter fileWriter = new FileWriter(path + fileGenerate.getFileName());

        //Generate header is file has header
        if (fileGenerate.getColumns() != null && fileGenerate.getColumns().length > 0) {
            String[] headerCols = fileGenerate.getColumns();

            for (int i = 0; i <= headerCols.length; i++) {

                if (i < headerCols.length) {
                    fileWriter.append(headerCols[i]);
                    fileWriter.append(",");
                } else {
                    fileWriter.append("\n"); //change next line
                }
            }
        }

        //Generate body content for file
        if (fileGenerate.getRows() != null && fileGenerate.getColumns().length > 0) {

            for (Map.Entry entry : fileGenerate.getRows().entrySet()) {
                String[] row = (String[]) entry.getValue();
                for (int i = 0; i <= row.length; i++) {

                    if (i == row.length) {
                        fileWriter.append("\n");
                        break;
                    }

                    fileWriter.append(row[i]);
                }
            }
        }

        fileWriter.flush();
        fileWriter.close();
    }

    /**
     * This method generate a TXT File and save to the path indicate for param
     *
     * @param path,         Path rule to save the file
     * @param fileGenerate, File to Generate
     * @throws IOException, Exception
     */
    public static void createTxtFile(String path, FileText fileGenerate) throws IOException {

        //Evaluate if file exist
        if (fileGenerate == null) {
            throw new NullPointerException("File to generate is not exist");
        }

        //Generate new File in format specified
        FileWriter fileWriter = new FileWriter(path + fileGenerate.getFileName());

        //Generate body content for file
        if (fileGenerate.getRows() != null) {

            for (Map.Entry entry : fileGenerate.getRows().entrySet()) {
                String[] row = (String[]) entry.getValue();
                for (int i = 0; i <= row.length; i++) {

                    if (i == row.length) {
                        fileWriter.append("\n");
                        break;
                    }

                    fileWriter.append(row[i]);
                }
            }
        }

        fileWriter.flush();
        fileWriter.close();
    }

    /**
     * This method generate a TXT File and save to the path indicate for param
     *
     * @param path,         Path rule to save the file
     * @param fileGenerate, File to Generate
     * @throws IOException, Exception
     */
    public static void createTxtFileRowSorted(String path, FileText fileGenerate) throws IOException {

        //Evaluate if file exist
        if (fileGenerate == null) {
            throw new NullPointerException("File to generate is not exist");
        }

        //Generate new File in format specified
        FileWriter fileWriter = new FileWriter(path + fileGenerate.getFileName());

        //Generate body content for file
        if (fileGenerate.getRows() != null) {

            for (Integer rowSorted : fileGenerate.getRowsSorted()) {
                String[] row = fileGenerate.getRows().get(rowSorted);
                for (int i = 0; i <= row.length; i++) {
                    if (i == row.length) {
                        fileWriter.append("\n");
                        break;
                    }

                    fileWriter.append(row[i]);
                }
            }
        }

        fileWriter.flush();
        fileWriter.close();
    }
}
