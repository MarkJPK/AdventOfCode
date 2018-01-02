package puzzle12;

import java.util.ArrayList;

public class Configuration
{
  ArrayList<Integer> mConfiguration;
  
  //  Constructor
  
  Configuration(ArrayList<Integer> configuration)
  {
    mConfiguration = configuration;
  }
  
  //  Override the equals method
  
  @Override
  public boolean equals(Object o)
  {
    //  If the object is NULL return False
    
    if(o == null) return(false);
    
    //  If the object passed is this object return True
    
    if(o == this) return(true);
    
    //  Typecast the passed object
    
    Configuration inputConfiguration = (Configuration)o;
    
    //  Check that the configurations are of the same length
    
    if(getLength() != inputConfiguration.getLength()) return(false);
    
    //  Compare each value in the configuration
    
    for(int i = 0 ; i < getLength() ; i++)
    {
      if(mConfiguration.get(i) != inputConfiguration.getValueAtIndex(i))
      {
        return(false);
      }
    }
    
    //  Configurations are identical
    
    return(true);
  }
  
  //  Procedure to return the number of elements in the configuration
  
  public int getLength()
  {
    return(mConfiguration.size());
  }
  
  //  Procedure to return the value at a given index
  
  public int getValueAtIndex(int index)
  {
    if((index >= 0) && (index < mConfiguration.size()))
    {
      return(mConfiguration.get(index));
    }
    
    return(0);
  }
}
