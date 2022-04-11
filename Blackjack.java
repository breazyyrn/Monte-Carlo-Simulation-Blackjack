

public class Blackjack {
    Deck gameDeck;
    Hand playerHand;
    Hand DealerHand;
    int reshuffleNum;
    

    public Blackjack (int reshuffleNum) {
        //iNITIALIZES NEW DECK, PLAYERHAND,DEALERHAND 
        gameDeck = new Deck();
        playerHand = new Hand();
        DealerHand = new Hand();
        this.reshuffleNum = reshuffleNum;
        //SHUFFLES ONCE THE DECK IS REMAINING WITH A CERTAIN AMOUNT OF CARDS
        if (gameDeck.size() < reshuffleNum) {
            gameDeck.shuffle();
        }

    }
    //RESETS PLAYER HAND, DEALER HAND AND GAME DECK
    public void reset() {
        playerHand.Reset();
        DealerHand.Reset();
        gameDeck.shuffle();
    }
    //dEALS CARDS FROM GAME DECK TO PLAYER HAND AND DEALER HAND 
    public void deal() {
        for (int i = 0; i<2; i++) {
            Card playerCard = gameDeck.deal();
            Card DealerCard = gameDeck.deal();
            playerHand.add(playerCard);
            DealerHand.add(DealerCard);
        }
    }
    //FALSE IF TOTAL VALUE OF PLAYER CARDS IS GREATER THAN 21, TRUE IF NOT
    public boolean playerTurn() {
        boolean bust = true;
        for (int i = 0; i < gameDeck.size(); i++) {
            Card playerCard = gameDeck.deal();
            if (playerHand.getTotalValue() < 16){
                playerHand.add(playerCard);
            } if (playerHand.getTotalValue() > 21) {
                bust = false;
                
            }
        }
        return bust;                          
    }

    //FALSE IF TOTAL VALUE OF DEALER CARDS IS GREATER THAN 21, TRUE IF NOT
    public boolean dealerTurn() {
        boolean bust = true;
        for (int i = 0; i < gameDeck.size(); i++) {
            Card dealerCard = gameDeck.deal();
            if (DealerHand.getTotalValue() < 17) {
                DealerHand.add(dealerCard);
            } if (DealerHand.getTotalValue() > 21) {
                bust = false;
            }
        }
        return bust;
    }
    //ONCE THIS AMOUNT OF CARDS IS LEFT ON DECK, DECK WILL RESHUFFLE
    public void setReshuffleCutoff(int cutoff) {
        this.reshuffleNum = cutoff;
    }
    
    public int getReshuffleCutoff() {
        return this.reshuffleNum;
    }

    public String toString() {
        String playerTalk = "player: ";
        String dealerTalk = "dealer: ";
        String conversation;
        playerTalk = playerTalk + playerHand.toString() + " Your total value is: " + playerHand.getTotalValue();
        dealerTalk = dealerTalk + DealerHand.toString() + " Your total value is: " + DealerHand.getTotalValue();
        conversation = playerTalk + "\n" + dealerTalk;
        return conversation;
       
    }

    public static void main(String[] args) {
        Blackjack gameTest = new Blackjack(36);
        for (int i = 0; i<3; i++) {
            gameTest.game(true);}
        }


    public int game(boolean verbose) {
        int winnerScore = 0;
        if (verbose == true) {
        //Blackjack officialGame = new Blackjack(36);
        reset();
        deal();



        System.out.println("                       Deck ----> Players                      ");
        System.out.println("                       Initial Hand                      ");
        System.out.println(toString());
        System.out.println("\n");


        playerTurn();
        dealerTurn();

        System.out.println("                       Deck ----> Players                      ");
        System.out.println("                         Final Hand                      ");
        System.out.println(toString()); 


        if (playerHand.getTotalValue() > 21 && DealerHand.getTotalValue()<=21) {
           winnerScore = -1; 
           System.out.println("                   The House Always Wins!!!                    ");
           //System.out.println(winnerScore);
        }

        else if (DealerHand.getTotalValue() >21 && playerHand.getTotalValue()<=21) {
            winnerScore = 1;
            System.out.println("                      Player Won!!!                      ");
           // System.out.println(winnerScore);
        }

        else if (playerHand.getTotalValue() == DealerHand.getTotalValue()) {
            winnerScore = 0;
            System.out.println("                         It's a Tie!!!                     ");
            //System.out.println(winnerScore);
        }

        else if (playerHand.getTotalValue() <=21 && DealerHand.getTotalValue()<=21 ) {
            winnerScore = 0;
            System.out.println("                         It's a Tie!!!                     ");
            //System.out.println(winnerScore);
        }

        else if (playerHand.getTotalValue()>=21 && DealerHand.getTotalValue()>=21) {
            winnerScore = 0;
            System.out.println("                         It's a Tie                     ");
            //System.out.println(winnerScore);
        }

        }

        return winnerScore;
        



        

    }
}
