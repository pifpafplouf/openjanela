package org.openjanela.component;

import Model.BillOfMat;
import org.jdesktop.swingx.treetable.DefaultMutableTreeTableNode;

/**
 * Copyright (c) 2013, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 02-26-13
 * Time: 10:47 AM
 * This class represents Bill Of Materials Tree Table Node
 */
public class BomTreeTableNode extends DefaultMutableTreeTableNode {

    private BillOfMat billOfMat;

    public BomTreeTableNode(BillOfMat billOfMat) {
        super(billOfMat, true);

        this.billOfMat = billOfMat;
    }

    public BillOfMat getBillOfMat() {
        return billOfMat;
    }

    public String toString() {
        return billOfMat.stockcode + " " + billOfMat.description;
    }
}
