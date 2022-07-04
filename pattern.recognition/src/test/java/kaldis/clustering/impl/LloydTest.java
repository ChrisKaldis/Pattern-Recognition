package kaldis.clustering.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import kaldis.Application;
import kaldis.service.impl.MedicalExamService;
import kaldis.utility.PatternUtilities;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
class LloydTest {

	@Autowired
	private MedicalExamService medicalExamService;

	@Autowired
	private PatternUtilities patternUtilities;

	@Test
	void testCenters() {
		Lloyd algorithm = new Lloyd(this.patternUtilities.medicalExamsToArray(this.medicalExamService.findAllMedicalExams()));
		algorithm.initialCenters( 0, 202 );
		double[][] centersProgram = algorithm.getCenters();
		double[][] answer = {{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
							  0.0, 0.0, 1.0,
							  0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
							  1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
							  1.0, 0.0,
							  3.0,
							  0.0,
							  0.0, 1.0, 0.0, 0.0, 0.0,
							  0.0},
							 {0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
							  0.0, 0.0, 1.0,
							  0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
							  1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
							  1.0, 0.0,
							  1.0,
							  0.0,
							  0.0, 1.0, 0.0, 0.0, 0.0,
							  0.0}
							};
		for ( int i = 0; i < answer.length; i++ ) {
			for ( int j = 0; j < answer[0].length; j++ ) {
				assertEquals( answer[i][j], centersProgram[i][j], "Wrong data in cell of initial centers.");
			}
		}
	}

}
