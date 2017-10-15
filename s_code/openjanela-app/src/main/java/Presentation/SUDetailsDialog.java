/**
 * *****************************************************************************
 * Copyright (c) 2009 Sherif El Dibani. All rights reserved.
 *
 * Contributors: Sherif El Dibani
 * *****************************************************************************
 */
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
import javax.swing.RootPaneContainer;
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
import util.ProjectDetails;
import util.XYConstraints;
import util.XYLayout;

public class SUDetailsDialog extends JDialog {
	
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
	 * SUDetails Dialog Editing SUType
	 *
	 * @param parent,     ItemFrame
	 * @param controller, GlassSelectorPanelcontroller
	 */
	public SUDetailsDialog(ItemFrame parent, GlassSelectorPanelController controller) {
		super( parent.myParent, ProjectDetails.PROJECT_NAME + " - " + ProjectDetails.PROJECT_VERSION, true);
		
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
			SUType suType = controller.getSuTypeSelected();
			
			idTxt.setText(suType.getId() + ""); //Id
			scTxt.setText(suType.getStockCode()); //Stock code
			descTxt.setText(suType.getDescription()); //Description
			nextTxt.setText(suType.getNextItem() + ""); //Next
			displayChk.setSelected(suType.getDisplay()); //Display
			sortTxt.setText(suType.getSortSeq() + ""); //Sort sequence
			
			//Type Glazing
			for (Object typeGlazing : glazingTypes) {
				if (suType.getGlazingType() != null) {
					if (suType.getGlazingType().equals(((TypeGlazing) typeGlazing).getId())) {
						typeCmb.setSelectedItem(typeGlazing);
					}
				}
			}
			
			noLeafsC.setSelectedItem(String.valueOf(suType.getNumOfLeaves())); //Number of leaves
			this.leafs = suType.getNumOfLeaves();
			wasteTxt.setText(suType.getWaste() + ""); //Waste
			
			//SU Family
			for (Object suFamily : suFamilies) {
				if (suType.getFamilyId() != null) {
					if (suType.getFamilyId().equals(((SUFamily) suFamily).getId())) {
						familyCmb.setSelectedItem(suFamily);
					}
				}
			}
			
			madeinChk.setSelected(suType.getMadeIn()); //Made in
			abbrevTxt.setText(suType.getAbbrev()); //Abbrev
			
			//Production Line
			for (Object productionLine : prodLines) {
				if (suType.getProductionLine() != null) {
					if (suType.getProductionLine().equals(((ProductionLine) productionLine).getId())) {
						prodLineCmb.setSelectedItem(productionLine);
					}
				}
			}
			
			//Supplier
			for (Object supplier : suppliers) {
				if (suType.getSupplierId() != null) {
					if (suType.getSupplierId().equals(((Partner) supplier).getPartnerid())) {
						supCmb.setSelectedItem(supplier);
					}
				}
			}
			
			ltT.setText(suType.getLeadTime() + ""); //Lead time                
			fromDate.setDate(suType.getStartDate()); //Start date
			toDate.setDate(suType.getEndDate()); //End date
			isCustomChk.setSelected(suType.getCustom()); //Custom
			
			//Thickness
			thickT.setText(suType.getThickness() + "");
			thickiT.setText(suType.getThicknessImp() + "");
			
			//Glass to Spacer in
			gtoST.setText(suType.getGlassEdgeToSpacerIn() + "");
			gtoSiT.setText(suType.getGlassEdgeToSpacerInImp() + "");
			
			//Min Area
			minAreaT.setText(suType.getMinArea() + "");
			minAreaiT.setText(suType.getMinAreaImp() + "");
			
			//Max Area
			maxAreaT.setText(suType.getMaxArea() + "");
			maxAreaiT.setText(suType.getMaxAreaImp() + "");
			
			//Min W
			minWT.setText(suType.getMinWidth() + "");
			minWiT.setText(suType.getMinWidthImp() + "");
			
			//Max W
			maxWT.setText(suType.getMaxWidth() + "");
			maxWiT.setText(suType.getMaxWidthImp() + "");
			
			//Min H
			minHT.setText(suType.getMinHeight() + "");
			minHiT.setText(suType.getMinHeightImp() + "");
			
			//Max H
			maxHT.setText(suType.getMaxHeight() + "");
			maxHiT.setText(suType.getMaxHeightImp() + "");
			
			//Min price Area
			minpriceAT.setText(suType.getMinPricingArea() + "");
			minpriceAiT.setText(suType.getMinPricingAreaImp() + "");
			
			//Min cost Area
			minpcostAT.setText(suType.getMinCostArea() + "");
			mincostAiT.setText(suType.getMinCostAreaImp() + "");
			
			//Ratio
			whRatioT.setText(suType.getWhRatio() + "");
			
			//Sealant
			for (Object part : sealants) {
				if (suType.getSealantPartId() != null) {
					if (suType.getSealantPartId().equals(((Parts) part).getId())) {
						sealantC.setSelectedItem(part);
					}
				}
			}
			
			//Glass1C
			for (Object glass : glass1) {
				if (suType.getLeaf1Id() != null) {
					if (suType.getLeaf1Id().equals(((SUType) glass).getId())) {
						glass1C.setSelectedItem(glass);
					}
				}
			}
			
			//Glass2C
			for (Object glass : glass1) {
				if (suType.getLeaf2Id() != null) {
					if (suType.getLeaf2Id().equals(((SUType) glass).getId())) {
						glass2C.setSelectedItem(glass);
					}
				}
			}
			
			//Glass3C
			for (Object glass : glass1) {
				if (suType.getLeaf3Id() != null) {
					if (suType.getLeaf3Id().equals(((SUType) glass).getId())) {
						glass3C.setSelectedItem(glass);
					}
				}
			}
			
			//Glass4C
			for (Object glass : glass1) {
				if (suType.getLeaf4Id() != null) {
					if (suType.getLeaf4Id().equals(((SUType) glass).getId())) {
						glass4C.setSelectedItem(glass);
					}
				}
			}
			
			//Glassf1C
			for (Object part : films) {
				if (suType.getGlass1FilmPartId() != null) {
					if (suType.getGlass1FilmPartId().equals(((Parts) part).getId())) {
						glassf1C.setSelectedItem(part);
					}
				}
			}
			
			//Glassf2C
			for (Object part : films) {
				if (suType.getGlass2FilmPartId() != null) {
					if (suType.getGlass2FilmPartId().equals(((Parts) part).getId())) {
						glassf2C.setSelectedItem(part);
					}
				}
			}
			
			//Glassf3C
			for (Object part : films) {
				if (suType.getGlass3FilmPartId() != null) {
					if (suType.getGlass3FilmPartId().equals(((Parts) part).getId())) {
						glassf3C.setSelectedItem(part);
					}
				}
			}
			
			//Glassf4C
			for (Object part : films) {
				if (suType.getGlass4FilmPartId() != null) {
					if (suType.getGlass4FilmPartId().equals(((Parts) part).getId())) {
						glassf4C.setSelectedItem(part);
					}
				}
			}
			
			//Glass process 11
			for (Object part : processes) {
				if (suType.getCavity1ProcessId() != null) {
					if (suType.getCavity1ProcessId().equals(((Parts) part).getId())) {
						glassp11C.setSelectedItem(part);
					}
				}
			}
			
			//Glass process 12
			for (Object part : processes) {
				if (suType.getCavity1Process2Id() != null) {
					if (suType.getCavity1Process2Id().equals(((Parts) part).getId())) {
						glassp12C.setSelectedItem(part);
					}
				}
			}
			
			//Glass process 13
			for (Object part : processes) {
				if (suType.getCavity1Process3Id() != null) {
					if (suType.getCavity1Process3Id().equals(((Parts) part).getId())) {
						glassp13C.setSelectedItem(part);
					}
				}
			}
			
			//Glass process 21
			for (Object part : processes) {
				if (suType.getCavity2ProcessId() != null) {
					if (suType.getCavity2ProcessId().equals(((Parts) part).getId())) {
						glassp21C.setSelectedItem(part);
					}
				}
			}
			
			//Glass process 22
			for (Object part : processes) {
				if (suType.getCavity2Process2Id() != null) {
					if (suType.getCavity2Process2Id().equals(((Parts) part).getId())) {
						glassp22C.setSelectedItem(part);
					}
				}
			}
			
			//Glass process 23
			for (Object part : processes) {
				if (suType.getCavity2Process3Id() != null) {
					if (suType.getCavity2Process3Id().equals(((Parts) part).getId())) {
						glassp23C.setSelectedItem(part);
					}
				}
			}
			
			//Glass process 31
			for (Object part : processes) {
				if (suType.getCavity3ProcessId() != null) {
					if (suType.getCavity3ProcessId().equals(((Parts) part).getId())) {
						glassp31C.setSelectedItem(part);
					}
				}
			}
			
			//Glass process 32
			for (Object part : processes) {
				if (suType.getCavity3Process2Id() != null) {
					if (suType.getCavity3Process2Id().equals(((Parts) part).getId())) {
						glassp32C.setSelectedItem(part);
					}
				}
			}
			
			//Glass process 33
			for (Object part : processes) {
				if (suType.getCavity3Process3Id() != null) {
					if (suType.getCavity3Process3Id().equals(((Parts) part).getId())) {
						glassp33C.setSelectedItem(part);
					}
				}
			}
			
			//Glass process 41
			for (Object part : processes) {
				if (suType.getGlass4ProcessId() != null) {
					if (suType.getGlass4ProcessId().equals(((Parts) part).getId()))
						glassp41C.setSelectedItem(part);
				}
			}
			
			//Glass process 42
			for (Object part : processes) {
				if (suType.getGlass4Process2Id() != null) {
					if (suType.getGlass4Process2Id().equals(((Parts) part).getId())) {
						glassp42C.setSelectedItem(part);
					}
				}
			}
			
			//Glass process 43
			for (Object part : processes) {
				if (suType.getGlass4Process3Id() != null) {
					if (suType.getGlass4Process3Id().equals(((Parts) part).getId())) {
						glassp43C.setSelectedItem(part);
					}
				}
			}
			
			//Spacer 1
			for (Object part : spacers) {
				if (suType.getSpacer1PartId() != null) {
					if (suType.getSpacer1PartId().equals(((Parts) part).getId())) {
						spacer1C.setSelectedItem(part);
					}
				}
			}
			
			//Spacer 2
			for (Object part : spacers) {
				if (suType.getSpacer2PartId() != null) {
					if (suType.getSpacer2PartId().equals(((Parts) part).getId())) {
						spacer2C.setSelectedItem(part);
					}
				}
			}
			
			//Spacer 3
			for (Object part : spacers) {
				if (suType.getSpacer3PartId() != null) {
					if (suType.getSpacer3PartId().equals(((Parts) part).getId())) {
						spacer3C.setSelectedItem(part);
					}
				}
			}
			
			//Gas 1
			for (Object part : gases) {
				if (suType.getGas1PartId() != null) {
					if (suType.getGas1PartId().equals(((Parts) part).getId())) {
						gas1C.setSelectedItem(part);
					}
				}
			}
			
			//Gas 2
			for (Object part : gases) {
				if (suType.getGas2PartId() != null) {
					if (suType.getGas2PartId().equals(((Parts) part).getId())) {
						gas2C.setSelectedItem(part);
					}
				}
			}
			
			//Gas 3
			for (Object part : gases) {
				if (suType.getGas3PartId() != null) {
					if (suType.getGas3PartId().equals(((Parts) part).getId())) {
						gas3C.setSelectedItem(part);
					}
				}
			}
			
			//Cp 1
			for (Object part : processes) {
				if (suType.getCavity1ProcessId() != null) {
					if (suType.getCavity1ProcessId().equals(((Parts) part).getId())) {
						cp1C.setSelectedItem(part);
					}
				}
			}
			
			//Cp 2
			for (Object part : processes) {
				if (suType.getCavity2ProcessId() != null) {
					if (suType.getCavity2ProcessId().equals(((Parts) part).getId())) {
						cp2C.setSelectedItem(part);
					}
				}
			}
			
			//Cp 3
			for (Object part : processes) {
				if (suType.getCavity3ProcessId() != null) {
					if (suType.getCavity3ProcessId().equals(((Parts) part).getId())) {
						cp3C.setSelectedItem(part);
					}
				}
			}
			
			//Insert1id
			for (Object suTypeObject : inserts) {
				if (suType.getInsert1Id() != null) {
					if (suType.getInsert1Id().equals(((SUType) suTypeObject).getId())) {
						insert1idC.setSelectedItem(suTypeObject);
						hasInsert1.setSelected(true);
					}
				}
			}
			
			//Insert2id
			for (Object suTypeObject : inserts) {
				if (suType.getInsert2Id() != null) {
					if (suType.getInsert2Id().equals(((SUType) suTypeObject).getId())) {
						insert2idC.setSelectedItem(suTypeObject);
						hasInsert2.setSelected(true);
					}
				}
			}
			
			//Insert3id
			for (Object suTypeObject : inserts) {
				if (suType.getInsert3Id() != null) {
					if (suType.getInsert3Id().equals(((SUType) suTypeObject).getId())) {
						insert3idC.setSelectedItem(suTypeObject);
						hasInsert3.setSelected(true);
					}
				}
			}
			
			//Price UOM
			for (Object systemUOM : uoms) {
				if (suType.getPricingUOMId() != null) {
					if (suType.getPricingUOMId().equals(((SystemUOM) systemUOM).getId())) {
						priceuomC.setSelectedItem(systemUOM);
					}
				}
			}
			
			priceactualChk.setSelected(suType.getPriceActualSize()); //Price actual
			costactualChk.setSelected(suType.getCostActualSize()); //Cost actual
			priceT.setText(suType.getPrice() + ""); //Price
			minpriceT.setText(suType.getMinPrice() + ""); //Min Price
			costT.setText(suType.getCost() + ""); //Cost
			
			//Pricing Group
			for (Object priceGroup : priceGroups) {
				if (suType.getPriceGroupId() != null) {
					if (suType.getPriceGroupId().equals(((PricingGroup) priceGroup).getId())) {
						priceGroupC.setSelectedItem(priceGroup);
					}
				}
			}
			
			//Costing Group
			for (Object costGroup : costGroups) {
				if (suType.getCostGroupId() != null) {
					if (suType.getCostGroupId().equals(((CostingGroup) costGroup).getId())) {
						costGroupC.setSelectedItem(costGroup);
					}
				}
			}
			
			//Matrix
			for (Object matrixHeader : matrices) {
				if (suType.getPriceMatrixId() != null) {
					if (suType.getPriceMatrixId().equals(((MatrixHeader) matrixHeader).getId())) {
						matrixPriceChk.setSelected(true);
						priceMatrixC.setSelectedItem(matrixHeader);
						priceMatrixC.setEnabled(true);
					}
				}
			}
			
			//********************************************************************
			//Evaluating glazing type 
			//********************************************************************
			if (suType.getGlazingType() == GlazingTypes.GLASS.getValue()) {
				
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
				
			} else if (suType.getGlazingType() == GlazingTypes.SU.getValue()) {
				
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
				
			} else if (suType.getGlazingType() >= GlazingTypes.INSERT.getValue()) {
				
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
	
	//    private void cloneNewSUType() {
	//
	//        try {
	//            SUType suType = controller.getSuTypeSelected().clone();
	//            suType.setStockCode(scTxt.getText()); //Stock code
	//            suType.setDescription(descTxt.getText()); //Description
	//            suType.setSealantPartId(sealantC.getSelectedItem() != null ? ((Parts) sealantC.getSelectedItem()).getId() : null); //Sealant
	//            suType.setLeaf1Id(glass1C.getSelectedItem() != null ? ((SUType) glass1C.getSelectedItem()).getId() : null); //Leaf1
	//            suType.setLeaf2Id(glass2C.getSelectedItem() != null ? ((SUType) glass2C.getSelectedItem()).getId() : null); //Leaf2
	//            suType.setLeaf3Id(glass3C.getSelectedItem() != null ? ((SUType) glass3C.getSelectedItem()).getId() : null); //Leaf3
	//            suType.setLeaf4Id(glass4C.getSelectedItem() != null ? ((SUType) glass4C.getSelectedItem()).getId() : null); //Leaf4
	//            suType.setGlass1FilmPartId(glassf1C.getSelectedItem() != null ? ((Parts) glassf1C.getSelectedItem()).getId() : null); //film1
	//            suType.setGlass2FilmPartId(glassf2C.getSelectedItem() != null ? ((Parts) glassf2C.getSelectedItem()).getId() : null); //film2
	//            suType.setGlass3FilmPartId(glassf3C.getSelectedItem() != null ? ((Parts) glassf3C.getSelectedItem()).getId() : null); //film3
	//            suType.setGlass4FilmPartId(glassf4C.getSelectedItem() != null ? ((Parts) glassf4C.getSelectedItem()).getId() : null); //film4
	//            suType.setCavity1ProcessId(glassp11C.getSelectedItem() != null ? ((Parts) glassp11C.getSelectedItem()).getId() : null); //process11
	//            suType.setCavity2ProcessId(glassp12C.getSelectedItem() != null ? ((Parts) glassp12C.getSelectedItem()).getId() : null); //process12
	//            suType.setCavity3ProcessId(glassp13C.getSelectedItem() != null ? ((Parts) glassp13C.getSelectedItem()).getId() : null); //process12
	//            suType.setCavity2ProcessId(glassp21C.getSelectedItem() != null ? ((Parts) glassp21C.getSelectedItem()).getId() : null); //process21
	//            suType.setCavity2Process2Id(glassp22C.getSelectedItem() != null ? ((Parts) glassp22C.getSelectedItem()).getId() : null); //process22
	//            suType.setCavity2Process3Id(glassp23C.getSelectedItem() != null ? ((Parts) glassp23C.getSelectedItem()).getId() : null); //process23
	//            suType.setCavity3ProcessId(glassp31C.getSelectedItem() != null ? ((Parts) glassp31C.getSelectedItem()).getId() : null); //process31
	//            suType.setCavity3Process2Id(glassp32C.getSelectedItem() != null ? ((Parts) glassp32C.getSelectedItem()).getId() : null); //process32
	//            suType.setCavity3Process3Id(glassp33C.getSelectedItem() != null ? ((Parts) glassp33C.getSelectedItem()).getId() : null); //process33
	//            suType.setGlass4ProcessId(glassp41C.getSelectedItem() != null ? ((Parts) glassp41C.getSelectedItem()).getId() : null); //process41
	//            suType.setGlass4Process2Id(glassp42C.getSelectedItem() != null ? ((Parts) glassp42C.getSelectedItem()).getId() : null); //process42
	//            suType.setGlass4Process3Id(glassp43C.getSelectedItem() != null ? ((Parts) glassp43C.getSelectedItem()).getId() : null); //process43
	//            suType.setSpacer1PartId(spacer1C.getSelectedItem() != null ? ((Parts) spacer1C.getSelectedItem()).getId() : null); //Spacer 1
	//            suType.setSpacer2PartId(spacer2C.getSelectedItem() != null ? ((Parts) spacer2C.getSelectedItem()).getId() : null); //Spacer 2
	//            suType.setSpacer3PartId(spacer3C.getSelectedItem() != null ? ((Parts) spacer3C.getSelectedItem()).getId() : null); //Spacer 3
	//            suType.setGas1PartId(gas1C.getSelectedItem() != null ? ((Parts) gas1C.getSelectedItem()).getId() : null); //Gas 1
	//            suType.setGas2PartId(gas2C.getSelectedItem() != null ? ((Parts) gas2C.getSelectedItem()).getId() : null); //Gas 2
	//            suType.setGas3PartId(gas3C.getSelectedItem() != null ? ((Parts) gas3C.getSelectedItem()).getId() : null); //Gas 3
	//            suType.setCavity1ProcessId(cp1C.getSelectedItem() != null ? ((Parts) cp1C.getSelectedItem()).getId() : null); //Cavity Process 11
	//            suType.setCavity2ProcessId(cp2C.getSelectedItem() != null ? ((Parts) cp2C.getSelectedItem()).getId() : null); //Cavity Process 21
	//            suType.setCavity3ProcessId(cp3C.getSelectedItem() != null ? ((Parts) cp3C.getSelectedItem()).getId() : null); //Cavity Process 31
	//
	//            if (hasInsert1.isSelected())
	//                suType.setInsert1Id(insert1idC.getSelectedItem() != null ? ((SUType) insert1idC.getSelectedItem()).getId() : null); //Insert 1
	//            else
	//                suType.setInsert1Id(null);
	//
	//            if (hasInsert2.isSelected())
	//                suType.setInsert2Id(insert2idC.getSelectedItem() != null ? ((SUType) insert2idC.getSelectedItem()).getId() : null); //Insert 2
	//            else
	//                suType.setInsert2Id(0);
	//
	//            if (hasInsert3.isSelected())
	//                suType.setInsert3Id(insert3idC.getSelectedItem() != null ? ((SUType) insert3idC.getSelectedItem()).getId() : null); //Insert 3
	//            else
	//                suType.setInsert3Id(0);
	//
	//            suType.setPricingUOMId(priceuomC.getSelectedItem() != null ? ((SystemUOM) priceuomC.getSelectedItem()).getId() : null); //Pricing UOM Id
	//            suType.setPriceActualSize(priceactualChk.isSelected()); //Price actual size
	//            suType.setCostActualSize(costactualChk.isSelected()); //Cost actual size
	//            suType.setPrice(new BigDecimal(priceT.getText())); //Price
	//            suType.setMinPrice(new BigDecimal(minpriceAT.getText())); //Min Price
	//            suType.setCost(new BigDecimal(costT.getText())); //Cost
	//            suType.setPriceGroupId(priceGroupC.getSelectedItem() != null ? ((PricingGroup) priceGroupC.getSelectedItem()).getId() : null); //Pricing group
	//            suType.setCostGroupId(costGroupC.getSelectedItem() != null ? ((CostingGroup) costGroupC.getSelectedItem()).getId() : null); //Costing group
	//
	//            if (matrixPriceChk.isSelected())
	//                suType.setPriceMatrixId(priceMatrixC.getSelectedItem() != null ? ((MatrixHeader) priceMatrixC.getSelectedItem()).getId() : null); //Price matrix Id
	//            else
	//                suType.setPriceMatrixId(null);
	//
	//            /* Adding new SU Type customizable */
	//            controller.addingNewSUType(suType);
	//
	////            suType.setId(controller.getSuTypeSelected().getId());
	////            suType.setStockCode(controller.getSuTypeSelected().getStockCode());
	////            suType.setDescription(controller.getSuTypeSelected().getDescription());
	////            suType.setMinArea(controller.getSuTypeSelected().getMinArea());
	////            suType.setMinAreaImp(controller.getSuTypeSelected().getMinAreaImp());
	////            suType.setMaxArea(controller.getSuTypeSelected().getMaxArea());
	////            suType.setMaxAreaImp(controller.getSuTypeSelected().getMaxAreaImp());
	////            suType.setMinWidth(controller.getSuTypeSelected().getMinWidth());
	////            suType.setMinWidthImp(controller.getSuTypeSelected().getMinWidthImp());
	////            suType.setMaxWidth(controller.getSuTypeSelected().getMaxWidth());
	////            suType.setMaxWidthImp(controller.getSuTypeSelected().getMaxWidthImp());
	////            suType.setMinHeight(controller.getSuTypeSelected().getMinHeight());
	////            suType.setMinHeightImp(controller.getSuTypeSelected().getMinHeightImp());
	////            suType.setMaxHeight(controller.getSuTypeSelected().getMaxHeight());
	////            suType.setMaxHeightImp(controller.getSuTypeSelected().getMaxHeightImp());
	////            suType.setWhRatio(controller.getSuTypeSelected().getWhRatio());
	////            suType.setPricingUOMId(controller.getSuTypeSelected().getPricingUOMId());
	////            suType.setPriceActualSize(controller.getSuTypeSelected().getPriceActualSize());
	////
	//
	//        } catch (CloneNotSupportedException e) {
	//            System.err.println(e.getMessage());
	//        }
	
	//    }
	
	/**
	 * Setting edit values to SUType
	 */
	private void setValuesToSUType() {
		
		if (controller.getSuTypeSelected() != null) {
			
			controller.getSuTypeSelected().setStockCode(scTxt.getText()); //Stock code
			controller.getSuTypeSelected().setDescription(descTxt.getText()); //Description
			controller.getSuTypeSelected().setSupplierId(supCmb.getSelectedItem() != null ? ((Partner) supCmb.getSelectedItem()).getId() : -1); //Supplier
			controller.getSuTypeSelected().setSealantPartId(sealantC.getSelectedItem() != null ? ((Parts) sealantC.getSelectedItem()).getId() : -1); //Sealant
			controller.getSuTypeSelected().setLeaf1Id(glass1C.getSelectedItem() != null ? ((SUType) glass1C.getSelectedItem()).getId() : -1); //Leaf1
			controller.getSuTypeSelected().setLeaf2Id(glass2C.getSelectedItem() != null ? ((SUType) glass2C.getSelectedItem()).getId() : -1); //Leaf2
			controller.getSuTypeSelected().setLeaf3Id(glass3C.getSelectedItem() != null ? ((SUType) glass3C.getSelectedItem()).getId() : -1); //Leaf3
			controller.getSuTypeSelected().setLeaf4Id(glass4C.getSelectedItem() != null ? ((SUType) glass4C.getSelectedItem()).getId() : -1); //Leaf4
			controller.getSuTypeSelected().setGlass1FilmPartId(glassf1C.getSelectedItem() != null ? ((Parts) glassf1C.getSelectedItem()).getId() : -1); //film1
			controller.getSuTypeSelected().setGlass2FilmPartId(glassf2C.getSelectedItem() != null ? ((Parts) glassf2C.getSelectedItem()).getId() : -1); //film2
			controller.getSuTypeSelected().setGlass3FilmPartId(glassf3C.getSelectedItem() != null ? ((Parts) glassf3C.getSelectedItem()).getId() : -1); //film3
			controller.getSuTypeSelected().setGlass4FilmPartId(glassf4C.getSelectedItem() != null ? ((Parts) glassf4C.getSelectedItem()).getId() : -1); //film4
			controller.getSuTypeSelected().setCavity1ProcessId(glassp11C.getSelectedItem() != null ? ((Parts) glassp11C.getSelectedItem()).getId() : -1); //process11
			controller.getSuTypeSelected().setCavity2ProcessId(glassp12C.getSelectedItem() != null ? ((Parts) glassp12C.getSelectedItem()).getId() : -1); //process12
			controller.getSuTypeSelected().setCavity3ProcessId(glassp13C.getSelectedItem() != null ? ((Parts) glassp13C.getSelectedItem()).getId() : -1); //process12
			controller.getSuTypeSelected().setCavity2ProcessId(glassp21C.getSelectedItem() != null ? ((Parts) glassp21C.getSelectedItem()).getId() : -1); //process21
			controller.getSuTypeSelected().setCavity2Process2Id(glassp22C.getSelectedItem() != null ? ((Parts) glassp22C.getSelectedItem()).getId() : -1); //process22
			controller.getSuTypeSelected().setCavity2Process3Id(glassp23C.getSelectedItem() != null ? ((Parts) glassp23C.getSelectedItem()).getId() : -1); //process23
			controller.getSuTypeSelected().setCavity3ProcessId(glassp31C.getSelectedItem() != null ? ((Parts) glassp31C.getSelectedItem()).getId() : -1); //process31
			controller.getSuTypeSelected().setCavity3Process2Id(glassp32C.getSelectedItem() != null ? ((Parts) glassp32C.getSelectedItem()).getId() : -1); //process32
			controller.getSuTypeSelected().setCavity3Process3Id(glassp33C.getSelectedItem() != null ? ((Parts) glassp33C.getSelectedItem()).getId() : -1); //process33
			controller.getSuTypeSelected().setGlass4ProcessId(glassp41C.getSelectedItem() != null ? ((Parts) glassp41C.getSelectedItem()).getId() : -1); //process41
			controller.getSuTypeSelected().setGlass4Process2Id(glassp42C.getSelectedItem() != null ? ((Parts) glassp42C.getSelectedItem()).getId() : -1); //process42
			controller.getSuTypeSelected().setGlass4Process3Id(glassp43C.getSelectedItem() != null ? ((Parts) glassp43C.getSelectedItem()).getId() : -1); //process43
			controller.getSuTypeSelected().setSpacer1PartId(spacer1C.getSelectedItem() != null ? ((Parts) spacer1C.getSelectedItem()).getId() : -1); //Spacer 1
			controller.getSuTypeSelected().setSpacer2PartId(spacer2C.getSelectedItem() != null ? ((Parts) spacer2C.getSelectedItem()).getId() : -1); //Spacer 2
			controller.getSuTypeSelected().setSpacer3PartId(spacer3C.getSelectedItem() != null ? ((Parts) spacer3C.getSelectedItem()).getId() : -1); //Spacer 3
			controller.getSuTypeSelected().setGas1PartId(gas1C.getSelectedItem() != null ? ((Parts) gas1C.getSelectedItem()).getId() : -1); //Gas 1
			controller.getSuTypeSelected().setGas2PartId(gas2C.getSelectedItem() != null ? ((Parts) gas2C.getSelectedItem()).getId() : -1); //Gas 2
			controller.getSuTypeSelected().setGas3PartId(gas3C.getSelectedItem() != null ? ((Parts) gas3C.getSelectedItem()).getId() : -1); //Gas 3
			controller.getSuTypeSelected().setCavity1ProcessId(cp1C.getSelectedItem() != null ? ((Parts) cp1C.getSelectedItem()).getId() : -1); //Cavity Process 11
			controller.getSuTypeSelected().setCavity2ProcessId(cp2C.getSelectedItem() != null ? ((Parts) cp2C.getSelectedItem()).getId() : -1); //Cavity Process 21
			controller.getSuTypeSelected().setCavity3ProcessId(cp3C.getSelectedItem() != null ? ((Parts) cp3C.getSelectedItem()).getId() : -1); //Cavity Process 31
			
			if (hasInsert1.isSelected())
				controller.getSuTypeSelected().setInsert1Id(insert1idC.getSelectedItem() != null ? ((SUType) insert1idC.getSelectedItem()).getId() : -1); //Insert 1
			else
				controller.getSuTypeSelected().setInsert1Id(-1);
			
			if (hasInsert2.isSelected())
				controller.getSuTypeSelected().setInsert2Id(insert2idC.getSelectedItem() != null ? ((SUType) insert2idC.getSelectedItem()).getId() : -1); //Insert 2
			else
				controller.getSuTypeSelected().setInsert2Id(-1);
			
			if (hasInsert3.isSelected())
				controller.getSuTypeSelected().setInsert3Id(insert3idC.getSelectedItem() != null ? ((SUType) insert3idC.getSelectedItem()).getId() : -1); //Insert 3
			else
				controller.getSuTypeSelected().setInsert3Id(-1);
			
			controller.getSuTypeSelected().setPricingUOMId(priceuomC.getSelectedItem() != null ? ((SystemUOM) priceuomC.getSelectedItem()).getId() : -1); //Pricing UOM Id
			controller.getSuTypeSelected().setPriceActualSize(priceactualChk.isSelected()); //Price actual size
			controller.getSuTypeSelected().setCostActualSize(costactualChk.isSelected()); //Cost actual size
			controller.getSuTypeSelected().setPrice(new BigDecimal(priceT.getText())); //Price
			controller.getSuTypeSelected().setMinPrice(new BigDecimal(minpriceAT.getText())); //Min Price
			controller.getSuTypeSelected().setCost(new BigDecimal(costT.getText())); //Cost
			controller.getSuTypeSelected().setPriceGroupId(priceGroupC.getSelectedItem() != null ? ((PricingGroup) priceGroupC.getSelectedItem()).getId() : -1); //Pricing group
			controller.getSuTypeSelected().setCostGroupId(costGroupC.getSelectedItem() != null ? ((CostingGroup) costGroupC.getSelectedItem()).getId() : -1); //Costing group
			
			if (matrixPriceChk.isSelected())
				controller.getSuTypeSelected().setPriceMatrixId(priceMatrixC.getSelectedItem() != null ? ((MatrixHeader) priceMatrixC.getSelectedItem()).getId() : -1); //Price matrix Id
			else
				controller.getSuTypeSelected().setPriceMatrixId(-1);
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
					//myParent.jobItem.design.resetDrawing();
					
					
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
		//        cloneNewSUType();
		
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
}
