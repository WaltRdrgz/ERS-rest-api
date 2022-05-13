package com.flexnet.reimbursement.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;
import org.springframework.data.couchbase.core.mapping.id.IdPrefix;
import org.springframework.data.couchbase.core.mapping.id.IdSuffix;

@Document
public class User {

	@Id
	@GeneratedValue(strategy = GenerationStrategy.UNIQUE, delimiter = "::")
	private String id;
	
	@IdPrefix(order=0)
	private String idPrefix = "User";

	@Field
	private String schema;
	
	@Field
	private String type = idPrefix;
	
	@Field
	@NotEmpty
	private String username;

	@Field
	@NotEmpty
	private String password;

	@Field
	@NotEmpty
	private String firstName;

	@Field
	private String lastName;

	@Field
	@Email
	private String email;

	@Field
	private List<String> roles = new ArrayList<>();

	@Version
	private long version;

	@LastModifiedDate
	private Date lastModification;

	@CreatedDate
	private Date creationDate;
	

	public User() {
		super();
	}
	
	public User(String username, String firstname, String lastname, String email, String password) {
		super();
		this.username = username;
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.password = password;
	}


	public String getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	
	public Date getLastModification() {
		return lastModification;
	}

	public void setLastModification(Date lastModification) {
		this.lastModification = lastModification;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", type=" + type + ", schema=" + schema + ", username=" + username + ", password="
				+ password + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", roles="
				+ roles + ", version=" + version + ", lastModification=" + lastModification + ", creationDate="
				+ creationDate + "]";
	}



}
