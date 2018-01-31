/**
 * 
 */
package oc222ba_assign1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author olgachristensen
 *
 */
public class OneTwoThree extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start (Stage primaryStage) {
		primaryStage.setTitle("One Two Three");
		
		Text one = new Text ("One");
		one.setFont(Font.font(20));
		Text two = new Text (20, 50, "Two");
		two.setFont(Font.font(20));
		Text three = new Text (20, 50, "Three");
		three.setFont(Font.font(20));
		
		// main box with 3 horizontal boxes
		VBox main = new VBox();
		HBox box1 = new HBox();
		HBox box2 = new HBox();
		HBox box3 = new HBox();
		
		box1.setStyle("-fx-background-color: DAE6F3; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; -fx-padding: 15; ");
		box1.setPrefSize(450, 90);
		box1.setAlignment(Pos.TOP_LEFT);
		box1.getChildren().add(one);
		
		box2.setStyle("-fx-background-color: DCDCDC; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; -fx-padding: 15; ");
		box2.setPrefSize(450, 90);
		box2.setAlignment(Pos.CENTER);
		box2.getChildren().add(two);
		
		box3.setStyle("-fx-background-color: E0EE90; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; -fx-padding: 15; ");
		box3.setPrefSize(450, 90);
		box3.setAlignment(Pos.BOTTOM_RIGHT);
		box3.getChildren().add(three);
		
		// putting it all together
		main.getChildren().addAll(box1, box2, box3);
				
		Scene scene = new Scene(main, 450, 270);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
