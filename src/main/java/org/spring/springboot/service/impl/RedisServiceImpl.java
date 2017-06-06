package org.spring.springboot.service.impl;

import javax.annotation.Resource;

import org.spring.springboot.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	public void set(String key, Object value) {
		ValueOperations<String, Object> vo = redisTemplate.opsForValue();
		vo.set(key, value);
	}

	public Object get(String key) {
		ValueOperations<String, Object> vo = redisTemplate.opsForValue();
		return vo.get(key);
	}

}
