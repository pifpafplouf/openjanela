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
@Table(name = "matrix_header")
@Cacheable
public class MatrixHeaderObject implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    public int id = 0;

    @Column(name = "description")
    public String description = "";

    @Column(name = "matrix_type_id")
    public Integer matrix_type_id = 0;

    @Column(name = "row_type_id")
    public int row_type_id = 0;

    @Column(name = "affected_option")
    public int affected_option = 0;

    @Column(name = "row_option_id")
    public int row_option_id = 0;

    @Column(name = "row_start")
    public double row_start = 0;

    @Column(name = "row_end")
    public double row_end = 0;

    @Column(name = "row_step")
    public double row_step = 0;

    @Column(name = "number_rows")
    public int number_rows = 0;

    @Column(name = "column_type_id")
    public int column_type_id = 0;

    @Column(name = "column_option_id")
    public int column_option_id = 0;

    @Column(name = "column_start")
    public double column_start = 0;

    @Column(name = "column_end")
    public double column_end = 0;

    @Column(name = "column_step", nullable = false)
    public double column_step = 0.0;

    @Column(name = "number_columns")
    public int number_columns = 0;

    @Column(name = "deleted")
    public Boolean deleted = false;

    @Column(name = "system_uom_id")
    public int system_uom_id = 0;

    @Column(name = "sub_matrix")
    public Boolean sub_matrix = false;

    @Column(name = "main_matrix_id")
    public int main_matrix_id = 0;

    @Column(name = "math_operator_id")
    public int operator_id = 0;

    @Column(name = "operator_value")
    public double operator_value = 0;

    @Column(name = "series_id")
    public int series_id = 0;

    @Column(name = "measure")
    public int measure = 1;

    public MatrixHeaderObject() {
    }

    public MatrixHeaderObject(int matrixid) {
        this.id = matrixid;
    }

    public MatrixHeaderObject(int id, String description, Integer matrix_type_id, int row_type_id, int affected_option,
                              int row_option_id, double row_start, double row_end, double row_step, int number_rows,
                              int column_type_id, int column_option_id, double column_start, double column_end,
                              double column_step, int number_columns, Boolean deleted, int system_uom_id, Boolean sub_matrix,
                              int main_matrix_id, int operator_id, double operator_value, int series_id, int measure) {

        this.id = id;
        this.description = description;
        this.matrix_type_id = matrix_type_id;
        this.row_type_id = row_type_id;
        this.affected_option = affected_option;
        this.row_option_id = row_option_id;
        this.row_start = row_start;
        this.row_end = row_end;
        this.row_step = row_step;
        this.number_rows = number_rows;
        this.column_type_id = column_type_id;
        this.column_option_id = column_option_id;
        this.column_start = column_start;
        this.column_end = column_end;
        this.column_step = column_step;
        this.number_columns = number_columns;
        this.deleted = deleted;
        this.system_uom_id = system_uom_id;
        this.sub_matrix = sub_matrix;
        this.main_matrix_id = main_matrix_id;
        this.operator_id = operator_id;
        this.operator_value = operator_value;
        this.series_id = series_id;
        this.measure = measure;
    }

    public int getMatrixid() {
        return id;
    }

    public void setMatrixid(int matrixid) {
        this.id = matrixid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMatrixTypeID() {
        return matrix_type_id;
    }

    public void setMatrixTypeID(int matrixtypenumber) {
        this.matrix_type_id = matrixtypenumber;
    }

    public int getRowTypeID() {
        return row_type_id;
    }

    public void setRowTypeID(int rowtypenumber) {
        this.row_type_id = rowtypenumber;
    }

    public int getAffectedOption() {
        return affected_option;
    }

    public void setAffectedOption(int rowtype) {
        this.affected_option = rowtype;
    }

    public int getRowOptionID() {
        return row_option_id;
    }

    public void setRowOptionID(int rowoption) {
        this.row_option_id = rowoption;
    }

    public double getRowstart() {
        return row_start;
    }

    public void setRowstart(double rowstart) {
        this.row_start = rowstart;
    }

    public double getRowEnd() {
        return row_end;
    }

    public void setRowEnd(double rowend) {
        this.row_end = rowend;
    }

    public double getRowStep() {
        return row_step;
    }

    public void setRowStep(double rowstep) {
        this.row_step = rowstep;
    }

    public int getNoRows() {
        return number_rows;
    }

    public void setNoRows(int rownum) {
        this.number_rows = rownum;
    }

    public int getColumnTypeID() {
        return column_type_id;
    }

    public void setColumnTypeID(int columntypenumber) {
        this.column_type_id = columntypenumber;
    }

    public int getColumnOptionID() {
        return column_option_id;
    }

    public void setColumnOptionID(int columnoption) {
        this.column_option_id = columnoption;
    }

    public double getColumnStart() {
        return column_start;
    }

    public void setColumnStart(double columnstart) {
        this.column_start = columnstart;
    }

    public double getColumnEnd() {
        return column_end;
    }

    public void setColumnEnd(double columnend) {
        this.column_end = columnend;
    }

    public double getColumnStep() {
        return column_step;
    }

    public void setColumnStep(double columnstep) {
        this.column_step = columnstep;
    }

    public int getNoColumns() {
        return number_columns;
    }

    public void setNoColumns(int columnnum) {
        this.number_columns = columnnum;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public int getSystemUOM() {
        return system_uom_id;
    }

    public void setSystemUOM(int formatid) {
        this.system_uom_id = formatid;
    }

    public Boolean getSubmatrix() {
        return sub_matrix;
    }

    public void setSubmatrix(Boolean submatrix) {
        this.sub_matrix = submatrix;
    }

    public int getMainmatrixid() {
        return main_matrix_id;
    }

    public void setMainmatrixid(int mainmatrixid) {
        this.main_matrix_id = mainmatrixid;
    }

    public int getOperatormat() {
        return operator_id;
    }

    public void setOperatormat(int operatormat) {
        this.operator_id = operatormat;
    }

    public double getOperatorvalue() {
        return operator_value;
    }

    public void setOperatorvalue(double operatorvalue) {
        this.operator_value = operatorvalue;
    }

    public int getSeriesID() {
        return series_id;
    }

    public void setSeriesID(int seriesid) {
        this.series_id = seriesid;
    }

    @Override
    public boolean equals(Object object) {
        boolean myret = false;
        if ((object instanceof MatrixHeaderObject)) {
            myret = true;
        }

        return myret;
    }

    @Override
    public String toString() {
        return this.description;
    }

    public Vector getAll(Connection myConn) throws SQLException {
        Vector types = new Vector();

        String sql = "SELECT * FROM matrix_header ORDER BY id";

        PreparedStatement stmt = myConn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            MatrixHeaderObject result = new MatrixHeaderObject();

            result.id = rs.getInt(1);
            result.description = rs.getString(2);

            result.matrix_type_id = rs.getInt(3);

            result.row_type_id = rs.getInt(4);

            result.affected_option = rs.getInt(5);

            result.row_option_id = rs.getInt(6);

            result.row_start = rs.getDouble(7);

            result.row_end = rs.getDouble(8);

            result.row_step = rs.getDouble(9);

            result.number_rows = rs.getInt(10);

            result.column_type_id = rs.getInt(11);

            result.column_option_id = rs.getInt(12);

            result.column_start = rs.getDouble(13);

            result.column_end = rs.getDouble(14);

            result.column_step = rs.getDouble(15);

            result.number_columns = rs.getInt(16);

            result.deleted = rs.getBoolean(17);

            result.system_uom_id = rs.getInt(18);

            result.sub_matrix = rs.getBoolean(19);

            result.main_matrix_id = rs.getInt(20);

            result.operator_id = rs.getInt(21);

            result.operator_value = rs.getDouble(22);

            result.series_id = rs.getInt(23);

            result.measure = rs.getInt(24);

            types.add(result);
        }
        rs.close();
        stmt.close();

        return types;
    }

    public MatrixHeaderObject getType(int myid, Connection myConn) throws SQLException {

        String sql = "SELECT * FROM matrix_header where matrix_header.id ="
                + myid;

        PreparedStatement stmt = myConn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        MatrixHeaderObject result = new MatrixHeaderObject();
        while (rs.next()) {

            result.id = rs.getInt(1);
            result.description = rs.getString(2);

            result.matrix_type_id = rs.getInt(3);

            result.row_type_id = rs.getInt(4);

            result.affected_option = rs.getInt(5);

            result.row_option_id = rs.getInt(6);

            result.row_start = rs.getDouble(7);

            result.row_end = rs.getDouble(8);

            result.row_step = rs.getDouble(9);

            result.number_rows = rs.getInt(10);

            result.column_type_id = rs.getInt(11);

            result.column_option_id = rs.getInt(12);

            result.column_start = rs.getDouble(13);

            result.column_end = rs.getDouble(14);

            result.column_step = rs.getDouble(15);

            result.number_columns = rs.getInt(16);

            result.deleted = rs.getBoolean(17);

            result.system_uom_id = rs.getInt(18);

            result.sub_matrix = rs.getBoolean(19);

            result.main_matrix_id = rs.getInt(20);

            result.operator_id = rs.getInt(21);

            result.operator_value = rs.getDouble(22);

            result.series_id = rs.getInt(23);

            result.measure = rs.getInt(24);
        }

        rs.close();
        stmt.close();

        return result;
    }

    public int insert(Connection myConn) {

        String insertSQL = "INSERT INTO matrix_header "
                + "( id, "
                + "description, "
                + "matrix_type_id, "
                + "row_type_id, "
                + "affected_option, "
                + "row_option_id, "
                + "row_start, "
                + "row_end, "
                + "row_step, "
                + "number_rows, "
                + "column_type_id, "
                + "column_option_id, "
                + "column_start, "
                + "column_end, "
                + "column_step, "
                + "number_columns, "
                + "deleted, "
                + "system_uom_id, "
                + "sub_matrix, "
                + "main_matrix_id, "
                + "math_operator_id, "
                + "operator_value, "
                + "series_id, measure) "
                + " VALUES "
                + "(?,?,?,?,?," +
                "   ?,?,?,?,?," +
                " 	 ?,?,?,?,?," +
                "   ?,?,?,?,?," +
                "   ?,?,?,?)";
        int maxid = 0;
        try {

            PreparedStatement stmt = myConn.prepareStatement(insertSQL);
            maxid = this.getMaxID(myConn);

            this.id = ++maxid;

            stmt.setInt(1, this.id);

            stmt.setString(2, description);

            stmt.setInt(3, getMatrixTypeID());

            stmt.setInt(4, this.row_type_id);

            stmt.setInt(5, affected_option);

            stmt.setInt(6, row_option_id);

            stmt.setDouble(7, row_start);

            stmt.setDouble(8, row_end);

            stmt.setDouble(9, row_step);

            stmt.setInt(10, number_rows);

            stmt.setInt(11, column_type_id);

            stmt.setInt(12, column_option_id);

            stmt.setDouble(13, column_start);

            stmt.setDouble(14, column_end);

            stmt.setDouble(15, column_step);

            stmt.setInt(16, number_columns);

            stmt.setBoolean(17, deleted);

            stmt.setInt(18, system_uom_id);

            stmt.setBoolean(19, sub_matrix);

            stmt.setInt(20, main_matrix_id);

            stmt.setInt(21, operator_id);

            stmt.setDouble(22, operator_value);

            stmt.setInt(23, series_id);

            stmt.setInt(24, measure);

            stmt.execute();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return maxid;

    }

    public int getMaxID(Connection myConn) throws SQLException {

        String sql = "SELECT MAX(id) from matrix_header ";


        int i = -1;
        PreparedStatement stmt = myConn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        rs.next();
        i = rs.getInt(1);
        rs.close();
        stmt.close();

        return i;

    }

    public void update(int id, Connection myConn) throws SQLException {


        String sql = "update matrix_header  SET "
                + " id =?,"

                + " description =?,"

                + " matrix_type_id =?,"

                + " row_type_id =?,"

                + " affected_option =?,"

                + " row_option_id =?,"

                + " row_start =?,"

                + " row_end =?,"

                + " row_step =?,"

                + " number_rows =?,"

                + " column_type_id =?,"

                + " column_option_id =?,"

                + " column_start =?,"

                + " column_end =?,"

                + " column_step =?,"

                + " munber_columns =?,"

                + " deleted =?,"

                + " system_uom_id =?,"

                + " sub_matrix =?,"

                + " main_matrix_id =?,"

                + " math_operator_id =?,"

                + " operator_value =?,"

                + " series_id =?, measure=?  where id=" + id;


        PreparedStatement stmt = myConn.prepareStatement(sql);

        stmt.setInt(1, this.id);

        stmt.setString(2, description);

        stmt.setInt(3, getMatrixTypeID());

        stmt.setInt(4, this.row_type_id);

        stmt.setInt(5, affected_option);

        stmt.setInt(6, row_option_id);

        stmt.setDouble(7, row_start);

        stmt.setDouble(8, row_end);

        stmt.setDouble(9, row_step);

        stmt.setInt(10, number_rows);

        stmt.setInt(11, column_type_id);

        stmt.setInt(12, column_option_id);

        stmt.setDouble(13, column_start);

        stmt.setDouble(14, column_end);

        stmt.setDouble(15, column_step);

        stmt.setInt(16, number_columns);

        stmt.setBoolean(17, deleted);

        stmt.setInt(18, system_uom_id);

        stmt.setBoolean(19, sub_matrix);

        stmt.setInt(20, main_matrix_id);

        stmt.setInt(21, operator_id);

        stmt.setDouble(22, operator_value);

        stmt.setInt(23, series_id);

        stmt.setInt(24, measure);

        stmt.execute();
        stmt.close();

    }


}
