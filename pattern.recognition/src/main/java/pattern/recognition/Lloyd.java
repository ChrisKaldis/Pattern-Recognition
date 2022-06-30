package pattern.recognition;

/**
 * 
 * @author Chris Kaldis
 *
 */
public class Lloyd implements Clustering {
	private double[][] patterns;
	private double[][] centers;

	public Lloyd( double[][] patterns ) {
		super();
		this.patterns = patterns;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * The way algorithm is developed based on paper:<i>A data-
	 * Clustering Algorithm On Distributed Memory Multiprocessors,</i>
	 * published by:<b>Inderjit S. Dhillon and Dharmendra S. Modha.</b>
	 * <span>You can read the pseudocode in page 5, Figure 1. Sequential k-means Algorithm.</span>
	 * 
	 * @param patterns
	 * @param centers
	 * 
	 */
	@Override
	public void kMeans( double[][] patterns, double[][] centers ) {
		// TODO testing
		double[][] distance = new double[287][];
		int[] argminArray = new int[287];
		double oldSSE;
		double tmpSSE;
		double SSE = Double.POSITIVE_INFINITY;
		
		do {
			tmpSSE = 0;
			oldSSE = SSE;
			
			for ( int i = 0; i < patterns.length; i++ ) {
				for ( int j = 0; j < patterns[0].length; j++ )
					distance[i][j] = distanceEucledean(patterns[i], centers[j]);
				argminArray[i] = argMin(distance[i]);
			}
			
			
			
		} while ( SSE < oldSSE ) ;
				
		return ;
	}
	
	/**
	 * 
	 * Calculates the eucledean distance between a vector 
	 * (data of a pattern) & a center.
	 * 
	 * @param vector
	 * @param center
	 * @return distance
	 * 
	 */
	private double distanceEucledean( double[] vector, double[] center ) {
		//TODO testing
		double distance = 0;
		
		for ( int i = 0; i < vector.length; i++ )
			distance += Math.pow((vector[i] - center[i]), 2.0);
		
		return Math.sqrt(distance);
	}
	
	/**
	 * 
	 * Finds the index (place) of the minimun inside a vector.
	 * 
	 * @param vector
	 * @return index
	 * 
	 */
	private int argMin( double[] vector ) {
		//TODO testing
		int index = 0;
		double min = vector[index];
		
		for ( int i = 0; i < vector.length; i++ ) {
			if ( min > vector[i] ) {
				index = i;
				min = vector[index];
			}
		}
		
		return index;
	}

	/**
	 * 
	 * Finds the center closer to the pattern and classify it 
	 * in that category. 
	 * 
	 * @param pattern as one dimension array 
	 * 
	 */
	@Override
	public boolean classifyPattern( double[] pattern ) {
		//TODO test
		boolean reccurent = false;
		double[][] centers = getCenters();
		double[] distances = new double[centers.length];
		
		for ( int i = 0; i < centers.length; i++ ) {
			distances[i] = distanceEucledean(pattern, centers[i]);
		}
		if ( argMin(distances) == 1 )
			reccurent = true;
		
		return reccurent;
	}
	
	/**
	 * 
	 * --------------------||-----WARNING-----||--------------------<br>
	 * Lloyd Algorithm will not work without initialization of centers.<br>
	 * You have to call this method in every new instance of this Class.
	 * 
	 */
	public void initialCenters() {
		//TODO test
		//written in naive way that works only for this dataset.
		
		//no recurrence events start at 0 in the current file.
		centers[0] = patterns[1];
		//recerrence events star at 202 in the current file.
		centers[1] = patterns[203];
		
		return ;
	}
	
	@Override
	public void calculateError() {
		//TODO
		return ;
	}
	
	public double[][] getCenters() {
		
		return centers;
	}
}
