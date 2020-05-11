package top.kissvs.dataview.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kiss伟少
 * @version 1.0
 * @date 2020/5/2 0002 16:15
 */

@RestController
public class Demo {


    @RequestMapping("/hello")
    public String hello(){


        return "hello";
    }
}
