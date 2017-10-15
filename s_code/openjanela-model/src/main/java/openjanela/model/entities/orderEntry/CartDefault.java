/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package openjanela.model.entities.orderEntry;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author Sherif
 */
@Entity
@Table(name = "order_default_cart")
@Cacheable
public class CartDefault implements Serializable {

    @EmbeddedId
    protected CartDefaultPK cartDefaultPK;

    @Basic(optional = false)
    @Column(name = "answer")
    private int answer;

    /**
     * Default Constructor
     */
    public CartDefault() {
    }

    public CartDefault(CartDefaultPK partnerDefaultPK) {
        this.cartDefaultPK = partnerDefaultPK;
    }

    public CartDefault(CartDefaultPK partnerDefaultPK, int answer) {
        this.cartDefaultPK = partnerDefaultPK;
        this.answer = answer;
    }

    public CartDefault(int partnerid, int defaulttype, int options) {
        this.cartDefaultPK = new CartDefaultPK(partnerid, defaulttype, options);
    }

    public CartDefaultPK getCartDefaultPK() {
        return cartDefaultPK;
    }

    public void setPartnerDefaultPK(CartDefaultPK partnerDefaultPK) {
        this.cartDefaultPK = partnerDefaultPK;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    @Override
    public int hashCode() {

        int hash = 0;
        hash += (cartDefaultPK != null ? cartDefaultPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartDefault)) {
            return false;
        }
        CartDefault other = (CartDefault) object;
        if ((this.cartDefaultPK == null && other.cartDefaultPK != null)
                || (this.cartDefaultPK != null && !this.cartDefaultPK.equals(other.cartDefaultPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Openjanela_Partner_PersistenceObjects.PartnerDefault[ partnerDefaultPK=" + cartDefaultPK + " ]";
    }

}
