package oc222ba_assign2.game;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class CatchCreature extends Application{
	
	public void start (Stage primaryStage) {
		Creature minion = new Creature();
		Counter status = new Counter();
		
		status.counter.textProperty().bind(minion.counter.textProperty());
		
		VBox group = new VBox();
		
		group.getChildren().addAll(status, minion);
		
		
		primaryStage.setScene(new Scene(group,700,720));
	    primaryStage.show();
	    
	    
	    //prevents application from running in the background
	    primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                System.exit(0);
            }
        });
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
