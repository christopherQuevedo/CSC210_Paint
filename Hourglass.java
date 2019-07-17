/*  
Chris Quevedo
Tim Root
001B
Assignment10
Assignment11
Hourglass.java, CSc 210, Fall 2017
This program is a class for Hourglass objects and extends Shape.
An hourglass is basically an UP triangle and DOWN triangle together.
So its fields include two triangles, one up and one down.  The constructor will
create these triangles accordingly based on the hourglass height and fill.
*/

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Hourglass extends Shape{
	
	private Triangle upTri;
	private Triangle downTri;
	
	public Hourglass(String newName, String newFill, int newHeight, int newX, int newY){
		super(newName, newFill, newHeight, 10, newX, newY);
		int h2 = newHeight / 2;
		int h1 = newHeight - h2;
		this.downTri = new Triangle("downTri", newFill, h1, newX, newY, "DOWN");
		this.upTri = new Triangle("upTri", newFill, h2, h1-h2+newX, newY+h1, "UP");
	}
	
	public void setHeight(int newHeight){
		super.setHeight(newHeight);
		int h2 = newHeight / 2;
		int h1 = newHeight - h2;
		int newX = super.getXpos();
		int newY = super.getYpos();
		this.downTri = new Triangle("downTri", "na", h1, newX, newY, "DOWN");
		this.upTri = new Triangle("upTri", "na", h2, h1-h2+newX, newY+h1, "UP");
	}
	
	public void setX(int x){
		super.setX(x);
		int h2 = this.getHeight() / 2;
		int h1 = this.getHeight() - h2;
		int newX = super.getXpos();
		int newY = super.getYpos();
		this.downTri = new Triangle("downTri", "na", h1, newX, newY, "DOWN");
		this.upTri = new Triangle("upTri", "na", h2, h1-h2+newX, newY+h1, "UP");
		
	}
	public void setY(int y){
		super.setY(y);
		int h2 = this.getHeight() / 2;
		int h1 = this.getHeight() - h2;
		int newX = super.getXpos();
		int newY = super.getYpos();
		this.downTri = new Triangle("downTri", "na", h1, newX, newY, "DOWN");
		this.upTri = new Triangle("upTri", "na", h2, h1-h2+newX, newY+h1, "UP");
	}
	
	//Will set the two triangle's gc field to the same gc as hourglass and will
	//simply draw the two triangles.
	public void Draw(){
		upTri.gc = this.gc;
		downTri.gc = this.gc;
		upTri.Draw();
		downTri.Draw();
		this.addDrawAmount();
	}
	
	//Calculates each triangles area and adds them to get total area.
	public void Dump(){
		double areaD = this.downTri.getBase() * this.downTri.getHeight() / 2.0;
		double areaU = this.upTri.getBase() * this.upTri.getHeight() / 2.0;
		double area = areaD + areaU;
		System.out.printf("HOURGLASS (name:%s) (x:%d) (y:%d) ", this.getName(), this.getXpos(), this.getYpos());
		System.out.printf("(height:%d) (area:%f) (fill:%s) (draw_amount:%d)\n", this.getHeight(), area, Color.valueOf(this.getFill()).toString(), this.getDrawAmount());
		return;
	}
	
	//Doubles the height and "adjusts" the two triangle fields.
	public void DoubleSize(){
		this.setHeight(this.getHeight()*2);
		int h2 = this.getHeight() / 2;
		int h1 = this.getHeight() - h2;
		this.downTri = new Triangle("downTri", this.getFill(), h1, this.getXpos(), this.getYpos(), "DOWN");
		this.upTri = new Triangle("upTri", this.getFill(), h2, h1 - h2 + this.getXpos(), this.getYpos() + h1, "UP");
		return;
	}
	
	//Halves height and "adjusts" the two triangle fields.
	public void HalveSize(){
		this.setHeight(this.getHeight()/2);
		int h2 = this.getHeight() / 2;
		int h1 = this.getHeight() - h2;
		this.downTri = new Triangle("downTri", this.getFill(), h1, this.getXpos(), this.getYpos(), "DOWN");
		this.upTri = new Triangle("upTri", this.getFill(), h2, h1 - h2 + this.getXpos(), this.getYpos() + h1, "UP");
		return;
	}
	
	public static void main(String[] args){
		/*
		//name:h1, height:5, fill:@, x:6, y:7
		Shape h1 = new Hourglass("h1","GREEN",1000,6,7);
		h1.Dump();
		h1.Draw();
		
		//name:h1, height:10, fill:@, x:6, y:7
		h1.DoubleSize();
		h1.Dump();
		h1.Draw();
		
		//name:h1, height:2, fill:@, x:6, y:7
		h1.HalveSize();
		h1.HalveSize();
		h1.Dump();
		h1.Draw();
		*/
	}
}