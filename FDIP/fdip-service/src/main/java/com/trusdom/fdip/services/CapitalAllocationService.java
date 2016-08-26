/**
 * 
 */
package com.trusdom.fdip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trusdom.fdip.mappers.CapitalAllocationMapper;
import com.trusdom.fdip.model.CapitalAllocation;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年6月6日 下午3:55:19
 * @version 1.0 
 * @parameter  
 * @return  
*/
/**
 * @author lenovo
 *
 */
@Service
public class CapitalAllocationService {
	
	@Autowired
	CapitalAllocationMapper capitalAllocationMapper;
	

	/**
	 * 资金划拨记录
	 * @param channel
	 * @param bigDecimal
	 */
	@Transactional
	public void transferAmount(CapitalAllocation capitalAllocation){
		capitalAllocationMapper.insert(capitalAllocation);
	}
	
	
	/**
	 * 获取资金划拨的结果集
	 */
	public List<CapitalAllocation> findBytradeNOs(String tradeNos){
		return capitalAllocationMapper.findByTradeNos(tradeNos);
	}
	
}
