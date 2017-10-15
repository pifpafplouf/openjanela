package openjanela.model.entities.partner;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@Table(name = "contacts")
public class Contacts implements Serializable {

    @EmbeddedId
    private ContactsPK id;

    @Column(name = "partnerid", nullable = false)
    private int partnerId;

    @Column(name = "salutation", nullable = true)
    private String salutation;

    @Column(name = "position", nullable = true)
    private String position;

    @Column(name = "phone", nullable = true)
    private String phone;

    @Column(name = "extension", nullable = true)
    private String extension;

    @Column(name = "cell", nullable = true)
    private String cell;

    @Column(name = "fax", nullable = true)
    private String fax;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "defaultcontact", nullable = false)
    private boolean defaultContact;

    @Column(name = "notes", nullable = true)
    private String notes;

    @Column(name = "groupid", nullable = false)
    private int groupId;

    @Column(name = "isuser", nullable = false)
    private boolean isUser;

    @Column(name = "isadmin", nullable = false)
    private boolean isAdmin;

    @Column(name = "sys_user_id", nullable = false)
    private int sysUserId;

    public Contacts() {
    }

    public Contacts(ContactsPK id, int partnerId, String salutation, String position, String phone, String extension,
                    String cell, String fax, String email, boolean defaultContact, String notes, int groupId,
                    boolean isUser, boolean isAdmin, int sysUserId) {

        this.id = id;
        this.partnerId = partnerId;
        this.salutation = salutation;
        this.position = position;
        this.phone = phone;
        this.extension = extension;
        this.cell = cell;
        this.fax = fax;
        this.email = email;
        this.defaultContact = defaultContact;
        this.notes = notes;
        this.groupId = groupId;
        this.isUser = isUser;
        this.isAdmin = isAdmin;
        this.sysUserId = sysUserId;
    }

    //**************************************************<Getters & Setters>*********************************************

    public ContactsPK getId() {
        return id;
    }

    public void setId(ContactsPK id) {
        this.id = id;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDefaultContact() {
        return defaultContact;
    }

    public void setDefaultContact(boolean defaultContact) {
        this.defaultContact = defaultContact;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean isUser) {
        this.isUser = isUser;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(int sysUserId) {
        this.sysUserId = sysUserId;
    }
}
