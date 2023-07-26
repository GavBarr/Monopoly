import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameBoard 
{
    public static int totalSpaces = 40;
    public static String name;
    public static int spaceNumber;
    public static String[] gameBoardArray;
    


    /** This is the GameBoard object that stores all of the spaces and the titles associated with them
     * 
     * return ????
     * @throws FileNotFoundException
     */ 
    public static void generateGameBoard() throws FileNotFoundException 
    {
        Scanner sc = new Scanner(new File("C:/Users/Admin/Documents/CSIS 2430 Projects/Monopoly/lib/Space Names.csv")); //Importint the CSV file with the apporpiate space names for each square on the board

        sc.useDelimiter(",");//Setting a comma as the delimiter for the data being read in the csv file
        gameBoardArray=new String[totalSpaces];//Setting the gameBoardArray with 40 spaces in the array

        while(sc.hasNext())//A while loop, for until there are no longer data in the csv file
        {

        
            for(int i=0; i<totalSpaces; i++)//using a for loop to load the space names into the appropriate indexes
            {
                gameBoardArray[i]= new String(sc.next());//after every iteration, the data from the csv file will be upload to the array here according the index

            }

        }
         
        sc.close();//closing out of the scanner for the csv file
        
        
    }


    //public static int[][] runThroughGame(int numOfTurns)
   //{
   //    //int previousPreviousDice; //still need to implement the three roll dice for goToJail
   //     int previousFirstDice;
   //     int previousSecondDice;
   //     int currentFirstDice;
   //     int currentSecondDice;
   //     boolean jailCondition = false;//defaulted value should be assumed to be false until otherwise changed by the checkGoToJailSpace method
   //    //boolean chanceCondition= false;
   //     String currentCardName="";
   //     
   //     
   //   
   //    
   //    for(int i = 1; i<numOfTurns; i++)
   //    {
   //        //int tempId = 0;//"resetting" the tempId to make sure the data doesn't get skewed after each iteration
   //       
   //        previousFirstDice=Dice.firstDiceNumber;
   //        previousSecondDice=Dice.secondDiceNumber;
   //        Player.useDice();
   //        System.out.println("Dice Number Rolled: " + Player.diceNumberRolled + " The Two Dice Numbers adding to get it " + Dice.firstDiceNumber + " " + Dice.secondDiceNumber);
   //        currentFirstDice=Dice.firstDiceNumber;
   //        currentSecondDice=Dice.secondDiceNumber;
   //        checkDiceDoubles(currentFirstDice,currentSecondDice, previousFirstDice, previousSecondDice);
   //       
   //       
   //        Player.move();
//
   //        //DEBUG PLEASE DONT FORGET TO DO THIS           
   //        //checkChanceCardSpace(currentSpace);
   //        //if(chanceCondition == true)
   //        //{
   //          //  ChanceCardPile.drawChanceCard();
   //          //  currentCardName=ChanceCardPile.cardName;
   //        //}
   //        //System.out.println(currentCardName);
   //        checkJailCards(currentCardName);
   //     
   //        
   //        checkGoToJailSpace(currentSpace);
   //        if (jailCondition==true)//if the jailCondition that is returned from the above method is true, then the player is sent back to jail
   //        {
   //            goToJail();
   //        }
   //
   //        if(currentSpace>=40) //resetting the currentSpace everytime that Go is passed, so that the dimmed array for the gameBoard is valid and can track accurately
   //        {
   //            currentSpace = currentSpace-40;
   //           
   //        }   
   //      
   //        System.out.println(GameBoard.gameBoardArray[currentSpace]);//Debug line to check for the dice and movement system
   //        System.out.println("CURRENT SPACE:" + currentSpace);
   //        int tempId = currentSpace;//setting the currentSpace to tempId, which is used as an identifier for the amount of times a space is landed o
   //        dataSet[0][tempId] += 1;//using the dataSet array to increment everytime a space is hit according to the index/currentSpac
   //    
   //    
   //     for(int j = 0; j<40; j++)
   //      {
   //        
   //        dataSet[1][j] = dataSet[0][j] * 100 / numOfTurns;
   //    
   //     }
   //     
   //    
   //     }
   //      return dataSet;//this will be returning the required values for the datasets
   // }
//
   
    
    
    
//if(goToJailCondition == true && ChanceCardPile.chanceCards.size()!=0)
//{
//
//    cardToDiscardIndex = ChanceCardPile.currentCards.indexOf("Go to Jail");
//
//    cardToDiscard = ChanceCardPile.currentCards.get(cardToDiscardIndex);
//    ChanceCardPile.createDiscardPile(cardToDiscard);
//    System.out.println("Index Number: " + cardToDiscardIndex);
//    ChanceCardPile.currentCards.remove(cardToDiscardIndex);
// 
//
//    
//    goToJailCondition = false; //resetting this condition after its use
//    
//}
// else if(useGetOutOfJail == true  && ChanceCardPile.chanceCards.size()!=0)
// {
//
//     cardToDiscardIndex = ChanceCardPile.currentCards.indexOf("Get Out of Jail Free");               
//     cardToDiscard = ChanceCardPile.currentCards.get(cardToDiscardIndex);
//     ChanceCardPile.createDiscardPile(cardToDiscard);
//     System.out.println("Index Number: " + cardToDiscardIndex);
//     ChanceCardPile.currentCards.remove(cardToDiscardIndex);
//  
//
//     
//     useGetOutOfJail = false;
//     
// }
}
