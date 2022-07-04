package kaldis.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


class PatternTest {

	/**
	 * 
	 * Checks if a Pattern that created is non empty, below 
	 * complete all cases of pattern creation. 19.8%
	 * 
	 */
	@Test
	void testPattern() {
		MedicalExam medicalExamTest = new MedicalExam("false", "30-39", "premeno", "30-34", "0-2", "no", "3", "left", "left_low", "no");
		Pattern patternTest = new Pattern(medicalExamTest);
		List<Double> emptyArray = new ArrayList<>();
		assertNotEquals(emptyArray, patternTest.getData(), "data list should not be empty.");
	}

	/**
	 * 
	 * 29.6% Coverage.
	 * 
	 */
	@Test
	void testConvertMedicalExamToPattern() {
		MedicalExam medicalExamTest = new MedicalExam("false", "30-39", "premeno", "30-34", "0-2", "no", "3", "left", "left_low", "no");
		Pattern patternTest = new Pattern(medicalExamTest);
		List<Double> myAnswer = patternTest.getData();
		double answer[] = { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // Decade
							0.0, 0.0, 1.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, // tumor size
							1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							1.0, 0.0, // node caps
							3.0, // deg malig
							0.0, // breast
							0.0, 1.0, 0.0, 0.0, 0.0, // breast quad
							0.0 }; // irradiant
		for (int i = 0; i < answer.length; i++) {
			assertEquals( answer[i], myAnswer.get(i), "wrong value in cell." );
		}
	}
	
	/**
	 * 
	 * 38.9% Coverage
	 * 
	 */
	@Test
	void testConverMedicalExamToPattern1() {
		MedicalExam medicalExamTest2 = new MedicalExam("true", "20-29", "ge40", "25-29", "3-5", "yes", "2", "right", "left_up", "yes");
		Pattern patternTest2 = new Pattern(medicalExamTest2);
		List<Double> myAnswer2 = patternTest2.getData();
		double answer2[] = { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // Decade
							0.0, 1.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // tumor size
							0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							0.0, 1.0, // node caps
							2.0, // deg malig
							1.0, // breast
							1.0, 0.0, 0.0, 0.0, 0.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer2.length; i++) {
			assertEquals( answer2[i], myAnswer2.get(i), "wrong value in cell." );
		}
	}
	
	/**
	 * 
	 * 45.8% Coverage
	 * 
	 */
	@Test
	void testConvertMedicalExamToPattern2() {
		MedicalExam medicalExamTest3 = new MedicalExam("true", "10-19", "lt40", "20-24", "6-8", "yes", "1", "right", "right_up", "yes");
		Pattern patternTest3 = new Pattern(medicalExamTest3);
		List<Double> myAnswer3 = patternTest3.getData();
		double answer3[] = { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // tumor size
							0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							0.0, 1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 1.0, 0.0, 0.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer3.length; i++) {
			assertEquals( answer3[i], myAnswer3.get(i), "wrong value in cell." );
		}
	}
	
	/**
	 * 
	 * 51.3% Coverage
	 * 
	 */
	@Test
	void testConvertMedicalExamToPattern3() {
		MedicalExam medicalExamTest4 = new MedicalExam("true", "40-49", "lt40", "15-19", "9-11", "yes", "1", "right", "right_low", "yes");
		Pattern patternTest4 = new Pattern(medicalExamTest4);
		List<Double> myAnswer4 = patternTest4.getData();
		double answer4[] = { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // tumor size
							0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							0.0, 1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 1.0, 0.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer4.length; i++) {
			assertEquals( answer4[i], myAnswer4.get(i), "wrong value in cell." );
		}
	}
	
	/**
	 * 
	 * 56.0% Coverage
	 * 
	 */
	@Test
	void testConvertMedicalExamToPattern4() {	
		MedicalExam medicalExamTest5 = new MedicalExam("true", "50-59", "lt40", "10-14", "12-14", "yes", "1", "right", "central", "yes");
		Pattern patternTest5 = new Pattern(medicalExamTest5);
		List<Double> myAnswer5 = patternTest5.getData();
		double answer5[] = { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							0.0, 1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer5.length; i++) {
			assertEquals( answer5[i], myAnswer5.get(i), "wrong value in cell." );
		}
	}
	/**
	 * 
	 * 59.7% Coverage
	 * 
	 */
	@Test
	void testConvertMedicalExamToPattern5() {
		MedicalExam medicalExamTest6 = new MedicalExam("true", "60-69", "lt40", "5-9", "15-17", "yes", "1", "right", "central", "yes");
		Pattern patternTest6 = new Pattern(medicalExamTest6);
		List<Double> myAnswer6 = patternTest6.getData();
		double answer6[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							0.0, 1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer6.length; i++) {
			assertEquals( answer6[i], myAnswer6.get(i), "wrong value in cell." );
		}
	}
		
	/**
	 * 
	 * 63.0% Coverage
	 * 
	 */
	@Test
	void testConvertMedicalExamToPattern6() {
		MedicalExam medicalExamTest7 = new MedicalExam("true", "70-79", "lt40", "0-4", "18-20", "yes", "1", "right", "central", "yes");
		Pattern patternTest7 = new Pattern(medicalExamTest7);
		List<Double> myAnswer7 = patternTest7.getData();
		double answer7[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							0.0, 1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer7.length; i++) {
			assertEquals( answer7[i], myAnswer7.get(i), "wrong value in cell." );
		}
	}
		
	/**
	 * 
	 * 65.8% Coverage
	 * 
	 */
	@Test
	void testConvertMedicalExamToPattern7() {
		MedicalExam medicalExamTest8 = new MedicalExam("true", "80-89", "lt40", "35-39", "21-23", "yes", "1", "right", "central", "yes");
		Pattern patternTest8 = new Pattern(medicalExamTest8);
		List<Double> myAnswer8 = patternTest8.getData();
		double answer8[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							0.0, 1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer8.length; i++) {
			assertEquals( answer8[i], myAnswer8.get(i), "wrong value in cell." );
		}
	}

	/**
	 * 
	 * 68.3% Coverage
	 * 
	 */
	@Test
	void testConvertMedicalExamToPattern8() {
		MedicalExam medicalExamTest9 = new MedicalExam("true", "90-99", "lt40", "40-44", "24-26", "yes", "1", "right", "central", "yes");
		Pattern patternTest9 = new Pattern(medicalExamTest9);
		List<Double> myAnswer9 = patternTest9.getData();
		double answer9[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							0.0, 1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer9.length; i++) {
			assertEquals( answer9[i], myAnswer9.get(i), "wrong value in cell." );
		}
	}
		
	/**
	 * 
	 * 70.3% Coverage
	 * 
	 */
	@Test
	void testConvertMedicalExamToPattern9() {
		MedicalExam medicalExamTest10 = new MedicalExam("true", "90-99", "lt40", "45-49", "27-29", "yes", "1", "right", "central", "yes");
		Pattern patternTest10 = new Pattern(medicalExamTest10);
		List<Double> myAnswer10 = patternTest10.getData();
		double answer10[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, // inv nodes
							0.0, 1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer10.length; i++) {
			assertEquals( answer10[i], myAnswer10.get(i), "wrong value in cell." );
		}
	}
	
	/**
	 * 
	 * 72.2% Coverage
	 * 
	 */
	@Test
	void testConvertMedicalExamToPattern10() {
		MedicalExam medicalExamTest11 = new MedicalExam("true", "90-99", "lt40", "50-54", "30-32", "yes", "1", "right", "central", "yes");
		Pattern patternTest11 = new Pattern(medicalExamTest11);
		List<Double> myAnswer11 = patternTest11.getData();
		double answer11[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, // inv nodes
							0.0, 1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer11.length; i++) {
			assertEquals( answer11[i], myAnswer11.get(i), "wrong value in cell." );
		}
	}

	/**
	 * 
	 * 73.8% Coverage
	 * 
	 */
	@Test
	void testConvertMedicalExamToPattern11() {
		MedicalExam medicalExamTest12 = new MedicalExam("true", "90-99", "lt40", "55-59", "33-35", "yes", "1", "right", "central", "yes");
		Pattern patternTest12 = new Pattern(medicalExamTest12);
		List<Double> myAnswer12 = patternTest12.getData();
		double answer12[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, // inv nodes
							0.0, 1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer12.length; i++) {
			assertEquals( answer12[i], myAnswer12.get(i), "wrong value in cell." );
		}
	}
	
	/**
	 * 
	 * 75.2% Coverage
	 * 
	 */
	@Test
	void testConvertMedicalExamToPattern12() {
		MedicalExam medicalExamTest13 = new MedicalExam("true", "90-99", "lt40", "55-59", "36-39", "yes", "1", "right", "central", "yes");
		Pattern patternTest13 = new Pattern(medicalExamTest13);
		List<Double> myAnswer13 = patternTest13.getData();
		double answer13[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, // inv nodes
							0.0, 1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer13.length; i++) {
			assertEquals( answer13[i], myAnswer13.get(i), "wrong value in cell." );
		}
	}
	
}
