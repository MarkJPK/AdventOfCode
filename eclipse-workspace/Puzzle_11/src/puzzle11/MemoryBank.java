package puzzle11;

public class MemoryBank
{
  private int mNumberOfBlocks = 0;
  
  //  Constructor
  
  MemoryBank()
  {
    mNumberOfBlocks = 0;
  }
  
  //  Procedure to set the number of blocks
  
  public void setNumberOfBlocks(int numberOfBlocks)
  {
    mNumberOfBlocks = numberOfBlocks;
  }
  
  //  Procedure to get the number of blocks
  
  public int getNumberOfBlocks()
  {
    return(mNumberOfBlocks);
  }
  
  //  Procedure to increment the number of blocks
  
  public void incrementNumberOfBlocks()
  {
    mNumberOfBlocks++;
  }
}
