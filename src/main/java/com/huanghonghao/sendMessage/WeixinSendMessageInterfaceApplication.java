package com.huanghonghao.sendMessage;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAsync
public class WeixinSendMessageInterfaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeixinSendMessageInterfaceApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
		// 设置核心线程数
		threadPool.setCorePoolSize(10);
		// 设置最大线程数
		threadPool.setMaxPoolSize(100);
		// 线程池所使用的缓冲队列
		threadPool.setQueueCapacity(10);
		// 等待任务在关机时完成--表明等待所有线程执行完
		threadPool.setWaitForTasksToCompleteOnShutdown(true);
		// 等待时间 （默认为0，此时立即停止），并没等待xx秒后强制停止
		threadPool.setAwaitTerminationSeconds(10);
		// 线程名称前缀
		threadPool.setThreadNamePrefix("MyAsync-");
		// 初始化线程
		threadPool.initialize();
		return threadPool;
	}
}
