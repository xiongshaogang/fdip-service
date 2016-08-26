package com.trusdom.fdip.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.trusdom.fdip.model.Account;
import com.trusdom.fdip.model.Account.Status;

public interface AccountMapper {
	
	@Insert({"insert into account(accountNo,bankAccountNo,bankAccount,name,credential,tradePwd, status, createTime, updateTime) values(#{accountNo},#{bankAccountNo},#{bankAccount},#{name},#{credential},#{tradePwd},#{status}, #{createTime}, #{updateTime})"})
	@Options(keyProperty="id",keyColumn="id",useGeneratedKeys=true)
	Long insert(Account account);
	
	@Select({"select * from account where id = #{id}"})
	Account findById(Long id);
	
	@Select({"select * from account where accountNo = #{accountNo}"})
	Account findByAccountNo(String accountNo);
	
	@Select("select accountNo from account where id = #{id}")
	String getAccountNoById(Long id);
	
	@Update("update account set status = #{status} where id = #{id}")
	void enableOrDisable(@Param("id")Long id, @Param("status")Status status);
}
