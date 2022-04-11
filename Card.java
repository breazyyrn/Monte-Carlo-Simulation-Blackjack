public class Card {
    //Creates Private Field
    private int v;
    public Card(int v) {
        ///Value = v
        this.v  = v;
        if (v < 1 || v > 11) {
            System.out.println("Your card value is out of range");
        } 
    }

    public int getValue() {
        return this.v;
    }

    public String toString() {
        String stValue = "Value: ";
        stValue = stValue + this.getValue();
        return stValue;
    }



   

   public static void main(String[] args) {
        Card newC = new Card(5);
       System.out.println(newC.toString());
   }
    
}
