package com.trusdom.fdip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trusdom.fdip.form.AccountForm;
import com.trusdom.fdip.form.BalanceForm;
import com.trusdom.fdip.form.IncomeForm;
import com.trusdom.fdip.form.IncomeRateForm;
import com.trusdom.fdip.form.SyncIncomeForm;
import com.trusdom.fdip.services.AccountService;
import com.trusdom.fdip.services.IncomeRateService;
import com.trusdom.fdip.services.IncomeService;
import com.trusdom.fdip.vo.AbstractVo;
import com.trusdom.fdip.vo.BaseVo;

@Controller
@RequestMapping(value="/fund", method=RequestMethod.POST)
public class AccountController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	@Autowired
	AccountService accountService;
	
	@Autowired
	IncomeRateService incomeRateService;
	
	@Autowired
	IncomeService incomeService;
	
	@RequestMapping(value="/openAccount")
	public @ResponseBody BaseVo openAccount(@RequestBody @Validated AccountForm accountForm,BindingResult bindingResult) throws Exception{
		LOGGER.info("正在进行基金账户开户操作; params: [{}]", accountForm);
		if(bindingResult.hasErrors()){
			LOGGER.error("基金账户开户请求参数有误! [{}]", bindingResult.getFieldError().getDefaultMessage());
			return BaseVo.error(bindingResult.getFieldError().getDefaultMessage());
		}
		BaseVo result = accountService.openAccount(accountForm);
		LOGGER.info("基金账户开户返回结果: [{}]",result);
		return result;
	}
	
	@RequestMapping(value="/balance")
	public @ResponseBody BaseVo balance(@RequestBody @Validated BalanceForm form, BindingResult errors){
		LOGGER.info("有息余额查询; params: [{}]", form);
		if(errors.hasErrors()){
			LOGGER.info("有息余额查询请求参数有误! [{}]", errors.getFieldError().getDefaultMessage());
			return BaseVo.error(errors.getFieldError().getDefaultMessage());
		}
		BaseVo result = accountService.balance(form.getAccountNo(), form.getChannel(), form.getFundCode());
		LOGGER.info("有息余额查询返回结果: [{}]", result);
		return result;
	}
	
	@RequestMapping("/income")
	public @ResponseBody BaseVo income(@RequestBody @Validated IncomeForm form, BindingResult errors){
		LOGGER.info("账户收益查询; params: [{}]", form);
		if(errors.hasErrors()){
			LOGGER.info("账户收益查询请求参数有误; [{}]", errors.getFieldError().getDefaultMessage());
			return BaseVo.error(errors.getFieldError().getDefaultMessage());
		}
		BaseVo result = accountService.income(form.getAccountNo(), form.getChannel(), form.getFundCode());
		LOGGER.info("账户收益查询返回结果: [{}]", result);
		return result;
	}
	
	@RequestMapping("/income/history")
	public @ResponseBody AbstractVo historyIncome(@RequestBody @Validated IncomeForm form, BindingResult errors){
		if(errors.hasErrors()){
			return BaseVo.error(errors.getFieldError().getDefaultMessage());
		}
		return accountService.historyIncome(form.getAccountNo(), form.getChannel(), form.getFundCode(), form.getStartTime(), form.getEndTime());
	}
	
	@RequestMapping("/incomeRate")
	public @ResponseBody AbstractVo incomeRate(@RequestBody @Validated IncomeRateForm form, BindingResult errors){
		LOGGER.info("万份收益/七日年化收益率查询; params: [{}]", form);
		if(errors.hasErrors()){
			LOGGER.info("万份收益/七日年化收益率查询请求参数有误: [{}]", errors.getFieldError().getDefaultMessage());
			return BaseVo.error(errors.getFieldError().getDefaultMessage());
		}
		AbstractVo result = incomeRateService.find(form);
		LOGGER.info("万份收益/七日年化收益率查询返回结果: [{}]", result);
		return result;
	}
	
	/**
	 * 业务支撑系统 渠道返利 统计
	 * @param form
	 * @param errors
	 * @return
	 */
	@RequestMapping("/sync/income")
	public @ResponseBody AbstractVo syncIncome(@RequestBody @Validated SyncIncomeForm form, BindingResult errors){
		if(errors.hasErrors()){
			return BaseVo.error(errors.getFieldError().getDefaultMessage());
		}
		return incomeService.findTotalIncomeByDay(form.getDay(), form.getPage(), form.getSize());
	}
}
