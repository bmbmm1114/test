<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지</title>
<link rel="stylesheet" type="text/css" href="${initParam.rootPath }/style/style.css">
</head>
<body>
<%@ include file="/WEB-INF/view/menu.jsp" %>
<h2>처리도중 오류가 발생했습니다.</h2>
<div id="error">
${requestScope.errorMessage }
</div>
</body>
</html>