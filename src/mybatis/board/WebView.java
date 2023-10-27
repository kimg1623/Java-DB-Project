package mybatis.board;

import mybatis.dbtest.Addr;

import java.util.ArrayList;

public class WebView {

	/* 게시물 전체 출력 */
	public void printBoards(ArrayList<Board> BoardList) {
		System.out.println("========= [게시물 전체 읽기] =========");
		for(int i = 0; i < BoardList.size(); i++) {
			System.out.println("번호 : " + BoardList.get(i).getBno());
			System.out.println("제목 : " + BoardList.get(i).getBtitle());
			System.out.println("내용 : " + BoardList.get(i).getBcontent());
			System.out.println("작성자 : " + BoardList.get(i).getBwriter());
			System.out.println("날짜: " + BoardList.get(i).getBdate());
			System.out.println("=============================");
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

