package com.gms.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gms.web.constant.DB;
import com.gms.web.constant.SQL;
import com.gms.web.constant.Vendor;
import com.gms.web.domain.ArticleBean;
import com.gms.web.factory.DatabaseFactory;



public class ArticleDAOImpl implements ArticleDAO {

	public static ArticleDAOImpl getInstance(){
		return new ArticleDAOImpl();
	}
	private ArticleDAOImpl(){
		
	}
	@Override
	public String insert(ArticleBean bean) {
		int rs = 0;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.BOARD_INSERT);
			pstmt.setString(1, bean.getTitle());
			pstmt.setString(1, bean.getId());
			pstmt.setString(1, bean.getContent());
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(rs);
	}

	@Override
	public List<ArticleBean> selectAll() {
		List<ArticleBean> list = new ArrayList<ArticleBean>();
		ArticleBean bean = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE,DB.USERNAME,DB.PASSWORD).getConnection()
															.prepareStatement(SQL.BOARD_LIST).executeQuery();
			while(rs.next()){
				bean = new ArticleBean();
				bean.setArticleseq(Integer.parseInt(rs.getString(DB.BOARD_ARTICLE_SEQ)));
				bean.setId(rs.getString(DB.BOARD_ID));
				bean.setTitle(rs.getString(DB.TITLE));
				bean.setContent(rs.getString(DB.BOARD_CONTENT));
				bean.setHitcount(rs.getInt(DB.BOARD_HITCOUNT));
				bean.setRegdate(rs.getString(DB.BOARD_REGDATE));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ArticleBean> selectById(String id) {
		List<ArticleBean> list = new ArrayList<ArticleBean>();
		ArticleBean bean = null;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE,DB.USERNAME,DB.PASSWORD).getConnection()
					.prepareStatement(SQL.BOARD_FINDBYID);
			pstmt.setString(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				bean = new ArticleBean();
				bean.setArticleseq(Integer.parseInt(rs.getString(DB.BOARD_ARTICLE_SEQ)));
				bean.setId(rs.getString(DB.BOARD_ID));
				bean.setTitle(rs.getString(DB.TITLE));
				bean.setContent(rs.getString(DB.BOARD_CONTENT));
				bean.setHitcount(rs.getInt(DB.BOARD_HITCOUNT));
				bean.setRegdate(rs.getString(DB.BOARD_REGDATE));
				list.add(bean);
				
				PreparedStatement pstmt2 = DatabaseFactory.createDatabase(Vendor.ORACLE,DB.USERNAME,DB.PASSWORD).getConnection()
						.prepareStatement(SQL.BOARD_HITUPDATE);
				pstmt2.setInt(1,rs.getInt(DB.BOARD_HITCOUNT)+1);
				pstmt2.setInt(2,rs.getInt(DB.BOARD_ARTICLE_SEQ));
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
	}

	@Override
	public ArticleBean selectBySeq(String seq) {
		ArticleBean bean = new ArticleBean();
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE,DB.USERNAME,DB.PASSWORD).getConnection()
					.prepareStatement(SQL.BOARD_FINDBYSEQ);
			pstmt.setString(1,seq);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				bean.setArticleseq(Integer.parseInt(rs.getString(DB.BOARD_ARTICLE_SEQ)));
				bean.setId(rs.getString(DB.BOARD_ID));
				bean.setTitle(rs.getString(DB.TITLE));
				bean.setContent(rs.getString(DB.BOARD_CONTENT));
				bean.setHitcount(rs.getInt(DB.BOARD_HITCOUNT));
				bean.setRegdate(rs.getString(DB.BOARD_REGDATE));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public String count() {
		String cnt="";
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE,DB.USERNAME,DB.PASSWORD).getConnection()
					.prepareStatement(SQL.BOARD_COUNT).executeQuery();
			if(rs.next()){
				cnt=rs.getString("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public String update(ArticleBean bean) {
		ArticleBean find = new ArticleBean();
		int rs=0;

		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE,DB.USERNAME,DB.PASSWORD).getConnection()
									.prepareStatement(SQL.BOARD_UPDATE);
			if(bean.getTitle().equals("")){
				find = selectBySeq(String.valueOf(bean.getArticleseq()));
				pstmt.setString(1,find.getTitle());
			}else{
				pstmt.setString(1,bean.getTitle());
			}
			pstmt.setString(2, bean.getContent());
			pstmt.setInt(3, bean.getArticleseq());
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return String.valueOf(rs);
	}

	@Override
	public String delete(String seq) {
		int rs=0;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE,DB.USERNAME,DB.PASSWORD).getConnection()
					.prepareStatement(SQL.BOARD_DELETE);
			pstmt.setString(1, seq);
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return String.valueOf(rs);
	}

}
