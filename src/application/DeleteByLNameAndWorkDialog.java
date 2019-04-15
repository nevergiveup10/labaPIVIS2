package application;

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
	TextField lastNameInsert = new TextField ();
	TextField workLowLimitInsert = new TextField ();
	TextField workHighLimitInsert = new TextField ();
	Button delete = new Button("Удалить");
	Button cancel = new Button("Отмена");
	VBox controlBox = new VBox(10, lastNameLabel,lastNameInsert, workLowLimitLabel, workLowLimitInsert, workHighLimitLabel, workHighLimitInsert, delete, cancel);
	private Scene scene = new Scene(controlBox, 500, 300);

	private void configure() {
		stage.setTitle("Удаление по фамилии и кол-ву работы.");
		stage.setScene(scene);
	}

	public void show() {
		configure();
		stage.show();
	}
}
