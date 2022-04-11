import java.util.ArrayList;

public class Hand {
    //Creates a hand list
    private ArrayList<Card> myHandList;
    public Hand() {
         myHandList = new ArrayList<Card>();
    }
    //Clears everything in the myhandList
    public void Reset() {
        myHandList.clear();
    }
    //Adds card to myhandlist
    public void add(Card card) {
        myHandList.add(card);
    }
    //Gets the amount of elements in myhandlist
    public int size() {
        return myHandList.size();
    }

    public Card getCard(int i) {
        Card ve = myHandList.get(i);
        return ve;
    }

    public int getTotalValue() {
        int sum = 0;
        for (int i = 0; i<myHandList.size(); i++) {
            Card card = myHandList.get(i);
            sum += card.getValue();

        }
        return sum;
    }

    public String toString() {
        String stHand = "this is what I have in my hand...";
        for (int i = 0; i<myHandList.size(); i++) {
            Card card = myHandList.get(i);
            stHand = stHand + card.getValue() + " ";

        }
        return stHand;
    }

    public static void main(String[] args) {

        Hand myHand = new Hand();
        Card myCard = new Card(5);
        myHand.add(myCard);
        String cardPlayed = "."+myHand.myHandList;
        System.out.println(cardPlayed);

        //String whatCardIGot = "This is what card I got... " + myHand.getCard(myCard.getValue());
        //System.out.println(whatCardIGot);
        //String totalSumOfCards = "This is what my cards amount to be when added up... " + myHand.getTotalValue();
        //System.out.println(totalSumOfCards);
        //System.out.println(myHand.toString());
        

    }


    
}
