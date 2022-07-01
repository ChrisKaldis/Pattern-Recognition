package rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MedicalExamServiceTest {

	@Test
	void testClassifyExam() {
		MedicalExam medicalExamTest = new MedicalExam(false, "30-39", "premeno", "30-34", "0-2", false, 3, "left", "left_low", false);
		MedicalExamService serviceTest = new MedicalExamService();
		String answer = serviceTest.classifyExam(medicalExamTest);
		assertEquals( answer, "non-recurrent", "ok!" );
		
//		MedicalExam medicalExamTest2 = new MedicalExam(true, "60-69", "ge40", "20-24", "24-26", true, 3, "left", "left_low", true);
//		MedicalExamService serviceTest2 = new MedicalExamService();
//		String answer2 = serviceTest2.classifyExam(medicalExamTest2);
//		assertEquals( answer2, "non-recurrent", "ok!" );
	}

}
