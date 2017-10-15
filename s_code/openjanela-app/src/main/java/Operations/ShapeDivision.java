/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Operations;


import javax.swing.JOptionPane;


/*
 * Call function when Mullion or coupler is clicked into opening. Validate shape from division
 * Left or Top and Right or Bottom.
 */
public class ShapeDivision {

    public int myShape = 1;

    public int orientation = 0; // 1= V 2 = H
// coupler or mullion

    public int resultLT = 1; // resulting
// shape from division Left or Top

    public int resultRB = 1; // resulting
// shape from division Right or Bottom

    public boolean vcPossible = true;

    public boolean hcPossible = true;

    /**
     * Shape division constructor
     *
     * @param myShape,     Type of shape
     * @param orientation, Orientation
     * @param corm,        SelectedLevel
     */
    public ShapeDivision(int myShape, int orientation, int corm) {
        this.resultLT(myShape, orientation, corm);
    }

    /**
     * Result LT Validation
     *
     * @param myShape,     Type of shape
     * @param orientation, Orientation vertial or horizontal
     * @param corm,        Selected Level (Coupler or Mullion)
     */
    private void resultLT(int myShape, int orientation, int corm) {

        switch (myShape) {

            case 1:
                resultLT = 1;
                resultRB = 1;
                break;

            case 90:
                if (corm == 1) {

                    //Show message dialog
                    JOptionPane.showMessageDialog(null, "Division for shape " + myShape
                            + " is unavailable:\nTo request this feature please contact your supplier!",
                            "Error", JOptionPane.ERROR_MESSAGE);

                    //Vertical and Horizontal coupler not available
                    vcPossible = false;
                    hcPossible = false;
                }

                break;
            case 91:
                if (corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    vcPossible = false;
                    hcPossible = false;
                }
                break;
            case 92:
                if (corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    vcPossible = false;
                    hcPossible = false;
                }
                break;
            case 93:
                if (corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    vcPossible = false;
                    hcPossible = false;
                }
                break;
            case 100:
                resultLT = 100;
                resultRB = 100;
                if (orientation == 2) {
                    resultLT = 100;
                    resultRB = 1;
                }
                break;
            case 101:
                resultLT = 101;
                resultRB = 101;
                if (orientation == 2) {
                    resultLT = 101;
                    resultRB = 1;
                }
                break;
            case 102:
                resultLT = 102;
                resultRB = 1;
                if (orientation == 2 && corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    hcPossible = false;
                    // vcPossible=false;
                }
                break;
            case 103:
                resultLT = 1;
                resultRB = 103;
                if (orientation == 2 && corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    hcPossible = false;
                    // vcPossible=false;
                }
                break;
            case 104:
                resultLT = 104;
                resultRB = 104;
                if (orientation == 2 && corm == 1) {
                    resultLT = 1;
                    resultRB = 104;
                }
                break;
            case 105:
                resultLT = 105;
                resultRB = 105;
                if (orientation == 2) {
                    resultLT = 1;
                    resultRB = 105;
                }
                break;
            case 106:
                resultLT = 1;
                resultRB = 106;
                if (orientation == 2 && corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    hcPossible = false;
                    // vcPossible=false;
                }
                break;
            case 107:
                resultLT = 107;
                resultRB = 1;
                if (orientation == 2 && corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    hcPossible = false;
                    // vcPossible=false;
                }
                break;
            case 108:
                if (corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    vcPossible = false;
                    hcPossible = false;
                }
                break;
            case 109:
                if (corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    vcPossible = false;
                    hcPossible = false;
                }
                break;
            case 110: {
                JOptionPane
                        .showMessageDialog(
                                null,
                                "Division for shape "
                                        + myShape
                                        + " is unavailable:\nTo request this feature please contact your supplier!",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                vcPossible = false;
                hcPossible = false;
                // this.resultLT=110;
                // this.resultRB=110;
                // if(orientation==2){
                // JOptionPane.showMessageDialog(null,
                // "Division for shape "+myShape+" is unavailable:\nTo request this feature please contact your supplier!","Error",JOptionPane.ERROR_MESSAGE);
                // hcPossible=false;
                // }
            }
            break;
            case 111:
                if (corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    vcPossible = false;
                    hcPossible = false;
                    // this.resultLT=111;
                    // this.resultRB=111;
                    // if(orientation==2){
                    // JOptionPane.showMessageDialog(null,
                    // "Division for shape "+myShape+" is unavailable:\nTo request this feature please contact your supplier!","Error",JOptionPane.ERROR_MESSAGE);
                    // hcPossible=false;
                    // }
                }
                break;
            case 112:
                if (orientation == 1) {
                    resultLT = 102;
                    resultRB = 103;
                }
                if (orientation == 2) {
                    resultLT = 112;
                    resultRB = 112;
                }
// if ((orientation == 2)
// && (corm==1))
// {
// JOptionPane
// .showMessageDialog(
// null,
// "Division for shape "
// + myShape
// +
// " is unavailable:\nTo request this feature please contact your supplier!",
// "Error",
// JOptionPane.ERROR_MESSAGE);
// hcPossible = false;
// // vcPossible=false;
// }
                // JOptionPane.showMessageDialog(null,
                // "Division for shape "+myShape+" is unavailable:\nTo request this feature please contact your supplier!","Error",JOptionPane.ERROR_MESSAGE);
                // vcPossible=false;
                // hcPossible=false;

                break;
            case 113:
                // JOptionPane.showMessageDialog(null,
                // "Division for shape "+myShape+" is unavailable:\nTo request this feature please contact your supplier!","Error",JOptionPane.ERROR_MESSAGE);
                // hcPossible=false;
                // vcPossible=false;
                resultLT = 113;
                resultRB = 113;
                if (orientation == 2) {
                    resultLT = 101;
                    resultRB = 104;
                }
                break;
            case 114:
                resultLT = 107;
                resultRB = 106;
                if (orientation == 1) {
                    resultLT = 107;
                    resultRB = 106;
                }
                if (orientation == 2) {
                    resultLT = 114;
                    resultRB = 114;
                }
// if ((orientation == 2)
// && (corm==1))
// {
// JOptionPane
// .showMessageDialog(
// null,
// "Division for shape "
// + myShape
// +
// " is unavailable:\nTo request this feature please contact your supplier!",
// "Error",
// JOptionPane.ERROR_MESSAGE);
// hcPossible = false;
// // vcPossible=false;
// }
                break;
            case 115:
                // JOptionPane.showMessageDialog(null,
                // "Division for shape "+myShape+" is unavailable:\nTo request this feature please contact your supplier!","Error",JOptionPane.ERROR_MESSAGE);
                // hcPossible=false;
                // vcPossible=false;
                resultLT = 115;
                resultRB = 115;
                if (orientation == 2) {
                    resultLT = 100;
                    resultRB = 105;
                }
                break;
            case 150:
                if (orientation == 1) {
                    // JOptionPane
                    // .showMessageDialog(
                    // null,
                    // "Division for shape "
                    // + myShape
                    // +
                    // " is unavailable:\nTo request this feature please contact your supplier!",
                    // "Error",
// JOptionPane.ERROR_MESSAGE);
                    // // hcPossible=false;
                    // vcPossible = false;
                }
                resultLT = 100;
                resultRB = 101;
                if (orientation == 2) {
                    resultLT = 150;
                    resultRB = 1;
                }
                break;
            case 154:
                // JOptionPane.showMessageDialog(null,
                // "Division for shape "+myShape+" is unavailable:\nTo request this feature please contact your supplier!","Error",JOptionPane.ERROR_MESSAGE);
                // hcPossible=false;
                // vcPossible=false;
                resultLT = 154;
                resultRB = 1;
                if (orientation == 2) {
                    resultLT = 154;
                    resultRB = 1;
                }
                break;
            case 155:
                // JOptionPane.showMessageDialog(null,
                // "Division for shape "+myShape+" is unavailable:\nTo request this feature please contact your supplier!","Error",JOptionPane.ERROR_MESSAGE);
                // hcPossible=false;
                // vcPossible=false;
                resultLT = 1;
                resultRB = 155;
                if (orientation == 2) {
                    resultLT = 155;
                    resultRB = 1;
                }
                break;
            case 160:
                if (orientation == 1) {
                    // JOptionPane
                    // .showMessageDialog(
                    // null,
                    // "Division for shape "
                    // + myShape
                    // +
                    // " is unavailable:\nTo request this feature please contact your supplier!",
                    // "Error",
// JOptionPane.ERROR_MESSAGE);
                    // // hcPossible=false;
                    // vcPossible = false;
                    resultLT = 154;
                    resultRB = 155;
                } else if (orientation == 2) {
                    resultLT = 160;
                    resultRB = 1;
                }
                break;
            case 165:
                if (orientation == 1) {
                    // JOptionPane
                    // .showMessageDialog(
                    // null,
                    // "Division for shape "
                    // + myShape
                    // +
                    // " is unavailable:\nTo request this feature please contact your supplier!",
                    // "Error",
// JOptionPane.ERROR_MESSAGE);
                    // // hcPossible=false;
                    // vcPossible = false;
                    resultLT = 154;
                    resultRB = 155;
                } else if (orientation == 2) {
                    resultLT = 160;
                    resultRB = 1;
                }
                break;
            case 200:
                resultLT = 201;
                resultRB = 202;
                if (orientation == 2) {
                    resultLT = 200;
                    resultRB = 1;
                }
                break;
            case 201:
                resultLT = 201;
                resultRB = 201;
                if (orientation == 2) {
                    resultLT = 201;
                    resultRB = 1;
                }
                break;
            case 202:
                resultLT = 202;
                resultRB = 202;
                if (orientation == 2) {
                    resultLT = 202;
                    resultRB = 1;
                }
                break;
            case 203:
                resultLT = 304;
                resultRB = 305;
// if (orientation == 2)
// {
// resultLT = 303;
// resultRB = 304;
// }
                if (orientation == 2 && corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    hcPossible = false;
// resultLT = 203;
// resultRB = 304;

                }
                break;
            case 204:
                resultLT = 304;
                resultRB = 301;
                if (orientation == 2) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);

                    hcPossible = false;
                }
                break;
            case 205:
                resultLT = 302;
                resultRB = 305;
                if (orientation == 2 && corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);

                    hcPossible = false;
                }
                break;
            case 300:
                resultLT = 301;
                resultRB = 302;
                if (orientation == 2) {
                    resultLT = 300;
                    resultRB = 1;
                }
                break;
            case 301:
                resultLT = 301;
                resultRB = 301;
                if (orientation == 2) {
                    resultLT = 301;
                    resultRB = 1;
                }
                break;
            case 333:
                resultLT = 301;
                resultRB = 301;
                if (orientation == 2) {
                    resultLT = 301;
                    resultRB = 1;
                }
                break;
            case 302:
                resultLT = 302;
                resultRB = 302;
                if (orientation == 2) {
                    resultLT = 302;
                    resultRB = 1;
                }
                break;
            case 3333:
                resultLT = 302;
                resultRB = 302;
                if (orientation == 2) {
                    resultLT = 302;
                    resultRB = 1;
                }
                break;
            case 303:
                resultLT = 304;
                resultRB = 305;
                if (orientation == 2) {
                    resultLT = 303;
                    resultRB = 1;
                }
                break;
            case 304:
                resultLT = 304;
                resultRB = 301;
                if (orientation == 2 && corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    hcPossible = false;
                }
                break;
            case 305:
                resultLT = 302;
                resultRB = 305;
                if (orientation == 2 && corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    hcPossible = false;
                }
                break;
            case 400:
                resultLT = 401;
                resultRB = 402;
                if (orientation == 2) {
                    resultLT = 400;
                    resultRB = 1;
                }
                break;
            case 401:
                resultLT = 401;
                resultRB = 401;
                // JOptionPane
                // .showMessageDialog(
                // null,
                // "Division for shape "
                // + myShape
                // +
                // " is unavailable:\nTo request this feature please contact your supplier!",
                // "Error",
// JOptionPane.ERROR_MESSAGE);
                // vcPossible = false;
                if (orientation == 2) {
                    resultLT = 401;
                    resultRB = 1;
                }
                break;
            case 402:
                // JOptionPane
                // .showMessageDialog(
                // null,
                // "Division for shape "
                // + myShape
                // +
                // " is unavailable:\nTo request this feature please contact your supplier!",
                // "Error",
// JOptionPane.ERROR_MESSAGE);
                // vcPossible = false;
                resultLT = 402;
                resultRB = 402;
                if (orientation == 2) {
                    resultLT = 402;
                    resultRB = 1;
                }
                break;
            case 403:
                resultLT = 401;
                resultRB = 402;
                if (orientation == 2) {
                    resultLT = 403;
                    resultRB = 1;
                }
                break;
            case 450:
                if (corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    hcPossible = false;
                    vcPossible = false;
                }
                break;
            case 453:
                if (corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    hcPossible = false;
                    vcPossible = false;
                }
                break;
            case 700:
                resultLT = 700;
                resultRB = 100;
                if (orientation == 2)
// && (corm==1))
                {
// JOptionPane
// .showMessageDialog(
// null,
// "Division for shape "
// + myShape
// +
// " is unavailable:\nTo request this feature please contact your supplier!",
// "Error",
// JOptionPane.ERROR_MESSAGE);
// hcPossible = false;
                    resultLT = 700;
                    resultRB = 102;
                }
                break;
            case 701:
                resultLT = 101;
                resultRB = 701;
                if (orientation == 2)
// && (corm==1))
                {
// JOptionPane
// .showMessageDialog(
// null,
// "Division for shape "
// + myShape
// +
// " is unavailable:\nTo request this feature please contact your supplier!",
// "Error",
// JOptionPane.ERROR_MESSAGE);
// hcPossible = false;
                    resultLT = 701;
                    resultRB = 103;
                }
                break;
            case 702:
                resultLT = 702;
                resultRB = 115;
                if (orientation == 2 && corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    hcPossible = false;
// resultLT = 700;
// resultRB = 705;
                }
                break;
            case 703:
                resultLT = 113;
                resultRB = 703;
                if (orientation == 2 && corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    hcPossible = false;
// resultLT = 701;
// resultRB = 706;
                }
                break;
            case 704:
                this.resultLT = 700;
                this.resultRB = 701;
                if (orientation == 1 && corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    vcPossible = false;
                }
                if (orientation == 2)
// && (corm==1))
                {
// JOptionPane
// .showMessageDialog(
// null,
// "Division for shape "
// + myShape
// +
// " is unavailable:\nTo request this feature please contact your supplier!",
// "Error",
// JOptionPane.ERROR_MESSAGE);
// hcPossible = false;
                    this.resultLT = 704;
                    this.resultRB = 112;
                }
                break;
            case 705:
                resultLT = 705;
                resultRB = 105;
                if (orientation == 2)
// && (corm==1))
                {
// JOptionPane
// .showMessageDialog(
// null,
// "Division for shape "
// + myShape
// +
// " is unavailable:\nTo request this feature please contact your supplier!",
// "Error",
// JOptionPane.ERROR_MESSAGE);
// hcPossible = false;

                    resultLT = 107;
                    resultRB = 705;
                }
                break;
            case 706:
                resultLT = 104;
                resultRB = 706;
                if (orientation == 2)
// && (corm==1))
                {
// JOptionPane
// .showMessageDialog(
// null,
// "Division for shape "
// + myShape
// +
// " is unavailable:\nTo request this feature please contact your supplier!",
// "Error",
// JOptionPane.ERROR_MESSAGE);
// hcPossible = false;
                    resultLT = 106;
                    resultRB = 706;
                }
                break;
            case 800:
                JOptionPane
                        .showMessageDialog(
                                null,
                                "Division for shape "
                                        + myShape
                                        + " is unavailable:\nTo request this feature please contact your supplier!",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                vcPossible = false;
                hcPossible = false;
                break;
            case 801:
                if (corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    vcPossible = false;
                    hcPossible = false;
                }

                break;
            case 802:
                if (corm == 1) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Division for shape "
                                            + myShape
                                            + " is unavailable:\nTo request this feature please contact your supplier!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    vcPossible = false;
                    hcPossible = false;
                }
                break;
        }

    }

    public int getResultLT() {

        return resultLT;
    }

    public int getResultRB() {

        return resultRB;
    }

    public boolean rbPossible() {

        return hcPossible;
    }

    public boolean ltPossible() {

        return vcPossible;
    }

}
