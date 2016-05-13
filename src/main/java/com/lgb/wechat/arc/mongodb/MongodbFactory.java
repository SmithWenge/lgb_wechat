package com.lgb.wechat.arc.mongodb;

import com.google.common.base.Optional;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:db/mongodb.properties")
public class MongodbFactory {
    @Bean
    private static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Value(value = "${mongodb.host}")
    private static String mongodbHost;
    @Value(value = "${mongodb.port}")
    private static String port;
    @Value(value = "${mongodb.db}")
    private static String db;

    private static MongoClient client = new MongoClient(mongodbHost, Integer.valueOf(port));

    private MongodbFactory() {

    }

    public static MongoClient getClientInstance() {
        Optional<MongoClient> optional = Optional.fromNullable(client);
        if (optional.isPresent()) {
            return client;
        }

        return new MongoClient(mongodbHost, Integer.valueOf(port));
    }

    public static String getDb() {
        return db;
    }
}
