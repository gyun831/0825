package com.gms.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gms.web.constant.DB;
import com.gms.web.constant.SQL;
import com.gms.web.constant.Vendor;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudentBean;
import com.gms.web.factory.DatabaseFactory;

import java.sql.*;

public class MemberDAOImpl implements MemberDAO {
	StudentBean student;
	MemberBean member;
	Connection conn;
	
	public static MemberDAOImpl getInstance(){
		return new MemberDAOImpl();
	}
	private MemberDAOImpl(){
		conn=null;
		member=null;
		student=null;
	}
	@Override
	public String insert(Map<?,?> map) {
		String rs = "";
		MemberBean bean = (MemberBean)map.get("member");
		List<MajorBean> list=  (List<MajorBean>) map.get("major");
		PreparedStatement pstmt=null;

		try {
			conn = DatabaseFactory.createDatabase(Vendor.ORACLE,DB.USERNAME,DB.PASSWORD).getConnection();
			conn.setAutoCommit(false);
			pstmt =conn.prepareStatement(SQL.MEMBER_INSERT);
			pstmt.setString(1,bean.getId());
			pstmt.setString(2,bean.getName());
			pstmt.setString(3,bean.getPw());
			pstmt.setString(4,bean.getSsn());
			pstmt.setString(5,bean.getPhone());
			pstmt.setString(6,bean.getEmail());
			pstmt.setString(7,bean.getProfile());
			pstmt.executeUpdate();
			for(int i=0; i<list.size();i++){
				pstmt =conn.prepareStatement(SQL.MAJOR_INSERT);
				pstmt.setString(1,list.get(i).getMajorId()+i);
				pstmt.setString(2,list.get(i).getTitle());
				pstmt.setString(3,list.get(i).getId());
				pstmt.setString(4,list.get(i).getSubjId());
				rs=String.valueOf(pstmt.executeUpdate());
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try{
					conn.rollback();
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		}
		return rs;
	}

	@Override
	public List<?> selectAll(Object o) {
		List<StudentBean> list = new ArrayList<StudentBean>();
		int[] arr=(int[])o;
		try {
			conn= DatabaseFactory.createDatabase(Vendor.ORACLE,DB.USERNAME,DB.PASSWORD).getConnection();
			PreparedStatement pstmt =conn.prepareStatement(SQL.STUDENT_LIST);
			pstmt.setString(1, String.valueOf(arr[0]));
			pstmt.setString(2, String.valueOf(arr[1]));
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				student = new StudentBean();
				student.setNo(rs.getString(DB.NO));
				student.setId(rs.getString(DB.ID));
				student.setName(rs.getString(DB.NAME));
				student.setEmail(rs.getString(DB.EMAIL));
				student.setPhone(rs.getString(DB.PHONE));
				student.setRegdate(rs.getString(DB.REGDATE));
				student.setSsn(rs.getString(DB.SSN));
				student.setTitle(rs.getString(DB.TITLE));
				list.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		List<MemberBean>list = new ArrayList<MemberBean>();
		try {
			PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE,DB.USERNAME,DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYNAME);
			pstmt.setString(1,name);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				member = new MemberBean();
				member.setId(rs.getString(DB.MEM_ID));
				member.setName(rs.getString(DB.NAME));
				member.setPw(rs.getString(DB.PASS));
				member.setSsn(rs.getString(DB.SSN));
				member.setRegdate(rs.getString(DB.REGDATE));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public MemberBean selectById(String id) {
		MemberBean member = null;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE,DB.USERNAME,DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYID);
		
			pstmt.setString(1,id);
			ResultSet rs = pstmt.executeQuery(); 
			while(rs.next()) {
				member = new MemberBean();
				member.setId(rs.getString(DB.MEM_ID));
				member.setName(rs.getString(DB.NAME));
				member.setPw(rs.getString(DB.PASS));
				member.setSsn(rs.getString(DB.SSN));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return member;
	}

	@Override
	public String count() {
		int cnt = 0;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.STUDENT_COUNT).executeQuery();
			if(rs.next()){
				cnt = Integer.parseInt(rs.getString("count"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(cnt);
	}

	@Override
	public String update(MemberBean member) {
		int rs = 0;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).
												getConnection().prepareStatement(SQL.MEMBER_UPDATE);
			pstmt.setString(1,member.getPw());
			pstmt.setString(2, member.getId());
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(rs);
	}

	@Override
	public String delete(String id) {
		int rs = 0;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).
																	getConnection().prepareStatement(SQL.MEMBER_DELETE);
			pstmt.setString(1,id);
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(rs);
	}
}
