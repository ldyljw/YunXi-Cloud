package com.yunxi.framework.desensitize.core.slider.handler;

import com.yunxi.framework.desensitize.core.slider.annotation.BankCardDesensitize;

/**
 * <p>
 * {@link BankCardDesensitize} 的脱敏处理器
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
public class BankCardDesensitizationHandler extends AbstractSliderDesensitizationHandler<BankCardDesensitize> {

    @Override
    Integer getPrefixKeep(BankCardDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getSuffixKeep(BankCardDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getReplacer(BankCardDesensitize annotation) {
        return annotation.replacer();
    }

}