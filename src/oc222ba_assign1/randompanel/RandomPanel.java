/**
 * 
 */
package oc222ba_assign1.randompanel;


import java.util.Random;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author olgachristensen
 *
 */
public class RandomPanel extends BorderPane{
	
	final Text num = new Text();
	
	public RandomPanel() {
	
		num.setFont(Font.font(90));
		
		VBox left = new VBox();
		left.setPrefSize(200, 100);
		left.setAlignment(Pos.CENTER);
		left.setStyle("-fx-background-color: DAE6F3; ");
		
		VBox right = new VBox();
		right.setPrefSize(200, 100);
		right.setAlignment(Pos.CENTER);
		right.setStyle("-fx-background-color: DCDCDC; ");
		
		Button btn = new Button("New Random");
	
		btn.setOnAction(event -> { 
			Random r = new Random();
			int n = r.nextInt(100) + 1;
			String str = "" + n;
			num.setText(str);
		});
		
		left.getChildren().add(btn);
		right.getChildren().add(num);
			
		setLeft(left);
		setRight(right);
		
	
	}
	
	
}