package com.pay.util;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;

public class QRSign {

	 /**
     * ΢��֧��ǩ���㷨sign
     * @param map ����΢֧��body
     * @param key �̻�key (���ǹ��ں�key)
     * @return
     */
    public static String getSign(Map<String,String> map,String key) {
        StringBuffer sb = new StringBuffer();
        String[] keyArr = (String[]) map.keySet().toArray(new String[map.keySet().size()]);//��ȡmap�е�keyתΪarray
        Arrays.sort(keyArr);//��array����
        for (int i = 0, size = keyArr.length; i < size; ++i) {
            if ("sign".equals(keyArr[i])) {
                continue;
            }
            sb.append(keyArr[i] + "=" + map.get(keyArr[i]) + "&");
        }
        sb.append("key=" + key);
        String sign = string2MD5(sb.toString());
        return sign;
    }

    /***
     * MD5���� ����32λmd5��
     */
    public static String string2MD5(String str){
        if (str == null || str.length() == 0) {
            return null;
        }
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };

        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf).toUpperCase();
        } catch (Exception e) {
            return null;
        }
    }
}
