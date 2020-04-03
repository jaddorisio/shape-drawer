// File name: Square.java

// Written by: Jonpaul Addorisio
 
// Description: A class file that is used for calculating the perimeter,
//              and area of a square. Then return those said calculations
//              
//              
// Challenges: No challenges were met when creating this object
//
// Time Spent: 25 min

// Revision History:
// Date:         		By:      Action:
// ---------------------------------------------------
/* 04/10/1997                   JA      Created                       
 * 
 *                      
 * 
 *                        
*/      
public class Square {
    private double side;
    
    // Constructer for setting values of side
    public Square(){
        this.side = 0;
    }
    public Square(double s){
        this.side = s;
    }
    
    // a method to set the side value
    public void setSide(double s){
        this.side = s;
    }

    // a method that returns the value 
    // of side variable
    public double getSide(){
        return this.side;
    }

    
    
    // methods that calculates the area
    // of square and perimeter
    public double getArea(){
        double result;
        result = this.side * this.side;
        
        return Math.round(result * 100.0) / 100.0;
    }
    public double getPerimeter(){
        double result;
        result = this.side * 4;
        
        return  Math.round(result * 100.0) / 100.0;
    }
    
    // Method that returns name of shap
    public String getName(){
        return "[Square] Side = " + this.side;
    }
}
