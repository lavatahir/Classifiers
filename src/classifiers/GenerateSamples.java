package classifiers;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.SwingUtilities;

public class GenerateSamples {
	private int c;
	private int d;
	private int numSamples;
	private JGraphAdapterDemo graph;
	private ArrayList<Omega> omegas;
	private ProbabilityMatrix pm; 
	private ArrayList<Sample> samples;
	public GenerateSamples(int c, int num, JGraphAdapterDemo graph, ProbabilityMatrix pm){
		this.c = c;
		this.d = graph.getGraph().vertexSet().size();
		this.numSamples = num;
		this.graph = graph;
		omegas = new ArrayList<Omega>(c);
		this.pm = pm;
		samples = new ArrayList<Sample>();
	}
	public void addOmega(Omega o){
		omegas.add(o);
	}
	
	public void genSamples(){
		
		for(int i = 0; i < omegas.size() ;i++){
			Omega o = omegas.get(i);
			Sample s = new Sample();
			for(int j = 0; j < d; j++){
				ArrayList<Integer> sampleRow = new ArrayList<Integer>(d);
				ArrayList<Double> probs = pm.getProbs().get(j);
				for(int x = 0; x < d; x++){
					
					if(o.getProbs0().get(x) >= probs.get(x)){
						sampleRow.add(0);
					}
					else{
						sampleRow.add(1);
					}
					
				}
				s.addSample(sampleRow);
			}
			System.out.println(s);
			samples.add(s);
		}
		
	}
	/*
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
	*/
/*
	private ArrayList<CClass> generateCClasses(int c) {
		ArrayList<CClass> cClasses = new ArrayList<>();
		for(int i = 0; i < c; i++){
			CClass cc = new CClass();
			cClasses.add(cc);
		}
		return cClasses;
	}
	*/
	public static void main(String[] args){
		JGraphAdapterDemo jg = new JGraphAdapterDemo(10);
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                jg.createAndShowGui();
                
            }
        });
		/*
		GenerateSamples gs = new GenerateSamples(4,2000,jg);
		*/
		ProbabilityMatrix pm = new ProbabilityMatrix(2000);
		System.out.println("THIS IS PM:" +pm);
		GenerateSamples gs = new GenerateSamples(4,2000,jg,pm);
		Omega o1 = new Omega(10);
		System.out.println("THIS IS OM1:" +o1);
		gs.addOmega(o1);
		
		Omega o2 = new Omega(10);
		System.out.println("THIS IS OM2:" +o2);
		gs.addOmega(o2);
		gs.genSamples();
		
	}
}
