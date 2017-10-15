package org.openjanela.commons.util.test;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Copyright (c) 2011-2013, OpenJanela. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-07-13
 *          Time: 10:23 PM
 */
public class TigerStopCommTest {

    //Apache Log4j
    private static final Logger logger = Logger.getLogger(TigerStopCommTest.class);

    //Comm Port Identifier
    private static CommPortIdentifier portIdentifier;
    private static SerialPort serialPort;

    private static int baudRate = 0;

    private static OutputStream mOutputToPort;
    private static InputStream mInputFromPort;

    /**
     * Open Communication Port RS232
     */
    private static void openCOMMPort() throws Exception {
        try {

            //Open Port Identifier
            portIdentifier = CommPortIdentifier.getPortIdentifier("COM5");

            if (portIdentifier.isCurrentlyOwned()) {
                throw new Exception("Port COM15 is in use!");
            }

        } catch (NoSuchPortException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }

    /**
     * Initialized Tiger Stop Machinery
     *
     * @throws Exception, Exception
     */
    private static void initializedTigerStop() throws Exception {

        try {

            //*********************************************************
            //Tiger Stop Communication
            //*********************************************************
            String mValue = "Hr";
            String value = "";

            mOutputToPort.write(mValue.getBytes());
            mOutputToPort.flush();

            Thread.sleep(500);

            byte mBytesIn[] = new byte[256];

            mInputFromPort.read(mBytesIn);

            value = new String(mBytesIn);

            System.out.println("Response from Serial Device: " + value);

        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new Exception(e.getMessage(), e);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * Return Tiger Stop Position
     *
     * @throws Exception, Exception
     */
    private static void getTigerStopPositon() throws Exception {

        try {

            //***********************************************************
            //Return Current Stop Position
            //***********************************************************
            String mValue = "Pr";
            String value = "";

            mOutputToPort.write(mValue.getBytes());
            mOutputToPort.flush();

            Thread.sleep(500);

            byte mBytesIn[] = new byte[256];

            mInputFromPort.read(mBytesIn);

            value = new String(mBytesIn);

            System.out.println("Response from Serial Device: " + value);

        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new Exception(e.getMessage(), e);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * Return Tiger Stop Status Position
     *
     * @throws Exception, Exception
     */
    private static void getTigerStopStatus() throws Exception {

        try {

            //***********************************************************
            //Return Current Stop Position
            //***********************************************************
            String mValue = "Sr";
            String value = "";

            mOutputToPort.write(mValue.getBytes());
            mOutputToPort.flush();

            Thread.sleep(500);

            byte mBytesIn[] = new byte[256];

            mInputFromPort.read(mBytesIn);

            value = new String(mBytesIn);

            System.out.println("Response from Serial Device: " + value);

        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new Exception(e.getMessage(), e);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * Return Tiger Stop Version
     *
     * @throws Exception, Exception
     */
    private static void getTigerSetVersion() throws Exception {
        try {

            //***********************************************************
            //Return Current Stop Position
            //***********************************************************
            String mValue = "Vr";
            String value = "";

            mOutputToPort.write(mValue.getBytes());
            mOutputToPort.flush();

            Thread.sleep(500);

            byte mBytesIn[] = new byte[256];

            mInputFromPort.read(mBytesIn);

            value = new String(mBytesIn);

            System.out.println("Response from Serial Device: " + value);

        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new Exception(e.getMessage(), e);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * Setting Tiger Stop Position
     *
     * @throws Exception, Exception
     */
    private static void setTigetStopPosition() throws Exception {
        try {

            //***********************************************************
            //Return Current Stop Position
            //***********************************************************
            String mValue = "G123.456r";
            String value = "";

            mOutputToPort.write(mValue.getBytes());
            mOutputToPort.flush();

            Thread.sleep(500);

            byte mBytesIn[] = new byte[256];

            mInputFromPort.read(mBytesIn);

            value = new String(mBytesIn);

            System.out.println("Response from Serial Device: " + value);

        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new Exception(e.getMessage(), e);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * Main Method Test
     *
     * @param args
     */
    public static final void main(String args[]) {

        try {

            //****************************************************
            //1. Open Port Comm Communication
            //****************************************************
            openCOMMPort();

            //Open Serial Port 300
            serialPort = (SerialPort) portIdentifier.open(TigerStopCommTest.class.getName(), 300);

            //Getting Baud Rate
            baudRate = serialPort.getBaudRate();
            System.out.println(Integer.toString(baudRate));

            //Setting Serial Port Params 57600
            serialPort.setSerialPortParams(19200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

            //Init Output & Input Stream
            mOutputToPort = serialPort.getOutputStream();
            mInputFromPort = serialPort.getInputStream();

            //****************************************************
            //1. Get Tiger Stop Set Version
            //****************************************************
            getTigerSetVersion();

            //****************************************************
            //2. Initialize Tiger Stop Communication
            //****************************************************
            initializedTigerStop();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }
}
