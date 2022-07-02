package pattern.recognition;

public interface Clustering {
	
	void kMeans();
	
	boolean classifyPattern( double[] pattern );
	
	void calculateError();

}
