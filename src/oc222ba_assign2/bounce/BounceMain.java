package oc222ba_assign2.bounce;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BounceMain extends Application {
	
	public void start(Stage primaryStage) {
		BorderPane window = new BorderPane();
		
		Frame f = new Frame();
		AddNew an = new AddNew();
		
		// release additional ball if clicked
		an.btn.setOnAction(event -> { 
			f.add();
		});
		
		window.setTop(an);
		window.setCenter(f);
		
		
		
		Scene scene = new Scene(window, 600, 400);
		primaryStage.setTitle("Bouncing Balls");
		primaryStage.setScene(scene);
		primaryStage.show(); 
		
		
	}
	
	public static void main(final String[] args) {
        launch(args);
    }

}
