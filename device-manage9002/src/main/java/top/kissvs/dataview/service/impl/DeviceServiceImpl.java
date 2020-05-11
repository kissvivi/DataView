package top.kissvs.dataview.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.kissvs.dataview.dao.DeviceDao;
import top.kissvs.dataview.entities.DeviceInfo;
import top.kissvs.dataview.service.DeviceService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kiss伟少
 * @version 1.0
 * @date 2020/5/2 0002 20:23
 */
@Service
public class DeviceServiceImpl implements DeviceService {


    private final Logger logger = LoggerFactory.getLogger(DeviceServiceImpl.class);


    @Resource
    private DeviceDao deviceDao;


    @Override
    public int addDevice(DeviceInfo deviceinfo) {

        deviceinfo.setCreateDate(new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date()));

        logger.info("设备添加成功！");

            return deviceDao.addDevice(deviceinfo);

    }

    @Override
    public int startDevice(String userId, String deviceId) {
        return 0;
    }

    @Override
    public int delDevice(String userId, String deviceId) {
        return 0;
    }

    @Override
    public DeviceInfo selectDevice(String deviceName) {
        return deviceDao.selectDevice(deviceName);
    }
}
