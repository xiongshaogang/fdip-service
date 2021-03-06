package com.trusdom.fdip.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trusdom.fdip.mappers.IncomeMapper;
import com.trusdom.fdip.mappers.IncomeRateMapper;
import com.trusdom.fdip.model.Income;
import com.trusdom.fdip.model.IncomeRate;
import com.trusdom.fdip.vo.IncomeResult;
import com.trusdom.fdip.vo.SyncIncomeVo;

@Service
public class IncomeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(IncomeService.class);

	@Autowired
	IncomeMapper incomeMapper;
	
	@Autowired
	IncomeRateMapper incomeRateMapper;
	
	public Income findIncomeByDay(long account, long channel, long fund, String day){
		return incomeMapper.findMyIncomeByDay(account, channel, fund, day);
	}
	
	public List<Income> findIncomeByDates(long account, long channel, long fund, String startTime, String endTime){
		return incomeMapper.findByDates(account, channel, fund, startTime, endTime);
	}
	
	
	public IncomeRate findIncomeRateByDay(long channel, long fund, String day){
		return incomeRateMapper.findByDay(channel, fund, day);
	}
	
	public List<IncomeRate> findIncomeRateByDates(long channel, long fund, String startTime, String endTime){
		return incomeRateMapper.findByDate(channel, fund, startTime, endTime);
	}
	
	@Transactional
	public void updateRealAmount(Income income ){
		incomeMapper.update(income);
	}
	
	public SyncIncomeVo<IncomeResult> findTotalIncomeByDay(String day, int page, int size){
		SyncIncomeVo<IncomeResult> result = new SyncIncomeVo<IncomeResult>();
		result.setDay(day);
		result.setPage(page);
		result.setSize(size);
		result.setTotal(incomeMapper.findTotalNumByDay(day));
		int start = (page-1)*size;
		result.setResults(incomeMapper.findTotalIncomeByDay(day, start, size));
		return result;
	}
}
