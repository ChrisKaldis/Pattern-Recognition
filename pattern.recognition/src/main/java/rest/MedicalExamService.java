package rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pattern.recognition.Pattern;
import pattern.recognition.PatternUtilities;

/**
 * 
 * @author Chris Kaldis
 * 
 * <p>
 * Code is based on the basic REST API developed in a lab.
 * The constructor calls two functions in order to store
 * the data from the txt. Also it implements the methods 
 * described in the interface used in our controller.
 * </p>
 * 
 */
@Service
public class MedicalExamService implements IMedicalExamService {

	@Autowired
	private PatternUtilities patternUtilities;
	
	public MedicalExamService() {
		
	}

	/**
	 * 
	 * Reads a file line by line and transpose the medical medical
	 * exams into pattern instances.
	 * 
	 */
	@Override
	public List<MedicalExam> findAllMedicalExams() {
		return this.patternUtilities.extractData("src/main/resources/data/BreastCancerData.txt");
	}

	@Override
	public String classifyExam( MedicalExam medicalExam ) {
		Pattern p = new Pattern(medicalExam);
		String response = p.classify(this.findAllMedicalExams());
		
		return response;
	}

}
