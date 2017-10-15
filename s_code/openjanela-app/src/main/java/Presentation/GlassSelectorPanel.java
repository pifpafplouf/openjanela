package Presentation;

import Model.GlassSU;
import openjanela.app.configuration.controller.GlassSelectorPanelController;
import openjanela.app.configuration.controller.SUTypeCustomOption;
import openjanela.app.configuration.controller.SUTypeSearchOption;
import openjanela.model.entities.admin.TypeGlazing;
import openjanela.model.entities.design.Metrics;
import openjanela.model.entities.orderEntry.CartDefault;
import openjanela.model.entities.partner.GlassSUColumns;
import openjanela.model.entities.partner.PartnerDefault;
import openjanela.model.entities.partner.SUFamily;
import openjanela.model.entities.partner.SUType;

import org.jdesktop.swingx.JXList;
import org.jdesktop.swingx.JXTable;

import org.openjanela.data.MenuActionEventDraw;
import util.XYConstraints;
import util.XYLayout;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif El Dibani
 * @author Eddy Montenegro
 * @version 2.0.8b
 *          Date: 02-26-13
 *          Time: 10:42 AM
 */
public class GlassSelectorPanel extends JPanel {

    ItemFrame myParent;

    public JPanel glassPanel = new JPanel();

    public JPanel glassScrollPanel = new JPanel();

    public static HashMap iconFiles = new HashMap();

    public JPanel topPanel = new JPanel();

    public JPanel mainPanel = new JPanel();

    public JPanel glassListPanel = new JPanel();

    public JPanel bottomPanel = new JPanel();

    public JPanel whichSelectedGlass = new JPanel();

    public JLabel myGlass = new JLabel();

    public JCheckBox lookGlass = new JCheckBox();

    public JLabel lookGlassL = new JLabel();

    public JCheckBox lookAllGlass = new JCheckBox();

    public JLabel lookAllGlassL = new JLabel();

    public JScrollPane glassScroll = new JScrollPane();

    public JScrollPane selectedglassScroll = new JScrollPane();

    public ButtonGroup viewGroup = new ButtonGroup();

    public ButtonGroup groups = new ButtonGroup();

    public int whichPos = 2;

    // 1-in, 2 mid 3 out

    public JComboBox cmbSearchOption = new JComboBox();
    public JComboBox cmbSearchValue = new JComboBox();

    public JTextField txtSearchValue = new JTextField();

    public String[] partStrings2 = {" Cat 2 - 1", " Cat 2 - 2", " Cat 2 - 3", " Cat 2 - 4"};

    public JComboBox glassClass2 = new JComboBox(partStrings2);

    public JCheckBox class2 = new JCheckBox();

    public JLabel glassClassLabel = new JLabel();
    public JLabel glassClassLabel2 = new JLabel();

    public JRadioButton allGlass = new JRadioButton();
    public JRadioButton oneGlass = new JRadioButton();

    public JLabel allGlassL = new JLabel();
    public JLabel oneGlassL = new JLabel();

    public JPanel actionPanel = new JPanel();
    public JPanel actionSelectedPanel = new JPanel();
    public JPanel glassClassPanel = new JPanel();

    public JButton editSUType = new JButton();
    public JButton editGlass = new JButton();

    public ButtonGroup whichLevel = new ButtonGroup();

    public int selectedGlassLevel = 1; // 2 = Frame 1 = Overall

    public GlassSU glass = null;

    public JXList glassList = new JXList();
    public JXList selectedGlassList = new JXList();

    public JXTable glassPropertiesTable = new JXTable(); //Show glass properties configured

    JButton search = new JButton();

    //*******************************************************************
    //Controller services
    //*******************************************************************
    private GlassSelectorPanelController glassController;

    //*******************************************************************
    // Getters and Setters
    //*******************************************************************

    public GlassSelectorPanelController getGlassController() {
        return glassController;
    }

    /**
     * Default constructor
     *
     * @param frame, ItemFrame
     */
    public GlassSelectorPanel(ItemFrame frame) {

        //Setting ItemFrame parent
        this.myParent = frame;

        //Init controller
        glassController = new GlassSelectorPanelController();

        //Init components layout
        this.initComponentsLayout();

        //Init components values
        this.initComponentsValues();

        //registerListeners
        this.registerListeners();
    }

    /**
     * This method set default Sealed Unit
     */
    public void setDefaultSU() {

        boolean goodToGo = true;

        if (glassList.getModel().getSize() > 0) {

            this.myParent.mySelectedSU = ((SUType) this.glassList.getModel().getElementAt(0));

            glassController.setSuTypeSelected(this.myParent.mySelectedSU);

            if (whichPos == 1) {

                myParent.mySelectedSUIn = this.myParent.mySelectedSU;
                glassController.setSuTypeSelected(myParent.mySelectedSUIn);
            }
            if (whichPos == 2) {
                this.myParent.mySelectedSU = myParent.mySelectedSUMid = this.myParent.mySelectedSU;
                glassController.setSuTypeSelected(myParent.mySelectedSUMid);

            }
            if (whichPos == 3) {
                this.myParent.mySelectedSU = myParent.mySelectedSUOut = this.myParent.mySelectedSU;
                glassController.setSuTypeSelected(myParent.mySelectedSUOut);
            }


            Object[] partnerDefaults = myParent.partnerDefaults.toArray();

            for (Object pd : partnerDefaults) {

                if (((PartnerDefault) pd).getPartnerDefaultPK().getDefaulttype() == 2) {

                    goodToGo = false;

                    for (Object s : this.glassController.getSuTypes().toArray()) {

                        if (((SUType) s).equals(ItemFrame.getApplicationBaseRules().getSUType(((PartnerDefault) pd)
                                .getPartnerDefaultPK().getOptions()))) {
                            goodToGo = true;
                            break;
                        }
                    }


                    if (goodToGo) {
                        if (whichPos == 1) {
                            if (((PartnerDefault) pd).getPartnerDefaultPK().getOptions() > 0) {
                                myParent.mySelectedSUIn = ItemFrame.getApplicationBaseRules().getSUType(((PartnerDefault) pd)
                                        .getPartnerDefaultPK().getOptions());
                                glassController.setSuTypeSelected(myParent.mySelectedSUIn);
                            }
                        }
                        if (whichPos == 2) {
                            if (((PartnerDefault) pd).getPartnerDefaultPK().getOptions() > 0) {
                                myParent.mySelectedSU = myParent.mySelectedSUMid = ItemFrame.getApplicationBaseRules().
                                        getSUType(((PartnerDefault) pd).getPartnerDefaultPK().getOptions());
                                glassController.setSuTypeSelected(myParent.mySelectedSUMid);
                            }
                        }
                        if (whichPos == 3) {
                            if (((PartnerDefault) pd).getPartnerDefaultPK().getOptions() > 0) {
                                myParent.mySelectedSUOut = ItemFrame.getApplicationBaseRules().getSUType(((PartnerDefault) pd)
                                        .getPartnerDefaultPK().getOptions());
                                glassController.setSuTypeSelected(myParent.mySelectedSUOut);
                            }
                        }
                    }
                    break;
                }
            }

            Object[] cartDefaults = myParent.cartDefaults.toArray();
            for (Object pd : cartDefaults) {
                if (((CartDefault) pd).getCartDefaultPK().getDefaultType() == 2) {

                    goodToGo = false;

                    for (Object s : this.glassController.getSuTypes().toArray()) {

                        if (((SUType) s).equals(ItemFrame.getApplicationBaseRules().getSUType(((CartDefault) pd).
                                getCartDefaultPK().getOptions()))) {
                            goodToGo = true;
                            break;
                        }
                    }


                    if (goodToGo) {

                        if (whichPos == 1) {
                            if (((CartDefault) pd).getCartDefaultPK().getOptions() > 0) {
                                myParent.mySelectedSUIn = ItemFrame.getApplicationBaseRules().getSUType(((CartDefault) pd).
                                        getCartDefaultPK().getOptions());
                                glassController.setSuTypeSelected(myParent.mySelectedSUIn);
                            }
                        }
                        if (whichPos == 2) {
                            if (((CartDefault) pd).getCartDefaultPK().getOptions() > 0) {
                                myParent.mySelectedSUMid = ItemFrame.getApplicationBaseRules().getSUType(((CartDefault) pd)
                                        .getCartDefaultPK().getOptions());
                                glassController.setSuTypeSelected(myParent.mySelectedSUMid);
                            }
                        }
                        if (whichPos == 3) {
                            if (((CartDefault) pd).getCartDefaultPK().getOptions() > 0) {
                                myParent.mySelectedSUOut = ItemFrame.getApplicationBaseRules().getSUType(((CartDefault) pd)
                                        .getCartDefaultPK().getOptions());
                                glassController.setSuTypeSelected(myParent.mySelectedSUOut);
                            }
                        }
                    }
                    break;

                }
            }
        }
    }

    /**
     * Init components values Panel
     */
    private void initComponentsLayout() {

        //***********************************************
        //Init Preference design options
        //***********************************************
        this.editGlass.setPreferredSize(new Dimension(30, 19));
        this.editSUType.setPreferredSize(new Dimension(30, 19));

        //***********************************************
        //Setting icons
        //***********************************************
        this.allGlassL.setIcon(ItemFrame.iconFiles.get("allglass"));
        this.oneGlassL.setIcon(ItemFrame.iconFiles.get("oneglass"));
        this.glassClassLabel.setIcon(ItemFrame.iconFiles.get("glassClass"));
        this.search.setIcon(ItemFrame.iconFiles.get("search"));
        this.editSUType.setIcon(ItemFrame.iconFiles.get("edit"));
        this.editGlass.setIcon(ItemFrame.iconFiles.get("edit"));
        this.lookGlassL.setIcon(ItemFrame.iconFiles.get("oneglass"));
        this.lookAllGlassL.setIcon(ItemFrame.iconFiles.get("allglass"));

        //************************************************
        //Setting tooltipText
        //************************************************
        this.allGlass.setToolTipText("Set All Glass");
        this.oneGlass.setToolTipText("Set Single Glass");
        this.allGlassL.setToolTipText("Set All Glass");
        this.oneGlassL.setToolTipText("Set Single Glass");
        this.glassClassLabel.setToolTipText("Category");
        this.glassClassLabel2.setToolTipText("Category 2");
        this.class2.setToolTipText("Category 2");
        this.search.setToolTipText("Search");
        this.editGlass.setToolTipText("Edit");

        //**********************************************
        //Setting buttons options
        //**********************************************
        this.glassClass2.setEnabled(false);
        this.editSUType.setEnabled(true);
        this.editGlass.setEnabled(true);
        this.lookAllGlass.setSelected(true);
        this.allGlass.setSelected(true);

        //ButtonGroup configuration
        this.whichLevel.add(allGlass);
        this.whichLevel.add(oneGlass);
        this.viewGroup.add(this.lookGlass);
        this.viewGroup.add(this.lookAllGlass);

        //Config glass List
        DefaultListModel listModel = new DefaultListModel();
        glassList.setModel(listModel);

        //Config selected glass List
        DefaultListModel selectedListModel = new DefaultListModel();
        selectedGlassList.setModel(selectedListModel);

        //Config cmbSearch comboBox option
        cmbSearchOption.setModel(new DefaultComboBoxModel(SUTypeSearchOption.values()));
        cmbSearchValue.setVisible(false);
        txtSearchValue.setVisible(false);

        //**********************************************
        //Config panels
        //**********************************************

        //Config Top panel
        this.topPanel.setPreferredSize(new Dimension(200, 23));
        this.topPanel.setBorder(BorderFactory.createEtchedBorder(Color.white, new Color(148, 145, 140)));
        this.topPanel.setLayout(new XYLayout());

        this.topPanel.add(this.allGlass, new XYConstraints(1, 0, 20, 19));
        this.topPanel.add(this.allGlassL, new XYConstraints(22, 0, 20, 19));
        this.topPanel.add(this.oneGlass, new XYConstraints(40, 0, 20, 19));
        this.topPanel.add(this.oneGlassL, new XYConstraints(62, 0, 20, 19));

        //Glass List panel
        this.glassListPanel.setLayout(new XYLayout());
        this.glassListPanel.setPreferredSize(new Dimension(200, 45));

        this.glassListPanel.add(this.glassClassLabel, new XYConstraints(1, 1, 20, 19));
        this.glassListPanel.add(this.cmbSearchOption, new XYConstraints(22, 1, 190, 19));
        this.glassListPanel.add(this.cmbSearchValue, new XYConstraints(22, 23, 190, 19));
        this.glassListPanel.add(this.txtSearchValue, new XYConstraints(22, 23, 190, 19));

        //Glass class panel
        this.glassClassPanel.setLayout(new XYLayout());
        this.glassClassPanel.setPreferredSize(new Dimension(200, 24));

        //Which Selected Glass
        this.whichSelectedGlass.setLayout(new XYLayout());
        this.whichSelectedGlass.add(this.lookAllGlass, new XYConstraints(1, 1, 20, 19));
        this.whichSelectedGlass.add(this.lookAllGlassL, new XYConstraints(22, 1, 20, 19));
        this.whichSelectedGlass.add(this.lookGlass, new XYConstraints(40, 1, 20, 19));
        this.whichSelectedGlass.add(this.lookGlassL, new XYConstraints(62, 1, 20, 19));

        //Action panel
        this.actionPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.actionPanel.setPreferredSize(new Dimension(198, 30));
        this.actionPanel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        //Action selected panel
        this.actionSelectedPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.actionSelectedPanel.setPreferredSize(new Dimension(198, 30));
        this.actionSelectedPanel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        this.actionPanel.add(this.editSUType);
        this.actionSelectedPanel.add(this.editGlass);

        //Configuring glass scroll
        this.glassScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.glassScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.glassScroll.getViewport().add(this.glassList);

        this.glassScrollPanel.setLayout(new BorderLayout());
        this.glassScrollPanel.add(this.glassScroll, BorderLayout.CENTER);
        this.glassScrollPanel.add(this.actionPanel, BorderLayout.SOUTH);

        this.selectedglassScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.selectedglassScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.selectedglassScroll.getViewport().add(this.selectedGlassList, BorderLayout.CENTER);
        this.selectedglassScroll.setPreferredSize(new Dimension(200, 105));

        //Bottom panel
        this.bottomPanel.setLayout(new BorderLayout());
        this.bottomPanel.setPreferredSize(new Dimension(200, 130));
        this.bottomPanel.add(this.selectedglassScroll, BorderLayout.CENTER);
        this.bottomPanel.add(this.actionSelectedPanel, BorderLayout.SOUTH);

        //Main panel
        this.mainPanel.setPreferredSize(new Dimension(200, 350));
        this.mainPanel.setLayout(new BorderLayout());
        this.mainPanel.add(this.glassListPanel, BorderLayout.NORTH);
        this.mainPanel.add(this.glassScrollPanel, BorderLayout.CENTER);
        this.mainPanel.add(this.bottomPanel, BorderLayout.SOUTH);

        //Config glass panel
        this.glassPanel.setLayout(new BorderLayout());
        this.glassPanel.setPreferredSize(new Dimension(198, 480));
        this.glassPanel.add(this.topPanel, BorderLayout.NORTH);
        this.glassPanel.add(this.mainPanel, BorderLayout.CENTER);
    }

    /**
     * Init components values
     */
    public void initComponentsValues() {

        //Search for valid glass using the series selected value
        glassController.findValidSUTypes(myParent.baseUOM);
        glassController.findSUFamily();
        glassController.findTypeGlazing();

        //Clear list model
        ((DefaultListModel) glassList.getModel()).clear();

        //Init Glass List
        for (SUType suType : glassController.getSuTypes()) {
            ((DefaultListModel) glassList.getModel()).addElement(suType);
        }
    }

    /**
     * Register Listeners events components
     */
    private void registerListeners() {

        this.oneGlass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedGlassLevel = 2;
            }
        });

        this.allGlass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedGlassLevel = 1;
            }
        });

        this.class2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (class2.isSelected()) {
                    glassClass2.setEnabled(true);
                } else {
                    glassClass2.setEnabled(false);
                }
            }
        });

        this.cmbSearchOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                SUTypeSearchOption suTypeSearchOption = (SUTypeSearchOption) cb.getSelectedItem();

                if (suTypeSearchOption.getValue() == SUTypeSearchOption.GLAZING_TYPE.getValue()) {
                    txtSearchValue.setVisible(false);
                    cmbSearchValue.setVisible(true);

                    //Remove all items comboBox
                    cmbSearchValue.removeAllItems();

                    //Find valid type glazing
                    glassController.findTypeGlazing();

                    //Adding items custom values
                    cmbSearchValue.setModel(new DefaultComboBoxModel(glassController.getTypeGlazings().toArray()));

                } else if (suTypeSearchOption.getValue() == SUTypeSearchOption.IS_CUSTOM.getValue()) {
                    txtSearchValue.setVisible(false);
                    cmbSearchValue.setVisible(true);

                    //Remove all items comboBox
                    cmbSearchValue.removeAllItems();

                    //Adding items custom values
                    cmbSearchValue.setModel(new DefaultComboBoxModel(SUTypeCustomOption.values()));

                } else if (suTypeSearchOption.getValue() == SUTypeSearchOption.NUM_OF_LEAVES.getValue()) {
                    txtSearchValue.setVisible(true);
                    cmbSearchValue.setVisible(false);
                } else if (suTypeSearchOption.getValue() == SUTypeSearchOption.THICKNESS.getValue()) {
                    txtSearchValue.setVisible(true);
                    cmbSearchValue.setVisible(false);
                } else if (suTypeSearchOption.getValue() == SUTypeSearchOption.FAMILY.getValue()) {
                    txtSearchValue.setVisible(false);
                    cmbSearchValue.setVisible(true);

                    //Remove all items comboBox
                    cmbSearchValue.removeAllItems();

                    //Find valid family
                    glassController.findSUFamily();

                    //Adding items custom values
                    cmbSearchValue.setModel(new DefaultComboBoxModel(glassController.getSuFamilyList().toArray()));

                } else if (suTypeSearchOption.getValue() == SUTypeSearchOption.DESCRIPTION.getValue()) {
                    txtSearchValue.setVisible(true);
                    cmbSearchValue.setVisible(false);
                } else if (suTypeSearchOption.getValue() == SUTypeSearchOption.STOCKCODE.getValue()) {
                    txtSearchValue.setVisible(true);
                    cmbSearchValue.setVisible(false);
                } else if (suTypeSearchOption.getValue() == SUTypeSearchOption.SEARCH_OPTION.getValue()) {
                    txtSearchValue.setVisible(false);
                    cmbSearchValue.setVisible(false);

                    //Clear glass List
                    ((DefaultListModel) glassList.getModel()).clear();

                    //Init Glass List
                    for (SUType suType : glassController.getSuTypes()) {
                        ((DefaultListModel) glassList.getModel()).addElement(suType);
                    }
                }
            }
        });

        this.txtSearchValue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (KeyEvent.VK_ENTER == e.getKeyCode()) {

                    SUTypeSearchOption suTypeSearchOption = (SUTypeSearchOption) cmbSearchOption.getSelectedItem();

                    //List of SUTypeList
                    List<SUType> suTypeList = new ArrayList<SUType>();

                    if (suTypeSearchOption.getValue() == SUTypeSearchOption.NUM_OF_LEAVES.getValue()) {
                        //Filter list of SUTypes
                        suTypeList = glassController.filterSUTypes(null, false, new Integer(txtSearchValue.getText()),
                                null, null, null, null);
                    } else if (suTypeSearchOption.getValue() == SUTypeSearchOption.THICKNESS.getValue()) {
                        //Filter list of SUTypes
                        suTypeList = glassController.filterSUTypes(null, false, null,
                                new Integer(txtSearchValue.getText()),
                                null, null, null);
                    } else if (suTypeSearchOption.getValue() == SUTypeSearchOption.DESCRIPTION.getValue()) {
                        //Filter list of SUTypes
                        suTypeList = glassController.filterSUTypes(null, false, null, null, null, txtSearchValue.getText(),
                                null);
                    } else if (suTypeSearchOption.getValue() == SUTypeSearchOption.STOCKCODE.getValue()) {
                        //Filter list of SUTypes
                        suTypeList = glassController.filterSUTypes(null, false, null, null,
                                null, null, txtSearchValue.getText());
                    } else if (suTypeSearchOption.getValue() == SUTypeSearchOption.SEARCH_OPTION.getValue()) {
                        //Get all list of SUTypes
                        suTypeList = glassController.getSuTypes();
                    }

                    //Clear glass List
                    ((DefaultListModel) glassList.getModel()).clear();

                    for (SUType suType : suTypeList) {
                        ((DefaultListModel) glassList.getModel()).addElement(suType);
                    }

                }
            }
        });

        this.cmbSearchValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JComboBox cb = (JComboBox) e.getSource();

                //Get selected Item
                Object obj = cb.getSelectedItem();

                if (obj instanceof TypeGlazing) {

                    //Get type glazing object
                    TypeGlazing typeGlazing = (TypeGlazing) obj;

                    //Filter list of SUTypes
                    List<SUType> suTypeList = glassController.filterSUTypes(typeGlazing.getId(), false, null, null,
                            null, null, null);

                    //Clear glass List
                    ((DefaultListModel) glassList.getModel()).clear();

                    for (SUType suType : suTypeList) {
                        ((DefaultListModel) glassList.getModel()).addElement(suType);
                    }

                } else if (obj instanceof SUTypeCustomOption) {

                    //Get type custom option
                    SUTypeCustomOption suTypeCustomOption = (SUTypeCustomOption) obj;

                    //Filter list of SUTypes
                    List<SUType> suTypeList = glassController.filterSUTypes(null, true, null,
                            null, null, null, null);

                    //Clear glass List
                    ((DefaultListModel) glassList.getModel()).clear();

                    for (SUType suType : suTypeList) {
                        ((DefaultListModel) glassList.getModel()).addElement(suType);
                    }

                } else if (obj instanceof SUFamily) {

                    //Get SUFamily
                    SUFamily suFamily = (SUFamily) obj;

                    //Filter list of SUTypes
                    List<SUType> suTypeList = glassController.filterSUTypes(null, false, null, null, suFamily.getId(),
                            null, null);

                    //Clear glass List
                    ((DefaultListModel) glassList.getModel()).clear();

                    for (SUType suType : suTypeList) {
                        ((DefaultListModel) glassList.getModel()).addElement(suType);
                    }
                }
            }
        });

        this.glassList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                //****************************************************
                //Recalculate Bom for Window
                //****************************************************
                myParent.calcBom = true;

                //Setting Action Type Event
                myParent.setActionTypeEvent(MenuActionEventDraw.GLASS_SEALED_UNIT_EVENT.getValue());

                //Get SUType selected and setting in state change
                if (whichPos == 1) {

                    myParent.mySelectedSUIn = (SUType) glassList.getSelectedValue();

                    setSuTypeSelected(myParent.mySelectedSUIn);

                    glassController.setSuTypeSelected(myParent.mySelectedSUIn);

                    if (myParent.mySelectedSUIn != null) {
                        if (myParent.mySelectedSUIn.getCustom() && myParent.mySelectedSUIn.getGlazingType() == 2)
                            editSUType.setEnabled(myParent.mySelectedSUIn.getCustom());

                        if (allGlass.isSelected()) {
                            myParent.jobItem.design.searchOpeningAnsSetSUType();
                        }
                    }

                }

                if (whichPos == 2) {

                    myParent.mySelectedSUMid = (SUType) glassList.getSelectedValue();
                    setSuTypeSelected(myParent.mySelectedSUMid);
                    glassController.setSuTypeSelected(myParent.mySelectedSUMid);

                    if (myParent.mySelectedSUMid != null) {
                        if (myParent.mySelectedSUMid.getCustom() && myParent.mySelectedSUMid.getGlazingType() == 2)
                            editSUType.setEnabled(myParent.mySelectedSUMid.getCustom());

                        if (allGlass.isSelected()) {
                            myParent.jobItem.design.searchOpeningAnsSetSUType();
                        }
                    }
                }

                if (whichPos == 3) {
                    myParent.mySelectedSUOut = (SUType) glassList.getSelectedValue();
                    setSuTypeSelected(myParent.mySelectedSUOut);
                    glassController.setSuTypeSelected(myParent.mySelectedSUOut);

                    if (myParent.mySelectedSUOut != null) {
                        if (myParent.mySelectedSUOut.getCustom() && myParent.mySelectedSUOut.getGlazingType() == 2)
                            editSUType.setEnabled(myParent.mySelectedSUOut.getCustom());

                        if (allGlass.isSelected()) {
                            myParent.jobItem.design.searchOpeningAnsSetSUType();
                        }
                    }

                }

                if (allGlass.isSelected()) {
                    if (myParent.cView != null) {
                        myParent.cView.initPriceCategories();
                    }

                    //Reset Options values
                    myParent.options.initValues();
                }

                if (oneGlass.isSelected()) {
                    myParent.myCursorImage = ItemFrame.iconFiles.get("oneglass");
                    myParent.myCursor = myParent.toolkit.createCustomCursor(myParent.myCursorImage.getImage(), new Point(0, 0), "");
                    myParent.startCustomCursor(myParent.main, myParent.myCursor);
                }
            }
        });

        this.editGlass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (glassController.getGlassSUSelected() != null) {
                    //Open Glass SU Dialog editing
                    new GlassSUDialog(myParent, glassController);
                }
            }
        });

        this.editSUType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (glassController.getSuTypeSelected() != null) {

                    //Open SU Dialog editing
                    new SUDetailsDialog(myParent, glassController);
                }
            }
        });

        lookAllGlass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lookAllGlass.isSelected()) {
                    //Show table properties into selected glass scroll
                    selectedglassScroll.getViewport().remove(glassPropertiesTable);
                    selectedglassScroll.getViewport().add(selectedGlassList);
                }
            }
        });

        lookGlass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lookGlass.isSelected()) {
                    //Show table properties into selected glass scroll
                    selectedglassScroll.getViewport().remove(selectedGlassList);
                    selectedglassScroll.getViewport().add(glassPropertiesTable);
                }
            }
        });
    }

    /**
     * Setting selected glass List to the JList
     *
     * @param glassSU, GlassSU
     */
    public void setSelectedGlassList(GlassSU glassSU) {

        if (allGlass.isSelected()) {
            //Clear glass List
            ((DefaultListModel) selectedGlassList.getModel()).clear();
        }

        /** Iterate selected glass list to find the glassSU element and dont repeated into the list */
        DefaultListModel listModel = (DefaultListModel) selectedGlassList.getModel();

	    /* Evaluate if list model is not empty */
        if (listModel.getSize() > 0) {

		    /* Found glass boolean value */
            boolean foundGlass = false;

            for (int i = 0; i < listModel.getSize(); i++) {

                GlassSU selectedGlass = (GlassSU) listModel.get(i);

			    /* Verifiying if the selected glass is listed */
                if (selectedGlass.stockCode.trim().equals(glassSU.stockCode.trim())) {
                    foundGlass = true;
                }
            }

		    /* Adding glass to List model table */
            if (!foundGlass) {
                listModel.addElement(glassSU);
            }

        } else {
            listModel.addElement(glassSU); //Adding glassSU if list model is empty
        }

	    /* If look glass properties is selected - show information list table model */
        if (lookGlass.isSelected()) {
            configGlassPropertiesTable(glassSU);
        }

        //****************************************************
        //Recalculate Bom for Window
        //****************************************************
        this.myParent.calcBom = true;
    }

    /**
     * Config Glass SU Properties table
     *
     * @param glassSU, GlassSU
     */
    public void configGlassPropertiesTable(GlassSU glassSU) {

        try {

            //Column name JTable
            String[] columnNames = {"Property", "Value"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            //Get glass SU Class
            Class glassSUClass = glassSU.getClass();

            //Get fields class
            Field[] fields = null;

            if (myParent.currentUOM == Metrics.METRIC.getValue()) {

                fields = new Field[]{glassSUClass.getField("stockCode"), glassSUClass.getField("description"),
                        glassSUClass.getField("widthM"), glassSUClass.getField("heightM"), glassSUClass.getField("cost"),
                        glassSUClass.getField("price")};

            } else if (myParent.currentUOM == Metrics.IMPERIAL_DECIMAL.getValue() || myParent.baseUOM == Metrics.IMPERIAL_FRACTION.getValue()) {

                fields = new Field[]{glassSUClass.getField("stockCode"), glassSUClass.getField("description"),
                        glassSUClass.getField("widthI"), glassSUClass.getField("heightI"),
                        glassSUClass.getField("cost"), glassSUClass.getField("price")};
            }

            for (Field field : fields) {
                Object[] row = new Object[2];
                row[0] = GlassSUColumns.NONE.getColumnName(field.getName());

                if (field.getName().equals(GlassSUColumns.WIDTHM.getValue()) || field.getName().equals(GlassSUColumns.WIDTHI.getValue()) ||
                        field.getName().equals(GlassSUColumns.HEIGHTM.getValue()) || field.getName().equals(GlassSUColumns.HEIGHTI.getValue())) {
                    if (myParent.currentUOM == Metrics.METRIC.getValue()) {
                        row[1] = field.getInt(glassSU) / 100;
                    } else if (myParent.currentUOM == Metrics.IMPERIAL_DECIMAL.getValue() ||
                            myParent.currentUOM == Metrics.IMPERIAL_FRACTION.getValue()) {
                        row[1] = field.getInt(glassSU) / 64;
                    }
                } else {
                    row[1] = field.get(glassSU);
                }

                tableModel.addRow(row);
            }

            //Setting table model
            glassPropertiesTable.setModel(tableModel);
            glassPropertiesTable.setEditable(false);
            glassPropertiesTable.setSortable(false);
            //Show table properties into selected glass scroll
            this.selectedglassScroll.getViewport().remove(selectedGlassList);
            this.selectedglassScroll.getViewport().add(glassPropertiesTable, BorderLayout.CENTER);

            //Clean suType selected from controller
            setSuTypeSelected(null);

            //Setting glassSU Selected view properties
            this.glassController.setGlassSUSelected(glassSU);

            //Evaluate if glassSU is customizable to enable editGlass
            editGlass.setEnabled(glassSU.isCustom);

        } catch (NoSuchFieldException e) {
            System.err.println(e.getMessage());
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Return a Sealed Unit Selected
     *
     * @return SUType
     */
    public SUType getSuTypeSelected() {

        if (this.whichPos == 1) {
            return myParent.mySelectedSUIn;
        } else if (this.whichPos == 2) {
            return myParent.mySelectedSUMid;
        } else {
            return myParent.mySelectedSUOut;
        }
    }

    /**
     * Setting Sealed Unit Selected
     *
     * @param suType, SUType
     */
    public void setSuTypeSelected(SUType suType) {

        if (this.whichPos == 1) {
            myParent.mySelectedSUIn = suType;
        } else if (this.whichPos == 2) {
            myParent.mySelectedSUMid = suType;
        } else {
            myParent.mySelectedSUOut = suType;
        }
    }

}
