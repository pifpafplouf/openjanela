package Rules;

import java.math.BigDecimal;

import openjanela.model.entities.orderEntry.PricingGroup;
import orderEntryUtility.OEUtility;
import Presentation.ItemFrame;

public class CalculatePriceCost {

    public double qty = 0;

    public double sizem = 0;

    public double sizei = 0;

    public double costingsizem = 0;

    public double costingsizei = 0;

    public BigDecimal price;

    public BigDecimal cost;

    public double discountP = 0;

    public ItemFrame myFrame2;

    public PricingGroup pg;

    public double pricemarkup = 0;

    public double costmarkup = 0;

    public int priceuom = 0;

    public int costuom = 0;

    public int myMeasure = 0;

    public int pricemeasure = 0;

    public boolean discountable = false;

    public BigDecimal minprice;

    public double waste = 0;

    public BigDecimal mincost = new BigDecimal(0);

    BigDecimal myPricingSize = new BigDecimal(0.00);

    BigDecimal myCostingSize = new BigDecimal(0.00);

    boolean includePrice = true;
    boolean includeCost = true;

    public CalculatePriceCost() {
    }

    public Object[] calcTotalPrice() {

        BigDecimal tp = new BigDecimal(0.00);
        BigDecimal netPrice = price;

        BigDecimal mprice = new BigDecimal(0.00);
        BigDecimal mcost = new BigDecimal(0.00);

        if (myMeasure == 1) {// if Price Measure is Metric
            myPricingSize = new BigDecimal(sizem + "");

        } else {
            myPricingSize = new BigDecimal(sizei + "");

        }

        if (myMeasure == 1) {// if Price Measure is Metric
            myCostingSize = new BigDecimal(costingsizem + "");

        } else {
            myCostingSize = new BigDecimal(costingsizei + "");

        }

        Object[] costs = calcTotalCost();

        BigDecimal totalCost = new BigDecimal(costs[0].toString());

        double discFactor = 1 - discountP;

        if (pricemarkup > 0) {// If Part Family = Marked Up Cost

            mprice = new BigDecimal(costs[0].toString()).multiply(new BigDecimal(1 + pricemarkup));

            tp = totalCost.multiply(new BigDecimal(1 + pricemarkup));

            if (this.myFrame2.roundTotal) {
                tp = OEUtility.roundPrice(tp, pg);
            }

        } else {

            if (priceuom <= 1 || priceuom > 8) {// Unit Format
                mprice = netPrice;
                tp = netPrice.multiply(BigDecimal.valueOf(qty));

                if (myFrame2.roundTotal) {
                    tp = OEUtility.roundPrice(tp, pg);
                }

            } else {

                if (pricemeasure == 1) {// If Metric Pricing Measurement (prices in Metric)

                    if (myMeasure == 1) {// Selected Entry Is in Metric

                        tp = myPricingSize.multiply(netPrice);
                        if (myFrame2.roundPrice) {
                            tp = OEUtility.roundPrice(tp, pg);
                        }

                        if (minprice.doubleValue() > tp.doubleValue() && myPricingSize.doubleValue() > 0) {
                            tp = minprice;
                        }

                        // tp = tp.multiply(new BigDecimal(discFactor +
                        // ""));
                        if (myFrame2.roundDiscountedPrice) {
                            tp = OEUtility.roundPrice(tp, pg);
                        }

                        mprice = netPrice;

                        tp = tp.multiply(BigDecimal.valueOf(qty));

                        if (myFrame2.roundTotal) {
                            tp = OEUtility.roundPrice(tp, pg);
                        }

                    } // END Metric item Entry

                    else {// If Imperial item Entry


                        tp = myPricingSize.multiply(OEUtility.getFootValueFromMeterValue(netPrice));

                        if (myFrame2.roundPrice) {
                            tp = OEUtility.roundPrice(tp, pg);
                        }
                        if (minprice.doubleValue() > tp.doubleValue() && myPricingSize.doubleValue() > 0) {
                            tp = minprice;
                        }

                        if (myFrame2.roundDiscountedPrice) {
                            tp = OEUtility.roundPrice(tp, pg);
                        }

                        mprice = netPrice;

                        tp = tp.multiply(BigDecimal.valueOf(qty));
                        if (myFrame2.roundTotal) {
                            tp = OEUtility.roundPrice(tp, pg);
                        }

                    }

                } else { // If Imperial Price Measurement (prices in Imperial)
                    if (myMeasure == 2 || myMeasure == 3) {// If Entry is Imperial Decimal or Fractions
                        // Need to add Fraction Text Parsing here


                        tp = myPricingSize.divide(new BigDecimal(1), 4, BigDecimal.ROUND_HALF_EVEN).multiply(netPrice);

                        if (myFrame2.roundPrice) {
                            tp = OEUtility.roundPrice(tp, pg);
                        }

                        if (minprice.doubleValue() > tp.doubleValue() && myPricingSize.doubleValue() > 0) {
                            tp = minprice;
                        }
                        // tp = tp.multiply(new BigDecimal(discFactor
                        // + ""));
                        if (myFrame2.roundDiscountedPrice) {
                            tp = OEUtility.roundPrice(tp, pg);
                        }

                        mprice = netPrice;

                        tp = tp.multiply(BigDecimal.valueOf(qty));
                        if (myFrame2.roundPrice) {
                            tp = OEUtility.roundPrice(tp, pg);
                        }


                    } // Imp OE

                    else {// if Order Entry is in METRIC


                        tp = myPricingSize.divide(new BigDecimal(1), 4, BigDecimal.ROUND_HALF_EVEN).multiply(
                                OEUtility.getMeterValueFromFootValue(netPrice));
                        if (myFrame2.roundPrice) {
                            tp = OEUtility.roundPrice(tp, pg);
                        }
                        if (minprice.doubleValue() > tp.doubleValue() && myPricingSize.doubleValue() > 0) {
                            tp = minprice;
                        }
                        // tp = tp.multiply(new BigDecimal(discFactor
                        // + ""));
                        if (myFrame2.roundDiscountedPrice) {
                            tp = OEUtility.roundPrice(tp, pg);
                        }

                        mprice = netPrice;

                        tp = tp.multiply(BigDecimal.valueOf(qty));
                        if (myFrame2.roundTotal) {
                            tp = OEUtility.roundPrice(tp, pg);
                        }
                    }
                }
            }
        }

        mprice = mprice.multiply(new BigDecimal(discFactor + ""));
        tp = tp.multiply(new BigDecimal(discFactor + ""));


        Object[] mo = new Object[4];

        if(includePrice){
            mo[0] = tp;
            mo[2] = mprice;
        }else{
            mo[0] = new BigDecimal("0");
            mo[2] = new BigDecimal("0");
        }

        if (includeCost) {
            mo[1] = totalCost;
            mo[3] = new BigDecimal(costs[1].toString());
        } else {
            mo[1] = new BigDecimal("0");
            mo[3] = new BigDecimal("0");
        }

        return mo;
    }

    public Object[] calcTotalCost() {

        BigDecimal tp = new BigDecimal(0.00);
        BigDecimal mcost = new BigDecimal(0.00);

        cost = cost.multiply(new BigDecimal(1 + (this.waste / 100)));

        if (costuom <= 1 || costuom > 8) {

            mcost = cost.multiply(BigDecimal.valueOf(qty));
            tp = cost.multiply(BigDecimal.valueOf(qty));

        } else {

            if (pricemeasure == 1) {// metric

                if (myMeasure == 1) {

                    tp = myCostingSize.multiply(cost);

                    if (mincost.doubleValue() > tp.doubleValue() && myCostingSize.doubleValue() > 0) {
                        tp = mincost;
                    }

                    mcost = tp;
                    tp = tp.multiply(BigDecimal.valueOf(qty));

                } else { // Metric OE

                    tp = myCostingSize.multiply(OEUtility.getFootValueFromMeterValue(cost));

                    if (mincost.doubleValue() > tp.doubleValue() && myCostingSize.doubleValue() > 0) {
                        tp = mincost;
                    }

                    mcost = tp;
                    tp = tp.multiply(BigDecimal.valueOf(qty));
                }

            } else {

                if (myMeasure == 2 || myMeasure == 3) {

//					tp = myCostingSize.divide(new BigDecimal(12), 4, BigDecimal.ROUND_HALF_EVEN).multiply(cost);
                    tp = myCostingSize.multiply(cost);
                    if (mincost.doubleValue() > tp.doubleValue() && myCostingSize.doubleValue() > 0) {
                        tp = mincost;
                    }
                    mcost = tp;
                    tp = tp.multiply(BigDecimal.valueOf(qty));

                } else {  // Imp OE

//					tp = myCostingSize.divide(new BigDecimal(1000), 4, BigDecimal.ROUND_HALF_EVEN).multiply(
//								OEUtility.getMeterValueFromFootValue(cost));

                    tp = myCostingSize.multiply(OEUtility.getMeterValueFromFootValue(cost));

                    if (mincost.doubleValue() > tp.doubleValue() && myCostingSize.doubleValue() > 0) {
                        tp = mincost;
                    }

                    mcost = tp;
                    tp = tp.multiply(BigDecimal.valueOf(qty));
                }
            }
        }

        Object[] ret = new Object[2];

        ret[0] = tp;
        ret[1] = mcost;

        return ret;
    }
}
