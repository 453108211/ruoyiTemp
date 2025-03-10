package com.ruoyi.web;

import com.ruoyi.common.utils.jasypt.JasyptStringEncryptorUtil;

public class Test {
    public static void main(String[] args) {
        String encStr = JasyptStringEncryptorUtil.encrypt("123");
        System.out.println("encStr::" + encStr);
        String decStr = JasyptStringEncryptorUtil.decrypt(encStr);
        System.out.println("decStr::" + decStr);
    }
}
