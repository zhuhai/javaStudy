package com.zhuhai.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/4/1
 * Time: 22:26
 *
 * @author: hai
 */
@Component
@Slf4j
public class MyTask {

    //@Async
    //@Scheduled(cron = "0/5 * * * * ?")
    public void task1() throws InterruptedException {
        log.info("task execute：{}", LocalDateTime.now());
        Thread.sleep(2000);

    }

    //@Scheduled(fixedRate = 1000)
    public void task2() throws InterruptedException {
        log.info("task2 execute...");
        Thread.sleep(2000);

    }

    //@Scheduled(fixedDelay = 3000)
    public void task3() throws InterruptedException {
        log.info("task2 excute...");
        Thread.sleep(2000);

    }


}
