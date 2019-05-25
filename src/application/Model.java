package application;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private List<Student> students;

	public Model() {
		students = new ArrayList<>();
	}

	public Model(List<Student> students) {
		this.students = students;
	//	this.students = new ArrayList<>(students);
	}

	public List<Student> getStudents() {
		return students;
	//return new ArrayList<>(this.students);
	}

	public void rewriteStudentsList(List<Student> students) {
		this.students = students;
	}
}
