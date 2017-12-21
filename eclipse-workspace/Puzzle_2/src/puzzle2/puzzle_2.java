package puzzle2;

import java.util.Scanner;

public class puzzle_2
{
  static int[] inputArray;
  static int   sum = 0;
  
  //  Entry point
  
  public static void main(String[] args)
  {
    System.out.println("Puzzle 2");
    
    //  Get the input string
    
    String inputString = getInputString();

    //  Declare an empty input array
    
    inputArray = new int[inputString.length()];

    //  Generate the input array from the input string
    
    generateInputArray(inputString);
    
    //  Calculate the sum
    
    calculateSum();

    //  Display the sum
    
    System.out.println("Sum = " + sum);
  }
  
  //  Procedure to get the input string
  
  private static String getInputString()
  {
    //  Create a scanner
    
    Scanner scanner = new Scanner(System.in);
    
    //  Prompt for the input
    
    System.out.println("Enter input string...>");
    
    //  Convert the input to a string
    
    String inputString = scanner.nextLine();
    
    //  Close the scanner
    
    scanner.close();
    
    //  Return the input string
    
    return(inputString);
  }
  
  //  Procedure to convert the input string to an array of integers
  
  private static void generateInputArray(String inputString)
  {
    //  Loop through each value in the input array
    
    for(int i = 0 ; i < inputString.length() ; i++)
    {
      //  Convert the character to an integer
      
      inputArray[i] = Character.getNumericValue(inputString.charAt(i));
    }
  }
  
  //  Calculate the sum
  
  private static void calculateSum()
  {
    //  Loop through each value in the input array
    
    for(int i = 0, next_i = inputArray.length / 2 ; i < inputArray.length ; i++, next_i++)
    {
      //  Wrap the input if the next value reaches the end
      
      if(next_i == inputArray.length)  next_i = 0;
      
      //  If this value matches the next, add it to the sum
      
      if(inputArray[i] == inputArray[next_i])  { sum += inputArray[i]; }
    }
  }
}
