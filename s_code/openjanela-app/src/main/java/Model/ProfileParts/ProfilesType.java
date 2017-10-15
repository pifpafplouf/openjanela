package Model.ProfileParts;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 04-13-12
 * Time: 04:50 PM
 */
public enum ProfilesType {

    _undefined(0),
    _top1(1),
    _top2(2),
    _top3(3),
    _left(4),
    _right(5),
    _botom1(6),
    _botom2(7),
    _botom3(8),
    _top1_part(9),
    _top2_part(10),
    _top3_part(11),
    _right_part(12),
    _left_part(13),
    _botom1_part(14),
    _botom2_part(15),
    _botom3_part(16),
    _parts_object(17);

    private int value;

    ProfilesType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
