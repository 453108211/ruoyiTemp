package com.ruoyi.common.utils.jasypt;

import org.jasypt.util.text.BasicTextEncryptor;

public class JasyptStringEncryptorUtil {


    public static String encrypt(String input){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("JcgZqtyzDfFp");

        return textEncryptor.encrypt(input);
    }

    public static String decrypt(String input){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("JcgZqtyzDfFp");

        return textEncryptor.decrypt(input);
    }

    public static void main(String[] args) {

        System.out.println(encrypt("MTcwMzE0MT9k5NABo="));

    }
}
