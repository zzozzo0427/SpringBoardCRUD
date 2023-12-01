package com.example.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {


	@Autowired
	JdbcTemplate jdbcTemplate;

	public int insertBoard(BoardVO vo){
		String sql = "insert into BOARD(title, writer, content, category) values ("
				+ "'" + vo.getTitle() + "',"
				+ "'" + vo.getWriter() + "',"
				+ "'" + vo.getContent() + "',"
				+ "'" + vo.getCategory() + "')";
		return jdbcTemplate.update(sql);
	}

	public int deleteBoard(int seq) {
		String sql = "delete from BOARD where seq = " + seq;
		return jdbcTemplate.update(sql);
	}

	public int updateBoard(BoardVO vo) {
		String sql = "update BOARD set title=" + vo.getTitle() + "',"
				+ "title='" + vo.getTitle() + "',"
				+ "writer='" + vo.getWriter() + "',"
				+ "content='" + vo.getContent() + "',"
				+ "category='" + vo.getCategory() + "' where seq = " + vo.getSeq();
		return jdbcTemplate.update(sql);
	}

	public BoardVO getBoard(int seq) {
		String sql = "select * from BOARD where seq = " + seq;
		return jdbcTemplate.queryForObject(sql, new BoardRowMapper());
	}

	public List<BoardVO> getBoardList() {
		String sql = "selct * from BOARD order by regdate desc";
		return jdbcTemplate.query(sql, new BoardRowMapper());
	}
	
//	Connection conn = null;
//	PreparedStatement stmt = null;
//	ResultSet rs = null;
//
//	private final String BOARD_INSERT = "insert into BOARD (category, title, writer, content) values (?,?,?,?)";
//	private final String BOARD_UPDATE = "update BOARD set category=?, title=?, writer=?, content=? where seq=?";
//	private final String BOARD_DELETE = "delete from BOARD  where seq=?";
//	private final String BOARD_GET = "select * from BOARD  where seq=?";
//	private final String BOARD_LIST = "select * from BOARD order by seq desc";

//	public int insertBoard(BoardVO vo) {
//		System.out.println("===> JDBC로 insertBoard() 기능 처리");
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_INSERT);
//			stmt.setString(1, vo.getTitle());
//			stmt.setString(2, vo.getWriter());
//			stmt.setString(3, vo.getContent());
//			stmt.executeUpdate();
//			return 1;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}

	// 글 삭제
//	public void deleteBoard(BoardVO vo) {
//		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_DELETE);
//			stmt.setInt(1, vo.getSeq());
//			stmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public int updateBoard(BoardVO vo) {
//		System.out.println("===> JDBC로 updateBoard() 기능 처리");
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_UPDATE);
//			stmt.setString(1, vo.getTitle());
//			stmt.setString(2, vo.getWriter());
//			stmt.setString(3, vo.getContent());
//			stmt.setInt(4, vo.getSeq());
//
//
//			System.out.println(vo.getTitle() + "-" + vo.getWriter() + "-" + vo.getContent() + "-" + vo.getSeq());
//			stmt.executeUpdate();
//			return 1;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
	
//	public BoardVO getBoard(int seq) {
//		BoardVO one = new BoardVO();
//		System.out.println("===> JDBC로 getBoard() 기능 처리");
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_GET);
//			stmt.setInt(1, seq);
//			rs = stmt.executeQuery();
//			if(rs.next()) {
//				one.setSeq(rs.getInt("seq"));
//				one.setTitle(rs.getString("title"));
//				one.setWriter(rs.getString("writer"));
//				one.setContent(rs.getString("content"));
//				one.setCnt(rs.getInt("cnt"));
//			}
//			rs.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return one;
//	}
	
//	public List<BoardVO> getBoardList(){
//		List<BoardVO> list = new ArrayList<BoardVO>();
//		System.out.println("===> JDBC로 getBoardList() 기능 처리");
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_LIST);
//			rs = stmt.executeQuery();
//			while(rs.next()) {
//				BoardVO one = new BoardVO();
//				one.setSeq(rs.getInt("seq"));
//				one.setTitle(rs.getString("title"));
//				one.setWriter(rs.getString("writer"));
//				one.setContent(rs.getString("content"));
//				one.setRegdate(rs.getDate("regdate"));
//				one.setCnt(rs.getInt("cnt"));
//				list.add(one);
//			}
//			rs.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
}
