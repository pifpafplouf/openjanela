/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/

package Presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import util.UOMConvert;
import util.XYConstraints;
import util.XYLayout;
import Model.ProfileParts.Profiles;
import Model.TextObjects.TextFieldTop;

public class LayoutPanel extends JPanel {

    ItemFrame myParent;

    boolean fixedA = true;

    public boolean isInit = true;

    public boolean angleChanged = false;

    public double base = 0;

    public int noExtra = 0;

    public int noC = 0;

    public JTextField[] lites;

    public JTextField[] couplers;

    public ImageIcon bayC1Icon;

    public ImageIcon bayC2Icon;

    JLabel bayC1L = new JLabel();

    JLabel bayC2L = new JLabel();

    JPanel whichLayout = new JPanel();

    public JPanel bayPanel = new JPanel();

    public JPanel inputPanel = new JPanel();

    public JPanel graph = new JPanel();

    public JRadioButton flat = new JRadioButton();

    public JRadioButton bay = new JRadioButton();

    public JRadioButton bow = new JRadioButton();

    public JRadioButton custom = new JRadioButton();

    public JLabel flatLabel = new JLabel();

    public JLabel bayLabel = new JLabel();

    public JLabel bowLabel = new JLabel();

    public JLabel customLabel = new JLabel();

    public JLabel flatDLabel = new JLabel();

    public JLabel bayDLabel = new JLabel();

    public JLabel bowDLabel = new JLabel();

    public JLabel customDLabel = new JLabel();

    ButtonGroup plan = new ButtonGroup();

    public ImageIcon refreshIcon;

    public ImageIcon setIcon;

    public ImageIcon flatIcon;

    public ImageIcon bayIcon;

    public ImageIcon bowIcon;

    public ImageIcon customIcon;

    public ImageIcon flatDIcon;

    public ImageIcon bayDIcon;

    public ImageIcon bowDIcon;

    public ImageIcon customDIcon;

    public double wi = 0;

    public double wo = 0;

    public int ns = 0;

    public double ri = 0;

    public double ro = 0;

    public double pi = 0;

    public double po = 0;

    public double a = 0;

    public double d = 0;

    public double g = 0;

    public double center = 0;

    public double flanker = 0;

    public double lite = 0;

    public double cp = 0;

    public double fp = 0;

    public double openingSize = 0;

    public double td = 0;

    double bbCT = 0;

    public double wi_M_O = 0;

    public double wo_M_O = 0;

    public double ri_M_O = 0;

    public double ro_M_O = 0;

    public double pi_M_O = 0;

    public double po_M_O = 0;

    public double d_M_O = 0;

    public double g_M_O = 0;

    public double center_M_O = 0;

    public double flanker_M_O = 0;

    public double lite_M_O = 0;

    public double openingSize_M_O = 0;

    public double td_M_O = 0;

    public double wi_I_O = 0;

    public double wo_I_O = 0;

    public double ri_I_O = 0;

    public double ro_I_O = 0;

    public double pi_I_O = 0;

    public double po_I_O = 0;

    public double d_I_O = 0;

    public double g_I_O = 0;

    public double center_I_O = 0;

    public double flanker_I_O = 0;

    public double lite_I_O = 0;

    public double openingSize_I_O = 0;

    public double td_I_O = 0;

    public JLabel wiLabel = new JLabel("WI:");

    public JLabel woLabel = new JLabel("WO:");

    public JLabel nsLabel = new JLabel("N?:");

    public JLabel dLabel = new JLabel("D :");

    public JLabel centerLabel = new JLabel("C :");

    public JLabel flankerLabel = new JLabel("B :");

    public JLabel OSLabel = new JLabel("OS:");

    public JLabel TDLabel = new JLabel("TD:");

    public JLabel GLabel = new JLabel("G:");

    public JTextField wiText = new JTextField("0");

    public JTextField woText = new JTextField("0");

    public JTextField nsText = new JTextField("0");

    public JTextField riText = new JTextField("0");

    public JTextField roText = new JTextField("0");

    public JTextField piText = new JTextField("0");

    public JTextField poText = new JTextField("0");

    public JTextField aText = new JTextField("0");

    public JTextField dText = new JTextField("0");

    public JTextField gText = new JTextField("0");

    public JTextField centerText = new JTextField("0");

    public JTextField flankerText = new JTextField("0");

    public JTextField centerPText = new JTextField("0");

    public JTextField flankerPText = new JTextField("0");

    public JTextField OSText = new JTextField("0");

    public JTextField TDText = new JTextField("0");

    public JLabel lSize = new JLabel("B :");

    public JTextField liteText = new JTextField("0");

    public JButton refresh = new JButton();

    JCheckBox R = new JCheckBox("RI/RO");

    JRadioButton RI = new JRadioButton("RI:");

    JRadioButton RO = new JRadioButton("RO:");

    ButtonGroup RIorRO = new ButtonGroup();

    JRadioButton PI = new JRadioButton("PI:");

    JRadioButton PO = new JRadioButton("PO:");

    ButtonGroup PIorPO = new ButtonGroup();

    JLabel jeLabel = new JLabel("E:");

    JTextField jeText = new JTextField("0");

    public double je = 0;

    JRadioButton size = new JRadioButton("B/C:");

    JRadioButton perc = new JRadioButton("%:");

    ButtonGroup SorP = new ButtonGroup();

    JLabel percent = new JLabel("%");

    JLabel percent2 = new JLabel("%");

    public boolean woChanged = false;

    public double flatW = 0;

    // public double originalScale = 0;

    public double hyp = 0;

    public double hypHeight = 0;

    public double hypBase = 0;

    double theta = 0;

    Object[] values = new Object[2];

    // public double flatScale = 0;
    public JCheckBox refreshV = new JCheckBox();

    public JLabel refreshVL = new JLabel();

    // public double initScale = 0;
    public boolean goodToGo = true;

    public boolean[] active = new boolean[1];

    public boolean fromNewton = false;

    public boolean suspend = false;

    BigDecimal myScale = new BigDecimal("0");

    public LayoutPanel(final ItemFrame myParent) {

        getButtonIcons();

        this.myParent = myParent;
        // initScale = myParent.jobItem.scale;

        if (myParent.myTopPanel.metric.isSelected()) {
            myScale = myParent.scale.multiply(new BigDecimal(100));
        } else {
            myScale = myParent.scale;
        }

        this.setLayout(new BorderLayout());
        whichLayout.setLayout(new XYLayout());
        whichLayout.setPreferredSize(new Dimension(65, 190));
        whichLayout.setBorder(BorderFactory.createEtchedBorder());
        bayPanel.setLayout(new XYLayout());

        refresh.setToolTipText("Reset Layout Panel");
        bayPanel.setBorder(BorderFactory.createEtchedBorder());

        graph.setBorder(BorderFactory.createEtchedBorder());

        graph.setLayout(new BorderLayout());

        flatLabel.setIcon(flatIcon);
        bayLabel.setIcon(bayIcon);
        bowLabel.setIcon(bowIcon);
        customLabel.setIcon(customIcon);
        refresh.setIcon(refreshIcon);

        flatDLabel.setIcon(flatDIcon);
        bayDLabel.setIcon(bayDIcon);
        bowDLabel.setIcon(bowDIcon);
        customDLabel.setIcon(customDIcon);
        bayC1L.setIcon(bayC1Icon);
        bayC2L.setIcon(bayC2Icon);

        plan.add(flat);
        plan.add(bay);
        plan.add(bow);
        plan.add(custom);

        flat.setSelected(true);

        whichLayout.add(flat, new XYConstraints(0, 0, 15, 15));
        whichLayout.add(flatLabel, new XYConstraints(16, 0, 18, 19));

        whichLayout.add(bay, new XYConstraints(0, 21, 15, 15));
        whichLayout.add(bayLabel, new XYConstraints(16, 21, 30, 19));

        whichLayout.add(bow, new XYConstraints(0, 42, 15, 15));

        whichLayout.add(bowLabel, new XYConstraints(16, 42, 30, 19));

        whichLayout.add(custom, new XYConstraints(0, 63, 15, 15));

        whichLayout.add(customLabel, new XYConstraints(16, 63, 30, 19));

        whichLayout.add(refresh, new XYConstraints(1, 166, 18, 19));

        refreshVL.setIcon(myParent.changeImage);
        whichLayout.add(refreshV, new XYConstraints(22, 166, 18, 18));

        whichLayout.add(refreshVL, new XYConstraints(42, 166, 16, 18));

        refreshVL.setToolTipText("Reset to Original Values before Calculating changes.");

        refreshV.setSelected(false);

        flatLabel.setToolTipText("Flat:  1 Facet");
        bayLabel.setToolTipText("Bay:	3 Facets - Variable Angles");
        bowLabel.setToolTipText("Bow: 	N Facets - Variable Angles - Bound by Arc");
        customLabel.setToolTipText("Custom:	N Facets - Variable Angles");

        flat.setToolTipText("Flat:	1 Facet");
        bay.setToolTipText("Bay:	3 Facets - Variable Angles");
        bow.setToolTipText("Bow: 	N Facets - Variable Angles - Bound by Arc");
        custom.setToolTipText("Custom:	N Facets - Variable Angles");

        inputPanel.setLayout(new BorderLayout());
        inputPanel.setPreferredSize(new Dimension(600, 190));
        inputPanel.add(whichLayout, BorderLayout.WEST);

        graph.setPreferredSize(new Dimension(600, 400));
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(graph, BorderLayout.CENTER);

        buildInputPanel();

        dText.setText("0");

        addActions();

        isInit = true;
        inputPanel.removeAll();
        inputPanel.add(whichLayout, BorderLayout.WEST);
        inputPanel.add(flatDLabel, BorderLayout.EAST);
        inputPanel.add(bayPanel, BorderLayout.CENTER);

        bayPanel.remove(size);
        bayPanel.remove(perc);

        bayPanel.remove(centerLabel);
        bayPanel.remove(flankerLabel);

        bayPanel.remove(centerText);
        bayPanel.remove(flankerText);

        bayPanel.remove(centerPText);
        bayPanel.remove(flankerPText);

        bayPanel.remove(percent);
        bayPanel.remove(percent2);
        bayPanel.remove(R);
        bayPanel.remove(PI);
        bayPanel.remove(PO);
        bayPanel.remove(piText);
        bayPanel.remove(poText);
        bayPanel.remove(nsText);
        bayPanel.remove(nsLabel);
        // bayPanel.remove(WI);
        bayPanel.remove(wiText);

        woText.setText(myParent.myTopPanel.fW.getText());

        bay.setEnabled(false);
        bow.setEnabled(false);
        custom.setEnabled(false);

        LayoutPanel.this.validate();
        LayoutPanel.this.repaint();

    }// end constructor

    public void addActions() {

        R.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                if (R.isSelected()) {

                    if (bow.isSelected()) {

                        flankerText.setEnabled(false);
                        RI.setEnabled(false);

                        RO.setEnabled(false);

                        riText.setEnabled(false);
                        roText.setEnabled(false);
                        liteText.setEnabled(false);

                    } else if (bay.isSelected()) {

                        size.setEnabled(true);
                        perc.setEnabled(true);

                        centerText.setEnabled(true);

                    }

                } else {
                    if (bay.isSelected()) {
                        centerText.setEnabled(false);
                    }
                }

                bayPanel.validate();
                bayPanel.repaint();

            }

        });

        perc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                isInit = false;
                centerPText.setEnabled(true);
                centerText.setEnabled(false);

                bayPanel.validate();
                bayPanel.repaint();
            }

        });

        size.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                isInit = false;
                centerPText.setEnabled(false);
                centerText.setEnabled(true);

            }

        });

        PI.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                piText.setEnabled(true);
                poText.setEnabled(false);
                bayPanel.validate();
                bayPanel.repaint();

            }
        });

        PO.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                isInit = false;
                poText.setEnabled(true);
                piText.setEnabled(false);
                bayPanel.validate();
                bayPanel.repaint();
            }
        });

        RO.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                isInit = false;
                roText.setEnabled(true);
                riText.setEnabled(false);
                bayPanel.validate();
                bayPanel.repaint();
            }
        });

        RI.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                isInit = false;
                riText.setEnabled(true);
                roText.setEnabled(false);
                bayPanel.validate();
                bayPanel.repaint();
            }
        });

        flat.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                isInit = true;
                inputPanel.removeAll();
                inputPanel.add(whichLayout, BorderLayout.WEST);
                inputPanel.add(flatDLabel, BorderLayout.EAST);
                inputPanel.add(bayPanel, BorderLayout.CENTER);

                bayPanel.remove(size);
                bayPanel.remove(perc);

                bayPanel.remove(centerLabel);
                bayPanel.remove(flankerLabel);

                bayPanel.remove(centerText);
                bayPanel.remove(flankerText);

                bayPanel.remove(centerPText);
                bayPanel.remove(flankerPText);

                bayPanel.remove(percent);
                bayPanel.remove(percent2);
                bayPanel.remove(R);
                bayPanel.remove(PI);
                bayPanel.remove(PO);
                bayPanel.remove(piText);
                bayPanel.remove(poText);
                bayPanel.remove(nsText);
                bayPanel.remove(nsLabel);
                bayPanel.remove(wiText);

                bayPanel.remove(RI);
                bayPanel.remove(RO);
                bayPanel.remove(lSize);

                bayPanel.remove(riText);
                bayPanel.remove(roText);
                bayPanel.remove(lSize);
                bayPanel.remove(liteText);
                bayPanel.remove(TDLabel);
                bayPanel.remove(TDText);

                myParent.jobItem.layout = 1;
                woText.setText(myParent.myTopPanel.fW.getText());

                if (myParent.myTopPanel.labelFlat.isVisible()) {
                    myParent.myTopPanel.remove(myParent.myTopPanel.labelFlat);

                    myParent.myTopPanel.remove(myParent.myTopPanel.flatW);
                    myParent.myTopPanel.remove(myParent.myTopPanel.layoutLabel);

                    myParent.mullionsPanel.vC.setEnabled(false);
                    myParent.mullionsPanel.couplerTypeC.setEnabled(true);

                }

                myParent.myTopPanel.remove(myParent.myTopPanel.labelFlat);
                myParent.myTopPanel.remove(myParent.myTopPanel.flatW);
                myParent.myTopPanel.remove(myParent.myTopPanel.layoutLabel);

                myParent.validate();
                myParent.repaint();

            }

        });

        bay.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                myParent.facetUsed.frameWRounded = false;
                myParent.facetUsed.frameHRounded = false;
                isInit = true;
                inputPanel.removeAll();
                inputPanel.add(whichLayout, BorderLayout.WEST);
                inputPanel.add(bayDLabel, BorderLayout.EAST);
                inputPanel.add(bayPanel, BorderLayout.CENTER);

                myParent.jobItem.layout = 2;

                buildInputPanel();
                R.setSelected(true);
                R.setVisible(false);

                bayPanel.remove(RI);
                bayPanel.remove(RO);
                bayPanel.remove(lSize);

                bayPanel.remove(riText);
                bayPanel.remove(roText);
                bayPanel.remove(lSize);
                bayPanel.remove(liteText);

                bayPanel.add(size, new XYConstraints(190, 90, 45, 19));
                bayPanel.add(perc, new XYConstraints(295, 90, 45, 19));

                perc.setSelected(true);

                bayPanel.add(centerLabel, new XYConstraints(195, 110, 45, 19));
                bayPanel.add(flankerLabel, new XYConstraints(196, 130, 45, 19));

                bayPanel.add(centerText, new XYConstraints(210, 110, 80, 19));
                bayPanel.add(flankerText, new XYConstraints(210, 130, 80, 19));

                centerPText.setText(myParent.mySeries.getDefaultBayCenterSplit() + "");
                flankerPText.setText(myParent.mySeries.getDefaultBayCenterSplit() / 2 + "");

                bayPanel.add(centerPText, new XYConstraints(295, 110, 40, 19));
                bayPanel.add(flankerPText, new XYConstraints(295, 130, 40, 19));

                bayPanel.add(percent, new XYConstraints(337, 110, 80, 19));
                bayPanel.add(percent2, new XYConstraints(337, 130, 80, 19));

                setAngle();
                nsText.setEnabled(false);
                centerPText.setEnabled(true);
                flankerPText.setEnabled(false);
                woText.setText(myParent.myTopPanel.fW.getText());
                PI.setEnabled(true);
                PO.setEnabled(true);

                piText.setEnabled(true);
                poText.setEnabled(true);
                R.setText("B/C");

                try {
                    doInit();
                } catch (final Exception e1) {

                    e1.printStackTrace();
                }
                setTexts();

                LayoutPanel.this.validate();
                LayoutPanel.this.repaint();

            }

        });

        bow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                isInit = true;
                inputPanel.removeAll();
                inputPanel.add(whichLayout, BorderLayout.WEST);
                nsText.setEnabled(false);
                inputPanel.add(bowDLabel, BorderLayout.EAST);
                inputPanel.add(bayPanel, BorderLayout.CENTER);
                myParent.jobItem.layout = 3;
                buildInputPanel();
                bayPanel.remove(size);
                bayPanel.remove(perc);

                bayPanel.remove(centerLabel);
                bayPanel.remove(flankerLabel);

                bayPanel.remove(centerText);
                bayPanel.remove(flankerText);

                bayPanel.remove(centerPText);
                bayPanel.remove(flankerPText);

                bayPanel.remove(percent);
                bayPanel.remove(percent2);

                woText.setText(myParent.myTopPanel.fW.getText());

                bayPanel.add(RI, new XYConstraints(185, 90, 45, 19));
                bayPanel.add(RO, new XYConstraints(185, 110, 45, 19));

                bayPanel.add(riText, new XYConstraints(232, 90, 80, 19));
                bayPanel.add(roText, new XYConstraints(232, 110, 80, 19));

                bayPanel.add(lSize, new XYConstraints(208, 130, 45, 19));
                bayPanel.add(liteText, new XYConstraints(232, 130, 80, 19));

                RI.setEnabled(false);
                RO.setEnabled(false);
                PI.setEnabled(false);
                PO.setEnabled(false);
                riText.setEditable(false);
                roText.setEnabled(false);
                piText.setEditable(false);
                poText.setEnabled(false);
                liteText.setEnabled(false);

                R.setText("RI/RO");
                R.setText("RI/RO");
                nsText.setText("4");
                nsText.setEnabled(false);

                setAngle();

                try {
                    doInit();
                } catch (final Exception e1) {
                    // TODO
                    // Auto-generated catch block
                    e1.printStackTrace();
                }
                if (!suspend) {
                    setTexts();
                }

                LayoutPanel.this.validate();
                LayoutPanel.this.repaint();

            }

        });
        custom.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                isInit = true;
                inputPanel.removeAll();

                inputPanel.add(whichLayout, BorderLayout.WEST);
                inputPanel.add(customDLabel, BorderLayout.EAST);

                final String customLayoutWarning = "Custom layout with variable angles will be developed according to demand.\n"
                        + "To request this fuctionlaity, please contact your supplier!";

                JOptionPane.showMessageDialog(null, customLayoutWarning, "Warning", JOptionPane.WARNING_MESSAGE);

                // inputPanel
                // .add(
                // bayPanel,
                // BorderLayout.CENTER);
                //
                // bayPanel.remove(size);
                // bayPanel.remove(perc);
                //
                // bayPanel
                // .remove(centerLabel);
                // bayPanel
                // .remove(flankerLabel);
                //
                // bayPanel.remove(centerText);
                // bayPanel
                // .remove(flankerText);
                //
                // bayPanel
                // .remove(centerPText);
                // bayPanel
                // .remove(flankerPText);
                //
                // bayPanel.remove(percent);
                // bayPanel.remove(percent2);
                // // bayPanel.remove(stdAngles);
                // // bayPanel.remove(custAngle);
                // bayPanel.remove(TDLabel);
                // bayPanel.remove(TDText);
                //
                // bayPanel.remove(RI);
                // bayPanel.remove(RO);
                // bayPanel.remove(lSize);
                //
                // bayPanel.remove(riText);
                // bayPanel.remove(roText);
                // bayPanel.remove(lSize);
                // bayPanel.remove(liteText);
                //
                // bayPanel.remove(R);
                // bayPanel.remove(PI);
                // bayPanel.remove(PO);
                // bayPanel.remove(piText);
                // bayPanel.remove(poText);
                // bayPanel.remove(nsText);
                // bayPanel.remove(nsLabel);
                // // bayPanel.remove(WI);
                // bayPanel.remove(wiText);
                //
                // woText
                // .setText(myParent.myTopPanel.fW
                // .getText());
                // myParent.jobItem.layout = 4;

                LayoutPanel.this.validate();
                LayoutPanel.this.repaint();

            }

        });

        // G
        // .addActionListener(new ActionListener()
        // {
        //
        // @Override
        // public void actionPerformed(
        // final ActionEvent e)
        // {
        //
        // if(G.isSelected()) {
        // gText.setEditable(true);
        // gText.setEditable(true);
        // }
        // else {
        // gText.setEditable(false);
        // gText.setEditable(false);
        // }
        //
        // bayPanel.validate();
        // bayPanel.repaint();
        // }
        //
        // });

        refresh.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                isInit = false;

                myParent.myTopPanel.fW_actionPerformed();

                myParent.jobItem.myCanvas.enableLayouts();

                // refreshNew();

                bayPanel.validate();
                bayPanel.repaint();
            }

        });

        wiText.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                wiTextAction(e);

            }

        });

        woText.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                woTextAction(e);

            }

        });

        nsText.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                isInit = false;
                try {
                    doInit();
                } catch (final Exception e1) {
                    // TODO
                    // Auto-generated catch block
                    e1.printStackTrace();
                }
                setTexts();
                bayPanel.validate();
                bayPanel.repaint();

            }

        });

        riText.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                isInit = false;
                setAction();

            }

        });

        roText.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                isInit = false;
                setAction();

            }

        });
        piText.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                // double myScale =0;
                // if(myParent.myTopPanel.metric.isSelected()) {
                // myScale = myParent.scale.doubleValue()*100;
                // }else {
                // myScale = myParent.scale.doubleValue();
                // }
                try {
                    values = myParent.readTextCurrentUOM(piText);
                    pi = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myScale.doubleValue();
                    piAction(1);
                } catch (final Exception e1) {
                    // TODO
                    // Auto-generated catch block
                    e1.printStackTrace();
                }

            }

        });

        poText.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                // double myScale =0;
                // if(myParent.myTopPanel.metric.isSelected()) {
                // myScale = myParent.scale.doubleValue()*100;
                // }else {
                // myScale = myParent.scale.doubleValue();
                // }
                try {
                    values = myParent.readTextCurrentUOM(poText);
                    po = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myScale.doubleValue();
                    if (!fromNewton) {
                        getHyp();

                        pi = po - hyp + hypHeight;

                        piAction(0);
                    } else {
                        doNewton();
                        if (!suspend) {
                            setTexts();
                        }
                        bayPanel.validate();
                        bayPanel.repaint();
                    }

                } catch (final Exception e1) {

                    e1.printStackTrace();
                }

            }

        });

        dText.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                isInit = false;
                try {
                    doDText();
                } catch (final Exception e1) {
                    // TODO
                    // Auto-generated catch block
                    e1.printStackTrace();
                }
            }

        });

        gText.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                // double myScale =0;
                // if(myParent.myTopPanel.metric.isSelected()) {
                // myScale = myParent.scale.doubleValue()*100;
                // }else {
                // myScale = myParent.scale.doubleValue();
                // }
                try {
                    values = myParent.readTextCurrentUOM(gText);
                    g = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myScale.doubleValue();

                    getHyp();

                    doDText();

                } catch (final Exception e1) {

                    e1.printStackTrace();
                }
            }

        });

        centerText.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                centerAction();

                bayPanel.validate();
                bayPanel.repaint();
            }

        });

        flankerText.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                isInit = false;
                setAction();
            }

        });

        OSText.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                setAction();
                bayPanel.validate();
                bayPanel.repaint();
            }

        });

        aText.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                try {
                    aAction();
                } catch (final Exception e1) {
                    // TODO
                    // Auto-generated catch block
                    e1.printStackTrace();
                }

            }

        });

        centerPText.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                try {
                    cpAction();
                } catch (final Exception e1) {
                    // TODO
                    // Auto-generated catch block
                    e1.printStackTrace();
                }

            }

        });

    }

    public void piAction(final int from) throws Exception {

        if (bay.isSelected()) {

            if (refreshV.isSelected()) {
                doInit();
            }

            setAngle();

            if (fixedA) {

                flanker = pi / Math.sin(Math.toRadians(a));

                center = flanker * cp / fp;

                base = flanker * Math.cos(Math.toRadians(a));

                values = myParent.dimConvert(flanker / myScale.doubleValue(), true);

                flanker = Double.parseDouble(values[0].toString()) * myScale.doubleValue();

                values = myParent.dimConvert(center / myScale.doubleValue(), true);

                center = Double.parseDouble(values[0].toString()) * myScale.doubleValue();

                flatW = 2 * flanker + center;

                Math.toRadians(a);

                getHyp();

                if (from == 1) {
                    po = pi + hyp - hypHeight;
                }

                wi = wo - 2 * hypBase;

            }// Fixed Angle
            else {

                angleChanged = true;
                setAngle();

                try {
                    values = myParent.readTextCurrentUOM(piText);
                    pi = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myScale.doubleValue();
                } catch (final Exception e1) {
                    e1.printStackTrace();
                }
                if (size.isSelected()) {

                    a = Math.toDegrees(Math.atan(pi / base));

                    flanker = pi / Math.sin(Math.toRadians(a));

                    flatW = 2 * flanker + center;

                    cp = center / flatW;
                    fp = flanker / flatW;

                } else {
                    center = (wo - bbCT) * cp;
                    base = (wo - bbCT) * fp;

                    a = Math.toDegrees(Math.atan(pi / base));

                    flanker = base / Math.cos(Math.toRadians(a));

                    flatW = 2 * flanker + center;
                    double lastValue = 1000;

                    boolean found = true;
                    if (flanker / flatW < fp - 0.001 || flanker / flatW > fp + 0.001 || flatW < wo - bbCT) {
                        found = false;

                        do {
                            base = base - 1;
                            a = Math.toDegrees(Math.atan(pi / base));
                            flanker = base / Math.cos(Math.toRadians(a));

                            center = wo - bbCT - 2 * base;
                            flatW = 2 * flanker + center;

                            if (lastValue > fp && flanker / flatW < fp) {
                                found = true;
                                break;
                            }
                            lastValue = flanker / flatW;
                            // count++;
                            if (flanker / flatW > fp - 0.001 && flanker / flatW < fp + 0.001 && flatW > wo - bbCT) {
                                found = true;
                                break;
                            }

                        }
                        while (!found || flatW < wo - bbCT);

                        if (!found) {
                            base = (wo - bbCT) * fp;
                            do {
                                base = base + 1;
                                a = Math.toDegrees(Math.atan(pi / base));
                                flanker = base / Math.cos(Math.toRadians(a));

                                center = wo - bbCT - 2 * base;
                                flatW = 2 * flanker + center;

                                if (lastValue > fp && flanker / flatW < fp) {
                                    found = true;
                                    break;
                                }
                                lastValue = flanker / flatW;
                                // count++;
                                if (flanker / flatW > fp - 0.001 && flanker / flatW < fp + 0.001 && flatW > wo - bbCT) {
                                    found = true;
                                    break;
                                }

                            }
                            while (flanker / flatW < fp - 0.001 || flanker / flatW > fp + 0.001 || flatW < wo - bbCT);
                        }

                        if (!found) {
                            base = (wo - bbCT) * fp;
                            a = Math.toDegrees(Math.atan(pi / base));
                            flanker = base / Math.cos(Math.toRadians(a));

                            center = wi - 2 * base;
                            flatW = 2 * flanker + center;
                        }
                    }
                }

                values = myParent.dimConvert(flanker / myScale.doubleValue(), true);

                flanker = Double.parseDouble(values[0].toString()) * myScale.doubleValue();

                values = myParent.dimConvert(center / myParent.scale.doubleValue(), true);

                center = Double.parseDouble(values[0].toString()) * myScale.doubleValue();

                flatW = 2 * flanker + center;

                getHyp();

                if (from == 1) {
                    po = pi + hyp - hypHeight;
                }

                wi = wo - 2 * hypBase;

            }
        }// bay

        setTexts();
        bayPanel.validate();
        bayPanel.repaint();

    }

    public void aAction() throws Exception {

        if (bay.isSelected()) {

            if (refreshV.isSelected()) {

                setAngle();
                try {

                    doInit();

                } catch (final Exception e) {
                    // TODO
                    // Auto-generated catch block
                    e.printStackTrace();
                }

            }

            angleChanged = false;

            a = Double.parseDouble(aText.getText());

            if (a < 90) {
                pi = base * Math.tan(Math.toRadians(a));

                getHyp();
                po = pi + hyp - hypHeight;

                wi = wo - 2 * hypBase;

                if (size.isSelected()) {

                    flanker = pi / Math.sin(Math.toRadians(a));
                    values = myParent.dimConvert(flanker / myParent.scale.doubleValue(), true);

                    flanker = Double.parseDouble(values[0].toString()) * myParent.scale.doubleValue();

                    flatW = 2 * flanker + center;

                    cp = center / flatW;
                    fp = flanker / flatW;

                } else {
                    center = wi * cp;
                    values = myParent.dimConvert(center / myParent.scale.doubleValue(), true);

                    center = Double.parseDouble(values[0].toString()) * myParent.scale.doubleValue();
                    base = wi * fp;

                    flanker = base / Math.cos(Math.toRadians(a));
                    values = myParent.dimConvert(flanker / myParent.scale.doubleValue(), true);

                    flanker = Double.parseDouble(values[0].toString()) * myParent.scale.doubleValue();
                    flatW = 2 * flanker + center;
                    double lastValue = 1000;
                    boolean found = true;
                    if (flanker / flatW < fp - 0.001 || flanker / flatW > fp + 0.001 || flatW < wo - bbCT) {
                        found = false;

                        do {
                            base = base - 1;
                            a = Math.atan(pi / base);
                            flanker = base / Math.cos(Math.toRadians(a));

                            center = wi - 2 * base;
                            flatW = 2 * flanker + center;

                            if (lastValue > fp && flanker / flatW < fp) {
                                found = true;
                                break;
                            }
                            lastValue = flanker / flatW;

                            if (flanker / flatW > fp - 0.001 && flanker / flatW < fp + 0.001 && flatW > wo - bbCT) {
                                found = true;
                                break;
                            }

                        }
                        while (!found || flatW < wo - bbCT);

                        if (!found) {
                            base = (wo - bbCT) * fp;
                            do {
                                base = base + 1;
                                a = Math.atan(pi / base);
                                flanker = base / Math.cos(Math.toRadians(a));

                                center = wi - 2 * base;
                                flatW = 2 * flanker + center;
                                if (lastValue > fp && flanker / flatW < fp) {
                                    found = true;
                                    break;
                                }
                                lastValue = flanker / flatW;
                                if (flanker / flatW > fp - 0.001 && flanker / flatW < fp + 0.001 && flatW > wo - bbCT) {
                                    found = true;
                                    break;
                                }

                            }
                            while (!found || flatW < wo - bbCT);
                        }

                        if (!found) {
                            base = (wo - bbCT) * fp;
                            a = Math.atan(pi / base);
                            flanker = base / Math.cos(Math.toRadians(a));

                            center = wi - 2 * base;
                            flatW = 2 * flanker + center;
                        }

                    }
                }
                values = myParent.dimConvert(flanker / myParent.scale.doubleValue(), true);

                flanker = Double.parseDouble(values[0].toString()) * myParent.scale.doubleValue();
                values = myParent.dimConvert(center / myParent.scale.doubleValue(), true);

                center = Double.parseDouble(values[0].toString()) * myParent.scale.doubleValue();
                flatW = 2 * flanker + center;
            } else if (a == 90) {

                center = wo - bbCT - 2 * hyp;
                flanker = pi = center / 2;

                values = myParent.dimConvert(flanker / myParent.scale.doubleValue(), true);

                flanker = Double.parseDouble(values[0].toString()) * myParent.scale.doubleValue();
                values = myParent.dimConvert(center / myParent.scale.doubleValue(), true);

                center = Double.parseDouble(values[0].toString()) * myParent.scale.doubleValue();
                flatW = 2 * flanker + center;
                getHyp();
                po = pi + hyp - hypHeight;
                wi = wo - 2 * hyp;
                cp = 100 / 100;
                fp = 50 / 100;

            }

        }// bay

        setTexts();
        bayPanel.validate();
        bayPanel.repaint();

    }

    public void centerAction() {

        double myCenter = 0;

        if (refreshV.isSelected()) {

            try {
                values = myParent.readTextCurrentUOM(centerText);

                myCenter = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myScale.doubleValue();

                base = wi - myCenter;

                flanker = base / Math.cos(Math.toRadians(a));
                values = myParent.dimConvert(flanker / myScale.doubleValue(), true);

                flanker = Double.parseDouble(values[0].toString()) * myScale.doubleValue();

                pi = Math.sin(Math.toRadians(a)) * flanker;

                values = myParent.dimConvert(center / myScale.doubleValue(), true);

                center = Double.parseDouble(values[0].toString()) * myScale.doubleValue();

                base = flanker * Math.cos(Math.toRadians(a));

                pi = Math.sin(Math.toRadians(a)) * flanker;

                flatW = 2 * flanker + center;

                cp = center / flatW;
                fp = flanker / flatW;

                centerPText.setText(cp * 100 + "");
                flankerPText.setText(fp * 100 + "");
                getHyp();
                po = pi + hyp - hypHeight;

                // if (myParent.currentUOM == 1)
                // {
                // po =
                // pi
                // + hyp;
                // }
                // else
                // {
                //
                // po =
                // pi
                // + hyp;
                // }

            } catch (final Exception e) {
                // TODO Auto-generated catch
                // block
                e.printStackTrace();
            }
            center = myCenter;
        } else {
            try {
                values = myParent.readTextCurrentUOM(centerText);

                center = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myScale.doubleValue();
            } catch (final NumberFormatException e) {
                // TODO Auto-generated catch
                // block
                e.printStackTrace();
            } catch (final Exception e) {
                // TODO Auto-generated catch
                // block
                e.printStackTrace();
            }
        }

        angleChanged = false;
        setAngle();

        try {

            if (fixedA) {

                base = wo - bbCT - center;

                flanker = base / Math.cos(Math.toRadians(a));

                values = myParent.dimConvert(flanker / myParent.scale.doubleValue(), true);

                flanker = Double.parseDouble(values[0].toString()) * myParent.scale.doubleValue();

                pi = Math.sin(Math.toRadians(a)) * flanker;

                flatW = 2 * flanker + center;

                cp = center / flatW;

                fp = (flatW - center) / 2 / flatW;

            }// Fixed Angle
            else {

                base = wo - bbCT - center;

                a = Math.toDegrees(Math.atan(pi / base));

                flanker = base / Math.cos(Math.toRadians(a));

                values = myParent.dimConvert(flanker / myParent.scale.doubleValue(), true);

                flanker = Double.parseDouble(values[0].toString()) * myParent.scale.doubleValue();

                flatW = 2 * flanker + center;

                double lastValue = 1000;
                boolean found = true;
                if (flanker / flatW < fp - 0.001 || flanker / flatW > fp + 0.001 || flatW < wo - bbCT) {
                    found = false;

                    do {
                        base = base - 1;
                        a = Math.toDegrees(Math.atan(pi / base));
                        flanker = base / Math.cos(Math.toRadians(a));

                        center = wi - 2 * base;
                        flatW = 2 * flanker + center;

                        if (lastValue > fp && flanker / flatW < fp) {
                            found = true;
                            break;
                        }
                        lastValue = flanker / flatW;

                        if (flanker / flatW > fp - 0.001 && flanker / flatW < fp + 0.001 && flatW > wo - bbCT) {
                            found = true;
                            break;
                        }

                    }
                    while (flanker / flatW < fp - 0.001 || flanker / flatW > fp + 0.001 || flatW < wo - bbCT);

                    if (!found) {
                        base = (wo - bbCT) * fp;
                        do {
                            base = base + 1;
                            a = Math.toDegrees(Math.atan(pi / base));
                            flanker = base / Math.cos(Math.toRadians(a));

                            center = wi - 2 * base;
                            flatW = 2 * flanker + center;

                            if (lastValue > fp && flanker / flatW < fp) {
                                found = true;
                                break;
                            }
                            lastValue = flanker / flatW;
                            if (flanker / flatW > fp - 0.001 && flanker / flatW < fp + 0.001 && flatW > wo - bbCT) {
                                found = true;
                                break;
                            }

                        }
                        while (flanker / flatW < fp - 0.001 || flanker / flatW > fp + 0.001 || flatW < wo - bbCT);
                    }

                    if (!found) {
                        base = (wo - bbCT) * fp;
                        a = Math.toDegrees(Math.atan(pi / base));
                        flanker = base / Math.cos(Math.toRadians(a));

                        center = wi - 2 * base;
                        flatW = 2 * flanker + center;
                    }
                }

                values = myParent.dimConvert(flanker / myParent.scale.doubleValue(), true);

                flanker = Double.parseDouble(values[0].toString()) * myParent.scale.doubleValue();

                values = myParent.dimConvert(center / myParent.scale.doubleValue(), true);

                center = Double.parseDouble(values[0].toString()) * myParent.scale.doubleValue();

                flatW = 2 * flanker + center;

                getHyp();

                po = pi + hyp - hypHeight;
                wi = wo - 2 * hypBase;

            }
        } catch (final Exception e1) {
            e1.printStackTrace();
        }

        setTexts();
        bayPanel.validate();
        bayPanel.repaint();

    }

    public void cpAction() throws Exception {

        if (bay.isSelected()) {
            if (refreshV.isSelected()) {

                if (myParent.currentUOM == 1) {
                    cp = Double.parseDouble(centerPText.getText()) / 100;
                }
                fp = (1 - cp) / 2;

                flankerPText.setText(fp * 100 + "");

                try {
                    doInit();
                } catch (final Exception e) {
                    // TODO
                    // Auto-generated catch block
                    e.printStackTrace();
                }
            } else {

                angleChanged = false;

                setAngle();
                boolean found = true;
                double lastValue = 1000;

                cp = Double.parseDouble(centerPText.getText()) / 100;

                center = (wo - bbCT) * cp;

                base = (wo - bbCT - (wo - bbCT) * cp) / 2;

                if (fixedA) {

                    pi = Math.tan(Math.toRadians(a)) * base;

                    flanker = pi / Math.sin(Math.toRadians(a));
                    values = myParent.dimConvert(flanker / myScale.doubleValue(), true);

                    flanker = Double.parseDouble(values[0].toString()) * myScale.doubleValue();

                    flatW = 2 * flanker + center;

                    if (center / flatW < cp - 0.001 || center / flatW > cp + 0.001 || flatW < wo - bbCT) {
                        found = false;

                        do {

                            base = base - 1;

                            flanker = base / Math.cos(Math.toRadians(a));
                            pi = Math.sin(Math.toRadians(a)) * flanker;
                            center = wi - 2 * base;
                            flatW = 2 * flanker + center;

                            if (lastValue > cp && cp / flatW < cp) {
                                found = true;
                                break;
                            }
                            lastValue = cp / flatW;

                            if (cp / flatW > cp - 0.005 && cp / flatW < cp + 0.005 && flatW > wo - bbCT) {
                                found = true;
                            }

                        }
                        while (!found || flatW < wo - bbCT);

                        if (!found) {
                            lastValue = 10000;

                            base = (wo - bbCT) * fp;
                            center = (wo - bbCT) * cp;
                            do {
                                base = base + 1;
                                flanker = base / Math.cos(Math.toRadians(a));
                                pi = Math.sin(Math.toRadians(a)) * flanker;
                                center = wi - 2 * base;
                                flatW = 2 * flanker + center;
                                if (lastValue > cp && cp / flatW < fp) {
                                    found = true;
                                    break;
                                }
                                lastValue = cp / flatW;
                                if (cp / flatW > cp - 0.005 && cp / flatW < cp + 0.005 && flatW > wo - bbCT) {
                                    found = true;
                                }

                            }
                            while (!found || flatW < wo - bbCT);
                        }

                        if (!found) {
                            base = (wo - bbCT) * fp;
                            center = (wo - bbCT) * cp;
                            flanker = base / Math.cos(Math.toRadians(a));
                            pi = Math.sin(Math.toRadians(a)) * flanker;
                            center = wi - 2 * base;
                            flatW = 2 * flanker + center;
                        }
                    }
                    values = myParent.dimConvert(flanker / myScale.doubleValue(), true);

                    flanker = Double.parseDouble(values[0].toString()) * myScale.doubleValue();

                    values = myParent.dimConvert(center / myScale.doubleValue(), true);

                    center = Double.parseDouble(values[0].toString()) * myScale.doubleValue();
                    flatW = 2 * flanker + center;

                    fp = flanker / flatW;

                    getHyp();

                    po = pi + hyp - hypHeight;

                    wi = wo - 2 * hypBase;

                }// Fixed Angle
                else {
                    a = Math.toDegrees(Math.atan(pi / base));

                    flanker = base / Math.cos(Math.toRadians(a));

                    values = myParent.dimConvert(flanker / myScale.doubleValue(), true);

                    flanker = Double.parseDouble(values[0].toString()) * myScale.doubleValue();

                    flatW = 2 * flanker + center;

                    fp = flanker / flatW;

                    if (center / flatW < cp - 0.001 || center / flatW > cp + 0.001 || flatW < wo - bbCT) {
                        found = false;

                        do {
                            base = base - 1;
                            a = Math.toDegrees(Math.atan(pi / base));
                            flanker = base / Math.cos(Math.toRadians(a));

                            center = wi - 2 * base;
                            flatW = 2 * flanker + center;
                            if (lastValue > cp && center / flatW < cp) {
                                found = true;
                                break;
                            }
                            lastValue = center / flatW;

                            if (center / flatW > cp - 0.001 && center / flatW < cp + 0.001 && flatW > wo - bbCT) {
                                found = true;
                                break;
                            }

                        }
                        while (center / flatW < cp - 0.001 || center / flatW > cp + 0.001 || flatW < wo - bbCT);

                        if (!found) {
                            base = (wo - bbCT) * fp;
                            center = (wo - bbCT) * cp;
                            do {
                                base = base + 1;
                                a = Math.toDegrees(Math.atan(pi / base));
                                flanker = base / Math.cos(Math.toRadians(a));

                                center = wi - 2 * base;
                                flatW = 2 * flanker + center;

                                if (lastValue > fp && flanker / flatW < fp) {
                                    found = true;
                                    break;
                                }
                                lastValue = flanker / flatW;

                                // count++;
                                if (flanker / flatW > fp - 0.001 && flanker / flatW < fp + 0.001 && flatW > wo - bbCT) {
                                    found = true;
                                    break;
                                }
                            }
                            while (flanker / flatW < fp - 0.001 || flanker / flatW > fp + 0.001 || flatW < wo - bbCT);
                        }

                        if (!found) {
                            base = (wo - bbCT) * fp;
                            center = (wo - bbCT) * cp;
                            a = Math.toDegrees(Math.atan(pi / base));
                            flanker = base / Math.cos(Math.toRadians(a));

                            center = wi - 2 * base;
                            flatW = 2 * flanker + center;
                        }
                    }
                    values = myParent.dimConvert(flanker / myScale.doubleValue(), true);

                    flanker = Double.parseDouble(values[0].toString()) * myScale.doubleValue();

                    values = myParent.dimConvert(flanker / myParent.scale.doubleValue(), true);

                    flanker = Double.parseDouble(values[0].toString()) * myScale.doubleValue();

                    flatW = 2 * flanker + center;

                    getHyp();

                    po = pi + hyp - hypHeight;
                    wi = wo - 2 * hypBase;

                }
            }// bay

        }// If not refreshV

        setTexts();
        bayPanel.validate();
        bayPanel.repaint();

    }

    public void getWO() {

        if (myParent.currentUOM <= 1) {
            hyp = myParent.mySeries.getFrameDepth() * myParent.scale.doubleValue();
        } else {
            hyp = myParent.mySeries.getFrameDepthImp() * myParent.scale.doubleValue();
        }

        a = Double.parseDouble(aText.getText());

        try {
            if (wiText.getText().length() > 0) {

                values = myParent.readTextCurrentUOM(wiText);

                wi = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myScale.doubleValue();
            }
        } catch (final Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        wo = wi + 2 * hyp * Math.cos(theta) + bbCT;
        woChanged = true;

    }

    public void getWI() {

        if (myParent.currentUOM <= 1) {
            hyp = myParent.mySeries.getFrameDepth() * myParent.scale.doubleValue();
        } else {
            hyp = myParent.mySeries.getFrameDepthImp() * myParent.scale.doubleValue();
        }

        a = Double.parseDouble(aText.getText());

        try {
            if (woText.getText().length() > 0) {
                values = myParent.readTextCurrentUOM(woText);

                wo = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myParent.scale.doubleValue();
            }
        } catch (final Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        wi = wo - 2 * hyp * Math.cos(theta);
        woChanged = true;
    }

    public void woTextAction(final ActionEvent e) {

        getWI();
        try {
            doInit();
        } catch (final Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        setTexts();
    }

    public void getFlankerUsingCenter() {

        try {

            values = myParent.readTextCurrentUOM(piText);

            pi = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myParent.scale.doubleValue();
            values = myParent.readConvertText(centerText);

            center = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myParent.scale.doubleValue();

            wi = Double.parseDouble(values[0].toString());

            base = wi - center - bbCT;

            a = Math.toDegrees(Math.atan(pi / base));

            flanker = myParent.doRoundDim(Math.abs(pi / Math.sin(Math.toRadians(a))));

            aText.setText(myParent.oneDecimal.format(a) + "");

            // if (!custAngle.isSelected())
            // {
            // a =
            // Double
            // .parseDouble(stdAngles
            // .getSelectedItem()
            // .toString());
            // }
            // else
            // {
            a = Double.parseDouble(aText.getText());
            // }
            Math.toRadians(180 - (a + 90));

            if (woText.getText().length() > 0) {
                values = myParent.readTextCurrentUOM(woText);
                wo = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myParent.scale.doubleValue();
            }
        } catch (final Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    public void wiTextAction(final ActionEvent e) {

        getWO();

        try {

            values = myParent.dimConvert(wo / myScale.doubleValue(), false);

            if (myParent.currentUOM <= 2) {
                myParent.myTopPanel.fW.setText(values[0] + "");
                woText.setText(values[0] + "");
            } else {
                myParent.myTopPanel.fW.setText(values[1] + "");
                woText.setText(values[1] + "");
            }
            this.bay.doClick();
        } catch (final Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public void setAngle() {

        final Object[] myMs = myParent.jobItem.design.bOpeningObject.mullions.toArray();

        final double[] myAs = new double[myMs.length];
        final int[] order = new int[myMs.length];

        for (int i = 0; i < myAs.length; i++) {
            myAs[i] = 0;
        }

        int count = 0;
        int noExtra = 0;
        for (final Object m : myMs) {
            if (((Profiles) m).angle != 180 || !((Profiles) m).fixedAngle && ((Profiles) m).orientation == 1
                    && ((Profiles) m).posCondition == 1) {
                myAs[count] = ((Profiles) m).angle;
                order[count] = ((Profiles) m).order;

                count++;

                if (!((Profiles) m).fixedAngle) {
                    fixedA = false;
                }

            } else if (((Profiles) m).angle == 180

                    && ((Profiles) m).orientation == 1 && ((Profiles) m).posCondition == 1) {

                noExtra++;
            }
        }

        // ns = count + 1;
        // nsText.setText(ns + "");

        double angle = 0;
        for (int i = 0; i < myAs.length; i++) {
            if (myAs[i] != 0) {
                angle = myAs[i];
                break;
            }
        }

        final String myText = angle + "";

        bayPanel.add(aText, new XYConstraints(60, 130, 50, 19));
        if (isInit) {
            aText.setText(myText);
        }
        aText.setEnabled(false);
        if (!fixedA) {
            aText.setEnabled(true);
        }

    }

    public void buildInputPanel() {

        bayPanel.add(woLabel, new XYConstraints(18, 0, 45, 19));
        bayPanel.add(woText, new XYConstraints(46, 0, 80, 19));
        bayPanel.add(wiLabel, new XYConstraints(22, 20, 45, 19));
        // WI.setEnabled(false);
        bayPanel.add(wiText, new XYConstraints(46, 20, 80, 19));
        wiText.setEnabled(false);

        // WIorWO.add(WI);
        // WIorWO.add(WO);

        bayPanel.add(gText, new XYConstraints(176, 0, 80, 19));
        bayPanel.add(OSLabel, new XYConstraints(150, 20, 35, 19));
        bayPanel.add(GLabel, new XYConstraints(157, 0, 35, 19));
        bayPanel.add(OSText, new XYConstraints(176, 20, 80, 19));

        bayPanel.add(nsLabel, new XYConstraints(23, 40, 45, 19));
        bayPanel.add(nsText, new XYConstraints(46, 40, 80, 19));

        bayPanel.add(dLabel, new XYConstraints(273, 0, 35, 19));
        bayPanel.add(dText, new XYConstraints(290, 0, 80, 19));
        bayPanel.add(TDLabel, new XYConstraints(270, 20, 35, 19));
        bayPanel.add(TDText, new XYConstraints(290, 20, 80, 19));
        bayPanel.add(jeLabel, new XYConstraints(276, 40, 35, 19));
        bayPanel.add(jeText, new XYConstraints(290, 40, 80, 19));

        bayPanel.add(PI, new XYConstraints(10, 90, 45, 19));
        bayPanel.add(PO, new XYConstraints(10, 110, 45, 19));

        bayPanel.add(piText, new XYConstraints(60, 90, 80, 19));
        bayPanel.add(poText, new XYConstraints(60, 110, 80, 19));

        aText.setEnabled(true);

        RIorRO.add(RI);
        PIorPO.add(PI);

        RIorRO.add(RO);
        PIorPO.add(PO);

        SorP.add(size);
        SorP.add(perc);

        bayPanel.add(R, new XYConstraints(180, 70, 70, 19));

        // bayPanel.add(refresh, new XYConstraints(
        // 354,
        // 166,
        // 18,
        // 18));

        // refreshVL.setIcon(myParent.changeImage);
        // bayPanel.add(refreshV, new XYConstraints(
        // 1,
        // 166,
        // 18,
        // 18));
        //
        // bayPanel.add(refreshVL, new XYConstraints(
        // 22,
        // 166,
        // 18,
        // 18));
        //
        // refreshVL.setToolTipText("Reset to Original Values before Calculating changes.");
        //
        // refreshV.setSelected(false);
        // refreshV.setEnabled(false);

        size.setSelected(true);
        piText.setEnabled(false);
        poText.setEnabled(false);
        wiText.setEnabled(false);
        woText.setEnabled(false);
        centerText.setEnabled(false);
        flankerText.setEnabled(false);

        // WO.setSelected(true);

        PI.setSelected(true);
        piText.setEnabled(true);
        aText.setEnabled(false);
        gText.setText("0");
        // G.setEnabled(false);

        OSText.setEnabled(false);
        TDText.setEnabled(false);

        this.validate();
        this.repaint();

    }

    private void getButtonIcons() {

        refreshIcon = myParent.iconFiles.get("refresh");

        refreshIcon = myParent.iconFiles.get("refresh");
        flatIcon = myParent.iconFiles.get("flat");
        bayIcon = myParent.iconFiles.get("bay");
        bayC1Icon = myParent.iconFiles.get("bayC1");
        bayC2Icon = myParent.iconFiles.get("bayC2");
        bowIcon = myParent.iconFiles.get("bow");
        customIcon = myParent.iconFiles.get("custom");

        flatDIcon = myParent.iconFiles.get("flatdetails");
        bayDIcon = myParent.iconFiles.get("baydetails");
        bowDIcon = myParent.iconFiles.get("bowdetails");
        customDIcon = myParent.iconFiles.get("customdetails");

    }

    private void setAction() {

        try {
            doInit();
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setTexts();
        bayPanel.validate();
        bayPanel.repaint();
    }

    public void changeUOM() {

        try {

            woText.setText(myParent.myTopPanel.fW.getText());
            if (wiText.getText().length() > 0) {
                values = myParent.readConvertText(wiText);
                wiText.setText(values[1] + "");
            }
            if (OSText.getText().length() > 0) {
                values = myParent.readConvertText(OSText);
                OSText.setText(values[1] + "");
            }
            if (dText.getText().length() > 0) {
                values = myParent.readConvertText(dText);
                dText.setText(values[1] + "");
            }
            if (TDText.getText().length() > 0) {
                values = myParent.readConvertText(TDText);
                TDText.setText(values[1] + "");
            }
            if (piText.getText().length() > 0) {
                values = myParent.readConvertText(piText);
                piText.setText(values[1] + "");
            }
            if (poText.getText().length() > 0) {
                values = myParent.readConvertText(poText);
                poText.setText(values[1] + "");
            }
            if (jeText.getText().length() > 0) {
                values = myParent.readConvertText(jeText);
                jeText.setText(values[1] + "");
            }
            if (liteText.getText().length() > 0) {
                values = myParent.readConvertText(liteText);
                liteText.setText(values[1] + "");
            }
            if (centerText.getText().length() > 0) {

                values = myParent.readConvertText(centerText);
                centerText.setText(values[1] + "");
            }
            if (flankerText.getText().length() > 0) {
                values = myParent.readConvertText(flankerText);
                flankerText.setText(values[1] + "");
            }

            if (riText.getText().length() > 0) {
                values = myParent.readConvertText(riText);
                riText.setText(values[1] + "");
            }

            if (roText.getText().length() > 0) {
                values = myParent.readConvertText(roText);
                roText.setText(values[1] + "");
            }

            validate();
            repaint();

        } catch (final NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void changeTextUOM() {

        try {
            if (myParent.currentUOM == 1) {

                wiText.setText(wi_M_O + "");

                woText.setText(wo_M_O + "");

                riText.setText(ri_M_O + "");

                riText.setText(ro_M_O + "");

                piText.setText(pi_M_O + "");

                poText.setText(po_M_O + "");

                dText.setText(d_M_O + "");

                gText.setText(g_M_O + "");

                centerText.setText(center_M_O + "");

                flankerText.setText(flanker_M_O + "");

                liteText.setText(lite_M_O + "");

                OSText.setText(openingSize_M_O + "");

                TDText.setText(td_M_O + "");
            } else if (myParent.currentUOM == 2) {

                wiText.setText(wi_I_O / 64 + "");

                woText.setText(wo_I_O / 64 + "");

                riText.setText(ri_I_O / 64 + "");

                riText.setText(ro_I_O / 64 + "");

                piText.setText(pi_I_O / 64 + "");

                poText.setText(po_I_O / 64 + "");

                dText.setText(d_I_O / 64 + "");

                gText.setText(g_I_O / 64 + "");

                centerText.setText(center_I_O / 64 + "");

                flankerText.setText(flanker_I_O / 64 + "");

                liteText.setText(lite_I_O / 64 + "");

                OSText.setText(openingSize_I_O / 64 + "");

                TDText.setText(td_I_O / 64 + "");
            } else if (myParent.currentUOM == 3) {

                wiText.setText(UOMConvert.imperialToFraction(wi_I_O / 64 + ""));

                woText.setText(UOMConvert.imperialToFraction(wo_I_O / 64 + ""));

                riText.setText(UOMConvert.imperialToFraction(ri_I_O / 64 + ""));

                riText.setText(UOMConvert.imperialToFraction(ro_I_O / 64 + ""));

                piText.setText(UOMConvert.imperialToFraction(pi_I_O / 64 + ""));

                poText.setText(UOMConvert.imperialToFraction(po_I_O / 64 + ""));

                dText.setText(UOMConvert.imperialToFraction(d_I_O / 64 + ""));

                gText.setText(UOMConvert.imperialToFraction(g_I_O / 64 + ""));

                centerText.setText(UOMConvert.imperialToFraction(center_I_O / 64 + ""));

                flankerText.setText(UOMConvert.imperialToFraction(flanker_I_O / 64 + ""));

                liteText.setText(UOMConvert.imperialToFraction(lite_I_O / 64 + ""));

                OSText.setText(UOMConvert.imperialToFraction(openingSize_I_O / 64 + ""));

                TDText.setText(UOMConvert.imperialToFraction(td_I_O / 64 + ""));
            }

            wi_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(wi_M_O + "")), 1, myParent.impRound, 2) * 64;

            wo_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(wo_M_O + "")), 1, myParent.impRound, 2) * 64;

            ri_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(ri_M_O + "")), 1, myParent.impRound, 2) * 64;

            ro_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(ro_M_O + "")), 1, myParent.impRound, 2) * 64;

            pi_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(pi_M_O + "")), 1, myParent.impRound, 2) * 64;

            po_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(po_M_O + "")), 1, myParent.impRound, 2) * 64;

            d_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(d_M_O + "")), 1, myParent.impRound, 2) * 64;

            g_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(g_M_O + "")), 1, myParent.impRound, 2) * 64;

            center_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(center_M_O + "")), 1,
                    myParent.impRound, 2) * 64;

            flanker_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(flanker_M_O + "")), 1,
                    myParent.impRound, 2) * 64;

            lite_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(lite_M_O + "")), 1, myParent.impRound,
                    2) * 64;

            openingSize_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(openingSize_M_O + "")), 1,
                    myParent.impRound, 2) * 64;

            td_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(td_M_O + "")), 1, myParent.impRound, 2) * 64;
        } catch (final NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void saveMandI() {

        try {
            if (myParent.currentUOM == 1) {

                wi_M_O = Double.parseDouble(wiText.getText());
                if (woChanged || wo_M_O == 0) {
                    wo_M_O = Double.parseDouble(woText.getText());
                }

                ri_M_O = Double.parseDouble(riText.getText());

                ro_M_O = Double.parseDouble(roText.getText());

                pi_M_O = Double.parseDouble(piText.getText());

                po_M_O = Double.parseDouble(poText.getText());

                d_M_O = Double.parseDouble(dText.getText());

                g_M_O = Double.parseDouble(gText.getText());

                center_M_O = Double.parseDouble(centerText.getText());

                flanker_M_O = Double.parseDouble(flankerText.getText());

                lite_M_O = Double.parseDouble(liteText.getText());

                openingSize_M_O = Double.parseDouble(OSText.getText());

                td_M_O = Double.parseDouble(TDText.getText());

                wi_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(wi_M_O + "")), 1,
                        myParent.impRound, 2) * 64;
                if (woChanged || wo_I_O == 0) {
                    wo_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(wo_M_O + "")), 1,
                            myParent.impRound, 2) * 64;
                }

                ri_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(ri_M_O + "")), 1,
                        myParent.impRound, 2) * 64;

                ro_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(ro_M_O + "")), 1,
                        myParent.impRound, 2) * 64;

                pi_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(pi_M_O + "")), 1,
                        myParent.impRound, 2) * 64;

                po_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(po_M_O + "")), 1,
                        myParent.impRound, 2) * 64;

                d_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(d_M_O + "")), 1, myParent.impRound,
                        2) * 64;

                g_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(g_M_O + "")), 1, myParent.impRound,
                        2) * 64;

                center_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(center_M_O + "")), 1,
                        myParent.impRound, 2) * 64;

                flanker_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(flanker_M_O + "")), 1,
                        myParent.impRound, 2) * 64;

                lite_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(lite_M_O + "")), 1,
                        myParent.impRound, 2) * 64;

                openingSize_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(openingSize_M_O + "")), 1,
                        myParent.impRound, 2) * 64;

                td_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.metricToImperial(td_M_O + "")), 1,
                        myParent.impRound, 2) * 64;

            } else {
                if (myParent.currentUOM == 2) {

                    wi_I_O = myParent.roundDim(Double.parseDouble(wiText.getText()), 1, myParent.impRound, 2) * 64;
                    if (woChanged || wo_I_O == 0) {
                        wo_I_O = myParent.roundDim(Double.parseDouble(woText.getText()), 1, myParent.impRound, 2) * 64;
                    }

                    ri_I_O = myParent.roundDim(Double.parseDouble(riText.getText()), 1, myParent.impRound, 2) * 64;

                    ro_I_O = myParent.roundDim(Double.parseDouble(roText.getText()), 1, myParent.impRound, 2) * 64;

                    pi_I_O = myParent.roundDim(Double.parseDouble(piText.getText()), 1, myParent.impRound, 2) * 64;

                    po_I_O = myParent.roundDim(Double.parseDouble(poText.getText()), 1, myParent.impRound, 2) * 64;

                    d_I_O = myParent.roundDim(Double.parseDouble(dText.getText()), 1, myParent.impRound, 2) * 64;

                    g_I_O = myParent.roundDim(Double.parseDouble(gText.getText()), 1, myParent.impRound, 2) * 64;

                    center_I_O = myParent.roundDim(Double.parseDouble(centerText.getText()), 1, myParent.impRound, 2) * 64;

                    flanker_I_O = myParent.roundDim(Double.parseDouble(flankerText.getText()), 1, myParent.impRound, 2) * 64;

                    lite_I_O = myParent.roundDim(Double.parseDouble(liteText.getText()), 1, myParent.impRound, 2) * 64;

                    openingSize_I_O = myParent.roundDim(Double.parseDouble(OSText.getText()), 1, myParent.impRound, 2) * 64;

                    td_I_O = myParent.roundDim(Double.parseDouble(TDText.getText()), 1, myParent.impRound, 2) * 64;

                } else if (myParent.currentUOM == 3) {
                    wi_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.fractionToImperial(wiText.getText())), 1,
                            myParent.impRound, 2) * 64;
                    if (woChanged || wo_I_O == 0) {

                        wo_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.fractionToImperial(woText.getText())), 1,
                                myParent.impRound, 2) * 64;
                    }

                    ri_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.fractionToImperial(riText.getText())), 1,
                            myParent.impRound, 2) * 64;

                    ro_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.fractionToImperial(roText.getText())), 1,
                            myParent.impRound, 2) * 64;

                    pi_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.fractionToImperial(piText.getText())), 1,
                            myParent.impRound, 2) * 64;

                    po_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.fractionToImperial(poText.getText())), 1,
                            myParent.impRound, 2) * 64;

                    d_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.fractionToImperial(dText.getText())), 1,
                            myParent.impRound, 2) * 64;

                    g_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.fractionToImperial(gText.getText())), 1,
                            myParent.impRound, 2) * 64;

                    center_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.fractionToImperial(centerText.getText())),
                            1, myParent.impRound, 2) * 64;

                    flanker_I_O = myParent.roundDim(
                            Double.parseDouble(UOMConvert.fractionToImperial(flankerText.getText())), 1,
                            myParent.impRound, 2) * 64;

                    lite_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.fractionToImperial(liteText.getText())), 1,
                            myParent.impRound, 2) * 64;

                    openingSize_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.fractionToImperial(OSText.getText())),
                            1, myParent.impRound, 2) * 64;

                    td_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.fractionToImperial(TDText.getText())), 1,
                            myParent.impRound, 2) * 64;
                } else if (myParent.currentUOM == 4) {
                    wi_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.feetInchToImperial(wiText.getText(),
                            myParent.mySeries.getFeetInchAdjustment())), 1, myParent.impRound, 2) * 64;
                    if (woChanged || wo_I_O == 0) {
                        wo_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.feetInchToImperial(woText.getText(),
                                myParent.mySeries.getFeetInchAdjustment())), 1, myParent.impRound, 2) * 64;
                    }

                    ri_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.feetInchToImperial(riText.getText(),
                            myParent.mySeries.getFeetInchAdjustment())), 1, myParent.impRound, 2) * 64;

                    ro_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.feetInchToImperial(roText.getText(),
                            myParent.mySeries.getFeetInchAdjustment())), 1, myParent.impRound, 2) * 64;

                    pi_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.feetInchToImperial(piText.getText(),
                            myParent.mySeries.getFeetInchAdjustment())), 1, myParent.impRound, 2) * 64;

                    po_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.feetInchToImperial(poText.getText(),
                            myParent.mySeries.getFeetInchAdjustment())), 1, myParent.impRound, 2) * 64;

                    d_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.feetInchToImperial(dText.getText(),
                            myParent.mySeries.getFeetInchAdjustment())), 1, myParent.impRound, 2) * 64;

                    g_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.feetInchToImperial(gText.getText(),
                            myParent.mySeries.getFeetInchAdjustment())), 1, myParent.impRound, 2) * 64;

                    center_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.feetInchToImperial(centerText.getText(),
                            myParent.mySeries.getFeetInchAdjustment())), 1, myParent.impRound, 2) * 64;

                    flanker_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.feetInchToImperial(flankerText.getText(),
                            myParent.mySeries.getFeetInchAdjustment())), 1, myParent.impRound, 2) * 64;

                    lite_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.feetInchToImperial(liteText.getText(),
                            myParent.mySeries.getFeetInchAdjustment())), 1, myParent.impRound, 2) * 64;

                    openingSize_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.feetInchToImperial(OSText.getText(),
                            myParent.mySeries.getFeetInchAdjustment())), 1, myParent.impRound, 2) * 64;

                    td_I_O = myParent.roundDim(Double.parseDouble(UOMConvert.feetInchToImperial(TDText.getText(),
                            myParent.mySeries.getFeetInchAdjustment())), 1, myParent.impRound, 2) * 64;
                }

                wi_M_O = myParent.roundDim(Double.parseDouble(UOMConvert.imperialTometric(wi_I_O / 64 + "")), 1,
                        myParent.metricRound, 1);
                if (woChanged || wo_M_O == 0) {
                    wo_M_O = myParent.roundDim(Double.parseDouble(UOMConvert.imperialTometric(wo_I_O / 64 + "")), 1,
                            myParent.metricRound, 1);
                }

                ri_M_O = myParent.roundDim(Double.parseDouble(UOMConvert.imperialTometric(ri_I_O / 64 + "")), 1,
                        myParent.metricRound, 1);

                ro_M_O = myParent.roundDim(Double.parseDouble(UOMConvert.imperialTometric(ro_I_O / 64 + "")), 1,
                        myParent.metricRound, 1);

                pi_M_O = myParent.roundDim(Double.parseDouble(UOMConvert.imperialTometric(pi_I_O / 64 + "")), 1,
                        myParent.metricRound, 1);

                po_M_O = myParent.roundDim(Double.parseDouble(UOMConvert.imperialTometric(po_I_O / 64 + "")), 1,
                        myParent.metricRound, 1);

                d_M_O = myParent.roundDim(Double.parseDouble(UOMConvert.imperialTometric(d_I_O / 64 + "")), 1,
                        myParent.metricRound, 1);

                g_M_O = myParent.roundDim(Double.parseDouble(UOMConvert.imperialTometric(g_I_O / 64 + "")), 1,
                        myParent.metricRound, 1);

                center_M_O = myParent.roundDim(Double.parseDouble(UOMConvert.imperialTometric(center_I_O / 64 + "")), 1,
                        myParent.metricRound, 1);

                flanker_M_O = myParent.roundDim(Double.parseDouble(UOMConvert.imperialTometric(flanker_I_O / 64 + "")), 1,
                        myParent.metricRound, 1);

                lite_M_O = myParent.roundDim(Double.parseDouble(UOMConvert.imperialTometric(lite_I_O / 64 + "")), 1,
                        myParent.metricRound, 1);

                openingSize_M_O = myParent.roundDim(Double
                        .parseDouble(UOMConvert.imperialTometric(openingSize_I_O / 64 + "")), 1, myParent.metricRound,
                        1);

                td_M_O = myParent.roundDim(Double.parseDouble(UOMConvert.imperialTometric(td_I_O / 64 + "")), 1,
                        myParent.metricRound, 1);

            }
        } catch (final NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void doInit() throws Exception {

        final Object[] dVs = myParent.jobItem.design.bOpeningObject.mullions.toArray();
        double totalThicks = 0;

        for (final Object d : dVs) {
            if (((Profiles) d).divideFacet) {
                totalThicks = totalThicks + ((Profiles) d).thickness;
            }
        }

        bbCT = totalThicks;

        doReadFields();

        if (bay.isSelected()) {

            getFlankerByPercent();

            po = pi + hyp - hypHeight;

            wi = wo - 2 * hypBase;

        } else if (bow.isSelected()) {
            // double fThick = 0;

            theta = Math.toRadians(a);

            // getHyp();

            if (ns == 5 && fixedA) {
                oddBow();
            } else if (ns == 4 && fixedA) {
                evenBow();
            } else {
                bowNewton();
            }

            // wi =wo - 2 * hypBase;
            //
            // if (myParent.currentUOM == 1)
            // {
            // fThick =
            // myParent.mySeries.framedepthM
            // * myParent.scale.doubleValue();
            //
            // }
            // else
            // {
            // fThick =
            // myParent.mySeries.framedepthI
            // * myParent.scale.doubleValue();
            //
            // }
            //
            // base =
            // fThick
            // * Math
            // .tan(Math
            // .toRadians(a / 2d));
            //
            // final double j_S =
            // (180 - a * ns) / 2d;
            //
            // final double j_R =
            // wo
            // * Math
            // .sin(Math
            // .toRadians(j_S))
            // /
            // Math
            // .sin(Math
            // .toRadians(a
            // * ns));
            //
            // final double j_Base =
            // j_R
            // * Math
            // .sin(Math
            // .toRadians(a))
            // / Math
            // .sin(Math
            // .toRadians(((180 - a) / 2d)));
            //
            // lite = j_Base - base;
            // lite = this.getRoundedValueMI(lite);
            // pi =
            // lite
            // * Math
            // .sin(Math
            // .toRadians(a
            // / 2d
            // * (ns - 1)))
            // +
            // lite
            // * Math
            // .sin(Math
            // .toRadians(a / 2d));
            //
            // po =
            // pi
            // - fThick
            // * Math
            // .cos(Math
            // .toRadians(a
            // / 2d
            // * (ns - 1)))
            // +
            // fThick
            // / Math
            // .cos(Math
            // .toRadians(a / 2d)) - hypHeight;
            //
            // ri =
            // pi
            // / 2d
            // + Math.pow(
            // wi,
            // 2d)
            // / (8d * pi);
            // ro = ri + fThick;
            //
            // hypBase = hyp * Math.cos(Math
            // .toRadians(a / 2d));
            //
            // base = 2*(ri*Math.cos(a/2d));
            //
            // flatW = ns*lite+bbCT;

        }

        if (bay.isSelected()) {
            final double value = Math.min(center, flanker) / myScale.doubleValue();

            if (myParent.currentUOM == 1) {
                if (value < myParent.mySeries.getFacetMinWidth() / 100) {
                    goodToGo = false;
                }

            } else {

                if (value < myParent.mySeries.getFacetMinWidthI()) {
                    goodToGo = false;
                }

            }

        } else if (bow.isSelected()) {
            final double value = lite / myScale.doubleValue();
            if (myParent.currentUOM == 1) {
                if (value < myParent.mySeries.getFacetMinWidth() / 100) {
                    goodToGo = false;
                }

            } else {

                if (value < myParent.mySeries.getFacetMinWidthI()) {
                    goodToGo = false;
                }

            }
        }

        validate();
        repaint();

    }

    public void bowNewton() {

        double angle = 0;
        if (fixedA) {
            angle = a / 2;

            ro = wo / 2 / Math.sin(Math.toRadians(angle * ns));

            po = ro - ro * Math.cos(Math.toRadians(a * ns / 2));
            doNewton();
        } else {

            JOptionPane.showMessageDialog(null, "Need Outside Projection of Bow Window!\n"
                    + "Please enter a value in the PO filed and press Enter.", "Input Required - Warning!",
                    JOptionPane.WARNING_MESSAGE);

            PI.setSelected(false);
            PI.setEnabled(false);

            PO.setSelected(true);
            PO.setEnabled(false);

            piText.setText("----");
            piText.setEnabled(false);

            poText.setText("");
            poText.setEnabled(true);
            poText.setEditable(true);
            poText.grabFocus();

            fromNewton = true;
            suspend = true;

            // po = ro - (ro * Math.cos(Math.toRadians(a*ns/2)));

        }

    }

    public void doNewton() {

        final double F = Math.pow(10, 12);
        final double PI = Math.PI;
        final double deg = 180 / PI;
        final double rad = PI / 180;

        String display = "\nbest fit results\n";
        double span = wo;
        double projection = po;
        final double bays = ns;

        if (span < 12) {
            span = 12;
        }
        if (projection > span) {
            projection = span / 2;
        }

        String results = "";

        final double half_span = .5 * span;

        // double theta = .01;

        double theta = 1 / F;
        double limit = .5 * (bays - 1);
        double i = 0;

        double odd_bay_add = 0.5;
        boolean odd_bays = true;

        final double odd_even = bays % 2;
        if (odd_even == 0) {
            odd_bays = false;
            limit = .5 * bays;
            odd_bay_add = 0.0;
        }

        double n_sum = 0;
        double d_sum = 0;
        double n_calc = 0;
        double d_calc = 0;
        double numerator = 0;
        double denominator = 0;
        double ratio = 0;
        double difference = 0;

        for (double j = 0; j < 1000; j++) {

            n_sum = 0;
            d_sum = 0;
            n_calc = 0;
            d_calc = 0;
            numerator = 0;
            denominator = 0;
            ratio = 0;
            difference = 0;

            do {
                for (double n = 1; n <= limit; n++) {
                    if (odd_bays) {
                        n_calc = Math.cos(n * theta);
                        d_calc = Math.sin(n * theta);
                    } else {
                        n_calc = Math.cos((2 * n - 1) * theta / 2);
                        d_calc = Math.sin((2 * n - 1) * theta / 2);
                    }
                    n_sum = n_sum + n_calc;
                    d_sum = d_sum + d_calc;
                }

                if (d_sum == 0) {
                    break;
                }
                numerator = half_span / (odd_bay_add + n_sum);
                denominator = projection / d_sum;
                ratio = numerator / denominator;
                difference = denominator - numerator;
                results = results + "\n" + i + " difference = " + difference + " ";
                results = results + "\n" + i + " ratio = " + ratio + " ";
                results = results + "\n" + i + " theta = " + deg * theta + " ";
                i++;
                theta = theta / ratio;

                if (ratio < 1) {
                    break;
                }

            }
            while (difference > 0);
            // if(Math.abs(difference) <
            // .0000000000001){
            // break;}
            if (Math.abs(difference) < 1 / F) {
                break;
            }
        }

        final double radius = .5 * (numerator + denominator) / 2 / Math.sin(.5 * theta);
        final double bay_arc = radius * theta;
        final double total_arc = bays * radius * theta;

        display = display + "\n\n" + " Span derived Side = " + numerator;
        display = display + "\n" + " Projection derived Side = " + denominator;
        display = display + "\n" + " Ratio = " + ratio;
        display = display + "\n" + " Difference = " + difference;
        display = display + "\n" + " Theta = " + theta * deg;
        display = display + "\n" + " Radius = " + radius;
        display = display + "\n" + " Arc Length Per Bay = " + bay_arc;
        display = display + "\n" + " Total arc length = " + total_arc;
        display = display + "\n" + " odd bays = " + odd_bays;
        results = results + display + "";

//        System.out.print(results);

        lite = denominator;
        lite = getRoundedValueMI(lite);
        a = theta * deg;

        getHyp();

        wi = wo - 2 * hypBase;

        ro = radius;

        ri = ro - hyp;

        pi = po - hyp + hypHeight;

        flatW = ns * lite + bbCT;

        suspend = false;
    }

    public void oddBow() {

        getHyp();

        wi = wo - 2 * hypBase;

        ri = wi / 2 / Math.sin(Math.toRadians(a * ns / 2));

        pi = ri - ri * Math.cos(Math.toRadians(a * ns / 2));

        final double isoA = (180 - a) / 2;

        lite = 2 * ri * Math.cos(Math.toRadians(isoA));
        lite = getRoundedValueMI(lite);
        po = pi + hyp - hypHeight;

        ro = ri + hyp;

        flatW = ns * lite + bbCT;

    }

    public void evenBow() {

        getHyp();

        wi = wo - 2 * hypBase;

        ri = wi / 2 / Math.sin(Math.toRadians(a * ns / 2));

        pi = ri - ri * Math.cos(Math.toRadians(a * ns / 2));

        final double isoA = (180 - a) / 2;

        lite = 2 * ri * Math.cos(Math.toRadians(isoA));
        lite = getRoundedValueMI(lite);
        po = pi + hyp - hypHeight;

        ro = ri + hyp;

        flatW = ns * lite + bbCT;

    }

    public void doDText() throws Exception {

        getHyp();
        values = myParent.readTextCurrentUOM(dText);

        d = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myScale.doubleValue();

        if (g >= 0) {

            td = po + d;
        } else {
            po = po + this.hypHeight;
            td = po + d;
        }

        values = myParent.dimConvert(td / myScale.doubleValue(), false);

        TDText.setText(values[0] + "");

        je = td - po;

        values = myParent.dimConvert(je / myScale.doubleValue(), false);

        jeText.setText(values[0] + "");

        openingSize = wo + 2 * g;

        values = myParent.dimConvert((wo + 2 * g) / myScale.doubleValue(), false);

        OSText.setText(values[0] + "");

        values = myParent.dimConvert(po / myScale.doubleValue(), false);

        poText.setText(values[0] + "");

    }

    public double getRoundedValueMI(double value) {

        // double myScale.doubleValue() =0;
        // if(myParent.myTopPanel.metric.isSelected()) {
        // myScale.doubleValue() = originalScale*100;
        // }else {
        // myScale.doubleValue() = originalScale;
        // }

        if (myParent.myTopPanel.metric.isSelected()) {
            value = myParent.roundDim(value / myScale.doubleValue(), 2, myParent.metricRound, 1) * myScale.doubleValue();
        } else {
            value = myParent.roundDim(value / myParent.scale.doubleValue(), 2, myParent.impRound, 2) * myParent.scale.doubleValue();
        }
        return value;
    }

    public void doReadFields() throws Exception {

        a = Double.parseDouble(aText.getText());

        theta = Math.toRadians(a);

        openingSize = 0;

        values = myParent.readTextCurrentUOM(gText);
        g = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myScale.doubleValue();
        values = myParent.readTextCurrentUOM(dText);
        d = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myScale.doubleValue();
        ns = Integer.parseInt(nsText.getText());

        values = myParent.readTextCurrentUOM(woText);

        wo = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myScale.doubleValue();
        hypBase = 0;

        getHyp();

        wi = wo - 2 * hypBase;

        cp = Double.parseDouble(centerPText.getText());

        fp = Double.parseDouble(flankerPText.getText());

        base = wi * fp;

        values = myParent.readTextCurrentUOM(centerText);

        center = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myScale.doubleValue();

        values = myParent.readTextCurrentUOM(piText);
        pi = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myScale.doubleValue();

        values = myParent.readTextCurrentUOM(poText);
        po = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myScale.doubleValue();

        values = myParent.readTextCurrentUOM(riText);
        ri = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myScale.doubleValue();

        values = myParent.readTextCurrentUOM(roText);
        ro = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myScale.doubleValue();

        values = myParent.readTextCurrentUOM(liteText);
        lite = myParent.doRoundDim(Double.parseDouble(values[0].toString())) * myScale.doubleValue();
    }

    public void getHyp() {

        if (myParent.currentUOM <= 1) {
            hyp = myParent.mySeries.getFrameDepth() * myScale.doubleValue() / 100;
        } else {
            hyp = myParent.mySeries.getFrameDepthImp() * myScale.doubleValue() / 100;
        }

        if (bay.isSelected()) {
            hypBase = hyp * Math.sin(theta);
            hypHeight = hypBase * Math.tan(theta);
            if (g < 0) {
                hypBase = hypBase + g;
                hypHeight = hypBase * Math.tan(theta);

            }
        } else if (bow.isSelected()) {

            if (ns < 4 || ns > 5 || !fixedA) {

                final double o = 90 - ns * a / 2;
                final double isoA = (180 - a) / 2;
                double myAngle = 360 - (2 * 90 + isoA + isoA - o);

                myAngle = o + a / 2;

                hypBase = hyp * Math.sin(Math.toRadians(myAngle));
                hypHeight = hypBase * Math.tan(Math.toRadians(myAngle));

                if (g < 0) {
                    hypBase = hypBase + g;
                    hypHeight = hypBase * Math.tan(Math.toRadians(myAngle));
                }
            } else if (ns == 5 && fixedA) {

                final double o = 90 - ns * a / 2;
                final double isoA = (180 - a) / 2;
                double myAngle = 360 - (2 * 90 + isoA + isoA - o);

                myAngle = a;

                hypBase = hyp * Math.sin(2 * Math.toRadians(myAngle));
                hypHeight = hypBase * Math.tan(2 * Math.toRadians(myAngle));

                if (g < 0) {
                    hypBase = hypBase + g;
                    hypHeight = hypBase * Math.tan(Math.toRadians(myAngle));
                }
            } else if (ns == 4 && fixedA) {

                final double o = 90 - ns * a / 2;
                final double isoA = (180 - a) / 2;
                double myAngle = 360 - (2 * 90 + isoA + isoA - o);

                myAngle = a;

                hypBase = hyp * Math.sin(1.5 * Math.toRadians(myAngle));
                hypHeight = hypBase * Math.tan(1.5 * Math.toRadians(myAngle));

                if (g < 0) {
                    hypBase = hypBase + g;
                    hypHeight = hypBase * Math.tan(1.5 * Math.toRadians(myAngle));
                }
            }
        }

    }

    public void getFlankerByPercentBAD() {

        getHyp();

        center = (wo - bbCT) * cp;

        center = getRoundedValueMI(center);

        wi = wo - 2 * hypBase;

        base = (wi - center - bbCT) / 2;

        flanker = base / Math.cos(Math.toRadians(a));

        pi = Math.sin(theta) * flanker;

        flatW = 2 * flanker + center + bbCT;
    }

    public void getFlankerByPercent() {

        getHyp();

        center = (wo - bbCT) * cp;

        center = getRoundedValueMI(center);

        base = (wi - bbCT - center) / 2;

        flanker = base / Math.cos(Math.toRadians(a));

        flanker = getRoundedValueMI(flanker);

        pi = Math.tan(Math.toRadians(a)) * base;

        flatW = 2 * flanker + center;

        // int count = 1;
        // boolean found = true;
        // double lastValue = 1000;

        // if((flanker/flatW != fp)
        // || (flatW < wo-bbCT)) {
        // found = false;
        //
        // do {
        //
        // base = base - 1;
        //
        // flanker = base/Math.cos(Math.toRadians(a));
        //
        // pi = Math.sin(Math.toRadians(a))*flanker;
        // center = wo - 2*base - bbCT;
        //
        // flatW = 2* flanker + center;
        //
        // if((lastValue > fp) && (flanker/flatW<fp)) {
        // found = true;
        // break;
        // }
        // lastValue = flanker/flatW;
        //
        // if((flanker/flatW ==fp)
        // && (flatW > wo-bbCT)) {
        // found = true;
        // }
        //
        // }while(!found || (flatW < wo-bbCT));
        //
        //
        // if(!found) {
        // lastValue = 10000;
        // count = 0;
        // base = (wo-bbCT)*fp;
        // do {
        // base = base + 1;
        // flanker = base/Math.cos(Math.toRadians(a));
        //
        // pi = Math.sin(Math.toRadians(a))*flanker;
        // center = wo - 2*base - bbCT;
        //
        // flatW = 2* flanker + center;
        // if((lastValue > fp) && (flanker/flatW<fp)) {
        // found = true;
        // break;
        // }
        // lastValue = flanker/flatW;
        // ;
        // if((flanker/flatW ==fp)
        //
        // && (flatW > wo-bbCT)) {
        // found = true;
        // }
        //
        // }while(!found || (flatW < wo-bbCT));
        // }
        //
        // if(!found) {
        // base = (wo-bbCT)*fp;
        // flanker = base/Math.cos(Math.toRadians(a));
        //
        // pi = Math.sin(Math.toRadians(a))*flanker;
        // center = wo - 2*base - bbCT;
        //
        // flatW = 2* flanker + center;
        // }
        //
        // flanker = getRoundedValueMI(flanker);
        // center = getRoundedValueMI(center);
        // flatW = 2* flanker + center ;
        //
        // try
        // {
        //
        // // double myScale.doubleValue() =0;
        // // if(myParent.myTopPanel.metric.isSelected()) {
        // // myScale.doubleValue() = myParent.scale.doubleValue()*100;
        // // }else {
        // // myScale.doubleValue() = myParent.scale.doubleValue();
        // // }
        //
        //
        // values =
        // myParent
        // .dimConvert(
        // center
        // / myScale.doubleValue(),
        // true);
        //
        // center =
        // Double.parseDouble(values[0].toString())*myScale.doubleValue();
        //
        // flatW = center / cp;
        // flatW = getRoundedValueMI(flatW);
        //
        // flanker = (flatW - center)/2;
        // flatW = getRoundedValueMI(flatW);
        //
        // values =
        // myParent
        // .dimConvert(
        // flanker
        // /myScale.doubleValue(),
        // true);
        //
        //
        // flanker =
        // Double.parseDouble(values[0].toString())*myScale.doubleValue();
        // flatW = 2* flanker + center ;
        // final double flankerW = flanker/myScale.doubleValue();
        // final double centerW = center/myScale.doubleValue();
        //
        // base = flanker * Math.cos(Math.toRadians(a));
        //
        // pi = Math.sin(Math.toRadians(a))*flanker;
        //
        // }
        // catch (final Exception e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        //
        // }

    }

    public void doBowFacets() {

        final Object[] myMs = myParent.jobItem.design.bOpeningObject.mullions.toArray();

        myParent.jobItem.design.bOpeningObject.mullions.clear();

        final Collection bowMs = new ArrayList();

        for (final Object m : myMs) {

            if (((Profiles) m).angle != 180) {
                bowMs.add(m);
                ((Profiles) m).angle = a;
            }

            myParent.jobItem.design.bOpeningObject.mullions.add(m);
        }

        doSetW();

    }

    public void doSetW() {

        if (!suspend) {
            Object[] fWs = myParent.fcolTextObjects.toArray();

            myParent.fcolTextObjects.clear();

            int count = 1;
            for (final Object t : fWs) {
                if (bay.isSelected()) {
                    if (count == 1 || count == 3) {
                        myParent.fcolTextObjects.add(this.flankerText.getText());
                    } else {
                        myParent.fcolTextObjects.add(this.centerText.getText());
                    }
                } else if (bow.isSelected()) {
                    myParent.fcolTextObjects.add(this.liteText.getText());
                }
                count++;
            }

            fWs = myParent.fcolTextObjects.toArray();

            double newW = 0;

            final Object[] dVs = myParent.jobItem.design.bOpeningObject.mullions.toArray();
            double totalThicks = 0;
            int countFacets = 1;

            for (final Object d : dVs) {
                if (((Profiles) d).divideFacet) {
                    totalThicks = totalThicks + ((Profiles) d).thickness;
                    countFacets++;
                }
            }

            for (int j = 0; j < fWs.length; j++) {
                newW = newW + Double.parseDouble(fWs[j].toString());
            }

            newW = newW + totalThicks / myScale.doubleValue();

            myParent.changeFacetW = true;

            myParent.doResetOverallSize(newW, myParent.jobItem.design.heightPix / myScale.doubleValue(), myParent.jobItem.design, 0, false,
                    false);

            fWs = myParent.fcolTextObjects.toArray();

            if (!fixedA && (bay.isSelected() || bow.isSelected())) {
                final Object[] myMs = myParent.jobItem.design.bOpeningObject.mullions.toArray();
                myParent.jobItem.design.bOpeningObject.mullions.clear();

                for (final Object m : myMs) {

                    if (((Profiles) m).orientation == 1 && ((Profiles) m).posCondition == 1 && ((Profiles) m).cOrM == 1
                            && (((Profiles) m).angle != 180 || !((Profiles) m).fixedAngle)) {

                        ((Profiles) m).angle = (int) (a * 100) / 100;

                    }

                    myParent.jobItem.design.bOpeningObject.mullions.add(m);
                }
            }

            myParent.jobItem.myCanvas.createTextFieldsFacet();
            myParent.jobItem.myCanvas.createTextFieldsCoupler();

            myParent.changeFacetW = false;
            myParent.doFacetRadioClick();
            myParent.dimAction();
        }

    }

    public void doSetWBow(final double wOverall, final double hOverall, final Collection bowMs) {

        try {

            myParent.topTexts.toArray();

            myParent.facetUsed.initFacetSize(wOverall, hOverall, wOverall, hOverall, myParent.facetUsed, 0);

            myParent.facetUsed.frameWRounded = false;
            myParent.facetUsed.frameHRounded = false;

            myParent.facetUsed.resetTextsforRowCol(myParent.selectedRadioForRow, myParent.selectedRadioForRow,
                    myParent.selectedRadioForRowo, myParent.selectedRadioForColo, false);

            myParent.facetUsed.frameWRounded = false;
            myParent.facetUsed.frameHRounded = false;

            myParent.jobItem.myCanvas.drawTextTop = true;
            myParent.jobItem.myCanvas.drawTextLeft = true;

            //Clear draw canvas components
            myParent.jobItem.myCanvas.clearDrawCanvasComponents();

            myParent.jobItem.myCanvas.createTextFieldsTop();
            myParent.jobItem.myCanvas.createTextFieldsLeft();
            myParent.jobItem.myCanvas.createTextFieldsFacet();
            myParent.jobItem.myCanvas.createTextFieldsCoupler();

            myParent.facetUsed.frameWRounded = false;
            myParent.facetUsed.frameHRounded = false;

            myParent.facetUsed.reDrawRadioRowCol(myParent.facetUsed.yRows, myParent.facetUsed.xCols, myParent.selectedDim,
                    myParent.selectedRadioForRow, myParent.selectedRadioForCol, myParent.facetUsed);

            myParent.facetUsed.frameWRounded = false;
            myParent.facetUsed.frameHRounded = false;

            Object[] topTs = myParent.topTexts.toArray();

            int count = 1;
            double newSize = 0;
            int lastBM = 0;

            final Object[] mybMs = bowMs.toArray();
            final Object[] myTotalCs = myParent.jobItem.design.bOpeningObject.mullions.toArray();
            noExtra = myTotalCs.length - mybMs.length;
            int myCcount = 0;
            if (noExtra > 0) {
                count = 0;
                final int myc = 0;

                for (final Object c : topTs) {
                    count++;
                    myCcount = 0;
                    for (int i = 0; i < mybMs.length; i++) {

                        myCcount++;

                        if (count > ((Profiles) mybMs[i]).order) {

                        }
                        if (count > ((Profiles) mybMs[i]).order && myCcount == ns - 1 && count < myTotalCs.length) {
                            int d = myTotalCs.length - lastBM;

                            if (d == 0) {
                                d = lastBM;
                            }
                            lastBM = ((Profiles) mybMs[i]).order;
                            myParent.jobItem.myCanvas.selectedFrameNo = count;
                            newSize = lite / d / myScale.doubleValue();
                            myParent.jobItem.myCanvas.modColWidths(newSize, true);

                            break;
                        } else if (count <= ((Profiles) mybMs[i]).order) {
                            int d = ((Profiles) mybMs[i]).order - lastBM;

                            if (d == 0) {
                                d = lastBM;
                            }

                            lastBM = ((Profiles) mybMs[i]).order;
                            myParent.jobItem.myCanvas.selectedFrameNo = count;
                            newSize = lite / d / myScale.doubleValue();
                            myParent.jobItem.myCanvas.modColWidths(newSize, true);

                            break;

                        }

                    }
                }

            }

            count = 1;

            lastBM = 0;

            active = new boolean[topTs.length];

            if (noExtra > 0) {

                for (final Object bm : mybMs) {

                }
                topTs = myParent.topTexts.toArray();
                myParent.topTexts.clear();

                for (final Object c : topTs) {

                    for (final Object bm : mybMs) {

                        if (count < ((Profiles) bm).order && (count > 1 || count > lastBM) || count == ((Profiles) bm).order
                                && (count - 1 > 1 || count - 1 > lastBM) || count > ns - 1 && count < topTs.length) {
                            ((TextFieldTop) c).active = true;
                            ((TextFieldTop) c).facetW = lite;
                            lastBM = ((Profiles) bm).order;
                            break;
                        }

                    }

                    active[count - 1] = ((TextFieldTop) c).active;

                    count++;

                    myParent.topTexts.add(c);
                }
            }

            myParent.facetUsed.frameWRounded = false;
            myParent.facetUsed.frameHRounded = false;

            myParent.dimAction();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setTexts() {

        if (flat.isSelected() && this.myParent.myTopPanel.labelFlat.isVisible()) {
            myParent.myTopPanel.remove(myParent.myTopPanel.labelFlat);

            myParent.myTopPanel.remove(myParent.myTopPanel.flatW);
            myParent.myTopPanel.remove(myParent.myTopPanel.layoutLabel);

        }

        if (!suspend) {
            aText.setText(myParent.twoDecimal.format(a) + "");

            try {

                values = myParent.dimConvert(wi / myScale.doubleValue(), false);

                wiText.setText(values[0] + "");

                values = myParent.dimConvert((wo + 2 * g) / myScale.doubleValue(), false);

                OSText.setText(values[0] + "");

                values = myParent.dimConvert(pi / myScale.doubleValue(), false);

                piText.setText(values[0] + "");

                values = myParent.dimConvert(po / myScale.doubleValue(), false);

                poText.setText(values[0] + "");

                values = myParent.dimConvert(center / myScale.doubleValue(), false);

                centerText.setText(values[0] + "");

                values = myParent.dimConvert(flanker / myScale.doubleValue(), false);

                flankerText.setText(values[0] + "");

                if (d == 0) {
                    je = 0;
                }

                values = myParent.dimConvert(je / myScale.doubleValue(), false);

                jeText.setText(values[0] + "");

                values = myParent.dimConvert(td / myScale.doubleValue(), false);

                TDText.setText(values[0] + "");

                values = myParent.dimConvert(ri / myScale.doubleValue(), false);

                riText.setText(values[0] + "");

                values = myParent.dimConvert(ro / myScale.doubleValue(), false);

                roText.setText(values[0] + "");

                values = myParent.dimConvert(lite / myScale.doubleValue(), false);

                liteText.setText(values[0] + "");

                openingSize = wo + 2 * g;

                values = myParent.dimConvert(flatW / myScale.doubleValue(), false);

                if (!flat.isSelected()) {
                    this.myParent.myTopPanel.add(myParent.myTopPanel.labelFlat, new XYConstraints(6, 70, 40, 20));

                    this.myParent.myTopPanel.add(myParent.myTopPanel.flatW, new XYConstraints(52, 70, 80, 20));

                    setlayoutIcon();

                    myParent.myTopPanel.flatW.setText(values[0] + "");
                }

                if (myParent.currentUOM >= 3) {

                    values = myParent.dimConvert((wo + 2 * g) / myScale.doubleValue(), false);

                    OSText.setText(values[1] + "");

                    values = myParent.dimConvert(pi / myScale.doubleValue(), true);

                    piText.setText(values[1] + "");

                    values = myParent.dimConvert(po / myScale.doubleValue(), true);

                    poText.setText(values[1] + "");

                    values = myParent.dimConvert(center / myScale.doubleValue(), true);

                    centerText.setText(values[1] + "");

                    flankerText.setText(values[1] + "");

                    values = myParent.dimConvert(je / myScale.doubleValue(), true);

                    jeText.setText(values[1] + "");

                    values = myParent.dimConvert(td / myScale.doubleValue(), true);

                    TDText.setText(values[1] + "");

                    values = myParent.dimConvert(ri / myScale.doubleValue(), true);

                    riText.setText(values[1] + "");

                    values = myParent.dimConvert(ro / myScale.doubleValue(), true);

                    roText.setText(values[1] + "");

                    values = myParent.dimConvert(lite / myScale.doubleValue(), true);

                    liteText.setText(values[1] + "");

                    aText.setText(a + "");

                    // values =
                    // myParent
                    // .dimConvert(
                    // (wo + (2*g))
                    // / myScale.doubleValue(),
                    // false);
                    //
                    // OSText.setText(values[0] + "");

                }
                if (bay.isSelected()) {
                    centerPText.setText(myParent.oneDecimal.format(cp * 100) + "");
                    flankerPText.setText(myParent.oneDecimal.format(fp * 100) + "");
                }

            } catch (final NumberFormatException e) {
                // TODO Auto-generated catch
                // block
                e.printStackTrace();
            } catch (final Exception e) {
                // TODO Auto-generated catch
                // block
                e.printStackTrace();
            }

            saveMandI();

            myParent.jobItem.myCanvas.createTextFieldsCoupler();

            myParent.hasGrids = false;

            myParent.setBayBowTasks();

            this.validate();
            this.repaint();
        }

    }

    public void setlayoutIcon() {

        if (this.flat.isSelected()) {
            this.myParent.myTopPanel.remove(this.myParent.myTopPanel.layoutLabel);
        } else if (this.custom.isSelected()) {
            myParent.myTopPanel.layoutLabel.setIcon(myParent.layoutP.customIcon);
            myParent.myTopPanel.layoutLabel.setToolTipText("Custom Layout");
            this.myParent.myTopPanel.add(this.myParent.myTopPanel.layoutLabel, new XYConstraints(138, 67, 30, 24));
        } else if (this.bay.isSelected()) {
            myParent.myTopPanel.layoutLabel.setIcon(myParent.layoutP.bayIcon);
            myParent.myTopPanel.layoutLabel.setToolTipText("Bay Layout");
            this.myParent.myTopPanel.add(this.myParent.myTopPanel.layoutLabel, new XYConstraints(138, 67, 30, 24));

        } else if (this.bow.isSelected()) {
            myParent.myTopPanel.layoutLabel.setIcon(myParent.layoutP.bowIcon);
            myParent.myTopPanel.layoutLabel.setToolTipText("Bow Layout");
            this.myParent.myTopPanel.add(this.myParent.myTopPanel.layoutLabel, new XYConstraints(138, 67, 30, 24));
        }

        this.myParent.myTopPanel.validate();
        this.myParent.myTopPanel.repaint();
    }

    public void doSelectedLayout() {

        if (flat.isSelected()) {
            flat.doClick();
        } else if (custom.isSelected()) {
            custom.doClick();
        } else if (bay.isSelected()) {
            bay.doClick();
        } else if (bow.isSelected()) {
            bow.doClick();
        }

    }

    public void refreshNew() {

        cp = myParent.mySeries.getDefaultBayCenterSplit() / 100;

        fp = myParent.mySeries.getDefaultBayCenterSplit() / 100 / 2;

        centerPText.setText(cp * 100 + "");
        flankerPText.setText(fp * 100 + "");

        try {
            doInit();
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    class MyItemListener implements ItemListener {

        // This method is called only if a new item
        // has been selected.
        @Override
        public void itemStateChanged(final ItemEvent evt) {

            // final JComboBox cb = (JComboBox)evt.getSource();
            //
            // // Get the affected item
            // final Object item = evt.getItem();
            //
            // if (evt.getStateChange() == ItemEvent.SELECTED) {

            LayoutPanel.this.setAction();

            // } else if (evt.getStateChange() == ItemEvent.DESELECTED)
            // {
            //
            // }
        }
    }

}
