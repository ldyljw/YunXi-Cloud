package com.yunxi.framework.pay.core.client;

import com.yunxi.framework.pay.core.enums.channel.PayChannelEnum;

/**
 * <p>
 * 支付客户端的工厂接口
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
public interface PayClientFactory {

    /**
     * 获得支付客户端
     *
     * @param channelId 渠道编号
     * @return 支付客户端
     */
    PayClient getPayClient(Long channelId);

    /**
     * 创建支付客户端
     *
     * @param channelId   渠道编号
     * @param channelCode 渠道编码
     * @param config      支付配置
     */
    <Config extends PayClientConfig> void createOrUpdatePayClient(Long channelId, String channelCode,
                                                                  Config config);

    /**
     * 注册支付客户端 Class，用于模块中实现的 PayClient
     *
     * @param channel        支付渠道的编码的枚举
     * @param payClientClass 支付客户端 class
     */
    void registerPayClientClass(PayChannelEnum channel, Class<?> payClientClass);

}
