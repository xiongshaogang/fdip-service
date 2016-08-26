/**
 * 
 */
package com.trusdom.fdip.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.trusdom.fdip.model.CapitalAllocation;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年6月1日 下午2:17:15
 * @version 1.0 
 * @parameter  
 * @return  
*/

public interface CapitalAllocationMapper {
	
	@Insert("insert into capital_allocation(txTradeNo,tradeNos, amount,status,type,remark,occurTime) values(#{txTradeNo},#{tradeNos},#{amount},#{status},#{type},#{remark},#{occurTime})")
	@Options(keyProperty="id",keyColumn="id",useGeneratedKeys=true)
	void insert(CapitalAllocation capitalAllocation);
	
	@Select("select * from capital_allocation where tradeNos=#{tradeNos}")
	List<CapitalAllocation> findByTradeNos(@Param("tradeNos") String tradeNos);
}
