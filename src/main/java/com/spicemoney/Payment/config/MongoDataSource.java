package com.spicemoney.Payment.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDataSource {

  @Autowired
  Environment env;

  @Bean
  public MongoClient mongoClient () throws UnsupportedEncodingException {
    String url = env.getProperty("spring.data.mongodb.uri");

    String password = URLEncoder.encode(env.getProperty("spring.data.mongodb.password"), "UTF-8");

    url = url.replace("**user**", env.getProperty("spring.data.mongodb.username"));
    url = url.replace("**pass**", password);
    return MongoClients.create(url);
  }

  @Bean
  public MongoTemplate mongoTemplate () throws UnsupportedEncodingException {
    return new MongoTemplate(mongoClient(), env.getProperty("spring.data.mongodb.database"));
  }
}