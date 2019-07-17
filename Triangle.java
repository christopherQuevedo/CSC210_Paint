/* 
Chris Quevedo 
Tim Root
001B
Assignment10
Assignment11
Triangle.java, CSc 210, Fall 2017
This program is a class for Triangle objects and extends Shape.
Triangles also have a direction either UP or DOWN and have an int base
field.  When drawn, triangles will always be isosceles and point straight up
or down.
*/

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Triangle extends Shape{
	
	private String dir;    //"UP" is up, "DOWN" is down
	private int base;
	
	public Triangle(String newName, String newFill, int newHeight, int newX, int newY, String newDir){
		super(newName, newFill, newHeight, 10, newX, newY);
		this.dir = newDir;
		this.base = 2*newHeight - 1;
	}
	//GETTERS
	public int getBase(){
		return this.base;
	}
	//////////////////////////////
	
	//SETTERS
	public void setBase(int newBase){
		this.base = newBase;
	}
	public void setHeight(int newHeight){
		super.setHeight(newHeight);
		this.base = 2*newHeight - 1;
	}
	//////////////////////////////
	
	//Uses fillPolygon to draw triangle but the points used in the method
	//depend on if it is an UP or DOWN triangle.
	public void Draw(){
		double[] xpoints = new double[3];
		double[] ypoints = new double[3];
		if(this.dir.equals("UP")){
			xpoints[0] = this.getXpos();
			xpoints[1] = this.getXpos() + this.base/2;
			xpoints[2] = this.getXpos() + this.base;
			ypoints[0] = this.getYpos() + this.getHeight();
			ypoints[1] = this.getYpos();
			ypoints[2] = this.getYpos() + this.getHeight();
		}
		else{
			xpoints[0] = this.getXpos();
			xpoints[1] = this.getXpos() + this.base/2;
			xpoints[2] = this.getXpos() + this.base;
			ypoints[0] = this.getYpos();
			ypoints[1] = this.getYpos() + this.getHeight();
			ypoints[2] = this.getYpos();
		}
		//this.gc.setFill(Color.valueOf(this.getFill()));
		this.gc.fillPolygon(xpoints, ypoints, 3);
		this.addDrawAmount();
	}
	
	//Displays relevant info but includes a direction and omits width.
	public void Dump(){
		double area = this.base * this.getHeight() / 2.0;
		System.out.printf("TRIANGLE (name:%s) (x:%d) (y:%d) ", this.getName(), this.getXpos(), this.getYpos());
		System.out.printf("(height:%d) (area:%f) (direction:%s) (fill:%s) (draw_amount:%d)\n", this.getHeight(), area, this.dir, Color.valueOf(this.getFill()).toString(), this.getDrawAmount());
		return;
	}
	
	//Doubles the height and adjusts base accordingly.
	public void DoubleSize(){
		int newHeight = this.getHeight()*2;
		this.setHeight(newHeight);
		this.base = 2*newHeight - 1;
		return;
	}
	
	//Halves height and adjusts base.
	public void HalveSize(){
		int newHeight = this.getHeight()/2;
		this.setHeight(newHeight);
		this.base = 2*newHeight - 1;
		return;
	}
	
	public static void main(String[] args){
		/*
		//name:t1, height:5, fill:@, x:6, y:7, dir:UP
		Shape t1 = new Triangle("t1","YELLOW",5,6,7,"DOWN");
		t1.Dump();
		t1.Draw();
		
		//name:t1, height:10, fill:@, x:6, y:7, dir:UP
		t1.DoubleSize();
		t1.Dump();
		t1.Draw();
		
		//name:t1, height:2, fill:@, x:6, y:7, dir:UP
		t1.HalveSize();
		t1.HalveSize();
		t1.Dump();
		t1.Draw();
		*/
	}
}