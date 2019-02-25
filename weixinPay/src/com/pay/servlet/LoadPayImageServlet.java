package com.pay.servlet;

import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pay.util.HttpUtil;
import com.pay.util.MapToXmlUtil;
import com.pay.util.QRSign;
import com.pay.util.RandomStringGenerator;
import com.pay.weixinPayConfig.PayConfigUtil;

/**
 * Servlet implementation class LoadPayImageServlet
 */
public class LoadPayImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*String orderNo=DateUtil.getCurrentDateStr();//订单号
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("appid", weixinPayConfig.appid);//公众账号ID
		map.put("mch_id", weixinPayConfig.mch_id);//商户号
		map.put("device_info", weixinPayConfig.device_info);//设备号
		map.put("nonce_str", StringUtil.generateLowerString(30));//随机字符串
		map.put("notify_url", weixinPayConfig.notify_url);//异步通知地址
		map.put("trade_type", "NATIVE");//交易类型
		map.put("out_trade_no", orderNo);//商户订单号
		map.put("body", "测试商品");//商品描述
		map.put("total_fee", 100);//标价金额
		map.put("spbill_create_ip", getIP(request));//终端ip
		map.put("sign", "weitao");//签名
		String xml=XmlUtil.getRequestXmlQuery(map);
		System.out.println(xml);
		
		String i=HttpUtil.postData(weixinPayConfig.notify_url, xml);
		System.out.println(i);
	}
	
	public static String getIP(HttpServletRequest request){
		
		if(request.getHeader("x-forwarded-for")==null){
			
			return request.getRemoteAddr();
		}
		return request.getHeader("x-forwarded-for");
	}*/
	
		/*String appid = PayConfigUtil.APP_ID;  // appid  
		String mch_id = PayConfigUtil.MCH_ID; // 商户号  
		String key = PayConfigUtil.API_KEY; // key  
		String currTime = PayCommonUtil.getCurrTime();  
		String strTime = currTime.substring(8, currTime.length());  
		String strRandom = PayCommonUtil.buildRandom(4) + "";  
		String nonce_str = strTime + strRandom;          
		int order_price = 1; // 商品价格   注意：价格的单位是分  
		String body = "商品名称";   // 商品名称  
		String out_trade_no = PayCommonUtil.getCurrTime() + PayCommonUtil.buildRandom(4); // 商户订单号  
		// 获取发起电脑 ip  
		String spbill_create_ip = "127.0.0.1";  
		// 回调接口   
		String notify_url = PayConfigUtil.NOTIFY_URL;  
		String trade_type = "NATIVE";  //交易类型          
		SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();  
		packageParams.put("appid", appid);  
		packageParams.put("mch_id", mch_id);  
		packageParams.put("nonce_str", nonce_str);  
		packageParams.put("body", body);  
		packageParams.put("out_trade_no", out_trade_no);  
		packageParams.put("total_fee", String.valueOf(order_price));  
		packageParams.put("spbill_create_ip", spbill_create_ip);  
		packageParams.put("notify_url", notify_url);  
		packageParams.put("trade_type", trade_type);  
		
		String sign = PayCommonUtil.createSign("UTF-8", packageParams,key);  
	    packageParams.put("sign", sign);  
		
	    String requestXML = PayCommonUtil.getRequestXml(packageParams);  
	    System.out.println(requestXML);  
	    
	    String resXml = HttpUtil.postData(PayConfigUtil.UFDODER_URL, requestXML);       
        Map map = null;
		try {
			map = XmlUtil.doXMLParse(resXml);
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        String urlCode = (String) map.get("code_url");  
	               
	    System.out.println(urlCode);
	}*/
		
		//商户key
        String key = "mlqho2dwhxxxxxxxxxxxv81m1r6i28";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Map<String,String> map = new HashMap<String, String>();
        //公众账号ID
        map.put("appid","wssssssxxxxxxxxxe0e5b");
        //商户号
        map.put("mch_id","1xxxxxxxxx2");
        //随机数
        map.put("nonce_str", RandomStringGenerator.getRandomStringByLength(32));
        //商品描述
        map.put("body","香辣鸡腿堡");
        //订单号
        map.put("out_trade_no",sdf.format(new Date()));
        //总金额单位分
        map.put("total_fee","1");
        InetAddress ia = InetAddress.getLocalHost();
        //ip
        map.put("spbill_create_ip",ia.getHostAddress());
        //通知地址
        map.put("notify_url","www.niudao.com");
        //交易类型
        map.put("trade_type","NATIVE");
        //商品ID
        map.put("product_id","10000");
        //签名
        map.put("sign", QRSign.getSign(map, key));
        //请求地址及请求数据
        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        String data = null;
		try {
			data = MapToXmlUtil.mapToXml(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(data);
        
        
        String resXml = HttpUtil.postData(PayConfigUtil.UFDODER_URL, data);  
        System.out.println(resXml);
        /*//发送请求
        ClientRequest request = new ClientRequest(url);
        request.body("text/xml;charset=utf-8",data);
        ClientResponse response = request.post(String.class);
        //xml字符串转化成json对象
        String result = XMLAndJsonUtil.xmlChangeJson(response.getEntity().toString());
        result = result.replaceAll("\r\n","");
        JSONObject jsonObject = JSONObject.fromObject(result);
        //二维码内容
        String qrCode = "";
        if(jsonObject.get("return_code").toString().equals("SUCCESS")){
            qrCode = jsonObject.get("code_url").toString();
        }
       System.out.println(qrCode);*/
	}
}
