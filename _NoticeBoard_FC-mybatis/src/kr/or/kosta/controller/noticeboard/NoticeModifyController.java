package kr.or.kosta.controller.noticeboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.controller.common.AttributeAndView;
import kr.or.kosta.controller.common.Controller;
import kr.or.kosta.model.service.NoticeBoardService;
import kr.or.kosta.model.service.impl.NoticeBoardServiceImpl;
import kr.or.kosta.vo.Code;
import kr.or.kosta.vo.Notice;
/**
 * 수정처리 Controller
 * 
 * Model : modifyNotice()
 * View : 	정상 - /controller?command=noticeViewAsResult(리다이렉트)  - NoticeFindAsResultController호출  
 * 				요청파라미터오류 - modify_form.jsp(요청디스패치) 
 * 				예외발생 - error.jsp(요청디스패치)
 * @author kgmyh
 *
 */
public class NoticeModifyController implements Controller {

	@Override
	public AttributeAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		NoticeBoardService service = NoticeBoardServiceImpl.getInstance();
		//요청파라미터 조회
		int no = 0; 
		String prefix = request.getParameter("prefix");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//검증작업
		//검증시 발생하는 에러메세지를 저장할 ArrayList
		ArrayList<String> errorList = new ArrayList<String>();
		
		try{
			no = Integer.parseInt(request.getParameter("no"));
		}catch(NumberFormatException ne){
			errorList.add("글번호가 문제가 있어 수정할 수 없습니다.");
		}
		if(prefix!=null && prefix.equals("말머리")){
			errorList.add("말머리를 선택하세요");
		}
		if(title==null || title.trim().isEmpty()){
			errorList.add("공지사항 제목을 넣으세요.");
		}
		if(content == null||content.trim().isEmpty()){
			errorList.add("공지사항 내용을 넣으세요.");
		}
		//에러 메세지가 있는 경우 수정폼으로 이동.
		if(errorList.size() != 0){
			List<Code> prefixList = service.getWriteFormPrefix();
			HashMap<String, Object> map = new HashMap<>();
			map.put("codeList", prefixList);
			map.put("errorList", errorList);
			return new AttributeAndView("/WEB-INF/view/notice_board/modify_form.jsp", false,  map);
			
		}
		
		//수정처리.
		Notice notice = new Notice(no, prefix, title, content);
		
		try{
			service.modifyNotice(notice);
			//수정 처리 결과 페이지로 이동 - 수정정보를 보여주기 위해 no값을 Query String으로 해서 이동.
			//새로고침시 재 수정되는 것을 막기 위해 redirect방식으로 이동
			return new AttributeAndView(request.getContextPath()+"/controller?command=noticeViewAsResult&no="+no+"&page="+request.getParameter("page"), true);
		} catch (Exception e) {
			e.printStackTrace();
			return new AttributeAndView("/WEB-INF/view/error.jsp", false, "errorMessage", "등록 도중 오류가 발생 : "+e.getMessage());
		}
	}

}
