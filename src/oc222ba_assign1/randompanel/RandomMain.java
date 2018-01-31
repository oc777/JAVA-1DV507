package oc222ba_assign1.randompanel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author olgachristensen
 *
 */
public class RandomMain extends Application {

	@Override
	public void start (Stage primaryStage) {
		primaryStage.setTitle("Random Panel");
		RandomPanel rp = new RandomPanel();
		Scene scene = new Scene(rp, 400, 100);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
