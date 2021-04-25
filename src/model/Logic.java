package model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


import processing.core.PApplet;

public class Logic {

	//attributes
	private ArrayList<String> words;
	private String[] textS;
	private String[] textS2;
	private String[] lines;
	private ArrayList<Dog> dogs;
	private int sortType;
	
	public Logic(PApplet app) {
		
		words = new ArrayList<>();
		dogs = new ArrayList<>();
		sortType = 1;
		readFiles(app);
		
	}
	
	@SuppressWarnings("static-access")
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

	public void sortById() {
		Collections.sort(dogs);
	}
	
	public void sortByName() {
		DogNameComparator dogNC = new DogNameComparator();
		Collections.sort(dogs,dogNC);
	}
	
	public void sortByAge() {
		Comparator<Dog> ageComparator = new Comparator<Dog>() {
			@Override
			public int compare(Dog dogo1, Dog dogo2) {
				return Integer.compare(dogo1.getAge(), dogo2.getAge()) ;
			}
			
		};
		Collections.sort(dogs,ageComparator);
	}
	
	public void sortByBreed() {
		Comparator<Dog> breedComparator = new Comparator<Dog>() {
			@Override
			public int compare(Dog dogo1, Dog dogo2) {
				return dogo1.getRaza().compareTo(dogo2.getRaza());
			}
		};
		Collections.sort(dogs,breedComparator);
	}
	
	public ArrayList<Dog> getDogs() {
		return dogs;
	}

	public void exportId() throws FileNotFoundException {
		PrintWriter pwId = new PrintWriter("data/exports/dogsById");
		for (int i = 0; i < dogs.size(); i++) {
			pwId.print(dogs.get(i).toString());
		}
		pwId.close();
	}
	
	public void exportAge() throws FileNotFoundException {
		PrintWriter pwA = new PrintWriter("data/exports/dogsByAge");
		for (int i = 0; i < dogs.size(); i++) {
			pwA.print(dogs.get(i).toString());
		}
		pwA.close();
	}
		
	public void exportName() throws FileNotFoundException {
		PrintWriter pwN = new PrintWriter("data/exports/dogsByName");
		for (int i = 0; i < dogs.size(); i++) {
			pwN.print(dogs.get(i).toString());
		}
		pwN.close();
	}
		
	public void exportBreed() throws FileNotFoundException {
		PrintWriter pwB = new PrintWriter("data/exports/dogsByBreed");
		for (int i = 0; i < dogs.size(); i++) {
			pwB.print(dogs.get(i).toString());
		}
		pwB.close();
	}

	public int getSortType() {
		return sortType;
	}

	public void setSortType(int sortType) {
		this.sortType = sortType;
	}
	
	
}
