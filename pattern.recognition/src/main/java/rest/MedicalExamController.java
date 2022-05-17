package rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedicalExamController {

	@Autowired
	private IMedicalExamService medicalExamService;
	
	private static final Logger log = LoggerFactory.getLogger( MedicalExamController.class );

	@ApiOperation(value = "Retrieves all Medical Exams", notes = "This operation retrieves all Medical exams. ", response = MedicalExam.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = MedicalExam.class),
							@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
							@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
							@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
							@ApiResponse(code = 404, message = "Not Found", response = Error.class),
							@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
							@ApiResponse(code = 409, message = "Conflict", response = Error.class),
							@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/medicalExams/" , produces = { "application/json;charset=utf-8" }, method = RequestMethod.GET)
	public List<MedicalExam> getMedicalExams() {
		List<MedicalExam> medicalExams = medicalExamService.findAll();

		return medicalExams;
	}
	
	@ApiOperation(value = "Creates a Medical Exam", notes = "This operation creates a MedicalExam entity.", response = MedicalExam.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = MedicalExam.class),
							@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
							@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
							@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
							@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
							@ApiResponse(code = 409, message = "Conflict", response = Error.class),
							@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/medicalExam", produces = { "application/json;charset=utf-8" }, consumes = { "application/json;charset=utf-8" }, method = RequestMethod.POST)
	public ResponseEntity<MedicalExam> createMedicalExam(@ApiParam(value = "The MedicalExam to be created", required = true) @RequestBody MedicalExam exam) {
		log.info( "Will add a new medical Exam" );
		MedicalExam medicalExam = medicalExamService.addExam(exam);
		return new ResponseEntity<MedicalExam>( medicalExam, HttpStatus.OK );
	}
	
	@ApiOperation(value = "Classify a Medical Exam", notes = "This operation classify a MedicalExam entity.", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = MedicalExam.class),
							@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
							@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
							@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
							@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
							@ApiResponse(code = 409, message = "Conflict", response = Error.class),
							@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/classifyMedicalExam", produces = { "application/json;charset=utf-8" }, consumes = { "application/json;charset=utf-8" }, method = RequestMethod.POST)
	public ResponseEntity<String> classifyExam(@ApiParam(value = "MedicalExam for classification", required = true) @RequestBody MedicalExam exam) {
		log.info( "Classify MedicalExam" );
		String response = medicalExamService.classifyExam(exam);
		return new ResponseEntity<String>( response, HttpStatus.OK );
	}
}
