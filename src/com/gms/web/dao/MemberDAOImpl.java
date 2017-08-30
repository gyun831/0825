package com.gms.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gms.web.command.Command;
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
	Connection conn;
	
	public static MemberDAOImpl getInstance(){
		return new MemberDAOImpl();
	}
	private MemberDAOImpl(){
		conn=null;
		student=null;
	}
	@Override
	public String insert(Map<?,?> map) {
		String rs = "";
		MemberBean bean = (MemberBean)map.get("member");
		@SuppressWarnings("unchecked")
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
				pstmt.setString(1,list.get(i).getMajorId()+(int) (Math.random()*100+1));
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
	public List<?> selectAll(Command cmd) {
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {
			conn= DatabaseFactory.createDatabase(Vendor.ORACLE,DB.USERNAME,DB.PASSWORD).getConnection();
			PreparedStatement pstmt =conn.prepareStatement(SQL.STUDENT_LIST);
			pstmt.setString(1, cmd.getStartRow());
			pstmt.setString(2, cmd.getEndRow());
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
	public List<?> selectByName(Command cmd) {
		System.out.println(cmd.getSearch());
		List<StudentBean>list = new ArrayList<StudentBean>();
		try {
			PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE,DB.USERNAME,DB.PASSWORD).getConnection().prepareStatement(SQL.STUDENT_SEARCH);
			pstmt.setString(1,"%"+cmd.getSearch()+"%");
			pstmt.setString(2,cmd.getStartRow());
			pstmt.setString(3,cmd.getEndRow());
			ResultSet rs=pstmt.executeQuery();
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
	public StudentBean selectById(Command cmd) {
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE,DB.USERNAME,DB.PASSWORD).getConnection().prepareStatement(SQL.STUDENT_FINDBYID);
		
			pstmt.setString(1,cmd.getSearch());
			ResultSet rs = pstmt.executeQuery(); 
			while(rs.next()) {
				student = new StudentBean();
				student.setNo(rs.getString(DB.NO));
				student.setId(rs.getString(DB.ID));
				student.setPw(rs.getString(DB.PASS));
				student.setName(rs.getString(DB.NAME));
				student.setEmail(rs.getString(DB.EMAIL));
				student.setPhone(rs.getString(DB.PHONE));
				student.setRegdate(rs.getString(DB.REGDATE));
				student.setSsn(rs.getString(DB.SSN));
				student.setTitle(rs.getString(DB.TITLE));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return student;
	}

	@Override
	public String count(Command cmd) {
		int cnt = 0;
		System.out.println("count("+cmd.getSearch()+")");
		System.out.println("count("+cmd.getColumn()+")");
		PreparedStatement pstmt;
		ResultSet rs;
		System.out.println("search : "+cmd.getSearch());
		if(cmd.getSearch()==null){
			cmd.setSearch("%");
		}else{
			cmd.setSearch("%"+cmd.getSearch()+"%");
		}
		try{
			pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.STUDENT_COUNT);
			pstmt.setString(1,cmd.getSearch());
			rs = pstmt.executeQuery();
			if(rs.next()){
				cnt = Integer.parseInt(rs.getString("count"));
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(cnt);
	}
	@Override
	public String update(StudentBean student) {
		int rs = 0;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).
												getConnection().prepareStatement(SQL.MEMBER_UPDATE);
			pstmt.setString(1,student.getPw());
			pstmt.setString(2, student.getId());
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(rs);
	}

	@Override
	public String delete(Command cmd) {
		int rs = 0;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).
																	getConnection().prepareStatement(SQL.MEMBER_DELETE);
			pstmt.setString(1,cmd.getSearch());
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(rs);
	}
}
