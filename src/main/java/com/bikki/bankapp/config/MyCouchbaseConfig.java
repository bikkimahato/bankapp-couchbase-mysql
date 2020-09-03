package com.bikki.bankapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.bikki.bankapp"})
public class MyCouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    public String getConnectionString() {
        return "localhost";
    }

    @Override
    public String getUserName() {
        return "bikki";
    }

    @Override
    public String getPassword() {
        return "bikkimahato";
    }

    @Override
    public String getBucketName() {
        return "bankapp";
    }

}