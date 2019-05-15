package application;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Table {
	
	private List<Student> students;
	TableView<Student> table = new TableView();
	TableColumn<Student, String> firstName = new TableColumn<>("���");
	TableColumn<Student, String> lastName = new TableColumn<>("�������");
	TableColumn<Student, String> patronymic = new TableColumn<>("��������");
	TableColumn<Student, String> groupNumber = new TableColumn<>("������");
	TableColumn<Student, String> societyWork = new TableColumn<>("������������ ������");
	TableColumn<Student, String> sem1 = new TableColumn<>("1 ���.");
	TableColumn<Student, String> sem2 = new TableColumn<>("2 ���.");
	TableColumn<Student, String> sem3 = new TableColumn<>("3 ���.");
	TableColumn<Student, String> sem4 = new TableColumn<>("4 ���.");
	TableColumn<Student, String> sem5 = new TableColumn<>("5 ���.");
	TableColumn<Student, String> sem6 = new TableColumn<>("6 ���.");
	TableColumn<Student, String> sem7 = new TableColumn<>("7 ���.");
	TableColumn<Student, String> sem8 = new TableColumn<>("8 ���.");
	TableColumn<Student, String> sem9 = new TableColumn<>("9 ���.");
	TableColumn<Student, String> sem10 = new TableColumn<>("10 ���.");
	Pane paneForTable = new Pane(table);
	
	Button firstPageButton = new Button("������ ���.  ");
	Button previousPageButton = new Button("<");
	Button nextPageButton = new Button(">");
	Button lastPageButton = new Button("��������� ���.");

	HBox tableControlButtons = new HBox(10, firstPageButton, previousPageButton, nextPageButton,
			lastPageButton);

	Label allRecordsLabel = new Label("����� �������: ");
	Label allPagesLabel = new Label("����� �������: ");
	Label currentPageLabel = new Label("������� ��������: ");
	Label recordsNumLabel = new Label("������� �� ��������: ");

	Label allRecordsValue = new Label("0");
	Label allPagesValue = new Label("0");
	Label currentPageValue = new Label("0");
	TextField recordsNumValue = new TextField("0");

	HBox allRecordsBox = new HBox(5, allRecordsLabel, allRecordsValue);
	HBox allPagesBox = new HBox(5, allPagesLabel, allPagesValue);
	HBox currentPageBox = new HBox(5, currentPageLabel, currentPageValue);
	HBox recordsNumBox = new HBox(5, recordsNumLabel, recordsNumValue);

	VBox tableControlPane = new VBox(10, tableControlButtons, allRecordsBox, allPagesBox, currentPageBox,
			recordsNumBox);
	public Table() {
		this(new ArrayList<>());
	    }
	public Table(List<Student> students){
		societyWork.getColumns().addAll(sem1, sem2, sem3, sem4, sem5, sem6, sem7, sem8, sem9, sem10);
		table.getColumns().add(lastName);
		table.getColumns().add(firstName);
		table.getColumns().add(patronymic);		
		table.getColumns().add(groupNumber);
		table.getColumns().add(societyWork); 
		
	    lastName.setCellValueFactory(value -> new SimpleStringProperty(value.getValue().getLastName()));
	    firstName.setCellValueFactory(value -> new SimpleStringProperty(value.getValue().getFirstName()));
	    patronymic.setCellValueFactory(value -> new SimpleStringProperty(value.getValue().getPatronymic()));
	    groupNumber.setCellValueFactory(value -> new SimpleStringProperty(value.getValue().getGroupNumber()));
	    sem1.setCellValueFactory(value -> new SimpleStringProperty(value.getValue().getHoursInSem(1)));
	    sem2.setCellValueFactory(value -> new SimpleStringProperty(value.getValue().getHoursInSem(2)));
	    sem3.setCellValueFactory(value -> new SimpleStringProperty(value.getValue().getHoursInSem(3)));
	    sem4.setCellValueFactory(value -> new SimpleStringProperty(value.getValue().getHoursInSem(4)));
	    sem5.setCellValueFactory(value -> new SimpleStringProperty(value.getValue().getHoursInSem(5)));
	    sem6.setCellValueFactory(value -> new SimpleStringProperty(value.getValue().getHoursInSem(6)));
	    sem7.setCellValueFactory(value -> new SimpleStringProperty(value.getValue().getHoursInSem(7)));
	    sem8.setCellValueFactory(value -> new SimpleStringProperty(value.getValue().getHoursInSem(8)));
	    sem9.setCellValueFactory(value -> new SimpleStringProperty(value.getValue().getHoursInSem(9)));
	    sem10.setCellValueFactory(value -> new SimpleStringProperty(value.getValue().getHoursInSem(10)));
	    table.setItems(FXCollections.observableArrayList(students));
	}
	public Pane getTable() {
		return paneForTable;
			}
	
	public void updateStudentsList(List<Student> students) {
		this.students = students;
	    table.setItems(FXCollections.observableArrayList(students));

	//	this.students.addAll(students);
	//	navigation.updateStatement();
	//	navigation.setLastPage();
	    }

	public VBox getTableControlPane() {
	return tableControlPane;
}
}