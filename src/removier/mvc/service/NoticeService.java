package removier.mvc.service;

import java.sql.SQLException;
import java.util.List;

import removier.mvc.dao.NoticeDAO;
import removier.mvc.dao.NoticeDAOImpl;
import removier.mvc.dto.Notice;

public class NoticeService {
	
	NoticeDAO noticeDao = new NoticeDAOImpl();
	
	/**공지사항 목록보기
	 * @return : 공지사항을 list 로 리턴
	 * */
	public List<Notice> noticeSelectAll() throws SQLException {
		List<Notice> list = noticeDao.noticeSelectAll();
		if(list.size() == 0 || list.isEmpty()) {
			throw new SQLException("게시물 정보가 없습니다.");
		}		
		return list;
	}

	/** 공지사항 등록
	 * @param : 작성받은 공지사항을 notice 로 받는다.
	 * */
	public void noticeInsert(Notice notice) throws SQLException {
		if(noticeDao.noticeInsert(notice) == 0)
			throw new SQLException("게시물이 등록되지 않았습니다."); 
	}

	/** 공지사항 수정
	 * @param : 수정된 Notice 를 인수로 받는다.
	 * */
	public void noticeUpdate(Notice notice) throws SQLException {
		if(noticeDao.noticeUpdate(notice) == 0)
		throw new SQLException("수정되지 않았습니다.");		
	}

	/**
	 * 공지사항 삭제
	 * */
	public void noticeDelete(int no) throws SQLException {
		if(noticeDao.noticeDelete(no) == 0)
		throw new SQLException("삭제되지 않았습니다.");		
	}
}
