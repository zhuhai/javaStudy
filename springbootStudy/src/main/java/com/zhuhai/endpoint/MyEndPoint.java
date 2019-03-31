package com.zhuhai.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/31
 * Time: 22:24
 *  自定义监控端点
 * @author: hai
 */
@Endpoint(id = "myPoint")
public class MyEndPoint {

    @ReadOperation
    public Map<String, String> hello() {
        Map<String, String> result = new HashMap<>();
        result.put("author", "Levin");
        result.put("age", "24");
        result.put("email", "1837307557@qq.com");
        return result;
    }
}
