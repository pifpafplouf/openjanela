/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 * 
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/

package util;

import java.io.*;
import java.sql.ResultSet;

public class DBResultSet
	implements Serializable
{

	private int columnCount = 0;
	private String columnNames[] = null;
	private Object columnValues[] = null;
	private int columnTypes[] = null;

	public DBResultSet()
	{
	}

	public DBResultSet(ResultSet resultSet, int columnCount, int columnTypes[], String columnNames[])
	{
		this.columnCount = columnCount;
		this.columnNames = columnNames;
		columnValues = new Object[columnCount];
		this.columnTypes = columnTypes;
		try
		{
			for(int i = 1; i < columnCount; i++)
				switch(columnTypes[i])
				{
				case -3:
				case -1:
				case 0: // '\0'
				case 2: // '\002'
				case 7: // '\007'
				case 1111:
				case 2000:
				case 2001:
				case 2002:
					break;

				case 12: // '\f'
				{
					if(resultSet.getString(i) == null)
						columnValues[i] = ((Object) (new String("")));
					else
						columnValues[i] = ((Object) (resultSet.getString(i)));
					break;
				}

				case 4: // '\004'
				{
					columnValues[i] = ((Object) (new Integer(resultSet.getInt(i))));
					break;
				}

				case 93: // ']'
				{
					columnValues[i] = ((Object) (resultSet.getTimestamp(i)));
					break;
				}

				case 2003:
				{
					columnValues[i] = ((Object) (resultSet.getArray(i)));
					break;
				}

				case -5:
				{
					columnValues[i] = ((Object) (new Long(resultSet.getLong(i))));
					break;
				}

				case -2:
				{
					byte resultByte[] = new byte[0];
					if(resultSet.getBinaryStream(i) != null)
					{
						resultByte = new byte[resultSet.getBinaryStream(i).available()];
						resultSet.getBinaryStream(i).read(resultByte);
					}
					columnValues[i] = ((Object) (resultByte));
					break;
				}

				case -7:
				{
					columnValues[i] = ((Object) (new Byte(resultSet.getByte(i))));
					break;
				}

				case 2004:
				{
					columnValues[i] = ((Object) (resultSet.getBlob(i)));
					break;
				}

				case 1: // '\001'
				{
					columnValues[i] = ((Object) (resultSet.getString(i)));
					break;
				}

				case 2005:
				{
					columnValues[i] = ((Object) (resultSet.getClob(i)));
					break;
				}

				case 91: // '['
				{
					columnValues[i] = ((Object) (resultSet.getDate(i)));
					break;
				}

				case 3: // '\003'
				{
					columnValues[i] = ((Object) (new Double(resultSet.getDouble(i))));
					break;
				}

				case 8: // '\b'
				{
					columnValues[i] = ((Object) (new Double(resultSet.getDouble(i))));
					break;
				}

				case 6: // '\006'
				{
					columnValues[i] = ((Object) (new Double(resultSet.getFloat(i))));
					break;
				}

				case -4:
				{
					byte resultByte[] = new byte[0];
					if(resultSet.getBinaryStream(i) != null)
					{
						resultByte = new byte[resultSet.getBinaryStream(i).available()];
						resultSet.getBinaryStream(i).read(resultByte);
					}
					columnValues[i] = ((Object) (resultByte));
					break;
				}

				case 2006:
				{
					columnValues[i] = ((Object) (resultSet.getRef(i)));
					break;
				}

				case 5: // '\005'
				{
					columnValues[i] = ((Object) (new Integer(((int) (resultSet.getShort(i))))));
					break;
				}

				case 92: // '\\'
				{
					columnValues[i] = ((Object) (resultSet.getTime(i)));
					break;
				}

				case -6:
				{
					columnValues[i] = ((Object) (new Boolean(resultSet.getBoolean(i))));
					break;
				}

				default:
				{
					System.out.println("Column Type is: ".concat(String.valueOf(((Object) (String.valueOf(columnTypes[i]))))));
					break;
				}
				}

		}
		catch(Exception exception)
		{
			((Throwable) (exception)).printStackTrace();
			System.err.println("DBResultSet: ".concat(((Throwable) (exception)).toString()));
		}
	}

	public int getColumnCounts()
	{
		return columnCount;
	}

	public String getColumnName(int i)
	{
		if(i < columnCount)
			return columnNames[i];
		else
			return "";
	}

	public String getStringValue(int i)
	{
		return String.valueOf(((Object) (String.valueOf(getValue(i)))));
	}

	public String getStringValue(String s)
	{
		return String.valueOf(((Object) (String.valueOf(getValue(s)))));
	}

	public Object getValue(int i)
	{
		if(i < columnCount)
		{
			if(columnValues[i] == null)
				return ((Object) (""));
			else
				return columnValues[i];
		} else
		{
			return ((Object) (""));
		}
	}

	public Object getValue(String s)
	{
		for(int i = 0; i < columnCount; i++)
			if(columnNames[i] != null && columnNames[i].equalsIgnoreCase(s))
				return columnValues[i];

		return ((Object) (""));
	}
}
