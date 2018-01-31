package oc222ba_assign2.bounce;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Frame extends Pane {
	private Timeline bounce;
	
	public Frame() {
		bounce = new Timeline(new KeyFrame(Duration.millis(10), event -> moveBall()));
		bounce.setCycleCount(Timeline.INDEFINITE);
		bounce.play();
	}
	
	public void add() {
		getChildren().add(new Ball());
	}
	
	public void moveBall() {
		for (Node n : getChildren()) {
			Ball b = (Ball) n;
			
			// change direction if hit a wall
			if (b.getLayoutX() < b.getRadius() || b.getLayoutX() > getWidth() - b.getRadius()) 
				b.dx *= -1;
				
			// change direction if hit top or bottom
			if (b.getLayoutY() < b.getRadius() || b.getLayoutY() > getHeight() - b.getRadius()) 
				b.dy *= -1;
			
			// change position
			b.setLayoutX(b.getLayoutX() + b.dx);
			b.setLayoutY(b.getLayoutY() + b.dy);
			
			
			// detect collision
			for (Node nn : getChildren()) {
				
				Ball bb = (Ball) nn;
				
				// change balls direction
				if (bb != b && intersect(b, bb)) {
					int tempX = b.dx;
					int tempY = b.dy;
					b.dx = bb.dx;
					b.dy = bb.dy;
					bb.dx = tempX;
					bb.dy = tempY;
					break;
				}
			}
			
		}
	}
	
	// check if two balls intersect
	private boolean intersect(Ball one, Ball two) {
		double dist = Math.sqrt((one.getLayoutX() - two.getLayoutX())*(one.getLayoutX() - two.getLayoutX()) 
				+ (one.getLayoutY() - two.getLayoutY())*(one.getLayoutY() - two.getLayoutY()));		
		return (dist < one.getRadius() + two.getRadius());
	}

}
