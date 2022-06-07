package pattern.recognition;

import java.util.ArrayList;
import java.util.List;

import rest.MedicalExam;

public class Pattern {
	
	private List<Double> data = new ArrayList<>();
	MedicalExam exam;
	
	public Pattern(MedicalExam exam) {
		super();
		this.exam = exam;

	}
	
	// methods below used to convert the instances from a MedicalExam to a data array
	public void convertMedicalExamToPattern() {
				
		insertDecadeInData();
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
	
	private void insertDecadeInData() {
		// TODO
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
		// TODO
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
		// TODO 
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
		// TODO testing
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
		// TODO testing
		boolean nodeCaps = exam.isNodeCaps();
		double x = (nodeCaps) ? 1.0 : 0.0;
		data.add(x);
		
		return ;
	}

	private void insertDegMaligData() {
		// TODO testing
		double x = exam.getDegMalig();
		data.add(x);
		
		return ;
	}

	private void insertBreastData() {
		// TODO
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
		//TODO
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
	
	private void fillingData( int num, int length ) {
		
		for (int i = 0; i < length; i++) {
			if ( i != num )
				data.add(0.0);
			else
				data.add(1.0);
		}
		
		return ;
	}
	// Uses the data array to classify the pattern
	public String classify() {
		// TODO Auto-generated method stub
		String response = "class";
		
		
		return response;
	}
	//
	public List<Double> getData() {
		return data;
	}

	public void setData( List<Double> data ) {
		this.data = data;
	}

}
