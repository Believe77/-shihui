package com.pay.weixinPayConfig;

import javax.servlet.http.HttpServletRequest;

public class PayConfigUtil {

	 public static final String APP_ID = "";//΢�ſ���ƽ̨Ӧ��ID(���ں�ID)
	 public static final String MCH_ID = "";//�̻���(�̻���ID)
	 public static final String API_KEY = "";//API key(�̻��������)
	 public static final String CREATE_IP = "";//����֧����ip
	 public static final String NOTIFY_URL = "";//�ص���ַ
	 public static final String UFDODER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";//΢��ͳһ�µ��ӿ�
	 public static final String APP_SECRET = "";//Ӧ�ö�Ӧ��ƾ֤(�ڹ��ں�����)
	 
	 //��ȡip
	 public static String getIP(HttpServletRequest request)
	 {
	     String ip = request.getRemoteAddr();
	     return ip;
	 }
	
}
