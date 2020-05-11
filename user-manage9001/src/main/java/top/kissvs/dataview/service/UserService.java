package top.kissvs.dataview.service;

import org.springframework.stereotype.Service;
import top.kissvs.dataview.entities.UserInfo;

/**
 * @author kiss伟少
 * @version 1.0
 * @date 2020/4/25 0025 14:55
 */

public interface UserService {

    //注册
     UserInfo reg(UserInfo userinfo);

    //登录
     UserInfo login(UserInfo userinfo);

    //是否存在注册
     Boolean isReg(String userName);

    //注销用户
     Boolean deleteUser(UserInfo userinfo);

    //修改密码
     Boolean alterPassword(UserInfo userinfo);

    //获取用户信息
    UserInfo getUserInfoById(Long id);
}
