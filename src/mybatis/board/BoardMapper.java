package mybatis.board;

import java.util.ArrayList;

public interface BoardMapper {
	
	public ArrayList<Board> getBoards();
	public Board getBoard(int bno);
	public void insertBoards(Board board);
	public void updateBoard(Board board);
	public void deleteBoard(int bno);
	public void deleteAll();
}
