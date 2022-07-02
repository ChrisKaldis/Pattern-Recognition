package pattern.recognition;

import java.util.ArrayList;
import java.util.List;

import rest.MedicalExam;

/**
 * 
 * @author Chris Kaldis
 * 
 * <p>
 * The use of this class is to transpose MedicalExam item 
 * into some data that we can use in classification and 
 * pattern recognition using KMeans Class. In order to achieve that 
 * we have to transform the String values into numerical and 
 * after that the arrayList into typical array.
 * </p>
 *
 */
public class Pattern {
	
	private List<Double> data = new ArrayList<>();
	private MedicalExam exam;
	
	public Pattern() {
		super();
	}
	
	public Pattern( MedicalExam exam ) {
		super();
		this.exam = exam;
	}
	
	/**
	 * 
	 * Method used to convert the instances from a MedicalExam to 
	 * a data arrayList used in order to classify a pattern.
	 * 
	 */
	public void convertMedicalExamToPattern() {
		insertDecadeData();
		insertMenopauseData();
		insertTumorSizeData();
		insertInvNodesData();
		insertNodeCapsData();
		insertDegMaligData();
		insertBreastData();
		insertBreastQuadData();
		insertIrradiant();
		
		return ;
	}
	
	private void insertDecadeData() {
		String decade = exam.getDecade();
		switch (decade) {
			case "10-19":
				fillingData(0, 9);
				break;
			case "20-29":
				fillingData(1, 9);
				break;
			case "30-39":
				fillingData(2, 9);
				break;
			case "40-49":
				fillingData(3, 9);
				break;
			case "50-59":
				fillingData(4, 9);
				break;
			case "60-69":
				fillingData(5, 9);
				break;
			case "70-79":
				fillingData(6, 9);
				break;
			case "80-89":
				fillingData(7, 9);
				break;
			case "90-99":
				fillingData(8, 9);
				break;
		}
		
		return ;
	}
	
	private void insertMenopauseData() {
		String menopause = exam.getMenopause();
		switch (menopause) {
			case "lt40":
				fillingData(0, 3);
				break;
			case "ge40":
				fillingData(1, 3);
				break;
			case "premeno":
				fillingData(2, 3);
				break;
		}
		
		return ;
	}
	
	private void insertTumorSizeData() {
		String tumorSize = exam.getTumorSize();
		switch (tumorSize) {
			case "0-4":
				fillingData(0, 12);
				break;
			case "5-9":
				fillingData(1, 12);
				break;
			case "10-14":
				fillingData(2, 12);
				break;
			case "15-19":
				fillingData(3, 12);
				break;
			case "20-24":
				fillingData(4, 12);
				break;
			case "25-29":
				fillingData(5, 12);
				break;
			case "30-34":
				fillingData(6, 12);
				break;
			case "35-39":
				fillingData(7, 12);
				break;
			case "40-44":
				fillingData(8, 12);
				break;
			case "45-49":
				fillingData(9, 12);
				break;
			case "50-54":
				fillingData(10, 12);
				break;
			case "55-59":
				fillingData(11, 12);
				break;
		}
		
		return ;
	}
	
	private void insertInvNodesData() {
		String invNodes = exam.getInvNodes();
		switch (invNodes) {
			case "0-2":
				fillingData(0, 13);
				break;
			case "3-5":
				fillingData(1, 13);
				break;
			case "6-8":
				fillingData(2, 13);
				break;
			case "9-11":
				fillingData(3, 13);
				break;
			case "12-14":
				fillingData(4, 13);
				break;
			case "15-17":
				fillingData(5, 13);
				break;
			case "18-20":
				fillingData(6, 13);
				break;
			case "21-23":
				fillingData(7, 13);
				break;
			case "24-26":
				fillingData(8, 13);
				break;
			case "27-29":
				fillingData(9, 13);
				break;
			case "30-32":
				fillingData(10, 13);
				break;
			case "33-35":
				fillingData(11, 13);
				break;
			case "36-39":
				fillingData(12, 13);
				break;
		}
		
		return ;
	}
	
	private void insertNodeCapsData() {
		boolean nodeCaps = exam.isNodeCaps();
		double x = (nodeCaps) ? 1.0 : 0.0;
		data.add(x);
		
		return ;
	}

	private void insertDegMaligData() {
		double x = exam.getDegMalig();
		data.add(x);
		
		return ;
	}

	private void insertBreastData() {
		String breast = exam.getBreast();
		switch (breast) {
			case "left":
				data.add(0.0);
				break;
			case "right":
				data.add(1.0);
				break;
		}
		
		return ;
	}
	
	private void insertBreastQuadData() {
		String breastQuad = exam.getBreastQuad();
		switch (breastQuad) {
			case "left_up":
				fillingData(0, 5);
				break;
			case "left_low":
				fillingData(1, 5);
				break;
			case "right_up":
				fillingData(2, 5);
				break;
			case "right_low":
				fillingData(3, 5);
				break;
			case "central":
				fillingData(4, 5);
				break;
		}
		
		return ;
	}

	private void insertIrradiant() {
		boolean irradiant = exam.isIrradiant();
		double x = (irradiant) ? 1.0 : 0.0;
		data.add(x);
		
		return ;
	}
	
	/**
	 * 
	 * It fills cells equal to length param with 0.0 and 
	 * 1.0 at the index equal with num in the data List.
	 * 
	 * @param num
	 * @param length
	 * 
	 */
	private void fillingData( int num, int length ) {
		for ( int i = 0; i < length; i++ ) {
			if ( i != num ) {
				data.add(0.0);
			} else {
				data.add(1.0);
			}
		}
		
		return ;
	}

	public String classify( List<MedicalExam> medicalExams ) {
		// Written before Lloyd Class
		// TODO rethink at testing.
		String response;
		Lloyd algorithm = new Lloyd(medicalExamsToArray(medicalExams));
		algorithm.initialCenters(0, 202);
		algorithm.kMeans();
		if ( algorithm.classifyPattern(patternToArray()) ) {
			response = "recurrent";
		} else {
			response = "non-recurrent";
		}
		
		return response;
	}
	
	/**
	 * 
	 * This method changes the data structure in order to use
	 * the implementations of Clustering Interface.
	 * Class Pattern takes List with medical Exam type and Lloyd
	 * class use a 2-D array store data used to perform calculations.
	 * 
	 * @param medicalExams
	 * @return patterns a 2-D array with all data from medicalExams.
	 * 
	 */
	public double[][] medicalExamsToArray( List<MedicalExam> medicalExams ) {
		double[][] patterns = new double[medicalExams.size()][];
		
		for ( int i = 0; i < medicalExams.size(); i++ ) {
			Pattern p = new Pattern(medicalExams.get(i));
			p.convertMedicalExamToPattern();
			patterns[i] = patternToArray();
		}
		
		return patterns;
	}
	
	/**
	 * 
	 * This method changes the data structure in order to use 
	 * the implementations of Clustering Interface.
	 * Class Pattern stores data in an arrayList and Lloyd class 
	 * uses array. 
	 * 
	 * @return Array of numbers that are inside the arrayList data.
	 * 
	 */
	public double[] patternToArray() {
		double[] vector = new double[data.size()];
		
		for ( int i = 0; i < data.size(); i++ )
			vector[i] = data.get(i);
		
		return vector;
	}
	
	public List<Double> getData() {
		
		return data;
	}

}
