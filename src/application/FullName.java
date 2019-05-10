package application;

public class FullName {
	private String firstName, lastName, patronymic;
	
	public FullName(String firstName, String lastName, String patronymic, String groupNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.patronymic = patronymic;
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
}