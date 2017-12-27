package puzzle6;

public class Cell
{
  //  Offset from Centre of Spiral (mRight = 0, mUp = 0);
  
  private int mOffsetRight = 0;
  private int mOffsetUp    = 0;
  
  //  Value held by cell
  
  private int mValue = 0;
  
  //  Constructor
  
  public Cell()
  {
    this.mOffsetRight = 0;
    this.mOffsetUp    = 0;
    this.mValue       = 0;
  }
  
  //  Constructor
  
  public Cell(int offsetRight, int offsetUp, int value)
  {
    this.mOffsetRight = offsetRight;
    this.mOffsetUp    = offsetUp;
    this.mValue       = value;
  }
  
  //  Procedure to set the value
  
  public void setValue(int value)
  {
    this.mValue = value;
  }
  
  //  Procedure to get the value
  
  public int getValue()
  {
    return(this.mValue);
  }
  
  //  Procedure to set the right offset
  
  public void setOffsetRight(int offsetRight)
  {
    this.mOffsetRight = offsetRight;
  }
  
  //  Procedure to get the right offset
  
  public int getOffsetRight()
  {
    return(this.mOffsetRight);
  }
  
  //  Procedure to set the up offset
  
  public void setOffsetUp(int offsetUp)
  {
    this.mOffsetUp = offsetUp;
  }
  
  //  Procedure to get the up offset
  
  public int getOffsetUp()
  {
    return(this.mOffsetUp);
  }
}
