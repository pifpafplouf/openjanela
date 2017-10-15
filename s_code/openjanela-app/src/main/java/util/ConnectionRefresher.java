/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 * 
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

import java.sql.*;
import java.util.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class ConnectionRefresher {
  private static Timer timer = null;
  public static ArrayList<ConnectionWrapper> conns = new ArrayList();
   public static String driverClass = null;

   private static Statement stmt = null;
   private static final int error1 = 0xcd140;
   private static final int error2 = 0xcd140;
   private static boolean connectionOK = false;

  private ConnectionRefresher() {
  }

  public static void setDriverClass(String driver) {
    driverClass = driver;
  }

  public static void loadDriverClass() {
    try {
      Class.forName(driverClass).newInstance();
    }
    catch (ClassNotFoundException ce) {
      JOptionPane.showMessageDialog(null,
				    String.valueOf(String.valueOf( (new
	  StringBuffer("JDBC Driver Class: ")).append(driverClass).append(
	  " not found!\n").append("Please check your class path setting.\n").
	  append("-----------------------------------------\n").append(
	  "DriverClass = ").append(driverClass).append("\n").append(
	  "-----------------------------------------\n").append(
	  "Error Message: ").append(ce))), "ClassNotFoundException", 0);
      System.exit( -1000);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void loadDriverClass(String driver) {
    setDriverClass(driver);
    loadDriverClass();
  }

  public static void startTimer() {
    timer = new Timer(0xcd140, new ActionListener() {

      public void actionPerformed(ActionEvent e) {
	if (ConnectionRefresher.connectionOK) {
	  System.out.println("----------------------------------------------");
	  System.out.println("  +--Current time: ".concat(String.valueOf(String.
	      valueOf(new Time(System.currentTimeMillis())))));
	  System.out.println("  +--Connection refreshing....");
	}
	ConnectionRefresher.checkConnection();
	if (ConnectionRefresher.connectionOK) {
	  System.out.println("  +--Connections refreshed.");
	  System.out.println("  +--Current time: ".concat(String.valueOf(String.
	      valueOf(new Time(System.currentTimeMillis())))));
	}
      }

    });
    timer.setInitialDelay(0xcd140);
    timer.setCoalesce(true);
    if (connectionOK) {
      System.out.println("----Timer started. Current time: ".concat(String.
	  valueOf(String.valueOf(new Time(System.currentTimeMillis())))));
    }
    timer.start();
  }

  public static synchronized void registerConnection(Connection conn,
      String url, String uid, String pwd, int connType) {
    boolean isDuplicatedConn = false;
    ConnectionWrapper wrapper = null;
    boolean isConnectionObjetDuplicated = false;
    if (connectionOK) {
      System.out.println(String.valueOf(String.valueOf( (new StringBuffer(
	  "Register Connection: ")).append(url).append(" ...."))));
    }
    int i = 0;
    do {
      if (i >= conns.size()) {
	break;
      }
      wrapper = (ConnectionWrapper) conns.get(i);
      if (wrapper.url.compareToIgnoreCase(url) == 0) {
	isDuplicatedConn = true;
	isConnectionObjetDuplicated = true;
	break;
      }
      if (url.compareToIgnoreCase(wrapper.url) == 0) {
	isDuplicatedConn = true;
	isConnectionObjetDuplicated = false;
	break;
      }
      i++;
    }
    while (true);
    if (isDuplicatedConn) {
      if (connectionOK && isConnectionObjetDuplicated) {
	System.out.println("  --Duplicate connection url found. register exit.");
	System.out.println("  |--URL = ".concat(String.valueOf(String.valueOf(
	    url))));
	System.out.println("  |--Orignal Connection is: ".concat(String.valueOf(
	    String.valueOf(wrapper.conn))));
	System.out.println("  |--Current Connection is: ".concat(String.valueOf(
	    String.valueOf(conn))));
      }
      if (connectionOK && !isConnectionObjetDuplicated) {
	System.out.println(
	    "  --Duplicate connection object found. register exit.");
	System.out.println("  |--Orignal url is: ".concat(String.valueOf(String.
	    valueOf(wrapper.url))));
	System.out.println("  |--Current url is: ".concat(String.valueOf(String.
	    valueOf(url))));
      }
      return;
    }
    wrapper = new ConnectionWrapper(conn, url, uid, pwd, connType);
    conns.add(wrapper);
    if (connectionOK) {
      System.out.println("  --Connection registered at: ".concat(String.valueOf(
	  String.valueOf(new Time(System.currentTimeMillis())))));
    }
  }

  public static synchronized void unregisterConnection(Connection conn) {
    boolean isConnectionFound = false;
    ConnectionWrapper wrapper = null;
    if (connectionOK) {
      System.out.println(String.valueOf(String.valueOf( (new StringBuffer(
	  "unregister Connection: ")).append(conn).append("...."))));
    }
    int i = 0;
    do {
      if (i >= conns.size()) {
	break;
      }
      wrapper = (ConnectionWrapper) conns.get(i);
      if (wrapper.conn.hashCode() == conn.hashCode()) {
	isConnectionFound = true;
	break;
      }
      i++;
    }
    while (true);
    if (isConnectionFound) {
      if (connectionOK) {
	System.out.println("  --connection found. Connection unregistered.");
	System.out.println("    Unregisterd at: ".concat(String.valueOf(String.
	    valueOf(new Time(System.currentTimeMillis())))));
      }
      try {
	if (!wrapper.conn.isClosed()) {
	  wrapper.conn.close();
	}
      }
      catch (SQLException se) {
	System.out.println("Exception when unregister connection.");
	System.out.println("  --Cann't close the connection");
	se.printStackTrace();
      }
      conns.remove(wrapper);
      conns.trimToSize();
    }
    else {
      System.out.println(String.valueOf(String.valueOf( (new StringBuffer(
	  "  --Connection: ")).append(conn).append(
	  " not founded in resigteration list..."))));
      System.out.println("    unregister failed.");
    }
  }

  private static void checkConnection() {
    conLoad(conns);
  }

  private static synchronized void conLoad(ArrayList conns) {
    for (int i = 0; i < conns.size(); ) {
      ConnectionWrapper connWrapper = (ConnectionWrapper) conns.get(i);
      Connection conn = connWrapper.conn;
      try {
	if (conn.isClosed()) {
	  if (connectionOK) {
	    System.out.println("    !!Connection closed. Now reopen it...");
	  }
	  loadDriverClass();
	  conn = DriverManager.getConnection(connWrapper.url, connWrapper.uid,
					     connWrapper.pwd);
	  if (connectionOK) {
	    System.out.println("    !!Connection reopened successfully.");
	  }
	}
      }
      catch (SQLException se) {
	se.printStackTrace();
      }
      if (connectionOK) {
	System.out.print("    |--Refreshing: ".concat(String.valueOf(String.
	    valueOf(connWrapper.url))));
      }
      try {
	stmt = conn.createStatement();
	switch (connWrapper.connType) {
	  case 0: // '\0'
	    stmt.executeQuery("select count(*) from seriespath");
	    break;

	  case 1: // '\001'
	    stmt.executeQuery("select count(*) from erpiccolodb.users");
	    break;
	}
	stmt.close();
	if (connectionOK) {
	  System.out.print(" ok.\n");
	}
	continue;
      }
      catch (SQLException se) {
	if (connectionOK) {
	  System.out.print(" failed.\n");
	}
	System.out.println("Failed in refresh connection:".concat(String.
	    valueOf(String.valueOf(connWrapper.url))));
	se.printStackTrace();
	i++;
      }
    }

  }

  private static synchronized void closeConnection() {
    if (connectionOK) {
      System.out.println("--Clear Unregistered connection count: ".concat(
	  String.valueOf(String.valueOf(conns.size()))));
    }
    ConnectionWrapper wrapper = null;
    for (int i = 0; i < conns.size(); i++) {
      wrapper = (ConnectionWrapper) conns.get(i);
      System.out.println("--Connection index: ".concat(String.valueOf(String.
	  valueOf(i))));
      System.out.println("  |--Connection url: ".concat(String.valueOf(String.
	  valueOf(wrapper.url))));
      try {
	System.out.println("  |--Connection closed? ".concat(String.valueOf(
	    String.valueOf(wrapper.conn.isClosed()))));
	if (!wrapper.conn.isClosed()) {
	  wrapper.conn.close();
	}
      }
      catch (SQLException se) {
	se.printStackTrace();
      }
    }

  }


}
