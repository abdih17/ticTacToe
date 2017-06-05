package TicTacToe;

/**
 * 
 * @author HAbdi
 */

public class TicTacToe {

	public static void main(String[] args) {
		System.out.print("Welcome to my Tic-Tac-Toe game: ");
		System.out.println();
		System.out.println();
		
		GameBoard myGame = new GameBoard();
		myGame.displayBoard();
		int counter = 1;
		
		while (myGame.gameActive() && counter < 10) {
			if(counter % 2 == 0)
				myGame.askPlayer('O');
			else
				myGame.askPlayer('X');
			counter++;
			
			System.out.println("\n");
			myGame.displayBoard();
			myGame.checkForWinner();
			
			if (counter == 10) {
				System.out.print("Stale mate! GAME OVER!");
			}
		}
		

	}

}
