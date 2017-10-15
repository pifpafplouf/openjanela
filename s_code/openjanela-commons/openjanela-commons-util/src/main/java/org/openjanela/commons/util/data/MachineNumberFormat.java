package org.openjanela.commons.util.data;

import java.text.DecimalFormat;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-28-13
 *          Time: 10:13 AM
 */
public class MachineNumberFormat {

    /**
     * Decimal Format value to process pattern specific transformation
     */
    private static DecimalFormat decimalFormat;

    /**
     * This method convert to Greller Welder Format Machine for profiles cuts process into the factory
     * Format with value * 100 (2 decimal positions)
     *
     * @param value, Double Value Format calculated
     * @return Readable format for machine could process
     */
    public static String formatGrellerWelder(double value) {
        decimalFormat = new DecimalFormat("00000");
        return decimalFormat.format(value * 100d);
    }

    /**
     * This method convert to Greller Welder Format Machine for profiles cuts process into the factory
     * Format with value * 1000 (3 decimal positions)
     *
     * @param value, Double Value Format calculated
     * @return Readable format for machine could process
     */
    public static String formatGrellerWelder6Digits(double value) {
        decimalFormat = new DecimalFormat("000000");
        return decimalFormat.format(value * 1000d);
    }

    /**
     * This method convert to Sampson Welder Machine for profiles cuts process into the factory
     * format with value * 10000 (3 decimal positions)
     *
     * @param value, Double Value Format calculated
     * @return Readable format for machine could process
     */
    public static String formatSampsonWelderDigits(double value) {
        decimalFormat = new DecimalFormat("000.000");
        return decimalFormat.format(value);
    }

    /**
     * This method convert to 3 Digits format a number
     *
     * @param value, Integer value Format
     * @return Readable format for 3 digits
     */
    public static String format3Digits(int value) {
        decimalFormat = new DecimalFormat("000");
        return decimalFormat.format(value);
    }

    /**
     * This method convert to 10 Digits format a number
     *
     * @param value, Integer value Format
     * @return Readable format for 10 digits
     */
    public static String format10Digits(int value) {
        decimalFormat = new DecimalFormat("0000000000");
        return decimalFormat.format(value);
    }

    /**
     * This method convert to number of digits parse
     *
     * @param value,          Integer value format
     * @param numberOfDigits, Number of digits format
     * @return Readable format for 10 digits
     */
    public static String formatNumberDigits(int value, int numberOfDigits) {
        StringBuffer pattern = new StringBuffer();

        for (int i = 1; i <= numberOfDigits; i++) {
            pattern.append("0");
        }

        decimalFormat = new DecimalFormat(pattern.toString());
        return decimalFormat.format(value);
    }

    /**
     * This method convert to currency representation
     *
     * @param value,    Value to format
     * @param digits,   Number of digits values
     * @param decimals, Number of decimals values
     * @return String
     */
    public static String formatCurrencyDigits(double value, int digits, int decimals) {
        StringBuffer pattern = new StringBuffer();

        for (int i = 1; i <= digits; i++) {
            if (i == digits) {
                pattern.append("0.");
            } else {
                pattern.append("0");
            }
        }

        for (int j = 1; j <= decimals; j++) {
            pattern.append("0");
        }

        decimalFormat = new DecimalFormat(pattern.toString());
        return decimalFormat.format(value);
    }

    /**
     * This method convert to currency representation
     * @param value, Value to format
     * @param decimal, Number of decimals
     * @param floatingPoints, Number of Floating Points
     * @return String
     */
    public static String formatFloatingPoints(double value, int decimal, int floatingPoints) {
        StringBuffer pattern = new StringBuffer();

        for (int i = 1; i <= decimal; i++) {
            if (i == decimal) {
                pattern.append("0.");
            } else {
                pattern.append("#");
            }
        }

        for (int j = 1; j <= floatingPoints; j++) {
            pattern.append("0");
        }

        decimalFormat = new DecimalFormat(pattern.toString());
        return decimalFormat.format(value);
    }
}
