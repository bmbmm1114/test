package kr.or.kosta.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class InsertBatch {

	public static void main(String[] args) throws Exception{
		
		String sql = "INSERT INTO notice_board values(notice_board_seq.nextval, ?, ?, ?, ?, ?)"; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			for(int i = 1; i < 1001; i++){
				pstmt.setString(1, (int)(Math.random()*2)==0?"배송":"고객");
				pstmt.setString(2, "제목 : "+i);
				pstmt.setString(3, "공지사항 내용 "+i+" 입니다.<br>배치에서 넣었어요.<br> 1 < 2 => false 입니다.<br>A          B A와 B사이 공백은 10개 입니다."+i);
				
				long l = (long)(Math.random()*120000000000L);
				pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()-l));
				
				pstmt.setInt(5, (int)(Math.random()*120));
				
				pstmt.addBatch();
			} 
			pstmt.executeBatch();
			System.out.println("완료");
		}finally {
			if(pstmt != null)pstmt.close();
			if(conn != null) conn.close();
		}

	}

}
