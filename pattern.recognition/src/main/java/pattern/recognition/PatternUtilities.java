package pattern.recognition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rest.MedicalExam;

public class PatternUtilities {
	
	public PatternUtilities() {
		
	}
	
	/**
    *
    * This method changes the data structure in order to use
    * the implementations of Clustering Interface.
    * Class Pattern takes List with medical Exam type and Lloyd
    * class use a 2-D array store data used to perform calculations.
    *
    * @param medicalExams
    * @return patterns a 2-D array with all data from medicalExams.
    *
    */
   public double[][] medicalExamsToArray( List<MedicalExam> medicalExams ) {
       double[][] patterns = new double[medicalExams.size()][patternToArray(new Pattern(medicalExams.get(0))).length];

       for ( int i = 0; i < medicalExams.size(); i++ ) {
           Pattern p = new Pattern(medicalExams.get(i));
           patterns[i] = this.patternToArray(p);
       }

       return patterns;
   }
   
   /**
   *
   * This method changes the data structure in order to use
   * the implementations of Clustering Interface.
   * Class Pattern stores data in an arrayList and Lloyd class
   * uses array.
   *
   * @return Array of numbers that are inside the arrayList data.
   *
   */
  public double[] patternToArray(Pattern pattern) {
      double[] vector = new double[pattern.getData().size()];
      for ( int i = 0; i < pattern.getData().size(); i++ )
          vector[i] = pattern.getData().get(i);

      return vector;
  }
  
  public List<MedicalExam> extractData(String path) {
      List<MedicalExam> medicalExams = new ArrayList<>();
      // code copied from url below, tested for working not effectiveness.
      // https://www.javatpoint.com/how-to-read-file-line-by-line-in-java
      // TODO testing
      try {
          FileInputStream dataInFile = new FileInputStream(path);
          Scanner text = new Scanner(dataInFile);
          while ( text.hasNextLine() ) {
              String line = text.nextLine();
              String[] data = line.split(",");
              // TODO rethink way to detect exam with missing attributes
              // exams with all attributes contain 10 items.
              if ( data.length != 10 )
                  try {
                      throw new Exception("error error error");
                  } catch (Exception e) {
                      System.out.println("10 attributes expected");
                  }
              String recurenceEvent = data[0];
              String decade = data[1];
              String menopause = data[2];
              String tumorSize = data[3];
              String invNodes = data[4];
              String nodeCaps = data[5];
              String degMalig = data[6];
              String breast = data[7];
              String breastQuad = data[8];
              String irradiant = data[9];
              medicalExams.add(new MedicalExam(recurenceEvent, decade, menopause, tumorSize, invNodes, nodeCaps, degMalig, breast, breastQuad, irradiant));
          }
          text.close();
      } catch ( IOException e ) {
          e.printStackTrace();
      }

      return medicalExams;
  }

}
