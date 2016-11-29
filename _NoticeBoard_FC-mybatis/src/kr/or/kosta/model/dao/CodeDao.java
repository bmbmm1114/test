package kr.or.kosta.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.kosta.vo.Code;

public interface CodeDao {

	/**
	 * 코드 테이블에서 특정 코드 카테고리의 코드정보들을 조회하는 메소드.
	 * @param session
	 * @param codeCategory 조회할 코드 카테고리.
	 * @return
	 */
	List<Code> selectCodeByCodeCategory(SqlSession session, String codeCategory);

}