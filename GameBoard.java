package TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
	private char[][] gameBoard;
	private boolean gameIsActive = true;
	
	/***************************************************************************************************************
	 * This is the constructor for the GameBoard class
	 */
	public GameBoard() {
		gameBoard = new char[3][3];
		
		//putting a space at each position so it isn't set to null initially
		
		for (int row=0; row < gameBoard.length; row++) {
			Arrays.fill(gameBoard[row], ' ');
		}
	} //end of constructor
	
	/***************************************************************************************************************
	 * This method will display the gameBoard to the screen
	 */
	public void displayBoard() {
		for (int row=0; row < gameBoard.length; row++) {
			for (int column=0; column < gameBoard[0].length; column++) {
				System.out.print("\t" + gameBoard[row][column]);
				
				if (column == 0 || column == 1){
					System.out.print("|");
				}
			}
			if( row == 0 || row == 1) {
				System.out.print("\n----------------------------\n");
			}
		}
		System.out.println();
	} //end of displayBoard method
	
	/***************************************************************************************************************
	 * This method will checks to see the game currently active
	 * @return true if the game is active.
	 */
	public boolean gameActive() {
		return gameIsActive;
	} // end of gameActive method
	
	/***************************************************************************************************************
	 * This method will ask the user to pick a row and column, validates the inputs, and calls the makeMove() method
	 */
	public void askPlayer(char player) {
		Scanner playerInput = new Scanner(System.in);
		int row, column;
		
		do {
			System.out.printf("Player %s please enter a row (1-3): ", player);
			row = playerInput.nextInt();
			
			System.out.printf("Player %s please enter a column (1-3): ", player);
			column = playerInput.nextInt();
			
			
		} while (notValid(row, column));
		
		makeMove(player, row-1, column-1);
	} //end of askPlayer method
	
	/***************************************************************************************************************
	 * This method will validate if the row and column is between 1-3
	 * @return false if the player makes an invalid move and if the position is currently empty
	 */
	public boolean notValid(int row, int column) {
		if (row < 1 || row > 3 || column < 1 || column > 3 || !isEmpty(row, column)) {
			System.out.print("You entered an invalid number. Please a pick valid number from 1 to 3.\n");
			return true;
		}
		else
			return false;
	} // end of notValid method
	
	/***************************************************************************************************************
	 * This method will validate if a players move is allowed
	 * @return true if the move was completed
	 */
	public boolean makeMove(char player, int row, int column) {
		if (row >= 0 && row <= 2 && column >= 0 && column <= 2) {
			if ( gameBoard[row][column] != ' ') {
				return false;
			} else {
				gameBoard[row][column] = player;
				return true;
			}
		} else {
			return false;
		}
	} //end of makeMove method
	
	/***************************************************************************************************************
	 * This method will check if a position is empty
	 * @return true if the position is empty, false otherwise
	 */
	public boolean isEmpty(int row, int column) {
		if (gameBoard[row-1][column-1] == ' ')
			return true;
		else {
			System.out.print("This position is taken.\n");
			return false;
		}
	} // end of isEmpty method
	
	/***************************************************************************************************************
	 * This method will check to see if there is 3 X's or 3 O's in a row.
	 * @return false if there is no winner
	 */
	public boolean checkForWinner() {
		
		//looping through the array to see if there is a horizontal winner (rows are changing)
		for (int row=0; row < gameBoard.length; row++) {
			if(gameBoard[row][0] == gameBoard[row][1] && gameBoard[row][1] == gameBoard[row][2] && gameBoard[row][0] != ' ') {
				System.out.print("The winner is player " + gameBoard[row][0] + ". Thanks for playing! :)");
				gameIsActive = false;
			}
		}
		
		//looping through the array to see if there is a vertical winner (columns are changing)
		for (int column=0; column < gameBoard.length; column++) {
			if(gameBoard[0][column] == gameBoard[1][column] && gameBoard[1][column] == gameBoard[2][column] && gameBoard[0][column] != ' ') {
				System.out.print("The winner is player " + gameBoard[0][column] + ". Thanks for playing! :)");
				gameIsActive = false;
			}
		}
		
		//checking through the array to see if there is a diagonal winner (columns are changing)
		if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != ' ') {
			System.out.print("The winner is player " + gameBoard[0][0]+ ". Thanks for playing! :)");
			gameIsActive = false;
		}
		
		if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[0][2] && gameBoard[2][0] != ' '){
			System.out.print("The winner is player " + gameBoard[2][0] + ". Thanks for playing! :)");
			gameIsActive = false;
		}
		
		return false;
	} // end of checkForWinner method
	
//	/***************************************************************************************************************
//	 * This method will check if the players want to play again.
//	 * @return true if, both players want to play again.
//	 */
//	public boolean isReplay() {
//		Scanner playerInput = new Scanner(System.in);
//		System.out.println("\nWould you like to play Tic-Tac-Toe again? (y/n, or yes/no): ");
//		String playersAnswer = playerInput.nextLine();
//		
//		if (playersAnswer == "y" || playersAnswer.toLowerCase() == "yes") {
//			gameBoard = new char[3][3];
//			return true;
//		} 
//		
//		if (playersAnswer == "n" || playersAnswer.toLowerCase() == "no") {
//			System.out.print("Bummer to see you go, but thanks for playing!");
//			gameIsActive = false;
//			return false;
//		}
//		
//		return true;
//	}
}
