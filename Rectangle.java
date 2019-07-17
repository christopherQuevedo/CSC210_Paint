/*  
Chris Quevedo
Tim Root
001B
Assignment10
Assignment11
Rectangle.java, CSc 210, Fall 2017
This program is a class for Rectangle which extends Shape.  Rectangles also have 
an int width field.  Contains methods to draw a rectangle in the drawing window,
display the important info about the rectangle, double both its width and height as well as halve both
of them.
*/

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends Shape{
	
	public Rectangle(String newName, int newWidth, int newHeight, String newFill, int newX, int newY){
		super(newName, newFill, newHeight, newWidth, newX, newY); 
	}
	
	//Sets the gc to rectangle's color and draws it on screen.
	public void Draw(){
		//this.gc.setFill(Color.valueOf(this.getFill()));
		this.gc.fillRect(this.getXpos(), this.getYpos(), this.getWidth(), this.getHeight());
		this.addDrawAmount();
		return;
	}
	
	//Displays relevant information about this rectangle.
	public void Dump(){
		
		double area = this.getHeight() * this.getWidth();
		System.out.printf("RECTANGLE (name:%s) (x:%d) (y:%d) (width:%d) ", this.getName(), this.getXpos(), this.getYpos(), this.getWidth());
		System.out.printf("(height:%d) (area:%f) (fill:%s) (draw_amount:%d)\n", this.getHeight(), area, Color.valueOf(this.getFill()).toString(), this.getDrawAmount());
		return;
	}
	
	//Doubles both width and height
	public void DoubleSize(){
		int newHeight = this.getHeight()*2;
		int newWidth = this.getWidth()*2;
		this.setHeight(newHeight);
		this.setWidth(newWidth);
		return;
	}
	
	//Halves both width and height
	public void HalveSize(){
		int newHeight = this.getHeight()/2;
		int newWidth = this.getWidth()/2;
		this.setHeight(newHeight);
		this.setWidth(newWidth);
		return;
	}
	
	public static void main(String[] args){
		/*
		//name:r1, width:3, height:4, fill:@, x:5, y:6
		Shape r1 = new Rectangle("r1",3,4,"BLUE",5,6);
		r1.Dump();
		r1.Draw();
		
		//name:r1, width:6, height:8, fill:@, x:5, y:6
		r1.DoubleSize();
		r1.Dump();
		r1.Draw();
		
		//name:r1, width:1, height:2, fill:@, x:5, y:6
		r1.HalveSize();
		r1.HalveSize();
		r1.Dump();
		r1.Draw();
		
		//testing out of bounds
		r1.DoubleSize();
		r1.DoubleSize();
		r1.DoubleSize();
		r1.DoubleSize();
		r1.Dump();
		r1.Draw();
		*/
	}
}