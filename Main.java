//create a rock paper scissors game
//The System must accept user input, as well as if he wants to continue the game
//The System must be random, being 1/3 chance of winning, loosing or drawing with the user
//The system must print the computer choice
//The system must tell if the user won,lost or drawed
//The system must quit if asked to do so.
import java.util.Scanner;
import java.util.Random;

public class Main {
   public static void main(String[] args) {
      //declaring our variables
      Scanner sc = new Scanner(System.in);
      Random random = new Random();
      char choice;
      int player;
      int computer;
      System.out.print("***************************************\n");
      System.out.print("Welcome to rock, paper, scissors!\n");
      System.out.println("***************************************");

      try{
         Thread.sleep(1000);
      } catch(InterruptedException e){
         System.out.print("ERROR; Program did not sleep" + e.getMessage());
      }
      System.out.println("Would you like to play? (Y/N)");
         String input = sc.next().trim().toUpperCase();
         choice = input.charAt(0);
      do{//a loop designed to keep the program running while player doesn't quit by typing 'N'
        if (choice == 'Y'){
           System.out.println("Pick an option:\n1) Rock\n2) Paper\n3) Scissors");
           player = sc.nextInt();
           switch (player) {//will display once player chooses 
            case 1:
               System.out.println("You chose: Rock\n");
               break;
            case 2:
               System.out.println("You chose: Paper\n");
               break;
            case 3:
               System.out.println("You chose: Scissors\n");
               break;
           }
           if (player >=1 && player <= 3){
              computer = random.nextInt(1, 4);
              switch (computer) {//will display what computer chose at random
               case 1:
                  System.out.println("Computer chose: Rock\n");
                  break;
               case 2:
                  System.out.println("Computer chose: Paper\n");
                  break;
               case 3:
                  System.out.println("Computer chose: Scissors\n");
                  break;
              }
              rockPaperScissors(player, computer);//method call
              System.out.println("Would you like to play again? (Y/N)");
              input = sc.next().trim().toUpperCase();
              choice = input.charAt(0);
            }else if (player < 1 || player > 3){//if player types a number that's invalid
               System.out.println("Please select a valid option");
               continue;
            }
        }else if(choice != 'N'){//if player types an invalid char
           System.out.println("Please select a valid option.");
           System.out.println("Would you like to play again? (Y/N)");
              input = sc.next().trim().toUpperCase();
              choice = input.charAt(0);}
         } while (choice != 'N');
       System.out.println("Thanks for running the program!");

      sc.close();
     }
   static void rockPaperScissors(int player, int computer){
      //using the following formula, we will get 3 diferent results, each of which we can identify as a victory, defeat or a tie.
      int result = (player - computer + 3) % 3;
      if (result == 0) {
        System.out.println("It's a Tie!");
      } else if (result == 1) {
        System.out.println("You Won!");
      } else {
        System.out.println("You Lost!");
       }
   }
}

