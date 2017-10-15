package util;

import javax.swing.*;
import java.util.Collection;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 11-14-12
 * Time: 09:20 AM
 */
public class LoadDataListUtil {

    /**
     * Load objects to comboBox UI Component
     *
     * @param comboBox, JComboBox
     * @param data,     Collection of data
     */
    public static void loadObjectToComboBox(JComboBox comboBox, Collection data) {
        for (Object aData : data) {
            comboBox.addItem(aData);
        }
    }
}
