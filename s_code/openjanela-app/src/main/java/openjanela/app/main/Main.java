/**
 * Copyright (c) 2012, OpenJanela LLC. All rights reserved.
 */
package openjanela.app.main;

import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.*;

import Presentation.JOpenJanelaItemDesign;
import openjanela.model.PersistenceConfigProperties;
import openjanela.model.entities.design.Metrics;
import openjanela.model.entities.sales.SalesRepsCommission;
import org.apache.log4j.Logger;
import org.openjanela.data.ApplicationInitializeExecutor;
import org.openjanela.data.UserPreferences;

/**
 * The <p>Main</p> class represents the start service main draw openJanela Panel.
 *
 * @author seldibani@openjanela.com
 * @author emontenegro@openjanela.com
 * @since 2.0.8b
 * Date: 02-19-12
 * Time: 10:38 AM
 */
public class Main extends JFrame {

    /**
     * apache log4j *
     */
    private static final Logger logger = Logger.getLogger(Main.class);

    /**
     * User Preferences Initialization
     */
    private final UserPreferences userPreferences = new UserPreferences();

    /**
     * Screen size
     */
    private Dimension screenSize;

    //Main start service
    public static void main(String[] args) {

        Main mainApp = new Main();
        mainApp.intializeApplication();
        mainApp.initializePreferences();
        mainApp.initilize();
    }

    /**
     * Initialize main service and derive configuration main panel
     */
    private void initilize() {

        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension((int) screenSize.getWidth(), (int) (screenSize.getHeight() - 40)));
        this.setPreferredSize(new Dimension((int) screenSize.getWidth(), (int) (screenSize.getHeight() - 40)));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());

        //OpenJanela Logo
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon(getClass().getResource("/openjanela/resources/images/logo.png")));
        logo.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(logo, BorderLayout.CENTER);

        //Init OpenJanela Icon
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/openjanela/resources/images/OJ16x16.png"));
        this.setIconImage(imageIcon.getImage());

        this.setVisible(true);

        //Init OpenJanela Configurator
        new JOpenJanelaItemDesign(this, true, userPreferences);
    }

    /**
     * Init Application Main Base App
     */
    private void intializeApplication() {

        // Init Partner Database Properties
        String dbOpenJanelaPartnerHost = "localhost";
        String dbOpenJanelaPartnerPort = "3306";
        String dbOpenJanelaPartnerLogin = "root";
        String dbOpenJanelaPartnerPass = "root";
        String dbOpenJanelaDatabase = "openjanela";
        String dbOpenJanelaPartnerDatabase = "openjanela_partner_alcor";

        // Init Connection for OpenJanela Configurator Access Database
        PersistenceConfigProperties.getInstance().setTenant_1_server(dbOpenJanelaPartnerHost);
        PersistenceConfigProperties.getInstance().setTenant_1_port(Integer.parseInt(dbOpenJanelaPartnerPort));
        PersistenceConfigProperties.getInstance().setTenant_1_login(dbOpenJanelaPartnerLogin);
        PersistenceConfigProperties.getInstance().setTenant_1_password(dbOpenJanelaPartnerPass);
        PersistenceConfigProperties.getInstance().setTenant_1_schema(dbOpenJanelaDatabase);

        PersistenceConfigProperties.getInstance().setTenant_2_server(dbOpenJanelaPartnerHost);
        PersistenceConfigProperties.getInstance().setTenant_2_port(Integer.parseInt(dbOpenJanelaPartnerPort));
        PersistenceConfigProperties.getInstance().setTenant_2_login(dbOpenJanelaPartnerLogin);
        PersistenceConfigProperties.getInstance().setTenant_2_password(dbOpenJanelaPartnerPass);
        PersistenceConfigProperties.getInstance().setTenant_2_schema(dbOpenJanelaPartnerDatabase);

        // Init Application Service Executor
        ApplicationInitializeExecutor.initializeApplicationService();
    }

    /**
     * Initialize User Preferences for OpenJanela Default Options
     */
    private void initializePreferences() {

        userPreferences.setPartnerID(28);
        userPreferences.setJobType(1);
        userPreferences.setSalesRepID(1000000001);

        //Init Sales Reps Commission
        SalesRepsCommission salesRepsCommission = new SalesRepsCommission();
        salesRepsCommission.setId(1);
        salesRepsCommission.setDescription("Sample");
        salesRepsCommission.setRate(new BigDecimal("0"));
        userPreferences.setSalesRepCommission(salesRepsCommission);

        userPreferences.setUomID(Metrics.IMPERIAL_DECIMAL.getValue());
        userPreferences.setOrderCartID(1000000001);
        userPreferences.setSeriesID(-1);
        userPreferences.setUserID(1000000001);
        userPreferences.setCountry(null);
        userPreferences.setCurrency(null);
        userPreferences.setLocale(new Locale("en", "US"));
        userPreferences.setLanguage(null);
        userPreferences.setNew(true);
        userPreferences.setRound_total(false);
        userPreferences.setRound_price(false);
        userPreferences.setRound_discounted_price(false);
        userPreferences.setView_price(true);
        userPreferences.setView_cost(true);
        userPreferences.setChange_base_price(true);
        userPreferences.setViewBom(true);
        userPreferences.setChange_bom_price(true);
        userPreferences.setChange_discount(true);
        userPreferences.setChange_glass_price(true);
        userPreferences.setChange_option_price(true);
        userPreferences.setDistribMP(false);
        userPreferences.setDistribMPtoIS(false);
        userPreferences.setPartnerDefaults(new ArrayList());
        userPreferences.setCartDefaults(new ArrayList());
        userPreferences.setItemsPanel(null);
        userPreferences.setSupplier(true);
        userPreferences.setCompanyID(-1);
        userPreferences.setDocType(1);

    }
}
