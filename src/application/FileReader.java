package application;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class FileReader {

    private SAXParserFactory factory;

    private SAXParser parser;

    public FileReader() {
	factory = SAXParserFactory.newInstance();
	try {
	    parser = factory.newSAXParser();
	} catch (ParserConfigurationException configurationError) {
	    System.out.println(configurationError.getMessage());
	} catch (SAXException SAXError) {
	    System.out.println(SAXError.getMessage());
	}
    }

    public List<Student> read(File file) {
	List<Student> students = null;
	try {
	    XMLHandler handler = new XMLHandler();
	    parser.parse(file, handler);
	    students = handler.getStudents();
	} catch (IOException IOError) {
	    System.out.println(IOError.getMessage());
	} catch (SAXException SAXError) {
	    System.out.println(SAXError.getMessage());
	}
	return students;
    }
}