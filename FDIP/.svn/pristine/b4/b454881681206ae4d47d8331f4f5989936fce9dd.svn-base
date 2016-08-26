package com.trusdom.fdip.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.Message;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.bridge.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trusdom.fdip.common.Json;
import com.trusdom.fdip.common.NotifyMessageUtil;
import com.trusdom.fdip.model.Account3RD;
import com.trusdom.fdip.model.AccountFundAmount;
import com.trusdom.fdip.model.Trade;
import com.trusdom.fdip.model.Trade.Status;
import com.trusdom.fdip.model.account3RD.ThsAccount;
import com.trusdom.fdip.services.Account3RDService;
import com.trusdom.fdip.services.AccountFundAmountService;
import com.trusdom.fdip.services.TradeService;
import com.trusdom.fdip.services.VerifyService;
import com.trusdom.fdip.vo.BaseVo;

@Controller
@RequestMapping("/notify")
public class TradeNotifyController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TradeNotifyController.class);
	
	@Autowired
	VerifyService verifyService;
	
	@Autowired
	TradeService tradeService;
	
	@Autowired
	Account3RDService account3RDService;
	
	@Autowired
	AccountFundAmountService accountFundAmountService;
	
	@Autowired
	NotifyMessageUtil notifyMessageUtil;
	
	@RequestMapping("/ths/fundTrade/result")
	public @ResponseBody String fundTradeNotify(@RequestParam("downDate") final String downDate){
		new Thread(new Runnable() {
			public void run() {
				//同步交易记录状态
				verifyService.trade(downDate);
				//同步分红数据
				verifyService.income(downDate);
				//对账
				verifyService.verify(downDate);
			}
		}).start();
		return "OK";
	}
}
