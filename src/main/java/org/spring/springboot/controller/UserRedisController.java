package org.spring.springboot.controller;

import org.spring.springboot.domain.User;
import org.spring.springboot.service.RedisService;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRedisController {
	@Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;
    
    //存一笔data的同时,分别存入MySQL、Redis。然后通过存入MySQL时自动生成的ID，将ID成为redis的Key,并且将User对象作为Value,存入Redis.
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public @ResponseBody String addUser(@RequestBody User user) {
    	userService.addUser(user);
    	redisService.set(user.getId()+"",user);
    	System.out.println(user.getId()+"-------------------------");
    	return "saved";
    }
    
    
    //从redis获取某个用户
    @RequestMapping(value = "/getuserfromredis", method = RequestMethod.GET)
    public @ResponseBody User getRedis(@RequestParam String key) {
        return (User)redisService.get(key);
    }
    
    
    //根据userName获取DB用户
    @RequestMapping(value = "/getusers", method = RequestMethod.GET)
    public @ResponseBody User findByName(@RequestParam(value = "userName", required = true) String userName){
        return userService.findByName(userName); 
    }
}
