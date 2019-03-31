package com.zhuhai.config;

import com.zhuhai.endpoint.MyEndPoint;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/31
 * Time: 22:27
 *
 * @author: hai
 */
@Configuration
public class MyEndPointConfig {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public MyEndPoint myEndPoint() {
        return new MyEndPoint();
    }
}
