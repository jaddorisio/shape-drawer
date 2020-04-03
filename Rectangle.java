// File name: Rectangle.java

// Written by: Jonpaul Addorisio
 
// Description: A class file that is used for calculating the perimeter,
//              and area of a rectangle. Then return those said calculations
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
public class Rectangle{
    // Varaible to store dimensions of rectangel
    private double width;
    private double height;
   
    
    // Different contructers to handle certian arguments
    public Rectangle(){
        this.width = 0;
        this.height = 0;
    }
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    
    
    // A set of methods to retrive and set instance variables
    public void setWidth(double w){
        this.width = w;
    }
    public void setHeight(double h){
        this.height = h;
    }
    
    public double getWidth(){
        return this.width;
    }
    public double getHeight(){
        return this.height;
    }
    
    
    // Methods that calculate the area
    // and permiter of rectangle
    public double getArea(){
        double result;
        result = this.height * this.width;
        return Math.round(result * 100.0) / 100.0;
    }
    public double getPerimeter(){
        double result;
        result = (this.width * 2)+(this.height *2);
        return Math.round(result * 100.0) / 100.0;
    }
    
    // Retrieve the name of shape
    public String getName(){
        return "[Rectangle] Width = " + width + " and Height = " +height;
    }
        
    

}
