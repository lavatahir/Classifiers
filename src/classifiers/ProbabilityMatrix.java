package classifiers;

import java.util.*;

public class ProbabilityMatrix {
	ArrayList<ArrayList<Double>> probs;
	Random generator = new Random();
	public ProbabilityMatrix(int size){
		probs = new ArrayList<ArrayList<Double>>(size);
		for(int i = 0; i < size; i++){
			ArrayList<Double> rowProbs = new ArrayList<Double>();
			for(int j = 0; j < 10; j++){
				double number = Double.parseDouble(String.format( "%.2f", generator.nextDouble() * 1,2));
				rowProbs.add(number);
			}
			probs.add(rowProbs);
		}
	}
	public ArrayList<ArrayList<Double>> getProbs(){
		return probs;
	}
	
	public String toString(){
		String s = "";
		for(ArrayList<Double> probRow : probs){
			for(Double d : probRow){
				s+="\t" + d;
			}
			s+= "\n";
		}
		return s;
	}
	
	public static void main(String[] args){
		ProbabilityMatrix pm = new ProbabilityMatrix(2000);
		System.out.println(pm);
	}
}
