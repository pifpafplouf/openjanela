package openjanela.model.eao.designGlassEAO;

import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.DesignGlassEntityObject;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-05-13
 *          Time: 02:29 PM
 */
public class DesignGlassPersistenceEAO extends GenericPersistenceEAO<DesignGlassEntityObject, Integer> implements DesignGlassEAO {

    //Apache Log4j
    private static final Logger logger = Logger.getLogger(DesignGlassPersistenceEAO.class);

    @Override
    public DesignGlassEntityObject findGridsInfo(Integer designGlassId) throws GenericPersistenceEAOException {

        try {

            //Init Service
            initService();

            final int param_glass_bom_id = designGlassId;

            final DesignGlassEntityObject glassBom = new DesignGlassEntityObject();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {

                    StringBuffer query = new StringBuffer();
                    query.append("select id, grid_id, grid_type, no_grids_v, no_grids_h, no_grids_s, no_grids_r ");
                    query.append("from design_glass ");
                    query.append("where id = ?");

                    PreparedStatement pstmt = connection.prepareStatement(query.toString());
                    pstmt.setInt(1, param_glass_bom_id);

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        glassBom.setId(rs.getInt("id"));
                        glassBom.setGridID(rs.getInt("grid_id"));
                        glassBom.setGridType(rs.getInt("grid_type"));
                        glassBom.setNoGridsV(rs.getInt("no_grids_v"));
                        glassBom.setNoGridsH(rs.getInt("no_grids_h"));
                        glassBom.setNoGridsS(rs.getInt("no_grids_s"));
                        glassBom.setNoGridsR(rs.getInt("no_grids_r"));
                    }

                    rs.close();
                    pstmt.close();
                }
            });

            return glassBom;

        } finally {
            closeService();
        }
    }

    @Override
    public List<DesignGlassEntityObject> findByJobItem(Integer jobItemId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            List<DesignGlassEntityObject> designGlass = em.createQuery("select glass from JobItem job inner join " +
                    "job.glassBoms glass where job.id = :jobItemId").setParameter("jobItemId", jobItemId).getResultList();

            return designGlass;

        } finally {
            closeService();
        }
    }
}
