import javax.swing.*;
import java.util.ArrayList;
/**
 * The ConnectFour class.
 * 
 * This class represents a Connect Four (TM)
 * game, which allows two players to drop
 * checkers into a grid until one achieves
 * four checkers in a straight line.
 */
public class ConnectFour {
  
int column0 = 0;
int column1 = 0;
int column2 = 0;
int column3 = 0;
int column4 = 0;
int column5 = 0;
int column6 = 0;
int colAndRow;
ArrayList <Integer> player1 = new ArrayList<Integer>();
ArrayList <Integer> player2 = new ArrayList<Integer>();
ArrayList <Integer> player1Col = new ArrayList<Integer>();
ArrayList <Integer> player2Col = new ArrayList<Integer>();
ArrayList <Integer> player1Row = new ArrayList<Integer>();
ArrayList <Integer> player2Row = new ArrayList<Integer>();
//int columnValues for each column
  

  // the grid used for storing the game layout.
  private int[][] grid;
  // the player whose turn it is.
  private int currentPlayer;
  
  /**
   * The ConnectFour constructor.
   * 
   * Creates and initializes the grid for the
   * Connect Four game.
   */
  public ConnectFour() {
    // create the grid
    grid = new int[7][6];
    // initialize the grid
    for (int row = 0; row < 6; row++) {
      for (int column = 0; column < 7; column++) {
        // set the position to a default value
        grid[column][row] = 0;
      }
    }
    // set the first move to Player 1
    currentPlayer = 1;
  }
  
  /**
   * The drop method.
   * 
   * Drop a checker into the specified column,
   * and return the row that the checker lands on.
   * row + (column * 6) is used to give each space a specific value
   * stores that value into an array list to be used to check win
   */
  int drop(int column) {
    int row = columnValue(column);
    colAndRow = row + (column * 6);
    
     if(currentPlayer == 1){
      player1.add(colAndRow);
      player1Col.add(column);
    player1Row.add(row);
    }else{
      player2.add(colAndRow);
      player2Col.add(column);
    player2Row.add(row);
    }if (hasWon(colAndRow, column, row)){
      if(currentPlayer == 1){
        System.out.println("Black wins!");
      }else{
        System.out.println("Red wins!");
      }
    }else{
    }
      
        currentPlayer = (currentPlayer % 2) + 1;
    
    return row;
  }
  /** 
   * The columnValue method.
   * 
   * input the column and it adds one to the column counter
   * this keeps track of how many checkers are in each column
   * return the number of checkers in column
   */
  int columnValue(int column) {
    int columnVal = 0;
    if(column == 0){
      columnVal = column0;
    column0++;
    return columnVal;
  }else if(column == 1){
      columnVal = column1;
    column1++;
    return columnVal;
  }else if(column == 2){
      columnVal = column2;
    column2++;
    return columnVal;
  }else if(column == 3){
      columnVal = column3;
    column3++;
    return columnVal;
  }else if(column == 4){
      columnVal = column4;
    column4++;
    return columnVal;
  }else if(column == 5){
      columnVal = column5;
    column5++;
    return columnVal;
  }else{
      columnVal = column6;
    column6++;
    return columnVal;
  }
  }
  
  /**
   * The toString method
   * 
   * Returns a String representation of this 
   * Connect Four (TM) game.
   */
  public String toString() {
    String returnString = "";
    for (int row = 5; row >= 0; row--) {
      for (int column = 0; column < 7; column++) {
        returnString = returnString + grid[column][row];
      }
      returnString = returnString + "\n";
      System.out.println(returnString);
    }
    return returnString;
  }
  
  /**
   * The hasWon method.
   * 
   * This method returns true if one of the 
   * players has won the game.
   * row + (column * 6) is used to give each space an individual value to make it easier to check wins
   * the addition or subtraction is based on the spaces around each space
   */
  public boolean hasWon(int colAndRow, int column, int row) {
    boolean status = false;
    if (currentPlayer == 1){
      //check columns perfect so far
      if ( player1.contains((colAndRow) + 1) || player1.contains((colAndRow) - 1)){
        if(player1.contains((colAndRow) + 1) &&((colAndRow + 1) / 6) == colAndRow / 6 
             ||player1.contains((colAndRow) - 1) && ((colAndRow - 1) / 6) == colAndRow / 6){
        if(player1.contains((colAndRow) + 2) || player1.contains((colAndRow) - 2) ){
        if(player1.contains((colAndRow) + 2) &&((colAndRow + 1) / 6) == colAndRow / 6 ||
           player1.contains((colAndRow) - 2) && ((colAndRow - 2) / 6) == colAndRow / 6){
          if(player1.contains((colAndRow) + 3) || player1.contains((colAndRow) - 3) ){
     if(player1.contains((colAndRow) + 3) && ((colAndRow + 1) / 6) == colAndRow / 6 || 
        player1.contains((colAndRow) - 3) && ((colAndRow - 3) / 6) == colAndRow / 6){
          status = true;
       }
        }
        }
          
        
        }//check row
      }
      }if(player1.contains((colAndRow) + 6) || player1.contains((colAndRow) - 6) ){
        if(player1.contains((colAndRow) + 12) || player1.contains((colAndRow) - 12) ){
          if(player1.contains((colAndRow) + 18) || player1.contains((colAndRow) - 18) ){
          status = true;
          }
        }//check diagonal top left to bottom right
      }if(player1.contains((colAndRow) + 5) && player1Col.get(player1.indexOf((colAndRow) + 5)) != column //doesnt work because your basing it off the current column
            || player1.contains((colAndRow) - 5) && player1Col.get(player1.indexOf((colAndRow) - 5)) != column ){
      
        if(player1.contains((colAndRow) + 10) || player1.contains((colAndRow) - 10) 
             ||player1.contains((colAndRow) + 5) && player1.contains((colAndRow) - 5) ){
          if(player1.contains((colAndRow) + 15) || player1.contains((colAndRow) - 15) 
               || player1.contains((colAndRow) + 5) && player1.contains((colAndRow) - 5)  && player1.contains((colAndRow) + 10) 
            ||player1.contains((colAndRow) + 5) && player1.contains((colAndRow) - 5)  && player1.contains((colAndRow) - 10)){
            
 status = true;
            
          
          }
          
        }//check diagonal top right to bottom left
      }if(player1.contains((colAndRow) + 7) || player1.contains((colAndRow) - 7) ){
        if(player1.contains((colAndRow) + 14) || player1.contains((colAndRow) - 14) ){
          if(player1.contains((colAndRow) + 21) || player1.contains((colAndRow) - 21) ){
          status = true;
          }
        }
      }else{
    }
    }else{
      //check columns
       if ( player2.contains((colAndRow) + 1) || player2.contains((colAndRow) - 1)){
        if(player2.contains((colAndRow) + 2) || player2.contains((colAndRow) - 2) ){
          if(player2.contains((colAndRow) + 3) || player2.contains((colAndRow) - 3) ){
          status = true;
          }
        }//check row
      } if(player2.contains((colAndRow) + 6) || player2.contains((colAndRow) - 6) ){
        if(player2.contains((colAndRow) + 12) || player2.contains((colAndRow) - 12) ){
          if(player2.contains((colAndRow) + 18) || player2.contains((colAndRow) - 18) ){
         status = true;
          }
        }//check diagonal top left to bottom right
      }if(player2.contains((colAndRow) + 5) || player2.contains((colAndRow) - 5) ){
        if(player2.contains((colAndRow) + 10) || player2.contains((colAndRow) - 10) ){
          if(player2.contains((colAndRow) + 15) || player2.contains((colAndRow) - 15) ){
         status = true;
          }
        }////check diagonal top right to bottom left
      } if(player2.contains((colAndRow) + 7) || player2.contains((colAndRow) - 7) ){
        if(player2.contains((colAndRow) + 14) || player2.contains((colAndRow) - 14) ){
          if(player2.contains((colAndRow) + 21) || player2.contains((colAndRow) - 21) ){
          status = true;
          }
        }
      }else{
    }
    }
    return status;
  }
  
  
 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public static void main(String[] args) {
    ConnectFour game = new ConnectFour();
    ConnectFourGUI gui = new ConnectFourGUI();
    ConnectFourListener listener = new ConnectFourListener(game, gui);
  }
  
}

















