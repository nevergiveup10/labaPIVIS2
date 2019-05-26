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
	InterfaceBuilder interfaceBuilder = new InterfaceBuilder();
	Label lastNameLabel = interfaceBuilder.lastNameLabel;
	Label workLowLimitLabel = interfaceBuilder.workLowLimitLabel;
	Label workHighLimitLabel = interfaceBuilder.workHighLimitLabel;
	TextField lastNameInsert = interfaceBuilder.lastNameInsert;
	TextField workLowLimitInsert = interfaceBuilder.workLowLimitInsert;
	TextField workHighLimitInsert = interfaceBuilder.workHighLimitInsert;
	Button delete = interfaceBuilder.delete;
	Button cancel = interfaceBuilder.cancel;
	VBox controlBox = new VBox(interfaceBuilder.DeleteByLNameAndWorkControlBox());
	private Scene scene = new Scene(controlBox, 500, 300);

	public DeleteByLNameAndWorkDialog(Controller controller, Table table) {
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
				stage.close();
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
