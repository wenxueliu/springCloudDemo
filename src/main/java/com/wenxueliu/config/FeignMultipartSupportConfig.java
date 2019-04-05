package com.wenxueliu.config;

//import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import feign.codec.Encoder;


/**
 * Created by liuwenxue on 17/03/2019.
 * Feign文件上传Configuration
 */
@Configuration
public class FeignMultipartSupportConfig {

    @Bean
    @Primary
    @Scope("prototype")
    public Encoder multipartFormEncoder() {
        //return new SpringFormEncoder();
        return null;
    }
}
