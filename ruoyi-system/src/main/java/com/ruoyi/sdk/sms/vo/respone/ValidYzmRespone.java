package com.ruoyi.sdk.sms.vo.respone;

import lombok.Data;

/**
 * 短信验证码回调接口
 */
@Data
public class ValidYzmRespone {

    /** Code 为 1 表示任务提交成功，其他值都是失败； */
    private Integer code;

    /** 本次处理描述 */
    private String text;

    /** 平台生成的本次任务编号 */
    private String smsid;

    /** 正常发送的号码，如号码不在此中，则是无效号码，不会发送，不会有状态报告； */
    private String phones;

    private boolean valid;

    /**
     * 判断是否验证成功
     * @return
     */
    public boolean isValid(){
        if(this.code != null && this.code == 1 && valid) return true;
        return false;
    }
}
