package pattern.recognition;

/**
 * 
 * @author Chris Kaldis
 *
 */
public class Lloyd implements Clustering {
	// Based on the current data the size of array is (285,46).
	private final int SIZE;
	private final int LENGTH;
	private static int CENTER = 2;
	private double[][] patterns;
	private double[][] centers;

	public Lloyd( double[][] patterns ) {
		this.SIZE = patterns.length;
		this.LENGTH = patterns[0].length;
		this.patterns = patterns;
		this.centers = new double[CENTER][LENGTH];
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * The way algorithm is developed based on paper:<i>A data-
	 * Clustering Algorithm On Distributed Memory Multiprocessors,</i>
	 * published by:<b>Inderjit S. Dhillon and Dharmendra S. Modha.</b>
	 * <span>You can read the pseudocode in page 5, Figure 1. 
	 * Sequential k-means Algorithm.</span>
	 * 
	 */
	@Override
	public void kMeans() {
		// TODO Να βάλω κάρτα για πάρω τηλ τη Ζωή.
		double[][] distance = new double[SIZE][LENGTH];
		int[] argminArray = new int[SIZE];
		double SSE = Double.POSITIVE_INFINITY;
		double oldSSE, tmpSSE;
		do {
			tmpSSE = 0.0;
			oldSSE = SSE;
			// initial step, finds nearest mean for every pattern
			for ( int i = 0; i < SIZE; i++ ) {
				for ( int j = 0; j < CENTER; j++ )
					distance[i][j] = distanceEucledean(patterns[i], this.centers[j]);
				argminArray[i] = argMin(distance[i]);
			}
			// initialization of arrays used for recalculating means
			double[][] y = new double[CENTER][LENGTH];
			double[][] z = new double[CENTER][LENGTH];
			for ( int i = 0; i < CENTER; i++ ) {
				for ( int j = 0; j < LENGTH; j++ ) {
					y[i][j] = 0.0;
					z[i][j] = 0.0;
				}
			}
			// update step, recalculate means
			for ( int i = 0; i < SIZE; i++ ) {
				int index = argminArray[i];
				for ( int k = 0; k < LENGTH; k++ ) {
					y[index][k] += patterns[i][k];
					z[index][k] += 1.0;
				}
				tmpSSE += distanceEucledean(patterns[i], this.centers[argminArray[i]]);
			}
			for ( int j = 0; j < this.centers.length; j++ ) {
				for ( int k = 0; k < this.centers[0].length; k++ ) {
					this.centers[j][k] = y[j][k]/z[j][k];
				}
			}
			SSE = tmpSSE;
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
		//TODO tests
		double distance = 0.0;
		
		for ( int i = 0; i < vector.length; i++ )
			distance += Math.pow((vector[i] - center[i]), 2.0);
		
		return Math.sqrt(distance);
	}
	
	/**
	 * 
	 * Finds the index of the minimun value in vector's cells.
	 * 
	 * @param vector
	 * @return index
	 * 
	 */
	private int argMin( double[] vector ) {
		//TODO tests
		int index = 0;
		double min = vector[index];
		
		for ( int i = 0; i < vector.length; i++ ) {
			if ( min > vector[i] ) {
				index = i;
				min = vector[i];
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
		double[] distances = new double[this.centers.length];
		
		for ( int i = 0; i < this.centers.length; i++ ) {
			distances[i] = distanceEucledean(pattern, this.centers[i]);
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
	public void initialCenters( int num1, int num2 ) {
		//TODO test
		double[][] initialCenters = new double[CENTER][LENGTH];
		//no recurrence events start at 0 in the current file.
		initialCenters[0] = patterns[num1];
		//recerrence events star at 202 in the current file.
		initialCenters[1] = patterns[num2];
		
		setCenters(initialCenters);
		
		return ;
	}
	
	@Override
	public void calculateError() {
		//TODO
		double[][] distancesForError = new double[SIZE][CENTER];
		for ( int i = 0; i < SIZE; i++ ) {
			for ( int j = 0; j < CENTER; j++)
			distancesForError[i][j] = distanceEucledean(patterns[i], centers[j]); 
		}
		
		int error = 0;
		for ( int i = 0; i < SIZE; i++ ) {
			if ( argMin(distancesForError[i]) == 1 && i < 202 )
				error += 1;
			else if ( argMin(distancesForError[i]) == 0 && i > 201 )
				error += 1;
		}
		System.out.println(error);
		
		return ;
	}
	
	public double[][] getCenters() {
		
		return this.centers;
	}
	
	public void setCenters( double[][] array ) {
		this.centers = array;
		
		return ;
	}
}
