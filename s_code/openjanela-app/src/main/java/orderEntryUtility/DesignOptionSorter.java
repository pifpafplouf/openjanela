package orderEntryUtility;

import java.util.Comparator;

import Model.DesignOption;

public enum DesignOptionSorter implements Comparator<DesignOption> {

    Sequence {
        @Override
        public int compare(DesignOption a1, DesignOption a2) {

            Integer result = validateNull(a1, a2);
            if (result != null)
                return result;

            result = validateNull(a1.seq, a2.seq);
            if (result != null)
                return result;

            return (a1.seq.compareTo(a2.seq));
        }
    },
    
    ParentRule {
        @Override
        public int compare(DesignOption a1, DesignOption a2) {

            Integer result = validateNull(a1, a2);
            if (result != null)
                return result;

            result = validateNull(a1.parentRule, a2.parentRule);
            if (result != null)
                return result;
            
            Integer a11 = Integer.parseInt(a1.parentRule+"");
            Integer a22 = Integer.parseInt(a2.parentRule+"");
            
            return (a11.compareTo(a22));
        }
    },
    RuleNo {
        @Override
        public int compare(DesignOption a1, DesignOption a2) {

            Integer result = validateNull(a1, a2);
            if (result != null)
                return result;

            result = validateNull(a1.ruleno, a2.ruleno);
            if (result != null)
                return result;

            return (new Integer(a1.ruleno).compareTo(a2.ruleno));
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
