package com.espark.adarsh.config;

import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.SolrClientFactory;
import org.springframework.data.solr.server.support.HttpSolrClientFactory;

@Configuration
@ComponentScan
@EnableSolrRepositories(basePackages = {"com.espark.adarsh"})
public class SolrConfig {

    @Autowired
    SolrConfigProperties solrConfigProperties;

    @Bean
    SolrTemplate solrTemplate() {
        return new SolrTemplate(solrServerFactory());
    }

    @Bean
    SolrClientFactory solrServerFactory() {
        Credentials credentials = new UsernamePasswordCredentials(solrConfigProperties.getUsername(), solrConfigProperties.getPassword());
        return new HttpSolrClientFactory(solrServer(), credentials, "BASIC");
    }

    @Bean
    SolrClient solrServer() {
        return new HttpSolrClient(solrConfigProperties.getHost());
    }
}