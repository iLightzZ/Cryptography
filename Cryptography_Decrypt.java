//Exercise 4.39 V2: Pg 214-215 (Java 11th Edition)
//Enforcing Privacy with Cryptography
import java.util.Scanner;

public class Cryptography_Decrypt
{
  public static void main(String[] args)
  {
    //create a Scanner object to access its methods
    Scanner input = new Scanner(System.in);
    
    System.out.printf("%s%n%n%s%s%s%n%n", 
    "\t\t\t\t   ~Enforcing Privacy with Cryptography (Decryption)~",
    "The explosive growth of Internet communications and data storage on Internet-connected computers has greatly increased privacy concerns.", 
    "The field of cryptography is concerned with coding data to make it difficult (and hopefully—with the most ",
    "advanced schemes—impossible) for unauthorized users to read.");
    
    System.out.println("The following program will decrypt an encrypted data to form its original number.\n");
    
    //Initialization phase (1)
    
    int data; //four-digit number for the user to enter
    int dataDup; //data duplicate to aid in counting the integers
    int digitCount = 0;
    
    System.out.print("Enter your encrypted four-digit integer: ");
    data = input.nextInt();
    dataDup = data;
    
    while(dataDup != 0) //counting the number of digits
    {
      dataDup /= 10;
      ++digitCount;
    }
    
    while(digitCount != 4) //Error-trapping the user's input
    {
      System.out.print("Data is not a four-digit integer. Please try again: ");
      data = input.nextInt();
      dataDup = data;
      
      digitCount = 0; //re-initializing digitCount
      while(dataDup != 0) //counting the number of digits
      {
        dataDup /= 10;
        ++digitCount;
      }
    }//end error-trapping
    
    
    //----> Encryption process <---- (processing phase (2))
    
    int[] encryptedData = new int[4]; //array to store the digits seperately (data)
    int divisor = 1000; //variable to aid seperate the digits
    for(int counter = 0; counter < encryptedData.length; ++counter)
    {
      //replacing each digit by adding 10, subtracting a 7 and getting the remainder after dividing by 10
      encryptedData[counter] = ((((data / divisor) + 10) - 7) % 10);
      divisor /= 10; 
    }
    
    //Swapping the third digit with the first and the fourth digit with the second
    int hold = encryptedData[2];
    encryptedData[2] = encryptedData[0];
    encryptedData[0] = hold;
    
    hold = encryptedData[3];
    encryptedData[3] = encryptedData[1];
    encryptedData[1] = hold;
    
    System.out.print("Decrypted Data: "); //Displaying the results (termination phase (3))
    for(int i = 0; i < encryptedData.length; ++i)
    {
      System.out.print(encryptedData[i]);
    }
    System.out.println();
  }//end main
}//end class Cryptography
