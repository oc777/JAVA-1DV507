package oc222ba_assign2.game;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class Creature extends VBox{
	public Label counter;
	private int count = 0;
	private ImageView iv;
	private Timer timer;
	
	public Creature() {
		counter = new Label("0");
		Image img = new Image(getClass().getResourceAsStream("m.png"));
		iv = new ImageView(img);
		iv.setFitWidth(100.0);
		iv.setPreserveRatio(true);
		
		getChildren().add(iv);
		
		clicked(iv);
		
		run();	
		
	}
	
	public void run() {
		timer = new Timer();
	    timer.scheduleAtFixedRate(new TimerTask() {
	        @Override
	        public void run() {
	        	iv.setTranslateX(random());
	    		iv.setTranslateY(random());
	        }
	    }, 0, 1000);
	}
	
	public void stop() {
		timer.cancel();
	}
	
	private void clicked(ImageView iv) {
		iv.setOnMouseClicked((MouseEvent event) -> {
			stop();
            run();
            count++;
            update();
            //System.out.println(count);

        });
	}
	
	private int random() {
		Random r = new Random();
		int n;
		n = r.nextInt(600);
		return n;
	}
	
	public void update() {
		counter.setText("" + count);
	}

}
