package pattern.recognition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import rest.MedicalExam;

class PatternTest {

	@Test
	void testPattern() {
		fail("Not yet implemented");		
	}

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
		for ( int i = 0; i < answer.length; i++ ) {
			//System.out.println(myAnswer.get(i));
			assertEquals( answer[i], myAnswer.get(i), "ok" );
		}
	}

	@Test
	void testClassify() {
		fail("Not yet implemented");
	}

	@Test
	void testGetData() {
		fail("Not yet implemented");
	}

	@Test
	void testSetData() {
		fail("Not yet implemented");
	}

}
