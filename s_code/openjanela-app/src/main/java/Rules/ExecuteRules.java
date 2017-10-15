package Rules;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import openjanela.app.configuration.controller.calculation.MatrixController;
import openjanela.model.eao.admin.systemUOMEAO.SystemUOMEAO;
import openjanela.model.eao.admin.systemUOMEAO.SystemUOMPersistenceEAO;
import openjanela.model.eao.admin.typeGlazingEAO.TypeGlazingEAO;
import openjanela.model.eao.admin.typeGlazingEAO.TypeGlazingPersistenceEAO;
import openjanela.model.eao.admin.typeLevelEAO.TypeLevelEAO;
import openjanela.model.eao.admin.typeLevelEAO.TypeLevelPersistenceEAO;
import openjanela.model.eao.admin.typeOpeningEAO.TypeOpeningEAO;
import openjanela.model.eao.admin.typeOpeningEAO.TypeOpeningPersistenceEAO;
import openjanela.model.eao.admin.typePriceCategoryEAO.TypePriceCategoryEAO;
import openjanela.model.eao.admin.typePriceCategoryEAO.TypePriceCategoryPersistenceEAO;
import openjanela.model.eao.admin.typeShapeEAO.TypeShapeEAO;
import openjanela.model.eao.admin.typeShapeEAO.TypeShapePersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.eao.orderEntry.costingGroupEAO.CostingGroupEAO;
import openjanela.model.eao.orderEntry.costingGroupEAO.CostingGroupPersistenceEAO;
import openjanela.model.eao.partner.gridsEAO.GridsEAO;
import openjanela.model.eao.partner.gridsEAO.GridsPersistenceEAO;
import openjanela.model.eao.partner.matrixEAO.MatrixEAO;
import openjanela.model.eao.partner.matrixHeaderEAO.MatrixHeaderEAO;
import openjanela.model.eao.partner.matrixHeaderEAO.MatrixHeaderPersistenceEAO;
import openjanela.model.eao.partner.matrixEAO.MatrixPersistenceEAO;
import openjanela.model.eao.partner.optionsEAO.OptionAnswersEAO;
import openjanela.model.eao.partner.optionsEAO.OptionAnswersPersistenceEAO;
import openjanela.model.eao.partner.optionsEAO.OptionsEAO;
import openjanela.model.eao.partner.optionsEAO.OptionsPersistenceEAO;
import openjanela.model.eao.partner.partnerEAO.PartnerDefaultEAO;
import openjanela.model.eao.partner.partnerEAO.PartnerDefaultPersistenceEAO;
import openjanela.model.eao.partner.partnerEAO.PartnerEAO;
import openjanela.model.eao.partner.partnerEAO.PartnerPersistenceEAO;
import openjanela.model.eao.partner.partnerGroupLineDiscountEAO.PartnerGroupLineDiscountEAO;
import openjanela.model.eao.partner.partnerGroupLineDiscountEAO.PartnerGroupLineDiscountPersistenceEAO;
import openjanela.model.eao.partner.partnerLineDiscountEAO.PartnerLineDiscountEAO;
import openjanela.model.eao.partner.partnerLineDiscountEAO.PartnerLineDiscountPersistenceEAO;
import openjanela.model.eao.partner.partsCostPriceEAO.PartsCostPriceEAO;
import openjanela.model.eao.partner.partsCostPriceEAO.PartsCostPricePersistenceEAO;
import openjanela.model.eao.partner.partsEAO.PartsEAO;
import openjanela.model.eao.partner.partsEAO.PartsPersistenceEAO;
import openjanela.model.eao.partner.partsFamilyEAO.PartsFamilyEAO;
import openjanela.model.eao.partner.partsFamilyEAO.PartsFamilyPersistenceEAO;
import openjanela.model.eao.partner.pricingGroupEAO.PricingGroupEAO;
import openjanela.model.eao.partner.pricingGroupEAO.PricingGroupPersistenceEAO;
import openjanela.model.eao.partner.productionLineEAO.ProductionLineEAO;
import openjanela.model.eao.partner.productionLineEAO.ProductionLinePersistenceEAO;
import openjanela.model.eao.partner.ruleAnswerEAO.RuleAnswersEAO;
import openjanela.model.eao.partner.ruleAnswerEAO.RuleAnswersPersistenceEAO;
import openjanela.model.eao.partner.ruleTestEAO.RuleTestEAO;
import openjanela.model.eao.partner.ruleTestEAO.RuleTestPersistenceEAO;
import openjanela.model.eao.partner.ruleTestValueEAO.RuleTestValueEAO;
import openjanela.model.eao.partner.ruleTestValueEAO.RuleTestValuePersistenceEAO;
import openjanela.model.eao.partner.rulesEAO.RulesEAO;
import openjanela.model.eao.partner.rulesEAO.RulesPersistenceEAO;
import openjanela.model.eao.partner.seriesAllowedSUThickEAO.SeriesAllowedSUThickEAO;
import openjanela.model.eao.partner.seriesAllowedSUThickEAO.SeriesAllowedSUThickPersistenceEAO;
import openjanela.model.eao.partner.seriesEAO.SeriesCategoryEAO;
import openjanela.model.eao.partner.seriesEAO.SeriesCategoryPersistenceEAO;
import openjanela.model.eao.partner.seriesValidOpeningShapeEAO.SeriesValidOpeningShapeEAO;
import openjanela.model.eao.partner.seriesValidOpeningShapeEAO.SeriesValidOpeningShapePersistenceEAO;
import openjanela.model.eao.partner.seriesValidOpeningsEAO.SeriesValidOpeningsEAO;
import openjanela.model.eao.partner.seriesValidOpeningsEAO.SeriesValidOpeningsPersistenceEAO;
import openjanela.model.eao.partner.seriesValidShapesEAO.SeriesValidShapesEAO;
import openjanela.model.eao.partner.seriesValidShapesEAO.SeriesValidShapesPersistenceEAO;
import openjanela.model.eao.partner.suFamilyEAO.SUFamilyEAO;
import openjanela.model.eao.partner.suFamilyEAO.SUFamilyPersistenceEAO;
import openjanela.model.eao.partner.suTypeEAO.SUTypeEAO;
import openjanela.model.eao.partner.suTypeEAO.SUTypePersistenceEAO;
import openjanela.model.entities.admin.SystemUOM;
import openjanela.model.entities.admin.TypeGlazing;
import openjanela.model.entities.admin.TypeLevel;
import openjanela.model.entities.admin.TypeOpening;
import openjanela.model.entities.admin.TypeOption;
import openjanela.model.entities.admin.TypePosition;
import openjanela.model.entities.admin.TypePriceCategory;
import openjanela.model.entities.admin.TypeShape;
import openjanela.model.entities.design.GlazingType;
import openjanela.model.entities.orderEntry.CartDefault;
import openjanela.model.entities.orderEntry.CostingGroup;
import openjanela.model.entities.orderEntry.OrdersCart;
import openjanela.model.entities.orderEntry.PricingGroup;
import openjanela.model.entities.partner.Grids;
import openjanela.model.entities.partner.Matrix;
import openjanela.model.entities.partner.MatrixHeader;
import openjanela.model.entities.partner.OptionAnswers;
import openjanela.model.entities.partner.OptionDefinitions;
import openjanela.model.entities.partner.Partner;
import openjanela.model.entities.partner.PartnerDefault;
import openjanela.model.entities.partner.PartnerGroupLineDiscount;
import openjanela.model.entities.partner.PartnerLineDiscount;
import openjanela.model.entities.partner.ProductionLine;
import openjanela.model.entities.partner.RuleAnswers;
import openjanela.model.entities.partner.RuleTest;
import openjanela.model.entities.partner.RuleTestValue;
import openjanela.model.entities.partner.Rules;
import openjanela.model.entities.partner.SUFamily;
import openjanela.model.entities.partner.SUType;
import openjanela.model.entities.partner.Series;
import openjanela.model.entities.partner.SeriesAllowedSUThick;
import openjanela.model.entities.partner.SeriesCategory;
import openjanela.model.entities.partner.SeriesValidOpeningShape;
import openjanela.model.entities.partner.SeriesValidOpenings;
import openjanela.model.entities.partner.SeriesValidShapes;
import openjanela.model.entities.parts.Parts;
import openjanela.model.entities.parts.PartsCostPrice;
import openjanela.model.entities.parts.PartsFamily;
import orderEntryUtility.UOMConvertData;
import Model.BkgrdOpeningObject;
import Model.DLO;
import Model.DesignOption;
import Model.Facet;
import Model.Frame;
import Model.GlassSU;
import Model.GlazingBeads;
import Model.JobItemCostPrice;
import Model.OpeningObject;
import Model.OrderItemsCart;
import Model.Overall;
import Model.SashLeaf;
import Model.SashTypeObject;
import Model.ShapeObject;
import Model.ProfileParts.Profiles;
import Presentation.ItemFrame;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;

import org.apache.commons.collections.CollectionUtils;
import org.openjanela.data.ApplicationBaseApp;
import org.openjanela.data.ApplicationBaseRulesApp;
import org.openjanela.data.ApplicationRemoteBaseRulesApp;

public class ExecuteRules {

	public OrdersCart cartData = new OrdersCart();

	public Series series = new Series();

	public SeriesCategory seriesCat = new SeriesCategory();

	public Partner partner = new Partner();

	public Overall design = new Overall();

	public CartDefault cartDefault = new CartDefault();

	public Collection<CartDefault> cartDefaults = new ArrayList<CartDefault>();

	public Rules rule = new Rules();

	public RulesEAO rulesEAO;

	public List<Rules> currentRules = new ArrayList();

	public RuleTest ruleTest = new RuleTest();

	public RuleTestEAO ruleTestEAO;

	public List<RuleTest> myRuleTests = new ArrayList();

	public RuleTestValue ruleTestValue = new RuleTestValue();

	public RuleTestValueEAO ruleTestValueEAO;

	public List<RuleTestValue> myRuleTestValues = new ArrayList();

	public RuleAnswers ruleAnswer = new RuleAnswers();

	public RuleAnswersEAO ruleAnswerEAO;

	public List<RuleAnswers> myRuleAnswers = new ArrayList();

	public List<OptionAnswers> myOptionAnswers = new ArrayList();

	public PartnerDefault partnerDefault = new PartnerDefault();

	public PartnerDefaultEAO partnerDefaultEAO;

	public PartnerLineDiscount partnerLineDiscount = new PartnerLineDiscount();

	public PartnerLineDiscountEAO partnerLineDiscountEAO;

	public PartnerGroupLineDiscount partnerGroupLineDiscount = new PartnerGroupLineDiscount();

	public PartnerGroupLineDiscountEAO partnerGroupLineDiscountEAO;

	public OptionDefinitions option = new OptionDefinitions();

	public OptionsEAO optionsEAO;

	public OptionAnswersEAO optionAnswersEAO;

	public OptionAnswers optionAnswer = new OptionAnswers();

	public Parts part = new Parts();

	public PartsEAO partsEAO;

	public Matrix matrix = new Matrix();

	public MatrixEAO matrixEAO;

	public MatrixHeaderEAO matrixHeaderEAO;

	public PartsFamilyEAO partsFamilyEAO;

	public PartsCostPrice partsCostPrice = new PartsCostPrice();

	public PartsCostPriceEAO partsCostPriceEAO;

	public List<PartsCostPrice> partCostPrices = new ArrayList();

	public PricingGroup priceGroup = new PricingGroup();

	public PricingGroupEAO priceGroupsEAO;

	public SeriesValidOpenings openingClass = new SeriesValidOpenings();

	public SeriesValidOpeningsEAO seriesValidOpeningsEAO;

	public SeriesValidShapes shapeClass = new SeriesValidShapes();

	public SeriesValidShapesEAO seriesValidShapesEAO;

	public SeriesValidOpeningShape udOpening = new SeriesValidOpeningShape();

	public SeriesValidOpeningShapeEAO seriesValidOpeningShapeEAO;

	public TypeOpening openingType = new TypeOpening();

	public TypeOpeningEAO typeOpeningEAO;

	public TypePriceCategoryEAO typePriceCategoryEAO;

	public TypeLevel level = new TypeLevel();

	public TypeLevelEAO typeLevelEAO;

	public TypeShape shape = new TypeShape();

	public TypeShapeEAO typeShapeEAO;

	public BigDecimal myScale = new BigDecimal(0);

	public int mySeq = 0;

	public int myUOM = 1;

	public ShapeObject myShape = null;

	public Profiles myMullionCoupler = null;

	public OrderItemsCart myItem = null;

	public Overall myOverall = null;

	public int myAssemblyLevel = 0;

	public Facet myFacet = null;

	public Frame myFrame = null;

	public SashTypeObject mySashType = null;

	public SashLeaf mySash = null;

	public OpeningObject myOpening = null;

	public GlassSU myGlass = null; // + 902

	public DLO myDLO = null;

	public BkgrdOpeningObject myBkgrdOpening = null;

	public GlazingBeads myBeads = null;

	public Facet mySubFacet = null;

	public SashTypeObject mySubSash = null;

	public Profiles myMullion = null;

	public Profiles myCoupler = null;

	public Profiles myDivider = null;

	public Profiles myGrid = null;

	public Profiles profile;

	public GlassSU myGlassItem = null; // 902

	public OrderItemsCart myUnitItem = null; // 903

	public OrderItemsCart myProfileItem; // 904

	public OrderItemsCart myAreaItem = null; // 905

	public OrderItemsCart myVolumeItem = null; // 906

	public OrderItemsCart myLabourItem = null; // 907

	public TypeOption optionType = new TypeOption();

	public Collection objectOptions = new ArrayList();

	public CalculatePriceCost calPriceCost = new CalculatePriceCost();

	public Collection discs = new ArrayList();

	public ItemFrame myFrame2;

	public boolean isNewItem = true;

	public List<Rules> subRules = new ArrayList<Rules>();

	public List<RuleTest> subTests = new ArrayList<RuleTest>();

	public List<RuleTestValue> subTestValues = new ArrayList<RuleTestValue>();

	public List<RuleAnswers> subRulesAnswers = new ArrayList<RuleAnswers>();

	public List<RuleTest> subParentTests = new ArrayList<RuleTest>();

	public List<RuleTestValue> subParenTestValues = new ArrayList<RuleTestValue>();

	public List<RuleAnswers> subParentRulesAnswers = new ArrayList<RuleAnswers>();

	public int parentRuleID = 0;

	public Rules myParentRule;

	public String setColorAbbrev = "";

	public int setWild1 = 0;
	public int setWild2 = 0;
	public int setWild3 = 0;
	public int setWild4 = 0;
	public int setWild5 = 0;
	public int setWild6 = 0;

	public String setWild1T = "";
	public String setWild2T = "";
	public String setWild3T = "";
	public String setWild4T = "";
	public String setWild5T = "";
	public String setWild6T = "";

	public int setColorid = 0;
	public int setColoridIn = 0;

	public OptionAnswers setColorAnswer = new OptionAnswers();
	public OptionAnswers setColorAnswerIn = new OptionAnswers();

	public List<Integer> colorList = new ArrayList<Integer>();
	public int showColorOptionID = 0;

	public int setRGB_r = 255;

	public int setRGB_g = 255;

	public int setRGB_b = 255;

	public int setRGB_rIn = 255;

	public int setRGB_gIn = 255;

	public int setRGB_bIn = 255;

	public int setSize = 0;

	public int setSizeI = 0;

	public int setDepth = 0;

	public int setDepthI = 0;

	public int setProdLine = 0;

	public int setStation = 0;

	public int setReport = 0;

	public int setDelivery = 0;

	public int setAssembly = 0;

	public int setProcess = 0;

	public int setStage = 0;

	public int setParentAssembly = 0;

	public int setParentRule = 0;

	public TypePosition position = new TypePosition();

	// public TypePositionEAO positionEAO;

	public List<TypePosition> positions = new ArrayList<TypePosition>();

	public SeriesAllowedSUThickEAO seriesAllowedSUThickEAO;

	public List<SeriesAllowedSUThick> allowedThicks = new ArrayList<SeriesAllowedSUThick>();

	public SUTypeEAO suTypeEAO;

	public SUType suType = new SUType();

	public List<SUType> suTypes = new ArrayList<SUType>();

	public SUFamilyEAO suFamilyEAO;

	public SUFamily suFamily = new SUFamily();

	public List<SUFamily> suFamilys = new ArrayList<SUFamily>();

	public TypeGlazingEAO typeGlazingEAO;

	public List<TypeGlazing> TypeGlazing = new ArrayList<TypeGlazing>();

	public ProductionLineEAO productionLineEAO;

	public ProductionLine prodLine = new ProductionLine();

	public List<ProductionLine> prodLines = new ArrayList<ProductionLine>();

	public PartnerEAO partnerEAO;

	public SystemUOMEAO systemUOMEAO;

	public SystemUOM sysUOM = new SystemUOM();

	public List<SystemUOM> sysUOMs = new ArrayList<SystemUOM>();

	public CostingGroupEAO costingGroupEAO;

	public List<CostingGroup> costGroups = new ArrayList<CostingGroup>();

	public GlazingType glazingType = new GlazingType();

	public List<GlazingType> glazingTypes = new ArrayList<GlazingType>();

	public GridsEAO gridsEAO = new GridsPersistenceEAO();

	public List<Grids> grids = new ArrayList<Grids>();

	public Grids grid = new Grids();

	// ------------------------------------------------------------------------------
	// Expression Variables
	// ------------------------------------------------------------------------------

	double w = 0;
	double h = 0;
	double l = 0;

	double t1pl = 0;
	double t2pl = 0;
	double t3pl = 0;
	double b1pl = 0;
	double b2pl = 0;
	double b3pl = 0;

	double lpl = 0;
	double rpl = 0;

	double perimeter = 0;
	double area = 0;

	double d = 0;
	int c = 0;

	int cConn = 0; // Grid Cross Connectors
	int tConn = 0; // Grid T Connectors
	int lConn = 0; // Grid L Connectors
	int sConn = 0; // Grid S Connectors
	int hConn = 0; // Grid Hub Connectors
	int spConn = 0; // Grid Spoke Connectors

	public int forcedAssembly = 0;

	// public boolean setGlazed = false;
	// public int setLastGlazed = 0;
	//
	public ExecuteRules(ItemFrame myframe) {
		myFrame2 = myframe;
	}

	/*
	 * First need to set the 4 bits of info below then need to initialize Data
	 * 
	 * Then Execute Option Rules First!
	 * 
	 * Then Execute Rules as you are building the Design.
	 * 
	 * 
	 * Rebuidling the Model Rebuilds the Result from execute Rules where
	 * necessary. (Includes rebuilding Options)
	 * 
	 * In Options, Executing Options Rules may cause Options to require
	 * rebuilding
	 */

	/**
	 * Reset Execution Values for Rules
	 */
	public void resetExecutionValues() {

		setRGB_r = 255;
		setRGB_g = 255;
		setRGB_b = 255;

		setSize = 0;
		setSizeI = 0;
		setDepth = 0;
		setDepthI = 0;
		setProdLine = 0;
		setStation = 0;
		setReport = 0;
		setDelivery = 0;
		setAssembly = 0;
		setProcess = 0;
		setStage = 0;
		setParentAssembly = 0;
		setParentRule = 0;
	}

	public void setCart(OrdersCart data) {
		this.cartData = data;
	}

	public void setCartDefault(Collection<CartDefault> defaults) {
		this.cartDefaults = defaults;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	public void setDesign(Overall design) {
		this.design = design;
	}

	public Partner setPartner(int pid) {

		this.partner = new Partner();

		partnerEAO = new PartnerPersistenceEAO();

		try {
			partner = partnerEAO.findParner(pid);
		} catch (PersistenceClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GenericPersistenceEAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return partner;
	}

	public Partner setSupplier(int pid) {
		this.partner = new Partner();

		partnerEAO = new PartnerPersistenceEAO();

		try {
			partner = partnerEAO.findParner(pid);
		} catch (PersistenceClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GenericPersistenceEAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return partner;
	}

	public void initData() throws GenericPersistenceEAOException {

		getSeriesRules(this.series);

		initBaseData();

		loadGlazing();

		this.getMandatoryOptions();

		buildPriceGroupsCats();
	}

	public void initBaseData() throws GenericPersistenceEAOException {

		suTypeEAO = new SUTypePersistenceEAO();

		suFamilyEAO = new SUFamilyPersistenceEAO();

		typeGlazingEAO = new TypeGlazingPersistenceEAO();

		productionLineEAO = new ProductionLinePersistenceEAO();

		partnerEAO = new PartnerPersistenceEAO();

		systemUOMEAO = new SystemUOMPersistenceEAO();

		costingGroupEAO = new CostingGroupPersistenceEAO();
		this.costGroups = costingGroupEAO.findAll();

		matrixHeaderEAO = new MatrixHeaderPersistenceEAO();

		matrixEAO = new MatrixPersistenceEAO();

		partsEAO = new PartsPersistenceEAO();

		partsFamilyEAO = new PartsFamilyPersistenceEAO();

		partsCostPriceEAO = new PartsCostPricePersistenceEAO();
		this.partCostPrices = partsCostPriceEAO.findAll();

		priceGroupsEAO = new PricingGroupPersistenceEAO();

		this.typePriceCategoryEAO = new TypePriceCategoryPersistenceEAO();

		partnerDefaultEAO = new PartnerDefaultPersistenceEAO();

		partnerLineDiscountEAO = new PartnerLineDiscountPersistenceEAO();

		partnerGroupLineDiscountEAO = new PartnerGroupLineDiscountPersistenceEAO();

		optionsEAO = new OptionsPersistenceEAO();

		optionAnswersEAO = new OptionAnswersPersistenceEAO();

		seriesValidOpeningsEAO = new SeriesValidOpeningsPersistenceEAO();

		seriesValidShapesEAO = new SeriesValidShapesPersistenceEAO();

		seriesValidOpeningShapeEAO = new SeriesValidOpeningShapePersistenceEAO();

		typeOpeningEAO = new TypeOpeningPersistenceEAO();

		typeLevelEAO = new TypeLevelPersistenceEAO();

		typeShapeEAO = new TypeShapePersistenceEAO();

		this.grids.addAll(this.myFrame2.gridsPanel.grids);

	}

	public void buildPriceGroupsCats() {

		int id = 0;
		for (Object pg : ItemFrame.getApplicationBase().getPricingGroups()) {
			JobItemCostPrice group = new JobItemCostPrice(id++,
					((PricingGroup) pg).getDescription(), 0,
					((PricingGroup) pg).getId());

			this.myFrame2.priceGroups.add(group);
		}

		id = 0;
		for (Object cg : ItemFrame.getApplicationBase().getPartsFamilies()) {
			JobItemCostPrice group = new JobItemCostPrice(id++,
					((PartsFamily) cg).getDescription(), 1,
					((PartsFamily) cg).getId());

			this.myFrame2.partFamilies.add(group);
		}

		id = 0;
		for (Object pc : ItemFrame.getApplicationBase()
				.getTypePriceCategories()) {
			JobItemCostPrice cat = new JobItemCostPrice(id++,
					((TypePriceCategory) pc).getDescription(), 2,
					((TypePriceCategory) pc).getId());

			this.myFrame2.priceCategories.add(cat);
		}

	}

	public void loadGlazing() throws PersistenceClassNotFoundException,
			GenericPersistenceEAOException {

		seriesAllowedSUThickEAO = new SeriesAllowedSUThickPersistenceEAO();
		suTypeEAO = new SUTypePersistenceEAO();
		allowedThicks = seriesAllowedSUThickEAO.findBySeries(this.series
				.getId());

		Timestamp today = new Timestamp(System.currentTimeMillis());

		int uom = 1;
		if (this.myFrame2.currentUOM > 1) {
			uom = 2;
		}

		// Find List of SUTypes
		for (Object asut : allowedThicks) {

			this.suTypes.addAll(suTypeEAO.findByThickness(uom,
					((SeriesAllowedSUThick) asut).getId().getFromThick(),
					((SeriesAllowedSUThick) asut).getId().getToThick(), today));
		}
	}

	public void getSeriesRules(Series series)
			throws GenericPersistenceEAOException {

		SeriesCategoryEAO seriesCatEAO = new SeriesCategoryPersistenceEAO();
		this.seriesCat = seriesCatEAO.findCategory(series.getId());

		rulesEAO = new RulesPersistenceEAO();

		ruleTestEAO = new RuleTestPersistenceEAO();

		ruleTestValueEAO = new RuleTestValuePersistenceEAO();

		ruleAnswerEAO = new RuleAnswersPersistenceEAO();
	}

	public void getMandatoryOptions() {

		myFrame2.mandatoryOptions.clear();
		for (OptionDefinitions option : ItemFrame.getApplicationBaseRules()
				.getOptionDefinitions()) {
			if (option.getMustanswer()) {
				myFrame2.mandatoryOptions.add(option);
			}
		}

	}

	public boolean isCorrectAssemblyLevel(Rules rule) {

		if (rule.getRuletype() <= 3) {

			if (this.myShape != null && rule.getAssemblyID() != 31
					&& rule.getAssemblyID() != 30) {
				return myShape.isMatchingOptionRule(rule);

			} else if (this.myShape == null && this.myMullionCoupler != null) {
				return myMullionCoupler.isMatchingOptionRule(rule);
			}
		} else {

			if (this.myShape != null) {
				return myShape.isMatchingRule(rule);

			} else if (this.myShape == null && this.myMullionCoupler != null) {
				return myMullionCoupler.isMatchingRule(rule);
			}
		}

		return false;
	}

	public boolean isExactAssemblyLevel(Rules rule) {

		if (rule.getRuletype() <= 3) {

			if (this.myShape != null && rule.getAssemblyID() != 31
					&& rule.getAssemblyID() != 30) {
				return myShape.isExactMatchingOptionRule(rule);

			} else if (this.myShape == null && this.myMullionCoupler != null) {
				return myMullionCoupler.isMatchingOptionRule(rule);
			}
		} else {

			if (this.myShape != null) {
				return myShape.isMatchingRule(rule);

			} else if (this.myShape == null && this.myMullionCoupler != null) {
				return myMullionCoupler.isMatchingRule(rule);
			}
		}

		return false;
	}

	/**
	 * Filter Complete Arrays -> Get Individual Rule Arrays
	 * 
	 * @param rule
	 *            , Rules Execution
	 * @param answers
	 *            , Answers Collection
	 * @param tests
	 *            , Test Collection
	 * @return boolean
	 */
	public boolean filterArraysAndTest(Rules rule, List<RuleAnswers> answers,
			List<RuleTest> tests, int mySeries) {

		// load Test and Test values and
		// RuleAnswers for current
		List<TestResults> testRes = new ArrayList<TestResults>();

		boolean passTest = true;

		/**
		 * Clear individual Rule Arrays and Populate From Complete Arrays
		 */

		myRuleAnswers.clear();
		myRuleTests.clear();
		myRuleTestValues.clear();
		myOptionAnswers.clear();

		ArrayList ruleTestsResults = new ArrayList();

		TestResults testResults = new TestResults();
		Object[] myAnswers = answers.toArray();
		Object[] myTests = tests.toArray();

		for (Object ruleAnswer : myAnswers) {
			if (((RuleAnswers) ruleAnswer).getRuleAnswersPK().getRuleno() == rule
					.getRulesPK().getId()
					&& ((RuleAnswers) ruleAnswer).getRuleAnswersPK()
							.getSeriesid() == mySeries) {
				myRuleAnswers.add((RuleAnswers) ruleAnswer);
			}
		}

		if (rule == null) {
			System.out.println("rule null");
		}

		if (rule.getRuletype() <= 2) {
			if (rule.isRemote()) {
				for (OptionAnswers a : ItemFrame
						.getApplicationRemoteBaseRules().getOptionAnswers(
								rule.getSupplierId(), rule.getRulevalue())) {
					if (a.getId().getOptionId() == rule.getRulevalue()) {
						myOptionAnswers.add(a);
					}
				}
			} else {
				for (OptionAnswers a : ItemFrame.getApplicationBaseRules()
						.getOptionAnswers(rule.getRulevalue())) {
					if (a.getId().getOptionId() == rule.getRulevalue()) {
						myOptionAnswers.add(a);
					}
				}
			}
		}

		/**
		 * If rule type allowed Answes clean OptionAnswers and rebuild it with
		 * only those Answers listed under RuleAnswers
		 */
		if (rule.getAllowedanswer()) {
			Object[] optAnswers = myOptionAnswers.toArray();
			myOptionAnswers.clear();

			for (Object ra : myRuleAnswers) {
				for (Object a : optAnswers) {
					if (((RuleAnswers) ra).getRuleAnswersPK().getAnswerid() == ((OptionAnswers) a)
							.getId().id
							&& ((OptionAnswers) a).getId().optionId == rule
									.getRulevalue()) {
						myOptionAnswers.add((OptionAnswers) a);
					}
				}
			}
		}

		/**
		 * Filter Test, Test Values and Perform Test If rule.test = true
		 */
		if (rule.getTest()) {

			for (Object test : myTests) {

				if (((RuleTest) test).getRuleTestPK().getRuleno() == rule
						.getRulesPK().getId()
						&& ((RuleTest) test).getRuleTestPK().getSeriesid() == mySeries) {

					// *********************************************************
					// Init Rule Test Values;
					// *********************************************************
					List<RuleTestValue> ruleTestValues;
					if (rule.isRemote()) {
						ruleTestValues = ItemFrame
								.getApplicationRemoteBaseRules()
								.getRuleTestValues(
										rule.getSupplierId(),
										rule.getRulesPK().getSeriesId(),
										rule.getRulesPK().getId(),
										((RuleTest) test).getRuleTestPK()
												.getTestid());
					} else {
						ruleTestValues = ItemFrame.getApplicationBaseRules()
								.getRuleTestValues(
										mySeries,
										rule.getRulesPK().getId(),
										((RuleTest) test).getRuleTestPK()
												.getTestid());
					}

					myRuleTests.add((RuleTest) test);
					myRuleTestValues.clear();

					for (Object testValue : ruleTestValues) {// TODO: Improve
																// testing
						if (((RuleTestValue) testValue).getRuleTestValuePK()
								.getRuleno() == rule.getRulesPK().getId()
								&& ((RuleTestValue) testValue)
										.getRuleTestValuePK().getTestid() == ((RuleTest) test)
										.getRuleTestPK().getTestid()
								&& ((RuleTestValue) testValue)
										.getRuleTestValuePK().getSeriesid() == mySeries) {
							myRuleTestValues.add((RuleTestValue) testValue);
						}
					}

					passTest = performTests((RuleTest) test,
							rule.getRcondition());

					TestResults testResult = new TestResults();
					testResult.testid = ((RuleTest) test).getRuleTestPK()
							.getTestid();
					testResult.pass = passTest;
					testResult.andor = ((RuleTest) test).getAndor();
					testResult.nexttest = ((RuleTest) test).getNext();

					testResult.startGroup = ((RuleTest) test).getStartGroup();

					testRes.add(testResult);

					ruleTestsResults.add(((RuleTest) test).getRuleTestPK()
							.getTestid());
					ruleTestsResults.add(passTest);
					ruleTestsResults.add(((RuleTest) test).getAndor());
					ruleTestsResults.add(((RuleTest) test).getNext());
				}
			}
		}

		Collections.sort(testRes);
		
		if (ruleTestsResults.size() / 4 > 1) {
			// passTest = analyseNextTests(ruleTestsResults);
			passTest = analyseNextTestsII(testRes, true);
		}

		return passTest;
	}

	public boolean analyseNextTestsII(List<TestResults> results, boolean doGroup) {

//		if(doGroup){
//			results = createNetResults(results);
//		}
		boolean pass = false;

		for (TestResults r : results) {

			if (r.evaluated) {
				continue;
			}

			r.evaluated = true;
			pass = r.pass;

			// Evaluate for And value - next test
			if (r.andor && r.pass) {

				if (r.nexttest > 0) {
					pass = analyseTestValue(r, results);
				} else {
					break;
				}

			} else if (r.andor && !r.pass) {
				for (TestResults result2 : results) {
					result2.evaluated = true;
				}
				break;
			} else if (!r.andor) {

				if (r.nexttest > 0 && !r.pass) {
					pass = analyseTestValue(r, results);

				} else if (r.pass) {
					break;
				}
			}
		}

		return pass;
	}

	public List<TestResults> createNetResults(List<TestResults> results) {

		boolean start = false;
		List<TestResults> netTests = new ArrayList<TestResults>();

		List<TestResults> group = new ArrayList<TestResults>();
		boolean stop = false;
		int myStartID = 0;
		int myNextID = 0;
		boolean myAndOr = true;
		List<Integer> used = new ArrayList<Integer>();
		for (TestResults r : results) {
			myStartID = 0;
			if (r.startGroup == 1  && !this.isInList(used, r.testid)) {
				group = new ArrayList<TestResults>();
				myStartID = r.testid;
				stop = false;
				group.add(r);
				used.add(r.testid);
				for (TestResults r2 : results) {
					
					if (r2.startGroup == 0 && r2.testid > r.testid) {
						group.add(r2);
						used.add(r2.testid);
					}
					if (r2.startGroup == 2 && r2.testid > r.testid) {
						group.add(r2);
						used.add(r2.testid);
						myNextID = r2.nexttest;
						myAndOr = r2.andor;
						stop = true;
						break;

					}
					
				}
				TestResults tr = new TestResults();
				tr.testid = myStartID;
				tr.andor = myAndOr;
				tr.nexttest = myNextID;
				
				tr.pass = this.analyseNextTestsII(group, false);

				netTests.add(tr);

			} else if (r.startGroup==0){
				if (myStartID > 0) {
					r.nexttest = myStartID;
				}
				netTests.add(r);
			}

		}

		return netTests;
	}
	
	private boolean isInList(List<Integer> myList, int id){
		boolean found = false;
		for(Integer i : myList){
			if(id == i){
				found = true;
				break;
			}
		}
		return found;
	}

	public boolean analyseTestValue(TestResults r, List<TestResults> results) {

		boolean pass = r.pass;

		for (TestResults result : results) {

			if (result.evaluated) {
				continue;
			}

			if (result.testid == r.nexttest) {

				result.evaluated = true;

				pass = result.pass;

				if (result.andor && result.pass) {

					if (result.nexttest > 0) {
						pass = analyseTestValue(result, results);
					} else {
						break;
					}

				} else if (result.andor && !result.pass) {
					for (TestResults result2 : results) {
						result2.evaluated = true;
					}
					break;
				}

				else if (!result.andor) {

					if (result.nexttest > 0 && !result.pass) {
						pass = analyseTestValue(result, results);

					} else if (result.pass) {
						break;
					}
				}
			}
		}

		return pass;
	}

	public List<TestResults> buildTestValueList(List<TestResults> results) {

		List<TestResults> nextResults = new ArrayList<TestResults>();
		for (TestResults r : results) {
			if (!r.evaluated) {
				nextResults.add(r);
			}
		}

		return nextResults;
	}

	public boolean analyseNextTests(ArrayList results) {

		int i = 0;

		int myRowSeq = (int) getRowForTestID(results, 0);

		if (myRowSeq >= 0) {

			boolean resThisId = ((Boolean) results.get(4 * myRowSeq + 1))
					.booleanValue();

			boolean myRes = ((Boolean) results.get(4 * myRowSeq + 1))
					.booleanValue();

			do {
				i++;
				if (getRowForTestID(results,
						((Integer) results.get(4 * myRowSeq)).intValue()) == -1) {
					i = results.size() / 5 + 1;
				} else {
					myRowSeq = (int) getRowForTestID(results,
							((Integer) results.get(4 * myRowSeq)).intValue());
					if (myRowSeq >= 0) {
						resThisId = ((Boolean) results.get(4 * myRowSeq + 1))
								.booleanValue();
						if (((Boolean) results.get(4 * myRowSeq + 2))
								.booleanValue()) {
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
			} while (i <= results.size() / 5);

			return myRes;
		} else {

			return false;
		}

		/**
		 * 
		 * for(test){ if(nexttest>0){ if(and && not pass || (not pass && next
		 * test ==0)){ Not Pass } else(not pass && OR){
		 * 
		 * do while??? next test >0
		 * 
		 * } }
		 * 
		 * 
		 */
	}

	public double getRowForTestID(ArrayList res, int myKey) {

		double row = -1D;
		for (int i = 0; i < res.size() / 4; i++) {
			if (((Integer) res.get(4 * i + 3)).intValue() == myKey) {
				row = i;

			}
		}
		return row;
	}

	public PricingGroup getPricingGroup(int groupid) {
		return ItemFrame.getApplicationBase().getPricingGroup(groupid);
	}

	public PricingGroup getRemotePricingGroup(int supplierId, int groupid) {
		return ItemFrame.getApplicationRemoteBaseRules().getPricingGroup(
				supplierId, groupid);
	}

	public double getRuleQuantityValue(Rules rule) {

		double quantity = 0;

		if (rule.getQuantitytype() == 1) {

			quantity = rule.getQtyvalue();

		} else if (rule.getQuantitytype() == 2) {

			// int matrixid =
			// ItemFrame.getApplicationBase().getMatrixHeader(rule.getQtyvalue()).getId();
			int matrixid = rule.getQtyvalue();

			MatrixController matrixController = new MatrixController(myShape,
					this.myFrame2);

			try {
				quantity = (matrixController.getValueFromMatrix(matrixid,
						rule.getSupplierId(), false, false, rule.isRemote()))
						.doubleValue();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (rule.getQuantitytype() == 3) { // From Option

			// Get answer of Qty Option specified in in Qty Option

			Object[] options = this.myFrame2.designOptionsAll.toArray();

			for (Object m : options) {
				if (rule.getRulevalue() == ((DesignOption) m).optionid) {
					quantity = ((DesignOption) m).qtyanswer;
					break;
				}

			}

		} else if (rule.getQuantitytype() == 4) { // from Expression

			// Get Qty from Expression

			String expression = "";

			if (myFrame2.currentUOM == 1) {
				expression = rule.qtyexpression;
			} else {
				expression = rule.qtyexpressioni;
			}

			setExpressionVariableValues();

			Calculable calc;
			try {
				if (expression.trim().length() > 0) {
					calc = new ExpressionBuilder(expression).withVariableNames(
							"L", "W", "H", "D", "C", "T1PL", "T2PL", "T3PL",
							"B1PL", "B2PL", "B3PL", "LPL", "RPL", "PERIMETER",
							"AREA", "CCONNECTOR", "TCONNECTOR", "LCONNECTOR",
							"SCONNECTOR", "HCONNECTOR", "SPCONNECTOR").build();

					calc.setVariable("L", l); // Length
					calc.setVariable("W", w); // Width
					calc.setVariable("H", h); // Height
					calc.setVariable("D", d); // Depth
					calc.setVariable("C", c); // Corners

					calc.setVariable("T1PL", t1pl); // top1part.length
					calc.setVariable("T2PL", t2pl); // top2part.length
					calc.setVariable("T3PL", t3pl); // top3part.length

					calc.setVariable("B1PL", b1pl); // bot1part.length
					calc.setVariable("B2PL", b2pl); // bot2part.length
					calc.setVariable("B3PL", b3pl); // bot3part.length

					calc.setVariable("LPL", lpl); // leftpart.length
					calc.setVariable("RPL", rpl); // rightpart.length

					calc.setVariable("PERIMETER", perimeter); // perimeter.length
					calc.setVariable("AREA", area); // area

					calc.setVariable("c", perimeter); // perimeter.length
					calc.setVariable("AREA", area); // area

					calc.setVariable("CCONNECTOR", cConn); // Grid Cross
															// Connector
					calc.setVariable("TCONNECTOR", tConn); // Grid T Connector
					calc.setVariable("LCONNECTOR", lConn); // Grid L Connector
					calc.setVariable("SCONNECTOR", sConn); // Grid S Connector
					calc.setVariable("HCONNECTOR", hConn); // Grid HUB Connector
					calc.setVariable("SPCONNECTOR", spConn); // Grid SPOKE
																// Connector

					quantity = calc.calculate();
				} else {
					quantity = 1;
				}

			} catch (UnknownFunctionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnparsableExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return quantity;
	}

	public void setExpressionVariableValues() {

		w = 0;
		h = 0;
		l = 0;
		t1pl = 0;
		t2pl = 0;
		t3pl = 0;
		b1pl = 0;
		b2pl = 0;
		b3pl = 0;
		lpl = 0;
		rpl = 0;
		perimeter = 0;

		d = 0;

		if (myShape != null) {

			c = myShape.noSides;

			if (myFrame2.currentUOM == 1) {

				d = setDepth / 100;
				if (d == 0) {
					d = myFrame2.mySeries.getFrameDepth();
				}

				w = myShape.widthM / 100;
				h = myShape.heightM / 100;

				if (myShape.top1Part.posInUse) {
					t1pl = myShape.top1Part.lengthM / 100;
				}

				if (myShape.top2Part.posInUse) {
					t2pl = myShape.top2Part.lengthM / 100;
				}

				if (myShape.top3Part.posInUse) {
					t3pl = myShape.top3Part.lengthM / 100;
				}

				if (myShape.bot1Part.posInUse) {
					b1pl = myShape.bot1Part.lengthM / 100;
				}
				if (myShape.bot2Part.posInUse) {
					b2pl = myShape.bot2Part.lengthM / 100;
				}
				if (myShape.bot3Part.posInUse) {
					b3pl = myShape.bot3Part.lengthM / 100;
				}
				if (myShape.leftPart.posInUse) {
					lpl = myShape.leftPart.lengthM / 100;
				}
				if (myShape.rightPart.posInUse) {
					rpl = myShape.rightPart.lengthM / 100;
				}

				perimeter = t1pl + t2pl + t3pl + b1pl + b2pl + b3pl + lpl + rpl;

				area = w / 1000 * h / 1000;
			}

			if (myMullionCoupler != null) {
				l = myMullionCoupler.lengthM / 100;
			}

			// DLO Grids Connectors values
			if (myShape instanceof DLO) {
				cConn = ((DLO) myShape).crossConnectors;
				tConn = ((DLO) myShape).tConnectors;
				lConn = ((DLO) myShape).lConnectors;
				sConn = ((DLO) myShape).spacerConnectors;
				hConn = ((DLO) myShape).hubConnector;
				spConn = ((DLO) myShape).spokeConnectors;
			}

		} else {

			d = setDepthI / 64;

			if (d == 0) {
				d = myFrame2.mySeries.getFrameDepthImp();
			}

			if (myShape != null) {

				w = myShape.widthI / 64;
				h = myShape.heightI / 64;

				if (myShape.top1Part.posInUse) {
					t1pl = myShape.top1Part.lengthI / 64;
				}

				if (myShape.top2Part.posInUse) {
					t2pl = myShape.top2Part.lengthI / 64;
				}

				if (myShape.top3Part.posInUse) {
					t3pl = myShape.top3Part.lengthI / 64;
				}

				if (myShape.bot1Part.posInUse) {
					b1pl = myShape.bot1Part.lengthI / 64;
				}
				if (myShape.bot2Part.posInUse) {
					b2pl = myShape.bot2Part.lengthI / 64;
				}
				if (myShape.bot3Part.posInUse) {
					b3pl = myShape.bot3Part.lengthI / 64;
				}
				if (myShape.leftPart.posInUse) {
					lpl = myShape.leftPart.lengthI / 64;
				}
				if (myShape.rightPart.posInUse) {
					rpl = myShape.rightPart.lengthI / 64;
				}

				perimeter = t1pl + t2pl + t3pl + b1pl + b2pl + b3pl + lpl + rpl;

				area = w / 12 * h / 12;
			}
			if (myMullionCoupler != null) {
				l = myMullionCoupler.lengthI / 64;
			}

		}
	}

	public int[] getAdjustValue(Rules rule) {

		int[] res = new int[4];

		int wAdjust = 0;

		int hAdjust = 0;

		int wAdjusti = 0;

		int hAdjusti = 0;

		Collection ops = new ArrayList();

		setExpressionVariableValues();

		if (myShape != null) {
			ops = myShape.options;
		} else if (myMullionCoupler != null) {
			ops = myMullionCoupler.options;
		} else if (myItem != null) {
			// ops = item.options;
		}

		/**
		 * 
		 * Width Adjustments
		 * 
		 */

		if (rule.getSizeadjustwtype() == 1) {

			wAdjust = rule.getSizeadjustw();
			wAdjusti = rule.getSizeadjustwi();

		} else if (rule.getSizeadjustwtype() == 2) {

			int matrixid = 0;

			if (myFrame2.currentUOM == 1) {
				matrixid = ItemFrame.getApplicationBaseRules()
						.getMatrixHeader(rule.getSizeadjustw()).getId();
			} else {
				matrixid = ItemFrame.getApplicationBaseRules()
						.getMatrixHeader(rule.getSizeadjustwi()).getId();
			}

			MatrixController matrixController = new MatrixController(myShape,
					this.myFrame2);

			try {
				if (matrixController.getMatrixMeasure(matrixid) == 1) {
					wAdjust = (int) (matrixController.getValueFromMatrix(
							matrixid, rule.getSupplierId(), false, false,
							rule.isRemote())).doubleValue() * 100;
					wAdjusti = (int) (Double.parseDouble(UOMConvertData
							.metricToSixtyFourth(wAdjust / 100 + ""))) * 64;
				} else {
					wAdjusti = (int) (matrixController.getValueFromMatrix(
							matrixid, rule.getSupplierId(), false, false,
							rule.isRemote())).doubleValue() * 64;
					wAdjust = (int) (Double.parseDouble(UOMConvertData
							.imperialTometric(wAdjusti / 64 + "")));
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (rule.getSizeadjustwtype() == 3) {// option

			Object[] options = this.myFrame2.designOptionsAll.toArray();

			for (Object m : options) {
				if (rule.getRulevalue() == ((DesignOption) m).optionid) {
					wAdjust = ((DesignOption) m).adjust;
					wAdjusti = ((DesignOption) m).adjusti;
					break;
				}
			}

		} else if (rule.getSizeadjustwtype() == 4) {

			// Parse Expression

			String expression = rule.adjwexpression;

			String expressioni = rule.adjwexpressioni;

			if (myFrame2.currentUOM == 1) {

				try {
					Calculable calc;

					calc = new ExpressionBuilder(expression).withVariableNames(
							"L", "W", "H", "D", "C", "T1PL", "T2PL", "T3PL",
							"B1PL", "B2PL", "B3PL", "LPL", "RPL", "PERIMETER",
							"AREA", "CCONNECTOR", "TCONNECTOR", "LCONNECTOR",
							"SCONNECTOR", "HCONNECTOR", "SPCONNECTOR").build();

					calc.setVariable("L", l); // Length
					calc.setVariable("W", w); // Width
					calc.setVariable("H", h); // Height
					calc.setVariable("D", d); // Depth
					calc.setVariable("C", c); // Corners

					calc.setVariable("T1PL", t1pl); // top1part.length
					calc.setVariable("T2PL", t2pl); // top2part.length
					calc.setVariable("T3PL", t3pl); // top3part.length

					calc.setVariable("B1PL", b1pl); // bot1part.length
					calc.setVariable("B2PL", b2pl); // bot2part.length
					calc.setVariable("B3PL", b3pl); // bot3part.length

					calc.setVariable("LPL", lpl); // bot2part.length
					calc.setVariable("RPL", rpl); // bot3part.length

					calc.setVariable("PERIMETER", lpl); // bot2part.length
					calc.setVariable("AREA", rpl); // bot3part.length

					calc.setVariable("CCONNECTOR", cConn); // Grid Cross
															// Connector
					calc.setVariable("TCONNECTOR", tConn); // Grid T Connector
					calc.setVariable("LCONNECTOR", lConn); // Grid L Connector
					calc.setVariable("SCONNECTOR", sConn); // Grid S Connector
					calc.setVariable("HCONNECTOR", hConn); // Grid HUB Connector
					calc.setVariable("SPCONNECTOR", cConn); // Grid SPOKE
															// Connector

					wAdjust = (int) (calc.calculate() * 100);

				} catch (UnknownFunctionException e) {
					e.printStackTrace();
				} catch (UnparsableExpressionException e) {
					e.printStackTrace();
				}

			} else {

				try {
					Calculable calc;

					calc = new ExpressionBuilder(expression).withVariableNames(
							"L", "W", "H", "D", "C", "T1PL", "T2PL", "T3PL",
							"B1PL", "B2PL", "B3PL", "LPL", "RPL", "PERIMETER",
							"AREA", "CCONNECTOR", "TCONNECTOR", "LCONNECTOR",
							"SCONNECTOR", "HCONNECTOR", "SPCONNECTOR").build();

					calc.setVariable("L", l); // Length
					calc.setVariable("W", w); // Width
					calc.setVariable("H", h); // Height
					calc.setVariable("D", d); // Depth
					calc.setVariable("C", c); // Corners

					calc.setVariable("T1PL", t1pl); // top1part.length
					calc.setVariable("T2PL", t2pl); // top2part.length
					calc.setVariable("T3PL", t3pl); // top3part.length

					calc.setVariable("B1PL", b1pl); // bot1part.length
					calc.setVariable("B2PL", b2pl); // bot2part.length
					calc.setVariable("B3PL", b3pl); // bot3part.length

					calc.setVariable("LPL", lpl); // bot2part.length
					calc.setVariable("RPL", rpl); // bot3part.length

					calc.setVariable("PERIMETER", lpl); // bot2part.length
					calc.setVariable("AREA", rpl); // bot3part.length

					calc.setVariable("CCONNECTOR", cConn); // Grid Cross
															// Connector
					calc.setVariable("TCONNECTOR", tConn); // Grid T Connector
					calc.setVariable("LCONNECTOR", lConn); // Grid L Connector
					calc.setVariable("SCONNECTOR", sConn); // Grid S Connector
					calc.setVariable("HCONNECTOR", hConn); // Grid HUB Connector
					calc.setVariable("SPCONNECTOR", cConn); // Grid SPOKE
															// Connector

					wAdjusti = (int) (calc.calculate() * 100);

				} catch (UnknownFunctionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnparsableExpressionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		/**
		 * 
		 * Height Adjustments
		 * 
		 */

		if (rule.getSizeadjusthtype() == 1) {

			hAdjust = rule.getSizeadjusth();
			hAdjusti = rule.getSizeadjusthi();

		} else if (rule.getSizeadjusthtype() == 2) {

			int matrixid = 0;

			if (myFrame2.currentUOM == 1) {
				matrixid = ItemFrame.getApplicationBaseRules()
						.getMatrixHeader(rule.getSizeadjusth()).getId();
			} else {
				matrixid = ItemFrame.getApplicationBaseRules()
						.getMatrixHeader(rule.getSizeadjusthi()).getId();
			}

			MatrixController matrixController = new MatrixController(myShape,
					this.myFrame2);

			try {
				if (matrixController.getMatrixMeasure(matrixid) == 1) {
					hAdjust = (int) (matrixController.getValueFromMatrix(
							matrixid, rule.getSupplierId(), false, false,
							rule.isRemote())).doubleValue();
					hAdjusti = (int) (Double.parseDouble(UOMConvertData
							.metricToSixtyFourth(hAdjust + "")));
				} else {
					hAdjusti = (int) (matrixController.getValueFromMatrix(
							matrixid, rule.getSupplierId(), false, false,
							rule.isRemote())).doubleValue();
					hAdjust = (int) (Double.parseDouble(UOMConvertData
							.imperialTometric(hAdjusti / 64 + "")));
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (rule.getSizeadjusthtype() == 3) {// option

			Object[] options = this.myFrame2.designOptionsAll.toArray();

			for (Object m : options) {
				if (rule.getRulevalue() == ((DesignOption) m).optionid) {
					hAdjust = ((DesignOption) m).adjust;
					hAdjusti = ((DesignOption) m).adjusti;
					break;
				}

			}

		} else if (rule.getSizeadjusthtype() == 4) {

			// Parse Expression

			String expression = "";
			String expressioni = "";

			expression = rule.adjhexpression;

			expressioni = rule.adjhexpressioni;

			if (myFrame2.currentUOM == 1) {

				try {
					Calculable calc;

					calc = new ExpressionBuilder(expression).withVariableNames(
							"L", "W", "H", "D", "C", "T1PL", "T2PL", "T3PL",
							"B1PL", "B2PL", "B3PL", "LPL", "RPL", "PERIMETER",
							"AREA").build();

					calc.setVariable("L", l); // Length
					calc.setVariable("W", w); // Width
					calc.setVariable("H", h); // Height
					calc.setVariable("D", d); // Depth
					calc.setVariable("C", c); // Corners

					calc.setVariable("T1PL", t1pl); // top1part.length
					calc.setVariable("T2PL", t2pl); // top2part.length
					calc.setVariable("T3PL", t3pl); // top3part.length

					calc.setVariable("B1PL", b1pl); // bot1part.length
					calc.setVariable("B2PL", b2pl); // bot2part.length
					calc.setVariable("B3PL", b3pl); // bot3part.length

					calc.setVariable("LPL", lpl); // bot2part.length
					calc.setVariable("RPL", rpl); // bot3part.length

					calc.setVariable("PERIMETER", lpl); // bot2part.length
					calc.setVariable("AREA", rpl); // bot3part.length

					hAdjust = (int) (calc.calculate() * 100);

				} catch (UnknownFunctionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnparsableExpressionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {

				try {
					Calculable calc;

					calc = new ExpressionBuilder(expression).withVariableNames(
							"L", "W", "H", "D", "C", "T1PL", "T2PL", "T3PL",
							"B1PL", "B2PL", "B3PL", "LPL", "RPL", "PERIMETER",
							"AREA").build();

					calc.setVariable("L", l); // Length
					calc.setVariable("W", w); // Width
					calc.setVariable("H", h); // Height
					calc.setVariable("D", d); // Depth
					calc.setVariable("C", c); // Corners

					calc.setVariable("T1PL", t1pl); // top1part.length
					calc.setVariable("T2PL", t2pl); // top2part.length
					calc.setVariable("T3PL", t3pl); // top3part.length

					calc.setVariable("B1PL", b1pl); // bot1part.length
					calc.setVariable("B2PL", b2pl); // bot2part.length
					calc.setVariable("B3PL", b3pl); // bot3part.length

					calc.setVariable("LPL", lpl); // bot2part.length
					calc.setVariable("RPL", rpl); // bot3part.length

					calc.setVariable("PERIMETER", lpl); // bot2part.length
					calc.setVariable("AREA", rpl); // bot3part.length

					hAdjusti = (int) (calc.calculate() * 100);

				} catch (UnknownFunctionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnparsableExpressionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		res[0] = wAdjust;
		res[1] = wAdjusti;
		res[2] = hAdjust;
		res[3] = hAdjusti;

		return res;
	}

	public double getLineDiscount(int pricecat) {

		double discount = 0.0d;

		List<PartnerLineDiscount> partnerDiscounts = ApplicationBaseApp
				.getInstance().getPartnerLineDiscounts();
		for (PartnerLineDiscount d : partnerDiscounts) {
			if (pricecat == d.getId().getPriceCategoryId()) {
				discount = d.getDiscount();
				break;
			}
		}

		return discount;
	}

	public double getRemoteLineDiscount(int supplierId, int pricecat) {

		double discount = 0.0d;

		List<PartnerLineDiscount> partnerDiscounts = ItemFrame
				.getApplicationRemoteBaseRules().getPartnerLineDiscounts(
						supplierId);
		for (PartnerLineDiscount d : partnerDiscounts) {
			if (pricecat == d.getId().getPriceCategoryId()) {
				discount = d.getDiscount();
				break;
			}
		}

		return discount;
	}

	public Object[] setCalcPrice(double size, double sizei, double costingsize,
			double costingsizei, PricingGroup priceGroup, double quantity,
			double discountP, double pricemarkup, double costmarkup,
			BigDecimal price, BigDecimal cost, BigDecimal minprice,
			int priceuom, int costuom, int pricemeasure, boolean discountable,
			ItemFrame itemFrame, int currentUOM, double waste,
			boolean incPrice, boolean incCost) {

		calPriceCost = new CalculatePriceCost();

		calPriceCost.qty = quantity;
		calPriceCost.sizem = size;
		calPriceCost.sizei = sizei;
		calPriceCost.costingsizem = costingsize;
		calPriceCost.costingsizei = costingsizei;
		calPriceCost.price = price;
		calPriceCost.cost = cost;
		calPriceCost.discountP = discountP;
		calPriceCost.myFrame2 = itemFrame;
		calPriceCost.pg = priceGroup;
		calPriceCost.pricemarkup = pricemarkup;
		calPriceCost.costmarkup = costmarkup;
		calPriceCost.priceuom = priceuom;
		calPriceCost.costuom = costuom;
		calPriceCost.myMeasure = currentUOM;
		calPriceCost.pricemeasure = pricemeasure;
		calPriceCost.discountable = discountable;
		calPriceCost.minprice = minprice;
		calPriceCost.waste = waste;
		calPriceCost.includePrice = incPrice;
		calPriceCost.includeCost = incCost;

		Object[] mo = calPriceCost.calcTotalPrice();

		return mo;
	}

	public boolean performTests(RuleTest test, int condition) {

		Collection myTests = new ArrayList();
		Collection myTestValues = new ArrayList();

		/**
		 * Continue with Test Evaluation
		 */

		boolean pass = false;

		boolean levelError = false;

		switch (test.type) {

		case 1: // Width
			if (myShape != null) {
				pass = myShape.widthTest(test, condition, myUOM,
						myRuleTestValues);
			} else if (myItem != null) {
				pass = myItem.widthTest(test, condition, myUOM,
						myRuleTestValues);
			}
			if (myShape == null && myItem == null) {
				levelError = true;
			}

			break;

		case 2: // Height

			if (myShape != null) {
				pass = myShape.heightTest(test, condition, myUOM,
						myRuleTestValues);
			} else if (myItem != null) {
				pass = myItem.heightTest(test, condition, myUOM,
						myRuleTestValues);
			}
			if (myShape == null && myItem == null) {
				levelError = true;
			}
			break;

		case 3: // Length

			if (myItem != null) {
				pass = myItem.lengthTest(test, condition, myUOM,
						myRuleTestValues);
			} else if (this.myMullionCoupler != null) {
				pass = myMullionCoupler.lengthTest(test, condition, myUOM,
						myRuleTestValues);
			}
			if (myItem == null && myMullionCoupler == null) {
				levelError = true;
			}
			break;

		case 4: // Area

			if (myShape != null) {
				pass = myShape.areaTest(test, condition, myUOM,
						myRuleTestValues);

			} else if (myItem != null) {
				pass = myItem
						.areaTest(test, condition, myUOM, myRuleTestValues);

			}
			if (myShape == null && myItem == null) {
				levelError = true;
			}

			break;

		case 5: // UI

			if (myShape != null) {
				pass = myShape.uiTest(test, condition, myUOM, myRuleTestValues);

			} else if (myItem != null) {
				pass = myItem.uiTest(test, condition, myUOM, myRuleTestValues);

			}
			if (myShape == null && myItem == null) {
				levelError = true;
			}
			break;

		case 6: // Volume

			if (myItem != null) {
				pass = myItem.volumeTest(test, condition, myUOM,
						myRuleTestValues);

			}
			if (myItem == null) {
				levelError = true;
			}
			break;

		case 7: // Depth

			if (myItem != null) {
				pass = myItem.depthTest(test, condition, myUOM,
						myRuleTestValues);

			}
			if (myItem == null) {
				levelError = true;
			}
			break;

		case 8: // Global Option

			OptionDefinitions myGOption = null;
			if (test.isRemote()) {
				myGOption = ItemFrame.getApplicationRemoteBaseRules()
						.getOptionDefinitions(test.getSupplierId(),
								test.value1.intValue());
			} else {
				myGOption = ItemFrame.getApplicationBaseRules()
						.getOptionDefinitions(test.value1.intValue());
			}

			if (this.myFrame2.jobItem.design != null) {
				pass = this.myFrame2.jobItem.design.optionTest(test, myUOM,
						myRuleTestValues, myGOption);
			}

			if (myFrame2.jobItem.design == null && myItem == null) {
				levelError = true;
			}

			break;

		case 9: // Option

			OptionDefinitions myOption = null;
			if (test.isRemote()) {
				myOption = ItemFrame.getApplicationRemoteBaseRules()
						.getOptionDefinitions(test.getSupplierId(),
								test.value1.intValue());
			} else {
				myOption = ItemFrame.getApplicationBaseRules()
						.getOptionDefinitions(test.value1.intValue());
			}

			if (myShape != null) {
				pass = myShape.optionTest(test, myUOM, myRuleTestValues,
						myOption);
			} else if (myMullionCoupler != null) {

				pass = myMullionCoupler.optionTest(test, myUOM,
						myRuleTestValues);

			} else if (myItem != null) {
				pass = myItem.optionTest(test, myUOM, myRuleTestValues,
						myOption);

			}
			if (myShape == null && myItem == null && myMullionCoupler == null) {
				levelError = true;
			}

			break;

		case 10: // User Defined Opening
			if (myShape != null) {
				pass = myShape.udOpeningTest(test, myRuleTestValues);
			}

			else if (this.myMullionCoupler != null) {
				pass = myMullionCoupler.udOpeningTest(test, myRuleTestValues);
			}

			else {
				levelError = true;
			}

			break;

		case 11: // opening Class
			if (myShape != null) {
				pass = myShape.openingClassTest(test, myRuleTestValues);
			}

			else if (this.myMullionCoupler != null) {
				pass = myMullionCoupler.opClassTest(test, myRuleTestValues);
			}

			else {
				levelError = true;
			}
			break;

		case 12: // Shape
			if (myShape != null) {
				pass = myShape.shapeTest(test, myRuleTestValues);
			}
			if (myShape == null) {
				levelError = true;
			}
			break;

		case 13: // Sash No. Sash Leaf

			pass = myShape.sashNoTest(test, myRuleTestValues);
			if (myShape == null) {
				levelError = true;
			}
			break;

		case 14: // Track No.
			if (myShape != null) {
				pass = myShape.trackNoTest(test, myRuleTestValues);
			}
			if (myShape == null) {
				levelError = true;
			}
			break;

		case 15: // SU Type (Glass)

			pass = myShape.suIDTest(test, myRuleTestValues);
			if (myShape == null) {
				levelError = true;
			}
			break;

		case 16: // Grid ID

			if (myShape != null) {
				pass = myShape.gridIDTest(test, myRuleTestValues);
			}

			if (myMullionCoupler != null) {
				pass = myMullionCoupler.gridIDTest(test, myRuleTestValues);
			}

			break;

		case 17: // Su Thickness
			if (myShape != null) {
				pass = myShape.suThicknessTest(test, myUOM, myRuleTestValues);
			}
			if (myShape == null) {
				levelError = true;
			}
			break;

		case 18: // Divider Type

			pass = myMullionCoupler.typeTest(test, myRuleTestValues);
			if (myMullionCoupler == null) {
				levelError = true;
			}
			break;

		case 19: // Coupler Type
			// myMullionCoupler

			pass = myMullionCoupler.typeTest(test, myRuleTestValues);
			if (myMullionCoupler == null) {
				levelError = true;
			}
			break;

		case 20: // Mullion Type
			if (myShape != null) {
				pass = myMullionCoupler.typeTest(test, myRuleTestValues);
			}
			if (myMullionCoupler == null) {
				levelError = true;
			}
			break;

		case 21: // Bay/Bow Angle (Coupler Angle)
			if (myShape != null) {
				pass = myMullionCoupler.angleTest(test, myRuleTestValues);
			}
			if (myMullionCoupler == null) {
				levelError = true;
			}
			break;

		case 22: // Left/Top Side (Opening)

			if (myMullionCoupler == null) {
				levelError = true;
			}

			break;

		case 23: // Right/Bottom side (Opening)

			if (myMullionCoupler == null) {
				levelError = true;
			}

			break;

		case 24: // Mullion/Divider/Coupler Class

			pass = myMullionCoupler.classTest(test, myRuleTestValues);

			if (myMullionCoupler == null) {
				levelError = true;
			}

			break;

		case 25: // predefined Design ID

			if (test.isrange) {
				pass = isWithinRange(test.value1, test.value2,
						myFrame2.jobItem.designID);

			} else {
				pass = isWithinValues(myFrame2.jobItem.designID);

			}

			if (test.isnot) {
				pass = !pass;
			}

			break;

		case 26: // Design Family - for std designs

			if (test.isrange) {
				pass = isWithinRange(test.value1, test.value2,
						myFrame2.jobItem.designFamily);

			} else {
				pass = isWithinValues(myFrame2.jobItem.designFamily);

			}

			if (test.isnot) {
				pass = !pass;
			}

			break;

		case 27: // Part Form

			pass = myMullionCoupler.formTest(test, myRuleTestValues);

			if (myMullionCoupler == null) {
				levelError = true;
			}

			break;

		case 28: // Grid Type

			if (myShape != null) {
				pass = myShape.gridTypeTest(test, myRuleTestValues);
			}

			if (myMullionCoupler != null) {
				pass = myMullionCoupler.gridTypeTest(test, myRuleTestValues);
			}

			break;

		case 29: // glass1

			pass = myShape.suGlass1Test(test, myRuleTestValues);
			if (myShape == null) {
				levelError = true;
			}
			break;

		case 30: // glass2

			pass = myShape.suGlass2Test(test, myRuleTestValues);
			if (myShape == null) {
				levelError = true;
			}
			break;

		case 31: // Glass 3
			pass = myShape.suGlass3Test(test, myRuleTestValues);
			if (myShape == null) {
				levelError = true;
			}
			break;

		case 32: // glass 4
			pass = myShape.suGlass4Test(test, myRuleTestValues);
			if (myShape == null) {
				levelError = true;
			}
			break;

		case 33: // Not Used

			break;

		case 34: // Not Used

			break;

		case 35: // Not Used

			break;

		case 36: // Not Used

			break;

		case 37: // Not Used

			break;

		case 38: // Not Used

			break;

		case 39: // Not Used

			break;

		case 40: // Parent Level 1

			if (myShape != null) {
				pass = myShape
						.parentLevelTest(test, myUOM, myRuleTestValues, 1);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 41: // Parent Level 2

			if (myShape != null) {
				pass = myShape
						.parentLevelTest(test, myUOM, myRuleTestValues, 2);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 42: // Parent Level 3

			if (myShape != null) {
				pass = myShape
						.parentLevelTest(test, myUOM, myRuleTestValues, 3);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 43: // Parent Level 4

			if (myShape != null) {
				pass = myShape
						.parentLevelTest(test, myUOM, myRuleTestValues, 4);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 44: // Parent Level 5

			if (myShape != null) {
				pass = myShape
						.parentLevelTest(test, myUOM, myRuleTestValues, 5);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 45: // Parent Level 6
			if (myShape != null) {
				pass = myShape
						.parentLevelTest(test, myUOM, myRuleTestValues, 6);
			}

			if (myShape == null) {
				levelError = true;
			}
			break;

		case 46: // Parent Level 7
			if (myShape != null) {
				pass = myShape
						.parentLevelTest(test, myUOM, myRuleTestValues, 7);
			}

			if (myShape == null) {
				levelError = true;
			}
			break;

		case 47: // Parent Level 8

			if (myShape != null) {
				pass = myShape
						.parentLevelTest(test, myUOM, myRuleTestValues, 8);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 48: // Parent Level 9

			if (myShape != null) {
				pass = myShape
						.parentLevelTest(test, myUOM, myRuleTestValues, 9);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 49: // Parent Level 10

			if (myShape != null) {
				pass = myShape.parentLevelTest(test, myUOM, myRuleTestValues,
						10);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 50: // Not Used

			break;

		case 51: // Sequence

			if (myShape != null) {
				pass = myShape.sequenceTest(test, myUOM, myRuleTestValues, 0);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 52: // Sequence 1

			if (myShape != null) {
				pass = myShape.sequenceTest(test, myUOM, myRuleTestValues, 1);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 53: // Sequence 2

			if (myShape != null) {
				pass = myShape.sequenceTest(test, myUOM, myRuleTestValues, 2);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 54: // Sequence 3

			if (myShape != null) {
				pass = myShape.sequenceTest(test, myUOM, myRuleTestValues, 3);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 55: // Sequence 4

			if (myShape != null) {
				pass = myShape.sequenceTest(test, myUOM, myRuleTestValues, 4);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 56: // Sequence 5

			if (myShape != null) {
				pass = myShape.sequenceTest(test, myUOM, myRuleTestValues, 5);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 57: // Sequence 6
			if (myShape != null) {
				pass = myShape.suFamilyTest(test, myRuleTestValues);
			}
			if (myShape == null) {
				levelError = true;
			}
			break;

		case 58: // Sequence 7

			if (myShape != null) {
				pass = myShape.sequenceTest(test, myUOM, myRuleTestValues, 7);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 59: // Sequence 8

			if (myShape != null) {
				pass = myShape.sequenceTest(test, myUOM, myRuleTestValues, 8);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 60: // Sequence 9

			if (myShape != null) {
				pass = myShape.sequenceTest(test, myUOM, myRuleTestValues, 9);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 61: // Sequence 10

			if (myShape != null) {
				pass = myShape.sequenceTest(test, myUOM, myRuleTestValues, 10);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 62: // No. Cols

			if (myShape != null) {
				pass = myShape.noColTest(test, myUOM, myRuleTestValues);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 63: // No. Rows

			if (myShape != null) {
				pass = myShape.noRowTest(test, myUOM, myRuleTestValues);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 64: // No. of Tracks

			if (myShape != null) {
				pass = myShape.noTrackTest(test, myUOM, myRuleTestValues);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 65: // No. of Sashes

			if (myShape != null) {
				pass = myShape.noSashesTest(test, myUOM, myRuleTestValues);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 66: // Not Used

			break;

		case 67: // Not Used

			break;

		case 68: // Not Used

			break;

		case 69: // Not Used

			break;

		case 70: // Not Used

			break;

		case 71: // Not Used

			break;

		case 72: // Radius 1

			if (myShape != null) {
				pass = myShape.radius1Test(test, myUOM, myRuleTestValues);
			} else if (this.myMullionCoupler != null) {
				pass = myMullionCoupler.radius1Test(test, myUOM,
						myRuleTestValues);
			} else if (myItem != null) {
				pass = myItem.radius1Test(test, myUOM, myRuleTestValues);
			}

			if (myShape == null && myMullionCoupler == null) {
				levelError = true;
			}

			break;

		case 73: // Radius 2

			if (myShape != null) {
				pass = myShape.radius2Test(test, myUOM, myRuleTestValues);
			} else if (this.myMullionCoupler != null) {
				pass = myMullionCoupler.radius2Test(test, myUOM,
						myRuleTestValues);
			} else if (myItem != null) {
				pass = myItem.radius2Test(test, myUOM, myRuleTestValues);
			}

			if (myShape == null && myMullionCoupler == null) {
				levelError = true;
			}

			break;

		case 74: // Not Used

			break;

		case 75: // RO Adj

			if (test.isrange) {
				pass = isWithinRange(test.value1, test.value2,
						myFrame2.jobItem.roID);
			} else {
				pass = isWithinValues(myFrame2.jobItem.roID);

			}

			if (test.isnot) {
				pass = !pass;
			}

			break;

		case 76: // Date
			/**
			 * CHECK FORMAT and Stored Format in TEST
			 */

			Date today = new Date(System.currentTimeMillis());

			if (test.isrange) {
				pass = isWithinRange(test.value1, test.value2, today.getTime());
			} else {
				pass = isWithinValues(today.getTime());
			}

			if (test.isnot) {
				pass = !pass;
			}

			break;

		case 77: // SU Air Space 1

			if (myShape != null) {
				pass = myShape.airSpaceTest(test, myUOM, myRuleTestValues, 1);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 78: // SU Air Space 2

			if (myShape != null) {
				pass = myShape.airSpaceTest(test, myUOM, myRuleTestValues, 1);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 79: // SU Air Space 3

			if (myShape != null) {
				pass = myShape.airSpaceTest(test, myUOM, myRuleTestValues, 1);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 80: // No. Horizontal (Grids)

			if (myShape != null) {
				pass = myShape.noGridHTest(test, myRuleTestValues);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 81: // No. Vertical (Grids)

			if (myShape != null) {
				pass = myShape.noGridVTest(test, myRuleTestValues);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 82: // No. Radii (Grids)

			if (myShape != null) {
				pass = myShape.noGridRTest(test, myRuleTestValues);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 83: // Spokes No. (Grids)

			if (myShape != null) {
				pass = myShape.noGridSTest(test, myRuleTestValues);
			}

			if (myShape == null) {
				levelError = true;
			}

			break;

		case 84: // Partner Group

			if (test.isrange) {
				pass = isWithinRange(test.value1, test.value2,
						myFrame2.myCustomer.getGroupId());

			} else {
				pass = isWithinValues(myFrame2.myCustomer.getGroupId());

			}

			if (test.isnot) {
				pass = !pass;
			}

			break;

		case 85: // OEM Company
			if (test.isRemote()) {

				if (test.isrange) {
					pass = isWithinRange(test.value1, test.value2,
							myFrame2.userPref.getCompanyID());
				} else {
					pass = isWithinValues(myFrame2.userPref.getCompanyID());
				}

			} else {

				if (test.isrange) {
					pass = isWithinRange(test.value1, test.value2,
							myFrame2.myCustomer.getId());
				} else {
					pass = isWithinValues(myFrame2.myCustomer.getId());
				}
			}

			if (test.isnot) {
				pass = !pass;
			}

			break;

		case 86: // Partner

			if (test.isRemote()) {

				if (test.isrange) {
					pass = isWithinRange(test.value1, test.value2,
							myFrame2.userPref.getCompanyID());
				} else {
					pass = isWithinValues(myFrame2.userPref.getCompanyID());
				}

			} else {

				if (test.isrange) {
					pass = isWithinRange(test.value1, test.value2,
							myFrame2.myCustomer.getId());
				} else {
					pass = isWithinValues(myFrame2.myCustomer.getId());
				}
			}

			if (test.isnot) {
				pass = !pass;
			}

			break;

		case 87: // User

			if (test.isrange) {
				pass = isWithinRange(test.value1, test.value2, myFrame2.userID);
			} else {
				pass = isWithinValues(myFrame2.userID);
			}

			if (test.isnot) {
				pass = !pass;
			}

			break;

		case 88: // Job Type
			if (test.isrange) {
				pass = isWithinRange(test.value1, test.value2, myFrame2.jobType);
			} else {
				pass = isWithinValues(myFrame2.jobType);
			}

			if (test.isnot) {
				pass = !pass;
			}

			break;

		case 89: // Job Type

			if (test.isrange) {
				pass = isWithinRange(test.value1, test.value2, myFrame2.jobType);
			} else {
				pass = isWithinValues(myFrame2.jobType);
			}

			if (test.isnot) {
				pass = !pass;
			}

			break;

		case 90: // Job Type

			if (test.isrange) {
				pass = isWithinRange(test.value1, test.value2, myFrame2.jobType);
			} else {
				pass = isWithinValues(myFrame2.jobType);
			}

			if (test.isnot) {
				pass = !pass;
			}

			break;

		case 91: // Job Type

			if (test.isrange) {
				pass = isWithinRange(test.value1, test.value2, myFrame2.jobType);
			} else {
				pass = isWithinValues(myFrame2.jobType);
			}

			if (test.isnot) {
				pass = !pass;
			}

			break;

		case 92: // Job Type

			if (test.isrange) {
				pass = isWithinRange(test.value1, test.value2, myFrame2.jobType);
			} else {
				pass = isWithinValues(myFrame2.jobType);
			}

			if (test.isnot) {
				pass = !pass;
			}

			break;

		case 93: // Job Type

			if (test.isrange) {
				pass = isWithinRange(test.value1, test.value2, myFrame2.jobType);
			} else {
				pass = isWithinValues(myFrame2.jobType);
			}

			if (test.isnot) {
				pass = !pass;
			}

			break;

		case 94: // Job Type

			if (test.isrange) {
				pass = isWithinRange(test.value1, test.value2, myFrame2.jobType);

			} else {
				pass = isWithinValues(myFrame2.jobType);
			}

			if (test.isnot) {
				pass = !pass;
			}

			break;

		case 95: // Is Opening Glazed
			if (myShape != null) {
				pass = ((OpeningObject) myShape).glazedTest();
			}

			if (myShape == null) {
				levelError = true;
			}
			break;

		case 96: // Not Used

			break;

		case 97: // Not Used

			break;

		case 98: // Not Used

			break;

		case 99: // Not Used

			break;

		case 100: // Sill Type

			break;

		case 101: // Slab Family

			break;

		case 102: // Insert Series

			break;

		case 103: // Insert Family

			break;

		case 104: // Slab ID

			break;

		case 105: // Insert ID

			break;

		}

		return pass;
	}

	public boolean volumeTest(RuleTest test) {

		boolean pass = false;
		double volume = 0;
		if (test.isrange) {

			if (myUOM == 1) {

				if (myAssemblyLevel == 906) {
					volume = (myProfileItem.getWidth() / 100 / 1000
							* myProfileItem.getHeight() / 100 / 1000
							* myProfileItem.getDepth() / 100 / 1000);
					pass = isWithinRange(test.value1, test.value2, volume);
				} else {
					JOptionPane.showMessageDialog(null,
							" Volume test Not valid for Object!",
							"Rule Test  - Error!", JOptionPane.ERROR_MESSAGE);
				}

			} else {
				if (myAssemblyLevel == 906) {
					volume = (myProfileItem.getWidthI() / 64 / 12
							* myProfileItem.getHeightI() / 64 / 12
							* myProfileItem.getDepthI() / 64 / 12);
					pass = isWithinRange(test.value1i, test.value2i, volume);
				} else {
					JOptionPane.showMessageDialog(null,
							" Volume test Not valid for Object!",
							"Rule Test  - Error!", JOptionPane.ERROR_MESSAGE);
				}
			}

		} else {

			if (myUOM == 1) {

				if (myAssemblyLevel == 906) {
					volume = (myProfileItem.getWidth() / 100 / 1000
							* myProfileItem.getHeight() / 100 / 1000
							* myProfileItem.getDepth() / 100 / 1000);
					pass = isWithinValues(volume);
				} else {
					JOptionPane.showMessageDialog(null,
							" Volume test Not valid for Object!",
							"Rule Test  - Error!", JOptionPane.ERROR_MESSAGE);
				}

			} else {
				if (myAssemblyLevel == 906) {
					volume = (myProfileItem.getWidthI() / 64 / 12
							* myProfileItem.getHeightI() / 64 / 12
							* myProfileItem.getDepthI() / 64 / 12);
					pass = isWithinValues(volume);
				} else {
					JOptionPane.showMessageDialog(null,
							" Volume test Not valid for Object!",
							"Rule Test  - Error!", JOptionPane.ERROR_MESSAGE);
				}
			}

		}

		/**
		 * 1,0,Overall,1 2,1,Facet,1 3,3,Frame,1 4,121,Sash Type,1 5,12,Sash,1
		 * 6,21,Glass/Glazing,1 7,0,Glazing Bead,1 8,22,DLO,1 20,5,Bkgrd
		 * Opening,1 30,0,Divider,1 31,2,Coupler,1 32,4,Mullion,1 32,0,Grids,1
		 * 40,5,Opening,1 200,1,Sub-Facet,1 400,121,Sub-Sash,1 902,0,Object,2
		 * 903,0,Object,3 904,0,Object,4 905,0,Object,5 906,0,Object,6
		 * 907,0,Object,7
		 */

		if (test.isnot) {
			pass = !pass;
		}

		return pass;
	}

	public boolean depthTest(RuleTest test) {

		boolean pass = false;
		double volume = 0;
		if (test.isrange) {

			if (myUOM == 1) {

				if (myItem.getTypeId() == 906) {

					pass = isWithinRange(test.value1, test.value2,
							myProfileItem.getDepth());
				} else {
					JOptionPane.showMessageDialog(null,
							" Volume test Not valid for Object!",
							"Rule Test  - Error!", JOptionPane.ERROR_MESSAGE);
				}

			} else {
				if (myAssemblyLevel == 906) {
					pass = isWithinRange(test.value1i, test.value2i,
							myProfileItem.getDepthI());
				} else {
					JOptionPane.showMessageDialog(null,
							" Volume test Not valid for Object!",
							"Rule Test  - Error!", JOptionPane.ERROR_MESSAGE);
				}
			}

		} else {

			if (myUOM == 1) {

				if (myAssemblyLevel == 906) {
					pass = isWithinValues(myProfileItem.getDepth());
				} else {
					JOptionPane.showMessageDialog(null,
							" Volume test Not valid for Object!",
							"Rule Test  - Error!", JOptionPane.ERROR_MESSAGE);
				}

			} else {
				if (myAssemblyLevel == 906) {
					pass = isWithinValues(myProfileItem.getDepthI());
				} else {
					JOptionPane.showMessageDialog(null,
							" Volume test Not valid for Object!",
							"Rule Test  - Error!", JOptionPane.ERROR_MESSAGE);
				}
			}

		}

		/**
		 * 1,0,Overall,1 2,1,Facet,1 3,3,Frame,1 4,121,Sash Type,1 5,12,Sash,1
		 * 6,21,Glass/Glazing,1 7,0,Glazing Bead,1 8,22,DLO,1 20,5,Bkgrd
		 * Opening,1 30,0,Divider,1 31,2,Coupler,1 32,4,Mullion,1 32,0,Grids,1
		 * 40,5,Opening,1 200,1,Sub-Facet,1 400,121,Sub-Sash,1 902,0,Object,2
		 * 903,0,Object,3 904,0,Object,4 905,0,Object,5 906,0,Object,6
		 * 907,0,Object,7
		 */

		if (test.isnot) {
			pass = !pass;
		}

		return pass;
	}

	public boolean isWithinRange(int value1, int value2, int value) {
		return value >= value1 && value <= value2;
	}

	public boolean isWithinRange(double value1, double value2, double value) {
		return value >= value1 && value <= value2;
	}

	public boolean isWithinRange(long value1, long value2, long value) {
		return value >= value1 && value <= value2;
	}

	public boolean isWithinValues(int value) {

		boolean pass = false;
		if (myUOM == 1) {
			for (Object tv : myRuleTestValues) {
				if (((RuleTestValue) tv).getRuleTestValuePK().getValue() == value) {
					pass = true;
					break;
				}
			}

		} else {
			for (Object tv : myRuleTestValues) {
				if (((RuleTestValue) tv).getRuleTestValuePK().getValuei() == value) {
					pass = true;
					break;
				}
			}
		}
		return pass;
	}

	public boolean isWithinValues(double value) {

		boolean pass = false;
		if (myUOM == 1) {
			for (Object tv : myRuleTestValues) {
				if (((RuleTestValue) tv).getRuleTestValuePK().getValue() == value) {
					pass = true;
					break;
				}
			}

		} else {
			for (Object tv : myRuleTestValues) {
				if (((RuleTestValue) tv).getRuleTestValuePK().getValuei() == value) {
					pass = true;
					break;
				}
			}
		}
		return pass;
	}

	public boolean isWithinValues(long value) {

		boolean pass = false;
		if (myUOM == 1) {
			for (Object tv : myRuleTestValues) {
				if (((RuleTestValue) tv).getRuleTestValuePK().getValue() == value) {
					pass = true;
					break;
				}
			}

		} else {
			for (Object tv : myRuleTestValues) {
				if (((RuleTestValue) tv).getRuleTestValuePK().getValuei() == value) {
					pass = true;
					break;
				}
			}
		}
		return pass;
	}

	public class TestResults implements Comparable<TestResults> {

		public int testid = 0;

		public boolean pass = false;

		public boolean andor = false;

		public int startGroup = 0;

		public int nexttest = 0;

		public boolean evaluated = false;

		public TestResults() {

		}

		@Override
		public int compareTo(TestResults o) {

			if (this.testid <= 0) {
				return -1;
			}

			if (o == null || o.testid <= 0) {
				return -1;
			}

			Integer testId_one = new Integer(this.testid);
			Integer testId_two = new Integer(o.testid);

			return testId_one.compareTo(testId_two);
		}

	}

}
