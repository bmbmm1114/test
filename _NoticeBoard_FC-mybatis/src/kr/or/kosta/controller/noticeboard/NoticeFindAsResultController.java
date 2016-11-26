package kr.or.kosta.controller.noticeboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.controller.common.AttributeAndView;
import kr.or.kosta.controller.common.Controller;
import kr.or.kosta.model.service.NoticeBoardService;
import kr.or.kosta.model.service.impl.NoticeBoardServiceImpl;
import kr.or.kosta.vo.Notice;
/**
 * 공지사항 등록, 수정 처리후 redirect 방식으로 호출될 컨트롤러
 * 등록/수정된 공지사항 정보를 조회해 리턴
 * 
 * Model : getNoticeAsResult()
 * View : 정상 - notice_view.jsp (요청디스패치) 
 * 			  예외 - error.jsp(요청디스패치)
 * @author kgmyh
 *
 */
public class NoticeFindAsResultController implements Controller {

	@Override
	public AttributeAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			int no = Integer.parseInt(request.getParameter("no"));
			
			NoticeBoardService service = NoticeBoardServiceImpl.getInstance();
			Notice notice = service.getNoticeAsResult(no);
			return new AttributeAndView("/WEB-INF/view/notice_board/notice_view.jsp", false, "notice", notice);
		}catch(Exception e){
			e.printStackTrace();
			return new AttributeAndView("/WEB-INF/view/error.jsp", false, "errorMessage", e.getMessage());
		}
	}

}
