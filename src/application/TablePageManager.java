package application;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TablePageManager {
	private List<List<Student>> pages = new ArrayList<>();
    private int currentPage;
    private int recordsOnPage;  
    private List<Student> students;
    
   /* public TablePageManager(List<Student> students) {        
          for (int i = 0; i < students.size(); i += 10) {
                pages.add(students.subList(i, Math.min(students.size(), i + 10)));
            }     
        this.students = students;
        this.currentPage = 0;
    } */
    
    public ObservableList<Student> getPage(int index) {
        ObservableList<Student> page = FXCollections.observableArrayList(pages.get(index));
        return page;
    }

    public List<List<Student>> getPages() {
        return pages;
    }
    public void update(List<Student> students, int recordsOnPage) {
    		pages.clear();
    	  for (int i = 0; i < students.size(); i += recordsOnPage) {
              pages.add(students.subList(i, Math.min(students.size(), i + recordsOnPage)));
          }     
    }
   public void update(List<Student> students) {
      		pages.clear();
      	  for (int i = 0; i < students.size(); i += 10) {
                pages.add(students.subList(i, Math.min(students.size(), i + 10)));
            }     
      this.students = students;
  //    this.currentPage = 0;
    }
}
