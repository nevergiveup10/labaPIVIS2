package application;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FileChooserBuilder {

	public FileChooserBuilder() {
	}

	public FileChooser getFileChooser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("");
		fileChooser.setInitialFileName("filename.xml");
		ExtensionFilter filter = new ExtensionFilter("XML", "*.xml");
		fileChooser.getExtensionFilters().add(filter);
		return fileChooser;
	}

}
