package com.huanghonghao.sendMessage.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TokenApplicationRunner implements ApplicationRunner {
	
	@Autowired
	public TokenThread tokenThread;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		tokenThread.start();
	}

}
