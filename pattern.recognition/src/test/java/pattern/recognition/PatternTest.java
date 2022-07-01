package pattern.recognition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import rest.MedicalExam;

class PatternTest {

	@Test
	void testPattern() {
		MedicalExam medicalExamTest = new MedicalExam(false, "30-39", "premeno", "30-34", "0-2", false, 3, "left", "left_low", false);
		Pattern patternTest = new Pattern(medicalExamTest);
		List<Double> emptyArray = new ArrayList<>();
		assertEquals(emptyArray, patternTest.getData(), "item created ok, data list is empty.");
	}

	/**
	 * 
	 * Test written to check all the switch cases in methods 
	 * called inside the convertMedicalExamToPattern method.
	 * 
	 */
	@Test
	void testConvertMedicalExamToPattern() {
		MedicalExam medicalExamTest = new MedicalExam(false, "30-39", "premeno", "30-34", "0-2", false, 3, "left", "left_low", false);
		Pattern patternTest = new Pattern(medicalExamTest);
		patternTest.convertMedicalExamToPattern();
		List<Double> myAnswer = patternTest.getData();
		double answer[] = { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // Decade
							0.0, 0.0, 1.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, // tumor size
							1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							0.0, // node caps
							3.0, // deg malig
							0.0, // breast
							0.0, 1.0, 0.0, 0.0, 0.0, // breast quad
							0.0 }; // irradiant
		for (int i = 0; i < answer.length; i++) {
			assertEquals( answer[i], myAnswer.get(i), "ok" );
		}
		
		MedicalExam medicalExamTest2 = new MedicalExam(true, "20-29", "ge40", "25-29", "3-5", true, 2, "right", "left_up", true);
		Pattern patternTest2 = new Pattern(medicalExamTest2);
		patternTest2.convertMedicalExamToPattern();
		List<Double> myAnswer2 = patternTest2.getData();
		double answer2[] = { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // Decade
							0.0, 1.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // tumor size
							0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							1.0, // node caps
							2.0, // deg malig
							1.0, // breast
							1.0, 0.0, 0.0, 0.0, 0.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer2.length; i++) {
			assertEquals( answer2[i], myAnswer2.get(i), "ok" );
		}
		
		MedicalExam medicalExamTest3 = new MedicalExam(true, "10-19", "lt40", "20-24", "6-8", true, 1, "right", "right_up", true);
		Pattern patternTest3 = new Pattern(medicalExamTest3);
		patternTest3.convertMedicalExamToPattern();
		List<Double> myAnswer3 = patternTest3.getData();
		double answer3[] = { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // tumor size
							0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 1.0, 0.0, 0.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer3.length; i++) {
			assertEquals( answer3[i], myAnswer3.get(i), "ok" );
		}
		
		MedicalExam medicalExamTest4 = new MedicalExam(true, "40-49", "lt40", "15-19", "9-11", true, 1, "right", "right_low", true);
		Pattern patternTest4 = new Pattern(medicalExamTest4);
		patternTest4.convertMedicalExamToPattern();
		List<Double> myAnswer4 = patternTest4.getData();
		double answer4[] = { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // tumor size
							0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 1.0, 0.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer4.length; i++) {
			assertEquals( answer4[i], myAnswer4.get(i), "ok" );
		}
		
		MedicalExam medicalExamTest5 = new MedicalExam(true, "50-59", "lt40", "10-14", "12-14", true, 1, "right", "central", true);
		Pattern patternTest5 = new Pattern(medicalExamTest5);
		patternTest5.convertMedicalExamToPattern();
		List<Double> myAnswer5 = patternTest5.getData();
		double answer5[] = { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer5.length; i++) {
			assertEquals( answer5[i], myAnswer5.get(i), "ok" );
		}
		
		MedicalExam medicalExamTest6 = new MedicalExam(true, "60-69", "lt40", "5-9", "15-17", true, 1, "right", "central", true);
		Pattern patternTest6 = new Pattern(medicalExamTest6);
		patternTest6.convertMedicalExamToPattern();
		List<Double> myAnswer6 = patternTest6.getData();
		double answer6[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer6.length; i++) {
			assertEquals( answer6[i], myAnswer6.get(i), "ok" );
		}
		
		MedicalExam medicalExamTest7 = new MedicalExam(true, "70-79", "lt40", "0-4", "18-20", true, 1, "right", "central", true);
		Pattern patternTest7 = new Pattern(medicalExamTest7);
		patternTest7.convertMedicalExamToPattern();
		List<Double> myAnswer7 = patternTest7.getData();
		double answer7[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer7.length; i++) {
			assertEquals( answer7[i], myAnswer7.get(i), "ok" );
		}
		
		MedicalExam medicalExamTest8 = new MedicalExam(true, "80-89", "lt40", "35-39", "21-23", true, 1, "right", "central", true);
		Pattern patternTest8 = new Pattern(medicalExamTest8);
		patternTest8.convertMedicalExamToPattern();
		List<Double> myAnswer8 = patternTest8.getData();
		double answer8[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer8.length; i++) {
			assertEquals( answer8[i], myAnswer8.get(i), "ok" );
		}
		
		MedicalExam medicalExamTest9 = new MedicalExam(true, "90-99", "lt40", "40-44", "24-26", true, 1, "right", "central", true);
		Pattern patternTest9 = new Pattern(medicalExamTest9);
		patternTest9.convertMedicalExamToPattern();
		List<Double> myAnswer9 = patternTest9.getData();
		double answer9[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, // inv nodes
							1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer9.length; i++) {
			assertEquals( answer9[i], myAnswer9.get(i), "ok" );
		}
		
		MedicalExam medicalExamTest10 = new MedicalExam(true, "90-99", "lt40", "45-49", "27-29", true, 1, "right", "central", true);
		Pattern patternTest10 = new Pattern(medicalExamTest10);
		patternTest10.convertMedicalExamToPattern();
		List<Double> myAnswer10 = patternTest10.getData();
		double answer10[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, // inv nodes
							1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer10.length; i++) {
			assertEquals( answer10[i], myAnswer10.get(i), "ok" );
		}
		
		MedicalExam medicalExamTest11 = new MedicalExam(true, "90-99", "lt40", "50-54", "30-32", true, 1, "right", "central", true);
		Pattern patternTest11 = new Pattern(medicalExamTest11);
		patternTest11.convertMedicalExamToPattern();
		List<Double> myAnswer11 = patternTest11.getData();
		double answer11[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, // inv nodes
							1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer11.length; i++) {
			assertEquals( answer11[i], myAnswer11.get(i), "ok" );
		}

		MedicalExam medicalExamTest12 = new MedicalExam(true, "90-99", "lt40", "55-59", "33-35", true, 1, "right", "central", true);
		Pattern patternTest12 = new Pattern(medicalExamTest12);
		patternTest12.convertMedicalExamToPattern();
		List<Double> myAnswer12 = patternTest12.getData();
		double answer12[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, // inv nodes
							1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer12.length; i++) {
			assertEquals( answer12[i], myAnswer12.get(i), "ok" );
		}
		
		MedicalExam medicalExamTest13 = new MedicalExam(true, "90-99", "lt40", "55-59", "36-39", true, 1, "right", "central", true);
		Pattern patternTest13 = new Pattern(medicalExamTest13);
		patternTest13.convertMedicalExamToPattern();
		List<Double> myAnswer13 = patternTest13.getData();
		double answer13[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, // Decade
							1.0, 0.0, 0.0, // Menopause
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, // tumor size
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, // inv nodes
							1.0, // node caps
							1.0, // deg malig
							1.0, // breast
							0.0, 0.0, 0.0, 0.0, 1.0, // breast quad
							1.0 }; // irradiant
		for (int i = 0; i < answer13.length; i++) {
			assertEquals( answer13[i], myAnswer13.get(i), "ok" );
		}

	}
	
}

