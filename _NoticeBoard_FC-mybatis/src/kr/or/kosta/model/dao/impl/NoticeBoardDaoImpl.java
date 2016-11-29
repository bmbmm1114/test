package kr.or.kosta.model.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.kosta.model.dao.NoticeBoardDao;
import kr.or.kosta.util.Constants;
import kr.or.kosta.vo.Notice;

public class NoticeBoardDaoImpl implements NoticeBoardDao {
	private static NoticeBoardDao instance;
	
	private NoticeBoardDaoImpl() {
	}

	public static NoticeBoardDao getInstance() {
		if (instance == null) {
			instance = new NoticeBoardDaoImpl();
		}
		return instance;
	}
	private String makeSqlId(String id){
		return "noticeboardMapper."+id;
	}

	@Override
	public Notice selectNoticeBoardByNo(SqlSession session, int no){
		return session.selectOne(makeSqlId("selectNoticeBoardByNo"), no);
		
	}
	
	@Override
	public List<Notice> selectNoticeBoardList(SqlSession session, int page){
		HashMap<String, Integer> param = new HashMap<>();
		param.put("itemPerPage", Constants.ITEMS_PER_PAGE);
		param.put("page", page);
		return session.selectList(makeSqlId("selectNoticeBoardList"), param);
	}
	

	@Override
	public int selectCountNoticeBoard(SqlSession session){
		return session.selectOne(makeSqlId("selectCountNoticeBoard"));
	}
	

	@Override
	public int insertNoticeBoard(SqlSession session, Notice notice){
		return session.insert(makeSqlId("insertNoticeBoard"), notice);
	}
	

	@Override
	public int updateViewCount(SqlSession session, int no){
		return session.update(makeSqlId("updateViewCount"), no);
	}
	

	@Override
	public int updateNoticeBoard(SqlSession session, Notice notice){
		return session.update(makeSqlId("updateNoticeBoard"), notice);
	}
	
	
	@Override
	public int deleteNoticeBoardByNo(SqlSession session, int no){
		return session.delete(makeSqlId("deleteNoticeBoardByNo"), no);
	}
}
