package rest;

import java.util.List;

public interface IMedicalExamService {

	List<MedicalExam> findAllMedicalExams();
		
	String classifyExam( MedicalExam medicalExam );
}
