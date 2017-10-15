package openjanela.model.eao.production.productionLineStationEAO;

import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.production.ProductionLineStation;
import openjanela.model.entities.production.ProductionLineStationPK;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

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
 * @version 2.0.8
 *          Date: 06-04-13
 *          Time: 09:20 PM
 */
public class ProductionLineStationPersistenceEAO extends GenericPersistenceEAO<ProductionLineStation, ProductionLineStationPK>
        implements ProductionLineStationEAO {

    @Override
    public List<ProductionLineStation> findByProductionLine(Integer productionLineId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            List<ProductionLineStation> productionLineStations = em.createQuery("select p from ProductionLineStation p " +
                    "where p.id.prodlineid = :productionLineId  order by p.id.stationid").
                    setParameter("productionLineId", productionLineId).getResultList();

            return productionLineStations;

        } finally {
            closeService();
        }
    }

    @Override
    public List<ProductionLineStation> findByProductionLine(String productionLineIds) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final String p_prod_line_ids = productionLineIds;

            final List<ProductionLineStation> prodLineStations = new ArrayList<ProductionLineStation>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select p.* from production_line_station p where p.prodlineid in (").append(p_prod_line_ids).
                            append(") order by p.prodlineid");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        ProductionLineStationPK prodLineStationPK = new ProductionLineStationPK();
                        prodLineStationPK.setProdlineid(rs.getInt("prodlineid"));
                        prodLineStationPK.setStationid(rs.getInt("stationid"));

                        ProductionLineStation prodLineStation = new ProductionLineStation();
                        prodLineStation.setId(prodLineStationPK);
                        prodLineStation.setSequence(rs.getInt("sequence"));
                        prodLineStation.setAvgwait(rs.getDouble("avgwait"));

                        prodLineStations.add(prodLineStation);
                    }

                    rs.close();
                    pstmt.close();
                }
            });

            return prodLineStations;

        } finally {
            closeService();
        }
    }
}
