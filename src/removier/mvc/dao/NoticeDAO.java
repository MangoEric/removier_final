package removier.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import removier.mvc.dto.Notice;

public interface NoticeDAO {
	/**
	 * 전체검색
	 */
	List<Notice> noticeSelectAll() throws SQLException;
	
	/**
	 * 공지 등록하기
	 * */
	int noticeInsert(Notice notice) throws SQLException;
	
	/**
	 * 공지 수정하기
	 * */
	int noticeUpdate(Notice notice) throws SQLException;
	
	/**
	 * 공지 삭제하기
	 * */
	int noticeDelete(int no) throws SQLException;
	
	
}
