package top.kissvs.dataview.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author kiss伟少
 * @version 1.0
 * @date 2020/5/2 0002 20:49
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
