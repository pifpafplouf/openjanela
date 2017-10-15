/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani. 
 *  All rights reserved.
 *
 *  Contributors:  
 *  Sherif El Dibani
 ******************************************************************************/
package util;

//Revised from enhydra swing

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.Hashtable;

public class XYLayout implements LayoutManager2, Serializable {

    private static final long serialVersionUID = 200L;

    int width;

    int height;

    Hashtable<Component, Object> info;

    static final XYConstraints defaultConstraints = new XYConstraints();

    public XYLayout() {
        info = new Hashtable<Component, Object>();
    }

    public XYLayout(final int width, final int height) {
        info = new Hashtable<Component, Object>();
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return String.valueOf(String
                .valueOf(new StringBuffer("XYLayout[width=").append(width)
                        .append(",height=").append(height).append("]")));
    }

    public void addLayoutComponent(final String s, final Component component1) {
    }

    public void removeLayoutComponent(final Component component) {
        info.remove(component);
    }

    public Dimension preferredLayoutSize(final Container target) {
        return getLayoutSize(target, true);
    }

    public Dimension minimumLayoutSize(final Container target) {
        return getLayoutSize(target, false);
    }

    public void layoutContainer(final Container target) {
        final Insets insets = target.getInsets();
        final int count = target.getComponentCount();
        for (int i = 0; i < count; i++) {
            final Component component = target.getComponent(i);
            if (component.isVisible()) {
                final Rectangle r = getComponentBounds(component, true);
                component.setBounds(insets.left + r.x, insets.top + r.y,
                        r.width, r.height);
            }
        }

    }

    public void addLayoutComponent(final Component component, final Object constraints) {
        if (constraints instanceof XYConstraints) {
            info.put(component, constraints);
        }
    }

    public Dimension maximumLayoutSize(final Container target) {
        return new Dimension(0x7fffffff, 0x7fffffff);
    }

    public float getLayoutAlignmentX(final Container target) {
        return 0.5F;
    }

    public float getLayoutAlignmentY(final Container target) {
        return 0.5F;
    }

    public void invalidateLayout(final Container container) {
    }

    Rectangle getComponentBounds(final Component component, final boolean doPreferred) {
        XYConstraints constraints = (XYConstraints) info.get(component);
        if (constraints == null) {
            constraints = defaultConstraints;
        }
        final Rectangle r = new Rectangle(constraints.x, constraints.y,
                constraints.width, constraints.height);
        if ((r.width <= 0) || (r.height <= 0)) {
            final Dimension d = doPreferred ? component.getPreferredSize()
                    : component.getMinimumSize();
            if (r.width <= 0) {
                r.width = d.width;
            }
            if (r.height <= 0) {
                r.height = d.height;
            }
        }
        return r;
    }

    Dimension getLayoutSize(final Container target, final boolean doPreferred) {
        final Dimension dim = new Dimension(0, 0);
        if ((width <= 0) || (height <= 0)) {
            final int count = target.getComponentCount();
            for (int i = 0; i < count; i++) {
                final Component component = target.getComponent(i);
                if (component.isVisible()) {
                    final Rectangle r = getComponentBounds(component, doPreferred);
                    dim.width = Math.max(dim.width, r.x + r.width);
                    dim.height = Math.max(dim.height, r.y + r.height);
                }
            }

        }
        if (width > 0) {
            dim.width = width;
        }
        if (height > 0) {
            dim.height = height;
        }
        final Insets insets = target.getInsets();
        dim.width += insets.left + insets.right;
        dim.height += insets.top + insets.bottom;
        return dim;
    }

}

// class XYConstraints implements Cloneable, Serializable {
//
// int x;
//
// int y;
//
// int width;
//
// int height;
//
// public XYConstraints() {
// this(0, 0, 0, 0);
// }
//
// public XYConstraints(int x, int y, int width, int height) {
// this.x = x;
// this.y = y;
// this.width = width;
// this.height = height;
// }
//
// public int getX() {
// return x;
// }
//
// public void setX(int x) {
// this.x = x;
// }
//
// public int getY() {
// return y;
// }
//
// public void setY(int y) {
// this.y = y;
// }
//
// public int getWidth() {
// return width;
// }
//
// public void setWidth(int width) {
// this.width = width;
// }
//
// public int getHeight() {
// return height;
// }
//
// public void setHeight(int height) {
// this.height = height;
// }
//
// public int hashCode() {
// return x ^ y * 37 ^ width * 43 ^ height * 47;
// }
//
// public boolean equals(Object that) {
// if (that instanceof XYConstraints) {
// XYConstraints other = (XYConstraints) that;
// return other.x == x && other.y == y && other.width == width && other.height
// == height;
// } else {
// return false;
// }
// }
//
// public Object clone() {
// return new XYConstraints(x, y, width, height);
// }
//
// public String toString() {
// return String.valueOf(String.valueOf((new
// StringBuffer("XYConstraints[")).append(x).append(",")
// .append(y).append(",").append(width).append(",").append(height).append("]")));
// }
// }

