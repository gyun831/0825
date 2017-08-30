package  com.gms.web.constant;


public class SQL {

	public static final String MEMBER_INSERT=String.format("INSERT INTO %s(%s,%s,%s,%s,%s,%s,%s,%s)  VALUES(?,?,?,?,?,?,?,SYSDATE)",
												DB.TABLE_MEMBER,DB.MEM_ID,DB.NAME,DB.PASS,DB.SSN,DB.PHONE,DB.EMAIL,DB.PROFILE,DB.REGDATE);
	public static final String MEMBER_LIST=String.format("SELECT * FROM %s", DB.TABLE_MEMBER);
	public static final String MEMBER_FINDBYNAME=String.format("SELECT * FROM %s WHERE %s=?", DB.TABLE_MEMBER,DB.NAME);
	public static final String MEMBER_FINDBYID=String.format("SELECT * FROM %s WHERE %s=?", DB.TABLE_MEMBER,DB.MEM_ID);
	public static final String MEMBER_COUNT=String.format("SELECT COUNT(*) AS count FROM %s", DB.TABLE_MEMBER);
	public static final String MEMBER_UPDATE=String.format("UPDATE %s SET %s=? WHERE %s=?",DB.TABLE_MEMBER,DB.PASS,DB.MEM_ID);
	public static final String MEMBER_DELETE=String.format("DELETE FROM %s WHERE %s=?", DB.TABLE_MEMBER,DB.MEM_ID);
	public static final String BOARD_INSERT=String.format("INSERT INTO %s(%s,%s,%s,%s,%s,%s)  VALUES(article_seq.nextval,?,?,?,0,SYSDATE)",
			DB.TABLE_BOARD,DB.BOARD_ARTICLE_SEQ,DB.TITLE,DB.BOARD_ID,DB.BOARD_CONTENT,DB.BOARD_HITCOUNT,DB.BOARD_REGDATE);
	public static final String BOARD_LIST=String.format("SELECT * FROM %s", DB.TABLE_BOARD);
	public static final String BOARD_FINDBYID=String.format("SELECT * FROM %s WHERE %s=?", DB.TABLE_BOARD,DB.BOARD_ID);
	public static final String BOARD_FINDBYSEQ=String.format("SELECT * FROM %s WHERE %s=?", DB.TABLE_BOARD,DB.BOARD_ARTICLE_SEQ);
	public static final String BOARD_COUNT=String.format("SELECT COUNT(*) AS count FROM %s", DB.TABLE_BOARD);
	public static final String BOARD_UPDATE=String.format("UPDATE %s SET %s=?,%s=? WHERE %s=?",DB.TABLE_BOARD,DB.TITLE,DB.BOARD_CONTENT,DB.BOARD_ARTICLE_SEQ);
	public static final String BOARD_DELETE=String.format("DELETE FROM %s WHERE %s=?", DB.TABLE_BOARD,DB.BOARD_ARTICLE_SEQ);
	public static final String BOARD_HITUPDATE=String.format("UPDATE %s SET %s=? WHERE %s=?",DB.TABLE_BOARD,DB.BOARD_HITCOUNT,DB.BOARD_ARTICLE_SEQ);
	public static final String MAJOR_INSERT=String.format("INSERT INTO %s(%s,%s,%s,%s) VALUES(?,?,?,?)",DB.TABLE_MAJOR,DB.MAJOR_ID,DB.TITLE,DB.MEM_ID,DB.SUBJ_ID);
	public static final String STUDENT_LIST="select t.* from (select rownum rnum,s.* from student s)t where t.rnum between ? and ?";
	public static final String STUDENT_SEARCH=String.format("select t2.* from (select rownum seq,t.* from(select * from student where %s like ? order by no desc)t )t2 where t2.seq between ? and ?","name");
	public static final String STUDENT_COUNT=String.format("SELECT COUNT(*) AS count FROM %s WHERE name like ?", DB.TABLE_STUDENT);
	public static final String STUDENT_FINDBYID=String.format("SELECT * FROM %s WHERE %s like ?", DB.TABLE_STUDENT,DB.ID);
}
