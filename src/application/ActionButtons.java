package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ActionButtons {
	Button addButton = new Button("�������� ������");
	Button searchByLNameAndGNumButton = new Button("����� �� ���. ��� � ��.");
	Button searchByLNameAndWorkButton = new Button("����� �� ���. � ���-�� ��� ���.");
	Button searchByGNumAndWorkButton = new Button("����� �� � ��. � ���-�� ���. ���.");
	Button deleteByLNameAndGNumButton = new Button("����. �� ���. ��� � ��.");
	Button deleteByLNameAndWorkButton = new Button("����. �� ���. � ���-�� ��� ���.");
	Button deleteByGNumAndWorkButton = new Button("����. �� � ��. � ���-�� ���. ���.");
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
