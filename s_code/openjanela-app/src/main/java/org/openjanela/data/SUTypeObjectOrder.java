package org.openjanela.data;

import openjanela.model.entities.partner.SUType;

import java.util.Comparator;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-17-13
 *          Time: 10:21 AM
 */
public enum SUTypeObjectOrder implements Comparator<SUType> {

    SORT_SEQ {
        @Override
        public int compare(SUType o1, SUType o2) {
            if (o1 == null) return -1;
            if (o2 == null) return -1;

            Integer sequence_1;
            Integer sequence_2;

            if (o1 != null && o2 != null) {
                sequence_1 = o1.getSortSeq();
                sequence_2 = o2.getSortSeq();

                return sequence_1.compareTo(sequence_2);
            }

            return -1;
        }
    }
}
