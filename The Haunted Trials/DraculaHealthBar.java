import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DraculaHealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DraculaHealthBar extends Actor
{
    private int health;  // Current health of the player
    private int maxHealth;  // Max health for scaling
    private int healthBarWidth = 100;  // Width of the health bar
    private int healthBarHeight = 10;  // Height of the health bar

    public DraculaHealthBar(int initialHealth)
    {
        this.maxHealth = initialHealth;  // Set the maximum health
        this.health = initialHealth;  // Set the current health
        update();  // Initial health bar setup
    }

    public void act()
    {
        update();  // Continuously update the health bar
    }

    public void update()
    {
        // Calculate the width of the red part of the health bar based on the current health
        int pixelsPerHealthPoint = healthBarWidth / maxHealth;  // Pixels per health point
        int currentWidth = health * pixelsPerHealthPoint;  // The width of the red bar (based on current health)
        
        // Create an image for the health bar
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myImage = getImage();
        
        // Draw the border of the health bar
        myImage.setColor(Color.BLACK);
        myImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);
        
        // Draw the red portion of the health bar (remaining health)
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 1, currentWidth, healthBarHeight);
    }

    // Method to update the health of the player and reflect it on the health bar
    public void updateHealth(int newHealth)
    {
        this.health = newHealth;  // Update the current health
        update();  // Update the health bar visual
    }
}
