package com.gms.web.service;

import java.util.List;

import com.gms.web.dao.ArticleDAOImpl;
import com.gms.web.domain.ArticleBean;



public class ArticleServiceImpl implements ArticleService {
	public static ArticleServiceImpl getInstance(){
		return new ArticleServiceImpl();
	}
	private ArticleServiceImpl(){
		
	}
	@Override
	public String write(ArticleBean bean) {
		return (Integer.parseInt(ArticleDAOImpl.getInstance().insert(bean))==1)?"게시성공":"게시실패";
	}

	@Override
	public List<ArticleBean> list() {
		return ArticleDAOImpl.getInstance().selectAll();
	}

	@Override
	public List<ArticleBean> findById(String id) {
		return ArticleDAOImpl.getInstance().selectById(id);
	}

	@Override
	public ArticleBean findSeq(String seq) {
		return ArticleDAOImpl.getInstance().selectBySeq(seq);
	}

	@Override
	public String count() {
		return ArticleDAOImpl.getInstance().count();
	}

	@Override
	public String modify(ArticleBean bean) {
		return ArticleDAOImpl.getInstance().update(bean).equals("1")?"수정성공":"수정실패";
	}

	@Override
	public String remove(String seq) {
		// TODO Auto-generated method stub
		return ArticleDAOImpl.getInstance().delete(seq).equals("1")?"삭제성공":"삭제실패";
	}

}
