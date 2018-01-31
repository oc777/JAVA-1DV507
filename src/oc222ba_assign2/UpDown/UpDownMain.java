package oc222ba_assign2.UpDown;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author olgachristensen
 *
 */
public class UpDownMain extends Application{

	public void start (Stage primaryStage) {
		primaryStage.setTitle("Up Down Pane");
		
		UpDownPane pane = new UpDownPane();
		Scene scene = new Scene(pane, 700, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		pane.action();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
