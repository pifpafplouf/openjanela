package openjanela.commons.components.generic;

import org.apache.log4j.Logger;

import javax.swing.*;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * <p/>
 * This class represents the generic style components for main panel window openJanela draw canvas.
 * <p/>
 * User: EMontenegro
 * Date: 02-22-12
 * Time: 11:26 PM
 */
public abstract class GenericStyle extends JPanel {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(GenericStyle.class);

    //Message Resource Bundle
    private static final ResourceBundle messageBundle = ResourceBundle.getBundle("openjanela/resources/messages/Menssages",
            LanguageLocale.getInstance().getLocale());

    //PROPERTY NAME: Main generic frame
    private GenericFrame genericFrame;

    //PROPERTY NAME: Icon files map
    private Map<String, ImageIcon> imageIconMap;

    /**
     * Creating Generic Style
     *
     * @param frame, GenericFrame
     */
    public GenericStyle(GenericFrame frame) {

        //Setting parent main frame
        this.genericFrame = frame;

        //Loading icon resources
        imageIconMap = IconResources.loadImageIconMap();

        //Initialize generic style
        initialize();
    }

    /**
     * Return generic panel frame
     *
     * @return GenericFrame
     */
    public GenericFrame getGenericFrame() {
        return genericFrame;
    }

    /**
     * Return ImageIcon from resource key
     *
     * @param key, String
     * @return ImageIcon
     */
    public ImageIcon getImageIcon(String key) {
        return imageIconMap.get(key);
    }

    /**
     * Return message resource bundle
     * @param key, String
     * @return String
     */
    public String getMessageResource(String key) {
        return messageBundle.getString(key);
    }

    /**
     * Initialize Generic Style
     */
    public abstract void initialize();
}
