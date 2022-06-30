package pattern.recognition;

public interface Clustering {
	
	void kMeans( double[][] patterns, double[][] centers );
	
	boolean classifyPattern( double[] pattern );
	
	void calculateError();

}
