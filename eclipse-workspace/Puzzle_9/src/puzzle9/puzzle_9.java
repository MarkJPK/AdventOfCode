package puzzle9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class puzzle_9
{
  static int                mSum        = 0;
  static ArrayList<Integer> mInputList  = new ArrayList<Integer>();
  
  //  Entry point
  
  public static void main(String[] args)
  {
    System.out.println("Puzzle 9");
    
    // The name of the file to open.

    String fileName = "input.txt";

    // This will reference one line at a time

    String line = null;

    try
    {
      //  FileReader reads text files in the default encoding
      
      FileReader fileReader = new FileReader(fileName);
      
      //  Wrap FileReader in BufferedReader
      
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      
      //  Read each line until the file is complete
      
      while((line = bufferedReader.readLine()) != null)
      {
        //  Convert the line to an integer
        
        Integer thisInteger = Integer.parseInt(line);

        //  Add the integer to the list
          
        mInputList.add(thisInteger);
      }
      
      //  Close the file
      
      bufferedReader.close();
      
      //  Process the input list
      
      processInputList();
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
  
  //  Procedure to process the input list
  
  private static void processInputList()
  {
    int length       = mInputList.size();
    int currentIndex = 0;
    int steps        = 0;
    
    while(true)
    {
      //  Get the value at the current index
      
      int currentValue = mInputList.get(currentIndex);

      //  Increment the current value
      
      mInputList.set(currentIndex, currentValue + 1);
      
      //  Increment the current index by the current value
      
      currentIndex += currentValue;
      
      //  Increment the number of steps
      
      steps++;
      
      //  Check whether the current index his greater than the maximum
      
      if(currentIndex >= length)
      {
        //  Exit is reached
        
        System.out.println("Exit reached in " + steps + " steps");
        
        return;
      }
    }
  }
}
