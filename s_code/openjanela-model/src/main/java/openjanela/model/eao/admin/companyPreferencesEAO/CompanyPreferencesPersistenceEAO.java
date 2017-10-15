package openjanela.model.eao.admin.companyPreferencesEAO;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.CompanyPreferences;
import openjanela.model.entities.admin.Partners;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import javax.persistence.FlushModeType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 07-30-12
 * Time: 10:28 PM
 */
public class CompanyPreferencesPersistenceEAO extends GenericPersistenceEAO<CompanyPreferences, Integer>
        implements CompanyPreferencesEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(CompanyPreferencesPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Rules Persistence Default Constructor
     */
    public CompanyPreferencesPersistenceEAO () {
        partnersEAO = new PartnersPersistenceEAO();
    }

    /**
     * This method init a remote persistence service
     *
     * @param supplierId, Supplier Identification Id
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    protected void initRemoteService(Integer supplierId) throws GenericPersistenceEAOException {


        try {

            //Search supplier remote values
            Partners supplier = partnersEAO.findById(supplierId);

            //Getting persistence service
            em = PersistenceManagementServiceRemoteFactory.getEntityManager(supplier);

            //Added to prevent Flushing
            em.setFlushMode(FlushModeType.AUTO);

            PersistenceManagementServiceRemoteFactory.beginTransaction();

        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }

    }

    /**
     * This method commit a remote persistence service
     *
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    protected void commitRemoteService() throws GenericPersistenceEAOException {
        try {
            PersistenceManagementServiceRemoteFactory.commit(true);
        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }

    /**
     * This method close a remote session service from entity access object
     *
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    protected void closeRemoteService() throws GenericPersistenceEAOException {
        try {
            PersistenceManagementServiceRemoteFactory.close();
        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }

    @Override
    public CompanyPreferences getPref() throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            List<CompanyPreferences> companyPreferences = em.createQuery("select c from CompanyPreferences c").
                    getResultList();

            if (companyPreferences != null && companyPreferences.size() > 0) {
                return companyPreferences.get(0);
            }

            return null;

        } finally {
            closeService();
        }
    }

    @Override
    public int getNextOrderNumberRemote(Integer supplierId, Integer docType) throws GenericPersistenceEAOException {

        try {

            //Init service
            initRemoteService(supplierId);

            final int param_doctype = docType;
            final int[] order_no = new int[1];

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    //Return Next Order Number
                    StringBuffer query = new StringBuffer();
                    query.append("select c.* from company_preferences c ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());

                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {

                        if (param_doctype == 1) {
                            order_no[0] = rs.getInt("nextquote");
                        } else if (param_doctype == 3 || param_doctype == 2) {
                            order_no[0] = rs.getInt("nextorder");
                        } else if (param_doctype == 4) {
                            order_no[0] = rs.getInt("nexttemplate");
                        }
                    }

                    //Update Company Preferences number
                    query = new StringBuffer();

                    if (param_doctype == 1) {
                        query.append("update company_preferences c set c.nextquote = ? ");
                    } else if (param_doctype == 3 || param_doctype == 2) {
                        query.append("update company_preferences c set c.nextorder = ? ");
                    } else if (param_doctype == 4) {
                        query.append("update company_preferences c set c.nexttemplate = ? ");
                    }

                    pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, order_no[0] + 1);

                    pstmt.executeUpdate();

                    rs.close();
                    pstmt.close();

                }
            });

            return order_no[0];

        } finally {
            closeRemoteService();
        }
    }

}
