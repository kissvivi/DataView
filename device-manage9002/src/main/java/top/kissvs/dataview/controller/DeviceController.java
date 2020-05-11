package top.kissvs.dataview.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kissvs.dataview.entities.CommonResult;
import top.kissvs.dataview.entities.DeviceInfo;
import top.kissvs.dataview.service.DeviceService;

import javax.annotation.Resource;

/**
 * @author kiss伟少
 * @version 1.0
 * @date 2020/5/2 0002 21:35
 */

@RestController
@RequestMapping("/device")
public class DeviceController {

    private final Logger logger = LoggerFactory.getLogger(DeviceController.class);


    @Resource
    private DeviceService deviceService;

    @PostMapping("/addDevice")
    public CommonResult <DeviceInfo> addDevice(DeviceInfo deviceInfo){

        if(deviceService.addDevice(deviceInfo)>0){
            logger.info("设备添加成功！");
            return new CommonResult<>(200,"设备添加成功！");

        }else{
            logger.error("设备添加失败",new Throwable().getMessage());
            return new CommonResult<>(99,"设备添加失败！");
        }
    }

    @PostMapping("/selectDevice")
    public CommonResult <DeviceInfo> selectDevice(DeviceInfo deviceInfo){

        if(deviceService.selectDevice(deviceInfo.getDeviceName()) != null){
            logger.info("设备搜索成功！");
            return new CommonResult<>(200,"设备搜索成功！",deviceService.selectDevice(deviceInfo.getDeviceName()));

        }else{
            logger.error("设备搜索失败",new Throwable().getMessage());
            return new CommonResult<>(99,"设备搜索失败！");
        }
    }


}
