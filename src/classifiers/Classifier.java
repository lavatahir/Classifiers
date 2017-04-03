package classifiers;

public abstract class Classifier {
	protected int fold;
	protected Sample s;
	protected Sample testSample = new Sample();
	protected Sample trainingSample = new Sample();
	protected int testIndexMax;
	
	public abstract void trainData();
	public abstract void testData();
	public abstract double findProbability();
}
