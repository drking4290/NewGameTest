import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.ImageView;
import javafx.scene.CacheHint;


import java.util.ArrayList;





public class Game extends Application
{

	private final int PRIMARY_CANVAS_WIDTH = 800;
	private final int PRIMARY_CANVAS_HEIGHT = 600;
	
	//this arraylist contains the keys that are currently being pressed
    private static ArrayList<String> input = new ArrayList<String>();
    
	
	public static void main(String[] args) 
	{
		Application.launch(); 
	}

	
	public static ArrayList<String> getInput()
	{
		return input;
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
		primaryStage.setResizable(false);
		
		//create player object 
	    Actor player1 = new Actor();
		Background background1 = new Background();
		
		
	    //add canvas to stack
	    primaryStackPane.getChildren().addAll(primaryCanvas);
	   
	    
	    //add background to stack
		primaryStackPane.getChildren().addAll(background1.getBackgroundImageView());
    	
	    //add sprite imageview to stack, make it invisible
    	primaryStackPane.getChildren().addAll(player1.getSpriteImageView());
    	player1.getSpriteImageView().setCache(true);
    	player1.getSpriteImageView().setCacheHint(CacheHint.SPEED);
    	player1.getSpriteImageView().setVisible(false);
	    
    	background1.getBackgroundImageView().setCache(true);
    	background1.getBackgroundImageView().setCacheHint(CacheHint.SPEED);

        //listeners on primaryScene detect key presses
        primaryScene.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                	//asci code is stored in string 
                    String code = e.getCode().toString();
 
                    // check if code is already in arraylist
                    if ( !input.contains(code) )
                        input.add( code );
                    //print contents of arraylist to console
                    //System.out.println(input);
                }
            });
 
        primaryScene.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    //when key is released remove the code from the arraylist
                    input.remove( code );
                }
            });
    	
    	
    	
		//setup timeline/game loop
        Timeline gameLoop = new Timeline();
        
        //timeline runs indefinetly
        gameLoop.setCycleCount( Timeline.INDEFINITE );
        
        //store the time when we started measuring the time, not currently used, but will be important later
        final long timeStart = System.currentTimeMillis();
        
        //keyframe is an animation fram in a timeline, we are using it to set our game to process in ticks at a speed of 60 fps
        KeyFrame kf = new KeyFrame(Duration.seconds(0.016), new EventHandler<ActionEvent>()
            {
               
        		//game loop happens here at 60fps
        		//everything that we want to happen during a single frame needs to go here
        		public void handle(ActionEvent ae)
                {

        			//update background
        			background1.updateBackground();
                    
                	//update playerobject
        			player1.update();
                	
        		
                	
                }
            
            
            
            
            });
        
        
        
        //add keyframe to game loop
        gameLoop.getKeyFrames().add( kf );
        //play the animation/loop
        gameLoop.play();
		//show the stage
		primaryStage.show();
		
	}

}
