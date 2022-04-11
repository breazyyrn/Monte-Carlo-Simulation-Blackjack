import java.util.ArrayList;
import java.util.*;
/**
 * SimulationWithExtensions.java
 * Blackjack Game
 * Bryan Thiam
 * CS231 S22
 * Lab C & D
 */
public class SimulationWithExtensions {
    public static void main(String[] args) {
        //Initial amount in each player's bank account
        int playerInitialAmount = 10000;
        int dealerInitialAmount = 10000;


        /**Everytime player wins add 1 integer to the list 
         * Once the game is done running calculate the lists' size which calculates
         * How many games the player won.
         */ 
        ArrayList<Integer> PlayerWins = new ArrayList<Integer>();
        ArrayList<Integer> DealerWins = new ArrayList<Integer>();
        ArrayList<Integer> TiedGames = new ArrayList<Integer>();


        int playerBankAccount = playerInitialAmount;
        int dealerBankAccount = dealerInitialAmount;

        for (int i = 0; i<3; i++) {
            //This is the betting system corresponding to players bet
            //Make a scanner object which scans inputed items
            Scanner sc = new Scanner(System.in);
            //Player inputs wager
            System.out.println("Player, Enter your wager: ");
            //Scans the inputed integer
            int num = sc.nextInt();
            //Adds player's Waged amount to playerwager variable
            int playerWager = num;
            System.out.println("Your wager is: " + playerWager);
            //Removes amount player waged from their bank account 
            int playerRemainingBalance = playerBankAccount - playerWager;
            
            

             //This is the betting system corresponding to the dealers bet
            //Dealer inputs wager
            System.out.println("Dealer, Enter your wager: ");
            //Scans integer inputed on command line
            int numb = sc.nextInt();
            int dealerWager = numb;
            System.out.println("Your wager is: " + dealerWager);
           
            //Removes amount dealer waged from their bank account
            int dealerRemainingBalance = dealerBankAccount - dealerWager;


            

            //Game starts
            Blackjack gameBlackjack = new Blackjack(36);
            int results = gameBlackjack.game(true);
            System.out.println(results);
            //If results = 1 player won
            if (results == 1) {
                PlayerWins.add(results);
                dealerWager = 0;
                playerBankAccount = playerRemainingBalance + num + numb;
              
            }
            //If results = -1 dealer AKA the house won
            if (results == -1) {
                DealerWins.add(results);
                playerWager = 0;
                dealerBankAccount = dealerRemainingBalance + num + numb;
            }
            //If results = 0 the game is a push
            if (results == 0) {
                TiedGames.add(results);
                playerWager = 0;
                dealerWager = 0;
                playerBankAccount = playerInitialAmount;
                dealerBankAccount = dealerInitialAmount;
            }

        }



        ///Use totalGames played to calculate percentages
        int totalGamesPlayed = PlayerWins.size() + DealerWins.size() + TiedGames.size(); 

        ///Calculates percentages
        int playerPercentages = 100*PlayerWins.size()/totalGamesPlayed;
        int dealerPercentages = 100*DealerWins.size()/totalGamesPlayed;
        int tiedPercentages = 100*TiedGames.size()/totalGamesPlayed;

    
        System.out.println("Player has won: " + PlayerWins.size() + " times! " + playerPercentages + " %" + " Balance: " + "$" + playerBankAccount);
        System.out.println("Dealer has won: " + DealerWins.size() + " times! " + dealerPercentages + " %" + " Balance: " + "$" + dealerBankAccount);
        System.out.println("Players have tied: " + TiedGames.size() + " times! " + tiedPercentages + " %" + " Player Balance: " + "$" + playerBankAccount + " Dealer Balance: " + "$" + dealerBankAccount);
        System.out.println("Total Games Played: " + totalGamesPlayed);
    }
    
}
