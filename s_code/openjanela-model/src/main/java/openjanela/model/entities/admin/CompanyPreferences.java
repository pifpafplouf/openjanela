package openjanela.model.entities.admin;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif ElDibani
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 1/11/14
 *          Time: 8:08 PM
 */
@Entity
@Table(name = "company_preferences")
@Cacheable
public class CompanyPreferences implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
	private Integer id;

    @Column(name = "nextquote", nullable = true)
	private Integer nextquote;

    @Column(name = "nextorder", nullable = true)
	private Integer nextorder;

    @Column(name = "nexttemplate", nullable = true)
	private Integer nexttemplate;

    @Column(name = "nextinvoice", nullable = true)
	private Integer nextinvoice;

    @Column(name = "nextship", nullable = false)
	private Integer nextship;

    @Column(name = "nextcredit", nullable = true)
	private Integer nextcredit;

    @Column(name = "usecreditcheck", nullable = true)
	private boolean usecreditcheck;

    @Column(name = "onhold", nullable = true)
	private Integer onhold;

    @Column(name = "confirmed", nullable = true)
	private Integer confirmed;

    @Column(name = "ordered", nullable = true)
	private Integer ordered;

    @Column(name = "purchasing", nullable = true)
	private Integer purchasing;

    @Column(name = "productionready", nullable = true)
	private Integer productionready;

    @Column(name = "production", nullable = true)
	private Integer production;

    @Column(name = "productionbo", nullable = true)
	private Integer productionbo;

    @Column(name = "ship", nullable = true)
	private Integer ship;

    @Column(name = "shipbo", nullable = true)
	private Integer shipbo;

    @Column(name = "shipped", nullable = true)
	private Integer shipped;

    @Column(name = "partialinvoice", nullable = true)
	private Integer partialinvoice;

    @Column(name = "invoiced", nullable = true)
	private Integer invoiced;

    @Column(name = "complete", nullable = true)
	private Integer complete;

    @Column(name = "nextproject", nullable = true)
	private Integer nextproject;

    @Column(name = "application", nullable = true)
	private String application;

    @Column(name = "exportprefix", nullable = true)
	private String exportprefix;

    @Column(name = "quote", nullable = false)
	private int quote;

    @Column(name = "credithold", nullable = false)
	private int credithold;

    @Column(name = "readytoprocess", nullable = false)
	private int readytoprocess;

    @Column(name = "canceled", nullable = false)
	private int canceled;

    @Column(name = "invoicebeforeship", nullable = false)
	private boolean invoicebeforeship;

    @Column(name = "home_currency", nullable = false)
	private Integer homeCurrency;

    @Column(name = "autoaccount", nullable = false)
	private boolean autoaccount;

    @Column(name = "startaccountno", nullable = false)
	private Integer startaccountno;

    @Column(name = "country", nullable = false)
	private String country;

    @Column(name = "currency", nullable = false)
	private String currency;

    @Column(name = "language", nullable = false)
	private String language;

    @Column(name = "customer_currency", nullable = false)
	private boolean customerCurrency;

    @Column(name = "default_uom", nullable = false)
	private Integer defaultUom;

    @Column(name = "separate_quotes", nullable = false)
	private boolean separateQuotes;

    @Column(name = "year_start_month", nullable = false)
	private Integer yearStartMonth;

    @Column(name = "roundprice", nullable = false)
	private boolean roundprice;

    @Column(name = "roundtotal", nullable = false)
	private boolean roundtotal;

    @Column(name = "rounddiscountedprice", nullable = false)
	private boolean rounddiscountedprice;

    @Column(name = "defaultseries", nullable = false)
	private Integer defaultseries;

    @Column(name = "printinvoice", nullable = false)
	private boolean printinvoices = true;

    @Column(name = "defaultlt", nullable = false)
	private int defaultLt = 0;

    @Column(name = "defaultcutoff", nullable = false)
	private int defaultCutOff = 0;

    @Column(name = "verifyzip", nullable = false)
	private boolean verifyZip = false;

    @Column(name = "distribute_manual_price", nullable = false)
	private boolean distribManualPrice = true;

    @Column(name = "distribute_to_inst_ship", nullable = false)
	private boolean distribToInstallShi = false;

    @Column(name = "defaultLeadTime", nullable = false)
    private int defaultLeadTime = 0;

    @Column(name = "printinvoices", nullable = false)
    private boolean printInvoices = false;

    @Column(name = "smtp_server", nullable = true)
    private String smtpServer = "";

    @Column(name = "smtp_port", nullable = false)
    private int smtpPort = 0;

    @Column(name = "pop_server", nullable = false)
    private String popServer = "";

    @Column(name = "pop_port", nullable = false)
    private int popPort = 0;

    @Column(name = "smtp_username", nullable = false)
    private String smtpUsername = "";

    @Column(name = "smtp_password", nullable = false)
    private String smtpPassword = "";

    @Column(name = "smtp_ssl", nullable = false)
    private boolean smtpssl = false;

    @Column(name = "default_credit_limit", nullable = false)
    private double defaultCreditLimit = 0;

    @Column(name = "qc_receipts", nullable = false)
    private boolean qcReceipts = false;

    @Column(name = "rec_into_inv", nullable = false)
    private boolean receivedIntoInventory = false;

    @Column(name = "active_reminder", nullable = false)
    private boolean activeReminder = false;

    @Column(name = "stock_forecast_margin", nullable = false)
    private double stockForecastMargin = 0;

    @Column(name = "autowh", nullable = false)
    private boolean verifyOverallWh;

    //*****************************************<Getters & Setters>******************************************************

    public CompanyPreferences() {}

    public CompanyPreferences(Integer id, Integer nextquote, Integer nextorder, Integer nexttemplate, Integer nextinvoice,
                              Integer nextship, Integer nextcredit, boolean usecreditcheck, Integer onhold, Integer confirmed,
                              Integer ordered, Integer purchasing, Integer productionready, Integer production, Integer productionbo,
                              Integer ship, Integer shipbo, Integer shipped, Integer partialinvoice, Integer invoiced, Integer complete,
                              Integer nextproject, String application, String exportprefix, int quote, int credithold, int readytoprocess,
                              int canceled, boolean invoicebeforeship, Integer homeCurrency, boolean autoaccount, Integer startaccountno,
                              String country, String currency, String language, boolean customerCurrency, Integer defaultUom,
                              boolean separateQuotes, Integer yearStartMonth, boolean roundprice, boolean roundtotal,
                              boolean rounddiscountedprice, Integer defaultseries, boolean printinvoices, int defaultLt,
                              int defaultCutOff, boolean verifyZip, boolean distribManualPrice, boolean distribToInstallShi,
                              int defaultLeadTime, boolean printInvoices, String smtpServer, int smtpPort, String popServer,
                              int popPort, String smtpUsername, String smtpPassword, boolean smtpssl, double defaultCreditLimit,
                              boolean qcReceipts, boolean receivedIntoInventory, boolean activeReminder, double stockForecastMargin,
                              boolean verifyOverallWh) {
        this.id = id;
        this.nextquote = nextquote;
        this.nextorder = nextorder;
        this.nexttemplate = nexttemplate;
        this.nextinvoice = nextinvoice;
        this.nextship = nextship;
        this.nextcredit = nextcredit;
        this.usecreditcheck = usecreditcheck;
        this.onhold = onhold;
        this.confirmed = confirmed;
        this.ordered = ordered;
        this.purchasing = purchasing;
        this.productionready = productionready;
        this.production = production;
        this.productionbo = productionbo;
        this.ship = ship;
        this.shipbo = shipbo;
        this.shipped = shipped;
        this.partialinvoice = partialinvoice;
        this.invoiced = invoiced;
        this.complete = complete;
        this.nextproject = nextproject;
        this.application = application;
        this.exportprefix = exportprefix;
        this.quote = quote;
        this.credithold = credithold;
        this.readytoprocess = readytoprocess;
        this.canceled = canceled;
        this.invoicebeforeship = invoicebeforeship;
        this.homeCurrency = homeCurrency;
        this.autoaccount = autoaccount;
        this.startaccountno = startaccountno;
        this.country = country;
        this.currency = currency;
        this.language = language;
        this.customerCurrency = customerCurrency;
        this.defaultUom = defaultUom;
        this.separateQuotes = separateQuotes;
        this.yearStartMonth = yearStartMonth;
        this.roundprice = roundprice;
        this.roundtotal = roundtotal;
        this.rounddiscountedprice = rounddiscountedprice;
        this.defaultseries = defaultseries;
        this.printinvoices = printinvoices;
        this.defaultLt = defaultLt;
        this.defaultCutOff = defaultCutOff;
        this.verifyZip = verifyZip;
        this.distribManualPrice = distribManualPrice;
        this.distribToInstallShi = distribToInstallShi;
        this.defaultLeadTime = defaultLeadTime;
        this.printInvoices = printInvoices;
        this.smtpServer = smtpServer;
        this.smtpPort = smtpPort;
        this.popServer = popServer;
        this.popPort = popPort;
        this.smtpUsername = smtpUsername;
        this.smtpPassword = smtpPassword;
        this.smtpssl = smtpssl;
        this.defaultCreditLimit = defaultCreditLimit;
        this.qcReceipts = qcReceipts;
        this.receivedIntoInventory = receivedIntoInventory;
        this.activeReminder = activeReminder;
        this.stockForecastMargin = stockForecastMargin;
        this.verifyOverallWh = verifyOverallWh;
    }


    //*****************************************<Getters & Setters>******************************************************

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNextquote() {
        return nextquote;
    }

    public void setNextquote(Integer nextquote) {
        this.nextquote = nextquote;
    }

    public Integer getNextorder() {
        return nextorder;
    }

    public void setNextorder(Integer nextorder) {
        this.nextorder = nextorder;
    }

    public Integer getNexttemplate() {
        return nexttemplate;
    }

    public void setNexttemplate(Integer nexttemplate) {
        this.nexttemplate = nexttemplate;
    }

    public Integer getNextinvoice() {
        return nextinvoice;
    }

    public void setNextinvoice(Integer nextinvoice) {
        this.nextinvoice = nextinvoice;
    }

    public Integer getNextship() {
        return nextship;
    }

    public void setNextship(Integer nextship) {
        this.nextship = nextship;
    }

    public Integer getNextcredit() {
        return nextcredit;
    }

    public void setNextcredit(Integer nextcredit) {
        this.nextcredit = nextcredit;
    }

    public boolean isUsecreditcheck() {
        return usecreditcheck;
    }

    public void setUsecreditcheck(boolean usecreditcheck) {
        this.usecreditcheck = usecreditcheck;
    }

    public Integer getOnhold() {
        return onhold;
    }

    public void setOnhold(Integer onhold) {
        this.onhold = onhold;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public Integer getPurchasing() {
        return purchasing;
    }

    public void setPurchasing(Integer purchasing) {
        this.purchasing = purchasing;
    }

    public Integer getProductionready() {
        return productionready;
    }

    public void setProductionready(Integer productionready) {
        this.productionready = productionready;
    }

    public Integer getProduction() {
        return production;
    }

    public void setProduction(Integer production) {
        this.production = production;
    }

    public Integer getProductionbo() {
        return productionbo;
    }

    public void setProductionbo(Integer productionbo) {
        this.productionbo = productionbo;
    }

    public Integer getShip() {
        return ship;
    }

    public void setShip(Integer ship) {
        this.ship = ship;
    }

    public Integer getShipbo() {
        return shipbo;
    }

    public void setShipbo(Integer shipbo) {
        this.shipbo = shipbo;
    }

    public Integer getShipped() {
        return shipped;
    }

    public void setShipped(Integer shipped) {
        this.shipped = shipped;
    }

    public Integer getPartialinvoice() {
        return partialinvoice;
    }

    public void setPartialinvoice(Integer partialinvoice) {
        this.partialinvoice = partialinvoice;
    }

    public Integer getInvoiced() {
        return invoiced;
    }

    public void setInvoiced(Integer invoiced) {
        this.invoiced = invoiced;
    }

    public Integer getComplete() {
        return complete;
    }

    public void setComplete(Integer complete) {
        this.complete = complete;
    }

    public Integer getNextproject() {
        return nextproject;
    }

    public void setNextproject(Integer nextproject) {
        this.nextproject = nextproject;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getExportprefix() {
        return exportprefix;
    }

    public void setExportprefix(String exportprefix) {
        this.exportprefix = exportprefix;
    }

    public int getQuote() {
        return quote;
    }

    public void setQuote(int quote) {
        this.quote = quote;
    }

    public int getCredithold() {
        return credithold;
    }

    public void setCredithold(int credithold) {
        this.credithold = credithold;
    }

    public int getReadytoprocess() {
        return readytoprocess;
    }

    public void setReadytoprocess(int readytoprocess) {
        this.readytoprocess = readytoprocess;
    }

    public int getCanceled() {
        return canceled;
    }

    public void setCanceled(int canceled) {
        this.canceled = canceled;
    }

    public boolean isInvoicebeforeship() {
        return invoicebeforeship;
    }

    public void setInvoicebeforeship(boolean invoicebeforeship) {
        this.invoicebeforeship = invoicebeforeship;
    }

    public Integer getHomeCurrency() {
        return homeCurrency;
    }

    public void setHomeCurrency(Integer homeCurrency) {
        this.homeCurrency = homeCurrency;
    }

    public boolean isAutoaccount() {
        return autoaccount;
    }

    public void setAutoaccount(boolean autoaccount) {
        this.autoaccount = autoaccount;
    }

    public Integer getStartaccountno() {
        return startaccountno;
    }

    public void setStartaccountno(Integer startaccountno) {
        this.startaccountno = startaccountno;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isCustomerCurrency() {
        return customerCurrency;
    }

    public void setCustomerCurrency(boolean customerCurrency) {
        this.customerCurrency = customerCurrency;
    }

    public Integer getDefaultUom() {
        return defaultUom;
    }

    public void setDefaultUom(Integer defaultUom) {
        this.defaultUom = defaultUom;
    }

    public boolean isSeparateQuotes() {
        return separateQuotes;
    }

    public void setSeparateQuotes(boolean separateQuotes) {
        this.separateQuotes = separateQuotes;
    }

    public Integer getYearStartMonth() {
        return yearStartMonth;
    }

    public void setYearStartMonth(Integer yearStartMonth) {
        this.yearStartMonth = yearStartMonth;
    }

    public boolean isRoundprice() {
        return roundprice;
    }

    public void setRoundprice(boolean roundprice) {
        this.roundprice = roundprice;
    }

    public boolean isRoundtotal() {
        return roundtotal;
    }

    public void setRoundtotal(boolean roundtotal) {
        this.roundtotal = roundtotal;
    }

    public boolean isRounddiscountedprice() {
        return rounddiscountedprice;
    }

    public void setRounddiscountedprice(boolean rounddiscountedprice) {
        this.rounddiscountedprice = rounddiscountedprice;
    }

    public Integer getDefaultseries() {
        return defaultseries;
    }

    public void setDefaultseries(Integer defaultseries) {
        this.defaultseries = defaultseries;
    }

    public boolean isPrintinvoices() {
        return printinvoices;
    }

    public void setPrintinvoices(boolean printinvoices) {
        this.printinvoices = printinvoices;
    }

    public int getDefaultLt() {
        return defaultLt;
    }

    public void setDefaultLt(int defaultLt) {
        this.defaultLt = defaultLt;
    }

    public int getDefaultCutOff() {
        return defaultCutOff;
    }

    public void setDefaultCutOff(int defaultCutOff) {
        this.defaultCutOff = defaultCutOff;
    }

    public boolean isVerifyZip() {
        return verifyZip;
    }

    public void setVerifyZip(boolean verifyZip) {
        this.verifyZip = verifyZip;
    }

    public boolean isDistribManualPrice() {
        return distribManualPrice;
    }

    public void setDistribManualPrice(boolean distribManualPrice) {
        this.distribManualPrice = distribManualPrice;
    }

    public boolean isDistribToInstallShi() {
        return distribToInstallShi;
    }

    public void setDistribToInstallShi(boolean distribToInstallShi) {
        this.distribToInstallShi = distribToInstallShi;
    }

    public int getDefaultLeadTime() {
        return defaultLeadTime;
    }

    public void setDefaultLeadTime(int defaultLeadTime) {
        this.defaultLeadTime = defaultLeadTime;
    }

    public boolean isPrintInvoices() {
        return printInvoices;
    }

    public void setPrintInvoices(boolean printInvoices) {
        this.printInvoices = printInvoices;
    }

    public String getSmtpServer() {
        return smtpServer;
    }

    public void setSmtpServer(String smtpServer) {
        this.smtpServer = smtpServer;
    }

    public int getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(int smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getPopServer() {
        return popServer;
    }

    public void setPopServer(String popServer) {
        this.popServer = popServer;
    }

    public int getPopPort() {
        return popPort;
    }

    public void setPopPort(int popPort) {
        this.popPort = popPort;
    }

    public String getSmtpUsername() {
        return smtpUsername;
    }

    public void setSmtpUsername(String smtpUsername) {
        this.smtpUsername = smtpUsername;
    }

    public String getSmtpPassword() {
        return smtpPassword;
    }

    public void setSmtpPassword(String smtpPassword) {
        this.smtpPassword = smtpPassword;
    }

    public boolean isSmtpssl() {
        return smtpssl;
    }

    public void setSmtpssl(boolean smtpssl) {
        this.smtpssl = smtpssl;
    }

    public double getDefaultCreditLimit() {
        return defaultCreditLimit;
    }

    public void setDefaultCreditLimit(double defaultCreditLimit) {
        this.defaultCreditLimit = defaultCreditLimit;
    }

    public boolean isQcReceipts() {
        return qcReceipts;
    }

    public void setQcReceipts(boolean qcReceipts) {
        this.qcReceipts = qcReceipts;
    }

    public boolean isReceivedIntoInventory() {
        return receivedIntoInventory;
    }

    public void setReceivedIntoInventory(boolean receivedIntoInventory) {
        this.receivedIntoInventory = receivedIntoInventory;
    }

    public boolean isActiveReminder() {
        return activeReminder;
    }

    public void setActiveReminder(boolean activeReminder) {
        this.activeReminder = activeReminder;
    }

    public double getStockForecastMargin() {
        return stockForecastMargin;
    }

    public void setStockForecastMargin(double stockForecastMargin) {
        this.stockForecastMargin = stockForecastMargin;
    }

    public boolean isVerifyOverallWh() {
        return verifyOverallWh;
    }

    public void setVerifyOverallWh(boolean verifyOverallWh) {
        this.verifyOverallWh = verifyOverallWh;
    }
}
