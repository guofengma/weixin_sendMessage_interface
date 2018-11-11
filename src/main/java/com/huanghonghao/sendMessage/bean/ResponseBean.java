package com.huanghonghao.sendMessage.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true) 
public class ResponseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "errcode")
	private String errCode;
	
	@JsonProperty(value = "errmsg")
	private String errMsg;
	
	@JsonProperty(value = "invaliduser")
	private String invalidUser;
}
