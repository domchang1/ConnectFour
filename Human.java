
public class Human extends Player{
	
	public Human(char c) {
		super(c);
	}
	
	public int makeMove(char[][] currentScoreBoard, int lastCol, int x) {
		int position = 0;
		do {
			System.out.print("Player " + (x + 1) + "'s turn: ");
			position = TextIO.getlnInt() - 1;
		}
		while(position > 6 || position < 0);
		return position;
	}
}

