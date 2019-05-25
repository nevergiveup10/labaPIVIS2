package application;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
	private int currentPage;
	private int recordsOnPage;
	private List<Student> students;
	TablePageManager tablePageManager = new TablePageManager();
	TableView<Student> table = new TableView();
	TableColumn<Student, String> firstName = new TableColumn<>("Имя");
	TableColumn<Student, String> lastName = new TableColumn<>("Фамилия");
	TableColumn<Student, String> patronymic = new TableColumn<>("Отчество");
	TableColumn<Student, String> groupNumber = new TableColumn<>("Группа");
	TableColumn<Student, String> societyWork = new TableColumn<>("Общественная работа");
	TableColumn<Student, String> sem1 = new TableColumn<>("1 сем.");
	TableColumn<Student, String> sem2 = new TableColumn<>("2 сем.");
	TableColumn<Student, String> sem3 = new TableColumn<>("3 сем.");
	TableColumn<Student, String> sem4 = new TableColumn<>("4 сем.");
	TableColumn<Student, String> sem5 = new TableColumn<>("5 сем.");
	TableColumn<Student, String> sem6 = new TableColumn<>("6 сем.");
	TableColumn<Student, String> sem7 = new TableColumn<>("7 сем.");
	TableColumn<Student, String> sem8 = new TableColumn<>("8 сем.");
	TableColumn<Student, String> sem9 = new TableColumn<>("9 сем.");
	TableColumn<Student, String> sem10 = new TableColumn<>("10 сем.");
	Pane paneForTable = new Pane(table);

	Button firstPageButton = new Button("Первая стр.  ");
	Button previousPageButton = new Button("<");
	Button nextPageButton = new Button(">");
	Button lastPageButton = new Button("Последняя стр.");
	Button recordsNumButton = new Button("Применить");

	HBox tableControlButtons = new HBox(10, firstPageButton, previousPageButton, nextPageButton, lastPageButton);

	Label allRecordsLabel = new Label("Всего записей: ");
	Label allPagesLabel = new Label("Всего страниц: ");
	Label currentPageLabel = new Label("Текущая страница: ");
	Label recordsNumLabel = new Label("Записей на странице: ");

	Label allRecordsValue = new Label("0");
	Label allPagesValue = new Label("0");
	Label currentPageValue = new Label("0");
	TextField recordsNumValue = new TextField("0");

	HBox allRecordsBox = new HBox(5, allRecordsLabel, allRecordsValue);
	HBox allPagesBox = new HBox(5, allPagesLabel, allPagesValue);
	HBox currentPageBox = new HBox(5, currentPageLabel, currentPageValue);
	HBox recordsNumBox = new HBox(5, recordsNumLabel, recordsNumValue, recordsNumButton);

	VBox tableControlPane = new VBox(10, tableControlButtons, allRecordsBox, allPagesBox, currentPageBox,
			recordsNumBox);

	public Table() {
		this(new ArrayList<>());
	}

	public Table(List<Student> students) {

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

	private void tableControl(List<Student> students) {
		// TablePageManager tablePageManager = new TablePageManager(students);

		tablePageManager.update(students);
		table.setItems(tablePageManager.getPage(0));

		recordsNumValue.setText(Integer.toString(tablePageManager.getPage(currentPage).size()));
		currentPageValue.setText("1");
		allPagesValue.setText(Integer.toString(tablePageManager.getPages().size()));

		recordsNumValue.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					recordsNumValue.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		firstPageButton.setOnAction(event -> {
			table.setItems(tablePageManager.getPage(0));
			currentPage = 0;
			currentPageValue.setText(Integer.toString(currentPage + 1));

		});

		previousPageButton.setOnAction(event -> {
			if (currentPage == 0) {
			} else {
				table.setItems(tablePageManager.getPage(currentPage - 1));
				currentPage = currentPage - 1;
				currentPageValue.setText(Integer.toString(currentPage + 1));
			}
		});

		nextPageButton.setOnAction(event -> {
			if (currentPage == tablePageManager.getPages().size() - 1) {

			} else {
				table.setItems(tablePageManager.getPage(currentPage + 1));
				currentPage = currentPage + 1;
				currentPageValue.setText(Integer.toString(currentPage + 1));
			}
		});

		lastPageButton.setOnAction(event -> {
			table.setItems(tablePageManager.getPage(tablePageManager.getPages().size() - 1));
			currentPage = tablePageManager.getPages().size() - 1;
			currentPageValue.setText(Integer.toString(tablePageManager.getPages().size()));
		});

		recordsNumButton.setOnAction(event -> {
			recordsOnPage = Integer.parseInt(recordsNumValue.getText());
			tablePageManager.update(students, recordsOnPage);
			currentPage = 0;
			table.setItems(tablePageManager.getPage(0));
			currentPageValue.setText(Integer.toString(currentPage + 1));
			recordsNumValue.setText(Integer.toString(tablePageManager.getPage(0).size()));
			allPagesValue.setText(Integer.toString(tablePageManager.getPages().size()));
		});

	}

	public void resetTable() {
		table.getItems().clear();
		allRecordsValue.setText("0");
		allPagesValue.setText("0");
		currentPageValue.setText("0");
		recordsNumValue.setText("0");
	}

	public Pane getTable() {
		return paneForTable;
	}

	public void updateStudentsList(List<Student> students) {
		this.students = students;
		tableControl(students);
		allRecordsValue.setText(Integer.toString(students.size()));
	}

	public VBox getTableControlPane() {
		return tableControlPane;
	}
}