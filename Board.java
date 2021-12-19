public class Board {
	private char[][] board;
	private int lastRow;
	
	public Board() {
		board = new char[6][7];
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 7; c++) {
				board[r][c] = '_';
			}
		}
	}
	
	public char[][] getBoard() {
		return board;
	}
	
	public int getLastRow() {
		return lastRow;
	}
	
	public char getCharAtPosition(int r, int c) {
		return board[r][c];
	}
	
	public void setCharAtPosition(int r, int c, char g) {
		this.board[r][c] = g;
	}
	
	public boolean check(int lastCol, int lastRow2, int addRow, int addCol, char c) {
		for (int i = 0; i < 4; i++) {
			if (board[lastRow2 + (i * addRow)][lastCol + (i * addCol)] != c) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkConnectFour(int lastCol) {
		char c = this.board[lastRow][lastCol];
		
		for (int i = 0; i < 6; i++) {
			for (int e = 0; e < 4; e++) {
				if (board[i][e] == c && board[i][e + 1] == c
						&& board[i][e + 2] == c && c 
								== board[i][e + 3]){
									return true;
								}
			}
		}
		
		if (lastRow < 3) { // check vertical
			if (check(lastCol, lastRow, 1, 0, c)) {
				return true;
			}
		}
		else if(lastRow >= 3) { // check vertical
			if (check(lastCol, lastRow, -1, 0, c)) {
				return true;
			}
		}
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				if (row < 3) {
					if (col <= 3 && check(col, row, 1, 1, c)) {
						return true;
					}
					if (col >= 3 && check(col, row, 1, -1, c)) {
						return true;
					}
				}
				if (row >= 3) {
					if (col <= 3 && check(col, row, -1, 1, c)) {
						return true;
					}
					if (col >= 3 && check(col, row, -1, -1, c)) {
						return true;
					}
				}
				
			}
		}
		
		return false;
	}
	
	public void updateBoard(int column, char c) {
		for (int i = 5; i >= 0; i--) {
			if (this.getCharAtPosition(i, column) == '_') {
				this.setCharAtPosition(i, column, c);
				lastRow = i;
				break;
			}
		}
	}
	public String toString() {
		String re = "\n";
		for (int r = 1; r <= 6; r++) {
			re += "| ";
			for (int c = 1; c <= 7; c++) {
				re += board[r - 1][c - 1] + " ";
			}
			re += "|\n";
		}
		re += " --------------- \n  1 2 3 4 5 6 7  ";
		return re;
	}
}
