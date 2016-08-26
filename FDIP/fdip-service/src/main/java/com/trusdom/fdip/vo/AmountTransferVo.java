package com.trusdom.fdip.vo;

import java.math.BigDecimal;

/**
 * @author zhihuayang E-mail:425273175@qq.com
 * @date 创建时间：2016年6月22日 上午10:11:42
 * @version 1.0
 * @parameter
 * @return
 */

public class AmountTransferVo {

	private BigDecimal total;// 资金总金额

	private Long channel;// 渠道

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Long getChannel() {
		return channel;
	}

	public void setChannel(Long channel) {
		this.channel = channel;
	}

}
