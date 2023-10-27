package mybatis.board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp {

  public static void main(String[] args) {
		
		DBUtil db = new DBUtil();
		db.init();	// db연결
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			// Boards 테이블 전체를 웹뷰로 출력
			ArrayList<Board> boardsList = db.getBoards();
			WebView wv = new WebView();
			wv.printBoards(boardsList);

			// MainMenu 출력
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
			System.out.print("메뉴 선택: ");
			String cmd = scanner.nextLine();
			
			if(cmd.equals("4")) {
				break;
				
			} else if(cmd.equals("1")) {
				System.out.println("========= [새 게시물 입력] =========");
				System.out.print("제목 : ");
				String btitle = scanner.nextLine();
				System.out.print("내용 : ");
				String bcontent = scanner.nextLine();
				System.out.print("작성자 : ");
				String bwriter = scanner.nextLine();

				//보조 메뉴 출력
				printSubMenu1();
				String menuNo = scanner.nextLine();
				if(menuNo.equals("1")) {
					//boards 테이블에 게시물 정보 저장
					try {
						db.insertBoards(btitle, bcontent, bwriter);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				System.out.println("게시물 등록 완료.");
				System.out.println("============================");
				
			} else if(cmd.equals("2")) {

				//입력 받기
				System.out.println("========= [게시물 읽기: 게시물 번호 입력] =========");
				System.out.print("bno: ");
				int bno = Integer.parseInt(scanner.nextLine());

				wv.printBoard(db.getBoard(bno));

				//보조 메뉴 출력
				printSubMenu2();
				String menuNo = scanner.nextLine();
				System.out.println();

				if(menuNo.equals("1")) {
					// update()
					System.out.println("========= [수정 내용 입력] =========");
					System.out.print("제목 : ");
					String btitle = scanner.nextLine();
					System.out.print("내용 : ");
					String bcontent = scanner.nextLine();
					System.out.print("작성자 : ");
					String bwriter = scanner.nextLine();

					db.updateBoard(bno, btitle, bcontent, bwriter);

					System.out.println("게시물 수정 완료.");
					System.out.println("============================");

				} else if(menuNo.equals("2")) {
					//delete();
					db.deleteBoard(bno);
					System.out.println(bno + "번 게시물이 삭제되었습니다.");
					System.out.println("==============================");
				}
			} else if(cmd.equals("3")) {
				// clear()
				System.out.println("========= [수정 내용 입력] =========");
				printSubMenu1();
				String menuNo = scanner.nextLine();
				if(menuNo.equals("1")) {
					//boards 테이블에 게시물 정보 저장
					try {
						db.deleteAll();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}	
	}
	/* create(), update() 입력 후 보조메뉴 */
	private static void printSubMenu1() {
		System.out.println("-------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
	}

	/* read() 검색 후 출력할 보조메뉴 */
	private static void printSubMenu2() {
		System.out.println("-------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
		System.out.print("메뉴 선택: ");
	}

}
