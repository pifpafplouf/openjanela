package openjanela.model.entities.admin;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif ElDibani
 * @author Eddy Montenegro
 * @version 2.0.8
 */
@Entity
@Table(name = "users")
public class UserAdmin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "partnerid")
    private Integer partnerId;

    @Basic(optional = false)
    @Column(name = "role")
    private int role;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "is_email_as_login")
    private boolean isEmailAsLogin;
    
    @Column(name = "username")
    private String userName;
    
    @Column(name = "email")
    private String email;
    
    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    @Column(name = "languageid")
    private String languageId;

    @Column(name = "defaultentryuom")
    private Integer defaultEntryUom;

    @Column(name = "connection")
    private String connection;

    @Column(name = "loggedin")
    private boolean loggedIn;

    @Column(name = "phone", nullable = true)
    private Integer phone;

    @Column(name = "extension", nullable = true)
    private Integer extension;

    @Column(name = "fax", nullable = true)
    private Integer fax;

    @Column(name = "salutation")
    private String salutation;

    @Column(name = "position")
    private String position;

    @Column(name = "isdefault")
    private boolean isDefault;

    @Column(name = "max_status")
    private Integer maxStatus;

    @Column(name = "groupid")
    private Integer groupId;

    @Column(name = "initials")
    private String inititals;
    
    @Column(name = "is_global_system")
    private boolean isGlobalSystem;
    
    @Column(name = "createdate")
    private Date createDate;

    @Column(name = "createdby")
    private Integer createdBy;

    @Column(name = "deleted")
    private boolean deleted;
    
    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @Transient
    private List<UserRights> userRights; 
    
    @Transient
    private List<UserGroups> userGroups; 
    
    @Override
   	public String toString() {
   		return firstName.concat(" " + lastName);
   	}

	public UserAdmin() {
		id = 0;
		partnerId = 0;
		firstName = "";
		lastName = "";
		email = "";
		password = "";
		languageId = "";		
		userRights = new ArrayList<UserRights>();
		userGroups = new ArrayList<UserGroups>();
	}

	public UserAdmin(Integer id, Integer partnerId, int role, String firstName,
			String lastName, boolean isEmailAsLogin, String userName,
			String email, String password, String languageId,
			Integer defaultEntryUom, String connection, boolean loggedIn,
			Integer phone, Integer extension, Integer fax, String salutation,
			String position, boolean isDefault, Integer maxStatus,
			Integer groupId, String inititals, boolean isGlobalSystem,
			Date createDate, Integer createdBy, boolean deleted, byte[] photo,
			boolean isAdmin) {
		super();
		this.id = id;
		this.partnerId = partnerId;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isEmailAsLogin = isEmailAsLogin;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.languageId = languageId;
		this.defaultEntryUom = defaultEntryUom;
		this.connection = connection;
		this.loggedIn = loggedIn;
		this.phone = phone;
		this.extension = extension;
		this.fax = fax;
		this.salutation = salutation;
		this.position = position;
		this.isDefault = isDefault;
		this.maxStatus = maxStatus;
		this.groupId = groupId;
		this.inititals = inititals;
		this.isGlobalSystem = isGlobalSystem;
		this.createDate = createDate;
		this.createdBy = createdBy;
		this.deleted = deleted;
		this.photo = photo;
		this.isAdmin = isAdmin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((connection == null) ? 0 : connection.hashCode());
		result = prime * result
				+ ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result
				+ ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result
				+ ((defaultEntryUom == null) ? 0 : defaultEntryUom.hashCode());
		result = prime * result + (deleted ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((extension == null) ? 0 : extension.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((inititals == null) ? 0 : inititals.hashCode());
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result + (isDefault ? 1231 : 1237);
		result = prime * result + (isEmailAsLogin ? 1231 : 1237);
		result = prime * result + (isGlobalSystem ? 1231 : 1237);
		result = prime * result
				+ ((languageId == null) ? 0 : languageId.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + (loggedIn ? 1231 : 1237);
		result = prime * result
				+ ((maxStatus == null) ? 0 : maxStatus.hashCode());
		result = prime * result
				+ ((partnerId == null) ? 0 : partnerId.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + Arrays.hashCode(photo);
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result + role;
		result = prime * result
				+ ((salutation == null) ? 0 : salutation.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
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
		UserAdmin other = (UserAdmin) obj;
		if (connection == null) {
			if (other.connection != null)
				return false;
		} else if (!connection.equals(other.connection))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (defaultEntryUom == null) {
			if (other.defaultEntryUom != null)
				return false;
		} else if (!defaultEntryUom.equals(other.defaultEntryUom))
			return false;
		if (deleted != other.deleted)
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
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inititals == null) {
			if (other.inititals != null)
				return false;
		} else if (!inititals.equals(other.inititals))
			return false;
		if (isAdmin != other.isAdmin)
			return false;
		if (isDefault != other.isDefault)
			return false;
		if (isEmailAsLogin != other.isEmailAsLogin)
			return false;
		if (isGlobalSystem != other.isGlobalSystem)
			return false;
		if (languageId == null) {
			if (other.languageId != null)
				return false;
		} else if (!languageId.equals(other.languageId))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (loggedIn != other.loggedIn)
			return false;
		if (maxStatus == null) {
			if (other.maxStatus != null)
				return false;
		} else if (!maxStatus.equals(other.maxStatus))
			return false;
		if (partnerId == null) {
			if (other.partnerId != null)
				return false;
		} else if (!partnerId.equals(other.partnerId))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (!Arrays.equals(photo, other.photo))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (role != other.role)
			return false;
		if (salutation == null) {
			if (other.salutation != null)
				return false;
		} else if (!salutation.equals(other.salutation))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isEmailAsLogin() {
		return isEmailAsLogin;
	}

	public void setEmailAsLogin(boolean isEmailAsLogin) {
		this.isEmailAsLogin = isEmailAsLogin;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	public Integer getDefaultEntryUom() {
		return defaultEntryUom;
	}

	public void setDefaultEntryUom(Integer defaultEntryUom) {
		this.defaultEntryUom = defaultEntryUom;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Integer getExtension() {
		return extension;
	}

	public void setExtension(Integer extension) {
		this.extension = extension;
	}

	public Integer getFax() {
		return fax;
	}

	public void setFax(Integer fax) {
		this.fax = fax;
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

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Integer getMaxStatus() {
		return maxStatus;
	}

	public void setMaxStatus(Integer maxStatus) {
		this.maxStatus = maxStatus;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getInititals() {
		return inititals;
	}

	public void setInititals(String inititals) {
		this.inititals = inititals;
	}

	public boolean isGlobalSystem() {
		return isGlobalSystem;
	}

	public void setGlobalSystem(boolean isGlobalSystem) {
		this.isGlobalSystem = isGlobalSystem;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<UserRights> getUserRights() {
		return userRights;
	}

	public void setUserRights(List<UserRights> userRights) {
		this.userRights = userRights;
	}

	public List<UserGroups> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(List<UserGroups> userGroups) {
		this.userGroups = userGroups;
	}

}
