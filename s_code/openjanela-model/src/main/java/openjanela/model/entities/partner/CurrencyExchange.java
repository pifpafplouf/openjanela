package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright (c) 2011-2014 OpenJanela LLC. All rights reserved.
 *
 * @author emontenegro@openjanela.com
 * @version 2.1.2
 *          Date: 7/7/14
 *          Time: 11:54 AM
 */
@Entity
@Table(name = "currency_exchange")
public class CurrencyExchange implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currencyid", nullable = false)
    private Integer currencyId;

    @Column(name = "fromcurrency", nullable = false)
    private String fromCurrency;

    @Column(name = "tocurrency", nullable = false)
    private String toCurrency;

    @Column(name = "rate", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal rate;

    @Column(name = "updated", nullable = true)
    private Date updated;

    @Column(name = "auto_update", nullable = false)
    private boolean auto_update;

    //********************************************************************************

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public boolean isAuto_update() {
        return auto_update;
    }

    public void setAuto_update(boolean auto_update) {
        this.auto_update = auto_update;
    }
}
