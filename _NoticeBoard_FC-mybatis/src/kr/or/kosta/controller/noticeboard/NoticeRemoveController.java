package kr.or.kosta.controller.noticeboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.controller.common.AttributeAndView;
import kr.or.kosta.controller.common.Controller;
import kr.or.kosta.model.service.NoticeBoardService;
import kr.or.kosta.model.service.impl.NoticeBoardServiceImpl;
/**
 * 게시글 삭제 처리 Controller
 * 
 * Model : removeByNo()
 * View : 	정상 - /controller?command=noticeList(리다이렉트)  - NoticeViewController 호출
 * 				예외-error.jsp(요청디스패치)
 * @author kgmyh
 *
 */
public class NoticeRemoveController implements Controller {

	@Override
	public AttributeAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			//요청파라미터 : 삭제할 글번호 조회
			int no = Integer.parseInt(request.getParameter("no"));
			
			NoticeBoardService service = NoticeBoardServiceImpl.getInstance();
			service.removeByNo(no);
			
			return new AttributeAndView(request.getContextPath()+"/controller?command=noticeList&page="+request.getParameter("page"), true);
		}catch(Exception e){
			e.printStackTrace();
			return new AttributeAndView("/WEB-INF/view/error.jsp", false, "errorMessage", e.getMessage());
		}
	}

}
