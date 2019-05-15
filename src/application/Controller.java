package application;

import java.io.File;
import java.util.List;

import javafx.scene.control.TableView;

public class Controller {
	 private Model model;
	 private TableView table;

	    public Controller(Model model) {
		this.model = model;
	    }
	    
	    public List<Student> open(File file) {    	
	    	return new FileReader().read(file);
	        }
	    public void eraseStudentsList() {
	    	model.getStudents().clear();
	        }
	    public void updateStudentsList(List<Student> students) {
	    	model.getStudents().addAll(students);
	        }
}
