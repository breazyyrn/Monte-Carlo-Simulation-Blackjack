import java.util.ArrayList;
/**
 * Simulation.java
 * Blackjack Game
 * Bryan Thiam
 * CS231 S22
 * Lab C & D
 */
public class Simulation {
    public static void main(String[] args) {

        /**Everytime player wins add 1 integer to the list 
         * Once the game is done running calculate the lists' size which calculates
         * How many games the player won.
         */ 
        ArrayList<Integer> PlayerWins = new ArrayList<Integer>();
        ArrayList<Integer> DealerWins = new ArrayList<Integer>();
        ArrayList<Integer> TiedGames = new ArrayList<Integer>();

        for (int i = 0; i<1000; i++) {
            //Game starts
            Blackjack gameBlackjack = new Blackjack(36);
            int results = gameBlackjack.game(true);
            System.out.println(results);
            //If results = 1 player won
            if (results == 1) {
                PlayerWins.add(results);
            }
            //If results = -1 dealer AKA the house won
            if (results == -1) {
                DealerWins.add(results);
            }
            //If results = 0 the game is a push
            if (results == 0) {
                TiedGames.add(results);
            }

        }



        ///Use totalGames played to calculate percentages
        int totalGamesPlayed = PlayerWins.size() + DealerWins.size() + TiedGames.size(); 

        ///Calculates percentages
        int playerPercentages = 100*PlayerWins.size()/totalGamesPlayed;
        int dealerPercentages = 100*DealerWins.size()/totalGamesPlayed;
        int tiedPercentages = 100*TiedGames.size()/totalGamesPlayed;

    
        System.out.println("Player has won: " + PlayerWins.size() + " times! " + playerPercentages + " %");
        System.out.println("Dealer has won: " + DealerWins.size() + " times! " + dealerPercentages + " %");
        System.out.println("Players have tied: " + TiedGames.size() + " times! " + tiedPercentages + " %");
        System.out.println("Total Games Played: " + totalGamesPlayed);
    }
    
}
