/*******************************************************************************
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/

package Presentation;

import Model.*;
import Model.Frame;
import Model.ProfileParts.Profiles;
import Model.TextObjects.*;
import Operations.*;
import Rules.ExecutePartRules;
import openjanela.commons.util.ResourcesUtil;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.eao.partner.partnerEAO.PartnerEAO;
import openjanela.model.eao.partner.partnerEAO.PartnerPersistenceEAO;
import openjanela.model.eao.partner.seriesEAO.SeriesEAO;
import openjanela.model.eao.partner.seriesEAO.SeriesPersistenceEAO;
import openjanela.model.entities.admin.PriceChangeReason;
import openjanela.model.entities.admin.TypePriceCategory;
import openjanela.model.entities.admin.UserAdmin;
import openjanela.model.entities.orderEntry.PricingGroup;
import openjanela.model.entities.partner.*;
import openjanela.model.entities.parts.PartsFamily;
import openjanela.model.entities.sales.SalesRepsCommission;
import orderEntryUtility.DesignOptionSorter;
import orderEntryUtility.OEUtility;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXTextField;
import org.jdesktop.swingx.JXTitledSeparator;
import org.jdesktop.swingx.VerticalLayout;
import org.openjanela.commons.util.controller.CursorController;
import org.openjanela.commons.util.ui.JPanelAsynchronous;
import org.openjanela.component.JOpenJanelaComponent;
import org.openjanela.component.JXTaskPaneOJ;
import org.openjanela.data.*;

import util.ProjectDetails;
import util.UOMConvert;
import util.XYConstraints;
import util.XYLayout;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;

/**
 * ItemFrame Application Configuration for OpenJanela
 */
public class ItemFrame extends JDialog implements JOpenJanelaComponent {

    // Apache log4j
    private static final Logger logger = Logger.getLogger(ItemFrame.class);

    boolean showDims = true;

    // Application Base data execution
    private static ApplicationBaseApp applicationBase;

    private static ApplicationBaseRulesApp applicationBaseRules;

    // This object representes user preferences for implementation
    public UserPreferences userPref;

    public ShapeObject facetUsed = null;

    public boolean isNewItem = true;

    public boolean modifyDims = false;

    public boolean hasGrids = false;

    public boolean calcBom = true;

    public boolean saveModel = false;

    public Toolkit toolkit = Toolkit.getDefaultToolkit();

    public static Cursor myCursor;

    public int currentUOM = 0;

    public int prevUOM = 0;

    public double UOMRound = 0;

    public List undoArray = new LinkedList();

    public ShapeSelectorPanel shapesPanel;

    public SashSelectorPanel sashPanel;

    public GlassSelectorPanel glassPanel;

    public JTabbedPane myTabs = new JTabbedPane();

    public JPanel defaultPanel = null;

    public JPanel mainFramePanel = new JPanel();

    public JPanel layoutPanel = new JPanel();

    public JPanel partsPanel = new JPanel();

    public JPanel panelGlass = new JPanel();

    public JPanel costPanel = new JPanel();

    public JPanel notesPanel = new JPanel();

    public JPanel errorsPanel = new JPanel();

    public JPanel warningsPanel = new JPanel();

    public JPanel infoPanel = new JPanel();

    JScrollPane errorScroll = new JScrollPane();

    JScrollPane warningScroll = new JScrollPane();

    JList errorList = new JList(new DefaultListModel());

    JList warningList = new JList(new DefaultListModel());

    JScrollPane infoScroll = new JScrollPane();

    public JTable infoTable = new JTable();

    public JPanel main;

    public JPanel mainDraw;

    public JPanel mainMenu = new JPanel();

    public JPanel rightAdverts = new JPanel();

    public JPanel buttonsPanel = new JPanel();

    public JPanel topPanel = new JPanel();

    public JPanel bottomPanel = new JPanel();

    public JPanel bottomFunctions = new JPanel();

    public JPanel bottomButtons = new JPanel();

    public JPanel bottomAdverts = new JPanel();

    public JPanel bottomMenu = new JPanel();

    public JPanel rightLabelsPanel = new JPanel();

    public JPanel drawCanvas = new JPanel();

    public TopPanel myTopPanel;

    public GridPanel gridsPanel;

    public EditorPanel editor;

    public DimsPanel dim;

    public CouplerAndMullionPanel mullionsPanel;

    public SupplierSelectorPanel supplierPanel;

    public JXCollapsiblePane collapsemenu;

    public JXTaskPaneOJ designTask;

    public JXTaskPaneOJ supplierTask;

    public JXTaskPaneOJ editTask;

    public JXTaskPaneOJ optionsTask;

    public JXTaskPaneOJ viewTask;

    public JXTaskPaneOJ dimTask;

    public JXTaskPaneOJ costPriceTask;

    public JXTaskPaneOJ errorWarningTask;

    public JXTaskPaneOJ infoTask;

    // public Collection myUser;
    public Object lastWorkspace = null;

    public static String driverClass = null;

    public static String dbServerInitURL = null;

    public static String dbServerHost;

    public static String dbServerPort;

    public static String serverlogin;

    public static String serverpass;

    public static String completeURL = null;

    public static String mainDB = "ik_main";

    public static String inventoryDB = "ik_inventory";

    public JobItemModel jobItem;

    public JButton btnSave = new JButton();

    public JButton btnCancel = new JButton();

    public Collection gpObjects = new ArrayList();

    public Collection topTexts = new ArrayList();

    public Collection botTexts = new ArrayList();

    public Collection leftTexts = new ArrayList();

    public Collection rightTexts = new ArrayList();

    public TextFieldTop textTop = new TextFieldTop();

    public TextFieldBot textBot = new TextFieldBot();

    public TextFieldLeft textLeft = new TextFieldLeft();

    public int[] topTextsMod;

    public int[] leftTextsMod;

    public int[] topTextsModo;

    public int[] leftTextsModo;

    public int[] fbotTextsMod;

    public int lastSelectedCol = 0;

    public int lastSelectedColBot = 0;

    public int lastSelectedRowLeft = 0;

    public int modSeqUndo = 0;

    public int modSeqUndoBot = 0;

    public int modSeqUndoLeft = 0;

    public Collection couplerTexts = new ArrayList();

    public Collection fcolTexts = new ArrayList();

    public CouplerText couplerText;

    public FacetBotText fcolText;

    public FacetRightText frowText;

    public Collection colTextObjects = new ArrayList();

    public Collection colTextObjectsc = new ArrayList();

    public Collection colTextPosXs = new ArrayList();

    public Collection colTextPosXe = new ArrayList();

    public Collection colTextPosXsc = new ArrayList();

    public Collection colTextPosXec = new ArrayList();

    public Collection fcolTextObjects = new ArrayList();

    public Collection fcolTextObjectsc = new ArrayList();

    public Collection fcolTextPosXs = new ArrayList();

    public Collection fcolTextPosXe = new ArrayList();

    public Collection fcolTextPosXsc = new ArrayList();

    public Collection fcolTextPosXec = new ArrayList();

    public Collection frowTextObjects = new ArrayList();

    public Collection frowTextObjectsc = new ArrayList();

    public Collection frowTextPosXs = new ArrayList();

    public Collection frowTextPosXe = new ArrayList();

    public Collection frowTextPosXsc = new ArrayList();

    public Collection frowTextPosXec = new ArrayList();

    public Collection colTextObjectsO = new ArrayList();

    public Collection colTextPosXsO = new ArrayList();

    public Collection colTextPosXeO = new ArrayList();

    public Collection colTextObjectscO = new ArrayList();

    public Collection colTextPosXscO = new ArrayList();

    public Collection colTextPosXecO = new ArrayList();

    public Collection rowTextObjects = new ArrayList();

    public Collection rowTextPosYs = new ArrayList();

    public Collection rowTextPosYe = new ArrayList();

    public Collection rowTextObjectsc = new ArrayList();

    public Collection rowTextPosYsc = new ArrayList();

    public Collection rowTextPosYec = new ArrayList();

    public Collection rowTextObjectsO = new ArrayList();

    public Collection rowTextPosYsO = new ArrayList();

    public Collection rowTextPosYeO = new ArrayList();

    public Collection rowTextObjectscO = new ArrayList();

    public Collection rowTextPosYscO = new ArrayList();

    public Collection rowTextPosYecO = new ArrayList();

    public Collection gpFillShapes = new ArrayList();

    public Collection gpColors = new ArrayList();

    public Collection ellipses = new ArrayList();

    public double deduct = 0;

    public double scaleSizeMax = 0;

    public double scaleSizeMin = 0;

    public BigDecimal scale = new BigDecimal(0);

    public BigDecimal imperialscale = new BigDecimal(0);

    public BigDecimal metricscale = new BigDecimal(0);

    public int baseUOM = 1;

    public int selectedRadioForCol = 1;

    public LayoutPanel layoutP;

    public int selectedRadioForRow = 1;

    public int lastRR = 1;

    public int lastRC = 1;

    public int lastRRo = 1;

    public int lastRCo = 1;

    public int lastFB = 1;

    public int selectedPos = 2;

    public int selectedRadioForColo = 1;

    public ShapeObject mySelectedSash;

    public ShapeObject mySelectedSashLeaf;

    public int selectedRadioForRowo = 1;

    public static Map<String, ImageIcon> iconFiles = new HashMap<String, ImageIcon>();

    public JFrame myParent;

    public int lastSelectedDim = 0;

    public ShapeObject mySelectedFrame = null;

    public int alignSeq = 0;

    // Semaphore to align Vertical option is active
    public boolean alignV = false;

    // Semaphore to align Horizontal option is active
    public boolean alignH = false;

    public Object myMaster;

    public Object mySlave;

    public int myMasterType; // 1=coupler 2 = mullion // 3 = intelock L //
    // 4=interlock R 5== meetRail // 6=astragal
    // //7=grid

    public int mySlaveType;

    public boolean masterAboveLeft = false;

    // Semaphore to edit coupler or mullions actions
    public boolean editCM = false;

    // Semaphore to extend coupler or mullions actions
    public boolean extendCM = false;

    public Profiles editingMullion;

    public Profiles editingCoupler;

    public boolean hasMullion = false;

    public boolean hasSMullion = false;

    public boolean hasCoupler = false;

    public int HorV = 0;

    public int orientation = 0;

    public boolean alignPerformed = false;

    public boolean alignHPerformed = false;

    public boolean extendPerformed = false;

    public int endLT = 0;

    public int endRB = 0;

    public int partID = 0;

    public double partThick = 0;

    public double partDimB = 0;

    public double partDimC = 0;

    public double partDimA = 0;

    public double partDimM = 0;

    public double partDimD = 0;

    public double partDimBtoC = 0;

    public ShapeObject selectedFrame = null;

    public ShapeObject selectedGlassSU = null;

    public Profiles selectedPart = null;

    public boolean resetParts = true;

    public SashTypeObject sashType;

    public int mySlaveFrame = 0;

    public OpeningObject lastChangedOpening;

    public int lastChangedLeaf = -1;

    public boolean openingChanged = true;

    public int gridOp = 0;

    public ShapeObject slave = null;

    public int selectedDim = 0;

    public DecimalFormat noDecimal = new DecimalFormat("0");

    public DecimalFormat oneDecimal = new DecimalFormat("0.0");

    public DecimalFormat twoDecimal = new DecimalFormat("0.00");

    public DecimalFormat sixDecimal = new DecimalFormat("0.000000");

    public double impRound = 1;

    public double metricRound = 1;

    public boolean roundW = false;

    public boolean roundH = false;

    public boolean foundPotential = false;

    public int alignClicks = 0;

    public boolean subFClicked = false;

    public boolean resetModTextsV = false;

    public boolean resetModTextsH = false;

    public boolean hasSubF = false;

    public double topDeltas = 0;

    public double leftDeltas = 0;

    public Series mySeries = new Series();

    public int supplierID = 0;

    public int dealerID = 0;

    public boolean isStd = false;

    public ImageIcon nextIcon = new ImageIcon();

    public ImageIcon balanceIcon = new ImageIcon();

    public ImageIcon balanceIconH = new ImageIcon();

    public ImageIcon myCursorImage = new ImageIcon();

    public ImageIcon undoImage = new ImageIcon();

    public ImageIcon infoImage = new ImageIcon();

    public ImageIcon error16Image = new ImageIcon();

    public ImageIcon warning16Image = new ImageIcon();

    public ImageIcon shABImage = new ImageIcon();

    public ImageIcon setImage = new ImageIcon();

    public ImageIcon supplierImage = new ImageIcon();

    public ImageIcon seriesImage = new ImageIcon();

    public ImageIcon saveImage = new ImageIcon();

    public ImageIcon abcDH = new ImageIcon();
    public ImageIcon abcSH = new ImageIcon();
    public ImageIcon abcSSL = new ImageIcon();
    public ImageIcon abcSSR = new ImageIcon();
    public ImageIcon abc2LP = new ImageIcon();
    public ImageIcon abc3LS = new ImageIcon();
    public ImageIcon abc4LS = new ImageIcon();
    public ImageIcon abcCLS = new ImageIcon();
    public ImageIcon abcDLS = new ImageIcon();

    public ImageIcon cancelImage = new ImageIcon();

    public ImageIcon changeImage = new ImageIcon();

    public ImageIcon addImage = new ImageIcon();

    public ImageIcon designFunctionImage = new ImageIcon();

    public ImageIcon optionsImage = new ImageIcon();

    public ImageIcon gridsImage = new ImageIcon();

    public ImageIcon glassImage = new ImageIcon();

    public ImageIcon couplermullionImage = new ImageIcon();

    public ImageIcon shapesImage = new ImageIcon();

    public ImageIcon subFrameImage = new ImageIcon();

    public ImageIcon sashImage = new ImageIcon();

    public ImageIcon subsashImage = new ImageIcon();

    public ImageIcon overallShapeImage = new ImageIcon();

    public ImageIcon frameShapeImage = new ImageIcon();

    public ImageIcon overallSShapeImage = new ImageIcon();

    public ImageIcon frameSShapeImage = new ImageIcon();

    public ImageIcon openingsImage = new ImageIcon();

    public ImageIcon editProfilesImage = new ImageIcon();

    public ImageIcon profileshapeImage = new ImageIcon();

    public ImageIcon elevationImage = new ImageIcon();

    public ImageIcon costImage = new ImageIcon();

    public ImageIcon priceImage = new ImageIcon();

    public ImageIcon noteImage = new ImageIcon();

    public ImageIcon addonsImage = new ImageIcon();

    public ImageIcon tipImage = new ImageIcon();

    public ImageIcon errorImage = new ImageIcon();

    public String errorTip = "Errors & Warnings";

    public Collection errors = new ArrayList();

    public Dimension myDim = new Dimension();

    public int posCond = 0;

    public boolean changeFacetW = false;

    public boolean changeFacetH = false;

    public boolean wEntered = false;

    public boolean hEntered = false;

    public JCheckBox mainColCheck[];

    public JCheckBox mainFacetCheckBot[];

    public JCheckBox mainRowCheck[];

    public boolean drawGuide = true;

    public ButtonGroup radioForCol;

    public ButtonGroup radioForFacetBot;

    public ButtonGroup radioForRows;

    public ButtonGroup radioForColOpening;

    public ButtonGroup radioForRowOpening;

    public ButtonGroup radioForColSashOp;

    public ButtonGroup radioForRowSashOp;

    public JRadioButton radioColOpening[];

    public JRadioButton radioRowOpening[];

    public JRadioButton radioColSashOp[];

    public JRadioButton radioRowSashOp[];

    public Object[] textFieldsTop;

    public Object[] textFieldsCoupler;

    public Object[] textFieldsFBot;

    public Object[] textFieldsFRight;

    public Object[] textFieldsLeft;

    public Object[] textFieldsRight;

    public JXTextField myTextRow[];

    public JXTextField myTextFacetBot[];

    public JXTextField myTextBot[];

    public JXTextField myTextCoupler[];

    public JXTextField myTextLeft[];

    public JXTextField myTextRight[];

    public int[] rcPosx;

    public int[] rrPosy;

    public int[] rcPosxo;

    public int[] rrPosyo;

    public int[] frcPosx;

    public boolean isUndo = false;

    public OptionSelectorPanel options;

    public Collection<DesignOption> designOptionsNet = new ArrayList();

    public Collection<DesignOption> designOptionsAll = new ArrayList();

    public List<OptionDefinitions> mandatoryOptions = new ArrayList();

    public Partner myCustomer = new Partner();

    public Partner mySupplier = new Partner();

    public ExecutePartRules executePartRules;

    public Locale locale;

    public String myCurrency = new String();

    public String country = "";

    public String language = "";

    public NumberFormat currencyFormatter;

    public NumberFormat percentFormatter;

    public static DecimalFormat myDecimal;

    public String myCS = "";

    public UserAdmin userAdmin = new UserAdmin();

    public List partnerDefaults = new ArrayList();

    public List cartDefaults = new ArrayList();

    public boolean roundTotal;

    public boolean roundPrice;

    public boolean roundDiscountedPrice;

    public boolean viewPrice;

    public boolean viewCost;

    public boolean changeBasePrice;

    public boolean changeBOMPrice;

    public boolean changeDiscount;

    public boolean changeGlassPrice;

    public boolean changeOptionPrice;

    public boolean openingSize;

    public int defaultentryUOM;

    public int jobType;

    public String Country;

    public boolean isNew = false;

    public boolean isSupplier = false;

    public static int userID = 0;

    public static int partnerID = 0;

    public static int partnerGroupID = 0;

    public static int orderCartID = 0;

    public static int companyID = 0;

    public static int jobID = 0;

    public static int itemID = 0;

    public static int versionID = 0;

    public static int seriesID = 0;

    public static int designID = 0;

    public static int salesRepID = 0;

    public static int designFamilyID = 0;

    public static int itemType = 0;

    public static int standardRoID = 0;

    public SalesRepsCommission salesCommission = new SalesRepsCommission();

    public SUType currentSUIn = null;

    public SUType currentSUMid = null;

    public SUType currentSUOut = null;

    public List<JobItemCostPrice> priceGroups = new ArrayList();

    public List<JobItemCostPrice> partFamilies = new ArrayList();

    public List<JobItemCostPrice> priceCategories = new ArrayList();

    JScrollPane notesScroll = new JScrollPane();

    public JTextArea textArea = new JTextArea();

    public String attributes = "";

    public FinancialSummay cView;

    public SUType mySelectedSUIn = new SUType();

    public SUType mySelectedSUMid = new SUType();

    public SUType mySelectedSUOut = new SUType();

    public SUType mySelectedSU = new SUType();

    public boolean manualCostEntered = false;
    public boolean manualPriceEntered = false;

    // Entity Access Object
    private final PartnerEAO partnerEAO;

    private final SeriesEAO seriesEAO;

    public CostPricePanel costPricePanel;

    // ****************************************************************
    // Design action buttons
    // ****************************************************************
    private JButton btnOptionSelect;

    private JButton btnMullionSelect;

    private JButton btnShapesSelect;

    private JButton btnSashSelect;

    private JButton btnGlassSelect;

    public JButton btnGridsSelect;

    private JButton btnEditProfilesSelect;

    /**
     * Represent the event selection for perform operations
     */
    int actionType = MenuActionEventDraw.NOT_SELECTION.getValue();

    public SetShapeObjectColors shapeColor = new SetShapeObjectColors();

    public Collection<ForcedOptionAnswer> alreadyAnsweredOptions = new ArrayList<ForcedOptionAnswer>();

    public Collection<ErrorsAndWarnings> errorMessages = new ArrayList<ErrorsAndWarnings>();

    public Collection<ErrorsAndWarnings> warningMessages = new ArrayList<ErrorsAndWarnings>();

    public Vector infoMessages = new Vector();

    java.awt.Color errorColor = new Color(255, 0, 0, 16);

    java.awt.Color warningColor = new Color(255, 255, 0, 16);

    JXTitledSeparator errorSep = new JXTitledSeparator("Errors");

    JXTitledSeparator warningSep = new JXTitledSeparator("Warnings");

    public Cursor cursor;

    public BomView bomView;

    public boolean initDesign = false;

    public boolean frameDim = false;

    public boolean costManual = false;
    public boolean priceManual = false;
    public boolean discountManual = false;

    public JDialog finalSave = new JDialog();

    JLabel qtyL = new JLabel("Quantity:");
    JLabel refL = new JLabel("Reference:");
    JLabel locL = new JLabel("Location:");

    JTextField qtyT = new JTextField();
    JTextField refT = new JTextField();
    JTextField locT = new JTextField();

    public double lastTextValue = 0;

    public JComboBox reasonCmb = new JComboBox();

    public BigDecimal netPrice = new BigDecimal("0");
    public BigDecimal calcPrice = new BigDecimal("0");

    public JPanel topChecks = new JPanel();
    public JPanel leftChecks = new JPanel();
    public JPanel topRadios = new JPanel();
    public JPanel leftRadios = new JPanel();
    public JPanel botStuff = new JPanel();

    public Collection<DesignOption> shapeOptions = new ArrayList<DesignOption>();

    public boolean doOptions = true;

    public int docType;
	
	
	


	public Frame shapeChangeFrame = new Frame();

   
	Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);


    Cursor waitCursor = new Cursor(Cursor.WAIT_CURSOR);


    public List<OpeningObject> topRowShapes = new ArrayList<OpeningObject>();
    
    // Build Bill Of Material for Rules
    public BuildBOM buildBOM;

    /**
     * Create ItemFrame main application for executions
     *
     * @param frame , JFrame parent component
     * @param modal , Modal execution application
     */
    public ItemFrame(JFrame frame, boolean modal) {

        // Call super constructor
        super(frame, ProjectDetails.PROJECT_NAME + " - "
                + ProjectDetails.PROJECT_VERSION, modal);

        // Setting frame width and height dimensions parent
        setSize(frame.getWidth(), frame.getHeight());

        // Setting default Look and feel decorated
        JDialog.setDefaultLookAndFeelDecorated(false);
        JFrame.setDefaultLookAndFeelDecorated(false);

        // Init Entity Access Object
        this.partnerEAO = new PartnerPersistenceEAO();
        this.seriesEAO = new SeriesPersistenceEAO();
    }

    /**
     * Create ItemFrame main application for executions
     *
     * @param frame,    JFrame parent component
     * @param modal,    Modal execution application
     * @param userPref, User execution preferences
     * @throws HeadlessException, Exception
     */
    public ItemFrame(JFrame frame, boolean modal, UserPreferences userPref) throws HeadlessException {

        // *************************************************************************************
        // Call constructor
        // *************************************************************************************
        this(frame, modal);

        // *************************************************************************************
        // Setting user preferences
        // *************************************************************************************
        this.myParent = frame;
        this.userPref = userPref;

        // *************************************************************************************
        // Setting values runtime application
        // *************************************************************************************
        this.orderCartID = this.userPref.getOrderCartID();
        this.jobID = this.userPref.getOrderID();
        this.itemID = this.userPref.getItemID();
        this.versionID = this.userPref.getVersionID();
        this.seriesID = this.userPref.getSeriesID();
        this.designID = this.userPref.getDesignID();
        this.standardRoID = this.userPref.getAdjustmentRoID();
        this.itemType = this.userPref.getItemType();
        this.designFamilyID = this.userPref.getDesignFamilyID();
        this.userID = this.userPref.getUserID();
        this.supplierID = this.userPref.getSupplierID();
        this.partnerID = this.userPref.getPartnerID();
        this.companyID = this.userPref.getCompanyID();
        this.openingSize = this.userPref.isOpening_size();
        this.partnerDefaults = this.userPref.getPartnerDefaults();
        this.cartDefaults = this.userPref.getCartDefaults();
        this.roundTotal = this.userPref.isRound_total();
        this.roundPrice = this.userPref.isRound_price();
        this.roundDiscountedPrice = this.userPref.isRound_discounted_price();
        this.viewPrice = this.userPref.isView_price();
        this.viewCost = this.userPref.isView_cost();
        this.isNewItem = this.userPref.isNew();
        this.changeBasePrice = this.userPref.isChange_base_price();
        this.changeBOMPrice = this.userPref.isChange_bom_price();
        this.changeDiscount = this.userPref.isChange_discount();
        this.changeGlassPrice = this.userPref.isChange_glass_price();
        this.changeOptionPrice = this.userPref.isChange_option_price();
        this.salesRepID = this.userPref.getSalesRepID();
        this.salesCommission = this.userPref.getCommission();
        this.isSupplier = this.userPref.isSupplier();

        this.jobType = this.userPref.getJobType();
        this.country = this.userPref.getCountry();
        this.language = this.userPref.getLanguage();
        this.defaultentryUOM = this.userPref.getUomID();
        this.baseUOM = this.userPref.getUomID();
        this.currentUOM = this.userPref.getUomID();
        this.myCurrency = this.userPref.getCurrency();
        this.locale = this.userPref.getLocale();
        this.frameDim = this.mySeries.isFrameDim();
        this.selectedDim = this.currentUOM;

        docType = this.userPref.getDocType();

        this.myCS = OEUtility.getCurrencySymbol(locale);
        this.myDecimal = OEUtility.getDecimalFormat(locale);

        // *************************************************************************************
        // Init Part Rules and getting partner
        // *************************************************************************************
        this.executePartRules = new ExecutePartRules(this);

        if (supplierID > 0) {
            this.mySupplier = executePartRules.setPartner(this.supplierID);
        }

        if (this.designID > 0) {
            initDesign = true;
        }

        try {

            this.mySeries = seriesEAO.findById(this.seriesID);
            this.myCustomer = partnerEAO.findById(this.partnerID);

            // Setting partner group
            this.partnerGroupID = myCustomer.getGroupId();

            // Setting imperial rounding
            this.impRound = mySeries.getRounding();

        } catch (PersistenceClassNotFoundException e) {
            e.printStackTrace();
        } catch (GenericPersistenceEAOException e) {
            e.printStackTrace();
        }

        // *************************************************************************************
        // Register listeners
        // *************************************************************************************
        this.registerListeners();
        alreadyAnsweredOptions.clear();

        // *************************************************************************************
        // Initialize build BOM
        // *************************************************************************************
        this.buildBOM = new BuildBOM(this);

        // *************************************************************************************
        // Initialize service configuration content pane
        // *************************************************************************************
        try {
            initialize();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * Register listeners actions
     */
    private void registerListeners() {

        try {
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(final MouseEvent e) {
                    rightClick_MouseClicked(e);
                }
            });
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * Right click mouse click event for this JDialog
     *
     * @param e, MouseEvent
     */
    public void rightClick_MouseClicked(MouseEvent e) {

        try {
            if (e.getButton() == 3) {
                this.setButtonsFalse();
                bottomPanel.grabFocus();
            }
        } catch (final Exception err) {
            logger.error(err.getMessage(), err);
        }
    }

    /**
     * This method initialize ItemFrame service
     *
     * @throws Exception , Exception
     */
    public void initialize() throws Exception {

        ToolTipManager.sharedInstance().setInitialDelay(0);

        // Setting layout design
        this.setLayout(new BorderLayout());

        this.drawGuide = true;

        this.bomView = new BomView();
        this.bomView.initItemFrame(ItemFrame.this);

        // Init Components Values for series
        this.initValueComponents();

        this.buildPriceGroupsCats();

        this.initComponents();
        this.initListenersComponents();

        this.topChecks.setPreferredSize(new Dimension(600, 45));
        this.leftChecks.setPreferredSize(new Dimension(45, 500));
        this.topRadios.setPreferredSize(new Dimension(600, 45));
        this.leftRadios.setPreferredSize(new Dimension(45, 500));

        this.topChecks.setLayout(new XYLayout());
        this.leftChecks.setLayout(new XYLayout());
        this.topRadios.setLayout(new XYLayout());
        this.leftRadios.setLayout(new XYLayout());

        this.mainFramePanel.add(topChecks, BorderLayout.NORTH);
        this.mainFramePanel.add(leftChecks, BorderLayout.WEST);

        this.initializeJobItem();
        this.wEntered = this.hEntered = false;
        this.main.validate();
        this.main.repaint();

        // Close Parent JDialog if this is call
        if (this.userPref.getParent() != null) {
            this.userPref.getParent().setVisible(false);
        }

        if (this.errorMessages.size() <= 0) {
            designTask.setCollapsed(false);
        }

        this.enableByItemType();
        this.setVisible(true);
    }

    private void enableByItemType() {

        if (this.itemType == 3) {
            btnOptionSelect.setEnabled(false);
            btnMullionSelect.setEnabled(false);
            btnShapesSelect.setEnabled(false);
            btnSashSelect.setEnabled(false);
            btnGlassSelect.setEnabled(false);
            btnGridsSelect.setEnabled(false);
            btnEditProfilesSelect.setEnabled(false);
            this.designTask.setCollapsed(true);
            this.designTask.setEnabled(false);
            this.dim.alignHorz.setEnabled(false);
            this.dim.alignVert.setEnabled(false);
            this.dim.equalize.setEnabled(false);
            this.dim.equalizeH.setEnabled(false);
        }

    }

    private void resetActionEvent() {
        MenuActionEventDraw.NOT_SELECTION.resetValue();

        setActionTypeEvent(0);
    }

    /**
     * This method initialize JobItem design
     *
     * @throws Exception , Exception
     */
    public void initializeJobItem() throws Exception {

        // *************************************************
        // Initialize jobItem model
        // *************************************************
        this.jobItem = new JobItemModel(this);

        // *************************************************
        // Init Task Panels options by Supplier and Series
        // *************************************************
        this.supplierPanel.initCombos();
        this.myTopPanel.setComboBasedOnSeries();
        this.glassPanel.setDefaultSU();

        // *************************************************
        // Do Options design panel default selection
        // *************************************************
        this.btnOptionSelect.doClick();

        // *************************************************
        // New of Open JobItem Model
        // *************************************************
        if (this.isNewItem) {

            this.jobItem.newJobItemInfo();

            // *************************************************
            // Init Dimension Object
            // *************************************************
            if (!this.frameDim) {
                this.dim.center.doClick();
            } else {
                this.dim.frame.doClick();
            }
        }

        // *************************************************
        // Open JobItem Model
        // *************************************************
        if (!this.isNewItem) {

            this.jobItem.openJobItemInfo();

            // *************************************************
            // Init Dimension Object
            // *************************************************
            if (!this.frameDim) {
                this.dim.center.doClick();
            } else {
                this.dim.frame.doClick();
            }

            // ************************************************
            // First edit entry, not calculate BOM First Time
            // ************************************************
            this.calcBom = false;

            // ************************************************
            // Init Financial Summary for Order Items Cart
            // ************************************************
            this.costPricePanel.initItemFinancialSummaryData(this.jobItem.getOrderItemsCart());
        }

        // Setting UOM Rounding Mode
        this.UOMRound = this.metricRound;

        // Init Design to False
        this.initDesign = false;

        // ************************************************
        // Init Grids Panel
        // *************************************************
        this.gridsPanel.initGridValueComponents(this.isNewItem);

        // ************************************************
        // Set Preference for Unit of Metric
        // ************************************************
        setPrefUOM();
    }

    @Override
    public void initComponents() {

        // Initialize icon images
        this.setImages();

        this.doMainMenu();
        this.doTabsPanel();
        this.doMainPanel();
    }

    public void buildPriceGroupsCats() {

        int id = 0;
        for (Object pg : getApplicationBase().getPricingGroups()) {
            JobItemCostPrice group = new JobItemCostPrice(id++, ((PricingGroup) pg).getDescription(), 0,
                    ((PricingGroup) pg).getId());

            priceGroups.add(group);
        }

        id = 0;

        for (Object cg : getApplicationBase().getPartsFamilies()) {
            JobItemCostPrice group = new JobItemCostPrice(id++, ((PartsFamily) cg).getDescription(), 1,
                    ((PartsFamily) cg).getId());

            partFamilies.add(group);
        }

        id = 0;
        for (Object pc : getApplicationBase().getTypePriceCategories()) {
            JobItemCostPrice cat = new JobItemCostPrice(id++,
                    ((TypePriceCategory) pc).getDescription(), 2,
                    ((TypePriceCategory) pc).getId());

            priceCategories.add(cat);
        }
    }

    @Override
    public void initValueComponents() {
        // Init Application Base
        this.applicationBase = ApplicationBaseApp.getInstance(this.seriesID, this.partnerID, this.partnerGroupID);
        this.applicationBaseRules = ApplicationBaseRulesApp.getInstance(seriesID);
    }

    public void drawing_MouseClicked(MouseEvent event) {

        try {
            if (event.getButton() == 3) {
                setButtonsFalse();
                stopCustomCursor(this.main);
                resetActionEvent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initListenersComponents() {

        collapsemenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                if (collapsemenu.getBounds().contains(p)) {
                    if (myCursor != Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)) {
                        stopCustomCursor(ItemFrame.this.main);
                        MenuActionEventDraw.NOT_SELECTION.resetValue();

                        setActionTypeEvent(0);
                    }
                }
            }
        });

        myTopPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                if (myTopPanel.getBounds().contains(p)) {
                    if (myCursor != Cursor
                            .getPredefinedCursor(Cursor.DEFAULT_CURSOR)) {
                        stopCustomCursor(ItemFrame.this.main);
                        MenuActionEventDraw.NOT_SELECTION.resetValue();

                        setActionTypeEvent(0);
                    }

                }
            }
        });

        designTask.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                if (designTask.getBounds().contains(p)) {
                    if (myCursor != Cursor
                            .getPredefinedCursor(Cursor.DEFAULT_CURSOR)) {
                        stopCustomCursor(ItemFrame.this.main);
                        MenuActionEventDraw.NOT_SELECTION.resetValue();

                        setActionTypeEvent(0);
                    }

                }
            }
        });

        this.mainMenu.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                stopCustomCursor(main);
                setActionTypeEvent(0);
            }
        });

        this.myTopPanel.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                stopCustomCursor(main);
                setActionTypeEvent(0);
            }
        });

        this.bottomButtons.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                stopCustomCursor(main);
                setActionTypeEvent(0);
            }
        });

        btnSave.addActionListener(CursorController.createListener(this,
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        stopCustomCursor(main);
                        btnSave_actionPerformed(e);
                    }
                }));

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                stopCustomCursor(main);
                Object[] options = {"Yes", "No"};
                int response = JOptionPane.showOptionDialog(null,
                        "Cancel Changes?", "Confirm",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE, null, options, options[0]);

                if (response == 0) {
                    // Refresh User Interface caller panel
                    ((JPanelAsynchronous) userPref.getItemsPanel()).refreshUI();

                    // Close this application
                    ItemFrame.this.dispose();
                }
            }
        });

        btnOptionSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetActionEvent();
                stopCustomCursor(main);
                addComponentToDesignTaskMenu(options.mainPanel);

                setColorDesignButtons(Color.WHITE);
                btnOptionSelect.setBackground(Color.DARK_GRAY);

                setActionTypeEvent(MenuActionEventDraw.NOT_SELECTION.getValue());
            }
        });

        btnMullionSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetActionEvent();
                stopCustomCursor(main);
                addComponentToDesignTaskMenu(mullionsPanel.couplerMullionPanel);

                setColorDesignButtons(Color.WHITE);
                btnMullionSelect.setBackground(Color.DARK_GRAY);

                setActionTypeEvent(MenuActionEventDraw.COUPLER_MULLION_EVENT
                        .getValue());
            }
        });

        btnShapesSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetActionEvent();
                stopCustomCursor(main);
                addComponentToDesignTaskMenu(shapesPanel.myShapePanel);

                setColorDesignButtons(Color.WHITE);
                btnShapesSelect.setBackground(Color.DARK_GRAY);

                setActionTypeEvent(MenuActionEventDraw.SHAPE_EVENT.getValue());
            }
        });

        btnSashSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetActionEvent();
                stopCustomCursor(main);
                addComponentToDesignTaskMenu(sashPanel.mainPanel);

                setColorDesignButtons(Color.WHITE);
                btnSashSelect.setBackground(Color.DARK_GRAY);

                setActionTypeEvent(MenuActionEventDraw.SASH_EVENT.getValue());
            }
        });

        btnGlassSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetActionEvent();
                stopCustomCursor(main);
                addComponentToDesignTaskMenu(glassPanel.glassPanel);

                setColorDesignButtons(Color.WHITE);
                btnGlassSelect.setBackground(Color.DARK_GRAY);

                setActionTypeEvent(MenuActionEventDraw.GLASS_SEALED_UNIT_EVENT
                        .getValue());
            }
        });

        btnGridsSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetActionEvent();
                stopCustomCursor(main);
                addComponentToDesignTaskMenu(gridsPanel.gridPanel);

                setColorDesignButtons(Color.WHITE);
                btnGridsSelect.setBackground(Color.DARK_GRAY);

                setActionTypeEvent(MenuActionEventDraw.GRIDS_EVENT.getValue());
            }
        });

        btnEditProfilesSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetActionEvent();
                stopCustomCursor(main);
                addComponentToDesignTaskMenu(editor.editPanel);

                setColorDesignButtons(Color.WHITE);
                btnEditProfilesSelect.setBackground(Color.DARK_GRAY);
            }
        });

        supplierTask.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                resetActionEvent();
                stopCustomCursor(main);

                if (!supplierTask.isCollapsed()) {
                    costPriceTask.setCollapsed(true);
                    dimTask.setCollapsed(true);
                    viewTask.setCollapsed(true);
                    errorWarningTask.setCollapsed(true);
                    infoTask.setCollapsed(true);
                }
            }
        });

        designTask.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                resetActionEvent();
                stopCustomCursor(main);
                if (!designTask.isCollapsed()) {
                    costPriceTask.setCollapsed(true);
                    dimTask.setCollapsed(true);
                    viewTask.setCollapsed(true);
                    errorWarningTask.setCollapsed(true);
                    infoTask.setCollapsed(true);
                }
            }
        });

        costPriceTask.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                try {

                    resetActionEvent();
                    stopCustomCursor(main);

                    if (!costPriceTask.isCollapsed()) {

                        // Init Financial Summary Data
                        costPricePanel.initFinancialSummaryData();

                        designTask.setCollapsed(true);
                        dimTask.setCollapsed(true);
                        viewTask.setCollapsed(true);
                        errorWarningTask.setCollapsed(true);
                        infoTask.setCollapsed(true);

                        enableByItemType();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(myParent, e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        dimTask.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

                stopCustomCursor(main);
                if (!dimTask.isCollapsed()) {
                    designTask.setCollapsed(true);
                    costPriceTask.setCollapsed(true);
                    viewTask.setCollapsed(true);
                    errorWarningTask.setCollapsed(true);
                    infoTask.setCollapsed(true);
                    enableByItemType();
                }
            }
        });

        viewTask.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                resetActionEvent();
                stopCustomCursor(main);
                if (!viewTask.isCollapsed()) {
                    designTask.setCollapsed(true);
                    costPriceTask.setCollapsed(true);
                    dimTask.setCollapsed(true);
                    errorWarningTask.setCollapsed(true);
                    infoTask.setCollapsed(true);
                    enableByItemType();
                }
            }
        });

        errorWarningTask
                .addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        stopCustomCursor(main);

                        if (!errorWarningTask.isCollapsed()) {
                            designTask.setCollapsed(true);
                            costPriceTask.setCollapsed(true);
                            dimTask.setCollapsed(true);
                            viewTask.setCollapsed(true);
                            infoTask.setCollapsed(true);
                            enableByItemType();
                        }
                    }
                });

        infoTask.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                resetActionEvent();
                stopCustomCursor(main);
                if (!infoTask.isCollapsed()) {

                    designTask.setCollapsed(true);
                    costPriceTask.setCollapsed(true);
                    dimTask.setCollapsed(true);
                    viewTask.setCollapsed(true);
                    errorWarningTask.setCollapsed(true);
                    enableByItemType();
                }
            }
        });

        // Init Task Panel Listener
        this.intTaskPanelListener();
    }

    private void intTaskPanelListener() {

        ChangeListener changeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {

                stopCustomCursor(main);
                JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();

                int index = sourceTabbedPane.getSelectedIndex();

                if (index == 0) {

                    ItemFrame.this.jobItem.myCanvas.enableLayouts();

                    ItemFrame.this.supplierTask.setCollapsed(false);
                    ItemFrame.this.designTask.setCollapsed(true);
                    ItemFrame.this.costPriceTask.setCollapsed(true);
                    ItemFrame.this.dimTask.setCollapsed(true);
                    ItemFrame.this.viewTask.setCollapsed(true);
                    ItemFrame.this.errorWarningTask.setCollapsed(true);
                    ItemFrame.this.infoTask.setCollapsed(false);

                    if (errorMessages.size() > 0 || warningMessages.size() > 0) {
                        ItemFrame.this.errorWarningTask.setCollapsed(false);
                    }

                    if (infoMessages.size() == 0) {
                        ItemFrame.this.infoTask.setCollapsed(true);
                    }

                    setTasksVisible(false);

                } else if (index == 1) {
                    setTasksVisible(true);
                } else if (index == 2) {

                    bomView = new BomView(ItemFrame.this);

                    ItemFrame.this.partsPanel.removeAll();
                    ItemFrame.this.partsPanel.add(bomView, BorderLayout.CENTER);

                    setTasksVisible(false);

                } else if (index == 3) {

                    GlassView gView = new GlassView(ItemFrame.this);
                    ItemFrame.this.panelGlass.removeAll();
                    ItemFrame.this.panelGlass.add(gView, BorderLayout.CENTER);

                    setTasksVisible(false);

                } else if (index == 4) {

                    // Update Financial Category values
                    FinancialSummay cView = new FinancialSummay(ItemFrame.this);
                    cView.initPriceCategories();

                    ItemFrame.this.costPanel.removeAll();
                    ItemFrame.this.costPanel.add(cView, BorderLayout.CENTER);

                    setTasksVisible(false);

                } else if (index == 5) {

                    ItemFrame.this.notesPanel.removeAll();
                    JLabel iNotes = new JLabel("Item Notes:");
                    notesScroll.getViewport().add(textArea);
                    ItemFrame.this.notesPanel.add(iNotes, BorderLayout.NORTH);
                    ItemFrame.this.notesPanel.add(notesScroll, BorderLayout.CENTER);

                    setTasksVisible(false);
                }
            }
        };

        // Adding Change Listener to myTabs component
        this.myTabs.addChangeListener(changeListener);
    }

    private void doMainMenu() {

        doSupplierTaskPane();
        doDesignTaskPane();
        doViewCostTaskPane();
        doViewTaskPane();
        doDimensionTaskPane();
        doErrorTaskPane();
        doInfoTaskPane();

        // *************************************************************
        // Init collapsemenu
        // *************************************************************
        this.collapsemenu = new JXCollapsiblePane(new VerticalLayout());
        this.collapsemenu.setPreferredSize(new Dimension(200, this.getHeight() - 62));

        this.collapsemenu.add(this.supplierTask);
        this.collapsemenu.add(this.designTask);

        if (this.userPref.isView_price()) {
            this.collapsemenu.add(this.costPriceTask);
        }

        this.collapsemenu.add(this.dimTask);
        this.collapsemenu.add(this.viewTask);

        this.errorWarningTask.setCollapsed(true);
        if (this.errorMessages.size() > 0 || this.warningMessages.size() > 0) {
            this.collapsemenu.add(this.errorWarningTask);
            errorWarningTask.setCollapsed(false);
        }
        if (this.infoMessages.size() > 0) {
            // this.collapsemenu.add(this.infoTask);
            // infoTask.setCollapsed(false);
        }

        // *************************************************************
        // Init Main Menu
        // *************************************************************
        this.mainMenu = new JPanel(new BorderLayout());
        this.mainMenu.setPreferredSize(new Dimension(350, this.getHeight() - 62));

        this.mainMenu.add(collapsemenu, BorderLayout.CENTER);

        if (myDim.height > 768) {
            mainMenu.add(bottomMenu, BorderLayout.SOUTH);
        }

    }

    private void doSupplierTaskPane() {

        this.supplierPanel = new SupplierSelectorPanel(this);

        this.supplierTask = new JXTaskPaneOJ(new XYLayout());
        this.supplierTask.setToolTipText("Change Supplier/Series");
        this.supplierTask.setIcon(ItemFrame.iconFiles.get("supplier"));
        this.supplierTask.setCollapsed(false);

        this.supplierTask.add(this.supplierPanel.mainPanel);
    }

    private void doDesignTaskPane() {

        // *************************************************************
        // Start Panel Instantiation
        // *************************************************************
        this.options = new OptionSelectorPanel(this);
        this.mullionsPanel = new CouplerAndMullionPanel(this);
        this.shapesPanel = new ShapeSelectorPanel(this);
        this.sashPanel = new SashSelectorPanel(this);
        this.glassPanel = new GlassSelectorPanel(this);
        this.gridsPanel = new GridPanel(this);
        this.editor = new EditorPanel(this);

        this.dim = new DimsPanel(this);
        this.dim.guidePanel.setVisible(false);

        btnOptionSelect = new JButton();
        btnOptionSelect.setPreferredSize(new Dimension(40, 40));
        btnOptionSelect.setIcon(ItemFrame.iconFiles.get("options"));
        btnOptionSelect.setToolTipText("Product Options");
        btnOptionSelect.setBackground(Color.WHITE);

        btnMullionSelect = new JButton();
        btnMullionSelect.setPreferredSize(new Dimension(40, 40));
        btnMullionSelect.setIcon(ItemFrame.iconFiles.get("couplermullion"));
        btnMullionSelect.setToolTipText("Couplers & Mullions");
        btnMullionSelect.setBackground(Color.WHITE);

        btnShapesSelect = new JButton();
        btnShapesSelect.setPreferredSize(new Dimension(40, 40));
        btnShapesSelect.setIcon(ItemFrame.iconFiles.get("shapes"));
        btnShapesSelect.setToolTipText("Shapes");
        btnShapesSelect.setBackground(Color.WHITE);

        btnSashSelect = new JButton();
        btnSashSelect.setPreferredSize(new Dimension(40, 40));
        btnSashSelect.setIcon(ItemFrame.iconFiles.get("openings"));
        btnSashSelect.setToolTipText("Opening Types: Windows, Doors, Entrances");
        btnSashSelect.setBackground(Color.WHITE);

        btnGlassSelect = new JButton();
        btnGlassSelect.setPreferredSize(new Dimension(40, 40));
        btnGlassSelect.setIcon(ItemFrame.iconFiles.get("glass16"));
        btnGlassSelect.setToolTipText("Glass & Sealed Units");
        btnGlassSelect.setBackground(Color.WHITE);

        btnGridsSelect = new JButton();
        btnGridsSelect.setPreferredSize(new Dimension(40, 40));
        btnGridsSelect.setIcon(ItemFrame.iconFiles.get("grids16"));
        btnGridsSelect.setToolTipText("Grids");
        btnGridsSelect.setBackground(Color.WHITE);

        btnEditProfilesSelect = new JButton();
        btnEditProfilesSelect.setPreferredSize(new Dimension(40, 40));
        btnEditProfilesSelect.setIcon(ItemFrame.iconFiles.get("editprofiles"));
        btnEditProfilesSelect.setToolTipText("Edit Profile: End Types, Part Numbers, etc.");
        btnEditProfilesSelect.setBackground(Color.WHITE);

        JPanel designMenuPanel = new JPanel(new FlowLayout());
        designMenuPanel.setBorder(new EtchedBorder());
        designMenuPanel.add(btnOptionSelect);
        designMenuPanel.add(btnMullionSelect);
        designMenuPanel.add(btnShapesSelect);
        designMenuPanel.add(btnSashSelect);
        designMenuPanel.add(btnGlassSelect);
        designMenuPanel.add(btnGridsSelect);
        designMenuPanel.add(btnEditProfilesSelect);

        // *************************************************************
        // Init Design Task
        // *************************************************************
        this.designTask = new JXTaskPaneOJ(new VerticalLayout(0));
        this.designTask.setToolTipText("Design Functions");
        this.designTask.setIcon(ItemFrame.iconFiles.get("designFunction"));
        if (itemType != 3) {
            this.designTask.setCollapsed(false);
        } else {
            this.designTask.setCollapsed(true);
        }

        this.designTask.add(designMenuPanel);
        enableByItemType();
    }

    private void doViewCostTaskPane() {

        this.costPricePanel = new CostPricePanel(this);

        this.costPriceTask = new JXTaskPaneOJ(new XYLayout());
        this.costPriceTask.setToolTipText("Item Financial Summary");
        this.costPriceTask.setIcon(ItemFrame.iconFiles.get("cost"));
        this.costPriceTask.setCollapsed(true);

        this.costPriceTask.add(this.costPricePanel);
    }

    private void doDimensionTaskPane() {

        // *************************************************************
        // Init Dimension Task
        // *************************************************************
        this.dimTask = new JXTaskPaneOJ(new BorderLayout());
        this.dimTask.setToolTipText("Dimensioning");
        this.dimTask.setIcon(ItemFrame.iconFiles.get("dimensioning"));
        this.dimTask.setCollapsed(true);

        this.dimTask.add(this.dim.dimPanel, BorderLayout.CENTER);
        this.dimTask.add(this.dim.guidePanel, BorderLayout.SOUTH);
    }

    private void doViewTaskPane() {

        // *************************************************************
        // Init View Task
        // *************************************************************
        this.viewTask = new JXTaskPaneOJ(new XYLayout());
        this.viewTask.setToolTipText("View Details");
        this.viewTask.setIcon(ItemFrame.iconFiles.get("view"));
        this.viewTask.setCollapsed(true);

        this.viewTask.add(this.dim.viewPanel, BorderLayout.CENTER);
    }

    private void doErrorTaskPane() {

        // *************************************************************
        // Init View Task
        // *************************************************************

        errorWarningTask = new JXTaskPaneOJ(new BorderLayout());

        errorsPanel.setLayout(new BorderLayout());
        warningsPanel.setLayout(new BorderLayout());

        this.errorScroll.setPreferredSize(new Dimension(290, 200));
        this.warningScroll.setPreferredSize(new Dimension(290, 200));

        this.errorScroll.getViewport().add(this.errorList);
        this.warningScroll.getViewport().add(this.warningList);

        buildErrorList();

        errorWarningTask.setBackground(Color.WHITE);

        errorSep.setFont(new Font("SansSerif", Font.BOLD, 14));

        errorsPanel.add(errorSep, BorderLayout.NORTH);
        errorsPanel.add(errorScroll, BorderLayout.CENTER);

        warningSep.setFont(new Font("SansSerif", Font.BOLD, 14));

        warningsPanel.add(warningSep, BorderLayout.NORTH);
        warningsPanel.add(warningScroll, BorderLayout.CENTER);

        this.errorWarningTask.setToolTipText("Errors & Warnings");

        this.errorWarningTask.setIcon(ItemFrame.iconFiles.get("error"));

        this.errorWarningTask.add(this.errorsPanel, BorderLayout.CENTER);
        this.errorWarningTask.add(this.warningsPanel, BorderLayout.SOUTH);

        this.errorWarningTask.setCollapsed(true);

    }

    public void buildErrorList() {

        this.errorList.removeAll();
        this.warningList.removeAll();

        errorList.setListData(this.errorMessages.toArray());
        warningList.setListData(this.warningMessages.toArray());

    }

    public void doInfoTaskPane() {

        // *************************************************************
        // Init Info Task
        // *************************************************************

        infoTask = new JXTaskPaneOJ(new BorderLayout());

        infoPanel.setLayout(new BorderLayout());

        this.infoScroll.setPreferredSize(new Dimension(290, 200));

        infoTask.setBackground(Color.WHITE);

        infoPanel.add(infoScroll, BorderLayout.CENTER);

        this.infoTask.setToolTipText("Rules Based and Product Information");

        this.infoTask.setIcon(ItemFrame.iconFiles.get("tip"));

        this.infoTask.add(this.infoPanel, BorderLayout.CENTER);

        this.infoTask.setCollapsed(true);

    }

    public void initInfoList() {

        if (infoMessages != null && infoMessages.size() > 0) {
            infoTable.setModel(new DefaultModel());
        }

        infoScroll.getViewport().add(infoTable, null);
        int xx = this.jobItem.designID;
        if (infoMessages.size() > 0) {
            // collapsemenu.add(infoTask);
            // infoTask.setCollapsed(false);
        }
        if (infoMessages.size() == 0) {
            // collapsemenu.remove(infoTask);
            // designTask.setCollapsed(false);
        }

        attributes = "";

        for (Object info : infoMessages.toArray()) {

            if (((InfoMessage) info).showQty) {
                if (attributes.trim().length() == 0) {
                    attributes = ((InfoMessage) info).stockcode + " : "
                            + String.valueOf(((InfoMessage) info).value) + ",";
                } else {
                    if ((attributes + attributes
                            + ((InfoMessage) info).stockcode + " : "
                            + String.valueOf(((InfoMessage) info).value) + ",")
                            .length() > 400) {
                        attributes = attributes + "\n,";
                        attributes = attributes
                                + ((InfoMessage) info).stockcode + " : "
                                + String.valueOf(((InfoMessage) info).value)
                                + ",";
                    } else {
                        attributes = attributes
                                + ((InfoMessage) info).stockcode + " : "
                                + String.valueOf(((InfoMessage) info).value)
                                + ",";
                    }

                }

            }

        }

        for (Object info : infoMessages.toArray()) {
            if (!((InfoMessage) info).showQty) {
                if (attributes.trim().length() == 0) {
                    attributes = ((InfoMessage) info).stockcode + " : "
                            + ((InfoMessage) info).description + "\n";
                } else {
                    attributes = attributes + ((InfoMessage) info).stockcode
                            + " : " + ((InfoMessage) info).description + "\n";
                }

            }
        }

        collapsemenu.validate();
        collapsemenu.repaint();
        validate();
        repaint();

    }

    private void doTabsPanel() {

        // *************************************************************
        // Init Tabs for Panel
        // *************************************************************
        // this.layoutP = new LayoutPanel(this);
        this.layoutPanel = new JPanel(new BorderLayout());
        this.layoutPanel.setBorder(BorderFactory.createEtchedBorder());
        // this.jPanelLayout.add(layoutP, BorderLayout.CENTER);

        this.mainFramePanel = new JPanel(new BorderLayout());
        this.mainFramePanel.setPreferredSize(new Dimension(650, 550));

        this.partsPanel = new JPanel(new BorderLayout());
        this.panelGlass = new JPanel(new BorderLayout());
        this.costPanel = new JPanel(new BorderLayout());
        this.notesPanel = new JPanel(new BorderLayout());

        // *************************************************************
        // Init Tabs Panel
        // *************************************************************
        this.myTabs = new JTabbedPane(JTabbedPane.BOTTOM);

        this.myTabs.addTab("", ItemFrame.iconFiles.get("bay"), layoutPanel, "Product Layout");
        this.myTabs.addTab("", ItemFrame.iconFiles.get("elevation"), mainFramePanel, "Elevation");
        this.myTabs.addTab("", ItemFrame.iconFiles.get("part"), partsPanel, "Parts & Labour - B.O.M.");
        this.myTabs.addTab("", ItemFrame.iconFiles.get("glass16"), panelGlass, "Glass & Glass Labour - B.O.M.");
        this.myTabs.addTab("", ItemFrame.iconFiles.get("cost"), costPanel, "Item Financial Summary");
        this.myTabs.addTab("", ItemFrame.iconFiles.get("note"), notesPanel, "Item Notes");

        this.myTabs.setSelectedIndex(1);

        //**************************************************************
        //Setting Enabled - Disabled User Rights
        //**************************************************************
        this.myTabs.setEnabledAt(2, this.userPref.isViewBom());
        this.myTabs.setEnabledAt(3, this.userPref.isViewBom());
        this.myTabs.setEnabledAt(4, this.userPref.isView_cost());
    }

    private void doMainPanel() {

        // *************************************************************
        // Init Top Panel
        // *************************************************************
        this.myTopPanel = new TopPanel(this);
        this.myTopPanel.addUndo();

        this.topPanel = new JPanel(new BorderLayout());
        this.topPanel.setBorder(BorderFactory.createEtchedBorder());
        this.topPanel.setPreferredSize(new Dimension(500, 105));

        this.topPanel.add(this.myTopPanel, BorderLayout.CENTER);

        // *************************************************************
        // Init Bottom Buttons Panel
        // *************************************************************
        this.btnSave = new JButton();
        this.btnSave.setIcon(ItemFrame.iconFiles.get("save"));
        this.btnSave.setToolTipText("Save");
        this.btnSave.setVisible(this.userPref.isEdit()); // Setting visible false if not edit available

        this.btnCancel = new JButton();
        this.btnCancel.setIcon(ItemFrame.iconFiles.get("cancel"));
        this.btnCancel.setToolTipText("Cancel");

        this.bottomButtons = new JPanel(new XYLayout());
        this.bottomButtons.setPreferredSize(new Dimension(122, 20));
        this.bottomButtons.add(this.btnSave, new XYConstraints(1, 1, 60, 19));
        this.bottomButtons.add(this.btnCancel, new XYConstraints(61, 1, 60, 19));

        // *************************************************************
        // Init Bottom Functions Panel
        // *************************************************************
        this.bottomFunctions = new JPanel(new BorderLayout());
        this.bottomFunctions.setBorder(BorderFactory.createEtchedBorder());
        this.bottomFunctions.setPreferredSize(new Dimension(500, 24));

        this.bottomFunctions.add(bottomButtons, BorderLayout.EAST);

        // *************************************************************
        // Init Bottom Panel
        // *************************************************************
        this.bottomPanel.setLayout(new BorderLayout());
        this.bottomPanel.setPreferredSize(new Dimension(500, 30));
        if (this.myDim.height <= 768) {
            this.bottomPanel.setPreferredSize(new Dimension(500, 24));
        }

        this.bottomPanel.add(bottomFunctions, BorderLayout.NORTH);
        if (myDim.height > 768) {
            this.bottomPanel.add(this.bottomAdverts, BorderLayout.CENTER);
        }

        this.bottomAdverts = new JPanel(new BorderLayout());
        this.bottomAdverts.setPreferredSize(new Dimension(500, this.bottomPanel.getHeight() - this.bottomFunctions.getHeight()));

        // *************************************************************
        // Init Buttons Panel
        // *************************************************************
        this.buttonsPanel = new JPanel(new VerticalLayout());
        this.buttonsPanel.setPreferredSize(new Dimension(280, 150));

        if (myDim.height <= 768) {
            bottomMenu.setPreferredSize(new Dimension(500, 24));
        } else {
            bottomMenu.setPreferredSize(new Dimension(500, myDim.height - 766));
        }

        // *************************************************************
        // Init Main Draw Panel
        // *************************************************************
        this.mainDraw = new JPanel(new BorderLayout());
        this.mainDraw.setBorder(BorderFactory.createEtchedBorder());
        this.mainDraw.setPreferredSize(new Dimension(this.myDim.width - 150,
                this.getHeight() - 62));
        this.mainDraw.setOpaque(false);

        if (this.myDim.width <= 1024) {
            this.mainDraw.setPreferredSize(new Dimension(this.myDim.width - 250, this.getHeight() - 62));
        }

        this.mainDraw.add(this.topPanel, BorderLayout.NORTH);
        this.mainDraw.add(this.myTabs, BorderLayout.CENTER);
        this.mainDraw.add(this.bottomPanel, BorderLayout.SOUTH);

        // *************************************************************
        // Init Right Adverts Panel
        // *************************************************************
        this.rightAdverts = new JPanel();
        this.rightAdverts.setPreferredSize(new Dimension(250, this.getHeight() - 62));
        if (myDim.width <= 1024) {
            this.rightAdverts.setPreferredSize(new Dimension(0, this.getHeight() - 62));
        }

        this.rightLabelsPanel = new JPanel(new VerticalLayout());

        // *************************************************************
        // Init Main Panel
        // *************************************************************
        this.main = new JPanel(new BorderLayout());
        this.main.setBorder(BorderFactory.createEtchedBorder());
        this.main.setOpaque(false);

        if (this.myDim.width > 1024) {
            main.add(rightAdverts, BorderLayout.EAST);
        }
        this.main.add(mainMenu, BorderLayout.WEST);
        this.main.add(mainDraw, BorderLayout.CENTER);

        this.getContentPane().add(main);
    }

    /**
     * Setting images to buttons configuration
     */
    private void setImages() {

        // Init images from Icons Map
        iconFiles = ResourcesUtil.getImageIconMap();

        error16Image = iconFiles.get("error16");
        warning16Image = iconFiles.get("warning16");
        shABImage = iconFiles.get("sh_ab");
        infoImage = iconFiles.get("info");
        undoImage = iconFiles.get("undo");
        setImage = iconFiles.get("set");
        saveImage = iconFiles.get("save");

        abcDH = iconFiles.get("abcDH");
        abcSH = iconFiles.get("abcSH");
        abcSSL = iconFiles.get("abcSSL");
        abcSSR = iconFiles.get("abcSSR");
        abc2LP = iconFiles.get("abc2LP");
        abc3LS = iconFiles.get("abc3LS");
        abc4LS = iconFiles.get("abc4LS");
        abcCLS = iconFiles.get("abcCLS");
        abcDLS = iconFiles.get("abcDLS");

        cancelImage = iconFiles.get("cancel");
        changeImage = iconFiles.get("change");
        addImage = iconFiles.get("add");
        designFunctionImage = iconFiles.get("designFunction");
        optionsImage = iconFiles.get("options");
        gridsImage = iconFiles.get("grids16");
        glassImage = iconFiles.get("glass16");
        couplermullionImage = iconFiles.get("couplermullion");
        shapesImage = iconFiles.get("shapes");
        overallShapeImage = iconFiles.get("overallShapeUnselected");
        frameShapeImage = iconFiles.get("frameShapeUnselected");
        overallSShapeImage = iconFiles.get("overallShapeSelected");
        frameSShapeImage = iconFiles.get("frameShapeSelected");
        openingsImage = iconFiles.get("openings");
        editProfilesImage = iconFiles.get("editprofiles");
        subFrameImage = iconFiles.get("subFrame");
        sashImage = iconFiles.get("sashdims");
        subsashImage = iconFiles.get("subsash");
        profileshapeImage = iconFiles.get("profileshape");
        elevationImage = iconFiles.get("elevation");
        costImage = iconFiles.get("cost");
        priceImage = iconFiles.get("price");
        noteImage = iconFiles.get("note");
        addonsImage = iconFiles.get("addons");
        supplierImage = iconFiles.get("supplier");
        seriesImage = iconFiles.get("series");
        tipImage = iconFiles.get("tip");
        errorImage = iconFiles.get("error");
        balanceIcon = iconFiles.get("equalize");
        balanceIconH = iconFiles.get("equalizeH");
    }

    /**
     * This method stablish an editable task pane operations
     *
     * @param visible, boolean
     */
    private void setTasksVisible(boolean visible) {

        // Editable values for Supplier panel
        ItemFrame.this.supplierPanel.suppliersCmb.setEnabled(visible);
        ItemFrame.this.supplierPanel.seriesCmb.setEnabled(visible);
        ItemFrame.this.supplierPanel.setSS.setEnabled(visible);

        // Visibility for task panels
        ItemFrame.this.designTask.setVisible(visible);
        ItemFrame.this.costPriceTask.setVisible(visible);
        ItemFrame.this.dimTask.setVisible(visible);
        ItemFrame.this.viewTask.setVisible(visible);

        enableByItemType();
    }

    public void setPrefUOM() {

        if (defaultentryUOM == 1) {
            myTopPanel.metric.setSelected(true);
            currentUOM = 1;
            prevUOM = 1;
        } else if (defaultentryUOM == 2) {
            myTopPanel.impDec.setSelected(true);
            currentUOM = 2;
            prevUOM = 2;
        } else if (defaultentryUOM == 3) {
            myTopPanel.impFrac.setSelected(true);
            currentUOM = 3;
            prevUOM = 3;
        } else if (defaultentryUOM == 4) {
            myTopPanel.feet.setSelected(true);
            currentUOM = 4;
            prevUOM = 4;
        }
    }

    public void setPercentActive(boolean on) {
        myTopPanel.percent.setEnabled(false);
    }

    /**
     * This method add a component to design task menu
     *
     * @param c, Component
     */
    private void addComponentToDesignTaskMenu(Component c) {

        try {
            Component component = this.designTask.getContentPane().getComponent(1);
            if (component != null) {
                this.designTask.remove(component);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            if (logger.isDebugEnabled()) {
                logger.debug("No one component could be found!!!");
            }
        }

        this.designTask.add(c, 1);
        this.designTask.repaint();
    }

    /**
     * This method update Background color for design menu buttons
     *
     * @param color , Color
     */
    private void setColorDesignButtons(Color color) {

        btnOptionSelect.setBackground(color);
        btnMullionSelect.setBackground(color);
        btnEditProfilesSelect.setBackground(color);
        btnGlassSelect.setBackground(color);
        btnGridsSelect.setBackground(color);
        btnSashSelect.setBackground(color);
        btnShapesSelect.setBackground(color);
    }

    /**
     * Return a type of action event
     *
     * @return int
     */
    public int getActionTypeEvent() {
        return actionType;
    }

    /**
     * Set a type of action event
     *
     * @param actionTypeEvent , int
     */
    public void setActionTypeEvent(int actionTypeEvent) {
        this.actionType = actionTypeEvent;
    }

    public void set_actionPerformed(final ActionEvent e) {

        if (editor.editFrame) { /*
                                 * -- End Type Specs -- End Type:
								 * 
								 * pos = 8 Left: bottom RB Top LT
								 * 
								 * pos = 1,2,3 top: Left RB right LT
								 * 
								 * pos = 4 right: Top RB Bottom LT
								 * 
								 * pos = 5,6,7 Bot: Right LT Bottom RB
								 */

            if (selectedPart.position <= 4) {
                if (editor.endTypeLT.isSelected()) {
                    endRB = editor.getSelectedEndTypeLT();
                }
                if (editor.endTypeRB.isSelected()) {
                    endLT = editor.getSelectedEndTypeRB();
                }
            } else {
                if (editor.endTypeLT.isSelected()) {
                    endLT = editor.getSelectedEndTypeLT();
                }
                if (editor.endTypeRB.isSelected()) {
                    endRB = editor.getSelectedEndTypeRB();
                }
            }

            if (editor.parts.getSelectedIndex() > 0 && editor.part.isSelected()) {
                partID = editor.parts.getSelectedIndex() + 1;
                partThick = 2;
                partDimB = 2f;
                partDimC = 0.0f;
                partDimA = 12;
                partDimM = 12;
            }
            if (editor.selectedEditLevel == 1) {
                if (selectedFrame.a_levelID > 1) {
                    this.setChangeProfileFrame(selectedPart, selectedFrame);
                } else {
                    setChangeProfileFacet(selectedPart);
                }

            } else if (editor.selectedEditLevel == 2) {

                this.setChangeProfileSash(selectedPart, selectedFrame);
            } else if (editor.selectedEditLevel == 4) {

                this.setChangeProfileSubFrame(selectedPart, selectedFrame);
            } else if (editor.selectedEditLevel == 5) {
                this.setChangeProfileSubSash(selectedPart, selectedFrame);
            }
        } else if (editor.removeFrame) {
            if (editor.selectedEditLevel == 1) {
                this.setChangeProfileFrame(selectedPart, selectedFrame);
            } else if (editor.selectedEditLevel == 2) {
                this.setChangeProfileSash(selectedPart, selectedFrame);
            } else if (editor.selectedEditLevel == 4) {
                this.setChangeProfileSubFrame(selectedPart, selectedFrame);
            } else if (editor.selectedEditLevel == 5) {
                this.setChangeProfileSash(selectedPart, selectedFrame);
            }
        }
        if (frameDim) {
            dim.center.doClick();
        } else {
            dim.frame.doClick();
        }
        editor.cancel.doClick();

        this.jobItem.resetGraphics();

    }

    public void doFacetRadioClick() {

        if (mainFacetCheckBot != null && mainFacetCheckBot[lastFB - 1] != null) {
            mainFacetCheckBot[lastFB - 1].doClick();
        } else {
            final Object[] facets = jobItem.design.frames.toArray();
            for (final Object f : facets) {
                facetUsed = (Facet) f;
                break;
            }
        }
    }

    /**
     * Process coupler mullion action click
     *
     * @param xxx       , Axis x position
     * @param yyy       , Axis y position
     * @param whichPos  , Disire which position
     * @param dimType   , Dimension type
     * @param myOpening , OpeningObject
     * @param myFrame   , ShapeObject
     */
    public void doCouplerMullionClick(int xxx, int yyy, int whichPos, int dimType, OpeningObject myOpening,
                                      ShapeObject myFrame) {

        try {

            // Initialize values
            editor.editFrame = false;
            alignV = false;
            alignH = false;

            if (dimType > 4) {
                // center.doClick();
            }

            boolean okAdd = true;

            /**
             * Selected level is a coupler and level ID is 101
             */
            if (mullionsPanel.selectedLevel == ValidCouplerMullions.COUPLER
                    .getValue() && facetUsed.a_levelID == 101) {
                okAdd = false;

                JOptionPane
                        .showMessageDialog(
                                null,
                                "Cannot Add Coupler into a SubFrame!\n"
                                        + "To request this feature, please contact your Supplier.",
                                "Add Coupler in SubFrame - Error!",
                                JOptionPane.ERROR_MESSAGE);
            }

            if (okAdd) {

                facetUsed.addCouplerMullion(xxx, yyy, mullionsPanel.selectedHV,
                        mullionsPanel.selectedLevel, mullionsPanel.mType,
                        whichPos, true, null, myOpening);

                if (mullionsPanel.selectedLevel == 1
                        && mullionsPanel.selectedHV > 0) {

                    hasCoupler = true;

                    if (!layoutP.flat.isSelected()
                            && mullionsPanel.selectedHV == 1 && posCond == 1) {
                        jobItem.myCanvas.repaint();
                    }

                } else if (mullionsPanel.selectedLevel == 2
                        && mullionsPanel.selectedHV > 0) {
                    hasMullion = true;
                    mullionsPanel.editEnabled(true);
                } else if (mullionsPanel.selectedLevel == 3
                        && mullionsPanel.selectedHV > 0) {
                    hasSMullion = true;
                    mullionsPanel.editEnabled(true);
                }

                if (hasGrids) {
                    if (this.btnGridsSelect.isSelected()) {
                        this.btnGridsSelect.doClick();
                    }
                    setgrids();
                }
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Do Divider Click
     *
     * @param xxx       , Axis x position
     * @param yyy       , Axis y position
     * @param whichPos  , Which position
     * @param dimType   , Dimension type
     * @param myOpening , OpeningObject
     * @param myFrame   , ShapeObject
     */
    public void doDividerClick(int xxx, int yyy, int whichPos, int dimType, OpeningObject myOpening, ShapeObject myFrame) {

        try {

            editor.editFrame = false;
            alignV = false;
            alignH = false;

            if (mullionsPanel.selectedHV == 1) {
                if (mullionsPanel.selectedLevel == 1) {
                }
                jobItem.design.addDivider(xxx, yyy, 1,
                        mullionsPanel.selectedLevel, mullionsPanel.mType,
                        whichPos, true, null);
            } else if (mullionsPanel.selectedHV == 2) {
                if (mullionsPanel.selectedLevel == 1) {

                }
                jobItem.design.addDivider(xxx, yyy, 2,
                        mullionsPanel.selectedLevel, mullionsPanel.mType,
                        whichPos, true, null);
            }

            if (mullionsPanel.selectedLevel == 1
                    && mullionsPanel.selectedHV > 0) {
                hasCoupler = true;
                if (!layoutP.flat.isSelected() && mullionsPanel.selectedHV == 1
                        && posCond == 1) {

                    jobItem.myCanvas.repaint();
                }
            } else if (mullionsPanel.selectedLevel == 2
                    && mullionsPanel.selectedHV > 0) {
                hasMullion = true;
                mullionsPanel.editEnabled(true);
            } else if (mullionsPanel.selectedLevel == 3
                    && mullionsPanel.selectedHV > 0) {
                hasSMullion = true;

                mullionsPanel.editEnabled(true);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public void getSashType(final OpeningObject O) {

        try {

            final int[] info = sashPanel.getDefaultSashType();// setDefaultSashType(O);

            boolean gOut = false;
            if (info[2] == 1) {
                gOut = true;
            }

            CreateSash createSash = new CreateSash(O, info[0], info[1],
                    sashPanel.noOfLeafs, sashPanel.notracks,
                    sashPanel.sashOnTrack, sashPanel.whichPos, sashPanel.split,
                    sashPanel.opens, null, gOut, sashPanel.sashGlazedOut,
                    sashPanel.paneType, sashPanel.isOriel,
                    sashPanel.interlockTypes, sashPanel.extendExtra, this,
                    sashPanel.selectedType);

            sashType = createSash.createSashType();
            // this.wEntered = this.hEntered = false;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setSashType(final OpeningObject O) {

        try {

            CreateSash createSash = new CreateSash(O, sashPanel.openingClass,
                    sashPanel.userDefinedOpeningID, sashPanel.noOfLeafs,
                    sashPanel.notracks, sashPanel.sashOnTrack,
                    sashPanel.whichPos, sashPanel.split, sashPanel.opens, null,
                    sashPanel.glazedOut, sashPanel.sashGlazedOut,
                    sashPanel.paneType, sashPanel.isOriel,
                    sashPanel.interlockTypes, sashPanel.extendExtra, this,
                    sashPanel.selectedType);

            sashType = createSash.createSashType();
            this.wEntered = this.hEntered = false;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public int[] getDefaultSashTypeBy() {
        return sashPanel.getDefaultSashType();
    }

    public void setChangeGridMaster(int xxx, int yyy, int op, int pos,
                                    int form, Rectangle currentRect) {

        if (jobItem.design.findDLO == null) {
            jobItem.design.findDLO = new FindBiggestDLO(this);
        }

        if (currentRect != null && currentRect.width > 0
                && currentRect.height > 0) {

            jobItem.design.findDLO.initMasterChange(
                    this.jobItem.myCanvas.currentRect.x,
                    jobItem.myCanvas.currentRect.y, op, pos, form);
        } else {
            jobItem.design.findDLO.initMasterChange(xxx, yyy, op, pos, form);
        }

        gridsPanel.l2.setText("");
        if (selectedDim == 9) {
            facetUsed.reDrawTextsforRowColOp(lastRR, lastRC, lastRRo, lastRCo,
                    false, selectedDim);
        }

        this.jobItem.resetGraphics();
    }

    /**
     * Getting Selected DLO for edit Grids
     *
     * @param xxx  , Axis X Position
     * @param yyy  , Axis Y Position
     * @param op   , Option
     * @param pos  , Position
     * @param form , Form
     */
    public void getSelectedDLO(int xxx, int yyy, int op, int pos, int form) {

        // Evaluate if findDLO is not null to process to init master change
        if (this.jobItem.design.findDLO == null) {
            this.jobItem.design.findDLO = new FindBiggestDLO(this);
        }

        // Set Grid Change Panel
        this.gridsPanel.setGridChangePanel(this.jobItem.design.findDLO
                .initMasterChange(xxx, yyy, 0, pos, form), xxx, yyy);
    }

    /**
     * Setting Number to Grids to facet Used
     *
     * @param xxx  , Axis X Position
     * @param yyy  , Axis Y Position
     * @param op   , Option
     * @param pos  , Position
     * @param form , Form
     */
    public void SetNumGrids(int xxx, int yyy, int op, int pos, int form) {

        // Evaluate if findDLO is not null to process to init master change
        if (this.jobItem.design.findDLO == null) {
            this.jobItem.design.findDLO = new FindBiggestDLO(this);
        }

        this.jobItem.design.findDLO.initMasterChange(xxx, yyy, op, pos, form);

        // Setting empty string grids panel 12
        this.gridsPanel.l2.setText("");

        // Redraw text for row and cols
        if (selectedDim == 9) {
            facetUsed.reDrawTextsforRowColOp(lastRR, lastRC, lastRRo, lastRCo,
                    false, selectedDim);
        }

        // Reset drawing for facet used
        jobItem.resetGraphics();
    }

    /**
     * Setting Grids
     */
    public void setgrids() {

        if (this.jobItem.design.findDLO != null) {
            this.doSetGrid();
        } else {
            this.jobItem.design.findDLO = new FindBiggestDLO(this);
            this.doSetGrid();
        }

        this.jobItem.resetGraphics();
    }

    /**
     * Setting Grids
     */
    public void doSetGrid() {

        this.jobItem.design.findDLO.setGridInfo();
        this.jobItem.design.findDLO.getAllDLOsMid(0);

        this.gridsPanel.l2.setText("");

        if (selectedDim == 9) {
            facetUsed.reDrawTextsforRowColOp(lastRR, lastRC, lastRRo, lastRCo,
                    false, selectedDim);
        }
    }

    public void setChangeMullion() {

        try {

            boolean isNewC = false;
            boolean joinTop = false;
            boolean joinBot = false;
            Profiles mySelectedMullion = null;

            if (mullionsPanel.selectedLevel == 2) {

                Object[] frameObjects = editingMullion.myParent.myParent.myFacet.frames
                        .toArray();
                editingMullion.myParent.myParent.myFacet.frames.clear();

                boolean frameFound = false;

                for (Object F : frameObjects) {

                    AddMullionV addMullion = new AddMullionV(
                            ((Frame) F).bOpeningObject, jobItem,
                            ((Frame) F).myFacet.myFrame2, 2);

                    AddMullionH addMullionH = new AddMullionH(
                            ((Frame) F).bOpeningObject, jobItem,
                            ((Frame) F).myFacet.myFrame2, 2);

                    if (editingMullion.myParent.myParent.a_levelID == 3) {
                        if (editingMullion.myParent.myParent.a_sequenceID == ((Frame) F).bOpeningObject.myParent.a_sequenceID) {

                            if (HorV == 1) {

                                Object[] mVs = ((Frame) F).bOpeningObject.mullions
                                        .toArray();

                                ((Frame) F).bOpeningObject.mullions.clear();

                                for (Object MV : mVs) {

                                    isNewC = false;
                                    if (((Profiles) MV).profileSelected == 1) {
                                        frameFound = true;

                                        mySelectedMullion = (Profiles) MV;

                                        if (((Profiles) MV).partID != mullionsPanel.partID
                                                && mullionsPanel.part
                                                .isSelected()) {

                                            isNewC = true;
                                            ((Profiles) MV).partID = mullionsPanel.partID;
                                            ((Profiles) MV).thickness = mullionsPanel.mullionThick
                                                    / scale.doubleValue();
                                            ((Profiles) MV).partDimB = mullionsPanel.mullionThick
                                                    / scale.doubleValue();
                                            ((Profiles) MV).partDimBtoC = mullionsPanel.mullionBtoC
                                                    / scale.doubleValue();
                                            ((Profiles) MV).partDimA = mullionsPanel.mullionA
                                                    / scale.doubleValue();
                                            ((Profiles) MV).partDimC = mullionsPanel.mullionC
                                                    / scale.doubleValue();
                                        }

                                        if (mullionsPanel.endTypeLT
                                                .isSelected()
                                                && mullionsPanel.endLT > 0) {
                                            if (((Profiles) MV).endTypeLT == 2
                                                    && mullionsPanel.endLT != 2) {
                                                joinTop = true;
                                            }

                                            ((Profiles) MV).endTypeLT = mullionsPanel.endLT;
                                        }

                                        if (mullionsPanel.endTypeRB
                                                .isSelected()
                                                && mullionsPanel.endRB > 0) {
                                            if (((Profiles) MV).endTypeRB == 2
                                                    && mullionsPanel.endRB != 2) {
                                                joinBot = true;
                                            }

                                            ((Profiles) MV).endTypeRB = mullionsPanel.endRB;
                                        }

                                        if (mullionsPanel.pfFormL.isSelected()
                                                && mullionsPanel.mullionPartForm != ((Profiles) MV).partForm
                                                || mullionsPanel.offsetTL != ((Profiles) MV).offsetTL
                                                || ((Profiles) MV).offsetRB != mullionsPanel.offsetBR
                                                || ((Profiles) MV).deltaTL != mullionsPanel.deltaTL
                                                || ((Profiles) MV).deltaRB != mullionsPanel.deltaRB) {

                                            ((Profiles) MV).partForm = mullionsPanel.mullionPartForm;
                                            ((Profiles) MV).offsetTL = mullionsPanel.offsetTL;
                                            ((Profiles) MV).offsetRB = mullionsPanel.offsetBR;
                                            ((Profiles) MV).deltaTL = mullionsPanel.deltaTL;
                                            ((Profiles) MV).deltaRB = mullionsPanel.deltaRB;

                                            addMullion.newStartingYCenter = ((Profiles) MV).centerYs;
                                            addMullion.newStartingXCenter = ((Profiles) MV).centerXs
                                                    + ((Profiles) MV).offsetTL;
                                            ((Profiles) MV).centerXe = ((Profiles) MV).centerXe
                                                    + ((Profiles) MV).offsetRB;

                                        } else {
                                            addMullion.newStartingYCenter = ((Profiles) MV).centerYs;
                                            addMullion.newStartingXCenter = ((Profiles) MV).centerXs;
                                            ((Profiles) MV).centerXe = ((Profiles) MV).centerXe;
                                        }

                                        addMullion.vcEndY = ((Profiles) MV).centerYe;
                                        addMullion.vcEnd = ((Frame) F).endCol;

                                        if (currentUOM == 1) {
                                            addMullion.partDimA = ((Profiles) MV).partDimA;
                                            addMullion.partDimB = ((Profiles) MV).partDimB;
                                            addMullion.partDimC = ((Profiles) MV).partDimC;
                                            addMullion.partDimD = ((Profiles) MV).partDimD;
                                            addMullion.partDimBtoC = ((Profiles) MV).partDimBtoC;
                                        } else {
                                            addMullion.partDimA = ((Profiles) MV).partDimAi;
                                            addMullion.partDimB = ((Profiles) MV).partDimBi;
                                            addMullion.partDimC = ((Profiles) MV).partDimCi;
                                            addMullion.partDimD = ((Profiles) MV).partDimDi;
                                            addMullion.partDimBtoC = ((Profiles) MV).partDimBtoCi;
                                        }

                                        addMullion.getDimsForMullion(
                                                ((Profiles) MV).myParent.xCols,
                                                2);
                                        addMullion.getNewPositionsXY(
                                                ((Profiles) MV), isNewC, true);

                                        addMullion
                                                .verifyLimitLR(((Profiles) MV));

                                        addMullion.calcMullion = new CalculateMullionV(
                                                addMullion);
                                        addMullion.calcMullion
                                                .calculateCoord(((Profiles) MV));

                                    } else {
                                        // addMullion.newStartingYCenter
                                        // =
                                        // ((Profiles) MV).centerYs;
                                        //
                                        // addMullion.newStartingXCenter
                                        // =
                                        // ((Profiles) MV).centerXs;
                                        // addMullion.vcEndY =
                                        // ((Profiles)
                                        // MV).centerYe;
                                        // addMullion.vcEnd = ((Frame)
                                        // F).endCol;
                                        //
                                        // addMullion.getDimsForMullion(((Profiles)
                                        // MV).myParent.xCols, 2);
                                        //
                                        // addMullion.getNewPositionsXY(((Profiles)
                                        // MV), isNewC, true);
                                        //
                                        // addMullion.verifyLimitLR(((Profiles)
                                        // MV));
                                        //
                                        // addMullion.calcMullion =
                                        // new
                                        // CalculateMullionV(addMullion);
                                        //
                                        // addMullion.calcMullion.calculateCoord(((Profiles)
                                        // MV));

                                    }

                                    ((Frame) F).bOpeningObject.mullions.add(MV);
                                }

                                ((Frame) F).resetRemovedParts();

                                Object[] ops = ((Frame) F).openings.toArray();
                                ((Frame) F).openings.clear();
                                for (Object o : ops) {
                                    ((OpeningObject) o).myParent = (Frame) F;
                                    ((Frame) F).openings.add(o);
                                }

                                if (frameFound) {
                                    ((Frame) F).doOpenings();
                                }

                                addMullion.splitParts(mySelectedMullion,
                                        joinTop, joinBot);

                                if (joinBot) {
                                    ((Frame) F).resetOpeningGlazed();
                                }

                            } else if (HorV == 2) {
                                ((Frame) F).bOpeningObject.mullionObjectsH = ((Frame) F).bOpeningObject.mullionsH
                                        .toArray();
                                ((Frame) F).bOpeningObject.mullionsH.clear();

                                for (final Object MV : ((Frame) F).bOpeningObject.mullionObjectsH) {
                                    frameFound = true;
                                    if (((Profiles) MV).profileSelected == 1) {
                                        if (mullionsPanel.part.isSelected()
                                                && ((Profiles) MV).partID != mullionsPanel.partID) {
                                            ((Profiles) MV).partID = mullionsPanel.partID;
                                            ((Profiles) MV).thickness = mullionsPanel.mullionThick
                                                    / scale.doubleValue();
                                            ((Profiles) MV).partDimB = mullionsPanel.mullionThick
                                                    / scale.doubleValue();
                                            ((Profiles) MV).partDimBtoC = mullionsPanel.mullionBtoC
                                                    / scale.doubleValue();
                                            ((Profiles) MV).partDimA = mullionsPanel.mullionA
                                                    / scale.doubleValue();
                                            ((Profiles) MV).partDimC = mullionsPanel.mullionC
                                                    / scale.doubleValue();
                                        }

                                        if (mullionsPanel.endTypeLT
                                                .isSelected()
                                                && mullionsPanel.endLT > 0) {
                                            ((Profiles) MV).endTypeLT = mullionsPanel.endLT;
                                        }

                                        if (mullionsPanel.endTypeRB
                                                .isSelected()
                                                && mullionsPanel.endRB > 0) {
                                            ((Profiles) MV).endTypeRB = mullionsPanel.endRB;
                                        }

                                        if (mullionsPanel.pfFormL.isSelected()
                                                && mullionsPanel.mullionPartForm != ((Profiles) MV).partForm
                                                || mullionsPanel.offsetTL != ((Profiles) MV).offsetTL
                                                || ((Profiles) MV).offsetRB != mullionsPanel.offsetBR
                                                || ((Profiles) MV).deltaTL != mullionsPanel.deltaTL
                                                || ((Profiles) MV).deltaRB != mullionsPanel.deltaRB) {

                                            ((Profiles) MV).partForm = mullionsPanel.mullionPartForm;
                                            ((Profiles) MV).offsetTL = mullionsPanel.offsetTL;
                                            ((Profiles) MV).offsetRB = mullionsPanel.offsetBR;
                                            ((Profiles) MV).deltaTL = mullionsPanel.deltaTL;
                                            ((Profiles) MV).deltaRB = mullionsPanel.deltaRB;

                                            addMullionH.newStartingYCenter = ((Profiles) MV).centerYs
                                                    + ((Profiles) MV).offsetTL;
                                            ((Profiles) MV).centerYe = ((Profiles) MV).centerYe
                                                    + ((Profiles) MV).offsetRB;
                                        } else {
                                            addMullionH.newStartingYCenter = ((Profiles) MV).centerYs;
                                            ((Profiles) MV).centerYe = ((Profiles) MV).centerYe;
                                        }

                                        addMullionH.hcStartX = ((Profiles) MV).centerXs;
                                        addMullionH.hcEnd = ((Frame) F).endCol;

                                        if (currentUOM == 1) {
                                            addMullion.partDimA = ((Profiles) MV).partDimA;
                                            addMullion.partDimB = ((Profiles) MV).partDimB;
                                            addMullion.partDimC = ((Profiles) MV).partDimC;
                                            addMullion.partDimD = ((Profiles) MV).partDimD;
                                            addMullion.partDimBtoC = ((Profiles) MV).partDimBtoC;
                                        } else {
                                            addMullion.partDimA = ((Profiles) MV).partDimAi;
                                            addMullion.partDimB = ((Profiles) MV).partDimBi;
                                            addMullion.partDimC = ((Profiles) MV).partDimCi;
                                            addMullion.partDimD = ((Profiles) MV).partDimDi;
                                            addMullion.partDimBtoC = ((Profiles) MV).partDimBtoCi;
                                        }

                                        addMullionH.getDimsForMullion(0, 0);
                                        addMullionH.getPointsXY(
                                                ((Profiles) MV), isNewC, true);
                                        addMullionH
                                                .verifyLimitLR(((Profiles) MV));

                                        addMullionH.calcMullion = new CalculateMullionHii(
                                                addMullionH);
                                        addMullionH.calcMullion
                                                .calculateCoord(((Profiles) MV));

                                    } else {
                                        // addMullionH.newStartingYCenter
                                        // =
                                        // ((Profiles)
                                        // MV).centerYs;

                                    }

                                    ((Frame) F).bOpeningObject.mullionsH
                                            .add(MV);

                                    Object[] ops = ((Frame) F).openings
                                            .toArray();
                                    ((Frame) F).openings.clear();

                                    for (Object o : ops) {
                                        ((OpeningObject) o).myParent = (Frame) F;
                                        ((Frame) F).openings.add(o);
                                    }

                                    if (frameFound) {
                                        ((Frame) F).doOpenings();
                                    }

                                }
                            }
                            if (((Frame) F).glazedOut) {
                                ((Frame) F).doGPParts(true);
                            } else {
                                ((Frame) F).doGPParts(false);
                            }

                            ((Frame) F).bOpeningObject.mullionObjectsV = ((Frame) F).bOpeningObject.mullions
                                    .toArray();
                            ((Frame) F).bOpeningObject.mullionObjectsH = ((Frame) F).bOpeningObject.mullionsH
                                    .toArray();

                            Object[] openingObjects = ((Frame) F).openings
                                    .toArray();

                        }

                    } else {

                        Object[] openings = ((Frame) F).openings.toArray();
                        Object[] leafs = null;

                        for (final Object O : openings) {

                            if (((OpeningObject) O).sashObjectIn != null
                                    && editingMullion.whichPos == 1) {
                                leafs = ((OpeningObject) O).sashObjectIn.frames
                                        .toArray();
                            }
                            if (((OpeningObject) O).sashObjectMid != null
                                    && editingMullion.whichPos == 2) {
                                leafs = ((OpeningObject) O).sashObjectMid.frames
                                        .toArray();

                            }// Mid Sash

                            if (((OpeningObject) O).sashObjectOut != null
                                    && editingMullion.whichPos == 3) {
                                leafs = ((OpeningObject) O).sashObjectOut.frames
                                        .toArray();

                            }// Out Sash

                            if (leafs != null) {
                                for (final Object S : leafs) {
                                    addMullion = new AddMullionV(
                                            ((SashLeaf) S).bOpeningObject,
                                            jobItem,
                                            ((Frame) F).myFacet.myFrame2, 2);
                                    addMullionH = new AddMullionH(
                                            ((SashLeaf) S).bOpeningObject,
                                            jobItem,
                                            ((Frame) F).myFacet.myFrame2, 2);

                                    if (HorV == 1) {
                                        Object[] MVs = ((SashLeaf) S).bOpeningObject.mullions
                                                .toArray();
                                        ((SashLeaf) S).bOpeningObject.mullions
                                                .clear();

                                        for (Object MV : MVs) {

                                            if (((Profiles) MV).profileSelected == 1) {
                                                mySelectedMullion = (Profiles) MV;
                                                if (((Profiles) MV).partID != mullionsPanel.partID
                                                        && mullionsPanel.part
                                                        .isSelected()) {
                                                    ((Profiles) MV).partID = mullionsPanel.partID;
                                                    ((Profiles) MV).thickness = mullionsPanel.mullionThick
                                                            / scale.doubleValue();
                                                    ((Profiles) MV).partDimB = mullionsPanel.mullionThick
                                                            / scale.doubleValue();
                                                    ((Profiles) MV).partDimBtoC = mullionsPanel.mullionBtoC
                                                            / scale.doubleValue();
                                                    ((Profiles) MV).partDimA = mullionsPanel.mullionA
                                                            / scale.doubleValue();
                                                    ((Profiles) MV).partDimC = mullionsPanel.mullionC
                                                            / scale.doubleValue();
                                                }

                                                if (mullionsPanel.endTypeLT
                                                        .isSelected()
                                                        && mullionsPanel.endLT > 0) {
                                                    if (((Profiles) MV).endTypeLT == 2
                                                            && mullionsPanel.endLT != 2) {
                                                        joinTop = true;
                                                    }
                                                    ((Profiles) MV).endTypeLT = mullionsPanel.endLT;
                                                }

                                                if (mullionsPanel.endTypeRB
                                                        .isSelected()
                                                        && mullionsPanel.endRB > 0) {
                                                    if (((Profiles) MV).endTypeRB == 2
                                                            && mullionsPanel.endRB != 2) {
                                                        joinBot = true;
                                                    }

                                                    ((Profiles) MV).endTypeRB = mullionsPanel.endRB;
                                                }

                                                if (mullionsPanel.pfFormL
                                                        .isSelected()
                                                        && mullionsPanel.mullionPartForm != ((Profiles) MV).partForm
                                                        || mullionsPanel.offsetTL != ((Profiles) MV).offsetTL
                                                        || ((Profiles) MV).offsetRB != mullionsPanel.offsetBR
                                                        || ((Profiles) MV).deltaTL != mullionsPanel.deltaTL
                                                        || ((Profiles) MV).deltaRB != mullionsPanel.deltaRB) {

                                                    ((Profiles) MV).partForm = mullionsPanel.mullionPartForm;
                                                    ((Profiles) MV).offsetTL = mullionsPanel.offsetTL;
                                                    ((Profiles) MV).offsetRB = mullionsPanel.offsetBR;
                                                    ((Profiles) MV).deltaTL = mullionsPanel.deltaTL;
                                                    ((Profiles) MV).deltaRB = mullionsPanel.deltaRB;

                                                    addMullion.newStartingYCenter = ((Profiles) MV).centerYs;
                                                    addMullion.newStartingXCenter = ((Profiles) MV).centerXs
                                                            + ((Profiles) MV).offsetTL;
                                                    ((Profiles) MV).centerXe = ((Profiles) MV).centerXe
                                                            + ((Profiles) MV).offsetRB;

                                                } else {
                                                    addMullion.newStartingYCenter = ((Profiles) MV).centerYs;
                                                    addMullion.newStartingXCenter = ((Profiles) MV).centerXs;
                                                    ((Profiles) MV).centerXe = ((Profiles) MV).centerXe;
                                                }

                                            } else {
                                                addMullion.newStartingYCenter = ((Profiles) MV).centerYs;
                                                addMullion.newStartingXCenter = ((Profiles) MV).centerXs;
                                            }

                                            addMullion.vcEndY = ((Profiles) MV).centerYe;
                                            addMullion.vcEnd = ((Frame) F).endCol;

                                            addMullion
                                                    .getDimsForMullion(
                                                            ((Profiles) MV).myParent.xCols,
                                                            2);

                                            addMullion.getNewPositionsXY(
                                                    ((Profiles) MV), isNewC,
                                                    true);

                                            addMullion
                                                    .verifyLimitLR(((Profiles) MV));

                                            addMullion.calcMullion = new CalculateMullionV(
                                                    addMullion);
                                            addMullion.calcMullion
                                                    .calculateCoord(((Profiles) MV));

                                            ((SashLeaf) S).bOpeningObject.mullions
                                                    .add(MV);
                                        }

                                    } else {
                                        final Object[] MVs = ((SashLeaf) S).bOpeningObject.mullionsH
                                                .toArray();
                                        ((SashLeaf) S).bOpeningObject.mullionsH
                                                .clear();

                                        for (final Object MV : MVs) {

                                            if (((Profiles) MV).profileSelected == 1) {

                                                if (mullionsPanel.part
                                                        .isSelected()
                                                        && ((Profiles) MV).partID != mullionsPanel.partID) {
                                                    ((Profiles) MV).partID = mullionsPanel.partID;
                                                    ((Profiles) MV).thickness = mullionsPanel.mullionThick
                                                            / scale.doubleValue();
                                                    ((Profiles) MV).partDimB = mullionsPanel.mullionThick
                                                            / scale.doubleValue();
                                                    ((Profiles) MV).partDimBtoC = mullionsPanel.mullionBtoC
                                                            / scale.doubleValue();
                                                    ((Profiles) MV).partDimA = mullionsPanel.mullionA
                                                            / scale.doubleValue();
                                                    ((Profiles) MV).partDimC = mullionsPanel.mullionC
                                                            / scale.doubleValue();
                                                }

                                                if (mullionsPanel.endTypeLT
                                                        .isSelected()
                                                        && mullionsPanel.endLT > 0) {
                                                    ((Profiles) MV).endTypeLT = mullionsPanel.endLT;
                                                }

                                                if (mullionsPanel.endTypeRB
                                                        .isSelected()
                                                        && mullionsPanel.endRB > 0) {
                                                    ((Profiles) MV).endTypeRB = mullionsPanel.endRB;
                                                }

                                                if (mullionsPanel.pfFormL
                                                        .isSelected()
                                                        && mullionsPanel.mullionPartForm != ((Profiles) MV).partForm
                                                        || mullionsPanel.offsetTL != ((Profiles) MV).offsetTL
                                                        || ((Profiles) MV).offsetRB != mullionsPanel.offsetBR
                                                        || ((Profiles) MV).deltaTL != mullionsPanel.deltaTL
                                                        || ((Profiles) MV).deltaRB != mullionsPanel.deltaRB) {

                                                    ((Profiles) MV).partForm = mullionsPanel.mullionPartForm;
                                                    ((Profiles) MV).offsetTL = mullionsPanel.offsetTL;
                                                    ((Profiles) MV).offsetRB = mullionsPanel.offsetBR;
                                                    ((Profiles) MV).deltaTL = mullionsPanel.deltaTL;
                                                    ((Profiles) MV).deltaRB = mullionsPanel.deltaRB;

                                                    addMullionH.newStartingYCenter = ((Profiles) MV).centerYs
                                                            + ((Profiles) MV).offsetTL;
                                                    ((Profiles) MV).centerYe = ((Profiles) MV).centerYe
                                                            + ((Profiles) MV).offsetRB;
                                                } else {
                                                    addMullionH.newStartingYCenter = ((Profiles) MV).centerYs;
                                                    ((Profiles) MV).centerYe = ((Profiles) MV).centerYe;
                                                }

                                            } else {
                                                addMullionH.newStartingYCenter = ((Profiles) MV).centerYs;
                                            }

                                            addMullionH.hcStartX = ((Profiles) MV).centerXs;
                                            addMullionH.hcEnd = ((Frame) F).endCol;

                                            addMullionH.getDimsForMullion(0, 0);
                                            addMullionH.getPointsXY(
                                                    ((Profiles) MV), isNewC,
                                                    true);
                                            addMullionH
                                                    .verifyLimitLR(((Profiles) MV));

                                            addMullionH.calcMullion = new CalculateMullionHii(
                                                    addMullionH);

                                            addMullionH.calcMullion
                                                    .calculateCoord(((Profiles) MV));
                                            ((SashLeaf) S).bOpeningObject.mullionsH
                                                    .add(MV);
                                        }
                                    }

                                    ((SashLeaf) S).bOpeningObject.mullionObjectsV = ((SashLeaf) S).bOpeningObject.mullions
                                            .toArray();
                                    ((SashLeaf) S).bOpeningObject.mullionObjectsH = ((SashLeaf) S).bOpeningObject.mullionsH
                                            .toArray();

                                    ((SashLeaf) S).bOpeningObject = ((SashLeaf) S)
                                            .doMullions(((SashLeaf) S).bOpeningObject);

                                }
                            }
                        }
                    }

                    addMullion.recalcHCCoords();
                    addMullionH.recalcVCCoords();
                    addMullion.reOrderVNotches();
                    addMullionH.reOrderHMNotches();

                    ((Facet) facetUsed).reDrawRadioRowCol(
                            ((Facet) facetUsed).yRows,
                            ((Facet) facetUsed).xCols, selectedDim, lastRR,
                            lastRC, facetUsed);

                    if (selectedDim <= 2) {
                        ((Facet) facetUsed).reDrawTextsforRowCol(lastRR,
                                lastRC, false, facetUsed);
                    } else if (selectedDim == 3 || selectedDim == 4) {
                        ((Facet) facetUsed).reDrawTextsforRowColOp(lastRR,
                                lastRC, lastRRo, lastRCo, false, selectedDim);
                    }

                    editingMullion.myParent.myParent.myFacet.frames.add(F);
                }

            } else if (mullionsPanel.selectedLevel == 1) {

            } else if (mullionsPanel.selectedLevel == 3) {

            }

            mullionsPanel.edit.setSelected(false);

            editCM = false;
            mullionsPanel.vC.setEnabled(true);
            mullionsPanel.hC.setEnabled(true);
            mullionsPanel.couplerTypeC.setEnabled(true);

            clearCMAlignEdit();

            mullionsPanel.setEditVisible(false, null);
            jobItem.resetGraphics();

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doEditRemoveSashProfiles(final Object S) {

        try {
            if (editor.editFrame) {
                ((ShapeObject) S).modifyParts();
            } else if (editor.removeFrame) {
                this.doRemovePartError();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doRemovePartError() {
        JOptionPane.showMessageDialog(null,
                "Removing Sash parts is not allowed",
                "Invalid Operation - Error!", JOptionPane.ERROR_MESSAGE);
    }

    public void setChangeProfileFacet(final Profiles p) {

        try {

            final Object[] facets = jobItem.design.frames.toArray();

            jobItem.design.frames.clear();

            for (Object facet : facets) {
                if (((Facet) facet).a_sequenceID == this.facetUsed.a_sequenceID) {
                    ((Facet) facet).newPart = false;
                    if (editor.editFrame) {
                        facet = ((Facet) facet).modifyFacetParts((Facet) facet);
                    } else if (editor.removeFrame) {
                        facet = ((Facet) facet).removeFramePart();
                    }

                }

                jobItem.design.frames.add(facet);

                jobItem.design.doFacets(true, true, true, false);
                jobItem.design.drawFacets();

            }

            resetParts = false;
            doFacetRadioClick();
            jobItem.myCanvas.validate();
            jobItem.myCanvas.repaint();

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setChangeProfileFrame(final Profiles p, final ShapeObject f) {

        try {

            resetParts = false;
            final Object[] fo = ((Facet) facetUsed).frames.toArray();
            ((Facet) facetUsed).frames.clear();

            for (final Object F : fo) {
                ((Frame) F).newPart = false;
                ((Facet) facetUsed).frames.add(F);

            }// for Frames

            final Object[] frames = ((Facet) facetUsed).frames.toArray();

            for (final Object F : frames) {
                if (editor.selectedEditLevel == 1) {
                    if (f.equals(F)) {
                        if (editor.editFrame) {
                            ((Frame) F).modifyParts();
                        } else if (editor.removeFrame) {
                            ((Frame) F).removeFramePart();

                        }
                    }
                }

            }
            jobItem.myCanvas.validate();
            jobItem.myCanvas.repaint();

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setChangeProfileSubFrame(final Profiles p, final ShapeObject f) {

        try {

            resetParts = false;
            final Object[] fo = ((Facet) facetUsed).frames.toArray();

            for (final Object F : fo) {
                final Object[] openings = ((ShapeObject) F).openings.toArray();
                final Object[] leafs = null;

                for (final Object O : openings) {
                    if (((OpeningObject) O).subFacet != null) {
                        final Object[] sfo = ((OpeningObject) O).subFacet.frames
                                .toArray();
                        ((OpeningObject) O).subFacet.frames.clear();
                        for (final Object sF : sfo) {

                            ((Frame) sF).newPart = false;
                            ((OpeningObject) O).subFacet.frames.add(sF);
                        }

                    }

                }
            }// for Frames

            final Object[] frames = ((Facet) facetUsed).frames.toArray();

            for (final Object F : frames) {

                final Object[] openings = ((ShapeObject) F).openings.toArray();
                final Object[] leafs = null;

                for (final Object O : openings) {
                    if (((OpeningObject) O).subFacet != null) {
                        facetUsed = ((OpeningObject) O).subFacet;

                        final Object[] sfo = facetUsed.frames.toArray();

                        for (final Object sF : sfo) {
                            if (editor.editFrame) {
                                ((Frame) sF).modifyParts();
                            } else if (editor.removeFrame) {
                                ((Frame) sF).removeFramePart();
                            }
                        }// For SubFrame
                        // Frames

                    }

                }
            }
            jobItem.myCanvas.validate();
            jobItem.myCanvas.repaint();

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setChangeProfileSash(final Profiles p, final ShapeObject f) {

        resetParts = false;
        final Object[] fo = ((Facet) facetUsed).frames.toArray();

        for (final Object F : fo) {
            final Object[] openings = ((ShapeObject) F).openings.toArray();
            Object[] leafs = null;

            for (final Object O : openings) {

                if (((OpeningObject) O).sashObjectIn != null) {
                    leafs = ((OpeningObject) O).sashObjectIn.frames.toArray();
                    ((OpeningObject) O).sashObjectIn.frames.clear();
                    for (final Object S : leafs) {
                        if (f.equals(S)) {
                            ((ShapeObject) S).newPart = false;
                        }
                        ((OpeningObject) O).sashObjectIn.frames.add(S);
                    }// In Sash
                }

                if (((OpeningObject) O).sashObjectMid != null) {
                    leafs = ((OpeningObject) O).sashObjectMid.frames.toArray();
                    ((OpeningObject) O).sashObjectMid.frames.clear();
                    for (final Object S : leafs) {
                        if (f.equals(S)) {
                            ((ShapeObject) S).newPart = false;
                        }
                        ((OpeningObject) O).sashObjectMid.frames.add(S);
                    }

                }// Mid Sash

                if (((OpeningObject) O).sashObjectOut != null) {
                    leafs = ((OpeningObject) O).sashObjectOut.frames.toArray();
                    ((OpeningObject) O).sashObjectOut.frames.clear();
                    for (final Object S : leafs) {
                        if (f.equals(S)) {
                            ((ShapeObject) S).newPart = false;
                        }
                        ((OpeningObject) O).sashObjectOut.frames.add(S);
                    }
                }
            }

        }// for Frames

        final Object[] frames = ((Facet) facetUsed).frames.toArray();

        for (final Object F : frames) {

            final Object[] openings = ((ShapeObject) F).openings.toArray();
            Object[] leafs = null;

            for (final Object O : openings) {

                if (((OpeningObject) O).sashObjectIn != null) {
                    leafs = ((OpeningObject) O).sashObjectIn.frames.toArray();

                    for (final Object S : leafs) {
                        if (f.equals(S)) {
                            doEditRemoveSashProfiles(S);
                        }

                    }// In
                    // Sash
                }

                if (((OpeningObject) O).sashObjectMid != null) {
                    leafs = ((OpeningObject) O).sashObjectMid.frames.toArray();

                    for (final Object S : leafs) {
                        if (f.equals(S)) {
                            doEditRemoveSashProfiles(S);
                        }
                    }

                }// Mid Sash

                if (((OpeningObject) O).sashObjectOut != null) {
                    leafs = ((OpeningObject) O).sashObjectOut.frames.toArray();

                    for (final Object S : leafs) {
                        if (f.equals(S)) {
                            doEditRemoveSashProfiles(S);
                        }
                    }

                }

            }

        }
        jobItem.myCanvas.validate();
        jobItem.myCanvas.repaint();

    }

    public void setChangeProfileSubSash(final Profiles p, final ShapeObject f) {

        resetParts = false;
        final Object[] fo = ((Facet) facetUsed).frames.toArray();

        for (final Object F : fo) {
            final Object[] openings = ((ShapeObject) F).openings.toArray();
            final Object[] leafs = null;

            for (final Object O : openings) {
                if (((OpeningObject) O).subFacet != null) {
                    final Object[] sfo = ((OpeningObject) O).subFacet.frames
                            .toArray();

                    for (final Object sF : sfo) {
                        final Object[] openingsS = ((ShapeObject) sF).openings
                                .toArray();

                        Object[] leafsS = null;

                        for (final Object sO : openingsS) {

                            if (((OpeningObject) sO).sashObjectIn != null) {
                                leafsS = ((OpeningObject) sO).sashObjectIn.frames
                                        .toArray();
                                ((OpeningObject) sO).sashObjectIn.frames
                                        .clear();
                                for (final Object S : leafsS) {
                                    if (f.equals(S)) {
                                        ((ShapeObject) S).newPart = false;
                                    }
                                    ((OpeningObject) sO).sashObjectIn.frames
                                            .add(S);
                                }// In
                                // Sash
                            }

                            if (((OpeningObject) sO).sashObjectMid != null) {
                                leafsS = ((OpeningObject) sO).sashObjectMid.frames
                                        .toArray();
                                ((OpeningObject) sO).sashObjectMid.frames
                                        .clear();
                                for (final Object S : leafsS) {
                                    if (f.equals(S)) {
                                        ((ShapeObject) S).newPart = false;
                                    }
                                    ((OpeningObject) sO).sashObjectMid.frames
                                            .add(S);
                                }

                            }// Mid
                            // Sash

                            if (((OpeningObject) sO).sashObjectOut != null) {
                                leafsS = ((OpeningObject) sO).sashObjectOut.frames
                                        .toArray();
                                ((OpeningObject) sO).sashObjectOut.frames
                                        .clear();
                                for (final Object S : leafsS) {
                                    if (f.equals(S)) {
                                        ((ShapeObject) S).newPart = false;
                                    }
                                    ((OpeningObject) sO).sashObjectOut.frames
                                            .add(S);
                                }

                            }

                        }

                    }

                }

            }

        }// for Frames

        final Object[] frames = ((Facet) facetUsed).frames.toArray();

        for (final Object F : frames) {
            final Object[] openings = ((ShapeObject) F).openings.toArray();
            final Object[] leafs = null;

            for (final Object O : openings) {
                if (((OpeningObject) O).subFacet != null) {
                    facetUsed = ((OpeningObject) O).subFacet;

                    final Object[] sfo = facetUsed.frames.toArray();

                    for (final Object sF : sfo) {
                        final Object[] openingsS = ((ShapeObject) sF).openings
                                .toArray();

                        Object[] leafsS = null;

                        for (final Object sO : openingsS) {

                            if (((OpeningObject) sO).sashObjectIn != null) {
                                leafsS = ((OpeningObject) sO).sashObjectIn.frames
                                        .toArray();

                                for (final Object S : leafsS) {
                                    if (f.equals(S)) {
                                        doEditRemoveSashProfiles(S);
                                    }

                                }// In
                                // Sash
                            }

                            if (((OpeningObject) sO).sashObjectMid != null) {
                                leafsS = ((OpeningObject) sO).sashObjectMid.frames
                                        .toArray();

                                for (final Object S : leafsS) {
                                    if (f.equals(S)) {
                                        doEditRemoveSashProfiles(S);
                                    }

                                }

                            }// Mid
                            // Sash

                            if (((OpeningObject) sO).sashObjectOut != null) {
                                leafsS = ((OpeningObject) sO).sashObjectOut.frames
                                        .toArray();

                                for (final Object S : leafsS) {
                                    if (f.equals(S)) {
                                        doEditRemoveSashProfiles(S);
                                    }

                                }

                            }

                        }

                    }// For SubFrame
                    // Frames

                }

            }

        }
        jobItem.myCanvas.validate();
        jobItem.myCanvas.repaint();

    }

    public void doActions(boolean sameFrame, ShapeObject slave, ShapeObject master) {

        try {

            if (alignV) {

                if (((Profiles) mySlave).cOrM <= 2) {
                    alignPerformed = slave.modifyVMullion((Profiles) mySlave,
                            myMaster, myMasterType, masterAboveLeft, sameFrame);
                } else if (((Profiles) mySlave).cOrM >= 3
                        && ((Profiles) mySlave).cOrM <= 6) {

                    final double newX = ((Profiles) myMaster).centerXs;

                    ((SashTypeObject) slave).split = (newX - slave.startingX)
                            / slave.widthPix * 100;

                    final CreateSash createSash = //
                            new CreateSash(((SashTypeObject) slave).myParentO,
                                    ((SashTypeObject) slave).sashClassType,
                                    ((SashTypeObject) slave).userDefinedOpeningID,
                                    ((SashTypeObject) slave).noOfLeafs,
                                    ((SashTypeObject) slave).noTracks,
                                    ((SashTypeObject) slave).sashOnTrack,
                                    ((SashTypeObject) slave).whichPos,
                                    ((SashTypeObject) slave).split,
                                    ((SashTypeObject) slave).opens, null,
                                    ((SashTypeObject) slave).glazedOut,
                                    ((SashTypeObject) slave).sashGlazedOut,
                                    ((SashTypeObject) slave).paneType,
                                    ((SashTypeObject) slave).isOriel,
                                    ((SashTypeObject) slave).interLocks,
                                    ((SashTypeObject) slave).extraExtend, this,
                                    ((SashTypeObject) slave).openingTypeClass);

                    final OpeningObject mynewOpening = createSash.doNewSash(
                            ((SashTypeObject) slave), false, null);

                    final Object[] mFOpen = ((SashTypeObject) slave).myParentO.myParent.openings
                            .toArray();
                    ((SashTypeObject) slave).myParentO.myParent.openings
                            .clear();
                    for (final Object o : mFOpen) {
                        if (((OpeningObject) o).a_sequenceID == ((SashTypeObject) slave).myParentO.a_sequenceID) {
                            ((SashTypeObject) slave).myParentO.myParent.openings
                                    .add(mynewOpening);
                        } else {
                            ((SashTypeObject) slave).myParentO.myParent.openings
                                    .add(o);
                        }
                    }

                    this.resetAlign();
                    this.hideAlign();
                    jobItem.resetGraphics();
                } else if (((Profiles) mySlave).cOrM == 7) {
                    jobItem.design.findDLO.changeVGridPos(
                            ((Profiles) myMaster).centerXs,
                            ((Profiles) mySlave), 2);

                    this.resetAlign();
                    this.hideAlign();

                    jobItem.resetGraphics();
                }
            } else if (alignH) {

                if (((Profiles) mySlave).cOrM <= 2) {
                    alignHPerformed = slave.modifyHMullion((Profiles) mySlave,
                            myMaster, myMasterType, masterAboveLeft, sameFrame);
                } else if (((Profiles) mySlave).cOrM >= 3
                        && ((Profiles) mySlave).cOrM <= 6) {
                    final double newX = ((Profiles) myMaster).centerYs;

                    ((SashTypeObject) slave).split = (newX - slave.highestY)
                            / slave.heightPix * 100;

                    final CreateSash createSash = //
                            new CreateSash(((SashTypeObject) slave).myParentO,
                                    ((SashTypeObject) slave).sashClassType,
                                    ((SashTypeObject) slave).userDefinedOpeningID,
                                    ((SashTypeObject) slave).noOfLeafs,
                                    ((SashTypeObject) slave).noTracks,
                                    ((SashTypeObject) slave).sashOnTrack,
                                    ((SashTypeObject) slave).whichPos,
                                    ((SashTypeObject) slave).split,
                                    ((SashTypeObject) slave).opens, null,
                                    ((SashTypeObject) slave).glazedOut,
                                    ((SashTypeObject) slave).sashGlazedOut,
                                    ((SashTypeObject) slave).paneType,
                                    ((SashTypeObject) slave).isOriel,
                                    ((SashTypeObject) slave).interLocks,
                                    ((SashTypeObject) slave).extraExtend, this,
                                    ((SashTypeObject) slave).openingTypeClass);

                    final OpeningObject mynewOpening = createSash.doNewSash(
                            ((SashTypeObject) slave), false, null);

                    final Object[] mFOpen = ((SashTypeObject) slave).myParentO.myParent.openings
                            .toArray();
                    ((SashTypeObject) slave).myParentO.myParent.openings
                            .clear();
                    for (final Object o : mFOpen) {
                        if (((OpeningObject) o).a_sequenceID == ((SashTypeObject) slave).myParentO.a_sequenceID) {
                            ((SashTypeObject) slave).myParentO.myParent.openings
                                    .add(mynewOpening);
                        } else {
                            ((SashTypeObject) slave).myParentO.myParent.openings
                                    .add(o);
                        }
                    }

                    this.resetAlign();
                    this.hideAlign();
                } else if (((Profiles) mySlave).cOrM == 7) {
                    jobItem.design.findDLO.changeHGridPos(
                            ((Profiles) myMaster).centerYs,
                            ((Profiles) mySlave), 2);

                    this.resetAlign();
                    this.hideAlign();

                }
                jobItem.resetGraphics();
            } else if (extendCM) {

                extendPerformed = true;
                master.extendMullions((Profiles) myMaster, (Profiles) mySlave,
                        ((Profiles) myMaster).orientation);
            }

            if (jobItem.design.findDLO != null && hasGrids) {
                jobItem.design.findDLO.resetSelectedGrids(gridsPanel.whichPos);
                this.dimAction();
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setMullionUnselected() {

        for (final Object CV : ((Facet) facetUsed).bOpeningObject.mullionObjectsV) {
            if (((Profiles) CV).profileSelected == 2) {
                ((Profiles) CV).profileSelected = 0;
            }
            ((Facet) facetUsed).bOpeningObject.mullions.add(CV);
        }

        for (final Object CH : ((Facet) facetUsed).bOpeningObject.mullionObjectsH) {
            if (((Profiles) CH).profileSelected == 2) {
                ((Profiles) CH).profileSelected = 0;
            }
            ((Facet) facetUsed).bOpeningObject.mullionsH.add(CH);
        }
        final Object[] frameObjects = ((Facet) facetUsed).frames.toArray();
        for (final Object F : frameObjects) {
            ((Frame) F).bOpeningObject.mullionObjectsV = ((Frame) F).bOpeningObject.mullions
                    .toArray();
            ((Frame) F).bOpeningObject.mullions.clear();

            ((Frame) F).bOpeningObject.mullionObjectsH = ((Frame) F).bOpeningObject.mullionsH
                    .toArray();
            ((Frame) F).bOpeningObject.mullionsH.clear();

            for (final Object MV : ((Frame) F).bOpeningObject.mullionObjectsV) {
                if (((Profiles) MV).profileSelected == 2) {
                    ((Profiles) MV).profileSelected = 0;
                }

                ((Frame) F).bOpeningObject.mullions.add(MV);
            }

            for (final Object MH : ((Frame) F).bOpeningObject.mullionObjectsH) {
                if (((Profiles) MH).profileSelected == 2) {
                    ((Profiles) MH).profileSelected = 0;
                }

                ((Frame) F).bOpeningObject.mullionsH.add(MH);
            }
        }
    }

    public void hideAlign() {
        dim.guidePanel.setVisible(false);
    }

    public void resetAlign() {

        alignH = false;
        alignV = false;

        myMaster = null;
        mySlave = null;
        myMasterType = 0;
        mySlaveType = 0;
        jobItem.myCanvas.masterFound = false;
        foundPotential = false;
        alignClicks = 0;
        dim.alignVert.setEnabled(true);
        dim.alignHorz.setEnabled(true);
        dim.masterSelected.setSelected(false);
        dim.slaveSelected.setSelected(false);
        mullionsPanel.hideExtend();
        mullionsPanel.editEnabled(true);
        extendCM = false;
        editCM = false;
    }

    public void clearCMAlignEdit() {

        editCM = false;
        this.alignH = false;
        this.alignV = false;
        this.extendCM = false;

        Object[] facets = jobItem.design.frames.toArray();

        jobItem.design.frames.clear();

        for (Object facet : facets) {

            final Object[] parts = ((Facet) facet).partObjects.toArray();
            ((Facet) facet).partObjects.clear();
            for (final Object P : parts) {
                ((Profiles) P).profileSelected = 0;
                ((Facet) facet).partObjects.add(P);
            }

            final Object[] mVsFacet = ((Facet) facet).bOpeningObject.mullions
                    .toArray();
            ((Facet) facet).bOpeningObject.mullions.clear();
            for (final Object CV : mVsFacet) {
                ((Profiles) CV).profileSelected = 0;
                ((Profiles) CV).potentialS = false;
                ((Facet) facet).bOpeningObject.mullions.add(CV);

            }

            final Object[] mHsFacet = ((Facet) facet).bOpeningObject.mullionsH
                    .toArray();

            ((Facet) facet).bOpeningObject.mullionsH.clear();

            for (final Object CH : mHsFacet) {
                ((Profiles) CH).profileSelected = 0;
                ((Profiles) CH).potentialS = false;
                ((Facet) facet).bOpeningObject.mullionsH.add(CH);

            }

            facet = resetMCinAllLevels((Facet) facet);

            jobItem.design.frames.add(facet);
        }

        if (jobItem.design.findDLO != null) {
            jobItem.design.findDLO.resetSelectedGrids(gridsPanel.whichPos);
        }

        this.resetActive();
    }

    public Facet resetMCinAllLevels(final Facet myFacet) {

        final Object[] frameObjects = myFacet.frames.toArray();

        myFacet.frames.clear();

        for (final Object F : frameObjects) {
            ((ShapeObject) F).bOpeningObject.mullionObjectsV = ((ShapeObject) F).bOpeningObject.mullions
                    .toArray();
            ((ShapeObject) F).bOpeningObject.mullions.clear();

            ((ShapeObject) F).bOpeningObject.mullionObjectsH = ((ShapeObject) F).bOpeningObject.mullionsH
                    .toArray();
            ((ShapeObject) F).bOpeningObject.mullionsH.clear();

            final Object[] parts = ((ShapeObject) F).partObjects.toArray();
            ((ShapeObject) F).partObjects.clear();

            for (final Object MV : ((ShapeObject) F).bOpeningObject.mullionObjectsV) {
                ((Profiles) MV).profileSelected = 0;
                ((Profiles) MV).potentialS = false;
                ((ShapeObject) F).bOpeningObject.mullions.add(MV);
            }

            for (final Object MH : ((ShapeObject) F).bOpeningObject.mullionObjectsH) {
                ((Profiles) MH).profileSelected = 0;
                ((Profiles) MH).potentialS = false;
                ((ShapeObject) F).bOpeningObject.mullionsH.add(MH);
            }

            for (final Object P : parts) {
                ((Profiles) P).profileSelected = 0;
                ((ShapeObject) F).partObjects.add(P);
            }

            for (final Object F2 : frameObjects) {

                final Object[] openings = ((ShapeObject) F2).openings.toArray();
                Object[] leafs = null;

                for (final Object O : openings) {

                    if (((OpeningObject) O).sashObjectIn != null) {
                        if (((OpeningObject) O).sashObjectIn.bOpeningObject != null) {
                            this.resetSashInterlocks(((OpeningObject) O).sashObjectIn.bOpeningObject);
                        }
                        leafs = ((OpeningObject) O).sashObjectIn.frames
                                .toArray();
                        this.resetSashMullionsV(leafs);
                        this.resetSashMullionsH(leafs);

                    }// In Sash
                    if (((OpeningObject) O).sashObjectMid != null) {
                        if (((OpeningObject) O).sashObjectMid.bOpeningObject != null) {
                            this.resetSashInterlocks(((OpeningObject) O).sashObjectMid.bOpeningObject);
                        }
                        leafs = ((OpeningObject) O).sashObjectMid.frames
                                .toArray();
                        this.resetSashMullionsV(leafs);
                        this.resetSashMullionsH(leafs);
                    }// In Sash
                    if (((OpeningObject) O).sashObjectOut != null) {
                        if (((OpeningObject) O).sashObjectOut.bOpeningObject != null) {
                            this.resetSashInterlocks(((OpeningObject) O).sashObjectOut.bOpeningObject);
                        }
                        leafs = ((OpeningObject) O).sashObjectOut.frames
                                .toArray();
                        this.resetSashMullionsV(leafs);
                        this.resetSashMullionsH(leafs);
                    }// In Sash
                }

            }
            myFacet.frames.add(F);
        }

        return myFacet;
    }

    public void resetSashMullionsV(final Object[] leafs) {

        for (Object S : leafs) {

            Object[] MVs = ((SashLeaf) S).bOpeningObject.mullions.toArray();
            ((SashLeaf) S).bOpeningObject.mullions.clear();
            for (Object MV : MVs) {
                ((Profiles) MV).profileSelected = 0;
                ((Profiles) MV).potentialS = false;
                ((SashLeaf) S).bOpeningObject.mullions.add(MV);
            }
            Object[] parts = ((SashLeaf) S).partObjects.toArray();
            ((SashLeaf) S).partObjects.clear();
            for (Object P : parts) {
                ((Profiles) P).profileSelected = 0;

                ((SashLeaf) S).partObjects.add(P);
            }
        }
    }

    public void resetSashMullionsH(final Object[] leafs) {

        for (Object S : leafs) {

            Object[] MVs = ((SashLeaf) S).bOpeningObject.mullionsH.toArray();
            ((SashLeaf) S).bOpeningObject.mullionsH.clear();
            for (Object MV : MVs) {
                ((Profiles) MV).profileSelected = 0;
                ((Profiles) MV).potentialS = false;
                ((SashLeaf) S).bOpeningObject.mullionsH.add(MV);
            }

            Object[] parts = ((SashLeaf) S).partObjects.toArray();
            ((SashLeaf) S).partObjects.clear();
            for (Object P : parts) {
                ((Profiles) P).profileSelected = 0;

                ((SashLeaf) S).partObjects.add(P);
            }
        }
    }

    public BkgrdOpeningObject resetSashInterlocks(BkgrdOpeningObject myOpen) {

        Object[] MVs = myOpen.mullions.toArray();
        myOpen.mullions.clear();
        for (final Object MV : MVs) {
            ((Profiles) MV).profileSelected = 0;
            ((Profiles) MV).potentialS = false;
            myOpen.mullions.add(MV);
        }

        Object[] MHs = myOpen.mullionsH.toArray();
        myOpen.mullionsH.clear();
        for (final Object MH : MHs) {
            ((Profiles) MH).profileSelected = 0;
            ((Profiles) MH).potentialS = false;
            myOpen.mullionsH.add(MH);
        }

        return myOpen;
    }

    public void resetActive() {

        mullionsPanel.vC.setSelected(false);
        mullionsPanel.hC.setSelected(false);
        mullionsPanel.vC.setEnabled(true);
        mullionsPanel.hC.setEnabled(true);
        mullionsPanel.edit.setEnabled(true);
        mullionsPanel.extend.setEnabled(true);

        mullionsPanel.couplerTypeC.setEnabled(true);

    }

    public void dimAction() {

        if (jobItem.myCanvas != null) {
            clearTexts();

            this.doFacetRadioClick();

            lastSelectedDim = jobItem.myCanvas.dimensionType;
            jobItem.hasSubRC(selectedRadioForRow, selectedRadioForRow);
            this.dim.getSelectedDim();

            jobItem.myCanvas.setSelectedDims(selectedDim);

            doRadiosDim5to9();

            if (selectedDim == 9) {
                jobItem.myCanvas.setSelectedDims(selectedDim);
                doRadiosDim5to9();
            }
        }

        if (showDims) {
            this.jobItem.resetGraphics();
        }

    }

    public void clearTexts() {

        topTexts.clear();
        leftTexts.clear();
        colTextObjects.clear();
        this.colTextObjectsc.clear();
        this.colTextObjectscO.clear();
        this.colTextObjectsO.clear();
        this.colTextPosXe.clear();
        this.colTextPosXec.clear();
        this.colTextPosXecO.clear();
        this.colTextPosXeO.clear();
        this.colTextPosXs.clear();
        this.colTextPosXsc.clear();
        this.colTextPosXsO.clear();
        this.colTextPosXscO.clear();

        rowTextObjects.clear();
        this.rowTextObjectsc.clear();
        this.rowTextObjectscO.clear();
        this.rowTextObjectsO.clear();
        this.rowTextPosYe.clear();
        this.rowTextPosYec.clear();
        this.rowTextPosYecO.clear();
        this.rowTextPosYeO.clear();
        this.rowTextPosYs.clear();
        this.rowTextPosYsc.clear();
        this.rowTextPosYsO.clear();
        this.rowTextPosYscO.clear();
    }

    public void doRadiosDim5to9() {

        Object[] myFrames = facetUsed.frames.toArray();
        for (Object f : myFrames) {
            if (((Frame) f).startRow == jobItem.myCanvas.selectedRadioForRow
                    && ((Frame) f).startCol == jobItem.myCanvas.selectedRadioForCol) {

                if (selectedDim >= 5 && selectedDim <= 9)// Openings
                {
                    if (!dim.isSash.isSelected()) {

                        jobItem.myCanvas.createRadiosForOpeningCols((Frame) f);
                        jobItem.myCanvas.createRadiosForOpeningRows((Frame) f);

                    } else if (dim.isSash.isSelected()) {

                        Object[] leafs = ((SashTypeObject) mySelectedSash).frames
                                .toArray();
                        Object[] ops = ((SashTypeObject) mySelectedSash).openings
                                .toArray();
                        for (Object l : leafs) {
                            jobItem.myCanvas
                                    .createRadiosForOpeningCols((SashLeaf) l);
                            jobItem.myCanvas
                                    .createRadiosForOpeningRows((SashLeaf) l);
                        }

                    }

                }

            }
        }

    }

    /**
     * This action performed method save a job item design model
     *
     * @param event , ActionEvent
     */
    public void btnSave_actionPerformed(ActionEvent event) {
        doSaveAction();
    }

    public void doSaveAction() {

        buildErrorList();
        drawGuide = false;

        try {
            // Save object model designjobItem.saveObjectModel();
            if (this.warningMessages.size() > 0) {

                int response = 0;

                Object[] options = {"Yes", "No"};

                response = JOptionPane.showOptionDialog(null,
                        "Item Contains Rules Based Warnings!\n"
                                + "Continue Saving?", "Continue",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE, null, options, options[0]);

                if (response == 0) {
                    setFinalDialog();

                }
            } else {
                if (this.errorMessages.size() > 0) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Please resolve all outstanding Errors prior to Saving!",
                                    "Error", JOptionPane.ERROR_MESSAGE);

                    this.collapsemenu.add(this.errorWarningTask);
                    errorWarningTask.setCollapsed(false);
                } else {
                    this.collapsemenu.remove(this.errorWarningTask);
                    errorWarningTask.setCollapsed(true);
                    setFinalDialog();

                }
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            // Show message error dialog
            JOptionPane
                    .showMessageDialog(
                            null,
                            "Errors occured while saving . Please contact your supplier!",
                            "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Refresh Items Panel Components
            ((JPanelAsynchronous) this.userPref.getItemsPanel()).refreshUI();
        }
    }

    public void setFinalDialog() {

        this.finalSave = new JDialog(this, "Please Verify Information", true);

        final JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        mainPanel.setLayout(new XYLayout());

        JLabel reasonL = new JLabel("Price Change:");

        List<PriceChangeReason> changeReasons = ApplicationBaseApp.getInstance().getChangeReasons();

        if (this.docType != 99) {
            if (changeReasons != null) {
                addObjects(reasonCmb, changeReasons);
                reasonCmb.setSelectedIndex(0);
            }

            if (!isNewItem) {
                PriceChangeReason changeReason = ApplicationBaseApp.getInstance().getChangeReason(jobItem.priceChangeReasonID);

                if (changeReason != null) {
                    reasonCmb.setSelectedItem(changeReason);
                }
            }

            qtyT.setText(this.myTopPanel.qty.getText().trim() + "");
            refT.setText(this.myTopPanel.reference.getText().trim() + "");
            locT.setText(this.myTopPanel.locationT.getText().trim() + "");

        } else {
            if (changeReasons != null) {
                addObjects(reasonCmb, changeReasons);
                reasonCmb.setSelectedIndex(0);
            }

            if (!isNewItem) {
                PriceChangeReason changeReason = ApplicationBaseApp.getInstance().getChangeReason(jobItem.priceChangeReasonID);

                if (changeReason != null) {
                    reasonCmb.setSelectedItem(changeReason);
                }
            }

            qtyT.setText(this.myTopPanel.qty.getText().trim() + "");
            refT.setText(this.myTopPanel.reference.getText().trim() + "");
            locT.setText(this.myTopPanel.locationT.getText().trim() + "");
        }

        JButton okBtn = new JButton();
        okBtn.setIcon(ItemFrame.iconFiles.get("set"));
        okBtn.setToolTipText("Proceed to Save Item");

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainPanel.getRootPane().setCursor(waitCursor);

                setValues();
                ItemFrame.this.dispose();

                mainPanel.getRootPane().setCursor(normalCursor);
            }
        });

        if (this.calcPrice.compareTo(this.netPrice) != 0) {

            mainPanel.add(reasonL, new XYConstraints(1, 1, 140, 22));
            mainPanel.add(reasonCmb, new XYConstraints(142, 1, 200, 22));

            mainPanel.add(qtyL, new XYConstraints(1, 25, 140, 22));
            mainPanel.add(qtyT, new XYConstraints(142, 25, 40, 22));

            mainPanel.add(refL, new XYConstraints(1, 49, 140, 22));
            mainPanel.add(refT, new XYConstraints(142, 49, 200, 22));

            mainPanel.add(locL, new XYConstraints(1, 73, 140, 22));
            mainPanel.add(locT, new XYConstraints(142, 73, 200, 22));

            mainPanel.add(okBtn, new XYConstraints(302, 97, 40, 26));

        } else {

            mainPanel.add(qtyL, new XYConstraints(1, 1, 80, 22));
            mainPanel.add(qtyT, new XYConstraints(82, 1, 40, 22));

            mainPanel.add(refL, new XYConstraints(1, 25, 80, 22));
            mainPanel.add(refT, new XYConstraints(82, 25, 200, 22));

            mainPanel.add(locL, new XYConstraints(1, 49, 80, 22));
            mainPanel.add(locT, new XYConstraints(82, 49, 200, 22));

            mainPanel.add(okBtn, new XYConstraints(242, 73, 40, 26));
        }

        finalSave.getContentPane().add(mainPanel);
        finalSave.setLocation((myParent.getWidth() / 2) - 110, (myParent.getHeight() / 2) - 60);

        finalSave.getContentPane().setSize(220, 120);
        finalSave.setResizable(false);
        finalSave.pack();
        finalSave.setVisible(true);
    }

    public void setValues() {

        String qty = qtyT.getText().trim();

        try {

            if (qty.length() > 0 && Integer.parseInt(qty) > 0) {
                ItemFrame.this.myTopPanel.qty.setText(qty);

            }

            if (this.calcPrice.compareTo(this.netPrice) != 0) {
                ItemFrame.this.jobItem.priceChangeReasonID = ((PriceChangeReason) reasonCmb
                        .getSelectedItem()).getId();
            }

            ItemFrame.this.myTopPanel.reference.setText(refT.getText().trim());
            ItemFrame.this.myTopPanel.locationT.setText(locT.getText().trim());

            // Init Financial summary data
            ItemFrame.this.costPricePanel.initFinancialSummaryData();

            // Save Job Item Model Design
            this.jobItem.saveObjectModel();

        } catch (NumberFormatException e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(this.myParent,
                    "Invalid Quantity Entered", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(this.myParent, e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Dispose Item Frame
            this.finalSave.dispose();
        }
    }

    public void setButtonsFalse() {

        final Cursor stdCursor = new Cursor(Cursor.DEFAULT_CURSOR);
        this.setCursor(stdCursor);
        mullionsPanel.couplerMullionPanel.setCursor(stdCursor);
        mullionsPanel.whichFeature.setCursor(stdCursor);
        jobItem.myCanvas.setCursor(stdCursor);
        this.setCursor(stdCursor);

        mullionsPanel.vC.setSelected(false);
        mullionsPanel.hC.setSelected(false);
        mullionsPanel.edit.setSelected(false);
        mullionsPanel.extend.setSelected(false);

        if (shapesPanel != null && shapesPanel.shapeButton != null) {
            for (final JButton element : shapesPanel.shapeButton) {
                element.setSelected(false);
            }
        }

        dim.cancelAlign.doClick();
        dim.equalize.setSelected(false);
        dim.equalizeH.setSelected(false);
        dim.alignVert.setSelected(false);
        dim.alignHorz.setSelected(false);

        gridsPanel.bAddGrids.setSelected(false);
        gridsPanel.bChangeMasterH.setSelected(false);
        gridsPanel.bChangeMasterV.setSelected(false);
        gridsPanel.bChangeNumGrids.setSelected(false);
        gridsPanel.bCutGrid.setSelected(false);
        gridsPanel.bEqualizeH.setSelected(false);
        gridsPanel.bEqualizeV.setSelected(false);
        gridsPanel.bRemoveAll.setSelected(false);
        gridsPanel.bRemoveGrid.setSelected(false);
        gridsPanel.bSetNumberGrid.setSelected(false);
        gridsPanel.bSetSelectedGrid.setSelected(false);

        editor.edit.setSelected(false);
        editor.cancel.doClick();
        dim.cancelAlign.doClick();
        dim.changeAlign.setSelected(false);
        dim.doAlign.setSelected(false);
        editor.removePart.setSelected(false);
        editor.setGo.setSelected(false);

    }

    public double doRoundDim(double size) {

        if (currentUOM <= 1) {
            size = roundDim(size, 1, metricRound, 1);
        } else if (currentUOM == 2) {
            size = roundDim(size, 2, impRound, 2);
        } else if (currentUOM == 3) {
            size = roundDim(size, 3, impRound, 2);
        } else if (currentUOM == 4) {
            size = roundDim(size, 4, impRound, 2);
        }
        return size;
    }

    public double roundDim(double size, final int type, final double round, int measure) {

        if (Double.isNaN(size)) {
            size = 0.0;
            return size;
        }

        size = (int) (size / round) * round;

        return size;
    }

    /**
     * Action performed for change in Unit of Measure selection for design
     *
     * @param type , Type of Unit of Measure selected
     */
    public void uom_actionPerformed(int type) {

        // Save actual dimension options before process new change unit of
        // measure
        this.jobItem.setDimensionOptions();

        if (type == 1) { // Metric Unit of Measure
            doChangeToMetric(type);
        } else if (type >= 2) { // Imperial unit of measure & Imperial fraction
            // unit of measure
            doChangeToImperial(type);
        }

        // Change Unit of Measure text values
        if (myTabs.getSelectedIndex() == 0) {
            layoutP.changeTextUOM();
        }
    }

    public void doChangeToMetric(int type) {

        double initW;
        double initH;
        boolean doChangeSize = false;
        this.scale = this.metricscale;

        /**
         * This change unit measure is done, action should come up from another
         * unit of measure
         */
        if (prevUOM > 1) {

            // Init values for Width and Height
            initW = jobItem._WIDTH_Metric_O / 100;
            initH = jobItem._HEIGHT_Metric_O / 100;

            /**
             * Init Width value is distinct from Width Metric value actual
             * design
             */
            if (initW != jobItem._WIDTH_Metric) {
                doChangeSize = true;
                roundW = true;
            }

            /**
             * Init Height value if distinct from Height Metric value actual
             * design
             */
            if (initH != jobItem._HEIGHT_Metric) {
                doChangeSize = true;
                roundH = true;
            }

            // Rounding init Width & Height dimensions
            String w = roundDim(initW, type, metricRound, 1) + "";
            String h = roundDim(initH, type, metricRound, 1) + "";

            if (initW != Double.parseDouble(w)
                    || initH != Double.parseDouble(h)) {
                doChangeSize = true;
            }

            // Format width and height dimension rounding to 6 decimal format
            w = sixDecimal.format(Double.parseDouble(w));
            h = sixDecimal.format(Double.parseDouble(h));

            // Update dimension values to UI components
            this.myTopPanel.fW.setText(w);
            this.myTopPanel.fH.setText(h);

            this.myTopPanel.oW.setText(w + myTopPanel.getOAW());
            this.myTopPanel.oH.setText(h + myTopPanel.getOAH());

            if (doChangeSize) {
                // Reset Overall design with new dimension sizes
                this.doResetOverallSize(Double.parseDouble(w),
                        Double.parseDouble(h), jobItem.design, 0, true, false);
                roundW = false;
                roundH = false;
            } else {
                // Reset Overall design with new unit of measure
                this.doResetOverallSize(Double.parseDouble(w),
                        Double.parseDouble(h), jobItem.design, 1, true, false);
                roundW = false;
                roundH = false;
            }
        }
    }

    public void doChangeToImperial(int type) {

        double initW;
        double initH;
        double initWo;
        double initHo;
        boolean doChangeSize = false;
        boolean sameDims = false;

        // Get Adjustment RO Width & Height dimensions
        int adjW = myTopPanel.getOAW();
        int adjH = myTopPanel.getOAH();

        this.scale = this.imperialscale;

        if (prevUOM == 1) { // This action come from metric unit of measure
            initW = jobItem._WIDTH_Imp_O;
            initH = jobItem._HEIGHT_Imp_O;

            // Init width & height dimension with Ro adjustment
            initWo = jobItem._WIDTH_Imp_O + adjW;
            initHo = jobItem._HEIGHT_Imp_O + adjH;

        } else {
            initW = jobItem._WIDTH_Imp;
            initH = jobItem._HEIGHT_Imp;
            initWo = jobItem._WIDTH_Imp + adjW;
            initHo = jobItem._HEIGHT_Imp + adjH;
        }

        /**
         * Init Width value is distinct from Width Imperial value actual design
         */
        if (initW != jobItem._WIDTH_Imp) {
            roundW = true;
            doChangeSize = true;
        }

        /**
         * Init Height value is distinct from Height Imperial value actual
         * design
         */
        if (initH != jobItem._HEIGHT_Imp) {
            roundH = true;
            doChangeSize = true;
        }

        if (prevUOM > 1) {
            sameDims = true;
        }

        // Calculating width & height dimension and ro adjustment
        String w = (int) (((int) (initW / impRound)) * impRound) + "";
        String h = (int) (((int) (initH / impRound)) * impRound) + "";

        String wo = (int) (((int) (initWo / impRound)) * impRound) + "";
        String ho = (int) (((int) (initHo / impRound)) * impRound) + "";

        /**
         * Change dimension size if width & height is not equals for init values
         */
        if (initW != Double.parseDouble(w) || initH != Double.parseDouble(h)) {
            doChangeSize = true;
        }

        // Format dimensions for six dimension values
        w = sixDecimal.format(Double.parseDouble(w) / 64);
        h = sixDecimal.format(Double.parseDouble(h) / 64);
        wo = sixDecimal.format(Double.parseDouble(wo) / 64);
        ho = sixDecimal.format(Double.parseDouble(ho) / 64);

        if (type == 2 || type == 4) { // Update values for Imperial Decimal
            // values
            myTopPanel.fW.setText(w);
            myTopPanel.fH.setText(h);
            myTopPanel.oW.setText(wo);
            myTopPanel.oH.setText(ho);
        } else if (type == 3) { // Update UI representation values for Imperial
            // Fraction Values
            String fracw = "";
            String frach = "";
            String fracwo = "";
            String fracho = "";

            try {
                fracw = UOMConvert.imperialToFraction(w);
                frach = UOMConvert.imperialToFraction(h);
                fracwo = UOMConvert.imperialToFraction(wo);
                fracho = UOMConvert.imperialToFraction(ho);
            } catch (final Exception e) {
                e.printStackTrace();
            }

            myTopPanel.fW.setText(fracw);
            myTopPanel.fH.setText(frach);
            myTopPanel.oW.setText(fracwo);
            myTopPanel.oH.setText(fracho);
        }

        if (doChangeSize) {
            // Reset Overall design with new dimension sizes
            this.doResetOverallSize(Double.parseDouble(w),
                    Double.parseDouble(h), jobItem.design, 0, true, sameDims);
            roundW = false;
            roundH = false;
        } else {
            // Reset Overall design with new unit of measure
            this.doResetOverallSize(Double.parseDouble(w),
                    Double.parseDouble(h), jobItem.design, 1, true, sameDims);
            roundW = false;
            roundH = false;
        }
    }

    public Object[] dimConvert(double value, final boolean round) throws Exception {

        final Object[] values = new Object[2];
        if (currentUOM == 1) {
            if (round) {
                value = roundDim(value, 1, metricRound, 1);
            }
            value = Double.parseDouble(oneDecimal.format(value));
            values[0] = value;
            values[1] = value + "";

        } else if (currentUOM == 2) {
            value = value / 64;
            if (round) {
                value = roundDim(value, 2, impRound, 2);
            }
            value = Double.parseDouble(sixDecimal.format(value));
            values[0] = value;
            values[1] = value + "";

        } else if (currentUOM == 3) {
            value = value / 64;
            if (round) {
                value = roundDim(value, 3, impRound, 2);
            }
            value = Double.parseDouble(sixDecimal.format(value));
            values[0] = value;
            values[1] = UOMConvert.imperialToFraction(value + "");

        } else if (currentUOM == 4) {
            if (round) {
                value = roundDim(value, 4, impRound, 2);
            }
            value = Double.parseDouble(noDecimal.format(value));
            values[0] = value;
            values[1] = UOMConvert.imperialToFeetInch(value + "", 0);

        } else if (currentUOM == 5) {
            // roundDim(jobItem._HEIGHT_Imp_O, 5, impRound , 2);
        }

        return values;
    }

    public Object[] readConvertText(final JTextField tf) throws Exception {

        final Object[] myText = new Object[2];

        if (currentUOM == 1) {
            if (prevUOM == 1) {
                myText[0] = Double.parseDouble(tf.getText());
                myText[1] = tf.getText() + "";
            } else if (prevUOM == 2) {
                myText[0] = Double.parseDouble(UOMConvert.imperialTometric(tf
                        .getText()));
                myText[1] = UOMConvert.imperialTometric(tf.getText()) + "";
            } else if (prevUOM == 3) {
                myText[0] = Double.parseDouble(UOMConvert.fractionToMetric(tf
                        .getText()));
                myText[1] = UOMConvert.fractionToMetric(tf.getText()) + "";

            } else if (prevUOM == 4) {
                myText[0] = Double.parseDouble(UOMConvert.feetInchToMetric(
                        tf.getText(), mySeries.getFeetInchAdjustment()));
                myText[1] = UOMConvert.feetInchToMetric(tf.getText(),
                        mySeries.getFeetInchAdjustment())
                        + "";
            }

        } else if (currentUOM == 2) {
            if (prevUOM == 1) {
                myText[0] = Double.parseDouble(UOMConvert.metricToImperial(tf
                        .getText()));
                myText[1] = UOMConvert.metricToImperial(tf.getText()) + "";
            } else if (prevUOM == 2) {
                // myText =
                // Double.parseDouble(UOMConvert.imperialToSixtyFourth(tf.getText()));
                myText[0] = Double.parseDouble(tf.getText());
                myText[1] = tf.getText() + "";
            } else if (prevUOM == 3) {
                myText[0] = Double.parseDouble(UOMConvert.fractionToImperial(tf
                        .getText())) * 64;
                myText[1] = Double.parseDouble(UOMConvert.fractionToImperial(tf
                        .getText())) * 64 + "";

            } else if (prevUOM == 4) {
                myText[0] = Double.parseDouble(UOMConvert
                        .feetInchToSixtyFourth(tf.getText(),
                                mySeries.getFeetInchAdjustment()));
                myText[1] = UOMConvert.feetInchToSixtyFourth(tf.getText(),
                        mySeries.getFeetInchAdjustment()) + "";
            }
        } else if (currentUOM == 3) {
            if (prevUOM == 1) {
                myText[0] = Double.parseDouble(UOMConvert.metricToImperial(tf
                        .getText()));
                myText[1] = UOMConvert.metricToFraction(tf.getText());
            } else if (prevUOM == 2) {
                myText[0] = Double.parseDouble(tf.getText());
                myText[1] = UOMConvert.imperialToFraction(tf.getText());
            } else if (prevUOM == 3) {
                myText[0] = Double.parseDouble(UOMConvert.fractionToImperial(tf
                        .getText())) * 64;
                myText[1] = tf.getText();
            } else if (prevUOM == 4) {
                myText[0] = Double.parseDouble(UOMConvert
                        .feetInchToSixtyFourth(tf.getText(),
                                mySeries.getFeetInchAdjustment()));
                myText[1] = UOMConvert.feetInchToFraction(tf.getText(),
                        mySeries.getFeetInchAdjustment());
            }

        } else if (currentUOM == 4) {
            if (prevUOM == 1) {
                myText[0] = Double.parseDouble(UOMConvert.metricToImperial(tf
                        .getText()));
                myText[1] = UOMConvert.feetInchToMetric(tf.getText(),
                        mySeries.getFeetInchAdjustment());
            } else if (prevUOM == 2) {
                myText[0] = Double.parseDouble(tf.getText());
                myText[1] = UOMConvert.feetInchToSixtyFourth(tf.getText(),
                        mySeries.getFeetInchAdjustment());
            } else if (prevUOM == 3) {
                myText[0] = Double.parseDouble(UOMConvert.fractionToImperial(tf
                        .getText())) * 64;
                myText[1] = UOMConvert.feetInchToSixtyFourth(tf.getText(),
                        mySeries.getFeetInchAdjustment());
            } else if (prevUOM == 4) {
                myText[0] = Double.parseDouble(UOMConvert
                        .feetInchToSixtyFourth(tf.getText(),
                                mySeries.getFeetInchAdjustment()));
                myText[1] = tf.getText();
            }

        }
        return myText;
    }

    public Object[] readTextCurrentUOM(final JTextField tf) throws Exception {

        final Object[] myText = new Object[2];

        if (jobItem != null) {
            if (currentUOM == 1) {
                myText[0] = Double.parseDouble(tf.getText());
                myText[1] = tf.getText() + "";
            } else if (currentUOM >= 2) {
                myText[0] = Double.parseDouble(tf.getText()) * 64;
                myText[1] = Double.parseDouble(tf.getText()) * 64 + "";
            }
        } else {
            if (currentUOM == 1) {
                myText[0] = 1000;
                myText[1] = 1000;
            } else {
                myText[0] = 39 * 64;
                myText[1] = 39 * 64;
            }
        }

        return myText;
    }

    public Object[] readTextStringCurrentUOM(final String tf) throws Exception {

        final Object[] myText = new Object[2];

        if (jobItem != null) {
            if (currentUOM == 1) {
                myText[0] = Double.parseDouble(tf);
                myText[1] = tf + "";
            } else if (currentUOM >= 2) {
                myText[0] = Double.parseDouble(tf) * 64;
                myText[1] = Double.parseDouble(tf) * 64 + "";
            }
        } else {
            if (currentUOM == 1) {
                myText[0] = 1000;
                myText[1] = 1000;
            } else {
                myText[0] = 39 * 64;
                myText[1] = 39 * 64;
            }
        }

        return myText;
    }

    /**
     * This method add a Overall design to array do changes to performed undo
     * operations
     */
    public void addToUndo() {
        JobItemModel undoObject = this.jobItem.clone();
        this.undoArray.add(undoObject);
    }

    /**
     * Return an application base for execution
     *
     * @return ApplicationBaseApp
     */
    public static ApplicationBaseApp getApplicationBase() {
        return applicationBase;
    }

    /**
     * Return an application base rules for execution
     *
     * @return ApplicationBaseRulesApp
     */
    public static ApplicationBaseRulesApp getApplicationBaseRules() {
        return applicationBaseRules;
    }

    /**
     * Return an application base remote rules for execution
     *
     * @return ApplicationRemoteBaseRulesApp
     */
    public static ApplicationRemoteBaseRulesApp getApplicationRemoteBaseRules() {
        return ApplicationRemoteBaseRulesApp.getInstance();
    }

    /**
     * This method performed undo operations over a jobItem design
     */
    public void undoAction() {

        // Undo operation
        this.isUndo = true;

        // Check if undo array of changes is not empty
        if (undoArray.size() == 0) {
            return;
        }

        // Get last change from array
        JobItemModel undoModel = (JobItemModel) undoArray.get(undoArray.size() - 1);

        // Remove last change load
        if (undoModel != null) {
            this.undoArray.remove(undoArray.size() - 1);

            // Load undo design to JobItem model
            this.jobItem = undoModel;

            // Reset unit of measure for topPanel dimensions
            this.myTopPanel.resetUnitOfMeasureFromJobItem();

            // Init facet selected for design
            this.jobItem.initFacetSelectedForDesign();

            // Init design options
            this.jobItem.initDesignOptions();

            // Reset graphics design
            this.jobItem.resetGraphics();

            // Calculate Bill Of Material
            this.calcBom = true;
        }
    }

    public void setBayBowTasks() {

        mullionsPanel.vC.setEnabled(false);
        mullionsPanel.couplerTypeC.setEnabled(true);

        setButtonsFalse();
        this.validate();
        this.repaint();
        jobItem.myCanvas.validate();
        jobItem.myCanvas.repaint();
    }

    public void clearItemFrameTextObjects() {

        colTextObjects.clear();
        colTextPosXs.clear();
        colTextPosXe.clear();
        colTextObjectsc.clear();
        colTextPosXsc.clear();
        colTextPosXec.clear();

        rowTextObjects.clear();
        rowTextPosYs.clear();
        rowTextPosYe.clear();
        rowTextObjectsc.clear();
        rowTextPosYsc.clear();
        rowTextPosYec.clear();

        topTexts.clear();
        botTexts.clear();
        leftTexts.clear();

        textTop = null;
        textLeft = null;
        textBot = null;

        textFieldsTop = null;
        myTextRow = null;

        textFieldsFBot = null;
        textFieldsFRight = null;
        myTextRow = null;
        textFieldsLeft = null;
        myTextLeft = null;
        textFieldsRight = null;
        myTextRight = null;
    }

    public boolean compareTwoDoubles(final double v1, final double v2) {

        boolean goodToGo = false;
        if (v1 >= v2 - 1 && v1 <= v2 + 1) {
            goodToGo = true;
        }

        return goodToGo;
    }

    public void clearFacetTexts() {

        fcolTexts.clear();
        fcolTextObjects.clear();
        fcolTextPosXs.clear();
        fcolTextPosXe.clear();
        fcolTextObjectsc.clear();
        fcolTextPosXsc.clear();
        fcolTextPosXec.clear();

        frowTextObjects.clear();
        frowTextPosXs.clear();
        frowTextPosXe.clear();
        frowTextObjectsc.clear();
        frowTextPosXsc.clear();
        frowTextPosXec.clear();
        fcolText = null;
        frowText = null;
    }

    public Facet doResetFacetSize(final double w, final double h, Facet newOverall, final int dimChange) {

        try {

            newOverall = newOverall.initFacetSize(w / scale.doubleValue(), h
                    / scale.doubleValue(), w / scale.doubleValue(),
                    h / scale.doubleValue(), newOverall, dimChange);

            newOverall.widthPix = newOverall.widthPix * scale.doubleValue();
            newOverall.heightPix = newOverall.heightPix * scale.doubleValue();

            return newOverall;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    public void doResetOverallSize(double w, double h, ShapeObject newOverall, int dimChange, boolean setTexts,
                                   boolean sameDims) {

        try {

            if (w - Math.floor(w) >= 0.999) {
                w = Math.ceil(w);
            }
            if (h - Math.floor(h) >= 0.999) {
                h = Math.ceil(h);
            }

            if (dimChange == 0) // Overall Dim Change
            {
                jobItem.setWHDimChange(w, h, setTexts);

            } else if (dimChange == 1) // UOM Change
            {
                jobItem.setWH(w, h, setTexts);

            } else if (dimChange == 2) // ShapeChange
            {
                if (myTopPanel.metric.isSelected()) {
                    jobItem.setWH(w, h, setTexts);
                } else if (myTopPanel.impDec.isSelected()) {
                    jobItem.setWH(w / 64, h / 64, setTexts);
                }
                if (myTopPanel.impFrac.isSelected()) {
                    jobItem.setWH(w / 64, h / 64, setTexts);
                }
            }

            if (facetUsed != null) {// HERE check uom
                facetUsed.scaleM = scale;
            }

            newOverall.scaleM = scale;
            final double ow = jobItem.odW;
            final double oh = jobItem.odH;

            newOverall.initOverallSize(jobItem.design_flat_WIDTHpix,
                    jobItem.design_flat_HEIGHTpix, ow, oh, newOverall,
                    dimChange, false); // sameDims

            if (hasGrids) {
                if (this.btnGridsSelect.isSelected()) {
                    this.btnGridsSelect.doClick();
                }
                setgrids();
            }

            this.jobItem.myCanvas.redrawTextForColRow(true);

            validate();
            repaint();

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void initRules(Series series) {

        executePartRules.setPartner(this.partnerID);
        executePartRules.setSeries(series);
        Collection empty = new ArrayList();
        executePartRules.setCartDefault(empty);
    }

    /**
     * Execute Model Rules
     *
     * @param doBOM , Execute all rules for Job Item
     */
    public void executeRules(boolean doBOM) {
        buildBOM.buildModelBOM(doBOM);
    }

    /**
     * Create a Filtered version of DesignOptionAll and put it into designOption
     * for use in OptionTable model.
     */
    public void createNetDesignOption() {

        // Load Model Options All
        this.jobItem.design.loadOptionsAll();

        designOptionsNet.clear();

        /**
         * copy all to net
         */
        designOptionsNet.addAll(designOptionsAll);

        /**
         *
         * Set Mixed=True/False duplicate Add to Set and back to Collection.
         *
         */
        Object[] allOptions = designOptionsNet.toArray();

        designOptionsNet.clear();
        int i = 1;

        for (Object ao : allOptions) {

            for (Object ao2 : allOptions) {

                if (!((DesignOption) ao).global
                        && (((DesignOption) ao).optionid == ((DesignOption) ao2).optionid
                        && ((DesignOption) ao).answerid != 0 && ((DesignOption) ao).answerid != ((DesignOption) ao2).answerid)) {

                    ((DesignOption) ao).isMixed = true;
                    ((DesignOption) ao).answerid = 0;
                }
            }

            ((DesignOption) ao).seq = i;
            designOptionsNet.add((DesignOption) ao);
            i++;
        }

        allOptions = designOptionsNet.toArray();

        designOptionsNet.clear();

        Object[] net = designOptionsNet.toArray();

        boolean dup = true;
        DesignOption myOpt = new DesignOption();

        // i = 0;

        boolean found = false;

        for (Object a : allOptions) {

            found = false;

            net = designOptionsNet.toArray();

            for (Object n : net) {
                if (((DesignOption) a).equals(n)) {
                    found = true;
                    break;
                }
            }

            if (net.length == 0 || !found) {
                designOptionsNet.add((DesignOption) a);
            }
        }

        Collections.sort((ArrayList) designOptionsNet,
                DesignOptionSorter.ParentRule);
    }

    public void resetAllOptionsFromDesignOptions() {

        Object[] netOptions = this.designOptionsNet.toArray();
        Object[] allOptions = this.designOptionsAll.toArray();

        this.designOptionsAll.clear();

        for (Object all : allOptions) {

            for (Object net : netOptions) {

                if (((DesignOption) net).isMixed
                        && ((DesignOption) net).answerid != 0) {
                    ((DesignOption) net).isMixed = false;
                }

                if (((DesignOption) all).optionid == ((DesignOption) net).optionid
                        && !((DesignOption) net).isMixed) {

                    if (((DesignOption) all).myoption.getOptiontypeid() <= 2) {
                        ((DesignOption) all).answerid = ((DesignOption) net).answerid;
                        ((DesignOption) all).myanswer = ((DesignOption) net).myanswer;
                        ((DesignOption) all).rgb_R = ((DesignOption) net).rgb_R;
                        ((DesignOption) all).rgb_G = ((DesignOption) net).rgb_G;
                        ((DesignOption) all).rgb_B = ((DesignOption) net).rgb_B;
                        break;

                    } else if (((DesignOption) all).myoption.getOptiontypeid() == 3) {// Qty
                        ((DesignOption) all).qtyanswer = ((DesignOption) net).qtyanswer;

                        break;

                    } else if (((DesignOption) all).myoption.getOptiontypeid() == 4) { // Size/Length
                        ((DesignOption) all).sizeanswer = ((DesignOption) net).sizeanswer;
                        ((DesignOption) all).sizeansweri = ((DesignOption) net).sizeansweri;

                        break;

                    } else if (((DesignOption) all).myoption.getOptiontypeid() == 5) {// depth
                        ((DesignOption) all).depthanswer = ((DesignOption) net).depthanswer;
                        ((DesignOption) all).depthansweri = ((DesignOption) net).depthansweri;

                        break;

                    } else if (((DesignOption) all).myoption.getOptiontypeid() == 6) {// Text
                        ((DesignOption) all).textAnswer = ((DesignOption) net).textAnswer;

                        break;

                    } else if (((DesignOption) all).myoption.getOptiontypeid() == 7) {// Adjust
                        ((DesignOption) all).adjust = ((DesignOption) net).adjust;
                        ((DesignOption) all).adjusti = ((DesignOption) net).adjusti;

                        break;
                    }
                }
            }

            this.designOptionsAll.add((DesignOption) all);
        }
    }

    /**
     * Sets cursor for specified component to Wait cursor
     */
    public static void startWaitCursor(JComponent component) {
        RootPaneContainer root = (RootPaneContainer) component
                .getTopLevelAncestor();
        root.getGlassPane().setCursor(
                Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        root.getGlassPane().setVisible(true);
    }

    /**
     * Sets cursor for specified component to normal cursor
     */
    public static void stopWaitCursor(JComponent component) {
        startCustomCursor(component, myCursor);

        // RootPaneContainer root = (RootPaneContainer)
        // component.getTopLevelAncestor();
        // root.getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        // root.getGlassPane().setVisible(false);
    }

    /**
     * Sets cursor for specified component to Wait cursor
     */
    public static void startCustomCursor(JComponent component, Cursor myC) {
        RootPaneContainer root = (RootPaneContainer) component.getTopLevelAncestor();
        root.getGlassPane().setCursor(myC);
        root.getGlassPane().setVisible(true);
    }

    /**
     * Sets cursor for specified component to normal cursor
     */
    public static void stopCustomCursor(JComponent component) {

        RootPaneContainer root = (RootPaneContainer) component.getTopLevelAncestor();
        root.getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        myCursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
        root.getGlassPane().setVisible(false);
    }

    private void addObjects(JComboBox box, Collection data) {
        box.removeAllItems();
        Iterator ia = data.iterator();
        while (ia.hasNext()) {
            box.addItem(ia.next());
        }

    }

    public ShapeOption setShapeOptionsFromDesignOptions(DesignOption designOption, ShapeOption shapeOption) {

        shapeOption.a_levelID = designOption.a_levelID;
        shapeOption.a_sequenceID = designOption.a_sequenceID;
        shapeOption.a_assemblyLevel = designOption.a_assemblyLevel;
        shapeOption.a_1Level = designOption.a_1Level;
        shapeOption.a_1Sequence = designOption.a_1Sequence;
        shapeOption.a_2Level = designOption.a_2Level;
        shapeOption.a_2Sequence = designOption.a_2Sequence;
        shapeOption.a_3Level = designOption.a_3Level;
        shapeOption.a_3Sequence = designOption.a_3Sequence;
        shapeOption.a_4Level = designOption.a_4Level;
        shapeOption.a_4Sequence = designOption.a_4Sequence;
        shapeOption.a_5Level = designOption.a_5Level;
        shapeOption.a_5Sequence = designOption.a_5Sequence;
        shapeOption.a_6Level = designOption.a_6Level;
        shapeOption.a_6Sequence = designOption.a_6Sequence;
        shapeOption.a_7Level = designOption.a_7Level;
        shapeOption.a_7Sequence = designOption.a_7Sequence;
        shapeOption.a_8Level = designOption.a_8Level;
        shapeOption.a_8Sequence = designOption.a_8Sequence;
        shapeOption.a_9Level = designOption.a_9Level;
        shapeOption.a_9Sequence = designOption.a_9Sequence;
        shapeOption.a_10Level = designOption.a_10Level;
        shapeOption.a_10Sequence = designOption.a_10Sequence;

        shapeOption.optionid = designOption.optionid;
        shapeOption.answerid = designOption.answerid;
        shapeOption.myoption = designOption.myoption;
        shapeOption.myanswer = designOption.myanswer;
        shapeOption.qtyanswer = designOption.qtyanswer;
        shapeOption.sizeanswer = designOption.sizeanswer;
        shapeOption.sizeansweri = designOption.sizeansweri;
        shapeOption.depthanswer = designOption.depthanswer;
        shapeOption.depthansweri = designOption.depthansweri;
        shapeOption.adjust = designOption.adjust;
        shapeOption.adjusti = designOption.adjusti;
        shapeOption.textAnswer = designOption.textAnswer;
        shapeOption.rgb_R = designOption.rgb_R;
        shapeOption.rgb_G = designOption.rgb_G;
        shapeOption.rgb_B = designOption.rgb_B;
        shapeOption.price = designOption.price;
        shapeOption.discountP = designOption.discountP;
        shapeOption.priceUser = designOption.priceUser;
        shapeOption.cost = designOption.cost;
        shapeOption.w = designOption.w;
        shapeOption.h = designOption.h;
        shapeOption.wi = designOption.wi;
        shapeOption.hi = designOption.hi;
        shapeOption.d = designOption.d;
        shapeOption.di = designOption.di;
        shapeOption.l = designOption.l;
        shapeOption.li = designOption.li;
        shapeOption.priceuom = designOption.priceuom;
        shapeOption.costuom = designOption.costuom;
        shapeOption.pricemeasure = designOption.pricemeasure;
        shapeOption.priceTotal = designOption.priceTotal;
        shapeOption.priceTotalUser = designOption.priceTotalUser;
        shapeOption.costTotal = designOption.costTotal;
        shapeOption.seriesid = designOption.seriesid;
        shapeOption.ruleno = designOption.ruleno;

        shapeOption.optionsAllowedAnswers
                .addAll(designOption.optionsAllowedAnswers);

        shapeOption.isAuto = designOption.isAuto;
        shapeOption.global = designOption.global;

        shapeOption.supplierId = designOption.supplierID;
        shapeOption.supplierSeriesId = designOption.supplierSeriesID;
        shapeOption.remote = designOption.remote;

        return shapeOption;
    }

    public void setGlobalOption(ShapeOption myOp) {

        cleanOption(myOp, jobItem.design);

        jobItem.design.options.add(myOp);

        // List<Facet> fs = new ArrayList<Facet>();
        //
        // for (Object facet : jobItem.design.frames.toArray()) {
        // fs.add((Facet) facet);
        // }
        //
        //
        // jobItem.design.frames.clear();
        //
        // for (Facet facet : fs) {
        //
        // cleanOption(myOp, facet);
        //
        // facet.options.add(myOp);
        //
        // List<Frame> frames = new ArrayList<Frame>();
        //
        // for (Object frame : facet.frames.toArray()) {
        // frames.add((Frame) frame);
        // }
        //
        // facet.frames.clear();
        //
        //
        // for (Frame frame : frames) {
        //
        // cleanOption(myOp, frame);
        //
        // frame.options.add(myOp);
        //
        // if (frame.shapeID != 10) {
        // List<OpeningObject> openings = new ArrayList<OpeningObject>();
        //
        //
        // for (Object o : frame.openings.toArray()) {
        // openings.add((OpeningObject) o);
        // }
        //
        // frame.openings.clear();
        //
        // for (OpeningObject o : openings) {
        // cleanOption(myOp, o);
        // o.options.add(myOp);
        //
        // if (((OpeningObject) o).contentMid == 1) {
        // cleanOption(myOp, o.dloMid);
        // o.dloMid.options.add(myOp);
        //
        //
        // } else if (((OpeningObject) o).contentMid == 2) {
        //
        // cleanOption(myOp, o.sashObjectMid);
        //
        // o.sashObjectMid.options.add(myOp);
        //
        //
        // } else if (((OpeningObject) o).contentMid == 3) {
        // cleanOption(myOp, o.subFacet);
        // o.subFacet.options.add(myOp);
        //
        //
        // }
        // frame.openings.add(o);
        // }
        //
        // }
        // facet.frames.add(frame);
        // }// Frames
        //
        // jobItem.design.frames.add(facet);
        // }// facets

    }

    private void cleanOption(ShapeOption myOp, ShapeObject shape) {
        Object[] shapeoptions = shape.options.toArray();
        shape.options.clear();
        for (Object so : shapeoptions) {
            if (((ShapeOption) so).optionid == myOp.optionid) {

            } else {
                shape.options.add((ShapeOption) so);
            }

        }
    }

    public void cleanColorList() {
        this.executePartRules.colorList.clear();
    }

    public class DefaultModel extends DefaultTableModel {

        private String[] columnNames = new String[]{"Attribute", "value"};

        /**
         * Default Model Constructor
         */
        @Override
        public int getColumnCount() {

            if (columnNames == null) {
                columnNames = new String[]{"Attribute", "value"};
            }
            return columnNames.length;
        }

        @Override
        public int getRowCount() {

            return infoMessages.size();
        }

        @Override
        public String getColumnName(int col) {

            return columnNames[col];
        }

        @Override
        public Class getColumnClass(int c) {

            return getValueAt(0, c).getClass();
        }

        @Override
        public boolean isCellEditable(int row, int col) {

            return false;
        }

        @Override
        public Object getValueAt(int row, int column) {

            // Obtain a Cart default
            InfoMessage ugr = (InfoMessage) infoMessages.get(row);

            try {

                if (column == 0) {
                    return ugr.stockcode;
                } else if (column == 1) {
                    String show = "";
                    if (ugr.showQty) {
                        show = ugr.value;
                    } else {
                        show = ugr.description;
                    }

                    return show;

                }

                return "";

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return null;
        }

        public void refresh() {

            fireTableRowsDeleted(infoMessages.size(), infoMessages.size());
        }

        @Override
        public void removeRow(int row) {

            infoMessages.remove(row);
            fireTableRowsDeleted(infoMessages.size(), infoMessages.size());
        }

    }
}
