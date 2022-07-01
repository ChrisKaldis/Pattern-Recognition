package rest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import pattern.recognition.Pattern;

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

	List<MedicalExam> medicalExams = new ArrayList<>();
	
	public MedicalExamService() {
		super();
		readData("src/main/resources/data/BreastCancerData.txt");
	}
	
	/**
	 * 
	 * Reads a file line by line & traspose the medical 
	 * exams into patterns.
	 * 
	 * @param fileName it is a String with the path of 
	 * the .txt file.
	 * 
	 */
	private void readData( String fileName ) {
		// code copied from url below, tested for working not effectiveness.
		// https://www.javatpoint.com/how-to-read-file-line-by-line-in-java
		// TODO testing
		try {
			FileInputStream dataInFile = new FileInputStream(fileName);
			Scanner text = new Scanner(dataInFile);
			while ( text.hasNextLine() ) {
				String line = text.nextLine();
				String[] data = line.split(",");
				appendExamInMedicalExamList(data);
			}
			text.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		
		return ;
	}
	
	/**
	 * 
	 * Takes a line by the .txt file and creates a 
	 * medicalExam instance.
	 * 
	 * @param data array that stores the medical exam attributes from 
	 * the file as Strings.
	 * 
	 */
	private void appendExamInMedicalExamList( String[] data ) {
		// TODO rethink way to detect exam with missing attributes
		// exams with all attributes contain 10 items.
		if ( data.length != 10 )
			return ;
		boolean recurenceEvent = (data[0].equals("recurrence-events")) ? true : false;
		String decade = data[1];
		String menopause = data[2];
		String tumorSize = data[3];
		String invNodes = data[4];
		boolean nodeCaps = (data[5].equals("right")) ? true : false;
		int degMalig = 0;
		try { 
			degMalig = Integer.parseInt(data[6]);
		} catch ( NumberFormatException e ) { 
			e.printStackTrace();
		}
		String breast = data[7];
		String breastQuad = data[8];
		boolean irradiant = (data[9].equals("yes")) ? true : false;
		medicalExams.add(new MedicalExam(recurenceEvent, decade, menopause, tumorSize, invNodes, nodeCaps, degMalig, breast, breastQuad, irradiant));

		return ;
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
		p.convertMedicalExamToPattern();
		String response = p.classify(medicalExams);
		
		return response;
	}

}
