package com.teng.task.controller;

import com.teng.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shkstart
 * @create 2021-06-16 22:19
 */
@RestController
public class HelloController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/hello")
    public String hell0(){
        asyncService.hello();
        return "Hello World";
    }
}
