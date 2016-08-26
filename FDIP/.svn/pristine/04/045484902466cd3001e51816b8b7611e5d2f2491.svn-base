/**
 * 
 */
package com.trusdom.fdip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trusdom.fdip.common.CodeBuilder;
import com.trusdom.fdip.form.BuyOrRedeForm;
import com.trusdom.fdip.services.BuyFundService;
import com.trusdom.fdip.services.FundService;
import com.trusdom.fdip.services.IncomeRateService;
import com.trusdom.fdip.services.RedeFundService;
import com.trusdom.fdip.vo.AbstractVo;
import com.trusdom.fdip.vo.BaseVo;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年5月18日 上午11:47:44
 * @version 1.0 
 * @parameter  
 * @return  
*/

@Controller
@RequestMapping("/fund")
public  class FundController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FundController.class);
	@Autowired
	BuyFundService buyFundService;
	
	@Autowired
	RedeFundService redeFundService;
	
	@Autowired
	FundService fundService;
	
	@Autowired
	IncomeRateService incomeRateService;
	
	@RequestMapping(method=RequestMethod.POST,value="/purchase1")
	@ResponseBody
	public AbstractVo buy(@RequestBody  @Validated BuyOrRedeForm buyOrRedeForm,BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return BaseVo.error(bindingResult.getFieldError().getDefaultMessage());
		}
		try {
			return buyFundService.buyThs(buyOrRedeForm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return BaseVo.error("global.systemError");
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/redemption1")
	@ResponseBody
	public AbstractVo rede(@RequestBody  @Validated BuyOrRedeForm buyOrRedeForm,BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return BaseVo.error(bindingResult.getFieldError().getDefaultMessage());
		}
		try {
			return redeFundService.RedeThs(buyOrRedeForm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return BaseVo.error("global.systemError");
		}
	}
	

	@RequestMapping(value="/purchase", method=RequestMethod.POST)
	@ResponseBody
	public BaseVo purchase(@RequestBody @Validated BuyOrRedeForm form,BindingResult bindingResult){
		LOGGER.info("正在进行申购操作; params: [{}]", form);
		if(bindingResult.hasErrors()){
			LOGGER.error("申购请求参数有误! [{}]", bindingResult.getFieldError().getDefaultMessage());
			return BaseVo.error(bindingResult.getFieldError().getDefaultMessage());
		}
		BaseVo result = fundService.purchase(form);
		LOGGER.info("申购返回结果: [{}]", result);
		return result;
	}
	
	@RequestMapping(value="/redemption", method=RequestMethod.POST)
	@ResponseBody
	public BaseVo redemption(@RequestBody  @Validated BuyOrRedeForm form,BindingResult bindingResult){
		LOGGER.info("正在进行赎回操作; params: [{}]", form);
		if(bindingResult.hasErrors()){
			LOGGER.error("赎回请求参数有误! [{}]", bindingResult.getFieldError().getDefaultMessage());
			return BaseVo.error(bindingResult.getFieldError().getDefaultMessage());
		}
		BaseVo result = fundService.redemption(form);
		LOGGER.info("赎回返回结果: [{}]", result);
		return result;
	}
	
	
	@RequestMapping(value="/status/{channelCode}/{fundCode}",method=RequestMethod.GET)
	@ResponseBody
	public BaseVo fundStatus(@PathVariable String channelCode,@PathVariable String fundCode){
		BaseVo result=fundService.getFundStatus(channelCode, fundCode);
		return result;
	}
}
