import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Garlic extends Actor
{
    private static final int DAMAGE = 7;  // Damage dealt to Dracula when hit
    private int life = 100;  // Lifespan of PowerBlast, in number of act cycles

    private int velocityX = 0;  
    private int velocityY = 0; 
    private int speed;
    public Garlic()
    {
        this.speed = 14;
    }

    public Garlic(int speed, int rotation)
    {
        this.speed = speed;
        setRotation(rotation);  // Set the rotation based on the given angle

        velocityX = (int) (speed * Math.cos(Math.toRadians(rotation)));
        velocityY = (int) (speed * Math.sin(Math.toRadians(rotation)));
    }

    // Act method called on every frame of the simulation
    public void act()
    {
        if (life <= 0) {
            getWorld().removeObject(this);  // Remove PowerBlast if its life has ended
        } 
        else {
            life--;  // Decrease the lifespan of PowerBlast with each act cycle
            move();  // Move PowerBlast based on its velocity
            checkDraculaHit();  
        }
    }

    // Move method to update PowerBlast's position based on its velocity
    private void move()
    {
        // Update the PowerBlast's position based on velocity
        int newX = getX() + velocityX;
        int newY = getY() + velocityY;
        setLocation(newX, newY);  // Set the new location of the PowerBlast
    }

    // Check if PowerBlast hits Dracula
    private void checkDraculaHit()
    {
        Dracula dracula = (Dracula) getOneIntersectingObject(Dracula.class);  // Check for intersection with Dracula
        if (dracula != null) 
        {
            getWorld().removeObject(this);  // Remove PowerBlast from the world
            dracula.hit(DAMAGE);  // Deal damage to Dracula
        }
    }
}

