package org.openjanela.commons.util.reports;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.*;
import org.apache.log4j.Logger;
import org.openjanela.commons.util.ui.JRViewerPanel;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.swing.*;
import java.awt.print.PrinterJob;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 01-30-12
 *          Time: 04:58 PM
 *          Print Viewer implementation utilities Jasper reports
 */
public class JRPrintReport {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(JRPrintReport.class);

    /**
     * Fill Report to Print Preview with JRViewer
     *
     * @param jrxReportGenerated, JRXReportGenerated
     * @throws Exception, Exception
     */
    public static void printPreviewReport(JRXReportGenerated jrxReportGenerated) throws Exception {
        new JRViewerPanel(null, fillReport(jrxReportGenerated));
    }

    /**
     * Fill Report to Print Preview with JRViewer
     *
     * @param parentFrame,        JFrame parent
     * @param jrxReportGenerated, JRXReportGenerated
     * @throws Exception, Exception
     */
    public static void printPreviewReport(JFrame parentFrame, JRXReportGenerated jrxReportGenerated) throws Exception {

        final JFrame frmParent = parentFrame;
        final JRXReportGenerated jrxReport = jrxReportGenerated;

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new JRViewerPanel(frmParent, fillReport(jrxReport));
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
        });

    }

    /**
     * Print Report to a Selected File
     *
     * @param jrxReportGenerated, JRXReportGenerated
     * @throws Exception, Exception
     */
    public static void printFile(JRXReportGenerated jrxReportGenerated) throws Exception {

        if (jrxReportGenerated.getTypeOfFile().trim().equals(JRPrintReportGenerate.CVS.getTypeOfFile())) {
            printCsvFile(jrxReportGenerated);
        } else if (jrxReportGenerated.getTypeOfFile().trim().equals(JRPrintReportGenerate.DOC.getTypeOfFile())) {
            //TODO: Implements doc type print
        } else if (jrxReportGenerated.getTypeOfFile().trim().equals(JRPrintReportGenerate.EXCEL.getTypeOfFile())) {
            //TODO: Implements doc type print
        } else if (jrxReportGenerated.getTypeOfFile().trim().equals(JRPrintReportGenerate.PDF.getTypeOfFile())) {
            printPdfFile(jrxReportGenerated);
        } else if (jrxReportGenerated.getTypeOfFile().trim().equals(JRPrintReportGenerate.RTF.getTypeOfFile())) {
            printRtfFile(jrxReportGenerated);
        } else if (jrxReportGenerated.getTypeOfFile().trim().equals(JRPrintReportGenerate.ORD.getTypeOfFile()) ||
                jrxReportGenerated.getTypeOfFile().trim().equals(JRPrintReportGenerate.TXT.getTypeOfFile())) {
            printTxtFile(jrxReportGenerated);
        }
    }

    /**
     * Print Report to PDF File
     *
     * @param jrxReportGenerated, JRXReportGenerated
     * @throws Exception, Exception
     */
    public static void printPdfFile(JRXReportGenerated jrxReportGenerated) throws Exception {

        JRPdfExporter pdfExporter = new JRPdfExporter();
        pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, fillReport(jrxReportGenerated));
        pdfExporter.setParameter(JRExporterParameter.OUTPUT_FILE, jrxReportGenerated.getFile());

        pdfExporter.exportReport();
    }

    /**
     * Print Report to CSV File
     *
     * @param jrxReportGenerated, JRXReportGenerated
     * @throws Exception, Exception
     */
    public static void printCsvFile(JRXReportGenerated jrxReportGenerated) throws Exception {

        JRCsvExporter csvExporter = new JRCsvExporter();
        csvExporter.setParameter(JRExporterParameter.JASPER_PRINT, fillReport(jrxReportGenerated));
        csvExporter.setParameter(JRExporterParameter.OUTPUT_FILE, jrxReportGenerated.getFile());

        csvExporter.exportReport();
    }

    /**
     * Print Report to Rtf File
     *
     * @param jrxReportGenerated, JRXReportGenerated
     * @throws Exception, Exception
     */
    public static void printRtfFile(JRXReportGenerated jrxReportGenerated) throws Exception {

        JRRtfExporter rtfExporter = new JRRtfExporter();
        rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, fillReport(jrxReportGenerated));
        rtfExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, jrxReportGenerated.getFile());

        rtfExporter.exportReport();
    }

    /**
     * Print Report to Txt File
     *
     * @param jrxReportGenerated, JRXReportGenerated
     * @throws Exception, Exception
     */
    public static void printTxtFile(JRXReportGenerated jrxReportGenerated) throws Exception {

        JRTextExporter txtExporter = new JRTextExporter();

        JasperPrint report = fillReport(jrxReportGenerated);

        double CHAR_WIDTH =  report.getPageWidth() / 95;
        double CHAR_HEIGHT =  report.getPageHeight() / 60;

        txtExporter.setParameter(JRExporterParameter.JASPER_PRINT, report);
        txtExporter.setParameter(JRExporterParameter.OUTPUT_FILE, jrxReportGenerated.getFile());
        txtExporter.setParameter(JRTextExporterParameter.CHARACTER_WIDTH, new Float(CHAR_WIDTH));
        txtExporter.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT, new Float(CHAR_HEIGHT));

        txtExporter.exportReport();
    }

    /**
     * Print Report to selected printer
     *
     * @param jrxReportGenerated, JRXReportGenerated
     * @throws Exception, Exception
     */
    public static void printService(JRXReportGenerated jrxReportGenerated) throws Exception {

        PrinterJob printerJob = PrinterJob.getPrinterJob();

        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);

        //Verify that have printer services available
        if (services.length <= 0) {
            return;
        }

        //Scan to find the printer service
        int selectedPrinter = 0;
        for (int i = 0; i < services.length; i++) {
            if (services[i].getName().trim().toUpperCase().contains(jrxReportGenerated.getPrinterName().trim().toUpperCase())) {
                selectedPrinter = i;
            }
        }

        printerJob.setPrintService(services[selectedPrinter]);

        MediaSizeName mediaSizeName = MediaSize.findMedia(4, 6, MediaPrintableArea.INCH);
        PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
        printRequestAttributeSet.add(mediaSizeName);
        printRequestAttributeSet.add(new Copies(1));

        //Create Print service exporter
        JRPrintServiceExporter exporter = new JRPrintServiceExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, fillReport(jrxReportGenerated));
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, services[selectedPrinter]);
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, services[selectedPrinter].
                getAttributes());
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);

        exporter.exportReport();
    }

    /**
     * Fill report with a JRBeanCollectionDataSource
     *
     * @param jrxReportGenerated, JRXReportGenerated
     * @return JasperPrint
     */
    public static JasperPrint fillReport(JRXReportGenerated jrxReportGenerated) throws Exception {

        try {

            //Fill report.
            return JasperFillManager.fillReport(jrxReportGenerated.getJasperReport(), jrxReportGenerated.getParameters(),
                    jrxReportGenerated.getDataSource());

        } catch (JRException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }
    }
}
