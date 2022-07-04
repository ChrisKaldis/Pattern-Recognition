package kaldis.clustering;

/**
 * 
 * Clustering is an Interface to implement basic features of kMeans Algorithm,
 * the simplest is Lloyd's implementation. 
 *
 */
public interface Clustering {
	
	void kMeans();
	
	boolean classifyPattern( double[] pattern );
	
	void calculateError();

}
