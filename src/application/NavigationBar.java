package application;

import java.io.File;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class NavigationBar {
	MenuItem newFile = new MenuItem("�����");
	MenuItem openFile = new MenuItem("�������");
	MenuItem saveFile = new MenuItem("���������");
	Menu menuFiles = new Menu("����");

	MenuItem update = new MenuItem("��������");
	Menu menuAdd = new Menu("��������");
	
	MenuItem lastNameSrch = new MenuItem("�� �������");
	MenuItem groumNmSrch = new MenuItem("�� ������ ������");
	MenuItem societyWorkSrch = new MenuItem("�� ���-�� ���. ������");
	Menu menuSrch = new Menu("�����");
	
	MenuItem del1 = new MenuItem("�������1");
	MenuItem del2 = new MenuItem("�������2");
	MenuItem del3 = new MenuItem("�������3");
	Menu menuDel = new Menu("��������");


	MenuBar menuBar = new MenuBar(menuFiles, menuAdd, menuSrch, menuDel);
	Pane menuBarPane = new Pane(menuBar);
	
    private Stage stage;
    
	public NavigationBar() {
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
		
		openFile.setOnAction((e) -> {
		    FileChooser fileChooser = new FileChooserBuilder().getFileChooser();
		    File selectedFile = fileChooser.showOpenDialog(stage);
		    if (selectedFile != null) {
		
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
