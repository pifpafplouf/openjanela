package openjanela.model.eao.partner.partnerEAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.FlushModeType;
import javax.persistence.Query;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.partner.Partner;

import org.apache.log4j.Logger;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 * 
 * @author Eddy Montenegro
 * @version 2.0.8 Date: 07-25-12 Time: 02:27 PM
 */
public class PartnerPersistenceEAO extends
		GenericPersistenceEAO<Partner, Integer> implements PartnerEAO {

	// Apache log4j
	private static final Logger logger = Logger
			.getLogger(PartnerPersistenceEAO.class);

	// Entity Access Object
	private PartnersEAO partnersEAO;

	/**
	 * Partner Persistence Default Constructor
	 */
	public PartnerPersistenceEAO() {
		this.partnersEAO = new PartnersPersistenceEAO();
	}

	/**
	 * This method init a remote persistence service
	 * 
	 * @param supplierId
	 *            , Supplier Identification Id
	 * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
	 *             , Exception
	 */
	protected void initRemoteService(Integer supplierId)
			throws GenericPersistenceEAOException {

		try {

			// Search supplier remote values
			Partners supplier = partnersEAO.findById(supplierId);

			// Getting persistence service
			em = PersistenceManagementServiceRemoteFactory
					.getEntityManager(supplier);

			// Added to prevent Flushing
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
	 * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
	 *             , Exception
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
	 * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
	 *             , Exception
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
	public List<Partner> findSuppliers() throws GenericPersistenceEAOException {

		try {

			// Init service
			initService();

			// Query String
			String query = "select distinct p from Partner p, PartnerType pt, TypePartner tp where "
					+ "p.id = pt.id.partnerId and pt.id.typePartnerId = tp.id and tp.id = 4 order by p.companyName";

			// Executing query and retrieve collection
			List<Partner> partners = em.createQuery(query).getResultList();

			return partners;

		} finally {
			closeService();
		}
	}

	@Override
	public Partner findParner(int pid) throws GenericPersistenceEAOException {

		try {

			// Init service
			initService();

			// Query String
			String hql = "From Partner p where partnerid= :pid";
			Query query = em.createQuery(hql);

			query.setParameter("pid", pid);

			// Executing query and retrieve collection
			Partner mp = (Partner) query.getSingleResult();

			return mp;

		} finally {
			closeService();
		}
	}

	@Override
	public Partner findRemoteDealerById(int supplierID, int dealerID)
			throws GenericPersistenceEAOException {

		try {

			// Init Remote Service
			initRemoteService(supplierID);

			Partner dealer = (Partner) em
					.createQuery(
							"select p from Partner p where p.id = :dealerID")
					.setParameter("dealerID", dealerID).getSingleResult();

			return dealer;

		} finally {
			closeRemoteService();
		}
	}

	@Override
	public List<Partner> findSuppliersForIds(List<Integer> suppliersId)
			throws GenericPersistenceEAOException {

		try {

			// Init service
			initService();

			StringBuffer query = new StringBuffer();

			if (suppliersId != null && !suppliersId.isEmpty()) {

				query.append("select p from Partner p where p.partnerid in (");

				for (Iterator it = suppliersId.iterator(); it.hasNext();) {
					Integer id = (Integer) it.next();

					if (!it.hasNext()) {
						query.append(id).append(")");
					} else {
						query.append(id).append(",");
					}
				}

				return em.createQuery(query.toString()).getResultList();
			}

			return new ArrayList<Partner>();

		} finally {
			// closeService();
		}
	}

	@Override
	public List<Partner> findProspectsByCampaignId(int campaignId)
			throws GenericPersistenceEAOException {

		List<Partner> partners = null;
		String query = "SELECT p from Partner p, PartnerType pt, TypePartner tp where ";
		query = query
				.concat("p.id = pt.id.partnerId AND pt.id.typePartnerId = tp.id AND tp.id = 1 AND p.campaign = :campaignId ");
		query = query.concat("ORDER BY p.companyName");

		try {
			initService();
			partners = em.createQuery(query)
					.setParameter("campaignId", campaignId).getResultList();
		} finally {
			closeService();
		}

		return partners;
	}

	@Override
	public List<Partner> findCustomersByCampaignId(int campaignId)
			throws GenericPersistenceEAOException {

		List<Partner> partners = null;
		String query = "SELECT p from Partner p, PartnerType pt, TypePartner tp where ";
		query = query
				.concat("p.id = pt.id.partnerId AND pt.id.typePartnerId = tp.id AND tp.id = 2 AND p.campaign = :campaignId ");
		query = query.concat("ORDER BY p.companyName");

		try {
			initService();
			partners = em.createQuery(query)
					.setParameter("campaignId", campaignId).getResultList();
		} finally {
			closeService();
		}

		return partners;
	}

	@Override
	public List<Partner> findByType(Connection connection, int type) {

		List<Partner> partners = new ArrayList<Partner>();

		String pselect = "SELECT p.* FROM partner p LEFT JOIN type_partner tp "
				+ "ON p.partnertype = tp.id "
				+ "WHERE  tp.system_partner_type = " + type
				+ " order by p.companyName";

		try {
			// stmt stmt = new stmt(customerSelect);
			PreparedStatement stmt = connection.prepareStatement(pselect);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Partner partner = new Partner();

				setPartner(rs, partner);
				partners.add(partner);

			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return partners;

	}

	public Partner setPartner(ResultSet rs, Partner partner)
			throws SQLException {

		partner.setId(rs.getInt(1));
		partner.setPartnerid(rs.getInt(2));
		partner.setStatus(rs.getInt(3));
		partner.setCompanyName(rs.getString(4));
		partner.setAccountNo(rs.getInt(5));
		partner.setAltAccountNo(rs.getString(6));
		partner.setEmail(rs.getString(7));
		partner.setWebsite(rs.getString(8));
		partner.setPhone(rs.getString(9));
		partner.setFax(rs.getString(10));
		partner.setCountry(rs.getString(11));
		partner.setNotes(rs.getString(12));
		partner.setPaymentId(rs.getInt(13));
		partner.setSalesRepId(rs.getInt(14));
		partner.setTaxId(rs.getInt(15));
		partner.setTax2Id(rs.getInt(16));
		partner.setTax2Compound(rs.getBoolean(17));
		partner.setTax3Id(rs.getInt(18));
		partner.setTax3Compound(rs.getBoolean(19));
		partner.setDiscount(rs.getDouble(20));
		partner.setDisplayContact(rs.getString(21));
		partner.setJobTypeId(rs.getInt(22));
		partner.setCreditLimit(rs.getBigDecimal(23));
		partner.setAvailCredit(rs.getBigDecimal(24));
		partner.setCurrency(rs.getString(25));
		partner.setLeadTime(rs.getInt(26));
		partner.setCutoff(rs.getInt(27));
		partner.setGroupId(rs.getInt(28));
		partner.setFactor(rs.getBoolean(29));
		partner.setMeasure(rs.getInt(30));
		partner.setPartnerType(rs.getInt(31));
		partner.setExpenseAccount(rs.getString(32));
		partner.setTax_ID(rs.getString(33));
		partner.setAccountExtra1(rs.getString(34));
		partner.setAccountExtra2(rs.getString(35));
		partner.setActive(rs.getBoolean(36));
		partner.setDateCreated(rs.getDate(37));
		partner.setPartnerSince(rs.getDate(38));
		partner.setCampaign(rs.getInt(39));
		partner.setOem(rs.getBoolean(40));
		partner.setLogo(rs.getBytes(41));
		partner.setLogoName(rs.getString(42));
		partner.setBuilder(rs.getBoolean(43));
		partner.setEdi(rs.getBoolean(44));
		partner.setEdi_confirm(rs.getBoolean(45));
		partner.setReferringId(rs.getInt(46));
		partner.setListId(rs.getInt(47));

		return partner;
	}

	@Override
	public List<Partner> findByList(int list)
			throws GenericPersistenceEAOException {
		List<Partner> partners = null;
		String query = "SELECT p from Partner p where p.list_id = :listID ORDER BY p.companyName";

		try {
			initService();
			partners = em.createQuery(query).setParameter("listID", list)
					.getResultList();
		} finally {
			closeService();
		}

		return partners;
	}

	@Override
	public List<Partner> findByReferring(int ref)
			throws GenericPersistenceEAOException {
		List<Partner> partners = null;
		String query = "SELECT p from Partner p where p.referring_id = :ref ORDER BY p.companyName";

		try {
			initService();
			partners = em.createQuery(query).setParameter("ref", ref)
					.getResultList();
		} finally {
			closeService();
		}

		return partners;
	}

	@Override
	public List<Partner> findByCampaign(int camp)
			throws GenericPersistenceEAOException {
		List<Partner> partners = null;
		String query = "SELECT p from Partner p where p.campaign = :camP ORDER BY p.companyName";

		try {
			initService();
			partners = em.createQuery(query).setParameter("camP", camp)
					.getResultList();
		} finally {
			closeService();
		}

		return partners;
	}

	@Override
	public List<Partner> findByInquiryType(int type)
			throws GenericPersistenceEAOException {
		List<Partner> partners = null;
		String query = "SELECT p from Partner p where p.inquiryType = :type ORDER BY p.companyName";

		try {
			initService();
			partners = em.createQuery(query).setParameter("type", type)
					.getResultList();
		} finally {
			closeService();
		}

		return partners;
	}

}
