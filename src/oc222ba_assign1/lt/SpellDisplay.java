/**
 * 
 */
package oc222ba_assign1.lt;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * @author olgachristensen
 *
 */
public class SpellDisplay extends VBox{
	private List<RuleMatch> errors ;
	private String spellresult;
	
	public SpellDisplay() {
		
		setStyle("-fx-padding: 10; -fx-background-color: DCDCDC; "); 
		setSpacing(20);
		
		HBox box1 = new HBox(10);
		VBox box2 = new VBox(10);
		VBox box3 = new VBox(10);
		HBox box4 = new HBox();
		
		TextField path = new TextField();
		path.setPrefWidth(420);
		Button btn = new Button("Check spelling");
		btn.setPrefWidth(150);
		
		box1.getChildren().addAll(path, btn);
		
		
		TextArea input = new TextArea();
		input.setPrefWidth(580);
		input.setWrapText(true);
		
		Text label1 = new Text("Your text: ");
		
		box2.getChildren().addAll(label1, input);
		
		Text label2 = new Text("Spell check result: ");
		
		TextArea result = new TextArea();
		result.setPrefWidth(580);
		result.setWrapText(true);
		
		box3.getChildren().addAll(label2, result);
		
		
		Text msg = new Text();
		msg.setFill(Color.RED);; 
		box4.getChildren().add(msg);
		
		errors = new ArrayList<RuleMatch>();
		
		
		btn.setOnAction(event -> { 
			String fPath = path.getText();
			String txt = "";
			String err = "";
			try {
				txt = readFile(fPath);
			}
			catch (IOException e) {
				err = e.getMessage();
				msg.setText(err);
				
			}
			
			input.setText(txt);
			
			try {
				errors = spellCheck(txt);
			} catch (IOException e) {
				err = e.getMessage();
				msg.setText(err);
				
			}
			
			String output = printErrors(errors, txt);
			result.setText(output);
		});
		
		
		getChildren().addAll(box1, box2, box3, box4);
		
	}
	
	public String readFile(String path) throws IOException {
		String txt = "";
	
		File file = new File(path);
		Scanner scan = new Scanner(file);
		
		while (scan.hasNextLine()) {
			txt += scan.nextLine();
			txt += "\n";
		}
		scan.close();
			
		return txt;
		
	}
	
	public List<RuleMatch> spellCheck(String txt) throws IOException {
		JLanguageTool jlt = new JLanguageTool(new BritishEnglish());
	    
		List<RuleMatch> matches = jlt.check(txt);
	    
		return matches;
		
	}
	
	public String printErrors(List<RuleMatch> errors, String txt) {
		spellresult = "";
		int errs = 0;
		int start = 0;
		int end = 0;
		for (RuleMatch error : errors) {
			errs++;
			String str = "";
			start = error.getFromPos();
			end = error.getToPos();
			spellresult += error.getMessage() +  " on line " + error.getLine() + "\n";
			str = txt.substring(start, end);
			spellresult += "In: " + str  + "\n";
			spellresult += "Possible corrections: " + error.getSuggestedReplacements() + "\n";
			spellresult += "\n";
		}
		
		spellresult += "In total " + errs + " errors found";
		
		return spellresult;
		
	}

}
