package com.domain.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.domain.board.dao.HealthDao;
import com.mydomain.vo.Board;
import com.mydomain.vo.CodeTable;


//import com.domain.member.vo.Member;

public class HealthDaoImp implements HealthDao {
	
	private static HealthDaoImp instance;

	private HealthDaoImp() {
	}

	public static HealthDaoImp getInstance() {
		if (instance == null) {
			instance = new HealthDaoImp();
		}
		return instance;
	}
	private String makeSql(String tagId){
		return "board."+tagId;
	}
	/*@Override
	public int insertMember(SqlSession session, Member member) {
		return session.insert(makeSql("insertMember"), member);
	}

	@Override
	public int updateMemberById(SqlSession session, Member member) {
		return session.update(makeSql("updateMemberById"), member);
	}

	@Override
	public int deleteMemberById(SqlSession session, String memberId) {
		return session.delete(makeSql("deleteMemberById"), memberId);
	}

	@Override
	public Member selectMemberById(SqlSession session, String memberId) {
		return session.selectOne(makeSql("selectMemberById"), memberId);
	}

	@Override
	public List<Member> selectMemberByName(SqlSession session, String memberName) {
		return session.selectList(makeSql("selectMemberByName"), memberName);
	}

	@Override
	public List<Member> selectMemberList(SqlSession session) {
		return session.selectList(makeSql("selectMemberList"));
	}

	@Override
	public List<Member> selectMemberByMileageRange(SqlSession session, int startMileage, int endMileage) {
		HashMap param = new HashMap();
		param.put("startMileage", startMileage);
		param.put("endMileage", endMileage);
		return session.selectList(makeSql("selectMemberByMileageRange"), param);
	}
	 *****추가 - page단위 회원목록 조회************* 

	@Override
	public List<Member> selectMemberList(SqlSession session, int page) {
		HashMap param = new HashMap();
		param.put("itemPerPage", Constants.ITEMS_PER_PAGE);
		param.put("page", page);
		return session.selectList(makeSql("selectMemberListPaging"), param);
	}

	@Override
	public int selectCountMember(SqlSession session) {
		return session.selectOne(makeSql("selectCountMember"));
	}*/

	@Override
	public int insertMember(SqlSession session, Board board) {
		// TODO Auto-generated method stub
		return session.insert(makeSql("insertboard"), board);
	}
	
	public List<CodeTable> selectBoardById(SqlSession session) {
		return session.selectList(makeSql("selectBoardById"));
	}
	
	public int updateBoardById(SqlSession session, Board board) {
		return session.update(makeSql("updateBoardById"), board);
	}
	

	public Board selectMemberById1(SqlSession session, int memberId)
	{
		return session.selectOne(makeSql("selectlistById"),memberId);
	}
	
	public int deleteMemberById(SqlSession session, int memberId) {
		return session.delete(makeSql("deleteBoardById"), memberId);
	}
	
	public List<Board> selectMemberList(SqlSession session) {
		return session.selectList(makeSql("selectBoardList"));
	}

	@Override
	public Board selectMemberById(SqlSession session, int memberId) {
		// TODO Auto-generated method stub
		return null;
	}

}











