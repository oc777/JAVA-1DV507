package oc222ba_assign2.UpDown;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * @author olgachristensen
 *
 */
public class UpDownPane extends GridPane{
	
	private int col = 7;		// number of columns
	private int row = 7;		// number of rows
	private int posC = col/2;	// current column position of img; start position - center
	private int posR = row/2;	// current row position of img; start position - center
	private ImageView iv ;
	
	public UpDownPane() {
		
		setPadding(new Insets(10, 10, 10, 10));
		setVgap(5);
		setHgap(5);
		
		// fill the grid with boxes
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				VBox box = new VBox();
				box.setPrefSize(90, 90);
				box.setStyle("-fx-background-color: DAE6F3; ");
				add(box, i, j);
			}	
		}
		
		Image img = new Image(getClass().getResourceAsStream("ghosty.png"));
		iv = new ImageView(img);
		iv.setFitHeight(90);
		iv.setPreserveRatio(true);
		
		// set image in the default position (center)
		add(iv, posC, posR);
		
	}
	
	// get the node by its location on the grid
	private Node find(int col, int row) {
		Node node = null;
		for (Node n : getChildren()) {
			if (getColumnIndex(n) == col && getRowIndex(n) == row)
				node = n;
		}
		return node;
	}
	
	// check if the image is outside of the grid
	private void check() {
		if (posR == row) 
			posR = 0;
		if (posR == -1) 
			posR = row-1;
		if (posC == col) 
			posC = 0;
		if (posC == -1) 
			posC = col-1;
	}
	
	// event listener 
	public void action() {
		getScene().setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.UP) {
				getChildren().remove(find(posC, posR));
				--posR;
				check();
				add(iv, posC, posR);
			}
			else if (e.getCode() == KeyCode.DOWN) {
				getChildren().remove(find(posC, posR));
				++posR;
				check();
				add(iv, posC, posR);
			}
			else if (e.getCode() == KeyCode.LEFT) {
				getChildren().remove(find(posC, posR));
				--posC;
				check();
				add(iv, posC, posR);
			}
			else if (e.getCode() == KeyCode.RIGHT) {
				getChildren().remove(find(posC, posR));
				++posC;
				check();
				add(iv, posC, posR);
			}
				
		});
	}
	
}

