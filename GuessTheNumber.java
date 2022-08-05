package Games;

import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

class Guesser
{
	int guessNum;
	public int guessNumber()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Guesser kindly guess the number");
		guessNum=scan.nextInt();
		return guessNum;	
	}	
}

class Player
{
	int pguessNum;
	
	public int guessNumber()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Player kindly guess the number");
		pguessNum=scan.nextInt();
		return pguessNum;
	}
}

class Umpire
{
	int player1Win=0;
	int player2Win=0;
	int player3Win=0;
	int numFromGuesser;
	int numFromPlayer1;
	int numFromPlayer2;
	int numFromPlayer3;
	
	int numberOfGuesses(){
		System.out.println("Number of Guesses: ");
		Scanner scan=new Scanner(System.in);
		int guesscount=scan.nextInt();
		return guesscount;
	}


	public void collectNumFromGuesser()
	{
		Guesser g=new Guesser();
		numFromGuesser=g.guessNumber();
		
	}
	
	
	public void collectNumFromPlayer()
	{
		Player p1=new Player();
		Player p2=new Player();
		Player p3=new Player();
		
		
		numFromPlayer1=p1.guessNumber();
		numFromPlayer2=p2.guessNumber();
		numFromPlayer3=p3.guessNumber();
	}
	
	void compare()
	{
		if(numFromGuesser==numFromPlayer1)
		{
			if(numFromGuesser==numFromPlayer2 && numFromGuesser==numFromPlayer3)
			{
				System.out.println("Game tied all three players guessed correctly");
				player1Win++;
				player2Win++;
				player3Win++;
			}
			else if(numFromGuesser==numFromPlayer2)
			{
				System.out.println("Player 1 and Player2 won the game");
				player2Win++;
			}
			else if(numFromGuesser==numFromPlayer3)
			{
				System.out.println("Player 1 and Player3 won the game");
				player3Win++;
			}
			else
			{
			System.out.println("Player 1 won the game");
			player1Win++;
			}
		}
		
		
		else if(numFromGuesser==numFromPlayer2)
		{
			
			if(numFromGuesser==numFromPlayer3)
			{
			System.out.println("Player 2 and Player3 won the game");
			player2Win++;
			player3Win++;
			}
			else
			{
				System.out.println("Player 2 won the game");
				player2Win++;
			}
		}
		
		
		
		else if(numFromGuesser==numFromPlayer3)
		{
			System.out.println("Player 3 won the game\n");
			player3Win++;
		}
		else
		{
			System.out.println("Game lost! try again\n");
		}
	}
	
	void reset()
	{
		player1Win=0;
		player2Win=0;
		player3Win=0;
	}

	void winner()
	{
		if(player1Win==player2Win && player1Win==player3Win && player1Win!=0)
			System.out.println("Game tied all three players guessed correctly");
		else if(player1Win>=player2Win && player1Win>=player3Win && player1Win!=0)
		{
			if(player1Win==player2Win)
				System.out.println("Player1 and Player2 won the game");
			else if(player1Win==player3Win)
				System.out.println("Player1 and Player3 won the game");
			else 
				System.out.println("Player1 won the game");
		}
		else if(player2Win>=player1Win && player2Win>=player3Win && player2Win!=0)
		{
			if(player1Win==player2Win)
				System.out.println("Player1 and Player2 won the game");
			else if(player2Win==player3Win)
				System.out.println("Player2 and Player3 won the game");
			else 
				System.out.println("Player2 won the game");
		}
		else if(player3Win>=player1Win && player3Win>=player2Win && player3Win!=0)
		{
			if(player1Win==player3Win)
				System.out.println("Player1 and Player3 won the game");
			else if(player3Win==player2Win)
				System.out.println("Player2 and Player3 won the game");
			else 
				System.out.println("Player3 won the game");
		}
		else 
		{
			System.out.println("No all three players guessed correctly won the game");
		}
	}
}




public class GuessTheNumber{

	public static void main(String[] args) {
		Umpire u=new Umpire();
		int guesscount=u.numberOfGuesses();
		int totalGuessesGot=guesscount;
		while(guesscount!=0)
		{
			u.collectNumFromGuesser();
			u.collectNumFromPlayer();
			u.compare();
			System.out.println("\nScore Board:\nPlayer1: "+u.player1Win+"\nPlayer2: "+u.player2Win+"\nPlayer3: "+u.player3Win);
			System.out.println("Guess Left: "+(guesscount-1)+"\n");
			guesscount--;
		}
		System.out.println("Total Number of Guesses Each Player Got : "+totalGuessesGot);
		u.winner();
		u.reset();

		
		

	}

}

