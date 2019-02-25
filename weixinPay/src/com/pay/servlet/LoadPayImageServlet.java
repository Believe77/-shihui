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
		
		/*String orderNo=DateUtil.getCurrentDateStr();//������
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("appid", weixinPayConfig.appid);//�����˺�ID
		map.put("mch_id", weixinPayConfig.mch_id);//�̻���
		map.put("device_info", weixinPayConfig.device_info);//�豸��
		map.put("nonce_str", StringUtil.generateLowerString(30));//����ַ���
		map.put("notify_url", weixinPayConfig.notify_url);//�첽֪ͨ��ַ
		map.put("trade_type", "NATIVE");//��������
		map.put("out_trade_no", orderNo);//�̻�������
		map.put("body", "������Ʒ");//��Ʒ����
		map.put("total_fee", 100);//��۽��
		map.put("spbill_create_ip", getIP(request));//�ն�ip
		map.put("sign", "weitao");//ǩ��
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
		String mch_id = PayConfigUtil.MCH_ID; // �̻���  
		String key = PayConfigUtil.API_KEY; // key  
		String currTime = PayCommonUtil.getCurrTime();  
		String strTime = currTime.substring(8, currTime.length());  
		String strRandom = PayCommonUtil.buildRandom(4) + "";  
		String nonce_str = strTime + strRandom;          
		int order_price = 1; // ��Ʒ�۸�   ע�⣺�۸�ĵ�λ�Ƿ�  
		String body = "��Ʒ����";   // ��Ʒ����  
		String out_trade_no = PayCommonUtil.getCurrTime() + PayCommonUtil.buildRandom(4); // �̻�������  
		// ��ȡ������� ip  
		String spbill_create_ip = "127.0.0.1";  
		// �ص��ӿ�   
		String notify_url = PayConfigUtil.NOTIFY_URL;  
		String trade_type = "NATIVE";  //��������          
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
		
		//�̻�key
        String key = "mlqho2dwhxxxxxxxxxxxv81m1r6i28";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Map<String,String> map = new HashMap<String, String>();
        //�����˺�ID
        map.put("appid","wssssssxxxxxxxxxe0e5b");
        //�̻���
        map.put("mch_id","1xxxxxxxxx2");
        //�����
        map.put("nonce_str", RandomStringGenerator.getRandomStringByLength(32));
        //��Ʒ����
        map.put("body","�������ȱ�");
        //������
        map.put("out_trade_no",sdf.format(new Date()));
        //�ܽ�λ��
        map.put("total_fee","1");
        InetAddress ia = InetAddress.getLocalHost();
        //ip
        map.put("spbill_create_ip",ia.getHostAddress());
        //֪ͨ��ַ
        map.put("notify_url","www.niudao.com");
        //��������
        map.put("trade_type","NATIVE");
        //��ƷID
        map.put("product_id","10000");
        //ǩ��
        map.put("sign", QRSign.getSign(map, key));
        //�����ַ����������
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
        /*//��������
        ClientRequest request = new ClientRequest(url);
        request.body("text/xml;charset=utf-8",data);
        ClientResponse response = request.post(String.class);
        //xml�ַ���ת����json����
        String result = XMLAndJsonUtil.xmlChangeJson(response.getEntity().toString());
        result = result.replaceAll("\r\n","");
        JSONObject jsonObject = JSONObject.fromObject(result);
        //��ά������
        String qrCode = "";
        if(jsonObject.get("return_code").toString().equals("SUCCESS")){
            qrCode = jsonObject.get("code_url").toString();
        }
       System.out.println(qrCode);*/
	}
}
