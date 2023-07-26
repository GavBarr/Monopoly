public class Player 
{
    public static int currentSpace;
    public static int totalMoves;
    public static int diceNumberRolled;


    public static void move()
    {
        currentSpace=currentSpace+diceNumberRolled;
        totalMoves++;       

    }

    public static int useDice()
    {   
        diceNumberRolled = Dice.rollDiceOne() + Dice.rollDiceTwo();
        return diceNumberRolled;  
      
    }
}