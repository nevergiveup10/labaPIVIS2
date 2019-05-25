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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchByLNameAndWorkDialog {
	private Stage stage = new Stage();

	Table table = new Table();
	Label lastNameLabel = new Label("�������: ");
	Label workLowLimitLabel = new Label("���-�� ������ (������ ������): ");
	Label workHighLimitLabel = new Label("���-�� ������ (������� ������): ");
	TextField lastNameInsert = new TextField();
	TextField workLowLimitInsert = new TextField();
	TextField workHighLimitInsert = new TextField();
	Button search = new Button("�����");
	Button cancel = new Button("������");
	Button erase = new Button("��������");
	VBox controlBox = new VBox(10, lastNameLabel, lastNameInsert, workLowLimitLabel, workLowLimitInsert,
			workHighLimitLabel, workHighLimitInsert, search, cancel, erase);
	Pane tablePane = table.getTable();
	VBox tableControlPane = table.getTableControlPane();
	AnchorPane SearchByLNameAndGNumPane = new AnchorPane(controlBox, tablePane, tableControlPane);
	private Scene scene = new Scene(SearchByLNameAndGNumPane, 1400, 700);

	private Controller controller;

	public SearchByLNameAndWorkDialog(Controller controller) {
		List<Student> searchResults = new ArrayList<>();
		this.controller = controller;
		List<Student> students = controller.getStudentsList();
		stage.setTitle("����� �� ������� � ����������� ������������ ������.");
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

				for (int i = 0; i < students.size(); i++) {
					if (lastNameInsert.getText().equals(students.get(i).getLastName())) {
						for (int j = 0; j < students.get(i).getSemesterWork().size(); j++) {
							if (Integer.parseInt(students.get(i).getSemesterWork().get(j)) >= Integer
									.parseInt(workLowLimitInsert.getText())
									&& Integer.parseInt(students.get(i).getSemesterWork().get(j)) <= Integer
											.parseInt(workHighLimitInsert.getText())) {

								if (!searchResults.contains(students.get(i))) {
									searchResults.add(students.get(i));
								}

							}

						}
					}
				}

				if (!searchResults.isEmpty()) {
					table.updateStudentsList(searchResults);
				}
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
