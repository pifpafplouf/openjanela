package openjanela.model.test;

import openjanela.model.eao.partner.seriesAllowedSUThickEAO.SeriesAllowedSUThickEAO;
import openjanela.model.eao.partner.seriesAllowedSUThickEAO.SeriesAllowedSUThickPersistenceEAO;
import openjanela.model.eao.partner.suTypeEAO.SUTypeEAO;
import openjanela.model.eao.partner.suTypeEAO.SUTypePersistenceEAO;
import org.apache.log4j.Logger;

import org.testng.annotations.Configuration;
import org.testng.annotations.Test;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 09-15-12
 * Time: 04:31 PM
 */
@Test(groups = {"debug"})
public class modelTest2 {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(modelTest2.class);

    private SeriesAllowedSUThickEAO seriesAllowedThickEAO;
    private SUTypeEAO suTypeEAO;

    @Test
    @Configuration(beforeTestClass = true)
    public void setUpClass() throws Throwable {

        //Init EAO Service
        seriesAllowedThickEAO = new SeriesAllowedSUThickPersistenceEAO();
        suTypeEAO = new SUTypePersistenceEAO();
    }

}
