package com.yunxi.framework.mybatis.core.enums;


import com.baomidou.mybatisplus.annotation.DbType;

/**
 * <p>
 * SQL  相关常量类
 * </p>
 *
 * @author lidy
 * @since 2024-05-06
 */
public class SqlConstants {

    /**
     * 数据库的类型
     */
    public static DbType DB_TYPE;

    public static void init(DbType dbType) {
        DB_TYPE = dbType;
    }
}
