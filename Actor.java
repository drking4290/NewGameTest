import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;

import java.util.ArrayList;



public class Actor 
{
	private Image sprite;
	private ImageView spriteImageView;
	private Rectangle2D spriteViewport;
	private double positionX;
	private double positionY;
	private double velocityX;
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
		this.getSpriteImageView().setVisible(false);
    	
		this.positionX = this.getSpriteImageView().getX();
    	this.positionY = this.getSpriteImageView().getY();
    	this.width = this.getSprite().getWidth();
    	this.height = this.getSprite().getHeight();
		
    	
		this.setSpriteViewport(this.positionX, this.positionY, (this.width / 4), (this.height / 4));
		
		//example of switching the sprite in view on the sheet
		//this.setSpriteViewport((this.positionX + (this.width / 4)) , this.positionY, (this.width / 4), (this.height / 4));
		
		this.getSpriteImageView().setViewport(this.getSpriteViewport());
		
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
		this.spriteViewport = new Rectangle2D(posX, posY, width, height);
	}
	
	
}
