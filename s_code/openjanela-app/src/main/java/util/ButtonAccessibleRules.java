/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonAccessibleRules {

    private JButton newButton;
    private JButton editButton;
    private JButton saveButton;
    private JButton cancelButton;
    private JButton deleteButton;

    private JPanel otherComponents;

    private Collection exclusions;

    public ButtonAccessibleRules(JButton nButton, JButton eButton,
                                 JButton sButton,
                                 JButton cButton, JButton dButton,
                                 JPanel newOtherComponents,
                                 Collection newExclusions) {
        newButton = nButton;
        editButton = eButton;
        saveButton = sButton;
        cancelButton = cButton;
        deleteButton = dButton;
        otherComponents = newOtherComponents;
        exclusions = newExclusions;
    }

    public void init() {
        if (newButton != null) {
            newButton.setEnabled(true);
        }
        if (editButton != null) {
            editButton.setEnabled(true);
        }
        if (saveButton != null) {
            saveButton.setEnabled(false);
        }
        if (cancelButton != null) {
            cancelButton.setEnabled(false);
        }
        if (deleteButton != null) {
            deleteButton.setEnabled(true);
        }
        enableOrDisableComponenets(otherComponents, false);
    }

    public void buttonActionPerformed(ActionEvent ae) {
        JButton button = (JButton) ae.getSource();
        if (button == newButton) {
            if (newButton != null) {
                newButton.setEnabled(false);
            }
            if (editButton != null) {
                editButton.setEnabled(false);
            }
            if (saveButton != null) {
                saveButton.setEnabled(true);
            }
            if (cancelButton != null) {
                cancelButton.setEnabled(true);
            }
            if (deleteButton != null) {
                deleteButton.setEnabled(false);
            }
            enableOrDisableComponenets(otherComponents, true);

        } else if (button == editButton) {
            if (newButton != null) {
                newButton.setEnabled(false);
            }
            if (editButton != null) {
                editButton.setEnabled(false);
            }
            if (saveButton != null) {
                saveButton.setEnabled(true);
            }
            if (cancelButton != null) {
                cancelButton.setEnabled(true);
            }
            if (deleteButton != null) {
                deleteButton.setEnabled(false);
            }
            enableOrDisableComponenets(otherComponents, true);
        } else if (button == saveButton) {
            if (newButton != null) {
                newButton.setEnabled(true);
            }
            if (editButton != null) {
                editButton.setEnabled(true);
            }
            if (saveButton != null) {
                saveButton.setEnabled(false);
            }
            if (cancelButton != null) {
                cancelButton.setEnabled(false);
            }
            if (deleteButton != null) {
                deleteButton.setEnabled(true);
            }
            enableOrDisableComponenets(otherComponents, false);
        } else if (button == cancelButton) {
            if (newButton != null) {
                newButton.setEnabled(true);
            }
            if (editButton != null) {
                editButton.setEnabled(true);
            }
            if (saveButton != null) {
                saveButton.setEnabled(false);
            }
            if (cancelButton != null) {
                cancelButton.setEnabled(false);
            }
            if (deleteButton != null) {
                deleteButton.setEnabled(true);
            }
            enableOrDisableComponenets(otherComponents, false);
        }

    }

    private void enableOrDisableComponenets(Container container, boolean isEnable) {

        Component components[] = container.getComponents();
        for (int i = 0; i < components.length; i++) {
            Component c = components[i];
            if (exclusions == null || !exclusions.contains(c)) {
                if (c instanceof Container &&
                        (c != newButton && c != editButton && c != saveButton &&
                                c != cancelButton && c != deleteButton)) {
                    c.setEnabled(isEnable);

                    enableOrDisableComponenets((Container) c, isEnable);
                }
                if (c != newButton && c != editButton && c != saveButton &&
                        c != cancelButton && c != deleteButton) {
                    c.setEnabled(isEnable);

                }
            }
        }

    }
}
