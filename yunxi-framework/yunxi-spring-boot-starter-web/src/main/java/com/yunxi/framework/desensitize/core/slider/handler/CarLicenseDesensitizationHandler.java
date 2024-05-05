package com.yunxi.framework.desensitize.core.slider.handler;

import com.yunxi.framework.desensitize.core.slider.annotation.CarLicenseDesensitize;

/**
 * <p>
 * {@link CarLicenseDesensitize} 的脱敏处理器
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
public class CarLicenseDesensitizationHandler extends AbstractSliderDesensitizationHandler<CarLicenseDesensitize> {
    @Override
    Integer getPrefixKeep(CarLicenseDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getSuffixKeep(CarLicenseDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getReplacer(CarLicenseDesensitize annotation) {
        return annotation.replacer();
    }

}
