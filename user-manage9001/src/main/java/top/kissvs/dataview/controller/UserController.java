package top.kissvs.dataview.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import top.kissvs.dataview.entities.CommonResult;
import top.kissvs.dataview.entities.UserInfo;
import top.kissvs.dataview.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author kiss伟少
 * @version 1.0
 * @date 2020/4/25 0025 16:16
 */

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Resource
    private UserService userService;

    @Value("${server.port}")
    private String serverPort;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping("/userReg")
    public CommonResult<UserInfo> reg(@RequestBody UserInfo userInfo){

        logger.info("reg前端传来的值："+userInfo.getUserName());

        if(userService.isReg(userInfo.getUserName())){
            userService.reg(userInfo);
            return new CommonResult(200,"注册成功！"+serverPort,userInfo.getUserName());
        }else {
            return new CommonResult(99,"注册失败！用户名已存在！",userInfo.getUserName());

        }


    }

    @PostMapping("/userLogin")
    public CommonResult<UserInfo> login(@RequestBody UserInfo userInfo, HttpSession session){



        UserInfo userInfo1 = userService.login(userInfo);

        logger.info("userLogin-------------");
        logger.info("login前端传来的值："+userInfo.getUserName());
        if( userInfo1 != null){
            logger.info(userInfo1.toString());
            session.setAttribute("user",userInfo1.getId());
            return new CommonResult(200,"登录成功！"+serverPort,userInfo1);
        }else {
            return new CommonResult(99,"登录失败！");

        }

    }

    @GetMapping("/getUser")
    public CommonResult<UserInfo> getUserInfoById(HttpSession session){

        Long id = (Long) session.getAttribute("user");

        logger.info("生产者：getUserInfoById"+id);

        if( id != null) {

            if (userService.getUserInfoById(id) != null){

                return new CommonResult<>(200,"查询用户信息成功！",userService.getUserInfoById(id));
            }else{

                return new CommonResult<>(99,"查询用户信息失败！");
            }

        }else{

            return new CommonResult<>(99,"未登录，请登录！");
        }

    }



}
