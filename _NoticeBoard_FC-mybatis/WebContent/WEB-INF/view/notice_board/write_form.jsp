<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${initParam.rootPath }/style/style.css">
<script type="text/javascript" src="${initParam.rootPath }/script/notice_formcheck.js"></script>
<style type="text/css">
select{
	width: 70px;
}

</style>
</head>
<body>
<%@ include file="/WEB-INF/view/menu.jsp" %>
<c:if test="${not empty requestScope.errorList }">
	<ul id="error">
		<c:forEach items="${requestScope.errorList }" var="error">
			<li>${error }</li>
		</c:forEach>
	</ul>
</c:if>
<form action="${initParam.rootPath}/controller" method="post"
		  name="form1" onsubmit="return checkForm();">
<input type="hidden" name="command" value="noticeWrite">
<table>
	<tr>
		<td>
			<select name="prefix">
				<option>말머리</option>
				<c:forEach items="${requestScope.codeList }" var="code">
					<option ${code.codeName == param.prefix?'selected="selected"':'' }>${code.codeName }</option>
				</c:forEach>
			</select>
			<input type="text" name="title" size="70" placeholder="공지사항 제목" value="${param.title }">
		</td>
	</tr>
	<tr>
		<td>
			<textarea rows="20" cols="100" name="content">${param.content }</textarea>
		</td>
	</tr>
	<tr>
		<td align="center"><input type="submit" value="공지사항등록"> <input type="reset" value="초기화"></td>
	</tr>	
</table>
</form>
</body>
</html>