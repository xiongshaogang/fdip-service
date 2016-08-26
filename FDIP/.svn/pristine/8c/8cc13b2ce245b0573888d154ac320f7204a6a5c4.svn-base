package com.trusdom.fdip.services.cbip;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.trusdom.fdip.common.CodeBuilder;
import com.trusdom.fdip.common.Config;
import com.trusdom.fdip.common.Json;
import com.trusdom.fdip.vo.cbip.CapitalAllocationVo;

@Service
public class AccountTransferService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountTransferService.class);
	
	@Autowired
	RestTemplate rest;
	
	public CapitalAllocationVo frozen(String accountNo, BigDecimal amount) throws Exception{
		LOGGER.info("正在进行摊位号为[{}]用户的资金冻结操作, 冻结金额为: [{}]!", accountNo, amount);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountNo", accountNo);
		params.put("amount", amount);
		params.put("orderNo",CodeBuilder.generatorTradeNo(null));
		LOGGER.info("参数信息: [{}]", Json.toJson(params));
		CapitalAllocationVo result = rest.postForObject(Config.getConfigByKey("cbipBaseUrl")+Config.getConfigByKey("cbip.capital.frozen"), Json.toJson(params), CapitalAllocationVo.class);
		LOGGER.info("资金冻结操作结果:[{}]", result);
		return result;
	}
	
	public CapitalAllocationVo unFrozen(String accountNo, BigDecimal amount){
		LOGGER.info("正在进行摊位号为[{}]用户的资金解冻操作, 解冻金额为: [{}]!", accountNo, amount);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountNo", accountNo);
		params.put("amount", amount);
		params.put("orderNo",CodeBuilder.generatorTradeNo(null));
		LOGGER.info("参数信息: [{}]", Json.toJson(params));
		CapitalAllocationVo result = rest.postForObject(Config.getConfigByKey("cbipBaseUrl")+Config.getConfigByKey("cbip.capital.unfrozen"), Json.toJson(params), CapitalAllocationVo.class);
		LOGGER.info("资金解冻操作结果:[{}]", result);
		return result;
	}
	
	public CapitalAllocationVo transfer(String channel, String accountNo, String transferType, BigDecimal amount){
		LOGGER.info("正在进行资金划拨,channel:[{}]-accountNo:[{}]-amount:[{}]-transferType:[{}];", new Object[]{channel, accountNo, amount, transferType});
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("channel", channel);
		params.put("accountNo", accountNo);
		params.put("amount", amount);
		params.put("transferType", transferType);
		params.put("orderNo",CodeBuilder.generatorTradeNo(null));
		LOGGER.info("参数信息: [{}]", Json.toJson(params));
		CapitalAllocationVo result = rest.postForObject(Config.getConfigByKey("cbipBaseUrl")+Config.getConfigByKey("cbip.capital.transfer"), Json.toJson(params), CapitalAllocationVo.class);
		LOGGER.info("资金划拨操作结果:[{}]", result);
		return result;
	}
}
