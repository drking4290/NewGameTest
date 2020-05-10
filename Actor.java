import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;

import java.util.ArrayList;



public class Actor 
{
	private Image sprite;
	private ImageView spriteImageView; //allows us to use setViewport()
	private Rectangle2D spriteViewport; //stores coords for our viewport in a Rectangle2D
	private double positionX;
	private double positionY;
	private double velocityX; //unused currently
	private double velocityY;
	private double width;
	private double height;
	
	//constructor
	public Actor() {}
	
	//called every frame
	public void update() 
	{
		this.render();
	}
	
	//draws the actor
	
	public void render() 
	{
		//get the ImageView for our sprite, make it invisible
		this.getSpriteImageView().setVisible(false);
    	
		//get the position and dimensions of our image
		this.positionX = this.getSpriteImageView().getX();
    	this.positionY = this.getSpriteImageView().getY();
    	this.width = this.getSprite().getWidth();
    	this.height = this.getSprite().getHeight();
		
    	//a viewport can be thought of as a camera, we are using it to view only a portion of our sprite sheet at a time
		this.setSpriteViewport(this.positionX, this.positionY, (this.width / 4), (this.height / 4));
		
		//example of switching the sprite in view on the sheet, sdeet is 4 X 4 sprites hence why we divide by 4
		//this.setSpriteViewport((this.positionX + (this.width / 4)) , this.positionY, (this.width / 4), (this.height / 4));
		
		//get sprites ImageView, set the viewport to the viewport we set with setSpriteViewport()
		this.getSpriteImageView().setViewport(this.getSpriteViewport());
		
		//make our sprite visible
		this.getSpriteImageView().setVisible(true);
	}
	
    public Rectangle2D getBoundary()
    {
    	this.positionX = this.getSpriteImageView().getX();
    	this.positionY = this.getSpriteImageView().getY();
    	this.width = this.getSprite().getWidth();
    	this.height = this.getSprite().getHeight();
    	
    	
        return new Rectangle2D(this.positionX, this.positionY, this.width, this.height);
    }
 
    public boolean intersects(Actor otherActor)
    {
        return otherActor.getBoundary().intersects( this.getBoundary() );
    }
    
 
	public void setSprite(String sprite)
    {
    	this.sprite = new Image(sprite);
    	//set our sprite in an imageview node
    	this.setSpriteImageView(new ImageView(this.sprite));
    }
    
    public Image getSprite()
    {
    	return this.sprite;
    }

	public ImageView getSpriteImageView() 
	{
		return this.spriteImageView;
	}

	public void setSpriteImageView(ImageView spriteImageView) 
	{
		this.spriteImageView = spriteImageView;
	}

	public Rectangle2D getSpriteViewport() 
	{
		return spriteViewport;
	}

	public void setSpriteViewport(double posX, double posY, double width, double height) 
	{
		//setViewport() takes a Rectangle2D object as an argument
		this.spriteViewport = new Rectangle2D(posX, posY, width, height);
	}
	
	
}
