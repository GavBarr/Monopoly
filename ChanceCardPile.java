import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChanceCardPile
{
     
    public static String cardName;
    public static ArrayList<String> chanceCards = new ArrayList<String>();
    public static ArrayList<String> currentCards = new ArrayList<String>();
    public static ArrayList<String> discardCards = new ArrayList<String>();
    

    public static void createChanceCardsPile()
    {
       

            chanceCards.add("Advance to Boardwalk");
            chanceCards.add("Advance to Go (Collect $200)");
            chanceCards.add("Advance to Illinois Avenue. If you pass Go, collect $200");
            chanceCards.add("Advance to St. Charles Place. If you pass Go, collect $200");
            chanceCards.add("Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay wonder twice the rental to which they are otherwise entitled");
            chanceCards.add("Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay wonder twice the rental to which they are otherwise entitled");
            chanceCards.add("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown.");
            chanceCards.add("Bank pays you dividend of $50");
            chanceCards.add("Get Out of Jail Free");
            chanceCards.add("Go Back 3 Spaces");
            chanceCards.add("Go to Jail");
            chanceCards.add("Make general repairs on all your property. For each house pay $25. For each hotel pay $100");
            chanceCards.add("Speeding fine $15");
            chanceCards.add("Take a trip to Reading Railroad. If you pass Go, collect $200");
            chanceCards.add("You have been elected Chairman of the Board. Pay each player $50");
            chanceCards.add("Your building loan matures. Collect $150");

            
    }

    public static String drawChanceCard()
    {
  
        Collections.shuffle(chanceCards); //shuffling the deck everytime this method is being called     
        cardName = chanceCards.get(0); //setting the cardName to whateber is on the top of the arraylist stack or top of the deck pile
        return cardName;
   
    }

    public static void createCurrentCardsPile(String cardHandName)
    {
        
        currentCards.add(cardHandName);

    }

    public static void createDiscardPile(String cardHandName) //STILL NEED TO WORK ON THIS DONT FORGET
    {
        
        discardCards.add(cardHandName);

    }




    
    
}
