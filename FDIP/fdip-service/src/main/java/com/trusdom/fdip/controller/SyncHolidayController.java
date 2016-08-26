package com.trusdom.fdip.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trusdom.fdip.model.Holiday;
import com.trusdom.fdip.services.HolidayService;

@Controller
@RequestMapping("/holiday")
public class SyncHolidayController {

	@Autowired
	HolidayService holidayService;
	
	@RequestMapping("/sync")
	public @ResponseBody String syncHoliday(@RequestBody List<Holiday> holidays){
		holidayService.syncHoliday(holidays);
		return "ok";
	}
	
	@RequestMapping("/nextWorkday")
	public @ResponseBody String nextWorkday(){
		Calendar cal = Calendar.getInstance();
		return holidayService.nextWorkDay(cal).toString();
	}
	
	@RequestMapping("/payday")
	public @ResponseBody String payday(){
		return holidayService.getPayDay().toString();
	}
	
	@RequestMapping("/all")
	public @ResponseBody List<Holiday> all(){
		return holidayService.queryAllHoliday();
	}
}
