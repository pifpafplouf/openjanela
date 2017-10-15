package Presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import openjanela.app.configuration.controller.OptionAnswerController;
import openjanela.model.entities.partner.OptionAnswers;
import openjanela.model.entities.partner.OptionDefinitions;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXList;
import org.openjanela.component.JOpenJanelaComponent;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-25-13
 *          Time: 07:14 PM
 */
public class OptionAnswerDialog extends JDialog implements JOpenJanelaComponent {
	
	//Apache Log4j
	private static final Logger logger = Logger.getLogger(OptionAnswerDialog.class);
	
	private JPanel mainPanel;
	private JPanel optionDefinitionPanel;
	private JPanel optionAnswerPanel;
	private JPanel actionPanel;
	
	private JXList optionDefinitionList;
	private JXList optionAnswerList;
	
	private JScrollPane optionDefinitionScroll;
	private JScrollPane optionAnswerScroll;
	
	private JButton nextBtn;
	
	private final OptionDefinitions optionDefinitionsDefault;
	private OptionAnswers optionAnswersSelected;
	
	//Controller access
	private final OptionAnswerController optionAnswersController;
	
	ItemFrame mainFrame;
	/**
	 * Option Answer Dialog Constructor
	 *
	 * @param optionDefinition, OptionDefinitions
	 */
	public OptionAnswerDialog(OptionDefinitions optionDefinition, ItemFrame frame) {
		
		//Setting option definitions default
		this.optionDefinitionsDefault = optionDefinition;
		
		//Init Option Answers Controller
		this.optionAnswersController = new OptionAnswerController();
		this.mainFrame = frame;
		
		initComponents();
		initListenersComponents();
		initValueComponents();
		
		//Setting configuration of UI
		this.setTitle("Mandatory Option Choice Selection");
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(450, 360));
		this.setLocation((this.mainFrame.getWidth() / 2) - 225, (this.mainFrame.getHeight() / 2) - 230);
		
		this.setIconImage(ItemFrame.iconFiles.get("openJanelaIcon").getImage());
		
		//Setting visible UI
		this.setResizable(false);
		this.setModal(true);
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void initComponents() {
		
		//Setting JDialog Layout
		this.setLayout(new FlowLayout());
		
		//********************************************
		//Init option definition panel
		//********************************************
		this.optionDefinitionList = new JXList(new DefaultListModel());
		this.optionDefinitionList.setLayoutOrientation(JList.VERTICAL);
		this.optionDefinitionList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		this.optionDefinitionScroll = new JScrollPane();
		this.optionDefinitionScroll.setPreferredSize(new Dimension(200, 50));
		this.optionDefinitionScroll.getViewport().add(optionDefinitionList);
		
		this.optionDefinitionPanel = new JPanel(new BorderLayout());
		this.optionDefinitionPanel.setBorder(new TitledBorder("Mandatory Option"));
		this.optionDefinitionPanel.add(this.optionDefinitionScroll, BorderLayout.CENTER);
		
		//********************************************
		//Init option answers panel
		//********************************************
		this.optionAnswerList = new JXList(new DefaultListModel());
		this.optionAnswerList.setLayoutOrientation(JList.VERTICAL);
		this.optionAnswerList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		this.optionAnswerScroll = new JScrollPane();
		this.optionAnswerScroll.setPreferredSize(new Dimension(200, 250));
		this.optionAnswerScroll.getViewport().add(optionAnswerList);
		
		this.nextBtn = new JButton("Next >");
		this.nextBtn.setPreferredSize(new Dimension(80, 25));
		
		this.actionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.actionPanel.setBorder(new EtchedBorder());
		this.actionPanel.add(this.nextBtn);
		
		this.optionAnswerPanel = new JPanel(new BorderLayout());
		this.optionAnswerPanel.setBorder(new TitledBorder("Available Choices"));
		this.optionAnswerPanel.add(this.optionAnswerScroll, BorderLayout.NORTH);
		
		//*********************************************
		//Init Main panel
		//*********************************************
		this.mainPanel = new JPanel(new BorderLayout());
		this.mainPanel.add(optionDefinitionPanel, BorderLayout.WEST);
		this.mainPanel.add(optionAnswerPanel, BorderLayout.EAST);
		this.mainPanel.add(actionPanel, BorderLayout.SOUTH);
		
		this.add(mainPanel);
	}
	
	@Override
	public void initValueComponents() {
		
		//Init options Definitions Options
		List<OptionDefinitions> optionDefinitionsList = new ArrayList<OptionDefinitions>();
		optionDefinitionsList.add(optionDefinitionsDefault);
		
		this.optionDefinitionList.setListData(optionDefinitionsList.toArray());
		this.optionDefinitionList.setSelectedIndex(0);
	}
	
	@Override
	public void initListenersComponents() {
		
		this.optionDefinitionList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {

                OptionDefinitions optionDefinition = (OptionDefinitions) optionDefinitionList.getSelectedValue();

                //Search options answers
                List<OptionAnswers> answers = optionAnswersController.findOptionAnswers(optionDefinition);

                //Setting array to option answers list
                optionAnswerList.setListData(answers.toArray());
                optionAnswerList.setSelectedIndex(0);
			}
		});
		
		this.optionAnswerList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				OptionAnswers optionAnswers = (OptionAnswers) optionAnswerList.getSelectedValue();
				
				optionAnswersSelected = optionAnswers;
			}
		});
		
		this.nextBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (optionAnswersSelected == null && optionAnswerList.getModel().getSize() > 0) {
					JOptionPane.showMessageDialog(null, "Please select a valid option Choice", "Error",
								JOptionPane.ERROR_MESSAGE);
				} else {
					dispose();
				}
			}
		});
	}

    /**
     * Return option Answers selected
     *
     * @return OptionAnswers
     */
    public int getOptionAnswersSelected() {
        return optionAnswersSelected.getId().id;
    }
}
