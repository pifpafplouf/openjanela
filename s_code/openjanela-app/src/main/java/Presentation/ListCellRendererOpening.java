package Presentation;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

import openjanela.model.entities.partner.SeriesValidOpeningShape;

import org.pushingpixels.substance.api.renderers.SubstanceDefaultListCellRenderer;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-08-12
 *          Time: 11:57 AM
 */
public class ListCellRendererOpening extends SubstanceDefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        SeriesValidOpeningShape validOpening = (SeriesValidOpeningShape) value;

        String imageName = "op" + validOpening.getSeriesValidOpeningPK().getOpeningId().intValue() + "";
        ImageIcon imageIcon = ItemFrame.iconFiles.get(imageName);

        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        label.setIcon(imageIcon);
        label.setName(validOpening.getSeriesValidOpeningPK().getOpeningId().intValue() + "");
        label.setToolTipText(validOpening.getSeriesValidOpeningPK().getAbbreviation());
        label.setText(validOpening.getSeriesValidOpeningPK().getAbbreviation());

        return label;
    }
}
