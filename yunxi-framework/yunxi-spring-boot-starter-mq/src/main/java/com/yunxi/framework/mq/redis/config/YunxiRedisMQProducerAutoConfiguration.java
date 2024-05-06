package com.yunxi.framework.mq.redis.config;

import com.yunxi.framework.mq.redis.core.RedisMQTemplate;
import com.yunxi.framework.mq.redis.core.interceptor.RedisMessageInterceptor;
import com.yunxi.framework.redis.config.YunxiRedisAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

/**
 * <p>
 * Redis 消息队列 Producer 配置类
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@Slf4j
@AutoConfiguration(after = YunxiRedisAutoConfiguration.class)
public class YunxiRedisMQProducerAutoConfiguration {

    @Bean
    public RedisMQTemplate redisMQTemplate(StringRedisTemplate redisTemplate,
                                           List<RedisMessageInterceptor> interceptors) {
        RedisMQTemplate redisMQTemplate = new RedisMQTemplate(redisTemplate);
        // 添加拦截器
        interceptors.forEach(redisMQTemplate::addInterceptor);
        return redisMQTemplate;
    }

}
