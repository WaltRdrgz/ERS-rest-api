package com.flexnet.reimbursement.model;

import java.time.Instant;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;
import org.springframework.data.couchbase.core.mapping.id.IdPrefix;

@Document
public class Reimbursement {
	
	@Id
	@GeneratedValue(strategy = GenerationStrategy.UNIQUE, delimiter = "::")
	private String id;
	
	@IdPrefix(order=0)
	private String idPrefix = "Reimbursement";
	
	@Field
	private String type = idPrefix;
	
	@Field
	private String schema;
	
	@Version
	private long version;

	@LastModifiedDate
	private Date lastModification;

	@CreatedDate
	private Date creationDate;
	
	@Field
	@NotEmpty
	private String owner;
	
	@Field
	private String resolver;
	
	@Field
	@NotNull
	@Positive
	private double amount;
	
	@Field
	private Date dateResolved;
	
	@Field
	private String dateSubmitted = Instant.now().toString();
	
	@Field
	private String description;
	
	@Field
	@NotEmpty
	private String status;
	
	@Field
	@NotEmpty
	private String reimbursementType;
	
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Date dateResolved) {
		this.dateResolved = dateResolved;
	}


	public String getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReimbursementType() {
		return reimbursementType;
	}

	public void setReimbursementType(String reimbursementType) {
		this.reimbursementType = reimbursementType;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", type=" + type + ", schema=" + schema + ", version=" + version
				+ ", lastModification=" + lastModification + ", creationDate=" + creationDate + ", owner=" + owner
				+ ", resolver=" + resolver + ", amount=" + amount + ", dateResolved=" + dateResolved
				+ ", dateSubmitted=" + dateSubmitted + ", description=" + description + ", status=" + status
				+ ", reimbursementType=" + reimbursementType + "]";
	}


	
}
