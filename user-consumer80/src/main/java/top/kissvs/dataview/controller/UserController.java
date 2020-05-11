package top.kissvs.dataview.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.kissvs.dataview.entities.CommonResult;
import top.kissvs.dataview.entities.UserInfo;

import javax.annotation.Resource;

/**
 * @author kiss伟少
 * @version 1.0
 * @date 2020/5/2 0002 20:45
 */

@RestController
@Slf4j
@RequestMapping("/consumer")
public class UserController {

    //public static final String USER_URL = "http://127.0.0.1:9001";

    public static final String USER_URL = "http://CLOUD-GATEWAY-SERVICE/";

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/user/userLogin")
    public CommonResult<UserInfo> login(UserInfo userInfo){

        logger.info("login前端传来的值："+userInfo.getUserName());
        return restTemplate.postForObject(USER_URL+"user/userLogin",userInfo,CommonResult.class);
    }

    @GetMapping("/user/userReg")
    public CommonResult<UserInfo> reg(UserInfo userInfo){
        logger.info("reg前端传来的值："+userInfo.getUserName());
        return restTemplate.postForObject(USER_URL+"user/userReg",userInfo,CommonResult.class);
    }

    @GetMapping("/user/getUser")
    public CommonResult<UserInfo> getUser(){
        //logger.info("reg前端传来的值："+userInfo.getUserName());

        logger.info("消费者：getUser");
        return restTemplate.getForObject(USER_URL+"user/getUser",CommonResult.class);
    }

}
