import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  int [][] gameGrid;

  JTextField[][] textFieldsArray = new JTextFields[9][9];

  boolean solvedGame[][] = new boolean[9][9];

  int [][] usersInput;

  JButton checkButton;

  int [][] gridToShowOnScreen;
  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    // our main panel
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());

    // the text fields panel
    JPanel textFieldPanel = new JPanel();
    textFieldPanel.setLayout(new GridLayout(9,9));

    // put in all of the value into the 2D array
    gameGrid = new int[][]{{4, 8, 1, 5, 9, 2, 7, 3, 6},
      {9, 2, 5, 6, 7, 3, 1, 4, 8},
      {7, 3, 6, 4, 1, 8, 9, 2, 5},
      {8, 6, 7, 2, 4, 1, 3, 5, 9},
      {2, 9, 3, 8, 5, 7, 4, 6, 1},
      {1, 5, 4, 3, 6, 9, 8, 7, 2},
      {6, 7, 8, 1, 2, 4, 5, 9, 3},
      {5, 1, 9, 7, 3, 6, 2, 8, 4},
      {3, 4, 2, 9, 8, 5, 6, 1, 7}};

    gridToShowOnScreen = new int[][]{{4, 8, 1, 5, 9, 2, 7, 3, 6},
      {9, 2, 5, 6, 7, 3, 1, 4, 8},
      {7, 3, 6, 4, 1, 8, 9, 2, 5},
      {8, 6, 7, 2, 4, 1, 3, 5, 9},
      {2, 9, 3, 8, 5, 7, 4, 6, 1},
      {1, 5, 4, 3, 6, 9, 8, 7, 2},
      {6, 7, 8, 1, 2, 4, 5, 9, 3},
      {5, 1, 9, 7, 3, 6, 2, 8, 4},
      {3, 4, 2, 9, 8, 5, 6, 1, 7}};
  
     // create a constant for the grid's length
    int totalRows = 9;

    // create a constant for the grid's "width"
    int totalColumns = 9;

    // use a for loop inside of a for loop to create the text fields
    for(int i = 0; i < totalRows; i++){
      for(int z = 0; z < totalColumns; z++){

        // create a blank text field
        textFieldsArray[z] = new JTextField();

        // add the action command
        textFieldsArray[z].setActionCommand(""+ z);

        // add the action ActionListener
        textFieldsArray[z].addActionListener(this);

        // add the text fields to the GridLayout
        textFieldPanel.add(gameGrid[z]);
      }
    }
    
    // assemble the panels
    mainPanel.add(gameGrid, BorderLayout.CENTER);

    // initialize the button
    checkButton = new JButton("Check");

    // add an action listener to the button
    checkButton.addActionListener(this);

    // set the action command on the button
    checkButton.setActionCommand("Check");

    // add the button to the main pannel
    mainPanel.add(checkButton);

    // use an aray to store the user's input
    for(int i = 0; i < totalRows; i++){
      for(int z = 0; z < totalColumns; z++){

        // put the user's input inside of the array
        usersInput[z] = textFieldsArray;

      }
    }
   
    // add the main panel to the frame
    frame.add(mainPanel);

  }


  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    
    // what happens if the check button is pressed
    if(command.equals("Check")){
      
      // compare the users input with the original board
      for(i = 0; i < totalRows; i++){
        for(z = 0; z < totalColumns; z++){
          if(gameGrid[i][z] = usersInput[i][z]){
            usersInput = Integer.toHexInteger(color.getGreen);
          }else{
            usersInput = Integer.toHexInteger(color.getRed);
          }
        }
      }
    }
  }
  

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}