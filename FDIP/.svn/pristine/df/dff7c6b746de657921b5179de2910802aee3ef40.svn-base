package com.trusdom.fdip.services.mcip;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.trusdom.fdip.common.Config;
import com.trusdom.fdip.common.Json;

@Service
public class McipService {

	@Autowired
	RestTemplate rest;
	
	public void sendTplSms(String mobile, String tplId, String tplValue){
		Map<String, String> params = new HashMap<String, String>();
		params.put("mobile", mobile);
		params.put("tplId", tplId);
		params.put("tplValue", tplValue);
		String result =rest.postForObject(Config.getConfigByKey("mcipBaseUrl")+Config.getConfigByKey("send.sms"), Json.toJson(params), String.class);
		System.err.println(result);
	}
}
