package puzzle6;

import java.util.ArrayList;

public class Grid
{
  public enum Direction
  {
    DIRECTION_UNKNOWN,
    DIRECTION_RIGHT,
    DIRECTION_UP,
    DIRECTION_LEFT,
    DIRECTION_DOWN
  }
  
  private int mInitialValue = 1;
  private int mCurrentRight = 0;
  private int mCurrentUp    = 0;
  private int mMin          = 0;
  private int mMax          = 0;
  private int mValueToFind  = 0;
  
  private ArrayList<Cell> mCells = new ArrayList<Cell>();
  
  private Direction mDirection = Direction.DIRECTION_UNKNOWN;
  
  //  Constructor
  
  Grid(int valueToFind)
  {
    mValueToFind = valueToFind;
  }
  
  //  Procedure to append a new value to the list
  
  public int appendValue()
  {
    int sum = mInitialValue;
    
    Cell newCell = new Cell();
    
    //  Get the next cell offsets
    
    getNextCellOffsets(newCell);
    
    //  Check that this is not the first cell
    
    if((newCell.getOffsetRight() != 0) || (newCell.getOffsetUp() != 0))
    {
      //  Calculate the sum of the surrounding cells
      
      sum = getSumOfSurroundingCells(newCell);
    }
    
    //  Assign the sum to the cell
    
    newCell.setValue(sum);
    
    //  Append the cell
    
    mCells.add(newCell);
    
    //  Update the current cell
    
    mCurrentRight = newCell.getOffsetRight();
    mCurrentUp    = newCell.getOffsetUp();
    
    //  Check whether the value is the one being searched for
    
    if(newCell.getValue() > mValueToFind)
    {
      return(newCell.getValue());
    }
    
    return(-1);
  }
  
  //  Procedure to get the next cell offsets
  
  private void getNextCellOffsets(Cell cell)
  {
    switch(mDirection)
    {
      case DIRECTION_UNKNOWN:
      {
        mCurrentRight = 0;
        mCurrentUp    = 0;
        
        mDirection = Direction.DIRECTION_RIGHT;
        
        cell.setOffsetRight(mCurrentRight);
        cell.setOffsetUp(mCurrentUp);
        
        break;
      }
      case DIRECTION_DOWN:
      {
        if(mCurrentUp > mMin)
        {
          cell.setOffsetRight(mCurrentRight);
          cell.setOffsetUp(mCurrentUp - 1);
        }
        else
        {
          mDirection = Direction.DIRECTION_RIGHT;
          
          getNextCellOffsets(cell);
        }

        break;
      }
      case DIRECTION_LEFT:
      {
        if(mCurrentRight > mMin)
        {
          cell.setOffsetRight(mCurrentRight - 1);
          cell.setOffsetUp(mCurrentUp);
        }
        else
        {
          mDirection = Direction.DIRECTION_DOWN;
          
          getNextCellOffsets(cell);
        }

        break;
      }
      case DIRECTION_RIGHT:
      {
        if(mCurrentRight < mMax)
        {
          cell.setOffsetRight(mCurrentRight + 1);
          cell.setOffsetUp(mCurrentUp);
        }
        else
        {
          //  Increment to next layer
          
          nextLayer(cell);
        }

        break;
      }
      case DIRECTION_UP:
      {
        if(mCurrentUp < mMax)
        {
          cell.setOffsetRight(mCurrentRight);
          cell.setOffsetUp(mCurrentUp + 1);
        }
        else
        {
          mDirection = Direction.DIRECTION_LEFT;
          
          getNextCellOffsets(cell);
        }

        break;
      }
      default:
      {
        break;
      }
    }
  }

  //  Procedure to move to the next cell
  
  private void nextLayer(Cell cell)
  {
    mMin--;
    mMax++;
    
    cell.setOffsetRight(mCurrentRight + 1);
    cell.setOffsetUp(mCurrentUp);
    
    mDirection = Direction.DIRECTION_UP;
  }
  
  //  Procedure to determine the index of a given cell
  
  private int getIndexOfCell(int offsetRight, int offsetUp)
  {
    int minIndex      = 1;
    int maxIndex      = 1;
    int multiplier    = 0;
    
    //  Check for the centre cell
    
    if((offsetRight == 0) && (offsetUp == 0))
    {
      return(0);
    }

    //  The largest offset value corresponds to the layer that the cell resides in
    
    int cellInLayer = Math.abs(offsetRight) > Math.abs(offsetUp) ? Math.abs(offsetRight) : Math.abs(offsetUp);
    
    //  Determine the number of cells per edge
    
    int cellsPerEdge  = cellInLayer * 2;
    
    //  Determine the minimum and maximum indices of this layer
    
    for(int i = 0 ; i < cellInLayer ; i++)
    {
      minIndex += (i * 8);
      maxIndex  = (minIndex - 1) + ((i + 1) * 8);
    }
    
    //  Check for the first cell
    
    if((offsetRight == cellInLayer) && (offsetUp == -(cellInLayer - 1)))
    {
      //  First cell

      return(minIndex);
    }
    
    //  Check for a corner cell
    
    if     ((offsetRight ==  cellInLayer) && (offsetUp ==  cellInLayer))  multiplier = 1; //  Top Right
    else if((offsetRight == -cellInLayer) && (offsetUp ==  cellInLayer))  multiplier = 2; //  Top Left
    else if((offsetRight == -cellInLayer) && (offsetUp == -cellInLayer))  multiplier = 3; //  Bottom Left
    else if((offsetRight ==  cellInLayer) && (offsetUp == -cellInLayer))  multiplier = 4; //  Bottom Right
    
    //  Check whether a corner was found
    
    if(multiplier != 0)
    {
      //  Cell is at a corner
      
      return(minIndex + ((multiplier * cellsPerEdge) - 1));
    }
    else
    {
      int offset = 0;
      
      //  Check for an edge cell

      if(offsetUp == -cellInLayer)
      {
        //  Bottom edge
        
        multiplier = 0;
        offset     = offsetRight;
      }
      else if(offsetRight == -cellInLayer)
      {
        //  Left edge
        
        multiplier = 1;
        offset     = -offsetUp;
      }
      else if(offsetUp == cellInLayer)
      {
        //  Top edge
        
        multiplier = 2;
        offset     = -offsetRight;
      }
      else if(offsetRight == cellInLayer)
      {
        //  Right edge
        
        multiplier = 3;
        offset     = offsetUp;
      }
      else
      {
        //  Cell is not on a corner or an edge - error condition
        
        return(-1);
      }
      
      //  Add the correct offset from the max index and return the result
      
      return(((maxIndex - cellInLayer) - (multiplier * cellsPerEdge)) + offset);
    }
  }
  
  //  Procedure to calculate the sum of the surrounding cells
  
  private int getSumOfSurroundingCells(Cell cell)
  {
    int rightCellValue        = getCellValueAtOffset(cell.getOffsetRight() + 1, cell.getOffsetUp());
    int topRightCellValue     = getCellValueAtOffset(cell.getOffsetRight() + 1, cell.getOffsetUp() + 1);
    int topCellValue          = getCellValueAtOffset(cell.getOffsetRight(),     cell.getOffsetUp() + 1);
    int topLeftCellValue      = getCellValueAtOffset(cell.getOffsetRight() - 1, cell.getOffsetUp() + 1);
    int leftCellValue         = getCellValueAtOffset(cell.getOffsetRight() - 1, cell.getOffsetUp());
    int bottomLeftCellValue   = getCellValueAtOffset(cell.getOffsetRight() - 1, cell.getOffsetUp() - 1);
    int bottomCellValue       = getCellValueAtOffset(cell.getOffsetRight(),     cell.getOffsetUp() - 1);
    int bottomRightCellValue  = getCellValueAtOffset(cell.getOffsetRight() + 1, cell.getOffsetUp() - 1);

    return(rightCellValue + topRightCellValue + topCellValue + topLeftCellValue + leftCellValue + bottomLeftCellValue + bottomCellValue + bottomRightCellValue);
  }
  
  //  Procedure to return the value at a given cell offset
  
  private int getCellValueAtOffset(int offsetRight, int offsetUp)
  {
    return(getCellValueAtIndex(getIndexOfCell(offsetRight, offsetUp)));
  }
  
  //  Procedure to return the value at a given cell index
  
  private int getCellValueAtIndex(int index)
  {
    if((index >= 0) && (index < mCells.size()))
    {
      return(mCells.get(index).getValue());
    }
    
    return(0);
  }
}
