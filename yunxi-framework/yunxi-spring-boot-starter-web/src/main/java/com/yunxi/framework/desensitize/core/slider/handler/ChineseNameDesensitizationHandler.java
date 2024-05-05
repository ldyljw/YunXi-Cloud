package com.yunxi.framework.desensitize.core.slider.handler;

import com.yunxi.framework.desensitize.core.slider.annotation.ChineseNameDesensitize;

/**
 * <p>
 * {@link ChineseNameDesensitize} 的脱敏处理器
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
public class ChineseNameDesensitizationHandler extends AbstractSliderDesensitizationHandler<ChineseNameDesensitize> {

    @Override
    Integer getPrefixKeep(ChineseNameDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getSuffixKeep(ChineseNameDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getReplacer(ChineseNameDesensitize annotation) {
        return annotation.replacer();
    }

}