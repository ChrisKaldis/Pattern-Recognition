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
	public void convertMedicalExamToPattern( MedicalExam e ) {
				
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

	private void insertIrradiant() {
		
		boolean irradiant = exam.isIrradiant();
		double x = (irradiant) ? 1.0 : 0.0;
		data.add(x);
		
		return ;
	}

	private void insertBreastQuadData() {
		//TODO
		String breastQuad = exam.getBreastQuad();
		switch (breastQuad) {
			case "left-up":
				fillingData(0, 5);
			case "left-low":
				fillingData(1, 5);
			case "right-up":
				fillingData(2, 5);
			case "right-low":
				fillingData(3, 5);
			case "cantral":
				fillingData(4, 5);
		}
		return ;
	}

	private void insertBreastData() {
		// TODO
		String breast = exam.getBreast();
		switch (breast) {
		case "left":
			data.add(1.0);
			data.add(0.0);
		case "right":
			data.add(1.0);
			data.add(0.0);
		}
		return ;
	}

	private void insertDegMaligData() {
		// TODO testing
		double x = exam.getDegMalig();
		data.add(x);
		
		return ;
	}

	private void insertNodeCapsData() {
		// TODO testing
		boolean nodeCaps = exam.isNodeCaps();
		double x = (nodeCaps) ? 1.0 : 0.0;
		data.add(x);
		
		return ;
	}

	private void insertInvNodesData() {
		// TODO testing
		String invNodes = exam.getInvNodes();
		switch (invNodes) {
			case "0-2":
				fillingData(0, 12);
			case "3-5":
				fillingData(1, 12);
			case "6-8":
				fillingData(2, 12);
			case "9-11":
				fillingData(3, 12);
			case "12-14":
				fillingData(4, 12);
			case "15-17":
				fillingData(5, 12);
			case "21-23":
				fillingData(6, 12);
			case "24-26":
				fillingData(7, 12);
			case "27-29":
				fillingData(8, 12);
			case "30-32":
				fillingData(9, 12);
			case "33-35":
				fillingData(10, 12);
			case "36-39":
				fillingData(11, 12);
		}
		
		return ;
	}

	private void insertTumorSizeData() {
		// TODO 
		String tumorSize = exam.getTumorSize();
		switch (tumorSize) {
			case "10-19":
				fillingData(0, 9);
			case "20-29":
				fillingData(1, 9);
			case "30-39":
				fillingData(2, 9);
			case "40-49":
				fillingData(3, 9);
			case "50-59":
				fillingData(4, 9);
			case "60-69":
				fillingData(5, 9);
			case "70-79":
				fillingData(6, 9);
			case "80-89":
				fillingData(7, 9);
			case "90-99":
				fillingData(8, 9);
		}
		
		return ;
	}

	private void insertMenopauseData() {
		// TODO
		String menopause = exam.getMenopause();
		switch (menopause) {
			case "lt40":
				fillingData(0, 3);
			case "ge40":
				fillingData(1, 3);
			case "premeno":
				fillingData(2, 3);
		}
		
		return ;
	}

	private void insertDecadeInData() {
		// TODO
		String decade = exam.getDecade();
		switch (decade) {
			case "10-19":
				fillingData(0, 9);
			case "20-29":
				fillingData(1, 9);
			case "30-39":
				fillingData(2, 9);
			case "40-49":
				fillingData(3, 9);
			case "50-59":
				fillingData(4, 9);
			case "60-69":
				fillingData(5, 9);
			case "70-79":
				fillingData(6, 9);
			case "80-89":
				fillingData(7, 9);
			case "90-99":
				fillingData(8, 9);
		}
		
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
