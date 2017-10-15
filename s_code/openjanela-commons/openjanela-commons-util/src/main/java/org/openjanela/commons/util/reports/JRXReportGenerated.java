package org.openjanela.commons.util.reports;

import net.sf.jasperreports.engine.JasperReport;

import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.util.Map;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 01-30-12
 *          Time: 04:43 PM
 */
public class JRXReportGenerated implements Serializable {

    //Reporte stream content jasper
    private JasperReport jasperReport;

    //Listado de parametros
    private Map parameters;

    //Bean collection object to show report data
    private Connection dataSource;

    //File name and path to generate
    private File file;

    private String typeOfFile;

    //Printer selection name
    private String printerName;

    public JasperReport getJasperReport() {
        return jasperReport;
    }

    public void setJasperReport(JasperReport jasperReport) {
        this.jasperReport = jasperReport;
    }

    public Map getParameters() {
        return parameters;
    }

    public void setParameters(Map parameters) {
        this.parameters = parameters;
    }

    public Connection getDataSource() {
        return dataSource;
    }

    public void setDataSource(Connection dataSource) {
        this.dataSource = dataSource;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getTypeOfFile() {
        return typeOfFile;
    }

    public void setTypeOfFile(String typeOfFile) {
        this.typeOfFile = typeOfFile;
    }

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    /**
     * Constructor JRXReportGenerated
     *
     * @param jasperReport, JasperReport
     * @param parameters,   Map
     * @param dataSource,   JRBeanCollectionDataSource
     */
    public JRXReportGenerated(JasperReport jasperReport, Map parameters, Connection dataSource) {
        this.jasperReport = jasperReport;
        this.parameters = parameters;
        this.dataSource = dataSource;
    }

    /**
     * Constructor JRXReportGenerated
     *
     * @param jasperReport, JasperReport
     * @param parameters,   Map
     * @param dataSource,   Connection Datasource
     * @param file,         File
     * @param typeOfFile,   Type of File to generate
     */
    public JRXReportGenerated(JasperReport jasperReport, Map parameters, Connection dataSource, File file,
                              String typeOfFile) {
        this.jasperReport = jasperReport;
        this.parameters = parameters;
        this.dataSource = dataSource;
        this.file = file;
        this.typeOfFile = typeOfFile;
    }

    /**
     * Constructor JRXReportGenerated
     *
     * @param jasperReport, JasperReport
     * @param parameters,   Map
     * @param dataSource,   Connection Datasource
     * @param printerName,  Printer Name
     */
    public JRXReportGenerated(JasperReport jasperReport, Map parameters, Connection dataSource, String printerName) {
        this.jasperReport = jasperReport;
        this.parameters = parameters;
        this.dataSource = dataSource;
        this.printerName = printerName;
    }
}
