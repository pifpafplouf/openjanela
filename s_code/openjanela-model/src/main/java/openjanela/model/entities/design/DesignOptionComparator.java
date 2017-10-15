package openjanela.model.entities.design;

import java.util.Comparator;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-05-13
 *          Time: 01:26 PM
 */
public enum DesignOptionComparator implements Comparator<DesignOptionEntityObject> {

    RULE_NO {
        @Override
        public int compare(DesignOptionEntityObject o1, DesignOptionEntityObject o2) {
            if (o1 == null) {
                return -1;
            }

            if (o2 == null) {
                return -1;
            }

            Integer ruleNo1 = o1.getRuleno();
            Integer ruleNo2 = o2.getRuleno();

            return ruleNo1.compareTo(ruleNo2);
        }
    },

    SEQUENCE {
        @Override
        public int compare(DesignOptionEntityObject o1, DesignOptionEntityObject o2) {
            if (o1 == null) {
                return -1;
            }

            if (o2 == null) {
                return -1;
            }

            Integer seq_1 = o1.getSequenceId();
            Integer seq_2 = o2.getSequenceId();

            return seq_1.compareTo(seq_2);
        }
    }
}
