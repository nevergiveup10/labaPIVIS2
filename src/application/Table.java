package application;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Table {
	TableView table = new TableView();
	TableColumn firstName = new TableColumn("���");
	TableColumn lastName = new TableColumn("�������");
	TableColumn patronymic = new TableColumn("��������");
	TableColumn groupNumber = new TableColumn("������");
	TableColumn societyWork = new TableColumn("������������ ������");
	TableColumn sem1 = new TableColumn("1 ���.");
	TableColumn sem2 = new TableColumn("2 ���.");
	TableColumn sem3 = new TableColumn("3 ���.");
	TableColumn sem4 = new TableColumn("4 ���.");
	TableColumn sem5 = new TableColumn("5 ���.");
	TableColumn sem6 = new TableColumn("6 ���.");
	TableColumn sem7 = new TableColumn("7 ���.");
	TableColumn sem8 = new TableColumn("8 ���.");
	TableColumn sem9 = new TableColumn("9 ���.");
	TableColumn sem10 = new TableColumn("10 ���.");
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
