package application;



public class SemesterWork {
	private	String[] semWork;
	public SemesterWork(String[] semWork) {
		this.semWork = semWork;
	}

	public String[] getSemWork() {
		return semWork;
	}
	
	public void setSemWork(int num, String work) {
		this.semWork [num] = work;
	}
}
