package Presentation;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif El Dibani
 * @version 2.0.8b
 *          Date: 02-26-13
 *          Time: 10:42 AM
 */
public class OptionChoiceColumns {

    public String m_title;

    public int m_width;

    public int m_alignment;

    /**
     * Options Choice Columns
     *
     * @param title,     Column Title
     * @param width,     Width
     * @param alignment, Alignment
     */
    public OptionChoiceColumns(String title, int width, int alignment) {
        m_title = title;
        m_width = width;
        m_alignment = alignment;
    }

    public String getM_title() {
        return m_title;
    }

    public void setM_title(String m_title) {
        this.m_title = m_title;
    }

    public int getM_width() {
        return m_width;
    }

    public void setM_width(int m_width) {
        this.m_width = m_width;
    }

    public int getM_alignment() {
        return m_alignment;
    }

    public void setM_alignment(int m_alignment) {
        this.m_alignment = m_alignment;
    }
}
