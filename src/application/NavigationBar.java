package application;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

public class NavigationBar {
	MenuItem newFile = new MenuItem("Новый");
	MenuItem openFile = new MenuItem("Открыть");
	MenuItem saveFile = new MenuItem("Сохранить");
	Menu menuFiles = new Menu("Файл");

	MenuItem update = new MenuItem("Обновить");
	Menu menuAdd = new Menu("Добавить");
	
	MenuItem lastNameSrch = new MenuItem("По фамилии");
	MenuItem groumNmSrch = new MenuItem("По номеру группы");
	MenuItem societyWorkSrch = new MenuItem("По кол-ву общ. работы");
	Menu menuSrch = new Menu("Поиск");
	
	MenuItem del1 = new MenuItem("Удалить1");
	MenuItem del2 = new MenuItem("Удалить2");
	MenuItem del3 = new MenuItem("Удалить3");
	Menu menuDel = new Menu("Удаление");


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
