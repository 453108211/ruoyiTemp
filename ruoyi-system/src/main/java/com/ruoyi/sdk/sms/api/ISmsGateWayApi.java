package com.ruoyi.sdk.sms.api;


import com.ruoyi.sdk.sms.vo.request.SendMsgRequest;
import com.ruoyi.sdk.sms.vo.request.SendValidMsgRequest;
import com.ruoyi.sdk.sms.vo.request.ValidYzmRequest;
import com.ruoyi.sdk.sms.vo.respone.SendMsgRespone;
import com.ruoyi.sdk.sms.vo.respone.ValidYzmRespone;

import java.io.UnsupportedEncodingException;

/**
 * 短信平台接口
 */
public interface ISmsGateWayApi {

    /**
     * 发送短信
     */
    SendMsgRespone sendMsg(SendMsgRequest request) throws UnsupportedEncodingException;

    /**
     * 发送验证码短信
     * 注：在过期时间内短信无法再次发送
     */
    SendMsgRespone sendValidMsg(SendValidMsgRequest request) throws UnsupportedEncodingException;

    /**
     * 短信验证码 校验
     * 注：验证成功会将 缓存中(redis) 的验证码删除
     */
    ValidYzmRespone validYzm(ValidYzmRequest request) throws UnsupportedEncodingException;

    /**
     * 生成4位验证码
     * @return
     */
    String buildYzm4();
}
