package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeleteByLNameAndGNumDialog {
private Stage stage = new Stage();
Label lastNameLabel = new Label("�������: ");
Label groupNumLabel = new Label("����� ������: ");
TextField lastNameInsert = new TextField ();
TextField groupNumInsert = new TextField ();
Button delete = new Button("�������");
Button cancel = new Button("������");
VBox controlBox = new VBox(10, lastNameLabel,lastNameInsert, groupNumLabel, groupNumInsert, delete, cancel);
private Scene scene = new Scene(controlBox, 500, 250);

private void configure() {
	stage.setTitle("�������� �� ������� ��� ������ ������.");
	stage.setScene(scene);
}

public void show() {
	configure();
	stage.show();
}
}
