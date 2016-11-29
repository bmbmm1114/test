package kr.or.kosta.controller.noticeboard;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.controller.common.AttributeAndView;
import kr.or.kosta.controller.common.Controller;
import kr.or.kosta.model.service.NoticeBoardService;
import kr.or.kosta.model.service.impl.NoticeBoardServiceImpl;
/**
 * 페이지별 목록 조회처리 Controller
 * 
 * Model : list()
 * View : 	정상 - list.jsp (요청디스패치) 
 * 				예외 - error.jsp(요청디스패치)
 * @author kgmyh
 *
 */
public class NoticeListController implements Controller {

	@Override
	public AttributeAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int page = 1;//page가 안넘어오면 1 페이지를 보여준다.
		try {
			try{
				page = Integer.parseInt(request.getParameter("page"));
			}catch(NumberFormatException e){}
			NoticeBoardService service = NoticeBoardServiceImpl.getInstance();
			Map<String, Object> attributes = service.list(page);
			return new AttributeAndView("/WEB-INF/view/notice_board/list.jsp", false, attributes);
		} catch (Exception e) {
			e.printStackTrace();
			return new AttributeAndView("/WEB-INF/view/error.jsp", false, "errorMessage", "공지사항 목록 조회 도중 오류가 발생 : "+e.getMessage());
		}
		
	}

}
