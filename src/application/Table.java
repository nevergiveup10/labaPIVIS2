package application;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Table {
	TableView table = new TableView();
	TableColumn firstName = new TableColumn("Имя");
	TableColumn lastName = new TableColumn("Фамилия");
	TableColumn patronymic = new TableColumn("Отчество");
	TableColumn groupNumber = new TableColumn("Группа");
	TableColumn societyWork = new TableColumn("Общественная работа");
	TableColumn sem1 = new TableColumn("1 сем.");
	TableColumn sem2 = new TableColumn("2 сем.");
	TableColumn sem3 = new TableColumn("3 сем.");
	TableColumn sem4 = new TableColumn("4 сем.");
	TableColumn sem5 = new TableColumn("5 сем.");
	TableColumn sem6 = new TableColumn("6 сем.");
	TableColumn sem7 = new TableColumn("7 сем.");
	TableColumn sem8 = new TableColumn("8 сем.");
	TableColumn sem9 = new TableColumn("9 сем.");
	TableColumn sem10 = new TableColumn("10 сем.");
	Pane paneForTable = new Pane(table);
	public Table(){
		societyWork.getColumns().addAll(sem1, sem2, sem3, sem4, sem5, sem6, sem7, sem8, sem9, sem10);
		table.getColumns().add(lastName);
		table.getColumns().add(firstName);
		table.getColumns().add(patronymic);		
		table.getColumns().add(groupNumber);
		table.getColumns().add(societyWork);
	}
	public Pane getTable() {
		return paneForTable;
			}
}
