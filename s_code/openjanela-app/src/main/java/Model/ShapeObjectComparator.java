package Model;

import java.util.Comparator;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-10-13
 *          Time: 09:33 PM
 */
public enum ShapeObjectComparator implements Comparator<ShapeObject> {

    _SEQUENCE_ID {
        @Override
        public int compare(ShapeObject o1, ShapeObject o2) {
            if (o1 == null) {
                return -1;
            }

            if (o2 == null) {
                return -1;
            }

            Integer sequence1 = o1.a_sequenceID;
            Integer sequence2 = o2.a_sequenceID;

            return sequence1.compareTo(sequence2);
        }
    }
}
