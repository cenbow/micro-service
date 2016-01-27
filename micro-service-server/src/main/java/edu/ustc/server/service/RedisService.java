package edu.ustc.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisCluster;

@Service
@EnableScheduling
public class RedisService {
	
	@Autowired
	private JedisCluster jedisCluster;
	
	@Scheduled(fixedDelay = 1000 * 60 * 60)
	public void print() {
		System.out.println(jedisCluster);
	}
	
	public boolean lockUpdateOperation(String id) {
		
		if(1 == jedisCluster.setnx(id, "")) {
			jedisCluster.expire(id, 60 * 1);
			return true;
		}
		
		return false;
	}
}
