package rest;

import java.util.List;

public interface IMedicalExamService {

	List<MedicalExam> findAll();
	
	MedicalExam addExam( MedicalExam medicalExam );
	
	String classifyExam( MedicalExam medicalExam );
}
