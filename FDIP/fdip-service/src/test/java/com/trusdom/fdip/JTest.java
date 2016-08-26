package com.trusdom.fdip;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.trusdom.fdip.common.Constants;
import com.trusdom.fdip.mappers.FundMapper;
import com.trusdom.fdip.mappers.IncomeMapper;
import com.trusdom.fdip.mappers.IncomeRateMapper;
import com.trusdom.fdip.mappers.TradeMapper;
import com.trusdom.fdip.model.Fund;
import com.trusdom.fdip.model.Income;
import com.trusdom.fdip.model.IncomeRate;
import com.trusdom.fdip.spring.configs.AppConfig;
import com.trusdom.fdip.spring.configs.RedisConfig;
import com.trusdom.fdip.vo.AmountTransferVo;

public class JTest {

	AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
	@Before
	public void config(){
		ctx.register(AppConfig.class);
		ctx.refresh();
	}
	@Test
	public void incomeMapperTest() {
		Income income = new Income();
		income.setAccount(1);
		income.setChannel(1);
		income.setFund(1);
		income.setDay("2016-05-10");
		income.setIncome(new BigDecimal(10));
		income.setInterestAmount(income.getIncome());
		income.setCreateTime(new Date());
		IncomeMapper mapper = ctx.getBean(IncomeMapper.class);
		mapper.save(income);
		System.err.println(mapper.findMyIncomeByDay(1, 1, 1, "2016-05-10"));
	}
	
	@Test
	public void incomeRateMapperTest() {
		IncomeRate rate = new IncomeRate();
		rate.setChannel(1);
		rate.setFund(1);
		rate.setDay("2016-05-10");
		rate.setMillionIncomeRate(new BigDecimal(0.456));
		rate.setAnnualIncome7d(new BigDecimal(1.234));
		rate.setCreateTime(new Date());
		IncomeRateMapper mapper = ctx.getBean(IncomeRateMapper.class);
		mapper.save(rate);
		System.err.println(mapper.findByDay(1, 1, "2016-05-10"));
	}
	
	@Test
	public void channelTest(){
		TradeMapper tradeMapper=ctx.getBean(TradeMapper.class);
		List<AmountTransferVo> list=tradeMapper.findTransfer(Constants.SDF_DATE.format(new Date()));
		System.out.println(list.get(0).getTotal());
	}
	
	@Test
	public void channel(){
		RedisConfig.getObject("1111");
	}

}
