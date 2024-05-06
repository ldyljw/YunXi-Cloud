package com.yunxi.framework.pay.core.client.impl;

import com.yunxi.framework.pay.core.client.PayClientConfig;
import lombok.Data;

import javax.validation.Validator;

/**
 * <p>
 * 无需任何配置 PayClientConfig 实现类
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@Data
public class NonePayClientConfig implements PayClientConfig {

    /**
     * 配置名称
     * <p>
     * 如果不加任何属性，JsonUtils.parseObject2 解析会报错，所以暂时加个名称
     */
    private String name;

    public NonePayClientConfig() {
        this.name = "none-config";
    }

    @Override
    public void validate(Validator validator) {
        // 无任何配置不需要校验
    }

}
