package openjanela.model.entities.partner;

import java.util.Comparator;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.2
 *          Date: 07-05-13
 *          Time: 01:26 PM
 */
public enum ProductionLineComparator implements Comparator<ProductionLine> {

    ID {
        @Override
        public int compare(ProductionLine o1, ProductionLine o2) {
            if (o1 == null) {
                return -1;
            }

            if (o2 == null) {
                return -1;
            }

            Integer id1 = o1.getId();
            Integer id2 = o2.getId();

            return id1.compareTo(id2);
        }
    };
}
