package orderEntryUtility;

import java.util.Comparator;

import Model.BillOfMat;

/**
 * This Enum create a Bom different sorter
 */
public enum BOMSorter implements Comparator<BillOfMat> {

    Sequence {
        @Override
        public int compare(BillOfMat a1, BillOfMat a2) {

            Integer result = validateNull(a1, a2);
            if (result != null)
                return result;

            result = validateNull(a1.ruleno, a2.ruleno);
            if (result != null)
                return result;

            Integer a1_sequence = a1.a_1Sequence;
            Integer a2_sequence = a2.a_2Sequence;

            return a1_sequence.compareTo(a2_sequence);
        }
    },

    AssemblyID {
        @Override
        public int compare(BillOfMat a1, BillOfMat a2) {

            Integer result = validateNull(a1, a2);
            if (result != null) {
                return result;
            }

            result = validateNull(a1.ruleno, a2.ruleno);
            if (result != null) {
                return result;
            }

            Integer assembly_a1 = new Integer(a1.assemblyid);
            Integer assembly_a2 = new Integer(a2.assemblyid);

            return (assembly_a1.compareTo(assembly_a2));
        }
    },

    RuleNumber {
        @Override
        public int compare(BillOfMat a1, BillOfMat a2) {

            Integer result = validateNull(a1, a2);
            if (result != null) {
                return result;
            }

            result = validateNull(a1.ruleno, a2.ruleno);
            if (result != null) {
                return result;
            }

            return (a1.ruleno.compareTo(a2.ruleno));
        }

    },
    
    RuleNumberDesc {
        @Override
        public int compare(BillOfMat a1, BillOfMat a2) {

            Integer result = validateNull(a1, a2);
            if (result != null) {
                return result;
            }

            result = validateNull(a2.ruleno, a1.ruleno);
            if (result != null) {
                return result;
            }

            return (a2.ruleno.compareTo(a1.ruleno));
        }

    },

    Remote {
        @Override
        public int compare(BillOfMat a1, BillOfMat a2) {

            Integer result = validateNull(a1, a2);
            if (result != null) {
                return result;
            }

            result = validateNull(a2.ruleno, a1.ruleno);
            if (result != null) {
                return result;
            }

            Integer remote_value_1 = a1.remote ? 1 : 0;
            Integer remote_value_2 = a2.remote ? 1 : 0;

            return (remote_value_2.compareTo(remote_value_1));
        }

    };

    private static Integer validateNull(Object o1, Object o2) {

        if (o1 == null && o2 == null)
            return 0;
        if (o1 == null)
            return -1;
        if (o2 == null)
            return -2;
        return null;
    }
}
