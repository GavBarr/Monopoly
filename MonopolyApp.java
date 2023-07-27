import java.util.Arrays;

public class MonopolyApp extends Player 
{
    public static int turns;   
    public static boolean diceDoubles;
    public static int[][] dataSet; //I am setting this to be a two dimensional array, becuase I need to have a count column and percentage column for the amount of times the space is landed on
    public static int numOfTurns=10000;
    public static boolean chanceCondition;
    public static boolean discardCardCondition;
    public static boolean goToJailCondition;
    public static boolean jailCondition;
    public static boolean useGetOutOfJail;
    public static int cardToDiscardIndex;
    public static String cardToDiscard;
    public static String currentCardName;
    public static boolean getOutOfJailCard;
   
    
   
    

    
    
    /**
     * Main method to pefrom the simulation of n amount of turns for the game monopoly
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception 
    {
        
        int previousFirstDice;
        int previousSecondDice;
        int currentFirstDice;
        int currentSecondDice;
        boolean jailCondition = false;//defaulted value should be assumed to be false until otherwise changed by the checkGoToJailSpace method
        String tempHandArrayCardName = "";
        String cardToDiscard="";
        
        

       
       
        

        dataSet = new int[2][GameBoard.totalSpaces];//setting the initial size parameters for the array associated with the data like % of times landed on a space 
        GameBoard.generateGameBoard();//calling out to the GameBoard class and generateGameBoard Method, to construct the "gameboard"
        ChanceCardPile.createChanceCardsPile();//calling out to the ChanceCardPule and createChanceCardsPile to construct the "chance card pile" arraylist
        
        
        dataSet[0][0]=1; //We must set the index 0, which is the "Go" space. Because that is where the player begins

        System.out.println("Welcome to the Monopoly Game");
        System.out.println("In 5 seconds the simulation will begin");
        
       //DO NOT DELETE THIS LINE OF CODE runThroughGame(numOfTurns);
  
       
        for(int i = 1; i<numOfTurns; i++)
        {
            //int tempId = 0;//"resetting" the tempId to make sure the data doesn't get skewed after each iteration

            previousFirstDice=Dice.firstDiceNumber;
            previousSecondDice=Dice.secondDiceNumber;
            Player.useDice();
            System.out.println("Dice Number Rolled: " + Player.diceNumberRolled + " The Two Dice Numbers adding to get it " + Dice.firstDiceNumber + " " + Dice.secondDiceNumber);
            currentFirstDice=Dice.firstDiceNumber;
            currentSecondDice=Dice.secondDiceNumber;
            //checkDiceDoubles(currentFirstDice,currentSecondDice, previousFirstDice, previousSecondDice,currentCardName);


            Player.move(); 
            chanceCondition = false;  
            checkChanceCardSpace(currentSpace); //calling this method to check and see which space the player is on, and if they land on a chance space then the following if statement will be triggered

            if(ChanceCardPile.chanceCards.size()==0)//stating if the chanceCards array become empty, then we want to create a "new" card pile and clearing everything inside of the discardPile array
            {
                ChanceCardPile.createChanceCardsPile();
                //ChanceCardPile.discardCards.clear();
            }

            currentCardName="";
            if(chanceCondition == true)//if the player lands on the chance space then 
            {

                
                currentCardName= ChanceCardPile.drawChanceCard();
                System.out.println("TESTING: " + currentCardName);
                tempHandArrayCardName = currentCardName; // a temp variable that will chance each iteration that this if statement gets triggered
                ChanceCardPile.createCurrentCardsPile(tempHandArrayCardName);
                //System.out.println( "THIS IS THE CURRENT CARDS ARRAY: " + ChanceCardPile.currentCards.size());
                ChanceCardPile.chanceCards.remove(0);
                //System.out.println("THIS IS THE ARRY SIZE FOR CHANCE CARDS: " + ChanceCardPile.chanceCards.size());

                //System.out.println("You Picked This Card " + currentCardName);
                
                tempHandArrayCardName="";//clearing the tempCardName for the currentCardArrayPile
            }

            goToJailCondition=false;
            checkGoToJailCards(currentCardName);
            if(goToJailCondition == true)
            {
                

                
                 goToJail(currentCardName);

                     //System.out.println(currentCardName);
                     if(ChanceCardPile.chanceCards.size()!=0 && ChanceCardPile.currentCards.contains(currentCardName) == true)
                     {
                        cardToDiscardIndex = ChanceCardPile.currentCards.indexOf("Go to Jail");           
                        cardToDiscard = ChanceCardPile.currentCards.get(cardToDiscardIndex);
                        ChanceCardPile.createDiscardPile(cardToDiscard);
                        //System.out.println("Index Number: " + cardToDiscardIndex);
                        ChanceCardPile.currentCards.remove(cardToDiscardIndex);
                    
                    
                    }
                    else if(ChanceCardPile.chanceCards.size()!=0 && ChanceCardPile.currentCards.contains(currentCardName) == true)
                    {
                        cardToDiscardIndex = ChanceCardPile.currentCards.indexOf("Get Out of Jail Free ");           
                        cardToDiscard = ChanceCardPile.currentCards.get(cardToDiscardIndex);
                        ChanceCardPile.createDiscardPile(cardToDiscard);
                        //System.out.println("Index Number: " + cardToDiscardIndex);
                        ChanceCardPile.currentCards.remove(cardToDiscardIndex);
                    }


                               
            }

           
           

                
                        

 
            
            if (currentSpace==30)//if the jailCondition that is returned from the above method is true, then the player is sent back to jail
            {
                dataSet[0][30] =dataSet[0][30]+1;
                goToJail(currentCardName);
            }
            if(currentSpace>=40) //resetting the currentSpace everytime that Go is passed, so that the dimmed array for the gameBoard is valid and can track accurately
            {
                currentSpace = currentSpace-40;
            
            }  
            
            currentCardName="";
   
            System.out.println(GameBoard.gameBoardArray[currentSpace]);//Debug line to check for the dice and movement system
            System.out.println("CURRENT SPACE:" + currentSpace);
            int tempId = currentSpace;//setting the currentSpace to tempId, which is used as an identifier for the amount of times a space is landed o
            dataSet[0][tempId] += 1;//using the dataSet array to increment everytime a space is hit according to the index/currentSpac
 
 
         for(int j = 0; j<40; j++)
        {
     
            dataSet[1][j] = dataSet[0][j] * 100 / numOfTurns;
 
         }

         

         
        
  
 
     }
   

        for(int i = 0; i<40; i++)
        {
            
            dataSet[1][i] = dataSet[0][i] * 100 / numOfTurns;
        }


        //Displaying the data in the table format

        System.out.printf("%-10s \n","n= " + numOfTurns );
        
        for(int i=0; i<40; i++)
        {
            System.out.printf("%-30s %-10s %-10s\n",GameBoard.gameBoardArray[i] + "",dataSet[1][i] + "% ",dataSet[0][i] + " Times Landed");
            
        }
 
    }




   
   public static void checkDiceDoubles(int currentFirstDiceNumber,int currentSecondDiceNumber, int prevFirstDiceNumber, int prevSecondDiceNumber, String currentCardName)
   {
       if(prevFirstDiceNumber == prevSecondDiceNumber && currentFirstDiceNumber == currentSecondDiceNumber)
       {
           goToJail(currentCardName);
       }       
   }

   public static void goToJail(String currentCardName)
   {
       //System.out.println(currentCardName); //DEBUG      

      // discardCardCondition = ChanceCardPile.currentCards.contains(currentCardName);
       

       if(getOutOfJailCard !=true)
       {

           System.out.println("YOU ARE IN JAIL");
           currentSpace=10;
           Player.useDice();
           while(Dice.firstDiceNumber!=Dice.secondDiceNumber)
           {
               Player.useDice();
               System.out.println("Still In Jail!");
               System.out.println("Fist Dice Number: " + Dice.firstDiceNumber + "Second Dice Number: " + Dice.secondDiceNumber);
           }
          
           Player.diceNumberRolled = 0; //resetting the dice number, because the player does not move straight out of jail. They are put into the same space, and must wait until the next turn to roll the dice again
       }
       
      
       
   }

   


    public static boolean checkChanceCardSpace(int currentSpace)
    {
        //always assuming that the player is not on the chance space, until proven otherwise
        if(currentSpace==7 || currentSpace==22 || currentSpace==36)
        {
            chanceCondition = true;
            
        }

        return chanceCondition;
        
  
    }

    public static boolean checkGoToJailCards(String currentCardName)
    {
       
        //this all works great, do not alter please
        String name = currentCardName;          
         if(name == "Go to Jail")
           {
           // System.out.println("CHECK GO TO JAILS CARDS IN JAIL");
               currentSpace=10;
               goToJailCondition=true;
 
           }

           return goToJailCondition;
          


    }

    public static boolean checkGetOutJailCards(String currentCardName)
    {

        String name = currentCardName;          
         if(name == "Get Out of Jail Free")
           {
           // System.out.println("CHECK GO TO JAILS CARDS IN JAIL");
               currentSpace=10;
               getOutOfJailCard=true;
 
           }


        return getOutOfJailCard;
    }



    

// else if(ChanceCardPile.currentCards.contains(currentCardName))
          // {
          //  useGetOutOfJail = true;
          // }
    
}
