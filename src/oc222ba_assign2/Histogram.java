/**
 * 
 */
package oc222ba_assign2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * @author olgachristensen
 *
 */
public class Histogram extends Application{
	
	private int others = 0;
	private int zero = 0;
	private int one = 0;
	private int two = 0;
	private int three = 0;
	private int four = 0;
	private int five = 0;
	private int six = 0;
	private int seven = 0;
	private int eight = 0;
	private int nine = 0;
	private String err = "";
	private Text msg = new Text();
	
	public void start (Stage stage) {
		stage.setTitle("Histogram");
		
		VBox vb = new VBox();
		vb.setStyle("-fx-padding: 10; -fx-background-color: DCDCDC; "); 
		vb.setSpacing(20);
		
		Scene scene = new Scene(vb, 700, 600);
		
		VBox box1 = new VBox(10);
		box1.setAlignment(Pos.CENTER);
		
		VBox box2 = new VBox(10);
		box2.setAlignment(Pos.CENTER);
		
		
		HBox box3 = new HBox(10);
		
		FileChooser fc = new FileChooser();
		fc.setTitle("Find File");
		fc.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
		
		Text info = new Text("Choose *.txt file to scan for integers.");
		Button btn = new Button("Browse");
		
		
		box1.getChildren().addAll(info, btn);
		vb.getChildren().add(box1);
		
		PieChart chart = new PieChart();
		
		
		msg.setFill(Color.RED);; 
		box3.getChildren().add(msg);
		
		
		vb.getChildren().addAll(box2, box3);
		
		btn.setOnAction((ActionEvent e) -> {
			err = "";
			File file = fc.showOpenDialog(stage);
            if (file != null) {
                scanFile(file);
            }
            
            chart.setData(getData());
    		box2.getChildren().add(chart);
    		
		});
		
		stage.setScene(scene);
		stage.show();
	
	}

	public static void main(String[] args) {
		launch(args);
	}

	
	private void scanFile(File file) {
		try {
			Scanner scan = new Scanner(file);
			
			while(scan.hasNext()) {
				int number = scan.nextInt();
				if (number > 0 && number < 101) {
					if (number <= 10) {zero += 1;}
					if (number > 10 && number <= 20) {one += 1;}
					if (number > 20 && number <= 30) {two += 1;}
					if (number > 30 && number <= 40) {three += 1;}
					if (number > 40 && number <= 50) {four += 1;}
					if (number > 50 && number <= 60) {five += 1;}
					if (number > 60 && number <= 70) {six += 1;}
					if (number > 70 && number <= 80) {seven += 1;}
					if (number > 80 && number <= 90) {eight += 1;}
					if (number > 90 && number < 101) {nine += 1;}
				}
				else 
					others += 1;
			}
			scan.close();
		
		} catch (IOException e) {
			err = e.getMessage();
			msg.setText(err);
		}
	
	}
	
	private ObservableList<PieChart.Data> getData() {
		ObservableList<PieChart.Data> list = FXCollections.observableArrayList(
				new PieChart.Data("0", zero),
				new PieChart.Data("1", one),
				new PieChart.Data("2", two),
				new PieChart.Data("3", three),
				new PieChart.Data("4", four),
				new PieChart.Data("5", five),
				new PieChart.Data("6", six),
				new PieChart.Data("7", seven),
				new PieChart.Data("8", eight),
				new PieChart.Data("9", nine),
				new PieChart.Data("other", others)
				);
		
		return list;
	}

}
