package kr.or.kosta.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.kosta.vo.Notice;

public interface NoticeBoardDao {


	/**
	 * 글번호로 하나의 공지사항 글을 조회하는 메소드.
	 * @param session
	 * @param no 조회할 공지사항 글번호
	 * @return 조회한 공지사항. 글이 없을 경우 null
	 */
	Notice selectNoticeBoardByNo(SqlSession session, int no);

	/**
	 * 게시판 목록의 보여질 게시물들을 page단위로 조회하는 메소드
	 * @param session
	 * @param page 보여질 목록 page 번호
	 * @return
	 */
	List<Notice> selectNoticeBoardList(SqlSession session, int page);

	/**
	 * 총 게시물 수를 조회하는 메소드.
	 * @return
	 */
	int selectCountNoticeBoard(SqlSession session);

	/**
	 * 공지사항 게시물 글을 insert하는 메소드.
	 * 글번호는 notice_board_seq 시퀀스를 이용해 넣는다. 조회수는 0으로 설정. 
	 * @param notice insert할 공지사항 글정보.
	 * @return
	 */
	int insertNoticeBoard(SqlSession session, Notice notice);

	/**
	 * no로 view_count(조회수) update 처리 메소드.
	 * @param session
	 * @param no 조회수를 증가시킬 공지사항 글번호
	 * @return
	 */
	int updateViewCount(SqlSession session, int no);

	/**
	 * 공지사항 글번호로 하나의 게시물의 나머지 내용을 update
	 * @param session
	 * @param notice 수정할 내용을 담은 Notice객체
	 * @return
	 */
	int updateNoticeBoard(SqlSession session, Notice notice);

	/**
	 * 글번호로 공지사항 게시물을 delete 처리.
	 * @param session
	 * @param no 삭제할 공지사항 글번호
	 * @return
	 */
	int deleteNoticeBoardByNo(SqlSession session, int no);

}