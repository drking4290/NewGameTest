import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
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
		StackPane primaryStackPane = new StackPane();
		Canvas primaryCanvas = new Canvas(PRIMARY_CANVAS_WIDTH, PRIMARY_CANVAS_HEIGHT);
		Scene primaryScene = new Scene(primaryStackPane);
		
		//graphics context object is used to draw on canvas
		GraphicsContext gContext = primaryCanvas.getGraphicsContext2D();
	
		//set title, set scene
		primaryStage.setTitle("Game Test");
		primaryStage.setScene(primaryScene);
		
		
		//create player object and set the sprite
	    Actor player1 = new Actor();
	    player1.setSprite("sprite.png");
		
	    //add canvas to stack
	    primaryStackPane.getChildren().addAll(primaryCanvas);
    	
	    //add sprite imageview to stack, make it invisible
    	primaryStackPane.getChildren().addAll(player1.getSpriteImageView());
    	player1.getSpriteImageView().setVisible(false);
	    
		//setup game loop
        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount( Timeline.INDEFINITE );
        
        final long timeStart = System.currentTimeMillis();
        
        KeyFrame kf = new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>()
            {
               
        	
        	
        		//game loop happens here at 60fps
        		public void handle(ActionEvent ae)
                {

                    //Clear the canvas
                	//gContext.clearRect(0, 0, PRIMARY_CANVAS_WIDTH,PRIMARY_CANVAS_HEIGHT);
                    
                	//update playerobject
        			player1.update();
                	
        		
        			
                	
                }
            
            
            
            
            });
        
        
        
        
        gameLoop.getKeyFrames().add( kf );
        gameLoop.play();
		
		primaryStage.show();
		
	}

}
