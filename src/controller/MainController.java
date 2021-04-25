package controller;

import javax.swing.Box.Filler;

import model.Logic;
import processing.core.PApplet;

public class MainController {

	public final static int PX = 100;
	public final static int PY = 100;
	
	private Logic logic;
	
	public MainController(PApplet app) {
		logic = new Logic(app);
	}
	
	public void drawScene(PApplet app) {
		
		//darw buttons
		app.rect(900, 70, 200, 50);
		app.rect(900, 170, 200, 50);
		app.rect(900, 270, 200, 50);
		app.rect(900, 370, 200, 50);
		//darw button texts
		app.fill(20);
		app.text("sort by id", 950, 102);
		app.text("sort by age", 945, 202);
		app.text("sort by name", 935, 302);
		app.text("sort by breed", 930, 402);
		//draws the categories
		app.fill(255);
		app.text("id", PX, PY);
		app.text("name", PX + 100, PY);
		app.text("breed", PX + 250, PY);
		app.text("age (years)", PX + 500, PY);
		
		//darws the dogs
		for (int i = 0; i < logic.getDogs().size(); i++) {
			logic.getDogs().get(i).drawDog(app, PX, (i*50)+200);
		}
	}
	
	public void sortByID() {
		logic.sortById();
	}

	public void sortByName() {
		logic.sortByName();
	}
	
	public void sortByAge() {
		logic.sortByAge();
	}
	
	public void sortByBreed() {
		logic.sortByBreed();
	}
}
