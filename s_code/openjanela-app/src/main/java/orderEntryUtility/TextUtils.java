
package orderEntryUtility;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 11-25-12
 * Time: 08:10 PM
 */
public class TextUtils {
	
	/*
	 *  Convert an unformatted column name to a formatted column name. That is:
	 *
	 *  - insert a space when a new uppercase character is found, insert
	 *    multiple upper case characters are grouped together.
	 *  - replace any "_" with a space
	 *
	 *  @param columnName  unformatted column name
	 *  @return the formatted column name
	 */
	public static String formatColumnName(String columnName) {
		if (columnName.length() < 3) return columnName;
		
		StringBuffer buffer = new StringBuffer(columnName);
		boolean isPreviousLowerCase = false;
		
		for (int i = 1; i < buffer.length(); i++) {
			boolean isCurrentUpperCase = Character.isUpperCase(buffer.charAt(i));
			
			if (isCurrentUpperCase && isPreviousLowerCase) {
				buffer.insert(i, " ");
				i++;
			}
			
			isPreviousLowerCase = !isCurrentUpperCase;
		}
		
		return buffer.toString().replaceAll("_", " ");
	}
}
