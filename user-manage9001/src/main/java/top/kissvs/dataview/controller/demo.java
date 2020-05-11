package top.kissvs.dataview.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kiss伟少
 * @version 1.0
 * @date 2020/5/2 0002 14:07
 */

@RestController
public class demo {


    @RequestMapping("/demo")
    public String demo(){

        return "hello world";
    }
}
