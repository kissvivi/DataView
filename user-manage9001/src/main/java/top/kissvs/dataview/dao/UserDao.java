package top.kissvs.dataview.dao;

import top.kissvs.dataview.entities.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kiss伟少
 * @version 1.0
 * @date 2020/4/25 0025 14:32
 */


@Mapper
public interface UserDao {


    //注册
    int save(UserInfo userinfo);
    //登录
    UserInfo login(UserInfo userinfo);

    //是否存在注册
    UserInfo isReg(String userName);

    //注销用户
    int deleteUser(UserInfo userinfo);

    //修改密码
    int alterPassword(UserInfo userinfo);

    UserInfo getUserInfoById(Long id);
}
