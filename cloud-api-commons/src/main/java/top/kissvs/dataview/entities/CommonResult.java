package top.kissvs.dataview.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kiss伟少
 * @version 1.0
 * @date 2020/4/25 0025 1:18
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    public final int SUCESS=200;

    private Integer code;
    private String msg;
    private T data;


    public  CommonResult(Integer code,String msg){

        this(code,msg,null);
    }

}
