package kr.or.kosta.controller.noticeboard;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.controller.common.AttributeAndView;
import kr.or.kosta.controller.common.Controller;
import kr.or.kosta.model.service.NoticeBoardService;
import kr.or.kosta.model.service.impl.NoticeBoardServiceImpl;
import kr.or.kosta.vo.Notice;
/**
 * 게시글 등록 처리 Controller
 * 
 * Model : writeNotice()
 * View : 정상 - /controller?command=noticeViewAsResult(리다이렉트) - NoticeFindAsResultController호출
 *           요청파라미터오류 - /controller?command=noticeWriteForm(요청디스패치) - NoticeWriteFormController 호출
 *           예외 - error.jsp(요청디스패치)
 * @author kgmyh
 *
 */
public class NoticeWriteController implements Controller {

	@Override
	public AttributeAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//요청파라미터 : 등록할 게시글 정보 조회
		String prefix = request.getParameter("prefix");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//글번호는 Sequence 이용해 조회, 조회수는 0, 작성일은 Date객체 생성해서 처리
		
		//요청파라미터 검증
		//검증도중 에러발생시 에러메세지를 저장할 ArrayList
		ArrayList<String> errorList = new ArrayList<String>();
		if(prefix!=null && prefix.equals("말머리")){
			errorList.add("말머리를 선택하세요");
		}
		if(title==null || title.trim().isEmpty()){
			errorList.add("공지사항 제목을 넣으세요.");
		}
		if(content == null||content.trim().isEmpty()){
			errorList.add("공지사항 내용을 넣으세요.");
		}
		//에러메세지가 있는 경우 게시글 작성폼페이지로 이동.
		if(errorList.size() != 0){
			return new AttributeAndView("/controller?command=noticeWriteForm", false, "errorList", errorList);
		}
		
		//글 작성 처리.
		Notice notice = new Notice(prefix, title, content, new Date());
		NoticeBoardService service = NoticeBoardServiceImpl.getInstance();
		try{
			service.writeNotice(notice);
			return new AttributeAndView(request.getContextPath()+"/controller?command=noticeViewAsResult&no="+notice.getNo(), true);
		} catch (Exception e) {
			e.printStackTrace();
			return new AttributeAndView("/WEB-INF/view/error.jsp", false, "errorMessage", "등록 도중 오류가 발생 : "+e.getMessage());
		}
	}

}
