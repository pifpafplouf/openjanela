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
import java.util.Iterator;
import java.util.List;

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
import openjanela.model.entities.admin.PriceChangeReason;
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
import openjanela.model.entities.partner.TypeCouplerMullion;
import openjanela.model.entities.parts.Parts;
import org.openjanela.component.JXTaskPaneOJ;
import org.openjanela.data.ApplicationBaseApp;

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
public class PriceDiscountReasonDialog extends JPanel {
	
	private int leafs = 2;
	
	
	private JPanel panelContent = new JPanel();
//	private JPanel panelButton = new JPanel();
//	private JPanel panelButtonMain = new JPanel();
	
	
//	private JButton saveButton = new JButton();
//	
//	private JButton cancelButton = new JButton();
	
	private JLabel reasonL = new JLabel("Reason:") ;
	private JComboBox reasonCmb = new JComboBox();
	
	private final ItemFrame myParent;
	
	private List<PriceChangeReason> changeReasons;
	PriceChangeReason changeReason = new PriceChangeReason();
	
	
	/**
	 * GlassSU Dialog Editing GlassSU
	 *
	 * @param parent,     ItemFrame
	 * @param controller, GlassSelectorPanelcontroller
	 */
	
	public PriceDiscountReasonDialog(ItemFrame parent) {
		
		this.myParent = parent;
		this.changeReasons = ApplicationBaseApp.getInstance().getChangeReasons();
//		this.setTitle("Manual Price/Discount Change Reason");
		if (changeReasons != null) {
	            this.addObjects(this.reasonCmb, changeReasons);

	            reasonCmb.setSelectedIndex(0);

	        }
		
		if(!myParent.isNewItem){
			changeReason =ApplicationBaseApp.getInstance().getChangeReason(this.myParent.jobItem.priceChangeReasonID);
			reasonCmb.setSelectedItem(changeReason);
		}
		
		panelContent.setLayout(new XYLayout());
		panelContent.add(this.reasonL, new XYConstraints(1,1,60,22));
		panelContent.add(this.reasonCmb, new XYConstraints(63,1,200,22));
		
		initPanelButton();
		
		this.add(panelContent, BorderLayout.CENTER);
//		this.add(panelButtonMain, BorderLayout.SOUTH);
		
		addActions();
		
		//Setting visible dialog
		this.setLocation((this.myParent.getWidth()) / 2 - 100, (this.myParent.getHeight()) / 2 - 200);
		this.setPreferredSize(new Dimension(300,  100));
//		this.setResizable(false);
//		this.pack();
//		this.setVisible(true);
//		this.setAlwaysOnTop(true);
//		this.setModal(true);
	}

	
	/**
	 * Init panel button
	 */
	private void initPanelButton() {
		
//		this.panelButton = new JPanel();
//		this.panelButton.setLayout(new HorizontalLayout());
//		this.panelButton.setPreferredSize(new Dimension(210, 24));
//		
//		this.panelButtonMain = new JPanel();
//		this.panelButtonMain.setLayout(new BorderLayout());
//		this.panelButtonMain.setBorder(BorderFactory.createEtchedBorder());
//		
//		this.saveButton = new JButton();
//		this.saveButton.setIcon(myParent.saveImage);
//		this.saveButton.setToolTipText("Save");
//		this.saveButton.setPreferredSize(new Dimension(30, 20));
//		
//		this.cancelButton = new JButton();
//		this.cancelButton.setIcon(myParent.cancelImage);
//		this.cancelButton.setToolTipText("Cancel");
//		this.cancelButton.setPreferredSize(new Dimension(30, 20));
//	
//		
//		this.panelButton.add(saveButton);
//		this.panelButton.add(cancelButton);
//		
//		panelButtonMain.add(this.panelButton, BorderLayout.WEST);
	}


	public void addActions()
	{
	
//		this.saveButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				try {
//					
//					save_actionPerformed(e);
//				
//				} catch (Exception ex) {
//					System.err.println(ex.getMessage());
//					
//					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//				}
//			}
//		});
//		
//		this.cancelButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				cancel_actionPerformed(e);
//			}
//		});
	}
	
	/**
	 * Save action performed
	 *
	 * @param e, ActionEvent
	 * @throws Exception, Exception
	 */
	private void save_actionPerformed(ActionEvent e) throws Exception {
		
		//Setting values to SUType
		this.myParent.jobItem.priceChangeReasonID = ((PriceChangeReason) this.reasonCmb.getSelectedItem()).getId();
		
//		this.myParent.doSaveAction();
		
		//Show error message dialog
//		this.dispose();
		
		
	}
	
	
	
	/**
	 * Cancel action performed
	 *
	 * @param e, ActionEvent
	 */
	private void cancel_actionPerformed(ActionEvent e) {
//		saveButton.setEnabled(true);
//		cancelButton.setEnabled(false);
	}
	
	/**
	 * Has insert1 action performed event
	 *
	 * @param e, ActionEvent
	 */

	
	 private void addObjects(JComboBox box, Collection data) {

	      
	        box.removeAllItems();
	        Iterator ia = data.iterator();
	        while (ia.hasNext()) {
	            box.addItem(ia.next());
	        }

	    }

}
