package com.gms.web.proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Getter;

public class Proxy {
	@Getter HttpServletRequest request;
	public Proxy(HttpServletRequest request){
		this.request=request;
	}

}
