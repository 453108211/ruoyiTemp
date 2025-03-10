package com.ruoyi.sdk.sms.vo.request;

import com.ruoyi.sdk.sms.conf.SmsConfig;
import com.ruoyi.sdk.sms.util.SHA;
import com.ruoyi.sdk.sms.vo.Application;
import lombok.Data;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * appCode(必填) appKey(必填) 根据第三方平台获取
 * mobilePhone(必填) 发送的手机号码，多个手机号码之间用“,”分割（英文）
 * content(必填) 短信内容 （内容开头使用【】）
 * yzm(必填)  验证码（客户端自己生成）
 * expire(必填) 验证码有效时长（单位：秒）
 * timestamp(必填) 当前时间戳
 * sign 调用该类的createSign 自动生成
 */
@Data
public class SendValidMsgRequest extends Application {

    @NotNull
    private String mobilePhone;

    @NotNull
    private String content;

    @NotNull
    private String yzm;

    @NotNull
    private Integer expir;

    @NotNull
    private String timestamp;

    @NotNull
    private String sign;

    public SendValidMsgRequest(){
        setAppCode(SmsConfig.appCode);
        setAppKey(SmsConfig.appKey);
    }

    /**
     * 生成 签名
     */
    public void createSign() throws UnsupportedEncodingException {
        Assert.hasLength(super.getAppCode(), "应用code不能为空！");
        Assert.hasLength(super.getAppKey(), "应用key不能为空！");
        Assert.hasLength(mobilePhone, "手机号码不能为空！");
        Assert.hasLength(content, "短信内容不能为空！");
        Assert.hasLength(yzm, "验证码不能为空！");
        Assert.notNull(expir, "验证码有效时长不能为空！");
        Assert.notNull(timestamp, "时间戳不能为空！");

        this.setSign( SHA.SHA1(super.getAppCode() + super.getAppKey() + mobilePhone + URLEncoder.encode(content, "utf-8") + yzm + expir + timestamp) );
    }
}
