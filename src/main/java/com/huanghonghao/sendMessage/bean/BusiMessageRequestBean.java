package com.huanghonghao.sendMessage.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class BusiMessageRequestBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "touser")
	private String toUser = "HuangHongHao";
	
	@JsonProperty(value = "toparty")
	private String toParty;
	
	@JsonProperty(value = "totag")
	private String toTag;
	
	@JsonProperty(value = "msgtype")
	private String msgType = "text";
	
	@JsonProperty(value = "agentid")
	private int agentId = 1000002;
	
	@JsonProperty(value = "text")
	private MessageContentBean text;
	
	@JsonProperty(value = "safe")
	private int safe = 0;
}
