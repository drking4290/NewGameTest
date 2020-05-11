import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;

import java.util.ArrayList;



public class Actor 
{
	private Image sprite;
	private ImageView spriteImageView; //allows us to use setViewport()
	private Rectangle2D spriteViewport; //stores coords for our viewport in a Rectangle2D
	private Rectangle2D idleState;
	private int animationStep;
	private double positionX;
	private double positionY;
	private double velocityX; //unused currently
	private double velocityY;
	private double width;
	private double height;
	
	//constructor
	public Actor() 
	{
		
		this.sprite = new Image("sprite.png");
    	
		//set our sprite in an imageview node
    	this.setSpriteImageView(new ImageView(this.sprite));
		
		this.positionX = this.getSpriteImageView().getX();
    	this.positionY = this.getSpriteImageView().getY();
    	this.width = this.getSprite().getWidth();
    	this.height = this.getSprite().getHeight();
		
		this.animationStep = 0;
		this.idleState = new Rectangle2D(this.positionX , this.positionY, (this.width / 4), (this.height / 4));
 
	}
	
	//1 arg constructor to set a sprite on construction
	public Actor(Image sprite) 
	{
		this.sprite = sprite;
	}
	
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
    	if (Game.getInput().isEmpty())
    	{
    		this.setSpriteViewport(idleState);
    
    		//System.out.println("Player not receiving input");
    		this.animationStep = 0;
    	}
		if (Game.getInput().contains("W"))
    	{
			
    		if (this.animationStep <= 29)
    		{
    			this.setSpriteViewport((this.positionX), (this.positionY + ((this.height / 4) * 3)), (this.width / 4), (this.height / 4));
    			this.idleState = getSpriteViewport();
    			//System.out.println(this.animationStep);
    			this.animationStep++;
    		}
    		else if (this.animationStep >= 30 && this.animationStep <= 59)
    		{
    			this.setSpriteViewport((this.positionX) + (this.width / 4), (this.positionY + ((this.height / 4) * 3)), (this.width / 4), (this.height / 4));
    			//System.out.println(this.animationStep);
    			this.animationStep++;
    		}
    		else if (this.animationStep >= 60 && this.animationStep <= 89)
    		{
    			this.setSpriteViewport(this.positionX + (((this.width / 4) + (this.width / 4))), (this.positionY + ((this.height / 4) * 3)), (this.width / 4), (this.height / 4));
    			//System.out.println(this.animationStep);
    			this.animationStep++;
    		}    		
    		else if (this.animationStep >= 90 && this.animationStep <= 119)
    		{
    			this.setSpriteViewport(this.positionX + (((this.width / 4) + (this.width / 4)+ (this.width / 4))), (this.positionY + ((this.height / 4) * 3)), (this.width / 4), (this.height / 4));
    			//System.out.println(this.animationStep);
    			this.animationStep++;
    		}

    		if(this.animationStep >= 120)
    		{
    			this.animationStep = 0;
    		}    		
    		
			
    		
			//System.out.println("Player moving up");
    	}
    	if (Game.getInput().contains("A"))
    	{
    		
    		if (this.animationStep <= 29)
    		{
    			this.setSpriteViewport((this.positionX) , ((this.positionY) + (this.height / 4)), (this.width / 4), (this.height / 4));
    			this.idleState = getSpriteViewport();
    			this.animationStep++;
    		}
    		else if (this.animationStep >= 30 && this.animationStep <= 59)
    		{
    			this.setSpriteViewport((this.positionX + (this.width / 4)) ,  ((this.positionY) + (this.height / 4)), (this.width / 4), (this.height / 4));
    			this.animationStep++;
    		}
    		else if (this.animationStep >= 60 && this.animationStep <= 89)
    		{
    			this.setSpriteViewport((this.positionX + (this.width / 4) + (this.width / 4)) , ((this.positionY) + (this.height / 4)), (this.width / 4), (this.height / 4));
    			this.animationStep++;
    		}    		
    		else if (this.animationStep >= 90 && this.animationStep <= 119)
    		{
    			this.setSpriteViewport((this.positionX + (this.width / 4) + (this.width / 4) + (this.width / 4)) , ((this.positionY) + (this.height / 4)), (this.width / 4), (this.height / 4));
    			this.animationStep++;
    		}

    		if(this.animationStep >= 120)
    		{
    			this.animationStep = 0;
    		}    		
    		

    		//System.out.println("Player moving left");
    	}
    	if (Game.getInput().contains("S"))
    	{
    		
    		if (this.animationStep <= 29)
    		{
    			this.setSpriteViewport((this.positionX) , this.positionY, (this.width / 4), (this.height / 4));
    			this.idleState = getSpriteViewport();
    			this.animationStep++;
    		}
    		else if (this.animationStep >= 30 && this.animationStep <= 59)
    		{
    			this.setSpriteViewport((this.positionX + (this.width / 4)) , this.positionY, (this.width / 4), (this.height / 4));
    			this.animationStep++;
    		}
    		else if (this.animationStep >= 60 && this.animationStep <= 89)
    		{
    			this.setSpriteViewport((this.positionX + (this.width / 4) + (this.width / 4)) , this.positionY, (this.width / 4), (this.height / 4));
    			this.animationStep++;
    		}    		
    		else if (this.animationStep >= 90 && this.animationStep <= 119)
    		{
    			this.setSpriteViewport((this.positionX + (this.width / 4) + (this.width / 4) + (this.width / 4)) , this.positionY, (this.width / 4), (this.height / 4));
    			this.animationStep++;
    		}

    		if(this.animationStep >= 120)
    		{
    			this.animationStep = 0;
    		}    		
    		
    		//System.out.println("Player moving down");
    	}
    	if (Game.getInput().contains("D"))
    	{
    		if (this.animationStep <= 29)
    		{
    			this.setSpriteViewport((this.positionX) , ((this.positionY) + (this.height/4) + (this.height/4)), (this.width / 4), (this.height / 4));
    			this.idleState = getSpriteViewport();
    			this.animationStep++;
    		}
    		else if (this.animationStep >= 30 && this.animationStep <= 59)
    		{
    			this.setSpriteViewport((this.positionX + (this.width / 4)) , ((this.positionY) + (this.height/4) + (this.height/4)), (this.width / 4), (this.height / 4));
    			this.animationStep++;
    		}
    		else if (this.animationStep >= 60 && this.animationStep <= 89)
    		{
    			this.setSpriteViewport((this.positionX + (this.width / 4) + (this.width / 4)) , ((this.positionY) + (this.height/4) + (this.height/4)), (this.width / 4), (this.height / 4));
    			this.animationStep++;
    		}    		
    		else if (this.animationStep >= 90 && this.animationStep <= 119)
    		{
    			this.setSpriteViewport((this.positionX + (this.width / 4) + (this.width / 4) + (this.width / 4)) , ((this.positionY) + (this.height/4) + (this.height/4)), (this.width / 4), (this.height / 4));
    			this.animationStep++;
    		}

    		if(this.animationStep >= 120)
    		{
    			this.animationStep = 0;
    		}    		
    		
    		//System.out.println("Player moving right");
    	}
    	
    	
		
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
	public void setSpriteViewport(Rectangle2D spriteViewport) 
	{
		//setViewport() takes a Rectangle2D object as an argument
		this.spriteViewport = spriteViewport;
	}
	
	
}
