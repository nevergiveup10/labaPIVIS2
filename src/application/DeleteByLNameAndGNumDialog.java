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

public class DeleteByLNameAndGNumDialog {
	
	private Stage stage = new Stage();
	Label lastNameLabel = new Label("Фамилия: ");
	Label groupNumLabel = new Label("Номер группы: ");
	TextField lastNameInsert = new TextField();
	TextField groupNumInsert = new TextField();
	Button delete = new Button("Удалить");
	Button cancel = new Button("Отмена");
	VBox controlBox = new VBox(10, lastNameLabel, lastNameInsert, groupNumLabel, groupNumInsert, delete, cancel);
	private Scene scene = new Scene(controlBox, 500, 250);
	private Controller controller;

	public DeleteByLNameAndGNumDialog(Controller controller, Table table) {
		this.controller = controller;
		List<Student> students = controller.getStudentsList();
		stage.setTitle("Удаление по фамилии или номеру группы.");
		stage.setScene(scene);

		delete.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
			if (!lastNameInsert.getText().isEmpty()) {
				for (int i = 0; i<students.size(); i++) {
				if(students.get(i).getLastName().equals(lastNameInsert.getText())) {
					students.remove(i);
				}
				}
			}
			if (!groupNumLabel.getText().isEmpty())
				for (int i = 0; i<students.size(); i++) {
					if(students.get(i).getGroupNumber().equals(groupNumInsert.getText())) {
						students.remove(i);
				}
			}
			
			
			if (!groupNumLabel.getText().isEmpty() && !lastNameInsert.getText().isEmpty()) {
				for (int i = 0; i<students.size(); i++) {
					if(students.get(i).getGroupNumber().equals(groupNumInsert.getText())) {
						students.remove(i);				
					}
					if(students.get(i).getLastName().equals(lastNameInsert.getText())) {
						students.remove(i);
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
