package pattern.recognition;

public interface Clustering {
	
	void kMeans( double[][] patterns );
	
	boolean classifyPattern( double[] pattern );
	
	void calculateError();

}
