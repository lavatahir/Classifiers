package classifiers;

import java.util.*;

public class CClass {
	private ArrayList<Integer> features;
	
	public CClass(ArrayList<Integer> givenFeatures){
		features = new ArrayList<Integer>(givenFeatures);
	}
	public ArrayList<Integer> getFeatures(){
		return features;
	}
}
