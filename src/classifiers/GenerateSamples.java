package classifiers;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateSamples {
	private int c;
	private int d;
	private int numSamples;
	private ArrayList<CClass> cClasses;
	private JGraphAdapterDemo graph;
	
	public GenerateSamples(int c, int num, JGraphAdapterDemo graph){
		this.c = c;
		this.d = graph.getGraph().vertexSet().size();
		this.numSamples = num;
		this.cClasses = generateCClasses(c);
		this.graph = graph;
		generateSamples();
	}

	private void generateSamples() {
		ArrayList<ArrayList<Integer>> cClassSamples = new ArrayList<ArrayList<Integer>>(numSamples);
		
		ArrayList<String> features = graph.getFeatures();
		for(CClass cc : cClasses){
			for(int i = 0 ; i < numSamples;i++){
				ArrayList<Integer> cClassSample = new ArrayList<Integer>(features.size());
				
				for(int j = 0;j<features.size();j++){
					cClassSample.add(ThreadLocalRandom.current().nextInt(0, 2));
				}
				System.out.println(cClassSample);
				cClassSamples.add(cClassSample);
			}
			cc.setClassSamples(cClassSamples);
		}
		
		
	}

	private ArrayList<CClass> generateCClasses(int c) {
		ArrayList<CClass> cClasses = new ArrayList<>();
		for(int i = 0; i < c; i++){
			CClass cc = new CClass();
			cClasses.add(cc);
		}
		return cClasses;
	}
	public static void main(String[] args){
		JGraphAdapterDemo jg = new JGraphAdapterDemo(10);
		GenerateSamples gs = new GenerateSamples(4,2000,jg);
		
	}
}
