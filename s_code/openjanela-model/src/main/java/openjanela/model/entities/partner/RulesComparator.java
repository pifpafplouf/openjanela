package openjanela.model.entities.partner;

import java.util.Comparator;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-28-13
 *          Time: 08:58 PM
 */
public enum RulesComparator implements Comparator<Rules> {

    RULE_ID {
        @Override
        public int compare(Rules o1, Rules o2) {

            if (o1 == null) {
                return -1;
            }

            if (o2 == null) {
                return -1;
            }

            Integer id_1 = o1.getRulesPK().getId();
            Integer id_2 = o2.getRulesPK().getId();

            return id_1.compareTo(id_2);
        }
    },
}
