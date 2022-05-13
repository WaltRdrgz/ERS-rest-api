package com.flexnet.reimbursement.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.auditing.EnableCouchbaseAuditing;

@Configuration
@EnableCouchbaseAuditing
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {
	
	@Autowired
	ApplicationProperties props;

    @Override
    public String getConnectionString() {
        return props.getCbServers();
    }

    @Override
    public String getUserName() {
        return props.getCbUserName();
    }

    @Override
    public String getPassword() {
        return props.getCbPassword();
    }

    @Override
    public String getBucketName() {
        return props.getBucket();
    }
}