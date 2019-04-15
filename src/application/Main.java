package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AddDialog addDialog = new AddDialog();
			SearchByLNameAndGNumDialog searchByLNameAndGNumDialog = new SearchByLNameAndGNumDialog();
			SearchByLNameAndWorkDialog searchByLNameAndWorkDialog = new SearchByLNameAndWorkDialog();
			SearchByGNumAndWorkDialog searchByGNumAndWorkDialog = new SearchByGNumAndWorkDialog();
			DeleteByLNameAndGNumDialog deleteByLNameAndGNumDialog = new DeleteByLNameAndGNumDialog();
			DeleteByLNameAndWorkDialog deleteByLNameAndWorkDialog = new DeleteByLNameAndWorkDialog();
			DeleteByGNumAndWorkDialog deleteByGNumAndWorkDialog = new DeleteByGNumAndWorkDialog();
			Table table = new Table();

			Pane tablePane = table.getTable();

			ActionButtons actionButtons = new ActionButtons(addDialog, searchByLNameAndGNumDialog,
					searchByLNameAndWorkDialog, searchByGNumAndWorkDialog, deleteByLNameAndGNumDialog, deleteByLNameAndWorkDialog, deleteByGNumAndWorkDialog);
			VBox actionButtonsPane = actionButtons.getActionButtons();

			AnchorPane.setTopAnchor(actionButtonsPane, 100.0);
			AnchorPane.setLeftAnchor(actionButtonsPane, 5.0);
			AnchorPane.setBottomAnchor(actionButtonsPane, 30.0);

			AnchorPane.setTopAnchor(tablePane, 30.0);
			AnchorPane.setRightAnchor(tablePane, 15.0);
			AnchorPane.setBottomAnchor(tablePane, 30.0);

			TableControl tableControl = new TableControl();
			VBox tableControlPane = tableControl.getTableControlPane();

			AnchorPane.setTopAnchor(tableControlPane, 450.0);
			AnchorPane.setRightAnchor(tableControlPane, 800.0);
			AnchorPane.setBottomAnchor(tableControlPane, 20.0);

			NavigationBar menuPanel = new NavigationBar();
			Pane menuBarPane = menuPanel.getMenuPanel();

			AnchorPane root = new AnchorPane(menuBarPane, actionButtonsPane, tablePane, tableControlPane);
			Scene scene = new Scene(root, 1400, 700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("������������ ������ �2, ���������� �.�., ��. 721702");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}