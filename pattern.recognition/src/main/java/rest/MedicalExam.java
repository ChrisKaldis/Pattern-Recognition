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
	
	private boolean recurrenceEvent;
	private String decade;
	private String menopause;
	private String tumorSize;
	private String invNodes;
	private boolean nodeCaps;
	private int degMalig;
	private String breast;
	private String breastQuad;
	private boolean irradiant;
	
	public MedicalExam( boolean recurrenceEvent, String decade, String menopause, String tumorSize, String invNodes,
			boolean nodeCaps, int degMalig, String breast, String breastQuad, boolean irradiant ) {
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

	public boolean isRecurrenceEvent() {
		return recurrenceEvent;
	}

	public void setRecurrenceEvent( boolean recurrenceEvent ) {
		this.recurrenceEvent = recurrenceEvent;
	}

	public String getDecade() {
		return decade;
	}

	public void setDecade( String decade ) {
		this.decade = decade;
	}

	public String getMenopause() {
		return menopause;
	}

	public void setMenopause( String menopause ) {
		this.menopause = menopause;
	}

	public String getTumorSize() {
		return tumorSize;
	}

	public void setTumorSize( String tumorSize ) {
		this.tumorSize = tumorSize;
	}

	public String getInvNodes() {
		return invNodes;
	}

	public void setInvNodes( String invNodes ) {
		this.invNodes = invNodes;
	}

	public boolean isNodeCaps() {
		return nodeCaps;
	}

	public void setNodeCaps( boolean nodeCaps ) {
		this.nodeCaps = nodeCaps;
	}

	public int getDegMalig() {
		return degMalig;
	}

	public void setDegMalig( int degMalig ) {
		this.degMalig = degMalig;
	}

	public String getBreast() {
		return breast;
	}

	public void setBreast( String breast ) {
		this.breast = breast;
	}

	public String getBreastQuad() {
		return breastQuad;
	}

	public void setBreastQuad( String breastQuad ) {
		this.breastQuad = breastQuad;
	}

	public boolean isIrradiant() {
		return irradiant;
	}

	public void setIrradiant( boolean irradiant ) {
		this.irradiant = irradiant;
	}

}
