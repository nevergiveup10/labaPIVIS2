package application;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

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
	}
	public Pane getMenuPanel() {
		return menuBarPane;
	}
}
