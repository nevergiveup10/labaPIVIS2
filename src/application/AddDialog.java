package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddDialog {
	Controller controller;

	private String firstName;

	private String lastName;

	private String patronymic;

	private String groupNum;

	private List<String> semWork = new ArrayList<String>();

	private Stage addStage = new Stage();

	private Button add = new Button("Добавить");
	private Button cancel = new Button("Отмена");
	private HBox buttonBox = new HBox(10, add, cancel);

	private Label lastNameLabel = new Label("Фамилия:");
	private Label nameLabel = new Label("Имя:");
	private Label patronymicLabel = new Label("Фамилия:");
	private Label groupNumLabel = new Label("Номер группы:");
	private Label societyWorkLabel1 = new Label("О.р. за 1 сем.:");
	private Label societyWorkLabel2 = new Label("О.р. за 2 сем.:");
	private Label societyWorkLabel3 = new Label("О.р. за 3 сем.:");
	private Label societyWorkLabel4 = new Label("О.р. за 4 сем.:");
	private Label societyWorkLabel5 = new Label("О.р. за 5 сем.:");
	private Label societyWorkLabel6 = new Label("О.р. за 6 сем.:");
	private Label societyWorkLabel7 = new Label("О.р. за 7 сем.:");
	private Label societyWorkLabel8 = new Label("О.р. за 8 сем.:");
	private Label societyWorkLabel9 = new Label("О.р. за 9 сем.:");
	private Label societyWorkLabel10 = new Label("О.р. за 10 сем.:");
	private VBox labelBox = new VBox(15, lastNameLabel, nameLabel, patronymicLabel, groupNumLabel, societyWorkLabel1,
			societyWorkLabel2, societyWorkLabel3, societyWorkLabel4, societyWorkLabel5, societyWorkLabel6,
			societyWorkLabel7, societyWorkLabel8, societyWorkLabel9, societyWorkLabel10);

	private TextField lastNameInsert = new TextField();
	private TextField firstNameInsert = new TextField();
	private TextField patronymicInsert = new TextField();
	private TextField groupNumInsert = new TextField();
	private TextField societyWorkInsert1 = new TextField();
	private TextField societyWorkInsert2 = new TextField();
	private TextField societyWorkInsert3 = new TextField();
	private TextField societyWorkInsert4 = new TextField();
	private TextField societyWorkInsert5 = new TextField();
	private TextField societyWorkInsert6 = new TextField();
	private TextField societyWorkInsert7 = new TextField();
	private TextField societyWorkInsert8 = new TextField();
	private TextField societyWorkInsert9 = new TextField();
	private TextField societyWorkInsert10 = new TextField();
	private VBox textInsertBox = new VBox(5, lastNameInsert, firstNameInsert, patronymicInsert, groupNumInsert,
			societyWorkInsert1, societyWorkInsert2, societyWorkInsert3, societyWorkInsert4, societyWorkInsert5,
			societyWorkInsert6, societyWorkInsert7, societyWorkInsert8, societyWorkInsert9, societyWorkInsert10);

	private AnchorPane addDialogPane = new AnchorPane(labelBox, textInsertBox, buttonBox);
	private Scene addScene = new Scene(addDialogPane, 320, 570);

	public AddDialog(Controller controller, Table table) {
		this.controller = controller;

		add.setOnAction(event -> {
			List<Student> students = controller.getStudentsList();

			lastName = lastNameInsert.getText();
			firstName = firstNameInsert.getText();
			patronymic = patronymicInsert.getText();
			groupNum = groupNumInsert.getText();
			semWork.add(societyWorkInsert1.getText());
			semWork.add(societyWorkInsert2.getText());
			semWork.add(societyWorkInsert3.getText());
			semWork.add(societyWorkInsert4.getText());
			semWork.add(societyWorkInsert5.getText());
			semWork.add(societyWorkInsert6.getText());
			semWork.add(societyWorkInsert7.getText());
			semWork.add(societyWorkInsert8.getText());
			semWork.add(societyWorkInsert9.getText());
			semWork.add(societyWorkInsert10.getText());

			Student student = new Student(firstName, lastName, patronymic, groupNum, semWork);
			students.add(student);

			table.updateStudentsList(students);

			lastNameInsert.clear();
			firstNameInsert.clear();
			patronymicInsert.clear();
			groupNumInsert.clear();
			societyWorkInsert1.clear();
			societyWorkInsert2.clear();
			societyWorkInsert3.clear();
			societyWorkInsert4.clear();
			societyWorkInsert5.clear();
			societyWorkInsert6.clear();
			societyWorkInsert7.clear();
			societyWorkInsert8.clear();
			societyWorkInsert9.clear();
			societyWorkInsert10.clear();

			addStage.close();
		});

		cancel.setOnAction(event -> {
			addStage.close();

		});
	}

	private void configure() {
		addStage.setTitle("Добавить запись");
		AnchorPane.setTopAnchor(labelBox, 10.0);
		AnchorPane.setLeftAnchor(labelBox, 10.0);
		AnchorPane.setTopAnchor(textInsertBox, 10.0);
		AnchorPane.setRightAnchor(textInsertBox, 10.0);

		AnchorPane.setRightAnchor(buttonBox, 70.0);
		AnchorPane.setBottomAnchor(buttonBox, 20.0);

	}

	public void show() {
		configure();
		addStage.setScene(addScene);
		addStage.show();
	}

}
