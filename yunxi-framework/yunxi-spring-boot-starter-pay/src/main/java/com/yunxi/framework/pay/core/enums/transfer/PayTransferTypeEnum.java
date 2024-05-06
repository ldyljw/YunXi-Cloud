package com.yunxi.framework.pay.core.enums.transfer;

import cn.hutool.core.util.ArrayUtil;
import com.yunxi.framework.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * <p>
 * 转账类型枚举
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
@Getter
@AllArgsConstructor
public enum PayTransferTypeEnum implements IntArrayValuable {

    ALIPAY_BALANCE(1, "支付宝余额"),
    WX_BALANCE(2, "微信余额"),
    BANK_CARD(3, "银行卡"),
    WALLET_BALANCE(4, "钱包余额");

    public static final String ALIPAY_LOGON_ID = "ALIPAY_LOGON_ID";
    public static final String ALIPAY_ACCOUNT_NAME = "ALIPAY_ACCOUNT_NAME";
    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(PayTransferTypeEnum::getType).toArray();
    private final Integer type;
    private final String name;

    public static PayTransferTypeEnum typeOf(Integer type) {
        return ArrayUtil.firstMatch(item -> item.getType().equals(type), values());
    }

    @Override
    public int[] array() {
        return ARRAYS;
    }

}
