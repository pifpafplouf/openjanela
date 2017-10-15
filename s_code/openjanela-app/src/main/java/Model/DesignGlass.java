package Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import openjanela.model.entities.partner.OptionAnswers;
import org.apache.log4j.Logger;

public class DesignGlass implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(DesignGlass.class);

    public int a_levelID = 0;
    public int a_sequenceID = 11;
    public int a_assemblyLevel = 0;
    public int a_1Level = 0;
    public int a_1Sequence = 0;
    public int a_2Level = 0;
    public int a_2Sequence = 0;
    public int a_3Level = 0;
    public int a_3Sequence = 0;
    public int a_4Level = 0;
    public int a_4Sequence = 0;
    public int a_5Level = 0;
    public int a_5Sequence = 0;
    public int a_6Level = 0;
    public int a_6Sequence = 0;
    public int a_7Level = 0;
    public int a_7Sequence = 0;
    public int a_8Level = 0;
    public int a_8Sequence = 0;
    public int a_9Level = 0;
    public int a_9Sequence = 0;
    public int a_10Level = 0;
    public int a_10Sequence = 0;
    public int a_11Level = 0;
    public int a_11Sequence = 0;
    public int a_12Level = 0;
    public int a_12Sequence = 0;
    public int a_13Level = 0;
    public int a_13Sequence = 0;
    public int a_14Level = 0;
    public int a_14Sequence = 0;
    public int a_15Level = 0;
    public int a_15Sequence = 0;
    public int a_16Level = 0;
    public int a_16Sequence = 0;
    public int a_17Level = 0;
    public int a_17Sequence = 0;
    public int a_18Level = 0;
    public int a_18Sequence = 0;
    public int a_19Level = 0;
    public int a_19Sequence = 0;
    public int a_20Level = 0;
    public int a_20Sequence = 0;
    public int a_21Level = 0;
    public int a_21Sequence = 0;
    public int a_22Level = 0;
    public int a_22Sequence = 0;

    public String stockCode = "@@";
    public String description = "@@";
    public String abbrev = "@@";

    public double minArea = 0;
    public double minAreaImp = 0;
    public double maxArea = 0;
    public double maxAreaImp = 0;
    public double whRatio = 0;
    public double minPricingArea = 0;
    public double minPricingAreaImp = 0;
    public double waste = 0;
    public double minCostArea = 0;
    public double minCostAreaImp = 0;
    public double thickness = 0;
    public double thicknessImp = 0;
    public double glassToSpacer = 0;
    public double glassToSpacerImp = 0;
    public double spacerThick1 = 0;
    public double spacerThick2 = 0;
    public double spacerThick3 = 0;
    public double airSpace1 = 0;
    public double airSpace2 = 0;
    public double airSpace3 = 0;
    public double spacerThick1i = 0;
    public double spacerThick2i = 0;
    public double spacerThick3i = 0;
    public double airSpace1i = 0;
    public double airSpace2i = 0;
    public double airSpace3i = 0;

    public int suID;
    public int minWidth = 0;
    public int minWidthImp = 0;
    public int minHeight = 0;
    public int minHeightImp = 0;
    public int maxWidth = 0;
    public int maxWidthImp = 0;
    public int maxHeight = 0;
    public int maxHeightImp = 0;
    public int leadTime = 0;
    public int pricingUOMId = -1;
    public int priceMatrixId = -1;
    public int costGroupId = -1;
    public int priceGroupId = -1;
    public int partnerGroupId = -1;
    public int nextItem = -1;
    public int supplierId = -1;
    public int productionLine = -1;
    public int sortSeq = -1;
    public int sealantPartId = -1;
    public int familyId = -1;
    public int insert1Id = -1;
    public int insert2Id = -1;
    public int insert3Id = -1;
    public int glazingType = 1;// 0 = unglazed 1 = glass 2 = SU
    public int numOfLeaves = 0;
    public int leaf1 = 0;
    public int leaf2 = 0;
    public int leaf3 = 0;
    public int leaf4 = 0;
    public int spacer1 = 0;
    public int spacer2 = 0;
    public int spacer3 = 0;
    public int gas1 = 0;
    public int gas2 = 0;
    public int gas3 = 0;
    public int film1 = 0;
    public int film2 = 0;
    public int film3 = 0;
    public int film4 = 0;
    public int process1 = 0;
    public int process2 = 0;
    public int process3 = 0;
    public int process4 = 0;
    public int cavityProcess1 = 0;
    public int cavityProcess2 = 0;
    public int cavityProcess3 = 0;
    public int cavity1Process2 = 0;
    public int cavity2Process2 = 0;
    public int cavity3Process2 = 0;
    public int cavity1Process3 = 0;
    public int cavity2Process3 = 0;
    public int cavity3Process3 = 0;
    public int externalProcess1 = 0;
    public int externalProcess2 = 0;
    public int externalProcess3 = 0;
    public int externalProcess4 = 0;
    public int external1Process2 = 0;
    public int external2Process2 = 0;
    public int external3Process2 = 0;
    public int external4Process2 = 0;
    public int external1Process3 = 0;
    public int external2Process3 = 0;
    public int external3Process3 = 0;
    public int external4Process3 = 0;
    public int glass1 = 0;
    public int glass2 = 0;
    public int glass3 = 0;
    public int glass4 = 0;
    public int glass1Process2 = 0;
    public int glass2Process2 = 0;
    public int glass3Process2 = 0;
    public int glass4Process2 = 0;
    public int glass1Process3 = 0;
    public int glass2Process3 = 0;
    public int glass3Process3 = 0;
    public int glass4Process3 = 0;
    public int leafNo = 1;
    public int leafIn = 0;
    public int leafOut = 0;
    public int widthM = 0;          // OK
    public int heightM = 0;         // OK
    public int widthI = 0;          // OK
    public int heightI = 0;         // OK
    public int widthMN = 0;          // OK
    public int heightMN = 0;         // OK
    public int widthIN = 0;          // OK
    public int heightIN = 0;         // OK
    public int parentcol = 0;
    public int prodline = 0;
    public int station = 0;
    public int report = 0;
    public int delivery = 0;
    public int reqforstage = 0;
    public int partFamily = 0;
    public int priceGroup = 0;
    public int priceCat = 3;
    public int measure = 0;
    public int udOpeningID = 0;
    public int shapeID = 0;

    public int glassBomID = 0;
    public int assemblyID = 0;

    public int gridID = 0;
    public int gridType = 0;
    public int noGridsV = 0;
    public int noGridsH = 0;
    public int noGridsS = 0;
    public int noGridsR = 0;

    public boolean priceActualSize = false;
    public boolean costActualSize = false;
    public boolean display = false;
    public boolean madeIn = false;
    public boolean isCustom = false;
    public boolean inHouse = false;

    public String sashAbbreviation = "";
    public String shapeAbbreviation = "";

    public BigDecimal cost = new BigDecimal("0.00");
    public BigDecimal price = new BigDecimal("0.00");
    public BigDecimal priceUser = new BigDecimal("0.00");
    public BigDecimal minPrice = new BigDecimal("0.00");

    public Date startDate = new Date();
    public Date endDate = new Date();

    public Collection<OptionAnswers> optionsAllowedAnswers = new ArrayList();

    public boolean isUsed;

    public ShapeObject shapeObject;

    public int supplierRemoteId = 0;
    public int seriesSupplierId = 0;
    public boolean remote = false;

    public DesignGlass() {}

    /**
     * Reset Price and Cost to ZERO
     */
    public void resetPriceAndCost() {
        this.cost = new BigDecimal("0");
        this.price = new BigDecimal("0");
        this.priceUser = new BigDecimal("0");
        this.minPrice = new BigDecimal("0");
    }

    public boolean isForShape(ShapeObject shape) {

        boolean match = false;

        if (shape.a_assemblyLevel == this.a_assemblyLevel && shape.a_1Level == a_1Level && shape.a_2Level == a_2Level
                && shape.a_3Level == a_3Level && shape.a_4Level == a_4Level && shape.a_5Level == a_5Level
                && shape.a_6Level == a_6Level && shape.a_7Level == a_7Level && shape.a_8Level == a_8Level
                && shape.a_9Level == a_9Level && shape.a_10Level == a_10Level && shape.a_11Level == a_11Level
                && shape.a_12Level == a_12Level && shape.a_13Level == a_13Level && shape.a_14Level == a_14Level
                && shape.a_15Level == a_15Level && shape.a_16Level == a_16Level && shape.a_17Level == a_17Level
                && shape.a_18Level == a_18Level && shape.a_19Level == a_19Level && shape.a_20Level == a_20Level
                && shape.a_21Level == a_21Level && shape.a_22Level == a_22Level
                && shape.a_sequenceID == this.a_sequenceID && shape.a_1Sequence == a_1Sequence
                && shape.a_2Sequence == a_2Sequence && shape.a_3Sequence == a_3Sequence
                && shape.a_4Sequence == a_4Sequence && shape.a_5Sequence == a_5Sequence
                && shape.a_6Sequence == a_6Sequence && shape.a_7Sequence == a_7Sequence
                && shape.a_8Sequence == a_8Sequence && shape.a_9Sequence == a_9Sequence
                && shape.a_10Sequence == a_10Sequence && shape.a_11Sequence == a_11Sequence
                && shape.a_12Sequence == a_12Sequence && shape.a_13Sequence == a_13Sequence
                && shape.a_14Sequence == a_14Sequence && shape.a_15Sequence == a_15Sequence
                && shape.a_16Sequence == a_16Sequence && shape.a_17Sequence == a_17Sequence
                && shape.a_18Sequence == a_18Sequence && shape.a_19Sequence == a_19Sequence
                && shape.a_20Sequence == a_20Sequence && shape.a_21Sequence == a_21Sequence
                && shape.a_22Sequence == a_22Sequence) {

            match = true;

        }
        return match;
    }

    @Override
    public DesignGlass clone() {

        try {

            return (DesignGlass)super.clone();

        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }
}
