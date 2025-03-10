package com.ruoyi.sdk.sms.vo.respone;

import lombok.Data;

/**
 * 短信接口回调实体
 */
@Data
public class SendMsgRespone {

    /** Code 为 1 表示任务提交成功，其他值都是失败； */
    private Integer code;

    /** 本次处理描述 */
    private String text;

    /** 平台生成的本次任务编号 */
    private String smsid;

    /** 正常发送的号码，如号码不在此中，则是无效号码，不会发送，不会有状态报告； */
    private String phones;

    /**
     * 判断是否发送成功
     * @return
     */
    public boolean isSuccess(){
        if(this.code != null && this.code == 1) return true;
        return false;
    }
}
