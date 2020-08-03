package com.espark.adarsh.config;

import com.datastax.driver.core.AuthProvider;
import com.datastax.driver.core.PlainTextAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Autowired
    ApplicationProps applicationProps;

    @Override
    protected String getKeyspaceName() {
        return this.applicationProps.getKeyspaceName();
    }

    @Override
    protected String getContactPoints() {
        return this.applicationProps.getContactPoints();
    }

    @Override
    protected int getPort() {
        return this.applicationProps.getPort();
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return Collections.singletonList(CreateKeyspaceSpecification
                .createKeyspace(this.applicationProps.getKeyspaceName())
                .ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true)
                .withSimpleReplication()
        );
    }

   /* @Override
    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
        return Collections.singletonList(DropKeyspaceSpecification
                .dropKeyspace(keyspaceName));
    }*/

    @Bean
    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterConnectionRetryingService bean = new CassandraClusterConnectionRetryingService();
        bean.setAddressTranslator(getAddressTranslator());
        bean.setAuthProvider(getAuthProvider());
        bean.setClusterBuilderConfigurer(getClusterBuilderConfigurer());
        bean.setClusterName(getClusterName());
        bean.setCompressionType(getCompressionType());
        bean.setContactPoints(getContactPoints());
        bean.setLoadBalancingPolicy(getLoadBalancingPolicy());
        bean.setMaxSchemaAgreementWaitSeconds(getMaxSchemaAgreementWaitSeconds());
        bean.setMetricsEnabled(getMetricsEnabled());
        bean.setNettyOptions(getNettyOptions());
        bean.setPoolingOptions(getPoolingOptions());
        bean.setPort(getPort());
        bean.setProtocolVersion(getProtocolVersion());
        bean.setQueryOptions(getQueryOptions());
        bean.setReconnectionPolicy(getReconnectionPolicy());
        bean.setRetryPolicy(getRetryPolicy());
        bean.setSpeculativeExecutionPolicy(getSpeculativeExecutionPolicy());
        bean.setSocketOptions(getSocketOptions());
        bean.setTimestampGenerator(getTimestampGenerator());

        bean.setKeyspaceCreations(getKeyspaceCreations());
        bean.setKeyspaceDrops(getKeyspaceDrops());
        bean.setStartupScripts(getStartupScripts());
        bean.setShutdownScripts(getShutdownScripts());
        return bean;
    }


    @Override
    public String[] getEntityBasePackages() {
        return new String[]{this.applicationProps.getEntityBasePackage()};
    }

    @Override
    protected AuthProvider getAuthProvider() {
        return new PlainTextAuthProvider(this.applicationProps.getUsername(), this.applicationProps.getPassword());
    }

}
