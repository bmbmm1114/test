<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html;charset=UTF-8"%>  <!-- jsp관련 자바코드(동적)을 집어 넣겠다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
현재 시간 :  <%= new SimpleDateFormat("HH시 mm분 ss초").format(new Date())%> <br> <%-- //객체생성 // <% %>프로그램 코드를 넣겠다 --%>
			<!-- return하는 값을 여기다 찍어라 -->         
			
<% for(int i = 1; i<=10; i++){%>   <!-- 안녕하세요 10번찍어 클라이언트에게 보냄 -->
안녕하세요.<br>                                       
<%} %> 
                                        
<a href="helloweb/hello.html">hello.html로 이동</a>


</body>
</html>








