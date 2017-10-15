package org.openjanela.test;

import openjanela.model.entities.design.BillOfMaterialEntityObject;
import openjanela.model.entities.partner.JobItem;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.zip.GZIPInputStream;

/**
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-07-13
 *          Time: 11:55 PM
 */
public class OpenjanelaAppTest_3 {

    public static void main(String args[]) {

        try {
            FileInputStream fis = new FileInputStream("D:\\1000000001_5_0_.gz");
            GZIPInputStream gis = new GZIPInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(gis);

            JobItem jobItem = (JobItem)ois.readObject();

            for (BillOfMaterialEntityObject billOfMat : jobItem.getBoms()) {
                System.out.println(billOfMat.getRuleNo());
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
