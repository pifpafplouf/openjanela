package openjanela.commons.components.generic;

import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 02-23-12
 * Time: 02:39 PM
 */
public class XYConstraints implements Cloneable, Serializable {

    int x;

    int y;

    int width;

    int height;

    public XYConstraints() {
        this(0, 0, 0, 0);
    }

    public XYConstraints(final int x, final int y, final int width, final int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
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
    public int hashCode() {
        return x ^ y * 37 ^ width * 43 ^ height * 47;
    }

    @Override
    public boolean equals(final Object that) {
        if (that instanceof XYConstraints) {
            final XYConstraints other = (XYConstraints) that;
            return (other.x == x) && (other.y == y) && (other.width == width)
                    && (other.height == height);
        } else {
            return false;
        }
    }

    @Override
    public Object clone() {
        return new XYConstraints(x, y, width, height);
    }

    @Override
    public String toString() {
        return String.valueOf(String.valueOf(new StringBuffer("XYConstraints[")
                .append(x).append(",").append(y).append(",").append(width)
                .append(",").append(height).append("]")));
    }
}
