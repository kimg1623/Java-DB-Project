package mybatis.board;

import mybatis.dbtest.Addr;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WebView {

	/* 게시물 전체 출력 */
	public void printBoards(ArrayList<Board> BoardList) {
		System.out.println("---------------------------[게시물 전체 목록]---------------------------");
		System.out.printf("%-6s%-10s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("-----------------------------------------------------------------------");

		DateFormat dateFomatter = new SimpleDateFormat("yyyy-MM-dd");
		for(int i = 0; i < BoardList.size(); i++) {
			System.out.printf("%-6s%-10s%-16s%-40s \n",
					BoardList.get(i).getBno(),
					BoardList.get(i).getBwriter(),
					dateFomatter.format(BoardList.get(i).getBdate()),
					BoardList.get(i).getBtitle());
		}
	}

	/* 게시물 1개 출력 */
	public void printBoard(Board board) {
		System.out.println("========= [게시물 읽기] =========");
		System.out.println("번호 : " + board.getBno());
		System.out.println("제목 : " + board.getBtitle());
		System.out.println("내용 : " + board.getBcontent());
		System.out.println("작성자 : " + board.getBwriter());
		System.out.println("날짜: " + board.getBdate());
		System.out.println("=============================");
	}
}

