package rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pattern.recognition.Pattern;

@Service
public class MedicalExamService implements IMedicalExamService {

	List<MedicalExam> medicalExams = new ArrayList<>();
	
	public MedicalExamService() {
		super();
		medicalExams.add(new MedicalExam(false, "30-39", "Premeno", "30-34", "0-2", false, 3, "left", "left_low", false));
	}
	
	@Override
	public List<MedicalExam> findAll() {
		return medicalExams;
	}

	@Override
	public MedicalExam addExam( MedicalExam medicalExam ) {
		medicalExams.add(medicalExam);
		return medicalExam;
	}

	@Override
	public String classifyExam( MedicalExam medicalExam ) {
		Pattern p = new Pattern(medicalExam);
		p.convertMedicalExamToPattern(medicalExam);
		String response = p.classify();
		return response;
	}

}
