package kr.or.kosta.model.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.model.dao.CodeDao;
import kr.or.kosta.model.dao.NoticeBoardDao;
import kr.or.kosta.model.dao.impl.CodeDaoImpl;
import kr.or.kosta.model.dao.impl.NoticeBoardDaoImpl;
import kr.or.kosta.model.service.NoticeBoardService;
import kr.or.kosta.util.Constants;
import kr.or.kosta.util.PagingBean;
import kr.or.kosta.util.SqlSessionFactoryManager;
import kr.or.kosta.util.TextUtil;
import kr.or.kosta.vo.Code;
import kr.or.kosta.vo.Notice;

public class NoticeBoardServiceImpl implements NoticeBoardService {

	private SqlSessionFactory factory;
	private NoticeBoardDao dao;

	private static NoticeBoardService instance;
	
	private NoticeBoardServiceImpl() throws IOException {
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		dao = NoticeBoardDaoImpl.getInstance();
	}

	public static NoticeBoardService getInstance() throws IOException {
		if (instance == null) {
			instance = new NoticeBoardServiceImpl();
		}
		return instance;
	}
	
	@Override
	/*
	 * code테이블에서 말머리 조회 후 리턴 - CodeDao.selectCodeByCodeCategory()
	 */
	public List<Code> getWriteFormPrefix(){
		CodeDao codeDao = CodeDaoImpl.getInstance();
		SqlSession session = null;
		try {
			session = factory.openSession();
			return codeDao.selectCodeByCodeCategory(session, Constants.NOTICE_BOARD_PREFIX);
		} finally {
			session.close();
		}
	}
	
	@Override
	/*
	 * 1. 매개변수로 받은 등록할 공지사항 정보의 title과 글내용(content)을 html로 보여줄 형식으로 변경 - TextUtil.textToHtml() 
	 * 2. DB에 글 등록 - NoticeDao.insertNoticeBoard()
	 * 3. commit 처리
	 */
	public void writeNotice(Notice notice){
		SqlSession session = null;
		try {
			session = factory.openSession();
			//제목과 내용을 HTML에 맞게 변환
			notice.setTitle(TextUtil.textToHtml(notice.getTitle()));
			notice.setContent(TextUtil.textToHtml(notice.getContent()));
			
			//insert작업처리
			dao.insertNoticeBoard(session, notice);
			session.commit();
		} finally {
			session.close();
		}		
		
	}
	
	@Override
	/*
	 * 1. 조회수 1 증가 : NoticeDao.updateViewCount()
	 * 2. 글 조회 : NoticeDao.selectNoticeBoardByNo()
	 * 3. commit()
	 * 4. 조회한 결과 리턴
	 */
	public Notice getNotice(int no){
		SqlSession session = null;
		try {
			session = factory.openSession();
			//조회수 증가
			dao.updateViewCount(session, no);
			//게시물 조회
			Notice notice = dao.selectNoticeBoardByNo(session, no);
			session.commit();
			return notice;
		} finally {
			session.close();
		}
	}
	
	@Override
	/*
	 * 글번호로 글 조회 후 리턴 : NoticeDao.selectNoticeBoardByNo()
	 */
	public Notice getNoticeAsResult(int no){
		SqlSession session = null;
		try {
			session = factory.openSession();
			//게시물 조회
			Notice notice = dao.selectNoticeBoardByNo(session, no);
			return notice;
		} finally {
			session.close();
		}
	}
	
	@Override
	/*
	 * 1. 페이지에 보여줄 공지사항 게시물들 조회 - NoticeDao.selectNoticeBoardList()
	 * 2. 전체 게시물수 조회해서 PagingBean 생성 - NoticeDao.selectCountNoticeBoard()
	 * 3. 둘을 Map에 묶어 리턴 
	 */
	public Map<String, Object> list(int page){
		SqlSession session = null;
		//목록을 만드는데 필요한 List와 PagingBean객체를 담을 Map
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			session = factory.openSession();
			//목록에 보여줄 게시물들 조회
			result.put("list", dao.selectNoticeBoardList(session, page));
			//PagingBean 생성 - 총게시물수 조회
			result.put("pageBean", new PagingBean(dao.selectCountNoticeBoard(session), page));
			return result;
		} finally {
			session.close();
		}
		
	}
	

	@Override
	/*
	 * 1. 공지사항 글번호로 DB에서 게시물 삭제 : NoticeDao.deleteNoticeByNo()
	 * 2. commit 처리
	 */
	public void removeByNo(int no){
		SqlSession session = null;
		try {
			session = factory.openSession();
			dao.deleteNoticeBoardByNo(session, no);
			session.commit();
		} finally {
			session.close();
		}
		
	}
	

	@Override
	/*
	 * 1. 수정할 공지사항 게시물 글번호로 조회 - NoticeDao.selectNoticeBoardByNo()
	 * 2. 조회한 게시글의 title과 내용을 <textarea>에 보여질 방식으로 변환 : TextUtil.htmlToText()
	 * 3. 말머리에 보여줄 Code들 조회 : CodeDao.selectCodeByCodeCategory()
	 * 4.조회한 공지사항과 Code들을 Map으로 묶어 리턴
	 */
	public Map<String, Object> getModifyNotice(int no){
		//처리 결과로 수정할 게시물 정보(no로 조회) 와 prefix들을 조회해서 리턴. 
		HashMap<String, Object> map = new HashMap<String, Object>();
		SqlSession session = null;
		try {
			session = factory.openSession();
			Notice notice = dao.selectNoticeBoardByNo(session, no);
			notice.setTitle(TextUtil.htmlToText(notice.getTitle()));
			notice.setContent(TextUtil.htmlToText(notice.getContent()));
			map.put("notice", notice);
			//코드테이블에서 Prefix조회
			List<Code> codeList = CodeDaoImpl.getInstance().selectCodeByCodeCategory(session, Constants.NOTICE_BOARD_PREFIX);
			map.put("codeList", codeList);
			return map;
		} finally {
			session.close();
		}
	}
	
	@Override
	/*
	 * 1. 매개변수로 받은 수정 처리할 공지사항 정보의 title과 글내용(content)을 html로 보여줄 형식으로 변경 - TextUtil.textToHtml()
	 * 2. DB에 수정처리 : NoticeDao.updateNoticeBoard()
	 * 3. commit처리
	 */
	public void modifyNotice(Notice notice){
		SqlSession session = null;
		try {
			session = factory.openSession();
			//제목과 내용을 HTML에 맞게 변환
			notice.setTitle(TextUtil.textToHtml(notice.getTitle()));
			notice.setContent(TextUtil.textToHtml(notice.getContent()));
			//DB 수정처리
			dao.updateNoticeBoard(session, notice);
			session.commit();
		} finally {
			session.close();
		}
	}
}
