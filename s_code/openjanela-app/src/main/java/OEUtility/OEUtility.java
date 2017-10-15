/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/

package OEUtility;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

import javax.swing.ImageIcon;

import openjanela.model.eao.admin.appCurrencyEAO.AppCurrencyEAO;
import openjanela.model.eao.admin.appCurrencyEAO.AppCurrencyPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.AppCurrency;
import openjanela.model.entities.orderEntry.PricingGroup;


// Referenced classes of package erpiccoloequotesales:
//            DesignTableModel

public class OEUtility {

    public OEUtility() {

    }

    public static Locale languageLocale(String language, String country) {

        Locale locale = new Locale(language, country);

        return locale;

    }

    public static AppCurrency getCurrency(String currencyid) {

        AppCurrencyEAO appCurrency = new AppCurrencyPersistenceEAO();

        AppCurrency myCurrency = new AppCurrency();

        try {
            myCurrency = appCurrency.getCurrency(currencyid);
        } catch (GenericPersistenceEAOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return myCurrency;
    }

    public static String displayCurrency(BigDecimal value, Locale locale, AppCurrency myCurrency) {

        Currency currentCurrency = Currency.getInstance(myCurrency.id);

        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) nf).getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("");
        ((DecimalFormat) nf).setDecimalFormatSymbols(decimalFormatSymbols);

        String v = nf.format(value);
        return v;
    }

    public static String displayPercent(double value, Locale locale) {

        Double percent = new Double(0.75);

        String percentOut;

        NumberFormat percentFormatter = NumberFormat.getPercentInstance(locale);
        percentOut = percentFormatter.format(value);

        return percentOut;
    }


    public static BigDecimal parseCurrency(String ammount, Locale locale) throws ParseException {

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        Number nbr = currencyFormatter.parse(ammount);

        BigDecimal bd = new BigDecimal(nbr.doubleValue());

        BigDecimal adjusted = bd.setScale(currencyFormatter.getMaximumFractionDigits(), BigDecimal.ROUND_HALF_EVEN);
        return adjusted;
    }

    public static BufferedImage getBufferedImage(byte byteSource[], Color backGround, int w, int h) {

        BufferedImage resultImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        if (byteSource.length > 0) {
            ImageIcon imageIcon = new ImageIcon(byteSource);
            Image image = imageIcon.getImage();

            Graphics2D g2d = resultImage.createGraphics();

            g2d.drawImage(image, null, null);
        }
        return resultImage;
    }

    public static String getCurrencySymbol(Locale locale) {

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        String myCS = currencyFormatter.getCurrencyInstance(locale).getCurrency().getSymbol();

        return myCS;
    }

    public static DecimalFormat getDecimalFormat(Locale locale) {

        DecimalFormat myDecimal = new DecimalFormat("0.00");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        int mf = currencyFormatter.getCurrencyInstance(locale).getMaximumFractionDigits();

        if (mf == 0) {
            myDecimal = new DecimalFormat("0");
        } else if (mf == 1) {
            myDecimal = new DecimalFormat("0.0");
        } else if (mf == 2) {
            myDecimal = new DecimalFormat("0.00");
        } else if (mf == 3) {
            myDecimal = new DecimalFormat("0.000");
        } else if (mf == 4) {
            myDecimal = new DecimalFormat("0.0000");
        } else if (mf == 5) {
            myDecimal = new DecimalFormat("0.00000");
        } else if (mf == 6) {
            myDecimal = new DecimalFormat("0.000000");
        }

        return myDecimal;
    }

    public static double roundLength(double model, double num, boolean forprice) {

        if (forprice && model > 0) {
            double v = Math.ceil(num / model);
            num = v * model;
        }

        return num;
    }

    public static BigDecimal roundPrice(BigDecimal price, PricingGroup pg) {

        // use pricerounding Type , then get Decimal Part
        // For example Next Highest 0.05
        // means round up to the next closest ????.05 cents .10, .15, .2 etc.

        BigDecimal res = new BigDecimal(0);
        if (price.doubleValue() > 0) {
            int mainpart = 0;

            BigDecimal decimalpart = new BigDecimal(0);

            double min = 0.0D;

            double max = 0.0D;

            mainpart = price.intValue();

            decimalpart = price.subtract(new BigDecimal(mainpart));

            if (pg.getDecimalPart() == 0) {
                pg.setDecimalPart(1);
            }

            if (pg.getPriceRounding() == 1) // None
            {
                res = price;
            } else if (pg.getPriceRounding() == 2) // Next Highest
            {
                BigDecimal v = decimalpart.divide(new BigDecimal(pg.getDecimalPart()), 4, BigDecimal.ROUND_HALF_EVEN);

                v = v.setScale(0, RoundingMode.CEILING);
                decimalpart = new BigDecimal(pg.getDecimalPart()).multiply(v);

                res = new BigDecimal(mainpart).add(decimalpart);

            } else if (pg.getPriceRounding() == 3) // Next lowest
            {
                BigDecimal v = decimalpart.divide(new BigDecimal(pg.getDecimalPart()), 4, BigDecimal.ROUND_HALF_EVEN);
                v = v.setScale(0, RoundingMode.FLOOR);

                decimalpart = new BigDecimal(pg.getDecimalPart()).multiply(v);

                res = new BigDecimal(mainpart).add(decimalpart);
            } else if (pg.getPriceRounding() == 4) // Closest
            {
                BigDecimal v1 = decimalpart.divide(new BigDecimal(pg.getDecimalPart()), 4, BigDecimal.ROUND_HALF_EVEN);

                v1 = v1.setScale(0, RoundingMode.CEILING);

                BigDecimal v2 = decimalpart.divide(new BigDecimal(pg.getDecimalPart()), 4, BigDecimal.ROUND_HALF_EVEN);
                v2 = v2.setScale(0, RoundingMode.FLOOR);


                BigDecimal delta1 = decimalpart.subtract(v1).abs();
                BigDecimal delta2 = decimalpart.subtract(v2).abs();

                if (delta1.doubleValue() > delta2.doubleValue()) {
                    decimalpart = new BigDecimal(pg.getDecimalPart()).multiply(v2);
                } else {
                    decimalpart = new BigDecimal(pg.getDecimalPart()).multiply(v1);
                }

                res = new BigDecimal(mainpart).add(decimalpart);

            }
        } else {
            res = price;
        }
        return res;
    }

    public static BigDecimal getFootValueFromMeterValue(BigDecimal value) {

        return value.multiply(new BigDecimal(0.3048));

    }

    public static BigDecimal getMeterValueFromFootValue(BigDecimal value) {

        return value.divide(new BigDecimal(0.3048), 4, BigDecimal.ROUND_HALF_EVEN);

    }

    public static BigDecimal getAreaFootValueFromAreaMeterValue(BigDecimal value) {

        return value.multiply(new BigDecimal(0.092903));

    }

    public static BigDecimal getCubicFootValueFromCubicMeterValue(BigDecimal value) {

        return value.multiply(new BigDecimal(0.0283168));

    }

    public static BigDecimal getAreaMeterValueFromAreaFootValue(BigDecimal value) {

        return value.divide(new BigDecimal(0.092903), 4, BigDecimal.ROUND_HALF_EVEN);

    }

    public static BigDecimal getCubicMeterValueFromCubicFootValue(BigDecimal value) {

        return value.divide(new BigDecimal(0.0283168), 4, BigDecimal.ROUND_HALF_EVEN);

    }

}
