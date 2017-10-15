package org.openjanela.commons.util.controller;

import java.awt.*;
import java.awt.event.*;

/**
 * Copyright (c) 2011-2013, OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-11-13
 *          Time: 09:34 PM
 */
public class CursorController {


    public final static Cursor busyCursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
    public final static Cursor defaultCursor = Cursor.getDefaultCursor();

    private CursorController() {
    }

    public static ActionListener createListener(final Component component, final ActionListener listener) {
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    component.setCursor(busyCursor);
                    listener.actionPerformed(ae);
                } finally {
                    component.setCursor(defaultCursor);
                }
            }
        };
        return actionListener;
    }

    public static MouseListener createListener(final Component component, final MouseListener listener) {
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    component.setCursor(busyCursor);
                    listener.mouseClicked(e);
                } finally {
                    component.setCursor(defaultCursor);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    component.setCursor(busyCursor);
                    listener.mousePressed(e);
                } finally {
                    component.setCursor(defaultCursor);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    component.setCursor(busyCursor);
                    listener.mouseReleased(e);
                } finally {
                    component.setCursor(defaultCursor);
                }
            }
        };

        return mouseListener;
    }
}
