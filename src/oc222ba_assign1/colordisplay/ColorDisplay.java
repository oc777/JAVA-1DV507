/**
 * 
 */
package oc222ba_assign1.colordisplay;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/*
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
*/

/**
 * @author olgachristensen
 *
 */
public class ColorDisplay extends Application{
	
	@Override
	public void start (Stage primaryStage) {
		primaryStage.setTitle("Color Display");
		
		Display main = new Display();
		
		Scene scene = new Scene(main, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
