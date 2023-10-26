package mysql.dbtest;

import java.io.FileInputStream;
import java.sql.*;

public class BoardUpdateExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            //JDBC Driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver");

            //연결하기
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_prj", //java_prj는 스키마 이름
                    "root",
                    "12345"
            );
            //매개변수화된 SQL문 작성
            String sql = new StringBuilder()
                    .append("UPDATE boards SET ")
                    .append("btitle=?, ")
                    .append("bcontent=?, ")
                    .append("bfilename=?, ")
                    .append("bfiledata=? ")
                    .append("WHERE bno=?")
                    .toString();

            //PreparedStatement 얻기 및 값 지정
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "눈사람");
            pstmt.setString(2, "눈으로 만든 사람");
            pstmt.setString(3, "snowman.jpg");
            pstmt.setBlob(4, new FileInputStream("src/mysql/snowman.jpg"));
            pstmt.setInt(5, 2);  //boards 테이블에 있는 게시물 번호(bno) 지정

            //SQL문 실행
            int rows = pstmt.executeUpdate();
            System.out.println("수정된 행 수: " + rows);

            //PreparedStatement 닫기
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                    System.out.println("연결 끊기");
                } catch (SQLException e) {}
            }
        }
    }
}
