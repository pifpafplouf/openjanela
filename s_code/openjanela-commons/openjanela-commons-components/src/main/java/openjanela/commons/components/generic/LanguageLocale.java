package openjanela.commons.components.generic;

import java.util.Locale;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 02-27-12
 * Time: 03:51 PM
 * Language Locale default
 */
public class LanguageLocale {

    //Specific LanguageLocale Contry and Language
    private static LanguageLocale instance;

    //Locale especified
    private Locale locale;

    //Constructor
    public LanguageLocale() {
        //TODO: For development process only one lenguage support
        locale = new Locale("en", "US");
    }

    /**
     * Return specific locale config
     *
     * @return Locale
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * Return LanguageLocale instance
     *
     * @return LanguageLocale
     */
    public static final LanguageLocale getInstance() {
        if (instance == null)
            instance = new LanguageLocale();

        return instance;
    }
}
