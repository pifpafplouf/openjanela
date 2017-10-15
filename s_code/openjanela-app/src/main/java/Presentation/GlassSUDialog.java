package Presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Collection;

import javax.imageio.IIOImage;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import openjanela.app.configuration.controller.GlassSelectorPanelController;
import openjanela.model.entities.admin.SystemUOM;
import openjanela.model.entities.admin.TypeGlazing;
import openjanela.model.entities.design.GlazingTypes;
import openjanela.model.entities.orderEntry.CostingGroup;
import openjanela.model.entities.orderEntry.PricingGroup;
import openjanela.model.entities.partner.MatrixHeader;
import openjanela.model.entities.partner.Partner;
import openjanela.model.entities.partner.ProductionLine;
import openjanela.model.entities.partner.SUFamily;
import openjanela.model.entities.partner.SUType;
import openjanela.model.entities.parts.Parts;
import org.openjanela.component.JXTaskPaneOJ;

import org.jdesktop.swingx.HorizontalLayout;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.VerticalLayout;

import util.LoadDataListUtil;
import util.XYConstraints;
import util.XYLayout;
import Model.GlassSU;

/**
 * Copyright (c) 2012 Openjanela. All rights reserved.
 * User: emortiz
 * Date: 11-29-12
 * Time: 04:15 PM
 */
public class GlassSUDialog extends JDialog {
	
	private int leafs = 2;
	
	//Init declaration properties
	private JXCollapsiblePane panelDetails;
	
	private JPanel panelContent;
	private JPanel panelButton;
	private JPanel panelButtonMain;
	
	private JXTaskPaneOJ headerPane;
	
	private JXTaskPaneOJ limitsPane;
	
	private JXTaskPaneOJ costPricePane;
	
	private JXTaskPaneOJ glassPane;
	
	private JXTaskPaneOJ imagePane;
	
	private JButton uploadButton;
	private JButton newButton;
	private JButton editButton;
	private JButton saveButton;
	private JButton copyButton;
	private JButton deleteButton;
	private JButton cancelButton;
	
	private JLabel fromDateL;
	private JLabel toDateL;
	
	private JXDatePicker fromDate;
	private JXDatePicker toDate;
	
	private final ItemFrame myParent;
	
	private Collection priceGroups;
	private Collection costGroups;
	private Collection matrices;
	private Collection inserts;
	private Collection uoms;
	private Collection suFamilies;
	private Collection glazingTypes;
	private Collection suppliers;
	private Collection prodLines;
	private Collection sealants;
	private Collection spacers;
	private Collection gases;
	private Collection processes;
	private Collection films;
	private Collection glass1;
	
	private JLabel idLbl;
	private JTextField idTxt;
	
	private JLabel scLbl;
	private JTextField scTxt;
	
	private JLabel descLbl;
	private JTextField descTxt;
	
	private JLabel nextLbl;
	private JTextField nextTxt;
	
	private JCheckBox displayChk;
	
	private JLabel wasteLbl;
	private JTextField wasteTxt;
	
	private JCheckBox madeinChk;
	private JCheckBox isCustomChk;
	
	private JLabel supidLbl;
	private JComboBox supCmb;
	
	private JLabel ltL;
	private JTextField ltT;
	
	private JLabel sortL;
	private JTextField sortTxt;
	
	private JLabel typeLbl;
	private JComboBox typeCmb;
	
	
	private JLabel noLeafsL;
	private JComboBox noLeafsC;
	
	
	private JLabel prodLineLbl;
	private JComboBox prodLineCmb;
	
	
	private JLabel familyL;
	private JComboBox familyCmb;
	
	
	private JLabel metric;
	private JLabel imperial;
	
	private JLabel thickL;
	private JTextField thickT;
	private JTextField thickiT;
	
	private JLabel gtoSL;
	private JTextField gtoST;
	private JTextField gtoSiT;
	
	private JLabel minAreaL;
	private JTextField minAreaT;
	private JTextField minAreaiT;
	
	private JLabel maxAreaL;
	private JTextField maxAreaT;
	private JTextField maxAreaiT;
	
	private JLabel minWL;
	private JTextField minWT;
	private JTextField minWiT;
	
	private JLabel maxWL;
	private JTextField maxWT;
	private JTextField maxWiT;
	
	private JLabel minHL;
	private JTextField minHT;
	private JTextField minHiT;
	
	private JLabel maxHL;
	private JTextField maxHT;
	private JTextField maxHiT;
	
	private JLabel whRatioL;
	private JTextField whRatioT;
	
	
	private JLabel priceuomL;
	private JComboBox priceuomC;
	
	
	private JCheckBox priceactualChk;
	private JCheckBox costactualChk;
	
	private JLabel costL;
	private JTextField costT;
	
	private JLabel priceL;
	private JTextField priceT;
	
	private JLabel minpriceL;
	private JTextField minpriceT;
	
	private JLabel priceMatrixL;
	private JComboBox priceMatrixC;
	
	private JLabel minpriceAL;
	private JTextField minpriceAT;
	private JTextField minpriceAiT;
	
	private JLabel mincostAL;
	private JTextField minpcostAT;
	private JTextField mincostAiT;
	
	private JLabel costGroupL;
	private JComboBox costGroupC;
	
	
	private JLabel priceGroupL;
	private JComboBox priceGroupC;
	
	private JLabel sealantL;
	private JComboBox sealantC;
	
	private JLabel insert1idLbl;
	private JComboBox insert1idC;
	
	private JLabel insert2idLbl;
	private JComboBox insert2idC;
	
	private JLabel insert3idLbl;
	private JComboBox insert3idC;
	
	private JLabel glass1L;
	private JLabel glassf1L;
	private JLabel glassp11L;
	private JLabel glassp12L;
	private JLabel glassp13L;
	
	/////////////////////////////////////////
	private JComboBox glass1C;
	private JComboBox glassf1C;
	private JComboBox glassp11C;
	private JComboBox glassp12C;
	private JComboBox glassp13C;
	
	////////////////////////////////////////
	private JLabel spacer1L;
	private JComboBox spacer1C;
	
	private JLabel gas1L;
	private JComboBox gas1C;
	
	private JLabel cp1L;
	private JComboBox cp1C;
	
	///////////////////////////////////////////
	private JComboBox glass2C;
	private JComboBox glassf2C;
	private JComboBox glassp21C;
	private JComboBox glassp22C;
	private JComboBox glassp23C;
	
	///////////////////////////////////////////
	private JLabel spacer2L;
	private JComboBox spacer2C;
	
	private JLabel gas2L;
	private JComboBox gas2C;
	
	private JLabel cp2L;
	private JComboBox cp2C;
	
	///////////////////////////////////////////
	private JComboBox glass3C;
	private JComboBox glassf3C;
	private JComboBox glassp31C;
	private JComboBox glassp32C;
	private JComboBox glassp33C;
	
	////////////////////////////////////////////
	private JLabel spacer3L;
	private JComboBox spacer3C;
	
	private JLabel gas3L;
	private JComboBox gas3C;
	
	private JLabel cp3L;
	private JComboBox cp3C;
	
	//////////////////////////////////////////
	private JComboBox glass4C;
	private JComboBox glassf4C;
	private JComboBox glassp41C;
	private JComboBox glassp42C;
	private JComboBox glassp43C;
	
	////////////////////////////////////////////
	private JCheckBox matrixPriceChk;
	private JLabel abbrevLbl;
	private JTextField abbrevTxt;
	
	private JCheckBox hasInsert1;
	private JCheckBox hasInsert2;
	private JCheckBox hasInsert3;
	
	
	JLabel imageArea = new JLabel();
	JLabel lblimage = new JLabel();
	private final byte[] image = null;
	File currentDict = new File("c:\\");
	JFileChooser chooser;
	String choosertitle;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	MemoryCacheImageOutputStream mos = new MemoryCacheImageOutputStream(baos);
	IIOImage finalimage;
	InputStream fis;
	public byte byteArrayImage[] = new byte[0];
	public byte[] imageBytes = null;
	
	//Controller implementation
	private final GlassSelectorPanelController controller;
	
	/**
	 * GlassSU Dialog Editing GlassSU
	 *
	 * @param parent,     ItemFrame
	 * @param controller, GlassSelectorPanelcontroller
	 */
	public GlassSUDialog(ItemFrame parent, GlassSelectorPanelController controller) {
		
		this.myParent = parent;
		
		this.controller = controller;
		
		//Init values
		this.initValues();
		
		//Init components
		this.initComponents();
		
		//Init SU editing values
		this.initEditSUValues();
		
		//Init Action Listeners objects
		this.initActionListeners();
		
		//Setting visible dialog
		this.setLocation((this.myParent.getWidth() - 700) / 2 - 100, (this.myParent.getHeight() - 300) / 2 - 200);
		this.setPreferredSize(new Dimension(myParent.getWidth() - 700, myParent.getHeight() - 200));
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setModal(true);
	}
	
	/**
	 * Init values
	 */
	private void initValues() {
		
		//Finding valid SUType
		this.controller.findValidSUType(controller.getGlassSUSelected().suID);
		
		//Init glazing types collection
		this.glazingTypes = controller.findTypeGlazingOrderById();
		this.suFamilies = controller.findSUFamilyOrderById();
		this.prodLines = controller.findProductionLineOrderById();
		this.suppliers = controller.findAllPartners();
		
		this.sealants = controller.findPartsByType(GlassSelectorPanelController.SEALANTS);
		this.gases = controller.findPartsByType(GlassSelectorPanelController.GASES);
		this.films = controller.findPartsByType(GlassSelectorPanelController.FILMS);
		this.spacers = controller.findPartsByType(GlassSelectorPanelController.SPACERS);
		this.processes = controller.findPartsByType(GlassSelectorPanelController.PROCESSES);
		this.glass1 = controller.findSUTypesByGlazingType(1);
		
		this.uoms = controller.findAllSystemUOM();
		this.matrices = controller.findSubMatrixHeadersBySeries(4);
		this.priceGroups = controller.findAllPricingGroup();
		this.costGroups = controller.findAllCostingGroup();
		
		this.inserts = controller.findSUTypesByGlazingType(3);
	}
	
	/**
	 * Init Edit SU Values
	 */
	private void initEditSUValues() {
		
		if (controller.getSuTypeSelected() != null) {
			
			//SU Type editing
			GlassSU glassSU = controller.getGlassSUSelected();
			SUType suType = controller.getSuTypeSelected();
			
			idTxt.setText(glassSU.suID + ""); //Id
			scTxt.setText(glassSU.stockCode); //Stock code
			descTxt.setText(glassSU.description); //Description
			nextTxt.setText(glassSU.nextItem + ""); //Next
			displayChk.setSelected(glassSU.display); //Display
			sortTxt.setText(glassSU.sortSeq + ""); //Sort sequence
			
			//Type Glazing
			for (Object typeGlazing : glazingTypes) {
				if (glassSU.glazingType == ((TypeGlazing) typeGlazing).getId())
					typeCmb.setSelectedItem(typeGlazing);
			}
			
			noLeafsC.setSelectedItem(String.valueOf(glassSU.numOfLeaves)); //Number of leaves
			this.leafs = suType.getNumOfLeaves();
			wasteTxt.setText(glassSU.waste + ""); //Waste
			
			//SU Family
			for (Object suFamily : suFamilies) {
				if (glassSU.familyId == ((SUFamily) suFamily).getId())
					familyCmb.setSelectedItem(suFamily);
			}
			
			madeinChk.setSelected(glassSU.madeIn); //Made in
			abbrevTxt.setText(glassSU.abbrev); //Abbrev
			
			//Production Line
			for (Object productionLine : prodLines) {
				if (glassSU.productionLine == ((ProductionLine) productionLine).getId())
					prodLineCmb.setSelectedItem(productionLine);
			}
			
			//Supplier
			for (Object supplier : suppliers) {
				if (glassSU.supplierId == ((Partner) supplier).getPartnerid())
					supCmb.setSelectedItem(supplier);
			}
			
			ltT.setText(glassSU.leadTime + ""); //Lead time
			fromDate.setDate(glassSU.startDate); //Start date
			toDate.setDate(glassSU.endDate); //End date
			isCustomChk.setSelected(glassSU.isCustom); //Custom
			
			//Thickness
			thickT.setText(glassSU.thickness + "");
			thickiT.setText(glassSU.thicknessImp + "");
			
			//Glass to Spacer in
			gtoST.setText(glassSU.glassToSpacer + "");
			gtoSiT.setText(glassSU.glassToSpacerImp + "");
			
			//Min Area
			minAreaT.setText(glassSU.minArea + "");
			minAreaiT.setText(glassSU.minAreaImp + "");
			
			//Max Area
			maxAreaT.setText(glassSU.maxArea + "");
			maxAreaiT.setText(glassSU.maxAreaImp + "");
			
			//Min W
			minWT.setText(glassSU.minWidth + "");
			minWiT.setText(glassSU.minWidthImp + "");
			
			//Max W
			maxWT.setText(glassSU.maxWidth + "");
			maxWiT.setText(glassSU.maxWidthImp + "");
			
			//Min H
			minHT.setText(glassSU.minHeight + "");
			minHiT.setText(glassSU.minHeightImp + "");
			
			//Max H
			maxHT.setText(glassSU.maxHeight + "");
			maxHiT.setText(glassSU.maxHeightImp + "");
			
			//Min price Area
			minpriceAT.setText(glassSU.minPricingArea + "");
			minpriceAiT.setText(glassSU.minPricingAreaImp + "");
			
			//Min cost Area
			minpcostAT.setText(glassSU.minCostArea + "");
			mincostAiT.setText(glassSU.minCostAreaImp + "");
			
			//Ratio
			whRatioT.setText(glassSU.whRatio + "");
			
			//Sealant
			for (Object part : sealants) {
				if (glassSU.sealantPartId == ((Parts) part).getId())
					sealantC.setSelectedItem(part);
			}
			
			//Glass1C
			for (Object glass : glass1) {
				if (glassSU.leaf1 == ((SUType) glass).getId()) {
					glass1C.setSelectedItem(glass);
				}
			}
			
			//Glass2C
			for (Object glass : glass1) {
				if (glassSU.leaf2 == ((SUType) glass).getId()) {
					glass2C.setSelectedItem(glass);
				}
			}
			
			//Glass3C
			for (Object glass : glass1) {
				if (glassSU.leaf3 == ((SUType) glass).getId()) {
					glass3C.setSelectedItem(glass);
				}
			}
			
			//Glass4C
			for (Object glass : glass1) {
				if (glassSU.leaf4 == ((SUType) glass).getId())
					glass4C.setSelectedItem(glass);
			}
			
			//Glassf1C
			for (Object part : films) {
				if (glassSU.film1 == ((Parts) part).getId())
					glassf1C.setSelectedItem(part);
			}
			
			//Glassf2C
			for (Object part : films) {
				if (glassSU.film2 == ((Parts) part).getId())
					glassf2C.setSelectedItem(part);
			}
			
			//Glassf3C
			for (Object part : films) {
				if (glassSU.film3 == ((Parts) part).getId())
					glassf3C.setSelectedItem(part);
			}
			
			//Glassf4C
			for (Object part : films) {
				if (glassSU.film4 == ((Parts) part).getId())
					glassf4C.setSelectedItem(part);
			}
			
			//Glass process 11
			for (Object part : processes) {
				if (glassSU.cavityProcess1 == ((Parts) part).getId())
					glassp11C.setSelectedItem(part);
			}
			
			//Glass process 12
			for (Object part : processes) {
				if (glassSU.cavityProcess2 == ((Parts) part).getId())
					glassp12C.setSelectedItem(part);
			}
			
			//Glass process 13
			for (Object part : processes) {
				if (glassSU.cavityProcess3 == ((Parts) part).getId())
					glassp13C.setSelectedItem(part);
			}
			
			//Glass process 21
			for (Object part : processes) {
				if (glassSU.cavityProcess2 == ((Parts) part).getId())
					glassp21C.setSelectedItem(part);
			}
			
			//Glass process 22
			for (Object part : processes) {
				if (glassSU.cavity2Process2 == ((Parts) part).getId())
					glassp22C.setSelectedItem(part);
			}
			
			//Glass process 23
			for (Object part : processes) {
				if (glassSU.cavity2Process3 == ((Parts) part).getId())
					glassp23C.setSelectedItem(part);
			}
			
			//Glass process 31
			for (Object part : processes) {
				if (glassSU.cavityProcess3 == ((Parts) part).getId())
					glassp31C.setSelectedItem(part);
			}
			
			//Glass process 32
			for (Object part : processes) {
				if (glassSU.cavity2Process3 == ((Parts) part).getId())
					glassp32C.setSelectedItem(part);
			}
			
			//Glass process 33
			for (Object part : processes) {
				if (glassSU.cavity3Process3 == ((Parts) part).getId())
					glassp33C.setSelectedItem(part);
			}
			
			//Glass process 41
			for (Object part : processes) {
				if (suType.getGlass4ProcessId().equals(((Parts) part).getId()))
					glassp41C.setSelectedItem(part);
			}
			
			//Glass process 42
			for (Object part : processes) {
				if (glassSU.external4Process2 == ((Parts) part).getId())
					glassp42C.setSelectedItem(part);
			}
			
			//Glass process 43
			for (Object part : processes) {
				if (glassSU.external4Process3 == ((Parts) part).getId())
					glassp43C.setSelectedItem(part);
			}
			
			//Spacer 1
			for (Object part : spacers) {
				if (glassSU.spacer1 == ((Parts) part).getId())
					spacer1C.setSelectedItem(part);
			}
			
			//Spacer 2
			for (Object part : spacers) {
				if (glassSU.spacer2 == ((Parts) part).getId())
					spacer2C.setSelectedItem(part);
			}
			
			//Spacer 3
			for (Object part : spacers) {
				if (glassSU.spacer3 == ((Parts) part).getId())
					spacer3C.setSelectedItem(part);
			}
			
			//Gas 1
			for (Object part : gases) {
				if (glassSU.gas1 == ((Parts) part).getId())
					gas1C.setSelectedItem(part);
			}
			
			//Gas 2
			for (Object part : gases) {
				if (glassSU.gas2 == ((Parts) part).getId())
					gas2C.setSelectedItem(part);
			}
			
			//Gas 3
			for (Object part : gases) {
				if (glassSU.gas3 == ((Parts) part).getId())
					gas3C.setSelectedItem(part);
			}
			
			//Cp 1
			for (Object part : processes) {
				if (glassSU.cavityProcess1 == ((Parts) part).getId())
					cp1C.setSelectedItem(part);
			}
			
			//Cp 2
			for (Object part : processes) {
				if (glassSU.cavityProcess2 == ((Parts) part).getId())
					cp2C.setSelectedItem(part);
			}
			
			//Cp 3
			for (Object part : processes) {
				if (glassSU.cavityProcess3 == ((Parts) part).getId())
					cp3C.setSelectedItem(part);
			}
			
			//Insert1id
			for (Object suTypeObject : inserts) {
				if (glassSU.insert1Id == ((SUType) suTypeObject).getId()) {
					insert1idC.setSelectedItem(suTypeObject);
					hasInsert1.setSelected(true);
				}
			}
			
			//Insert2id
			for (Object suTypeObject : inserts) {
				if (glassSU.insert2Id == ((SUType) suTypeObject).getId()) {
					insert2idC.setSelectedItem(suTypeObject);
					hasInsert2.setSelected(true);
				}
			}
			
			//Insert3id
			for (Object suTypeObject : inserts) {
				if (glassSU.insert3Id == ((SUType) suTypeObject).getId()) {
					insert3idC.setSelectedItem(suTypeObject);
					hasInsert3.setSelected(true);
				}
			}
			
			//Price UOM
			for (Object systemUOM : uoms) {
				if (glassSU.pricingUOMId == ((SystemUOM) systemUOM).getId()) {
					priceuomC.setSelectedItem(systemUOM);
				}
			}
			
			priceactualChk.setSelected(glassSU.priceActualSize); //Price actual
			costactualChk.setSelected(glassSU.costActualSize); //Cost actual
			priceT.setText(glassSU.price + ""); //Price
			minpriceT.setText(glassSU.minPrice + ""); //Min Price
			costT.setText(glassSU.cost + ""); //Cost
			
			//Pricing Group
			for (Object priceGroup : priceGroups) {
				if (glassSU.priceGroupId == ((PricingGroup) priceGroup).getId())
					priceGroupC.setSelectedItem(priceGroup);
			}
			
			//Costing Group
			for (Object costGroup : costGroups) {
				if (glassSU.costGroupId == ((CostingGroup) costGroup).getId())
					costGroupC.setSelectedItem(costGroup);
			}
			
			//Matrix
			for (Object matrixHeader : matrices) {
				if (glassSU.priceMatrixId == ((MatrixHeader) matrixHeader).getId()) {
					matrixPriceChk.setSelected(true);
					priceMatrixC.setSelectedItem(matrixHeader);
					priceMatrixC.setEnabled(true);
				}
			}
			
			//********************************************************************
			//Evaluating glazing type
			//********************************************************************
			if (glassSU.glazingType == GlazingTypes.GLASS.getValue()) {
				
				//Setting number of leafs combo box enabled
				this.noLeafsC.setEnabled(false);
				//Setting abbreviation to true
				this.abbrevTxt.setEnabled(true);
				
				//Redraw panel details
				this.panelDetails.removeAll();
				this.panelDetails.add(this.headerPane);
				this.panelDetails.add(this.limitsPane);
				this.panelDetails.add(this.costPricePane);
				this.panelDetails.add(this.panelButtonMain);
				
				this.limitsPane.setCollapsed(true);
				this.glassPane.setCollapsed(true);
				this.costPricePane.setCollapsed(true);
				
			} else if (glassSU.glazingType == GlazingTypes.SU.getValue()) {
				
				//Setting number of leafs combo box enabled
				//this.noLeafsC.setEnabled(true);
				//trigger noLeafs item state changed event to render SU Panel
				this.noLeafs_itemStateChanged(null);
				//Setting abbreviation to false
				this.abbrevTxt.setEnabled(false);
				
				//Redraw panel details
				this.panelDetails.removeAll();
				this.panelDetails.add(this.headerPane);
				this.panelDetails.add(this.limitsPane);
				this.panelDetails.add(this.glassPane);
				this.panelDetails.add(this.costPricePane);
				this.panelDetails.add(this.panelButtonMain);
				
				this.limitsPane.setCollapsed(true);
				this.glassPane.setCollapsed(false);
				this.costPricePane.setCollapsed(true);
				
			} else if (glassSU.glazingType >= GlazingTypes.INSERT.getValue()) {
				
				//Setting number of leafs combo box enabled
				this.noLeafsC.setEnabled(false);
				//Setting abbreviation to true
				this.abbrevTxt.setEnabled(false);
				
				//Redraw panel details
				this.panelDetails.removeAll();
				this.panelDetails.add(this.headerPane);
				//                this.panelDetails.add(this.imagePane);
				this.panelDetails.add(this.limitsPane);
				this.panelDetails.add(this.glassPane);
				this.panelDetails.add(this.costPricePane);
				this.panelDetails.add(this.panelButtonMain);
				
				this.glassPane.setCollapsed(true);
				this.limitsPane.setCollapsed(true);
				this.costPricePane.setCollapsed(true);
				//                this.imagePane.setCollapsed(false);
			}
		}
	}
	
	/**
	 * Setting edit values to SUType
	 */
	private void setValuesToSUType() {
		
		if (controller.getSuTypeSelected() != null) {
			
			//Get suType selected
			SUType suType = controller.getSuTypeSelected();
			GlassSU glassSU = controller.getGlassSUSelected();
			
			glassSU.stockCode = scTxt.getText(); //Stock code
			glassSU.description = descTxt.getText(); //Description
			//            suType.setNextItem(Integer.parseInt(nextTxt.getText())); //Next
			//            suType.setDisplay(displayChk.isSelected()); //Display
			//            suType.setSortSeq(Integer.parseInt(sortTxt.getText())); //Sort sequence
			//            suType.setGlazingType(typeCmb.getSelectedItem() != null ? ((TypeGlazing) typeCmb.getSelectedItem()).getId() : null); //Type Glazing
			//            suType.setNumOfLeaves(Integer.parseInt((String) noLeafsC.getSelectedItem())); //Number of leaves
			//            suType.setWaste(Double.parseDouble(wasteTxt.getText()));
			//            suType.setFamilyId(familyCmb.getSelectedItem() != null ? ((SUFamily) familyCmb.getSelectedItem()).getId() : null); //SU Family
			//            suType.setMadeIn(madeinChk.isSelected()); //Made in
			//            suType.setAbbrev(abbrevTxt.getText()); //Abbrev
			//            suType.setProductionLine(prodLineCmb.getSelectedItem() != null ? ((ProductionLine) prodLineCmb.getSelectedItem()).getId() : null); //Production Line
			glassSU.supplierId = supCmb.getSelectedItem() != null ? ((Partner) supCmb.getSelectedItem()).getId() : null; //Supplier
			//            suType.setLeadTime(Integer.parseInt(ltT.getText())); //Lead time
			//            suType.setStartDate(fromDate.getDate()); //Start date
			//            suType.setEndDate(toDate.getDate()); //End date
			//            suType.setCustom(isCustomChk.isSelected()); //Custom
			//            suType.setThickness(Integer.parseInt(thickT.getText())); //Thickness
			//            suType.setThicknessImp(Integer.parseInt(thickiT.getText())); //Thickness imperial
			//            suType.setGlassEdgeToSpacerIn(Integer.parseInt(gtoST.getText())); //Glass to spacer in
			//            suType.setGlassEdgeToSpacerInImp(Integer.parseInt(gtoSiT.getText())); //Glass to spacer in imperial
			//            suType.setMinArea(Double.parseDouble(minAreaT.getText()) * 10000); //Min area
			//            suType.setMinAreaImp(Double.parseDouble(minAreaiT.getText()) * 144); //Min area imperial
			//            suType.setMaxArea(Double.parseDouble(maxAreaT.getText()) * 10000); //Max area
			//            suType.setMaxAreaImp(Double.parseDouble(maxAreaiT.getText()) * 144); //Max area imperial
			//            suType.setMinArea(Double.parseDouble(minWT.getText()) * 100); //Min width
			//            suType.setMinAreaImp(Double.parseDouble(minWiT.getText()) * 64); //Min width imperial
			//            suType.setMaxWidth(Integer.parseInt(maxWT.getText()) * 100); //Max width
			//            suType.setMaxWidthImp(Integer.parseInt(maxWiT.getText()) * 64); //Max width imperial
			//            suType.setMaxHeight(Integer.parseInt(maxHT.getText()) * 100); //Max Height
			//            suType.setMaxHeightImp(Integer.parseInt(maxHiT.getText()) * 64); //Max Height imperial
			//            suType.setMinHeightImp(Integer.parseInt(minHiT.getText()) * 64); //Min Height imperial
			//            suType.setMinHeight(Integer.parseInt(minHT.getText()) * 100); //Min Height
			//            suType.setMinPricingArea(Double.parseDouble(minpriceAT.getText()) * 10000); //Min price area
			//            suType.setMinPricingAreaImp(Double.parseDouble(minpriceAiT.getText()) * 144); //Min price area imperial
			//            suType.setMinCostArea(Double.parseDouble(minpcostAT.getText())); //Min cost area
			//            suType.setMinCostAreaImp(Double.parseDouble(mincostAiT.getText())); //Min cost area imperial
			//            suType.setWhRatio(Double.parseDouble(whRatioT.getText())); //Ratio
			glassSU.sealantPartId = sealantC.getSelectedItem() != null ? ((Parts) sealantC.getSelectedItem()).getId() : -1; //Sealant
			glassSU.leaf1 = glass1C.getSelectedItem() != null ? ((SUType) glass1C.getSelectedItem()).getId() : -1; //Leaf1
			glassSU.leaf2 = glass2C.getSelectedItem() != null ? ((SUType) glass2C.getSelectedItem()).getId() : -1; //Leaf2
			glassSU.leaf3 = glass3C.getSelectedItem() != null ? ((SUType) glass3C.getSelectedItem()).getId() : -1; //Leaf3
			glassSU.leaf4 = glass4C.getSelectedItem() != null ? ((SUType) glass4C.getSelectedItem()).getId() : -1; //Leaf4
			glassSU.film1 = glassf1C.getSelectedItem() != null ? ((Parts) glassf1C.getSelectedItem()).getId() : -1; //film1
			glassSU.film2 = glassf2C.getSelectedItem() != null ? ((Parts) glassf2C.getSelectedItem()).getId() : -1; //film2
			glassSU.film3 = glassf3C.getSelectedItem() != null ? ((Parts) glassf3C.getSelectedItem()).getId() : -1; //film3
			glassSU.film4 = glassf4C.getSelectedItem() != null ? ((Parts) glassf4C.getSelectedItem()).getId() : -1; //film4
			glassSU.process1 = glassp11C.getSelectedItem() != null ? ((Parts) glassp11C.getSelectedItem()).getId() : -1; //process11
			glassSU.process2 = glassp12C.getSelectedItem() != null ? ((Parts) glassp12C.getSelectedItem()).getId() : -1; //process12
			glassSU.process3 = glassp13C.getSelectedItem() != null ? ((Parts) glassp13C.getSelectedItem()).getId() : -1; //process12
			glassSU.process1 = glassp21C.getSelectedItem() != null ? ((Parts) glassp21C.getSelectedItem()).getId() : -1; //process21
			glassSU.cavity2Process2 = glassp22C.getSelectedItem() != null ? ((Parts) glassp22C.getSelectedItem()).getId() : -1; //process22
			glassSU.cavity2Process3 = glassp23C.getSelectedItem() != null ? ((Parts) glassp23C.getSelectedItem()).getId() : -1; //process23
			glassSU.cavity1Process3 = glassp31C.getSelectedItem() != null ? ((Parts) glassp31C.getSelectedItem()).getId() : -1; //process31
			glassSU.cavity3Process2 = glassp32C.getSelectedItem() != null ? ((Parts) glassp32C.getSelectedItem()).getId() : -1; //process32
			glassSU.cavity3Process3 = glassp33C.getSelectedItem() != null ? ((Parts) glassp33C.getSelectedItem()).getId() : -1; //process33
			glassSU.glass4 = (glassp41C.getSelectedItem() != null ? ((Parts) glassp41C.getSelectedItem()).getId() : -1); //process41
			glassSU.glass4Process2 = glassp42C.getSelectedItem() != null ? ((Parts) glassp42C.getSelectedItem()).getId() : -1; //process42
			glassSU.glass4Process3 = glassp43C.getSelectedItem() != null ? ((Parts) glassp43C.getSelectedItem()).getId() : -1; //process43
			glassSU.spacer1 = spacer1C.getSelectedItem() != null ? ((Parts) spacer1C.getSelectedItem()).getId() : -1; //Spacer 1
			glassSU.spacer2 = spacer2C.getSelectedItem() != null ? ((Parts) spacer2C.getSelectedItem()).getId() : -1; //Spacer 2
			glassSU.spacer3 = spacer3C.getSelectedItem() != null ? ((Parts) spacer3C.getSelectedItem()).getId() : -1; //Spacer 3
			glassSU.gas1 = gas1C.getSelectedItem() != null ? ((Parts) gas1C.getSelectedItem()).getId() : -1; //Gas 1
			glassSU.gas2 = gas2C.getSelectedItem() != null ? ((Parts) gas2C.getSelectedItem()).getId() : -1; //Gas 2
			glassSU.gas3 = gas3C.getSelectedItem() != null ? ((Parts) gas3C.getSelectedItem()).getId() : -1; //Gas 3
			glassSU.cavityProcess1 = cp1C.getSelectedItem() != null ? ((Parts) cp1C.getSelectedItem()).getId() : -1; //Cavity Process 11
			glassSU.cavityProcess2 = cp2C.getSelectedItem() != null ? ((Parts) cp2C.getSelectedItem()).getId() : -1; //Cavity Process 21
			glassSU.cavityProcess3 = cp3C.getSelectedItem() != null ? ((Parts) cp3C.getSelectedItem()).getId() : -1; //Cavity Process 31
			
			if (hasInsert1.isSelected())
				glassSU.insert1Id = insert1idC.getSelectedItem() != null ? ((SUType) insert1idC.getSelectedItem()).getId() : -1; //Insert 1
				else
					glassSU.insert1Id = 0;
			
			if (hasInsert2.isSelected())
				glassSU.insert2Id = insert2idC.getSelectedItem() != null ? ((SUType) insert2idC.getSelectedItem()).getId() : -1; //Insert 2
				else
					glassSU.insert2Id = 0;
			
			if (hasInsert3.isSelected())
				glassSU.insert3Id = insert3idC.getSelectedItem() != null ? ((SUType) insert3idC.getSelectedItem()).getId() : -1; //Insert 3
				else
					glassSU.insert3Id = 0;
			
			glassSU.pricingUOMId = priceuomC.getSelectedItem() != null ? ((SystemUOM) priceuomC.getSelectedItem()).getId() : -1; //Pricing UOM Id
			glassSU.priceActualSize = priceactualChk.isSelected(); //Price actual size
			glassSU.costActualSize = costactualChk.isSelected(); //Cost actual size
			glassSU.price = new BigDecimal(priceT.getText()); //Price
			glassSU.minPrice = new BigDecimal(minpriceAT.getText()); //Min Price
			glassSU.cost = new BigDecimal(costT.getText()); //Cost
			glassSU.priceGroupId = priceGroupC.getSelectedItem() != null ? ((PricingGroup) priceGroupC.getSelectedItem()).getId() : -1; //Pricing group
			glassSU.costGroupId = costGroupC.getSelectedItem() != null ? ((CostingGroup) costGroupC.getSelectedItem()).getId() : -1; //Costing group
			
			if (matrixPriceChk.isSelected())
				glassSU.priceMatrixId = priceMatrixC.getSelectedItem() != null ? ((MatrixHeader) priceMatrixC.getSelectedItem()).getId() : -1; //Price matrix Id
				else
					glassSU.priceMatrixId = 0;
			
			//Setting SUType to controller
			//controller.setSuTypeSelected(suType);
		}
	}
	
	/**
	 * Init components GUI
	 */
	private void initComponents() {
		
		//Setting Layout configuration
		this.setTitle("Glass & SU");
		this.setLayout(new BorderLayout());
		
		//Configuring panel details
		this.panelDetails = new JXCollapsiblePane();
		this.panelDetails.setBorder(BorderFactory.createEtchedBorder());
		this.panelDetails.setLayout(new VerticalLayout());
		
		//Configuring panel content
		this.panelContent = new JPanel();
		this.panelContent.setLayout(new BorderLayout());
		
		//Init panel components
		this.initPanelButton();
		this.initHeaderPane();
		this.initLimitsPane();
		this.initGlassComponentPane();
		this.initCostPricePane();
		this.initImagePane();
		
		//Adding panels to panel details
		this.panelDetails.add(this.headerPane);
		this.panelDetails.add(this.limitsPane);
		this.panelDetails.add(this.glassPane);
		this.panelDetails.add(this.costPricePane);
		this.panelDetails.add(this.panelButtonMain);
		
		this.add(panelDetails, BorderLayout.CENTER);
		
		//Setting Enabled and Disabled
		//this.enableDisable(false);
	}
	
	/**
	 * Init panel button
	 */
	private void initPanelButton() {
		
		this.panelButton = new JPanel();
		this.panelButton.setLayout(new HorizontalLayout());
		this.panelButton.setPreferredSize(new Dimension(210, 24));
		
		this.panelButtonMain = new JPanel();
		this.panelButtonMain.setLayout(new BorderLayout());
		this.panelButtonMain.setBorder(BorderFactory.createEtchedBorder());
		
		this.saveButton = new JButton();
		this.saveButton.setIcon(myParent.saveImage);
		this.saveButton.setToolTipText("Save");
		this.saveButton.setPreferredSize(new Dimension(30, 20));
		
		this.cancelButton = new JButton();
		this.cancelButton.setIcon(myParent.cancelImage);
		this.cancelButton.setToolTipText("Cancel");
		this.cancelButton.setPreferredSize(new Dimension(30, 20));
		
		this.copyButton = new JButton();
		this.copyButton.setIcon(myParent.cancelImage);
		this.copyButton.setToolTipText("Copy");
		this.copyButton.setPreferredSize(new Dimension(30, 20));
		
		this.uploadButton = new JButton();
		this.uploadButton.setIcon(myParent.cancelImage);
		this.uploadButton.setToolTipText("Upload");
		this.uploadButton.setPreferredSize(new Dimension(30, 20));
		
		this.panelButton.add(saveButton);
		this.panelButton.add(cancelButton);
		
		panelButtonMain.add(this.panelButton, BorderLayout.WEST);
	}
	
	/**
	 * Init Header Pane components
	 */
	public void initHeaderPane() {
		
		//**************************************
		//Initialize header pane
		//**************************************
		headerPane = new JXTaskPaneOJ();
		headerPane.setTitle("Header Details");
		headerPane.setLayout(new XYLayout());
		
		//**************************************
		//Initialize components for header pane
		//**************************************
		idLbl = new JLabel("ID");
		idTxt = new JTextField("0");
		idTxt.setEnabled(false);
		
		scLbl = new JLabel("Stock Code");
		scTxt = new JTextField("Stock Code");
		
		descTxt = new JTextField("Description");
		
		nextLbl = new JLabel("Next:");
		nextTxt = new JTextField();
		nextTxt.setEnabled(false);
		
		displayChk = new JCheckBox("Show");
		displayChk.setEnabled(false);
		
		sortL = new JLabel("Sequence");
		sortTxt = new JTextField("1");
		sortTxt.setEnabled(false);
		
		typeLbl = new JLabel("Type:");
		typeCmb = new JComboBox();
		typeCmb.setEnabled(false);
		
		noLeafsL = new JLabel("# Glass:");
		noLeafsC = new JComboBox(new String[]{"2", "3", "4"});
		noLeafsC.setEnabled(false);
		
		wasteLbl = new JLabel("Waste %");
		wasteTxt = new JTextField("0.00");
		wasteTxt.setEnabled(false);
		
		familyL = new JLabel("SU Family:");
		familyCmb = new JComboBox();
		familyCmb.setEnabled(false);
		
		madeinChk = new JCheckBox("Made In");
		madeinChk.setEnabled(false);
		
		abbrevLbl = new JLabel("Abbrev.:");
		abbrevTxt = new JTextField("");
		abbrevTxt.setEnabled(false);
		
		prodLineLbl = new JLabel("Prod. Line:");
		prodLineLbl.setVisible(false);
		prodLineCmb = new JComboBox();
		prodLineCmb.setVisible(false);
		prodLineCmb.setEnabled(false);
		
		supidLbl = new JLabel("Supplier:");
		supCmb = new JComboBox();
		
		ltL = new JLabel("Lead Time:");
		ltT = new JTextField("0");
		ltT.setEnabled(false);
		
		fromDateL = new JLabel("From:");
		toDateL = new JLabel("To:");
		fromDate = new JXDatePicker();
		toDate = new JXDatePicker();
		fromDate.setEnabled(false);
		toDate.setEnabled(false);
		
		isCustomChk = new JCheckBox("Customizable");
		isCustomChk.setEnabled(false);
		
		//**************************************
		//Init components values
		//**************************************
		
		if (glazingTypes != null && glazingTypes.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(typeCmb, glazingTypes);
			typeCmb.setSelectedIndex(0);
		}
		
		if (suFamilies != null && suFamilies.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(familyCmb, suFamilies);
			familyCmb.setSelectedIndex(0);
		}
		
		if (prodLines != null && prodLines.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(prodLineCmb, prodLines);
			prodLineCmb.setSelectedIndex(0);
		}
		
		if (suppliers != null && suppliers.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(supCmb, suppliers);
			supCmb.setSelectedIndex(0);
		}
		
		//**************************************
		//Adding components to header pane
		//**************************************
		headerPane.add(this.idLbl, new XYConstraints(1, 1, 80, 22));
		headerPane.add(this.idTxt, new XYConstraints(82, 1, 50, 22));
		
		headerPane.add(this.scLbl, new XYConstraints(135, 1, 80, 22));
		headerPane.add(this.scTxt, new XYConstraints(217, 1, 100, 22));
		
		headerPane.add(this.descTxt, new XYConstraints(320, 1, 214, 22));
		
		headerPane.add(this.nextLbl, new XYConstraints(1, 25, 80, 22));
		headerPane.add(this.nextTxt, new XYConstraints(82, 25, 50, 22));
		
		headerPane.add(this.displayChk, new XYConstraints(133, 25, 80, 22));
		
		headerPane.add(this.sortL, new XYConstraints(217, 25, 58, 22));
		headerPane.add(this.sortTxt, new XYConstraints(277, 25, 40, 22));
		
		headerPane.add(this.typeLbl, new XYConstraints(1, 49, 80, 22));
		headerPane.add(this.typeCmb, new XYConstraints(82, 49, 100, 22));
		
		headerPane.add(this.noLeafsL, new XYConstraints(217, 49, 80, 22));
		headerPane.add(this.noLeafsC, new XYConstraints(277, 49, 40, 22));
		
		headerPane.add(this.wasteLbl, new XYConstraints(217, 73, 80, 22));
		headerPane.add(this.wasteTxt, new XYConstraints(277, 73, 40, 22));
		
		headerPane.add(this.familyL, new XYConstraints(1, 73, 80, 22));
		headerPane.add(this.familyCmb, new XYConstraints(82, 73, 100, 22));
		
		headerPane.add(this.madeinChk, new XYConstraints(318, 25, 80, 22));
		
		headerPane.add(this.abbrevLbl, new XYConstraints(400, 25, 60, 22));
		headerPane.add(this.abbrevTxt, new XYConstraints(462, 25, 72, 22));
		
		headerPane.add(this.prodLineLbl, new XYConstraints(322, 49, 60, 22));
		headerPane.add(this.prodLineCmb, new XYConstraints(384, 49, 150, 22));
		
		headerPane.add(this.supidLbl, new XYConstraints(322, 49, 60, 22));
		headerPane.add(this.supCmb, new XYConstraints(384, 49, 150, 22));
		
		headerPane.add(this.ltL, new XYConstraints(322, 73, 60, 22));
		headerPane.add(this.ltT, new XYConstraints(384, 73, 50, 22));
		
		headerPane.add(this.fromDateL, new XYConstraints(1, 97, 80, 22));
		headerPane.add(this.toDateL, new XYConstraints(1, 121, 80, 22));
		headerPane.add(this.fromDate, new XYConstraints(82, 97, 120, 22));
		headerPane.add(this.toDate, new XYConstraints(82, 121, 120, 22));
		
		headerPane.add(this.isCustomChk, new XYConstraints(434, 121, 102, 22));
	}
	
	/**
	 * Init Limits Pane components
	 */
	private void initLimitsPane() {
		
		//**************************************
		//Initialize limits pane
		//**************************************
		limitsPane = new JXTaskPaneOJ();
		limitsPane.setTitle("Limits: Min & Max");
		limitsPane.setLayout(new XYLayout());
		limitsPane.setCollapsed(true);
		
		//**************************************
		//Initialize components for limits pane
		//**************************************
		metric = new JLabel("Metric");
		imperial = new JLabel("Imperial");
		
		thickL = new JLabel("Thickness");
		thickT = new JTextField("0.00");
		thickT.setHorizontalAlignment(SwingConstants.RIGHT);
		thickT.setEnabled(false);
		thickiT = new JTextField("0.00");
		thickiT.setHorizontalAlignment(SwingConstants.RIGHT);
		thickiT.setEnabled(false);
		
		gtoSL = new JLabel("Glass/Spacer:");
		gtoST = new JTextField("0.00");
		gtoST.setHorizontalAlignment(SwingConstants.RIGHT);
		gtoST.setEnabled(false);
		gtoSiT = new JTextField("0.00");
		gtoSiT.setHorizontalAlignment(SwingConstants.RIGHT);
		gtoSiT.setEnabled(false);
		
		minAreaL = new JLabel("Min Area:");
		minAreaT = new JTextField("0.00");
		minAreaT.setHorizontalAlignment(SwingConstants.RIGHT);
		minAreaT.setEnabled(false);
		minAreaiT = new JTextField("0.00");
		minAreaiT.setHorizontalAlignment(SwingConstants.RIGHT);
		minAreaiT.setEnabled(false);
		
		maxAreaL = new JLabel("Max Area:");
		maxAreaT = new JTextField("0.00");
		maxAreaT.setHorizontalAlignment(SwingConstants.RIGHT);
		maxAreaT.setEnabled(false);
		maxAreaiT = new JTextField("0.00");
		maxAreaiT.setHorizontalAlignment(SwingConstants.RIGHT);
		maxAreaiT.setEnabled(false);
		
		minWL = new JLabel("Min W:");
		minWT = new JTextField("0.00");
		minWT.setHorizontalAlignment(SwingConstants.RIGHT);
		minWT.setEnabled(false);
		minWiT = new JTextField("0.00");
		minWiT.setHorizontalAlignment(SwingConstants.RIGHT);
		minWiT.setEnabled(false);
		
		maxWL = new JLabel("Max W:");
		maxWT = new JTextField("0.00");
		maxWT.setHorizontalAlignment(SwingConstants.RIGHT);
		maxWT.setEnabled(false);
		maxWiT = new JTextField("0.00");
		maxWiT.setHorizontalAlignment(SwingConstants.RIGHT);
		maxWiT.setEnabled(false);
		
		minHL = new JLabel("Min H:");
		minHT = new JTextField("0.00");
		minHT.setHorizontalAlignment(SwingConstants.RIGHT);
		minHT.setEnabled(false);
		minHiT = new JTextField("0.00");
		minHiT.setHorizontalAlignment(SwingConstants.RIGHT);
		minHiT.setEnabled(false);
		
		maxHL = new JLabel("Max H:");
		maxHT = new JTextField("0.00");
		maxHT.setHorizontalAlignment(SwingConstants.RIGHT);
		maxHT.setEnabled(false);
		maxHiT = new JTextField("0.00");
		maxHiT.setHorizontalAlignment(SwingConstants.RIGHT);
		maxHiT.setEnabled(false);
		
		minpriceAL = new JLabel("Min Area:");
		minpriceAT = new JTextField("0.00");
		minpriceAT.setHorizontalAlignment(SwingConstants.RIGHT);
		minpriceAT.setEnabled(false);
		minpriceAiT = new JTextField("0.00");
		minpriceAiT.setHorizontalAlignment(SwingConstants.RIGHT);
		minpriceAiT.setEnabled(false);
		
		mincostAL = new JLabel("Min Area:");
		minpcostAT = new JTextField("0.00");
		minpcostAT.setHorizontalAlignment(SwingConstants.RIGHT);
		minpcostAT.setEnabled(false);
		mincostAiT = new JTextField("0.00");
		mincostAiT.setHorizontalAlignment(SwingConstants.RIGHT);
		mincostAiT.setEnabled(false);
		
		whRatioL = new JLabel("W:H Ratio:");
		whRatioT = new JTextField("0.00");
		whRatioT.setHorizontalAlignment(SwingConstants.RIGHT);
		whRatioT.setEnabled(false);
		
		//**************************************
		//Adding components to limits pane
		//**************************************
		limitsPane.add(this.metric, new XYConstraints(82, 1, 100, 22));
		limitsPane.add(this.imperial, new XYConstraints(186, 1, 100, 22));
		
		limitsPane.add(this.thickL, new XYConstraints(1, 25, 80, 22));
		limitsPane.add(this.thickT, new XYConstraints(82, 25, 100, 22));
		limitsPane.add(this.thickiT, new XYConstraints(186, 25, 100, 22));
		
		limitsPane.add(this.gtoSL, new XYConstraints(1, 49, 80, 22));
		limitsPane.add(this.gtoST, new XYConstraints(82, 49, 100, 22));
		limitsPane.add(this.gtoSiT, new XYConstraints(186, 49, 100, 22));
		
		limitsPane.add(this.minAreaL, new XYConstraints(1, 73, 80, 22));
		limitsPane.add(this.minAreaT, new XYConstraints(82, 73, 100, 22));
		limitsPane.add(this.minAreaiT, new XYConstraints(186, 73, 100, 22));
		
		limitsPane.add(this.maxAreaL, new XYConstraints(1, 97, 80, 22));
		limitsPane.add(this.maxAreaT, new XYConstraints(82, 97, 100, 22));
		limitsPane.add(this.maxAreaiT, new XYConstraints(186, 97, 100, 22));
		
		limitsPane.add(this.minWL, new XYConstraints(1, 121, 80, 22));
		limitsPane.add(this.minWT, new XYConstraints(82, 121, 100, 22));
		limitsPane.add(this.minWiT, new XYConstraints(186, 121, 100, 22));
		
		limitsPane.add(this.maxWL, new XYConstraints(1, 145, 80, 22));
		limitsPane.add(this.maxWT, new XYConstraints(82, 145, 100, 22));
		limitsPane.add(this.maxWiT, new XYConstraints(186, 145, 100, 22));
		
		limitsPane.add(this.minHL, new XYConstraints(1, 169, 80, 22));
		limitsPane.add(this.minHT, new XYConstraints(82, 169, 100, 22));
		limitsPane.add(this.minHiT, new XYConstraints(186, 169, 100, 22));
		
		limitsPane.add(this.maxHL, new XYConstraints(1, 193, 80, 22));
		limitsPane.add(this.maxHT, new XYConstraints(82, 193, 100, 22));
		limitsPane.add(this.maxHiT, new XYConstraints(186, 193, 100, 22));
		
		limitsPane.add(this.minpriceAL, new XYConstraints(1, 217, 80, 22));
		limitsPane.add(this.minpriceAT, new XYConstraints(82, 217, 100, 22));
		limitsPane.add(this.minpriceAiT, new XYConstraints(186, 217, 100, 22));
		
		limitsPane.add(this.mincostAL, new XYConstraints(1, 241, 80, 22));
		limitsPane.add(this.minpcostAT, new XYConstraints(82, 241, 100, 22));
		limitsPane.add(this.mincostAiT, new XYConstraints(186, 241, 100, 22));
		
		limitsPane.add(this.whRatioL, new XYConstraints(1, 265, 80, 22));
		limitsPane.add(this.whRatioT, new XYConstraints(82, 265, 100, 22));
		
	}
	
	/**
	 * Init Glass pane components
	 */
	private void initGlassComponentPane() {
		
		//**************************************
		//Initialize glass pane
		//**************************************
		glassPane = new JXTaskPaneOJ();
		glassPane.setTitle("Sealed Unit Composition");
		glassPane.setLayout(new XYLayout());
		glassPane.setCollapsed(true);
		
		//**************************************
		//Initialize components for limits pane
		//**************************************
		sealantL = new JLabel("Sealant:");
		sealantC = new JComboBox();
		
		glass1L = new JLabel("Glass:");
		glassf1L = new JLabel("Film:");
		glassp11L = new JLabel("Process:");
		glassp12L = new JLabel("Process:");
		glassp13L = new JLabel("Process:");
		
		glass1C = new JComboBox();
		glassf1C = new JComboBox();
		glassp11C = new JComboBox();
		glassp12C = new JComboBox();
		glassp13C = new JComboBox();
		
		glass2C = new JComboBox();
		glassf2C = new JComboBox();
		glassp21C = new JComboBox();
		glassp22C = new JComboBox();
		glassp23C = new JComboBox();
		
		glass3C = new JComboBox();
		glassf3C = new JComboBox();
		glassp31C = new JComboBox();
		glassp32C = new JComboBox();
		glassp33C = new JComboBox();
		
		glass4C = new JComboBox();
		glassf4C = new JComboBox();
		glassp41C = new JComboBox();
		glassp42C = new JComboBox();
		glassp43C = new JComboBox();
		
		spacer1L = new JLabel("Spacer:");
		spacer1C = new JComboBox();
		
		gas1L = new JLabel("Gas:");
		gas1C = new JComboBox();
		
		cp1L = new JLabel("Process:");
		cp1C = new JComboBox();
		
		spacer2L = new JLabel("Spacer:");
		spacer2C = new JComboBox();
		
		gas2L = new JLabel("Gas:");
		gas2C = new JComboBox();
		
		cp2L = new JLabel("Process:");
		cp2C = new JComboBox();
		
		spacer3L = new JLabel("Spacer:");
		spacer3C = new JComboBox();
		
		gas3L = new JLabel("Gas:");
		gas3C = new JComboBox();
		
		cp3L = new JLabel("Process:");
		cp3C = new JComboBox();
		
		insert1idLbl = new JLabel("Insert in 1:");
		insert1idLbl.setVisible(false);
		insert1idC = new JComboBox();
		insert1idC.setVisible(false);
		
		insert2idLbl = new JLabel("Insert in 2:");
		insert2idLbl.setVisible(false);
		insert2idC = new JComboBox();
		insert2idC.setVisible(false);
		
		insert3idLbl = new JLabel("Insert in 3:");
		insert3idLbl.setVisible(false);
		insert3idC = new JComboBox();
		insert3idC.setVisible(false);
		
		hasInsert1 = new JCheckBox("Has Insert");
		hasInsert2 = new JCheckBox("Has Insert");
		hasInsert3 = new JCheckBox("Has Insert");
		
		//**************************************
		//Init components values
		//**************************************
		
		if (sealants != null && sealants.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(sealantC, sealants);
			sealantC.setSelectedIndex(0);
		}
		
		if (glass1 != null && glass1.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glass1C, glass1);
			glass1C.setSelectedIndex(0);
		}
		
		if (films != null && films.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glassf1C, films);
			glassf1C.setSelectedIndex(0);
		}
		
		if (processes != null && processes.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glassp11C, processes);
			glassp11C.setSelectedIndex(0);
		}
		
		if (processes != null && processes.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glassp12C, processes);
			glassp12C.setSelectedIndex(0);
		}
		
		if (processes != null && processes.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glassp13C, processes);
			glassp13C.setSelectedIndex(0);
		}
		
		if (spacers != null && spacers.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(spacer1C, spacers);
			spacer1C.setSelectedIndex(0);
		}
		
		if (gases != null && gases.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(gas1C, gases);
			gas1C.setSelectedIndex(0);
		}
		
		if (processes != null && processes.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(cp1C, processes);
			cp1C.setSelectedIndex(0);
		}
		
		if (glass1 != null && glass1.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glass2C, glass1);
			glass2C.setSelectedIndex(0);
		}
		
		if (processes != null && processes.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glassp21C, processes);
			glassp21C.setSelectedIndex(0);
		}
		
		if (processes != null && processes.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glassp22C, processes);
			glassp22C.setSelectedIndex(0);
		}
		
		if (processes != null && processes.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glassp23C, processes);
			glassp23C.setSelectedIndex(0);
		}
		
		if (spacers != null && spacers.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(spacer2C, spacers);
			spacer2C.setSelectedIndex(0);
		}
		
		if (gases != null && gases.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(gas2C, gases);
			gas2C.setSelectedIndex(0);
		}
		
		if (processes != null && processes.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(cp2C, processes);
			cp2C.setSelectedIndex(0);
		}
		
		if (glass1 != null && glass1.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glass3C, glass1);
			glass3C.setSelectedIndex(0);
		}
		
		if (films != null && films.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glassf3C, films);
			glassf3C.setSelectedIndex(0);
		}
		
		if (processes != null && processes.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glassp31C, processes);
			glassp31C.setSelectedIndex(0);
		}
		
		if (processes != null && processes.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glassp32C, processes);
			glassp32C.setSelectedIndex(0);
		}
		
		if (processes != null && processes.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glassp33C, processes);
			glassp33C.setSelectedIndex(0);
		}
		
		if (spacers != null && spacers.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(spacer3C, spacers);
			spacer3C.setSelectedIndex(0);
		}
		
		if (gases != null && gases.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(gas3C, gases);
			gas3C.setSelectedIndex(0);
		}
		
		if (processes != null && processes.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(cp3C, processes);
			cp3C.setSelectedIndex(0);
		}
		
		if (glass1 != null && glass1.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glass4C, glass1);
			glass4C.setSelectedIndex(0);
		}
		
		if (films != null && films.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glassf4C, films);
			glassf4C.setSelectedIndex(0);
		}
		
		if (processes != null && processes.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glassp41C, processes);
			glassp41C.setSelectedIndex(0);
		}
		
		if (processes != null && processes.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glassp42C, processes);
			glassp42C.setSelectedIndex(0);
		}
		
		if (processes != null && processes.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(glassp43C, processes);
			glassp43C.setSelectedIndex(0);
		}
		
		//**************************************
		//Adding components to glass pane
		//**************************************
		glassPane.add(this.sealantL, new XYConstraints(1, 1, 80, 22));
		glassPane.add(this.sealantC, new XYConstraints(82, 1, 150, 22));
		glassPane.add(this.glass1L, new XYConstraints(82, 25, 100, 22));
		glassPane.add(this.glassf1L, new XYConstraints(234, 25, 150, 22));
		glassPane.add(this.glassp11L, new XYConstraints(386, 25, 150, 22));
		glassPane.add(this.glassp12L, new XYConstraints(538, 25, 150, 22));
		glassPane.add(this.glassp13L, new XYConstraints(690, 25, 150, 22));
		
		glassPane.add(this.glass1C, new XYConstraints(82, 49, 150, 22));
		glassPane.add(this.glassf1C, new XYConstraints(234, 49, 150, 22));
		glassPane.add(this.glassp11C, new XYConstraints(386, 49, 150, 22));
		glassPane.add(this.glassp12C, new XYConstraints(538, 49, 150, 22));
		glassPane.add(this.glassp13C, new XYConstraints(690, 49, 150, 22));
		
		glassPane.add(this.spacer1L, new XYConstraints(1, 73, 80, 22));
		glassPane.add(this.gas1L, new XYConstraints(1, 97, 80, 22));
		glassPane.add(this.cp1L, new XYConstraints(1, 121, 80, 22));
		
		glassPane.add(this.spacer1C, new XYConstraints(82, 73, 150, 22));
		glassPane.add(this.gas1C, new XYConstraints(82, 97, 150, 22));
		
		glassPane.add(this.insert1idLbl, new XYConstraints(250, 97, 100, 22));
		glassPane.add(this.insert1idC, new XYConstraints(352, 97, 150, 22));
		glassPane.add(this.hasInsert1, new XYConstraints(250, 73, 100, 22));
		
		glassPane.add(this.cp1C, new XYConstraints(82, 121, 150, 22));
		glassPane.add(this.glass2C, new XYConstraints(82, 145, 150, 22));
		glassPane.add(this.glassf2C, new XYConstraints(234, 145, 150, 22));
		glassPane.add(this.glassp21C, new XYConstraints(386, 145, 150, 22));
		glassPane.add(this.glassp22C, new XYConstraints(538, 145, 150, 22));
		glassPane.add(this.glassp23C, new XYConstraints(690, 145, 150, 22));
		
		if (leafs >= 3) {
			
			glassPane.add(this.spacer2L, new XYConstraints(1, 169, 80, 22));
			glassPane.add(this.gas2L, new XYConstraints(1, 193, 80, 22));
			glassPane.add(this.cp2L, new XYConstraints(1, 217, 80, 22));
			
			glassPane.add(this.spacer2C, new XYConstraints(82, 169, 150, 22));
			glassPane.add(this.gas2C, new XYConstraints(82, 193, 150, 22));
			glassPane.add(this.insert2idLbl, new XYConstraints(250, 193, 100, 22));
			glassPane.add(this.insert2idC, new XYConstraints(352, 193, 150, 22));
			glassPane.add(this.hasInsert2, new XYConstraints(250, 169, 100, 22));
			glassPane.add(this.cp2C, new XYConstraints(82, 217, 150, 22));
			
			glassPane.add(glass3C, new XYConstraints(82, 241, 150, 22));
			glassPane.add(glassf3C, new XYConstraints(234, 241, 150, 22));
			glassPane.add(glassp31C, new XYConstraints(386, 241, 150, 22));
			glassPane.add(glassp32C, new XYConstraints(538, 241, 150, 22));
			glassPane.add(glassp33C, new XYConstraints(690, 241, 150, 22));
		}
		
		if (leafs == 4) {
			
			glassPane.add(this.spacer3L, new XYConstraints(1, 265, 80, 22));
			glassPane.add(this.gas3L, new XYConstraints(1, 289, 80, 22));
			glassPane.add(this.cp3L, new XYConstraints(1, 313, 80, 22));
			
			glassPane.add(this.spacer3C, new XYConstraints(82, 265, 150, 22));
			glassPane.add(this.gas3C, new XYConstraints(82, 289, 150, 22));
			glassPane.add(this.insert3idLbl, new XYConstraints(250, 289, 100, 22));
			glassPane.add(this.insert3idC, new XYConstraints(352, 289, 150, 22));
			glassPane.add(this.hasInsert3, new XYConstraints(250, 265, 100, 22));
			
			glassPane.add(this.cp3C, new XYConstraints(82, 313, 150, 22));
			
			glassPane.add(this.glass4C, new XYConstraints(82, 337, 150, 22));
			glassPane.add(this.glassf4C, new XYConstraints(234, 337, 150, 22));
			glassPane.add(this.glassp41C, new XYConstraints(386, 337, 150, 22));
			glassPane.add(this.glassp42C, new XYConstraints(538, 337, 150, 22));
			glassPane.add(this.glassp43C, new XYConstraints(690, 337, 150, 22));
		}
	}
	
	/**
	 * Init Cost price pane components
	 */
	private void initCostPricePane() {
		
		//**************************************
		//Initialize glass pane
		//**************************************
		costPricePane = new JXTaskPaneOJ();
		costPricePane.setTitle("Costing & Pricing");
		costPricePane.setLayout(new XYLayout());
		costPricePane.setCollapsed(true);
		
		//**************************************
		//Initialize components for limits pane
		//**************************************
		priceuomL = new JLabel("Price UOM:");
		priceuomC = new JComboBox();
		
		priceactualChk = new JCheckBox("Price Size");
		costactualChk = new JCheckBox("Cost Size");
		
		priceL = new JLabel("Price:");
		priceT = new JTextField("0.00");
		priceT.setHorizontalAlignment(SwingConstants.RIGHT);
		
		minpriceL = new JLabel("Min:");
		minpriceT = new JTextField("0.00");
		minpriceT.setHorizontalAlignment(SwingConstants.RIGHT);
		
		matrixPriceChk = new JCheckBox("Matrix:");
		matrixPriceChk.setSelected(false);
		priceMatrixC = new JComboBox();
		priceMatrixC.setEnabled(false);
		
		priceGroupL = new JLabel("Price Group:");
		priceGroupC = new JComboBox();
		
		costL = new JLabel("Cost:");
		costT = new JTextField("0.00");
		costT.setHorizontalAlignment(SwingConstants.RIGHT);
		
		costactualChk = new JCheckBox("Cost Size");
		
		costGroupL = new JLabel("Cost Group:");
		costGroupC = new JComboBox();
		
		//**************************************
		//Init components values
		//**************************************
		
		if (uoms != null && uoms.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(priceuomC, uoms);
			priceuomC.setSelectedIndex(0);
		}
		
		if (matrices != null && matrices.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(priceMatrixC, matrices);
			priceMatrixC.setSelectedIndex(0);
		}
		
		if (priceGroups != null && priceGroups.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(priceGroupC, priceGroups);
			priceGroupC.setSelectedIndex(0);
		}
		
		if (inserts != null && inserts.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(this.insert1idC, inserts);
			insert1idC.setSelectedIndex(0);
			LoadDataListUtil.loadObjectToComboBox(this.insert2idC, inserts);
			insert2idC.setSelectedIndex(0);
			LoadDataListUtil.loadObjectToComboBox(this.insert3idC, inserts);
			insert3idC.setSelectedIndex(0);
		}
		
		if (costGroups != null && costGroups.size() > 0) {
			LoadDataListUtil.loadObjectToComboBox(costGroupC, costGroups);
			costGroupC.setSelectedIndex(0);
		}
		
		//**************************************
		//Adding components to cost price pane
		//**************************************
		this.costPricePane.add(this.priceuomL, new XYConstraints(1, 1, 80, 22));
		this.costPricePane.add(this.priceuomC, new XYConstraints(82, 1, 150, 22));
		this.costPricePane.add(this.priceactualChk, new XYConstraints(235, 1, 100, 22));
		
		this.costPricePane.add(this.priceL, new XYConstraints(1, 25, 80, 22));
		this.costPricePane.add(this.priceT, new XYConstraints(82, 25, 150, 22));
		
		this.costPricePane.add(this.minpriceL, new XYConstraints(238, 25, 80, 22));
		this.costPricePane.add(this.minpriceT, new XYConstraints(326, 25, 150, 22));
		
		this.costPricePane.add(this.matrixPriceChk, new XYConstraints(1, 49, 80, 22));
		this.costPricePane.add(this.priceMatrixC, new XYConstraints(82, 49, 150, 22));
		
		this.costPricePane.add(this.priceGroupL, new XYConstraints(238, 49, 80, 22));
		this.costPricePane.add(this.priceGroupC, new XYConstraints(326, 49, 150, 22));
		
		this.costPricePane.add(this.costL, new XYConstraints(1, 73, 80, 22));
		this.costPricePane.add(this.costT, new XYConstraints(82, 73, 150, 22));
		
		this.costPricePane.add(this.costactualChk, new XYConstraints(235, 73, 100, 22));
		this.costPricePane.add(this.costGroupL, new XYConstraints(1, 97, 80, 22));
		this.costPricePane.add(this.costGroupC, new XYConstraints(82, 97, 150, 22));
	}
	
	/**
	 * Init image pane
	 */
	private void initImagePane() {
		
		//**************************************
		//Initialize Image pane
		//**************************************
		imagePane = new JXTaskPaneOJ();
		imagePane.setTitle("Image");
		
		//**************************************
		//Adding components to image pane
		//**************************************
		imagePane.add(uploadButton, new XYConstraints(1, 1, 30, 20));
		imagePane.add(imageArea, new XYConstraints(1, 24, 200, 200));
	}
	
	/**
	 * Init action listeners UI components
	 */
	private void initActionListeners() {
		
		//Made in Chk
		this.madeinChk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (madeinChk.isSelected()) {
					supidLbl.setVisible(false);
					supCmb.setVisible(false);
					
					prodLineLbl.setVisible(true);
					prodLineCmb.setVisible(true);
				} else {
					supidLbl.setVisible(true);
					supCmb.setVisible(true);
					
					prodLineLbl.setVisible(false);
					prodLineCmb.setVisible(false);
				}
			}
		});
		
		//Type glazing
		this.typeCmb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				typeCmb_itemStateChanged(e);
			}
		});
		
		//Number of leafs
		this.noLeafsC.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				noLeafs_itemStateChanged(e);
			}
		});
		
		//Matrix Price Check box
		this.matrixPriceChk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (matrixPriceChk.isSelected()) {
					priceT.setText("0.00");
					priceT.setEnabled(false);
					priceMatrixC.setEnabled(true);
				} else {
					priceT.setEnabled(true);
					priceMatrixC.setEnabled(false);
				}
			}
		});
		
		//HasInsert1 check box
		this.hasInsert1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hasInsert1_actionPerformed(e);
			}
		});
		
		//HasInsert2 check box
		this.hasInsert2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hasInsert2_actionPerformed(e);
			}
		});
		
		//HasInsert3 check box
		this.hasInsert3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hasInsert3_actionPerformed(e);
			}
		});
		
		this.saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//Save SUType to DB
					save_actionPerformed(e);
					
					//Reset drawing to update changes
					myParent.jobItem.resetGraphics();
					
					//Reset glass table
					myParent.glassPanel.configGlassPropertiesTable(controller.getGlassSUSelected());
					
				} catch (Exception ex) {
					System.err.println(ex.getMessage());
					//Show error message dialog
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		this.cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancel_actionPerformed(e);
			}
		});
	}
	
	/**
	 * Save action performed
	 *
	 * @param e, ActionEvent
	 * @throws Exception, Exception
	 */
	private void save_actionPerformed(ActionEvent e) throws Exception {
		
		//Setting values to SUType
		setValuesToSUType();
		
		//Show error message dialog
		this.dispose();
	}
	
	/**
	 * Cancel action performed
	 *
	 * @param e, ActionEvent
	 */
	private void cancel_actionPerformed(ActionEvent e) {
		saveButton.setEnabled(true);
		cancelButton.setEnabled(false);
	}
	
	/**
	 * Glazing type comboBox item state changed event
	 *
	 * @param e, ItemEvent
	 */
	private void typeCmb_itemStateChanged(ItemEvent e) {
		
		if (this.typeCmb.getSelectedItem() != null) {
			
			if (((TypeGlazing) typeCmb.getSelectedItem()).getId() == 2) {
				
				//Set not enabled noLeafs
				this.noLeafsC.setEnabled(true);
				
				//**************************************
				//Init panelDetails
				//**************************************
				this.panelDetails.removeAll();
				this.panelDetails.add(this.headerPane);
				this.panelDetails.add(this.limitsPane);
				this.panelDetails.add(this.glassPane);
				this.panelDetails.add(this.costPricePane);
				this.panelDetails.add(this.panelButtonMain);
				
				this.limitsPane.setCollapsed(true);
				this.glassPane.setCollapsed(false);
				this.costPricePane.setCollapsed(true);
				
				
			} else if (((TypeGlazing) typeCmb.getSelectedItem()).getId() >= 3) {
				
				//**************************************
				//Init panelDetails
				//**************************************
				this.panelDetails.removeAll();
				this.panelDetails.add(this.headerPane);
				//                this.panelDetails.add(this.imagePane);
				this.panelDetails.add(this.limitsPane);
				this.panelDetails.add(this.glassPane);
				this.panelDetails.add(this.costPricePane);
				this.panelDetails.add(this.panelButtonMain);
				
				this.glassPane.setCollapsed(true);
				this.limitsPane.setCollapsed(true);
				this.costPricePane.setCollapsed(true);
				//                this.imagePane.setCollapsed(false);
				
			} else {
				
				this.noLeafsC.setEnabled(false);
				if (((TypeGlazing) typeCmb.getSelectedItem()).getId() == 1) {
					this.abbrevTxt.setEnabled(true);
				} else {
					this.abbrevTxt.setEnabled(false);
				}
				
				//**************************************
				//Init panelDetails
				//**************************************
				this.panelDetails.removeAll();
				this.panelDetails.add(this.headerPane);
				this.panelDetails.add(this.limitsPane);
				this.panelDetails.add(this.costPricePane);
				this.panelDetails.add(this.panelButtonMain);
				
				this.limitsPane.setCollapsed(true);
				this.glassPane.setCollapsed(true);
				this.costPricePane.setCollapsed(true);
			}
			
			this.validate();
			this.repaint();
		}
	}
	
	/**
	 * Number of leafs item state changed event
	 *
	 * @param e, ItemEvent
	 */
	private void noLeafs_itemStateChanged(ItemEvent e) {
		
		//Setting leaf selected
		this.leafs = Integer.parseInt(this.noLeafsC.getSelectedItem().toString());
		
		//Init Glass Components Pane
		this.initGlassComponentPane();
		this.initActionListeners();
		
		//**************************************
		//Init panelDetails
		//**************************************
		this.panelDetails.removeAll();
		this.panelDetails.add(this.headerPane);
		this.panelDetails.add(this.limitsPane);
		this.panelDetails.add(this.glassPane);
		this.panelDetails.add(this.costPricePane);
		this.panelDetails.add(this.panelButtonMain);
		
		this.limitsPane.setCollapsed(true);
		this.glassPane.setCollapsed(false);
		this.costPricePane.setCollapsed(true);
		
		this.validate();
		this.repaint();
	}
	
	/**
	 * Has insert1 action performed event
	 *
	 * @param e, ActionEvent
	 */
	private void hasInsert1_actionPerformed(ActionEvent e) {
		if (hasInsert1.isSelected()) {
			this.hasInsert1.setSelected(true);
			this.insert1idLbl.setVisible(true);
			this.insert1idC.setVisible(true);
		} else {
			this.hasInsert1.setSelected(false);
			this.insert1idLbl.setVisible(false);
			this.insert1idC.setVisible(false);
		}
	}
	
	/**
	 * Has insert2 action performed event
	 *
	 * @param e, ActionEvent
	 */
	private void hasInsert2_actionPerformed(ActionEvent e) {
		if (hasInsert2.isSelected()) {
			this.hasInsert2.setSelected(true);
			this.insert2idLbl.setVisible(true);
			this.insert2idC.setVisible(true);
		} else {
			this.hasInsert2.setSelected(false);
			this.insert2idLbl.setVisible(false);
			this.insert2idC.setVisible(false);
		}
	}
	
	/**
	 * Has insert3 action performed event
	 *
	 * @param e, ActionEvent
	 */
	private void hasInsert3_actionPerformed(ActionEvent e) {
		if (hasInsert3.isSelected()) {
			this.hasInsert3.setSelected(true);
			this.insert3idLbl.setVisible(true);
			this.insert3idC.setVisible(true);
		} else {
			this.hasInsert3.setSelected(false);
			this.insert3idLbl.setVisible(false);
			this.insert3idC.setVisible(false);
		}
	}
	
	//    private void upload_actionPerformed(ActionEvent ae) {
	//        chooser = new JFileChooser();
	//        chooser.setCurrentDirectory(new File("."));
	//        chooser.setDialogTitle(choosertitle);
	//        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	//        chooser.setAcceptAllFileFilterUsed(false);
	////        chooser.setFileView(new ImageFileView());
	////        chooser.setAccessory(new ImagePreview(chooser));
	////        chooser.addChoosableFileFilter(new ImageFilter());
	//        chooser.setLocation(220, 230);
	//        chooser.setPreferredSize(new Dimension(458, 360));
	//        chooser.setCurrentDirectory(currentDict);
	//        int returnval = chooser.showOpenDialog((Component) ae.getSource());
	//
	//
	//        try {
	//            if (returnval == 0) {
	//                FileInputStream fStream = new FileInputStream(chooser.
	//                        getSelectedFile().getPath());
	//                imageBytes = new byte[fStream.available()];
	//                fStream.read(imageBytes);
	//                image = imageBytes;
	//                ImageIcon myimg = new ImageIcon(imageBytes);
	//                int wx = myimg.getIconWidth();
	//                int hy = myimg.getIconHeight();
	//                if (hy > 300)
	//                    hy = 300;
	//                if (wx > 300)
	//                    wx = 300;
	//                ImageIcon thumbnail = new ImageIcon(myimg.getImage().getScaledInstance(
	//                        wx, hy, 2));
	//                imageArea.setIcon(thumbnail);
	//                //	        imageArea.setIconEditable(true);
	//                currentDict = chooser.getCurrentDirectory();
	//            }
	//
	//        } catch (Exception ex) {
	//            ex.printStackTrace();
	//        }
	//
	//    }
	
	//    private void setImage(byte[] imageBytes) {
	//        imageArea.setText("");
	//        if (imageBytes.length > 0) {
	//            try {
	//                if (imageBytes == null || imageBytes.length == 0) {
	//                    imageArea.setIcon(null);
	//                    image = null;
	//                    return;
	//                }
	//            } catch (Exception ex) {
	//                ex.printStackTrace();
	//            }
	//            try {
	//                if (imageBytes != null) {
	//                    image = imageBytes;
	//                    ImageIcon ii = new ImageIcon(imageBytes);
	//                    int xw = ii.getIconWidth();
	//                    int yh = ii.getIconHeight();
	//                    if (yh > 300) {
	//                        yh = 300;
	//                    }
	//                    if (xw > 300) {
	//                        xw = 300;
	//                    }
	//                    if (xw >= 0 || yh >= 0) {
	//                        ImageIcon thumbnail = new ImageIcon(ii.getImage().getScaledInstance(xw,
	//                                yh, 2));
	//                        imageArea.removeAll();
	//                        imageArea.setIcon(null);
	//                        imageArea.setIcon(thumbnail);
	//                        imageArea.setText("");
	//                    } else {
	//                        imageArea.setText("No Image Available");
	//                    }
	//                    this.validate();
	//                    this.repaint();
	//                }
	//            } catch (Exception ex) {
	//                ex.printStackTrace();
	//            }
	//
	//        }
	//    }
	//
	//    private byte[] getImage() {
	//        return image;
	//    }
}
