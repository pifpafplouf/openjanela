package openjanela.model.entities.orderEntry;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Copyright(c) 2011-2013 OpenJanela LLC. All rights reserved.
 * <p/>
 * Date: 03-05-13
 * Time: 09:45 PM
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 */
@Embeddable
public class OrderPK implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false)
    private Integer type;

    @Column(name = "prefix", columnDefinition = "char(3)", nullable = false)
    private String prefix;

    @Column(name = "order_no", nullable = false)
    private Integer orderNo;

    @Column(name = "version", nullable = false)
    private Integer version;

    /**
     * Default Constructor OrdersPK
     */
    public OrderPK() {
        this.type = 0;
        this.prefix = "";
        this.orderNo = 0;
        this.version = 0;
    }

    /**
     * Constructor OrdersPK
     *
     * @param type,    Integer
     * @param prefix,  String
     * @param orderNo, Integer
     * @param version, Integer
     */
    public OrderPK(Integer type, String prefix, Integer orderNo, Integer version) {
        this.type = type;
        this.prefix = prefix;
        this.orderNo = orderNo;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
