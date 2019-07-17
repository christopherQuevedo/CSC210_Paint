/* 
Chris Quevedo 
Tim Root
001B
Assignment11
Drawing.java, CSc 210, Fall 2017
This program acts as a driver to create a javafx application with buttons, labels, textfields, and a drawing canvas.
The buttons allow user to choose a shape and color to draw.  The textfields allow
the user to change the shape to draw's height and width and clicking the mouse on the
canvas area will draw the shape with specified parameters.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.*;

public class Drawing extends Application{
	
	//GUI components
	private Button rectButton;
	private Button paraButton;
	private Button triButton;
	private Button hourButton;
	private Button redButton;
	private Button greenButton;
	private Button blueButton;
	private Button clearButton;
	private Label heightLabel;
	private Label widthLabel;
	private TextField heightField;
	private TextField widthField;
	
	//Shape components
	private GraphicsContext gc;
	private Shape newShape;
	private int height = 10;
	private int width = 10;
	private int xpos = 0;
	private int ypos = 0;
	private String fill = "RED";
	
	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage primaryStage){
		//Initialization
		primaryStage.setTitle("Gooey");
		BorderPane pane = new BorderPane();
		VBox leftbox = new VBox();
		Canvas canvas = new Canvas(800, 800);
		pane.setLeft(leftbox);
		pane.setCenter(canvas);
		gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, 800, 800);
		gc.setFill(Color.valueOf(fill));
		Scene scene = new Scene(pane);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//Make Buttons
		rectButton = new Button("Rectangle");
		paraButton = new Button("Parallelogram");
		triButton = new Button("Triangle");
		hourButton = new Button("Hourglass");
		redButton = new Button("Red");
		greenButton = new Button("Green");
		blueButton = new Button("Blue");
		clearButton = new Button("Clear");
		
		//Make Labels
		heightLabel = new Label("Height:");
		widthLabel = new Label("Width:");
		
		//Make TextFields
		heightField = new TextField("Enter height");
		widthField = new TextField("Enter width");
		
		//Put buttons in VBox leftbox
		leftbox.getChildren().addAll(rectButton, paraButton, triButton, hourButton);
		leftbox.getChildren().addAll(redButton, greenButton, blueButton, heightLabel);
		leftbox.getChildren().addAll(heightField, widthLabel, widthField, clearButton);
		
		//Set up event handling
		EventHandler<ActionEvent> rH = new RectHandler();
		rectButton.setOnAction(rH);
		EventHandler<ActionEvent> pH = new ParaHandler();
		paraButton.setOnAction(pH);
		EventHandler<ActionEvent> tH = new TriHandler();
		triButton.setOnAction(tH);
		EventHandler<ActionEvent> hH = new HourHandler();
		hourButton.setOnAction(hH);
		EventHandler<ActionEvent> redH = new RedHandler();
		redButton.setOnAction(redH);
		EventHandler<ActionEvent> greenH = new GreenHandler();
		greenButton.setOnAction(greenH);
		EventHandler<ActionEvent> blueH = new BlueHandler();
		blueButton.setOnAction(blueH);
		EventHandler<ActionEvent> cH = new ClearHandler();
		clearButton.setOnAction(cH);
		EventHandler<ActionEvent> heightH = new HeightHandler();
		heightField.setOnAction(heightH);
		EventHandler<ActionEvent> widthH = new WidthHandler();
		widthField.setOnAction(widthH);
		EventHandler<MouseEvent> mH = new MouseHandler();
		canvas.setOnMouseClicked(mH);
		
		//Initialize a shape to draw
		newShape = new Rectangle("na", width, height, fill, xpos, ypos);
	}
	
	// EVENT HANDLER CLASSES ////////////////////
	private class RectHandler implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent event){
			newShape = new Rectangle("na", width, height, fill, xpos, ypos);
		}
	}
	
	private class ParaHandler implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent event){
			newShape = new Parallelogram("na", width, height, fill, xpos, ypos);
		}
	}
	
	private class TriHandler implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent event){
			newShape = new Triangle("na", fill, height, xpos, ypos, "UP");
		}
	}
	
	private class HourHandler implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent event){
			newShape = new Hourglass("na", fill, height, xpos, ypos);
		}
	}
	
	private class RedHandler implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent event){
			gc.setFill(Color.RED);
			fill = "RED";
		}
	}
	
	private class GreenHandler implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent event){
			gc.setFill(Color.GREEN);
			fill = "GREEN";
		}
	}
	
	private class BlueHandler implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent event){
			gc.setFill(Color.BLUE);
			fill = "BLUE";
		}
	}
	
	private class ClearHandler implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent event){
			gc.setFill(Color.WHITE);
			gc.fillRect(0,0,800,800);
			gc.setFill(Color.valueOf(fill));
		}
	}
	
	private class HeightHandler implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent event){
			
			String text = heightField.getText();
			
			try{
				height = Integer.parseInt(text);
				newShape.setHeight(height);
			}
			catch(NumberFormatException e){
				height = 10;
				heightField.setText("10");
			}
		}
	}
	
	private class WidthHandler implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent event){
			
			String text = widthField.getText();
			
			try{
				width = Integer.parseInt(text);
				try{
					newShape.setWidth(width);
				}
				catch(Exception ee){
					//do nothing
				}
			}
			catch(NumberFormatException e){
				width = 10;
				widthField.setText("10");
			}
		}
	}
	
	private class MouseHandler implements EventHandler<MouseEvent>{
		
		@Override
		public void handle(MouseEvent event){
			xpos = (int) event.getX();
			ypos = (int) event.getY();
			newShape.setX(xpos);
			newShape.setY(ypos);
			newShape.gc = gc;
			newShape.Draw();
		}
	}
	/////////////////////////////////////////////		
}