package openjanela.model.eao.production.productionStationsEAO;

import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.production.ProductionStations;
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
 *          Date: 05-27-13
 *          Time: 06:50 PM
 */
public class ProductionStationsPersistenceEAO extends GenericPersistenceEAO<ProductionStations, Integer> implements
        ProductionStationsEAO {

    @Override
    public List<ProductionStations> findAllOrderById() throws GenericPersistenceEAOException {
        try {

            //Init service
            initService();

            final List<ProductionStations> productionStations = new ArrayList<ProductionStations>();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer("select ps.* from production_stations ps order by ps.id");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        ProductionStations prodStation = new ProductionStations();
                        prodStation.setId(rs.getInt("id"));
                        prodStation.setDescription(rs.getString("description"));
                        prodStation.setBottleneck(rs.getBoolean("bottleneck"));
                        prodStation.setPaperless(rs.getBoolean("paperless"));
                        prodStation.setViewid(rs.getInt("viewid"));
                        prodStation.setOptimized(rs.getBoolean("optimized"));
                        prodStation.setMachinefile(rs.getInt("machinefile"));
                        prodStation.setSavedir(rs.getString("savedir"));
                        prodStation.setReportrounding(rs.getInt("reportrounding"));
                        prodStation.setCapacity(rs.getInt("capacity"));
                        prodStation.setLinestock(rs.getBoolean("linestock"));
                        prodStation.setWarehouseid(rs.getInt("warehouseid"));
                        prodStation.setLocationid(rs.getInt("locationid"));
                        prodStation.setShip(rs.getBoolean("ship"));
                        prodStation.setShipwarehouse(rs.getInt("shipwarehouse"));
                        prodStation.setBuildingno(rs.getInt("buildingno"));
                        prodStation.setComments(rs.getString("comments"));
                        prodStation.setActive(rs.getBoolean("active"));

                        productionStations.add(prodStation);
                    }

                    rs.close();
                    pstmt.close();
                }
            });

            return productionStations;

        } finally {
            closeService();
        }
    }
}
