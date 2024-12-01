import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Key extends Actor
{
    public void act()
    {
        checkCollection(); // Check if the Key is collected
    }

    private void checkCollection() {
        if (isTouching(Player.class)) {
            World world = getWorld();

            // Play the key collection sound
            SoundManager.playKeyCollectSound(); // Play the sound when the key is collected

            // Notify the current world that a key was collected
            if (world instanceof Level1) {
                ((Level1) world).collectKey(); 
            } 
            else if (world instanceof Level2) {
                ((Level2) world).collectKey(); 
            }

            getWorld().removeObject(this);  // Remove the key from the world
        }
    }
}
