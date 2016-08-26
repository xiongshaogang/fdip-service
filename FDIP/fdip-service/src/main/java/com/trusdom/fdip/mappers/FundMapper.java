package com.trusdom.fdip.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;

import com.trusdom.fdip.model.Fund;

public interface FundMapper {
	@Select({"select * from fund where id = #{id}"})
	Fund findById(Long id);
	
	@Select({"select * from fund where code = #{code}"})
	@Results(
		@Result(property="channel",column="channel",one=@One(select="com.trusdom.fdip.mappers.ChannelMapper.findById",fetchType=FetchType.EAGER))
	)
	Fund findByCode(String code);
	
	@Insert({"insert into fund (code,name,channel,status,createTime,updateTime) values (#{code},#{name},#{channel.id},#{status},#{createTime},#{updateTime})"})
	@Options(keyProperty="id",keyColumn="id",useGeneratedKeys=true)
	Long insert(Fund fund);
	
	@Select({"select channel from fund where code = #{code}"})
	@Results(
			@Result(property="channel",column="channel",one=@One(select="com.trusdom.fdip.mappers.ChannelMapper.findById",fetchType=FetchType.EAGER))
		)
	Fund findChannelByCode(String code);
	
	@Select({"select * from fund where channel = #{channel}"})
	@Results(
		@Result(property="channel",column="channel",one=@One(select="com.trusdom.fdip.mappers.ChannelMapper.findById",fetchType=FetchType.EAGER))
	)
	List<Fund> findByChannel(@Param("channel") long channel);
	
	@UpdateProvider(type=FundProvider.class, method="updateThsFundStatus")
	void updateThsFund(@Param("fund")Fund fund);
}
