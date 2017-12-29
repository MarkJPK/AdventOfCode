package puzzle8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class puzzle_8
{
  static int[] inputArray;
  static int   sum = 0;
	  
  //  Entry point
  
  public static void main(String[] args)
  {
    System.out.println("Puzzle 8");
    
    // The name of the file to open.

    String fileName = "input.txt";

    // This will reference one line at a time

    String line = null;

    try
    {
      int lineNumber = 1;
      
      //  FileReader reads text files in the default encoding
      
      FileReader fileReader = new FileReader(fileName);
      
      //  Wrap FileReader in BufferedReader
      
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      
      //  Read each line until the file is complete
      
      while((line = bufferedReader.readLine()) != null)
      {
        //  Instantiate a row with this line
        
        Row row = new Row(lineNumber++, line);
        
        //  Add the result to the sum
        
        sum += row.getResult();
      }

      System.out.println("Sum = " + sum);
      
      //  Close the file
      
      bufferedReader.close();         
    }
    catch(FileNotFoundException ex) 
    {
      System.out.println("Unable to open file '" + fileName + "'");                
    }
    catch(IOException ex)
    {
      System.out.println("Error reading file '" + fileName + "'");                  
    }
  }
}
