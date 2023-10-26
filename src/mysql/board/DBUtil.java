package mysql.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public Connection init() {
        Connection conn = null;

        try {
            // JDBC Driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 연결하기
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_prj", //java_prj는 스키마 이름
                    "root",
                    "12345"
            );
            System.out.println("연결 성공");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(conn != null) {
                return conn;
            }
        }
        return null;
    }
}
