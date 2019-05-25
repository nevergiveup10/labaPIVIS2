package application;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeleteByGNumAndWorkDialog {
	private Stage stage = new Stage();
	Label groupNumLabel = new Label("Номер группы: ");
	Label workLowLimitLabel = new Label("Кол-во работы (нижний предел): ");
	Label workHighLimitLabel = new Label("Кол-во работы (верхний предел): ");
	TextField groupNumInsert = new TextField();
	TextField workLowLimitInsert = new TextField();
	TextField workHighLimitInsert = new TextField();
	Button delete = new Button("Удалить");
	Button cancel = new Button("Отмена");
	VBox controlBox = new VBox(10, groupNumLabel, groupNumInsert, workLowLimitLabel, workLowLimitInsert,
			workHighLimitLabel, workHighLimitInsert, delete, cancel);
	private Scene scene = new Scene(controlBox, 500, 300);
	private Controller controller;
	public  DeleteByGNumAndWorkDialog(Controller controller, Table table) {
		this.controller = controller;
		List<Student> students = controller.getStudentsList();
		stage.setTitle("Удаление по номеру группы и кол-ву работы.");
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
								if (groupNumInsert.getText().equals(students.get(i).getGroupNumber())) {
								
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
