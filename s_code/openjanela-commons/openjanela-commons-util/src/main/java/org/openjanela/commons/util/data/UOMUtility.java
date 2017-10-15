package org.openjanela.commons.util.data;

import java.text.DecimalFormat;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-23-13
 *          Time: 09:47 AM
 */
public class UOMUtility {

    private static final int Imperial = 0;
    private static final int Metric = 2;
    private static final int ImperialFraction = 1;
    private static final int Units = 3;
    private static final int FeetInch = 4;
    private static final int selectUOM = 0;
    private static final double OneOver64 = 0.015625D;
    private static final double OneOver32 = 0.03125D;
    private static final double OneOver16 = 0.0625D;
    private static final double OneOver8 = 0.125D;
    private static final double OneOver4 = 0.25D;
    private static final double OneOver2 = 0.5D;
    private static final int DenominatorFor64 = 64;
    private static String entryUOM;

    public static String getCurrentMOUString(String value) {
        String rtnValue = null;
        try {
            switch (selectUOM) {
                case 0: // '\0'
                    rtnValue = value;
                    break;

                case 1: // '\001'
                    rtnValue = imperialToFraction(value);
                    break;

                case 2: // '\002'
                    rtnValue = imperialTometric(value);
                    break;
            }
        } catch (Exception e) {
            rtnValue = "error";
            System.out.println("--+--Exception From MeasureUnitConverterData::getCurrentMOUString(String)");
            System.out.println(String.valueOf(String.valueOf((new StringBuffer("  |--Current MOU = ")).append(selectUOM).append(", value passed in : ").append(value))));
            e.printStackTrace();
        }
        return rtnValue;
    }

    public static String feetInchToSixtyFourth(String strForConvert, double adjust) {
        double valueOfStr = adjust + Double.parseDouble(strForConvert.substring(0, 1)) * 12D + Double.parseDouble(strForConvert.substring(1, strForConvert.length()));
        long resultOfSixtyFourth = Math.round(valueOfStr / 0.015625D);
        double result = resultOfSixtyFourth * 0.015625D;
        return Double.toString(result);
    }

    public static String feetInchToImperial(String str, double adjust) throws Exception {
        DecimalFormat fourDecimal = new DecimalFormat("0.000000");
        String myString = feetInchToSixtyFourth(str, adjust);
        StringBuffer result = new StringBuffer("");
        result.append(myString);
        return result.toString();
    }

    public static String feetInchToMetric(String str, double adjust) throws Exception {
        String myString = feetInchToImperial(str, adjust);
        String metricValue = imperialTometric(myString);
        return metricValue;
    }

    public static String feetInchToFraction(String str, double adjust) throws Exception {
        String myString = feetInchToImperial(str, adjust);
        String fractionValue = imperialToFraction(myString);
        return fractionValue;
    }

    public static String imperialToFeetInch(String str, double adjust) throws Exception {
        double myStr = (Double.parseDouble(str) - adjust) / 12D;
        String myInt = String.valueOf(myStr).substring(0, String.valueOf(myStr).indexOf("."));
        if (myInt.length() > 1) {
            throw new Exception("Invalid format: contains more than one digit");
        } else {
            String myHelp = String.valueOf(String.valueOf(Double.parseDouble(str) - adjust - Double.parseDouble(myInt) * 12D)).concat("");
            String myDecimal = myHelp.substring(0, String.valueOf(myHelp).indexOf("."));
            return myInt.concat(myDecimal);
        }
    }

    public static String metricToFeetInch(String str, double adjust) throws Exception {
        String mI = metricToImperial(str);
        return imperialToFeetInch(mI, adjust);
    }

    public static String fractionToFeetInch(String str, double adjust) throws Exception {
        String fI = fractionToImperial(str);
        return imperialToFeetInch(fI, adjust);
    }

    public static String imperialToFraction(String str) throws Exception {
        String myString = imperialToSixtyFourth(str);
        String integerPart = " ";
        String decimalPart = " ";
        String separatedToTowPatrs[] = new String[2];
        separatedToTowPatrs = seperatingDecimal(myString);
        double d = Double.parseDouble(separatedToTowPatrs[1]);
        String sFractionPart = decimalToFraction(d);
        if (separatedToTowPatrs[0].equalsIgnoreCase("0") && sFractionPart.trim().length() > 0)
            return sFractionPart;
        if (separatedToTowPatrs[0].equalsIgnoreCase("0") && sFractionPart.trim().length() < 1)
            return "0";
        else
            return String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(separatedToTowPatrs[0])))).append(" ").append(sFractionPart)));
    }

    public static String fractionToImperial(String str) throws Exception {
        DecimalFormat fourDecimal = new DecimalFormat("0.000000");
        String getStringFromParameter = str.trim();
        String returnStringArray[] = new String[3];
        char resultChar[] = seperatorToChar(getStringFromParameter);
        boolean spaceValidate = containOneSpace(resultChar);
        if (!spaceValidate)
            throw new Exception(String.valueOf(String.valueOf((new StringBuffer("Invalid format: ")).append(getStringFromParameter.trim()).append(" contains more than one space, wrong format"))));
        returnStringArray = seperatingFraction(getStringFromParameter);
        StringBuffer result = new StringBuffer("");
        double integerPart = 0.0D;
        double deciamlPart = 0.0D;
        double total = 0.0D;
        if (returnStringArray[0].trim().length() > 0)
            integerPart = Double.parseDouble(returnStringArray[0].trim());
        else
            integerPart = 0.0D;
        if (returnStringArray[2].trim().length() > 0 && Double.parseDouble(returnStringArray[2]) == 0.0D)
            throw new Exception(String.valueOf(String.valueOf((new StringBuffer("Invalid format,")).append(returnStringArray[1].trim()).append("/0: Denominator can't be zero (0) "))));
        if (returnStringArray[1].trim().length() > 0 && returnStringArray[2].trim().length() > 0) {
            deciamlPart = Double.parseDouble(returnStringArray[1].trim()) / Double.parseDouble(returnStringArray[2].trim());
        } else {
            if (returnStringArray[1].trim().length() < 1 && returnStringArray[2].trim().length() > 0)
                throw new Exception(String.valueOf(String.valueOf((new StringBuffer("Invalid format, /")).append(returnStringArray[2].trim()).append(" Numerator empty, wrong format"))));
            if (returnStringArray[1].trim().length() > 0 && returnStringArray[2].trim().length() < 1)
                throw new Exception(String.valueOf(String.valueOf((new StringBuffer("Invalid format, ")).append(returnStringArray[1].trim()).append("/  Denominator empty, wrong format"))));
        }
        total = integerPart + deciamlPart;
        result.append(fourDecimal.format(total));
        return result.toString();
    }

    public static String fractionToMetric(String str) throws Exception {
        DecimalFormat fourDecimal = new DecimalFormat("0.000000");
        String resultOfImperial = fractionToImperial(str);
        double valueOfMetric = Double.parseDouble(resultOfImperial) * 25.4;
        StringBuffer result = new StringBuffer("");
        result.append(fourDecimal.format(valueOfMetric));
        return result.toString();
    }

    public static String metricToFraction(String str) throws Exception {
        String myString = metricToSixtyFourth(str);
        String imperialString = metricToImperial(myString);
        return imperialToFraction(imperialString);
    }

    public static String metricToImperial(String str) throws Exception {
        DecimalFormat fourDecimal = new DecimalFormat("0.000000");
        String myString = metricToSixtyFourth(str);
        double imperialValue = 0.000000D;
        double metricValue = Double.parseDouble(myString);
        String imperial = imperialToSixtyFourth(fourDecimal.format(metricValue / 25.4));
        imperialValue = Double.parseDouble(imperial);

        StringBuffer result = new StringBuffer("");
        result.append(fourDecimal.format(imperialValue));
        return result.toString();
    }

    public static String imperialTometric(String str) throws Exception {
        DecimalFormat fourDecimal = new DecimalFormat("0.000000");
        String myString = imperialToSixtyFourth(str);
        double metricValue = 0.0D;
        double imperialValue = Double.parseDouble(myString);
        metricValue = imperialValue * 25.4;
        StringBuffer result = new StringBuffer("");
        // result.append(fourDecimal.format(metricValue));
        return (int) metricValue + "";// result.toString();
    }

    public static String imperialToSixtyFourth(String strForConvert) {
        double valueOfStr = Double.parseDouble(strForConvert);
        long resultOfSixtyFourth = Math.round(valueOfStr / 0.015625D);
        double result = resultOfSixtyFourth * 0.015625D;
        return Double.toString(result);
    }

    public static String metricToSixtyFourth(String strForConvert) {
        DecimalFormat ZeroDecimal = new DecimalFormat("0");
        double valueOfStr = 0.0D;
        double resultOfSixtyFourth = 0.0D;
        valueOfStr = Double.parseDouble(strForConvert) / 100;
        valueOfStr = Math.floor(valueOfStr / 0.396875D);

        return Double.toString(valueOfStr);
    }

    //******************************************************************************************************************
    //********************************************PRIVATE METHODS*******************************************************
    //******************************************************************************************************************

    private static int greatestCommonDivisor(int n, int d) {
        for (int remainder = n % d; remainder != 0; remainder = n % d) {
            n = d;
            d = remainder;
        }

        return d;
    }

    private static String[] seperatingDecimal(String stringForSeparating) throws Exception {
        String returnStringArray[] = new String[2];
        StringBuffer integerPart = new StringBuffer("");
        StringBuffer decimalPart = new StringBuffer("");
        char charOfString[] = new char[stringForSeparating.length()];
        charOfString = seperatorToChar(stringForSeparating);
        int dotNumberOfString = dotNumber(charOfString);
        char dot = '.';
        int indexOfDot = -1;
        if (dotNumberOfString == 1) {
            indexOfDot = stringForSeparating.indexOf('.');
            integerPart.append(stringForSeparating.substring(0, indexOfDot));
            decimalPart.append(stringForSeparating.substring(indexOfDot, stringForSeparating.length()));
            decimalPart.insert(0, '0');
        } else if (dotNumberOfString == 0)
            integerPart.append(stringForSeparating);
        else
            throw new Exception("Invalid format: contains more than one dot");
        returnStringArray[0] = integerPart.toString();
        returnStringArray[1] = decimalPart.toString();
        return returnStringArray;
    }

    private static char[] seperatorToChar(String strForSepToChar) {
        char resultChar[] = new char[strForSepToChar.length()];
        for (int i = 0; i < resultChar.length; i++)
            resultChar[i] = strForSepToChar.charAt(i);

        return resultChar;
    }

    private static boolean containOneSpace(char charForCheck[]) {
        boolean type = false;
        int numberOfSpaceBeforeSlash = 0;
        int numberOfSpaceAfterSlash = 0;
        int indexOfSlash = -1;
        int j = 0;
        do {
            if (j >= charForCheck.length)
                break;
            if (charForCheck[j] == '/') {
                indexOfSlash = j;
                break;
            }
            j++;
        } while (true);
        if (indexOfSlash != -1) {
            for (int i = 0; i < indexOfSlash; i++)
                if (charForCheck[i] == ' ')
                    numberOfSpaceBeforeSlash++;

            for (int k = indexOfSlash; k < charForCheck.length; k++)
                if (charForCheck[k] == ' ')
                    numberOfSpaceAfterSlash++;

        }
        if (numberOfSpaceBeforeSlash == 0 && numberOfSpaceAfterSlash == 0)
            type = true;
        else if (numberOfSpaceBeforeSlash == 1 && numberOfSpaceAfterSlash == 0)
            type = true;
        else if (numberOfSpaceBeforeSlash == 0 && numberOfSpaceAfterSlash > 0)
            type = false;
        else
            type = false;
        return type;
    }

    private static String[] seperatingFraction(String stringForSeparating) {
        String returnStringArray[] = new String[3];
        StringBuffer integerPart = new StringBuffer("");
        StringBuffer fractionPart = new StringBuffer("");
        StringBuffer numeratorPart = new StringBuffer("");
        StringBuffer denominatorPart = new StringBuffer("");
        char space = ' ';
        char slash = '/';
        int indexOfSpace = -1;
        int indexOfSlash = -1;
        try {
            indexOfSpace = stringForSeparating.indexOf(' ');
        } catch (Exception ee) {
            ee.printStackTrace();
            indexOfSpace = -1;
        }
        try {
            indexOfSlash = stringForSeparating.indexOf('/');
        } catch (Exception ee) {
            ee.printStackTrace();
            indexOfSlash = -1;
        }
        if (indexOfSpace != -1)
            integerPart.append(stringForSeparating.substring(0, indexOfSpace));
        if (indexOfSlash != -1) {
            numeratorPart.append(stringForSeparating.substring(indexOfSpace + 1, indexOfSlash));
            denominatorPart.append(stringForSeparating.substring(indexOfSlash + 1));
        }
        if (indexOfSpace == -1 && indexOfSlash == -1)
            integerPart.append(stringForSeparating.trim());
        returnStringArray[0] = integerPart.toString();
        returnStringArray[1] = numeratorPart.toString();
        returnStringArray[2] = denominatorPart.toString();
        return returnStringArray;
    }

    private static int dotNumber(char charForCheck[]) {
        int numberOfDot = 0;
        for (int i = 0; i < charForCheck.length; i++)
            if (charForCheck[i] == '.')
                numberOfDot++;

        return numberOfDot;
    }

    private static String decimalToFraction(double decimalNumber) {
        StringBuffer numeratorPart = new StringBuffer("");
        StringBuffer denominatorPart = new StringBuffer("64");
        StringBuffer seperator1 = new StringBuffer(" ");
        int i = 0;
        if (decimalNumber == 0)
            return "";
        if (decimalNumber >= 0.015625D) {
            i = (int) (decimalNumber / 0.015625D);
            numeratorPart.append(i);
        } else if (decimalNumber % 0.015625D < 0.0078125D) {
            i = 1;
            numeratorPart.append(i);
        }
        int n = Integer.parseInt(numeratorPart.toString());
        int d = Integer.parseInt(denominatorPart.toString());
        int greatCD = greatestCommonDivisor(n, d);
        return String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(Integer.parseInt(numeratorPart.toString()) / greatCD)))).append("/").append(Integer.parseInt(denominatorPart.toString()) / greatCD)));
    }

}
