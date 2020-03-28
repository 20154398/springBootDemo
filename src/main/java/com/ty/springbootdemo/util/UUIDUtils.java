package com.ty.springbootdemo.util;

import java.util.UUID;

public class UUIDUtils {
    private static class SingletonHolder {
        private static final UUIDUtils INSTANCE = new UUIDUtils();
    }

    public static UUIDUtils getInstance() {
        return UUIDUtils.SingletonHolder.INSTANCE;
    }

    /**
     * 32位UUID生成方法
     *
     * @return 32位UUID生成方法
     */
    public String getUUID() {
        return UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    }

}
