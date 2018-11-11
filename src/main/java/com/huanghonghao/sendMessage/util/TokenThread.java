package com.huanghonghao.sendMessage.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.huanghonghao.sendMessage.bean.AccessTokenBean;

import lombok.extern.slf4j.Slf4j;

@Component
@Controller
@Slf4j
public class TokenThread {
	
	@Value("${token.app.appId}")
	private String appId;
	
	@Value("${token.app.appSecret}")
	private String appSecret;
	
	@Value("${token.app.tokenUrl}")
	private String appTokenUrl;
	
	@Value("${token.corp.corpId}")
	private String corpId;
	
	@Value("${token.corp.corpSecret}")
	private String corpSecret;
	
	@Value("${token.corp.tokenUrl}")
	private String corpTokenUrl;
	
	public static AccessTokenBean accessToken;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public static final int APP = 1;
	
	public static final int CORP = 0;

	@Async
	public void start() {
		while (true){
            try{
                accessToken = this.getAccessToken(CORP);
                if(null!=accessToken){
                	log.info("accessToken: {}", accessToken.getAccessToken());
                	log.info("expires_in: {}", accessToken.getExpiresin());
                    Thread.sleep(7000 * 1000); //获取到access_token 休眠7000秒
                }else{
                    Thread.sleep(1000*3); //获取的access_token为空 休眠3秒
                }
            }catch(Exception e){
                e.printStackTrace();
                try{
                    Thread.sleep(1000*10); //发生异常休眠1秒
                }catch (Exception e1){
 
                }
            }
		}
	}

	/**
	 * 获取access_token
	 * 
	 * @return
	 */
	private AccessTokenBean getAccessToken(int type) {
		String url;
		if (type == APP) {
			url = String.format(this.appTokenUrl, this.appId, this.appSecret);
			log.info("URL: {}", url);
		} else {
			url = String.format(this.corpTokenUrl, this.corpId, this.corpSecret);
			log.info("URL: {}", url);
		}
		return restTemplate.getForObject(url, AccessTokenBean.class);
	}

}
