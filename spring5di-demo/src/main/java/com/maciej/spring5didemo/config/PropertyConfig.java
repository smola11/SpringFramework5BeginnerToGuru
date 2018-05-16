package com.maciej.spring5didemo.config;

import com.maciej.spring5didemo.examplebeans.FakeDataSource;
import com.maciej.spring5didemo.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class PropertyConfig {

    @Value("${guru.username}")
    private String user;
    @Value("${guru.password}")
    private String password;
    @Value(("${guru.dburl}"))
    private String url;

    @Value("${guru.jms.username}")
    private String jmsUsername;
    @Value("${guru.jms.password}")
    private String jmsPassword;
    @Value(("${guru.jms.dburl}"))
    private String jmsUrl;

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUsername(jmsUsername);
        fakeJmsBroker.setPassword(jmsPassword);
        fakeJmsBroker.setUrl(jmsUrl);
        return fakeJmsBroker;
    }

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }
}
