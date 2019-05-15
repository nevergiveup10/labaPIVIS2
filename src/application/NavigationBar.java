package application;


import java.io.File;
import java.util.List;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class NavigationBar {
	private Controller controller;
	private MenuItem newFile = new MenuItem("�����");
	private MenuItem openFile = new MenuItem("�������");
	private MenuItem saveFile = new MenuItem("���������");
	private	Menu menuFiles = new Menu("����");

	private MenuItem update = new MenuItem("��������");
	private Menu menuAdd = new Menu("��������");
	
	private MenuItem lastNameSrch = new MenuItem("�� �������");
	private MenuItem groumNmSrch = new MenuItem("�� ������ ������");
	private MenuItem societyWorkSrch = new MenuItem("�� ���-�� ���. ������");
	private Menu menuSrch = new Menu("�����");
	
	private MenuItem del1 = new MenuItem("�������1");
	private MenuItem del2 = new MenuItem("�������2");
	private MenuItem del3 = new MenuItem("�������3");
	private Menu menuDel = new Menu("��������");


	private MenuBar menuBar = new MenuBar(menuFiles, menuAdd, menuSrch, menuDel);
	private	Pane menuBarPane = new Pane(menuBar);
	
    private Stage stage;
    
	public NavigationBar(Controller controller, Table table) {
		menuFiles.getItems().add(newFile);
		menuFiles.getItems().add(openFile);
		menuFiles.getItems().add(saveFile);
		menuAdd.getItems().add(update);
		menuSrch.getItems().add(lastNameSrch);
		menuSrch.getItems().add(groumNmSrch);
		menuSrch.getItems().add(societyWorkSrch);
		menuDel.getItems().add(del1);
		menuDel.getItems().add(del2);
		menuDel.getItems().add(del3);
		this.controller = controller;
		
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
		    }
		});
		
		newFile.setOnAction((e) -> {		   
		});
		
	}
	public Pane getMenuPanel() {
		return menuBarPane;
	}
}
