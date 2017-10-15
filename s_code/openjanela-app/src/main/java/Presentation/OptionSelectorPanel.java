/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/

package Presentation;

import Model.DesignOption;
import Model.OptionTableModel;
import Model.ShapeOption;
import openjanela.model.entities.partner.OptionAnswers;

import orderEntryUtility.DesignOptionSorter;
import org.jdesktop.swingx.JXTable;
import org.pushingpixels.substance.api.renderers.SubstanceDefaultTableCellRenderer;

import util.XYConstraints;
import util.XYLayout;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class OptionSelectorPanel extends JPanel {

    ItemFrame myParent;

    public JPanel mainPanel = new JPanel();

    public JPanel optionPanel = new JPanel();

    public JPanel byFramePanel = new JPanel();

    public JPanel bottomPanel = new JPanel();

    public JPanel framOptionPanel = new JPanel();

    JTable optionsTable = new JTable();

    JTable frameOptionsTable = new JTable();

    public JScrollPane optionScroll = new JScrollPane();

    public JScrollPane frameOptionScroll = new JScrollPane();

    public JCheckBox byFrame = new JCheckBox();

    public JLabel byFrameL = new JLabel();

    public Vector options = new Vector();

    DesignOption myOption = new DesignOption();

    JComboBox answerC = new JComboBox();

    Collection myAnswers = new ArrayList();

    String answerText = " ANSWER ";

    OptionAnswers myAnswer = new OptionAnswers();

    public OptionTableModel optionTableModel;

    public DesignOption mySelectedOption = new DesignOption();

    public OptionAnswers mySelectedAnswer = new OptionAnswers();

    public OptionChoiceColumns m_columns[] =
            {
                    new OptionChoiceColumns("", 0, 2), new OptionChoiceColumns("", 0, 2),
                    new OptionChoiceColumns("Option", 30, 2), new OptionChoiceColumns("Answer", 30, 2),
                    new OptionChoiceColumns("Price", 5, 4)
            };

    public Collection touchedCollection = new ArrayList();

    public OptionSelectorPanel(final ItemFrame frame) {
        myParent = frame;

        init();

    }

    public void init() {

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(300, 480));

        optionPanel.setLayout(new BorderLayout());
        optionPanel.setPreferredSize(new Dimension(298, 280));

        framOptionPanel.setLayout(new BorderLayout());
        framOptionPanel.setPreferredSize(new Dimension(298, 150));

        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setPreferredSize(new Dimension(300, 175));

        byFramePanel.setLayout(new XYLayout());
        byFramePanel.setPreferredSize(new Dimension(298, 22));

        byFrameL.setIcon(myParent.iconFiles.get("openings"));

        byFrameL.setToolTipText("View/Edit Individual Frame Options");


        optionScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        frameOptionScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        optionScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        frameOptionScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        optionScroll.setPreferredSize(new Dimension(298, 370));
        frameOptionScroll.setPreferredSize(new Dimension(298, 370));

        optionsTable.setPreferredSize(new Dimension(296, 370));
        frameOptionsTable.setPreferredSize(new Dimension(296, 300));
//        optionsTable.setSortable(false);

        optionPanel.add(optionScroll, BorderLayout.CENTER);
        framOptionPanel.add(frameOptionScroll, BorderLayout.CENTER);


        byFramePanel.add(this.byFrame, new XYConstraints(1, 1, 20, 19));
        byFramePanel.add(this.byFrameL, new XYConstraints(23, 1, 40, 19));

        bottomPanel.add(byFramePanel, BorderLayout.NORTH);

        bottomPanel.add(framOptionPanel, BorderLayout.CENTER);

        mainPanel.add(optionPanel, BorderLayout.CENTER);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        this.add(mainPanel);

        addActions();
    }

    public void addActions() {

        byFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {

            }

        });
    }

    public void buildOptionsTables() {

        if (myParent != null) {
        	
            this.myParent.createNetDesignOption();

            //*******************************************************************************************

            for (DesignOption sop : this.myParent.shapeOptions) {
                ShapeOption so = new ShapeOption();
                this.myParent.setGlobalOption(this.myParent.setShapeOptionsFromDesignOptions(sop, so));

                this.myParent.designOptionsNet.add(sop);
            }

            this.initValues();
        }

        this.validate();
        this.repaint();
    }

    public void initValues() {

        final SubstanceDefaultTableCellRenderer renderer = new SubstanceDefaultTableCellRenderer();

        final DefaultCellEditor editorText = new DefaultCellEditor(new JTextField());

        final DefaultCellEditor editorCombo = new MyOptionAnswerCellEditor(new JComboBox());

        optionsTable = new JXTable();

        this.optionsTable.setAutoCreateColumnsFromModel(false);

        this.optionsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        optionsTable.setShowGrid(false);

        options = new Vector();

        
        
        options.addAll(this.myParent.designOptionsNet);

        this.optionTableModel = new OptionTableModel(this.myParent, this.options);

        this.optionsTable.setModel(this.optionTableModel);

        this.optionsTable.setSelectionMode(0);

        JLabel m_title = new JLabel(this.optionTableModel.getTitle());

        TableColumn column1 = new TableColumn(0, 0, renderer, editorText);
        this.optionsTable.addColumn(column1);

        TableColumn column2 = new TableColumn(1, 0, renderer, editorText);
        this.optionsTable.addColumn(column2);

        TableColumn column3 = new TableColumn(2, 0, renderer, editorText);
        this.optionsTable.addColumn(column3);

        TableColumn column4 = new TableColumn(3, 0, renderer, editorCombo);
        this.optionsTable.addColumn(column4);

        TableColumn column5 = new TableColumn(4, 0, renderer, editorText);
        this.optionsTable.addColumn(column5);

        this.optionsTable.setRowHeight(22);

        this.optionsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        this.optionsTable.getColumnModel().getColumn(0).setWidth(0);
        this.optionsTable.getColumnModel().getColumn(0).setResizable(true);

        this.optionsTable.getColumnModel().getColumn(1).setMaxWidth(0);
        this.optionsTable.getColumnModel().getColumn(1).setWidth(0);
        this.optionsTable.getColumnModel().getColumn(1).setResizable(true);

        this.optionsTable.getColumnModel().getColumn(4).setMaxWidth(0);
        this.optionsTable.getColumnModel().getColumn(4).setWidth(0);
        this.optionsTable.getColumnModel().getColumn(4).setResizable(true);


        if (!this.myParent.isNewItem) {

            for (int i = 0; i < this.optionsTable.getRowCount(); i++) {

                touchedCollection.add(this.optionsTable.getValueAt(i, 0));

            }

        }

        optionScroll.getViewport().remove(optionsTable);
        optionScroll.getViewport().add(optionsTable);

        frameOptionScroll.getViewport().remove(frameOptionsTable);
        frameOptionScroll.getViewport().add(frameOptionsTable);

        optionsTable.validate();
        frameOptionsTable.repaint();

    }

    public class ResultSelectionListener implements ListSelectionListener {
        int lastIndex = -1;

        @Override
        public void valueChanged(ListSelectionEvent lse) {

            int index = optionsTable.getSelectedRow();
            if (index != -1 && index != lastIndex) {

                OptionTableModel model = (OptionTableModel) optionsTable.getModel();

                myOption = model.getOption(optionsTable.convertRowIndexToModel(index));
            }

            validate();
            repaint();

        }
    }

    public class MyOptionAnswerCellEditor extends DefaultCellEditor {

        private JComboBox comboBox = new JComboBox();

        private JTextField optionText = new JTextField();

        public MyOptionAnswerCellEditor(JComboBox comboBox) {
            super(comboBox);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int col) {


            mySelectedOption = (DesignOption) options.elementAt(row);


            if (!mySelectedOption.isAuto && mySelectedOption.myoption.getOptiontypeid() <= 2) {
                comboBox = new JComboBox();

                myAnswers.clear();

                myAnswers.addAll(mySelectedOption.optionsAllowedAnswers);


                if (myAnswers.size() > 0) {

                    if (mySelectedOption.isMixed) {
                        comboBox.addItem("Mixed");
                    }

                    for (Object answer : myAnswers) {
                        comboBox.addItem(answer);
                    }

                    comboBox.setSelectedIndex(0);

                    if (!mySelectedOption.isMixed) {

                        comboBox.setSelectedItem(mySelectedOption.myanswer);

                    }

                }

                comboBox.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        // Search series selected

                        optionChangedAction();
                    }
                });

                if (mySelectedOption.isAuto) {
                    comboBox.setEnabled(false);
                } else {
                    comboBox.setEnabled(true);
                }

                return this.comboBox;

            } else if (!mySelectedOption.isAuto && mySelectedOption.myoption.getOptiontypeid() >= 3) {
                optionText = new JTextField();

                if (mySelectedOption.isMixed) {
                    answerText = "Mixed";
                } else {

                    if (mySelectedOption.myoption.getOptiontypeid() == 3) {
                        myAnswers.clear();
                        answerText = mySelectedOption.qtyanswer + "";

                    } else if (mySelectedOption.myoption.getOptiontypeid() == 4) {

                        if (myParent.currentUOM == 1) {
                            answerText = mySelectedOption.sizeanswer + "";
                        } else {
                            // need to convert to Dec. or Fraction
                            answerText = mySelectedOption.sizeansweri + "";
                        }

                    } else if (mySelectedOption.myoption.getOptiontypeid() == 5) {

                        if (myParent.currentUOM == 1) {
                            answerText = mySelectedOption.depthanswer + "";
                        } else {
                            // need to convert to Dec. or Fraction
                            answerText = mySelectedOption.depthansweri + "";
                        }

                    } else if (mySelectedOption.myoption.getOptiontypeid() == 6) {

                        answerText = mySelectedOption.textAnswer;

                    } else if (mySelectedOption.myoption.getOptiontypeid() == 7) {

                        if (myParent.currentUOM == 1) {
                            answerText = mySelectedOption.adjust + "";
                        } else {
                            // need to convert to Dec. or Fraction
                            answerText = mySelectedOption.adjusti + "";
                        }

                    }
                }
                optionText.setText(answerText);

                if (mySelectedOption.isAuto) {
                    optionText.setEnabled(false);
                } else {
                    optionText.setEnabled(true);
                }

                optionText.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        // Search series selected
                        optionChangedAction();
                    }
                });

                return optionText;

            }

            return optionText;

        }

        /**
         * @throws NumberFormatException
         * @throws HeadlessException
         */

        private void optionChangedAction() throws NumberFormatException, HeadlessException {

            try {

                Object[] opts = options.toArray();

                boolean changed = false;

				mySelectedAnswer = ((OptionAnswers) comboBox.getSelectedItem());

//              if(myParent.getApplicationBase().getOptionDefinitions(mySelectedOption.optionid).getOptiontypeid() == 2){
//            	  myParent.cleanColorList();
//              }

                Object[] desOpts = myParent.alreadyAnsweredOptions.toArray();

                for (Object od : desOpts) {

                    if (((ForcedOptionAnswer) od).optionID == mySelectedOption.optionid) {
                        ((ForcedOptionAnswer) od).answerID = mySelectedAnswer.getId().getId();
                    }

                } // Shape Options Loop

                for (Object o : opts) {

                    if (((DesignOption) o).optionid == mySelectedOption.optionid) {

                        if (mySelectedOption.myoption.getOptiontypeid() <= 2) {

                            if (((DesignOption) o).answerid != mySelectedAnswer.getId().getId()) {
                                changed = true;
                            }

                            ((DesignOption) o).answerid = mySelectedAnswer.getId().getId();
                            ((DesignOption) o).myanswer = mySelectedAnswer;
                            ((DesignOption) o).rgb_R = mySelectedAnswer.getRgb_R();
                            ((DesignOption) o).rgb_G = mySelectedAnswer.getRgb_G();
                            ((DesignOption) o).rgb_B = mySelectedAnswer.getRgb_B();

                            //Adding to forced options answers
                            for (Object od : desOpts) {
                                if (((ForcedOptionAnswer) od).optionID == mySelectedOption.optionid) {
                                    ((ForcedOptionAnswer) od).answerID = mySelectedAnswer.getId().getId();
                                } else {
                                    ForcedOptionAnswer forcedOptionAnswer = new ForcedOptionAnswer();
                                    forcedOptionAnswer.optionID = mySelectedOption.optionid;
                                    forcedOptionAnswer.answerID = mySelectedAnswer.getId().getId();

                                    myParent.alreadyAnsweredOptions.add(forcedOptionAnswer);
                                }
                            }

                        } else if (mySelectedOption.myoption.getOptiontypeid() == 3) {// Qty

                            if (((DesignOption) o).qtyanswer != Double.parseDouble(optionText.getText())) {
                                changed = true;
                            }

                            ((DesignOption) o).qtyanswer = Double.parseDouble(optionText.getText());

                        } else if (mySelectedOption.myoption.getOptiontypeid() == 4) { // Size/Length

                            if (myParent.currentUOM == 1) {
                                if (((DesignOption) o).sizeanswer != Integer.parseInt(optionText.getText()) * 100) {
                                    changed = true;
                                }

                                ((DesignOption) o).sizeanswer = (Integer.parseInt(optionText.getText())) * 100;
                            } else {
                                if (((DesignOption) o).sizeansweri != Integer.parseInt(optionText.getText()) * 64) {
                                    changed = true;
                                }
                                ((DesignOption) o).sizeansweri = (Integer.parseInt(optionText.getText())) * 64;
                            }

                        } else if (mySelectedOption.myoption.getOptiontypeid() == 5) {// depth
                            if (myParent.currentUOM == 1) {
                                if (((DesignOption) o).depthanswer != Integer.parseInt(optionText.getText()) * 100) {
                                    changed = true;
                                }
                                ((DesignOption) o).depthanswer = (Integer.parseInt(optionText.getText())) * 100;
                            } else {
                                if (((DesignOption) o).depthansweri != Integer.parseInt(optionText.getText()) * 64) {
                                    changed = true;
                                }
                                ((DesignOption) o).depthansweri = (Integer.parseInt(optionText.getText())) * 64;
                            }

                        } else if (mySelectedOption.myoption.getOptiontypeid() == 6) {// Text
                            if (!((DesignOption) o).textAnswer.equals(optionText.getText())) {
                                changed = true;
                            }
                            ((DesignOption) o).textAnswer = optionText.getText() + "";

                        } else if (mySelectedOption.myoption.getOptiontypeid() == 7) {// Adjust

                            if (myParent.currentUOM == 1) {
                                if (((DesignOption) o).adjust != Integer.parseInt(optionText.getText()) * 100) {
                                    changed = true;
                                }
                                ((DesignOption) o).adjust = Integer.parseInt(optionText.getText()) * 100;
                            } else {
                                if (((DesignOption) o).adjusti != Integer.parseInt(optionText.getText()) * 64) {
                                    changed = true;
                                }
                                ((DesignOption) o).adjusti = Integer.parseInt(optionText.getText()) * 64;
                            }
                        }

                        break;
                    }


                }// End For


                if (changed) {
                    /**
                     *
                     * Need to change this opiton whereever it occurs - In all
                     * Shapes, in All Couplers
                     *
                     */
                	
                    myParent.designOptionsNet.clear();
                    myParent.designOptionsNet.addAll(options);
                    
//                    Collections.sort((ArrayList) myParent.designOptionsNet,
//                            DesignOptionSorter.ParentRule);

                    myParent.jobItem.design.loadOptionsAll();
                    myParent.resetAllOptionsFromDesignOptions();
                    
                      // ExecutePartRules se quedo setparentassembly = a la ultima que econtro  20001 (DHFrame)
                    myParent.jobItem.design.initOverall(myParent.jobItem.design_flat_WIDTHpix, myParent.jobItem._HEIGHTpix,
                            myParent.baseUOM);
                    if (myParent.cView != null) {
                        myParent.cView.initPriceCategories();
                    }

                    myParent.jobItem.resetGraphics();

                    if (myParent.jobItem.myCanvas != null) {
                        myParent.jobItem.myCanvas.redrawTextForColRow(true);
                    }

                    //***********************************************************
                    //Recalculate Job Item Bill Of Materials
                    //***********************************************************
                    myParent.calcBom = true;
                }

                options = new Vector();
                options.addAll(myParent.designOptionsNet);

                //Sort Collection of design options net
                Collections.sort((ArrayList) myParent.designOptionsNet, DesignOptionSorter.RuleNo);

                if (myParent.hasGrids) {

                    //Set Grids
                    myParent.setgrids();
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

}
