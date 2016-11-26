<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${requestScope.notice.no}번 공지사항</title>
<link rel="stylesheet" type="text/css" href="${initParam.rootPath }/style/style.css">
<style type="text/css">
section{
	width:700px;
	border:1px solid gray;
}
#title{
font-weight: bold;
border-bottom: 1px solid gray;
padding: 10px;
}
#info{
	font-size: 13px;
	border-bottom: 1px dotted gray;
	padding-top: 15px;
	padding-right: 5px;
	padding-bottom: 10px;
	text-align: right;
}
#content{
	min-height:300px; /*최소 높이 300px*/
	height:auto;/*자동으로 늘어나기*/
	padding: 10px;

}
</style>
</head>

<body >
<%@ include file="/WEB-INF/view/menu.jsp" %>
<section>
	<header>
		<div id="title">${requestScope.notice.no }. ${requestScope.notice.wholeTitle }</div>
		<div id="info">작성일시 : <fmt:formatDate value="${requestScope.notice.writeDate}" pattern="yyyy-MM-dd HH:mm:ss"/> | 조회수 : ${ requestScope.notice.viewCount}</div>
	</header>
	<article id="content">${requestScope.notice.content }</article>
</section>
<p>

<a href="${initParam.rootPath }/controller?command=noticeModifyForm&no=${requestScope.notice.no}&page=${param.page}">공지사항수정</a>&nbsp;&nbsp;&nbsp;
<a href="${initParam.rootPath }/controller?command=noticeRemove&no=${requestScope.notice.no}&page=${param.page}">공지사항삭제</a>
</p>

</body>