package oc222ba_assign2.game;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Counter extends HBox{
	public Label counter;
	
	public Counter() {
		setStyle("-fx-background-color: F0F8FF; ");
		
		counter = new Label("0");
		HBox left = new HBox();
		HBox right = new HBox();
		
		Text txtL = new Text("Creature caught ");
		Text txtR = new Text(" times.");
		left.getChildren().add(txtL);
		right.getChildren().add(txtR);
		
		getChildren().addAll(left, counter, right);
		
	}
	
}
