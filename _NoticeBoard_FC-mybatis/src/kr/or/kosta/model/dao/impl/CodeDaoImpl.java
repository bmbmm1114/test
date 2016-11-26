package kr.or.kosta.model.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.kosta.model.dao.CodeDao;
import kr.or.kosta.vo.Code;

public class CodeDaoImpl implements CodeDao {
	
	private static CodeDao instance;
	private CodeDaoImpl() {
	}

	public static CodeDao getInstance() {
		if (instance == null) {
			instance = new CodeDaoImpl();
		}
		return instance;
	}
	private String makeSqlId(String id){
		return "codeMapper."+id;
	}
	
	@Override
	public List<Code> selectCodeByCodeCategory(SqlSession session, String codeCategory){
		return session.selectList(makeSqlId("selectCodeByCodeCategory"), codeCategory);
	}
}
