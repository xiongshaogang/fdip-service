package com.trusdom.fdip.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import com.trusdom.fdip.model.Income;
import com.trusdom.fdip.vo.IncomeResult;

public interface IncomeMapper {

	@Insert("insert into income(channel, fund, account, day, income, interestAmount,realIncome, createTime) values(#{channel}, #{fund}, #{account}, #{day}, #{income}, #{interestAmount},#{realIncome}, #{createTime})")
	@Options(keyProperty="id",keyColumn="id",useGeneratedKeys=true)
	void save(Income income);
	
	@Update("update income set realIncome=#{realIncome} where id=#{id}")
	void update(Income income);

	@Select("select * from income where channel=#{channel} and fund=#{fund} and account=#{account} and day=#{day} limit 0,1")
	Income findMyIncomeByDay(@Param("account") long account, @Param("channel") long channel, @Param("fund") long fund, @Param("day") String day);
	
	@Select("select * from income where account=#{account} and channel=#{channel} and fund=#{fund} and day>=#{start} and day<=#{end}") 
	List<Income> findByDates(@Param("account") long account, @Param("channel") long channel, @Param("fund") long fund, @Param("start") String start, @Param("end") String end);
	
	@Select("select account, sum(income) as income, sum(interestAmount) as interestAmount from income where day=#{day} group by account,day limit ${start}, ${size}")
	@Results(
			@Result(property="accountNo",column="account",one=@One(select="com.trusdom.fdip.mappers.AccountMapper.getAccountNoById",fetchType=FetchType.EAGER))
		)
	List<IncomeResult> findTotalIncomeByDay(@Param("day") String day, @Param("start")int start, @Param("size")int size);
	
	@Select("SELECT COUNT(*) FROM (SELECT DISTINCT(account) FROM income WHERE day=#{day}) as accounts")
	int findTotalNumByDay(@Param("day") String day);
}
