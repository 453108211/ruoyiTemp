package com.ruoyi.sdk.sms.api.impl;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.sdk.sms.api.ISmsGateWayApi;
import com.ruoyi.sdk.sms.conf.SmsConfig;
import com.ruoyi.sdk.sms.vo.request.SendMsgRequest;
import com.ruoyi.sdk.sms.vo.request.SendValidMsgRequest;
import com.ruoyi.sdk.sms.vo.request.ValidYzmRequest;
import com.ruoyi.sdk.sms.vo.respone.SendMsgRespone;
import com.ruoyi.sdk.sms.vo.respone.ValidYzmRespone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.Random;

@Service
public class SmsGateWayApi implements ISmsGateWayApi {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 发送短信
     */
    @Override
    public SendMsgRespone sendMsg(SendMsgRequest request) throws UnsupportedEncodingException {
        /** 判断签名是否生成 */
        if(StringUtils.isEmpty(request.getSign())) request.createSign();

        return restTemplate.postForObject(SmsConfig.SMSGATEWAY_SENDMSG, request, SendMsgRespone.class);
    }

    /**
     * 发送验证码短信
     */
    @Override
    public SendMsgRespone sendValidMsg(SendValidMsgRequest request) throws UnsupportedEncodingException {
        /** 判断签名是否生成 */
        if(StringUtils.isEmpty(request.getSign())) request.createSign();

        return restTemplate.postForObject(SmsConfig.SMSGATEWAY_SENDVALIDMSG, request, SendMsgRespone.class);
    }

    /**
     * 短信验证码 校验
     */
    @Override
    public ValidYzmRespone validYzm(ValidYzmRequest request) throws UnsupportedEncodingException {
        /** 判断签名是否生成 */
        if(StringUtils.isEmpty(request.getSign())) request.createSign();

        return restTemplate.postForObject(SmsConfig.SMSGATEWAY_VALIDYZM, request, ValidYzmRespone.class);
    }

    private static final int[] YZMARR = {0,1,2,3,4,5,6,7,8,9};

    @Override
    public String buildYzm4() {
        Random rand = new Random();
        int index = 0;
        String randStr = "";
        for (int i=0; i<6; ++i){
            index = rand.nextInt(YZMARR.length-1);
            randStr += YZMARR[index];
        }
        return randStr;
    }
}
