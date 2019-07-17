/*  
Chris Quevedo
Tim Root
001B
Assignment10
Assignment11
Shape.java, CSc 210, Fall 2017
This program is an abstract class that envelopes all the 
common features of Shapes.  If it's in here, then it is relevant to 
all the Shapes.
*/

import javafx.scene.canvas.GraphicsContext;

public abstract class Shape{
	
	private String name;
	private String fill;
	private int height;
	private int width;
	private int xpos;
	private int ypos;
	private int drawAmount;
	GraphicsContext gc;
	
	public Shape(String newName, String newFill, int newHeight, int newWidth, int newX, int newY){
		this.name = newName;
		this.fill = newFill;
		this.height = newHeight;
		this.width = newWidth;
		this.xpos = newX;
		this.ypos = newY;
		this.drawAmount = 0;
	}
	
	//GETTERS
	public String getName(){
		return this.name;
	}
	public String getFill(){
		return this.fill;
	}
	public int getHeight(){
		return this.height;
	}
	public int getWidth(){
		return this.width;
	}
	public int getXpos(){
		return this.xpos;
	}
	public int getYpos(){
		return this.ypos;
	}
	public int getDrawAmount(){
		return this.drawAmount;
	}
	//////////////////////////////
	
	//SETTERS
	public void setHeight(int newHeight){
		this.height = newHeight;
	}
	public void setWidth(int newWidth){
		this.width = newWidth;
	}
	public void setX(int x){
		this.xpos = x;
	}
	public void setY(int y){
		this.ypos = y;
	}
	public void addDrawAmount(){
		this.drawAmount++;
	}
	//////////////////////////////
	
	public abstract void Draw();
	
	public abstract void Dump();
	
	public abstract void DoubleSize();
	
	public abstract void HalveSize();
	
}