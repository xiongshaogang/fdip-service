/**
 * 
 */
package com.trusdom.fdip.common;

import com.trusdom.fdip.common.Json;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年5月17日 下午3:07:40
 * @version 1.0 
 * @parameter  
 * @return  
*/

public class BaseCase {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Json.toJson(this).toString();
	}
}
