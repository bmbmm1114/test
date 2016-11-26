<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
<link rel="stylesheet" type="text/css" href="${initParam.rootPath }/style/style.css">
<style type="text/css">
/* table 스타일 처리  */
table, td, th {    
    border: 1px solid gray;
}
table {
    border-collapse: collapse;
    width:650px
}
th, td {
    padding: 5px;
}
</style>
</head>
<body>
<%@ include file="/WEB-INF/view/menu.jsp" %>
<h2>공지사항</h2>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>공지일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.list }" var="notice">
			<tr>
				<td>${notice.no }</td>
				<td>
					<a href="${initParam.rootPath }/controller?command=noticeView&no=${notice.no}&page=${requestScope.pageBean.page}">
						${notice.wholeTitle }
					</a>
				</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${notice.writeDate }"/></td>
				<td>${notice.viewCount }</td>
			</tr>	
		</c:forEach>
	</tbody>
</table>
<%--페이징 처리 --%>
<p>
<%-- 첫페이지로 이동 --%>
<a href="${initParam.rootPath }/controller?command=noticeList&page=1">◁</a>&nbsp;&nbsp;

<%--◀이전 페이지 그룹 처리 --%>
<c:choose>
	<c:when test="${requestScope.pageBean.previousPageGroup }">
		<a href="${initParam.rootPath }/controller?command=noticeList&page=${requestScope.pageBean.beginPage - 1}">
		◀
		</a>
	</c:when>
	<c:otherwise>◀</c:otherwise>
</c:choose>
<%--페이지 처리 --%>
<c:forEach begin="${requestScope.pageBean.beginPage }" end="${requestScope.pageBean.endPage }" var="page">
	<c:choose>
		<c:when test="${page == requestScope.pageBean.page }">
		 [${page }]
		</c:when>
		<c:otherwise>
			<a href="${initParam.rootPath }/controller?command=noticeList&page=${page }">
				${page }
			</a>
		</c:otherwise>
	</c:choose>
&nbsp;&nbsp;
</c:forEach>


<%--다음 페이지 그룹 처리 ▶--%>
<c:choose>
	<c:when test="${requestScope.pageBean.nextPageGroup }">
		<a href="${initParam.rootPath }/controller?command=noticeList&page=${requestScope.pageBean.endPage + 1}">
		▶
		</a>&nbsp;&nbsp;
	</c:when>
	<c:otherwise>▶&nbsp;&nbsp;</c:otherwise>
</c:choose>

<%--마지막 페이지로 이동 --%>
<a href="${initParam.rootPath }/controller?command=noticeList&page=${requestScope.pageBean.totalPage}">▷</a>

</p>
</body>
</html>