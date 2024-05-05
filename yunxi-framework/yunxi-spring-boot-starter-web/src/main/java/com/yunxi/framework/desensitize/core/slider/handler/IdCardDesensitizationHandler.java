package com.yunxi.framework.desensitize.core.slider.handler;

import com.yunxi.framework.desensitize.core.slider.annotation.IdCardDesensitize;

/**
 * <p>
 * {@link IdCardDesensitize} 的脱敏处理器
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
public class IdCardDesensitizationHandler extends AbstractSliderDesensitizationHandler<IdCardDesensitize> {
    @Override
    Integer getPrefixKeep(IdCardDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getSuffixKeep(IdCardDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getReplacer(IdCardDesensitize annotation) {
        return annotation.replacer();
    }

}