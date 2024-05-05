package com.yunxi.framework.desensitize.core.handler;

import com.yunxi.framework.desensitize.core.annotation.Address;
import com.yunxi.framework.desensitize.core.base.handler.DesensitizationHandler;

/**
 * <p>
 * {@link Address} 的脱敏处理器
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
public class AddressHandler implements DesensitizationHandler<Address> {

    @Override
    public String desensitize(String origin, Address annotation) {
        return origin + annotation.replacer();
    }

}
