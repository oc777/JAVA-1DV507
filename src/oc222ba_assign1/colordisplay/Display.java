/**
 * 
 */
package oc222ba_assign1.colordisplay;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author olgachristensen
 *
 */
public class Display extends VBox{
	
	final TextField rValue;
	final TextField gValue;
	final TextField bValue;
	
	private HBox box1;
	private int[] rgb;
	private String style;
	private Text msg;
	
	public Display() {
		rgb = new int[3];
		
		setStyle("-fx-padding: 10; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; "); 

		box1 = new HBox();
		style = "-fx-padding: 10; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; ";
		box1.setStyle(style);
		HBox box2 = new HBox(20);
		box2.setStyle("-fx-padding: 10; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; ");
		HBox box3 = new HBox();
		box3.setStyle("-fx-padding: 10; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; ");
		HBox box4 = new HBox();
		
		Text title = new Text("Color Display");
		title.setFont(Font.font(20));
		
		box1.setPrefSize(450, 90);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().add(title);
		
		VBox r = new VBox(10);
		r.setAlignment(Pos.CENTER);
		VBox g = new VBox(10);
		g.setAlignment(Pos.CENTER);
		VBox b = new VBox(10);
		b.setAlignment(Pos.CENTER);
		
		Text rText = new Text("Red");
		rValue = new TextField("0");
		
		Text gText = new Text("Green");
		gValue = new TextField("0");
		
		Text bText = new Text("Blue");
		bValue = new TextField("0");
		
		Button btn = new Button("Display Color");
		setAction(btn);
		
		r.getChildren().addAll(rText, rValue);
		g.getChildren().addAll(gText, gValue);
		b.getChildren().addAll(bText, bValue);
		
		box2.setAlignment(Pos.CENTER);
		box2.getChildren().addAll(r, g, b);
		
		box3.setAlignment(Pos.CENTER);
		box3.getChildren().add(btn);
		
		msg = new Text();
		msg.setFill(Color.RED);; 
		box4.getChildren().add(msg);
		
		
		getChildren().addAll(box1, box2, box3, box4);

	}
	
	private void setAction(Button btn) {
		btn.setOnAction(event -> { 
			String err = "";
			try {
				rgb = getRGB();
				showColor(rgb);
			}
			catch (Exception e) {
				err = "Provide positive integers";
				msg.setText(err);
			}
			
			
				
		});
	}
	
	private int[] getRGB() throws Exception{
		String err = "";
		int r = Integer.parseInt(rValue.getText());
		rgb[0] = r;
		int g = Integer.parseInt(gValue.getText());
		rgb[1] = g;
		int b = Integer.parseInt(bValue.getText());
		rgb[2] = b;
		
		if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
			err = "Each color should be in the range from 0 to 255";
			msg.setText(err);
			throw new Exception();
				
		}
		
		return rgb;
	}
	
	private void showColor(int[] rgb) {
		String styleRGB = "-fx-background-color: rgb(" + rgb[0] + ", " + rgb[1] + ", " + rgb[2] + "); ";
		style += styleRGB;
		box1.setStyle(style);
	}
}
