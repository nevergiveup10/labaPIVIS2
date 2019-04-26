package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ActionButtons {
	Button addButton = new Button("Добавить запись");
	Button searchByLNameAndGNumButton = new Button("Поиск по фам. или № гр.");
	Button searchByLNameAndWorkButton = new Button("Поиск по фам. и кол-ву общ раб.");
	Button searchByGNumAndWorkButton = new Button("Поиск по № гр. и кол-ву общ. раб.");
	Button deleteByLNameAndGNumButton = new Button("Удал. по фам. или № гр.");
	Button deleteByLNameAndWorkButton = new Button("Удал. по фам. и кол-ву общ раб.");
	Button deleteByGNumAndWorkButton = new Button("Удал. по № гр. и кол-ву общ. раб.");
	VBox actionButtons = new VBox(10, addButton, searchByLNameAndGNumButton, searchByLNameAndWorkButton,
			searchByGNumAndWorkButton, deleteByLNameAndGNumButton, deleteByLNameAndWorkButton,
			deleteByGNumAndWorkButton);

	public ActionButtons(AddDialog addDialog, SearchByLNameAndGNumDialog searchByLNameAndGNumDialog,
			SearchByLNameAndWorkDialog searchByLNameAndWorkDialog, SearchByGNumAndWorkDialog searchByGNumAndWorkDialog,
			DeleteByLNameAndGNumDialog deleteByLNameAndGNumDialog, DeleteByLNameAndWorkDialog deleteByLNameAndWorkDialog, DeleteByGNumAndWorkDialog deleteByGNumAndWorkDialog) {
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				addDialog.show();
			}
		});
		searchByLNameAndGNumButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				searchByLNameAndGNumDialog.show();
			}
		});

		searchByLNameAndWorkButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				searchByLNameAndWorkDialog.show();
			}
		});

		searchByGNumAndWorkButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				searchByGNumAndWorkDialog.show();
			}
		});
		deleteByLNameAndGNumButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				deleteByLNameAndGNumDialog.show();
			}
		});
		deleteByLNameAndWorkButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				deleteByLNameAndWorkDialog.show();
			}
		});
		deleteByGNumAndWorkButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				deleteByGNumAndWorkDialog.show();
			}
		});

	}

	public VBox getActionButtons() {
		return actionButtons;
	}
}
