package kr.or.kosta.model.service;

import java.util.List;
import java.util.Map;

import kr.or.kosta.vo.Code;
import kr.or.kosta.vo.Notice;

public interface NoticeBoardService {

	/**
	 * 등록/수정 폼에 출력할 나올 말머리를 조회 처리 
	 * @return 말머리 List
	 */
	List<Code> getWriteFormPrefix();

	/**
	 * 공지사항 등록 처리.
	 * @param notice
	 */
	void writeNotice(Notice notice);

	
	/**
	 * 글번호로 공지사항을 조회하는 메소드.
	 * 글 조회 + 조회수 1증가.
	 * @param no 조회할 공지사항 글번호
	 * @return
	 */
	Notice getNotice(int no);

	/**
	 * 글번호로 공지사항 조회하는 메소드로 등록/수정 처리 결과 보여줄때 사용.
	 * 조회만 하고 조회수 증가는 하지 않는다.
	 * @param no 조회할 등록/수정된  공지사항 글번호
	 * @return
	 */
	Notice getNoticeAsResult(int no);
	
	/**
	 * 공지사항 목록 조회 처리.
	 * @param page 조회할 페이지 번호.
	 * @return 목록에 보여줄 공지사항들(List)와 PagingBean을 Map에 묶어 리턴.
	 */
	Map<String, Object> list(int page);

	/**
	 * 공지 사항 글번호로 삭제 처리.
	 * @param no 삭제할 공지사항 글번호
	 */
	void removeByNo(int no);

	/**
	 * 글 수정폼 조회. 
	 * - title과 content를 textarea에 맞게 변환한다.
	 * - 말머리 목록도 조회해서 리턴.
	 * @param no 수정할 공지사항 글번호
	 * @return
	 */
	Map<String, Object> getModifyNotice(int no);

	/**
	 * 공지사항 글을 수정 처리하는 메소드
	 * 매개변수로 받은 Notice 객체의 글번호로 나머지 정보 수정한다.
	 * @param notice 수정할 내용
	 */
	void modifyNotice(Notice notice);

}