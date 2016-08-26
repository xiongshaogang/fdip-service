/**
 * 
 */
package com.trusdom.fdip.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.trusdom.fdip.model.Sgedit;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年5月20日 上午9:26:19
 * @version 1.0 
 * @parameter  
 * @return  
*/
/**
 * @author lenovo
 *
 */
public interface SgeditMapper {

	
	@Insert("insert into sgedit(trade,amount,createTime) values(#{trade},#{amount},#{createTime})")
	@Options(keyProperty="id",keyColumn="id",useGeneratedKeys=true)
	public void add(Sgedit sgedit);
}
