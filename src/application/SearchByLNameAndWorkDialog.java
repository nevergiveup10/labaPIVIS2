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
	InterfaceBuilder interfaceBuilder = new InterfaceBuilder();
	Table table = new Table();
	Label lastNameLabel = interfaceBuilder.lastNameLabel;
	Label workLowLimitLabel = interfaceBuilder.workLowLimitLabel;
	Label workHighLimitLabel = interfaceBuilder.workHighLimitLabel;
	TextField lastNameInsert = interfaceBuilder.lastNameInsert;
	TextField workLowLimitInsert = interfaceBuilder.workLowLimitInsert;
	TextField workHighLimitInsert = interfaceBuilder.workHighLimitInsert;
	Button search = interfaceBuilder.search;
	Button cancel = interfaceBuilder.cancel;
	Button erase = interfaceBuilder.erase;
	VBox controlBox = new VBox(interfaceBuilder.SearchByLNameAndWorkControlBox());
	Pane tablePane = table.getTable();
	AnchorPane SearchByLNameAndGNumPane = new AnchorPane(controlBox, tablePane);
	private Scene scene = new Scene(SearchByLNameAndGNumPane, 1400, 700);

	public SearchByLNameAndWorkDialog(Controller controller) {
		List<Student> searchResults = new ArrayList<>();
		List<Student> students = controller.getStudentsList();
		stage.setTitle("Поиск по фамилии и колличеству общественной работы.");
		stage.setScene(scene);
		AnchorPane.setTopAnchor(controlBox, 20.0);
		AnchorPane.setLeftAnchor(controlBox, 10.0);
		AnchorPane.setTopAnchor(controlBox, 20.0);

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
