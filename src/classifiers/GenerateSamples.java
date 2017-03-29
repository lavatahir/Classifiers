package classifiers;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

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
		ArrayList<ArrayList<Integer>> cClassSamples = new ArrayList<ArrayList<Integer>>(numSamples);
		CClass cc = cClasses.get(0);
		for(int i = 0 ; i < numSamples;i++){
			ArrayList<Integer> features = ArrayList<Integer>();
			for(int j = 0;j<d;j++){
				cClassSamples
				cc.addFeature(ThreadLocalRandom.current().nextInt(0, 2));
			}
			cClassSamples.add(cc.getFeatures());
		}
		System.out.println(cClassSamples);
		
	}

	private ArrayList<CClass> generateCClasses(int c) {
		ArrayList<CClass> cClasses = new ArrayList<>();
		for(int i = 0; i < c; i++){
			CClass cc = new CClass(new ArrayList<Integer>());
			cClasses.add(cc);
		}
		return cClasses;
	}
	public static void main(String[] args){
		GenerateSamples gs = new GenerateSamples(4,10,2000);
		
	}
}
