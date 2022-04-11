import java.util.ArrayList;
import java.util.Random;
public class Deck {
    ///Creates array list to hold deck
    private ArrayList<Card> myDeck;
    public Deck() {
        myDeck = new ArrayList<Card>();
        this.build();
        this.shuffle();
    }

    public void build() {
        //builds a deck of 52 cards, 4 each of cards with values 2-9 and 11, and 16 cards with the value 10.
        for (int i=0; i<4;i++) {
            int cardValue = 2;
            for (int g=0; g<9; g++) {
                if (cardValue == 11) {
                    cardValue+=1;}

                Card card = new Card(cardValue);
                myDeck.add(card);
                cardValue+=1;
            }
        }
        //Builds 16 cards of value 10
        while(myDeck.size() !=52) {
            Card card = new Card(10);
            myDeck.add(card);
        }


    }

    public int size() {
        //Returns list size
        return myDeck.size();
    }

    public Card deal() {
        //deals card from mydeck
        Card recentCard = myDeck.get(0);
        myDeck.remove(recentCard);
        return recentCard;
    }

    public Card pick(int i) {
        //Picks card from my deck depending on index
        Card removeCardFromDeck = myDeck.get(i);
        myDeck.remove(removeCardFromDeck);
        return removeCardFromDeck;
    }

    public void shuffle() {
        //Shuffles deck
        ArrayList<Card> newDeck;
        Random newRandomVariable = new Random();
        newDeck = new ArrayList<Card>();
        myDeck.clear();
        this.build();

        while (myDeck.size() != 0) {
            int val = newRandomVariable.nextInt(myDeck.size());
            Card pickedCard = myDeck.get(val);
            myDeck.remove(pickedCard);
            newDeck.add(pickedCard);
        }

        myDeck = newDeck;




        // for (int i = 0; i<myDeck.size(); i++) {
        //     myDeck.clear();
        //     Deck newDeckOfCards = new Deck();
        //     newDeckOfCards.build();


        // }
        
    }

    public static void main(String[] args) {
        Deck newDeck = new Deck();
        //newDeck.build();
        System.out.println("Deck: " + newDeck.myDeck);
        System.out.println("There are: " + newDeck.myDeck.size() + " Cards in the deck");
        Hand playerHand = new Hand();
        Card c = newDeck.deal();
        playerHand.add(c);
        System.out.println(c.getValue());
        System.out.println(playerHand.getTotalValue());
        

    }


    
}
