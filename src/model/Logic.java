package model;

import java.util.ArrayList;
import java.util.Arrays;

import processing.core.PApplet;

public class Logic {

	//attributes
	private ArrayList<String> words;
	private String[] textS;
	private String[] textS2;
	private String[] lines;
	private ArrayList<Dog> dogs;
	
	
	public Logic(PApplet app) {
		
		words = new ArrayList<>();
		dogs = new ArrayList<>();
		readFiles(app);
		
	}
	
	public void readFiles(PApplet app) {
		//add to the arrays each line of the .txt
		textS = app.loadStrings("data/imports/import1.txt");
		textS2 = app.loadStrings("data/imports/import2.txt");
		
		//arange the seconf array (the one that is not ordered)
		Arrays.sort(textS2);
		
		//add the content on the first array to the second per each line
		for (int i = 0; i < textS.length; i++) {
			textS2[i]+=textS[i];
		}			
		
		//separate the array with all the info into words
		for (int i = 0; i < textS.length; i++) {
			lines = app.split(textS2[i], " ");
			for (int j = 0; j < lines.length; j++) {
				words.add(lines[j]);
			}
		}
		

		createDogs(app);		
	}
	
	public void createDogs(PApplet app) {
		
		for (int i = 0; i < words.size(); i+=6) {
			
			int id = Integer.parseInt(words.get(i));
			String raza = words.get(i+1);
			String bDate = words.get(i+2);
			String name = words.get(i+4);
			
			Dog dog = new Dog (id, name, bDate, raza, app);
			dogs.add(dog);
		}
	}

	public ArrayList<Dog> getDogs() {
		return dogs;
	}

	
}