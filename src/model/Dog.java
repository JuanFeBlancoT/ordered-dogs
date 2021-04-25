package model;

import java.time.LocalDate;
import java.time.Period;

import processing.core.PApplet;

public class Dog {

	private int id;
	private String name;
	private String date;
	private int day, month, year;
	private String[] dateInfo;
	private String raza;
	private int age;
	
	public Dog(int idi, String n, String d, String r, PApplet app) {
		id = idi;
		name = n;
		date = d;
		raza = r;
		
		//
		dateInfo = app.split(date, "-");
		day = Integer.parseInt(dateInfo[0]);
		month = Integer.parseInt(dateInfo[1]);
		year = Integer.parseInt(dateInfo[2]);
		LocalDate today = LocalDate.now();
		LocalDate birthDate = LocalDate.of(year, month, day);
		age = Period.between(birthDate, today).getYears();
		
	}
	
	public void drawDog(PApplet app, int px, int py) {
		app.fill(255);
		app.text(id, px, py);
		app.text(name, px + 100, py);
		app.text(raza, px + 250, py);
		app.text(age, px + 500, py);
	}
}
