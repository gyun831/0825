package com.gms.web.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gms.web.command.Command;
import com.gms.web.dao.MemberDAOImpl;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudentBean;

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
		@SuppressWarnings("unchecked")
		List<MajorBean>list= (List<MajorBean>) map.get("major");
		System.out.println("넘어온 수강과목:"+list);
		MemberDAOImpl.getInstance().insert(map);
		return null;
	}

	@Override
	public List<?> list(Command cmd) {
		return MemberDAOImpl.getInstance().selectAll(cmd);
	}

	@Override
	public String countMembers(Command cmd) {
		return String.valueOf(MemberDAOImpl.getInstance().count(cmd));
	}

	@Override
	public StudentBean findById(Command cmd) {
		return MemberDAOImpl.getInstance().selectById(cmd);
	}

	@Override
	public List<?> findByName(Command cmd) {
		return MemberDAOImpl.getInstance().selectByName(cmd);
	}
	@Override
	public String modify(StudentBean student) {
		return (Integer.parseInt(MemberDAOImpl.getInstance().update(student))==1)?"수정성공":"수정실패";
	}

	@Override
	public String remove(Command cmd) {
		return (Integer.parseInt(MemberDAOImpl.getInstance().delete(cmd))==1)?"삭제성공":"삭제실패";
	}
	@Override
	public Map<String,Object> login(MemberBean bean) {
		Map<String,Object> map = new HashMap<>();
		Command cmd = new Command();
		cmd.setSearch(bean.getId());
		StudentBean student = findById(cmd);
		String page=
		 (student!=null)?
				(bean.getPw().equals(student.getPw()))?
						"home":"login_fail":"join";
		map.put("page", page);
		map.put("user", student);
		return map;
	}
}
