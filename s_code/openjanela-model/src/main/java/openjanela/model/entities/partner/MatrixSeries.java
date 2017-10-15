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

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Sherif
 */
@Entity
@Table(name = "matrix_series")
@Cacheable
public class MatrixSeries implements Serializable {

	@EmbeddedId
	private MatrixSeriesPK id;

    public MatrixSeriesPK getId() {
        return id;
    }

    public void setId(MatrixSeriesPK id) {
        this.id = id;
    }
}
