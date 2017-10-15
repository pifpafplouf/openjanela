package openjanela.model.entities.partner;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 08-31-12
 * Time: 04:16 PM
 */
public enum ValidEntries {

    validEntry_1(1),
    validEntry_2(2),
    validEntry_3(3),
    validEntry_6(6),
    validEntry_7(7),
    validEntry_271(271),
    validEntry_272(272),
    validEntry_273(273),
    validEntry_276(276),
    validEntry_277(277),
    validEntry_278(278);
//    validEntry_271(271),
//    validEntry_272(272),
//    validEntry_273(273),
//    validEntry_276(276),
//    validEntry_277(277),
//    validEntry_278(278),
//    validEntry_51(1),
//    validEntry_53(2),
//    validEntry_54(3),
//    validEntry_55(6),
//    validEntry_56(7),

    private int value;

    ValidEntries(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
