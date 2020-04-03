
import javax.swing.JFrame;

// File name: ShapeDrawer.java

// Written by: Jonpaul Addorisio
 
// Description: This is a program that allows the user to draw one of
//              3 shapes. These shapes can be displayed with different colors
//              and can be filled or just outline. The program automatically
//              updates a text area box that display calculations based on the 
//              shape drawn. The user from the menu bar can change the font, 
//              foreground color, and background color.
//              
//              
// Challenges: Trying to organize the code all into one file to make easier to
//             acces variables. Createing the mouse event for drawing the shapes.
//             Attempting to create methods for each event where possible to 
//             improve code usabilitty.
//
// Time Spent: 180 min

// Revision History:
// Date:         		By:      Action:
// ---------------------------------------------------
/* 11/16/2017                   JA      Created                       
 *

 *                      
 * 
 *                        
*/  
public class ShapeDrawer {
    public static void main(String args []){
        
        // creates the frame for program
        SelectionFrame main = new SelectionFrame();
         
         main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         main.setSize(600, 600);
         main.setLocationRelativeTo(null);
         main.setVisible(true);
         
    }
}
