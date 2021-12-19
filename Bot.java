
public class Bot extends Player{
	
	public Bot(char c) {
		super(c);
	}
	
	public int makeMove(char[][] currentScoreBoard, int lastCol, int lastRow) {
		char player = 'x';
		int counter = 0;
		int save = 0;
		int counterForOpen = 0;
		int returnVal = 0;
		if (lastRow < 4 && lastRow > 0) {
			for (int i = 0; i < 3; i++) {
				if(currentScoreBoard[lastRow + i][lastCol] == player) {
					counter++;
				}
			}
			if (counter == 3) {
				return lastCol;
			}
		}
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 4; c++) {
				counter = 0;
				save = 0;
				counterForOpen = 0;
				for (int i = 0; i < 4; i++) {
					if (currentScoreBoard[r][c + i] == player) {
						counter++;
					}
					if (currentScoreBoard[r][c + i] == '_') {
						save = c + i;
						counterForOpen += 1;	
					}
				}
				if (counter == 3 && counterForOpen == 1) {
					return save;
				}
			}
		}
		
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) { 
				if (row < 3) {
					if (col <= 3) {
						returnVal = check(currentScoreBoard, row, col, 1, 1);
						if (returnVal != -1) {
							return returnVal; 
						}
					}
					if (col >= 3) {
						returnVal = check(currentScoreBoard, row, col, 1, -1);
						if (returnVal != -1) {
							return returnVal; 
						}
					}
				}
				if (row >= 3) {
					if (col <= 3) {
						returnVal = check(currentScoreBoard, row, col, -1, 1);
						if (returnVal != -1) {
							return returnVal; 
						}
					}
					if (col >= 3) {
						returnVal = check(currentScoreBoard, row, col, -1, -1);
						if (returnVal != -1) {
							return returnVal; 
						}
					}
				} 
			}
		}
		returnVal = (int)(Math.random() * 7);
		do {
		returnVal = (int)(Math.random() * 7);
		}
		while(currentScoreBoard[0][returnVal] != '_');
		return returnVal;
	}
	
	public int check(char[][]scoreBoard, int row, int col, int AddRow, int AddCol) {
		int counter = 0;
		for (int i = 0; i < 3; i++) {
			if(scoreBoard[row + (i * AddRow)][col + (i * AddCol)] == 'x') {
				counter++;
			}
		}
		if (counter == 3) {
			if (scoreBoard[row + (3 * AddRow)][col + (3 * AddCol)] == '_') {
				return col + (3 * AddCol);
			}
			if (scoreBoard[row + AddRow][col + AddCol] == '_') {
				return col + AddCol;
			}
		}
		return -1;
	}
}
