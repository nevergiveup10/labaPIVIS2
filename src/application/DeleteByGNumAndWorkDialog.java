package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeleteByGNumAndWorkDialog {
	private Stage stage = new Stage();
	Label groupNumLabel = new Label("����� ������: ");
	Label workLowLimitLabel = new Label("���-�� ������ (������ ������): ");
	Label workHighLimitLabel = new Label("���-�� ������ (������� ������): ");
	TextField groupNumInsert = new TextField ();
	TextField workLowLimitInsert = new TextField ();
	TextField workHighLimitInsert = new TextField ();
	Button delete = new Button("�������");
	Button cancel = new Button("������");
	VBox controlBox = new VBox(10, groupNumLabel,groupNumInsert, workLowLimitLabel, workLowLimitInsert, workHighLimitLabel, workHighLimitInsert, delete, cancel);
	private Scene scene = new Scene(controlBox, 500, 300);

	private void configure() {
		stage.setTitle("�������� �� ������ ������ � ���-�� ������.");
		stage.setScene(scene);
	}

	public void show() {
		configure();
		stage.show();
	}
}
