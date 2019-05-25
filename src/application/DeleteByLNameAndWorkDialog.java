package application;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeleteByLNameAndWorkDialog {
	private Stage stage = new Stage();
	Label lastNameLabel = new Label("Фамилия: ");
	Label workLowLimitLabel = new Label("Кол-во работы (нижний предел): ");
	Label workHighLimitLabel = new Label("Кол-во работы (верхний предел): ");
	TextField lastNameInsert = new TextField();
	TextField workLowLimitInsert = new TextField();
	TextField workHighLimitInsert = new TextField();
	Button delete = new Button("Удалить");
	Button cancel = new Button("Отмена");
	VBox controlBox = new VBox(10, lastNameLabel, lastNameInsert, workLowLimitLabel, workLowLimitInsert,
			workHighLimitLabel, workHighLimitInsert, delete, cancel);
	private Scene scene = new Scene(controlBox, 500, 300);
	private Controller controller;

	public DeleteByLNameAndWorkDialog(Controller controller, Table table) {
		this.controller = controller;
		List<Student> students = controller.getStudentsList();
		stage.setTitle("Удаление по фамилии и кол-ву работы.");
		stage.setScene(scene);
		
		delete.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				for (int i = 0; i < students.size(); i++) {
						for (int j = 0; j < students.get(i).getSemesterWork().size(); j++) {
							if (Integer.parseInt(students.get(i).getSemesterWork().get(j)) >= Integer
									.parseInt(workLowLimitInsert.getText())
									&& Integer.parseInt(students.get(i).getSemesterWork().get(j)) <= Integer
											.parseInt(workHighLimitInsert.getText())) {
								if (lastNameInsert.getText().equals(students.get(i).getLastName())) {
								
									students.remove(i);
							
								}
								

							}

						}
				}

				
					table.updateStudentsList(students);
				}
			

		});

		cancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();
			}
		
		});


		
	}

	public void show() {
		stage.show();
	}
}
