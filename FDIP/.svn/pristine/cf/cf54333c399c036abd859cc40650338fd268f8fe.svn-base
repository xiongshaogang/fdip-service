package com.trusdom.fdip.mappers;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import com.trusdom.fdip.model.Holiday;

public class HolidaySQLProvider {

	private static final String TABLE = "holiday";

	public String syncSql(Map<String, List<Holiday>> map) {
		StringBuffer sb = new StringBuffer();
		sb.append("insert into ").append(TABLE)
				.append(" (year, day, name, description, festival, sort) ")
				.append(" values ");
		List<Holiday> holidays = map.get("holidays");
		MessageFormat messageFormat = new MessageFormat(
				"(#'{'holidays[{0}].year},#'{'holidays[{0}].day},#'{'holidays[{0}].name},#'{'holidays[{0}].description},#'{'holidays[{0}].festival},#'{'holidays[{0}].sort})");
		for (int i = 0; i < holidays.size(); i++) {
			sb.append(messageFormat.format(new Integer[] { i }));
			sb.append(",");
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}

}
