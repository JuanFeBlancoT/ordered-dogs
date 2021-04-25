package model;

import java.time.LocalDate;
import java.time.Period;

import processing.core.PApplet;

public class Dog implements Comparable<Dog>{

	private int id;
	private String name;
	private String date;
	private int day, month, year;
	private String[] dateInfo;
	private String raza;
	private int age;
	
	@SuppressWarnings("static-access")
	public Dog(int idi, String n, String d, String r, PApplet app) {
		id = idi;
		name = n;
		date = d;
		raza = r.replace("-", " ");

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
	
	
	@Override
	public int compareTo(Dog otherDog) {
		
		return id - otherDog.getId();
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
