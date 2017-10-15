package openjanela.model.entities.admin;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 1/11/14
 *          Time: 8:08 PM
 */
@Entity
@Table(name = "partners")
@Cacheable
public class Partners implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    public Integer id = 0;

    @Column(name = "partnertype", nullable = false)
    public int partnerType = 0;

    @Column(name = "companyname", nullable = false)
    public String companyname = "";

    @Column(name = "contact_firstname", nullable = false)
    public String contact_firstname = "";

    @Column(name = "contact_lastname", nullable = false)
    public String contact_lastname = "";

    @Column(name = "countrycode", nullable = false)
    public String countrycode = "";

    @Column(name = "phone", nullable = false)
    public String phone = "";

    @Column(name = "extension", nullable = false)
    public String extension = "";

    @Column(name = "fax", nullable = false)
    public String fax = "";

    @Column(name = "address1", nullable = false)
    public String address1 = "";

    @Column(name = "address2", nullable = false)
    public String address2 = "";

    @Column(name = "city", nullable = false)
    public String city = "";

    @Column(name = "stateid", nullable = false)
    public int stateid = 0;

    @Column(name = "postalcode", nullable = false)
    public String postalcode = "";

    @Column(name = "country", nullable = false)
    public String country = "";

    @Column(name = "currency", nullable = false)
    public String currency = "";

    @Column(name = "email", nullable = false)
    public String email = "";

    @Column(name = "website", nullable = false)
    public String website = "";

    @Column(name = "notes", nullable = false)
    public String notes = "";

    @Column(name = "partner_db_hostname", nullable = false)
    public String partner_db_hostname = "";

    @Column(name = "partner_db_port", nullable = false)
    public String partner_db_port = "";

    @Column(name = "partner_db_name", nullable = false)
    public String partner_db_name = "";

    @Column(name = "partner_db_user", nullable = false)
    public String partner_db_user = "";

    @Column(name = "partner_db_password", nullable = false)
    public String partner_db_password = "";

    //****************************************<Constructor>*************************************************************

    public Partners() {
    }

    public Partners(Integer id, String companyname, String contact_firstname, String contact_lastname, String countrycode,
                    String phone, String extension, String fax, String address1, String address2, String city, int stateid,
                    String postalcode, String country, String currency, String email, String website, String notes,
                    String partner_db_hostname, String partner_db_port, String partner_db_name, String partner_db_user,
                    String partner_db_password) {

        this.id = id;
        this.companyname = companyname;
        this.contact_firstname = contact_firstname;
        this.contact_lastname = contact_lastname;
        this.countrycode = countrycode;
        this.phone = phone;
        this.extension = extension;
        this.fax = fax;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.stateid = stateid;
        this.postalcode = postalcode;
        this.country = country;
        this.currency = currency;
        this.email = email;
        this.website = website;
        this.notes = notes;
        this.partner_db_hostname = partner_db_hostname;
        this.partner_db_port = partner_db_port;
        this.partner_db_name = partner_db_name;
        this.partner_db_user = partner_db_user;
        this.partner_db_password = partner_db_password;
    }

    //****************************************<Getters & Setters>*******************************************************

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result
				+ ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((companyname == null) ? 0 : companyname.hashCode());
		result = prime
				* result
				+ ((contact_firstname == null) ? 0 : contact_firstname
						.hashCode());
		result = prime
				* result
				+ ((contact_lastname == null) ? 0 : contact_lastname.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((countrycode == null) ? 0 : countrycode.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((extension == null) ? 0 : extension.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime
				* result
				+ ((partner_db_hostname == null) ? 0 : partner_db_hostname
						.hashCode());
		result = prime * result
				+ ((partner_db_name == null) ? 0 : partner_db_name.hashCode());
		result = prime
				* result
				+ ((partner_db_password == null) ? 0 : partner_db_password
						.hashCode());
		result = prime * result
				+ ((partner_db_port == null) ? 0 : partner_db_port.hashCode());
		result = prime * result
				+ ((partner_db_user == null) ? 0 : partner_db_user.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((postalcode == null) ? 0 : postalcode.hashCode());
		result = prime * result + stateid;
		result = prime * result + ((website == null) ? 0 : website.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partners other = (Partners) obj;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (companyname == null) {
			if (other.companyname != null)
				return false;
		} else if (!companyname.equals(other.companyname))
			return false;
		if (contact_firstname == null) {
			if (other.contact_firstname != null)
				return false;
		} else if (!contact_firstname.equals(other.contact_firstname))
			return false;
		if (contact_lastname == null) {
			if (other.contact_lastname != null)
				return false;
		} else if (!contact_lastname.equals(other.contact_lastname))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (countrycode == null) {
			if (other.countrycode != null)
				return false;
		} else if (!countrycode.equals(other.countrycode))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (extension == null) {
			if (other.extension != null)
				return false;
		} else if (!extension.equals(other.extension))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (partner_db_hostname == null) {
			if (other.partner_db_hostname != null)
				return false;
		} else if (!partner_db_hostname.equals(other.partner_db_hostname))
			return false;
		if (partner_db_name == null) {
			if (other.partner_db_name != null)
				return false;
		} else if (!partner_db_name.equals(other.partner_db_name))
			return false;
		if (partner_db_password == null) {
			if (other.partner_db_password != null)
				return false;
		} else if (!partner_db_password.equals(other.partner_db_password))
			return false;
		if (partner_db_port == null) {
			if (other.partner_db_port != null)
				return false;
		} else if (!partner_db_port.equals(other.partner_db_port))
			return false;
		if (partner_db_user == null) {
			if (other.partner_db_user != null)
				return false;
		} else if (!partner_db_user.equals(other.partner_db_user))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (postalcode == null) {
			if (other.postalcode != null)
				return false;
		} else if (!postalcode.equals(other.postalcode))
			return false;
		if (stateid != other.stateid)
			return false;
		if (website == null) {
			if (other.website != null)
				return false;
		} else if (!website.equals(other.website))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return companyname;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(int partnerType) {
        this.partnerType = partnerType;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getContact_firstname() {
        return contact_firstname;
    }

    public void setContact_firstname(String contact_firstname) {
        this.contact_firstname = contact_firstname;
    }

    public String getContact_lastname() {
        return contact_lastname;
    }

    public void setContact_lastname(String contact_lastname) {
        this.contact_lastname = contact_lastname;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStateid() {
        return stateid;
    }

    public void setStateid(int stateid) {
        this.stateid = stateid;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPartner_db_hostname() {
        return partner_db_hostname;
    }

    public void setPartner_db_hostname(String partner_db_hostname) {
        this.partner_db_hostname = partner_db_hostname;
    }

    public String getPartner_db_port() {
        return partner_db_port;
    }

    public void setPartner_db_port(String partner_db_port) {
        this.partner_db_port = partner_db_port;
    }

    public String getPartner_db_name() {
        return partner_db_name;
    }

    public void setPartner_db_name(String partner_db_name) {
        this.partner_db_name = partner_db_name;
    }

    public String getPartner_db_user() {
        return partner_db_user;
    }

    public void setPartner_db_user(String partner_db_user) {
        this.partner_db_user = partner_db_user;
    }

    public String getPartner_db_password() {
        return partner_db_password;
    }

    public void setPartner_db_password(String partner_db_password) {
        this.partner_db_password = partner_db_password;
    }
}
