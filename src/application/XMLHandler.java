package application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {

	    private List<Student> students;

	    private String lastElement;

	    private String firstName;

	    private String lastName;

	    private String patronymic;

	    private String groupNum;

	    private List<String> semWork = new ArrayList<String>();
	    
	    private int num;


	    public XMLHandler() {
		students = new LinkedList<>();
	    }

	    public List<Student> getStudents() {
		return students;
	    }

	    @Override
	    public void startElement(String uri, String localName, String qName, Attributes attributes) {
	     if (qName.equals("sem_work")) {
	              num = Integer.parseInt(attributes.getValue("num"));	              
	        }  
		lastElement = qName;
		
	    }

	    @Override
	    public void characters(char[] ch, int start, int length) {
		String information = new String(ch, start, length);
		information = information.replace("\n", "").trim();
		if (!information.isEmpty()) {
		 
			if (lastElement.equals("last_name")) {
				lastName = information;
			}
		    if (lastElement.equals("first_name")) {
			firstName = information;
		    }
		    if (lastElement.equals("patronymic")) {
			patronymic = information;
		    }
		    if (lastElement.equals("group_number")) {
		    groupNum = information;
		    }
		    
		   if (lastElement.equals("sem_work")) {
		    	
	    	semWork.add(num - 1, information);
		    	
		    } 

		}
	    }

	    @Override
	    public void endElement(String uri, String localName, String qName) {
		if (qName.equals("student")) {	   
			Student student = new Student(firstName, lastName, patronymic, groupNum, semWork);
		    students.add(student);
		    semWork = null;
		    semWork = new ArrayList<>();

		}
	    }
	}