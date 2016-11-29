/**
 * 공지사항 등록, 수정시 입력폼 체크
 */

function checkForm(){
	var form = document.form1;
	if(form.prefix.selectedIndex == 0){
		alert("말머리를 선택하세요");
		return false;
	}
	if(!form.title.value){
		alert("제목을 넣으세요");
		form.title.focus();
		return false;
	}
	if(!form.content.value){
		alert("글내용을 입력하세요");
		form.content.focus();
		return false;
	}
}
