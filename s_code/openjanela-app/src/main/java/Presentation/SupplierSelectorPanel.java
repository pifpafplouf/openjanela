package Presentation;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.*;

import openjanela.app.configuration.controller.SupplierSelectorPanelController;
import openjanela.model.entities.partner.Partner;
import openjanela.model.entities.partner.SUType;
import openjanela.model.entities.partner.Series;
import openjanela.model.entities.partner.TypeCouplerMullion;
import openjanela.model.entities.partner.ValidCouplerMullions;
import openjanela.model.entities.partner.ValidOrientations;
import util.XYConstraints;
import util.XYLayout;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif El Dibani
 * @author Eddy Montenegro
 * @version 2.0.8
 */
public class SupplierSelectorPanel extends JPanel {

    public ItemFrame myParent;

    public JPanel mainPanel = new JPanel();

    private final JLabel supplierLbl = new JLabel();
    private final JLabel seriesLbl = new JLabel();

    public final JComboBox suppliersCmb = new JComboBox();

    public final JComboBox seriesCmb = new JComboBox();

    public final JButton setSS = new JButton();

    //*********************************************************
    //Controller services
    //*********************************************************
    private SupplierSelectorPanelController supplierController;

    public SupplierSelectorPanelController getSupplierController() {
        return supplierController;
    }

    public void setSupplierController(SupplierSelectorPanelController supplierController) {
        this.supplierController = supplierController;
    }

    /**
     * Create Supplier Selector Panel with ItemFrame parent container
     *
     * @param frame, ItemFrame
     */
    public SupplierSelectorPanel(ItemFrame frame) {

        //Init ItemFrame
        this.myParent = frame;

        //Init controller
        supplierController = new SupplierSelectorPanelController();

        //Init components values
        initComponentsValues();

        //Init components layout
        initComponentsLayout();

        //Init listeners events
        registerListeners();
    }

    //******************************************************************************************************************
    //INITIALIZATION METHODS
    //******************************************************************************************************************

    /**
     * Init components values and configuration properties values
     */
    private void initComponentsValues() {

        //Setting components properties
        supplierLbl.setToolTipText("Supplier");
        seriesLbl.setToolTipText("Product Series/Profile System");
        setSS.setToolTipText("Set Supplier and Series");

        supplierLbl.setIcon(myParent.supplierImage);
        seriesLbl.setIcon(myParent.seriesImage);
        setSS.setIcon(myParent.setImage);

        suppliersCmb.setEnabled(false);
        seriesCmb.setEnabled(false);
        setSS.setEnabled(false);
    }

    /**
     * Configure layout panel design
     */
    private void initComponentsLayout() {

        //Config panel configuration
        this.mainPanel.setLayout(new XYLayout());
        this.mainPanel.setPreferredSize(new Dimension(225, 62));

        //Putting components panel position
        mainPanel.add(supplierLbl, new XYConstraints(1, 1, 20, 19));
        mainPanel.add(suppliersCmb, new XYConstraints(25, 0, 200, 19));

        mainPanel.add(seriesLbl, new XYConstraints(4, 21, 20, 19));
        mainPanel.add(seriesCmb, new XYConstraints(25, 21, 200, 19));
        mainPanel.add(setSS, new XYConstraints(185, 42, 40, 19));
    }

    /**
     * Init combo box supplier selector panel
     */
    public void initCombos() {

        //Get partners collection
        List<Partner> partners = supplierController.getPartners();

        //Adding partners to suppliers comboBox
        suppliersCmb.setModel(new DefaultComboBoxModel(partners.toArray()));

        for (Partner partner : partners) {
            if (partner.getId() == this.myParent.supplierID) {

                //Set Selected Index and trigger action performed
                supplierController.setPartnerSelected(partner);

                //Set selected supplier Item comboBox
                suppliersCmb.setSelectedItem(partner);
            }
        }
    }

    /**
     * Register listeners events components
     */
    private void registerListeners() {

        //Supplier Combo Box component
        suppliersCmb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supplierCmbAction();
            }
        });

        // Series Combo Box component
        seriesCmb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Search series selected
                seriesCmbAction();
            }
        });
    }

    //******************************************************************************************************************
    //ACTION EVENTS METHODS
    //******************************************************************************************************************

    /**
     * Supplier comboBox action performed
     * <a>Trigger series comboBox options</a>
     */
    public void supplierCmbAction() {

        //***********************************************************
        //Select partner (Supplier) from ComboBox and trigger action
        //***********************************************************
        if (suppliersCmb.getSelectedIndex() <= 0) {

            //Setting selected supplier Id to JobItem
            myParent.supplierID = 0;
            if (myParent.jobItem != null) {
                myParent.jobItem.supplierid = 0;
            }

        } else if (suppliersCmb.getSelectedIndex() > 0) {

            //Setting selected supplier Id to JobItem
            supplierController.setPartnerSelected((Partner) suppliersCmb.getSelectedItem());
            myParent.supplierID = supplierController.getPartnerSelected().getPartnerid();
            if (myParent.jobItem != null) {
                myParent.jobItem.supplierid = supplierController.getPartnerSelected().getPartnerid();
            }
        }

        //Clear series comboBox items
        seriesCmb.removeAllItems();

        //Get series for partner selected
        List<Series> series = supplierController.getSeries(myParent.supplierID);

        //Adding series items to comboBox
        seriesCmb.setModel(new DefaultComboBoxModel(series.toArray()));

        for (Series serie : series) {
            if (serie.getId() == this.myParent.seriesID) {

                //Set Combo Box selected series
                seriesCmb.setSelectedItem(serie);

                //Setting selected series
                supplierController.setSeriesSelected(serie);
            }
        }

        reInitDesign();
    }


    /**
     * Series ComboBox action performed
     * <a>Trigger shape selection options for series selected</a>
     */
    public void seriesCmbAction() {

        //Get series selected from comboBox
        Series series = (Series) seriesCmb.getSelectedItem();
        supplierController.setSeriesSelected(series);

        //Evaluate madeIn option from comboBox
        if (series != null) {

            //Setting selected series Id to JobItem
            this.myParent.mySeries = series;

            //Init Rules for design
            this.myParent.initRules(series);

            //Init valid series options
            initValidSeriesOptions(series);

            //Init valid shapes options
            initValidShapesOptions();

            //Init valid openings options
            initValidOpenings();

            //Init valid couplers mullions
            initValidCouplersMullions();

            //Init valid glass options
            initValidGlass();
        }

        reInitDesign();
    }

    /**
     * Re-Init and Execute Rules for Current Design
     */
    public void reInitDesign() {

        try {

            if (this.myParent.jobItem.design != null) {
                this.myParent.jobItem.design.initOpenOverall(this.myParent.jobItem._WIDTHpix * myParent.scale.doubleValue(),
                        this.myParent.jobItem._HEIGHTpix * myParent.scale.doubleValue());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //******************************************************************************************************************
    // CONFIGURATION OPTIONS FOR SERIES
    //******************************************************************************************************************

    /**
     * Init valid Series options for design configurator
     * <p>SupplierSelectorPanel</p>
     *
     * @param series, Series
     */
    private void initValidSeriesOptions(Series series) {
        myParent.mySeries.setId(series.getId());
        myParent.mySeries.setDescription(series.getDescription());
        myParent.mySeries.setDescriptionLong(series.getDescriptionLong());
        myParent.mySeries.setSupplierId(series.getSupplierId());
        myParent.mySeries.setDecimalsMetric(series.getDecimalsMetric());
        myParent.mySeries.setDecimalsImp(series.getDecimalsImp());
        myParent.mySeries.setDefaultOpeningType(series.getDefaultOpeningType());
        myParent.mySeries.setDefaultOpeningClass(series.getDefaultOpeningClass());
    }

    /**
     * Init valid shapes options for design configurator
     * <p>ShapeSelectorPanel</p>
     *
     * @see Presentation.ShapeSelectorPanel
     */
    private void initValidShapesOptions() {

        //Search for valid shapes using the series selected value
        myParent.shapesPanel.getShapeController().findValidShapes(myParent.mySeries.getId());

        //Init valid shapes values
        for (Map.Entry<Integer, JButton> shapeButton : myParent.shapesPanel.getShapesButtonsMap().entrySet()) {
            boolean enable = myParent.shapesPanel.getShapeController().isContainsValidShapes(shapeButton.getKey());
            shapeButton.getValue().setEnabled(enable);
        }
    }

    /**
     * Init valid sashes options for design configurator
     * <p>SashSelectorPanel</p>
     *
     * @see Presentation.SashSelectorPanel
     */
    private void initValidOpenings() {
        //Do opening click option default
        this.myParent.sashPanel.initValueComponents();
    }

    /**
     * Init valid couplers and mullions for design configurator
     * <p>CouplerAndMullionPanel</p>
     *
     * @see Presentation.CouplerAndMullionPanel
     */
    private void initValidCouplersMullions() {

        //Search for valid couplers and mullions using series selected value
        List<TypeCouplerMullion> list = myParent.mullionsPanel.getCouplerMullionController().findValidCouplerMullions(this.myParent.mySeries.getId());
   	
        List<TypeCouplerMullion> validCouplers = myParent.mullionsPanel. getCouplerMullionController().filterCouplerMullion(1,1);
        
        List<TypeCouplerMullion> validDividers = myParent.mullionsPanel.
  			   getCouplerMullionController().filterCouplerMullion(0,1);
        
        if(validDividers.size()<=0 && validCouplers.size()<=0){
     	   myParent.mullionsPanel.vC.setEnabled(false);
        }else{
     	   myParent.mullionsPanel.vC.setEnabled(true);
        }
       
        
        validCouplers = myParent.mullionsPanel.
     			   getCouplerMullionController().filterCouplerMullion(1,2);
        if(validCouplers.size()<=0){
     	   myParent.mullionsPanel.hC.setEnabled(false);
        }else{
     	   myParent.mullionsPanel.hC.setEnabled(true);
        }
        
        
        validCouplers = myParent.mullionsPanel.
     			   getCouplerMullionController().filterCouplerMullion(2,1);
        if(validCouplers.size()<=0){
     	   myParent.mullionsPanel.vM.setEnabled(false);
        }else{
     	   myParent.mullionsPanel.vM.setEnabled(true);
        }
        validCouplers = myParent.mullionsPanel.
     			   getCouplerMullionController().filterCouplerMullion(2,2);
        if(validCouplers.size()<=0){
     	   myParent.mullionsPanel.hM.setEnabled(false);
        }else{
     	   myParent.mullionsPanel.hM.setEnabled(true);
        }
    }

    /**
     * Init valid glass options for design configurator
     * <p>GlassSelectorPanel</p>
     *
     * @see Presentation.GlassSelectorPanel
     */
    private void initValidGlass() {

        //Search for valid glass using the series selected value
        myParent.glassPanel.getGlassController().findValidSUTypes(this.myParent.baseUOM);
        myParent.glassPanel.getGlassController().findSUFamily();
        myParent.glassPanel.getGlassController().findTypeGlazing();

        //Clear list model
        ((DefaultListModel) myParent.glassPanel.glassList.getModel()).clear();

        //Init Glass List
        for (SUType suType : myParent.glassPanel.getGlassController().getSuTypes()) {
            ((DefaultListModel) myParent.glassPanel.glassList.getModel()).addElement(suType);
        }
    }
}
