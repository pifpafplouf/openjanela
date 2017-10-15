package openjanela.model.entities.partner;

import java.util.Comparator;

public enum SeriesValidOpeningShapeOrder implements Comparator<SeriesValidOpeningShape> {
	
	SEQUENCE {
		@Override
		public int compare(SeriesValidOpeningShape o1, SeriesValidOpeningShape o2) {
			
            if (o1 == null) {
                return -1;
            }

            if (o2 == null) {
                return -1;
            }

            Integer s1 = o1.getSequence();
            Integer s2 = o2.getSequence();

            return s1.compareTo(s2);
        }		
    };
}
