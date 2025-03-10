package com.ruoyi.common.utils.pwd;

import java.util.regex.Pattern;


public class PasswordUtils {

    // 正则表达式匹配强密码的规则
    /**
     * 包含小写字母、大写字母、数字和特殊字符
     */
    private static final Pattern STRONG_PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&=^]).{8,}$");

    /**
     * 判断密码是否强度足够（符合正则表达式）
     * @param password 待判断的密码
     * @return 如果密码强度足够返回true，否则返回false
     */
    public static boolean isStrongPassword(String password) {
        return STRONG_PASSWORD_PATTERN.matcher(password).matches();
    }
}
