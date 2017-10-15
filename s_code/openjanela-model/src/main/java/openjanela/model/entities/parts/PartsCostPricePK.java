package openjanela.model.entities.parts;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: EMontenegro
 * Date: 10-31-12
 * Time: 08:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class PartsCostPricePK implements Serializable {

    @Column(name = "partid", nullable = false)
    private int partid = 0;

    @Column(name = "priceuom", nullable = false)
    private int priceuom = 0;

    public PartsCostPricePK() {
    }

    public PartsCostPricePK(int partid, int priceuom) {
        this.partid = partid;
        this.priceuom = priceuom;
    }

    public int getPartid() {
        return partid;
    }

    public void setPartid(int partid) {
        this.partid = partid;
    }

    public int getPriceuom() {
        return priceuom;
    }

    public void setPriceuom(int priceuom) {
        this.priceuom = priceuom;
    }
}
