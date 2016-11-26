package kr.or.kosta.controller.noticeboard;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.controller.common.AttributeAndView;
import kr.or.kosta.controller.common.Controller;
import kr.or.kosta.model.service.NoticeBoardService;
import kr.or.kosta.model.service.impl.NoticeBoardServiceImpl;

/**
 * 수정 폼 조회하는 Controller
 * 		수정할 글의 정보 조회
 *     말머리에 붙일 Code목록을 조회해서 전송한다.
 *     
 * Model : getModifyNotice()
 * View : 	정상 - modify_form.jsp(요청디스패치) 
 * 				예외 : error.jsp(요청디스패치)
 * @author kgmyh
 *
 */
public class NoticeModifyFormController implements Controller {

	@Override
	public AttributeAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			//요청파라미터 조회 : 수정할 글 번호 
			int no = Integer.parseInt(request.getParameter("no"));
			
			NoticeBoardService service = NoticeBoardServiceImpl.getInstance();
			Map<String, Object> map= service.getModifyNotice(no);
			
			return new AttributeAndView("/WEB-INF/view/notice_board/modify_form.jsp", false, map);
		}catch(Exception e){
			e.printStackTrace();
			return new AttributeAndView("/WEB-INF/view/error.jsp", false, "errorMessage", e.getMessage());
		}
	}

}
