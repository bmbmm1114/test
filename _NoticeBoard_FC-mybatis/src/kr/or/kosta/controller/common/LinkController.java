package kr.or.kosta.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 링크 처리 Controller<br>
 * 모든 View를 WEB-INF 아래로 빼기 위해 만듬.
 * 클라이언트 page는 html이나 jsp 요청시 링크 href에 LinkController의 command를 호출하고 쿼리 스트링(href)으로 이동할 View의 경로를 준다.
 *  
 * @author kgmyh
 *
 */
public class LinkController implements Controller{

	@Override
	public AttributeAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getParameter("href");
		return new AttributeAndView("/WEB-INF/view"+url, false); 
	}
	

}
