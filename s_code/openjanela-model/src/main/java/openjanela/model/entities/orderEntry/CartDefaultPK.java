package openjanela.model.entities.orderEntry;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 12-12-12
 * Time: 07:53 PM
 */
@Embeddable
public class CartDefaultPK implements Serializable {

    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "defaulttype", nullable = false)
    private Integer defaultType;
    @Column(name = "options", nullable = false)
    private Integer options;

    /**
     * Default Constructor
     */
    public CartDefaultPK() {
    }

    /**
     * Cart Default Constructor PK
     *
     * @param id,          Integer
     * @param defaultType, Integer
     * @param options,     Integer
     */
    public CartDefaultPK(Integer id, Integer defaultType, Integer options) {
        this.id = id;
        this.defaultType = defaultType;
        this.options = options;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDefaultType() {
        return defaultType;
    }

    public void setDefaultType(Integer defaultType) {
        this.defaultType = defaultType;
    }

    public Integer getOptions() {
        return options;
    }

    public void setOptions(Integer options) {
        this.options = options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartDefaultPK)) return false;

        CartDefaultPK that = (CartDefaultPK) o;

        if (!defaultType.equals(that.defaultType)) return false;
        if (!id.equals(that.id)) return false;
        if (!options.equals(that.options)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + defaultType.hashCode();
        result = 31 * result + options.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CartDefaultPK{" + "id=" + id + ", defaultType=" + defaultType + ", options=" + options + '}';
    }
}
