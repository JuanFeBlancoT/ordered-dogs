package model;

import java.util.Comparator;

public class DogNameComparator implements Comparator<Dog>{

	@Override
	public int compare(Dog dogo1, Dog dogo2) {		
		return dogo1.getName().compareTo(dogo2.getName());
	}

}
