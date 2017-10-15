/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/

package util;

import javax.swing.text.*;

public class NumericDocument
        extends PlainDocument {

    public NumericDocument() {
    }

    public void insertString(int offset, String string, AttributeSet attributeSet) throws
            BadLocationException {
        int stringLength = string.length();
        for (int i = 0; i < stringLength; i++) {
            char c = string.charAt(i);
            if (!Character.isDigit(c) && c != '.' && c != '-' && c != '/' && c != ' ') {
                return;
            }
        }

        super.insertString(offset, string, attributeSet);
    }
}
