package bitcamp.java142.board.dao;

import java.util.ArrayList;

import bitcamp.java142.board.vo.LdbHelloBoardVO;
import bitcamp.java142.ch5.ldbjf.vo.LdbMemberVO;

public interface LdbHelloBoardDAO {
	
	int boardInsert(LdbHelloBoardVO i_lvo);
	
	int boardUpdate(LdbHelloBoardVO i_lvo);
	
	int boardDelete(LdbHelloBoardVO i_lvo);
	
	ArrayList<LdbHelloBoardVO> boardSelectAll();
	
	ArrayList<LdbHelloBoardVO> boardSelect(LdbHelloBoardVO i_lvo);

}
