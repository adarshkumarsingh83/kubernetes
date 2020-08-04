package com.espark.adarsh.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

import java.util.Arrays;

@Configuration
@EnableSolrRepositories(
        basePackages = "com.espark.adarsh",
        namedQueriesLocation = "classpath:solr-named-queries.properties")
@Slf4j
@ComponentScan
public class ApplicationConfig {

    @Value("${spring.data.solr.zk-host}")
    private String zkHost;

    @Value("${spring.data.solr.host}")
    private String[] solrHost;

    @Bean
    public SolrClient solrClient() {
        CloudSolrClient solrClient = new CloudSolrClient.Builder(Arrays.asList(solrHost)).withZkHost(zkHost).build();
        solrClient.setDefaultCollection("employee");
        return solrClient;
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient solrClient) {
        SolrTemplate solrTemplate =  new SolrTemplate(solrClient);
        return solrTemplate;
    }
}
