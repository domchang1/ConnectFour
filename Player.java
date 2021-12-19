
public abstract class Player {
	private char Symbol;
	
	public Player(char symbol) {
		this.Symbol = symbol;
	}
	
	public char getSymbol() {
		return this.Symbol;
	}
	
	public abstract int makeMove(char[][] currentScoreBoard, int lastCol, int lastRow);
}
