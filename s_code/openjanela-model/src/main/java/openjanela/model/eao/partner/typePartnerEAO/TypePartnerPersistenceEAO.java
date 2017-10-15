package openjanela.model.eao.partner.typePartnerEAO;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.partner.TypePartner;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import javax.persistence.FlushModeType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 * 
 * @author Eddy Montenegro
 * @version 2.0.8 Date: 07-25-12 Time: 02:28 PM
 */
public class TypePartnerPersistenceEAO extends
		GenericPersistenceEAO<TypePartner, Integer> implements TypePartnerEAO {

	// Apache log4j
	private static final Logger logger = Logger
			.getLogger(TypePartnerPersistenceEAO.class);

	// Entity Access Object
	private PartnersEAO partnersEAO;

	/**
	 * Rules Persistence Default Constructor
	 */
	public TypePartnerPersistenceEAO() {
		partnersEAO = new PartnersPersistenceEAO();
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

	@Override
	public List<TypePartner> findBySystemType(Integer type)
			throws GenericPersistenceEAOException {

		try {

			// Init service
			initService();

			// String query builder
			StringBuffer query = new StringBuffer();

			TypePartner tp = new TypePartner();
			List<TypePartner> pTypes = new ArrayList<TypePartner>();

			query.append("select t from TypePartner t where t.systemPartnerType = :ptype order by t.id");
			pTypes = em.createQuery(query.toString())
					.setParameter("ptype", type).getResultList();

			return pTypes;

		} finally {
			closeService();
		}
	}
	
	@Override
	public List<TypePartner> findProspects() throws GenericPersistenceEAOException {

		try {

			// Init service
			initService();

			// String query builder
			StringBuffer query = new StringBuffer();

			TypePartner tp = new TypePartner();
			List<TypePartner> pTypes = new ArrayList<TypePartner>();

			query.append("select t from TypePartner t where t.prospect = 1 order by t.id");
			pTypes = em.createQuery(query.toString()).getResultList();

			return pTypes;

		} finally {
			closeService();
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
	public int getRemoteAllowedCancellationPeriod(Integer supplierId,
			Integer partnerId) throws Exception {

		try {

			// Init Remote Service
			initRemoteService(supplierId);

			final int param_partner_id = partnerId;
			final int[] _allowed_cancel_period = new int[1];

			Session session = em.unwrap(Session.class);
			session.doWork(new Work() {
				@Override
				public void execute(Connection connection) throws SQLException {

					StringBuffer query = new StringBuffer();
					query.append("select tp.* ");
					query.append("from type_partner tp inner join partner_type pt on tp.id = pt.type_id ");
					query.append("where pt.partner_id = ?");

					PreparedStatement pstmt = connection.prepareStatement(query
							.toString());
					pstmt.setInt(1, param_partner_id);

					ResultSet rs = pstmt.executeQuery();

					_allowed_cancel_period[0] = 0;

					while (rs.next()) {
						int cancellation_period = rs
								.getInt("allowed_cancellation_period");
						if (_allowed_cancel_period[0] < cancellation_period) {
							_allowed_cancel_period[0] = cancellation_period;
						}
					}

					pstmt.close();
					rs.close();

				}
			});

			return _allowed_cancel_period[0];

		} finally {
			closeRemoteService();
		}
	}
}
