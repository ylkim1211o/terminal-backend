package mou.terminal.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collections;

@Configuration
@EnableMongoRepositories(basePackages = "mou.terminal.web.repository.mongoDB", mongoTemplateRef = "MongoTemplate")
public class MongoConfig {

    @Primary
    @Bean(name = "MongoProperties")
    @ConfigurationProperties(prefix = "mongodb")
    public MongoProperties MonngoProperties(){
        return new MongoProperties();
    }

    @Primary
    @Bean(name = "MongoClient")
    public MongoClient mongoClient(@Qualifier("MongoProperties") MongoProperties mongoProperties){
        
        return MongoClients.create(MongoClientSettings.builder()
                        .applyToClusterSettings(builder -> builder
                                .hosts(Collections.singletonList(new ServerAddress(mongoProperties.getHost(),mongoProperties.getPort()))))
                .build());
    }


    @Primary
    @Bean(name = "MongoDBFactory")
    public MongoDatabaseFactory mongoDatabaseFactory(
            @Qualifier("MongoClient") MongoClient mongoClient,
            @Qualifier("MongoProperties")MongoProperties mongoProperties
    ){

        return new SimpleMongoClientDatabaseFactory(mongoClient,
                mongoProperties.getDatabase());
    }

    @Primary
    @Bean(name = "MongoTemplate")
    public MongoTemplate mongoTemplate(@Qualifier("MongoDBFactory") MongoDatabaseFactory mongoDatabaseFactory){
        return new MongoTemplate(mongoDatabaseFactory);
    }
}
