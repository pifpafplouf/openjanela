package openjanela.model.test;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.partner.partnerEAO.PartnerEAO;
import openjanela.model.eao.partner.partnerEAO.PartnerPersistenceEAO;
import openjanela.model.eao.partner.typePartnerEAO.TypePartnerEAO;
import openjanela.model.eao.partner.typePartnerEAO.TypePartnerPersistenceEAO;
import openjanela.model.entities.partner.Partner;
import openjanela.model.entities.partner.TypePartner;
import org.apache.log4j.Logger;

import org.testng.annotations.Configuration;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 03-22-12
 * Time: 10:51 PM
 */
@Test(groups = {"debug"})
public class modelTest1 {

    //Logger
    private static final Logger logger = Logger.getLogger(modelTest1.class);

    @Test
    @Configuration(beforeTestClass = true)
    public void setUpClass() throws Throwable {
    }

    @Test(enabled = false)
    public void findPartner() throws PersistenceManagementServiceFactoryException {
        
        try {
            
            System.out.println("Find Partner");

            PartnerEAO partnerEAO = new PartnerPersistenceEAO();
            
            //Find all partner
            List<Partner> partners = partnerEAO.findSuppliers();
            
            for (Partner partner : partners) {
                System.out.println("Company name: " + partner.getCompanyName());
            }
        
        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new PersistenceManagementServiceFactoryException(e.getMessage(), e);
        }
    }
    
    @Test(enabled = false)
    public void findTypePartner() throws PersistenceManagementServiceFactoryException {
        
        try {
            
            System.out.println("Find Type Partner");

            TypePartnerEAO typePartnerEAO = new TypePartnerPersistenceEAO();
            
            //Find all type partner
            List<TypePartner> typePartners = typePartnerEAO.findAll();
            
            for (TypePartner typePartner : typePartners) {
                System.out.println("Type Partner name: " + typePartner.getDescription());   
            }
            
        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new PersistenceManagementServiceFactoryException(e.getMessage(), e);
        }
    }
}
