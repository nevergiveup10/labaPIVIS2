package application;

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
TextField lastNameInsert = new TextField ();
TextField groupNumInsert = new TextField ();
Button delete = new Button("Удалить");
Button cancel = new Button("Отмена");
VBox controlBox = new VBox(10, lastNameLabel,lastNameInsert, groupNumLabel, groupNumInsert, delete, cancel);
private Scene scene = new Scene(controlBox, 500, 250);

private void configure() {
	stage.setTitle("Удаление по фамилии или номеру группы.");
	stage.setScene(scene);
}

public void show() {
	configure();
	stage.show();
}
}
