package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class InterfaceBuilder {

	Label workLowLimitLabel = new Label("Кол-во работы (нижний предел): ");
	Label workHighLimitLabel = new Label("Кол-во работы (верхний предел): ");
	Label lastNameLabel = new Label("Фамилия: ");
	Label groupNumLabel = new Label("Номер группы: ");
	TextField lastNameInsert = new TextField();
	TextField workLowLimitInsert = new TextField();
	TextField workHighLimitInsert = new TextField();
	TextField groupNumInsert = new TextField();
	Button search = new Button("Поиск");
	Button cancel = new Button("Отмена");
	Button erase = new Button("Очистить");
	Button delete = new Button("Удалить");

	public VBox SearchByLNameAndGNumControlBox() {
		VBox controlBox = new VBox(10, lastNameLabel, lastNameInsert, groupNumLabel, groupNumInsert, search, cancel,
				erase);
		return controlBox;
	}

	public VBox SearchByLNameAndWorkControlBox() {
		VBox controlBox = new VBox(10, lastNameLabel, lastNameInsert, workLowLimitLabel, workLowLimitInsert,
				workHighLimitLabel, workHighLimitInsert, search, cancel, erase);
		return controlBox;
	}

	public VBox SearchByGNumAndWorkControlBox() {
		VBox controlBox = new VBox(10, groupNumLabel, groupNumInsert, workLowLimitLabel, workLowLimitInsert,
				workHighLimitLabel, workHighLimitInsert, search, cancel, erase);
		return controlBox;
	}

	public VBox DeleteByLNameAndGNumControlBox() {
		VBox controlBox = new VBox(10, lastNameLabel, lastNameInsert, groupNumLabel, groupNumInsert, delete, cancel,
				erase);
		return controlBox;
	}

	public VBox DeleteByLNameAndWorkControlBox() {
		VBox controlBox = new VBox(10, lastNameLabel, lastNameInsert, workLowLimitLabel, workLowLimitInsert,
				workHighLimitLabel, workHighLimitInsert, delete, cancel);
		return controlBox;
	}

	public VBox DeleteByGNumAndWorkControlBox() {
		VBox controlBox = new VBox(10, groupNumLabel, groupNumInsert, workLowLimitLabel, workLowLimitInsert,
				workHighLimitLabel, workHighLimitInsert, delete, cancel);
		return controlBox;
	}

}
