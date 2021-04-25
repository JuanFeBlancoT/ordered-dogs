package controller;

import java.io.FileNotFoundException;

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
		app.fill(104,242,228);
		app.rect(900, 70, 200, 50);
		app.fill(108,245,162);
		app.rect(900, 170, 200, 50);
		app.fill(245,191,132);
		app.rect(900, 270, 200, 50);
		app.fill(245,129,135);
		app.rect(900, 370, 200, 50);
		app.fill(255,221,76);
		app.rect(450, 650, 300, 70);
		//darw button texts
		app.fill(140);
		app.rect(100, 125, 620, 2);
		app.fill(20);
		app.text("sort by id", 950, 102);
		app.text("sort by age", 945, 202);
		app.text("sort by name", 935, 302);
		app.text("sort by breed", 930, 402);
		app.text("Export sorted list", 515, 695);
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

	public void exportLists(int type) throws FileNotFoundException {
		switch(type) {
		case 1:
			logic.exportId();
			break;
		case 2:
			logic.exportAge();
			break;
		case 3:
			logic.exportName();
			break;
		case 4:
			logic.exportBreed();
			break;
		}
	}

	public Logic getLogic() {
		return logic;
	}

	public void setLogic(Logic logic) {
		this.logic = logic;
	}
	
	
}
