package openjanela.model.entities.design;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-10-12
 *          Time: 11:34 PM
 */
@Entity
@Table(name = "design_construction_map")
@Cacheable
public class ConstructionMap implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "assembly_level", nullable = false)
    private int _a_assemblyLevel = 0;
    @Column(name = "assembly_sequence", nullable = false)
    private int _a_assemblySequence = 0;
    @Column(name = "level_1", nullable = false)
    private int _a_1Level = 0;
    @Column(name = "sequence_1", nullable = false)
    private int _a_1Sequence = 0;
    @Column(name = "level_2", nullable = false)
    private int _a_2Level = 0;
    @Column(name = "sequence_2", nullable = false)
    private int _a_2Sequence = 0;
    @Column(name = "level_3", nullable = false)
    private int _a_3Level = 0;
    @Column(name = "sequence_3", nullable = false)
    private int _a_3Sequence = 0;
    @Column(name = "level_4", nullable = false)
    private int _a_4Level = 0;
    @Column(name = "sequence_4", nullable = false)
    private int _a_4Sequence = 0;
    @Column(name = "level_5", nullable = false)
    private int _a_5Level = 0;
    @Column(name = "sequence_5", nullable = false)
    private int _a_5Sequence = 0;
    @Column(name = "level_6", nullable = false)
    private int _a_6Level = 0;
    @Column(name = "sequence_6", nullable = false)
    private int _a_6Sequence = 0;
    @Column(name = "level_7", nullable = false)
    private int _a_7Level = 0;
    @Column(name = "sequence_7", nullable = false)
    private int _a_7Sequence = 0;
    @Column(name = "level_8", nullable = false)
    private int _a_8Level = 0;
    @Column(name = "sequence_8", nullable = false)
    private int _a_8Sequence = 0;
    @Column(name = "level_9", nullable = false)
    private int _a_9Level = 0;
    @Column(name = "sequence_9", nullable = false)
    private int _a_9Sequence = 0;
    @Column(name = "level_10", nullable = false)
    private int _a_10Level = 0;
    @Column(name = "sequence_10", nullable = false)
    private int _a_10Sequence = 0;
    @Column(name = "level_11", nullable = false)
    private int _a_11Level = 0;
    @Column(name = "sequence_11", nullable = false)
    private int _a_11Sequence = 0;
    @Column(name = "level_12", nullable = false)
    private int _a_12Level = 0;
    @Column(name = "sequence_12", nullable = false)
    private int _a_12Sequence = 0;
    @Column(name = "level_13", nullable = false)
    private int _a_13Level = 0;
    @Column(name = "sequence_13", nullable = false)
    private int _a_13Sequence = 0;
    @Column(name = "level_14", nullable = false)
    private int _a_14Level = 0;
    @Column(name = "sequence_14", nullable = false)
    private int _a_14Sequence = 0;
    @Column(name = "level_15", nullable = false)
    private int _a_15Level = 0;
    @Column(name = "sequence_15", nullable = false)
    private int _a_15Sequence = 0;
    @Column(name = "level_16", nullable = false)
    private int _a_16Level = 0;
    @Column(name = "sequence_16", nullable = false)
    private int _a_16Sequence = 0;
    @Column(name = "level_17", nullable = false)
    private int _a_17Level = 0;
    @Column(name = "sequence_17", nullable = false)
    private int _a_17Sequence = 0;
    @Column(name = "level_18", nullable = false)
    private int _a_18Level = 0;
    @Column(name = "sequence_18", nullable = false)
    private int _a_18Sequence = 0;
    @Column(name = "level_19", nullable = false)
    private int _a_19Level = 0;
    @Column(name = "sequence_19", nullable = false)
    private int _a_19Sequence = 0;
    @Column(name = "level_20", nullable = false)
    private int _a_20Level = 0;
    @Column(name = "sequence_20", nullable = false)
    private int _a_20Sequence = 0;
    @Column(name = "level_21", nullable = false)
    private int _a_21Level = 0;
    @Column(name = "sequence_21", nullable = false)
    private int _a_21Sequence = 0;
    @Column(name = "level_22", nullable = false)
    private int _a_22Level = 0;
    @Column(name = "sequence_22", nullable = false)
    private int _a_22Sequence = 0;

    public ConstructionMap() {
    }

    public ConstructionMap(int _a_assemblyLevel, int _a_assemblySequence, int _a_1Level, int _a_1Sequence, int _a_2Level,
                           int _a_2Sequence, int _a_3Level, int _a_3Sequence, int _a_4Level, int _a_4Sequence, int _a_5Level,
                           int _a_5Sequence, int _a_6Level, int _a_6Sequence, int _a_7Level, int _a_7Sequence, int _a_8Level,
                           int _a_8Sequence, int _a_9Level, int _a_9Sequence, int _a_10Level, int _a_10Sequence, int _a_11Level,
                           int _a_11Sequence, int _a_12Level, int _a_12Sequence, int _a_13Level, int _a_13Sequence, int _a_14Level,
                           int _a_14Sequence, int _a_15Level, int _a_15Sequence, int _a_16Level, int _a_16Sequence, int _a_17Level,
                           int _a_17Sequence, int _a_18Level, int _a_18Sequence, int _a_19Level, int _a_19Sequence, int _a_20Level,
                           int _a_20Sequence, int _a_21Level, int _a_21Sequence, int _a_22Level, int _a_22Sequence) {

        this._a_assemblyLevel = _a_assemblyLevel;
        this._a_assemblySequence = _a_assemblySequence;
        this._a_1Level = _a_1Level;
        this._a_1Sequence = _a_1Sequence;
        this._a_2Level = _a_2Level;
        this._a_2Sequence = _a_2Sequence;
        this._a_3Level = _a_3Level;
        this._a_3Sequence = _a_3Sequence;
        this._a_4Level = _a_4Level;
        this._a_4Sequence = _a_4Sequence;
        this._a_5Level = _a_5Level;
        this._a_5Sequence = _a_5Sequence;
        this._a_6Level = _a_6Level;
        this._a_6Sequence = _a_6Sequence;
        this._a_7Level = _a_7Level;
        this._a_7Sequence = _a_7Sequence;
        this._a_8Level = _a_8Level;
        this._a_8Sequence = _a_8Sequence;
        this._a_9Level = _a_9Level;
        this._a_9Sequence = _a_9Sequence;
        this._a_10Level = _a_10Level;
        this._a_10Sequence = _a_10Sequence;
        this._a_11Level = _a_11Level;
        this._a_11Sequence = _a_11Sequence;
        this._a_12Level = _a_12Level;
        this._a_12Sequence = _a_12Sequence;
        this._a_13Level = _a_13Level;
        this._a_13Sequence = _a_13Sequence;
        this._a_14Level = _a_14Level;
        this._a_14Sequence = _a_14Sequence;
        this._a_15Level = _a_15Level;
        this._a_15Sequence = _a_15Sequence;
        this._a_16Level = _a_16Level;
        this._a_16Sequence = _a_16Sequence;
        this._a_17Level = _a_17Level;
        this._a_17Sequence = _a_17Sequence;
        this._a_18Level = _a_18Level;
        this._a_18Sequence = _a_18Sequence;
        this._a_19Level = _a_19Level;
        this._a_19Sequence = _a_19Sequence;
        this._a_20Level = _a_20Level;
        this._a_20Sequence = _a_20Sequence;
        this._a_21Level = _a_21Level;
        this._a_21Sequence = _a_21Sequence;
        this._a_22Level = _a_22Level;
        this._a_22Sequence = _a_22Sequence;
    }

    // ==================================<GETTTER AND SETTERS>=================================================


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int get_a_assemblyLevel() {
        return _a_assemblyLevel;
    }

    public void set_a_assemblyLevel(int _a_assemblyLevel) {
        this._a_assemblyLevel = _a_assemblyLevel;
    }

    public int get_a_assemblySequence() {
        return _a_assemblySequence;
    }

    public void set_a_assemblySequence(int _a_assemblySequence) {
        this._a_assemblySequence = _a_assemblySequence;
    }

    public int get_a_1Level() {
        return _a_1Level;
    }

    public void set_a_1Level(int _a_1Level) {
        this._a_1Level = _a_1Level;
    }

    public int get_a_1Sequence() {
        return _a_1Sequence;
    }

    public void set_a_1Sequence(int _a_1Sequence) {
        this._a_1Sequence = _a_1Sequence;
    }

    public int get_a_2Level() {
        return _a_2Level;
    }

    public void set_a_2Level(int _a_2Level) {
        this._a_2Level = _a_2Level;
    }

    public int get_a_2Sequence() {
        return _a_2Sequence;
    }

    public void set_a_2Sequence(int _a_2Sequence) {
        this._a_2Sequence = _a_2Sequence;
    }

    public int get_a_3Level() {
        return _a_3Level;
    }

    public void set_a_3Level(int _a_3Level) {
        this._a_3Level = _a_3Level;
    }

    public int get_a_3Sequence() {
        return _a_3Sequence;
    }

    public void set_a_3Sequence(int _a_3Sequence) {
        this._a_3Sequence = _a_3Sequence;
    }

    public int get_a_4Level() {
        return _a_4Level;
    }

    public void set_a_4Level(int _a_4Level) {
        this._a_4Level = _a_4Level;
    }

    public int get_a_4Sequence() {
        return _a_4Sequence;
    }

    public void set_a_4Sequence(int _a_4Sequence) {
        this._a_4Sequence = _a_4Sequence;
    }

    public int get_a_5Level() {
        return _a_5Level;
    }

    public void set_a_5Level(int _a_5Level) {
        this._a_5Level = _a_5Level;
    }

    public int get_a_5Sequence() {
        return _a_5Sequence;
    }

    public void set_a_5Sequence(int _a_5Sequence) {
        this._a_5Sequence = _a_5Sequence;
    }

    public int get_a_6Level() {
        return _a_6Level;
    }

    public void set_a_6Level(int _a_6Level) {
        this._a_6Level = _a_6Level;
    }

    public int get_a_6Sequence() {
        return _a_6Sequence;
    }

    public void set_a_6Sequence(int _a_6Sequence) {
        this._a_6Sequence = _a_6Sequence;
    }

    public int get_a_7Level() {
        return _a_7Level;
    }

    public void set_a_7Level(int _a_7Level) {
        this._a_7Level = _a_7Level;
    }

    public int get_a_7Sequence() {
        return _a_7Sequence;
    }

    public void set_a_7Sequence(int _a_7Sequence) {
        this._a_7Sequence = _a_7Sequence;
    }

    public int get_a_8Level() {
        return _a_8Level;
    }

    public void set_a_8Level(int _a_8Level) {
        this._a_8Level = _a_8Level;
    }

    public int get_a_8Sequence() {
        return _a_8Sequence;
    }

    public void set_a_8Sequence(int _a_8Sequence) {
        this._a_8Sequence = _a_8Sequence;
    }

    public int get_a_9Level() {
        return _a_9Level;
    }

    public void set_a_9Level(int _a_9Level) {
        this._a_9Level = _a_9Level;
    }

    public int get_a_9Sequence() {
        return _a_9Sequence;
    }

    public void set_a_9Sequence(int _a_9Sequence) {
        this._a_9Sequence = _a_9Sequence;
    }

    public int get_a_10Level() {
        return _a_10Level;
    }

    public void set_a_10Level(int _a_10Level) {
        this._a_10Level = _a_10Level;
    }

    public int get_a_10Sequence() {
        return _a_10Sequence;
    }

    public void set_a_10Sequence(int _a_10Sequence) {
        this._a_10Sequence = _a_10Sequence;
    }

    public int get_a_11Level() {
        return _a_11Level;
    }

    public void set_a_11Level(int _a_11Level) {
        this._a_11Level = _a_11Level;
    }

    public int get_a_11Sequence() {
        return _a_11Sequence;
    }

    public void set_a_11Sequence(int _a_11Sequence) {
        this._a_11Sequence = _a_11Sequence;
    }

    public int get_a_12Level() {
        return _a_12Level;
    }

    public void set_a_12Level(int _a_12Level) {
        this._a_12Level = _a_12Level;
    }

    public int get_a_12Sequence() {
        return _a_12Sequence;
    }

    public void set_a_12Sequence(int _a_12Sequence) {
        this._a_12Sequence = _a_12Sequence;
    }

    public int get_a_13Level() {
        return _a_13Level;
    }

    public void set_a_13Level(int _a_13Level) {
        this._a_13Level = _a_13Level;
    }

    public int get_a_13Sequence() {
        return _a_13Sequence;
    }

    public void set_a_13Sequence(int _a_13Sequence) {
        this._a_13Sequence = _a_13Sequence;
    }

    public int get_a_14Level() {
        return _a_14Level;
    }

    public void set_a_14Level(int _a_14Level) {
        this._a_14Level = _a_14Level;
    }

    public int get_a_14Sequence() {
        return _a_14Sequence;
    }

    public void set_a_14Sequence(int _a_14Sequence) {
        this._a_14Sequence = _a_14Sequence;
    }

    public int get_a_15Level() {
        return _a_15Level;
    }

    public void set_a_15Level(int _a_15Level) {
        this._a_15Level = _a_15Level;
    }

    public int get_a_15Sequence() {
        return _a_15Sequence;
    }

    public void set_a_15Sequence(int _a_15Sequence) {
        this._a_15Sequence = _a_15Sequence;
    }

    public int get_a_16Level() {
        return _a_16Level;
    }

    public void set_a_16Level(int _a_16Level) {
        this._a_16Level = _a_16Level;
    }

    public int get_a_16Sequence() {
        return _a_16Sequence;
    }

    public void set_a_16Sequence(int _a_16Sequence) {
        this._a_16Sequence = _a_16Sequence;
    }

    public int get_a_17Level() {
        return _a_17Level;
    }

    public void set_a_17Level(int _a_17Level) {
        this._a_17Level = _a_17Level;
    }

    public int get_a_17Sequence() {
        return _a_17Sequence;
    }

    public void set_a_17Sequence(int _a_17Sequence) {
        this._a_17Sequence = _a_17Sequence;
    }

    public int get_a_18Level() {
        return _a_18Level;
    }

    public void set_a_18Level(int _a_18Level) {
        this._a_18Level = _a_18Level;
    }

    public int get_a_18Sequence() {
        return _a_18Sequence;
    }

    public void set_a_18Sequence(int _a_18Sequence) {
        this._a_18Sequence = _a_18Sequence;
    }

    public int get_a_19Level() {
        return _a_19Level;
    }

    public void set_a_19Level(int _a_19Level) {
        this._a_19Level = _a_19Level;
    }

    public int get_a_19Sequence() {
        return _a_19Sequence;
    }

    public void set_a_19Sequence(int _a_19Sequence) {
        this._a_19Sequence = _a_19Sequence;
    }

    public int get_a_20Level() {
        return _a_20Level;
    }

    public void set_a_20Level(int _a_20Level) {
        this._a_20Level = _a_20Level;
    }

    public int get_a_20Sequence() {
        return _a_20Sequence;
    }

    public void set_a_20Sequence(int _a_20Sequence) {
        this._a_20Sequence = _a_20Sequence;
    }

    public int get_a_21Level() {
        return _a_21Level;
    }

    public void set_a_21Level(int _a_21Level) {
        this._a_21Level = _a_21Level;
    }

    public int get_a_21Sequence() {
        return _a_21Sequence;
    }

    public void set_a_21Sequence(int _a_21Sequence) {
        this._a_21Sequence = _a_21Sequence;
    }

    public int get_a_22Level() {
        return _a_22Level;
    }

    public void set_a_22Level(int _a_22Level) {
        this._a_22Level = _a_22Level;
    }

    public int get_a_22Sequence() {
        return _a_22Sequence;
    }

    public void set_a_22Sequence(int _a_22Sequence) {
        this._a_22Sequence = _a_22Sequence;
    }
}
