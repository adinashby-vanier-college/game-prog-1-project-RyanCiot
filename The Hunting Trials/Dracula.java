import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot, and MouseInfo)
import java.util.List;

public class Dracula extends Actor {
    private int health = 100;  // Dracula's initial health
    private int shootCooldown = 30;  // Default cooldown time (slower)
    private int speed = 3; 
    private int direction = 1;
    private DraculaHealthBar draculaHealthBar;

    // The base cooldown time that can be adjusted based on health
    private final int baseCooldown = 30;  // This is the default cooldown time when health is full

    public void act() {
        shootBlood();  // Call the method to shoot blood
        moveVertically();  // Move Dracula vertically
        updateHealthBarPosition();  // Update health bar position
    }

    public Dracula() {
        // Initialize the HealthBar
        draculaHealthBar = new DraculaHealthBar(health);  // Pass initial health to the HealthBar
    }

    private void updateHealthBarPosition() {
        // Update the health bar position to be above Dracula
        draculaHealthBar.setLocation(getX(), getY() - 50);
        if (getWorld().getObjects(DraculaHealthBar.class).isEmpty()) {
            getWorld().addObject(draculaHealthBar, getX(), getY() - 20);  // Add health bar above Dracula
        }
    }

    public void hit(int damage) {
        health -= damage;
        draculaHealthBar.updateHealth(health);

        // If health is 0 or less, remove Dracula from the world
        if (health <= 0) {
            getWorld().removeObject(this);
            Greenfoot.setWorld(new GameWon());
        }
    }

    public void moveVertically() {
        // Move Dracula based on the direction
        setLocation(getX(), getY() + direction * speed);

        // Check if Dracula has hit the bottom or top of the screen
        if (getY() >= getWorld().getHeight() - 1) {
            direction = -1;  // Change direction to move up
        }
        else if (getY() <= 0) {
            direction = 1;  // Change direction to move down
        }
    }

    private void shootBlood() {
        // Adjust the shooting cooldown based on health percentage
        int adjustedCooldown = calculateCooldownBasedOnHealth();

        // Only shoot if cooldown is 0
        if (shootCooldown == 0) {
            List<Player> players = getWorld().getObjects(Player.class);
            if (!players.isEmpty()) {  // Ensure there's at least one player in the world
                Player targetPlayer = players.get(0);  // Get the first player object

                // Calculate the direction to shoot the blood towards the player
                int deltaX = targetPlayer.getX() - getX();
                int deltaY = targetPlayer.getY() - getY();
                double angle = Math.atan2(deltaY, deltaX);  // Calculate the angle between Dracula and Player

                // Create and shoot the blood
                Blood blood = new Blood(10, angle);
                getWorld().addObject(blood, getX(), getY());  // Add the blood at Dracula's current location
                
                // After shooting, reset the cooldown to the adjusted value based on health
                shootCooldown = adjustedCooldown;  // Adjusted cooldown based on health
            }
        }

        // If cooldown is greater than 0, decrease it each frame
        if (shootCooldown > 0) {
            shootCooldown--;
        }
    }

    // Method to calculate the cooldown based on health percentage
    private int calculateCooldownBasedOnHealth() {
        // Calculate the health percentage (0 to 100)
        double healthPercentage = (double) health / 100;

        // Reduce cooldown based on health percentage (lower health means faster shooting)
        int adjustedCooldown = (int) (baseCooldown * healthPercentage);

        // Ensure cooldown doesn't go below a threshold (e.g., 5)
        return Math.max(adjustedCooldown, 20);  // Min cooldown is 5
    }
}
