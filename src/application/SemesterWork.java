package application;



public class SemesterWork {
	int[] semWork;
	public SemesterWork() {
		semWork = new int[10];
	}

	public int[] getSemWork() {
		return semWork;
	}
	
	public void setSemWork(int num, int work) {
		this.semWork [num] = work;
	}
}
