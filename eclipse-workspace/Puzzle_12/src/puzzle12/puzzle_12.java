package puzzle12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class puzzle_12
{
  static ArrayList<Integer>       mInputList         = new ArrayList<Integer>();
  static ArrayList<Configuration> mConfigurationList = new ArrayList<Configuration>();
  
  //  Entry point
  
  public static void main(String[] args)
  {
    System.out.println("Puzzle 11");
    
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
        //  Tokenise the string
        
        StringTokenizer st1 = new StringTokenizer(line);

        //  Loop through each token
        
        while(st1.hasMoreTokens())
        {
          //  Convert the token to a string
          
          String thisToken = st1.nextToken();
 
          //  Convert the string to an integer
          
          Integer thisInteger = Integer.parseInt(thisToken);

          //  Add the integer to the list
            
          mInputList.add(thisInteger);
        }
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
    int repeatCycleNumber = -1;
    
    //  Create the memory manager
    
    MemoryManager memoryManager = new MemoryManager(16);
    
    //  Initialise the memory manager with the input
    
    memoryManager.Initialise(mInputList);
    
    //  Display the memory banks
    
    System.out.print("Initial Configuration : ");
    
    memoryManager.Display();
    
    //  Add the initial configuration to the configuration list
    
    mConfigurationList.add(memoryManager.getConfiguration());

    //  Loop until a configuration is found that already exists
    
    for(int i = 1 ; ; i++)
    {
      //  Iterate the memory manager
      
      memoryManager.Iterate();    
      
      //  Get the current configuration
      
      Configuration thisConfiguration = memoryManager.getConfiguration();
      
      //  Check whether this configuration has already been seen
      
      if(mConfigurationList.contains(thisConfiguration))
      {
        System.out.println("Configuration repeated in cycle " + i);
        
        //  Check whether this is the first repetition
        
        if(repeatCycleNumber == -1)
        {
          //  Store the cycle number of the repetition
          
          repeatCycleNumber = i;
          
          //  Clear the configuration list
          
          mConfigurationList.clear();
    
          //  Add the initial configuration to the configuration list
          
          mConfigurationList.add(thisConfiguration);
        }
        else
        {
          System.out.println("Loop size = " + (i - repeatCycleNumber));
          
          return;
        }
      }
      else
      {
        //  Add the configuration to the configuration list
          
        mConfigurationList.add(thisConfiguration);
      }
    }
  }
}
