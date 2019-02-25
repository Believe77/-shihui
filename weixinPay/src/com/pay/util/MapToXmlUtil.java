package com.pay.util;

import java.util.Map;

public class MapToXmlUtil {

	/**
     * 将map 转化成 xml
     * @param map
     * @return
     */
    public static String mapToXml(Map<String,String> map)throws Exception{
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("<" + entry.getKey() + ">" + entry.getValue().toString() + "</" + entry.getKey() + ">");
        }
        sb.append("</xml>");
        return sb.toString();
    }
	
}
