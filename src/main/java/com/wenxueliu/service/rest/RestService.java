package com.wenxueliu.service.rest;

import com.wenxueliu.model.User;
import feign.Feign;
import feign.Logger;
import feign.Retryer;
import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by liuwenxue on 05/04/2019.
 */
@Component
public class RestService {

    @Value("${client.github}")
    private String gitHubUrl;

    @Value("${retry.period:3000}")
    private int period;

    @Value("${retry.maxPeriod:30000}")
    private int maxPeriod;

    @Value("${retry.maxAttempts:5}")
    private int maxAttempts;

    @Bean
    public GitHubClient gitHubClient() {
        Decoder decoder = new JacksonDecoder();
        GitHubClient githubClient = Feign.builder()
                //.client(new ApacheHttpClient())
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(decoder)
                .errorDecoder(new GitHubErrorDecoder(decoder))
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.BASIC)
                .retryer(new Retryer.Default(period, maxPeriod, maxAttempts))
                .target(GitHubClient.class, gitHubUrl); // "https://api.github.com");
        return githubClient;
    }

    @Bean
    public UserClient userClient() {
        Decoder decoder = new JacksonDecoder();
        UserClient userClient = Feign.builder()
                //.client(new ApacheHttpClient())
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(decoder)
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.BASIC)
                .retryer(new Retryer.Default(period, maxPeriod, maxAttempts))
                .target(UserClient.class, gitHubUrl); // "https://api.github.com");
        return userClient;
    }

    @Bean
    public FileUploadClient fileUploadClient() {
        Decoder decoder = new JacksonDecoder();
        FileUploadClient fileUploadClient = Feign.builder()
                //.client(new ApacheHttpClient())
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(decoder)
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.BASIC)
                .retryer(new Retryer.Default(period, maxPeriod, maxAttempts))
                .target(FileUploadClient.class, gitHubUrl); // "https://api.github.com");
        return fileUploadClient;
    }


    /*
    public ApacheHttpClient createHttpClient() throws SSLException {
        HttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(createSSLContext())
                .build();
        return new ApacheHttpClient(httpClient);
    }
    */
}
