/**
 * 
 */
package com.trusdom.fdip.vo;

import java.util.List;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年6月25日 上午10:28:20
 * @version 1.0 
 * @parameter  
 * @return  
*/
/**
 * @author lenovo
 *
 */
public class ThsMcipTradingResponseVo extends AbstractVo<ThsMcipTradingResponseVo>{
	
	private Data data;
	
	public class Data{
		
		public List<TradingVo> getTradelist() {
			return tradelist;
		}
		public void setTradelist(List<TradingVo> tradelist) {
			this.tradelist = tradelist;
		}
		public String getSum() {
			return sum;
		}
		public void setSum(String sum) {
			this.sum = sum;
		}
		private List<TradingVo> tradelist;
		private String sum;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

}
