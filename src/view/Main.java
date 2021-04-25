package view;

import java.io.FileNotFoundException;

import controller.MainController;
import processing.core.PApplet;

public class Main extends PApplet{

	private int screen;
	private MainController mainController;
	
	public static void main(String[] args) {
		PApplet.main("view.Main");
	}

	public void settings() {
		size(1200,800);
	}
	
	public void setup() {
		screen = 1;
		mainController = new MainController(this);
	}

	public void draw() {
		background(40);
		textSize(20);
		fill(160);
		text("Choose the criteria to order the list and then press the export button to save the ordered\n"+"list into its corresponding file", 100, 550);

		mainController.drawScene(this);
	}
	
	public void mousePressed() {
		if(mouseX > 900 && mouseX < 1100 && mouseY > 70 && mouseY < 120) {
			mainController.sortByID();
			mainController.getLogic().setSortType(1);
		}
			
		if(mouseX > 900 && mouseX < 1100 && mouseY > 170 && mouseY < 220) {
			mainController.sortByAge();
			mainController.getLogic().setSortType(2);
		}
	
		if(mouseX > 900 && mouseX < 1100 && mouseY > 270 && mouseY < 320) {
			mainController.sortByName();
			mainController.getLogic().setSortType(3);
		}
	
		if(mouseX > 900 && mouseX < 1100 && mouseY > 370 && mouseY < 420) {
			mainController.sortByBreed();
			mainController.getLogic().setSortType(4);
		}
		
		if(mouseX > 450 && mouseX < 750 && mouseY > 650 && mouseY < 720) {
			try {
				mainController.exportLists(mainController.getLogic().getSortType());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		//app.rect(450, 650, 300, 70);
	}
}
