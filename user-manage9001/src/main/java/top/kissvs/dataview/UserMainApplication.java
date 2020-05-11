package top.kissvs.dataview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author kiss伟少
 * @version 1.0
 * @date 2020/4/25 0025 17:29
 */


@SpringBootApplication
@EnableEurekaClient
public class UserMainApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserMainApplication.class,args);
    }

}
