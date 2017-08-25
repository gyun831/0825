package com.gms.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gms.web.constant.Action;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudentBean;
import com.gms.web.proxy.BlockHandler;
import com.gms.web.proxy.PageHandler;
import com.gms.web.proxy.PageProxy;
import com.gms.web.service.MemberServiceImpl;
import com.gms.web.util.DispatcherServlet;
import com.gms.web.util.ParamsIterator;
import com.gms.web.util.Separator;


@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController Get 진입");
		Separator.init(request);
		MemberBean member = new MemberBean();
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		switch(request.getParameter(Action.CMD)){
		case Action.MOVE:
			DispatcherServlet.send(request, response);
			break;
		case Action.JOIN:
			System.out.println("========join진입=======");
			Map<?,?> map = ParamsIterator.execute(request);
			member.setId((String)map.get("id"));
			member.setPw((String)map.get("password"));
			member.setName((String)map.get("name"));
			member.setEmail((String)map.get("email"));
			member.setSsn((String)map.get("birthday"));
			member.setPhone((String)map.get("phone"));
			member.setGender((String)map.get("gender"));
			member.setMajor((String)map.get("major"));
			member.setSubject((String)map.get("subject"));
			
			System.out.println((String)map.get("id"));
			
			String[] subjects=((String)map.get("subject")).split(",");
			List<MajorBean> list = new ArrayList<>();
			MajorBean major = null;
			for(int i=0;i<subjects.length;i++){
				major = new MajorBean();
				major.setId((String)map.get("id"));
				major.setTitle((String)map.get("name"));
				major.setMajorId((String)map.get("major"));
				major.setSubjId(subjects[i]);
				list.add(major);
			}
			Map<String,Object>tempMap=new HashMap<>();
			tempMap.put("member", member);
			tempMap.put("major", list);
			Separator.cmd.setDir("common");
			Separator.cmd.process();
			service.addMember(tempMap);
			DispatcherServlet.send(request, response);
			break;
		case Action.LIST:
			System.out.println("Member List Enter");
			PageProxy pxy = new PageProxy(request);
			pxy.setPageSize(5);
			pxy.setBlockSize(2);
			pxy.setTheNumberOfRows(Integer.parseInt(service.countMembers()));
			pxy.setPageNumber(Integer.parseInt(request.getParameter("pageNumber")));
			int[] arr=PageHandler.attr(pxy);
			int[] arr2=BlockHandler.attr(pxy);
			pxy.execute(arr2, service.list(arr));
			DispatcherServlet.send(request, response);
			break;
		case Action.UPDATE:
			System.out.println("update 진입");
			service.modify(service.findById(request.getParameter("id")));
			DispatcherServlet.send(request, response);
			break;
		case Action.DELETE:
			System.out.println("delete 진입");
			service.remove(request.getParameter("id"));
			response.sendRedirect("member.do?action=list&page=member_list&pageNumber=1");
			break;
		case Action.DETAIL:
			System.out.println("detail 진입");
			request.setAttribute("student", service.findById(request.getParameter("id")));
			DispatcherServlet.send(request, response);
			break;
		default:
			System.out.println("Action FAIL");
			break;
		}
	}
}

