package kr.or.kosta.controller.common;

import kr.or.kosta.controller.noticeboard.NoticeFindAsResultController;
import kr.or.kosta.controller.noticeboard.NoticeListController;
import kr.or.kosta.controller.noticeboard.NoticeModifyController;
import kr.or.kosta.controller.noticeboard.NoticeModifyFormController;
import kr.or.kosta.controller.noticeboard.NoticeRemoveController;
import kr.or.kosta.controller.noticeboard.NoticeViewController;
import kr.or.kosta.controller.noticeboard.NoticeWriteController;
import kr.or.kosta.controller.noticeboard.NoticeWriteFormController;

public class HandlerMapping {

	public static Controller getController(String command){
		System.out.println(command);
		Controller controller = null;
		if(command.equals("link")){//링크
			controller = new LinkController();
		}else if(command.equals("noticeWriteForm")){//글쓰기폼
			controller = new NoticeWriteFormController();
		}else if(command.equals("noticeWrite")){//글쓰기 
			controller = new NoticeWriteController();
		}else if(command.equals("noticeViewAsResult")){//조회수 증가없이 글조회
			controller = new NoticeFindAsResultController();
		}else if(command.equals("noticeList")){//글목록
			controller = new NoticeListController();
		}else if(command.equals("noticeView")){//글상세
			controller = new NoticeViewController();
		}else if(command.equals("noticeRemove")){//글삭제
			controller = new NoticeRemoveController();
		}else if(command.equals("noticeModifyForm")){//글 수정폼
			controller = new NoticeModifyFormController();
		}else if(command.equals("noticeModify")){//글 수정 처리
			controller = new NoticeModifyController();
		}

		return controller;
	}
}
