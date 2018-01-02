package puzzle12;

import java.util.ArrayList;

public class MemoryManager
{
  ArrayList<MemoryBank> mMemoryBanks  = new ArrayList<MemoryBank>();
  
  //  Constructor
  
  MemoryManager(int numberOfMemoryBanks)
  {
    for(int i = 0 ; i < numberOfMemoryBanks ; i++)
    {
      mMemoryBanks.add(new MemoryBank());
    }
  }
  
  //  Procedure to initialise the memory banks
  
  public void Initialise(ArrayList<Integer> inputList)
  {
    //  Check that the input list is of the correct size
    
    if(inputList.size() != mMemoryBanks.size()) return;
    
    //  Loop through each memory bank
    
    for(int i = 0 ; i < mMemoryBanks.size() ; i++)
    {
      //  Set the initial number of blocks for this memory bank
      
      (mMemoryBanks.get(i)).setNumberOfBlocks(inputList.get(i));
    }
  }
  
  //  Procedure to display the memory banks
  
  public void Display()
  {
    //  Loop through each memory bank
    
    for(int i = 0 ; i < mMemoryBanks.size() ; i++)
    {
      if(i != 0)  System.out.print(", ");
      
      System.out.print((mMemoryBanks.get(i)).getNumberOfBlocks());
    }
    
    System.out.println("");
  }
  
  //  Procedure to iterate the memory manager
  
  public void Iterate()
  {
    //  Get the index of the fullest memory bank
    
    int fullestMemoryBankIndex = getIndexOfFullestMemoryBank();
    
    //  Get the number of blocks in the memory bank at this index
    
    int numberOfBlocksToRedistribute = (mMemoryBanks.get(fullestMemoryBankIndex)).getNumberOfBlocks();
    
    //  Clear the memory bank at this index
    
    (mMemoryBanks.get(fullestMemoryBankIndex)).setNumberOfBlocks(0);

    //  Get the next index
    
    int nextIndex = getNextIndex(fullestMemoryBankIndex);
    
    //  Loop until all the memory blocks have been redistributed
    
    while(numberOfBlocksToRedistribute > 0)
    { 
      //  Increment the number of blocks at this index
      
      (mMemoryBanks.get(nextIndex)).incrementNumberOfBlocks();
      
      //  Decrement the number of blocks to redistribute
      
      numberOfBlocksToRedistribute--;

      //  Get the next index
      
      nextIndex = getNextIndex(nextIndex);
    }
  }
  
  //  Procedure to return the memory bank configuration
  
  public Configuration getConfiguration()
  {
    //  Create a new ArrayList
    
    ArrayList<Integer> configurationList = new ArrayList<Integer>();
    
    //  Loop through each memory bank
    
    for(int i = 0 ; i < mMemoryBanks.size() ; i++)
    {
      //  Add the number of blocks in this memory bank to the ArrayList
      
      configurationList.add((mMemoryBanks.get(i)).getNumberOfBlocks());
    }
    
    //  Convert the ArrayList to a Configuration and return it
    
    return(new Configuration(configurationList));
  }
  
  //  Procedure to get the index of the fullest memory bank
  
  private int getIndexOfFullestMemoryBank()
  {
    int indexOfFullestMemoryBank = 0;
    
    //  Loop through each memory bank
    
    for(int i = 1 ; i < mMemoryBanks.size() ; i++)
    {
      //  Check whether the number of blocks in this memory bank is greater than those in the fullest memory bank index
      
      if((mMemoryBanks.get(i)).getNumberOfBlocks() > (mMemoryBanks.get(indexOfFullestMemoryBank)).getNumberOfBlocks())
      {
        //  Set the fullest memory bank index to be this index
        
        indexOfFullestMemoryBank = i;
      }
    }
    
    //  Return the index
    
    return(indexOfFullestMemoryBank);
  }
  
  //  Procedure to get the next memory bank index (wrapping if required)
  
  private int getNextIndex(int currentIndex)
  {
    int nextIndex = 0;
    
    //  Range check the current index
    
    if((currentIndex >= 0) && (currentIndex < (mMemoryBanks.size() - 1)))
    {
      //  Set the next index to be one more than the current index
      
      nextIndex = currentIndex + 1;
    }
    
    //  Return the next index
    
    return(nextIndex);
  }
}
