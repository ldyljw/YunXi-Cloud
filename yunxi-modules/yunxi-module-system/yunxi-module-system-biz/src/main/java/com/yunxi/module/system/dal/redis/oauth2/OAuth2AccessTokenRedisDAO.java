package com.yunxi.module.system.dal.redis.oauth2;

import com.yunxi.framework.common.util.collection.CollectionUtils;
import com.yunxi.module.system.dal.dataobject.oauth2.OAuth2AccessTokenDO;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

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

    public void set(oauth2accesstoken accessTokenDO) {

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
