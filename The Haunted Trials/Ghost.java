import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ghost extends Actor
{
    public void act()
    {
        move(3); // Move the ghost
        randomTurn(); // Randomly turn the ghost
        turnAtEdge(); // Turn if at the edge
        lookForPlayer(); // Check if the ghost intersects with the player
    }
    
    public void turnAtEdge()
    {
        if (isAtEdge()) {
            turn(90); // Turn 90 degrees if at the edge
        }
    }

    public void randomTurn()
    {
        if (Greenfoot.getRandomNumber(100) < 10) {
            turn(Greenfoot.getRandomNumber(90) - 45); // Random turn
        }
    }

    public void lookForPlayer()
    {
        Actor player = getOneIntersectingObject(Player.class);
        if (player != null)
        {
            getWorld().removeObject(player); // Remove the player if intersecting
            Greenfoot.setWorld(new GameOver()); // Transition to GameOver world
        }
    }
}
