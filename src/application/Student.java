package application;

public class Student {

    private FullName fullName;

    private SemesterWork semesterWork;
    
    private GroupNumber groupNumber;
    

    public Student(FullName fullName, SemesterWork semesterWork, GroupNumber groupNumber) {
	this.fullName = fullName;
	this.semesterWork = semesterWork;
	this.groupNumber = groupNumber;
    }

    public FullName getFullname() {
	return fullName;
    }

    public void setFullname(FullName fullName) {
	this.fullName = fullName;
    }

    public SemesterWork getSemesterWork() {
	return semesterWork;
    }

    public void setSemesterWork(SemesterWork semesterWork) {
	this.semesterWork = semesterWork;
    }
    
    public GroupNumber getGroupNumber() {
    	return groupNumber;
    }

        public void setGroupNumber(GroupNumber groupNumber) {
    	this.groupNumber = groupNumber;
        }
    
}