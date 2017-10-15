package openjanela.commons.components.generic.renderer;

import javax.swing.*;
import java.awt.*;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 07-30-12
 * Time: 11:21 PM
 */
public class ComboBoxEmptySelectionRenderer extends DefaultListCellRenderer {

    //Message
    private String selectionPrompt;

    //JComboBox
    private JComboBox comboBox;


    /**
     * Constructor Renderer
     *
     * @param comboBox,        JComboBox
     * @param selectionPrompt, String
     */
    public ComboBoxEmptySelectionRenderer(JComboBox comboBox, String selectionPrompt) {
        this.comboBox = comboBox;
        this.selectionPrompt = selectionPrompt;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index,
                                                  boolean isSelected, boolean focus) {
        super.getListCellRendererComponent(list, value, index, isSelected, focus);

        if (index == -1 && comboBox.getSelectedIndex() == -1) {
            setText(selectionPrompt);
        }

        return this;
    }
}
