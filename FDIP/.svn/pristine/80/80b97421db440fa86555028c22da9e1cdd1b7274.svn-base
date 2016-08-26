package com.trusdom.fdip.mappers;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

public class FundProvider {

	private static final String TABLE = "fund";
	
	public String updateThsFundStatus(){
		BEGIN();
		UPDATE(TABLE);
		SET("fstMinPurchaseAmount=#{fund.fstMinPurchaseAmount}, maxPurchaseAmount=#{fund.maxPurchaseAmount}, minRedemption=#{fund.minRedemption}, maxRedemption=#{fund.maxRedemption}, minAccountBalance=#{fund.minAccountBalance}, thsStatus=#{fund.thsStatus}, updateTime=#{fund.updateTime}");
		WHERE("id=#{fund.id}");
		return SQL();
	}
}
