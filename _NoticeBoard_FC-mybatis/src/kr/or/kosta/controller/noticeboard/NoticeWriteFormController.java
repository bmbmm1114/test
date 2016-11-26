package kr.or.kosta.controller.noticeboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.controller.common.AttributeAndView;
import kr.or.kosta.controller.common.Controller;
import kr.or.kosta.model.service.NoticeBoardService;
import kr.or.kosta.model.service.impl.NoticeBoardServiceImpl;
/**
 * 글 작성 폼 조회 처리 Controller
 *  - 말머리에 붙일 Code목록을 조회해서 전송한다.
 *  
 *  Model : getWriteFormPrefix()
 *  View : 	정상 -  write_form.jsp(요청디스패치)
 *  			예외 - error.jsp(요청디스패치)
 * @author kgmyh
 *
 */
public class NoticeWriteFormController implements Controller{

	@Override
	public AttributeAndView handle(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		NoticeBoardService service = NoticeBoardServiceImpl.getInstance();
		try {
			return new AttributeAndView("/WEB-INF/view/notice_board/write_form.jsp", false, 
														"codeList", service.getWriteFormPrefix());
		} catch (Exception e) {
			e.printStackTrace();
			return new AttributeAndView("/WEB-INF/view/error.jsp", false, "errorMessage", e.getMessage());
		}
	}
	
}
