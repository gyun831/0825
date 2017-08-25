package com.gms.web.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class ArticleBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String title,content,regdate,id;
	private int hitcount,articleseq;

	public String toString(){
		return "[글번호]"+articleseq+"\n[아이디]"+id+"\n[제목]"+title+"\n[내용]"+content+"\n[조회수]"+hitcount+"\n[작성일]"+regdate+"\n";
	}
	

}
