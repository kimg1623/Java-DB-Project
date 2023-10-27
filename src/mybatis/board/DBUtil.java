package mybatis.board;

import mybatis.board.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;

public class DBUtil {

	String url = "jdbc:mysql://localhost:3306/java_prj";
	String user = "root";
	String pass = "12345";
	SqlSessionFactory sqlSessionFactory;

	// MyBatis 설정 파일 가져오기
	public void init() {
		try {
			String resource = "mybatis/board/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (Exception e) {
			System.out.println("MyBatis 설정 파일 가져오는 중 문제 발생!!");
			e.printStackTrace();
		}
	}

	//
	public ArrayList<Board> getBoards() {
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		ArrayList<Board> boardList = mapper.getBoards();

		return boardList;
	}

	public Board getBoard(int bno) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		Board board = mapper.getBoard(bno);

		return board;
	}
	
	public void insertBoards(String btitle, String bcontent, String bwriter) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		Board board = new Board(btitle, bcontent, bwriter);
		mapper.insertBoards(board);
		
		session.commit(); // update, delete, insert
	}
	
	public void updateBoard(int bno, String btitle, String bcontent, String bwriter) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		Board board = new Board(bno, btitle, bcontent, bwriter);
		mapper.updateBoard(board);
		
		session.commit(); // update, delete, insert
	}
	
	public void deleteBoard(int bno) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		mapper.deleteBoard(bno);
		
		session.commit(); // update, delete, insert
	}

	public void deleteAll() {
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		mapper.deleteAll();

		session.commit(); // update, delete, insert
	}
	
}
