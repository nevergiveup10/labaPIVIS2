package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchByLNameAndGNumDialog {
	private Stage stage = new Stage();
	
Table table= new Table();
Label lastNameLabel = new Label("Фамилия: ");
Label groupNumLabel = new Label("Номер группы: ");
TextField lastNameInsert = new TextField ();
TextField groupNumInsert = new TextField ();
Button search = new Button("Поиск");
Button cancel = new Button("Отмена");
VBox controlBox = new VBox(10, lastNameLabel,lastNameInsert, groupNumLabel, groupNumInsert, search, cancel);
Pane tablePane = table.getTable();
VBox tableControlPane = table.getTableControlPane(); 
AnchorPane SearchByLNameAndGNumPane = new AnchorPane(controlBox, tablePane, tableControlPane);
private Scene scene = new Scene(SearchByLNameAndGNumPane, 1400, 700);

private void configure() {
	stage.setTitle("Поиск по фамилии или номеру группы.");
	stage.setScene(scene);
	AnchorPane.setTopAnchor(controlBox, 20.0);
    AnchorPane.setLeftAnchor(controlBox, 10.0);
    AnchorPane.setTopAnchor(controlBox, 20.0);
   
    
    AnchorPane.setTopAnchor(tableControlPane, 450.0);
	AnchorPane.setRightAnchor(tableControlPane, 800.0);
	AnchorPane.setBottomAnchor(tableControlPane, 20.0);
	
	AnchorPane.setTopAnchor(tablePane, 30.0);
	AnchorPane.setRightAnchor(tablePane, 15.0);
	AnchorPane.setBottomAnchor(tablePane, 30.0);
}

public void show() {
	configure();
	stage.show();
}
}
