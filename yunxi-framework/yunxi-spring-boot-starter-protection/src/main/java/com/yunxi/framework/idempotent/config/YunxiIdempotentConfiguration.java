package com.yunxi.framework.idempotent.config;

import com.yunxi.framework.idempotent.core.aop.IdempotentAspect;
import com.yunxi.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import com.yunxi.framework.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import com.yunxi.framework.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import com.yunxi.framework.idempotent.core.keyresolver.impl.UserIdempotentKeyResolver;
import com.yunxi.framework.idempotent.core.redis.IdempotentRedisDAO;
import com.yunxi.framework.redis.config.YunxiRedisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

/**
 * <p>
 * 幂等自动配置类
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@AutoConfiguration(after = YunxiRedisAutoConfiguration.class)
public class YunxiIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public UserIdempotentKeyResolver userIdempotentKeyResolver() {
        return new UserIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
