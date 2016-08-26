package com.trusdom.fdip.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trusdom.fdip.common.Constants;
import com.trusdom.fdip.mappers.ChannelMapper;
import com.trusdom.fdip.model.Channel;
import com.trusdom.fdip.spring.configs.RedisConfig;

@Service
public class ChannelService {
	@Autowired
	ChannelMapper channelMapper;
	
	public Channel QueryById(Long id){
		return channelMapper.findById(id);
	}
	
	public Channel QueryByCode(String code){
		String key=""+(Constants.REDISBASEKEY+"Channel"+code).hashCode();
		Channel channel=(Channel) RedisConfig.getObject(key);
		if(channel==null&&(channel=channelMapper.findByCode(code))!=null){
			RedisConfig.set(key, channel);
		}
		return channel;
	}
}
