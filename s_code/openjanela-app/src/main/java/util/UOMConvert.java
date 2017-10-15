/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani. 
 *  All rights reserved.
 *
 *  Contributors:  
 *  Sherif El Dibani
 ******************************************************************************/
package util;


import java.math.BigDecimal;
import java.text.DecimalFormat;


public class UOMConvert {
	
	public UOMConvert() {
		
		
	}
	
	
	public UOMConvert(String entryUOM) {
		
		
		entryUOM = entryUOM;
	}
	
	
	public static String getCurrentMOUString(
				final String value) {
		
		
		String rtnValue = null;
		try {
			switch (selectUOM) {
			case 0: // '\0'
				rtnValue = value;
				break;
				
			case 1: // '\001'
				rtnValue =
				imperialToFraction(value);
				break;
				
			case 2: // '\002'
				rtnValue =
				imperialTometric(value);
				break;
			}
		} catch (final Exception e) {
			rtnValue = "error";
			// System.out
			// .println("--+--Exception From MeasureUnitConverterData::getCurrentMOUString(String)");
			// System.out.println(String.valueOf(String.valueOf((new
			// StringBuffer(
			// "  |--Current MOU = ")).append(selectUOM).append(
			// ", value passed in : ").append(value))));
			e.printStackTrace();
		}
		return rtnValue;
	}
	
	
	public static int getCurrentMOU() {
		
		
		return selectUOM;
	}
	
	
	public static void setCurrentMOU(final int mou) {
		
		
		selectUOM = mou;
	}
	
	
	public static void gotoNextMOU() {
		
		
		selectUOM++;
		if (selectUOM >= 3) {
			selectUOM = 0;
		}
	}
	
	
	private static int greatestCommonDivisor(
				int n,
				int d) {
		
		
		for (int remainder = n % d; remainder != 0; remainder =
					n % d) {
			n = d;
			d = remainder;
		}
		
		return d;
	}
	
	
	private static String[] seperatingDecimal(
				final String stringForSeparating)
							throws Exception {
		
		
		final String returnStringArray[] =
					new String[2];
		final StringBuffer integerPart =
					new StringBuffer("");
		final StringBuffer decimalPart =
					new StringBuffer("");
		char charOfString[] =
					new char[stringForSeparating
					         .length()];
		charOfString =
					seperatorToChar(stringForSeparating);
		final int dotNumberOfString =
					dotNumber(charOfString);
		int indexOfDot = -1;
		if (dotNumberOfString == 1) {
			indexOfDot =
						stringForSeparating
						.indexOf('.');
			integerPart
			.append(stringForSeparating
						.substring(
									0,
									indexOfDot));
			decimalPart
			.append(stringForSeparating
						.substring(
									indexOfDot,
									stringForSeparating
									.length()));
			decimalPart.insert(0, '0');
		} else if (dotNumberOfString == 0) {
			integerPart
			.append(stringForSeparating);
		} else {
			throw new Exception(
						"Invalid format: contains more than one dot");
		}
		returnStringArray[0] =
					integerPart.toString();
		returnStringArray[1] =
					decimalPart.toString();
		return returnStringArray;
	}
	
	
	public static String feetInchToSixtyFourth(
				final String strForConvert,
				final double adjust) {
		
		
		final double valueOfStr =
					(adjust
								+ Double
								.parseDouble(strForConvert
											.substring(
														0,
														1))
														* 12D + Double
														.parseDouble(strForConvert
																	.substring(
																				1,
																				strForConvert
																				.length())));
		final long resultOfSixtyFourth =
					Math.round(valueOfStr / 0.015625f);
		final double result =
					(resultOfSixtyFourth * 0.015625D);
		return Double.toString(result);
	}
	
	
	public static String feetInchToImperial(
				final String str,
				final double adjust)
							throws Exception {
		
		
		new DecimalFormat("0.000000");
		final String myString =
					feetInchToSixtyFourth(str, adjust);
		final StringBuffer result =
					new StringBuffer("");
		result.append(myString);
		return result.toString();
	}
	
	
	public static String feetInchToMetric(
				final String str,
				final double adjust)
							throws Exception {
		
		
		final String myString =
					feetInchToImperial(str, adjust);
		final String metricValue =
					imperialTometric(myString);
		return metricValue;
	}
	
	
	public static String feetInchToFraction(
				final String str,
				final double adjust)
							throws Exception {
		
		
		final String myString =
					feetInchToImperial(str, adjust);
		final String fractionValue =
					imperialToFraction(myString);
		return fractionValue;
	}
	
	
	public static String imperialToFeetInch(
				final String str,
				final double adjust)
							throws Exception {
		
		
		final double myStr =
					(Double.parseDouble(str) - adjust) / 12f;
		final String myInt =
					String.valueOf(myStr).substring(
								0,
								String
								.valueOf(myStr)
								.indexOf("."));
		if (myInt.length() > 1) {
			throw new Exception(
						"Invalid format: contains more than one digit");
		} else {
			final String myHelp =
						String
						.valueOf(
									String
									.valueOf(Double
												.parseDouble(str)
												- adjust
												- Double
												.parseDouble(myInt)
												* 12D))
												.concat("");
			final String myDecimal =
						myHelp.substring(0, String
									.valueOf(myHelp)
									.indexOf("."));
			return myInt + "' " + myDecimal + "";
		}
	}
	
	
	public static String metricToFeetInch(
				final String str,
				final double adjust)
							throws Exception {
		
		
		final String mI = metricToImperial(str);
		return imperialToFeetInch(mI, adjust);
	}
	
	
	public static String fractionToFeetInch(
				final String str,
				final double adjust)
							throws Exception {
		
		
		final String fI = fractionToImperial(str);
		return imperialToFeetInch(fI, adjust);
	}
	
	
	public static String imperialToFraction(
				final String str) throws Exception {
		
		
		
		String separatedToTowPatrs[] =
					new String[2];
		separatedToTowPatrs =
					seperatingDecimal(str);
		final double d =
					Double
					.parseDouble(separatedToTowPatrs[1]);
		final String sFractionPart =
					decimalToFraction(d);
		if (separatedToTowPatrs[0]
					.equalsIgnoreCase("0")
					&& (sFractionPart.trim().length() > 0)) {
			return sFractionPart;
		}
		if (separatedToTowPatrs[0]
					.equalsIgnoreCase("0")
					&& (sFractionPart.trim().length() < 1)) {
			return "0";
		} else {
			return String
						.valueOf(String
									.valueOf(new StringBuffer(
												String
												.valueOf(String
															.valueOf(separatedToTowPatrs[0])))
									.append(
												" ")
												.append(
															sFractionPart)));
		}
	}
	
	
	private static char[] seperatorToChar(
				final String strForSepToChar) {
		
		
		final char resultChar[] =
					new char[strForSepToChar.length()];
		for (int i = 0; i < resultChar.length; i++) {
			resultChar[i] =
						strForSepToChar.charAt(i);
		}
		
		return resultChar;
	}
	
	
	private static boolean containOneSpace(
				final char charForCheck[]) {
		
		
		boolean flag = false;
		int numberOfSpaceBeforeSlash = 0;
		int numberOfSpaceAfterSlash = 0;
		int indexOfSlash = -1;
		int j = 0;
		do {
			if (j >= charForCheck.length) {
				break;
			}
			if (charForCheck[j] == '/') {
				indexOfSlash = j;
				break;
			}
			j++;
		}
		while (true);
		if (indexOfSlash != -1) {
			for (int i = 0; i < indexOfSlash; i++) {
				if (charForCheck[i] == ' ') {
					numberOfSpaceBeforeSlash++;
				}
			}
			
			for (int k = indexOfSlash; k < charForCheck.length; k++) {
				if (charForCheck[k] == ' ') {
					numberOfSpaceAfterSlash++;
				}
			}
			
		}
		if ((numberOfSpaceBeforeSlash == 0)
					&& (numberOfSpaceAfterSlash == 0)) {
			flag = true;
		} else if ((numberOfSpaceBeforeSlash == 1)
					&& (numberOfSpaceAfterSlash == 0)) {
			flag = true;
		} else if ((numberOfSpaceBeforeSlash == 0)
					&& (numberOfSpaceAfterSlash > 0)) {
			flag = false;
		} else {
			flag = false;
		}
		return flag;
	}
	
	
	private static String[] seperatingFraction(
				final String stringForSeparating) {
		
		
		final String returnStringArray[] =
					new String[3];
		final StringBuffer integerPart =
					new StringBuffer("");
		new StringBuffer("");
		final StringBuffer numeratorPart =
					new StringBuffer("");
		final StringBuffer denominatorPart =
					new StringBuffer("");
		int indexOfSpace = -1;
		int indexOfSlash = -1;
		try {
			indexOfSpace =
						stringForSeparating
						.indexOf(' ');
		} catch (final Exception ee) {
			ee.printStackTrace();
			indexOfSpace = -1;
		}
		try {
			indexOfSlash =
						stringForSeparating
						.indexOf('/');
		} catch (final Exception ee) {
			ee.printStackTrace();
			indexOfSlash = -1;
		}
		if (indexOfSpace != -1) {
			integerPart
			.append(stringForSeparating
						.substring(
									0,
									indexOfSpace));
		}
		if (indexOfSlash != -1) {
			numeratorPart
			.append(stringForSeparating
						.substring(
									indexOfSpace + 1,
									indexOfSlash));
			denominatorPart
			.append(stringForSeparating
						.substring(indexOfSlash + 1));
		}
		if ((indexOfSpace == -1)
					&& (indexOfSlash == -1)) {
			integerPart
			.append(stringForSeparating
						.trim());
		}
		returnStringArray[0] =
					integerPart.toString();
		returnStringArray[1] =
					numeratorPart.toString();
		returnStringArray[2] =
					denominatorPart.toString();
		return returnStringArray;
	}
	
	
	public static String fractionToImperial(
				final String str) throws Exception {
		
		
		final DecimalFormat fourDecimal =
					new DecimalFormat("0.000000");
		final String getStringFromParameter =
					str.trim();
		String returnStringArray[] = new String[3];
		final char resultChar[] =
					seperatorToChar(getStringFromParameter);
		final boolean spaceValidate =
					containOneSpace(resultChar);
		if (!spaceValidate) {
			throw new Exception(
						String
						.valueOf(String
									.valueOf(new StringBuffer(
												"Invalid format: ")
									.append(
												getStringFromParameter
												.trim())
												.append(
															" contains more than one space, wrong format"))));
		}
		returnStringArray =
					seperatingFraction(getStringFromParameter);
		final StringBuffer result =
					new StringBuffer("");
		double integerPart = 0.0f;
		double deciamlPart = 0.0f;
		double total = 0.0f;
		if (returnStringArray[0].trim().length() > 0) {
			integerPart =
						Double
						.parseDouble(returnStringArray[0]
									.trim());
		} else {
			integerPart = 0.0f;
		}
		if ((returnStringArray[2].trim().length() > 0)
					&& (Double
								.parseDouble(returnStringArray[2]) == 0.0D)) {
			throw new Exception(
						String
						.valueOf(String
									.valueOf(new StringBuffer(
												"Invalid format,")
									.append(
												returnStringArray[1]
															.trim())
															.append(
																		"/0: Denominator can't be zero (0) "))));
		}
		if ((returnStringArray[1].trim().length() > 0)
					&& (returnStringArray[2]
								.trim()
								.length() > 0)) {
			deciamlPart =
						Double
						.parseDouble(returnStringArray[1]
									.trim())
									/ Double
									.parseDouble(returnStringArray[2]
												.trim());
		} else {
			if ((returnStringArray[1]
						.trim()
						.length() < 1)
						&& (returnStringArray[2]
									.trim()
									.length() > 0)) {
				throw new Exception(
							String
							.valueOf(String
										.valueOf(new StringBuffer(
													"Invalid format, /")
										.append(
													returnStringArray[2]
																.trim())
																.append(
																			" Numerator empty, wrong format"))));
			}
			if ((returnStringArray[1]
						.trim()
						.length() > 0)
						&& (returnStringArray[2]
									.trim()
									.length() < 1)) {
				throw new Exception(
							String
							.valueOf(String
										.valueOf(new StringBuffer(
													"Invalid format, ")
										.append(
													returnStringArray[1]
																.trim())
																.append(
																			"/  Denominator empty, wrong format"))));
			}
		}
		total = integerPart + deciamlPart;
		result.append(fourDecimal.format(total));
		return result.toString();
	}
	
	
	private static int dotNumber(
				final char charForCheck[]) {
		
		
		int numberOfDot = 0;
		for (final char element : charForCheck) {
			if (element == '.') {
				numberOfDot++;
			}
		}
		
		return numberOfDot;
	}
	
	
	public static String fractionToMetric(
				final String str) throws Exception {
		
		
		final DecimalFormat fourDecimal =
					new DecimalFormat("0.000000");
		
		final String resultOfImperial =
					fractionToImperial(str);
		
		return imperialTometric(resultOfImperial);
	}
	
	
	public static String metricToFraction(
				final String str) throws Exception {
		
		
		final String myString =
					metricToSixtyFourth(str);
		final String imperialString =
					metricToImperial(myString);
		return imperialToFraction(imperialString);
	}
	
	
	public static String metricToImperial(
				final String str) throws Exception {
		
		
		final DecimalFormat fourDecimal =
					new DecimalFormat("0.000000");
		final String myString =
					metricToSixtyFourth(str);
		double imperialValue = 0.000000f;
		final double metricValue =
					Double.parseDouble(myString);
		final String imperial =
					imperialToSixtyFourth(fourDecimal
								.format(metricValue / 25.4));
		imperialValue = Double.parseDouble(imperial);
		
		final StringBuffer result =
					new StringBuffer("");
		result.append(fourDecimal
					.format(imperialValue));
		return result.toString();
	}
	
	
	public static String imperialTometric(
				final String str) throws Exception {
		
		
		final DecimalFormat fourDecimal =
					new DecimalFormat("0.000000");
		
		double metricValue = Double.parseDouble(str) * 25.4d;
		
		return (int) (metricValue) + "";
	}
	
	
	public static double getBigDecimalConversion(int value, BigDecimal convertMImp, int operator)
	{
		
		if (operator == 1)
		{
			return (new BigDecimal(value).multiply(convertMImp).setScale(20, BigDecimal.ROUND_UP)
						.doubleValue());
		}
		else
		{
			return (new BigDecimal(value).divide(convertMImp, 20, BigDecimal.ROUND_UP)).doubleValue();
		}
		
	}

    public static double getBigDecimalConversion(double value, BigDecimal convertMImp, int operator) {

        if (operator == 1) {
            return (new BigDecimal(value).multiply(convertMImp).setScale(20, BigDecimal.ROUND_UP).doubleValue());
        } else {
            return (new BigDecimal(value).divide(convertMImp, 20, BigDecimal.ROUND_UP)).doubleValue();
        }

    }

    public static String imperialToSixtyFourth(
				final String strForConvert) {
		
		
		final double valueOfStr =
					Double.parseDouble(strForConvert);
		final long resultOfSixtyFourth =
					Math.round(valueOfStr / 0.015625f);
		
		int ret = (int) resultOfSixtyFourth;
		
		return ret + "";
	}
	
	
	public static String metricToSixtyFourth(
				final String strForConvert) {
		
		
		new DecimalFormat("0");
		double valueOfStr = 0.0f;
		valueOfStr =
					Double.parseDouble(strForConvert);
		valueOfStr =
					Math
					.floor(valueOfStr / 0.396875D);
		
		return (int) valueOfStr + "";
	}
	
	
	private static String decimalToFraction(
				final double decimalNumber) {
		
		
		final StringBuffer numeratorPart =
					new StringBuffer("");
		final StringBuffer denominatorPart =
					new StringBuffer("64");
		new StringBuffer(" ");
		int i = 0;
		if (decimalNumber == 0) {
			return "";
		}
		if (decimalNumber >= 0.015625D) {
			i =
						(int) (decimalNumber / 0.015625D);
			numeratorPart.append(i);
		} else if (decimalNumber % 0.015625D < 0.0078125D) {
			i = 1;
			numeratorPart.append(i);
		}
		final int n =
					Integer.parseInt(numeratorPart
								.toString());
		final int d =
					Integer.parseInt(denominatorPart
								.toString());
		final int greatCD =
					greatestCommonDivisor(n, d);
		return String
					.valueOf(String
								.valueOf(new StringBuffer(
											String
											.valueOf(String
														.valueOf(Integer
																	.parseInt(numeratorPart
																				.toString())
																				/ greatCD)))
								.append("/")
								.append(
											Integer
											.parseInt(denominatorPart
														.toString())
														/ greatCD)));
	}
	
	
	public static final int Imperial = 0;
	
	
	public static final int Metric = 2;
	
	
	public static final int ImperialFraction = 1;
	
	
	public static final int FeetInch = 4;
	
	
	private static int selectUOM = 0;
	
	
	static final double OneOver64 =
				0.015625f;
	
	
	static final double OneOver32 =
				0.03125f;
	
	
	static final double OneOver16 =
				0.0625f;
	
	
	static final double OneOver8 =
				0.125f;
	
	
	static final double OneOver4 = 6;
	
	
	static final double OneOver2 = 12;
	
	
	static final int DenominatorFor64 = 64;
	
	
	static String entryUOM;
	
}
