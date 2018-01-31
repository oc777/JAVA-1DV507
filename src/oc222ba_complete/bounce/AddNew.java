package oc222ba_assign2.bounce;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class AddNew extends HBox{
	public Button btn;
	
	public AddNew() {
		btn = new Button("Release!");
		getChildren().add(btn);
		setAlignment(Pos.CENTER);
		
	}
}
