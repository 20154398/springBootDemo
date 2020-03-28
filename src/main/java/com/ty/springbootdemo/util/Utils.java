package com.ty.springbootdemo.util;

public class Utils {
    private static class SingletonHolder {
        private static final Utils INSTANCE = new Utils();
    }

    public static Utils getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String deCode(String msg){
        char[] c = msg.toCharArray();
        for (int i = 0; i < c.length; i++) {
            c[i] = (char) (c[i] ^ 1997);
        }
        return new String(c);
    }

    public String enCode(String msg){
        return deCode(msg);
    }
}
