package top.kissvs.dataview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author kiss伟少
 * @version 1.0
 * @date 2020/5/2 0002 21:09
 */

@SpringBootApplication
@EnableEurekaClient
public class UserConsumerMain80 {

    public static void main(String[] args) {
        SpringApplication.run(UserConsumerMain80.class,args);
    }
}
