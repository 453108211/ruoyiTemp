package com.ruoyi.sdk.sms.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * appCode(必填) appKey(必填) 根据第三方平台获取
 */
@Data
public class Application {

    @NotNull
    private String appCode;

    @NotNull
    private String appKey;
}
