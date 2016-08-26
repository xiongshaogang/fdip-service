/**
 * 
 */
package com.trusdom.fdip.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trusdom.fdip.services.mcip.McipService;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年7月28日 上午10:27:42
 * @version 1.0 
 * @parameter  
 * @return  
*/
/**
 * @author lenovo
 *
 */
@Service
public class NotifyMessageUtil {

	@Autowired
	McipService mcipService;

	private static final String[] DEVELOPERS = Config.getConfigByKey("verify.err.warning", "").split(",");

	private static final String VERIFYID = Config.getConfigByKey("verify.err.sms.tpl.id");

	private static final String TRANSFERID = Config.getConfigByKey("transfer.err.sms.tpl.id");

	private static final String WITHDRAWID = Config.getConfigByKey("withdraw.err.sms.tpl.id");

	public void sendMessage(int type, String... values) {
		String id = null, value = null;
		boolean send = false;
		switch (type) {
		case 0:
			id = VERIFYID;
			send = true;
			value = Config.getDynamicConfigByKey("verify.err.sms.value", values);
			break;
		case 1:
			id = TRANSFERID;
			send = true;
			value = Config.getDynamicConfigByKey("transfer.err.sms.value", values);
			break;
		case 2:
			id = WITHDRAWID;
			send = true;
			value = Config.getDynamicConfigByKey("withdraw.err.sms.value", values);
			break;
		default:
			break;
		}
		if (send) {
			for (String phone : DEVELOPERS) {
				if (StringUtils.isNotBlank(phone) && StringUtils.isNotBlank(id)) {
					mcipService.sendTplSms(phone, id, value);
				}
			}
		}

	}
}
