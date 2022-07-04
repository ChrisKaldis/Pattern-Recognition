package kaldis.service;

import java.util.List;

import kaldis.entity.MedicalExam;

/**
 * 
 * Basic features of my API.
 *
 */
public interface IMedicalExamService {

	List<MedicalExam> findAllMedicalExams();
		
	String classifyExam( MedicalExam medicalExam );
}
