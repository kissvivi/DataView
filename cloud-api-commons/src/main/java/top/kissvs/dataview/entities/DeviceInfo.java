package top.kissvs.dataview.entities;

import lombok.Data;

/**
 * @author kiss伟少
 * @version 1.0
 * @date 2020/4/25 0025 19:52
 */

@Data
public class DeviceInfo {

    private long id ;
    private String deviceName ;
    private String deviceAddr ;
    private long classId ;
    private int deviceGpsx ;
    private int deviceGpsy ;
    private int isDelete ;
    private String createDate ;
}
