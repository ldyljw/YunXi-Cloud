package com.yunxi.framework.pay.core.client.impl.wechat;

import com.yunxi.framework.pay.core.enums.channel.PayChannelEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 微信支付【小程序】的 PayClient 实现类
 * </p>
 * 由于公众号和小程序的微信支付逻辑一致，所以直接进行继承
 * <p>
 * 文档：<a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_5_1.shtml">JSAPI 下单</>
 *
 * @author lidy
 * @since 2024-05-06
 */
@Slf4j
public class WxLitePayClient extends WxPubPayClient {

    public WxLitePayClient(Long channelId, WxPayClientConfig config) {
        super(channelId, PayChannelEnum.WX_LITE.getCode(), config);
    }

}
