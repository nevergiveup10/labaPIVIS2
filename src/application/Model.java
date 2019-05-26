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
	}

	public List<Student> getStudents() {
		return students;
	}

	public void rewriteStudentsList(List<Student> students) {
		this.students = students;
	}
}
