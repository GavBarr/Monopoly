import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Dice 
{
    public static int firstDiceNumber;// declaring the diceNumber variable as an int
    public static int secondDiceNumber;// declaring the diceNumber variable as an int
    
    /**
     * This method is to generate the random number from "rolling" the dice
     * @return diceNumber
     */
    public static int rollDiceOne()
    {
        firstDiceNumber = ThreadLocalRandom.current().nextInt(1,7); //setting the dice number to a random value each time it is called with the range from 1 to 6
        return firstDiceNumber;// returning the new random diceNumber rolled
    }

     public static int rollDiceTwo()
    {
        secondDiceNumber = ThreadLocalRandom.current().nextInt(1,7); //setting the dice number to a random value each time it is called with the range from 1 to 6
        return secondDiceNumber;// returning the new random diceNumber rolled
    }
}
