package classifiers;

import java.text.DecimalFormat;
import java.util.*;

public class ProbabilityMatrix {
	ArrayList<ArrayList<String>> probs;
	Random generator = new Random();
	DecimalFormat df = new DecimalFormat("$#");
	public ProbabilityMatrix(int size){
		df.setMinimumFractionDigits(2);
		probs = new ArrayList<ArrayList<String>>(size);
		for(int i = 0; i < size; i++){
			ArrayList<String> rowProbs = new ArrayList<String>();
			for(int j = 0; j < 10; j++){
				
				
				String number = String.format( "%.02f", generator.nextDouble() * 1,2);
				
				rowProbs.add(number);
			}
			probs.add(rowProbs);
		}
	}
	public ArrayList<ArrayList<String>> getProbs(){
		return probs;
	}
	
	public String toString(){
		String s = "";
		for(ArrayList<String> probRow : probs){
			for(String d : probRow){
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
