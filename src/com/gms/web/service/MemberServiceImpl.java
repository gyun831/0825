package com.gms.web.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.gms.web.dao.MemberDAOImpl;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;

public class MemberServiceImpl implements MemberService {
	public static MemberServiceImpl instance = new MemberServiceImpl();
	public static MemberServiceImpl getInstance(){
		return instance;
	}
	Map<String, MemberBean> map;

	private MemberServiceImpl() {
		map = new HashMap<>();
	}

	@Override
	public String addMember(Map<String,Object> map) {
		System.out.println("member service 진입");
		MemberBean m =(MemberBean) map.get("member");
		System.out.println("넘어온 회원의 이름:"+m.getName());
		List<MajorBean>list= (List<MajorBean>) map.get("major");
		System.out.println("넘어온 수강과목:"+list);
		MemberDAOImpl.getInstance().insert(map);
		return null;
	}

	@Override
	public List<?> list(Object o) {
		return MemberDAOImpl.getInstance().selectAll(o);
	}

	@Override
	public String countMembers() {
		return String.valueOf(MemberDAOImpl.getInstance().count());
	}

	@Override
	public MemberBean findById(String id) {
		return MemberDAOImpl.getInstance().selectById(id);
	}

	@Override
	public List<MemberBean> findByName(String name) {
		return MemberDAOImpl.getInstance().selectByName(name);
	}
	@Override
	public String modify(MemberBean bean) {
		return (Integer.parseInt(MemberDAOImpl.getInstance().update(bean))==1)?"수정성공":"수정실패";
	}

	@Override
	public String remove(String id) {
		return (Integer.parseInt(MemberDAOImpl.getInstance().delete(id))==1)?"삭제성공":"삭제실패";
	}
	@Override
	public Map<String,Object> login(MemberBean bean) {
		Map<String,Object> map = new HashMap<>();
		MemberBean member = MemberDAOImpl.getInstance().selectById(bean.getId());
		String page=
		 (member!=null)?
				(bean.getPw().equals(member.getPw()))?
						"home":"login_fail":"join";
		map.put("page", page);
		map.put("user", member);
		return map;
	}
}
