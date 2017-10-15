package openjanela.model.entities.partner;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.2
 *          Date: 1/28/14
 *          Time: 10:36 AM
 */
@Entity
@Table(name = "company")
public class Company implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "partnerid", nullable = false)
    private String partnerId;

    @Column(name = "message1title", nullable = true)
    private String message1_title;

    @Column(name = "message1", nullable = true)
    private String message1;

    @Column(name = "message2title", nullable = true)
    private String message2_title;

    @Column(name = "message2", nullable = true)
    private String message2;

    @Column(name = "message3title", nullable = true)
    private String message3_title;

    @Column(name = "message3", nullable = true)
    private String message3;

    @Column(name = "message4title", nullable = true)
    private String message4_title;

    @Column(name = "message4", nullable = true)
    private String message4;

    @Column(name = "message5title", nullable = true)
    private String message5_title;

    @Column(name = "message5", nullable = true)
    private String message5;

    @Column(name = "message6title", nullable = true)
    private String message6_title;

    @Column(name = "message6", nullable = true)
    private String message6;

    @Lob
    @Column(name = "logo", nullable = true)
    private byte[] logo;

    @Lob
    @Column(name = "logosmall", nullable = true)
    private byte[] logosmall;

    public Company() {
    }

    public Company(Integer id, String partnerId, String message1_title, String message1, String message2_title,
                   String message2, String message3_title, String message3, String message4_title, String message4,
                   String message5_title, String message5, String message6_title, String message6, byte[] logo,
                   byte[] logosmall) {

        this.id = id;
        this.partnerId = partnerId;
        this.message1_title = message1_title;
        this.message1 = message1;
        this.message2_title = message2_title;
        this.message2 = message2;
        this.message3_title = message3_title;
        this.message3 = message3;
        this.message4_title = message4_title;
        this.message4 = message4;
        this.message5_title = message5_title;
        this.message5 = message5;
        this.message6_title = message6_title;
        this.message6 = message6;
        this.logo = logo;
        this.logosmall = logosmall;
    }

    //************************************************<Getters & Setters>***********************************************

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getMessage1_title() {
        return message1_title;
    }

    public void setMessage1_title(String message1_title) {
        this.message1_title = message1_title;
    }

    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public String getMessage2_title() {
        return message2_title;
    }

    public void setMessage2_title(String message2_title) {
        this.message2_title = message2_title;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public String getMessage3_title() {
        return message3_title;
    }

    public void setMessage3_title(String message3_title) {
        this.message3_title = message3_title;
    }

    public String getMessage3() {
        return message3;
    }

    public void setMessage3(String message3) {
        this.message3 = message3;
    }

    public String getMessage4_title() {
        return message4_title;
    }

    public void setMessage4_title(String message4_title) {
        this.message4_title = message4_title;
    }

    public String getMessage4() {
        return message4;
    }

    public void setMessage4(String message4) {
        this.message4 = message4;
    }

    public String getMessage5_title() {
        return message5_title;
    }

    public void setMessage5_title(String message5_title) {
        this.message5_title = message5_title;
    }

    public String getMessage5() {
        return message5;
    }

    public void setMessage5(String message5) {
        this.message5 = message5;
    }

    public String getMessage6_title() {
        return message6_title;
    }

    public void setMessage6_title(String message6_title) {
        this.message6_title = message6_title;
    }

    public String getMessage6() {
        return message6;
    }

    public void setMessage6(String message6) {
        this.message6 = message6;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public byte[] getLogosmall() {
        return logosmall;
    }

    public void setLogosmall(byte[] logosmall) {
        this.logosmall = logosmall;
    }
}
