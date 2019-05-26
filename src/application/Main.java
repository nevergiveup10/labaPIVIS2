package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Model model = new Model();
			Controller controller = new Controller(model);
			Table table = new Table(model.getStudents());

			AddDialog addDialog = new AddDialog(controller, table);
			SearchByLNameAndGNumDialog searchByLNameAndGNumDialog = new SearchByLNameAndGNumDialog(controller);
			SearchByLNameAndWorkDialog searchByLNameAndWorkDialog = new SearchByLNameAndWorkDialog(controller);
			SearchByGNumAndWorkDialog searchByGNumAndWorkDialog = new SearchByGNumAndWorkDialog(controller);
			DeleteByLNameAndGNumDialog deleteByLNameAndGNumDialog = new DeleteByLNameAndGNumDialog(controller, table);
			DeleteByLNameAndWorkDialog deleteByLNameAndWorkDialog = new DeleteByLNameAndWorkDialog(controller, table);
			DeleteByGNumAndWorkDialog deleteByGNumAndWorkDialog = new DeleteByGNumAndWorkDialog(controller, table);
			Pane tablePane = table.getTable();

			ActionButtons actionButtons = new ActionButtons(addDialog, searchByLNameAndGNumDialog,
					searchByLNameAndWorkDialog, searchByGNumAndWorkDialog, deleteByLNameAndGNumDialog,
					deleteByLNameAndWorkDialog, deleteByGNumAndWorkDialog);
			VBox actionButtonsPane = actionButtons.getActionButtons();

			AnchorPane.setTopAnchor(actionButtonsPane, 100.0);
			AnchorPane.setLeftAnchor(actionButtonsPane, 5.0);
			AnchorPane.setBottomAnchor(actionButtonsPane, 30.0);

			AnchorPane.setTopAnchor(tablePane, 30.0);
			AnchorPane.setRightAnchor(tablePane, 15.0);
			AnchorPane.setBottomAnchor(tablePane, 30.0);

			NavigationBar menuPanel = new NavigationBar(controller, table, addDialog, searchByLNameAndGNumDialog,
					searchByLNameAndWorkDialog, searchByGNumAndWorkDialog, deleteByLNameAndGNumDialog,
					deleteByLNameAndWorkDialog, deleteByGNumAndWorkDialog);
			Pane menuBarPane = menuPanel.getMenuPanel();

			AnchorPane root = new AnchorPane(menuBarPane, actionButtonsPane, tablePane);
			Scene scene = new Scene(root, 1400, 700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Лабораторная работа №2, Смоленский П.М., гр. 721702");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
