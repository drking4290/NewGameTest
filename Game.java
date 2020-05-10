import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;

import java.util.ArrayList;





public class Game extends Application
{

	private final int PRIMARY_CANVAS_WIDTH = 800;
	private final int PRIMARY_CANVAS_HEIGHT = 600;
	
	
	
	
	
	public static void main(String[] args) 
	{
		Application.launch(); 
	}

	@SuppressWarnings("restriction")
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		Group primaryGroup = new Group();
		Scene primaryScene = new Scene(primaryGroup);
		Canvas primaryCanvas = new Canvas(PRIMARY_CANVAS_WIDTH, PRIMARY_CANVAS_HEIGHT);
		
		GraphicsContext gContext = primaryCanvas.getGraphicsContext2D();
	
		primaryStage.setTitle("Game Test");
		primaryStage.setScene(primaryScene);
		
		primaryGroup.getChildren().add(primaryCanvas);
		
	    Actor player1 = new Actor();
	    
	    player1.setSprite("sprite.png");
		
		//setup game loop
        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount( Timeline.INDEFINITE );
        
        final long timeStart = System.currentTimeMillis();
        
        KeyFrame kf = new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent ae)
                {

                    //Clear the canvas
                	gContext.clearRect(0, 0, PRIMARY_CANVAS_WIDTH,PRIMARY_CANVAS_HEIGHT);
                    
                   
                	//draw player sprite
                	gContext.drawImage( player1.getSprite(), 196, 196 );
                }
            });
        
        gameLoop.getKeyFrames().add( kf );
        gameLoop.play();
		
		
		
		primaryStage.show();
		
	}

}
