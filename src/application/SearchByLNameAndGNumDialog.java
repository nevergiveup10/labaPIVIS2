package application;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchByLNameAndGNumDialog {
	private Stage stage = new Stage();
	List<Student> students;
	List<Student> searchResults = new ArrayList<>();
	Table table = new Table();
	Label lastNameLabel = new Label("Фамилия: ");
	Label groupNumLabel = new Label("Номер группы: ");
	TextField lastNameInsert = new TextField();
	TextField groupNumInsert = new TextField();
	Button search = new Button("Поиск");
	Button cancel = new Button("Отмена");
	Button erase = new Button("Очистить");
	VBox controlBox = new VBox(10, lastNameLabel, lastNameInsert, groupNumLabel, groupNumInsert, search, cancel, erase);
	Pane tablePane = table.getTable();
	VBox tableControlPane = table.getTableControlPane();
	AnchorPane SearchByLNameAndGNumPane = new AnchorPane(controlBox, tablePane, tableControlPane);
	private Scene scene = new Scene(SearchByLNameAndGNumPane, 1400, 700);

	private Controller controller;

	public SearchByLNameAndGNumDialog(Controller controller) {
		this.controller = controller;
		List<Student> students = controller.getStudentsList();
		stage.setTitle("Поиск по фамилии или номеру группы.");
		stage.setScene(scene);
		AnchorPane.setTopAnchor(controlBox, 20.0);
		AnchorPane.setLeftAnchor(controlBox, 10.0);
		AnchorPane.setTopAnchor(controlBox, 20.0);

		AnchorPane.setTopAnchor(tableControlPane, 450.0);
		AnchorPane.setRightAnchor(tableControlPane, 800.0);
		AnchorPane.setBottomAnchor(tableControlPane, 20.0);

		AnchorPane.setTopAnchor(tablePane, 30.0);
		AnchorPane.setRightAnchor(tablePane, 15.0);
		AnchorPane.setBottomAnchor(tablePane, 30.0);
		search.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				if (lastNameInsert.getText().isEmpty() && groupNumInsert.getText().isEmpty()) {
				}

				if (!lastNameInsert.getText().isEmpty() && !groupNumInsert.getText().isEmpty()) {
					for (int i = 0; i < students.size(); i++) {
						if (groupNumInsert.getText().equals(students.get(i).getGroupNumber())
								|| lastNameInsert.getText().equals(students.get(i).getLastName())) {
							searchResults.add(students.get(i));
							System.out.println("1");
						}
					}
				}

				if (lastNameInsert.getText().isEmpty()) {
					for (int i = 0; i < students.size(); i++) {
						if (groupNumInsert.getText().equals(students.get(i).getGroupNumber())) {
							searchResults.add(students.get(i));
							System.out.println("2");
						}
					}
				}
				if (groupNumInsert.getText().isEmpty()) {

					for (int i = 0; i < students.size(); i++) {
						if (lastNameInsert.getText().equals(students.get(i).getLastName())) {
							searchResults.add(students.get(i));
							System.out.println("3");
						}
					}
				}
				table.updateStudentsList(searchResults);

			}

		});

		cancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();
			}

		});

		erase.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				searchResults.clear();
				table.resetTable();
			}

		});

	}

	public void show() {

		stage.show();

	}
}
