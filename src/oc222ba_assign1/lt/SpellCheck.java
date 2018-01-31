/**
 * 
 */
package oc222ba_assign1.lt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author olgachristensen
 *
 */
public class SpellCheck extends Application{

	@Override
	public void start (Stage primaryStage) {
		primaryStage.setTitle("Spell Check");
		
		SpellDisplay main = new SpellDisplay();
		
		Scene scene = new Scene(main, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	
	
	public static void main(String[] args) {
		launch();

	}

}
