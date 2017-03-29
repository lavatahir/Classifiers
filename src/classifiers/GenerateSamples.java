package classifiers;

import java.util.*;

public class GenerateSamples {
	private int c;
	private int d;
	private int numSamples;
	private ArrayList<CClass> cClasses;
	
	public GenerateSamples(int c, int d, int num){
		this.c = c;
		this.d = d;
		numSamples = num;
		cClasses = generateCClasses(c);
		generateSamples();
	}

	private void generateSamples() {
		ArrayList<ArrayList<CClass>> cClassSamples = new ArrayList<ArrayList<CClass>>();
		for(CClass cc : cClasses){
			
		}
		
	}

	private ArrayList<CClass> generateCClasses(int c) {
		ArrayList<CClass> cClasses = new ArrayList<>();
		for(int i = 0; i < c; i++){
			CClass cc = new CClass(new ArrayList<Integer>());
			cClasses.add(cc);
		}
		return cClasses;
	}
	
}
