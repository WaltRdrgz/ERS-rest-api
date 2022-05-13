package com.flexnet.reimbursement.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProperties {
	
	@Value("${couchbase.username}")
	private String cbUserName;
	
	@Value("${couchbase.password}")
	private String cbPassword;
	
	@Value("${couchbase.bucket}")
	private String bucket;
	
	@Value("${couchbase.servers}")
	private String cbServers;

	public String getCbUserName() {
		return cbUserName;
	}

	public void setCbUserName(String cbUserName) {
		this.cbUserName = cbUserName;
	}

	public String getCbPassword() {
		return cbPassword;
	}

	public void setCbPassword(String cbPassword) {
		this.cbPassword = cbPassword;
	}

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public String getCbServers() {
		return cbServers;
	}

	public void setCbServers(String cbServers) {
		this.cbServers = cbServers;
	}
	
	

}
