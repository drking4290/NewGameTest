import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;

import java.util.ArrayList;



public class Actor 
{
	private Image sprite;
	private double positionX;
	private double positionY;
	private double velocityX;
	private double velocityY;
	private double width;
	private double height;
	
	//constructor
	public Actor() {}
	
	//calculates the new position based on the actor's velocity
	public void update() {}
	
	//draws the associated image to the canvas using the position as coordinates
	public void render() {}
	
    public Rectangle2D getBoundary()
    {
        return new Rectangle2D(this.positionX, this.positionY, this.width, this.height);
    }
 
    public boolean intersects(Actor otherActor)
    {
        return otherActor.getBoundary().intersects( this.getBoundary() );
    }
    
 
	public void setSprite(String sprite)
    {
    	this.sprite = new Image(sprite);
    }
    
    public Image getSprite()
    {
    	return this.sprite;
    }
}
