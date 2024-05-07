package com.yunxi.module.system.dal.redis.oauth2;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.yunxi.framework.common.util.collection.CollectionUtils;
import com.yunxi.framework.common.util.json.JsonUtils;
import com.yunxi.module.system.dal.dataobject.oauth2.OAuth2AccessTokenDO;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.yunxi.module.system.dal.redis.RedisKeyConstants.OAUTH2_ACCESS_TOKEN;

/**
 * <p>
 * {@link OAuth2AccessTokenDO} 的 RedisDAO
 * </p>
 *
 * @author lidy
 * @since 2024-05-07
 */
@Repository
public class OAuth2AccessTokenRedisDAO {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 格式化缓存 Key
     *
     * @param accessToken token
     * @return Redis 缓存 Key
     */
    private static String formatKey(String accessToken) {
        return String.format(OAUTH2_ACCESS_TOKEN, accessToken);
    }

    public OAuth2AccessTokenDO get(String accessToken) {
        String redisKey = formatKey(accessToken);
        return JsonUtils.parseObject(stringRedisTemplate.opsForValue().get(redisKey), OAuth2AccessTokenDO.class);
    }

    public void set(OAuth2AccessTokenDO accessTokenDO) {
        String redisKey = formatKey(accessTokenDO.getAccessToken());
        // 清理多余字段，避免缓存
        accessTokenDO.setUpdater(null);
        accessTokenDO.setUpdateTime(null);
        accessTokenDO.setCreateTime(null);
        accessTokenDO.setCreator(null);
        accessTokenDO.setDeleted(null);
        long time = LocalDateTimeUtil.between(LocalDateTime.now(), accessTokenDO.getExpiresTime(), ChronoUnit.SECONDS);
        if (time > 0) {
            stringRedisTemplate.opsForValue().set(redisKey, JsonUtils.toJsonString(accessTokenDO), time, TimeUnit.SECONDS);
        }
    }

    /**
     * 删除 Redis 缓存
     *
     * @param accessToken token
     */
    public void delete(String accessToken) {
        String redisKey = formatKey(accessToken);
        stringRedisTemplate.delete(redisKey);
    }

    /**
     * 批量删除 Redis 缓存
     *
     * @param accessTokens token 集合
     */
    public void deleteList(Collection<String> accessTokens) {
        List<String> redisKeys = CollectionUtils.convertList(accessTokens, OAuth2AccessTokenRedisDAO::formatKey);
        stringRedisTemplate.delete(redisKeys);
    }

}
