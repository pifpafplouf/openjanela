package openjanela.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-30-12
 * Time: 09:25 PM
 */
public class OpenJanelaRuleTest1 {
    
    public static void main(String args[]) {
        
        ArrayList ruleTestResult = new ArrayList();
        ruleTestResult.add(1);
        ruleTestResult.add(true);
        ruleTestResult.add(1);
        ruleTestResult.add(0);

        analyseNextTests(ruleTestResult);
    }

    private static double getRowForTestID(ArrayList res, int myKey) {

        double row = -1D;
        for (int i = 0; i < res.size() / 4; i++) {
            if (((Integer) res.get(4 * i + 3)).intValue() == myKey) {
                row = i;

            }
        }
        return row;
    }

    private static boolean analyseNextTests(ArrayList results) {

        int i = 0;

        int myRowSeq = (int) getRowForTestID(results, 0);

        if (myRowSeq >= 0) {

            boolean resThisId = ((Boolean) results.get(4 * myRowSeq + 1)).booleanValue();

            boolean myRes = ((Boolean) results.get(4 * myRowSeq + 1)).booleanValue();

            do {
                i++;
                if (getRowForTestID(results, ((Integer) results.get(4 * myRowSeq)).intValue()) == -1) {
                    i = results.size() / 5 + 1;
                } else {
                    myRowSeq = (int) getRowForTestID(results, ((Integer) results.get(4 * myRowSeq)).intValue());
                    if (myRowSeq >= 0) {
                        resThisId = ((Boolean) results.get(4 * myRowSeq + 1)).booleanValue();
                        if (((Boolean) results.get(4 * myRowSeq + 2)).booleanValue()) {
                            if (myRes && resThisId) {
                                myRes = true;
                            } else {
                                myRes = false;
                            }
                        } else if (myRes || resThisId) {
                            myRes = true;
                        } else {
                            myRes = false;
                        }
                    } else {
                        myRes = false;
                    }
                }
            }
            while (i <= results.size() / 5);

            return myRes;
        } else {

            return false;
        }

        /**
         *
         * for(test){
         *  if(nexttest>0){
         *      if(and && not pass ||   (not pass &&  next test ==0)){
         *          Not Pass
         *      } else(not pass && OR){
         *
         *       do while???      next test >0
         *
         *      }
         * }
         *
         *
         */
    }

}
