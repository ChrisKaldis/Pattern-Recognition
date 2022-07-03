package rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MedicalExamServiceTest {

	private MedicalExamService medicalExamService;

	@Test
	void testClassifyExam() {
		MedicalExam medicalExamTest = new MedicalExam("false", "30-39", "premeno", "30-34", "0-2", "false", "3", "left", "left_low", "false");
		String answer = this.medicalExamService.classifyExam(medicalExamTest);
		assertEquals( answer, "non-recurrent", "ok!" );
	}

}
