package openjanela.model.entities.admin;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 10/10/13
 *          Time: 10:40 AM
 */
@Entity
@Table(name = "math_operator")
@Cacheable
public class MathOperator implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "symbol", nullable = false)
    private String symbol;

    @Column(name = "operator_type_id", nullable = false)
    private int operatorTypeId;

    @Column(name = "name", nullable = false)
    private String name;

    //****************************************<Constructor>*************************************************************

    public MathOperator() {
    }

    public MathOperator(int id, String symbol, int operatorTypeId, String name) {
        this.id = id;
        this.symbol = symbol;
        this.operatorTypeId = operatorTypeId;
        this.name = name;
    }

    //****************************************<Getters & Setters>*******************************************************

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getOperatorTypeId() {
        return operatorTypeId;
    }

    public void setOperatorTypeId(int operatorTypeId) {
        this.operatorTypeId = operatorTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
