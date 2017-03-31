package classifiers;

import java.util.*;

public class Omega {

	private ArrayList<Double> probs0;
	private ArrayList<Double> probs1;
	private Random generator = new Random();
	
	public Omega(int size){
		probs0 = new ArrayList<Double>(size);
		probs1 = new ArrayList<Double>(size);
		for(int i = 0; i < size; i++){
			double number = Double.parseDouble(String.format( "%.2f", generator.nextDouble() * 1,2));
			probs0.add(number);
			probs1.add(Double.parseDouble(String.format( "%.2f", 1-number,2)));
		}
		
	}
	public ArrayList<Double> getProbs0(){
		return probs0;
	}
	public ArrayList<Double> getProbs1(){
		return probs1;
	}
	public String toString(){
		String s = "Pr(0): [ ";
		for(Double d : probs0){
			s+= d + " ";
		}
		s+= "]";
		return s;
	}
	public static void main(String[] args){
		Omega o = new Omega(10);
		System.out.println(o.getProbs0());
		System.out.println(o.getProbs1());
	}
	
}
