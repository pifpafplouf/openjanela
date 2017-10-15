/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

import java.util.*;

import javax.swing.table.*;

public class MyDefaultTableModel
        extends DefaultTableModel {

    public MyDefaultTableModel(Vector rowData, Vector header) {
        super(rowData, header);
    }

    public boolean isCellEditable(int row, int col) {
        int columnCount = getColumnCount();
        return col == columnCount;
    }
}
