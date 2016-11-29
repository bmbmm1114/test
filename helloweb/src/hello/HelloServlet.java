package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*               
 * Servlet - java CGI
 * 1. public class, javax.servlet.http.HttpServlet 를 상속(extends)
 * 2. no-argument 생성자 필수(생성자를 만들지 않는다)
 * 3. 사용자가 get이면 doget post면 dopost ..doGet() 또는 doPost() 메소드를 구현 - 클라이언트 요청을 처리하는 구문을 구현할 메소드.
 * 4. TOMCAT이 저장하라고 하는 디렉토리에다가 넣어준다 
 *                     
 * 구현이 끝나면 Web Container(Servlet실행환경) 에 만든 Servlet클래스를 등록.
 * web:xml : <Servlet> - <Servlet-name> <Servlet-class>
 * <servlet-mapping>-<servlet-name> <url-pattern> 		  
 * <servlet-class>는 HelloServlet.class -> TOMCAT에 등록																												 
*/
public class HelloServlet extends HttpServlet { //반드시 HttpServlet를 상속 받아야한다
	
	//생성자를 만들지 않음 ..no argument 자동으로 생성
  public void doGet(HttpServletRequest request, HttpServletResponse response)
  				throws IOException, ServletException{
	  //인사말, 현재시간(yyyy년 MM월 dd일 HH시 mm분 ss초)
	  Date d = new Date();
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
	  String message = sdf.format(d);
	  
	  response.setContentType("text/html;charset=utf-8");
	  PrintWriter out = response.getWriter(); //Client(Web Brower)와 연결된 Output Stream
	  out.println("<!doctype html>");
	  out.print("<html><head><title>HelloServelt</title></head>");
	  out.println("<body>");
	  out.println("안녕하세요<br>");
	  out.printf("현재시간은 %s 입니다",message);
	  out.println("<p><a href='/helloweb/hello.html'>hello.html</a>");
	  out.println("</body></html>");
	  //close는 필요없다
	  
	  //클라이언트를 여기를 원함      동적으로 html 코드를 만들고 
	  
  }
}
