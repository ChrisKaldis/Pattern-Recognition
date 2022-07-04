package kaldis.entity;

import java.util.ArrayList;
import java.util.List;

import kaldis.clustering.impl.Lloyd;
import kaldis.utility.PatternUtilities;

/**
 * 
 * @author Chris Kaldis
 * 
 * <p>
 * The use of this class is to transpose MedicalExam item 
 * into some data that we can use in classification and 
 * pattern recognition using kMeans method. In order to achieve that 
 * we have to transform the String values into numerical and 
 * after that the arrayList into typical array.
 * </p>
 *
 */
public class Pattern {
	
	private List<Double> data = new ArrayList<>();
	private MedicalExam medicalExam;
	
	private PatternUtilities patternUtilities = new PatternUtilities();
	
	public Pattern( MedicalExam exam ) {
		this.medicalExam = exam;
		this.convertMedicalExamToPattern();
	}
	
	/**
	 * 
	 * Method used to convert the instances from a MedicalExam to 
	 * a data arrayList used in order to classify a pattern.
	 * 
	 */
	private void convertMedicalExamToPattern() {
		insertDecadeData();
		insertMenopauseData();
		insertTumorSizeData();
		insertInvNodesData();
		insertNodeCapsData();
		insertDegMaligData();
		insertBreastData();
		insertBreastQuadData();
		insertIrradiant();
	}
	
	private void insertDecadeData() {
		String decade = medicalExam.getDecade();
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
		}
	}
	
	private void insertMenopauseData() {
		String menopause = medicalExam.getMenopause();
		switch (menopause) {
			case "lt40":
				fillingData(0, 3);
				break;
			case "ge40":
				fillingData(1, 3);
				break;
			case "premeno":
				fillingData(2, 3);
		}
	}
	
	private void insertTumorSizeData() {
		String tumorSize = medicalExam.getTumorSize();
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
		}
	}
	
	private void insertInvNodesData() {
		String invNodes = medicalExam.getInvNodes();
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
		}
	}
	
	private void insertNodeCapsData() {
		String nodeCaps = medicalExam.getNodeCaps();
		switch (nodeCaps) {
			case "yes":
				fillingData(1, 2);
				break;
			case "no":
				fillingData(0, 2);
				break;
			case "?":
				fillingData(-1, 2);
		}
	}

	private void insertDegMaligData() {
		data.add(Double.parseDouble(medicalExam.getDegMalig()));
	}

	private void insertBreastData() {
		String breast = medicalExam.getBreast();
		switch (breast) {
			case "left":
				data.add(0.0);
				break;
			case "right":
				data.add(1.0);
		}
	}
	
	private void insertBreastQuadData() {
		String breastQuad = medicalExam.getBreastQuad();
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
			case "?":
				fillingData(-1, 5);
		}
	}

	private void insertIrradiant() {
		String irradiant = medicalExam.getIrradiant();
		switch (irradiant) {
			case "yes":
				data.add(1.0);
				break;
			case "no":
				data.add(0.0);
		}
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
	}

	/**
	 * 
	 * Uses the list with all medical exams and a kMeans implementation
	 * in order to classify the pattern.
	 * 
	 * @param medicalExams
	 * @return event
	 * 
	 */
	public String classify( List<MedicalExam> medicalExams ) {
		String response;
		Lloyd algorithm = new Lloyd(this.patternUtilities.medicalExamsToArray(medicalExams));
		algorithm.initialCenters(0, 202);
		algorithm.kMeans();
		if ( algorithm.classifyPattern(this.patternUtilities.patternToArray(this)) ) {
			response = "recurrent";
		} else {
			response = "non-recurrent";
		}
		
		return response;
	}
	
	public List<Double> getData() {
		
		return data;
	}

}
