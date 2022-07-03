package rest;

/**
 * 
 * @author Chris Kaldis
 * 
 * <p>
 * The class developed in order to store the data of 
 * the medical exams with small effort. It is also important 
 * that data stayed readable for users and programmers in 
 * this point of the program.
 * </p>
 *
 */
public class MedicalExam {
	
	private String recurrenceEvent;
	private String decade;
	private String menopause;
	private String tumorSize;
	private String invNodes;
	private String nodeCaps;
	private String degMalig;
	private String breast;
	private String breastQuad;
	private String irradiant;
	
	public MedicalExam( String recurrenceEvent, String decade, String menopause, String tumorSize, String invNodes,
			String nodeCaps, String degMalig, String breast, String breastQuad, String irradiant ) {
		super();
		this.setRecurrenceEvent(recurrenceEvent);
		this.setDecade(decade);
		this.setMenopause(menopause);
		this.setTumorSize(tumorSize);
		this.setInvNodes(invNodes);
		this.setNodeCaps(nodeCaps);
		this.setDegMalig(degMalig);
		this.setBreast(breast);
		this.setBreastQuad(breastQuad);
		this.setIrradiant(irradiant);
	}

	public String getRecurrenceEvent() {
		return recurrenceEvent;
	}

	public void setRecurrenceEvent(String recurrenceEvent) {
		this.recurrenceEvent = recurrenceEvent;
	}

	public String getDecade() {
		return decade;
	}

	public void setDecade(String decade) {
		this.decade = decade;
	}

	public String getMenopause() {
		return menopause;
	}

	public void setMenopause(String menopause) {
		this.menopause = menopause;
	}

	public String getTumorSize() {
		return tumorSize;
	}

	public void setTumorSize(String tumorSize) {
		this.tumorSize = tumorSize;
	}

	public String getInvNodes() {
		return invNodes;
	}

	public void setInvNodes(String invNodes) {
		this.invNodes = invNodes;
	}

	public String getNodeCaps() {
		return nodeCaps;
	}

	public void setNodeCaps(String nodeCaps) {
		this.nodeCaps = nodeCaps;
	}

	public String getDegMalig() {
		return degMalig;
	}

	public void setDegMalig(String degMalig) {
		this.degMalig = degMalig;
	}

	public String getBreast() {
		return breast;
	}

	public void setBreast(String breast) {
		this.breast = breast;
	}

	public String getBreastQuad() {
		return breastQuad;
	}

	public void setBreastQuad(String breastQuad) {
		this.breastQuad = breastQuad;
	}

	public String getIrradiant() {
		return irradiant;
	}

	public void setIrradiant(String irradiant) {
		this.irradiant = irradiant;
	}

}
