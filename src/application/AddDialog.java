package application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddDialog {

	private Stage addStage = new Stage();

	private Button add = new Button("��������");
	private Button cancel = new Button("������");
	private HBox buttonBox = new HBox(10,add, cancel);
	
	private Label lastNameLabel = new Label("�������:");
	private Label nameLabel = new Label("���:");
	private Label patronymicLabel = new Label("�������:");
	private Label groupNumLabel = new Label("����� ������:");
	private Label societyWorkLabel1 = new Label("�.�. �� 1 ���.:");
	private Label societyWorkLabel2 = new Label("�.�. �� 2 ���.:");
	private Label societyWorkLabel3 = new Label("�.�. �� 3 ���.:");
	private Label societyWorkLabel4 = new Label("�.�. �� 4 ���.:");
	private Label societyWorkLabel5 = new Label("�.�. �� 5 ���.:");
	private Label societyWorkLabel6 = new Label("�.�. �� 6 ���.:");
	private Label societyWorkLabel7 = new Label("�.�. �� 7 ���.:");
	private Label societyWorkLabel8 = new Label("�.�. �� 8 ���.:");
	private Label societyWorkLabel9 = new Label("�.�. �� 9 ���.:");
	private Label societyWorkLabel10 = new Label("�.�. �� 10 ���.:");
	private VBox labelBox = new VBox(15, lastNameLabel, nameLabel, patronymicLabel, groupNumLabel, societyWorkLabel1,
			societyWorkLabel2, societyWorkLabel3, societyWorkLabel4, societyWorkLabel5, societyWorkLabel6,
			societyWorkLabel7, societyWorkLabel8, societyWorkLabel9, societyWorkLabel10);

	private TextField lastNameInsert = new TextField();
	private TextField nameInsert = new TextField();
	private TextField patronymicInsert = new TextField();
	private TextField groupNumInsert = new TextField();
	private TextField societyWorkInsert1 = new TextField();
	private TextField societyWorkInsert2 = new TextField();
	private TextField societyWorkInsert3 = new TextField();
	private TextField societyWorkInsert4 = new TextField();
	private TextField societyWorkInsert5 = new TextField();
	private TextField societyWorkInsert6 = new TextField();
	private TextField societyWorkInsert7 = new TextField();
	private TextField societyWorkInsert8 = new TextField();
	private TextField societyWorkInsert9 = new TextField();
	private TextField societyWorkInsert10 = new TextField();
	private VBox textInsertBox = new VBox(5, lastNameInsert, nameInsert, patronymicInsert, groupNumInsert,
			societyWorkInsert1, societyWorkInsert2, societyWorkInsert3, societyWorkInsert4, societyWorkInsert5,
			societyWorkInsert6, societyWorkInsert7, societyWorkInsert8, societyWorkInsert9, societyWorkInsert10);
	
	private AnchorPane addDialogPane = new AnchorPane(labelBox, textInsertBox, buttonBox);
	private Scene addScene = new Scene(addDialogPane, 320, 570);

	private void configure() {
		addStage.setTitle("�������� ������");
		AnchorPane.setTopAnchor(labelBox, 10.0);
        AnchorPane.setLeftAnchor(labelBox, 10.0);
        AnchorPane.setTopAnchor(textInsertBox, 10.0);
        AnchorPane.setRightAnchor(textInsertBox, 10.0);
        
        AnchorPane.setRightAnchor(buttonBox, 70.0);
        AnchorPane.setBottomAnchor(buttonBox, 20.0);
       
	}

	public void show() {
		configure();
		addStage.setScene(addScene);
		addStage.show();
	}

}
