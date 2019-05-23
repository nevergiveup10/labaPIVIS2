package application;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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

	private Controller controller;

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

	public void saveXML(File file, List<Student> students) {
		this.students = students;		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();


			Element rootElement = doc.createElement("listStudent");
			doc.appendChild(rootElement);
			for (int i = 0; i < students.size(); i++) {
		
			Element student = doc.createElement("student");
			rootElement.appendChild(student);
			
			Element lastName = doc.createElement("last_name");
			lastName.appendChild(doc.createTextNode(students.get(i).getLastName()));
			student.appendChild(lastName);
			
			Element firtstName = doc.createElement("first_name");
			firtstName.appendChild(doc.createTextNode(students.get(i).getFirstName()));
			student.appendChild(firtstName);
			
			Element patronymic = doc.createElement("patronymic");
			patronymic.appendChild(doc.createTextNode(students.get(i).getPatronymic()));
			student.appendChild(patronymic);
			
			Element groupNumber = doc.createElement("group_number");
			groupNumber.appendChild(doc.createTextNode(students.get(i).getGroupNumber()));
			student.appendChild(groupNumber);
			
			Element socialWorks = doc.createElement("social_works");
			student.appendChild(socialWorks);
			
			for (int j = 1; j <= 10; j++) {
			Element semWork = doc.createElement("sem_work");
			Attr attrType = doc.createAttribute("num");
	         attrType.setValue(Integer.toString(j));
	         semWork.setAttributeNode(attrType);
	         semWork.appendChild(doc.createTextNode(students.get(i).getSemesterWork().get(j-1)));
	         socialWorks.appendChild(semWork);
			}
			

			}

	
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			StreamResult result = new StreamResult(file);

			transformer.transform(source, result);

			
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	}

