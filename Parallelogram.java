/*   
Chris Quevedo
Tim Root
001B
Assignment10
Assignment11
Parallelogram.java, CSc 210, Fall 2017
This program is a class for Parallelograms and extends Rectangles.  Parallelograms in this case
are similar to rectangles and only differ greatly in their draw methods.
*/

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Parallelogram extends Rectangle{
	
	public Parallelogram(String newName, int newWidth, int newHeight, String newFill, int newX, int newY){
		super(newName, newWidth, newHeight, newFill, newX, newY);
	}
	
	//Draws parallelogram using fillPolygon method for GraphicsContext
	public void Draw(){
		double[] xpoints = new double[4];
		double[] ypoints = new double[4];
		xpoints[0] = this.getXpos() + this.getHeight();
		xpoints[1] = this.getXpos() + this.getHeight() + this.getWidth();
		xpoints[2] = this.getXpos() + this.getWidth();
		xpoints[3] = this.getXpos();
		ypoints[0] = this.getYpos();
		ypoints[1] = this.getYpos();
		ypoints[2] = this.getYpos() + this.getHeight();
		ypoints[3] = this.getYpos() + this.getHeight();
		//this.gc.setFill(Color.valueOf(this.getFill()));
		this.gc.fillPolygon(xpoints, ypoints, 4);
		this.addDrawAmount();
		return;
	}
	
	//Same as rectangle dump method except it is classified as PARALLELOGRAM
	public void Dump(){
		
		double area = this.getHeight() * this.getWidth();
		System.out.printf("PARALLELOGRAM (name:%s) (x:%d) (y:%d) (width:%d) ", this.getName(), this.getXpos(), this.getYpos(), this.getWidth());
		System.out.printf("(height:%d) (area:%f) (fill:%s) (draw_amount:%d)\n", this.getHeight(), area, Color.valueOf(this.getFill()).toString(), this.getDrawAmount());
		return;
	}
	
	public static void main(String[] args){
		/*
		//name:p1, width:3, height:4, fill:@, x:5, y:6
		Shape p1 = new Parallelogram("p1",3,4,"RED",5,6);
		p1.Dump();
		p1.Draw();
		
		//name:p1, width:6, height:8, fill:@, x:5, y:6
		p1.DoubleSize();
		p1.DoubleSize();
		p1.DoubleSize();
		p1.Dump();
		p1.Draw();
		
		//name:p1, width:1, height:2, fill:@, x:5, y:6
		p1.HalveSize();
		p1.HalveSize();
		p1.Dump();
		p1.Draw();
		*/
	}
}