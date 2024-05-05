package com.yunxi.framework.desensitize.core.regex.handler;

import com.yunxi.framework.desensitize.core.regex.annotation.EmailDesensitize;

/**
 * <p>
 * {@link EmailDesensitize} 的脱敏处理器
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
public class EmailDesensitizationHandler extends AbstractRegexDesensitizationHandler<EmailDesensitize> {

    @Override
    String getRegex(EmailDesensitize annotation) {
        return annotation.regex();
    }

    @Override
    String getReplacer(EmailDesensitize annotation) {
        return annotation.replacer();
    }

}
