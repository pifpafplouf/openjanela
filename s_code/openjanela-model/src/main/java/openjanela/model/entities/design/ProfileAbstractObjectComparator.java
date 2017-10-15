package openjanela.model.entities.design;

import java.util.Comparator;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-10-13
 *          Time: 10:46 AM
 */
public enum ProfileAbstractObjectComparator implements Comparator<ProfileAbstractObject> {

    _SEQUENCE_NO {
        @Override
        public int compare(ProfileAbstractObject o1, ProfileAbstractObject o2) {
            if (o1 == null) {
                return -1;
            }

            if (o2 == null) {
                return -1;
            }

            Integer sequence1 = o1.get_sequence();
            Integer sequence2 = o2.get_sequence();

            return sequence1.compareTo(sequence2);
        }
    }
}
