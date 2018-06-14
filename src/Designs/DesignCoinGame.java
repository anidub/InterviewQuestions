package Designs;

import java.util.Scanner;
/*
 * Design a coin game
 * http://www.newthinktank.com/2012/12/object-oriented-design-2/
 */
public class DesignCoinGame {

	static class Player{
		String name = "";
		String coinOption= "";	
		String[] coinValue = {"Head","Tail"};
		public Player(String name){
			this.name = name;
		}
		// Set coinOption to the opposite of what is sent
		public void setCoinOption(String opponetFlip){
			coinOption = opponetFlip == "Head" ? "Tail" : "Head";
		}
		public String getCoinOption(){
			return coinOption;
		}
		
		public String getRandomCoinOption(){
			// Set the value based on the index chosen at random for the array coinValue which will be either Heads or Tails
			int randomNum = Math.random() < 0.5 ? 0 : 1;
			coinOption = coinValue[randomNum];
			return coinOption;
		}
		
		public void didPlayerWin(String winningFlip){
			if(coinOption == winningFlip){
				System.out.println(name + " won a flip of " + coinOption);
			}else{
				System.out.println(name + " lost with a flip of " + coinOption);
			}
		}		
	}	
	
	static class Coin{
		String coinOption;
		String[] coinValue = {"Head", "Tail"};
		
		Coin(){
			int randomNum = Math.random() < 0.5 ? 0 : 1;
			coinOption = coinValue[randomNum];
		}
		
		public String getCoinOption(){
				return coinOption;
		}
	}
	
	static class CoinGame{
		Player[] players = new Player[2];
		Coin theCoin = new Coin();
		
		CoinGame(String player1Name, String player2Name){
			players[0] = new Player(player1Name);
			players[1]= new Player(player2Name);
		}
		
		public void startGame(){
			// Pick a random player to choose the face value guess
			int randIndex = Math.random() < 0.5 ? 0 : 1;
			String playerspick = players[randIndex].getRandomCoinOption();
			
			 // Set the opponents coinOption to the opposite value
			int opponentIndex = randIndex == 0 ? 1 : 0;
			players[opponentIndex].setCoinOption(playerspick);
			
			// Flip the coin to find the winning side
			String winningFlip = theCoin.getCoinOption();
			
			players[0].didPlayerWin(winningFlip);
			players[1].didPlayerWin(winningFlip);
		}
		
	}

	public static void main(String[] args) {
		// Create a coin game with the 2 players provided

		CoinGame theCoinGame = new CoinGame("Mark", "Tom");

		String usersAnswer;

		do {
			theCoinGame.startGame();
			System.out.println("Play Again? ");
			Scanner playGameAgain = new Scanner(System.in);
			usersAnswer = playGameAgain.nextLine();
		} while ((usersAnswer.startsWith("y")) || (usersAnswer.startsWith("Y")));
	}
}