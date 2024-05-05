package com.yunxi.framework.desensitize.core.slider.handler;

import com.yunxi.framework.desensitize.core.slider.annotation.PasswordDesensitize;

/**
 * <p>
 * {@link PasswordDesensitize} 的码脱敏处理器
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
public class PasswordDesensitizationHandler extends AbstractSliderDesensitizationHandler<PasswordDesensitize> {
    @Override
    Integer getPrefixKeep(PasswordDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getSuffixKeep(PasswordDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getReplacer(PasswordDesensitize annotation) {
        return annotation.replacer();
    }

}