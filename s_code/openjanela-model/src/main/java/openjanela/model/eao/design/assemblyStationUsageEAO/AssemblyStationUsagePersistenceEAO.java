package openjanela.model.eao.design.assemblyStationUsageEAO;

import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.AssemblyStationUsage;
import openjanela.model.entities.design.AssemblyStationUsagePK;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-30-13
 *          Time: 10:33 PM
 */
public class AssemblyStationUsagePersistenceEAO extends GenericPersistenceEAO<AssemblyStationUsage, AssemblyStationUsagePK>
        implements AssemblyStationUsageEAO{

    @Override
    public int getCapacityUsage(Date scheduleDate, int shift, int prodLine, int prodLineParent, int station)
            throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final Date param_scheduleDate = scheduleDate;
            final int param_shift = shift;
            final int param_prod_line = prodLine;
            final int param_prod_line_parent = prodLineParent;
            final int param_station = station;

            final int[] capacity = new int[1];

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    connection.setAutoCommit(false);

                    StringBuffer query = new StringBuffer();

                    if (param_prod_line_parent == 0) {
                        query.append("select sum(usedcapacity) ");
                        query.append("from assembly_station_usage ");
                        query.append("where scheduledusedate = ? and ");
                        query.append("shift = ").append(param_shift).append(" and used = 0 and ");
                        query.append("stationid = ").append(param_station).append(" and ");
                        query.append("prodlineid = ").append(param_prod_line);

                    } else {
                        query.append("select sum(usedcapacity) ");
                        query.append("from assembly_station_usage ");
                        query.append("where scheduledusedate = ? and ");
                        query.append("shift = ").append(param_shift).append(" and used = 0 and ");
                        query.append("stationid = ").append(param_station).append(" and ");
                        query.append("plparent = ").append(param_prod_line_parent);
                    }

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setDate(1, new java.sql.Date(param_scheduleDate.getTime()));

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        capacity[0] = rs.getInt(1);
                    }

                    pstmt.close();
                }
            });

            return capacity[0];

        } finally {
            closeService();
        }
    }

    @Override
    public void deleteAssemblyStationUsage(int orderID) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final int param_order_id = orderID;

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    connection.setAutoCommit(false);

                    StringBuffer query = new StringBuffer();

                    query.append("delete s from assembly_station_usage s inner join design_confirm_assemblies a ");
                    query.append("on s.assemblyid = a.barcode ");
                    query.append("where a.order_id = ? ");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_order_id);

                    pstmt.executeUpdate();

                    connection.commit();

                    pstmt.close();
                }
            });

        } finally {
            closeService();
        }

    }

}
