package openjanela.model.entities.design;

import java.util.Comparator;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 05-23-13
 *          Time: 10:00 PM
 */
public enum ConfirmAssemblyOrder implements Comparator<ConfirmAssemblyEntityObject> {

    ORDER_ITEM_QTY {
        @Override
        public int compare(ConfirmAssemblyEntityObject o1, ConfirmAssemblyEntityObject o2) {

            if (o1 == null) return -1;
            if (o2 == null) return -1;

            Integer orderId_1 = 0;
            Integer orderId_2 = 0;
            orderId_1 = o1.getOrderNo();
            orderId_2 = o2.getOrderNo();

            Integer itemNo_1 = 0;
            Integer itemNo_2 = 0;
            itemNo_1 = o1.getItemNo();
            itemNo_2 = o2.getItemNo();

            Integer qtyNo_1 = 0;
            Integer qtyNo_2 = 0;
            qtyNo_1 = o1.getQtyNo();
            qtyNo_2 = o2.getQtyNo();


            Integer val_1 = orderId_1.compareTo(itemNo_1.compareTo(qtyNo_1));
            Integer val_2 = orderId_2.compareTo(itemNo_2.compareTo(qtyNo_2));

            return val_1.compareTo(val_2);

        }
    },

    ASSEMBLY_ID {
        @Override
        public int compare(ConfirmAssemblyEntityObject o1, ConfirmAssemblyEntityObject o2) {

            if (o1 == null) return -1;
            if (o2 == null) return -1;

            Integer assembly_1 = o1.getAssemblyId();
            Integer assembly_2 = o2.getAssemblyId();

            return assembly_1.compareTo(assembly_2);
        }
    },

    ASSEMBLY_LEVEL_ID {
        @Override
        public int compare(ConfirmAssemblyEntityObject o1, ConfirmAssemblyEntityObject o2) {

            if (o1 == null) return -1;
            if (o2 == null) return -1;

            Integer assembly_level_1 = o1.getAssemblyLevelId();
            Integer assembly_level_2 = o2.getAssemblyLevelId();

            return assembly_level_1.compareTo(assembly_level_2);
        }
    };
}
