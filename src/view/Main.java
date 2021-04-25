package view;

import controller.MainController;
import processing.core.PApplet;

public class Main extends PApplet{

	private MainController mainController;
	
	public static void main(String[] args) {
		PApplet.main("view.Main");
	}

	public void settings() {
		size(1200,800);
	}
	
	public void setup() {
		
		mainController = new MainController(this);
	}

	public void draw() {
		background(40);
		textSize(20);
		mainController.drawScene(this);
	}
	
	public void mousePressed() {
		if(mouseX > 900 && mouseX < 1100 && mouseY > 70 && mouseY < 120) {
			mainController.sortByID();
		}
			
		if(mouseX > 900 && mouseX < 1100 && mouseY > 170 && mouseY < 220) {
			mainController.sortByAge();
		}
	
		if(mouseX > 900 && mouseX < 1100 && mouseY > 270 && mouseY < 320) {
			mainController.sortByName();
		}
	
		if(mouseX > 900 && mouseX < 1100 && mouseY > 370 && mouseY < 420) {
			mainController.sortByBreed();
		}
	}
}
