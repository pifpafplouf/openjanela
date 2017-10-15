/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

import java.io.*;
import java.sql.*;


public class LoadImage {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: LoadImage <image-filename> <album-id> <desc>");
            System.exit(0);
        }

        String filename = args[0];
        int albumId = Integer.parseInt(args[1]);
        String desc = args[2];

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            String url = "jdbc:mysql://localhost:3306/webphotogallery";
            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(url, username, password);
            ps = conn.prepareStatement("INSERT INTO Image (album_id, image_desc, image_thumb, image_full) VALUES( ?, ?, ?, ? )");

            ps.setInt(1, albumId);
            ps.setString(2, desc);

            // Insert the thumbnail into the first blob
            byte[] thumbnail = ImageUtils.constrain(filename, 128);
            ps.setBinaryStream(3, new ByteArrayInputStream(thumbnail), thumbnail.length);

            // Insert the image into the second Blob
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ps.setBinaryStream(4, fis, (int) image.length());

            // Execute the INSERT
            int count = ps.executeUpdate();
            System.out.println("Rows inserted: " + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
    }
}
