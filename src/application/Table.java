package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
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
	
	Button firstPageButton = new Button("������ ���.  ");
	Button previousPageButton = new Button("<");
	Button nextPageButton = new Button(">");
	Button lastPageButton = new Button("��������� ���.");

	HBox tableControlButtons = new HBox(10, firstPageButton, previousPageButton, nextPageButton,
			lastPageButton);

	Label allRecordsLabel = new Label("����� �������: ");
	Label allPagesLabel = new Label("����� �������: ");
	Label currentPageLabel = new Label("������� ��������: ");
	Label recordsNumLabel = new Label("������� �� ��������: ");

	Label allRecordsValue = new Label("0");
	Label allPagesValue = new Label("0");
	Label currentPageValue = new Label("0");
	TextField recordsNumValue = new TextField("0");

	HBox allRecordsBox = new HBox(5, allRecordsLabel, allRecordsValue);
	HBox allPagesBox = new HBox(5, allPagesLabel, allPagesValue);
	HBox currentPageBox = new HBox(5, currentPageLabel, currentPageValue);
	HBox recordsNumBox = new HBox(5, recordsNumLabel, recordsNumValue);

	VBox tableControlPane = new VBox(10, tableControlButtons, allRecordsBox, allPagesBox, currentPageBox,
			recordsNumBox);
	
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

	public VBox getTableControlPane() {
	return tableControlPane;
}
}