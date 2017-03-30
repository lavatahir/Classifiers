package classifiers;

import java.util.*;

public class CClass {
	private ArrayList<ArrayList<Integer>>classSamples;
	
	public CClass(){
		classSamples = new ArrayList<ArrayList<Integer>>();
	}
	
	public void setClassSamples(ArrayList<ArrayList<Integer>> cClassSamples) {
		classSamples.addAll(cClassSamples);	
	}

	public ArrayList<ArrayList<Integer>> getClassSamples() {
		return classSamples;
	}
	
}
