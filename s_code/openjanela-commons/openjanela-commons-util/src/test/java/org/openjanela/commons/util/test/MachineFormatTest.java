package org.openjanela.commons.util.test;

import org.openjanela.commons.util.data.MachineNumberFormat;

/**
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-28-13
 *          Time: 10:22 AM
 */
public class MachineFormatTest {

    public static void main(String args[]) {
        System.out.println(MachineNumberFormat.formatNumberDigits(1253, 10));
        System.out.println(MachineNumberFormat.formatFloatingPoints(40.25, 7, 3));
    }
}
