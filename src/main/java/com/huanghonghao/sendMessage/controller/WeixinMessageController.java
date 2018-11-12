package com.huanghonghao.sendMessage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.huanghonghao.sendMessage.bean.BusiMessageRequestBean;
import com.huanghonghao.sendMessage.bean.ResponseBean;
import com.huanghonghao.sendMessage.util.TokenThread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
public class WeixinMessageController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${sendMessage.corp.url}")
	private String corpUrl;
	
	@RequestMapping(value = "/sendMessage")
	@ResponseBody
	public ResponseBean sendBusiMessagee(@RequestBody BusiMessageRequestBean busiMessageRequestBean) {
		String tempCorpUrl = corpUrl;
		tempCorpUrl = String.format(corpUrl, TokenThread.accessToken.getAccessToken());
		log.info("corpUrl: {}", tempCorpUrl);
		return restTemplate.postForObject(tempCorpUrl, busiMessageRequestBean, ResponseBean.class);
	} 
	
}
