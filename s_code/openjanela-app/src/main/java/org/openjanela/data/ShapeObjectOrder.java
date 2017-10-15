package org.openjanela.data;

import Model.ShapeObject;
import openjanela.model.entities.design.ShapeAbstractObject;

import java.util.Comparator;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 02-10-13
 * Time: 12:28 AM
 */
public enum ShapeObjectOrder implements Comparator<Object> {

    SEQUENCE_ID {
        @Override
        public int compare(Object o1, Object o2) {

            if (o1 == null) return -1;
            if (o2 == null) return -1;

            Integer sequence_1; Integer sequence_2;

            if (o1 instanceof ShapeObject && o2 instanceof ShapeObject) {
                sequence_1 = ((ShapeObject)o1).a_sequenceID;
                sequence_2 = ((ShapeObject)o2).a_sequenceID;

                return sequence_1.compareTo(sequence_2);
            }

            if (o1 instanceof ShapeAbstractObject && o2 instanceof ShapeAbstractObject) {
                sequence_1 = ((ShapeAbstractObject)o1).getSequenceId();
                sequence_2 = ((ShapeAbstractObject)o2).getSequenceId();

                return sequence_1.compareTo(sequence_2);
            }

            return -1;
        }
    };


}
