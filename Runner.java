
public class Runner {
	
	public static void main(String[] args) throws InterruptedException {
		
		int playerWhoWon = 0;
		System.out.println("**" + "\uD83D\uDE0E" + "Welcome to Connect Four!" + "\uD83D\uDE0E" + "**");
		System.out.print("Enter '2' for 2 players and '1' for single player(against AI): ");
		int choice = TextIO.getlnInt();
		Game newGame = new Game(choice);
		String player1;
		String player2;
		if (choice == 1) {
			player1 = "You";
			player2 = "The AI" + "\uD83E\uDD16";
		}
		else {
			player1 = "Player 1";
			player2 = "Player 2";
		}
		System.out.println( player1 + " will be using the char x");
		System.out.println(player2 + " will be using the char o");
		System.out.println("When it is your turn, enter the column number you want to drop your chip in");
		Thread.sleep(1000);
		while (!newGame.seeIfWon()) { 
			playerWhoWon = newGame.playRound();
		}
		playerWhoWon++;
		System.out.println();
		if (choice == 2) {
			System.out.println("Congratulations Player " + playerWhoWon + " on winning!" + "\uD83D\uDE01");
		}
		else {
			if (playerWhoWon == 2) {
				System.out.println("\uD83D\uDE14" + "AI won" + "\uD83D\uDE14");
			}
			else {
				System.out.println("\uD83D\uDE01" + "Congratulations on winning!" + "\uD83D\uDE01");
			}
		}
	}
}
