package com.trusdom.fdip.mappers;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.trusdom.fdip.model.Holiday;

public interface HolidayMapper {

	@InsertProvider(type=HolidaySQLProvider.class, method="syncSql")
	void sync(@Param("holidays")List<Holiday> holidays);
	
	@Select("select count(*) from holiday where day = #{day}")
	int exists(String day);
	
	@Select("select * from holiday ")
	List<Holiday> all();
}
