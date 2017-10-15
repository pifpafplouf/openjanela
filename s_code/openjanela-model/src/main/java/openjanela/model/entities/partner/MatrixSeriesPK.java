/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openjanela.model.entities.partner;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Sherif
 */
@Embeddable
public class MatrixSeriesPK implements Serializable {


	    @Column(name = "matrixid", nullable = false)
	    public int matrixid;

	    @Column(name = "seriesid", nullable = false)
	    public int seriesid;

	    /**
	     * Option Answer Primary Key Constructor
	     */
	    public MatrixSeriesPK() {
		    
	    }


}
