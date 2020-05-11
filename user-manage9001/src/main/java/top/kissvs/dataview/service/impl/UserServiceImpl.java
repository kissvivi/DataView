package top.kissvs.dataview.service.impl;

import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.kissvs.dataview.dao.UserDao;
import top.kissvs.dataview.entities.UserInfo;
import top.kissvs.dataview.service.UserService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kiss伟少
 * @version 1.0
 * @date 2020/4/25 0025 14:59
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    public UserDao userdao;

    @Override
    public UserInfo reg(UserInfo userinfo) {
        userinfo.setCreateDate(new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date()));


        logger.info("MD5之前明文:"+userinfo.getPassWord());

        //密码MD5 加密
        userinfo.setPassWord(SecureUtil.md5(userinfo.getPassWord()));

        logger.info("MD5:"+userinfo.getPassWord());

        if(userdao.save(userinfo) > 0){

            Long id = userinfo.getId();
            logger.info("注册成功！id:"+id);

            userinfo.setId(id);
            return userinfo;
        }else{
        return userinfo;}
    }


    @Override
    public UserInfo login(UserInfo userinfo) {


        logger.info("登录验证1:"+userinfo.getPassWord());

        //密码MD5 加密
        userinfo.setPassWord(SecureUtil.md5(userinfo.getPassWord()));

        logger.info("登录成功:"+userinfo.getPassWord());

        return userdao.login(userinfo);
    }

    @Override
    public Boolean isReg(String userName) {

        boolean b = true;

        if(userdao.isReg(userName) != null){
            b = false;
            logger.info("用户已存在！");
        };
        return b;
    }

    @Override
    public Boolean deleteUser(UserInfo userinfo) {

        boolean b = false;

        if(userdao.deleteUser(userinfo) > 0){
            b = true;
            logger.info("用户已注销！");
        }
        return b;
    }

    @Override
    public Boolean alterPassword(UserInfo userinfo) {

        boolean b = false;

        if(userdao.alterPassword(userinfo) > 0){
            b = true;
            logger.info("用户密码已修改！");
        }
        return b;
    }

    @Override
    public UserInfo getUserInfoById(Long id) {

        logger.info("根据id查询用户中！");
        return userdao.getUserInfoById(id);
    }
}
