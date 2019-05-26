package application;

import java.io.File;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class NavigationBar {
	private MenuItem newFile = new MenuItem("Новый файл");
	private MenuItem openFile = new MenuItem("Открыть файл");
	private MenuItem saveFile = new MenuItem("Сохранить файл");
	private Menu menuFiles = new Menu("Файл");

	private MenuItem addRecord = new MenuItem("Добавить запись");
	private Menu menuAdd = new Menu("Добавить");

	private MenuItem search1 = new MenuItem("По фамилии или номеру группы");
	private MenuItem search2 = new MenuItem("По фамилии и общ. раб.");
	private MenuItem search3 = new MenuItem("По номеру гр. и общ. раб.");
	private Menu menuSrch = new Menu("Поиск");

	private MenuItem del1 = new MenuItem("По фамилии или номеру группы");
	private MenuItem del2 = new MenuItem("По фамилии и общ. раб.");
	private MenuItem del3 = new MenuItem("По номеру гр. и общ. раб.");
	private Menu menuDel = new Menu("Удаление");

	private MenuBar menuBar = new MenuBar(menuFiles, menuAdd, menuSrch, menuDel);
	private Pane menuBarPane = new Pane(menuBar);

	private Stage stage;

	public NavigationBar(Controller controller, Table table, AddDialog addDialog,
			SearchByLNameAndGNumDialog searchByLNameAndGNumDialog,
			SearchByLNameAndWorkDialog searchByLNameAndWorkDialog, SearchByGNumAndWorkDialog searchByGNumAndWorkDialog,
			DeleteByLNameAndGNumDialog deleteByLNameAndGNumDialog,
			DeleteByLNameAndWorkDialog deleteByLNameAndWorkDialog,
			DeleteByGNumAndWorkDialog deleteByGNumAndWorkDialog) {
		menuFiles.getItems().add(newFile);
		menuFiles.getItems().add(openFile);
		menuFiles.getItems().add(saveFile);
		menuAdd.getItems().add(addRecord);
		menuSrch.getItems().add(search1);
		menuSrch.getItems().add(search2);
		menuSrch.getItems().add(search3);
		menuDel.getItems().add(del1);
		menuDel.getItems().add(del2);
		menuDel.getItems().add(del3);
		openFile.setOnAction((e) -> {
			FileChooser fileChooser = new FileChooserBuilder().getFileChooser();
			File selectedFile = fileChooser.showOpenDialog(stage);
			if (selectedFile != null) {
				List<Student> students = controller.open(selectedFile);
				controller.eraseStudentsList();
				controller.updateStudentsList(students);
				table.updateStudentsList(students);
			}
		});

		saveFile.setOnAction((e) -> {
			FileChooser fileChooser = new FileChooserBuilder().getFileChooser();
			File selectedFile = fileChooser.showSaveDialog(stage);
			if (selectedFile != null) {
				List<Student> students = controller.getStudentsList();
				controller.write(selectedFile, students);
			}
		});

		newFile.setOnAction((e) -> {
			controller.eraseStudentsList();
			table.resetTable();
		});

		addRecord.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				addDialog.show();
			}
		});

		search1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				searchByLNameAndGNumDialog.show();
			}
		});

		search2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				searchByLNameAndWorkDialog.show();
			}
		});

		search3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				searchByGNumAndWorkDialog.show();
			}
		});

		del1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				deleteByLNameAndGNumDialog.show();
			}
		});

		del2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				deleteByLNameAndWorkDialog.show();
			}
		});

		del3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				deleteByGNumAndWorkDialog.show();
			}
		});

	}

	public Pane getMenuPanel() {
		return menuBarPane;
	}
}
