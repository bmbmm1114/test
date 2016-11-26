package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingServlet extends HttpServlet{
   public void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException, ServletException{
      
      Date d = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분  ss초");
      String message = sdf.format(d);
      
      response.setContentType("text/html;charset=utf-8");// 응답데이터의 타입을 MIME-TYPE으로 설정. 텍스트 종류중에  html이야. 
                                          //여기 한글 들어 간걸 알려주기 위해서 utf-8을 알려준다. charset=utf-8에 공백이 들어가면 안된다.
      
      PrintWriter out = response.getWriter();   // 응답을 위한 출력 스트림.(Web Browser와 연결) HeepServelt으로 부터 response를 가져옴.
      out.println("<!doctype html>");
      out.println("<html><head><title>GreetingServlet</title></head>");
      out.println("<body>");
      out.printf("현재시간은 %s입니다.<br>",message);
      for(int i =1; i<=10; i++){
      out.println("안녕하세요"+i+"<br>");
      }
      out.println("<p><a href='/helloweb/hello.html'>hello.html</a>");
      out.println("</body></html>");
   }
}