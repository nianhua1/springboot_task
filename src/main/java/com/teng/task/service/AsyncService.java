package com.teng.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author shkstart
 * @create 2021-06-16 22:17
 */
@Service
public class AsyncService {

    @Async    //告诉Spring这是一个异步方法
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中");
    }
}
