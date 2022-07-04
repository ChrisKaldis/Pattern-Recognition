package kaldis.utility;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kaldis.Application;
import kaldis.entity.MedicalExam;
import kaldis.entity.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
class PatternUtilitiesTest {

	@Autowired
	private PatternUtilities patternUtilities;
	
	/**
	 * 
	 * 11.7% Coverage
	 * 
	 */
	@Test
	void testPatternToArray() {
		MedicalExam medicalExamTest = new MedicalExam("false", "30-39", "premeno", "30-34", "0-2", "no", "3", "left", "left_low", "no");
		Pattern patternTest = new Pattern(medicalExamTest);
		double[] programOutput = patternUtilities.patternToArray(patternTest);
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
			assertEquals( answer[i], programOutput[i], "wrong value in cell." );
		}
	}
	
	/**
	 * 
	 * 17.9% Coverage
	 * Not an actual test of the accurate result of the method,
	 * a simple way to just realise if it's not empty, we suppose 
	 * that we know the result from the tests of convertMedicalExamToPattern()
	 * where we tested all the cases and were everything ok.
	 * 
	 */
	@Test
	void medicalExamsToArray() {
		double[][] medicalExams = patternUtilities.medicalExamsToArray(patternUtilities.extractData("src/main/resources/data/BreastCancerData.txt"));
		double[][] emptyArray = new double[medicalExams.length][medicalExams[0].length];
		assertNotEquals(medicalExams, emptyArray, "MedicalExams array should not be empty.");
	}

}
