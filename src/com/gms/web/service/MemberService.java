package com.gms.web.service;

import java.util.List;
import java.util.Map;

import com.gms.web.domain.MemberBean;

public interface MemberService {
	public String addMember(Map<String,Object> map);
	public List<?> list(Object o);
	public String countMembers();
	public MemberBean findById(String id);
	public List<MemberBean> findByName(String name);
	public String modify(MemberBean bean);
	public String remove(String id);
	public Map<String,Object> login(MemberBean bean);
}
