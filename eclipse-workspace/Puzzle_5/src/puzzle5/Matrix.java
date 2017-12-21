package puzzle5;

public class Matrix
{
  int mSize         = 0;
  int mOriginRight  = 0;
  int mOriginUp     = 0;
  int mCurrentIndex = 0;
  int mCurrentRight = 0;
  int mCurrentUp    = 0;
  
  Integer[] masterMatrix;
  
  Matrix(int size)
  {
    if((size % 2) == 0)
    {
      mSize = size + 1;
    }
    else
    {
      mSize = size;
    }
    
    System.out.println("Construct matrix : Rows = " + mSize + ", Columns = " + mSize);
    
    masterMatrix = new Integer[mSize * mSize];
    
    mOriginRight = mCurrentRight = -((mSize - 1) / 2);
    mOriginUp    = mCurrentUp    =  ((mSize - 1) / 2);
    
    System.out.println("Size         = " + masterMatrix.length);
    System.out.println("Origin Right = " + mOriginRight);
    System.out.println("Origin Up    = " + mOriginUp);
    
    setCellOfInterest(0, 0);

    setCellOfInterest(-2, 2);
    
    setCellOfInterest(2, -2);
    
    //  Size 3 => Top Left = -1, -1 = (Size - 1) / 2
    //  Size 5 => Top Left = -2, -2 = (Size - 1) / 2
    //  Size 7 => Top Left = -3, -3 = (Size - 1) / 2
    
    // X, Y (from centrepoint) (X => Positive Right, Y => Positive Up)
    // -2, +2 => masterMatrix[0]
    // -1, +2 => masterMatrix[1]
    //  0, +2 => masterMatrix[2]
    // +1, +2 => masterMatrix[3]
    // +2, +2 => masterMatrix[4]

    // -2, +1 => masterMatrix[5]
    // -1, +1 => masterMatrix[6]
    //  0, +1 => masterMatrix[7]
    // +1, +1 => masterMatrix[8]
    // +2, +1 => masterMatrix[9]

    // -2, +0 => masterMatrix[10]
    // -1, +0 => masterMatrix[11]
    //  0, +0 => masterMatrix[12]
    // +1, +0 => masterMatrix[13]
    // +2, +0 => masterMatrix[14]

    // -2, -1 => masterMatrix[15]
    // -1, -1 => masterMatrix[16]
    //  0, -1 => masterMatrix[17]
    // +1, -1 => masterMatrix[18]
    // +2, -1 => masterMatrix[19]

    // -2, -2 => masterMatrix[20]
    // -1, -2 => masterMatrix[21]
    //  0, -2 => masterMatrix[22]
    // +1, -2 => masterMatrix[23]
    // +2, -2 => masterMatrix[24]
  }
  
  //  Procedure to write a value to a specified cell
  
  public void writeCell(int right, int up, int value)
  {
    setCellOfInterest(right, up);
    
    masterMatrix[mCurrentIndex] = value;
  }
  
  //  Procedure to read a value from a specified cell
  
  public int readCell(int right, int up)
  {
    setCellOfInterest(right, up);
    
    return(masterMatrix[mCurrentIndex]);
  }
  
  private void setCellOfInterest(int right, int up)
  {
    System.out.println("Set Cell Of Interest: Right = " + right + ", Up = " + up);
    
    int stepsRight = right - mOriginRight;
    int stepsDown  = up    - mOriginUp;
    
    System.out.println("Steps Right = " + stepsRight + ", Down = " + stepsDown);
    
    mCurrentIndex = (-stepsDown * mSize) + stepsRight;
    mCurrentRight = right;
    mCurrentUp    = up;
    
    System.out.println("Current Index = " + mCurrentIndex);
  }
}
