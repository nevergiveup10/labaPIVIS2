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
	    	return new FileHandler().read(file);
	        }
	    
	    public void write (File file,List<Student> students) {    	
	    	new FileHandler().write(file, students);
	        }
	    
	    public void eraseStudentsList() {
	    	model.getStudents().clear();
	        }
	    public void updateStudentsList(List<Student> students) {
	    	model.getStudents().addAll(students);
	        }
	    
	    public void rewriteStudentsList(List<Student> students) {
	    	model.rewriteStudentsList(students);
	        }
	    
	    public List<Student> getStudentsList() {
	    	return model.getStudents();
	        }
}
