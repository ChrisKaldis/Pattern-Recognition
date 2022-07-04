package kaldis.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import kaldis.entity.MedicalExam;
import kaldis.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
class MedicalExamServiceTest {

	@Autowired
	private MedicalExamService medicalExamService;

	@Test
	void testClassifyExam() {
		MedicalExam medicalExamTest = new MedicalExam("false", "30-39", "premeno", "30-34", "0-2", "no", "3", "left", "left_low", "no");
		String answer = this.medicalExamService.classifyExam(medicalExamTest);
		assertEquals( answer, "non-recurrent", "wrong in classification!" );
	}

}
