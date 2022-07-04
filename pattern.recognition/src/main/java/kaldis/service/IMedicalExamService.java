package kaldis.service;

import java.util.List;

import kaldis.entity.MedicalExam;

public interface IMedicalExamService {

	List<MedicalExam> findAllMedicalExams();
		
	String classifyExam( MedicalExam medicalExam );
}
