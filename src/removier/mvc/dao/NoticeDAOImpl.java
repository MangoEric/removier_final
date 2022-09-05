package removier.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import removier.mvc.dto.Notice;
import removier.mvc.util.DBUtil;

public class NoticeDAOImpl implements NoticeDAO{
	private Properties proFile = DBUtil.getProFile();
	
	// 공지사항 - 조회화면(목록)
	public List<Notice> noticeSelectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Notice> list = new ArrayList<Notice>();
		String sql = proFile.getProperty("notice.selectAll"); // "select * from notice order by notice_pk desc";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			
			while(rs.next()) {

				Notice dto = new Notice(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(dto);
			}
			
		} finally {
			DBUtil.close(con, ps, rs);
		}
		return list;
	}
	
	
	@Override
	public int noticeInsert(Notice notice) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("notice.insert");

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, notice.getNotice_title());
			ps.setString(2, notice.getNotice_content());
			
			
			result = ps.executeUpdate(); 
		} finally {
			DBUtil.close(con, ps);
		}
		return result;
	}

	@Override
	public int noticeUpdate(Notice notice) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("notice.updateByNo");

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, notice.getNotice_content());
			ps.setInt(2, notice.getNotice_pk());
			
			result = ps.executeUpdate(); 
		} finally {
			DBUtil.close(con, ps);
		}
		return result;
	}

	@Override
	public int noticeDelete(int notice_pk) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("notice.deleteByNo");

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, notice_pk);	
			
			result = ps.executeUpdate(); 
		} finally {
			DBUtil.close(con, ps);
		}
		return result;
	}

}



