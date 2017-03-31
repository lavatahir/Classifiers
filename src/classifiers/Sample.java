package classifiers;

import java.util.ArrayList;

public class Sample {
	ArrayList<ArrayList<Integer>> sample;
	
	public Sample(){
		sample = new ArrayList<ArrayList<Integer>>();
	}
	public ArrayList<ArrayList<Integer>> getSample(){
		return sample;
	}
	public void addSample(ArrayList<Integer> sampleRow){
		sample.add(sampleRow);
	}
	public String toString(){
		String s = "";
		for(ArrayList<Integer> sampleRow : sample){
			for(Integer i : sampleRow){
				s+=" " + i;
			}
			s+= "\n";
		}
		return s;
	}
}
