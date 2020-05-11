package top.kissvs.dataview.dao;

import org.apache.ibatis.annotations.Mapper;
import top.kissvs.dataview.entities.DeviceInfo;

/**
 * @author kiss伟少
 * @version 1.0
 * @date 2020/5/2 0002 19:39
 */
@Mapper
public interface DeviceDao {

    //添加设备
    int addDevice(DeviceInfo deviceinfo);

    //启用设备
    int startDevice(String userId,String deviceId);

    //设备注销
    int delDevice(String userId,String deviceId);

    //搜索设备
    DeviceInfo selectDevice(String deviceName);
}
