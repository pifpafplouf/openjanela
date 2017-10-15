package openjanela.model.entities.design;

import java.util.Comparator;

/**
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-25-13
 *          Time: 04:14 PM
 */
public enum BillOfMaterialComparator implements Comparator<BillOfMaterialEntityObject> {

    CUT_LENGTH_METRIC_DESC {
        @Override
        public int compare(BillOfMaterialEntityObject o1, BillOfMaterialEntityObject o2) {

            if (o1 == null) {
                return -1;
            }

            if (o2 == null) {
                return -1;
            }

            Integer cutLength_1 = o1.getCutLength();
            Integer cutLength_2 = o2.getCutLength();

            return cutLength_2.compareTo(cutLength_1);
        }
    },

    CUT_LENGTH_IMPERIAL_DESC {
        @Override
        public int compare(BillOfMaterialEntityObject o1, BillOfMaterialEntityObject o2) {

            if (o1 == null) {
                return -1;
            }

            if (o2 == null) {
                return -1;
            }

            Integer cutLength_1 = o1.getCutLengthI();
            Integer cutLength_2 = o2.getCutLengthI();

            return cutLength_2.compareTo(cutLength_1);
        }
    };
}
