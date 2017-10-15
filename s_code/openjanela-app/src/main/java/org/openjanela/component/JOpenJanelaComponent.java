package org.openjanela.component;

/**
 * Copyright (c) 2013, OpenJanela. All rights reserved.
 * <p/>
 * Interface components for implementing GUI components with architectural representation for design user interfaces.
 * This class is for design representation and any user interface component should extends from this class to implements
 * this methods.
 * <p/>
 * User: Eddy Montenegro
 * Date: 01-22-13
 * Time: 08:41 PM
 */
public interface JOpenJanelaComponent {

    /**
     * This method implements init and configuration for GUI components
     */
    void initComponents();

    /**
     * This method implements init and configuration values for GUI components
     */
    void initValueComponents();

    /**
     * This method implements init and configuration listeners for GUI components
     */
    void initListenersComponents();
}
