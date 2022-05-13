package com.flexnet.reimbursement.model;

import java.util.Date;

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
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationStrategy.USE_ATTRIBUTES, delimiter = "::")
	private String id;
	
	@IdPrefix(order=0)
	private String type = "Role";


	@Field
	@NotEmpty
	@IdSuffix(order=0)
	private String roleName;
	
	@Version
	private long version;

	@LastModifiedDate
	private Date lastModification;

	@CreatedDate
	private Date creationDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
		return "Role [id=" + id + ", type=" + type + ", roleName=" + roleName + ", version=" + version
				+ ", lastModification=" + lastModification + ", creationDate=" + creationDate + "]";
	}
	
	

}
