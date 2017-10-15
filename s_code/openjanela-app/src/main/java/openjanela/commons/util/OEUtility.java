package openjanela.commons.util;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-23-12
 * Time: 10:14 PM
 */
public class OEUtility {

    /**
     * Round length to ceil value
     *
     * @param model,    double
     * @param num,      double
     * @param forprice, boolean
     * @return double
     */
    public static double roundLength(double model, double num, boolean forprice) {

        if (forprice && model > 0) {
            double v = Math.ceil(num / model);
            num = v * model;
        }

        return num;
    }
}
