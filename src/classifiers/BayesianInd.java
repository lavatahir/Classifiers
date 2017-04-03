package classifiers;

import javax.swing.SwingUtilities;

public class BayesianInd extends Classifier{
	
	
	public BayesianInd(int fold, Sample s){
		this.fold = fold;
		this.s = s;
		this.testIndexMax = s.getSample().size() / fold;	
		
		for(int i = 0; i < testIndexMax; i++){
			testSample.addSample(s.getSample().get(i));
		}
		for(int i = testIndexMax; i < s.getSample().size(); i++){
			trainingSample.addSample(s.getSample().get(i));
		}
	}
	@Override
	public void trainData() {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public double findProbability() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void testData() {
		
		
	}
	public static void main(String[] args){
		JGraphAdapterDemo jg = new JGraphAdapterDemo(10);
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                jg.createAndShowGui();
                
            }
        });
		ProbabilityMatrix pm = new ProbabilityMatrix(2000);
		GenerateSamples gs = new GenerateSamples(1,2000,jg,pm);
		Omega o1 = new Omega(10);
		gs.addOmega(o1);
		gs.genSamples();
		
		
		BayesianInd bi = new BayesianInd(5, gs.getSamples().get(0));
		System.out.println(bi.testSample);
		System.out.println(gs.getSamples().get(0));
		
		//System.out.println(bi.trainingSample);
		
	}
}