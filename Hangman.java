import java.util.Scanner;
public class Hangman
{
   private static String hangman = new String("peanuts");
   private static int guesses = 6;
   private static int counter = 0;
   private static String[] letters = new String[hangman.length()];
   private static String[] blanks = new String[hangman.length()];
   private static String word="";
      
   public static void main(String[] args)
   {  int index=0;   
      while (index<hangman.length())
      {
         blanks[index] = "_"; 
         letters[index] = hangman.substring(index, index+1);    
         index++;
      }  
         while (guesses > 0 && !hangman.equals(word))
      {
         word = "";
         printBlanks();
         String guess = getGuess();
         index = 0;
         if (hangman.contains(guess))
         {
            while (index<hangman.length())
            {
               if (guess.equals(letters[index]))
               {
                  blanks[index]=guess;
                  for (int n=0; n<blanks.length; n++)
                  {
                   word = word + blanks[n];
                  }
               }
               index++;
            }
         }
         else
         {
            guesses--;
         }
         counter++;
         System.out.println("You have "+ guesses +" guesses remaining"); 
         System.out.println(counter +" attempts");             
      }
      if (word.equals(hangman))
      {
         System.out.println("You win, you guessed the right word! The word was " + hangman + ".");
      }
      if (guesses==0)
      {
         System.out.println("You lose");
      }
}
   
   public static String getGuess()
   {
      Scanner scan = new Scanner(System.in);
      System.out.printf("\nGuess a letter: ");
      String letter = scan.next();
      System.out.println();
      return letter;
   }
   
   public static void printBlanks()
   {
      int index=0;
      while (index<hangman.length())
      {
         System.out.print(blanks[index] + " ");
         index++;
      }
   }
   
}