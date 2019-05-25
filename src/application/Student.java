package application;

import java.util.List;

public class Student {

	private String firstName, lastName, patronymic;

	private List<String> semesterWork;

	private String groupNumber;

	public Student(String firstName, String lastName, String patronymic, String groupNum, List<String> semesterWork) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.patronymic = patronymic;
		this.groupNumber = groupNum;
		this.semesterWork = semesterWork;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public List<String> getSemesterWork() {
		return semesterWork;
	}

	public void setSemesterWork(List<String> semesterWork) {
		this.semesterWork = semesterWork;
	}

	public String getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}

	public String getHoursInSem(int sem) {
		return semesterWork.get(sem - 1);
	}

}