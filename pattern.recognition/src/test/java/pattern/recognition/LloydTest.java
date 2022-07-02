package pattern.recognition;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import rest.MedicalExamService;

class LloydTest {

	@Test
	void testCenters() {
		MedicalExamService exams = new MedicalExamService();
		Pattern emptyPattern = new Pattern();
		Lloyd algorithm = new Lloyd(emptyPattern.medicalExamsToArray(exams.getMedicalExams()));
		algorithm.initialCenters( 0, 202 );
		double[][] centersProgram = algorithm.getCenters();
		double[][] answer = {{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
							  0.0, 0.0, 1.0,
							  0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
							  1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
							  0.0,
							  3.0,
							  0.0,
							  0.0, 1.0, 0.0, 0.0, 0.0,
							  0.0},
							 {0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
							  0.0, 0.0, 1.0,
							  0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
							  1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
							  0.0,
							  1.0,
							  0.0,
							  0.0, 1.0, 0.0, 0.0, 0.0,
							  0.0}
							};
		for ( int i = 0; i < answer.length; i++ ) {
			for ( int j = 0; j < answer[0].length; j++ ) {
				System.out.println(answer[i][j] + " " + centersProgram[i][j]);
				assertEquals( answer[i][j], centersProgram[i][j], "ok");
			}
		}
	}
	
//	@Test
//	void testKMeans() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testClassifyPattern() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCalculateError() {
//		fail("Not yet implemented");
//	}

}
