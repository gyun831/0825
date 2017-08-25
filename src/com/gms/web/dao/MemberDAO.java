package com.gms.web.dao;

import java.util.List;
import java.util.Map;

import com.gms.web.domain.MemberBean;

public interface MemberDAO {
	public String insert(Map<?,?> map);
	public List<?> selectAll(Object o);
	public List<MemberBean> selectByName(String name);
	public MemberBean selectById(String id);
	public String count();
	public String update(MemberBean member);
	public String delete(String id);
}
