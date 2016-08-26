/**
 * 
 */
package com.trusdom.fdip.vo;

import com.trusdom.fdip.common.HttpUtil;
import com.trusdom.fdip.common.Json;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年6月2日 下午2:52:59
 * @version 1.0 
 * @parameter  
 * @return  
*/
/**
 * @author lenovo
 *
 */
public class ThsMcipBuyFundResponseVo extends AbstractVo<ThsMcipBuyFundResponseVo> {

	private Data data;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public class Data {

		private String appsheetSerialNo;

		public String getAppsheetSerialNo() {
			return appsheetSerialNo;
		}

		public void setAppsheetSerialNo(String appsheetSerialNo) {
			this.appsheetSerialNo = appsheetSerialNo;
		}

	}

	public static void main(String[] args) {
		String result = "{\"success\":true,\"errCode\":\"\",\"errMsg\":\"\",\"data\":{\"appsheetSerialNo\":\"00000000000100060803\"}}";
		ThsMcipBuyFundResponseVo thsMcipBuyFundResponseVo = Json.fromJson(Json.parse(result),
				ThsMcipBuyFundResponseVo.class);
		System.out.println(thsMcipBuyFundResponseVo.getData().getAppsheetSerialNo());
	}

}
