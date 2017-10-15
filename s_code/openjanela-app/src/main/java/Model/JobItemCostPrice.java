package Model;

import java.math.BigDecimal;


public class JobItemCostPrice {

    public int id = 0;
    public String description = "";

    public int type = 0; // 0= price Group, 1= partFamily, 3= Price Cat

    public BigDecimal price = new BigDecimal(0);

    public BigDecimal cost = new BigDecimal(0);

    public int typeid = 0; // actualID of Group or Cat

    public JobItemCostPrice() {

    }

    public JobItemCostPrice(int id, String desc, int type, int typeid) {

        this.id = id;
        this.description = desc;
        this.type = type;
        this.typeid = typeid;

    }

}
