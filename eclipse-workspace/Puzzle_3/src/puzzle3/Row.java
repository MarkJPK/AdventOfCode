package puzzle3;

import java.util.StringTokenizer;

public class Row
{
  String thisRow = null;
  
  //  Constructor
  
  Row(String rowString)
  {
    thisRow = rowString;
  }
  
  //  Procedure to calculate and return the difference between the biggest
  //  and smallest values in the row
  
  public int getDelta()
  {
    int biggestNumber   = -1;
    int smallestNumber  = -1;

    //  Tokenise the string
    
    StringTokenizer st1 = new StringTokenizer(thisRow);

    //  Loop through each token
    
    while(st1.hasMoreTokens())
    {
      //  Convert the token to an integer
      
      int thisInteger = Integer.parseInt(st1.nextToken());
      
      //  Update the biggest and smallest values

      if((biggestNumber  == -1) || (thisInteger > biggestNumber))   biggestNumber  = thisInteger;
      if((smallestNumber == -1) || (thisInteger < smallestNumber))  smallestNumber = thisInteger;
    }
    
    //  Return the difference between the biggest and smallest values
    
    return(biggestNumber - smallestNumber);
  }
}
