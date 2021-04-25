package controller;

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
		
		app.text("id", PX, PY);
		app.text("name", PX + 100, PY);
		app.text("breed", PX + 250, PY);
		app.text("age (years)", PX + 500, PY);
		
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
