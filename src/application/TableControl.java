package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TableControl {
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
	
	public VBox getTableControlPane() {
		return tableControlPane;
	}
}
