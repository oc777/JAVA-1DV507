package oc222ba_assign2.bounce;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle {
	public int dx = 1;
	public int dy = 1;
	
	public Ball() {
		super(20, Color.RED);	
		relocate(10, 10);
	}
	
}
