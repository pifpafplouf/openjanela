package openjanela.model.entities.partner;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 08-31-12
 * Time: 03:14 PM
 */
public enum ValidOpenings {

    Default(0),
    P(1),
    LHo(2),
    RHo(3),
    THo(4),
    FSo(5),
    LHi(6),
    RHi(7),
    THi(8),
    FSi(9),
    BHi(10),
    SSL(11),
    SSR(12),
    _3LS(13),
    _4LS(14),
    CSL(15),
    CSR(16),
    CSBi(17),
    STS(18),
    DSL(21),
    DSR(22),
    _3LSd(23),
    _4LSd(24),
    SH(31),
    DH(32),
    TTL(41),
    TTR(42),
    TTLrs(43),
    TTRls(44),
    PvtH(51),
    PvtV(52),
    LOU(61),
    DCaso(71),
    DCLrs(72),
    DCEls(73),
    DCasi(76),
    _2DCLrs(77),
    _2DCRls(78),
    SSL_O(211),
    SSR_O(212),
    _3LS_O(213),
    _4LS_O(214),
    CSL_O(215),
    CSR_O(216),
    CSBi_(217),
    DSL_O(221),
    DSR_O(222),
    _3LSd_(223),
    _4LSd_(224),
    SH_O(231),
    DH_O(232),
    _2TTLrs(243),
    _2TTRls(244),
    DCASo(271),
    _3DCLrs(272),
    _3DCRls(273),
    DCASi(276),
    _4DCLrs(277),
    DCRls(278),
    SL_1(291),
    SR_1(292),
    SC_1(293),
    FL(301),
    FR(302),
    FM(303),
    PL(311),
    PR(312),
    PM(313);

    private int value;

    ValidOpenings(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * Getting opening abreviation
     * @param value, Opening valid id
     * @return String
     */
    public String getAbbrev(int value) {

        //Opening name
        String name;

        switch (value) {
            case 1:
                name = "P";
                break;
            case 2:
                name = "LHo";
                break;
            case 3:
                name = "RHo";
                break;
            case 4:
                name = "THo";
                break;
            case 5:
                name = "FSo";
                break;
            case 6:
                name = "LHi";
                break;
            case 7:
                name = "RHi";
                break;
            case 8:
                name = "THi";
                break;
            case 9:
                name = "FSi";
                break;
            case 10:
                name = "BHi";
                break;
            case 11:
                name = "SSL";
                break;
            case 12:
                name = "SSR";
                break;
            case 13:
                name = "3LS";
                break;
            case 14:
                name = "4LS";
                break;
            case 15:
                name = "CSL";
                break;
            case 16:
                name = "CSR";
                break;
            case 17:
                name = "CSBi";
                break;
            case 18:
                name = "STS";
                break;
            case 21:
                name = "DSL";
                break;
            case 22:
                name = "DSR";
                break;
            case 23:
                name = "3LSd";
                break;
            case 24:
                name = "4LSd";
                break;
            case 31:
                name = "SH";
                break;
            case 32:
                name = "DH";
                break;
            case 41:
                name = "TTL";
                break;
            case 42:
                name = "TTR";
                break;
            case 43:
                name = "TTLrs";
                break;
            case 44:
                name = "TTRls";
                break;
            case 51:
                name = "PvtH";
                break;
            case 52:
                name = "PvtV";
                break;
            case 61:
                name = "LOU";
                break;
            case 71:
                name = "DCaso";
                break;
            case 72:
                name = "DCLrs";
                break;
            case 73:
                name = "DCEls";
                break;
            case 76:
                name = "DCasi";
                break;
            case 77:
                name = "DCLrs";
                break;
            case 78:
                name = "DCRls";
                break;
            case 211:
                name = "SSL-O";
                break;
            case 212:
                name = "SSR-O";
                break;
            case 213:
                name = "3LS-O";
                break;
            case 214:
                name = "4LS-O";
                break;
            case 215:
                name = "CSL-O";
                break;
            case 216:
                name = "CSR-O";
                break;
            case 217:
                name = "CSBi-";
                break;
            case 221:
                name = "DSL-O";
                break;
            case 222:
                name = "DSR-O";
                break;
            case 223:
                name = "3LSd-";
                break;
            case 224:
                name = "4LSd-";
                break;
            case 231:
                name = "SH-O";
                break;
            case 232:
                name = "DH-O";
                break;
            case 243:
                name = "TTLrs";
                break;
            case 244:
                name = "TTRls";
                break;
            case 271:
                name = "DCASo";
                break;
            case 272:
                name = "DCLrs";
                break;
            case 273:
                name = "DCRls";
                break;
            case 276:
                name = "DCASi";
                break;
            case 277:
                name = "DCLrs";
                break;
            case 278:
                name = "DCRls";
                break;
            case 291:
                name = "SL-?";
                break;
            case 292:
                name = "SR-?";
                break;
            case 293:
                name = "SC-?";
                break;
            case 301:
                name = "FL";
                break;
            case 302:
                name = "FR";
                break;
            case 303:
                name = "FM";
                break;
            case 311:
                name = "PL";
                break;
            case 312:
                name = "PR";
                break;
            case 313:
                name = "PM";
                break;
            default :
                name = "**-**";
                break;
        }

        return name;
    }

    /**
     * Getting Opening description
     * @param value, Opening valid id
     * @return String
     */
    public String getName(int value) {
        
        //Opening name
        String name;
        
        switch (value) {
            case 1:
                name = "Picture/Fix";
                break;
            case 2:
                name = "Casement Left Hinged (LH)";
                break;
            case 3:
                name = "Casement Right Hinged (RH)";
                break;
            case 4:
                name = "Awning Top Hinged (TH)";
                break;
            case 5:
                name = "Fixed Sash (FS)";
                break;
            case 6:
                name = "In-Swing Left Hinged (LH)";
                break;
            case 7:
                name = "In-Swing Right Hinged (RH)";
                break;
            case 8:
                name = "In-Swing Top Hinged (TH)";
                break;
            case 9:
                name = "In_Swing Fixed Sash (FS)";
                break;
            case 10:
                name = "Hopper Bottom Hinged (BH)";
                break;
            case 11:
                name = "Single Slider L (SSL)";
                break;
            case 12:
                name = "Single Slider R (SSR)";
                break;
            case 13:
                name = "3 Pane Slider L+R Slide";
                break;
            case 14:
                name = "4 Pane Slider L+R Fixed - Centers Slide";
                break;
            case 15:
                name = "Center Slider - L";
                break;
            case 16:
                name = "Center Slider - R";
                break;
            case 17:
                name = "Center slider - Bi-Directional Center";
                break;
            case 18:
                name = "Custom Single Track Slider";
                break;
            case 21:
                name = "Doule Slider Left";
                break;
            case 22:
                name = "Double Slider Right";
                break;
            case 23:
                name = "3 Pane 2 Track Double Slider";
                break;
            case 24:
                name = "4 Pane 2 Track Double Slider";
                break;
            case 31:
                name = "Single Hung ";
                break;
            case 32:
                name = "Double Hung";
                break;
            case 41:
                name = "Tilt Turn left (TTL)";
                break;
            case 42:
                name = "Tilt Turn Right (TTR)";
                break;
            case 43:
                name = "TTL+ Slave Right";
                break;
            case 44:
                name = "TTR + Slave Left";
                break;
            case 51:
                name = "Pivot Horizontal";
                break;
            case 52:
                name = "Pivot Vertical";
                break;
            case 61:
                name = "Louvered/Jealousie";
                break;
            case 71:
                name = "Double Case: Projected Out";
                break;
            case 72:
                name = "Double Case: Left Project Out - Right Slave";
                break;
            case 73:
                name = "Double Case: Right Project Out - Left Slave";
                break;
            case 76:
                name = "Double Case: Projected In";
                break;
            case 77:
                name = "Double Case: Left Projected In - Right Slave";
                break;
            case 78:
                name = "Double Case: Right Projected In - Left Slave";
                break;
            case 211:
                name = "Single Slider Left - Variable Split";
                break;
            case 212:
                name = "Single slider Right - Variable Split";
                break;
            case 213:
                name = "3 Pane Slider - Variable Split";
                break;
            case 214:
                name = "4 Pabe Slider - Variable Split";
                break;
            case 215:
                name = "Center Slider Left - Variable Split";
                break;
            case 216:
                name = "Center Sllider Right - Variable Split";
                break;
            case 217:
                name = "Center Sllider Right - Variable Split";
                break;
            case 221:
                name = "Double Slider Left - Variable Split";
                break;
            case 222:
                name = "Double Slider Right - Variable Split";
                break;
            case 223:
                name = "3 Pane 2 Track Slider - Variable Split";
                break;
            case 224:
                name = "4 Pane 2 Track Slider - Variable Split";
                break;
            case 231:
                name = "Single Hung - Variable Split";
                break;
            case 232:
                name = "Double Hung - Variable Split";
                break;
            case 243:
                name = "TTL + Right Slave - Variable Split";
                break;
            case 244:
                name = "TTR + Left Slave = Variable Split";
                break;
            case 271:
                name = "DBL Case - PO - Variable Split";
                break;
            case 272:
                name = "DBL Case Left - PO - Right Slave";
                break;
            case 273:
                name = "DBL Case Right - PO - Left Slave";
                break;
            case 276:
                name = "DBL Case - PI";
                break;
            case 277:
                name = "DBL Case Left - PI -  Right Slave";
                break;
            case 278:
                name = "DBL Case Right - PI - Left Slave";
                break;
            case 291:
                name = "Custome Slider Left";
                break;
            case 292:
                name = "Custome Slider Right";
                break;
            case 293:
                name = "Custome Slider Center";
                break;
            case 301:
                name = "Folding Left";
                break;
            case 302:
                name = "Folding Right";
                break;
            case 303:
                name = "Folding Middle";
                break;
            case 311:
                name = "Pocket Left";
                break;
            case 312:
                name = "Pocket Right";
                break;
            case 313:
                name = "Pocket Middle";
                break;
            default :
                name = "**-**";
                break;                 
        }

        return name;
    }
}
