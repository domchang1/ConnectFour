
public class Game {
	private Board ConnectFourBoard;
	private Player[] players = new Player[2];
	private int[] positions = new int[2];
	private char[][] currentBoardArray = new char[6][7];
	private int lastRow;
	private boolean fourInARow;
	
	public Game() {
		ConnectFourBoard = new Board();
		players[0] = new Human('x');
		players[1] = new Bot('o');
	}
	
	public Game(int x) {
		ConnectFourBoard = new Board();
		players[0] = new Human('x');
		if (x == 1) {
			players[1] = new Bot('o');
		}
		else {
			players[1] = new Human('o');
		}
	}
	
	public boolean seeIfWon() {
		return fourInARow;
	}
	public int playRound() throws InterruptedException { 
		System.out.println("Board:");
		System.out.println(ConnectFourBoard.toString());
		for (int i = 0; i < 2; i++) {
			if (players[i] instanceof Human) {
				positions[i] = players[i].makeMove(currentBoardArray,lastRow,i);
				
			}
			else {
				positions[i] = players[i].makeMove(currentBoardArray, positions[i - 1], lastRow);
				System.out.println("\uD83E\uDD16" + "AI's move: " + (positions[i] + 1));
			}
			ConnectFourBoard.updateBoard(positions[i], players[i].getSymbol());
			lastRow = ConnectFourBoard.getLastRow(); //update previous position
			currentBoardArray = ConnectFourBoard.getBoard(); // update previous position
			System.out.println(ConnectFourBoard.toString());
			if(ConnectFourBoard.checkConnectFour(positions[i])) {
				fourInARow = true;
				return i;
			}
			Thread.sleep(1500);
		}
		return 0;
	}
	
	

}
