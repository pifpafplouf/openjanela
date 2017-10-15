package openjanela.model.entities.orderEntry;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import openjanela.model.entities.partner.OptionAnswers;
import openjanela.model.entities.partner.OptionDefinitions;
import openjanela.model.entities.partner.RuleAnswers;


public class OrderItemsCartOption {

    public int id = 0;

    private OrderItemsCartPK cartID;

    public int optionid = 0;

    public int answerid = 0;

    public boolean isAuto = false;

    public OptionDefinitions myoption;

    public OptionAnswers myanswer;

    public int qtyanswer = 0;

    public int sizeanswer = 0;

    public int sizeansweri = 0;

    public int depthanswer = 0;

    public int depthansweri = 0;

    public int adjust = 0;

    public int adjusti = 0;

    public String textAnswer = "";

    public int rgb_R = 255;

    public int rgb_G = 255;

    public int rgb_B = 255;

    public BigDecimal price = new BigDecimal(0);

    public double discountP = 0;


    public BigDecimal priceUser = new BigDecimal(0);

    public BigDecimal cost = new BigDecimal(0);

    public int w = 0;

    public int h = 0;

    public int wi = 0;

    public int hi = 0;

    public int d = 0;

    public int di = 0;

    public int l = 0;

    public int li = 0;

    public int priceuom = 0;

    public int costuom = 0;

    public int pricemeasure = 0;

    public BigDecimal priceTotal = new BigDecimal(0);

    public BigDecimal priceTotalUser = new BigDecimal(0);

    public BigDecimal costTotal = new BigDecimal(0);

    public int seriesid = 0;

    public boolean remove = false;


    public List<RuleAnswers> optionsAllowedAnswers = new ArrayList();

    public OrderItemsCartOption() {

    }

}
