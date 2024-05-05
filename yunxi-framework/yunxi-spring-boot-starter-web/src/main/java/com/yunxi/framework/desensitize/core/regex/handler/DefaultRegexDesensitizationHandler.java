package com.yunxi.framework.desensitize.core.regex.handler;

import com.yunxi.framework.desensitize.core.regex.annotation.RegexDesensitize;

/**
 * <p>
 * {@link RegexDesensitize}的正则脱敏处理器
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
public class DefaultRegexDesensitizationHandler extends AbstractRegexDesensitizationHandler<RegexDesensitize> {

    @Override
    String getRegex(RegexDesensitize annotation) {
        return annotation.regex();
    }

    @Override
    String getReplacer(RegexDesensitize annotation) {
        return annotation.replacer();
    }

}
