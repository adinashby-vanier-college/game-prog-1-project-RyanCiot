import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

public class Player extends Actor
{   
    private boolean hasGun = false;
    private int shootCooldown = 0;
    private int speed = 3;
    private int health = 100;
    private PlayerHealthBar playerHealthBar;
    private String gunAcquiredMessage = "Click space bar!";
    private int messageDuration = 0;
    public void act()
    {
        lookForKey();
        movePlayer();
        checkGunPickup();
        shoot();
        updateHealthBarPosition();
        }
    public Player()
    {
        // Initialize the HealthBar
        playerHealthBar = new PlayerHealthBar(health);  // Pass initial health to the HealthBar
    }
    private void updateHealthBarPosition()
    {
        // Update the health bar position to be above the player
        playerHealthBar.setLocation(getX(), getY() - 40);
        if (getWorld().getObjects(PlayerHealthBar.class).isEmpty()) {
            getWorld().addObject(playerHealthBar, getX(), getY() - 20);  // Add health bar above the player
        }
    }
    public void lookForKey()
    {
        Actor key = getOneIntersectingObject(Key.class);
        if (key != null) {
            getWorld().removeObject(key);
        }
    }
    private void movePlayer()
    {
        if (Greenfoot.isKeyDown("down")) {
            moveDown();
             if (isTouching(wall.class) || isTouching(WallUp.class)) {
                move(0, -speed); // Revert move if there's a collision
            }
        }
        if (Greenfoot.isKeyDown("up")) {
            moveUp();
             if (isTouching(wall.class) || isTouching(WallUp.class)) {
                move(0, speed); // Revert move if there's a collision
            }
        }
        if (Greenfoot.isKeyDown("left")) {  // Move left // Rotate to face left
            move(-3);
             if (isTouching(wall.class) || isTouching(WallUp.class)) {
                move(speed, 0); // Revert move if there's a collision
            }// Move left by 3 pixels
        }
        if (Greenfoot.isKeyDown("right")) {  /// Rotate to face right
            move(3); 
             if (isTouching(wall.class) || isTouching(WallUp.class)) {
                move(-speed, 0); // Revert move if there's a collision
            }// Move right by 3 pixels
        }
        
        if (Greenfoot.isKeyDown("s")) {
            moveDown();
             if (isTouching(wall.class) || isTouching(WallUp.class)) {
                move(0, -speed); // Revert move if there's a collision
            }
        }
        if (Greenfoot.isKeyDown("w")) {
            moveUp();
             if (isTouching(wall.class) || isTouching(WallUp.class)) {
                move(0, speed); // Revert move if there's a collision
            }
        }
        if (Greenfoot.isKeyDown("a")) {  // Move left // Rotate to face left
            move(-3); 
             if (isTouching(wall.class) || isTouching(WallUp.class)) {
                move(speed, 0); // Revert move if there's a collision
            }// Move left by 3 pixels
        }
        if (Greenfoot.isKeyDown("d")) {  /// Rotate to face right
            move(3);
             if (isTouching(wall.class) || isTouching(WallUp.class)) {
                move(-speed, 0); // Revert move if there's a collision
            }// Move right by 3 pixels
        }
    }
    private void move(int dx, int dy) {
        setLocation(getX() + dx, getY() + dy);
    }
    private void moveDown() {
        // Move the actor down by the speed value
        setLocation(getX(), getY() + speed);
    }
    private void moveUp() {
        // Move the actor up by the speed value
        setLocation(getX(), getY() - speed);
    }
    private void checkGunPickup()
    {
        Gun gun = (Gun) getOneIntersectingObject(Gun.class);
        if (gun != null)
        {
            hasGun = true;
            getWorld().removeObject(gun);
            showGunAcquiredMessage();
        }
    }
    private void showGunAcquiredMessage()
    {
    if ((getWorld() instanceof BreakWorld)) {
        // Split the message by the newline character
        String[] lines = gunAcquiredMessage.split("\n");
        SoundManager.playGunCollectSound();
        // Create and add the message lines to the world
        int messageX = 300;  // Horizontal position (center)
        int messageY = 55;   // Vertical position (starting point)
        
        for (int i = 0; i < lines.length; i++) {
            // Create a new BreakWorldText for each line
            BreakWorldText breakWorldText = new BreakWorldText(lines[i]);
            getWorld().addObject(breakWorldText, messageX, messageY + (i * 30));  // Space out the lines vertically
        }
    }
    }
    private void shoot()
    {
    if (shootCooldown == 0 && hasGun && Greenfoot.isKeyDown("space"))
    {
        Garlic blast = new Garlic(10, getRotation());
        getWorld().addObject(blast, getX(), getY()); 
        shootCooldown = 10;  // Cooldown for firing bullets
    }
    if (shootCooldown > 0) {
        shootCooldown--;
    }
    }

    public void hit(int damage) {
        if (health > 0) {
        health -= damage;
        playerHealthBar.updateHealth(health);
        SoundManager.playshootGarlic();
        if (health <= 0) {
            getWorld().removeObject(this);  // Remove player from world
            Greenfoot.setWorld(new GameOver()); // Transition to GameOver world
        }
        }
    }
}
