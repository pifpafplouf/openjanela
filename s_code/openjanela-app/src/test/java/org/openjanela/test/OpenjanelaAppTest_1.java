package org.openjanela.test;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 01-22-13
 * Time: 09:28 PM
 */
public class OpenjanelaAppTest_1 {

    public static void main(String args[]) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 300);
        window.getContentPane().add(new DrawCanvas());
        window.setVisible(true);
    }
}

class DrawCanvas extends JComponent {

    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.BLACK);

        //Return arc2D
        Arc2D.Float arc2D = drawArc2D();

        g2.draw(arc2D);
//        g2.setColor(Color.GREEN);
//        g2.fill(arc2D);

        g2.setColor(Color.BLACK);
        g2.drawString("Arc2D.OPEN", 140, 90);
    }

    public Arc2D.Float drawArc2D()  {
        Arc2D.Float arc2D = new Arc2D.Float(Arc2D.OPEN);
        arc2D.setFrame(140, 25, 100, 100);
        arc2D.setAngleStart(-180);
        arc2D.setAngleExtent(-180);

        return arc2D;
    }
}
